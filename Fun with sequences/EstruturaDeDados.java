 import java.util.Scanner;


public class EstruturaDeDados {

    public static void main(String[] args) {
       int s1,q1,i,j,n;
        
        Scanner sc1 = new Scanner(System.in); 
        s1 = sc1.nextInt();
        int[] S = new int[s1];

        for(i=0; i < s1; i++){
            S[i] = sc1.nextInt();
        }

        q1 = sc1.nextInt();
        int[] Q = new int[q1];

        for(i=0; i < q1; i++){
            Q[i] = sc1.nextInt();
        }
        
        
        for(i=0; i < s1; i++){
            n=-2;
            for(j=0; j < q1;j++){
                if(S[i] == Q[j]){
                    n = -1;
                }    
            }
            if(n != -1){
            System.out.print(S[i]+" ");
            }
        }
    }
}

