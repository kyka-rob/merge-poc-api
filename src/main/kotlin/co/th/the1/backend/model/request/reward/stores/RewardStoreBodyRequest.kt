package co.th.the1.backend.model.request.reward.stores

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class RewardStoreBodyRequest(
    var searchEligibility: List<String>? = emptyList(),
    var skip: Int? = 0,
    var take: Int? = 0
)