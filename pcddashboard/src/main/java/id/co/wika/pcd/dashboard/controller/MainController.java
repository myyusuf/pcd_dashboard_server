package id.co.wika.pcd.dashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import id.co.wika.pcd.dashboard.service.DashboardService;

@Controller
@EnableAutoConfiguration
@ComponentScan({"id.co.wika.pcd.dashboard"})
public class MainController {
	
	@Autowired
	private DashboardService dashboardServiceService;
	
	@RequestMapping("/")
    @ResponseBody
    String home() {
        return "Info : " + dashboardServiceService.getInfo();
    }
}
