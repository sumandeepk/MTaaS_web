package ec2_device_manager;

import java.io.IOException;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.AttachVolumeRequest;
import com.amazonaws.services.ec2.model.CreateVolumeRequest;
import com.amazonaws.services.ec2.model.CreateVolumeResult;

public class AddVolume {
   public void addVolume(int volume, String instanceId, String location){
	   
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
	   
	   CreateVolumeRequest newVolumeRequest = new CreateVolumeRequest();
		newVolumeRequest.setSize(volume); // 1.0GB
		if (location.equals("Oregon")) {
			newVolumeRequest.setAvailabilityZone("us-west-2b");
		}

		if (location.equals("N.California")) {
			newVolumeRequest.setAvailabilityZone("us-west-1b");
		}
		if (location.equals("N.Virginia")) {
			newVolumeRequest.setAvailabilityZone("us-east-1e");
		}

		

		CreateVolumeResult volumeResult = ec2
				.createVolume(newVolumeRequest);

		System.out.println("waiting");
		Thread.currentThread();
		try {
			Thread.sleep(50000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("OK");

		AttachVolumeRequest attachRequest = new AttachVolumeRequest()
				.withInstanceId(instanceId)
				.withVolumeId(volumeResult.getVolume().getVolumeId())
				.withDevice("/dev/sda2");

		ec2.attachVolume(attachRequest);

		System.out
				.println("EBS volume has been attached and the volume ID is: "
						+ volumeResult.getVolume().getVolumeId());
   }
}
