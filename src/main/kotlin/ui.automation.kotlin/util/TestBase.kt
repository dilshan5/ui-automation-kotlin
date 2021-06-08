package ui.automation.kotlin.util

import io.github.bonigarcia.wdm.WebDriverManager
import org.junit.jupiter.api.AfterAll
import org.openqa.selenium.Dimension
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import ui.automation.kotlin.util.ConfigurationSpecification.Companion.getBrowserURL
import ui.automation.kotlin.util.ConfigurationSpecification.Companion.getHeadlessMode
import java.util.concurrent.TimeUnit


/**
 * Base class for the Test classes
 * @author: Dilshan Fernando
 * @since: 24/05/2021
 */
abstract class TestBase {

    companion object {

        var driver: ChromeDriver? = null

        init {
            //https://github.com/bonigarcia/webdrivermanager
            WebDriverManager.chromedriver().setup()

            val options = ChromeOptions()
            options.setHeadless(getHeadlessMode())
            options.addArguments("--no-sandbox")
            options.addArguments("--whitelisted-ips")
            options.addArguments("--disable-dev-shm-usage")
            options.addArguments("--verbose")
            options.addArguments("--ignore-certificate-errors")
            options.addArguments("--allow-insecure-localhost")
            driver = ChromeDriver(options)

            driver!!.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS)
            driver!!.manage().window().size = Dimension(1920, 1080) // maximize won't work on headless mode
            driver!!.manage().window().maximize()
            driver!!.get(getBrowserURL());
        }

        /**
         * Publish test results to qCenter
         */
        @AfterAll
        @JvmStatic
        fun tearDown() {
            if (driver != null) {
//                (driver as JavascriptExecutor).executeScript("window.localStorage.clear()")
                driver!!.quit()
            }
        }

    }

}