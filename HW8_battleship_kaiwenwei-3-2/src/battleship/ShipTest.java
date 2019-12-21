package battleship;

import static org.junit.jupiter.api.Assertions.*;
//the ship test
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class ShipTest {
	//declare the variables for testing
	/**
	 * the battleship value
	 */
	private Ship battleship;
	/**
	 * the cruiser value
	 */
	private Ship cruiser;
	/**
	 * the destroyer value
	 */
	private Ship destroyer;
	/**
	 * the submarine value
	 */
	private Ship submarine;
	/**
	 * the emptysea value
	 */
	private Ship emptySea;
	/**
	 * the ocean value
	 */
	private Ocean ocean;
	/**
	 * the row of bow
	 */
	private int bowRow;
	/**
	 * the column of bow
	 */
	private int bowColumn;
	/**
	 * the horizontal value
	 */
	private boolean horizontal;
	/** 
	 * the hit array
	 */
	protected boolean [] hit = new boolean [4];
    /**
     * initial the values
     * @throws Exception value
     */
	@BeforeEach
	void setUp() throws Exception {
		//initialize variable for testing
		battleship= new Battleship();
		cruiser = new Cruiser();
		destroyer = new Destroyer();
		submarine = new Submarine();
		emptySea = new EmptySea();
		ocean = new Ocean();
	}
    /**
     * test getlenght()
     */
	@Test
	void testgetLength() {
		//get the length of each kind of ship and determine if it is true
		assertEquals(4, battleship.getLength());
		assertEquals(3, cruiser.getLength());
		assertEquals(2, destroyer.getLength());
		assertEquals(1, submarine.getLength());
		assertEquals(1, emptySea.getLength());
	}
	@Test
	/**
     * test getBowRow()
     */
	void testgetBowRow() {
		//test the bowrow of each kind of ship
		assertEquals(this.bowRow, battleship.getBowRow());
		assertEquals(this.bowRow, cruiser.getBowRow());
		assertEquals(this.bowRow, destroyer.getBowRow());
		assertEquals(this.bowRow, submarine.getBowRow());
		assertEquals(this.bowRow, emptySea.getBowRow());
		
	}
	/**
	 * test getBowColumn()
	 */
	@Test
	void testgetBowColumn() {
		//test the bowcolumn of each kind of ship
		assertEquals(this.bowColumn, battleship.getBowColumn());
		assertEquals(this.bowColumn, cruiser.getBowColumn());
		assertEquals(this.bowColumn, destroyer.getBowColumn());
		assertEquals(this.bowColumn, submarine.getBowColumn());
		assertEquals(this.bowColumn, emptySea.getBowColumn());
	}
	/**
	 * test getHit()
	 */
	@Test
	void testgetHit() {
		//use the battleship to test if this is hit 
		assertEquals(hit[0], battleship.getHit()[0]);
		assertEquals(hit[1], battleship.getHit()[1]);
		assertEquals(hit[2], battleship.getHit()[2]);
		assertEquals(hit[3], battleship.getHit()[3]);
	}
    /**
     * test isHorizontal()
     */
	@Test
	void testisHorizontal() {
		// test the ishorizontal method and if this is right 
		assertEquals(this.horizontal, battleship.isHorizontal());
		assertEquals(this.horizontal, cruiser.isHorizontal());
		assertEquals(this.horizontal, destroyer.isHorizontal());
		assertEquals(this.horizontal, submarine.isHorizontal());
		assertEquals(this.horizontal, emptySea.isHorizontal());
	}
	/**
	 * test getShipType()
	 */
	@Test
	void testgetShipType() {
		//test if the method can get the corresponding type of ship right
		assertEquals("battleship", battleship.getShipType());
		assertEquals("cruiser", cruiser.getShipType());
		assertEquals("destroyer", destroyer.getShipType());
		assertEquals("submarine", submarine.getShipType());
		assertEquals("empty", emptySea.getShipType());
		
	}
	/**
	 * test setBowRow()
	 */
	@Test
	void testsetBowRow() {
		//set the bowrow of each kind of ship
		battleship.setBowRow(1);
		cruiser.setBowRow(2);
		destroyer.setBowRow(3);
		submarine.setBowRow(4);
		emptySea.setBowRow(5);
		//test them
		assertEquals(1, battleship.getBowRow());
		assertEquals(2, cruiser.getBowRow());
		assertEquals(3, destroyer.getBowRow());
		assertEquals(4, submarine.getBowRow());
		assertEquals(5, emptySea.getBowRow());
	}
	/**
	 *  test setBowColumn()
	 */
	@Test
	void testsetBowColumn() {
		//set the bowcolumn of each kind of ship
		battleship.setBowColumn(1);
		cruiser.setBowColumn(2);
		destroyer.setBowColumn(3);
		submarine.setBowColumn(4);
		emptySea.setBowColumn(5);
		//test them
		assertEquals(1, battleship.getBowColumn());
		assertEquals(2, cruiser.getBowColumn());
		assertEquals(3, destroyer.getBowColumn());
		assertEquals(4, submarine.getBowColumn());
		assertEquals(5, emptySea.getBowColumn());
		
	}
	@Test
	/**
	 * test setHorizontal()
	 */
	void testsetHorizontal() {
		//set the horizontal condition of each kind of ship
		battleship.setHorizontal(true);
		cruiser.setHorizontal(true);
		destroyer.setHorizontal(true);
		submarine.setHorizontal(false);
		emptySea.setHorizontal(false);
		//test them
		assertTrue(battleship.isHorizontal());
		assertTrue(cruiser.isHorizontal());
		assertTrue(destroyer.isHorizontal());
		assertFalse(submarine.isHorizontal());
		assertFalse(emptySea.isHorizontal());
	}
	/**
	 * test setLength()
	 */
	@Test
	void testsetLength() {
		//set the ship length by the set method
		battleship.setLength(10);
		cruiser.setLength(2);
		destroyer.setLength(3);
		submarine.setLength(4);
		emptySea.setLength(5);
		//test them
		assertEquals(10, battleship.getLength());
		assertEquals(2, cruiser.getLength());
		assertEquals(3, destroyer.getLength());
		assertEquals(4, submarine.getLength());
		assertEquals(5, emptySea.getLength());	
	}
	/**
	 * test tokToPlaceShipAt()
	 */
	void testokToPlaceShipAt() {
		//out of the bound
		assertFalse(submarine.okToPlaceShipAt(0,-10, true, ocean));
		assertFalse(submarine.okToPlaceShipAt(-1,0, true, ocean));
		assertFalse(submarine.okToPlaceShipAt(0,10, true, ocean));

		destroyer.placeShipAt(2, 3, true, ocean);
		// horizontal adjacent
		assertFalse(submarine.okToPlaceShipAt(1, 3, true, ocean));
		assertFalse(cruiser.okToPlaceShipAt(2,5, true, ocean));
		assertFalse(battleship.okToPlaceShipAt(1, 0, true, ocean));
		// vertically adjacent
		assertFalse(submarine.okToPlaceShipAt(3, 3, true, ocean));
		assertFalse(destroyer.okToPlaceShipAt(0, 3, false, ocean));
		assertFalse(battleship.okToPlaceShipAt(0, 5, false, ocean));
		assertFalse(battleship.okToPlaceShipAt(3, 5, false, ocean));
		// diagonally adjacent
		assertFalse(submarine.okToPlaceShipAt(1, 2, false, ocean));
		assertFalse(submarine.okToPlaceShipAt(3, 5, false, ocean));
		assertFalse(cruiser.okToPlaceShipAt(3, 0, true, ocean));
		assertFalse(destroyer.okToPlaceShipAt(0, 5, false, ocean));

		// the location is legal
		assertTrue(battleship.okToPlaceShipAt(0, 0, true, ocean));
		assertTrue(battleship.okToPlaceShipAt(0, 1, true, ocean));
		assertTrue(battleship.okToPlaceShipAt(4, 4, false, ocean));
		assertTrue(battleship.okToPlaceShipAt(4, 4, false, ocean));
		assertTrue(battleship.okToPlaceShipAt(0, 6, true, ocean));
		assertTrue(battleship.okToPlaceShipAt(6, 0, false, ocean));
		
		// part of the ship is out of bound
		assertFalse(battleship.okToPlaceShipAt(0, 9, true, ocean));
		assertFalse(battleship.okToPlaceShipAt(8, 8, true, ocean));
		assertFalse(battleship.okToPlaceShipAt(9, 8, false, ocean));	
		
		
	}
	/**
	 * test ifExistAdj()
	 */
	@Test
	void testifExistAdj() {
		// place a destroyer
		destroyer.placeShipAt(2, 3, true, ocean);
		//the illegal location and determine if the result is false
		assertFalse(submarine.ifExistAdj(1,2, ocean));
		assertFalse(submarine.ifExistAdj(1,3, ocean));
		assertFalse(submarine.ifExistAdj(1,4, ocean));
		assertFalse(submarine.ifExistAdj(1,5, ocean));
		assertFalse(submarine.ifExistAdj(2,5, ocean));
		assertFalse(submarine.ifExistAdj(3,5, ocean));
		assertFalse(submarine.ifExistAdj(3,4, ocean));
		assertFalse(submarine.ifExistAdj(3,3, ocean));
		assertFalse(submarine.ifExistAdj(3,2, ocean));
		assertFalse(submarine.ifExistAdj(2,2, ocean));
		assertTrue(submarine.ifExistAdj(0,1, ocean));
		
		//the legal location and determine if the result is true
		assertTrue(submarine.ifExistAdj(2,0, ocean));
		assertTrue(submarine.ifExistAdj(0,1, ocean));
		assertTrue(submarine.ifExistAdj(1,0, ocean));
		assertTrue(submarine.ifExistAdj(0,9, ocean));
		assertTrue(submarine.ifExistAdj(8,0, ocean));
		assertTrue(submarine.ifExistAdj(9,9, ocean));
		assertTrue(submarine.ifExistAdj(4,6, ocean));
		assertTrue(submarine.ifExistAdj(8,8, ocean));

		
        //the ships are placed randomly and out the bound
		assertFalse(submarine.ifExistAdj(0,-1, ocean));
		assertFalse(submarine.ifExistAdj(-1,0, ocean));
		assertFalse(submarine.ifExistAdj(10,0, ocean));
		assertFalse(submarine.ifExistAdj(0,10, ocean));
		
	}
	/**
	 * test placeShipAt()
	 */
	@Test
	void testplaceShipAt() {
	//it is illegal to put in the empty
	assertFalse(emptySea.shootAt(0,0));
	//before the placing
	assertFalse(ocean.isOccupied(6, 6));
	//place a ship at 6,6
	battleship.placeShipAt(6, 6, true, ocean);
	//test if the locations is occupied
	assertFalse(ocean.isOccupied(6, 5));
	assertTrue(ocean.isOccupied(6, 6));
	assertTrue(ocean.isOccupied(6, 7));
	assertTrue(ocean.isOccupied(6, 8));
	assertTrue(ocean.isOccupied(6, 9));
	assertFalse(ocean.isOccupied(2, 2));
	//place a vertical ship
	destroyer.placeShipAt(2, 2, false, ocean);
	assertTrue(ocean.isOccupied(2, 2));
	assertTrue(ocean.isOccupied(3, 2));
		
	}
    /**
     * test isSunk()
     */
    @Test
	void testisSunk() {
		// emptySea
		assertFalse(emptySea.isSunk());
				
		// normal ship
		battleship.placeShipAt(6, 6, true, ocean);
		assertFalse(battleship.isSunk()); 
		battleship.shootAt(6,6);
		battleship.shootAt(6,7);
		assertFalse(battleship.isSunk()); 
		battleship.shootAt(6,8);
		battleship.shootAt(6,9);
		assertTrue(battleship.isSunk()); 
		
	}
    /**
     * test tostring()
     */
	@Test
	void testtoString() {
		//test if the board will have the right action
		assertEquals(".", emptySea.toString()); 
		emptySea.shootAt(0,0);
		assertEquals("-", emptySea.toString()); 
		cruiser.placeShipAt(3, 3, true, ocean);
		cruiser.shootAt(3,3);
		cruiser.shootAt(3,4);
		assertEquals("S", cruiser.toString()); 
		cruiser.shootAt(3,5);
		assertEquals("x", cruiser.toString()); 
	}
	/**
	 * test shootat()
	 */
	@Test
	void testshootAt() {
		//shoot in the empty sea
	    assertFalse(emptySea.shootAt(0,0));
	    
	    //place a ship
		battleship.placeShipAt(7, 6, true, ocean);
		//shoot the ship and test
		assertFalse(battleship.shootAt(5,9));
		assertTrue(battleship.shootAt(7,6));
		assertTrue(battleship.shootAt(7,7));
		assertTrue(battleship.shootAt(7,8));
		assertTrue(battleship.shootAt(7,9));
		assertFalse(battleship.shootAt(7,9));
	}

}
