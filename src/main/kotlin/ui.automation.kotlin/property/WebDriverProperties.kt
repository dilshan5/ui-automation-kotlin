package ui.automation.kotlin.property

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonRootName

@JsonRootName("webDriver")
data class WebDriverProperties(
    @JsonProperty("headless")
    val headless: Boolean
)
