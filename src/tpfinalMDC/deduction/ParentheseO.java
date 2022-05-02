package tpfinalMDC.deduction;

public class ParentheseO  extends JetonDeduction {

	public ParentheseO(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
    public JetonDeduction copy() {
    	return new ParentheseO(this.getval());
    }
}
