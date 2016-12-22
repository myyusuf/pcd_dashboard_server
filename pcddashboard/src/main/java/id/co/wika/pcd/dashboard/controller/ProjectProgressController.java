package id.co.wika.pcd.dashboard.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

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
		File serverFile = new File("/Users/myyusuf/Documents/Test/pcd_data/test.docx");
		if(!serverFile.exists()){
			serverFile.createNewFile();
		}
		BufferedOutputStream stream = new BufferedOutputStream(
				new FileOutputStream(serverFile));
		stream.write(bytes);
		stream.close();
		
        return ResponseHelper.responseSuccess();
    }

}
