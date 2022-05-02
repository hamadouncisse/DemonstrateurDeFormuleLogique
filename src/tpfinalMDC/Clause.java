package tpfinalMDC;

import java.util.ArrayList;

public class Clause {
	String s;
ArrayList <Variable> element;
public Clause(String s) {
	this.s="C".concat(s);
	this.element=new ArrayList<Variable> ();
}
public void ajouter(Variable v) {
	this.element.add(v);
}
public void enlever(int v) {
	this.element.remove(v);
}
public Variable getVariable(int v) {
	return this.element.get(v);
}
public Clause copie() {
	Clause c=new Clause(this.getNum().substring(1));
	for(int i=0;i<this.element.size();i++) {
		c.ajouter(this.element.get(i).copie());
	}
	return c;
}
public String getNum() {
	return this.s;
}
public boolean existe(Variable e){
	int i=0;boolean tr=false;
	while(i<this.element.size() && tr==false) {
		if(this.element.get(i).compare(e.getval())==true){
			tr=true;
		}
		i++;
	}
	return tr;
}
public int position(Variable e){
	int i=0;boolean tr=false;
	while(i<this.element.size() && tr==false) {
		if(this.element.get(i).compare(e.getval())==true){
			tr=true;
		}else {
		i++;
		}
	}
	return i;
}
public boolean clausevide() {
	return this.element.isEmpty();
}
public int taille() {
	return this.element.size();
}
public void affiche() {
	System.out.print("{ ");
	for(int i=0;i<this.element.size();i++) {
		if(i!=0) {
			System.out.print(" , ");
		}
		this.element.get(i).affiche();
	}
	System.out.print(" } ");
}
public void affichedemonstration() {
	System.out.print(this.s+"= { ");
	for(int i=0;i<this.element.size();i++) {
		if(i!=0) {
			System.out.print(" , ");
		}
		this.element.get(i).affiche();
	}
	System.out.print(" } ");
}
}//fin de la classe clause
