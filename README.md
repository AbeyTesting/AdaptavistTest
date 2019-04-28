#Test Execution – This test can be executed from "TestRunner.java" class located in "src/test/java" folder using TestNG Test i.e Run as TestNG Test. 

#The following consist of my test setup:
1)	MAVEN – Project and Build management tool which serves as my central repository to get dependencies (Selenium and TestNG).
2)	Java – Programming language used in this project hence, SeleniumIDE (Eclipse) and Java (JDK) were both installed on my 	machine. 
3)	Page Object Model & Page Factory – The design pattern/approach used for this exercise for easy maintainability, readability, 	reliability and re-usability of my script. The Page Factory also enables the usage of annotations @FindBy - to find 	WebElements and @CacheLookup - which helps to store frequently used web Elements. 
4)	Data – Stored all my data in a separate file (config.properties). The file contains data that can be manipulated and re-use. 	without having the need to alter or change any part of our code or framework e.g. browser and URL.
5)	Base Class – Contains methods that handles my browsers, the URL for the AUT and tear down method.
6)	TestNG – For Unit testing framework.

#Below are the step by step procedures I used to solve the Technical Test:
1)	Created a new MAVEN Project in Eclipse. 
2)	Added require dependencies in the pom.xml file e.g. Selenium 2.53.1 version and TestNG 6.9.10.
3)	Created a WebDriverExtension Class in "com.adapatavist.extension" package which contains re-usable methods like wait and 	getScreenshots.  
4)  Created a config.properties file to store value for our browser and url in the "com.adapatavist.config" package
5)  Created a Screenshots folder under the projects to save all our screenshots
6)  Created a Base Class to handles browser setup and teardown in the "com.adapatavist.util" package
7) 	Created Different Pages of the site which extends the Base Class and inherit its properties.Each page also contains its Page 	Objects, a Constructor – to initialise the page objects and Method(s) to perform a particular task on the page. 
8)  Created a TestRunner Class in the "com.adapatavist.runner" package to execute our test and Code implementation by creating 	instance of each page class and calling required methods.