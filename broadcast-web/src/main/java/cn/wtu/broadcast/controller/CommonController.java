package cn.wtu.broadcast.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
    * @ClassName: CommonController
    * @Description: 公共处理
    * @author huangjiakui
    * @date 2018年12月04日
    *
 */
@Controller
@RequestMapping("/common")
public class CommonController {
	/**
	 * 错误提示
	 */
	@RequestMapping("/error")
	public String error() {
		return "";
	}

	/**
	 * 权限错误
	 */
	@RequestMapping("/unauthorized")
	public String unauthorized(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String requestType = request.getHeader("X-Requested-With");
		if (requestType != null && requestType.equalsIgnoreCase("XMLHttpRequest")) {
			response.addHeader("loginStatus", "unauthorized");
			response.sendError(HttpServletResponse.SC_FORBIDDEN);
			return null;
		}
		return "";
	}
}