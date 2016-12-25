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
		DashboardItemDto data = new DashboardItemDto();
		data.setTitle("Realisasi");
		data.setOk(new BigDecimal("118.19"));
		data.setOp(new BigDecimal("0.00"));
		data.setLsp(new BigDecimal("2.82"));
		dashboardDto.setData1(data);
		
		data = new DashboardItemDto();
		data.setTitle("RKAP");
		data.setOk(new BigDecimal("3287.40"));
		data.setOp(new BigDecimal("962.06"));
		data.setLsp(new BigDecimal("10.90"));
		dashboardDto.setData2(data);
		
		data = new DashboardItemDto();
		data.setTitle("Prog");
		data.setOk(new BigDecimal("1338.96"));
		data.setOp(new BigDecimal("19.15"));
		data.setLsp(new BigDecimal("17.34"));
		dashboardDto.setData3(data);
		
		data = new DashboardItemDto();
		data.setTitle("SISA");
		data.setOk(new BigDecimal("1457.15"));
		data.setOp(new BigDecimal("19.15"));
		data.setLsp(new BigDecimal("-15.52"));
		dashboardDto.setData4(data);
		
		System.out.println("dasboard...");
        return dashboardDto;
    }

}
