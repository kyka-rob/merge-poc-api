package co.th.the1.backend.model.reponse.offers

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class RewardStoreOffers (
    var rewardStoreOffers: List<RewardStoreOffer>? = null
) {
    fun toRewardStoreOffers(): RewardStoreOffers {
        return RewardStoreOffers().also {
            it.rewardStoreOffers = rewardStoreOffers
        }
    }
}