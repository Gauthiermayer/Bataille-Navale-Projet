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
		
		Joueur bot;
		while(true) {
			try {
				bot = new Bot(nb_b,x,y);
				break;
			}
			catch(BotException e) {
				continue;
			}
		}
		
		
		Joueur j1 = new VraiJoueur(nb_b, x, y);
		
		System.out.println("-----------------");
		
		System.out.println("Joueur place ses bateaux");
		for (Bateau b : j1.getListe_bateau()) {
			while(true) {
				try {
					j1.placerBateau(b, sc.nextInt(), sc.nextInt(), 'h');
					System.out.println(j1.getGrille_bateau());
					break;
				}
				catch(GrilleException e){
					System.out.println("Réassayez");
					continue;
				}
				catch(ArrayIndexOutOfBoundsException e2) {
					System.out.println("Réassayez");
					continue;
				} catch (Exception e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
			}
		}
		

		
		System.out.println("Vos Bateaux : ");
		System.out.println(j1.getGrille_bateau());
		System.out.println("Grille de l'autre joueur :");
		System.out.println(j1.getGrille_attaque());
		
		int i = 1;
		while(!j1.aPerdu() && !bot.aPerdu()) {
			
			if (i%2 == 1) {
				System.out.println("Attaquer : ");
				while(true) {
					try {
						j1.attaquer(bot, sc.nextInt(), sc.nextInt());
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
					} catch (Exception e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					}
				}
				
			}
			
			else {
				System.out.println("Le bot attaque...");
				while(true) {
					try {
						bot.attaquer(j1, 0, 0);
						break;
					}
					catch(IndexOutOfBoundsException e) {
						System.out.println(e);
						continue;					
					}
					catch (GrilleException e2) {
						System.out.println(e2);
						continue;	
					} catch (Exception e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					}
				}
				
				
				System.out.println("Vos Bateaux : ");
				System.out.println(j1.getGrille_bateau());
				System.out.println("Grille de l'autre joueur :");
				System.out.println(j1.getGrille_attaque());
			}
			i++;
			
		}
		System.out.println("fin");
				
	}

}
