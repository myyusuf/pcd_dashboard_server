package id.co.wika.pcd.dashboard.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import id.co.wika.pcd.dashboard.dto.ChartDataDto;
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
		data.setOk(new BigDecimal("3287.40"));
		data.setOp(new BigDecimal("962.06"));
		data.setLsp(new BigDecimal("100.9"));
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
	
	@RequestMapping(value="/dashboard/ok/{selectedYear}")
    @ResponseBody
	public List<ChartDataDto> getOkChartData(@PathVariable("selectedYear") int selectedYear){
		
		List<ChartDataDto> result = new ArrayList<ChartDataDto>();
		ChartDataDto chartDataDto = new ChartDataDto();
		chartDataDto.setMonth("Jan");
		chartDataDto.setPlan(new BigDecimal("16.99"));
		chartDataDto.setActual(new BigDecimal("57.727"));
		result.add(chartDataDto);
		
		chartDataDto = new ChartDataDto();
		chartDataDto.setMonth("Feb");
		chartDataDto.setPlan(new BigDecimal("336.515"));
		chartDataDto.setActual(new BigDecimal("270.909"));
		result.add(chartDataDto);
		
		chartDataDto = new ChartDataDto();
		chartDataDto.setMonth("Mar");
		chartDataDto.setPlan(new BigDecimal("1650.662"));
		chartDataDto.setActual(new BigDecimal("1614.947"));
		result.add(chartDataDto);
		
		chartDataDto = new ChartDataDto();
		chartDataDto.setMonth("Apr");
		chartDataDto.setPlan(new BigDecimal("1893.504"));
		chartDataDto.setActual(new BigDecimal("2087.302"));
		result.add(chartDataDto);
		
		chartDataDto = new ChartDataDto();
		chartDataDto.setMonth("Mei");
		chartDataDto.setPlan(new BigDecimal("1913.385"));
		chartDataDto.setActual(new BigDecimal("2315.823"));
		result.add(chartDataDto);
		return result;
//		[
//		  {
//		    "month": "Jan",
//		    "plan": 16.99,
//		    "actual": 52.727
//		  },
//		  {
//		    "month": "Feb",
//		    "plan": 336.515,
//		    "actual": 270.909
//		  },
//		  {
//		    "month": "Mar",
//		    "plan": 1650.662,
//		    "actual": 1614.947
//		  },
//		  {
//		    "month": "Apr",
//		    "plan": 1893.504,
//		    "actual": 2087.302
//		  },
//		  {
//		    "month": "Mei",
//		    "plan": 1913.385,
//		    "actual": 2315.823
//		  },
//		  {
//		    "month": "Jun",
//		    "plan": 1932.368,
//		    "actual": 2417.732
//		  },
//		  {
//		    "month": "Jul",
//		    "plan": 2251.404,
//		    "actual": 2417.732
//		  },
//		  {
//		    "month": "Ags",
//		    "plan": 2447.976,
//		    "actual": 3180.081
//		  },
//		  {
//		    "month": "Sep",
//		    "plan": 2469.952,
//		    "actual": 3193.046
//		  },
//		  {
//		    "month": "Okt",
//		    "plan": 2515.469,
//		    "actual": 3200.158
//		  },
//		  {
//		    "month": "Nov",
//		    "plan": 2547.981,
//		    "actual": 3567.663
//		  },
//		  {
//		    "month": "Des",
//		    "plan": 2600,
//		    "actual": null
//		  }
//		]
	}
	
	@RequestMapping(value="/dashboard/op/{selectedYear}")
    @ResponseBody
	public List<ChartDataDto> getOpChartData(@PathVariable("selectedYear") int selectedYear){
		
		List<ChartDataDto> result = new ArrayList<ChartDataDto>();
		ChartDataDto chartDataDto = new ChartDataDto();
		chartDataDto.setMonth("Jan");
		chartDataDto.setPlan(new BigDecimal("16.99"));
		chartDataDto.setActual(new BigDecimal("57.727"));
		result.add(chartDataDto);
		
		chartDataDto = new ChartDataDto();
		chartDataDto.setMonth("Feb");
		chartDataDto.setPlan(new BigDecimal("336.515"));
		chartDataDto.setActual(new BigDecimal("270.909"));
		result.add(chartDataDto);
		
		chartDataDto = new ChartDataDto();
		chartDataDto.setMonth("Mar");
		chartDataDto.setPlan(new BigDecimal("1650.662"));
		chartDataDto.setActual(new BigDecimal("1614.947"));
		result.add(chartDataDto);
		
		chartDataDto = new ChartDataDto();
		chartDataDto.setMonth("Apr");
		chartDataDto.setPlan(new BigDecimal("1893.504"));
		chartDataDto.setActual(new BigDecimal("2087.302"));
		result.add(chartDataDto);
		
		chartDataDto = new ChartDataDto();
		chartDataDto.setMonth("Mei");
		chartDataDto.setPlan(new BigDecimal("1913.385"));
		chartDataDto.setActual(new BigDecimal("2315.823"));
		result.add(chartDataDto);
		return result;

	}
	
	@RequestMapping(value="/dashboard/lk/{selectedYear}")
    @ResponseBody
	public List<ChartDataDto> getLkChartData(@PathVariable("selectedYear") int selectedYear){
		
		List<ChartDataDto> result = new ArrayList<ChartDataDto>();
		ChartDataDto chartDataDto = new ChartDataDto();
		chartDataDto.setMonth("Jan");
		chartDataDto.setPlan(new BigDecimal("16.99"));
		chartDataDto.setActual(new BigDecimal("57.727"));
		result.add(chartDataDto);
		
		chartDataDto = new ChartDataDto();
		chartDataDto.setMonth("Feb");
		chartDataDto.setPlan(new BigDecimal("336.515"));
		chartDataDto.setActual(new BigDecimal("270.909"));
		result.add(chartDataDto);
		
		chartDataDto = new ChartDataDto();
		chartDataDto.setMonth("Mar");
		chartDataDto.setPlan(new BigDecimal("1650.662"));
		chartDataDto.setActual(new BigDecimal("1614.947"));
		result.add(chartDataDto);
		
		chartDataDto = new ChartDataDto();
		chartDataDto.setMonth("Apr");
		chartDataDto.setPlan(new BigDecimal("1893.504"));
		chartDataDto.setActual(new BigDecimal("2087.302"));
		result.add(chartDataDto);
		
		chartDataDto = new ChartDataDto();
		chartDataDto.setMonth("Mei");
		chartDataDto.setPlan(new BigDecimal("1913.385"));
		chartDataDto.setActual(new BigDecimal("2315.823"));
		result.add(chartDataDto);
		return result;

	}
	
	@RequestMapping(value="/dashboard/lsp/{selectedYear}")
    @ResponseBody
	public List<ChartDataDto> getLspChartData(@PathVariable("selectedYear") int selectedYear){
		
		List<ChartDataDto> result = new ArrayList<ChartDataDto>();
		ChartDataDto chartDataDto = new ChartDataDto();
		chartDataDto.setMonth("Jan");
		chartDataDto.setPlan(new BigDecimal("16.99"));
		chartDataDto.setActual(new BigDecimal("57.727"));
		result.add(chartDataDto);
		
		chartDataDto = new ChartDataDto();
		chartDataDto.setMonth("Feb");
		chartDataDto.setPlan(new BigDecimal("336.515"));
		chartDataDto.setActual(new BigDecimal("270.909"));
		result.add(chartDataDto);
		
		chartDataDto = new ChartDataDto();
		chartDataDto.setMonth("Mar");
		chartDataDto.setPlan(new BigDecimal("1650.662"));
		chartDataDto.setActual(new BigDecimal("1614.947"));
		result.add(chartDataDto);
		
		chartDataDto = new ChartDataDto();
		chartDataDto.setMonth("Apr");
		chartDataDto.setPlan(new BigDecimal("1893.504"));
		chartDataDto.setActual(new BigDecimal("2087.302"));
		result.add(chartDataDto);
		
		chartDataDto = new ChartDataDto();
		chartDataDto.setMonth("Mei");
		chartDataDto.setPlan(new BigDecimal("1913.385"));
		chartDataDto.setActual(new BigDecimal("2315.823"));
		result.add(chartDataDto);
		return result;

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
