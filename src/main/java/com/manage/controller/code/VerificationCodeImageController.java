package com.manage.controller.code;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;

/**
 * Created by L on 2017/8/8.
 */
@Controller
@RequestMapping("/kaptcha/*")
public class VerificationCodeImageController {

    @Autowired
    private Producer captchaProducer;

    @RequestMapping("/imgCode")
    public void getKaptchaImage(HttpServletRequest request, HttpServletResponse response) throws Exception {

        //try {

            HttpSession session = request.getSession();
            String code = (String)session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
            //System.out.println("******************验证码是: " + code + "******************");

            response.setDateHeader("Expires", 0);

            // Set standard HTTP/1.1 no-cache headers.
            response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");

            // Set IE extended HTTP/1.1 no-cache headers (use addHeader).
            response.addHeader("Cache-Control", "post-check=0, pre-check=0");

            // Set standard HTTP/1.0 no-cache header.
            response.setHeader("Pragma", "no-cache");

            // return a jpeg
            response.setContentType("image/jpeg");

            // create the text for the image
            String capText = captchaProducer.createText();

            // store the text in the session
            session.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);

            // create the image with the text
            BufferedImage bi = captchaProducer.createImage(capText);
            ServletOutputStream out = response.getOutputStream();
            //System.out.println("验证码中的："+session.getId());
            // write the data out
            ImageIO.write(bi, "jpg", out);
            try {
                out.flush();
            } finally {
                out.close();
            }
            //return null;
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }

}
