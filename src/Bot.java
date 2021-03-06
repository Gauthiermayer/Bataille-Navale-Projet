import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
/**
 * Classe premettant de creer et de gerer un bot (IA) qui est un Joueur
 * 
 * @author Gauthier Mayer
 * @version 1.0
 */
public class Bot extends Joueur{
	
	
	/**
	 * coordonnees du precedent point touche en cas d'attaque de bateau 
	 */
	private int xTouche,yTouche;
	
	/**
	 constructeur du bot
	 * @param nb_bateau nombre de bateau avec lequel on veut jouer 
	 * @param tx tailleX des grilles
	 * @param ty tailleY des grilles
	 * @throws BotException quand le bot ne peut pas �tre cr��
	 */
	public Bot(int nb_bateau,int tx, int ty) throws BotException{
		super(nb_bateau,tx,ty);
		
		this.xTouche = -1;
		this.yTouche = -1;
		try {
			this.placerBateau(new Bateau(0),0,0,'z');
		}
		catch(BotException e) {
			throw e;
		}
			
	}
	
	
	@Override
	public void attaquer(Joueur j2, int x, int y) throws GrilleException {
		
		if (xTouche == -1 || yTouche == -1) {
			x = (int)(Math.random()*9999)%j2.getGrille_bateau().getTailleX();
			y = (int)(Math.random()*9999)%j2.getGrille_bateau().getTailleY();
		}
		else {
			//verifie les 4 cases autour, si toutes touchees, remise a -1
			if (j2.getGrille_bateau().estTouche(xTouche+1, yTouche) 
				&& j2.getGrille_bateau().estTouche(xTouche-1, yTouche)
				&& j2.getGrille_bateau().estTouche(xTouche, yTouche-1)
				&& j2.getGrille_bateau().estTouche(xTouche, yTouche+1)) {
				
				xTouche = -1;
				yTouche = -1;
				x = 0;
				y = 0;
			}
			//attaque les cases autour de la case ou un bateau a ete touche afin de trouver le reste du bateau
			else {
				int[] tab_pos = {-1,0,1};
				
				x = xTouche + tab_pos[(int)((Math.random()*9999)%tab_pos.length)];
				if(x == xTouche) {
					y = yTouche + tab_pos[(int)((Math.random()*9999)%tab_pos.length)];
				}
				else {
					y = yTouche;
				}
				
			}
			
		}
		
		
		if (j2.getGrille_bateau().estTouche(x, y)) {
			throw new GrilleException("Erreur: Case deja touchee");
		}
		else if (j2.getGrille_bateauTab()[x][y] instanceof CaseBateau) {
			Bateau touche = j2.getGrille_bateauTab()[x][y].getBateau();
			touche.prendreDegat();
			
			//retire de la liste des bateau si coul� 
			if (touche.estCoule()) {
				j2.getListe_bateau().remove(touche);
			}
			
			Collections.sort(j2.getListe_bateau());
			
			j2.setCaseGrilleBateau(new CaseBateauTouche(), x, y);
			this.setCaseGrilleAttaque(new CaseBateauTouche(), x, y);
			xTouche = x;
			yTouche = y;
		}
		else {
			j2.setCaseGrilleBateau(new CaseMerTouchee(), x, y);
			this.setCaseGrilleAttaque(new CaseMerTouchee(), x, y);
		}
		
	}
	
	
	
	@Override
	public void placerBateau(Bateau b0, int x0, int y0, char dir0) throws BotException{
		
		char[] tab_dir = {'h','v'};
		
		for (Bateau b : super.getListe_bateau()) {
			int essais = 0;
			while(true) {
				try {
					
					if (essais > 15) {
						throw new BotException("Erreur : placement bugue");
					}
					else {
						
						char dir = tab_dir[(int)((Math.random()*9999)%tab_dir.length)];				
						int x =  (int)(Math.random()*(super.getGrille_bateau().getTailleX()-1));
						int y = (int)(Math.random()*(super.getGrille_bateau().getTailleY()-1));
						
						super.getGrille_bateau().placerBateau(b, x, y, dir);
						break;
					}
				}
				catch (GrilleException e) {
					essais++;
					continue;
				}
				catch (ArrayIndexOutOfBoundsException e2) {
					essais++;
					continue;
				}
			}
		}	
	}
}
