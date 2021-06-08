package ui.automation.kotlin.util

import ui.automation.kotlin.property.ProjectProperties


/**
 * Class containing methods to return configuration parameters based on gradle property input
 * If gradle property regarding environment is not input, returning configuration parameters stated in resource config file
 * @author: Dilshan Fernando
 * @since: 24/05/2021
 */
open class ConfigurationSpecification {

    companion object {

        /**
         * Initializing projectProperties to map the configuration parameters from resource config file to
         * return them if the gradle property input not present
         */
        private val projectProperties: ProjectProperties

        init {
            val inputStream = ConfigurationSpecification::class.java.getResourceAsStream("/config.yaml")
            projectProperties = ObjectMapperUtil.yamlObjectMapper.readValue(inputStream, ProjectProperties::class.java)
        }


        fun getHeadlessMode(): Boolean {
            return projectProperties.webDriver.headless
        }

        fun getBrowserURL(): String {
            return projectProperties.base_url
        }

    }
}
