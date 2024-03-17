/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package icbt_system;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Ahamed
 */
public class Course_reg extends javax.swing.JInternalFrame {
   
    public Course_reg() {
        initComponents();
        getContentPane().setBackground(Color.BLACK);
        

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();

        setBorder(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setForeground(new java.awt.Color(204, 255, 204));
        setPreferredSize(new java.awt.Dimension(1000, 600));
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 255, 204));
        jLabel2.setText("Course ID");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(318, 76, 91, 22);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 255, 204));
        jLabel3.setText("Course Name");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(295, 117, 121, 22);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 255, 204));
        jLabel4.setText("Course Fee");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(311, 169, 100, 22);

        jButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton1.setText("Register");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(360, 420, 130, 30);

        jButton2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton2.setText("Reset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(530, 420, 130, 30);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 255, 204));
        jLabel6.setText("Register Course");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(459, 24, 142, 22);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 255, 204));
        jLabel1.setText("Course Duration");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(275, 219, 148, 22);

        jTextField1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        getContentPane().add(jTextField1);
        jTextField1.setBounds(430, 73, 214, 28);

        jTextField2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        getContentPane().add(jTextField2);
        jTextField2.setBounds(430, 114, 214, 28);

        jTextField3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        getContentPane().add(jTextField3);
        jTextField3.setBounds(430, 166, 214, 28);

        jTextField4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField4);
        jTextField4.setBounds(430, 216, 214, 28);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 255, 204));
        jLabel5.setText("Class room");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(312, 293, 98, 22);

        jComboBox1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Lab1", "Lab2" }));
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(430, 290, 180, 28);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 255, 204));
        jLabel7.setText("Select Day");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(320, 350, 95, 22);

        jComboBox2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Monday ", "Tuesday", "Wednesday", "Thursday", "Friday ", "Saturday", "Sunday" }));
        jComboBox2.setToolTipText("");
        getContentPane().add(jComboBox2);
        jComboBox2.setBounds(430, 350, 180, 28);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    int dNo;
    
    int dupCheck = 0;
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        checkDuplicate();
        
        int day = jComboBox2.getSelectedIndex();
        
        switch (day) 
        {
            
        case 0:
        dNo = 2;
        break;
            
        case 1:
        dNo = 3;
        break;
        
        case 2:
        dNo = 4;
        break;
            
        case 3:
        dNo = 5;
        break;
            
        case 4:
        dNo = 6;
        break;
                 
        case 5:
        dNo = 7;
        break;
                      
        case 6:
        dNo = 1;
        break;
            
        default:
        System.out.println("Its none day");
        }
        
        String s1 = jTextField1.getText();
        String s2 = jTextField2.getText();
        String s3 = jTextField3.getText();
        String s4 = jTextField4.getText();
        
        String s5 = (String)jComboBox1.getSelectedItem();
       // String s3 = (String) jComboBox1.getSelectedItem();
        
                  Connection con = null;  
		  Statement stmt = null;
                
        if (jTextField2.getText().equals("")){
          JOptionPane.showMessageDialog(rootPane, "Please fill all the fields");
        }
        else{
            if (dupCheck ==0){
             try {
			  Class.forName("com.mysql.jdbc.Driver");
			  con =DriverManager.getConnection ("jdbc:mysql://localhost:3306/SmartUni","root","");
			  stmt = con.createStatement();
			  
			  String query =("INSERT INTO courses values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+dNo+"')");
			  Statement statement = null;
			  statement = (Statement) con.createStatement();
		      statement.executeUpdate(query);
			  
			  JOptionPane.showMessageDialog(rootPane, "Course succesfully created...");
 
			 } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Error in Saving...");
            ex.printStackTrace();
        } finally {
            try {                
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Error in saving");
            }
        }
        } 
        }
        
        dupCheck = 0;
    }//GEN-LAST:event_jButton1ActionPerformed

    public void checkDuplicate(){
              String s1 = jTextField1.getText();
        Connection con = null;
        Statement st = null;        

        String url = "jdbc:mysql://localhost:3306/smartuni";
        String user = "root";
        String password = "";                

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM courses WHERE course_id = "+s1+"");            
            if (rs.next()) {
             JOptionPane.showMessageDialog(null, "Duplicate Course ID found");
             dupCheck = 1;
            }           
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Error in Searching...");
            ex.printStackTrace();
        }
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    
                           jTextField1.setText(null);
                           jTextField2.setText(null);
                           jTextField3.setText(null);
                           jTextField4.setText(null);
                           
                           
                          jTextField1.requestFocus(); 
                          
                            jTextField1.setEditable(true);
                             jTextField2.setEditable(true);
                             jTextField3.setEditable(true);
                             jTextField4.setEditable(true);
                              
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

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
            java.util.logging.Logger.getLogger(Course_reg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Course_reg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Course_reg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Course_reg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Course_reg().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
