
package androidx.compose.samples.crane.home

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class HomeTest {

    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun home_navigatesToAllScreens() {
        // Waits until loading is finished
        composeTestRule.waitUntil(timeoutMillis = 10_000L) {
            composeTestRule
                .onAllNodesWithText("Explore Flights by Destination")
                .fetchSemanticsNodes().size == 1
        }

        composeTestRule.onNodeWithText("Explore Flights by Destination").assertIsDisplayed()
        composeTestRule.onNodeWithText("SLEEP").performClick()
        composeTestRule.onNodeWithText("Explore Properties by Destination").assertIsDisplayed()
        composeTestRule.onNodeWithText("EAT").performClick()
        composeTestRule.onNodeWithText("Explore Restaurants by Destination").assertIsDisplayed()
        composeTestRule.onNodeWithText("FLY").performClick()
        composeTestRule.onNodeWithText("Explore Flights by Destination").assertIsDisplayed()
    }
}
