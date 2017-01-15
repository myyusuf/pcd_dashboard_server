package id.co.wika.pcd.dashboard.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import id.co.wika.pcd.dashboard.dto.DashboardDto;
import id.co.wika.pcd.dashboard.dto.DashboardItemDto;
import id.co.wika.pcd.dashboard.model.ProjectProgress;
import id.co.wika.pcd.dashboard.service.ProjectProgressService;

@RestController
@EnableAutoConfiguration
@ComponentScan({"id.co.wika.pcd.dashboard"})
public class DashboardController {
	
	@Autowired
	private ProjectProgressService projectProgressService;
	
	@RequestMapping(value="/dashboard")
    @ResponseBody
    DashboardDto list() {
		
		DashboardDto dashboardDto = new DashboardDto();
//		DashboardItemDto data = new DashboardItemDto();
//		data.setTitle("Realisasi");
//		data.setOk(new BigDecimal("118.19"));
//		data.setOp(new BigDecimal("0.00"));
//		data.setLsp(new BigDecimal("2.82"));
		dashboardDto.setData1(getData1Values());
		
		DashboardItemDto data = new DashboardItemDto();
		data.setTitle("RKAP");
		data.setOk(new BigDecimal("0.0"));
		data.setOp(new BigDecimal("0.0"));
		data.setLsp(new BigDecimal("0.0"));
		dashboardDto.setData2(data);
		
		data = new DashboardItemDto();
		data.setTitle("Prog");
		data.setOk(new BigDecimal("0.0"));
		data.setOp(new BigDecimal("0.0"));
		data.setLsp(new BigDecimal("0.0"));
		dashboardDto.setData3(data);
		
		data = new DashboardItemDto();
		data.setTitle("SISA");
		data.setOk(new BigDecimal("0.0"));
		data.setOp(new BigDecimal("0.0"));
		data.setLsp(new BigDecimal("0.0"));
		dashboardDto.setData4(data);
		
//		System.out.println("dasboard...");
        return dashboardDto;
    }
	
	private DashboardItemDto getData1Values(){
		
		List<ProjectProgress> projectProgressList = projectProgressService
				.findByMonthAndYear(1, 2016);
		BigDecimal totalOk = new BigDecimal("0.0");
		BigDecimal totalOp = new BigDecimal("0.0");
		BigDecimal totalLsp = new BigDecimal("0.0");
		for (ProjectProgress projectProgress: projectProgressList){
			totalOk = totalOk.add(projectProgress.getRealisasiOk());
			totalOp = totalOp.add(projectProgress.getRealisasiOp());
			totalLsp = totalLsp.add(projectProgress.getRealisasiLk());
		}
		
		DashboardItemDto data = new DashboardItemDto();
		data.setTitle("Realisasi");
		data.setOk(totalOk);
		data.setOp(totalOp);
		data.setLsp(totalLsp);
		
		return data;
	}

}
