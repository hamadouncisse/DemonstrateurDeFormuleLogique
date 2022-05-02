package tpfinalMDC.deduction;

import java.util.ArrayList;

import tpfinalMDC.Variable;

public class Expression1 extends JetonDeduction {
 ArrayList<JetonDeduction> tab;
 Operateur o;
	public Expression1(String s) {
		super(s);
		tab= new ArrayList<JetonDeduction>();
		// TODO Auto-generated constructor stub
	}
 public void maj(String s) {
	String t= this.getval().concat(s);
	 this.setval(t);
 }
 public void ajouter(JetonDeduction j) {
	 if(j instanceof Operateur) {
		  o=(Operateur) j.copy();
	 }
	 maj(j.getval());
	 this.tab.add(0,j);
 }
 public Operateur getOperateur() {
	 return this.o;
 }
 public void ajouter1(JetonDeduction j) {
	 if(j instanceof Operateur) {
		  o=(Operateur) j.copy();
	 }
	 maj(j.getval());
	 this.tab.add(j);
 }
 public void affiche() {
	 for(int i=0;i<this.tab.size();i++) {
		 this.tab.get(i).affiche();
	 }
 }
 public String getval() {
	 String s="";
	 for(int i=0;i<this.tab.size();i++) {
		 s=s+this.tab.get(i).getval();
	 } 
	 return s;
 }
 public boolean estnegation(String s) {
		return s.startsWith("¬");
	}
	public String oppose() {
		String s;
		s=this.getval();
		if(estnegation(s)) {
			String w=s.substring(1);
			return w;
		}else {
			String w="¬".concat(this.s);
			return w;
		}
		
	}
 public JetonDeduction copy() {
	 Expression1 e=new Expression1("");
	 for(int i=0;i<this.tab.size();i++) {
		 e.ajouter1(this.tab.get(i).copy());
	 }
 	return e ;
 }
 public boolean isDecomposable() {
	 boolean tr=false;
	 for(int i=0;i<this.tab.size() && tr==false;i++) {
		 if(tab.get(i) instanceof Operateur) {
			 tr=true;
		 }
	 }
	 return tr;
 }
 public void eliParenthese() {
	 if(this.tab.get(0) instanceof ParentheseO){
		 System.out.println("kfkkjfddj");
			  this.tab.remove(0);
			  this.tab.remove(this.tab.size()-1);	  
	 }
 }
 public ArrayList<JetonDeduction> decompose() {
	 this.eliParenthese();
		 ArrayList<JetonDeduction> t=new ArrayList<JetonDeduction>();
		 for(int i=0;i<this.tab.size();i++) {
			 if(!(this.tab.get(i) instanceof Operateur)) {
				 if(this.tab.get(i) instanceof Expression1) {
			 t.add(this.tab.get(i).copy());
				 }else {
					 Expression1 e=new Expression1("");
					 e.ajouter1(this.tab.get(i).copy());
					 t.add(e);
				 }
				 
				 }
		 }
		 return t;
	 	
 }//fin de decompose
 
 
 
}//fin de l'expression1
