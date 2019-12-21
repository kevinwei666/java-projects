package hw6;
import java.util.Scanner;//import the scanner
/**
 * the hw of cit590 there are 5 mini program in this homework
 * greeting
 * adding machine
 * odd or even
 * prime or composite
 * word count
 * @author weikevin
 */
public class HelloWorld {

	public static void main(String[] args) {
		
		//print the hello world
		/*
		 * the printing of helloworld expression
		 */
		System.out.println("Hello,World!");
		
		//greeting 
		/*
		 * greeting part of homework
		 * fullname from the typing of the users
		 * return the first name and determine if the blank space is typed
		 */
		String fullName;
		Scanner scanner = new Scanner(System.in); 
		System.out.println("Please enter your full name : ");
		fullName=scanner.nextLine();
		String[] arr=fullName.split(" ");
		//if the user do not input with blank space
		if (arr.length<2)
		{
			System.out.println("error input");
		}
        //say hello
		if (arr.length>=2) {
			System.out.println("hello,"+arr[0]);
		}
		
		
		System.out.println("------------------------ \n");
		
		//Adding machine
		/*
		 * get the sum of the numbers from the input
		 * input the q to exit
		 * numbers is the value of inputing
		 */
	   // initial the variables
	   String numbers;
	   double sum=0.0;
	   System.out.println("adding machine\n");
	   while (0<1) {
		   
		System.out.println("please enter an number(enter q to exit)");
		numbers = scanner.nextLine();
		//if the input is q to exit
		if(numbers.equals("q")) {
			break;}
		  sum+=Double.valueOf(numbers);
		  System.out.println("the sum is"+sum);
		}
	   System.out.println("------------------------ \n");
		
		
		//Even or odd
	   /*
	    * determine if the number is odd or even
	    * get the number from users
	    *  return the odd or even
	    */
	   System.out.println("even or odd\n");
		int num;
		System.out.println("please enter an intger");
		num = scanner.nextInt();
		if (num%2==0)
		{
			System.out.println("the"+num+" is an even number");
		}
		if (num%2!=0)
		{
			System.out.println("the"+num+" is an odd number");
		}
		System.out.println("------------------------ \n");
		
		
		//Prime or Composite
		/*
		 * determine if the number is prime or composite
		 *  the temp is the reminder 
		 *  the num is the number
		 */
		System.out.println("prime or composite\n");
		int temp;
		boolean isPrime=true;
		
		System.out.println("Enter any number:");
		//capture the input in an integer
		int nums=scanner.nextInt();
		if (nums==1) {
			System.out.println("1");
		}
		if (nums==2) {
			System.out.println("2 is prime");
		}
		//if the number is larger than 2
		if(nums!=1 && nums!=2) {
	       
		for(int i=2;i<=nums/2;i++)
		{
	           temp=nums%i;
		   if(temp==0)
		   {
		      isPrime=false;//it is composite number
		      break;
		   }
		}
		//If isPrime is true then the number is prime else not
		if(isPrime)
		   System.out.println(nums + " is Prime ");
		else
		   System.out.println(nums + " is  composite ");
	   }
		
		System.out.println("------------------------ \n");
		
		
		//word count
		/*let the user input the sentence
		 * to count the word in a sentence
		 * return the number of words
		 */
		System.out.println("word count\n");
		String sentence;
		System.out.println("Please enter a sentence : ");
		//input the sentence
		Scanner scannerq = new Scanner(System.in); 
		sentence=scannerq.nextLine();
		System.out.println(sentence);
		//get the length of the sentence
		String[] arra=sentence.split(" ");
		System.out.println("the word in this sentence is:"+arra.length);	
		scannerq.close();//close the scanner
		scanner.close();//close the scanner

	}

}
