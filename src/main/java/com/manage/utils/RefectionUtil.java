package com.manage.utils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;


public class RefectionUtil {
    @SuppressWarnings({ "unchecked" })
    public static <T> T getObjectFromRequest(HttpServletRequest request,Class<T> c) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException{
        List<Method> list=getSetMethods(c); //获取要注入的类的所有公有setter方法
        Enumeration<String> enums=request.getParameterNames();


        T t=c.newInstance(); //获取注入类的一个实例


        String key; //request中的请求参数名


        Map<String,Map<String,Integer>> arrObject=new HashMap<String,Map<String,Integer>>();


        String[] splitArr;


        Map<String,Integer> mp;


        //循环所有的属性名，并取出所有的属性值
        while(enums.hasMoreElements()){
            key=enums.nextElement();


            if(key.indexOf(".")>0 && key.indexOf("[")<0){
                List<String> splitStr=mySplist(key);
                for(int i=0;i<splitStr.size()-1;i++){ //循环获取属性
                    t=(T) getObject(splitStr.get(i),splitStr.get(i+1),c,t,request);
                }
            }else if(key.indexOf("[")>0){ //数组存储   //start[0].name
                splitArr=getSplitKey(key);
                //判断map是否存在这个键
                if(arrObject.containsKey(splitArr[0])){
                    mp=arrObject.get(splitArr[0]);
                }else{
                    mp=new HashMap<String,Integer>();
                }
                if( mp.containsKey(splitArr[2]) ){
                    mp.put(splitArr[2],mp.get(splitArr[2])+1);
                }else{
                    mp.put(splitArr[2],1);
                }
                arrObject.put(splitArr[0],mp);
            }else{
                t=(T)setDirectInjection(list,key,request,t);
            }
        }


        //star[0].name分割的数组
        if(arrObject!=null && arrObject.size()>0){
            t=(T) getObjects(arrObject,c,t,request);
        }
        return t;
    }


    @SuppressWarnings("unchecked")
    public static <T> Object getObjects(Map<String,Map<String,Integer>> arrObject,Class<T> c,Object t,HttpServletRequest request) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException{
        Set<String> keys=arrObject.keySet();
        List<Method> getMethods=getGetMethods(c); //获取当前类中所有公用的get方法


        Object subObject=null;
        Type type=null;
        String typeName=null;
        List<T> list=null;
        Class<T> cl;
        T myObject; //实例对象
        Map<String,Integer> attrInfo;
        Set<String> innerKey;


        for(String key:keys){
            for(Method md:getMethods){
                if(("get"+getChangeName(key)).equals(md.getName())){
                    subObject=md.invoke(t,null); //获取当前注入对象事否为空


                    if(subObject==null){//如果为空，初始化一个对象出来,然后调用set方法注入
                        for(Method setMd:getSetMethods(c)){
                            if(("set"+getChangeName(key)).equals(setMd.getName())){
                                type=getMethodType(setMd);
                                typeName=type.toString().replaceFirst("^(class\\s*)","");


                                if(type instanceof ParameterizedType){//判断type 是不是参数化类型。 如Collection<String>就是一个参数化类型。
                                    if(typeName.startsWith("java.util.List")){
                                        list=new ArrayList<T>();

                                        type=((ParameterizedType)type).getActualTypeArguments()[0];
                                        typeName=type.toString().replaceFirst("^(class\\s*)","");


                                        //获取一个类的实例化
                                        cl=(Class<T>) Class.forName(typeName);
                                        attrInfo=arrObject.get(key);

                                        innerKey=attrInfo.keySet();

                                        for(int i=0;i<attrInfo.get(innerKey.toArray()[0]);i++){
                                            myObject=(T)cl.newInstance();
                                            for(String s:innerKey){
                                                myObject=(T)setDirectInjections(getSetMethods(myObject.getClass()),key+"["+i+"]."+s,request,myObject);
                                            }
                                            list.add( myObject );
                                        }
                                    }
                                }
                                subObject=setMd.invoke(t,list);
                                break;
                            }
                        }
                    }
                }
            }
        }
        return t;
    }




    @SuppressWarnings("unused")
    public static <T> Object getObject(String name,String nextName,Class<T> c,Object t,HttpServletRequest request) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, InstantiationException{
        List<Method> getMethods=getGetMethods(c); //获取当前类中所有公用的get方法
        Object subObject=null;


        List<Method> setMethods=null; //嵌套类的setter方法集合


        for(Method md:getMethods){
            if(("get"+getChangeName(name)).equals(md.getName())){
                subObject=md.invoke(t,null); //获取当前注入对象事否为空
                if(subObject==null){//如果为空，初始化一个对象出来,然后调用set方法注入
                    for(Method setMd:getSetMethods(c)){
                        if(("set"+getChangeName(name)).equals(setMd.getName())){
                            subObject=md.getReturnType().newInstance();
                            setMd.invoke(t,subObject);
                            break;
                        }
                    }
                }
                subObject=(T)setDirectInjections(getSetMethods(subObject.getClass()),name+"."+nextName,request,subObject);
                break;
            }
        }
        return t;
    }


    /**
     * 将给定的属性名的第一个字母变成大写
     * @param name：转换后的字符
     * @return
     */
    public static String getChangeName(String name){
        return name.substring(0,1).toUpperCase()+name.substring(1);
    }


    /**
     * 将字符串为star[0].name分割成一个数组
     * @param key：要分割的字符串
     * @return：分割后的数组
     */
    public static String[] getSplitKey(String key){
        String[] str=new String[3];
        str[0]=key.substring(0,key.indexOf("["));
        str[1]=key.substring(key.indexOf("[")+1,key.indexOf("]"));
        str[2]=key.substring(key.indexOf("]")+2);
        return str;
    }


    /**
     * 根据.将字符串分割成数组
     * @param str：要分割的字符串
     * @return：分割好的集合
     */
    public static List<String> mySplist(String str){
        List<String> list=new ArrayList<String>();
        String temp;
        while(!"".equals(str)&&str.indexOf(".")>0){
            temp=str.substring(0,str.indexOf("."));
            list.add(temp);
            str=str.substring(str.indexOf(".")+1);
        }
        list.add(str);
        return list;
    }


    /**
     * 普通类型注值
     * method：要反向激活的方法
     * @param request：当前请求
     * typeName：参数类型
     * @param key：取值属性
     * @param t：要注入到的对象
     * @return
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public static Object setDirectInjection(List<Method> list,String key,HttpServletRequest request,Object t) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException{
        Type type=null; //参数类型名
        String typeName=null;
        Object[] str;


        //循环匹配所有的setter方法
        for(Method method:list){
            if(("set"+getChangeName(key)).equals(method.getName())){ //如果找到了对应的方法
                //取出该方法的参数类型
                type=getMethodType(method);
                typeName=type.toString().replaceFirst("^(class\\s*)","");


                if(type instanceof ParameterizedType){//判断type 是不是参数化类型。 如Collection<String>就是一个参数化类型。
                    if(typeName.startsWith("java.util.List")){
                        //获取List中的参数类型
                        type=((ParameterizedType)type).getActualTypeArguments()[0];
                        str=(Object[]) request.getParameterValues(key);
                        List<Object> params=Arrays.asList(str);
                        method.invoke(t,params);
                    }
                }else{
                    t=setDirectInjectionType(method,request,typeName,key,t);
                }
                break;
            }
        }
        return t;
    }


    /**
     * 带一个.的注值
     * method：要反向激活的方法
     * request：当前请求
     * typeName：参数类型
     * @param key：取值属性
     * @param t：要注入到的对象
     * @return
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public static Object setDirectInjections(List<Method> list,String key,HttpServletRequest request,Object t) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException{
        Type type=null; //参数类型名
        String typeName=null;
        Object[] str;
        String name=key;


        //循环匹配所有的setter方法
        for(Method method:list){
            if(key.indexOf("]")>0){
                name=key.substring(key.lastIndexOf("]")+2);
            }else if(key.indexOf(".")>0){
                name=key.substring(key.lastIndexOf(".")+1);
            }


            if(("set"+getChangeName(name)).equals(method.getName())){ //如果找到了对应的方法
                //取出该方法的参数类型
                type=getMethodType(method);
                typeName=type.toString().replaceFirst("^(class\\s*)","");


                if(type instanceof ParameterizedType){//判断type 是不是参数化类型。 如Collection<String>就是一个参数化类型。
                    if(typeName.startsWith("java.util.List")){
                        //获取List中的参数类型
                        type=((ParameterizedType)type).getActualTypeArguments()[0];
                        str=(Object[]) request.getParameterValues(key);
                        List<Object> params=Arrays.asList(str);
                        method.invoke(t,params);
                    }
                }else{
                    t=setDirectInjectionType(method,request,typeName,key,t);
                }
                break;
            }
        }
        return t;
    }


    /**
     * 普通类型注值
     * @param method：要反向激活的方法
     * @param request：当前请求
     * @param typeName：参数类型
     * @param key：取值属性
     * @param t：要注入到的对象
     * @return
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public static Object setDirectInjectionType(Method method,HttpServletRequest request,String typeName,String key,Object t) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException{
        if("java.lang.String".equals(typeName)){
            method.invoke(t,request.getParameter(key));
        }else if("int".equals(typeName)){
            method.invoke(t,Integer.parseInt(request.getParameter(key)));
        }else if("double".equals(typeName)){
            method.invoke(t,Double.parseDouble(request.getParameter(key)));
        }else if("float".equals(typeName)){
            method.invoke(t,Float.parseFloat(request.getParameter(key)));
        }else if("boolean".equals(typeName)){
            method.invoke(t,Boolean.parseBoolean(request.getParameter(key)));
        }else if("java.lang.Long".equals(typeName)){
            method.invoke(t,Long.parseLong(request.getParameter(key)));
        }else if("java.lang.Integer".equals(typeName)){
            method.invoke(t,Integer.parseInt(request.getParameter(key)));
        }else{
            method.invoke(t,request.getParameter(key));
        }
        return t;
    }




    /**
     * 获取给定类的所有公有的setter方法
     * 包括那些由该类或接口声明的以及从超类和超接口继承的那些的类或接口
     * @param cl：要获取的类
     * @return：该类的所有公有的setter方法集合
     */
    public static <T> List<Method> getSetMethods(Class<T> cl){
        List<Method> list=new ArrayList<Method>();


        //返回一个包含某些 Method 对象的数组，这些对象反映此 Class 对象所表示的类或接口（包括那些由该类或接口声明的以及从超类和超接口继承的那些的类或接口）的公共 member 方法。
        Method[] methods=cl.getMethods();
        for(Method method:methods){
            if(method.getName().startsWith("set")){
                list.add(method);
                getMethodType(method);
            }
        }
        return list;
    }


    /**
     * 获取给定类的所有公有的getter方法
     * 包括那些由该类或接口声明的以及从超类和超接口继承的那些的类或接口
     * @param cl：要获取的类
     * @return：该类的所有公有的getter方法集合
     */
    public static <T> List<Method> getGetMethods(Class<T> cl){
        List<Method> list=new ArrayList<Method>();


        //返回一个包含某些 Method 对象的数组，这些对象反映此 Class 对象所表示的类或接口（包括那些由该类或接口声明的以及从超类和超接口继承的那些的类或接口）的公共 member 方法。
        Method[] methods=cl.getMethods();
        for(Method method:methods){
            if(method.getName().startsWith("get")){
                list.add(method);
            }
        }
        return list;
    }


    /**
     * 获取给定方法的第一个参数的参数类型
     * @param method：要获取第一个参数的方法
     * @return：该方法第一个参数的参数类型
     */
    public static Class<?> getMethodClass(Method method){
        Class<?>[] cls=method.getParameterTypes();
        if(cls!=null&&cls.length>0){
            return cls[0];
        }
        return null;
    }


    /**
     * 获取给定方法的第一个参数的参数类型
     * @param method：要获取第一个参数的方法
     * @return：该方法第一个参数的参数类型
     */
    public static Type getMethodType(Method method){
        Type[] type=method.getGenericParameterTypes();
        if(type!=null&&type.length>0){
            return type[0];
        }
        return null;
    }
}
