package tpfinalMDC;

public class Jeton {
	String s;
	public Jeton(String s) {
		this.s=s;
	}
	public boolean compare(String s) {
		
		return this.s.equals(s);
	}

	public void affiche() {
		System.out.print(this.s);
	}
	public String getval() {
		return this.s;
	}
	public boolean estnegation() {
		return this.s.startsWith("¬");
	}
	public Variable oppose() {
		if(estnegation()) {
			String w=this.s.substring(1);
			return new Variable(w);
		}else {
			String w="¬".concat(this.s);
			return new Variable(w);
		}
		
	}
public Variable copie() {
	return new Variable(this.s);
}
}
