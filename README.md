# ClearpointToDoAPI
This project provides the solution to run the Clearpoint ToDo API automation using Serenity, Cucumber and RestAssured all working together to run the test.
This Readme page helps to understand how to run the test after cloning the project.

# Application under test
In this project, the API under test is running on http://localhost:3002/. 

# How to run
-	Go to the folder path where your project POM.xml resides 
- Open the terminal and type
-	**mvn clean verify** – This will run the scenarios from ToDoItem.feature
-	Or using this command **“mvn clean verify serenity:aggregate”**  will run all scenarios and produce the aggregated results.

# How to add further tests
For a new story
-	Design your feature files based on your acceptance criteria and what your user wants to achieve
-	Create your step definitions by follwoing the project structure

# Reporting
- This project uses the Serenity reports which acts as a living documentation of results.
- After running the **"mvn clean verify", the report is available at **\ClearpointToDoAPI-master\reports\timestamp** folder if the test is initiated from the command prompt.
- If tests are started from **TestRunner** class (which is inside cucumberRunner.Runner), then results will be available at **target/site/serenity/index.html**
- This is how the tests will be executed from the terminal and all the details regarding the tests and the report paths will be shown to the user.
<img width="1564" alt="image" src="https://user-images.githubusercontent.com/26117118/184588950-92c28ec0-3a26-4696-9db1-687d10625871.png">
