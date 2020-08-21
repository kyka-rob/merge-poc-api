package co.th.the1.backend.model.reponse.reward.stores

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class RewardStoresResponse(
        var status: String? =null,
        var payload: RewardStores? = null
) {
    fun toRewardStoresResponse(): RewardStoresResponse {
        return RewardStoresResponse().also {
            it.status = status
            it.payload = payload?.toRewardStores()
        }
    }
}