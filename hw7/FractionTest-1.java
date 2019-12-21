package hw7;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FractionTest {
	//declare the variables for testing
	Fraction frac1;
	Fraction frac2;
	Fraction frac3;
	Fraction frac4;
	Fraction frac5;
	Fraction frac6;
	Fraction frac7;
	int array1[]= {1,2,3,4};
	int array2[]= {};
	int array3[]= {1,2,-1};
	

	@BeforeEach
	void setUp() throws Exception {
		//initialize variable for testing
		this.frac1= new Fraction (3,4);
		this.frac2= new Fraction (2,7);
		this.frac3= new Fraction (2,4);
		this.frac4= new Fraction (-2,4);
		this.frac5= new Fraction (2,-4);
		this.frac7= new Fraction  (0,1);			
	}

	@Test
	void testReduceToLowestForm() {
		this.frac3.reduceToLowestForm();//a normal fraction
		this.frac4.reduceToLowestForm();// a negative fraction
		this.frac5.reduceToLowestForm();// the '-' is at denominator
		assertEquals(1, this.frac3.numerator);
		assertEquals(2, this.frac3.denominator);
		
		assertEquals(-1, this.frac4.numerator);
		assertEquals(2, this.frac4.denominator);
		
		assertEquals(-1, this.frac5.numerator);
		assertEquals(2, this.frac5.denominator);
	}

	@Test
	void testAdd() {
		frac6=this.frac1.add(frac2);// a normal adding
		assertEquals(29, this.frac6.numerator);
		assertEquals(28, this.frac6.denominator);
		frac6=this.frac1.add(frac4);// a positive plus a negative
		assertEquals(1, this.frac6.numerator);
		assertEquals(4, this.frac6.denominator);
		frac6=this.frac5.add(frac4);// the '-' in the different place
		assertEquals(-1, this.frac6.numerator);
		assertEquals(1, this.frac6.denominator);
		frac6=this.frac3.add(frac4);// result is 0
		assertEquals(0, this.frac6.numerator);
		assertEquals(1, this.frac6.denominator);	
	}

	@Test
	void testSubtract() {
		frac6=this.frac1.subtract(frac2);// a normal subtracting
		assertEquals(13, this.frac6.numerator);
		assertEquals(28, this.frac6.denominator);
		
		frac6=this.frac3.subtract(frac4);// a positive minus a negative
		assertEquals(1, this.frac6.numerator);
		assertEquals(1, this.frac6.denominator);
		
		frac6=this.frac3.subtract(frac7);//subtract with 0
		assertEquals(1, this.frac6.numerator);
		assertEquals(2, this.frac6.denominator);
		
		frac6=this.frac4.subtract(frac5);//result is 0
		assertEquals(0, this.frac6.numerator);
		assertEquals(1, this.frac6.denominator);
	}

	@Test
	void testMul() {
		frac6=this.frac1.mul(frac2);// a normal mul
		assertEquals(3, this.frac6.numerator);
		assertEquals(14, this.frac6.denominator);
		
		frac6=this.frac4.mul(frac5);// the '-' at different place and negative mul negative
		assertEquals(1, this.frac6.numerator);
		assertEquals(4, this.frac6.denominator);
		
		frac6=this.frac7.mul(frac3);//mul with 0
		assertEquals(0, this.frac6.numerator);
		assertEquals(1, this.frac6.denominator);
		
	}

	@Test
	void testDiv() {
		frac6=this.frac1.div(frac2);// a normal div
		assertEquals(21, this.frac6.numerator);
		assertEquals(8, this.frac6.denominator);
		
		frac6=this.frac4.div(frac5);// the '-' at different place and negative div negative
		assertEquals(1, this.frac6.numerator);
		assertEquals(1, this.frac6.denominator);
		
		frac6=this.frac7.div(frac5);//with 0
		assertEquals(0, this.frac6.numerator);
		assertEquals(1, this.frac6.denominator);
		
	}

	@Test
	void testDecimal() {
		assertEquals(0.0, this.frac7.decimal());//0
		assertEquals(0.5, this.frac3.decimal());//positive
		assertEquals(-0.5, this.frac4.decimal());//negative
		
	}

	@Test
	void testSqr() {
		this.frac1.sqr();//a normal one
		assertEquals(9, this.frac1.numerator);
		assertEquals(16, this.frac1.denominator);
		
		this.frac7.sqr();//0
		assertEquals(0, this.frac7.numerator);
		assertEquals(1, this.frac7.denominator);
		
		this.frac4.sqr();//test if it can reduce to lowest form
		assertEquals(1, this.frac4.numerator);
		assertEquals(4, this.frac4.denominator);
		
	}

	@Test
	void testAverageFraction() {
		
		frac6=this.frac1.average(frac2);//a normal one
		assertEquals(29, this.frac6.numerator);
		assertEquals(56, this.frac6.denominator);
		
		frac6=this.frac1.average(frac4);//positive and negative
		assertEquals(1, this.frac6.numerator);
		assertEquals(8, this.frac6.denominator);
		
		frac6=this.frac5.average(frac4);//'-' at different place
		assertEquals(-1, this.frac6.numerator);
		assertEquals(2, this.frac6.denominator);
	}

	@Test
	void testAverageFractionArray() {
		Fraction a[]= {frac1,frac2};//with 2 elements
		frac6=frac1.average(a);
		assertEquals(29, frac6.numerator);
		assertEquals(56, frac6.denominator);
		
		Fraction b[]= {};//empty
		frac6=frac1.average(b);
		assertEquals(0, frac6.numerator);
		assertEquals(1, frac6.denominator);
		
		Fraction c[]= {frac4,frac5,frac3};//with 3 elements
		frac6=frac1.average(c);
		assertEquals(-1, frac6.numerator);
		assertEquals(6, frac6.denominator);
		
	}

	@Test
	void testAverageIntArray() {
		frac6=this.frac1.average(array1);//a normal positive
		assertEquals(5, this.frac6.numerator);
		assertEquals(2, this.frac6.denominator);
		
		frac6=this.frac1.average(array2);//empty
		assertEquals(0, this.frac6.numerator);
		assertEquals(1, this.frac6.denominator);
		
		frac6=this.frac1.average(array3);//with negative value
		assertEquals(2, this.frac6.numerator);
		assertEquals(3, this.frac6.denominator);
		
	}

	@Test
	void testToString() {
		assertEquals("3/4", this.frac1.toString());//3/4
		assertEquals("1/2", this.frac3.toString());//2/4
		assertEquals("0/1", this.frac7.toString());//0
		assertEquals("-1/2", this.frac5.toString());//-2/4
		
	}

}
