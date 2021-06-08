package ui.automation.kotlin.property

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * read and store all project properties
 * @author: Dilshan Fernando
 * @since: 24/05/2021
 */
data class ProjectProperties(
    @JsonProperty("webDriver")
    val webDriver: WebDriverProperties,
    @JsonProperty("base_url")
    val base_url: String
)