<h1 align = "center"> Student service </h1>

## About

This is an application for the needs of a student service officer with reliance on the programming language
Java and the library for developing graphical user interface Swing
### 1. App layout
The main window contains:
1. Menu Bar of the application
2. The toolbar of the application
3. Table with selected entities
4. Status Bar of the application

#### 1.1 Application Menu (#menu_bar)
The menu bar has 3 menus, each of them with the following items, respectively
submenus :
1. File <br>
  a) New - Add a new entity to the system. <br>
  b) Close - Close the application.
2. Edit <br>
  a) Edit - Modify an existing entity. <br>
  b) Delete - Deletes an existing entity.
3. Help <br>
  a) Help - This section should contain a detailed description of how the application is used. Also, it contains shortcuts(accelerators) for advanced users. <br>
  b) About - View the version of the application as well as a brief description of the application, followed by a biography of each author.
     
<p align="center">
 <img width="500" height="130" src="https://user-images.githubusercontent.com/49925421/76365913-c9944300-6328-11ea-80da-48a592072f32.png">
</p>

#### 1.2 Toolbar Application (#toolbar)

The toolbar of the application contains 3 buttons and one text input field. Toolbar layout is given
on the picture

<p align="center">
 <img width="500" height="50" src="https://user-images.githubusercontent.com/49925421/76366820-5d670e80-632b-11ea-9147-2400a2bd5ea0.png">
</p>

The first button is to open a dialog to create a new student/professor/subject. The second button is used to open a dialog to modify an existing student/professor/subject while the third button deletes the selected entity from the table. The user can enter the combined search and click on the button to search the table. The table will show satisfying entities.

#### 1.3 Status of the Application Bar (#status_bar)

The status of the application bar contains:
1) the current date
2) the current time
3) the name of the application
<p align="center">
 <img width="1111" height="35" src="https://user-images.githubusercontent.com/49925421/77109701-b702c380-6a24-11ea-9248-193e6058fd7a.png">
</p>

### 2. System model

The application handles with the following entities, which have the following attributes: <br> <br>
Student (#student) <br>
• Name <br>
• Surname <br>
• Date of birth <br>
• Residential address <br>
• Contact phone <br>
• E-mail address <br>
• Index number <br>
• Date of entry <br>
• Current year of study <br>
• Status (enum type: “B” - for budget and “S” - for self-financing) <br>
• Average rating <br>
• List of courses the student listens to <br> <br>
Professor (#professor) <br>
• Name <br> 
• Surname <br>
• Date of birth <br>
• Residential address <br>
• Contact phone <br>
• E-mail address <br>
• Office address <br>
• ID number <br>
• Title <br>
• Calling <br>
• A list of subjects the professor is on <br><br>

Subject (# subject) <br>
• Item code <br>
• Name of the subject <br>
• Semester <br>
• Year of study in which the course is taught <br>
• Subject Professor <br>
• List of students listening to the course <br>
## Functionality

### View a list of course that student is attending
Selecting the button "Prikazi" (View) we can see a list of courses that student is attending

  <img width="1111" height="560" src="https://user-images.githubusercontent.com/45834270/76363827-1f1a2100-6324-11ea-82ea-a6b9448d18a0.png">


### View a list of students who are attending that course
Selecting the button "Prikazi" (View) we can see list of students who attending that course, also we can delete students from that course selecting button "Obrisi" (Delete).

  <img width="1111" height="560" src="https://user-images.githubusercontent.com/45834270/76364025-89cb5c80-6324-11ea-8c03-a12335bf0043.png">


### Adding a student

Selecting the appropriate button (in this example, it is the first button from the toolbar) opens
new dialog to add student

  
  <img width="1111" height="560" src="https://user-images.githubusercontent.com/45834270/76364027-8b952000-6324-11ea-84ad-81a7e6ee970a.png">
  

### Editing student

Selecting the appropriate button (this is the second toolbar button in the example) opens
a new dialog to change the selected student from the spreadsheet 


<p align="center">

  <img width="1111" height="560" src="https://user-images.githubusercontent.com/45834270/76364032-8cc64d00-6324-11ea-8eed-8d7fcbffe68e.png">

</p>

### Deleting a student
Selecting the appropriate button (in this example, it is the third button in the toolbar) opens
a new dialog where the user needs to confirm whether they want to delete the selected student from
tables

<img width="1111" height="560" src="https://user-images.githubusercontent.com/49925421/77107857-96853a00-6a21-11ea-9484-7bf22f90a68b.jpeg">

### Sorting a students

Sorting all students in the table by: <br>
a) index (ascending / descending) <br>
b) name (ascending / descending) <br>
c) surname (ascending / descending) <br>
d) date of birth (ascending / descending) <br>
e) year of enrollment (ascending / descending) <br>
f) status (ascending / descending) <br>
g) average grade (rising / falling) <br>

<img width="1111" height="560" src="https://user-images.githubusercontent.com/49925421/77109019-84a49680-6a23-11ea-9d66-a159337c8a49.jpeg">

### Student search
<img width="1111" height="560" src="https://user-images.githubusercontent.com/49925421/77111526-cc2d2180-6a27-11ea-9fae-5017d65b1b33.jpeg">
<img width="1111" height="560" src="https://user-images.githubusercontent.com/49925421/77111634-f67edf00-6a27-11ea-8be3-55679552fc7a.jpeg">

### Adding students to the course (It is only possible to add students who matches the year of corresponding course)
<img width="1111" height="560" src="https://user-images.githubusercontent.com/49925421/77110891-9cc9e500-6a26-11ea-9398-cf5470c3afff.jpeg">

### Deliting students from the course
<img width="1111" height="560" src="https://user-images.githubusercontent.com/49925421/77111163-24175880-6a27-11ea-965e-b9cefcd05b0a.jpeg">
