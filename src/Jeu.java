import java.util.*;

public class Jeu {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Avec combien de bateaux voulez vous jouer ?");
		int nb_b = sc.nextInt();
		
		System.out.println("Taille X de la grille : ");
		int x = sc.nextInt();
		
		System.out.println("Taille Y de la grille : ");
		int y = sc.nextInt();
				
		
		
		Joueur j1 = new Joueur(nb_b, x, y);
		
		System.out.println("-----------------");
		
		System.out.println("Joueur 1 place ses bateaux");
		for (Bateau b : j1.getListe_bateau()) {
			while(true) {
				try {
					j1.placerBateau(b, sc.nextInt(), sc.nextInt(), 'h');
					System.out.println(j1.getGrille_bateau());
					break;
				}
				catch(GrilleException e){
					System.out.println(e);
					System.out.println("Réassayez");
					continue;
				}
				catch(ArrayIndexOutOfBoundsException e2) {
					System.out.println(e2);
					System.out.println("Réassayez");
					continue;
				}
			}
		}
		
		while(!j1.aPerdu()) {
			System.out.println("Attaquer : ");
			while(true) {
				try {
					j1.attaquer(j1, sc.nextInt(), sc.nextInt());
					break;
				}
				catch(IndexOutOfBoundsException e) {
					System.out.println(e);
					System.out.println("Réassayez");
					continue;					
				}
				catch (GrilleException e2) {
					System.out.println(e2);
					System.out.println("Réassayez");
					continue;	
				}
			}
			
			
			System.out.println("Vos Bateaux : ");
			System.out.println(j1.getGrille_bateau());
			System.out.println("Grille de l'autre joueur :");
			System.out.println(j1.getGrille_attaque());
		}
		System.out.println("fin");
				
	}

}
