package id.co.wika.pcd.dashboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.wika.pcd.dashboard.dao.hibernate.ProjectProgressDao;
import id.co.wika.pcd.dashboard.model.ProjectProgress;

@Service
public class ProjectProgressServiceImpl implements ProjectProgressService {
	
	@Autowired
	private ProjectProgressDao projectProgressDao;

	@Override
	public void create(ProjectProgress projectProgress) {
		projectProgressDao.create(projectProgress);
	}

	@Override
	public List<ProjectProgress> list() {
		return projectProgressDao.getAll();
	}

	@Override
	public ProjectProgress getByCodeMonthYear(String code, int month, int year) {
		return projectProgressDao.getByCodeMonthYear(code, month, year);
	}

	@Override
	public void update(ProjectProgress projectProgress) {
		projectProgressDao.update(projectProgress);
	}

}
