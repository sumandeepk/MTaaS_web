package ec2_device_manager;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.TerminateInstancesRequest;


import connection.DatabaseConnection;

public class DeleteInstances {

	static AmazonEC2 ec2;

	public void deleteInstances(String instanceId,String location) {

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
		
		if (location.equals("Oregon")) {
			Region usWest2 = Region.getRegion(Regions.US_WEST_2);
			ec2.setRegion(usWest2);
			

		}

		if (location.equals("N.California")) {
			Region usWest1 = Region.getRegion(Regions.US_WEST_1);
			ec2.setRegion(usWest1);
			
		}
		if (location.equals("N.Virginia")) {
			Region usEast1 = Region.getRegion(Regions.US_EAST_1);
			ec2.setRegion(usEast1);
			
		}

		

		List<String> instanceIds = new LinkedList<String>();
		instanceIds.add(instanceId);

		System.out.println("delete Instance");
		TerminateInstancesRequest tir = new TerminateInstancesRequest(
				instanceIds);
		ec2.terminateInstances(tir);
		System.out.println("Instance has been deleted");
		DatabaseConnection db = new DatabaseConnection();
		db.deleteInstance(instanceId);
		
		

	}

	// public static void main(String args[]) {
	//
	// deleteInstances("i-094d88f4");
	// }
}