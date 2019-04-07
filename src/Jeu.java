import java.io.*;
import java.util.*;
/**
 * classe permettant de créer un jeu, de l'initialiser et de le lancer
 * possibilité de sauvegarder et de charger un Jeu
 * @author Gauthier Mayer
 *
 */
public class Jeu implements Serializable{

		
		private Bot bot;
		
		private VraiJoueur j1;
		
		
		/**
		 * methode qui permet d'initialiser un nouveau avec un jouer contre un bot
		 * @param nb_b le nombre de bateau avec lequel on veut jouer 
		 * @param x la taille x de la grille de jeu
		 * @param y la taille y de la grille de jeu
		 * @throws java.lang.Exception quand les paramètres du jeu sont faux
		 */
		public Jeu(int nb_b,int x,int y) throws Exception{
			
			if (nb_b < 1 || x < 5 || y < 5) {
				throw new GrilleException("erreur d'initialisation");
			}
			
			while(true) {
				try {
					this.bot = new Bot(nb_b,x,y);
					break;
				}
				catch(BotException e) {
					continue;
				}
			}
						
			j1 = new VraiJoueur(nb_b, x, y);
		}
		
		
		
		/**
		 * methode qui initialise le jeu, permet eele placement des bateaux
		 */
		public void initialiser() {
			Scanner sc = new Scanner(System.in);
			System.out.println("-----------------");
			
			System.out.println("Joueur place ses bateaux");
			for (Bateau b : j1.getListe_bateau()) {
				while(true) {
					try {
						String dir = "?";
						int x;
						int y;
						System.out.println("Direction du bateau : horizontalement (h) ou verticale (v) ?");
						while(!dir.equals("h") && !dir.equals("v")){
							dir = sc.nextLine();							
						}
						
						System.out.println("Position x du bateau :");
						x = sc.nextInt();
						System.out.println("Position y du bateau :");
						y = sc.nextInt();
						
						
						j1.placerBateau(b, x, y, dir.charAt(0));
						System.out.println(j1.getGrille_bateau());
						break;
					}
					catch(GrilleException e){
						System.out.println(" Case déjà utilisée, réassayez");
						continue;
					}
					catch(ArrayIndexOutOfBoundsException e2) {
						System.out.println("Hors du jeu, réassayez");
						continue;
					} 
					catch (Exception e3) {
						System.out.println("Réassayez");
						continue;
					}
				}
			}
			
			
			
		}
		
		
		/**
		 * méthode qui gere le jeu, permet aux joueurs d'attaquer
		 */
		public void jouer() {
			
			Scanner sc = new Scanner(System.in);
		
			System.out.println(j1);
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
							this.sauvegarder();
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
					
				}
				
				else {
					System.out.println("Le bot attaque...");
					while(true) {
						try {
							bot.attaquer(j1, 0, 0);
							break;
						}
						catch(IndexOutOfBoundsException e) {
							continue;					
						}
						catch (GrilleException e2) {
							continue;
						} 
						catch (Exception e3) {
							continue;
						}
					}
					
					
					System.out.println(j1);
					System.out.println(j1.getGrille_bateau());
					System.out.println("Grille de l'autre joueur :");
					System.out.println(j1.getGrille_attaque());
				}
				i++;
			}
			
			if(j1.aPerdu()) {
				System.out.println("Désolé le bot a gagné...");
			}
			else {
				System.out.println("Félicitations vous avez gagné !");
			}
	
		}
		
		
		
		/**
		 * methode qui permet de sauvegarder le jeu dans un fichier
		 */
		public void sauvegarder() {
			try {
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(".\\bataille_navale.save"));
				oos.writeObject(this);
				oos.close();
			}
			catch (IOException e) {
				System.out.println(e);
				System.out.println("erreur de sauvegarde");
			}
			catch (Exception e2) {
				System.out.println(e2);
				System.out.println("erreur de sauvegarde");
			}
		}
		
		/**
		 * methode qui charge un jeu sauvegarde dans un fichier 
		 * @return le jeu que l on souahite charge ou null si aucune jeu sauvegarde 
		 */
		public static Jeu charger() {
			Jeu res;
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(".\\bataille_navale.save"));
				res = (Jeu)(ois.readObject());
				ois.close();
				
			}
			catch (IOException e) {
				System.out.println(e);
				res = null;
			}
			catch (ClassNotFoundException e2) {
				res = null;
			}
			
			return res;
		}
		

}
