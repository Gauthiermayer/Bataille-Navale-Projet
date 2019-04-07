import java.util.*;
/**
 * Classe principale contenant un main permettant de lancer le jeu
 * @author Gauthier Mayer
 *
 */
public class Lanceur {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Jeu j;
		String c;
		System.out.println("Nouvelle partie (n) ou charger (l)");
		
		do {
			c = sc.nextLine();
		}while(!c.equals("n") & !c.equals("l"));
		
		
		if (c.equals("n")) {
			while (true) {
				try {
					System.out.println("Avec combien de bateaux voulez vous jouer ?");
					int nb_b = sc.nextInt();
					
					System.out.println("Taille X de la grille : ");
					int x = sc.nextInt();
					
					System.out.println("Taille Y de la grille : ");
					int y = sc.nextInt();
					
					j = new Jeu(nb_b, x, y);
					break;
				}
				catch (Exception e) {
					System.out.println("Erreur : taille minimale 5x5");
					continue;
				}
				
			}
			
			j.initialiser();
		}
		else {
			j = Jeu.charger();
			if (j == null) {
				try {
					j = new Jeu(2, 5, 5);
				} catch (Exception e) {
				}
			}
		}
		
		j.jouer();
		

	}

}
