package sampleChatter;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class MCSThreadPart extends Thread {

	private MultipleChatServer mcs;
	private Socket socket;

	public MCSThreadPart(MultipleChatServer mcs, Socket socket) {
		this.mcs = mcs;
		this.socket = socket;
	}

	public void run() {

		try {
			Scanner sc=new Scanner(socket.getInputStream());//client'i dinlemek icin
		 while(sc.hasNextLine()) {
			 String gelen=sc.nextLine();//client'dan
			 System.out.println(gelen);//ekrana
			 mcs.mesajYaz(socket,gelen);//diger clientlara
		 }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
