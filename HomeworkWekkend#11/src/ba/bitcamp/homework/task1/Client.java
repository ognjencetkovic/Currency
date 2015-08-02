package ba.bitcamp.homework.task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		
		try {
			Socket socket = new Socket("localhost", 35721);
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			String filePath = "C:\\Program Files\\Google\\Chrome";
			
			writer.write(filePath);
			writer.newLine();
			writer.flush();
			
			System.out.println(reader.readLine());
			
			writer.close();
			socket.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
