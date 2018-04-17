package com.controller;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;

import com.base.util.ValidateCode;

public class ValidateCodeController {
	/**
	 * 生成验证码
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @ValidateCode.generateTextCode(验证码字符类型,验证码长度,需排除的特殊字符) @ValidateCode.generateImageCode(文本验证码,图片宽度,图片高度,干扰线的条数,字符的高低位置是否随机,图片颜色,字体颜色,干扰线颜色)
	 */

	@RequestMapping(value = "validateCode")
	public void validateCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setHeader("Cache-Control", "no-cache");
		String verifyCode = ValidateCode.generateTextCode(ValidateCode.TYPE_NUM_LOWER, 4, null);
		request.getSession().setAttribute("validateCode", verifyCode);
		response.setContentType("image/jpeg");
		BufferedImage bim = ValidateCode.generateImageCode(verifyCode, 90, 30, 5, true, Color.WHITE, Color.BLUE, null);
		ImageIO.write(bim, "JPEG", response.getOutputStream());
	}
}
