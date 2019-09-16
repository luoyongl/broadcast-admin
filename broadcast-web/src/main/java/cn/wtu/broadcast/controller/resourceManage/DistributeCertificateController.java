package cn.wtu.broadcast.controller.resourceManage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.wtu.broadcast.controller.BaseController;

@Controller
@RequestMapping("resourceManage/distributeCertificate")
public class DistributeCertificateController extends BaseController{
	
	@GetMapping
	public String ui(){
		return "resourceManage/distributeCertificate";
	}
}
