package SQS;



import java.io.IOException;








import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.CreateQueueRequest;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.util.json.JSONException;
import com.amazonaws.util.json.JSONObject;

import connection.Request;



public class RequestGenerator {

	public void sendRequest(Request[] requests,String requestType) throws Exception{
		AWSCredentials credentials = null;
		try {
			credentials = new PropertiesCredentials(
					RequestGenerator.class
							.getResourceAsStream("AwsCredentials.properties"));
		} catch (IOException e1) {
			System.out
					.println("Credentials were not properly entered into AwsCredentials.properties.");
			System.out.println(e1.getMessage());
			System.exit(-1);
		}

		AmazonSQS sqs = new AmazonSQSClient(credentials);
		Region usWest2 = Region.getRegion(Regions.US_WEST_2);
		sqs.setRegion(usWest2);

		
		try {

			
			String myQueueUrl = "https://sqs.us-west-2.amazonaws.com/674522844616/MyQueue";

			// Send a message
			
			for(int i=0;i<requests.length;i++){
			System.out.println("Sending a message to MyQueue.\n");
			
			JSONObject obj = new JSONObject();
			
			System.out.println("Resource name"+ requests[i].getOs());
		 	System.out.println("Resource type"+ requests[i].getImageType());
		 	System.out.println("volume"+ requests[i].getVolume());
		 	System.out.println("duration"+ requests[i].getDuration());
			
			obj.put("resource_name",requests[i].getOs());
			obj.put("resource_type",requests[i].getImageType());
			obj.put("volume",requests[i].getVolume());
			obj.put("duration",requests[i].getDuration());
			obj.put("userId",requests[i].getUserId());
			obj.put("security_group","group274");
			obj.put("keyName","New_Key11");
			
			
			sqs.sendMessage(new SendMessageRequest(myQueueUrl,
					obj.toString()));
			}
			
			if(!requestType.equals("staticRequest")){
			System.out.println("waiting");
	        Thread.currentThread().sleep(50000);
	        RequestReceiver r = new RequestReceiver();
	        r.recieveRequests();
			}
		} catch (AmazonClientException ace) {
			System.out
					.println("Caught an AmazonClientException, which means the client encountered "
							+ "a serious internal problem while trying to communicate with SQS, such as not "
							+ "being able to access the network.");
			System.out.println("Error Message: " + ace.getMessage());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
//	public static void main(String[] args) throws Exception{
//		Request r = new Request();
//		sendRequest(r);
//	}

}
