
public class Jeu {

	public static void main(String[] args) {
		Grille g = new Grille(5,5);
		System.out.println(g);
		
		System.out.println("-----------------");
		
		Bateau b = new Bateau(3);
		try {
			g.placerBateau(b, 0, 0, 'h');
			
		}
		catch(GrilleException e) {
			System.out.println(e);
		}
		catch (IndexOutOfBoundsException e2) {
			System.out.println(e2);
		}
		
		System.out.println(g);
		
		
		
		System.out.println(g.estTouche(1,0));
	}

}
