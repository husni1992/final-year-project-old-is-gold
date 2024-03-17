int count = 0; 

const int ledPin =  2;      // the number of the LED pin

// Variables will change:
int ledState = LOW;             // ledState used to set the LED
long previousMillis = 0;        // will store last time LED was updated


long interval = 1500;           

void setup() {
  pinMode(ledPin, OUTPUT);   

    Serial.begin(9600);
    Serial1.begin(9600);
    Serial2.begin(9600);  
}

void loop()
{

  
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
  
  
  unsigned long currentMillis = millis();
 
  if(currentMillis - previousMillis > interval) {
   
    previousMillis = currentMillis;   

    if (ledState == LOW)
      ledState = HIGH;
    else
      ledState = LOW;

    digitalWrite(ledPin, ledState);
  }
}

