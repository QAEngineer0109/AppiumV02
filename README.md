AppiumV02 – Appium Android Automation Framework
Overview

AppiumV02 is an Appium-based Android automation framework designed to run end-to-end tests on a real Android device.
The project emphasizes clean framework design, stability, and maintainability, using the Page Object Model (POM) with TestNG-based execution.

This framework reflects real-world mobile automation constraints where device availability limits parallel execution.

Tech Stack

Java 21

Appium (Java Client)

Selenium 4

TestNG

Maven

Extent Reports

Log4j2

Test Coverage

The framework includes end-to-end mobile test flows such as:

Application launch validation

Form input and navigation

Product selection and cart validation

Toast message validation

Terms & Conditions handling

Complete purchase flow (real-device safe)

Framework Design

Page Object Model (POM) for maintainability and readability

BaseTest / BasePage abstraction for driver setup and common actions

Explicit waits encapsulated within base actions to reduce flakiness

TestNG Listeners for reporting (Extent Reports)

Retry Analyzer utility included for optional controlled re-execution of flaky tests

Screenshots captured on test failure only

Centralized logging using Log4j2

Real Device Execution

Tests are executed on a single physical Android device using Appium with UiAutomator2.

Because a real device is used:

Tests run sequentially within a single device session

Parallel execution is limited by hardware constraints

ThreadLocal driver management is implemented to maintain framework correctness and enable future scalability

This setup mirrors real-world mobile automation environments where device access is constrained.

Project Structure
src/test/java
 ├── appiumTests    # Test classes
 ├── base           # BaseTest / BasePage / driver setup
 ├── pages          # Page Object classes
 ├── listeners      # TestNG listeners (Extent Reports)
 └── utils           # Retry utility, screenshots, helpers

src/test/resources
 └── log4j2.xml

How to Run Tests
Prerequisites

Appium Server running

Android device connected with USB debugging enabled

Device name and app path configured if required

Execution

Run tests using:

testng.xml

or:

mvn test

Reports & Logs

Extent Reports generated under /reports

Execution logs generated under /logs

Screenshots captured automatically on test failure

Notes

This project prioritizes framework structure, clarity, and real-device stability over emulator-based parallel execution.
The design is intended to be easily extended as additional devices or CI execution environments are introduced.
