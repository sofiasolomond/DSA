package com.skyscrapper.building;

import java.util.*;

public class SkyScrapperData {
	public static Scanner scannerObj = new Scanner(System.in);
	LinkedList<Integer> listOfAvailableFloorSize = new LinkedList<Integer>();
	LinkedList<Integer> listOfAvailableFloorSizeSorted = new LinkedList<Integer>();
	int totalNoOfFloors, numberOfDaysOfConstruction;

	void setData() {
		System.out.println("Enter the total no of floors in the building");
		totalNoOfFloors = numberOfDaysOfConstruction = scannerObj.nextInt();
		int floorSize;
		for (int floorNumber = 0; floorNumber < totalNoOfFloors; floorNumber++) {
			System.out.print("Enter the floor size given on day  " + (floorNumber + 1) + " : ");
			floorSize = scannerObj.nextInt();
			listOfAvailableFloorSize.add(floorSize);
			listOfAvailableFloorSizeSorted.add(floorSize);
		}
		Collections.sort(listOfAvailableFloorSizeSorted, Collections.reverseOrder());
	}

	void buildSkyScapper() {
		System.out.println("The order of construction is as follows");
		int sortedfloorNumber = 0;
		for (int dayOfConstruction = 0; dayOfConstruction < numberOfDaysOfConstruction; dayOfConstruction++) {
			System.out.println("\nDay: " + (dayOfConstruction + 1));
			int largestAvailableFloorSize = listOfAvailableFloorSizeSorted.get(sortedfloorNumber);
			if (listOfAvailableFloorSize.get(dayOfConstruction) < largestAvailableFloorSize) {
				continue;
			}
			System.out.print(largestAvailableFloorSize + " ");
			
			// The used floors are marked as -1 so as not to repeatedly search them. 
			listOfAvailableFloorSize.set(dayOfConstruction, -1);
			
			// Having two different Arrays, one to keep track of number of the floor
			// Another one to keep track of the size of the floors.
			listOfAvailableFloorSizeSorted.remove(sortedfloorNumber);

			int tempdayOfConstruction = 0;
			
			// Since elements of listOfAvailableFloorSizeSorted is deleted after use its size will be variable 
			// Thus, checking the size before going into loop to access this. 
			while ((tempdayOfConstruction <= dayOfConstruction) && listOfAvailableFloorSizeSorted.size() > 0) {
				if (listOfAvailableFloorSize.get(tempdayOfConstruction) < listOfAvailableFloorSizeSorted.get(sortedfloorNumber)) {
					tempdayOfConstruction++;
					continue;
				} else {
					System.out.print(listOfAvailableFloorSize.get(tempdayOfConstruction) + " ");
					listOfAvailableFloorSize.set(tempdayOfConstruction, -1);
					listOfAvailableFloorSizeSorted.remove(sortedfloorNumber);
					tempdayOfConstruction = 0;
				}
			}
		}

		// If there are any floor blocks remaining on the last day of construction they are place on top of each other. 
		for (int i = 0; i < listOfAvailableFloorSizeSorted.size(); i++) {
			System.out.print(listOfAvailableFloorSizeSorted.get(i) + " ");
		}
	}
}

