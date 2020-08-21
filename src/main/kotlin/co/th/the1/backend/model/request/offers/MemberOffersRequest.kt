package co.th.the1.backend.model.request.offers

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class MemberOffersRequest(
    var retailerId: String? = null,
    var userId: String? = null,
    var skip: Int? = null,
    var take: Int? = null,
    var sortColumn: String? = null,
    var sortDirection: String? = null,
    var includePointBalances: Boolean? = false,
    var culture: String? = null
)