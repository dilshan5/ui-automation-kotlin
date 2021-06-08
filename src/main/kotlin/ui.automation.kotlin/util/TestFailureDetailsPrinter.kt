package ui.automation.kotlin.util

import org.junit.platform.launcher.TestPlan
import org.junit.platform.launcher.listeners.SummaryGeneratingListener
import java.io.PrintWriter


/**
 * This will print test failure details (including assertions) to console
 *
 * @author Dilshan Fernando
 */
class TestFailureDetailsPrinter : SummaryGeneratingListener() {

    private val writer = PrintWriter(System.out)

    //This method is invoked after all tests in all containers is finished
    override fun testPlanExecutionFinished(testPlan: TestPlan?) {
        super.testPlanExecutionFinished(testPlan)
        printTestFailures()
    }

    private fun printTestFailures() {
        summary.printFailuresTo(writer)
        summary.printTo(writer)
    }
}