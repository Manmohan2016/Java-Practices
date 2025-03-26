import java.util.Scanner;


public class StringBuilder_Reverse {

	public static void main(String[] args) {
		//String s = "Nikhil";
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the String :");
		String s = scanner.nextLine();
		
		StringBuilder sb = new StringBuilder(s);
		System.out.println(sb.reverse().toString());

	}

}
