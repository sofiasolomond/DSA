package com.skyscrapper.building;

public class DriverClass {

	public static void main(String args[]) {
		while (true) {
			System.out.println("\n------------------------------");
			System.out.println("WELCOME TO SKYSCRAPPER BUILDERS !!\n");
			System.out.println("1.Set new Data and build floors");
			System.out.println("2.Quit Application");
			System.out.println("------------------------------");
			System.out.println("Enter your choice");
			int choice = SkyScrapperData.scannerObj.nextInt();
			switch (choice) {
			case 1:
				SkyScrapperData skyScrapperData = new SkyScrapperData();
				skyScrapperData.setData();
				skyScrapperData.buildSkyScapper();
				break;
			case 2:
				System.out.println("Exited Successfully!!");
				SkyScrapperData.scannerObj.close();
				System.exit(0);
				break;
			default:
				System.out.println("Give valid Input!!");
			}
		}
	}
}
