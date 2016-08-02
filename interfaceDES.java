package assignment1;

import java.awt.FileDialog;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class interfaceDES extends javax.swing.JFrame {
    
    DES des;
    functionShare fun;
    
    public interfaceDES() {
        initComponents();
        this.setLocation(300, 100);
        this.setResizable(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
        
        bar1 = new javax.swing.JProgressBar();
        bar2 = new javax.swing.JProgressBar();
        layer1 = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        tableName = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        btnFileEncrypt = new javax.swing.JButton();
        btnFileKey1 = new javax.swing.JButton();
        btnRemove1 = new javax.swing.JButton();
        btnEncrypt = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        table3 = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        table4 = new javax.swing.JTable();
        btnFileDecrypt = new javax.swing.JButton();
        btnFileKey2 = new javax.swing.JButton();
        btnRemove2 = new javax.swing.JButton();
        btnDecrypt = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Encryption / Decryption DES");
        
        nameLabel.setText("Data Encryption Standard - DES");
        nameLabel.setFont(new java.awt.Font("Segoe UI", 3, 20));
        nameLabel.setForeground(new java.awt.Color(51, 204, 0));
        
        tableName.setFont(new java.awt.Font("Segeo UI", 3, 14));
        tableName.setForeground(new java.awt.Color(0, 0, 0));
        
        table1.setFont(new java.awt.Font("Segoe UI", 1, 14));
        table1.setForeground(new java.awt.Color(51, 204, 0));
        table1.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
        table1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        table1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Hash code", "File Name", "File Key"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false
            };
            
            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
            
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane5.setViewportView(table1);
        
        table2.setFont(new java.awt.Font("Segoe UI", 1, 14));
        table2.setForeground(new java.awt.Color(51, 204, 0));
        table2.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
        table2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        table2.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "STT", "File Output", "Size(MB)", "Hash Code"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false, false
            };
            
            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
            
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane6.setViewportView(table2);
        
        btnFileEncrypt.setText("File Encrypt");
        btnFileEncrypt.setForeground(new java.awt.Color(30, 40, 180));
        btnFileEncrypt.setPreferredSize(new java.awt.Dimension(80, 27));
        btnFileEncrypt.addActionListener(this::btnFileEncryptActionPerformed);
        
        btnFileKey1.setText("File Key");
        btnFileKey1.setForeground(new java.awt.Color(30, 40, 180));
        btnFileKey1.setPreferredSize(new java.awt.Dimension(80, 27));
        btnFileKey1.addActionListener(this::btnFileKey1ActionPerformed);
        
        btnRemove1.setText("Remove");
        btnRemove1.setForeground(new java.awt.Color(30, 40, 180));
        btnRemove1.setPreferredSize(new java.awt.Dimension(80, 27));
        btnRemove1.addActionListener(this::btnRemove1ActionPerformed);
        
        btnEncrypt.setText("Encrypt");
        btnEncrypt.setForeground(new java.awt.Color(30, 40, 180));
        btnEncrypt.setPreferredSize(new java.awt.Dimension(80, 27));
        btnEncrypt.addActionListener(this::btnEncryptActionPerformed);
        
        bar1.setStringPainted(true);
        bar1.setMinimum(0);
        bar1.setMaximum(100);
        bar1.setBackground(new java.awt.Color(255, 255, 255));
        
        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(bar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(btnFileEncrypt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnFileKey1)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnRemove1)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnEncrypt, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(bar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnFileEncrypt)
                                        .addComponent(btnRemove1)
                                        .addComponent(btnEncrypt)
                                        .addComponent(btnFileKey1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(1, 1, 1))
        );
        
        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[]{bar1, btnEncrypt, btnFileEncrypt, btnFileKey1, btnRemove1});
        
        tableName.addTab("Encrypt", jPanel4);
        
        table3.setFont(new java.awt.Font("Segoe UI", 1, 14));
        table3.setForeground(new java.awt.Color(51, 204, 0));
        table3.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
        table3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        table3.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Hash code", "File Name", "File Key"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false
            };
            
            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
            
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane7.setViewportView(table3);
        
        table4.setFont(new java.awt.Font("Segoe UI", 1, 14));
        table4.setForeground(new java.awt.Color(51, 204, 0));
        table4.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
        table4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        table4.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "STT", "File Output", "Size(MB)", "Hash Code"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false, false
            };
            
            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
            
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane8.setViewportView(table4);
        
        btnFileDecrypt.setText("File Decrypt");
        btnFileDecrypt.setForeground(new java.awt.Color(30, 40, 180));
        btnFileDecrypt.setPreferredSize(new java.awt.Dimension(80, 27));
        btnFileDecrypt.addActionListener(this::btnFileDecryptActionPerformed);
        
        btnFileKey2.setText("File Key");
        btnFileKey2.setForeground(new java.awt.Color(30, 40, 180));
        btnFileKey2.setPreferredSize(new java.awt.Dimension(80, 27));
        btnFileKey2.addActionListener(this::btnFileKey2ActionPerformed);
        
        btnRemove2.setText("Remove");
        btnRemove2.setForeground(new java.awt.Color(30, 40, 180));
        btnRemove2.setPreferredSize(new java.awt.Dimension(80, 27));
        btnRemove2.addActionListener(this::btnRemove2ActionPerformed);
        
        btnDecrypt.setText("Decrypt");
        btnDecrypt.setForeground(new java.awt.Color(30, 40, 180));
        btnDecrypt.setPreferredSize(new java.awt.Dimension(80, 27));
        btnDecrypt.addActionListener(this::btnDecryptActionPerformed);
        
        bar2.setStringPainted(true);
        bar2.setMinimum(0);
        bar2.setMaximum(100);
        bar2.setBackground(new java.awt.Color(255, 255, 255));
        
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(bar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnFileDecrypt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnFileKey2)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnRemove2)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnDecrypt, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnFileDecrypt)
                                        .addComponent(btnRemove2)
                                        .addComponent(btnDecrypt)
                                        .addComponent(btnFileKey2))
                                .addComponent(bar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(1, 1, 1))
        );
        
        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[]{bar2, btnFileDecrypt, btnRemove2, btnDecrypt, btnFileKey2});
        
        tableName.addTab("Decrypt", jPanel1);
        
        javax.swing.GroupLayout layer1Layout = new javax.swing.GroupLayout(layer1);
        layer1.setLayout(layer1Layout);
        layer1Layout.setHorizontalGroup(
                layer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(tableName)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layer1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(177, 177, 177))
        );
        layer1Layout.setVerticalGroup(
                layer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layer1Layout.createSequentialGroup()
                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tableName, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        btnExit.setText("Exit");
        btnExit.setPreferredSize(new java.awt.Dimension(80, 27));
        btnExit.setForeground(new java.awt.Color(30, 40, 180));
        btnExit.addActionListener(this::btnExitActionPerformed);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(layer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExit)
                        .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(layer1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExit)
                        .addContainerGap(15, Short.MAX_VALUE))
        );
        
        pack();
    }// </editor-fold>                        
    
    public byte[] Encrypt(byte plaintext[], String key) {
        
        float c = 0;
        byte result[] = new byte[plaintext.length];
        
        functionShare fun = new functionShare();
        des = new DES();
        
        if (key != null && key.length() >= 8) {
            
            plaintext = fun.updatePaddingPKCS5(plaintext, "DES");
            
            byte encrypt[] = new byte[plaintext.length];
            int h = 0;
            String dataRaw = "";
            
            for (int count = 0; count < plaintext.length; count++) {
                
                String str = fun.byteToBinary(plaintext[count]);
                dataRaw += str;
                
                if (dataRaw.length() == 64) {
                    
                    dataRaw = des.InitialPermutation(dataRaw);
                    String L, R, Re, K, xorEK, subXor, subXorP;
                    
                    for (int j = 1; j <= 16; j++) {
                        L = des.LeftBlock(dataRaw);
                        R = des.RightBlock(dataRaw);
                        K = des.KeyDES(key, j);
                        
                        Re = des.Expansion(R);
                        xorEK = des.Xor(Re, K);
                        subXor = des.Substitution(xorEK);
                        subXorP = des.Permutation(subXor);
                        
                        L = des.Xor(L, subXorP);
                        dataRaw = R + L;
                    }
                    
                    L = des.LeftBlock(dataRaw);
                    R = des.RightBlock(dataRaw);
                    dataRaw = R + L;
                    
                    dataRaw = des.InverseIP(dataRaw);
                    c += dataRaw.length();
                    
                    char dataChar[] = dataRaw.toCharArray();
                    dataRaw = "";
                    
                    float a = (c * 100) / (encrypt.length * 8);
                    if (a < 100) {
                        if ("Complete".equals(bar1.getString())) {
                            bar1.setString(null);
                            bar1.setValue((int) a);
                        } else {
                            bar1.setValue((int) a);
                        }
                    } else {
                        bar1.setValue((int) a);
                        bar1.setString("Complete");
                    }
                    
                    String binary = "";
                    for (int k = 0; k < dataChar.length; k++) {
                        binary += dataChar[k];
                        if (binary.length() == 8) {
                            encrypt[h] = fun.binaryToByte(binary);
                            h++;
                            binary = "";
                        }
                    }
                }
                
            }
            
            result = encrypt;
        }
        return result;
    }
    
    public byte[] Decrypt(byte ciphetext[], String key) {
        
        float c = 0;
        byte result[] = new byte[ciphetext.length];
        
        functionShare fun = new functionShare();
        des = new DES();
        
        if (key != null && key.length() >= 8) {
            
            byte decrypt[] = new byte[ciphetext.length];
            int h = 0;
            String dataRaw = "";
            
            for (int count = 0; count < ciphetext.length; count++) {
                
                String str = fun.byteToBinary(ciphetext[count]);
                dataRaw += str;
                
                if (dataRaw.length() == 64) {
                    
                    dataRaw = des.InitialPermutation(dataRaw);
                    String L, R, Re, K, xorEK, subXor, subXorP;
                    
                    for (int j = 1; j <= 16; j++) {
                        L = des.LeftBlock(dataRaw);
                        R = des.RightBlock(dataRaw);
                        K = des.KeyDES(key, 17 - j);
                        
                        Re = des.Expansion(R);
                        xorEK = des.Xor(Re, K);
                        subXor = des.Substitution(xorEK);
                        subXorP = des.Permutation(subXor);
                        
                        L = des.Xor(L, subXorP);
                        dataRaw = R + L;
                    }
                    
                    L = des.LeftBlock(dataRaw);
                    R = des.RightBlock(dataRaw);
                    dataRaw = R + L;
                    
                    dataRaw = des.InverseIP(dataRaw);
                    c += dataRaw.length();
                    
                    char dataChar[] = dataRaw.toCharArray();
                    dataRaw = "";
                    
                    float a = (c * 100) / (decrypt.length * 8);
                    if (a < 100) {
                        if ("Complete".equals(bar2.getString())) {
                            bar2.setString(null);
                            bar2.setValue((int) a);
                        } else {
                            bar2.setValue((int) a);
                        }
                    } else {
                        bar2.setValue((int) a);
                        bar2.setString("Complete");
                    }
                    
                    String binary = "";
                    for (int k = 0; k < dataChar.length; k++) {
                        binary += dataChar[k];
                        if (binary.length() == 8) {
                            decrypt[h] = fun.binaryToByte(binary);
                            h++;
                            binary = "";
                        }
                    }
                }
                
            }
            
            decrypt = fun.deletePaddingPKCS5(decrypt);
            result = decrypt;
        }
        return result;
    }
    
    public class encryption implements Runnable {
        
        private Thread t;
        
        public void start() {
            t = new Thread(this);
            t.start();
        }
        
        @Override
        public void run() {
            int rowSelect = table1.getSelectedRow();
            String path = table1.getModel().getValueAt(rowSelect, 1).toString();
            String key = table1.getModel().getValueAt(rowSelect, 2).toString();
            
            fun = new functionShare();
            des = new DES();
            
            if (path != null && key != null) {
                
                File file = new File(path);
                File fileKey = new File(key);
                
                if (!file.exists()) {
                    JOptionPane.showMessageDialog(null,
                            "Encrypted file not found or cannot be accessed.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                byte data[] = fun.readByteFile(file);
                byte k[] = fun.readByteFile(fileKey);
                
                key = "";
                for (int i = 0; i < k.length; i++) {
                    key += (char) k[i];
                }
                
                data = Encrypt(data, key);
                
                if (fun.writeByteFile(file.getAbsolutePath() + ".enc", data)) {
                    
                    String pathNew = file.getAbsolutePath() + ".enc", code = null;
                    File f = new File(pathNew);
                    
                    file.delete();
                    
                    JOptionPane.showMessageDialog(null,
                            "File encrypted as : " + file.getName() + ".enc\n",
                            "Done", JOptionPane.INFORMATION_MESSAGE);
                    
                    try {
                        code = fun.hashcode(pathNew);
                    } catch (Exception ex) {
                        Logger.getLogger(interfaceDES.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    float sizef = (f.length()) / (1024 * 1024); // MB
                    int stt = table2.getRowCount();
                    
                    DefaultTableModel model = (DefaultTableModel) table2.getModel();
                    model.addRow(new Object[]{String.valueOf(stt + 1), f.getAbsoluteFile(), String.valueOf(sizef), code});
                }
            }
        }
    }
    
    public class decryption implements Runnable {
        
        private Thread t;
        
        public void start() {
            t = new Thread(this);
            t.start();
        }
        
        @Override
        public void run() {
            int rowSelect = table3.getSelectedRow();
            String path = table3.getModel().getValueAt(rowSelect, 1).toString();
            String key = table3.getModel().getValueAt(rowSelect, 2).toString();
            
            fun = new functionShare();
            des = new DES();
            
            if (path != null && key != null) {
                
                File file = new File(path);
                File fileKey = new File(key);
                
                if (!file.exists()) {
                    JOptionPane.showMessageDialog(null,
                            "Encrypted file not found or cannot be accessed.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                byte data[] = fun.readByteFile(file);
                byte k[] = fun.readByteFile(fileKey);
                
                key = "";
                for (int i = 0; i < k.length; i++) {
                    key += (char) k[i];
                }
                
                data = Decrypt(data, key);
                
                String filename = file.getAbsolutePath();
                filename = filename.substring(0, filename.length() - 3);
                
                if (fun.writeByteFile(filename, data)) {
                    
                    String code = null;
                    File f = new File(filename);
                    
                    file.delete();
                    
                    JOptionPane.showMessageDialog(null,
                            "File sucessfully decrypted.",
                            "Done", JOptionPane.INFORMATION_MESSAGE);
                    
                    try {
                        code = fun.hashcode(filename);
                    } catch (Exception ex) {
                        Logger.getLogger(interfaceDES.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    float sizef = (f.length()) / (1024 * 1024); // MB
                    int stt = table4.getRowCount();
                    
                    DefaultTableModel model = (DefaultTableModel) table4.getModel();
                    model.addRow(new Object[]{String.valueOf(stt + 1), f.getAbsoluteFile(), String.valueOf(sizef), code});
                }
            }
        }
        
    }
    
    private void btnEncryptActionPerformed(java.awt.event.ActionEvent evt) {
        new encryption().start();
    }
    
    private void btnDecryptActionPerformed(java.awt.event.ActionEvent evt) {
        new decryption().start();
    }
    
    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        new Encryption_DES_RSA_AES().setVisible(true);
    }
    
    private void btnRemove1ActionPerformed(java.awt.event.ActionEvent evt) {
        
        int rowSelect1 = table1.getSelectedRow();
        int rowSelect2 = table2.getSelectedRow();
        String stt;
        
        if (rowSelect1 != -1) {
            DefaultTableModel model = (DefaultTableModel) table1.getModel();
            model.removeRow(rowSelect1);
        }
        
        if (rowSelect2 != -1) {
            DefaultTableModel model = (DefaultTableModel) table2.getModel();
            model.removeRow(rowSelect2);
            
            int count = model.getRowCount();
            
            for (int i = 0; i < count; i++) {
                stt = Integer.toString(i + 1);
                table2.getModel().setValueAt(stt, i, 0);
            }
        }
    }
    
    private void btnFileKey1ActionPerformed(java.awt.event.ActionEvent evt) {
        File file = getFileDialogOpen("*.TXT*");
        
        if (file != null) {
            
            String pathKey = null;
            int row = -1;
            pathKey = file.getAbsolutePath();
            row = table1.getSelectedRow();
            
            table1.getModel().setValueAt(pathKey, row, 2);
            
            if (row == table1.getRowCount() - 1) {
                row = 0;
            }
            for (int i = row; i < table1.getRowCount(); i++) {
                if (table1.getModel().getValueAt(row, 2) == null) {
                    break;
                }
                row++;
            }
            
            if (row == table1.getRowCount()) {
                row = 0;
            }
            table1.setRowSelectionInterval(row, row);
        }
    }
    
    private void btnFileEncryptActionPerformed(java.awt.event.ActionEvent evt) {
        File file = getFileDialogOpen("*.*");
        fun = new functionShare();
        if (file != null) {
            
            String pathFile = null, hashCode = null;
            pathFile = file.getAbsolutePath();
            
            try {
                hashCode = fun.hashcode(pathFile);
            } catch (Exception ex) {
                Logger.getLogger(interfaceDES.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            DefaultTableModel model = (DefaultTableModel) table1.getModel();
            model.addRow(new Object[]{hashCode, pathFile, null});
            int count = table1.getRowCount();
            table1.setRowSelectionInterval(count - 1, count - 1);
        }
    }
    
    private void btnFileDecryptActionPerformed(java.awt.event.ActionEvent evt) {
        File file = getFileDialogOpen("*.EN*");
        fun = new functionShare();
        
        if (file != null) {
            
            String pathFile = null, hashCode = null;
            pathFile = file.getAbsolutePath();
            
            try {
                hashCode = fun.hashcode(pathFile);
            } catch (Exception ex) {
                Logger.getLogger(interfaceDES.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            DefaultTableModel model = (DefaultTableModel) table3.getModel();
            model.addRow(new Object[]{hashCode, pathFile, null});
            int count = table3.getRowCount();
            table3.setRowSelectionInterval(count - 1, count - 1);
        }
    }
    
    private void btnFileKey2ActionPerformed(java.awt.event.ActionEvent evt) {
        File file = getFileDialogOpen("*.TXT*");
        if (file != null) {
            
            String pathKey = null;
            int row = -1;
            pathKey = file.getAbsolutePath();
            row = table3.getSelectedRow();
            
            table3.getModel().setValueAt(pathKey, row, 2);
            
            if (row == table3.getRowCount() - 1) {
                row = 0;
            }
            for (int i = row; i < table3.getRowCount(); i++) {
                if (table3.getModel().getValueAt(row, 2) == null) {
                    break;
                }
                row++;
            }
            
            if (row == table3.getRowCount()) {
                row = 0;
            }
            table3.setRowSelectionInterval(row, row);
        }
    }
    
    private void btnRemove2ActionPerformed(java.awt.event.ActionEvent evt) {
        int rowSelect3 = table3.getSelectedRow();
        int rowSelect4 = table4.getSelectedRow();
        String stt;
        
        if (rowSelect3 != -1) {
            DefaultTableModel model = (DefaultTableModel) table3.getModel();
            model.removeRow(rowSelect3);
        }
        
        if (rowSelect4 != -1) {
            DefaultTableModel model = (DefaultTableModel) table4.getModel();
            model.removeRow(rowSelect4);
            
            int count = model.getRowCount();
            
            for (int i = 0; i < count; i++) {
                stt = Integer.toString(i + 1);
                table4.getModel().setValueAt(stt, i, 0);
            }
        }
    }
    
    private File getFileDialogOpen(String filter) {
        FileDialog fd = new FileDialog(this, "Select File Need Encrypt", FileDialog.LOAD);
        fd.setFile(filter);
        fd.setVisible(true);
        fd.setLocation(300, 300);
        
        if (fd.getFile() == null) {
            return null;
        }
        File file = new File(fd.getDirectory() + fd.getFile());
        
        if (!file.canRead()) {
            JOptionPane.showMessageDialog(null,
                    "Selected file cannot be read.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return file;
    }
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> {
            new interfaceDES().setVisible(true);
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnDecrypt;
    private javax.swing.JButton btnEncrypt;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnFileDecrypt;
    private javax.swing.JButton btnFileEncrypt;
    private javax.swing.JButton btnFileKey1;
    private javax.swing.JButton btnFileKey2;
    private javax.swing.JButton btnRemove1;
    private javax.swing.JButton btnRemove2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JPanel layer1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTable table1;
    private javax.swing.JTable table2;
    private javax.swing.JTable table3;
    private javax.swing.JTable table4;
    private javax.swing.JTabbedPane tableName;
    private javax.swing.JProgressBar bar1;
    private javax.swing.JProgressBar bar2;
    // End of variables declaration                   

}
