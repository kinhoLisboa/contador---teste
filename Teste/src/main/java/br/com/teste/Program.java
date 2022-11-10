package br.com.teste;

public class Program {
	
	   public static void main(String[] args){
	        for (int i = 1; i <=100; i++){
	            if (i%3 == 0)
	                System.out.println(i % 5 == 0? "Foobaa" : "Foo");
	            else if (i%5 == 0)
	                System.out.println("baa");
	            else
	                System.out.println(i);
	        }
	    }
	}



