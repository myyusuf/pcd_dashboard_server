package id.co.wika.pcd.dashboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.wika.pcd.dashboard.dao.hibernate.ProjectDao;
import id.co.wika.pcd.dashboard.model.Project;

@Service	
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	private ProjectDao projectDao;

	@Override
	public void create(Project project) {
		projectDao.create(project);
	}

	@Override
	public void update(Project project) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Project project) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Project> list() {
		return projectDao.getAll();
	}

}
