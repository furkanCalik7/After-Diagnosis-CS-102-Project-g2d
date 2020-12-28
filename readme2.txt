       g2D AFTER DIAGNOSIS
 
Description: After diagnosis a communication application for patients, doctors, lab technicians and admins. 
Our program aims to connect the patients with their doctors after the first treatment. 
Program is used by doctors, lab technicians and administrators other than patients. 
They all have separate login information and interfaces.

Project's current statue: The current statue of our project is almost finished. 
Although we have limited time and upcoming finals, we achieved to create a working demo even though it contains bugs to a certain extent.
In the current statue, all users send, get messages and see their messages. They can adjust their information. They connect their system by using username and password etc. 
Users can use their relative features such as adding drugs to a patient for a doctor. Or doctors and lab technicians can upload and/or download test results as files in our project.
However, like I said before, the program includes some bugs and it needs some work in order for it to update views after the controller is used by users.

Technologies we used: In this project, we used mostly github to construct a project collaboratively, intellij to java ide ,java version 15, eclipse to build gui. 
We also used 4 external libraries which are "JPlanner" and "LGoodDatePicker " for date picker and presentation in gui,
"mail" to gain the send mail to real email addresses and as a core, "mysql-connection-java" to access database and store and receive data. 
Additionally, we used pop sql and mysql workbench to manipulate the database we used. We used EducationHost to create a server to maintain our database,
which we found from github student pack. In order to create the GUI part, we used Eclipse window builder which gives the most organized code among other IDEs.

Setup instructions : To run our program, the four external libraries I stated above are required to add the classpath. 
Then to run the program, it is enough to run "Runner" class.
	

Furkan Çalik: I worked on connection and creation of database and wrote the model classes with Furkan Güzelant. 
I designed the tables in the database and wrote the methods in java application to connect database and get and store information from database. 
I designed and wrote the mainly doctor and lab technician model classes. 
Additionally, I created some of the other model classes in the application such as message, test, test request etc. 
Then, I edited the doctor gui classes to some extent. I integrated doctor gui and doctor model classes and wroted controllers for doctors view and model. 
I helped to write and design some of the views classes to my friends such as message view class.

Furkan Güzelant: I also worked on connection and creation of the database.
I created and designed the tables in the database together with Furkan Çalik.
I was also responsible for implementing some model classes such as Admin and Patient.
Additionally, I wrote some of the methods of MySQLAccess class which gets information from database and insert and updates data in database.
I also implemented some controller classes, especially for Admin and Patient.
I worked on the integration of gui and model classes of admin and patients and some other dependency classes such as EmailUtil.


Berkay Çalmaz: Even though I intended to build modal classes, I switched to building GUI part of the project.
I have researched multiple platforms and found the Eclipse IDE to get the most organized code from a window-builder. 
I have integrated the necessary codes to switch between panels. 
In GUI, I was responsible for the Doctor frame and panels where every user use such as messages, settings and button panels. 
Additionally I constructed the login page's both GUI and its implementation to a certain extent.


Bilgehan Sandıkcı: At the beginning I intended to create some model classes such as Doctor and Lab technician classes.
Due to the need for the database access and knowledge about inner codes of it.
I stopped implementing model classes and switched to building the GUI design and view/controller implementation of the Lab Technician class. 
I also implemented the file choosers for the lab technicians.

