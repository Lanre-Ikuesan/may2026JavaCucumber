package step_definitions;

import Base.TestBase;
import cucumber.api.java.After;

public class Hooks extends TestBase {

    // Runs after every scenario (pass or fail) and closes the browser
    @After
    public void tearDown() {
        if (driver != null) {
            try {
                driver.quit();
            } finally {
                driver = null;
            }
        }
    }
}
