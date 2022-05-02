package tpfinalMDC.deduction;

public interface File {
	public boolean vide();
	public int longueur();
    public void enfiler(JetonDeduction x);
	public JetonDeduction defiler() throws ErreurFileVide;
    public void aff() throws ErreurFileVide;

}
