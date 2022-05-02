package tpfinalMDC.deduction;

public class JetonDeduction {
	String s;
	public JetonDeduction(String s) {
		this.s=s;
	}
	public boolean compare(String s) {
		
		return this.s.equals(s);
	}
    public void setval(String s) {
    	this.s=s;
    }
	public void affiche() {
		System.out.print(this.s);
	}
	public String getval() {
		return this.s;
	}
    public JetonDeduction copy() {
    	return null;
    }
}
