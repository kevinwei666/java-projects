package battleship;
/**
 * the is the ship class
 * @author weikevin
 *
 */

/**
 * the ship class
 * @author weikevin
 *
 */
public class Ship {
	//instance variable
	/**
	 * the row of bow
	 */
	private int bowRow;
	/**
	 * the column of bow
	 */
	private int bowColumn;
	/**
	 * the length of the ship
	 */
	private int length;
	/**
	 * the horizontal value
	 */
	private boolean horizontal;
	/**
	 * the hit array
	 */
	protected boolean[] hit= new boolean [4];
	/**
	 * the shot value
	 */
	private boolean theshot=false;
	//constructor of ship
	/**
	 *the constructor of ship class, the hit array is initialized
	 */
	public Ship() {
		//initialize the hit array as false 
		this.hit[0]=false;
		this.hit[1]=false;
		this.hit[2]=false;
		this.hit[3]=false;
		}
	/**
	 * Returns the length of each kind of ship
	 * @return length
	 */
	public int getLength() {
		return this.length;
		
	}
	/**
	 * Returns the row of bow of the ship
	 * @return bowrow
	 */
	public int getBowRow() {
		return this.bowRow;
		
	}
	/**
	 * get the column of bow of the ship
	 * @return bowcolumn
	 */
	public int getBowColumn() {
		return this.bowColumn;
		
	}
	/**
	 * get the hit array
	 * @return hit array
	 */
	public boolean[] getHit(){
		return this.hit;
		
	}
	/**
	 * get the boolean if the ship is horizontal 
	 * @return horizontal value
	 */
	public boolean isHorizontal() {
		return this.horizontal;
		
	}
	/**
	 * get the type of ships
	 * @return the type of ship
	 */
	public String getShipType() {
		return " ";
		
	}
	/**
	 * set the length of each kind ship
	 * @param length of ship
	 */
	public void setLength(int length) {
		this.length=length;
	}
	/**
	 * set the row number of the row of bow
	 * @param row of bow
	 */
	public void setBowRow(int row) {
		this.bowRow=row;
	}
	/**
	 * set the column number of the column of bow
	 * @param column of bow
	 */
	public void setBowColumn(int column) {
		this.bowColumn=column;
	}
	/**
	 * set the the condition of the horizontal
	 * @param horizontal value
	 */
	public void setHorizontal (boolean horizontal) {
		this.horizontal=horizontal;
	}
	/**
	 * determind if the location is adjcant with others
	 * @param row of bow
	 * @param column of bow
	 * @param ocean value
	 * @return the boolean value
	 */
	public boolean ifExistAdj(int row, int column, Ocean ocean) {
		if(row<0||column<0||row>9||column>9) {
			return false;	
		}
		int uprow = row-1;
		int downrow = row+1;
		int upcol = column-1;
		int downcol = column+1;
		int ROW;
		int COL;
		
		for(ROW=uprow; ROW<=downrow; ROW++) {
			for(COL=upcol; COL<=downcol; COL++) {
				if (ocean.isOccupied(ROW,COL)==true) {
					return false;
				}
			}
		}
		return true;
	}
	/**
	 * determine if the location is legal to place the ships int he board
	 * @param row of bow
	 * @param column of bow
	 * @param horizontal value
	 * @param ocean value
	 * @return boolean value
	 */
	public boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		boolean isPlaceable = true;
		
		// horizontal ship
		if (horizontal == true) {
			// loop each part of the ship through column
			for (int i =  column; i < column + this.length; i++) {
				isPlaceable = this.ifExistAdj(row, i, ocean);
				if (isPlaceable == false) {
					return false;
				}
			}
		}
		
		// vertical ship
		else {
			// loop each part of the ship through row
			for (int i = row ; i < row + this.length; i++) {
				isPlaceable = this.ifExistAdj(i, column, ocean);
				if (isPlaceable == false) {
					return false;
				}
			}
		}
		return true;

	}
	/**
	 * place the ship on the board based on the row and column number
	 * @param row of bow
	 * @param column of bow
	 * @param horizontal value
	 * @param ocean value
	 */
	void placeShipAt (int row, int column, boolean horizontal, Ocean ocean) {
		int i;
		this.setBowRow(row);
		this.setBowColumn(column);
		this.setHorizontal(horizontal);
		if (horizontal==true) {
			for (i= column; i<column+this.length;i++) {
				ocean.setShipArray(row, i, this);
			}
		
		}
		else {
			for (i= row; i<row+this.length;i++) {
				ocean.setShipArray(i, column, this);
			}
			
		}
		
	}
	
	/**
	 * determine if the ship is shot 
	 * @param row of bow
	 * @param column of bow
	 * @return boolean value
	 */
	
	public boolean shootAt(int row, int column) {		
		boolean isOccupied = false;
		int whichPartOfShip = 0;
		
		// check if a part of the ship occupies the given row and column
		if (this.horizontal == true && this.bowRow == row) {
			for (int i = this.bowColumn; i < this.bowColumn + this.length; i++) {
				if (column == i) {
					// record which part of ship
					whichPartOfShip = i - this.bowColumn;
					// the given row/column is occupied
					isOccupied = true;
					break;
				}
			}
		}
		else if (this.horizontal == false && this.bowColumn == column) {
			for (int i = this.bowRow; i < this.bowRow + this.length; i++) {
				if (row == i) {
					whichPartOfShip = i - this.bowRow;
					isOccupied = true;
					break;
				}
			}
		}
		
		// if the given row/ column is occupied and the ship is not sunk yet
		if (isOccupied == true && this.isSunk() == false ) {
			// mark that part of the ship as ÓhitÓ
			this.hit[whichPartOfShip] = true;
			theshot = true; 
			return true;
		}
		return false;
	}
	/**
	 * determine if the ship is sunk
	 * @return boolean value
	 */
	
	public boolean isSunk() {
		for (int i =0; i < this.length; i++) {
			if (this.hit[i] == false) {
				return false;
			}
		}
		return true;
	}
	/**
	 * return the string of each case
	 */

	public String toString() {		
		if (this.theshot == true) {
			if (this.isSunk() == true) {
				// sunk ship
				
				return "x"; 
			}
			else {
				// ship being partially shot
				return "S"; 
			}
		}
		return ".";
	}

}

