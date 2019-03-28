import java.io.*;
import java.util.*;

public class Jeu implements Serializable{

		
		private Bot bot;
		
		private VraiJoueur j1;
		
		
		/**
		 * methode qui permet d'initialiser un nouveau avec un jouer contre un bot
		 * @param nb_b le nombre de bateau avec lequel on veut jouer 
		 * @param x la taille x de la grille de jeu
		 * @param y la taille y de la grille de jeu
		 */
		public Jeu(int nb_b,int x,int y) {
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
		 * méthode qui gere le jeu 
		 */
		public void jouer() {
			
			Scanner sc = new Scanner(System.in);
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
							System.out.println("test");
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
		
		
		
		/**
		 * methode qui permet de sauvegarder le jeu dans un fichier
		 */
		public void sauvegarder() {
			try {
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Gauthier\\Desktop\\bataille_navale.save"));
				oos.writeObject(this);
				oos.close();
			}
			catch (IOException e) {
				System.out.println("erreur de sauvegarde");
			}
		}
		
		/**
		 * methode qui charge un jeu sauvegarde dans un fichier 
		 * @return le jeu que l on souahite charge ou null si aucune jeu sauvegarde 
		 */
		public Jeu charger() {
			Jeu res;
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\Gauthier\\Desktop\\bataille_navale.save"));
				res = (Jeu)(ois.readObject());
				ois.close();
				
			}
			catch (IOException e) {
				res = null;
			}
			catch (ClassNotFoundException e2) {
				res = null;
			}
			
			return res;
		}
		

}
