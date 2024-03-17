
#include <SoftwareSerial.h>
#include <String.h>
SoftwareSerial mySerial(40, 41);

#include <LiquidCrystal.h>
LiquidCrystal lcd(12, 11, 10, 9, 8, 7);

//String str;
int x;
String inData;

String num; // sms number
String txt; // sms txt
String dis; 
String chk;

int count = 0; 

void setup() {
      
   mySerial.begin(19200);  // the GPRS baud rate   
 //  delay(500);
  
    lcd.begin(16, 2);
    lcd.print("   Swipe card");

    Serial.begin(9600);
    Serial.setTimeout(5);
  
    Serial1.begin(9600);
    Serial2.begin(9600);
  
    pinMode(2, OUTPUT);
    pinMode(3, OUTPUT);
    pinMode(48, OUTPUT);  // Buzzer
    pinMode(49, OUTPUT); // Lock
}

void loop() {

if (Serial.available()>0)
       {        
        x = Serial.parseInt(); // gets the first integer in the incomming serial data, (only 1st int wil be taken.. other integers are skipped after the 1st one)
        inData = Serial.readString();
        //dis = inData.substring(0,15);  // inside brackets we can give a range , start to end of string (2,15) then it will print string in between 2 and 5
        // str = Serial.readStringUntil('.'); //This reads the string after the 1st space in the serial
        chk = inData.substring(0,1);
               

     // access granted
  if(x == 1){
         dis = inData.substring(0,15); 
          lcd.clear(); 
          lcd.print(dis);
         
         digitalWrite(3, LOW);
         digitalWrite(2, HIGH);        
       
       // Buzzer
         digitalWrite(48, HIGH);
         delay(200);
         digitalWrite(48, LOW);  
       
       // Open door
         digitalWrite(49, HIGH);
         delay(1000);
         digitalWrite(49, LOW); 
       // end open door
       
       }
       
   // Access denied      
   if(x == 2)
       {   
         dis = inData.substring(0,15); 
         lcd.clear(); 
         lcd.print(dis);
         
          num = inData.substring(15,27);
          txt = inData.substring(28,150);

          
         digitalWrite(2, LOW);
         digitalWrite(3, HIGH); 
         
         // Buzzer
         digitalWrite(48, HIGH);
         delay(50);
         digitalWrite(48, LOW);  
         delay(50);
         digitalWrite(48, HIGH);
         delay(50);
         digitalWrite(48, LOW);
          // Buzzer end
         
         SendTextMessage();
       }

// sms Lec attendance       
   if(chk.equals("v")) {
     
     // substracted 10 from count... to identify count differently... without affecting led blick or any other chk value
     x=x-10;
     
         dis = inData.substring(1,16); 
         lcd.clear(); 
          lcd.print(dis);
        
         digitalWrite(3, HIGH);
         digitalWrite(2, HIGH);  
         
         //Buzzer
         digitalWrite(48, HIGH);
         delay(200);
         digitalWrite(48, LOW);  
        // end buzzer
        
        // Open door
         digitalWrite(49, HIGH);
         delay(1000);
         digitalWrite(49, LOW); 
       // end open door
        
        int n = 18;
        int y = 12;
        int w;
    
     int numCount = 14*x;
    
      int txtStrt = 17+(numCount);
      int txtEnd = txtStrt + 150;

      int xcount = 0;
      txt = inData.substring(txtStrt,txtEnd);   
      
         while(xcount<x){
           xcount++;
           
           w=n+y;
           num = inData.substring(n,w);
           
           SendTextMessage();
           n=w+2;
           delay(4000);
          }
       }
       
// sms schedule change
       
      if(chk.equals("t")) {
        
        // substracted 10 from count... to identify count differently... without affecting led blick or any other chk value
        x=x-10;
        
        lcd.clear();
        lcd.print("Schedule changed");
        delay(1000);
               
        int n = 29;
        int y = 12;
        int w;
    
     int numCount = 14*x;
    
      int txtStrt = 28+(numCount);
      int txtEnd = txtStrt + 100;

      int xcount = 0;
      txt = inData.substring(txtStrt,txtEnd);   
      
         while(xcount<x){
           xcount++;
           
           w=n+y;
           num = inData.substring(n,w);
           
           SendTextMessage();
           n=w+2;
           delay(4000);
          }

       }
       
// end of sms schedule change
  
 }

// >> Start rfid read function  >>>>>>>>>>>>>>>>>>>>>>>>>>> and send to java 
if(Serial1.available()) {
      if(count==0){
       Serial.print("Lab1_"); 
      }
      
      int i = Serial1.read();    
      Serial.print(i);
      count++;    
      }
        if(count==4){
        Serial.println("");    
        count=0;
      }     

if(Serial2.available()) {
        if(count==0){
        Serial.print("Lab2_"); 
        }
      
       int i = Serial2.read();    
       Serial.print(i);
       count++;    
       }
        if(count==4){
        Serial.println("");
        count=0;
       }
}


void SendTextMessage()
{
     mySerial.print("AT+CMGF=1\r");    //Because we want to send the SMS in text mode
     delay(100);
     mySerial.println("AT + CMGS = \""+num+"\"");//send sms message, be careful need to add a country code before the cellphone number
     delay(100);
     mySerial.println(""+txt+"");//the content of the message
     delay(100);
     mySerial.println((char)26);//the ASCII code of the ctrl+z is 26
     delay(100);
     mySerial.println();
}



