/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbmsproj;
import java.sql.*;
import dbmsproj.Encryption;
import javax.swing.JOptionPane;

/**
 *
 * @author vedant
 */
public class StaffLogin extends javax.swing.JFrame {

    /**
     * Creates new form StaffLogin
     */
    public StaffLogin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        StaffID = new javax.swing.JLabel();
        StaffIDfield = new javax.swing.JTextField();
        StaffPW = new javax.swing.JLabel();
        StaffPWfield = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        StaffID.setText("Staff ID");

        StaffPW.setText("Password");

        jButton1.setText("Enter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Poppins", 0, 24)); // NOI18N
        jLabel1.setText("Staff Login");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(StaffPW, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(StaffID, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(StaffIDfield)
                                    .addComponent(StaffPWfield, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StaffID)
                    .addComponent(StaffIDfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StaffPW)
                    .addComponent(StaffPWfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    StaffPage sp = new StaffPage();
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        
        Encryption enc=new Encryption("PdSgVkYp3s6v9y$B");
        ResultSet rs=null;
        PreparedStatement ps=null;
        
        try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject","root","asdf1234");
                //String sql="select pass from adminlogin_credentials where username=?";
                ps = conn.prepareStatement("select staff_password from staff where staff_id=?");
                
                ps.setString(1, StaffIDfield.getText());
                char[] pass1=StaffPWfield.getPassword();
                String pass=String.valueOf(pass1);
                String encpass=enc.encrypt(pass);
               // String dbpass=ReceptionistPWfield.getText();
                
                System.out.println(encpass);
                      
                      
                String username="";
              //  ps.setString(2, "");
                //ps.setString(2, new String(ReceptionistPWfield.getPassword()));
                
                rs = ps.executeQuery();
                rs.next();
                    
                //   username =ReceptionistIDfield.getText();*/
              String dbpass=rs.getString("staff_password");
              
              /*  ps=conn.prepareStatement(sql);
                ps.setString(1,dbpass);
                rs=ps.executeQuery();
                */System.out.println(dbpass);
                System.out.println(encpass.equals(dbpass));
                if (encpass.equals(dbpass))
                {
                    sp.setVisible(true);
                    JOptionPane.showMessageDialog(null, "Welcome  " + StaffIDfield.getText(), "Successful", JOptionPane.PLAIN_MESSAGE);
                }
                else
                    JOptionPane.showMessageDialog(null, "Inavlid" , "Unuccessful", JOptionPane.ERROR_MESSAGE);
            }
        
        
        
        /*
        String sql="select password from stafflogin_credentials where username=?";
        Encryption enc=new Encryption("PdSgVkYp3s6v9y$B");     
         try{
                Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject","root","1234")) {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, StaffIDfield.getText());
                char[] pass1=StaffPWfield.getPassword();
                String pass=String.valueOf(pass1);
                String encpass=enc.encrypt(pass);
                
                
                System.out.println(encpass);
              //  ps.setString(2, "");
                //ps.setString(2, new String(ReceptionistPWfield.getPassword()));
                
                ResultSet rs = ps.executeQuery();
                if (!encpass.equals(pass))
                {
                    sp.setVisible(true);
                    JOptionPane.showMessageDialog(null, "Welcome  " + StaffIDfield.getText(), "Successful", JOptionPane.PLAIN_MESSAGE);
                }
                else
                    JOptionPane.showMessageDialog(null, "Inavlid" , "Unuccessful", JOptionPane.ERROR_MESSAGE);
            }
        }
       /* try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject","root","asdf1234");
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, StaffIDfield.getText());
                ps.setString(2, new String(StaffPWfield.getPassword()));
                
                ResultSet rs = ps.executeQuery();
                if (rs.next())
                {
                    sp.setVisible(true);
                    JOptionPane.showMessageDialog(null, "Welcome  " + StaffIDfield.getText(), "Successful", JOptionPane.PLAIN_MESSAGE);
                }
                else
                    JOptionPane.showMessageDialog(null, "Inavlid" , "Unuccessful", JOptionPane.ERROR_MESSAGE);
                
                conn.close();
        }*/
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(StaffLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StaffLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StaffLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StaffLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StaffLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel StaffID;
    private javax.swing.JTextField StaffIDfield;
    private javax.swing.JLabel StaffPW;
    private javax.swing.JPasswordField StaffPWfield;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
