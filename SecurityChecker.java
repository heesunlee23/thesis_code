import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class SecurityChecker {
    public static void main(String[] args) {
        try {
            // Generate two different messages
            String message1 = "Jerry";
            String message2 = "Harry";

            // Compute hash values for both messages
            byte[] hash1 = computeHash(message1);
            byte[] hash2 = computeHash(message2);

            // Check if the hash values collide each other
            boolean isCollision = checkCollision(hash1, hash2);

            if (isCollision == true) {
                System.out.println("Collision detected!");
            } else {
                System.out.println("No collision found.");
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private static byte[] computeHash(String message) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-384");
        return md.digest(message.getBytes());
    }

    private static boolean checkCollision(byte[] hash1, byte[] hash2) {
        // check length of two hashes
        if (hash1.length != hash2.length) {
            return false;
        }

        for (int i = 0; i < hash1.length; i++) {
            // It means two hashes collide!
            if (hash1[i] != hash2[i]) {
                return false;
            }
        }
        return true;
    }
}
