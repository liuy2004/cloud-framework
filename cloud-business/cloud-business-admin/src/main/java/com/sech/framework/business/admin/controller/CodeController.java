package com.sech.framework.business.admin.controller;

import com.sech.framework.business.admin.service.UserService;
import com.sech.framework.business.commons.permission.Module;
import com.sech.framework.business.commons.web.aop.PrePermissions;
import com.sech.framework.core.commons.constants.SecurityConstant;
import com.sech.framework.core.utils.Assert;
import com.google.code.kaptcha.Producer;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;

/**
 * 图像验证码服务
 *
 * @author sech.io
 */
@Controller
@PrePermissions(value = Module.CODE, required = false)
public class CodeController {

    @Autowired
    private Producer producer;

    @Autowired
    private UserService userService;

    /**
     * 创建验证码
     */
    @GetMapping(SecurityConstant.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/{randomStr}")
    public void createCode(@PathVariable String randomStr, HttpServletRequest request,
                           HttpServletResponse response) throws Exception {
        Assert.isBlank(randomStr, "随机码不能为空");
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");
        // 生成文字验证码
        String text = producer.createText();
        // 生成图片验证码
        BufferedImage image = producer.createImage(text);
        userService.saveImageCode(randomStr, text);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "JPEG", out);
        IOUtils.closeQuietly(out);
    }

}
