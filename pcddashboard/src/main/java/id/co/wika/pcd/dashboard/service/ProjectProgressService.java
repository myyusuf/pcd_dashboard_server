package id.co.wika.pcd.dashboard.service;

import java.util.List;

import id.co.wika.pcd.dashboard.model.ProjectProgress;

public interface ProjectProgressService {
	void create(ProjectProgress projectProgress);
	void update(ProjectProgress projectProgress);
	List<ProjectProgress> list();
	ProjectProgress getByCodeMonthYear(String code, int month, int year);
	List<ProjectProgress> selectAllByMonthAndYear(int month, int year);
}
