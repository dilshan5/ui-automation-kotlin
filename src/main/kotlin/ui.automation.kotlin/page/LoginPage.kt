package ui.automation.kotlin.page

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import org.slf4j.LoggerFactory
import ui.automation.kotlin.util.TestBase.Companion.driver

open class LoginPage {

    init {
        PageFactory.initElements(driver, this)
    }

    @FindBy(id = "identifierId")
    val enterEmail: WebElement? = null

    fun enterEmail(email: String) {
        LOGGER.info("Entering email '$email'.")
        enterEmail!!.sendKeys(email)
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(LoginPage::class.java)
    }
}