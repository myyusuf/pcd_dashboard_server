package id.co.wika.pcd.dashboard.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import id.co.wika.pcd.dashboard.ResponseHelper;
import id.co.wika.pcd.dashboard.dto.ResponseDto;
import id.co.wika.pcd.dashboard.model.Project;
import id.co.wika.pcd.dashboard.service.ProjectService;

@RestController
@EnableAutoConfiguration
@ComponentScan({"id.co.wika.pcd.dashboard"})
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(value="/projects", method=RequestMethod.POST)
    @ResponseBody 
    Map<String, String> create(@RequestBody Project project) {
		
		projectService.create(project);
		
        return ResponseHelper.responseSuccess();
    }
	
	@RequestMapping(value="/projects")
    @ResponseBody
    ResponseDto<Project> list() {
		List<Project> list = projectService.list();
		ResponseDto<Project> response = new ResponseDto<Project>();
		response.setData(list);
		response.setTotalRecords(list.size());
        return response;
    }
	
	@RequestMapping(value="/projects/{code}", method=RequestMethod.PUT)
    @ResponseBody 
    Map<String, String> update(@PathVariable("code") String code, @RequestBody Project project) {
		
		Project localProject = projectService.getByCode(code);
		localProject.setName(project.getName());
		localProject.setDescription(project.getDescription());
		localProject.setProjectType(project.getProjectType());
		projectService.update(localProject);
		
        return ResponseHelper.responseSuccess();
    }
	
	@RequestMapping(value="/projects/{code}", method=RequestMethod.DELETE)
    @ResponseBody 
    Map<String, String> delete(@PathVariable("code") String code) {
		
		Project project = projectService.getByCode(code);
		projectService.delete(project);
		
        return ResponseHelper.responseSuccess();
    }
	
}
