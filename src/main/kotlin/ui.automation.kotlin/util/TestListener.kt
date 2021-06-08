package ui.automation.kotlin.util

import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.api.extension.TestWatcher
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import ui.automation.kotlin.util.TestBase.Companion.driver
import java.nio.file.Files
import java.nio.file.Paths
import java.time.Instant
import java.util.*

/**
 * This class will listen to the status of the test cases
 *
 * @author: Dilshan Fernando
 * @since: 22/05/2021
 */
class TestListener : TestWatcher {

    override fun testAborted(extensionContext: ExtensionContext?, throwable: Throwable?) {
        // do something
    }

    override fun testDisabled(extensionContext: ExtensionContext?, optional: Optional<String?>?) {
        // do something
    }

    override fun testFailed(extensionContext: ExtensionContext?, throwable: Throwable?) {
        if (driver is TakesScreenshot) {
            var basePath = Paths.get("./build/test-results")
            if (!Files.exists(basePath)) {
                basePath = Paths.get(".")
            }

            Files.write(
                basePath.resolve("${extensionContext?.displayName}${Instant.now()}.png"),
                driver!!.getScreenshotAs(OutputType.BYTES)
            )
        }
    }

    override fun testSuccessful(extensionContext: ExtensionContext?) {
        // do something
    }
}