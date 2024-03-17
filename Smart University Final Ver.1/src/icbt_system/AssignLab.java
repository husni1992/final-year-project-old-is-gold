
package icbt_system;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

/**
 * @author Ahamed
 */
public class AssignLab extends javax.swing.JInternalFrame {
    
    MainWindow mw = new MainWindow();

        String j1;
        String j2;    
    
        
        public void displayAllocatedLabs(){
            
            Font font = new Font("Verdana", Font.BOLD, 15);
           jTextArea1.setFont(font);
           jTextArea2.setForeground(Color.WHITE);

            
            String lab = "Lab1";
            
            try{ 
   
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SmartUni","root","");
    Statement st=conn.createStatement();
    ResultSet rs=st.executeQuery("SELECT * FROM courses WHERE allocatedLab = '"+lab+"'");
    String dayName = null;
        while(rs.next()){
            String d = rs.getString("lecDay");
            int y = Integer.parseInt(d);
            
            switch (y) 
        {
            
        case 0:
        dayName = "Saturday";
        break;
            
        case 1:
        dayName = "Sunday";
        break;
        
        case 2:
        dayName = "Monday";
        break;
            
        case 3:
        dayName = "Tuesday";
        break;
            
        case 4:
        dayName = "Wednesday";
        break;
                 
        case 5:
        dayName = "Thursday";
        break;
                      
        case 6:
        dayName = "Friday";
        break;
            
        default:
        System.out.println("Its none day");
        }
            
            
        jTextArea1.append((rs.getString("course_name"))+"    ("+dayName+")\n");
        // jTextArea1.append((rs.getString("course_name"))+"\n");
      //  jTextArea3.append(dayName+"\n");
        }
    }catch(Exception e){
        System.out.println(e);
    }
}

        public void displayAllocatedLabs2(){
            
           Font font = new Font("Verdana", Font.BOLD, 15);
           jTextArea2.setFont(font);
           jTextArea1.setForeground(Color.WHITE);

            
            String lab = "Lab2";
            
            try{ 
   
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SmartUni","root","");
    Statement st=conn.createStatement();
    ResultSet rs=st.executeQuery("SELECT * FROM courses WHERE allocatedLab = '"+lab+"'");
    
    String dayName = null;
    
        while(rs.next()){
            
            String d = rs.getString("lecDay");
            int y = Integer.parseInt(d);
            
            switch (y) 
        {
            
        case 0:
        dayName = "Saturday";
        break;
            
        case 1:
        dayName = "Sunday";
        break;
        
        case 2:
        dayName = "Monday";
        break;
            
        case 3:
        dayName = "Tuesday";
        break;
            
        case 4:
        dayName = "Wednesday";
        break;
                 
        case 5:
        dayName = "Thursday";
        break;
                      
        case 6:
        dayName = "Friday";
        break;
            
        default:
        System.out.println("Its none day");
        }
            
            
        jTextArea2.append((rs.getString("course_name"))+"    ("+dayName+")\n");
         //jTextArea2.append((rs.getString("course_name"))+"\n");
        //jTextArea4.append(dayName+"\n");
        
        }
    }catch(Exception e){
        System.out.println(e);
    }
}
 
    public  void AddComboBoxItem(){
    jComboBox1.removeAllItems();
    
try{ 
   
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SmartUni","root","");
    Statement st=conn.createStatement();
    ResultSet rs=st.executeQuery("SELECT * FROM courses");
        while(rs.next()){
        jComboBox1.addItem(rs.getString("course_name"));
       
        }
    }catch(Exception e){
        System.out.println(e);
    }


    }
    
    public void resetAll(){
        jTextArea1.setText("");
        jTextArea2.setText("");

        
        jComboBox1.removeAllItems();
        //jComboBox3.removeAllItems();
    }
    
    public AssignLab() {
        initComponents();
        getContentPane().setBackground(Color.BLACK); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();

        setBorder(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 600));
        getContentPane().setLayout(null);

        jComboBox1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(300, 100, 220, 28);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 255, 204));
        jLabel4.setText("Change lecture schedule and lab");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(50, 23, 295, 22);

        jButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton1.setText("Reallocate Lab 1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(160, 230, 180, 31);

        jButton3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton3.setText("Reallocate Lab2");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(590, 230, 180, 31);

        jComboBox3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Monday ", "Tuesday", "Wednesday", "Thursday", "Friday ", "Saturday", "Sunday" }));
        jComboBox3.setToolTipText("");
        getContentPane().add(jComboBox3);
        jComboBox3.setBounds(300, 140, 220, 28);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 255, 204));
        jLabel7.setText("Select Day");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(198, 143, 94, 22);

        jTextArea1.setBackground(new java.awt.Color(0, 0, 0));
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(90, 320, 330, 229);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 255, 204));
        jLabel5.setText("Lab 1 courses");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(90, 290, 210, 22);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 255, 204));
        jLabel6.setText("Lab 2 courses");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(520, 290, 180, 22);

        jTextArea2.setBackground(new java.awt.Color(0, 0, 0));
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(520, 320, 370, 229);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 255, 204));
        jLabel8.setText("Course");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(220, 102, 63, 22);

        pack();
    }// </editor-fold>//GEN-END:initComponents

        String courseID;
        int count = 0;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
jTextArea1.setText("");
jTextArea2.setText("");


    retriveRfidToConcat("Lab1"); 
    LecRfidToConcat("Lab1");
    int c1day = jComboBox3.getSelectedIndex();
    allocateLab("Lab1",c1day);
    displayAllocatedLabs();
    displayAllocatedLabs2();
    
        int x = JOptionPane.showConfirmDialog(rootPane, "Lecture schedules changed successfully\nDo you want to send sms notification?");
        
        if (x == JOptionPane.YES_OPTION) {
            smsScheduleChangeLab1();
        } 

    if (count == 3){
        //.showMessageDialog(rootPane, "Course & Student & Lecture tables updated succesfully");
        System.out.println("Course & Student & Lecture tables updated succesfully");
    }
    else{
        JOptionPane.showMessageDialog(rootPane, "Unsuccess");
    }
    count = 0;
    }//GEN-LAST:event_jButton1ActionPerformed
 int dNo;
    public void allocateLab(String x, int day){

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
        
        
      try{ 

    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SmartUni","root","");
    Statement st=conn.createStatement();
    st.executeUpdate("UPDATE courses SET allocatedLab='"+x+"', lecDay='"+dNo+"' WHERE course_id='"+courseID+"';"); 
        count = count + 1;
         }
        catch(Exception e){
            System.out.println(e);
         }
      
      
      
    }


    public void retriveRfidToConcat(String x){
        
      try{ 

    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SmartUni","root","");
    Statement st=conn.createStatement();
    ResultSet rs = st.executeQuery("SELECT * FROM students WHERE course_id="+courseID+"");           
            
            while (rs.next()) {
                //String s1 = rs.getString("stud_name");
                String s2 = rs.getString("stud_id"); 
                
                String s3 = rs.getString("stud_rfid");
                        
                    String[] parts = s3.split("_");
                  //  String part1 = parts[0]; 
                    String part2 = parts[1]; 
                    
                 // System.out.println(s3);
                //  System.out.println("'"+part1+"'");
                 // System.out.println("'"+part2+"'");
                   
                        
                allocateLabStuds(x,part2,s2);
  
             }
                count = count + 1;
 
    }
       catch(Exception e){
           JOptionPane.showMessageDialog(rootPane, "Error in Searching...");
            e.printStackTrace();
        }
    } 
  
   public void LecRfidToConcat(String x){
        
      try{ 

    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SmartUni","root","");
    Statement st=conn.createStatement();
    ResultSet rs = st.executeQuery("SELECT * FROM lecturers WHERE course_id="+courseID+"");           
            
            while (rs.next()) {
                String s2 = rs.getString("lec_id");                 
                String s3 = rs.getString("lec_rfid");
                        
                    String[] parts = s3.split("_");
                    //String part1 = parts[0]; 
                    String part2 = parts[1]; 
                    
                  //System.out.println(s3);
                   
                        
                allocateLabLecs(x,part2,s2);
                
             
             }
           count = count + 1;
 
    }
       catch(Exception e){
           JOptionPane.showMessageDialog(rootPane, "Error in Searching...");
            e.printStackTrace();
        }
    } 
    
        // concatanation method
    public void allocateLabStuds(String x , String y , String z){
        
        String nw = (x+"_"+y);

         
        try{ 
 
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SmartUni","root","");
    Statement st=conn.createStatement();
    st.executeUpdate("UPDATE students SET stud_rfid='"+nw+"' WHERE stud_id='"+z+"';");  
        }
        catch(Exception e){
        }
            
        
    } 
    // end of concatanation method
    
    // concatanation method
    public void allocateLabLecs(String x , String y , String z){
        
        String nw = (x+"_"+y);

         
        try{ 
 
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SmartUni","root","");
    Statement st=conn.createStatement();
    st.executeUpdate("UPDATE lecturers SET lec_rfid='"+nw+"' WHERE lec_id='"+z+"';");  
        }
        catch(Exception e){
        }
            
        
    } 
    // end of concatanation method
    
    
    public void allocateLab2Studs(){
     // j2 = (String)jComboBox2.getSelectedItem();
        
      try{ 

    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SmartUni","root","");
    Statement st=conn.createStatement();
   // st.executeUpdate("UPDATE courses SET allocatedLab='Lab1' WHERE course_name='"+j1+"';");  
    st.executeUpdate("UPDATE students SET stud_rfid = concat('koobs',stud_rfid) WHERE stud_course='"+j2+"';"); 
        JOptionPane.showMessageDialog(rootPane, "Students allocated to lab 2");
    }
        catch(Exception e){
        }
    }
    

    
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        
        j1 = (String)jComboBox1.getSelectedItem();
       
         
        try{  
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SmartUni","root","");
    Statement st=conn.createStatement();
    ResultSet rs=st.executeQuery("SELECT * FROM courses WHERE course_name = '"+j1+"'");
        if(rs.next()){
        courseID = rs.getString("course_id");
       // System.out.println(courseID);
                
        }
    }
        catch(Exception e){
        }
        
    }//GEN-LAST:event_jComboBox1ActionPerformed
    

    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
 jTextArea1.setText("");
jTextArea2.setText("");

         retriveRfidToConcat("Lab2");
         LecRfidToConcat("Lab2");
         int c2day = jComboBox3.getSelectedIndex();
         allocateLab("Lab2",c2day);
         
         displayAllocatedLabs();
         displayAllocatedLabs2();
         
          int x = JOptionPane.showConfirmDialog(rootPane, "Lecture schedules changed successfully\nDo you want to send sms notification?");
        
        if (x == JOptionPane.YES_OPTION) {
    smsScheduleChangeLab2();
        } 

    if (count == 3){
        //JOptionPane.showMessageDialog(rootPane, "Course & Student & Lecture tables updated succesfully");
        System.out.println("Course & Student & Lecture tables updated succesfully");
    }
    else{
        JOptionPane.showMessageDialog(rootPane, "Unsuccess");
    }
    count = 0;
         
    }//GEN-LAST:event_jButton3ActionPerformed


    public static void main(String args[]) {
        AssignLab al = new AssignLab();
        al.AddComboBoxItem();

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
            java.util.logging.Logger.getLogger(AssignLab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AssignLab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AssignLab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AssignLab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AssignLab().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables


        public void smsScheduleChangeLab1(){

            String day = (String) jComboBox3.getSelectedItem();
            String course = (String) jComboBox1.getSelectedItem();
                MainWindow mw = new MainWindow();
                mw.smsScheduleChange2(day, course, "Lab1");
                //mw.sendScheduleChangeToStud(day, course, "Lab1");
            
    }
        
                public void smsScheduleChangeLab2(){
            String day = (String) jComboBox3.getSelectedItem();
            String course = (String) jComboBox1.getSelectedItem();
                MainWindow mw = new MainWindow();
                mw.smsScheduleChange2(day, course, "Lab2");
    }

    
}