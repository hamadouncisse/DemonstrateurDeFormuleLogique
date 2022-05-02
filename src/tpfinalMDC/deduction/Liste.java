package tpfinalMDC.deduction;



public class Liste implements Pile, File{
	private JetonDeduction info;
	private Liste suivant;
	public boolean vide(){
		if (this.suivant==null){
			return true;
		}
		else return false;
	}
	public int longueur(){
		if (this.suivant==null){
			return 0;
		}
		else return 1+this.suivant.longueur();
		}
    public void ajouterD(JetonDeduction x){
    	Liste e=new Liste();
    	e.info=x;
    	e.suivant=this.suivant;
    	this.suivant=e;
    }
    public JetonDeduction suppD() throws ErreurListeVide{
    	if(this.suivant!=null){
    		Liste e=this.suivant;
    		this.suivant=e.suivant;
    		e.suivant=null;
    		return e.info;
    	}
    	else {throw new  ErreurListeVide("La Liste est vide ");}
    }
    public JetonDeduction suppF() throws ErreurListeVide {
    	if(this.suivant==null){
    		throw new ErreurListeVide("La Liste est Vide");
    	}
    	else{
    		if (this.suivant.suivant==null){
    			JetonDeduction e=this.suivant.info;
    			this.suivant=null;
    			return e;
    		}
    		else return this.suivant.suppF();
    	}
    }
	public void enfiler(JetonDeduction x) {
		this.ajouterD(x);
	}

	public JetonDeduction defiler() throws ErreurFileVide {
		try{ 
			return this.suppF();
		}catch(ErreurListeVide e){
			throw new ErreurFileVide("La File est vide");}
	}
	

	public void empiler(JetonDeduction x) {
		this.ajouterD(x);	
	}

	public JetonDeduction depiler() throws ErreurPileVide {
		try{ 
			return this.suppD();
		}catch(ErreurListeVide e){
			throw new ErreurPileVide("La Pile est vide");}
	}
	public JetonDeduction sommet() throws ErreurPileVide {
		if (this.suivant!=null){
			return this.suivant.info;
		}
		else throw new ErreurPileVide("La pile est Vide");
	}
	public void aff() throws ErreurFileVide {
		Liste p=this;
		Liste sav=new Liste();
		while (!p.vide()){
			JetonDeduction t=p.defiler();
			t.affiche();
			sav.enfiler(t);
			
		}
	while(!sav.vide()){
		JetonDeduction t=sav.defiler();
		this.enfiler(t);
	}
	}

}
