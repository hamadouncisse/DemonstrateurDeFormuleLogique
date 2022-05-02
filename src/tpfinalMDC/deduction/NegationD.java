package tpfinalMDC.deduction;

public class NegationD  extends OperateurU{

	public NegationD(String s) {
		super(s,4);
		// TODO Auto-generated constructor stub
	}
	  public JetonDeduction copy() {
	    	return new NegationD(this.getval());
	    }
}
