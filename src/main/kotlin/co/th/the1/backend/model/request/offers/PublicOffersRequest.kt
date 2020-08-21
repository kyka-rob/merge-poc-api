package co.th.the1.backend.model.request.offers

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class PublicOffersRequest(
    var retailerId: String? = null,
    var rewardStoreIds: List<String>? = emptyList(),
    var limitToOnlyActive: Boolean? = false,
    var excludeFreeOffers: Boolean? = false,
    var includeExpired: Boolean? = false,
    var skip: Int? = null,
    var take: Int? = null,
    var sortColumn: String? = null,
    var sortDirection: String? = null,
    var culture: String? = null
)