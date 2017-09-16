import java.util.Scanner;

public class Caesar {

	private static Scanner input = new Scanner(System.in);
	private static String userText = "";
	private static int secretKey;
	private static final int cipherLen = 72;
	private static final String cipherList = "abcdefghijklmnopqrstuvwxyz" 
											+ "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
											+ " ,.!#$@%&*()-_+=/.':";

	public static String encrypt(String plainText, int secretKey) {
		int keyValue;
		int shiftPosition;
		char replaceVal;
		String cipherText = "";

		for (int i = 0; i < plainText.length(); i++) {
			shiftPosition = cipherList.indexOf(plainText.charAt(i));
			keyValue = (secretKey + shiftPosition) % cipherLen;
			replaceVal = cipherList.charAt(keyValue);
			cipherText += replaceVal;
		}

		return cipherText;
	}

	public static String decrypt(String cipherText, int shiftKey) {
		int keyValue;
		int shiftPosition;
		char replaceVal;
		String plainText = "";

		for (int i = 0; i < cipherText.length(); i++) {
			shiftPosition = cipherList.indexOf(cipherText.charAt(i));
			keyValue = (shiftPosition - shiftKey) % cipherLen;
			if (keyValue < 0) {
				keyValue = cipherList.length() + keyValue;
			}
			replaceVal = cipherList.charAt(keyValue);
			plainText += replaceVal;
		}

		return plainText;
	}

	public static void main(String[] args) {
		System.out.print("Enter a message to encrypt: ");
		userText = input.nextLine();
		System.out.print("Enter a value for the secret key: ");
		secretKey = input.nextInt();
		
		if(secretKey == 72 ) {
			secretKey = (int) Math.random() * 10 + 1;
		}
		
		String encrypted = encrypt(userText, secretKey);
		String decrypted = decrypt(encrypt(userText, secretKey), secretKey);
		System.out.println("plaintext: " + userText);
		System.out.println("cipherText - Encrypted plainText - " + encrypted);
		System.out.println("plainText - Decrypted cipherText - " + decrypted);
		input.close();
	}
}
