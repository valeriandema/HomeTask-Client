import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.nio.channels.SocketChannel;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SealedObject;
import javax.crypto.spec.SecretKeySpec;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.SocketChannel;


public class MainClass {

	private static final byte[] key = "MyDifficult_pass".getBytes();
	private static final String transformation = "AES";
	public static void main(String[] args) throws UnknownHostException {
		
		String str = "SELECT Product.Name, Product.Price FROM Product WHERE Product.Price > 500";
		String key1 = "MyDifficult_pass";
		String login = "valera"; 
		String pass = "127681"; 
		String database = "HomeWorkDBShop";
		String ip = "127.0.0.1";
		String str1 = str + "=" + key1 + " " + login + " " + pass + " " + database + " " + ip;
		Socket socket;
		SocketChannel sc;
		SocketAddress address = new InetSocketAddress("127.0.0.1", 1437);
		
		boolean scan = true;
		
		while (scan) {
			
			try {
				//socket = new Socket("127.0.0.1", 1437);
				sc = SocketChannel.open(address);
				//Encription.encrypt(str1, sc.socket().getOutputStream());
				//sc.writ
				scan = false;
				
			} catch (Exception ex) {
				try {
					System.out.println("Connect failed, waiting and trying again");
		            Thread.sleep(1000);
		        }
		        catch(InterruptedException ie){
		            ie.printStackTrace();
		        }
			}
			
			//String clientMessage = (String)Encription.decrypt(socket.getInputStream());
		
		}
		/*System.out.println("We read");
		
		//String clientMessage = (String)Encription.decrypt(socket.getInputStream());
		byte[] bytes = new byte[16 * 1024];
		InputStream in = socket.getInputStream();
		
		int count;
		while ((count = in.read(bytes)) > 0) {
		    
		}
		
		System.out.println("We write");
		System.out.println(bytes.toString());
		
		in.close();*/
			
		
		
		
	}
}
