package id.co.wika.pcd.dashboard.service;

import java.util.List;

import id.co.wika.pcd.dashboard.model.Project;

public interface ProjectService {
	void create(Project project);
	void update(Project project);
	void delete(Project project);
	Project getByCode(String code);
	List<Project> list();
}
