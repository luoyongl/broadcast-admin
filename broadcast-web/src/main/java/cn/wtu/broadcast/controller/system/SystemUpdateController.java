package cn.wtu.broadcast.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.wtu.broadcast.controller.BaseController;

@Controller
@RequestMapping("systemManage/systemUpdate")
public class SystemUpdateController extends BaseController{
	
	@GetMapping
	public String ui(){
		return "systemManage/systemUpdate";
	}
}
