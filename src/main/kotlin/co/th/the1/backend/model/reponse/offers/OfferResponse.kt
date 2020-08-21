package co.th.the1.backend.model.reponse.offers

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class OfferResponse(
    var status: String? = null,
    var payload: RewardStoreOffers? = null
) {
    fun toOfferResponse(): OfferResponse {
        return OfferResponse().also {
            it.status = status
            it.payload = payload?.toRewardStoreOffers()
        }
    }
}