package id.co.wika.pcd.dashboard.service;

import org.springframework.stereotype.Service;

@Service
public class DashboardServiceImpl implements DashboardService {

	@Override
	public String getInfo() {
		return "PCD Dashboard";
	}

}
