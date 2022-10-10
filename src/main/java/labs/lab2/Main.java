package labs.lab2;

import java.util.Scanner;

public class Main {

	/**
	 * Reads a number between 1,000 and 999,999 from the user and prints it with a 
	 * comma separating the thousands.
	 * 
	 * @param in the Scanner to be used for user input
	 * 
	 *           To run this method using the keyboard for user input, call it like
	 *           this: problem2_printWithCommas(new Scanner(System.in));
	 */
	public static void problem2_printWithCommas(Scanner in) {
		// FILL IN
		String processNum = in.next();
		int commaIndex = processNum.length()-3;

		String backHalf = processNum.substring(commaIndex);
		String frontHalf = processNum.substring(0, commaIndex);

		System.out.print("Please enter an integer between 1000 and 999999: ");
		System.out.print(frontHalf + "," + backHalf);

	}
	
	
	/**
	 * Computes the total of a sticker order based on the price per sticker and number
	 * of stickers, which are prompted for from the user
	 * 
	 * @param in the Scanner to be used for user input
	 * 
	 *           To run this method using the keyboard for user input, call it like
	 *           this: problem3_calculateTotal(new Scanner(System.in));
	 */
	public static void problem3_calculateTotal(Scanner in) {
		// FILL IN
		double price = Double.parseDouble(in.next());
		int stickers = Integer.parseInt(in.next());

		System.out.print(String.format("Enter price per sticker: "));
		System.out.print(String.format("Enter the number of stickers: ", stickers));
		double subtotal = stickers * price;
		double total = subtotal + (subtotal * 0.10) + (stickers * 0.15);
		System.out.print(String.format("Your total is: $%.2f", total));
	}
	
	
	/**
	 * Computes the total of a sticker order based on the price per sticker and number
	 * of stickers, which are prompted for from the user
	 * 
	 * @param in the Scanner to be used for user input
	 * 
	 *           To run this method using the keyboard for user input, call it like
	 *           this: problemr_compoundInterest(new Scanner(System.in));
	 */
	public static void problem4_compoundInterest(Scanner in) {
		// p = principal
		double p = Double.parseDouble(in.next());

		// r = interest
		double r = Double.parseDouble(in.next());

		// t = years
		int t = Integer.parseInt(in.next());

		// n = times compounded/year
		int n = Integer.parseInt(in.next());

		double exponent = n * t;
		double paranthesis = 1 + (r * 0.01)/n;
		double total = p * Math.pow(paranthesis, exponent);

		System.out.print("Enter principal amount: ");
		System.out.print("Enter the annual rate of interest: ");
		System.out.print("Enter the number of years the amount is invested: ");
		System.out.print("Enter the number of times the interest is compounded per year: ");
		System.out.print(String.format("$%.2f invested at ", p) + Double.toString(r) + "% for " + Integer.toString(t) + " years compounded " + Integer.toString(n) + " times annually is $" + String.format("%.2f", total) + ".");
	}
	
	
	/**
	 * Computes the number of months it will take to pay off a credit card balance, based
	 * on the balance, APR, and monthly payment which are prompted for from the user
	 * 
	 * @param in the Scanner to be used for user input
	 * 
	 *           To run this method using the keyboard for user input, call it like
	 *           this: problem5_creditCardPayoff(new Scanner(System.in));
	 */
	public static void problem5_creditCardPayoff(Scanner in) {
		// FILL IN
		double balance = Double.parseDouble(in.next());
		double APR = Double.parseDouble(in.next())*.01/365;
		double monthlyPayment = Double.parseDouble(in.next());

		double numeratorCalc = 1 + ((balance/monthlyPayment) * (1 - Math.pow((1+APR), 30)));
		double numerator = Math.log(numeratorCalc);
		double denominator = Math.log1p(APR);

		double right = numerator/denominator;
		double left = -1.0/30.0;

		double months = right * left;

		if (months%1 != 0) {
			months = (int)Math.ceil(months);
		} else {
			months = (int) months;
		}

	 System.out.print(String.format("What is your balance? What is the APR on the card? What is the monthly payment you can make? It will take you %.0f months to pay off this card.", months));

	}
	
	
	/**
	 * Walk the user through troubleshooting issues with a car.
	 * 
	 * @param in the Scanner to be used for user input
	 * 
	 *           To run this method using the keyboard for user input, call it like
	 *           this: problem6_troubleshootCarIssues(new Scanner(System.in));
	 */
	public static void problem6_troubleshootCarIssues(Scanner in) {
		// FILL IN
		String firstResponse = in.next();

		System.out.print("Is the car silent when you turn the key? ");
		if (firstResponse.charAt(0) == 'y'| firstResponse.charAt(0) == 'Y') {
			System.out.print("Are the battery terminals corroded? ");

			String secondResponse = in.next();

			if (secondResponse.charAt(0) == 'y'| secondResponse.charAt(0) == 'Y') {
				System.out.print("Clean terminals and try starting again");
			} else if (secondResponse.charAt(0) == 'n' | secondResponse.charAt(0) == 'N') {
				System.out.print("Replace cables and try again.");
			} else {
				System.out.print("Invalid input. Exiting.");
			}

		} else if (firstResponse.charAt(0) == 'n' | firstResponse.charAt(0) =='N') {

			System.out.print("Does the car make a clicking noise? ");

			String secondResponse = in.next();

			if (secondResponse.charAt(0) == 'y' | secondResponse.charAt(0) =='Y') {
				System.out.print("Replace the battery");
			} else if (secondResponse.charAt(0) == 'n' | secondResponse.charAt(0) == 'N') {
				System.out.print("Does the car crank up but fail to start? ");

				String thirdResponse = in.next();

				if (thirdResponse.charAt(0) == 'y' | thirdResponse.charAt(0) == 'Y') {
					System.out.print("Check spark plug connections.");
				} else if (thirdResponse.charAt(0) == 'n' | thirdResponse.charAt(0) == 'N') {
					System.out.print("Does the engine start and then die? ");

					String fourthResponse = in.next();

					if (fourthResponse.charAt(0) == 'y' | fourthResponse.charAt(0) ==  'Y') {
						System.out.print("Does your car have fuel injection? ");

						String fifthResponse = in.next();

						if (fifthResponse.charAt(0) == 'y' | fifthResponse.charAt(0) ==  'Y') {
							System.out.print("Get it in for service.");
						} else if (fifthResponse.charAt(0) == 'n' | fifthResponse.charAt(0) ==  'N') {
							System.out.print("Check to ensure the choke is opening and closing.");
						} else {
							System.out.print("Invalid input. Exiting.");
						}


					} else if (fourthResponse.charAt(0) == 'n' | fourthResponse.charAt(0) ==  'N') {
						System.out.print("Get it in for service.");
						
					} else {
						System.out.print("Invalid input. Exiting.");
					}
				} else {
					System.out.print("Invalid input. Exiting.");
				}
			} else {
				System.out.print("Invalid input. Exiting.");
			}
		} else {
			System.out.print("Invalid input. Exiting.");
		}
	}
	
	
	/**
	 * Assesses the strength of a password based on these rules:
	 * 
	 * * A very weak password contains only digits and is fewer than eight characters
	 * * A weak password contains only letters and is fewer than eight characters
	 * * A strong password contains at least one letter and at least one digit and is at least
	 * eight characters
	 * * A very strong password contains at least one letter, at least one digit, and at least
	 * one special character (non letter or digit) and is at least eight characters
	 * * All other passwords are medium strength
	 * 
	 * @param password	the password to assess
	 * @return	a string describing its strength
	 */
	public static String problem7_assessPasswordStrength(String password) {
		
		if (password.length() < 8) {
			if (password.matches("[0-9]+")) {
				return "very weak";
			} else if (password.matches("[a-zA-Z]+")) {
				return "weak";
			} else {
				return "medium";
			}
		} else if (password.length() >= 8) {
			if (password.matches("[0-9 ]+")) {
				return "medium";
			}
			if (password.matches("[a-zA-Z ]+")) {
				return "medium";
			}

			if (password.matches("[0-9a-zA-Z]+")) {
				return "strong";
			} else if (password.matches("[0-9a-zA-Z!@#&()[{ }]:;',?/*~$^+=<>-]+")) {
				return "very strong";
			} else {
				return "medium";
			}
		}
		return "medium";
	}
	
	
	/**
	 * Translates a letter grade into a numeric grade
	 * 
	 * @param letterGrade	the letter grade to translate
	 * @return	the numeric grade
	 */
	public static double problem8_getNumericGrade(String letterGrade) {

		double base_grade = 0;
		char letter = letterGrade.charAt(0);

		if (letter == 'A' | letter =='a') {
			base_grade = 4.0;
		} else if (letter == 'B' | letter == 'b') {
			base_grade = 3.0;
		} else if (letter == 'C' | letter == 'c') {
			base_grade = 2.0;
		} else if (letter == 'D' | letter == 'd') {
			base_grade = 1.0;
		} else if (letter == 'F' | letter == 'f') {
			base_grade = 0.0;
		} else {
			return -1.0;
		}

		if (letterGrade.length() > 1) {
			char suffix = letterGrade.charAt(1);

			if (suffix == '+') {
				if (letter == 'A' | letter =='a') {
					return base_grade;
				}
				base_grade += 0.3;
			} else if (suffix == '-') {
				base_grade -= 0.3;
			}
		} 

		return base_grade;
		
	}

	
	/**
	 * Translates a numeric grade into a letter grade
	 * 
	 * @param numericGrade	the numeric grade to translate
	 * 
	 * @return	the letter grade
	 */
	public static String problem8_getLetterGrade(double numericGrade) {

		if (numericGrade ==4.0) {
			return "A+";
		} else if (3.85 <= numericGrade && numericGrade <= 4.0) {
			return "A";
		} else if (3.50 <= numericGrade && numericGrade < 3.85) {
			return "A-";
		} else if (3.15 <= numericGrade && numericGrade < 3.50) {
			return "B+";
		} else if (2.85 <= numericGrade && numericGrade < 3.15) {
			return "B";
		} else if (2.50 <= numericGrade && numericGrade < 2.85) {
			return "B-";
		} else if (2.15 <= numericGrade && numericGrade < 2.50) {
			return "C+";
		} else if (1.85 <= numericGrade && numericGrade < 2.15) {
			return "C";
		} else if (1.50 <= numericGrade && numericGrade < 1.85) {
			return "C-";
		} else if (1.15 <= numericGrade && numericGrade < 1.50) {
			return "D+";
		} else if (0.85 <= numericGrade && numericGrade < 1.15) {
			return "D";
		} else if (0.50 <= numericGrade && numericGrade < 0.85) {
			return "D-";
		} else if (0 <= numericGrade && numericGrade < 0.50) {
			return "F";
		} else {
			return "Error"; // FIX ME
		}
		
	}
	
	
	/**
	 * If one or both of the first 2 chars in the given string is the char 'x' 
	 * (lower case only), returns the string without those 'x' chars. Otherwise, 
	 * returns the string unchanged. 
	 * 
	 * @param str	the string to change
	 * 
	 * @return	the changed string
	 */
	public static String problem10_withoutX2(String str) {

		if (str.length() > 1) {
			if (str.charAt(0) == 'x' && str.charAt(1) == 'x') {
				return str.substring(2, str.length());

			} else if (str.charAt(0) == 'x') {
					return str.substring(1, str.length());

			} else if (str.charAt(1) == 'x') {
				return str.charAt(0) + str.substring(2, str.length());

			} else {
				return str; // FIX ME
			}
		} else if (str.length() == 1) {
			if (str.charAt(0) == 'x') {
				return "";
			} else {
				return str;
			}
		} else {
			return str;
		}
	}
}
