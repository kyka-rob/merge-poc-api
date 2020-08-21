package co.th.the1.backend.model.reponse.offers

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class RewardStoreOffer (
    var id: String? = null,
    var rootOfferId: String? =null,
    var rewardStoreId: String? =null,
    var price: Number? =null,
    var startDate: String? =null,
    var offerDetails: OfferDetails? =null
) {
    fun toRewardStoreOffer(): RewardStoreOffer {
        return RewardStoreOffer().also {
            it.id = id
            it.rootOfferId = rootOfferId
            it.rewardStoreId = rewardStoreId
            it.price = price
            it.startDate = startDate
            it.offerDetails = offerDetails?.toOfferDetails(rootOfferId, id)
        }
    }
}