package id.co.wika.pcd.dashboard.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import id.co.wika.pcd.dashboard.ResponseHelper;

@RestController
@EnableAutoConfiguration
@ComponentScan({"id.co.wika.pcd.dashboard"})
public class ProjectProgressController {
	
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
		Iterator<Row> rowIterator = sheet.iterator();
		
		int projectRowNum = 0;
		String projectCode = "";
		String projectName = "";
		BigDecimal rkapOk = new BigDecimal("0.0");
		BigDecimal rkapOp = new BigDecimal("0.0");
		BigDecimal rkapLk = new BigDecimal("0.0");
		
		while(rowIterator.hasNext()) {
			Row row = rowIterator.next();
			
			if(row.getRowNum() > 9 && row.getRowNum() < 46){
				
				//Last row indicator
				Cell cell2 = row.getCell(2);
				if(cell2 != null){
					switch (projectRowNum){
						case 0:
							projectCode = cell2.getStringCellValue();
							
							Cell cell4 = row.getCell(4);
							projectName = cell4.getStringCellValue();
							
							Cell cell9 = row.getCell(9);
							double rkapOkTmp = cell9.getNumericCellValue();
							rkapOk = BigDecimal.valueOf(rkapOkTmp);
							
							Cell cell10 = row.getCell(10);
							double rkapOpTmp = cell10.getNumericCellValue();
							rkapOp = BigDecimal.valueOf(rkapOpTmp);
							
							Cell cell11 = row.getCell(11);
							double rkapLkTmp = cell11.getNumericCellValue();
							rkapLk = BigDecimal.valueOf(rkapLkTmp);
							
							break;
						case 1:
							
							break;
						case 2:
							System.out.println("Project code : " + projectCode + 
									", Project name :" + projectName +
									", RKAP OK : " + rkapOk.toPlainString() +
									", RKAP OP : " + rkapOp.toPlainString() +
									", RKAP LK : " + rkapLk.toPlainString()
									);
							break;
						case 3:
							projectRowNum = -1;
							projectCode = "";
							projectName = "";
							rkapOk = new BigDecimal("0.0");
							rkapOp = new BigDecimal("0.0");
							rkapLk = new BigDecimal("0.0");
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
		
		file.close();
		
	}

}
