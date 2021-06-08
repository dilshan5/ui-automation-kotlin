package ui.automation.kotlin.e2e

import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Tags
import org.junit.jupiter.api.Test
import ui.automation.kotlin.page.GoogleHomePage
import ui.automation.kotlin.page.LoginPage
import ui.automation.kotlin.util.CommonConstants.TestTag.BVT
import ui.automation.kotlin.util.CommonConstants.TestTag.REGRESSION
import ui.automation.kotlin.util.TestBase

class GoogleHomePageTest : TestBase() {

    private var googleHomePage: GoogleHomePage? = null
    private var loginPage: LoginPage? = null

    init {
        googleHomePage = GoogleHomePage()
        loginPage = LoginPage()
    }

    @Test
    @Tags(Tag(BVT), Tag(REGRESSION))
    fun navigateToGmailEmailPage() {
        googleHomePage?.clickSignInButton()
        loginPage?.enterEmail("sed@gmail.com")

    }

}