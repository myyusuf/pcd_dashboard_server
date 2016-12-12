package id.co.wika.pcd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import id.co.wika.pcd.dashboard.controller.MainController;

@SpringBootApplication
public class PcddashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainController.class, args);
	}
}
