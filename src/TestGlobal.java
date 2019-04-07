import static org.junit.Assert.*;
import org.junit.*;;

public class TestGlobal {

	
	
	private Joueur j;
	
	@Before
	public void initTest() throws Exception {
		this.j = new VraiJoueur(2, 5, 5);
		j.placerBateau(j.getListe_bateau().get(0), 0, 0, 'v');
	}
	
	@Test
	public void testPlacementImpossible() {
		boolean res;
		try {
			j.placerBateau(j.getListe_bateau().get(1), 0, 1, 'h');
			res = true;
		} catch (Exception e) {
			res = false;
		}
		
		assertEquals("Le placement ne devrait pas se faire",false,res);
		
	}
	
	
	@Test
	public void testPlacementReussi() {
		boolean res;
		try {
			j.placerBateau(j.getListe_bateau().get(1), 1, 1, 'h');
			res = true;
		} catch (Exception e) {
			res = false;
		}
		
		assertEquals("Le placement devrait se faire",true,res);
		
	}
	
	@Test
	public void testAttaqueCaseIndispo() {
		boolean res;
		try {
			j.attaquer(j, -1, 0);
			res = true;
		} catch (Exception e) {
			res = false;
		}
		
		assertEquals("Impossible d'attaquer à cet endroit ", false , res);
		
		try {
			j.attaquer(j, 0, 0);
			j.attaquer(j, 0, 0);
			res = true;
		} catch (Exception e) {
			res = false;
		}
		
		assertEquals("Impossible d'attaquer à cet endroit ", false , res);
	}
	
	
	@Test
	public void testAttaquerNormal() throws Exception {
		j.attaquer(j, 0, 0);
		assertEquals("La case devrait être un bateau touché",true,j.getGrille_bateauTab()[0][0] instanceof CaseBateauTouche);
		assertEquals("La vie du bateau aurait dû diminué", 1, j.getListe_bateau().get(0).getVie());
	}
	
	@Test
	public void testSuppressionListe() throws Exception {
		j.attaquer(j, 0, 0);
		j.attaquer(j, 0, 1);
		assertEquals("Le bateau devrait être supprimé, il devrait y avoir un bateau", 1, j.getListe_bateau().size());
	}
	
	@Test
	public void testCaseTouche() throws Exception {
		j.attaquer(j, 0, 0);
		assertEquals("La devrait être touchée", true, j.getGrille_bateau().estTouche(0, 0));
		assertEquals("La devrait être touchée", false, j.getGrille_bateau().estTouche(0, 1));
	}
	
	@Test
	public void testPlacementBotNormal() throws BotException {
		Bot b = new Bot(2, 5, 5);
		int nb_case_b = 0;
		for(int x = 0; x < 5; x++) {
			for(int z = 0; z < 5; z++) {
				if (b.getGrille_bateauTab()[x][z] instanceof CaseBateau) {
					nb_case_b++;
				}
			}
		}
		assertEquals("Il devrait y avoir 5 cases contenant un bateau (1 de taille 2 et 1 de taille 3)", 5, nb_case_b);
	}
	
	@Test
	public void testAttaqueBot() throws BotException  {
		Bot b = new Bot(2, 5, 5);
		while(true) {
			try {
				b.attaquer(j, 0, 0);
				break;
			} catch (GrilleException e) {
				continue;
			}
		}
		
		while(true) {
			try {
				b.attaquer(j, 0, 0);
				break;
			} catch (GrilleException e) {
				continue;
			}
		}
		
		int nb_case_touche = 0;
		
		for(int x = 0; x < 5; x++) {
			for(int z = 0; z < 5; z++) {
				if (j.getGrille_bateau().estTouche(x, z)) {
					nb_case_touche++;
				}
			}
		}
		assertEquals("Il devrait y avoir 2 cases touchées", 2, nb_case_touche);
	}
	
	
	

}
