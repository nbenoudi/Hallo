package Nas.Test_Code;


import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import Decoder.BASE64Decoder;

/**
 *
 * @author Nasser Benoudi 
 */
public class CL_Decryptor {

    private static final String ALGORITHM = "AES";
    private static final byte[] keyValue
            = new byte[]{'N', 'a', 's', 's', 'e', 'r', '_', 'b', 'e', 'n', 'o', 'u', 'd', 'i', '0', '0'};

    public String encrypt(String valueToEnc) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGORITHM);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encValue = c.doFinal(valueToEnc.getBytes());
        String encryptedValue = new Decoder.BASE64Encoder().encode(encValue);
        return encryptedValue;
    }

    public String decrypt(String encryptedValue) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGORITHM);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedValue);
        byte[] decValue = c.doFinal(decordedValue);
        String decryptedValue = new String(decValue);
        return decryptedValue;
    }

    private static Key generateKey() throws Exception {
        Key key = new SecretKeySpec(keyValue, ALGORITHM);
        return key;
    }

    
    public static void main( String[] args ) throws Exception{
    	CL_Decryptor cl_decryptor = new CL_Decryptor();
    String claire ="Guten Morgen";
    System.out.println("Claire Text ist :"+claire);
    String  crypt = cl_decryptor.encrypt(claire);
    System.out.println("crypt Text ist :"+crypt);
    System.out.println("decrypt Text von : \""+crypt+"\" ist : "+cl_decryptor.decrypt(crypt));
    
    }
   
}

