/**
 * Classe premettant de creer des bateaux
 * 
 * @author Gauthier Mayer
 * @version 1.0
 */
public class Bateau {
	
	
	/**
	 * taille et vie du bateau
	 */
	private int size,vie;
	
	
	/**
	 * constructeur du bateau
	 * @param s taille du bateau
	 */
	public Bateau(int taille) {
		this.size = taille;
		this.vie = taille;
	}
	
	/**
	 * fonction qui retire un point de vie au bateau quand il est touche
	 */
	public void prendreDegat(){
		this.vie-=1;
	}
	
	/*
	 * fonction qui verifie si le bateau est coule ou non 
	 * @return true si le bateau a 0 pv donc coule 
	 */
	public boolean estCoule() {
		if (this.vie == 0 ) {
			return true;
		}
		else {
			return false;
		}
	}
	/*
	 * @return la taille du bateau
	 */
	public int getSize() {
		return size;
	}
	/*
	 * @return la vie restante du bateau
	 */
	public int getVie() {
		return vie;
	}
		
}
