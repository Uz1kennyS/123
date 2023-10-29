import java.util.Scanner;

public class PasswordManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请选择功能：");
        System.out.println("1. 加密");
        System.out.println("2. 解密");
        System.out.println("3. 判断密码强度");
        System.out.println("4. 生成密码");
        int choice = scanner.nextInt();
        scanner.nextLine(); // 读取换行符

        switch (choice) {
            case 1:
                System.out.println("请输入要加密的字符串：");
                String plainText = scanner.nextLine();
                String encryptedText = encrypt(plainText);
                System.out.println("加密后的字符串：" + encryptedText);
                break;
            case 2:
                System.out.println("请输入要解密的字符串：");
                String encryptedText2 = scanner.nextLine();
                String decryptedText = decrypt(encryptedText2);
                System.out.println("解密后的字符串：" + decryptedText);
                break;
            case 3:
                System.out.println("请输入要判断强度的密码：");
                String password = scanner.nextLine();
                int strength = checkPasswordStrength(password);
                System.out.println("密码强度：" + strength);
                break;
            case 4:
                System.out.println("生成的密码为：" + generatePassword());
                break;
            default:
                System.out.println("无效的选择");
                break;
        }
    }

    // 加密
    public static String encrypt(String plainText) {
        StringBuilder encryptedText = new StringBuilder();
        int offset = 3;

        for (int i = 0; i < plainText.length(); i++) {
            char c = plainText.charAt(i);
            int ascii = (int) c + i + offset;
            encryptedText.append((char) ascii);
        }

        encryptedText = encryptedText.reverse();
        char firstChar = encryptedText.charAt(0);
        char lastChar = encryptedText.charAt(encryptedText.length() - 1);
        encryptedText.setCharAt(0, lastChar);
        encryptedText.setCharAt(encryptedText.length() - 1, firstChar);

        return encryptedText.toString();
    }

    // 解密
    public static String decrypt(String encryptedText) {
        StringBuilder decryptedText = new StringBuilder(encryptedText);
        char firstChar = decryptedText.charAt(0);
        char lastChar = decryptedText.charAt(decryptedText.length() - 1);
        decryptedText.setCharAt(0, lastChar);
        decryptedText.setCharAt(decryptedText.length() - 1, firstChar);

        decryptedText = decryptedText.reverse();
        int offset = 3;

        for (int i = 0; i < decryptedText.length(); i++) {
            char c = decryptedText.charAt(i);
            int ascii = (int) c - i - offset;
            decryptedText.setCharAt(i, (char) ascii);
        }

        return decryptedText.toString();
    }

    // 判断密码强度
    public static int checkPasswordStrength(String password) {
        int strength = 0;

        if (password.length() >= 8) {
            strength++;
        }

        if (password.matches(".*[a-z]+.*")) {
            strength++;
        }

        if (password.matches(".*[A-Z]+.*")) {
            strength++;
        }

        if (password.matches(".*\\d+.*")) {
            strength++;
        }

        return strength;
    }

    // 生成密码
    public static String generatePassword() {
        String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";

        StringBuilder password = new StringBuilder();
        int length = 8;

        for (int i = 0; i < length; i++) {
            int type = (int) (Math.random() * 3);

            switch (type) {
                case 0:
                    password.append(uppercaseLetters.charAt((int) (Math.random() * uppercaseLetters.length())));
                    break;
                case 1:
                    password.append(lowercaseLetters.charAt((int) (Math.random() * lowercaseLetters.length())));
                    break;
                case 2:
                    password.append(digits.charAt((int) (Math.random() * digits.length())));
                    break;
            }
        }

        return password.toString();
    }
}
 //123
