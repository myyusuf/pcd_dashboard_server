package id.co.wika.pcd.dashboard.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import id.co.wika.pcd.dashboard.ResponseHelper;
import id.co.wika.pcd.dashboard.dto.ResponseDto;
import id.co.wika.pcd.dashboard.model.Project;
import id.co.wika.pcd.dashboard.model.ProjectProgress;
import id.co.wika.pcd.dashboard.service.ProjectProgressService;
import id.co.wika.pcd.dashboard.service.ProjectService;

@RestController
@EnableAutoConfiguration
@ComponentScan({"id.co.wika.pcd.dashboard"})
public class ProjectProgressController {
	
	@Autowired
	private ProjectProgressService projectProgressService;
	
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(value="/project_progress")
    @ResponseBody
    ResponseDto<ProjectProgress> list() {
		List<ProjectProgress> list = projectProgressService.list();
		ResponseDto<ProjectProgress> response = new ResponseDto<ProjectProgress>();
		response.setData(list);
		response.setTotalRecords(list.size());
        return response;
    }
	
	@RequestMapping(value="/project_progress/upload", method=RequestMethod.POST)
    @ResponseBody 
    Map<String, String> create(@RequestParam("progress") MultipartFile file) throws IOException {
		
		System.out.println("File : " + file.getName());
		
		byte[] bytes = file.getBytes();

		// Creating the directory to store file
//		String rootPath = System.getProperty("catalina.home");
//		File dir = new File(rootPath + File.separator + "tmpFiles");
//		if (!dir.exists())
//			dir.mkdirs();

		// Create the file on server
		String filePath = "/Users/myyusuf/Documents/Test/pcd_data/dpe_input.xlsx";
		
		File serverFile = new File(filePath);
		if(!serverFile.exists()){
			serverFile.createNewFile();
		}
		BufferedOutputStream stream = new BufferedOutputStream(
				new FileOutputStream(serverFile));
		stream.write(bytes);
		stream.close();
		
		try {
			readExcelFile(filePath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        return ResponseHelper.responseSuccess();
    }

	private void readExcelFile(String filePath) throws Exception {
		FileInputStream file = new FileInputStream(new File(filePath));
		
		//Get the workbook instance for XLS file 
		@SuppressWarnings("resource")
//		HSSFWorkbook workbook = new HSSFWorkbook(file);
		XSSFWorkbook workbook = new XSSFWorkbook (file);
		

		//Get first sheet from the workbook
		XSSFSheet sheet = workbook.getSheet("INPUTAN");
		
		//Iterate through each rows from first sheet
//		Iterator<Row> rowIterator = sheet.iterator();
		
		for(int i=1; i<=12; i++){
			parseProjectByMonth(sheet.iterator(), i);
		}
		
		file.close();
		
	}
	
	private void parseProjectByMonth(Iterator<Row> rowIterator, int month){
		
		int YEAR = 2016;
		
		int projectRowNum = 0;
		String projectCode = "";
		String projectName = "";
		BigDecimal rkapOk = new BigDecimal("0.0");
		BigDecimal rkapOp = new BigDecimal("0.0");
		BigDecimal rkapLk = new BigDecimal("0.0");
		
		BigDecimal prognosaOk = new BigDecimal("0.0");
		BigDecimal prognosaOp = new BigDecimal("0.0");
		BigDecimal prognosaLk = new BigDecimal("0.0");
		
		BigDecimal realisasiOk = new BigDecimal("0.0");
		BigDecimal realisasiOp = new BigDecimal("0.0");
		BigDecimal realisasiLk = new BigDecimal("0.0");
		
		int cellMonthPositionInit = 3 * (month - 1);
		
		while(rowIterator.hasNext()) {
			Row row = rowIterator.next();
			
			if(row.getRowNum() > 9 && row.getRowNum() < 46){
				
				//Last row indicator
				Cell cell2 = row.getCell(2);
				if(cell2 != null){
					switch (projectRowNum){
						case 0:
							projectCode = cell2.getStringCellValue() != null ? cell2.getStringCellValue().replaceAll("[^A-Za-z0-9]", "") : "";
							
							System.out.println("Project code : '" + projectCode + "'");
							Cell cell4 = row.getCell(4);
							projectName = cell4.getStringCellValue() != null ? cell4.getStringCellValue().replaceAll("[^A-Za-z0-9]", "") : "";
							
							Cell cell9 = row.getCell(cellMonthPositionInit + 9);
							double rkapOkTmp = cell9.getNumericCellValue();
							rkapOk = BigDecimal.valueOf(rkapOkTmp);
							
							Cell cell10 = row.getCell(cellMonthPositionInit + 10);
							double rkapOpTmp = cell10.getNumericCellValue();
							rkapOp = BigDecimal.valueOf(rkapOpTmp);
							
							Cell cell11 = row.getCell(cellMonthPositionInit + 11);
							double rkapLkTmp = cell11.getNumericCellValue();
							rkapLk = BigDecimal.valueOf(rkapLkTmp);
							
							break;
						case 1:
							
							Cell cell9b = row.getCell(cellMonthPositionInit + 9);
							double prognosaOkTmp = cell9b.getNumericCellValue();
							prognosaOk = BigDecimal.valueOf(prognosaOkTmp);
							
							Cell cell10b = row.getCell(cellMonthPositionInit + 10);
							double prognosaOpTmp = cell10b.getNumericCellValue();
							prognosaOp = BigDecimal.valueOf(prognosaOpTmp);
							
							Cell cell11b = row.getCell(cellMonthPositionInit + 11);
							double prognosaLkTmp = cell11b.getNumericCellValue();
							prognosaLk = BigDecimal.valueOf(prognosaLkTmp);
							
							break;
						case 2:
							
							Cell cell9c = row.getCell(cellMonthPositionInit + 9);
							double realisasiOkTmp = cell9c.getNumericCellValue();
							realisasiOk = BigDecimal.valueOf(realisasiOkTmp);
							
							Cell cell10c = row.getCell(cellMonthPositionInit + 10);
							double realisasiOpTmp = cell10c.getNumericCellValue();
							realisasiOp = BigDecimal.valueOf(realisasiOpTmp);
							
							Cell cell11c = row.getCell(cellMonthPositionInit + 11);
							double realisasiLkTmp = cell11c.getNumericCellValue();
							realisasiLk = BigDecimal.valueOf(realisasiLkTmp);
							
//							System.out.println(
//									"Month : " + month +
//									", Project code : " + projectCode + 
//									", Project name :" + projectName +
//									", RKAP OK : " + rkapOk.toPlainString() +
//									", RKAP OP : " + rkapOp.toPlainString() +
//									", RKAP LK : " + rkapLk.toPlainString() +
//									
//									", Prognosa OK : " + prognosaOk.toPlainString() +
//									", Prognosa OP : " + prognosaOp.toPlainString() +
//									", Prognosa LK : " + prognosaLk.toPlainString() +
//									
//									", Realisasi OK : " + realisasiOk.toPlainString() +
//									", Realisasi OP : " + realisasiOp.toPlainString() +
//									", Realisasi LK : " + realisasiLk.toPlainString()
//									);
							Project project = projectService.getByCode(projectCode);
							if(project != null){
								ProjectProgress projectProgress = projectProgressService.getByCodeMonthYear(projectCode, month, YEAR);
								if(projectProgress != null){
									projectProgress.setRkapOk(rkapOk);
									projectProgress.setRkapOp(rkapOp);
									projectProgress.setRkapLk(rkapLk);
									
									projectProgress.setPrognosaOk(prognosaOk);
									projectProgress.setPrognosaOp(prognosaOp);
									projectProgress.setPrognosaLk(prognosaLk);
									
									projectProgress.setRealisasiOk(realisasiOk);
									projectProgress.setRealisasiOp(realisasiOp);
									projectProgress.setRealisasiLk(realisasiLk);
									
									projectProgressService.update(projectProgress);
								}else{
									projectProgress = new ProjectProgress();
									projectProgress.setProject(project);
									projectProgress.setMonth(month);
									projectProgress.setYear(YEAR);
									
									projectProgress.setRkapOk(rkapOk);
									projectProgress.setRkapOp(rkapOp);
									projectProgress.setRkapLk(rkapLk);
									
									projectProgress.setPrognosaOk(prognosaOk);
									projectProgress.setPrognosaOp(prognosaOp);
									projectProgress.setPrognosaLk(prognosaLk);
									
									projectProgress.setRealisasiOk(realisasiOk);
									projectProgress.setRealisasiOp(realisasiOp);
									projectProgress.setRealisasiLk(realisasiLk);
									
									projectProgressService.create(projectProgress);
								}							
							}
							
							break;
						case 3:
							projectRowNum = -1;
							projectCode = "";
							projectName = "";
							rkapOk = new BigDecimal("0.0");
							rkapOp = new BigDecimal("0.0");
							rkapLk = new BigDecimal("0.0");
							
							prognosaOk = new BigDecimal("0.0");
							prognosaOp = new BigDecimal("0.0");
							prognosaLk = new BigDecimal("0.0");
							
							realisasiOk = new BigDecimal("0.0");
							realisasiOp = new BigDecimal("0.0");
							realisasiLk = new BigDecimal("0.0");
							break;
					}	
				}
//				System.out.println("Project row num : " + projectRowNum);
				projectRowNum++;
			}
			
			//For each row, iterate through each columns
//			Iterator<Cell> cellIterator = row.cellIterator();
//			while(cellIterator.hasNext()) {
//				
//				Cell cell = cellIterator.next();
//				
//				System.out.print(cell.getStringCellValue() + "");
//			}
			
		}
	}

}
