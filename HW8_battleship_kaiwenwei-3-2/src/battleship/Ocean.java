package battleship;
import java.util.*;

/**
 * the ocean class
 * @author weikevin
 *
 */
public class Ocean {
	/**
	 * the ship array
	 */
	private Ship[][]ships=new Ship[10][10];
	/**
	 * the number of shot
	 */
	private int shotsFired;
	/**
	 * the number of the hit
	 */
	private int hitCount;
	/**
	 * the number of sunkship
	 */
	private int shipsSunk;
	/**
	 * the random
	 */
	private Random random;
	/**
	 * the battleship
	 */
	private Ship battleship;
	/**
	 * the cruiserA
	 */
	private Ship cruiserA;
	/**
	 * the cruiserB
	 */
	private Ship cruiserB;
	/**
	 * the destroyerA
	 */
	private Ship destroyerA;
	/**
	 * the destroyerB
	 */
	private Ship destroyerB;
	/**
	 * the destroyerC
	 */
	private Ship destroyerC;
	/**
	 * the submarineA
	 */
	private Ship submarineA;
	/**
	 * the submarineB
	 */
	private Ship submarineB;
	/**
	 * the submarineC
	 */
	private Ship submarineC;
	/**
	 * the submarineD
	 */
	private Ship submarineD;
	/**
	 * the sunkArray
	 */
	private boolean [] sunkArray ;
	/**
	 * the houseOfShip
	 */
	private Ship [] houseOfShip;
	/**
	 * the constructor of the ocean class
	 */
	public Ocean() {
		//initialize the variables
		this.hitCount=0;
		this.shotsFired=0;
		this.shipsSunk=0;
		
		this.ships = new Ship[10][10];
		for (int i =0; i<10; i++) {			
			for (int j =0; j<10; j++) {
				this.ships[i][j] = new EmptySea();
			}
		}

	
		battleship = new Battleship();
		cruiserA = new Cruiser();
		cruiserB = new Cruiser();
		destroyerA = new Destroyer();
		destroyerB = new Destroyer();
		destroyerC = new Destroyer();
		submarineA = new Submarine();
		submarineB = new Submarine();
		submarineC = new Submarine();
		submarineD = new Submarine();

		
		random = new Random();

		sunkArray = new boolean[10];
		

	
		this.houseOfShip = new Ship[10];
		
		this.houseOfShip();

		
		
		}
	/**
	 * the array to place the ship there are 10 ships
	 */
		
	public void houseOfShip() {
		
		this.houseOfShip[0] = battleship;
		this.houseOfShip[1] = cruiserA;
		this.houseOfShip[2] = cruiserB;
		this.houseOfShip[3] = destroyerA;
		this.houseOfShip[4] = destroyerB;
		this.houseOfShip[5] = destroyerC;
		this.houseOfShip[6] = submarineA;
		this.houseOfShip[7] = submarineB;
		this.houseOfShip[8] = submarineC;
		this.houseOfShip[9] = submarineD;
	}
	/**
	 * to get the array of the ship
	 * @return the array of ship
	 */
	public Ship[] gethouseOfShip() {
		return this.houseOfShip;
	}
	/**
	 * place the ship randomly
	 * @param ship array value
	 */
	public void placeOneShipRandomly(Ship ship) {
		boolean isOkToPlace = false;
		int row = 10; 
		int column = 10 ; 
		boolean horizontal = false;

		while (isOkToPlace != true) {
			
			row = random.nextInt(10);
			column = random.nextInt(10);
			horizontal = random.nextBoolean();

		
			isOkToPlace = ship.okToPlaceShipAt(row, column, horizontal, this);
		}

	
		ship.placeShipAt(row, column, horizontal, this);
		
	}

	/**
	 * place all the ship randomly
	 */
	public void placeAllShipsRandomly() {
		
		for (int i=0; i<10; i++) {
			this.placeOneShipRandomly(this.houseOfShip[i]);
		}	
	}
	/**
	 * if the location in the board
	 * @param row of bow
	 * @param column of bow
	 * @return the boolean value
	 */
	public boolean IfInOcean (int row, int column) {
		if (row < 0 || column <0 || row > 9 || column > 9) {
			return false;
		}
		return true;
	}

   
	/**
	 * if the location is occupied by the ships
	 * @param row of bow
	 * @param column of bow
	 * @return boolean value
	 */
	public boolean isOccupied(int row, int column) {
		boolean isWithinOcean = this.IfInOcean(row, column);
		if (isWithinOcean == true ) {
			if (ships[row][column] instanceof EmptySea ) {
				return false;
			}
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * if the place is shot
	 * @param row of bow
	 * @param column of bow
	 * @return boolean value
	 */
	public boolean shootAt(int row, int column) {	
		boolean isWithinOcean = this.IfInOcean(row, column);
		if (isWithinOcean == true ) {
			
			if (ships[row][column].getShipType() != "empty" && ships[row][column].isSunk()== false) {
				
				this.hitCount ++;	
				this.shotsFired ++;
				
				ships[row][column].shootAt(row, column);
				return true;
			}

			
			else if (ships[row][column].getShipType() == "empty") {
				
				this.shotsFired ++;
				ships[row][column].shootAt(row, column);
			}
            if (ships[row][column].getShipType() != "empty" && ships[row][column].isSunk()== true) {
				
				
				this.shotsFired ++;
				return false;
			}

		

		}
		return false;
	}
	/**
	 * get the shot number
	 * @return shotsFired
	 */
	public int getShotsFired() {
		return this.shotsFired;
	}
   
	/**
	 * count the true in the array
	 * @param  theArray value
	 * @return counter
	 */
	public int countEleInArray(boolean[] theArray) {
		int counter =0;
		for (boolean trueOrFalse: theArray) {
			if (trueOrFalse == true) {
				counter ++;
			}
		}
		return counter;
	}


	/**
	 * the hit number
	 * @return hit count
	 */
	public int getHitCount() {
		

		return this.hitCount;

	
	}
	/**
	 * the number of sunk ships
	 * @return number of sunk ship
	 */
	public int getShipsSunk() {
		for (int i=0; i<10; i++) {
			this.sunkArray[i] = this.houseOfShip[i].isSunk();
		}
		this.shipsSunk=countEleInArray(this.sunkArray);
		
		return this.shipsSunk;
	}
	/**
	 * to return the type when sunk
	 * @param row of bow
	 * @param column of bow
	 * @return type of ship
	 */
	public String returnTheType(int row, int column) {
		boolean isWithinOcean = this.IfInOcean(row, column);
		if (isWithinOcean == true ) {
                if (ships[row][column].getShipType() != "empty" && ships[row][column].isSunk()== true) {
				
				System.out.println("the sunk ship type:"+ships[row][column].getShipType());
				
			}
			
		}
		
		return " ";
		
	}

	/**
	 * determine if the gameover
	 * @return boolean value
	 */
	public boolean isGameOver() {
		if (this.shipsSunk == 10) {
			return true;
		}
		return false;
	}
	/**
	 * get the ship array
	 * @return ship array
	 */
	public Ship[][] getShipArray() {
		return this.ships;
	}

	/**
	 * set the ship array
	 * @param row of bow
	 * @param column of bow
	 * @param ship array
	 */
	public void setShipArray(int row, int column, Ship ship) {
		if(row>=0 && column >=0 && row<=9 &&column<=9) {
			this.ships[row][column]=ship;
		}

		
	}
	/**
	 * print the board and the reaction of the action
	 */
	public void print() {		
		
		System.out.println();
		for (int i = 0; i <= 10; i++) {
			if (i==0) {
				System.out.println("    0 1 2 3 4 5 6 7 8 9");
			}
			else { 
				System.out.print("  ");
				System.out.print(i-1 +" ");
				for (int j = 0; j < 10; j++) {
					Ship ship = this.ships[i-1][j];
					if (ship.getShipType()=="empty") {
						System.out.print(ship + " ");
					}
					else if (ship.isHorizontal() == true) {
						if (ship.getHit()[j - ship.getBowColumn()] == true) {
							System.out.print(ship + " ");	
						}
						else {
							System.out.print("." + " ");
						}
					}
					else if (ship.isHorizontal() == false ) {
						if (ship.getHit()[i - 1 - ship.getBowRow()] == true) {
							System.out.print(ship + " ");
						}	
						else {
							System.out.print("." + " ");
						}
					}
				}
				System.out.println();
			}
		}
		System.out.println();
	}
}
	
	
	
	
	
	
	

