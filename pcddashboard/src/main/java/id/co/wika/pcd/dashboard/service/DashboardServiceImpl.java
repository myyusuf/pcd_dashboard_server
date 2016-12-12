package id.co.wika.pcd.dashboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.wika.pcd.dashboard.dao.hibernate.UserDao;

@Service
public class DashboardServiceImpl implements DashboardService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public String getInfo() {
		int count = userDao.getAll().size();
		return "PCD Dashboard : " + count;
	}

}
