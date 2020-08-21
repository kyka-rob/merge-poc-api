package co.th.the1.backend.model.reponse.reward.stores

import co.th.the1.backend.constant.EligibilityModes
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class RewardStore(
    var id: String? = null,
    var internalName: String? =null,
    var startDate: String? =null,
    var endDate: String? =null,

    @JsonDeserialize(using = RewardStoresCustomDataDeserializer::class)
    var customData: RewardStoresCustomData? = null,

    @JsonDeserialize(using = EligibilityModeDeserializer::class)
    var eligibilityModes: List<EligibilityModes>? = emptyList()
)