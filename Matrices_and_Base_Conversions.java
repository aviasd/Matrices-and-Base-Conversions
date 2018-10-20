import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.util.Random;

public class Matrices_and_Base_Conversions {

	// Exercise 1:
	// The method generates random numbers and put them in an one dimensional array
	public static int[] oneDimArrayBuilder(int size) {

		Random rand = new Random();
		int[] randomArray = new int[size]; // This array holds the random numbers
		for (int i = 0; i < size; i++) {
			randomArray[i] = rand.nextInt(128); // The numbers generated are between 0 and 127
		}
		return randomArray;
	}

	// Exercise 2:
	// The method uses the "oneDimArrayBuilder" method to create a two dimensional
	// array with random numbers
	public static int[][] twoDimArrayBuilder(int rows, int columns) {

		int[][] ramdomMatrix = new int[rows][columns]; // This matrix holds the random numbers
		for (int i = 0; i < rows; i++) {
			// The array from "oneDimArrayBuilder" is put into the matrix
			ramdomMatrix[i] = oneDimArrayBuilder(columns);
		}
		return ramdomMatrix;
	}

	// Exercise 3:
	// The method multiply two matrices
	public static int[][] matricesMultiplication(int[][] firstM, int[][] secondM) {

		int[][] multiMatrix = new int[firstM.length][secondM[0].length]; // This matrix holds the product
		// This "if" statement checks whether it is possible to multiply the two
		// matrices
		if (firstM[0].length == secondM.length) {
			for (int i = 0; i < firstM.length; i++) { // A loop on the rows of the first matrix
				for (int j = 0; j < secondM[0].length; j++) { // A loop on the columns of the second matrix
					for (int k = 0; k < firstM[0].length; k++) { // A loop on the place of the numbers to be multiplied
						multiMatrix[i][j] += firstM[i][k] * secondM[k][j];
					}
				}
			}
		} else
			return null;
		return multiMatrix;
	}

	// A method that converts a two dimensional array to string for printing
	public static String matrixToString(int[][] matrix) {

		String strMatrix = "";
		for (int[] i : matrix) {
			for (int j : i) {
				strMatrix += j + "\t";
			}
			strMatrix += "\n";
		}
		return strMatrix;
	}

	// Exercise 5:
	// A method that gets a matrix and return its transposed matrix
	public static int[][] transpose(int[][] matrix) {

		int[][] transMatrix = new int[matrix[0].length][matrix.length]; // This array holds the transposed matrix
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				transMatrix[j][i] = matrix[i][j];
			}
		}
		return transMatrix;
	}

	// Exercise 6.1:
	// A method that gets a number in base 10 and returns the same number in base 2
	public static int decimalToBinary(int decimalNum) {

		int digitsCounter = 0;
		int binaryNum = 0;

		while (decimalNum != 0) {
			// Every digit is put in the proper place in the new number
			binaryNum += (int) (Math.pow(10, digitsCounter) * (decimalNum % 2));
			decimalNum /= 2;
			digitsCounter++;
		}

		return binaryNum;
	}

	// Exercise 6.2:
	// A method that gets a number in base 2 and returns the same number in base 10
	public static int binaryToDecimal(int binNum) {

		int decNum = 0;
		double power = 0;// The power to which the base is raised when multiplying it by the digit
		int digit = 0;
		while (binNum != 0) {
			digit = binNum % 10; // This variable holds one digit of the binary number
			// The digit is being multiplied by 10 to the power of its place in the
			// original number
			decNum += digit * (int) Math.pow(2, power++);
			binNum /= 10;
		}
		return decNum;
	}

	// Exercise 6.3:
	// The method gets a number in base 10 and returns a number in base 16
	public static String decimalToHex(int decNum) {

		String hexNum = "";
		while (decNum != 0) {
			// We use the ASCII table to convert the value to a proper sign. We use the fact
			// that the digits are all one after another and the letters are all one after
			// another to our advantage. If the value is smaller than 10, we add the value
			// of '0' to it, to get the appropriate character. If the value is bigger than
			// 10, we decrease it by 10 and add the value of 'A' to get the appropriate
			// character.
			hexNum = (char) (decNum % 16 > 9 ? (decNum % 16 - 10 + 'A') : decNum % 16 + '0') + hexNum;
			decNum /= 16;
		}
		return hexNum;
	}

	// Exercise 6.4:
	// The method gets a number in base 16 and returns a number in base 10
	public static int hexToDecimal(char[] hexNum) {

		int decNum = 0;
		double power = hexNum.length - 1;
		for (char c : hexNum) {
			// We use the ASCII table to convert every character to its value. If the
			// character is a digit, we take the distance from it to the char '0' as the
			// value (because all the digits are one after another in the table). If the
			// character is a letter, we take the distance from it to the character 'A' and
			// add 10 to get the value (because all the letters are one after another in the
			// table)
			decNum += (c - '0' < 10 ? c - '0' : c - 'A' + 10) * (int) Math.pow(16, power--);
		}
		return decNum;
	}

	// The method generates a random hexadecimal number and returns it as an array
	// of characters
	public static char[] hexGenerator(int size) {

		Random rand = new Random();
		String hexHelper = "0123456789ABCDEF"; // We use this string as a conversion table from base 10 to base 16
		char[] hexNum = new char[size]; // This array holds the hexadecimal number
		for (int i = 0; i < size; i++) {
			if (i == 0) {
				// We make sure that the first character in the number is not '0'
				hexNum[i] = hexHelper.charAt(rand.nextInt(15) + 1);
			} else {
				hexNum[i] = hexHelper.charAt(rand.nextInt(16));
			}
		}
		return hexNum;
	}

	// The method generates a random binary number
	public static int binaryGenerator(int size) {

		Random rand = new Random();
		int binaryNum = 0;
		for (int i = 0; i < size; i++) {
			binaryNum += rand.nextInt(2) * Math.pow(10, i); // Every digit is put in the proper place in the number
		}
		return binaryNum;
	}

	// The method gets an array of integers and returns the same array in an
	// ascending order
	public static int[] arrayInOrder(int[] array) {

		int temp = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = i; j < array.length; j++) {
				if (array[j] < array[i]) {
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		return array;
	}

	// The method gets an ordered array and a number and searches the number in the
	// array with the Binary Search method
	public static String binarySearch(int[] array, int number) {

		int middle = 0, left = 0, right = array.length - 1;
		// The loop runs until we find the number or until we've done searching
		while (left <= right) {
			middle = (left + right) / 2;
			if (array[middle] == number) {
				return Integer.toString(middle);
			} else if (array[middle] < number) {
				left = middle + 1;
			} else {
				right = middle - 1;
			}
		}
		return null;
	}

	// Exercise 8:
	// The method generates an array of the requested size with random numbers,
	// arrange it in an ascending order and let the user choose a number between 1
	// to 127. Then, using the "binarySearch" method it searches the number in
	// the array and returns the place of the number in it (if it is there). the
	// method also converts the number to base 2 and base 16.
	public static void arrayGame() {

		int size = Integer.parseInt(JOptionPane.showInputDialog("Enter the size of the array to be generated:"));
		int[] array = oneDimArrayBuilder(size);
		array = arrayInOrder(array);
		String strArray = "";
		// The loop converts the array from an integer array type to string
		for (int i : array) {
			strArray += i + "   ";
		}
		JOptionPane.showMessageDialog(null, new JTextArea(strArray), "An Array of Random Numbers",
				JOptionPane.PLAIN_MESSAGE);
		int number = Integer.parseInt(JOptionPane.showInputDialog(
				"Enter a number between 1 to 127.\nThe computer will search the array for your number:"));
		String index = binarySearch(array, number);
		// If the number was found, we show the user its place and its value in base 2
		// and base 16. If the number wasn't found, we write a proper message
		JOptionPane.showMessageDialog(null,
				"The number you chose:  " + number + "\n" + (index == null ? "Does not exist in the array."
						: "Is stored in the array and its index is " + index + "\n" + number + " (base 10)  =  "
								+ decimalToBinary(number) + " (base 2)  =  " + decimalToHex(number) + " (base 16)"),
				"Results", JOptionPane.PLAIN_MESSAGE);

	}

	// The user enters the size of two matrices and gets the multiplied matrix of
	// the two. Then, the computer generates an hexadecimal number and a binary
	// number and converts them into decimal numbers. Then, the "arrayGame" method
	// is being activated.
	public static void main(String[] args) {

		// Exercise 4:
		JOptionPane.showMessageDialog(null,
				"Please enter the size of two matrices.\nThe computer will generate two matrices of the requested size"
						+ " and return the multiplied matrix of the two.");
		int rows1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Insert the 1st matrix row number:"));
		int columns1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Insert the 1st matrix column number:"));
		int rows2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Insert the 2nd matrix row number:"));
		int columns2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Insert the 2nd matrix column number:"));
		int[][] matrix1 = twoDimArrayBuilder(rows1, columns1);
		int[][] matrix2 = twoDimArrayBuilder(rows2, columns2);
		int[][] multiMatrix = matricesMultiplication(matrix1, matrix2);
		String strMatrix = "";
		if (multiMatrix != null) {
			strMatrix = matrixToString(multiMatrix); // We convert the matrix to string for printing
			JOptionPane.showMessageDialog(null, new JTextArea(strMatrix), "The Multiplied Matrix",
					JOptionPane.PLAIN_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "The multiplication of this two matrices is not defined.");
		}

		// Exercise 7:
		Random rand = new Random();
		// The size of the random hexadecimal and binary number is between 2 to 6. If we
		// will try to put bigger numbers, we could get a number (in the conversion to
		// base 10), bigger than what "int" capable of holding
		int size = rand.nextInt(5) + 2;
		char[] hexNum = hexGenerator(size);
		int binNum = binaryGenerator(size);
		String hexNumS = new String(hexNum); // Conversion from char array to string
		JOptionPane.showMessageDialog(null,
				hexNumS + " (base 16)   =   " + hexToDecimal(hexNum) + " (base 10)\n" + binNum + " (base 2)   =   "
						+ binaryToDecimal(binNum) + " (base 10)",
				"Random Numbers Conversion", JOptionPane.PLAIN_MESSAGE);

		// Exercise 8:
		arrayGame();
		JOptionPane.showMessageDialog(null, "End Of Program");
	}
}
