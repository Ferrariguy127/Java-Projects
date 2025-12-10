import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Scanner;

public class BlumBlumShub {

    private BigInteger n;
    private BigInteger state;

    // Constructor with optional user-provided seed
    public BlumBlumShub(int bitLength, BigInteger userSeed) {
        // Generate primes p and q such that p ≡ 3 mod 4 and q ≡ 3 mod 4
        BigInteger p = generatePrime(bitLength / 2);
        BigInteger q = generatePrime(bitLength / 2);
        this.n = p.multiply(q);

        // If a valid user seed is provided and coprime with n, use it
        if (userSeed != null && userSeed.gcd(n).equals(BigInteger.ONE)) {
            this.state = userSeed.mod(n); // Ensure state is within [1, n)
        } else {
            System.out.println("Invalid or no seed provided. Using random seed.");
            this.state = generateCoprime(n);
        }

        System.out.println("Using modulus n = " + n);
    }

    private BigInteger generatePrime(int bits) {
        SecureRandom rand = new SecureRandom();
        BigInteger p;
        do {
            p = BigInteger.probablePrime(bits, rand);
        } while (!p.mod(BigInteger.valueOf(4)).equals(BigInteger.valueOf(3)));
        return p;
    }

    private BigInteger generateCoprime(BigInteger n) {
        SecureRandom rand = new SecureRandom();
        BigInteger seed;
        do {
            seed = new BigInteger(n.bitLength(), rand);
        } while (!seed.gcd(n).equals(BigInteger.ONE));
        return seed;
    }

    public int nextBit() {
        state = state.modPow(BigInteger.valueOf(2), n); // state = state^2 mod n
        return state.testBit(0) ? 1 : 0;
    }

    public int nextInt(int bits) {
        int result = 0;
        for (int i = 0; i < bits; i++) {
            result = (result << 1) | nextBit();
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Blum Blum Shub PRNG");
        System.out.print("Enter a custom starting number (or press Enter to use random): ");
        String input = scanner.nextLine();

        BigInteger userSeed = null;
        if (!input.trim().isEmpty()) {
            try {
                userSeed = new BigInteger(input.trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format. Defaulting to random seed.");
            }
        }

        BlumBlumShub bbs = new BlumBlumShub(128, userSeed);
        System.out.println("Generated random number (8 bits): " + bbs.nextInt(8));
    }
}
