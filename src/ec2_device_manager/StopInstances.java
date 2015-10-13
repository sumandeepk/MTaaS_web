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
import com.amazonaws.services.ec2.model.StopInstancesRequest;

import connection.DatabaseConnection;

/*These are the APIs*/
public class StopInstances {

	

	public void stopInstances(String instanceId,String location){

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


		

		System.out.println("Stop Instance");
		System.out.println("#7 Stop the Instance");
		
        List<String> instanceIds = new LinkedList<String>();
        instanceIds.add(instanceId);
        
        //stop
        StopInstancesRequest stopIR = new StopInstancesRequest(instanceIds);
        ec2.stopInstances(stopIR);
        
        
		System.out.println("Instance has stoped");
		DatabaseConnection db = new DatabaseConnection();
		db.updateInstanceStatus(instanceId,"Stopped");


	}
	
//	public static void main(String args[]) {
//
//		stopInstances("i-094d88f4");
//	}
}