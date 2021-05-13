package quiz;
import java.util.ArrayList;

public class ResourceCentre {

	public static void main(String[] args) {

		ArrayList<Camcorder> camcorderList = new ArrayList<Camcorder>();
		ArrayList<Chromebook> chromebookList = new ArrayList<Chromebook>();

		camcorderList.add(new Camcorder("CC001", "Sony HDR-CX405", 35));
		camcorderList.add(new Camcorder("CC002", "Panasonic HC-MDH2", 10));
		chromebookList.add(new Chromebook("CB001", "ASUS Chromebook ", "Win 10"));
		chromebookList.add(new Chromebook("CB002", "HP Chromebook", "Win 10"));

		int option = 0;

		while (option != 5) {

			ResourceCentre.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// View all items
				ResourceCentre.viewAllCamcorder(camcorderList);
				ResourceCentre.viewAllChromebook(chromebookList);

			} else if (option == 2) {

				// Add item
				ResourceCentre.itemTypeMenu();
				int itemType = Helper.readInt("Enter option to select item type > ");

				if (itemType == 1) {

					// Add camcorder
					ResourceCentre.addCamcorder(camcorderList);

				} else if (itemType == 2) {

					// Add Chromebook
					ResourceCentre.addChromebook(chromebookList);

				} else {
					System.out.println("Invalid type");
				}

			} else if (option == 3) {

				// Loan item
				ResourceCentre.setHeader("LOAN");
				ResourceCentre.itemTypeMenu();

				int itemType = Helper.readInt("Enter option to select item type > ");

				if (itemType == 1) {

					// Loan camcorder
					ResourceCentre.loanCamcorder(camcorderList);

				} else if (itemType == 2) {

					// Loan Chromebook
					ResourceCentre.loanChromebook(chromebookList);

				} else {
					System.out.println("Invalid type");
				}

			} else if (option == 4) {

				// Return item
				ResourceCentre.setHeader("RETURN");
				ResourceCentre.itemTypeMenu();

				int itemType = Helper.readInt("Enter option to select item type > ");

				if (itemType == 1) {

					// Return camcorder
					ResourceCentre.returnCamcorder(camcorderList);

				} else if (itemType == 2) {

					// Return Chromebook
					ResourceCentre.returnChromebook(chromebookList);

				} else {
					System.out.println("Invalid type");
				}

			} else if (option == 5) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}

		}

	}

	public static void menu() {
		ResourceCentre.setHeader("RESOURCE CENTRE APP");
		System.out.println("1. Display Inventory");
		System.out.println("2. Add item");
		System.out.println("3. Loan item");
		System.out.println("4. Return item");
		System.out.println("5. Quit");
		Helper.line(80, "-");

	}
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	public static void itemTypeMenu() {
		ResourceCentre.setHeader("ITEM TYPES");
		System.out.println("1. Camcorder");
		System.out.println("2. Chromebook");
	}

	public static String showAvailability(boolean isAvailable) {
		String avail;

		if (isAvailable == true) {
			avail = "Yes";
		} else {
			avail = "No";
		}
		return avail;
	}
	
	//Write the code for the viewAllCamcorder method. 
	//Note: This method is a public static method that takes in an ArrayList of Camcorder objects.
	public static void viewAllCamcorder(ArrayList<Camcorder> camcorderList) {
		Helper.line(80, "-");
		System.out.println("CAMCORDER LIST");
		Helper.line(80, "-");
		String a = String.format("%-20s %-20s %-20s %-20s %-20s ", "ASSET TAG", "DESCRIPTION", "OPTICAL ZOOM", "AVAILABLE", "DUE DATE");
		for(int i = 0; i < camcorderList.size(); i++) {
			if(camcorderList.get(i) != null) {
				a += String.format("\n%-20s %-20s %-20d %-20b %-20s ", camcorderList.get(i).getAssetTag(), camcorderList.get(i).getDescription(), camcorderList.get(i).getOpticalZoom(), camcorderList.get(i).getIsAvailable(), camcorderList.get(i).getDueDate());
			}
		}
		System.out.println(a);
	}
	
	//Write the code for the viewAllChromebook method. 
	//Note: This method is a public static method that takes in an ArrayList of Chromebook objects.	
	public static void viewAllChromebook(ArrayList<Chromebook> chromebookList) {
		Helper.line(80, "-");
		System.out.println("CHROMEBOOK LIST");
		Helper.line(80, "-");
		String a = String.format("%-20s %-20s %-20s %-20s %-20s ", "ASSET TAG", "DESCRIPTION", "OS", "AVAILABLE" ,"DUE DATE");
		for(int i = 0; i < chromebookList.size(); i++) {
			if(chromebookList.get(i) != null) {
				a += String.format("\n%-20s %-20s %-20s %-20b %-20s ", chromebookList.get(i).getAssetTag(), chromebookList.get(i).getDescription(), chromebookList.get(i).getOs(), chromebookList.get(i).getIsAvailable(), chromebookList.get(i).getDueDate());
			}
		}
		System.out.println(a);
	}

	//Write the code for the addCamcorder method. 
	//Note: This method is a public static method that takes in an ArrayList of Camcorder objects.
	public static void addCamcorder(ArrayList<Camcorder> camcorderList) {
        String assetTag = Helper.readString("Enter asset tag > ");
        String description = Helper.readString("Enter description > ");
        int opticalZoom = Helper.readInt("Enter optical zoom > ");

 

        Camcorder newcamcorder = new Camcorder(assetTag, description, opticalZoom);

 

        for (int i = 0; i < camcorderList.size(); i++) {
            Camcorder c = camcorderList.get(i);
            if (c.getAssetTag().equals(assetTag) && c.getDescription().equals(description)
                    && c.getOpticalZoom() == opticalZoom) {
                System.out.println("Camcorder not added");
                break;
            } else {
                camcorderList.add(newcamcorder);
                System.out.println("Camcorder added");
                break;
            }
        }
    }

	//Write the code for the addChromebook method. 
	//Note: This method is a public static method that takes in an ArrayList of Chromebook objects.	
	 public static void addChromebook(ArrayList<Chromebook> chromebookList) {
	        String assetTag = Helper.readString("Enter asset tag > ");
	        String description = Helper.readString("Enter description > ");
	        String operatingSystem = Helper.readString("Enter operating system > ");
	        
	        Chromebook newchromebook = new Chromebook(assetTag, description, operatingSystem);

	 

	        for (int i = 0; i < chromebookList.size(); i++) {
	            Chromebook c = chromebookList.get(i);
	            if (c.getAssetTag().equals(assetTag) && c.getDescription().equals(description)
	                    && c.getOs().equals(operatingSystem)) {
	                System.out.println("Chromebook not added");
	                break;
	            } else {
	                chromebookList.add(newchromebook);
	                System.out.println("Chromebook added");
	                break;
	            }
	        }
	    }
	
	//Write the code for the loanCamcorder method. 
	//Note: This method is a public static method that takes in an ArrayList of Camcorder objects.
	public static void loanCamcorder(ArrayList<Camcorder> camcorderList) {
		Helper.line(80, "-");
		System.out.println("CAMCORDER LIST");
		Helper.line(80, "-");
		String a = String.format("%-20s %-20s %-20s %-20s %-20s ", "ASSET TAG", "DESCRIPTION", "OPTICAL ZOOM", "AVAILABLE", "DUE DATE");
//		camcorderList.get(1).setIsAvailable(true);
		for(int i = 0; i < camcorderList.size(); i++) {
			if(camcorderList.get(i) != null) {
				a += String.format("\n%-20s %-20s %-20d %-20b %-20s ", camcorderList.get(i).getAssetTag(), camcorderList.get(i).getDescription(), camcorderList.get(i).getOpticalZoom(), camcorderList.get(i).getIsAvailable(), camcorderList.get(i).getDueDate());
			}
		}
		System.out.println(a);
		String userTag = Helper.readString("Enter asset tag > ");
		boolean isChecker = true;
		int b = 0;
		for(int i = 0; i < camcorderList.size(); i++) {
			if(camcorderList.get(i).getAssetTag().equals(userTag) && camcorderList.get(i).getIsAvailable() == true) {
				isChecker = true;
				b = i;
				break;
			}
			else {
				isChecker = false;
			}
		}
		if(isChecker == true) {
			String userDue = Helper.readString("Enter due date > ");
			camcorderList.get(b).setDueDate(userDue);
			System.out.println("Camcorder " + camcorderList.get(b).getAssetTag() + " loaned out");
			camcorderList.get(b).setIsAvailable(false);
		}
		else {
			System.out.println("Invalid Asset Tag");
		}
	}
	
	//Write the code for the loanChromebook method. 
	//Note: This method is a public static method that takes in an ArrayList of Chromebook objects.	
	public static void loanChromebook(ArrayList<Chromebook> chromebookList) {
		Helper.line(80, "-");
		System.out.println("CHROMEBOOK LIST");
		Helper.line(80, "-");
		String a = String.format("%-20s %-20s %-20s %-20s %-20s ", "ASSET TAG", "DESCRIPTION", "OS", "AVAILABLE" ,"DUE DATE");
//		chromebookList.get(1).setIsAvailable(true);
		for(int i = 0; i < chromebookList.size(); i++) {
			if(chromebookList.get(i) != null) {
				a += String.format("\n%-20s %-20s %-20s %-20b %-20s ", chromebookList.get(i).getAssetTag(), chromebookList.get(i).getDescription(), chromebookList.get(i).getOs(), chromebookList.get(i).getIsAvailable(), chromebookList.get(i).getDueDate());
			}
		}
		System.out.println(a);
		String userTag = Helper.readString("Enter asset tag > ");
		boolean isChecker = true;
		int b = 0;
		for(int i = 0; i < chromebookList.size(); i++) {
			if(chromebookList.get(i).getAssetTag().equals(userTag) && chromebookList.get(i).getIsAvailable() == true) {
				isChecker = true;
				b = i;
				break;
			}
			else {
				isChecker = false;
			}
		}
		if(isChecker == true) {
			String userDue = Helper.readString("Enter due date > ");
			chromebookList.get(b).setDueDate(userDue);
			System.out.println("Camcorder " + chromebookList.get(b).getAssetTag() + " loaned out");
			chromebookList.get(b).setIsAvailable(false);
		}
		else {
			System.out.println("Invalid Asset Tag");
		}
	}

	
	  // Write the code for the returnCamcorder method.
    // Note: This method is a public static method that takes in an ArrayList of
    // Camcorder objects.
    public static void returnCamcorder(ArrayList<Camcorder> camcorderList) {
        Helper.line(30, "-");
        System.out.println("CAMCORDER LIST");
        Helper.line(30, "-");
        String output = String.format("%-20s%-20s%-20s%-20s%-20s\n", "ASSET TAG", "DESCRIPTION", "OTICAL ZOOM",
                "AVAILABLE", "DUE DATE");
        for (int i = 0; i < camcorderList.size(); i++) {
            output += String.format("%-20s%-20s%-20d%-20s%-20s\n", camcorderList.get(i).getAssetTag(),
                    camcorderList.get(i).getDescription(), camcorderList.get(i).getOpticalZoom(),
                    ResourceCentre.showAvailability(camcorderList.get(i).getIsAvailable()),
                    camcorderList.get(i).getDueDate());
        }
        System.out.println(output);
        boolean isReturned = false;
        int c = 0;
        String returned = Helper.readString("Enter asset tag > ");
        for (int i = 0; i < camcorderList.size(); i++) {
            if (returned.equals(camcorderList.get(i).getAssetTag()) && camcorderList.get(i).getIsAvailable() == false) {
                isReturned = true;
                c = i;
                break;
            } else {
                isReturned = false;
            }
        }
        if (isReturned == true) {
            System.out.println("Camcorder " + camcorderList.get(c).getAssetTag() + " returned");
            camcorderList.get(c).setIsAvailable(true);
            camcorderList.get(c).setDueDate("");
        } else {
            System.out.println("Invalid asset tag");

 

        }
    }

 

    // Write the code for the returnChromebook method.
    // Note: This method is a public static method that takes in an ArrayList of
    // Chromebook objects.
    public static void returnChromebook(ArrayList<Chromebook> chromebookList) {
        Helper.line(30, "-");
        System.out.println("CHROMEBOOK LIST");
        Helper.line(30, "-");
        String output = String.format("%-20s%-20s%-20s%-20s%-20s\n", "ASSET TAG", "DESCRIPTION", "OPERATING SYSTEM",
                "AVAILABLE", "DUE DATE");
        for (int i = 0; i < chromebookList.size(); i++) {
            output += String.format("%-20s%-20s%-20s%-20s%-20s\n", chromebookList.get(i).getAssetTag(),
                    chromebookList.get(i).getDescription(), chromebookList.get(i).getOs(),
                    ResourceCentre.showAvailability(chromebookList.get(i).getIsAvailable()),
                    chromebookList.get(i).getDueDate());
        }
        System.out.println(output);
        String returned = Helper.readString("Enter asset tag > ");
        boolean isReturned = false;
        int d = 0;
        for (int i = 0; i < chromebookList.size(); i++) {
            if (returned.equals(chromebookList.get(i).getAssetTag())
                    && chromebookList.get(i).getIsAvailable() == false) {
                isReturned = true;
                d = i;
                break;
            } else {
                isReturned = false;
            }
        }
        if (isReturned == true) {
            System.out.println("Chromebook " + chromebookList.get(d).getAssetTag() + " returned");
            chromebookList.get(d).setIsAvailable(true);
            chromebookList.get(d).setDueDate("");
        } else {
            System.out.println("Invalid asset tag");

 

        }
    }
}
	



