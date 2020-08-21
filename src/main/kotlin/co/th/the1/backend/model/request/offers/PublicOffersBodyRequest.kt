package co.th.the1.backend.model.request.offers

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class PublicOffersBodyRequest(
    var rewardStoreIds: List<String>? = emptyList(),
    var skip: Int? = null,
    var take: Int? = null,
    var version: Long? = 0
)