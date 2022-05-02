package tpfinalMDC.deduction;

public class Implication  extends OperateurB  {

	public Implication(String s) {
		super(s,1);
		// TODO Auto-generated constructor stub
	}
	  public JetonDeduction copy() {
	    	return new Implication(this.getval());
	    }
}
