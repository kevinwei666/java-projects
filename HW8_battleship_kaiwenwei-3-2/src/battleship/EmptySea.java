package battleship;
/**
 * the empty class
 * @author weikevin
 *
 */
public class EmptySea extends Ship {
	/**
	 * the length of the ship
	 */
	int length;
	/**
	 * the constructor of the emptysea
	 */
	public EmptySea() {
		//set it as 1
		this.setLength(1);
	}
	/**
	 * to determine if it is shot
	 * @return boolean value
	 */
	@Override
	public boolean shootAt(int row, int column) {
		//
		this.hit[0]=true;
		return false;
	}
	/**
	 * if it is sunk
	 */
	@Override
	public boolean isSunk() {
		return false;
	}
	/**
	 * the reaction string
	 */
	@Override
	public String toString() {
		if (this.hit[0]==true) {
			return "-";
		}
		return ".";
		
	}
	/**
	 * the type is empty
	 */
	@Override
	public String getShipType()
	{
		return "empty";
	}
	

}
