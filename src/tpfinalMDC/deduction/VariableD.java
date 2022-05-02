package tpfinalMDC.deduction;

public class VariableD extends JetonDeduction{

	public VariableD(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	  public JetonDeduction copy() {
	    	return new VariableD(this.getval());
	    }
	

}
