package tpfinalMDC.deduction;

public interface Pile {
	public boolean vide();
	public int longueur();
	public void empiler(JetonDeduction x);
	public JetonDeduction depiler() throws ErreurPileVide;
    public JetonDeduction sommet() throws ErreurPileVide;
}
