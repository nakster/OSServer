import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class EchoServer {
  public static void main(String[] args) throws Exception {
    ServerSocket m_ServerSocket = new ServerSocket(2004,10);
    int id = 0;

    while (true) {
      Socket clientSocket = m_ServerSocket.accept();
      ClientServiceThread cliThread = new ClientServiceThread(clientSocket, id++);
      cliThread.start();
    }
  }
}

class ClientServiceThread extends Thread {
  Socket clientSocket;
  String message;
  int clientID = -1;
  boolean running = true;
  ObjectOutputStream out;
  ObjectInputStream in;
  ArrayList<users> list = new ArrayList<users>();
  File inputfile = new File("Details.txt");
  

  ClientServiceThread(Socket s, int i) {
    clientSocket = s;
    clientID = i;
  }

  void sendMessage(String msg)
	{
		try{
			out.writeObject(msg);
			out.flush();
			
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
	}
  public void run() {
	  
	//this here loads all the users that are saved to a file to the Arraylist
	try {
		//call the method which loads all the users that are saved to a file to the arraylist
		addToArrayList();
	} catch (ClassNotFoundException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	} catch (IOException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
	//this here loads all the users that are saved to a file to the arraylist
	///////////////////////////////////////////////////////////////////////
	
    System.out.println("Accepted Client : ID - " + clientID + " : Address - "
        + clientSocket.getInetAddress().getHostName());
    try 
    {
    	out = new ObjectOutputStream(clientSocket.getOutputStream());
		out.flush();
		in = new ObjectInputStream(clientSocket.getInputStream());
		System.out.println("Accepted Client : ID - " + clientID + " : Address - "
		        + clientSocket.getInetAddress().getHostName());
		
		
		do{
			try
			{
				sendMessage("Press 1 to Register with the system\nPress 2 to Log-in to the fitness system \nPress 3 to exit");
				message = (String)in.readObject();
					
				if(message.compareToIgnoreCase("1")==0)
				{
					System.out.println("User wishes to Register with the system");
					sendMessage("Please enter a Name");
					String name = (String)in.readObject();	
					sendMessage("success");
					sendMessage("Please enter Address");
					String address = (String)in.readObject();
					sendMessage("success");
					sendMessage("Please enter PPS Number");
					String pps = (String)in.readObject();
					sendMessage("success");
					sendMessage("Please enter Age");
					String age = (String)in.readObject();
					sendMessage("success");
					sendMessage("Please enter Weight");
					String weight = (String)in.readObject();
					sendMessage("success");
					sendMessage("Please enter Height");
					String height = (String)in.readObject();
					sendMessage("success");
					sendMessage("Please enter UserName");
					String username = (String)in.readObject();
					sendMessage("success");
					sendMessage("Please enter Password");
					String password = (String)in.readObject();
					sendMessage("success");
					
					list.add(new users(name, address, pps,age, weight ,height,username, password));
					
					//this adds it to a file 
					FileOutputStream fo;
					try {
						fo = new FileOutputStream(inputfile);
						ObjectOutputStream ous = new ObjectOutputStream(fo);

						for(users u:list){
							ous.writeObject(u);

						}

						ous.close();
						fo.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
//					System.out.println("\n\n"+list);
//					for(users u:list){
//						System.out.println(u.getName());
//						System.out.println(u.getAddress());
//					
//					}						

				}
				//this here logs the user in 
				else if(message.compareToIgnoreCase("2")==0) {
					
					System.out.println("User wishes to Login with the system");
					sendMessage("Please enter a UserName");
					String name = (String)in.readObject();	
						
					for(users u:list){
						System.out.println(u.getUsername() + " " + u.getHeight() + " " + u.getAge());
						if(name.equalsIgnoreCase(u.getUsername())) {
							sendMessage("Success");
						}
					}
					System.out.println("--------done------");			
					
				}	
				
			}
			catch(ClassNotFoundException classnot){
				System.err.println("Data received in unknown format");
			}
			
    	}while(!message.equals("3"));
      
		System.out.println("Ending Client : ID - " + clientID + " : Address - "
		        + clientSocket.getInetAddress().getHostName());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

public void addToArrayList() throws IOException, ClassNotFoundException {
	  
	  FileInputStream fi = new FileInputStream(inputfile);
		ObjectInputStream input = new ObjectInputStream(fi);

		try {
			while(true) {

				users u = (users)input.readObject();
				list.add(u);

			}//eow8

		}catch (EOFException e) {
		}
		input.close();
		fi.close();
		
}

}
