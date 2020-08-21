package co.th.the1.backend.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "smp")
data class SMPConfiguration (
    var domain: String? = null,
    var ism15: String? = null,
    var ism16: String? = null,
    var ism33: String? = null,
    var authorization: String? = null,
    var retailerId: String? = null
)