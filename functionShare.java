package assignment1;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import javax.swing.JOptionPane;

/**
 *
 * @author VAN CONG NGUYEN
 */
public class functionShare {

    public int byteToInteger(byte data) {
        return (int) data & 0xff;
    }

    public byte integerToByte(int value) {
        return (byte) (value & 0xff);
    }

    public String integerToBinary(int value) {
        String result = Integer.toBinaryString(value);
        if (result.length() < 8) {
            String a = "";
            for (int i = 0; i < 8 - result.length(); i++) {
                a += '0';
            }
            result = a + result;
        }
        return result;
    }

    public int binaryToInteger(String data) {
        int result = 0;
        if (data != null) {
            char dataChar[] = data.toCharArray();
            for (int i = 0; i < dataChar.length; i++) {
                int zeroOrOne = 0;
                if (dataChar[i] == '1') {
                    zeroOrOne = 1;
                }
                result += zeroOrOne * Math.pow(2, dataChar.length - 1 - i);
            }
        }
        return result;
    }

    public String byteToBinary(byte data) {
        int number = byteToInteger(data);
        String binary = integerToBinary(number);
        return binary;
    }

    public byte binaryToByte(String data) {
        int number = binaryToInteger(data);
        byte Byte = integerToByte(number);
        return Byte;
    }

    public String dataStringBinary(String data) {
        String result = null;
        if (data != null) {
            char dataChar[] = data.toCharArray();

            String dataBinary = "";
            for (int i = 0; i < dataChar.length; i++) {
                String eight = Integer.toBinaryString((int) dataChar[i]);
                if (eight.length() < 8) {
                    String b = "";
                    for (int j = 0; j < 8 - eight.length(); j++) {
                        b += '0';
                    }
                    eight = b + eight;
                }
                dataBinary += eight;
            }
            result = dataBinary;
        }
        return result;
    }

    public boolean writeByteFile(String fileName, byte data[]) {
        File file = new File(fileName);
        if (!file.canWrite()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null,
                        "Unable to create file " + file.getName() + " for writing.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        try {
            try (FileOutputStream fos = new FileOutputStream(file)) {
                fos.write(data);
                fos.close();
            }
            return true;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Unable to write to file " + file.getName(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public byte[] readByteFile(File file) {
        byte data[] = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            int c, i = 0;
            data = new byte[(int) file.length()];
            while ((c = fis.read()) != -1) {
                data[i++] = (byte) c;
            }
            fis.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    file.getName() + " not found or cannot be read.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return data;
    }

    public String hashcode(String dataFile) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");// SHA1, MD5, ...
        String hash;
        try (FileInputStream fis = new FileInputStream(dataFile)) {
            byte[] dataBytes = new byte[1048576];
            int nRead = 0;
            while ((nRead = fis.read(dataBytes)) != -1) {
                md.update(dataBytes, 0, nRead);
            }
            byte[] mdBytes = md.digest();
            // convert the byte to hex format
            hash = "";
            for (int i = 0; i < mdBytes.length; i++) {
                hash += Integer.toString((mdBytes[i] & 0xff) + 0x100, 16)
                        .substring(1);
            }
        }
        return hash;
    }
    
    public byte[] updatePaddingPKCS5(byte data[], String type) {

        byte result[] = null;

        if (data != null) {
            
            int size = 8;
            
            if(null != type)switch (type) {
                case "DES":
                    size = 8;
                    break;
                case "AES":
                    size = 16;
                    break;
            }
            
            int addByte = size - data.length % size;
            if ((data.length) % size != 0) {
                byte add[] = new byte[addByte];
                int padding = size - (data.length) % size;
                for (int i = 0; i < addByte; i++) {
                    add[i] = (byte) padding;
                }

                byte out[] = new byte[data.length + add.length];
                System.arraycopy(data, 0, out, 0, data.length);
                System.arraycopy(add, 0, out, data.length, add.length);

                data = out;
            }

            result = data;
        }
        return result;
    }
    
    public byte[] deletePaddingPKCS5(byte data[]) {

        byte result[] = null;

        if (data != null) {
            int size = data.length;
            byte padding = data[size - 1];
            int remove = 0, s = 1;
            if (padding == 0x01) {
                remove = 1;
            } else {
                while (padding == data[size - 2] && size > 2) {
                    s++;
                    size--;
                    remove++;
                    if(s == byteToInteger(padding)){
                        break;
                    }
                }
                if (remove != 0) {
                    remove += 1;
                }
            }
            byte out[] = new byte[data.length - remove];
            System.arraycopy(data, 0, out, 0, data.length - remove);
            result = out;
        }
        return result;
    }

}
