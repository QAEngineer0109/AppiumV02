# AppiumV02
Appium Test Suite
# Appium Android Automation Framework (Real Device)

This project is an Appium-based automation framework for testing an Android application on a **physical Android device**.  
It demonstrates a clean Page Object Model (POM) design, TestNG-based execution, reporting, logging, and retry handling.

---

## Tech Stack
- Java 21
- Appium (Java Client)
- Selenium 4
- TestNG
- Maven
- Extent Reports
- Log4j2

---

## Test Coverage
The framework includes end-to-end mobile test flows such as:
- App launch validation
- Form input and navigation
- Product selection and cart validation
- Toast message validation
- Terms & Conditions handling
- Complete purchase flow (real-device safe)

---

## Framework Design
- **Page Object Model (POM)** for maintainability
- **BaseTest / BasePage** for driver and common actions
- **Explicit waits** encapsulated in base actions
- **TestNG Listeners** for reporting
- **Retry Analyzer** for controlled re-execution of flaky tests
- **Screenshots on failure only**
- **Logging via Log4j2**

---

## Real Device Execution
Tests are executed on a **single physical Android device** using Appium and UiAutomator2.

Because a real device is used:
- Tests run sequentially on one device session
- Parallel execution is limited by hardware constraints
- ThreadLocal driver management is still used for framework correctness and scalability

This mirrors real-world mobile automation environments where device availability is constrained.

---

## Project Structure
src/test/java
├── appiumTests # Test classes
├── base # BaseTest / BasePage / Driver setup
├── pages # Page Object classes
├── listeners # TestNG listeners (Extent Reports)
└── utils # Retry logic, screenshots, helpers

src/test/resources
└── log4j2.xml


---

## How to Run Tests
1. Start Appium server
2. Connect Android device (USB debugging enabled)
3. Update device name and app path if needed
4. Run via TestNG suite:
   - `testng.xml`
   - or `mvn test`

---

## Reports & Logs
- **Extent Reports** generated under `/reports`
- **Logs** generated under `/logs`
- **Screenshots** captured automatically on test failure

---

## Notes
This project focuses on framework design, maintainability, and real-device stability rather than emulator-based parallel execution.
