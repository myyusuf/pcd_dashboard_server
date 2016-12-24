package id.co.wika.pcd.dashboard.controller;

import java.math.BigDecimal;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import id.co.wika.pcd.dashboard.dto.DashboardDto;
import id.co.wika.pcd.dashboard.dto.DashboardItemDto;

@RestController
@EnableAutoConfiguration
@ComponentScan({"id.co.wika.pcd.dashboard"})
public class DashboardController {
	
	@RequestMapping(value="/dashboard")
    @ResponseBody
    DashboardDto list() {
		
		DashboardDto dashboardDto = new DashboardDto();
		DashboardItemDto data1 = new DashboardItemDto();
		data1.setOk(new BigDecimal("118.19"));
		data1.setOp(new BigDecimal("0.00"));
		data1.setLsp(new BigDecimal("1.82"));
		
		dashboardDto.setData1(data1);
		
        return dashboardDto;
    }

}
