import java.util.*;

public class Lanceur {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Avec combien de bateaux voulez vous jouer ?");
		int nb_b = sc.nextInt();
		
		System.out.println("Taille X de la grille : ");
		int x = sc.nextInt();
		
		System.out.println("Taille Y de la grille : ");
		int y = sc.nextInt();
		
		Jeu j = new Jeu(nb_b, x, y);
		j.jouer();
		

	}

}
