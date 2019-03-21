/**
 * Classe premettant de generer des exceptions du bot
 * 
 * @author Gauthier Mayer
 * @version 1.0
 */
public class BotException extends Exception{

	
	/**
	 * constructeur de l exception
	 * @param msg message a afficher 
	 */
	public BotException(String msg) {
		super(msg);
	}
	
}
