package com.ssafy;

import java.util.ArrayList;

class P{
	
}
class C extends P{
	
}

public class Test2 {
   public static void main(String[] args) {
	   ArrayList<P> list = new ArrayList<>();
	   list.add(new P());
	   list.add(new C());
	   
	   System.out.println( list.get(0) instanceof P);
	   System.out.println( list.get(0) instanceof C);
	   System.out.println("=========================");
	   System.out.println( list.get(1) instanceof P);
	   System.out.println( list.get(1) instanceof C);
   }
}



