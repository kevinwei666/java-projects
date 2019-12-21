package hw7;
/**
 * this program is about the fraction calculation 
 * @author weikevin
 *there are two parameters. numerator of the fraction and the denominator of the fraction
 *
 */
public class Fraction {
    //instance variable
	int numerator;
	int denominator;
	//constructor
	/**
	 * create the fraction with numerator and denominator
	 * @param numerator
	 * @param denominator
	 */
	public Fraction(int numerator,int denominator){
		
		this.numerator=numerator;
	    this.denominator=denominator;
		reduceToLowestForm();		
	}
	//methods
	/**
	 * to reduce the fraction to the lowest form
	 */
	public void reduceToLowestForm() {
		
		//if both numerator and denominator are negative, the result to be positive
		if(this.numerator<0&&this.denominator<0) {
			this.numerator=Math.abs(numerator);
			this.denominator=Math.abs(denominator);
		}
		//move the '-' to the numerator
		if(this.numerator>0&&this.denominator<0) {
			this.numerator=-this.numerator;
			this.denominator=Math.abs(denominator);
		}
		//if the numerator=0
		if(this.numerator==0) {
			this.numerator=0;
			this.denominator=1;
		}
		// get the greatest common division by the helper function and 
		//reduce the fraction to the lowest form
		int div=gcd(Math.abs(this.numerator),this.denominator);
		
				this.numerator=this.numerator/div;
				this.denominator=this.denominator/div;
				}
		
	/**
	 * to add two fractions
	 * @param otherFraction
	 * @return
	 */
	public Fraction add(Fraction otherFraction) {
		int newDen=this.denominator*otherFraction.denominator;//get the new den
		int newNum=this.numerator*otherFraction.denominator+otherFraction.numerator*this.denominator;//get the new num
		//return the result
		return new Fraction ( newNum,  newDen);
	}
	/**
	 * to subtract two fractions
	 * @param otherFraction
	 * @return
	 */
	public Fraction subtract(Fraction otherFraction) {
		int newDen=this.denominator*otherFraction.denominator;//get the new den
		int newNum=this.numerator*otherFraction.denominator-otherFraction.numerator*this.denominator;//get the new num
		//return the result
		return new Fraction ( newNum,  newDen);
	}
	/**
	 * to multiple two fractions
	 * @param otherFraction
	 * @return
	 */
	public Fraction mul(Fraction otherFraction) {
		int newDen=this.denominator*otherFraction.denominator;//get the new den
		int newNum=this.numerator*otherFraction.numerator;//get the new num
		//return the result
		return new Fraction ( newNum,  newDen);
	}
	/**
	 * to div two factions
	 * @param otherFraction
	 * @return
	 */
	public Fraction div(Fraction otherFraction) {
		int newDen=this.denominator*otherFraction.numerator;//get the new den
		int newNum=this.numerator*otherFraction.denominator;//get the new num
		new Fraction ( newNum,  newDen).reduceToLowestForm();
		//return the result
		return new Fraction ( newNum,  newDen);
	}
	/**
	 * covert a fraction to a decimal form
	 * @return
	 */
	public double decimal() {
		//return the result
		return (double)this.numerator/this.denominator;
	}
	/**
	 * square a fraction
	 */
	public void sqr() {
		this.denominator=this.denominator*this.denominator;//get the new den
		this.numerator=this.numerator*this.numerator;//get the new num
		
	}
	/**
	 * calculate the average value of two fractions
	 * @param otherFraction
	 * @return
	 */
	public Fraction average(Fraction otherFraction) {
		int newDen=2*this.denominator*otherFraction.denominator;//get the new den
		int newNum=this.numerator*otherFraction.denominator+otherFraction.numerator*this.denominator;//get the new num
		new Fraction ( newNum,  newDen).reduceToLowestForm();
		//return the result
		return new Fraction ( newNum,  newDen);
	}
	/**
	 * to calculate the average value of a array of fractions
	 * @param fractions
	 * @return
	 */
	public Fraction average(Fraction[]fractions) {
		int i;
		Fraction sum= new Fraction (0,1); 
		if(fractions.length!=0) {
        	for(i=0;i<fractions.length;++i) {
             sum=sum.add(fractions[i]);	
		}
        	sum.denominator=sum.denominator*fractions.length;	//get the new den
		}
        	//return the result
		return sum;
		}
	/**
	 * to  calculate the average of a list of integer
	 * @param ints
	 * @return
	 */
	public Fraction average(int[] ints) {
		int q;
		int sum=0;
		int newNum=0;
		int newDen=0;
		//if the array is not empty
		if (ints.length!=0) {
			for(q=0;q<ints.length;++q) {
				sum+=ints[q];
			}
			newNum=sum;
			newDen=ints.length;
		}
		//if the array is not empty
		if (ints.length==0) {
			newNum=0;
			newDen=1;	
		}
		//return the result
		return new Fraction(newNum, newDen);
		
			
		
	}
	/**
	 * to convert a fraction to string form
	 */
	public String toString() {
		return this.numerator+"/"+this.denominator;
	}
	/**
	 * to get the gcd of two integer
	 * @param a the integer1
	 * @param b the integer2
	 * @return
	 */
	public static int gcd(int a, int b) {
		int t;
		//set the loop
		while(b!=0) {
			t=a;
			a=b;
			b=t%b;
		}
		//return the result
		return a;
	}
	
}
