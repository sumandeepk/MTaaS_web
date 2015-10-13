package loadBalancer;

import connection.DatabaseConnection;
import connection.Image;
import connection.Request;
import connection.User;
import ec2_device_manager.AddInstances;

public class PSO {

	// Resource Allocation is done by PSO Algorithm
	
	public synchronized void antColonyRequestProcesor(Request request) {

		int cloud1_avilabiltiy = 3;
		int cloud2_avilability = 4;
		int cloud3_availability = 5;

		String location = null;

		Image[] resources = null;

		DatabaseConnection db = new DatabaseConnection();
		User user = db.getUser(1);

		if (cloud1_avilabiltiy > cloud2_avilability
				&& cloud1_avilabiltiy > cloud3_availability) {
			resources = db.getImagesFromCloud1();
			location = "Oregon";
		}

		if (cloud2_avilability > cloud1_avilabiltiy
				&& cloud2_avilability > cloud3_availability) {
			resources = db.getImagesFromCloud2();
			location = "N.Virginia";
		}

		if (cloud3_availability > cloud1_avilabiltiy
				&& cloud3_availability > cloud2_avilability) {
			resources = db.getImagesFromCloud3();
			location = "N.California";
		}

		if (cloud1_avilabiltiy == cloud2_avilability
				&& cloud1_avilabiltiy == cloud3_availability) {
			if (user.getDistancefromCloud1() < user.getDistancefromCloud2()
					&& user.getDistancefromCloud1() < user
							.getDistancefromCloud3()) {

				resources = db.getImagesFromCloud1();
				location = "Oregon";
				System.out.println("Cloud 1");

			}

			if (user.getDistancefromCloud2() < user.getDistancefromCloud1()
					&& user.getDistancefromCloud2() < user
							.getDistancefromCloud3()) {

				resources = db.getImagesFromCloud2();
				location = "N.Virginia";
				System.out.println("Cloud 2");

			}

			if (user.getDistancefromCloud3() < user.getDistancefromCloud2()
					&& user.getDistancefromCloud3() < user
							.getDistancefromCloud1()) {

				resources = db.getImagesFromCloud3();
				location = "N.California";
				System.out.println("Cloud 3");

			}
		}

		if (cloud1_avilabiltiy == cloud2_avilability) {
			if (user.getDistancefromCloud1() < user.getDistancefromCloud2()) {

				resources = db.getImagesFromCloud1();
				location = "Oregon";
				System.out.println("Cloud 1");

			} else {
				resources = db.getImagesFromCloud2();
				location = "N.Virginia";
				System.out.println("Cloud 2");
			}

		}

		if (cloud1_avilabiltiy == cloud3_availability) {
			if (user.getDistancefromCloud1() < user.getDistancefromCloud3()) {

				resources = db.getImagesFromCloud1();
				location = "Oregon";
				System.out.println("Cloud 1");

			} else {
				resources = db.getImagesFromCloud3();
				location = "N.California";
				System.out.println("Cloud 3");
			}

		}

		if (cloud2_avilability == cloud3_availability) {

			if (user.getDistancefromCloud2() < user.getDistancefromCloud3()) {

				resources = db.getImagesFromCloud2();
				location = "N.Virginia";
				System.out.println("Cloud 2");

			} else {
				resources = db.getImagesFromCloud3();
				location = "N.California";
				System.out.println("Cloud 3");
			}

		}

		String selectedImageId = null;

		while ((request.isAllocated() == false)) {

			for (int i = 0; i < resources.length; i++) {
				System.out.println("length:;" + resources.length);
				String resourceImageName = resources[i].getImageName();
				System.out.println("resourceImageName:" + resourceImageName);
				System.out.println("request.getOs():" + request.getOs());

				if (resourceImageName.equals(request.getOs())) {
					selectedImageId = resources[i].getImageId();

					// Set the request allocated to true
					request.setAllocated(true);

				}
				if (request.isAllocated() == true) {
					System.out.println("Request ID: " + request.getRequestId()
							+ " is Allocated");
					break;
				}

			}
			// break;
		}

		AddInstances a = new AddInstances();
		try {
			a.addInstances(selectedImageId, location, request.getImageType(),
					request.getVolume(), request.getDuration(),
					request.getRequestId());
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

		System.out.println("ImageId::::;" + selectedImageId);
	}

	// public static void main(String[] args) throws Exception{
	//
	// Request r = new
	// Request("1","Amazon Linux AMI 2015.03 (HVM)","typet2.micro",1,23,1,false);
	//
	// antColonyRequestProcesor(r);
	// }

}
