package others;

public class ReverseString {
	public static void main(String[] args) {
		reverseString("SHIVA");
	}
	
	private static void reverseString(String strTestString) {
		System.out.print("The reverse of string '"+strTestString+"' is ");
		for(int i=strTestString.length()-1; i>=0; i--) {
			System.out.print(strTestString.charAt(i));
		}
	}
	
	// Using RECURSION
	int intRecursiveCallIndex;
	private static void reverseStringUsingRecursion(String strTestString) {
		
	}
}
