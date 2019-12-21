package battleship;
/**
 * the battleship class
 * @author weikevin
 *
 */
public class Battleship extends Ship {
   /**
    * the constructor of the class and set its length as 4
    */
	public Battleship() {
		
		//set the length as 4
		this.setLength(4);
		
	}
	/**
	 * return the ship type
	 */
	@Override
	public String getShipType() {
		//the type of ship
		return "battleship";
	}

}
