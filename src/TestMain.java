
public class TestMain {

	public static void main(String[] args) {
		Joueur b;
		while(true) {
			try {
				b = new Bot(5,10,10);
				break;
			}
			catch(BotException e) {
				continue;
			}
		}
		
		System.out.println("Bot Bateaux : ");
		System.out.println(b.getGrille_bateau());
	}

}
