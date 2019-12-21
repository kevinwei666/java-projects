package battleship;
/**
 * the ocean test
 */
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
//the test of ocean
public class OceanTest {
    //instance variable
	/**
	 * the ocean value
	 */
	private Ocean ocean;
	/**
	 * the battleship value
	 */
	private Ship battleship;
	/**
	 * the cruiser value
	 */
	private Ship cruiser;
	/**
	 * the destoryer value
	 */
	private Ship destroyer;
	/**
	 * submarine value
	 */
	private Ship submarine;
	/**
	 * the house of ship
	 */
	private Ship [] houseOfShip ;
    /**
     * initial the value
     * @throws Exception value
     */
	@Before
	public void setUp() throws Exception {
		//initial value of variable
		ocean = new Ocean();
		houseOfShip = ocean. gethouseOfShip();
		battleship= houseOfShip[0];
		cruiser = houseOfShip[1];
		destroyer = houseOfShip[3];
		submarine = houseOfShip[6];	
	}

    /**
     * test the ocean
     */
	@Test
	public void testOcean() {
		//test the empty sea
		assertEquals("empty", ocean.getShipArray()[0][0].getShipType());
		assertEquals("empty", ocean.getShipArray()[1][5].getShipType());
		assertEquals("empty", ocean.getShipArray()[0][9].getShipType());

	}
	/**
	 * test the get house of ship method
	 */

	@Test
	public void testGethouseOfShip() {
		//test if the ships in the array
		assertEquals("battleship", ocean.gethouseOfShip()[0].getShipType());
		assertEquals("cruiser", ocean.gethouseOfShip()[1].getShipType());
		assertEquals("destroyer", ocean.gethouseOfShip()[3].getShipType());
		assertEquals("submarine", ocean.gethouseOfShip()[6].getShipType());

	}
    /**
     * test the ifinocean method
     */
	@Test
	public void testIfinOcean() {
		//test the location if in the board
		assertFalse(ocean.IfInOcean(-6, -1));
		assertFalse(ocean.IfInOcean(0, -9));
		assertFalse(ocean.IfInOcean(-1, 0));
		assertFalse(ocean.IfInOcean(0, 10));
		assertFalse(ocean.IfInOcean(18, 0));
		assertFalse(ocean.IfInOcean(10, 10));
		//in the ocean
		assertTrue(ocean.IfInOcean(0, 0));
		assertTrue(ocean.IfInOcean(1, 5));
		assertTrue(ocean.IfInOcean(6, 9));

	}
	/**
	 * test IsOccupied() method
	 */

	@Test
	public void testIsOccupied() {
		// if location out of bound
		assertFalse(ocean.isOccupied(0, -1));
		assertFalse(ocean.isOccupied(-6, -6));
		assertFalse(ocean.isOccupied(0, 10));
		assertFalse(ocean.isOccupied(100, 0));

		// place battleship 
		battleship.placeShipAt(8, 5, true, ocean);

		// non occupied place
		assertFalse(ocean.isOccupied(7, 4));
		assertFalse(ocean.isOccupied(7, 5));
		assertFalse(ocean.isOccupied(7, 6));
		assertFalse(ocean.isOccupied(5, 7));
		assertFalse(ocean.isOccupied(5, 8));
		assertFalse(ocean.isOccupied(5, 9));
		assertFalse(ocean.isOccupied(6, 4));
		assertFalse(ocean.isOccupied(6, 9));
		assertFalse(ocean.isOccupied(7, 4));
		assertFalse(ocean.isOccupied(7, 5));
		assertFalse(ocean.isOccupied(7, 6));
		assertFalse(ocean.isOccupied(7, 7));
		assertFalse(ocean.isOccupied(7, 8));
		assertFalse(ocean.isOccupied(7, 9));

		// occupied place
		assertTrue(ocean.isOccupied(8, 5));
		assertTrue(ocean.isOccupied(8, 6));
		assertTrue(ocean.isOccupied(8, 7));
		assertTrue(ocean.isOccupied(8, 8));

	}
    /**
     * test ShootAt()
     */
	@Test
	public void testShootAt() {
		//place a ship
        battleship.placeShipAt(7, 6, true, ocean);

		//don't shoot on the ship
		assertFalse(ocean.shootAt(3, 3));
		assertFalse(ocean.shootAt(5, 6));

		//shoot the ship and sunk it
		assertTrue(ocean.shootAt(7, 6));
		assertTrue(ocean.shootAt(7, 7));
		assertTrue(ocean.shootAt(7, 8));
		assertTrue(ocean.shootAt(7, 9));

		//the sunk ship
		assertTrue(battleship.isSunk());
		//shoot on the sunk ship,return false
		assertFalse(ocean.shootAt(7, 6));
	}
    /**
     * test GetShotsFired()
     */
	@Test
	public void testGetShotsFired() {
		//place 10 ships
		this.placeShips();
		//equals to 0 before fired
		assertEquals(0, ocean.getShotsFired());
		//shoot out of the ocean
		ocean.shootAt(-1,-1); 
		assertEquals(0, ocean.getShotsFired());
		//shoot the boat
		ocean.shootAt(3,3);
		ocean.shootAt(3,9);
		assertEquals(2, ocean.getShotsFired());
		
		//shoot the same place
		ocean.shootAt(6,9);
		ocean.shootAt(6,9);
		ocean.shootAt(6,9);
		assertEquals(5, ocean.getShotsFired());
		
		//sunk a ship
		ocean.shootAt(9,0);
		assertEquals(6, ocean.getShotsFired());
		
	    //the number will increase after sunk
		ocean.shootAt(9,0);
		assertEquals(7, ocean.getShotsFired());
	}
    /**
     * test GetTrueCount()
     */
	@Test
	public void testGetTrueCount() {
		//count the true in array
		boolean [] a = new boolean[10];
		assertEquals(0 , ocean.countEleInArray(a));
		a[0] = true;
		a[3] = true;
		assertEquals(2 , ocean.countEleInArray(a));
	}
    /**
     * test GetHitCount()
     */
	@Test
	public void testGetHitCount() {
		//place the ships
		cruiser.placeShipAt(0, 0, false, ocean);
		battleship.placeShipAt(5, 0, true, ocean);
		// no hit count before any shooting
		assertEquals(0, ocean.getHitCount());

		// shoot the cruiser 
		ocean.shootAt(1 ,0);
		assertEquals(1, ocean.getHitCount());
		// additional hit would increase hit count
		ocean.shootAt(1, 0); 
		assertEquals(2, ocean.getHitCount());

		// sunk cruiser
		ocean.shootAt(0, 0);
		ocean.shootAt(2, 0);
		assertEquals(4, ocean.getHitCount());
		assertTrue(cruiser.isSunk());
		
		
		ocean.shootAt(0, 0);
		assertEquals(4, ocean.getHitCount());

		// shoot on empty sea, hit count remains
		ocean.shootAt(0, 3); 
		assertEquals(4, ocean.getHitCount());

		// shoot battleship
		ocean.shootAt(5,1);
		ocean.shootAt(5,3);
		assertEquals(6, ocean.getHitCount());
	}
    /**
     * test GetShipsSunk()
     */
	@Test
	public void testGetShipsSunk() {
		//place the ship
		submarine.placeShipAt(0, 8, true, ocean);
		destroyer.placeShipAt(4, 0, true, ocean);
		cruiser.placeShipAt(1, 3, false, ocean);

		//no shoot, 0
		assertEquals(0, ocean.getShipsSunk());

	    //sunk a submarine
		ocean.shootAt(0 ,8);
		assertEquals(1, ocean.getShipsSunk());

		//shoot, but not sunk
		ocean.shootAt(4,0);
		ocean.shootAt(1,3);
		assertEquals(1, ocean.getShipsSunk());

		//sunk all
		ocean.shootAt(4,1);
		ocean.shootAt(2,3);
		ocean.shootAt(3,3);
		assertEquals(3, ocean.getShipsSunk());

	}

	/**
	 * helper function to place all ships on the ocean for testing isGameOver
	 */
	private void placeShips() {
		//place the ships in the board
		houseOfShip[0].placeShipAt(6, 9, false, ocean);
		houseOfShip[1].placeShipAt(1, 1, true, ocean);
		houseOfShip[2].placeShipAt(3, 2, true, ocean);
		houseOfShip[3].placeShipAt(5, 1, true, ocean);
		houseOfShip[4].placeShipAt(1, 6, false, ocean);
		houseOfShip[5].placeShipAt(2, 9, false, ocean);
		houseOfShip[6].placeShipAt(3, 0, true, ocean);
		houseOfShip[7].placeShipAt(9, 0, true, ocean);
		houseOfShip[8].placeShipAt(5, 4, true, ocean);
		houseOfShip[9].placeShipAt(5, 7, true, ocean);

	}
    /**
     * test IsGameOver()
     */
	@Test
	public void testIsGameOver() {
		//place the ships
		this.placeShips();
		assertEquals(0,ocean.getShipsSunk());
		assertFalse(ocean.isGameOver());	
		//shoot half board
		for (int i=0; i < 5; i++) { 
			for (int j=0; j<10; j++) {
				ocean.shootAt(i,j);
			}
		}
		assertEquals(5,ocean.getShipsSunk());
		assertFalse(ocean.isGameOver());

		//shoot all board
		for (int i=5; i < 10; i++) { 
			for (int j=0; j<10; j++) {
				ocean.shootAt(i,j);
			}
		}
		assertEquals(10,ocean.getShipsSunk());
		assertTrue(ocean.isGameOver());
	}
     /**
      * test GetShipArray()
      */
	@Test
	public void testGetShipArray() {
		//get the ship array return the type to test
		assertEquals("empty", ocean.getShipArray()[0][0].getShipType());
		assertEquals("empty", ocean.getShipArray()[3][5].getShipType());
		assertEquals("empty", ocean.getShipArray()[9][9].getShipType());
		battleship.placeShipAt(6, 9, false, ocean);
		assertEquals("battleship", ocean.getShipArray()[7][9].getShipType());
		assertEquals("battleship", ocean.getShipArray()[9][9].getShipType());
	}
	/**
	 * test SetShipArray()
	 */

	@Test
	public void testSetShipArray() {
		//set the array
		assertEquals("empty", ocean.getShipArray()[6][6].getShipType());
		assertEquals("empty", ocean.getShipArray()[1][1].getShipType());
		ocean.setShipArray(6, 6, battleship);
		ocean.setShipArray(1, 1, submarine);
		assertEquals("battleship", ocean.getShipArray()[6][6].getShipType());
		assertEquals("submarine", ocean.getShipArray()[1][1].getShipType());
	}
    
	/**
	 * test print
	 */
	@Test
	public void testPrint() {
		//print the board
		ocean.print(); 
		this.placeShips();
		//the result is shown in the console
		ocean.print(); 
		ocean.shootAt(0,0); //"-"
		ocean.shootAt(1,1); //'s'
		ocean.shootAt(1,3); //'s'
		ocean.shootAt(3,0); //'x'
		ocean.print();
		ocean.shootAt(1,2);  //sunk the ship
		ocean.print();	}

}