package sampleChatter;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class MultipleChatServer {

	// Surekli yeni client'in gelmesi beklenecek
	// Client baglandiginda bir thread olusturulup o thread icinde client'la
	// konusma yapilacak
	// Client'larin socket bilgileri bir Vector'de tutulacak
	// Client'lardan birisi mesaj yazdiginda ilgili thread
	// icinde islenip Vector'de tutulan diger client'lara bu mesajin
	// gitmesi saglanacak

	private Vector<Socket> clientlar;
	public MultipleChatServer() {
		try {
			ServerSocket ss=new ServerSocket(300);
			System.out.println(InetAddress.getLocalHost()+" hazir..");
			clientlar=new Vector<Socket>();
			while(true){
				Socket socket = ss.accept();//client bekleniyor
				clientlar.add(socket);//socket ilerde kullanilmak uzere Vector'de  saklaniyor
				MCSThreadPart mcs=new MCSThreadPart(this, socket);
				mcs.start();//Thread baslatildi
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void mesajYaz(Socket gonderen, String mesaj){
		//Vector'de tutulan socket'ler (clientlar) taraniyor
		for(int i=0;i<clientlar.size();i++){
			Socket s = clientlar.elementAt(i);
			if(s.equals(gonderen)) continue;//gondericiye mesaj gelmiyor
			//Client'a gondermek icin socket'den PrintStream elde edip
			//mesaj println ile gönderilecek
			try {
				PrintStream pr=new PrintStream(s.getOutputStream());
				pr.println(mesaj);//client'a gönderiliyor
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	public static void main(String[] args) {
		new MultipleChatServer();

	}

}
