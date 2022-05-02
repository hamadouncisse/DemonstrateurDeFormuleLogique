package tpfinalMDC;

import java.util.ArrayList;

public class Expression {
ArrayList<Clause> ensemble;

public Expression() {
	this.ensemble=new ArrayList<Clause>();
}
public Clause getClause(int i) {
	return this.ensemble.get(i);
}
public Expression copie() {
	Expression e=new Expression();
	for(int i=0;i<this.ensemble.size();i++) {
		e.ajouter(this.ensemble.get(i).copie());
	}
	return e;
}
public void ajouter(Clause c) {
	this.ensemble.add(c);
}
public void enlever(int i) {
	this.ensemble.remove(i);
}
public int taille() {
	return this.ensemble.size();
}
public void affiche() {
	System.out.print("{ ");
	for(int i=0;i<this.ensemble.size();i++) {
		if(i!=0) {
			System.out.print(" , ");
		}
		this.ensemble.get(i).affiche();
	}
	System.out.print(" }");
}

}//fin de la classe expression
