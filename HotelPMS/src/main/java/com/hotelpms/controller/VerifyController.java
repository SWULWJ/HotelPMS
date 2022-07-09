package com.hotelpms.controller;

import com.google.code.kaptcha.Producer;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
public class VerifyController {

    private final Producer producer;

    @Autowired
    public VerifyController(Producer producer) {
        this.producer = producer;
    }

    @RequestMapping("/verify.jpg")
    public void verifyCode(HttpServletResponse response, HttpSession session) throws IOException {
        String text = producer.createText();
        session.setAttribute("verifyCode", text);
        BufferedImage image = producer.createImage(text);
        response.setContentType("image/jpg");
        ServletOutputStream servletOutputStream = response.getOutputStream();
        ImageIO.write(image, "jpg" ,servletOutputStream);
    }
}
