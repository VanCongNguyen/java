package assignment1;

/**
 *
 * @author VAN CONG NGUYEN
 */
public class DES {

    public String PermutedChoice1(String data) {
        String result = null;
        if (data != null) {
            char dataChar[] = data.toCharArray();
            String dataOut = "";

            int k = 57, i;

            for (i = 0; i < 28; i++) {
                dataOut += dataChar[k - 1];
                if (k - 8 > 0) {
                    k = k - 8;
                } else {
                    k = k + 57;
                }
            }

            k = 63;
            for (i = 28; i < 52; i++) {
                dataOut += dataChar[k - 1];
                if (k - 8 > 0) {
                    k = k - 8;
                } else {
                    k = k + 55;
                }
            }

            k = 28;
            for (i = 52; i < 56; i++) {
                dataOut += dataChar[k - 1];
                k = k - 8;
            }

            result = dataOut;
        }
        return result;
    }

    public String PermutedChoice2(String data) {
        String result = null;
        if (data != null) {
            char dataChar[] = data.toCharArray();
            String dataOut = "";

            dataOut += dataChar[13];
            dataOut += dataChar[16];
            dataOut += dataChar[10];
            dataOut += dataChar[23];
            dataOut += dataChar[0];
            dataOut += dataChar[4];
            dataOut += dataChar[2];
            dataOut += dataChar[27];
            dataOut += dataChar[14];
            dataOut += dataChar[5];
            dataOut += dataChar[20];
            dataOut += dataChar[9];
            dataOut += dataChar[22];
            dataOut += dataChar[18];
            dataOut += dataChar[11];
            dataOut += dataChar[3];
            dataOut += dataChar[25];
            dataOut += dataChar[7];
            dataOut += dataChar[15];
            dataOut += dataChar[6];
            dataOut += dataChar[26];
            dataOut += dataChar[19];
            dataOut += dataChar[12];
            dataOut += dataChar[1];
            dataOut += dataChar[40];
            dataOut += dataChar[51];
            dataOut += dataChar[30];
            dataOut += dataChar[36];
            dataOut += dataChar[46];
            dataOut += dataChar[54];
            dataOut += dataChar[29];
            dataOut += dataChar[39];
            dataOut += dataChar[50];
            dataOut += dataChar[44];
            dataOut += dataChar[32];
            dataOut += dataChar[47];
            dataOut += dataChar[43];
            dataOut += dataChar[48];
            dataOut += dataChar[38];
            dataOut += dataChar[55];
            dataOut += dataChar[33];
            dataOut += dataChar[52];
            dataOut += dataChar[45];
            dataOut += dataChar[41];
            dataOut += dataChar[49];
            dataOut += dataChar[35];
            dataOut += dataChar[28];
            dataOut += dataChar[31];

            result = dataOut;
        }
        return result;
    }

    public String LeftShift(String data) {
        String result = null;
        if (data != null) {
            char dataChar[] = data.toCharArray();
            String dataOut = "";
            for (int i = 1; i < 28; i++) {
                dataOut += dataChar[i];
            }
            dataOut += dataChar[0];
            for (int j = 29; j < 56; j++) {
                dataOut += dataChar[j];
            }
            dataOut += dataChar[28];
            result = dataOut;
        }
        return result;
    }

    public String KeyDES(String key, int numberKey) {
        String result = null;
        functionShare fun = new functionShare();
        if (key != null && key.length() >= 8 && numberKey >= 1) {
            String keyBinary, keyPC, keyLS = null, K = null;
            if (key.length() > 8) {
                key = key.substring(0, 8); // Lay 8 ki tu dau lam KEY.
            }

            keyBinary = fun.dataStringBinary(key); // Key -> Binary
            keyPC = PermutedChoice1(keyBinary);//(keyBinary); // keyPC = PC1(Key)

            for (int round = 1; round <= numberKey; round++) {
                if (round == 1 || round == 2 || round == 9 || round == 16) {
                    keyLS = LeftShift(keyPC); //LS(key)
                } else {
                    keyLS = LeftShift(keyPC); //LS(key)
                    keyLS = LeftShift(keyLS); //LS(key)
                }
                K = PermutedChoice2(keyLS); // Key1
                keyPC = keyLS;
            }
            result = K;
        }
        return result;
    }

    public String InitialPermutation(String data) {
        String result = null;
        if (data != null && data.length() == 64) {
            char dataChar[] = data.toCharArray();
            String dataOut = "";

            int k = 58, i;
            for (i = 0; i < 32; i++) {
                dataOut += dataChar[k - 1];
                if (k - 8 > 0) {
                    k = k - 8;
                } else {
                    k = k + 58;
                }
            }

            k = 57;
            for (i = 32; i < 64; i++) {
                dataOut += dataChar[k - 1];
                if (k - 8 > 0) {
                    k = k - 8;
                } else {
                    k = k + 58;
                }
            }
            result = dataOut;
        }
        return result;
    }

    public String Expansion(String right) {
        String result = null;
        if (right != null && right.length() == 32) {
            String out = "";
            char dataChar[] = right.toCharArray();

            out += dataChar[31];
            int k = 1;
            for (; k < 6; k++) {
                out += dataChar[k - 1];
            }

            k = 4;
            for (; k < 10; k++) {
                out += dataChar[k - 1];
            }

            k = 8;
            for (; k < 14; k++) {
                out += dataChar[k - 1];
            }

            k = 12;
            for (; k < 18; k++) {
                out += dataChar[k - 1];
            }

            k = 16;
            for (; k < 22; k++) {
                out += dataChar[k - 1];
            }

            k = 20;
            for (; k < 26; k++) {
                out += dataChar[k - 1];
            }

            k = 24;
            for (; k < 30; k++) {
                out += dataChar[k - 1];
            }

            k = 28;
            for (; k < 33; k++) {
                out += dataChar[k - 1];
            }

            out += dataChar[0];
            result = out;
        }
        return result;
    }

    public String sBox(String data, int s[][]) {

        String result = null;
        functionShare fun = new functionShare();

        if (data != null && data.length() == 6) {

            char dataChar[] = data.toCharArray();

            String row = "", col = "";
            row += dataChar[0];
            row += dataChar[5];

            for (int i = 1; i < 5; i++) {
                col += dataChar[i];
            }

            int r, c;
            r = fun.binaryToInteger(row);
            c = fun.binaryToInteger(col);

            String out = Integer.toBinaryString(s[r][c]);

            if (out.length() < 4) {
                String str = "";
                for (int i = 0; i < 4 - out.length(); i++) {
                    str += '0';
                }
                out = str + out;
            }
            result = out;
        }

        return result;
    }

    public String Substitution(String data) {
        String result = null;
        if (data != null && data.length() == 48) {

            int s1[][]
                    = {
                        {14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7},
                        {0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8},
                        {4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0},
                        {15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13}
                    };

            int s2[][]
                    = {
                        {15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10},
                        {3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5},
                        {0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15},
                        {13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9}
                    };

            int s3[][]
                    = {
                        {10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8},
                        {13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1},
                        {13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7},
                        {1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12}
                    };

            int s4[][]
                    = {
                        {7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15},
                        {13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9},
                        {10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4},
                        {3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14}
                    };

            int s5[][]
                    = {
                        {2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9},
                        {14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6},
                        {4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14},
                        {11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3}
                    };

            int s6[][]
                    = {
                        {12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11},
                        {10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8},
                        {9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6},
                        {4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13}
                    };

            int s7[][]
                    = {
                        {4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1},
                        {13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6},
                        {1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2},
                        {6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12}
                    };

            int s8[][]
                    = {
                        {13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7},
                        {1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2},
                        {7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8},
                        {2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11}
                    };

            char dataChar[] = data.toCharArray();
            String block = "", out = "";
            int box = 0;

            for (int i = 0; i < 48; i++) {
                block += dataChar[i];
                if (block.length() == 6) {
                    box++;
                    switch (box) {
                        case 1:
                            out += sBox(block, s1);
                            break;
                        case 2:
                            out += sBox(block, s2);
                            break;
                        case 3:
                            out += sBox(block, s3);
                            break;
                        case 4:
                            out += sBox(block, s4);
                            break;
                        case 5:
                            out += sBox(block, s5);
                            break;
                        case 6:
                            out += sBox(block, s6);
                            break;
                        case 7:
                            out += sBox(block, s7);
                            break;
                        case 8:
                            out += sBox(block, s8);
                            break;
                    }
                    block = "";
                }
            }

            result = out;
        }
        return result;
    }

    public String InverseIP(String data) {
        String result = null;
        if (data != null && data.length() == 64) {
            char dataChar[] = data.toCharArray();
            String out = "";

            int p = 40, q = 8, k1, k2;
            for (int j = 0; j < 8; j++) {
                k1 = p;
                k2 = q;
                for (int i = 0; i < 8; i++) {
                    if (i % 2 == 0) {
                        out += dataChar[k1 - 1];
                        k1 = k1 + 8;
                    } else {
                        out += dataChar[k2 - 1];
                        k2 = k2 + 8;
                    }
                }
                p = p - 1;
                q = q - 1;
            }
            result = out;
        }
        return result;
    }

    public String Permutation(String data) {
        String result = null;
        if (data != null && data.length() == 32) {
            char dataChar[] = data.toCharArray();
            String out = "";

            out += dataChar[15];
            out += dataChar[6];
            out += dataChar[19];
            out += dataChar[20];
            out += dataChar[28];
            out += dataChar[11];
            out += dataChar[27];
            out += dataChar[16];
            out += dataChar[0];
            out += dataChar[14];
            out += dataChar[22];
            out += dataChar[25];
            out += dataChar[4];
            out += dataChar[17];
            out += dataChar[30];
            out += dataChar[9];
            out += dataChar[1];
            out += dataChar[7];
            out += dataChar[23];
            out += dataChar[13];
            out += dataChar[31];
            out += dataChar[26];
            out += dataChar[2];
            out += dataChar[8];
            out += dataChar[18];
            out += dataChar[12];
            out += dataChar[29];
            out += dataChar[5];
            out += dataChar[21];
            out += dataChar[10];
            out += dataChar[3];
            out += dataChar[24];

            result = out;
        }
        return result;
    }

    public String Xor(String data1, String data2) {
        String result = null;
        if (data1 != null && data2 != null && data1.length() == data2.length()) {
            char dataChar1[] = data1.toCharArray();
            char dataChar2[] = data2.toCharArray();
            String out = "";

            for (int i = 0; i < dataChar1.length; i++) {
                if (dataChar1[i] == dataChar2[i]) {
                    out += '0';
                } else {
                    out += '1';
                }
            }
            result = out;
        }
        return result;
    }

    public String LeftBlock(String data) {
        String result = null;
        if (data != null && data.length() == 64) {
            char dataChar[] = data.toCharArray();
            String out = "";
            for (int i = 0; i < 32; i++) {
                out += dataChar[i];
            }
            result = out;
        }
        return result;
    }

    public String RightBlock(String data) {
        String result = null;
        if (data != null && data.length() == 64) {
            char dataChar[] = data.toCharArray();
            String out = "";
            for (int i = 0; i < 32; i++) {
                out += dataChar[i + 32];
            }
            result = out;
        }
        return result;
    }

}
