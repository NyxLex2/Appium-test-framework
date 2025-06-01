## Preconditions:
- #### To run the project use an emulator or real device
- Download the project
- Configure config.properties file with appropriate values
- mobile.BaseTest.class already configured to use Appium
- Install Appium 2.0, then install uiautomator2 driver
  - `appium driver install uiautomator2`

## Test Task:
- Write a test for registration (onboarding) with checks.
- The test starts by pressing the "GET STARTED" button.

## While reviewing the test task we'll focus on:
- [x] Framework is described at least at a basic level.
- [x] The test should comprehensively cover the necessary functionality.
- [x] The code should be clean, well-structured, and easy to read.
- [x] The test must include sufficient checks (assertions).
- [x] The test runs successfully.
- [x] No code duplication.
- [x] The code should avoid common anti-patterns such as hard-coded values, over-complicated logic, or inefficient structures.

## ⚠️ Configuration & Sensitive Data

**Do not commit your real credentials or sensitive data to the repository!**

This project uses a `config.properties` file for local configuration (Appium path, email, password, etc).  
This file is ignored by git and should **not** be committed.

### How to Set Up Your Local Config

1. **Copy the example file:**
    ```sh
    cp src/main/resources/config.properties.example src/main/resources/config.properties
    ```
2. **Edit `src/main/resources/config.properties`** and fill in your real values:
    ```
    app.path=/path/to/Nebula.apk
    email=your@email.com
    password=yourpassword
    ```

3. **Never commit your real `config.properties`!**  
   It is already listed in `.gitignore` for your safety.

---

**If you accidentally committed sensitive data, remove it from git history before pushing.  
See [Removing sensitive data from a repository](https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/removing-sensitive-data-from-a-repository) for help.**
