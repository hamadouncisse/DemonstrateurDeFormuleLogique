package tpfinalMDC;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         String p="m";
         char s='m';
         p=p+s;
         String w="¬k";
         if(w.startsWith("¬")) {
        	 System.out.println("Ichrak");
         }else {
        	 System.out.println("Courage");
         }
         w=w.substring(1);
         if(w.startsWith("¬")) {
        	 System.out.println("Ichrak");
         }else {
        	 System.out.println("Courage");
         }
         System.out.println(w);
     Clause clause=new Clause("1");
       clause.ajouter(new Variable("a"));
       clause.ajouter(new Variable("b"));
       Clause clause1=new Clause("2");
       clause1.ajouter(new Variable("¬a"));
       clause1.ajouter(new Variable("b"));
       Clause clause2=new Clause("3");
       clause2.ajouter(new Variable("¬b"));
       clause1.affiche();
       System.out.println("\n");
       clause1.enlever(clause1.position(new Variable("¬a")));
       clause1.affiche();
         ArrayList<String> t=new ArrayList<String>();
         System.out.println("kflf"+t.size());
	}

}
