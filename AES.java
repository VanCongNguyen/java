package assignment1;

/**
 *
 * @author VAN CONG NGUYEN
 */
public class AES {
    
    AES aes;
    
    private static final int[] w0 = new int[4];
    private static final int[] w1 = new int[4];
    private static final int[] w2 = new int[4];
    private static final int[] w3 = new int[4];
    private static int[] w4 = new int[4];
    private static int[] w5 = new int[4];
    private static int[] w6 = new int[4];
    private static int[] w7 = new int[4];
    private static int[] w8 = new int[4];
    private static int[] w9 = new int[4];
    private static int[] w10 = new int[4];
    private static int[] w11 = new int[4];
    private static int[] w12 = new int[4];
    private static int[] w13 = new int[4];
    private static int[] w14 = new int[4];
    private static int[] w15 = new int[4];
    private static int[] w16 = new int[4];
    private static int[] w17 = new int[4];
    private static int[] w18 = new int[4];
    private static int[] w19 = new int[4];
    private static int[] w20 = new int[4];
    private static int[] w21 = new int[4];
    private static int[] w22 = new int[4];
    private static int[] w23 = new int[4];
    private static int[] w24 = new int[4];
    private static int[] w25 = new int[4];
    private static int[] w26 = new int[4];
    private static int[] w27 = new int[4];
    private static int[] w28 = new int[4];
    private static int[] w29 = new int[4];
    private static int[] w30 = new int[4];
    private static int[] w31 = new int[4];
    private static int[] w32 = new int[4];
    private static int[] w33 = new int[4];
    private static int[] w34 = new int[4];
    private static int[] w35 = new int[4];
    private static int[] w36 = new int[4];
    private static int[] w37 = new int[4];
    private static int[] w38 = new int[4];
    private static int[] w39 = new int[4];
    private static int[] w40 = new int[4];
    private static int[] w41 = new int[4];
    private static int[] w42 = new int[4];
    private static int[] w43 = new int[4];

    private void KeyFirst(int[] key) {
        
        if (key.length == 16) {

            int k = 0;
            for (int i = 0; i < 4; i++) {
                w0[k] = key[i];
                k++;
            }

            k = 0;
            for (int i = 4; i < 8; i++) {
                w1[k] = key[i];
                k++;
            }

            k = 0;
            for (int i = 8; i < 12; i++) {
                w2[k] = key[i];
                k++;
            }

            k = 0;
            for (int i = 12; i < 16; i++) {
                w3[k] = key[i];
                k++;
            }

            int[] x = new int[4];
            int[] y = new int[4];
            int[] r = new int[4];
            int[] z = new int[4];
            int[] w = new int[4];

            w = w3;

            for (int count = 1; count < 11; count++) {
                x = RotWord(w);
                y = SubWord(x);
                r = Rcon(count);
                z = xor(y, r);

                switch (count) {
                    case 1:
                        w4 = xor(w0, z);
                        w5 = xor(w4, w1);
                        w6 = xor(w5, w2);
                        w7 = xor(w6, w3);
                        w = w7;
                        break;
                    case 2:
                        w8 = xor(w4, z);
                        w9 = xor(w8, w5);
                        w10 = xor(w9, w6);
                        w11 = xor(w10, w7);
                        w = w11;
                        break;
                    case 3:
                        w12 = xor(w8, z);
                        w13 = xor(w12, w9);
                        w14 = xor(w13, w10);
                        w15 = xor(w14, w11);
                        w = w15;
                        break;
                    case 4:
                        w16 = xor(w12, z);
                        w17 = xor(w16, w13);
                        w18 = xor(w17, w14);
                        w19 = xor(w18, w15);
                        w = w19;
                        break;
                    case 5:
                        w20 = xor(w16, z);
                        w21 = xor(w20, w17);
                        w22 = xor(w21, w18);
                        w23 = xor(w22, w19);
                        w = w23;
                        break;
                    case 6:
                        w24 = xor(w20, z);
                        w25 = xor(w24, w21);
                        w26 = xor(w25, w22);
                        w27 = xor(w26, w23);
                        w = w27;
                        break;
                    case 7:
                        w28 = xor(w24, z);
                        w29 = xor(w28, w25);
                        w30 = xor(w29, w26);
                        w31 = xor(w30, w27);
                        w = w31;
                        break;
                    case 8:
                        w32 = xor(w28, z);
                        w33 = xor(w32, w29);
                        w34 = xor(w33, w30);
                        w35 = xor(w34, w31);
                        w = w35;
                        break;
                    case 9:
                        w36 = xor(w32, z);
                        w37 = xor(w36, w33);
                        w38 = xor(w37, w34);
                        w39 = xor(w38, w35);
                        w = w39;
                        break;
                    case 10:
                        w40 = xor(w36, z);
                        w41 = xor(w40, w37);
                        w42 = xor(w41, w38);
                        w43 = xor(w42, w39);
                        break;
                }
            }
        }
    }

    private static int[] RotWord(int w[]) {
        int[] result = null;
        if (w.length == 4) {
            int[] out = new int[4];
            for (int i = 1; i < 4; i++) {
                out[i - 1] = w[i];
            }
            out[3] = w[0];
            result = out;
        }
        return result;
    }

    private int[] SubWord(int w[]) {
        
        aes = new AES();
        int[] result = null;
        
        if (w.length == 4) {
            int[][] matrix = new int[1][4];
            System.arraycopy(w, 0, matrix[0], 0, 4);
            int[][] out = new int[1][4];
            out = aes.SubBytes(matrix);
            int[] a = new int[4];
            System.arraycopy(out[0], 0, a, 0, 4);
            result = a;
        }
        return result;
    }

    private static int[] Rcon(int number) {
        int[] result = new int[4];
        switch (number) {
            case 1:
                result[0] = 0x01;
                break;
            case 2:
                result[0] = 0x02;
                break;
            case 3:
                result[0] = 0x04;
                break;
            case 4:
                result[0] = 0x08;
                break;
            case 5:
                result[0] = 0x10;
                break;
            case 6:
                result[0] = 0x20;
                break;
            case 7:
                result[0] = 0x40;
                break;
            case 8:
                result[0] = 0x80;
                break;
            case 9:
                result[0] = 0x1b;
                break;
            case 10:
                result[0] = 0x36;
                break;
        }
        return result;
    }

    private static int[] xor(int y[], int r[]) {
        int[] result = new int[4];
        if (y.length == 4 && r.length == 4) {
            for (int i = 0; i < 4; i++) {
                result[i] = y[i] ^ r[i];
            }
        }
        return result;
    }

    public int[][] InitialMatrix(int data[]) {
        int[][] result = null;
        if (data != null) {
            int matrix[][] = new int[4][4];
            int k = 0;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    matrix[j][i] = data[k];
                    k++;
                }
            }
            result = matrix;
        }
        return result;
    }

    public int[][] AddRoundKey(int data[][], int key[][]) {
        int[][] result = null;
        if (data != null && key != null) {
            int matrix[][] = new int[4][4];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    matrix[i][j] = data[i][j] ^ key[i][j];
                }
            }
            result = matrix;
        }
        return result;
    }

    public int[][] SubBytes(int data[][]) {
        int[][] result = null;
        if (data != null) {
            int sBox[][]
                    = { //0    1     2     3     4     5     6     7     8     9     A     B     C     D     E      F
                        {0x63, 0x7c, 0x77, 0x7b, 0xf2, 0x6b, 0x6f, 0xc5, 0x30, 0x01, 0x67, 0x2b, 0xfe, 0xd7, 0xab, 0x76}, //0
                        {0xca, 0x82, 0xc9, 0x7d, 0xfa, 0x59, 0x47, 0xf0, 0xad, 0xd4, 0xa2, 0xaf, 0x9c, 0xa4, 0x72, 0xc0}, //1
                        {0xb7, 0xfd, 0x93, 0x26, 0x36, 0x3f, 0xf7, 0xcc, 0x34, 0xa5, 0xe5, 0xf1, 0x71, 0xd8, 0x31, 0x15}, //2
                        {0x04, 0xc7, 0x23, 0xc3, 0x18, 0x96, 0x05, 0x9a, 0x07, 0x12, 0x80, 0xe2, 0xeb, 0x27, 0xb2, 0x75}, //3
                        {0x09, 0x83, 0x2c, 0x1a, 0x1b, 0x6e, 0x5a, 0xa0, 0x52, 0x3b, 0xd6, 0xb3, 0x29, 0xe3, 0x2f, 0x84}, //4
                        {0x53, 0xd1, 0x00, 0xed, 0x20, 0xfc, 0xb1, 0x5b, 0x6a, 0xcb, 0xbe, 0x39, 0x4a, 0x4c, 0x58, 0xcf}, //5
                        {0xd0, 0xef, 0xaa, 0xfb, 0x43, 0x4d, 0x33, 0x85, 0x45, 0xf9, 0x02, 0x7f, 0x50, 0x3c, 0x9f, 0xa8}, //6
                        {0x51, 0xa3, 0x40, 0x8f, 0x92, 0x9d, 0x38, 0xf5, 0xbc, 0xb6, 0xda, 0x21, 0x10, 0xff, 0xf3, 0xd2}, //7
                        {0xcd, 0x0c, 0x13, 0xec, 0x5f, 0x97, 0x44, 0x17, 0xc4, 0xa7, 0x7e, 0x3d, 0x64, 0x5d, 0x19, 0x73}, //8
                        {0x60, 0x81, 0x4f, 0xdc, 0x22, 0x2a, 0x90, 0x88, 0x46, 0xee, 0xb8, 0x14, 0xde, 0x5e, 0x0b, 0xdb}, //9
                        {0xe0, 0x32, 0x3a, 0x0a, 0x49, 0x06, 0x24, 0x5c, 0xc2, 0xd3, 0xac, 0x62, 0x91, 0x95, 0xe4, 0x79}, //A
                        {0xe7, 0xc8, 0x37, 0x6d, 0x8d, 0xd5, 0x4e, 0xa9, 0x6c, 0x56, 0xf4, 0xea, 0x65, 0x7a, 0xae, 0x08}, //B
                        {0xba, 0x78, 0x25, 0x2e, 0x1c, 0xa6, 0xb4, 0xc6, 0xe8, 0xdd, 0x74, 0x1f, 0x4b, 0xbd, 0x8b, 0x8a}, //C
                        {0x70, 0x3e, 0xb5, 0x66, 0x48, 0x03, 0xf6, 0x0e, 0x61, 0x35, 0x57, 0xb9, 0x86, 0xc1, 0x1d, 0x9e}, //D
                        {0xe1, 0xf8, 0x98, 0x11, 0x69, 0xd9, 0x8e, 0x94, 0x9b, 0x1e, 0x87, 0xe9, 0xce, 0x55, 0x28, 0xdf}, //E
                        {0x8c, 0xa1, 0x89, 0x0d, 0xbf, 0xe6, 0x42, 0x68, 0x41, 0x99, 0x2d, 0x0f, 0xb0, 0x54, 0xbb, 0x16} //F
                    };

            functionShare fun = new functionShare();

            int sizeR = data.length;
            int sizeC = data[0].length;
            int matrix[][] = new int[sizeR][sizeC];

            for (int i = 0; i < sizeR; i++) {
                for (int j = 0; j < sizeC; j++) {
                    String binary = fun.integerToBinary(data[i][j]);
                    String row = binary.substring(0, 4);
                    String col = binary.substring(4, 8);
                    int r = 0, c = 0;
                    r = fun.binaryToInteger(row);
                    c = fun.binaryToInteger(col);
                    matrix[i][j] = sBox[r][c];
                }
            }
            result = matrix;
        }
        return result;
    }

    public int[][] InverseSubBytes(int data[][]) {
        int[][] result = null;
        if (data != null) {
            int sBox[][]
                    = { //0    1     2     3     4     5     6     7     8     9     A     B     C     D     E      F
                        {0x52, 0x09, 0x6A, 0xD5, 0x30, 0x36, 0xA5, 0x38, 0xBF, 0x40, 0xA3, 0x9E, 0x81, 0xF3, 0xD7, 0xFB}, //0
                        {0x7C, 0xE3, 0x39, 0x82, 0x9B, 0x2F, 0xFF, 0x87, 0x34, 0x8E, 0x43, 0x44, 0xC4, 0xDE, 0xE9, 0xCB}, //1
                        {0x54, 0x7B, 0x94, 0x32, 0xA6, 0xC2, 0x23, 0x3D, 0xEE, 0x4C, 0x95, 0x0B, 0x42, 0xFA, 0xC3, 0x4E}, //2
                        {0x08, 0x2E, 0xA1, 0x66, 0x28, 0xD9, 0x24, 0xB2, 0x76, 0x5B, 0xA2, 0x49, 0x6D, 0x8B, 0xD1, 0x25}, //3
                        {0x72, 0xF8, 0xF6, 0x64, 0x86, 0x68, 0x98, 0x16, 0xD4, 0xA4, 0x5C, 0xCC, 0x5D, 0x65, 0xB6, 0x92}, //4
                        {0x6C, 0x70, 0x48, 0x50, 0xFD, 0xED, 0xB9, 0xDA, 0x5E, 0x15, 0x46, 0x57, 0xA7, 0x8D, 0x9D, 0x84}, //5
                        {0x90, 0xD8, 0xAB, 0x00, 0x8C, 0xBC, 0xD3, 0x0A, 0xF7, 0xE4, 0x58, 0x05, 0xB8, 0xB3, 0x45, 0x06}, //6
                        {0xD0, 0x2C, 0x1E, 0x8F, 0xCA, 0x3F, 0x0F, 0x02, 0xC1, 0xAF, 0xBD, 0x03, 0x01, 0x13, 0x8A, 0x6B}, //7
                        {0x3A, 0x91, 0x11, 0x41, 0x4F, 0x67, 0xDC, 0xEA, 0x97, 0xF2, 0xCF, 0xCE, 0xF0, 0xB4, 0xE6, 0x73}, //8
                        {0x96, 0xAC, 0x74, 0x22, 0xE7, 0xAD, 0x35, 0x85, 0xE2, 0xF9, 0x37, 0xE8, 0x1C, 0x75, 0xDF, 0x6E}, //9
                        {0x47, 0xF1, 0x1A, 0x71, 0x1D, 0x29, 0xC5, 0x89, 0x6F, 0xB7, 0x62, 0x0E, 0xAA, 0x18, 0xBE, 0x1B}, //A
                        {0xFC, 0x56, 0x3E, 0x4B, 0xC6, 0xD2, 0x79, 0x20, 0x9A, 0xDB, 0xC0, 0xFE, 0x78, 0xCD, 0x5A, 0xF4}, //B
                        {0x1F, 0xDD, 0xA8, 0x33, 0x88, 0x07, 0xC7, 0x31, 0xB1, 0x12, 0x10, 0x59, 0x27, 0x80, 0xEC, 0x5F}, //C
                        {0x60, 0x51, 0x7F, 0xA9, 0x19, 0xB5, 0x4A, 0x0D, 0x2D, 0xE5, 0x7A, 0x9F, 0x93, 0xC9, 0x9C, 0xEF}, //D
                        {0xA0, 0xE0, 0x3B, 0x4D, 0xAE, 0x2A, 0xF5, 0xB0, 0xC8, 0xEB, 0xBB, 0x3C, 0x83, 0x53, 0x99, 0x61}, //E
                        {0x17, 0x2B, 0x04, 0x7E, 0xBA, 0x77, 0xD6, 0x26, 0xE1, 0x69, 0x14, 0x63, 0x55, 0x21, 0x0C, 0x7D} //F
                    };

            functionShare fun = new functionShare();

            int sizeR = data.length;
            int sizeC = data[0].length;
            int matrix[][] = new int[sizeR][sizeC];

            for (int i = 0; i < sizeR; i++) {
                for (int j = 0; j < sizeC; j++) {
                    String binary = fun.integerToBinary(data[i][j]);
                    String row = binary.substring(0, 4);
                    String col = binary.substring(4, 8);
                    int r = 0, c = 0;
                    r = fun.binaryToInteger(row);
                    c = fun.binaryToInteger(col);
                    matrix[i][j] = sBox[r][c];
                }
            }
            result = matrix;
        }
        return result;
    }

    public int[][] ShiftRows(int data[][]) {
        int[][] result = null;
        if (data != null) {
            int matrix[][] = new int[4][4];
            //row 0
            matrix[0][0] = data[0][0];
            matrix[0][1] = data[0][1];
            matrix[0][2] = data[0][2];
            matrix[0][3] = data[0][3];

            //row 1
            matrix[1][0] = data[1][1];
            matrix[1][1] = data[1][2];
            matrix[1][2] = data[1][3];
            matrix[1][3] = data[1][0];

            //row 2
            matrix[2][0] = data[2][2];
            matrix[2][1] = data[2][3];
            matrix[2][2] = data[2][0];
            matrix[2][3] = data[2][1];

            //row 3
            matrix[3][0] = data[3][3];
            matrix[3][1] = data[3][0];
            matrix[3][2] = data[3][1];
            matrix[3][3] = data[3][2];

            result = matrix;
        }
        return result;
    }

    public int[][] InverseShiftRows(int data[][]) {
        int[][] result = null;
        if (data != null) {
            int matrix[][] = new int[4][4];
            //row 0
            matrix[0][0] = data[0][0];
            matrix[0][1] = data[0][1];
            matrix[0][2] = data[0][2];
            matrix[0][3] = data[0][3];

            //row 1
            matrix[1][0] = data[1][3];
            matrix[1][1] = data[1][0];
            matrix[1][2] = data[1][1];
            matrix[1][3] = data[1][2];

            //row 2
            matrix[2][0] = data[2][2];
            matrix[2][1] = data[2][3];
            matrix[2][2] = data[2][0];
            matrix[2][3] = data[2][1];

            //row 3
            matrix[3][0] = data[3][1];
            matrix[3][1] = data[3][2];
            matrix[3][2] = data[3][3];
            matrix[3][3] = data[3][0];

            result = matrix;
        }
        return result;
    }

    private static int GF(int value1, int value2) {
        int result = 0;
        functionShare fun = new functionShare();
        if (value2 == 0x02) {
            String string1 = fun.integerToBinary(value1);
            char array1[] = string1.toCharArray();
            String string2 = "";
            for (int i = 1; i < array1.length; i++) {
                string2 += array1[i];
            }
            string2 += '0';
            String out = "";
            if (array1[0] == '1') {
                String string3 = fun.integerToBinary(0x1b);
                char data1[] = string2.toCharArray();
                char data2[] = string3.toCharArray();
                for (int i = 0; i < 8; i++) {
                    if (data1[i] == data2[i]) {
                        out += '0';
                    } else {
                        out += '1';
                    }
                }
                result = fun.binaryToInteger(out);
            } else {
                result = fun.binaryToInteger(string2);
            }
        }
        return result;
    }

    private static int GFnine(int value1, int value2) {
        int result = 0;
        if (value2 == 0x09) {
            int x = GF(value1, 0x02); //2x
            int y = GF(x, 0x02);      //4x
            int z = GF(y, 0x02);      //8x
            result = value1 ^ z;      //9x
        }
        return result;
    }

    private static int GFeleven(int value1, int value2) {
        int result = 0;
        if (value2 == 0x0B) {
            int x = GF(value1, 0x02); //2x
            int y = GF(x, 0x02);      //4x
            int z = value1 ^ y;       //5x
            int g = GF(z, 0x02);      //10x
            result = value1 ^ g;      //11x
        }
        return result;
    }

    private static int GFthirteen(int value1, int value2) {
        int result = 0;
        if (value2 == 0x0D) {
            int x = GF(value1, 0x02); //2x
            int y = value1 ^ x;       //3x
            int z = GF(y, 0x02);      //6x
            int g = GF(z, 0x02);      //12x
            result = value1 ^ g;      //13x
        }
        return result;
    }

    private static int GFfourteen(int value1, int value2) {
        int result = 0;
        if (value2 == 0x0E) {
            int x = GF(value1, 0x02); //2x
            int y = value1 ^ x;       //3x
            int z = GF(y, 0x02);      //6x
            int g = value1 ^ z;       //7xx
            result = GF(g, 0x02);     //14x
        }
        return result;
    }

    private static int GFfull(int value1, int value2) {
        int result = 0;
        switch (value2) {
            case 0x01:
                result = value1;
                break;
            case 0x02:
                result = GF(value1, 0x02);
                break;
            case 0x03:
                result = value1 ^ GF(value1, 0x02);
                break;
            case 0x09:
                result = GFnine(value1, 0x09);
                break;
            case 0x0B:
                result = GFeleven(value1, 0x0B);
                break;
            case 0x0D:
                result = GFthirteen(value1, 0x0D);
                break;
            case 0x0E:
                result = GFfourteen(value1, 0x0E);
                break;
        }
        return result;
    }

    public int[][] MixColumns(int data[][]) {
        int result[][] = null;
        if (data != null) {
            int matrix[][] = new int[4][4];

            int p[] = new int[4];
            for (int c = 0; c < 4; c++) {
                p[0] = GFfull(data[0][c], 0x02) ^ GFfull(data[1][c], 0x03) ^ GFfull(data[2][c], 0x01) ^ GFfull(data[3][c], 0x01);
                p[1] = GFfull(data[0][c], 0x01) ^ GFfull(data[1][c], 0x02) ^ GFfull(data[2][c], 0x03) ^ GFfull(data[3][c], 0x01);
                p[2] = GFfull(data[0][c], 0x01) ^ GFfull(data[1][c], 0x01) ^ GFfull(data[2][c], 0x02) ^ GFfull(data[3][c], 0x03);
                p[3] = GFfull(data[0][c], 0x03) ^ GFfull(data[1][c], 0x01) ^ GFfull(data[2][c], 0x01) ^ GFfull(data[3][c], 0x02);
                for (int r = 0; r < 4; r++) {
                    matrix[r][c] = p[r];
                }
            }

            result = matrix;
        }
        return result;
    }

    public int[][] InverseMixColumns(int data[][]) {
        int result[][] = null;
        if (data != null) {
            int matrix[][] = new int[4][4];

            int p[] = new int[4];
            for (int c = 0; c < 4; c++) {
                p[0] = GFfull(data[0][c], 0x0E) ^ GFfull(data[1][c], 0x0B) ^ GFfull(data[2][c], 0x0D) ^ GFfull(data[3][c], 0x09);
                p[1] = GFfull(data[0][c], 0x09) ^ GFfull(data[1][c], 0x0E) ^ GFfull(data[2][c], 0x0B) ^ GFfull(data[3][c], 0x0D);
                p[2] = GFfull(data[0][c], 0x0D) ^ GFfull(data[1][c], 0x09) ^ GFfull(data[2][c], 0x0E) ^ GFfull(data[3][c], 0x0B);
                p[3] = GFfull(data[0][c], 0x0B) ^ GFfull(data[1][c], 0x0D) ^ GFfull(data[2][c], 0x09) ^ GFfull(data[3][c], 0x0E);
                for (int r = 0; r < 4; r++) {
                    matrix[r][c] = p[r];
                }
            }

            result = matrix;
        }
        return result;
    }

    public void KeySecond(String key) {
        if (key != null && key.length() >= 16) {
     
            char arrKey[] = key.toCharArray();
            int intKey[] = new int[16];
            for (int i = 0; i < 16; i++) {
                intKey[i] = (int) arrKey[i];
            }
            KeyFirst(intKey);
        }
    }

    private static int[][] General(int w0[], int w1[], int w2[], int w3[]) {
        int[][] result = new int[4][4];
        if (w0.length == 4 && w1.length == 4 && w2.length == 4 && w3.length == 4) {
            for (int r = 0; r < 4; r++) {
                result[r][0] = w0[r];
            }
            for (int r = 0; r < 4; r++) {
                result[r][1] = w1[r];
            }
            for (int r = 0; r < 4; r++) {
                result[r][2] = w2[r];
            }
            for (int r = 0; r < 4; r++) {
                result[r][3] = w3[r];
            }
        }
        return result;
    }

    public int[][] Keygen(int number) {
        int[][] result = new int[4][4];
        switch (number) {
            case 0:
                result = General(w0, w1, w2, w3);
                break;
            case 1:
                result = General(w4, w5, w6, w7);
                break;
            case 2:
                result = General(w8, w9, w10, w11);
                break;
            case 3:
                result = General(w12, w13, w14, w15);
                break;
            case 4:
                result = General(w16, w17, w18, w19);
                break;
            case 5:
                result = General(w20, w21, w22, w23);
                break;
            case 6:
                result = General(w24, w25, w26, w27);
                break;
            case 7:
                result = General(w28, w29, w30, w31);
                break;
            case 8:
                result = General(w32, w33, w34, w35);
                break;
            case 9:
                result = General(w36, w37, w38, w39);
                break;
            case 10:
                result = General(w40, w41, w42, w43);
                break;
        }
        return result;
    }

}
