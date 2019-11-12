package com.manage.utils;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * HttpClient工具类
 * @Author Linyb
 * @Date 2016/12/13 14:18
 */
public class HttpClientUtil {

    public static String sendGet(String url) {
        HttpGet get = null;
        CloseableHttpResponse resp = null;
        CloseableHttpClient client = null;
        try {
            client = HttpClients.createDefault();
            get = new HttpGet(url);
            resp = client.execute(get);
            int statusCode = resp.getStatusLine().getStatusCode();
            if (statusCode >= 200 && statusCode < 300) {
                HttpEntity entity = resp.getEntity();
                String content = EntityUtils.toString(entity, "utf-8");
                return content;
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resp != null) {
                    resp.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (client != null) {
                    client.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * post请求json
     * @Author Linyb
     * @Date 2016/12/13 14:19
     */
    public static String sendJsonPost(String url, String json) throws Exception {
        return sendPost(url, json, "application/json");
    }

    public static String sendPost(String url, String content, String type) {
        CloseableHttpClient client = null;
        CloseableHttpResponse resp = null;
        try {
            client = HttpClients.createDefault();
            HttpPost post = new HttpPost(url);
            post.addHeader("Content-type", type);
            StringEntity entity = new StringEntity(content, ContentType.create(type, "UTF-8"));
            post.setEntity(entity);
            resp = client.execute(post);
            int statusCode = resp.getStatusLine().getStatusCode();
            if (statusCode >= 200 && statusCode < 300) {
                String str = EntityUtils.toString(resp.getEntity(), "utf-8");
                return str;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (client != null)
                    client.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                if (resp != null)
                    resp.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String sendPost(String url, Map<String, String> map, String type) {
        CloseableHttpClient client = null;
        CloseableHttpResponse resp = null;
        try {
            client = HttpClients.createDefault();
            HttpPost post = new HttpPost(url);
            post.addHeader("Content-type", type);

            //装填参数
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            if(map != null){
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
                }
            }

            //设置参数到请求对象中
            post.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
            resp = client.execute(post);
            int statusCode = resp.getStatusLine().getStatusCode();
            System.out.println("statusCode:"+statusCode);
            if (statusCode >= 200 && statusCode < 300) {
                String str = EntityUtils.toString(resp.getEntity(), "utf-8");
                return str;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (client != null)
                    client.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                if (resp != null)
                    resp.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 判断是否是ajax请求
     * @Author Linyb
     * @Date 2016/12/14 13:49
     */
    public static boolean isAjax(HttpServletRequest request){
        return  (request.getHeader("X-Requested-With") != null  && "XMLHttpRequest".equals( request.getHeader("X-Requested-With").toString())   ) ;
    }

    public static void main(String[] args) {
        String url = "http://192.168.10.129:8098/goldccm_war/test/test1";
//        https://api.shujumohe.com/octopus/sdk.service.task.query/v3?partner_code=jrhk_mohe&partner_key=787985c220ea41168bb26f5efaa8f79b&task_id=TASKEB000103201803301754150230940022
// String content = "task_id=TASKEB000103201803301754150230940022";
        String type ="application/x-www-form-urlencoded";
                //"application/json";
        Map<String, String> map = new HashMap<String, String>();
        map.put("partner_code", "jrhk_mohe");
        map.put("partner_key", "787985c220ea41168bb26f5efaa8f79b");
        map.put("task_id", "TASKEB000103201803301754150230940022");
        map.put("name","zhangsan");
        map.put("reason","实打实大师大红色的交付的时间发生的回复还是电风扇对方水电费是的");
        String s = sendPost(url, map, type);
        System.out.println(s.toString());
    }


}
