import java.util.Scanner;

public class PrimeNumber {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Number :");
		int num = scanner.nextInt();
		
		System.out.println(isPrime(num));
		scanner.close();
	}
		
		public static boolean isPrime(int n) {
			if (n == 0 || n == 1) {
				return false;
			}
			if (n == 2) {
				return true;
			}
			
//			for (int i = 2; i <= n / 2; i++) {  //We can check prime to run loop upto half of thwe given number
			
			for(int i=2; i<=Math.sqrt(n); i++) {  //we can also check prime number with square root of given n
				if (n % i == 0) {
					return false;
				}
			}

			return true;		
		

	}

}
