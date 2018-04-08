package onp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ONP {
    static class Pilha{
        private char dados[];
        private int tamMax;
        private int topo;
        
        public Pilha(){
            tamMax = 401;
            dados = new char[tamMax];
            topo = -1;
        }
        
        public char Topo(){
            return dados[topo];
        }
        
        public boolean vazia(){
            if (topo == -1)
                return true;
    	   else 
                return false;
	}
	
        public boolean cheia(){
            if (topo == (tamMax-1))
  		return true;
            else
  		return false;
	}
	
 	public boolean push (char valor) {
            if (cheia()) 
                return false;  // err: pilha cheia 
 		
            topo++;
            dados[topo] = valor; 
            return true;
	 }   

 	public char pop() {          
            if (vazia()) 
 		return (char) -1; // Pilha vazia
 		
            char valor = dados[topo]; 
            topo--; 
            return valor;
 	}
    }

    public static  boolean EOperador (char op)  // verifica se o caractere é operador
  {
    return( op == '(' || op == ')' || op == '+' || 
            op == '-' || op == '*' || op == '/' || op == '^' );
  }
    public static void main(String[] args)throws IOException{
        try{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String[] resp = new String[n]; 
        
       
        for(int i=0; i < n ; i++){
            String exp = in.readLine();
            resp[i] = "";
            int tam = exp.length();
            
            char[] expChar = exp.toCharArray();
            Pilha pilha = new Pilha();
            
            for(int j=0; j < tam ; j++){
                if (!EOperador(expChar[j]) && expChar[j]!= ' ') 
                    resp[i] += expChar[j];
                
                else if(expChar[j] == '('){         
                    pilha.push('(');
                }else if(expChar[j] == ')'){
                    while(pilha.Topo() != '('){
                        resp[i] += pilha.pop();
                    }
                    pilha.pop();
                }else if(expChar[j] == '^'){
                    while(pilha.Topo() == '^'){
                        resp[i] += pilha.pop();
                    }
                    pilha.push(expChar[j]);
                }else if(expChar[j]=='/' || expChar[j]=='*'){
                    while(pilha.Topo()=='/' || pilha.Topo() =='*' || pilha.Topo() =='^'){
                        resp[i] += pilha.pop();
                    }
                    pilha.push(expChar[j]);
                }else if(expChar[j]=='+' || expChar[j]=='-'){
                    while(pilha.Topo()!='('){
                        resp[i] += pilha.pop();
                    }
                    pilha.push(expChar[j]);
                }
            }
        }
        
        for(int i = 0; i < n; i++){
                System.out.println(resp[i]);
        }
        
        }catch(Exception e){
        	System.out.println(e.toString());
        }
    }
}

            
                 
        
             
  
