/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arsipsistem;

import static arsipsistem.Koneksi.conn;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.mysql.jdbc.Connection;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tam
 */
public class UI extends javax.swing.JFrame {

    /**
     * Creates new form UI
     */
    public UI() throws SQLException {
        initComponents();
        loadTabelUser();
    }
    private static final String ACCESS_TOKEN = "gaFanlksXxAAAAAAAAAAaukswiGw3nEm7hPDRT-urVVxXJm2gcejAxihubqZRima";
    DbxRequestConfig config = new DbxRequestConfig("dropbox/java-tutorial", "en_US");
    DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);
    Connection conn = Koneksi.connectDB();
    public void loadTabelUser() throws SQLException{
        String sql = "SELECT * FROM download";
        Object[] kolom={"ID","Username","link"};
        DefaultTableModel dataModel=new DefaultTableModel(null,kolom);
        tbUser.setModel(dataModel);
        tbUser.getColumnModel().getColumn(0).setMaxWidth(100);
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("id");
                String nama = rs.getString("username");
                String links = rs.getString("link");
                Object[] data={id, nama, links};
                dataModel.addRow(data);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
     public void loadTabelUser(String teks){
        String sql = "SELECT * FROM download";
        Object[] kolom={"ID","Username","link"};
        DefaultTableModel dataModel=new DefaultTableModel(null,kolom);
        tbUser.setModel(dataModel);
        tbUser.getColumnModel().getColumn(0).setMaxWidth(100);
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("id");
                String nama = rs.getString("username");
                String links = rs.getString("link");
                Object[] data={id,nama, links};
                dataModel.addRow(data);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        txtFile = new javax.swing.JTextField();
        btnChoose = new javax.swing.JButton();
        btnEncrypt = new javax.swing.JButton();
        btnDecrypt = new javax.swing.JButton();
        chkRemove = new javax.swing.JCheckBox();
        btnUpload = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbUser = new javax.swing.JTable();
        btnDownload = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFileActionPerformed(evt);
            }
        });

        btnChoose.setText("Choose");
        btnChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseActionPerformed(evt);
            }
        });

        btnEncrypt.setBackground(new java.awt.Color(200, 15, 13));
        btnEncrypt.setText("Encrypt");
        btnEncrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncryptActionPerformed(evt);
            }
        });

        btnDecrypt.setBackground(new java.awt.Color(32, 137, 40));
        btnDecrypt.setText("Decrypt");
        btnDecrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDecryptActionPerformed(evt);
            }
        });

        chkRemove.setText("Hapus file asli?");

        btnUpload.setBackground(new java.awt.Color(1, 22, 123));
        btnUpload.setText("Upload");
        btnUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadActionPerformed(evt);
            }
        });

        tbUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbUser);

        btnDownload.setBackground(new java.awt.Color(210, 201, 7));
        btnDownload.setText("Download");
        btnDownload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDownloadActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(150, 22, 10));

        jLabel2.setFont(new java.awt.Font("Chandas", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(1, 1, 1));
        jLabel2.setText("Caring your file, Caring your privacy");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(194, 194, 194)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(140, 20, 15));

        jLabel3.setFont(new java.awt.Font("Chandas", 3, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(1, 1, 1));
        jLabel3.setText("Andi Wian Pandu");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(141, 27, 5));

        jLabel1.setFont(new java.awt.Font("Chandas", 0, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(1, 1, 1));
        jLabel1.setText("AWIPA");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 375, Short.MAX_VALUE)
        );

        jLabel4.setIcon(new javax.swing.ImageIcon("/home/tam/NetBeansProjects/ArsipSistem/Screenshot from 2020-07-23 22-23-19.png")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkRemove)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtFile, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnChoose))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnEncrypt)
                                    .addGap(30, 30, 30)
                                    .addComponent(btnDecrypt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(btnUpload)
                                    .addGap(35, 35, 35)
                                    .addComponent(btnDownload)))))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(6, 6, 6)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnChoose))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chkRemove)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnEncrypt)
                                    .addComponent(btnDecrypt))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnUpload)
                                    .addComponent(btnDownload))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFileActionPerformed
    File myFile;
    String fileName;
    private void btnChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseActionPerformed
        // TODO add your handling code here:
        try {
            fileChooser.showOpenDialog(null);
            myFile=fileChooser.getSelectedFile();
            fileName = myFile.getAbsolutePath();
            txtFile.setText(fileName);
            txtFile.setEnabled(true);
            
        } catch (Exception e){
            System.out.println("Cancelled : " + e.getMessage());
        }
              
    }//GEN-LAST:event_btnChooseActionPerformed

    private void btnEncryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncryptActionPerformed
        // TODO add your handling code here:
        String keyInput = JOptionPane.showInputDialog(this,
                "Input kunci : ", "Input kunci", JOptionPane.OK_CANCEL_OPTION);
        if(keyInput!=null){
            String myFilePath = myFile.getAbsolutePath();
            File encryptedFile = new File(myFilePath+".enc");
            
            boolean p = false;
            try {
                p=AES256.encryptFile(keyInput, myFile, encryptedFile);
                if(p==false) {
                    JOptionPane.showMessageDialog(this,"File gagal dienkripsi!");                 
                } else {
                    JOptionPane.showMessageDialog(this, "File telah dienkripsi : "
                    + encryptedFile.getAbsolutePath());
                }
                if(p==true&&chkRemove.isSelected()){
                    myFile.delete();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally{
                System.out.println("done");
                chkRemove.setSelected(false);
            }
        } else {
            System.out.println("Dibatalkan");
        }
        
    }//GEN-LAST:event_btnEncryptActionPerformed

    private void btnDecryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDecryptActionPerformed
        // TODO add your handling code here:
         String keyInput = JOptionPane.showInputDialog(this,
                "Input kunci : ", "Input kunci", JOptionPane.OK_CANCEL_OPTION);
        if(keyInput!=null){
            String myFilePath = myFile.getAbsolutePath();
            String decryptedFilePath =myFilePath;
            File decryptedFile = new File(decryptedFilePath);
            
            boolean p = false;
            try {
                p=AES256.decryptFile(keyInput, myFile, decryptedFile);
                if(p==false) {
                    JOptionPane.showMessageDialog(this,"File gagal didekripsi!");                 
                } else {
                    JOptionPane.showMessageDialog(this, "File telah didekripsi");
                }
                if(p==true&&chkRemove.isSelected()){
                    myFile.delete();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally{
                System.out.println("done");
                chkRemove.setSelected(false);
            }
        } else {
            System.out.println("Dibatalkan");
        }
        
    }//GEN-LAST:event_btnDecryptActionPerformed

    private void btnUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadActionPerformed
        // TODO add your handling code here:
         JTextField txtNama = new JTextField(15);
         JPanel myPanel = new JPanel();
         myPanel.setLayout(new GridLayout(2,2,0,10));
         myPanel.add(new JLabel ("Masukkan username untuk didatabase!"));
         myPanel.add(txtNama);
          int result = JOptionPane.showConfirmDialog(this, myPanel,
                "Username Samaran!",
                JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
         if (txtNama.getText() != null){
         String myFilePath = myFile.getAbsolutePath();
         String fileNameUpload = myFile.toString();
         try{
                Statement stmt = conn.createStatement();
                stmt.executeUpdate("INSERT INTO download (username, link)" +
                        " VALUES('"+txtNama.getText()+"','"+fileNameUpload+"')");
                loadTabelUser();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        try (InputStream in = new FileInputStream(myFilePath)) {
            FileMetadata metadata = client.files().uploadBuilder(fileNameUpload)
                .uploadAndFinish(in);
            String sharedUrl = ("/" + fileName);
		//System.out.println("Uploaded: " + myFilePath);
                JOptionPane.showMessageDialog(null, "Berhasil upload file");
                
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DbxException | IOException ex) {
            Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
        }
         } else{
             JOptionPane.showMessageDialog(null, "Anda belum memasukkan username");
         }
         
         
    }//GEN-LAST:event_btnUploadActionPerformed
int selectedID;
    private void btnDownloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDownloadActionPerformed
        // TODO add your handling code here:
         if(tbUser.isRowSelected(tbUser.getSelectedRow())==true){
            selectedID=(int)tbUser.getValueAt(tbUser.getSelectedRow(),0);
         }
        try    
            {
                //output file for download --> storage location on local system to download file
                String home = System.getProperty("user.home");
                OutputStream downloadFile = new FileOutputStream(tbUser.getValueAt(tbUser.getSelectedRow(), 2).toString());
                try
                {
                FileMetadata metadata = client.files().downloadBuilder(tbUser.getValueAt(tbUser.getSelectedRow(), 2).toString())
                        .download(downloadFile);
                
                }
                finally
                {
                    downloadFile.close();
                    
                }
                JOptionPane.showMessageDialog(null, "Berhasil download file");
            }
            //exception handled
            catch (DbxException e)
            {
                //error downloading file
                JOptionPane.showMessageDialog(null, "Unable to download file to local system\n Error: " + e);
            }
            catch (IOException e)
            {
                JOptionPane.showMessageDialog(null, "Unable to download file to local system\n Error: " + e);
            }
    }//GEN-LAST:event_btnDownloadActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new UI().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChoose;
    private javax.swing.JButton btnDecrypt;
    private javax.swing.JButton btnDownload;
    private javax.swing.JButton btnEncrypt;
    private javax.swing.JButton btnUpload;
    private javax.swing.JCheckBox chkRemove;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbUser;
    private javax.swing.JTextField txtFile;
    // End of variables declaration//GEN-END:variables
}
