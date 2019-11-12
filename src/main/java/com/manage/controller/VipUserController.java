package com.manage.controller;

import com.manage.controller.base.BaseController;
import com.manage.dao.TblUserMapper;
import com.manage.dao.TblUserVipMapper;
import com.manage.model.CompanyOper;
import com.manage.model.TblUser;
import com.manage.model.TblUserVip;
import com.manage.service.UserVipService;
import com.manage.utils.ImageConfig;
import com.manage.utils.ResponseBase;
import com.manage.utils.ResponseObj;
import com.manage.utils.page.PageInfo;
import com.manage.utils.result.Result;
import com.manage.utils.result.ResultData;
import com.xdream.kernel.util.JsonUtil;
import com.xdream.kernel.util.ResponseUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpStatus;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.net.ssl.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.*;

@RequestMapping("/vipManage")
@RestController
public class VipUserController extends BaseController {

    @Autowired
    private TblUserMapper userMapper;

    @Autowired
    private UserVipService userVipService;


    @Value("${imageSaveDir}")
    private String imageSaveDir;


    @RequestMapping(value = "/getVip")
    public Result findByPage(HttpServletRequest request, HttpServletResponse response, @RequestParam(required = true, defaultValue = "1") Integer page,
                             @RequestParam(required = false, defaultValue = "10") Integer pageSize) throws Exception {
        String realName = request.getParameter("newsName");
        List<TblUser> news = userVipService.findByPage(realName, page, pageSize);
        PageInfo<TblUser> newsPageInfo = new PageInfo<TblUser>(news);
        return newsPageInfo != null ? ResultData.dataResult("success", "读取vip用户列表成功", newsPageInfo) : Result.unDataResult("fail", "读取vip用户列表失败");
    }

    @RequestMapping(value = "/delVip")
    public Result deleteNews(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            String id = request.getParameter("id");
            if (StringUtils.isBlank(id)) {
                return ResultData.unDataResult("fail", "缺少参数");
            }
            List<Integer> list = new ArrayList<Integer>();
            String[] ids = id.split(",");
            for (String s : ids) {
                list.add(Integer.valueOf(s));
            }
            Integer delete = userVipService.deleteNews(list);
            return delete > 0 ? ResultData.unDataResult("success", "删除成功") : Result.unDataResult("fail", "删除失败");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultData.unDataResult("fail", "系统异常");
        }
    }

    public String getFileImgName(String userId,String newsImageUrl) throws Exception{
        String serverUrl = "http://47.99.209.40:8081/goldccm-imgServer/goldccm/image/gainData";
        File file = new File(imageSaveDir,newsImageUrl);
        String fileRquestParam = "file";
        String imageFileName="";
        Map<String, String> dataMap = new HashMap<String, String>();
        dataMap.put("userId", userId);
        dataMap.put("type", "3");
        Connection.Response res = doPostFileRequest(serverUrl, dataMap, file, fileRquestParam);
        if (res != null) {
            String resultJson = res.parse().getElementsByTag("body").text();
            ResponseObj resObj= (ResponseObj) JsonUtil.toObj(resultJson, ResponseObj.class);
            if (200 == res.statusCode()) {
                //更新到数据库
                /*updateImgUrl(userId, flag, resObj.getData().getImageFileName());*/
                System.out.println(resObj.getData().getImageFileName());
                //删除本地文件
                file.delete();
                imageFileName=resObj.getData().getImageFileName();
                System.out.println("上传服务器成功！");
            }
        }else {
            System.out.println("上传服务器失败！");
        }
        return imageFileName;
    }


    @RequestMapping(value = "/addOrUpdVip")
    public Result addNews(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String addOrEdit = request.getParameter("addOrEdit");
        String id = request.getParameter("id");
        String newsName = request.getParameter("newsName");//姓名
        String mobilePhone = request.getParameter("mobilePhone");//手机号
        String idCard = request.getParameter("idCard");//身份证号
        String newsImageUrl = request.getParameter("newsImageUrl");


        if (StringUtils.isBlank(newsName)
                && StringUtils.isBlank(mobilePhone) && StringUtils.isBlank(idCard)&& StringUtils.isEmpty(newsImageUrl)) {
            return ResultData.unDataResult("fail", "缺少参数");
        }

        if ("add".equals(addOrEdit)) {
            TblUser user=new TblUser();
            Date date = new Date();
            String authDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
            String authTime = new SimpleDateFormat("HH:mm:ss").format(date);
            user.setIsauth("T");
            user.setRealname(newsName);
            user.setCreatedate(authDate);
            user.setCreatetime(authTime);
            user.setIdno(idCard);
            user.setPhone(mobilePhone);
            user.setIdfrontimgurl("v");
            user.setLoginname(mobilePhone);
            int insert = userMapper.insertSelective(user);
            if (insert>0){
                Long userId = user.getId();
                String fileImgName = getFileImgName(String.valueOf(userId), newsImageUrl);
                TblUser u=new TblUser();
                u.setId(userId);
                u.setIdhandleimgurl(fileImgName);
                insert = userMapper.updateByPrimaryKeySelective(u);
            }
            return insert > 0 ? ResultData.unDataResult("success", "插入成功") : Result.unDataResult("fail", "插入失败");
        } else if ("edit".equals(addOrEdit)) {
            TblUser user=new TblUser();
            user.setId(Long.parseLong(id));
            user.setRealname(newsName);
            user.setIdno(idCard);
            user.setPhone(mobilePhone);
            String fileImgName = getFileImgName(String.valueOf(id), newsImageUrl);
            user.setIdhandleimgurl(fileImgName);
            int update = userMapper.updateByPrimaryKeySelective(user);
            return update > 0 ? ResultData.unDataResult("success", "修改成功") : Result.unDataResult("fail", "修改失败");
        } else {
            return ResultData.unDataResult("fail", "系统异常");
        }
    }


    @RequestMapping(value = "/upNewsImg", method = RequestMethod.POST,consumes = "multipart/form-data")
    public Result upImg(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String flag = request.getParameter("flag");
        boolean isSucc = true;
        MultipartHttpServletRequest multipartRequest = null;
        //创建一个通用的多部分解析器
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        //判断 request 是否有文件上传,即多部分请求
        if (multipartResolver.isMultipart(request)) {
            multipartRequest = (MultipartHttpServletRequest) request;
            Iterator<String> iter = multipartRequest.getFileNames();
            MultipartFile myfile = null;
            String json = "";
            String realFileName = "";
            File files = null;
            try {
                if (iter.hasNext()) {
                    String key = iter.next();
                    myfile = multipartRequest.getFile(key);
                    if (myfile.isEmpty()) {

                    } else {
                        String originalFilename = myfile.getOriginalFilename();
                        if (!originalFilename.matches(".+(.JPEG|.jpeg|.JPG|.jpg|.GIF|.gif|.BMP|.bmp|.PNG|.png)$")) {
                            isSucc = false;
                        } else {
                            File file = new File(imageSaveDir);
                            if (!file.exists()) {
                                file.mkdirs();
                            }
                            // 这里不必处理IO流关闭的问题，因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉，我是看它的源码才知道的
                            String newFileName = System.currentTimeMillis() + "";
                            int index = originalFilename.lastIndexOf(".");

                            String fileNameType = originalFilename.substring(index, originalFilename.length());
                            realFileName = newFileName + fileNameType;
                            files = new File(imageSaveDir, realFileName);
                            FileUtils.copyInputStreamToFile(myfile.getInputStream(), files);
                            Map<String, Object> map=new HashMap<>();
                            map.put("imageFileName",realFileName);
                            return ResultData.dataResult("success", "上传成功", map );
                        }
                    }
                }else {
                    return ResultData.unDataResult("fail", "没有文件上传");
                }

            } catch (Exception e) {
                e.printStackTrace();
                return ResultData.unDataResult("fail", "系统异常");
            }
        }
        return ResultData.unDataResult("fail", "系统异常");
    }




    public static Connection.Response doPostFileRequest(String url, Map<String, String> paramMap, File file, String
            fileRequestParam) throws Exception {
        if (StringUtils.isBlank(url)) {
            throw new Exception("The request URL is blank.");
        }
        // Https请求
        if (StringUtils.startsWith(url, "https")) {
            trustEveryone();
        }
        Connection connection = Jsoup.connect(url);
        connection.method(Connection.Method.POST);
        connection.timeout(12000);
        connection.header("Content-Type", "multipart/form-data");
        connection.ignoreHttpErrors(true);
        connection.ignoreContentType(true);
        if (paramMap != null && !paramMap.isEmpty()) {
            connection.data(paramMap);
        }
        try {
            FileInputStream fis = new FileInputStream(file);
            //FileInputStream fiss = new FileInputStream(new File(""));
            //connection.data(fileRequestParam, file.getName(), fiss);
            connection.data(fileRequestParam, file.getName(), fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection.Response response = connection.execute();
            if (response.statusCode() != HttpStatus.SC_OK) {
                throw new Exception("http请求响应码:" + response.statusCode() + "");
            }
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解决Https请求,返回404错误
     */
    private static void trustEveryone() {
        try {
            HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {

                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
            SSLContext context = SSLContext.getInstance("TLS");
            context.init(null, new X509TrustManager[]{new X509TrustManager() {

                public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            }}, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(context.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}