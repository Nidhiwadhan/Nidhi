
Overview

This project provides an end-to-end automation framework using:

•	Selenium (Java) → Cross-browser legacy/enterprise coverage 

The framework is designed for scalability, reliability, and CI integration, with strong reporting and failure diagnostics.
 
Setup & Run Instructions

Prerequisites

•	Java (JDK 11+) 

•	Maven 

•	Git 

 
Install dependencies

Selenium

mvn clean install
 
Run tests locally

Selenium (all tests)

mvn test

Selenium (specific suite)

mvn test -DsuiteXmlFile=testng.xml
 
Reports

Selenium reports

•	TestNG reports → /test-output 

•	Logs → /logs 
 
CI Pipeline (GitHub Actions)

name: Automation Tests

on:
  push:
  
  pull_request:

jobs:

  test:
  
    runs-on: ubuntu-latest

    steps:
    
      - name: Checkout
      
        uses: actions/checkout@v3

      # Setup Java for Selenium
      
      - name: Setup Java
      
        uses: actions/setup-java@v3
        
        with:
        
          distribution: temurin
          
          java-version: 11

      - name: Run Selenium Tests
      
        run: mvn test

      # Upload Selenium artifacts
      
      - name: Upload Selenium Reports
      
        uses: actions/upload-artifact@v3
        
        if: always()
        
        with:
        
          name: selenium-reports
          
          path: |
          
            target/
            
            test-output/
            
            logs/
            
 Design Decisions
 
Architecture

/selenium

  /tests
  
  /pages
  
  /utils
 
Patterns Used

Page Object Model (POM)

•	Encapsulates locators and actions 

•	Promotes reusability and maintainability 

Reusable utilities

•	Common methods for waits, data handling, logging 

Automatically captured on failure:

Selenium

Captured via framework setup:

Screenshots on failure 

Reports

Selenium

•	JUnit XML (for CI integration) 


