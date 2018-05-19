
package nicebtree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Italo
 */
public class NiceBTree {

   
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader (System.in));
         
        int T = Integer.parseInt(in.readLine());
        
        for(int i=0; i< T ; i++){
            String s = in.readLine();
            
            if(s.equalsIgnoreCase("l")){
                System.out.print("0");
                continue;
            }
            
            int a = 0, b = 0;
            boolean[] t = new boolean[s.length()];
            t[0] = true;
            for(char c : s.toCharArray()){
                if(c == 'n'){
                    a++;
                    t[a] = true;
                }else if(c == 'l'){
                    while(!t[a]){
                        a--;
                    }
                    t[a] = false;
                }
                
                b = Math.max(a, b);
            }
            
            System.out.println(b);
        }
    }
    
}
