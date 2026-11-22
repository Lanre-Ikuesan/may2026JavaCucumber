# may2026JavaCucumber

Automated UI tests for demo websites, written in **Java** with **Selenium** and **Cucumber**.

Tests are written in plain English (Gherkin `.feature` files). Each English step is linked to Java code that drives a real Chrome browser.

---

## 1. What gets tested

| Feature file | Website | What it checks |
|---|---|---|
| `homepage.feature` | [saucedemo.com](https://www.saucedemo.com/) | Logo, username/password fields and login button are shown |
| `validLogin.feature` | saucedemo.com | Valid login works; wrong password shows an error |
| `SortProduct.feature` | saucedemo.com | Products can be sorted with the dropdown |
| `sauceDemo_common.feature` | saucedemo.com | Shared "open the homepage" step |
| `createAccount.feature` | [automationteststore.com](https://automationteststore.com/) | A new user can register |
| `createacc_common.feature` | automationteststore.com | Shared "open homepage, click login/register" steps |
| `iframe_Pestashop.feature` | [demo.prestashop.com](https://demo.prestashop.com/) | Switching into an iframe and checking header buttons |

---

## 2. What you need installed

| Tool | Version | Check with |
|---|---|---|
| Java JDK | **11** | `java -version` |
| Maven | 3.6+ | `mvn -version` |
| Google Chrome | latest | — |
| An IDE | IntelliJ IDEA recommended (with the *Cucumber for Java* and *Gherkin* plugins) | — |

You do **not** need to download ChromeDriver. [WebDriverManager](https://github.com/bonigarcia/webdrivermanager) downloads the right version for you automatically.

---

## 3. Get started

```bash
git clone https://github.com/Lanre-Ikuesan/may2026JavaCucumber.git
cd may2026JavaCucumber
mvn clean test
```

That's it. Chrome will open and close for each scenario.

---

## 4. Running tests

**Run everything (from the terminal):**
```bash
mvn clean test
```

**Run from IntelliJ:**
- Right-click `src/test/java/step_definitions/runnerClass.java` → **Run**, or
- Right-click any `.feature` file → **Run**.

**Skip a test:** put `@ignore` on the line above the `Scenario:` (or `Feature:`). The runner excludes anything tagged `@ignore`.

```gherkin
@ignore
Scenario: something not ready yet
```

> Note: failing tests do **not** fail the Maven build (`testFailureIgnore` is on in `pom.xml`). Always check the report.

---

## 5. Seeing the results

After `mvn clean test`, open:

```
target/cucumber-report-html/cucumber-html-reports/overview-features.html
```

This HTML report shows every feature, scenario and step with pass/fail status. The raw data is in `target/cucumber.json`.

---

## 6. Project layout

```
may2026JavaCucumber
├── pom.xml                          ← dependencies & build settings
├── src/main/java
│   ├── Base/TestBase.java           ← shared WebDriver + loads config
│   └── config/config.properties     ← website URLs and browser setting
└── src/test
    ├── resources/features/          ← .feature files (the tests in plain English)
    └── java
        ├── step_definitions/        ← Java code behind each English step
        │   ├── runnerClass.java     ← starts Cucumber (the "Run" entry point)
        │   └── Hooks.java           ← closes the browser after every scenario
        └── Pages/                   ← page objects: element locators + actions
```

### How the pieces fit together

```
.feature file  ──►  step definition  ──►  page object  ──►  browser
(English step)      (step_definitions/)   (Pages/)          (Selenium)
```

1. A **feature file** says *what* to test, e.g. `When I click the login button`.
2. A **step definition** is a Java method that matches that sentence (using a regex in `@Given` / `@When` / `@Then`).
3. The step calls a **page object** method, which finds elements on the page (`@FindBy`) and clicks/types/asserts.

### Which page object belongs to which site

| Page class | Used for |
|---|---|
| `page_Methods_And_locators` | SauceDemo login and product sorting |
| `pages_Methods_And_Locators` | SauceDemo homepage elements + PrestaShop iframe |
| `pages_locators_And_Methods` | AutomationTestStore create account |

(The names are very similar — double-check you're editing the right one.)

---

## 7. Configuration

`src/main/java/config/config.properties`:

```properties
uat_url=https://automationteststore.com/
Saucedemo_url=https://www.saucedemo.com/
browser=Chrome
```

Read it in code with `CONFIG.getProperty("Saucedemo_url")`. Add new URLs here instead of hard-coding them.

---

## 8. Adding a new test (step by step)

1. **Write the scenario** in a new or existing file under `src/test/resources/features/`:
   ```gherkin
   Feature: Cart
     Scenario: User can add an item to the cart
       Given i am on the saucedemo homepage
       When I add a backpack to the cart
       Then the cart badge should show 1
   ```
2. **Run it once.** Cucumber prints "undefined step" snippets for any new steps — copy them.
3. **Create a step definition class** in `step_definitions/` that `extends TestBase`, and paste the snippets in.
4. **Add locators and methods** to the right page class in `Pages/` (or create a new one):
   ```java
   @FindBy(how = How.ID, using = "add-to-cart-sauce-labs-backpack")
   public static WebElement addBackpack;
   ```
5. **Call the page object** from your step:
   ```java
   page_Methods_And_locators pages = PageFactory.initElements(driver, page_Methods_And_locators.class);
   pages.addBackpackToCart();
   ```
6. **Run `mvn clean test`** and check the report.

### Tips
- **Reuse existing steps.** Search the `step_definitions/` folder before writing a new one. Two step definitions with the same wording will cause a *DuplicateStepDefinition* error.
- The first `Given` step of a scenario is the one that opens Chrome (`driver = new ChromeDriver()`). `Hooks.java` closes it afterwards — you don't need to.
- Use the existing `Given i am on the saucedemo homepage` or `Given I am on the application homepage` steps to start new scenarios.
- The config file is loaded automatically before every scenario by the `@Before` hooks in `saucedemo_common` / `createacc_common`.

---

## 9. Tech stack

| Library | Version | Purpose |
|---|---|---|
| Selenium Java | 4.25.0 | Controls the browser |
| Cucumber (info.cukes) | 1.2.5 | Runs Gherkin feature files |
| JUnit | 4.13.2 | Test runner + assertions |
| WebDriverManager | 6.3.4 | Auto-downloads ChromeDriver |
| maven-cucumber-reporting | 2.8.0 | Builds the HTML report |

> Cucumber 1.2.5 is an old version. Imports use `cucumber.api.*` (not `io.cucumber.*`), so examples you find online for newer versions may look slightly different.

---

## 10. Contributing workflow

1. Pull the latest `main`: `git checkout main && git pull`
2. Create a branch: `git checkout -b my-change`
3. Make your changes and run `mvn clean test`
4. Commit, push, and open a Pull Request into `main`
5. An automated Claude code review runs on every PR. You can also mention `@claude` in a PR or issue comment to ask it questions.

---

## 11. Troubleshooting

| Problem | Fix |
|---|---|
| `NullPointerException` on `driver` | The scenario has no step that opens the browser. Start it with a `Given` that creates the driver. |
| `NullPointerException` on `CONFIG` | Config wasn't loaded. Check the `@Before` hooks in `saucedemo_common` / `createacc_common` still call `initialize()`, and that `config.properties` exists. |
| `Undefined step` | No Java method matches the sentence. Check spelling/case — matching is exact. |
| No tests run with `mvn test` | Make sure `runnerClass.java` is still in `step_definitions/` (Maven only runs that class). |
| Compile errors about Java version | Use JDK 11 (`java -version`). |
| PrestaShop test is slow | It waits 10 seconds for the demo site to load — that's expected. |
