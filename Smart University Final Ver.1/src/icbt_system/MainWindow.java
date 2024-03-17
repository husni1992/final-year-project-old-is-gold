
package icbt_system;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import gnu.io.CommPortIdentifier; 
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent; 
import gnu.io.SerialPortEventListener; 
import gnu.io.UnsupportedCommOperationException;
import java.awt.Color;
import java.awt.event.KeyEvent;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MainWindow extends javax.swing.JFrame implements SerialPortEventListener {

static MainWindow mw = new MainWindow();  
SerialPort serialPort;
private static final String PORT_NAMES[] = {"COM10"};

public BufferedReader input;
public static OutputStream output;
//public OutputStream output;
private static final int TIME_OUT = 2000;
private static final int DATA_RATE = 9600;

static Lab_simulator cls = new Lab_simulator();

static stud_reg s1 = new stud_reg();
static viewStudents vStud = new viewStudents();

static Register_Lecturer l1 = new Register_Lecturer();
static viewLecturers vLec = new viewLecturers();

static AddNewUser aduser = new AddNewUser();

static Course_reg c1 = new Course_reg();
static viewCourses vCrs = new viewCourses();

static AssignLab a1 = new AssignLab() ;


     //************** Open port ****************** 
    public void initialize() {
        
        //jDesktopPane2.setVisible(false);
        
    CommPortIdentifier portId = null;
    Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();   
    
    //First, Find an instance of serial port as set in PORT_NAMES.
    while (portEnum.hasMoreElements()) {
        CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
        for (String portName : PORT_NAMES) {
            if (currPortId.getName().equals(portName)) {
                portId = currPortId;
                break;
            }
        }
    }
    
    if (portId == null) {
        System.out.println("Could not find COM port.");
        return;
    }
    try {
        serialPort = (SerialPort) portId.open(this.getClass().getName(),
                TIME_OUT);
        serialPort.setSerialPortParams(DATA_RATE,SerialPort.DATABITS_8,SerialPort.STOPBITS_1,SerialPort.PARITY_NONE);

        // open the streams
        input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
        output = serialPort.getOutputStream();

        serialPort.addEventListener(this);
        serialPort.notifyOnDataAvailable(true);
        
    } catch (Exception e) {
       System.err.println(e.toString());
    }   
}
        String inputLine=null;
        String rfidNo;
        String smsTxt;
        String sendArd;
        int paymtArr;
        String ht;
        
        int returnVal;
    public synchronized void serialEvent(SerialPortEvent oEvent) {       
                
    if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
        //if ((oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE)&& (cls.isVisible())) {
        
        try {           
            
            if (input.ready()) {   
               
                inputLine = input.readLine();
                rfidNo = inputLine.substring(5);
                ht = inputLine.substring(3,4);
                
                if (l1.isVisible()){
                    l1.setRfid(rfidNo);
                }
       
                 if(s1.isVisible()){
                    s1.setRfid(rfidNo);
                  }

                 // >>>>>>>>>>>>>> run rfid check
                 checkStudTable();
                 if (returnVal == 0){
                  checkLecTable(); 
                 }                 
                 //  // >>>>>>>>>>>>>> run rfid check end                 
  
            }

        } catch (Exception e) {
             System.out.println(e);
              System.out.println("This is the error");
        }   
     }  
  } 
    
    public MainWindow() {
        initComponents();
        getContentPane().setBackground(Color.BLACK);
        setExtendedState(MAXIMIZED_BOTH);
        
        jDesktopPane2.setVisible(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton5 = new javax.swing.JButton();
        jMenu1 = new javax.swing.JMenu();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jButton5.setText("Register Lecturer");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Smart university System");
        getContentPane().setLayout(null);

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton1.setText("Add New Student");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(10, 110, 230, 30);

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton2.setText("Add New Course");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(9, 34, 230, 30);

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton3.setText("Exit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(20, 610, 210, 30);

        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton4.setText("Add New Lecturer");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(10, 70, 230, 30);

        jButton6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton6.setText("Reschedule Lecture");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(10, 150, 230, 30);

        jButton7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton7.setText("Class Room Simulator ");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7);
        jButton7.setBounds(10, 250, 230, 30);

        jButton8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton8.setText("View Students");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8);
        jButton8.setBounds(10, 410, 230, 30);

        jButton9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton9.setText("View Lecturers");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9);
        jButton9.setBounds(10, 450, 230, 30);

        jButton10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton10.setText("View Courses");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton10);
        jButton10.setBounds(10, 370, 230, 30);

        jDesktopPane2.setRequestFocusEnabled(false);
        getContentPane().add(jDesktopPane2);
        jDesktopPane2.setBounds(260, 40, 1000, 600);

        jButton12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton12.setText("Open Door");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton12);
        jButton12.setBounds(10, 290, 230, 30);

        jButton13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton13.setText("Add User Account");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton13);
        jButton13.setBounds(20, 570, 210, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Simulations");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(80, 230, 130, 14);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Course registration");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(60, 20, 130, 14);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Check database");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(70, 350, 100, 14);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
jDesktopPane2.setVisible(true);
        jDesktopPane2.removeAll();
        jDesktopPane2.repaint();

        jDesktopPane2.add(vLec);
        vLec.setUI(null);
        vLec.show();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
jDesktopPane2.setVisible(true);
        jDesktopPane2.removeAll();
        jDesktopPane2.repaint();

        jDesktopPane2.add(vStud);
        vStud.setUI(null);
        vStud.show();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
jDesktopPane2.setVisible(true);
        jDesktopPane2.removeAll();
        jDesktopPane2.repaint();

        jDesktopPane2.add(vCrs);
        vCrs.setUI(null);
        vCrs.show();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        int x = JOptionPane.showConfirmDialog(rootPane, "Are you sure to exit?");

        if (x == JOptionPane.YES_OPTION) {
            System.exit(0);
            serialPort.close();
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed

        String sendArd = "1 Lecturer Schedule changed";
        try {
            output.write(sendArd.getBytes());
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
jDesktopPane2.setVisible(true);
        jDesktopPane2.removeAll();
        jDesktopPane2.repaint();
        aduser.addComboBox();

        jDesktopPane2.add(aduser);
        aduser.setUI(null);
        aduser.show();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
jDesktopPane2.setVisible(true);
        jDesktopPane2.removeAll();
        jDesktopPane2.repaint();

        a1.resetAll();
        a1.AddComboBoxItem();
        a1.displayAllocatedLabs();
        a1.displayAllocatedLabs2();

        jDesktopPane2.add(a1);
        a1.setUI(null);
        a1.show();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
jDesktopPane2.setVisible(true);
        
        l1.resetText();
        l1.AddComboBoxItem();

        jDesktopPane2.removeAll();
        jDesktopPane2.repaint();

        jDesktopPane2.add(l1);
        l1.setUI(null);
        l1.show();

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
jDesktopPane2.setVisible(true);
        jDesktopPane2.removeAll();
        jDesktopPane2.repaint();

        Course_reg cReg = new Course_reg();
        jDesktopPane2.add(cReg);
        cReg.setUI(null);
        cReg.show();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
jDesktopPane2.setVisible(true);
        jDesktopPane2.removeAll();
        jDesktopPane2.repaint();

        jDesktopPane2.add(cls);
        cls.setUI(null);
        cls.show();

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
jDesktopPane2.setVisible(true);
        s1.resetText();
        s1.AddComboBoxItem();
        s1.clearRfid();

        jDesktopPane2.removeAll();
        jDesktopPane2.repaint();

        jDesktopPane2.add(s1);
        s1.setUI(null);
        s1.show();
    }//GEN-LAST:event_jButton1ActionPerformed
    
    String day;
    public void checkDay(String x){

        Connection con = null;
        Statement st = null;        

        String url = "jdbc:mysql://localhost:3306/smartuni";
        String user = "root";
        String password = "";               
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM courses WHERE course_id = '"+x+"'");           

            if (rs.next()) {
                day=rs.getString("lecDay");
            } 
            else{
               System.out.println("day not found");
            }     
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Error in searching");
            ex.printStackTrace();
        }
        
    }
    
    String studName1;
    String courseID;
    public void checkStudTable(){
        
        Calendar cal = Calendar.getInstance();
        int x = cal.get(Calendar.DAY_OF_WEEK);
        String dayOfWeek = Integer.toString(x);
        //>>>>>>>>>>>>>  Starting database sql code  >>>>>>>>>>>>>>         
        Connection con = null;
        Statement st = null;        

        String url = "jdbc:mysql://localhost:3306/smartuni";
        String user = "root";
        String password = "";               
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM students WHERE stud_rfid = '"+inputLine+"'");           

            if (rs.next()) {               
                returnVal = 1;

                System.out.println("Record found");
                String studMob = rs.getString("stud_mobile");    
                String studID = rs.getString("stud_id");
                
                studName1 = rs.getString("stud_name");
                String Srfid = rs.getString("stud_rfid");
                
                String s3 = rs.getString("fee");
                String s4 = rs.getString("paid");
                int fee = Integer.parseInt(s3);
                int paid = Integer.parseInt(s4);
                paymtArr = fee - paid;
                
                int xw = fee/2;
                System.out.println("Half amount is "+xw+". Paid "+paid);
                System.out.println("Arrier amount is "+paymtArr);

                // day checking code
                courseID = rs.getString("course_id");
                checkDay(courseID);
                if (day.equalsIgnoreCase(dayOfWeek)){                   
                    
               if(fee/2 < paid){
               System.out.println("Access Granted for "+inputLine+"");

                sendArd = "1 Access Granted";
                output.write(sendArd.getBytes());
                
                    if(ht.equalsIgnoreCase("1"))
                    {    
                        cls.attendance("");
                         cls.setNote1("");
                      cls.setNote2("");
                        
                    cls.lab2Text1("");
                    cls.lab2Text2("");
                    cls.lab1Text1("Access Granted");
                    cls.lab1Text2(rfidNo);
                    cls.door1Status("Door open");
                   }
                
                else if(ht.equalsIgnoreCase("2"))
                {
                    cls.attendance("");
                     cls.setNote1("");
                      cls.setNote2("");
                      
                    cls.lab1Text1("");
                    cls.lab1Text2("");
                    cls.lab2Text1("Access Granted");
                    cls.lab2Text2(rfidNo);  
                    cls.door2Status("Door open");   
                }
                     
                    markStudAttendance(studID,studName1,Srfid); 
                    //JOptionPane.showMessageDialog(null, "Day is matched");
                    cls.setNote1("You have lectures today");
                    cls.nameOfAttender("");
                    
                }

                else{
                    

                smsTxt = studName1+". You have "+paymtArr+" of payment to be settled. Please settle the arrears to attend lectures";
                sendArd = "2 Access Denied "+studMob+" "+smsTxt+"";
                output.write(sendArd.getBytes());
                
                
                System.out.println("Access denied for "+inputLine+"");
                 
                  if(ht.equalsIgnoreCase("1")){
                      cls.attendance("");
                      cls.setNote1("");
                      cls.setNote2("");
                      
                    cls.lab2Text2("");
                    cls.lab2Text1("");
                    cls.door1Status("Door closed");
                    cls.lab1Text1("Access Denied");
                    cls.lab1Text2(rfidNo);
  
                   } 
                  
                   else if(ht.equalsIgnoreCase("2"))
                   {
                       cls.attendance("");
                        cls.setNote1("");
                      cls.setNote2("");
                       
                       cls.lab1Text2("");
                       cls.lab1Text1("");
                       cls.door2Status("Door closed");
                    cls.lab2Text1("Access Denied");
                    cls.lab2Text2(rfidNo);  
                   }
                //JOptionPane.showMessageDialog(null,"Access Denied \nSms sent to "+studName1+"\n\"You have Rs."+paymtArr+". payment arrears\nPay your arrears to attend lectures");
                  cls.nameOfAttender("");
                  cls.attendance("You have lectures today");
                  cls.setNote1("But you don't have access");                 
                  cls.setNote2("You have arrears. [Sms sent to "+studName1+"]");
                }
                System.out.println(studMob);
                System.out.println("");
                    
                }
                else{
                    
                    if(ht.equalsIgnoreCase("1")){
                        
                        cls.attendance("");
                      cls.lab2Text2("");
                      cls.lab2Text1("");
                      cls.door1Status("Door closed");
                    cls.lab1Text1("Access Denied");
                    cls.lab1Text2(rfidNo);
  
                   } 
                  
                   else if(ht.equalsIgnoreCase("2"))
                   {
                       cls.attendance("");
                       cls.lab1Text2("");
                       cls.lab1Text1("");
                       cls.door2Status("Door closed");
                    cls.lab2Text1("Access Denied");
                    cls.lab2Text2(rfidNo);  
                   }
                    
                    //JOptionPane.showMessageDialog(null, "No access, day mismatch");
                   
                    
                    if(fee/2 > paid){
                        
                smsTxt = studName1+". You have "+paymtArr+" of payment to be settled. Please settle the arrears to attend lectures";
                sendArd = "2 Access Denied "+studMob+" "+smsTxt+"";
                output.write(sendArd.getBytes());
                
                System.out.println("Access denied for "+inputLine+"");
                 
                  if(ht.equalsIgnoreCase("1")){
                      
                      cls.attendance("");
                       cls.setNote1("");
                      cls.setNote2("");
                      
                      cls.lab2Text2("");
                      cls.lab2Text1("");
                      cls.door1Status("Door closed");
                    cls.lab1Text1("Access Denied");
                    cls.lab1Text2(rfidNo);
  
                   } 
                  
                   else if(ht.equalsIgnoreCase("2"))
                   {
                       cls.attendance("");
                      cls.setNote1("");
                      cls.setNote2("");
                       
                    cls.lab1Text2("");
                    cls.lab1Text1("");
                    cls.door2Status("Door closed");
                    cls.lab2Text1("Access Denied");
                    cls.lab2Text2(rfidNo);  
                   }
                //JOptionPane.showMessageDialog(null,"Access Denied & Day mismatch \nSMS: You have arrears \nSms sent to "+studName1+"\n\"You have Rs."+paymtArr+". payment arrears\nPay your arrears to attend lectures");
                cls.setNote1("You do not have lectures today");
                cls.setNote2("You have arrears. Sms sent to "+studName1+"");
                    }
                    else{
                    cls.setNote1("You do not have lectures today");
                    cls.setNote2("");
                    sendArd = "2 Access Denied";
                    output.write(sendArd.getBytes());
                    }
                     
                }
                //  The END OF day checking code

            } 
            else{
                returnVal = 0;
            }     
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Error in searching");
            
            ex.printStackTrace();
        } finally {
            try {                
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
              
                System.out.println(ex);
            }
        }
    }
    
     public void markStudAttendance(String x1 , String x2, String x3){
         
             // get time and date to get attendatnce
        Calendar cal = Calendar.getInstance();
        cal.getTime();
        SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss a");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");     
        // end of time and date
        
        String time = sdf1.format(cal.getTime());
        String date = sdf2.format(cal.getTime());
         
         Connection con = null;  
	 Statement stmt = null;
                     
             try {

			  Class.forName("com.mysql.jdbc.Driver");
			  con =DriverManager.getConnection ("jdbc:mysql://localhost:3306/SmartUni","root","");
			  stmt = con.createStatement();
			  
			  String query =("INSERT INTO studattendance values('"+x1+"','"+x2+"','"+x3+"','"+date+"','"+time+"')");
			  Statement statement = null;
			  statement = (Statement) con.createStatement();
                          try{
                              statement.executeUpdate(query);
                              //JOptionPane.showMessageDialog(rootPane, "Attendance marked success...");
                              cls.attendance("Student attendance recorded");
                          }catch (Exception e){
                              System.out.println("Duplicate value entered...");
                              
                          }

			 } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Error in Saving...");
                             
            ex.printStackTrace();
        }
         
        }
    
    String lecName;

    public void checkLecTable(){
        
        Calendar cal = Calendar.getInstance();
        int x = cal.get(Calendar.DAY_OF_WEEK);
        String dayOfWeek = Integer.toString(x);
        
        //>>>>>>>>>>>>>  Starting database sql code  >>>>>>>>>>>>>>      
        
        Connection con = null;
        Statement st = null;        

        String url = "jdbc:mysql://localhost:3306/smartuni";
        String user = "root";
        String password = "";               
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM lecturers WHERE lec_rfid = '"+inputLine+"'");           
            
            if (rs.next()) {
                

             courseID = rs.getString("course_id");
             checkDay(courseID);
             if (day.equalsIgnoreCase(dayOfWeek)){
                 cls.setNote1("Day mismatch, Lecturer welcome");
                 
                 
                String s1 = rs.getString("course_id");
                System.out.println(s1);
                
                String lecId = rs.getString("lec_id");
                lecName = rs.getString("lec_name");
                String lRfid = rs.getString("lec_rfid");
                
                
                if(ht.equalsIgnoreCase("1")){

                    cls.attendance("");
                    cls.setNote1("");
                    cls.setNote2("");
                    
                    cls.setNote1("Lecturer welcome");
                    cls.setNote2("SMS sent to all studnts");
                    
                    cls.lab2Text2("");
                    cls.lab2Text1("");
                    cls.lab1Text1("Access Granted");
                    cls.lab1Text2(rfidNo);
                    cls.door1Status("Door opened");
            
                }
                else if(ht.equalsIgnoreCase("2")){

                    cls.setNote1("Lecturer welcome");
                    cls.setNote2("SMS sent to all studnts");
                    
                    cls.lab1Text2("");
                    cls.lab1Text1("");
                    cls.lab2Text1("Access Granted");
                    cls.lab2Text2(rfidNo);  
                   cls.door2Status("Door opened");
                }
                
                sendSMSTOStuds(s1,lecName);
 
                markLecAttendance(lecId,lecName,lRfid); 
                 
             }else{
                    if(ht.equalsIgnoreCase("1")){
                        
                    cls.attendance("");
                    cls.setNote1("");
                    cls.setNote2("");
                    
                        
                    cls.lab2Text2("");
                    cls.lab2Text1("");
                    cls.door1Status("Door closed");
                    cls.lab1Text1("Access Denied");
                    cls.lab1Text2(rfidNo);
  
                }
                else if(ht.equalsIgnoreCase("2")){
                     
                    cls.attendance("");
                    cls.setNote1("");
                    cls.setNote2("");
                    
                    cls.lab1Text2("");
                    cls.lab1Text1("");
                    cls.door2Status("Door closed");
                    cls.lab2Text1("Access Denied");
                    cls.lab2Text2(rfidNo);  
                }
               
                    cls.setNote1("Lecturer ");
                    cls.setNote2("You don't have lectures today");
                    
                    sendArd = "2 Access Denied";
                    output.write(sendArd.getBytes());
                    
             }
               
            } 

            else {
                sendArd = "2 Not this class";
                output.write(sendArd.getBytes());
                
                cls.setNote1("Not this class");
                
                cls.nameOfAttender("");
                
                System.out.println("Access denied for "+inputLine+"");
                System.out.println("Unidentified RFID tag");
                System.out.println("");
                
                  if(ht.equalsIgnoreCase("1")){
                      
                    cls.attendance("");
                    //cls.setNote1("");
                    cls.setNote2("");
                      
                    cls.lab2Text2("");
                    cls.lab2Text1("");
                    cls.door1Status("Door closed");
                    cls.lab1Text1("Access Denied");
                    cls.lab1Text2(rfidNo);
  
                }
                else if(ht.equalsIgnoreCase("2")){
                    
                    cls.attendance("");
                    //cls.setNote1("");
                    cls.setNote2("");
                    
                    cls.lab1Text2("");
                    cls.lab1Text1("");
                    cls.door2Status("Door closed");
                    cls.lab2Text1("Access Denied");
                    cls.lab2Text2(rfidNo);  
                }
            }  
           
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Error in searching");
            ex.printStackTrace();
        } finally {
            try {                
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
              
                System.out.println(ex);
            }
        }
//>>>>>>>>>>>>>>>>>>>>>>>   End of Search database code  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    }
    
    public void markLecAttendance(String x1, String x2, String x3){ 
       
                     // get time and date to get attendatnce
        Calendar cal = Calendar.getInstance();
        cal.getTime();
        SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss a");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");     
        // end of time and date
        
        String time = sdf1.format(cal.getTime());
        String date = sdf2.format(cal.getTime());
         
         Connection con = null;  
	 Statement stmt = null;
                     
             try {
             
			  Class.forName("com.mysql.jdbc.Driver");
			  con =DriverManager.getConnection ("jdbc:mysql://localhost:3306/SmartUni","root","");
			  stmt = con.createStatement();
			  
			  String query =("INSERT INTO lecattendance values('"+x1+"','"+x2+"','"+x3+"','"+date+"','"+time+"')");
			  Statement statement = null;
			  statement = (Statement) con.createStatement();
                          try{
                              statement.executeUpdate(query);
                              //JOptionPane.showMessageDialog(rootPane, "Attendance marked success...");
                              cls.attendance("Lecturer attendance recorded");
                          }catch (Exception e){
                              System.out.println(e);
                              
                          }

			 } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Error in Saving...");
                             
            ex.printStackTrace();
        }
        
    }
    
    public void sendSMSTOStuds(String x , String lecName){
        String id = x;
        String cName = null;
                      //>>>>>>>>>>>>>  Starting database sql code  >>>>>>>>>>>>>>         
        Connection con = null;
        Statement st = null;        

        String url = "jdbc:mysql://localhost:3306/smartuni";
        String user = "root";
        String password = "";  
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM students WHERE course_id = '"+id+"'");           
              int count = 0;
              String mob = null;
              
              Vector vc=new Vector();
              
            while (rs.next()) {
                count = count+1;

                String s1 = rs.getString("stud_id");
                cName =rs.getString("stud_course");
                System.out.println(s1);
                
                 mob = rs.getString("stud_mobile");
                 vc.add(mob);               
            } 
            
            System.out.println(vc);
            // [+94775555555, +94771111111, +94777777777, +94776511996]
            
            String txt = cName+" Lecturer, "+lecName+" arrived lab no."+ht+". please attend the class soon";   
            System.out.println(txt);
              count = count +10;
              // 10 is added to count.. then it is again substracted in arduino code,, to avoid intefere with led blick n buzzer. 
                sendArd = count+"v Access Granted "+vc+""+txt; 
                
                
                System.out.println("This is sent to arduino "+sendArd);
               output.write(sendArd.getBytes()); 
               
               cls.nameOfAttender(lecName+" ("+cName+")");
                
            System.out.println("Count is "+count);
                        
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Error in searching");
            ex.printStackTrace();
        } finally {
            try {                
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
              
                System.out.println(ex);
            }
        }
//>>>>>>>>>>>>>>>>>>>>>>>   End of Search database code  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    }
    
 

    public static void main(String args[]) {
        
        mw.initialize();
   
        Calendar cal = Calendar.getInstance();
        cal.getTime();

        SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss a");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        
        String time = sdf1.format(cal.getTime());
        String date = sdf2.format(cal.getTime()); 
        
        System.out.println("Data is "+date+".\nCurrent time is "+time);
        
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
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);;
            }
        });
        
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    // End of variables declaration//GEN-END:variables



    public void smsScheduleChange2(String day, String course, String lab) {
        
        sendScheduleChangeToStud(day,course,lab);
        sendScheduleChangeToLec(day,course,lab);
    }
   
        int count = 0;
        Vector vc=new Vector();
    
    public void sendScheduleChangeToStud(String day, String course, String lab) {
                   try{ 
   
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SmartUni","root","");
    Statement st=conn.createStatement();
    ResultSet rs=st.executeQuery("SELECT * FROM students WHERE stud_course='"+course+"'");

        while(rs.next()){
            count = count+1;
            
            String name = rs.getString("stud_name");
            System.out.println(name);
            String mob = rs.getString("stud_mobile");
            vc.add(mob);            
        }        
    
    }catch(Exception e){
        System.out.println(e);
    }
    }
    
    public void sendScheduleChangeToLec(String day, String course, String lab) {
                   try{ 
   
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SmartUni","root","");
    Statement st=conn.createStatement();
    ResultSet rs=st.executeQuery("SELECT * FROM lecturers WHERE lec_course='"+course+"'");
  String subjct=null;
        while(rs.next()){
            count = count+1;
            
            String name = rs.getString("lec_name");
            System.out.println(name);
            String mob = rs.getString("lec_mobile");
            subjct = rs.getString("lec_course");
            vc.add(mob);            
        }        
                
                count = count +10;
               String txt = subjct+" lecture has been rescheduled to "+day+" at "+lab+". Sorry for the inconvenience caused";
               System.out.println(txt);
                //sendArd = count+" Access Granted "+txt+numList;
               String sendArdx = count+"t Lecturer Schedule changed."+vc+""+txt; 
  
               output.write(sendArdx.getBytes());
               System.out.println("count is "+count);
               System.out.println("This is sent to arduino "+sendArdx);
        
    }catch(Exception e){
        System.out.println(e);
    }
    }
    
}
