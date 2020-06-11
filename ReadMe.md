Project Structure :

# Created constant class
1.Added all the error/text messages in constant class.

#Created TestListner class:
1.Created TestListner class to implements all the methods of ITestListener interface to get better logging.
2.Created onTestFailure Method to get full printStackTrace of failed test case.


#Pages:
1.Created BasePage As a parent page so that all the properties of Base Page can be called to it's child classes(Inheritance)
2.Uses Page factory pattern (POM) to creates Object Repository for web UI elements.
3.It helps make the code more readable, maintainable, and reusable.

#TestBase
1.Testbase is a common(Parent Class) for all the test cases.
2.It will initiate the WebDriver interface with chrome or firefox Driver class.

#TestCases
1.TestCases will extend the TestBase class and initialize the driver.
2.Verify positive and negative scenarios.


#TestNG
1.Used TestNG Testing Framework to priorities and Assert the test cases.
1.Used TestNG anotations to Execute test cases

#pom.xml
1.Added all the required dependencies which are required to execute/write program.
2.Added compiler and surefire plugin to compile the source code of a Maven project and to run the project test.
4.command to compile and run : "mvn clean compile" or "mvn clean test"
5.Added Allure Reporting dependencies and reporting plugin.

#Reporting
1.Added Allure Reports to provide good representation of test execution output.
2.Anotations in test classes can be used for better representation of test executions.
3.To Execute/See the reports need to enter below command on the project path.
command: "allure serve"