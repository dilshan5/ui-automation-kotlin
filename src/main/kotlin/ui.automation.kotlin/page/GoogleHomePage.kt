package ui.automation.kotlin.page

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import org.slf4j.LoggerFactory
import ui.automation.kotlin.util.TestBase.Companion.driver

open class GoogleHomePage {

    init {
        PageFactory.initElements(driver, this)
    }

    @FindBy(linkText = "Sign in")
    val clickSignInButton: WebElement? = null

    fun clickSignInButton() {
        LOGGER.info("Clicking Sign in.")
        clickSignInButton!!.click()
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(GoogleHomePage::class.java)
    }
}