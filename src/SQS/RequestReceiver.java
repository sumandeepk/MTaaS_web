package SQS;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;









import loadBalancer.AntColonyOptimizer;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.util.json.JSONObject;

import connection.Cloud;
import connection.DatabaseConnection;
import connection.Instance;
import connection.Request;

public class RequestReceiver {
	
	public void recieveRequests() throws Exception{
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
		
	    // Receive messages
        System.out.println("Receiving messages from MyQueue.\n");
        ArrayList<Request> requests = new ArrayList<Request>();
        
        String myQueueUrl ="https://sqs.us-west-2.amazonaws.com/674522844616/MyQueue";
        ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(myQueueUrl).withMaxNumberOfMessages(10).withWaitTimeSeconds(20);;
        List<Message> messages = sqs.receiveMessage(receiveMessageRequest).getMessages();
        System.out.println("size:::::::"+messages.size());
        
        for (Message message : messages) {
            System.out.println("  Message");
            System.out.println("    MessageId:     " + message.getMessageId());
            System.out.println("    ReceiptHandle: " + message.getReceiptHandle());
            System.out.println("    MD5OfBody:     " + message.getMD5OfBody());
            System.out.println("    Body:          " + message.getBody());
            
            String messageBody=message.getBody();
            JSONObject json=new JSONObject(messageBody);
            
           
//            String jsonMessage=json.getString("Message").replace("\\\"","\"");
//            json=new JSONObject(jsonMessage);
            String resourceName=json.getString("resource_name");
            String resourceType = json.getString("resource_type");
            int volume = json.getInt("volume");
            int duration = json.getInt("duration");
            int userId = json.getInt("userId");
            
            
            Request r = new Request(message.getMessageId(),resourceName,resourceType,volume,duration,userId,false);
            requests.add(r);
            System.out.println("resource:   "+ resourceName);
                
            
            for (Entry<String, String> entry : message.getAttributes().entrySet()) {
                System.out.println("  Attribute");
                System.out.println("    Name:  " + entry.getKey());
                System.out.println("    Value: " + entry.getValue());
            }
        }
        Request[] r = requests.toArray(new Request[requests.size()]);
        DatabaseConnection db = new DatabaseConnection();
		db.addRequest(r);
        
        for(int i=0 ;i<r.length;i++){
        	AntColonyOptimizer o = new AntColonyOptimizer();
        	o.antColonyRequestProcesor(r[i]);
        }
	}
	
	public static void main(String[] args) throws Exception{
		
	}

}
