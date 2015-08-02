package ba.bitcamp.homework.task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		
		ServerSocket server = null;
		try {
			server = new ServerSocket(35721);
			while (true) {
				
				Socket client = server.accept();
				
				BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
				
				File file = new File(reader.readLine());
				
				if (file.exists()) {
					writer.write("1");
				} else {
					writer.write("0");
				}
				writer.newLine();
				writer.flush();
				writer.close();
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
