//package com.manage;
//
//import org.hamcrest.Matchers;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.util.LinkedMultiValueMap;
//import org.springframework.util.MultiValueMap;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.regex.Pattern;
//
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertThat;
//
///**
// *
// * @author   单红宇(365384722)
// * @myblog  http://blog.csdn.net/catoop/
// * @create    2016年2月23日
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
////@WebAppConfiguration // 使用@WebIntegrationTest注解需要将@WebAppConfiguration注释掉
////@WebIntegrationTest("server.port:0")// 使用0表示端口号随机，也可以具体指定如8888这样的固定端口
//public class ControllerTest {
//
//    private String dateReg;
//    private Pattern pattern;
//    private RestTemplate template = new RestTemplate();
//    @Value("${local.server.port}")// 注入端口号
//    private int port;
//
//    @Test
//    public void test3(){
//        String url = "http://localhost:"+8083+"/login/verificationUser";
//        MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
//        map.add("name", "Tom");
//        map.add("pwd", "Lily");
//        map.add("code", "Lily");
//        String result = template.postForObject(url, map, String.class);
//        System.out.println(result);
//        assertNotNull(result);
//        assertThat(result, Matchers.containsString("Tom"));
//    }
//
//}
