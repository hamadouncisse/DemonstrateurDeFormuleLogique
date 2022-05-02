package tpfinalMDC.deduction;

public class ParentheseF  extends JetonDeduction{

	public ParentheseF(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	  public JetonDeduction copy() {
	    	return new ParentheseF(this.getval());
	    }
}
