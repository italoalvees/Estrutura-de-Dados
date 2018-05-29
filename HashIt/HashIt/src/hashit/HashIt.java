package hashit;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
class Main{

    String hash[];
    int hash_length=0;
    
    int h(String key){
        int i, h = 0;
        int n = key.length();
        for(i=0 ; i<n ; i++){
            h+=(((int)key.charAt(i))*(i+1));
        }

        return 19*h;
    }

    int Hash(String key){
        return h(key)%101;
    }

    int find(String key){
        int r = -1;
        for(int i=0;i<101;i++){
            if(hash[i]!=null && hash[i].equals(key)){
                r = i;
                break;
            }
        }
        return r;
    }

    void insert(String key){
        int r = find(key);
        int j , key_hash = Hash(key);
        if(r == -1){
            for(j=0 ; j<20 ; j++){
                
                r = (key_hash+j*(j+23)) % 101;
                if(hash[r] == null){
                    hash[r] = key;
                    hash_length++;
                    break;
                }
            }
        }
    }

    void delete(String key){
        int r = find(key);
        if( r != -1){
            hash[r]=null;
            hash_length--;
        }
    }

    public static void main(String []args) throws IOException{
        new Main().run();
    }

    public void run() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        int n;
        String line, key, op, p[];
        
        while(t-->0){
            hash=new String[101];
            hash_length=0;
            n=Integer.parseInt(br.readLine().trim());
            while(n-->0){
                line=br.readLine().trim();
                p=line.split(":");
                if(p[0].equals("ADD")){
                    insert(p[1]);
                }else{
                    delete(p[1]);
                }
            }
            System.out.println(hash_length);
            for(int i=0;i<101;i++){
                if(hash[i]!=null){
                    System.out.println(i+":"+hash[i]);
                }
            }
        }
    }
}
