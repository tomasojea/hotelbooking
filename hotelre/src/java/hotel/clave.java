 
package hotel;

import java.util.Random;


public class clave {
    
    
//     public static void main(String[] args) {
//     clave example = new clave();
//    
//     System.out.println(example.getAlphaNumeric(6));
//    
//    
//  }

  public String getAlphaNumeric(int len) {
    char[] ch = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
        'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
        'Y', 'Z' };
    
    char[] c=new char[len];
    Random random=new Random();
    for (int i = 0; i < len; i++) {
      c[i]=ch[random.nextInt(ch.length)];
    }
    
    return new String(c);
  }
}
