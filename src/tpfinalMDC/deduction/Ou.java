package tpfinalMDC.deduction;

public class Ou  extends OperateurB  {

	public Ou(String s) {
		super(s,2);
		// TODO Auto-generated constructor stub
	}
	  public JetonDeduction copy() {
	    	return new Ou(this.getval());
	    }
}
