package utils;
import java.util.Random;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import org.apache.commons.codec.binary.Hex;

public class Encryption {
    private static final int ITERATIONS = 1000;
    private static final int KEY_LENGTH = 64;


     private byte[] hashPassword(final char[] password, String salt) {
        SecretKeyFactory secretKeyFactory;
        try {
            secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
        
        PBEKeySpec spec = new PBEKeySpec(password, salt.getBytes(), ITERATIONS, KEY_LENGTH);
        SecretKey key = secretKeyFactory.generateSecret(spec);


        return key.getEncoded();
        } 
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
        public String convertStringToHash(String password, String salt) {
            try{
                return Hex.encodeHexString(hashPassword(password.toCharArray(), salt));
            }
            catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        
        }

        public String generateSalt(int numchars) {
            try{
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
            while (sb.length() < numchars) {
                sb.append(Integer.toHexString(r.nextInt()));
            }

            return sb.toString().substring(0, numchars);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        }
       
    
}
