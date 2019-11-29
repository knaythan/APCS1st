import java.util.Arrays;
/*
  *Nathan Cohn
  *APCSA Period 4
  *1021
  *
  *Uses the split method to fin the filling in a sandwich
*/

/*
Your task Part 0

String.split();

It's a method that acts on a string, <StringName>.split(<sp>);

Where sp is the string where the string splits

And it returns an array

	Example: "I like apples!".split(" ");

	it will split at spaces and return an array of ["I","like","apples!"]

	Example 2: "I really like really red apples!".split("really")

	it will split at the word "really" and return an array of ["I "," like ","red apples!"]

play around with String.split!

What happens if you "I reallyreally likeapples".split("really") ?
*/
/*
Your task Part 1:
	  Write a method that take in a string like
	  
	  "applespineapplesbreadlettucetomatobaconmayohambreadcheese"
	  
	  describing a sandwich.
	  
	  Use String.split to split up the sandwich by the word "bread" and return
	  what's in the middle of
	  
	  the sandwich and ignores what's on the outside
	  
	  What if it's a fancy sandwich with multiple pieces of bread?
*/
 /*
Your task pt 2:
	  Write a method that take in a string like
	  
	  "apples pineapples bread lettuce tomato bacon mayo ham bread cheese"
	  
	  describing a sandwich
	  
	  use String.split to split up the sandwich at the spaces, " ", and return
	  what's in the middle of
	  
	  the sandwich and ignores what's on the outside.
	  
	  Again, what if it's a fancy sandwich with multiple pieces of bread?
*/	  

public class Split {

	public static void main(String[] args) {
		String sandwich = "apples pineapples bread lettuce cheese bread orange grapes blueberries bread mayo cheese lettuce bread cheese";
	}
	
	public static String part1(String sandwich) {
		String[] noBread = sandwich.split("bread");
		noBread[0] = noBread[noBread.length - 1] = "";
		return toString(noBread);
	}
	
	public static String part2(String sandwich) {
		sandwich = toString(sandwich.split(" "));
		return part1(sandwich);
	}
	
	public static String toString(String[] ingreds) {
		String string = "";
		for(String ingred : ingreds) {
			string += ingred;
		}
		return string;
	}
}