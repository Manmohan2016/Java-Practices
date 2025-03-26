import java.util.Scanner;

public class reverseString {

	public static void main(String[] args) {
		
		//String s ="Piyush"
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter ther string :");
		String s = scanner.nextLine();
		String b ="";
		for(int i =s.length()-1; i>=0; i--)
		{
			b += s.charAt(i);
		}
			System.out.println(b);

	}

}
