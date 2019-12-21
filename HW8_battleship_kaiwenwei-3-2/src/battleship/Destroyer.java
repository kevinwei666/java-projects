package battleship;
/**
 * the destoryer type
 * @author weikevin
 *
 */
public class Destroyer extends Ship {
	/**
	 * the constructor of the destroyer
	 */
	public Destroyer() {
		//the length as 2
		this.setLength(2);
	}
	/**
	 * return the ship type
	 */
	@Override
	public String getShipType() {
		return "destroyer";
	}

}
