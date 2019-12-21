package battleship;
/**
 * the submarine class
 * @author weikevin
 *
 */
public class Submarine extends Ship {
    /**
     * the constructor of class
     */
	public Submarine() {
		//set the length as 1
		this.setLength(1);
	}
	/**
	 * return the type
	 */
	@Override
	public String getShipType() {
		return "submarine";
	}
}
