# Final Year Project: IoT Smart Access System

## Introduction

Guess what...while I was cleaning my old google drive, I found a backup of my final year project from 10 years ago...the days I was uncertain of my future.. still remember the determination I had to complete this project.. I hardly knew how to code, but learnt everything within a very short time... Everytime I remembered this project, I realize how talented I am. WOW

## Project Description

Let me write what the project is about - This is an **IoT smart access system for a university** built with Arduino and Java. The components of the system were:
    - RFID reader.
    - A real door that opens programmatically with a relay circuit.
    - LCD panel
    - GSM module
    - SQL database
    - GUI built with Java

The idea was to provide access to students to different class rooms based on whether he/she has access to the classroom. Also if a lecturer enters a class room, all the students that belongs to the class will receive a SMS message.

## How It Works

Every student and lecturer has a unique access key (RFID card) given to them when registering with the university. The model had a real door with a relay circuit that opens automatically with an RFID card. The database stores all the students and lecturers. When a student or lecturer scans the RFID at the door (RFID scanner), the Arduino sends the card metadata to the system and checks the DB to see if the particular person has access to the classroom. If yes, then the door opens.

## Presentation

For a detailed overview of the project, you can view the presentation on Google Slides:

[View Presentation](https://docs.google.com/presentation/d/1OfkMGV9xLGyqtmAP1k3RksKIVwoi3LfM/edit#slide=id.p1)

## Personal Reflection

Side story: I had only 6 months to choose what to do in the final year project. I did not know a programming language in depth. Anyway I had to complete the project within 6 month. I was super determined that I would do this. I can't imagine how I did it. But I did it exactly how I expected and surprised the lecturers too. Everytime I get imposter syndrome, I used to remind myself of this project. I wish I had a video recording of the demonstration, but unfortunately I don't.