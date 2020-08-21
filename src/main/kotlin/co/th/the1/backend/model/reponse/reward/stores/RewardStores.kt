package co.th.the1.backend.model.reponse.reward.stores

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class RewardStores (
        var rewardStores: List<RewardStores>? = null
) {
    fun toRewardStores(): RewardStores {
        return RewardStores().also {
            it.rewardStores = rewardStores
        }
    }
}