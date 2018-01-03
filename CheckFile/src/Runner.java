import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner {

	public static void main(String[] args) throws ClassNotFoundException{

		ArrayList<users> list = new ArrayList<users>();
		ArrayList<users> list2 = new ArrayList<users>();
		
		File inputfile = new File("Details.txt");
		list.add(new users("tom", "one"));
		list.add(new users("Dave", "two"));
		list.add(new users("John", "Three"));

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
		

		///deeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee

//		FileInputStream fi = new FileInputStream(inputfile);
//		ObjectInputStream input = new ObjectInputStream(fi);
//
//		try {
//			while(true) {
//
//				users u = (users)input.readObject();
//				list2.add(u);
//
//			}//eow8
//
//		}catch (EOFException e) {
//		}

		//		try {
		//			while(true) {
		//				
		//				
		//				users u = (users)ius.readObject();
		//				list2.add(u);
		//				
		//				
		//			}
		//		} catch (ClassNotFoundException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}
		//		
//		for(users u:list2){
//			System.out.println(u.getNmae() + " " + u.getSome2());
//
//		}

	}

}
