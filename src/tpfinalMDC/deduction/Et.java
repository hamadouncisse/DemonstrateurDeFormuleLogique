package tpfinalMDC.deduction;

public class Et  extends OperateurB {

	public Et(String s) {
		super(s,3);
		// TODO Auto-generated constructor stub
	}
	  public JetonDeduction copy() {
	    	return new Et(this.getval());
	    }
}
