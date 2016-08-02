package assignment1;

import java.math.BigInteger;
import java.util.Random;

/**
 *
 * @author VAN CONG NGUYEN
 */
public class RSA {

    public BigInteger p;
    public BigInteger q;
    public BigInteger n;
    public BigInteger phi;
    public BigInteger e;
    public BigInteger d;
    public Random r;
    public int bitlength;

    public RSA(int bitlength) {
        this.bitlength = bitlength;
        r = new Random();
        p = BigInteger.probablePrime(bitlength, r); // p random
        q = BigInteger.probablePrime(bitlength, r); // q random
        n = p.multiply(q); // n = p*q
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE)); // phi = (p - 1)*(q - 1)
        e = BigInteger.probablePrime(bitlength / 2, r); // e random : gcd(e, phi(n)) = 1

        while (phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0) {
            e.add(BigInteger.ONE);
        }

        d = e.modInverse(phi);
    }

    public RSA(BigInteger n, BigInteger e, BigInteger d) {
        this.n = n;
        this.e = e;
        this.d = d;
    }

    public byte[] Encrypt(byte[] data) {
        return (new BigInteger(data)).modPow(e, n).toByteArray();
    }

    public byte[] Decrypt(byte[] data) {
        return (new BigInteger(data)).modPow(d, n).toByteArray();
    }

    public byte[] En(byte[] data, int bitlength) {
        byte[] result = null;

        int block = bitlength / 8;
        int blockEn = bitlength / 4;

        int lenght = 1024;
        if (data.length % block != 0) {
            lenght = blockEn * (data.length / block) + blockEn;
        } else {
            lenght = blockEn * (data.length / block);
        }

        byte[] encrypt = new byte[lenght];
        int c = 0, k = 0, h = 0;
        RSA rsa = new RSA(bitlength);

        if (data.length >= block) {

            byte[] dataEn3 = new byte[data.length % block];
            byte[] dataEn1 = new byte[block];

            for (int i = 0; i < data.length; i++) {

                dataEn1[k] = data[i];
                k++;

                if (k == block) {
                    k = 0;
                    byte[] dataEn2 = new byte[blockEn];
                    dataEn2 = rsa.Encrypt(dataEn1);
                    for (int j = 0; j < dataEn2.length; j++) {
                        encrypt[c] = dataEn2[j];
                        c++;
                    }
                }
            }

            if (data.length % block != 0) {
                for (int l = 0; l < data.length % block; l++) {
                    dataEn3[h] = dataEn1[l];
                    h++;
                }

                byte[] dataEn4 = new byte[blockEn];
                dataEn4 = rsa.Encrypt(dataEn3);
                for (int j = 0; j < dataEn4.length; j++) {
                    encrypt[c] = dataEn4[j];
                    c++;
                }
            }

            result = encrypt;
        } else {
            result = rsa.Encrypt(data);
        }

        return result;
    }
    
    public byte[] De(byte[] data, int bitlength) {
        byte[] result = null;

        int block = bitlength / 8;
        int blockEn = bitlength / 4;

        int lenght = 1024;
        if (data.length % block != 0) {
            lenght = blockEn * (data.length / block) + blockEn;
        } else {
            lenght = blockEn * (data.length / block);
        }

        byte[] decrypt = new byte[lenght];
        int c = 0, k = 0, h = 0;
        RSA rsa = new RSA(bitlength);

        if (data.length >= block) {

            byte[] dataEn3 = new byte[data.length % block];
            byte[] dataEn1 = new byte[block];

            for (int i = 0; i < data.length; i++) {

                dataEn1[k] = data[i];
                k++;

                if (k == block) {
                    k = 0;
                    byte[] dataEn2 = new byte[blockEn];
                    dataEn2 = rsa.Encrypt(dataEn1);
                    for (int j = 0; j < dataEn2.length; j++) {
                        decrypt[c] = dataEn2[j];
                        c++;
                    }
                }
            }

            if (data.length % block != 0) {
                for (int l = 0; l < data.length % block; l++) {
                    dataEn3[h] = dataEn1[l];
                    h++;
                }

                byte[] dataEn4 = new byte[blockEn];
                dataEn4 = rsa.Encrypt(dataEn3);
                for (int j = 0; j < dataEn4.length; j++) {
                    decrypt[c] = dataEn4[j];
                    c++;
                }
            }

            result = decrypt;
        } else {
            result = rsa.Encrypt(data);
        }

        return result;
    }

    public static void main(String[] args) {

        RSA rsa = new RSA(128);

        byte[] data = {1, 127, 2, 3, 78, -45, -1, 2, 3, 6, -123, 78, -45, -1, 2, 3, 78, -45, -1, 2, 3, 78, -45, -1, 2, 3, 78, -45,
            -1, 2, 3, 78, -123};//, 2, 3, 78, -45, -1, 2, 3, 78, -45, -1, 2, 3, 78, -45, -1, 2, 3, 78, -45, -1, 2, 3}; //,
            /*78, -45, -1, 2, 3, 78, -45, -1, 2, 3, 78, -45, -1, 2, 3, 78, -45, -1, 2, 3, 78, -45, -1, 2, 3, 78, -45,
         -1, 2, 3, 78, -45, -1, 2, 3, 78, -45, -1, 2, 3, 78, -45, -1, 2, 3, 78, -45, -1, 2, 3, 78, -45, -1, 2, 3,
         78, -45, -1, 2, 3, 78, -45, -1, 2, 3, 78, -45, -1, 2, 3, 78, -45, -1, 2, 3, 78, -45, -1, 2, 3, 78, -45,
         -1, 2, 3, 78, -45, -1, 2, 3, 78, -45, -1, 2, 3, 78, -45, -1, 2, 3, 78, -45, -1, 2, 3, 78, -45,
         -1, 2, 3, 78, -45, -1, 2, 3, 78, -45, -1, 2, 3, 78, -45, -1, 2, 3, 78, -45, -1, 2, 3, 78, -45
         - 1, 2, 3, 78, -45, -1, 2, 3, 78, -45, -1, 2, 3, 78, -45, -1, 2, 3, 78, -45, -1, 2, 3, 78, -45,
         -1, 2, 3, 78, -45, -1, 2, 3, 78, -45, -1, 2, 3, 78, -45, -1, 2, 3, 78, -45, -1, 2, 3, 78, -45,
         127, 2, 3, 78, -45, -1, 2, 3, 78, -45, -1, 2, 3, 78, -45, -1, 2, 3, 78, -45, -128, 0};*/

        System.out.println(data.length);

        byte[] encrypt = rsa.En(data, 128);
        for (int i = 0; i < encrypt.length; i++) {
            System.out.print(encrypt[i] + " ");
        }
        System.out.println("");
        System.out.println(encrypt.length);

        /*System.out.println("M : " + new BigInteger(data));
         System.out.println("n : " + rsa.n);
         System.out.println("");

         byte[] encrypt = rsa.Encrypt(data);
         for (int i = 0; i < encrypt.length; i++) {
         System.out.print(encrypt[i] + " ");
         }
         System.out.println("");
         System.out.println(encrypt.length);

         System.out.println("");

         byte[] decrypt = rsa.Decrypt(encrypt);
         for (int i = 0; i < decrypt.length; i++) {
         System.out.print(decrypt[i] + " ");
         }
         System.out.println("");
         System.out.println(decrypt.length);
         System.out.println("");*/
    }
}
