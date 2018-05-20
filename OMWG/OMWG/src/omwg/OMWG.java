
package omwg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Italo
 */
public class OMWG {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader (System.in));
        String s;
        String[] c;
        int T = Integer.parseInt(in.readLine());
        
        for(int i=0; i < T ; i++){
         s = in.readLine();
         c = new String[s.length()];
         c = s.split(" ");
         int a = Integer.parseInt(c[0]), b = Integer.parseInt(c[1]);
         
         System.out.println((2*a*b)-a-b);
        }
        
        
    }
    
}
