package adaqueue;

import java.io.IOException;
import java.util.Scanner;

public class AdaQueue {

    private static class No {

        private int conteudo;
        private No prox;

        public No() {
            setProx(null);
        }

        public int getConteudo() {
            return conteudo;
        }

        public void setConteudo(int conteudo) {
            this.conteudo = conteudo;
        }

        public No getProx() {
            return prox;
        }

        public void setProx(No prox) {
            this.prox = prox;
        }
    }

    static class Lista {

        private int nElementos;
        private No inicio;
        private No fim;

        public Lista() {
            inicio = null;
            fim = null;
            nElementos = 0;
        }

        public boolean vazia() {
            return nElementos == 0;
        }

        public void push_back(int b) { 
            No novoNo = new No();
                novoNo.setConteudo(b);
                novoNo.setProx(null);
            
            if(nElementos == 0){
                inicio = novoNo;
            }else{
                fim.setProx(novoNo);
            }
             
            fim = novoNo;
            this.nElementos++;
        }

        public void toFront(int b) {
            No novoNo = new No();
            novoNo.setConteudo(b);
            novoNo.setProx(inicio);
            
            if(nElementos == 0){
                fim = novoNo;
            }
            inicio = novoNo;
            nElementos++;
        }

        public int back() {
            if (vazia()) {
                return -1; // Erro: Fila vazia 
            }

            int valor = fim.getConteudo();
            No p = fim;
            if (nElementos == 1) { // Fila com 1 elemento 
                fim = null;
                inicio = null;
            } else {
                No aux = inicio;
                for (int i = 2; i <= (nElementos); i++) {
                    aux = aux.getProx();
                }
                fim = aux;
            }
            p = null;

            nElementos--;
            return valor;
        }

        public int front() {
            if (vazia()) {
                return -1; // Erro: Fila vazia 
            }

            int valor = inicio.getConteudo();
            No p = inicio;
            if (nElementos == 1) { // Fila com 1 elemento 
                fim = null;
                inicio = null;
            } else {
                inicio = p.getProx();
            }

            p = null;

            nElementos--;
            return valor;
        }

        public void reverse() {
            No aux = inicio;
            inicio = fim;
            fim = inicio;
        }

    }

    public static void main(String[] args) throws IOException {
        try {
            Lista dados = new Lista();
            Scanner sc = new Scanner(System.in);
            String aux;

            int n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                aux = sc.nextLine();

                if (aux.startsWith("back")) {
                    if (dados.vazia()) {
                        System.out.println("No job for Ada?");
                    } else {
                        System.out.println(dados.back());
                    }
                }
                if (aux.startsWith("front")) {
                    if (dados.vazia()) {
                        System.out.println("No job for Ada?");
                    } else {
                        System.out.println(dados.front());
                    }
                }
                if (aux.startsWith("toFront")) {
                    String c = aux.substring(8);
                    dados.toFront(Integer.parseInt(c));
                }
                if (aux.startsWith("push_back")) {
                    String c = aux.substring(10);
                    dados.toFront(Integer.parseInt(c));
                }
                if (aux.startsWith("reverse")) {
                    dados.reverse();
                }
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }
}
