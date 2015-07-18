import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SealedObject;
import javax.crypto.spec.SecretKeySpec;

public class Encription {
	
	private static final byte[] key = "MyDifficult_pass".getBytes();
	private static final String transformation = "AES";
	
	public static void encrypt(Serializable obj, OutputStream os) {
		
		SecretKeySpec sks = new SecretKeySpec(key, transformation);
		Cipher cipher = null;
		try {
			cipher = Cipher.getInstance(transformation);
			cipher.init(Cipher.ENCRYPT_MODE, sks);
			SealedObject so = new SealedObject(obj, cipher);
			ObjectOutputStream oos = new ObjectOutputStream(new CipherOutputStream(os, cipher));
			oos.writeObject(so);
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Object decrypt (InputStream iS) throws IOException {
		ObjectInputStream ois = null;
		try {
			System.out.println("start decrypt client decrypt");
			SecretKeySpec sks = new SecretKeySpec(key, transformation);
			Cipher cipher;
			cipher = Cipher.getInstance(transformation);
			cipher.init(Cipher.DECRYPT_MODE, sks);
			CipherInputStream cin = new CipherInputStream(iS, cipher);
			ois = new ObjectInputStream(cin);
			SealedObject so = (SealedObject) ois.readObject();
			return so.getObject(cipher);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ois.close();
		}
		return null;
	}
}
