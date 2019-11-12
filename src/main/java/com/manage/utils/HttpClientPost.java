package com.manage.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class HttpClientPost {

    public static String httpPostRequest(String url, JSONObject paramsJson){
        String result="";
        try {
            CloseableHttpClient httpClient= HttpClients.createDefault();
            HttpPost httpPost=new HttpPost(url);
            RequestConfig requestConfig=RequestConfig.custom().setConnectTimeout(10000)
                    .setConnectionRequestTimeout(10000)
                    .setSocketTimeout(30000)
                    .build();
            httpPost.setConfig(requestConfig);
            httpPost.addHeader("content-type", "application/json;charset=utf-8");
            httpPost.setEntity(new StringEntity(paramsJson.toJSONString(),Charset.forName("UTF-8")));
            // httpClient对象执行post请求,并返回响应参数对象
            //   HttpResponse httpResponse = httpClient.execute(httpPost);~~ 
            CloseableHttpResponse httpResponse=httpClient.execute(httpPost);
            result = EntityUtils.toString(httpResponse.getEntity());

        }catch (Exception e){
            e.printStackTrace();
        }
        return  result;
    }

//    public static void main(String[] args) {
//        Map<String,Object> map=new HashMap<String,Object>();
//        map.put("id","11111");
//        map.put("name","zhangsan");
//        map.put("age","27");
//        JSONObject object = JSONObject.parseObject(JSON.toJSONString(map));
//        String id =(String) object.get("id");
//        String name =(String) object.get("name");
//        String age = (String) object.get("age");
//        String s = httpPostRequest("http://192.168.10.129:8098/goldccm_war/test/test1", object);
//        System.out.println("调用192.168.10.129返回的结果是："+s.toString());
//    }
}
