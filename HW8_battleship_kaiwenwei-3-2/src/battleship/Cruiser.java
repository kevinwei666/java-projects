package battleship;
/**	
 * the cruiser class
 */
public class Cruiser extends Ship {
    /**
     * the constructor of the cruiser class
     */
	public Cruiser() {
		
		//set the length as 3
		this.setLength(3);
		
	}
	/**
	 * return the ship type
	 */
	@Override
	public String getShipType() {
		return "cruiser";
	}

}
