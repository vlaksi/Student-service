<h1 align = "center"> Student service </h1>

## About

This is an application for the needs of a student service officer with reliance on programming language
Java and the library for developing graphical user interface Swing
### 1. App layout
The main window contains:
1. Menu Bar of the application
2. Toolbar of the application
3. Table with selected entities
4. Status Bar of the application

#### 1.1 Application Menu (#menu_bar)
Menu bar has 3 menus, each of them with the following items, respectively
submenus :
1. File <br>
  a) New - Add a new entity to the system. <br>
  b) Close - Close the application.
2. Edit <br>
  a) Edit - Modify an existing entity. <br>
  b) Delete - Deletes an existing entity.
3. Help <br>
  a) Help - This section should contain a detailed description of how the application is used.
     Also, contain shortcuts(accelerators) for advanced users. <br>
  b) About - View the version of the application as well as a brief description of the application,followed by
     biography of each author.
     
<p align="center">
 <img width="500" height="130" src="https://user-images.githubusercontent.com/49925421/76365913-c9944300-6328-11ea-80da-48a592072f32.png">
</p>

#### 1.2 Toolbar Application (#toolbar)

The toolbar of the application contains 3 buttons and one text input field. Toolbar layout is given
on the picture

<p align="center">
 <img width="500" height="50" src="https://user-images.githubusercontent.com/49925421/76366820-5d670e80-632b-11ea-9147-2400a2bd5ea0.png">
</p>

The first button is to open a dialog to create a new student / professor / subject. The second button is used to open a dialog to modify an existing student / professor / subject while the third
button deletes the selected entity from the table.
The user can enter the combined search and with click on button search the table. The table will show satisfying entities.

#### 1.3 Status of the Application Bar (#status_bar)

The status of the application bar contains:
1) the current date
2) the current time
3) the name of the application
<p align="center">
 <img width="500" height="50" src="https://user-images.githubusercontent.com/49925421/76367441-56d99680-632d-11ea-83a5-d7d7512cbc00.png">
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

<p align="center">

  <img width="1111" height="550" src="https://user-images.githubusercontent.com/45834270/76363827-1f1a2100-6324-11ea-82ea-a6b9448d18a0.png">

</p>

<p align="center">

  <img width="1111" height="600" src="https://user-images.githubusercontent.com/45834270/76364025-89cb5c80-6324-11ea-8c03-a12335bf0043.png">

</p>

<p align="center">

  <img width="1111" height="600" src="https://user-images.githubusercontent.com/45834270/76364027-8b952000-6324-11ea-84ad-81a7e6ee970a.png">

</p>

<p align="center">

  <img width="1111" height="600" src="https://user-images.githubusercontent.com/45834270/76364032-8cc64d00-6324-11ea-8eed-8d7fcbffe68e.png">

</p>
