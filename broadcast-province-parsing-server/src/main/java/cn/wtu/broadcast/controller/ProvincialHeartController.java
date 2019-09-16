package cn.wtu.broadcast.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wtu.broadcast.parent.pojo.BroadcastResult;

@Controller
@RequestMapping("heart")
public class ProvincialHeartController {

	/**
	 * 平台心跳测试，检查本平台是否正常启动了
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/check", method = RequestMethod.POST)
	@ResponseBody
	public BroadcastResult check(HttpServletRequest request, HttpServletResponse response) {
		return BroadcastResult.ok();
	}
}
