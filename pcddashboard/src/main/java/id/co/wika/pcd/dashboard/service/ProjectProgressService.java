package id.co.wika.pcd.dashboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.wika.pcd.dashboard.mapper.ProjectProgressMapper;
import id.co.wika.pcd.dashboard.model.ProjectProgress;

@Service
public class ProjectProgressService{
	
	@Autowired
	private ProjectProgressMapper projectProgressMapper;

	public void create(ProjectProgress projectProgress) {
		projectProgressMapper.create(projectProgress);
	}

	public List<ProjectProgress> findAll() {
		return projectProgressMapper.findAll();
	}

	public ProjectProgress findByCodeMonthYear(String code, int month, int year) {
		ProjectProgress projectProgress = null;
		try{
			projectProgress = projectProgressMapper.findByCodeMonthYear(code, month, year);
		}catch(Exception e){
			System.out.println("CODE ERROR : " + code);
			e.printStackTrace();
			System.out.println("Project progress not found");
		}
				
		return projectProgress;
	}

	public void update(ProjectProgress projectProgress) {
		projectProgressMapper.update(projectProgress);
	}

	public List<ProjectProgress> findByMonthAndYear(int month, int year) {
		return projectProgressMapper.findByMonthAndYear(month, year);
	}

}
