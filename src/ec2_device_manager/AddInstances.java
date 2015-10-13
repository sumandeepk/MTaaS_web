package ec2_device_manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.Instance;
import com.amazonaws.services.ec2.model.RunInstancesRequest;
import com.amazonaws.services.ec2.model.RunInstancesResult;

import connection.DatabaseConnection;


public class AddInstances {

	static AmazonEC2 ec2;

	public void addInstances(String imageId, String location,
			String resourceType, int volume,int duration, String requestId) throws InterruptedException {

		AWSCredentials credentials = null;
		try {
			credentials = new PropertiesCredentials(
					AddInstances.class
							.getResourceAsStream("AwsCredentials.properties"));
		} catch (IOException e1) {
			System.out.println("Wrong Credentials");
			System.out.println(e1.getMessage());
			System.exit(-1);
		}

		AmazonEC2 ec2 = new AmazonEC2Client(credentials);
		String securityGroup = null;
		String keyName = null;

		if (location.equals("Oregon")) {
			Region usWest2 = Region.getRegion(Regions.US_WEST_2);
			ec2.setRegion(usWest2);
			securityGroup = "default";
			keyName = "Layla-key-pair-oregon";

		}

		if (location.equals("N.California")) {
			Region usWest1 = Region.getRegion(Regions.US_WEST_1);
			ec2.setRegion(usWest1);
			securityGroup = "default";
			keyName = "Layla-key-pair-california";
		}
		if (location.equals("N.Virginia")) {
			Region usEast1 = Region.getRegion(Regions.US_EAST_1);
			ec2.setRegion(usEast1);
			securityGroup = "group274";
			keyName = "New_Key11";
		}

		ArrayList<String> securityGroups = new ArrayList<String>();
		securityGroups.add(securityGroup);

		System.out.println("#5 Create an Instance");

		int minInstanceCount = 1;
		int maxInstanceCount = 1;
		RunInstancesRequest rir = new RunInstancesRequest(imageId,
				minInstanceCount, maxInstanceCount);

		rir.setInstanceType(resourceType);
		rir.setKeyName(keyName);

		rir.setSecurityGroups(securityGroups);
		RunInstancesResult result = ec2.runInstances(rir);

		System.out.println("waiting");
		Thread.currentThread();
		Thread.sleep(50000);
		System.out.println("OK");

		List<Instance> resultInstance = result.getReservation().getInstances();

		String createdInstanceId = null;
		for (Instance ins : resultInstance) {

			createdInstanceId = ins.getInstanceId();
			System.out.println("New instance has been created: "
					+ ins.getInstanceId());
			
			 DatabaseConnection db = new DatabaseConnection();
				db.addInstance(createdInstanceId, resourceType, volume, duration,imageId,location);;
                db.updateCloudAvailability(imageId);
//			AddVolume v = new AddVolume();
//			v.addVolume(volume, createdInstanceId, location);
			

		}

		

	}

//	public static void main(String args[]) throws InterruptedException {
//
//		String imageId = "ami-aeb532c6";
//		String location = "oregon";
//		String resourceType = "t2.micro";
//		int volume = 2;
//
//		addInstances(imageId, location, resourceType,
//				volume,1,"1");
//		
//	}
}