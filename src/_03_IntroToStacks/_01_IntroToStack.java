package _03_IntroToStacks;

import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class _01_IntroToStack {
	public static void main(String[] args) {
		//1. Create a Stack of Doubles
		//   Don't forget to import the Stack class
		Stack<Double> num = new Stack<Double>();
		//2. Use a loop to push 100 random doubles between 0 and 100 to the Stack.
		Random r = new Random();
		for (int i = 0; i <=100; i++) {
			double r2= r.nextDouble()*100;
			num.push(r2);
		}
		//3. Ask the user to enter in two numbers between 0 and 100, inclusive. 
		String answer= JOptionPane.showInputDialog("Enter in a number between 0 and 100");
		String answer2= JOptionPane.showInputDialog("Enter in another number between 0 and 100");
		double num1 = Double.parseDouble(answer);
		double num2 =  Double.parseDouble(answer2);;
		//4. Pop all the elements off of the Stack. Every time a double is popped that is
		//   between the two numbers entered by the user, print it to the screen.
		double largest =0;
		double lowest = 0;
		System.out.println("Popping elements off stack...");
		
		while(!num.isEmpty()) {
		double x= num.pop();
			
		if(num1<num2) {
			largest = num2;
			lowest = num1;
		}
		else {
			largest = num1;
			lowest = num2;
		}
		
		if(x<largest && x>lowest ) {
			System.out.println("Elements between " + lowest + " and " + largest + ":" + "\n"+ x);
		}
		else {
			System.out.println("not");
		}
		}
		//   EXAMPLE:
		//   NUM 1: 65
		//   NUM 2: 75
		
		//   Popping elements off stack...
		//   Elements between 65 and 75:
		//   66.66876846
		//   74.51651681
		//   70.05110654
		//   69.21350456
		//   71.54506465
		//   66.47984807
		//   74.12121224
	}
}
