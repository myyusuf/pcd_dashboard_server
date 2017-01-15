package id.co.wika.pcd.dashboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.wika.pcd.dashboard.mapper.ProjectMapper;
import id.co.wika.pcd.dashboard.model.Project;

@Service	
public class ProjectService  {
	
	@Autowired
	private ProjectMapper projectMapper;

	public void create(Project project) {
		projectMapper.create(project);
	}

	public void update(Project project) {
		projectMapper.update(project);
	}

	public void delete(String code) {
		projectMapper.delete(code); 
	}

	public List<Project> findAll() {
		return projectMapper.findAll();
	}

	public Project getByCode(String code) {
		Project project = null;
		try{
			project = projectMapper.findByCode(code);
		}catch(Exception e){
			System.out.println("Project not found : '" + code + "'");	
		}
		
		return project;
	}

}
