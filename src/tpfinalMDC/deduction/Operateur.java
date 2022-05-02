package tpfinalMDC.deduction;

public class Operateur extends JetonDeduction {
      int priorite;
	public Operateur(String s,int priorite) {
		super(s);
		// TODO Auto-generated constructor stub
	}
   public int priorite() {
	   return this.priorite;
   }
}
