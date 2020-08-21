package co.th.the1.backend.model.reponse.reward.stores

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class RewardStoresCustomData(
    var CategoryTh: String? = null,
    var CategoryEn: String? = null,
    var ImageUrlTh: String? = null,
    var ImageUrlEn: String? = null,
    var MobDarkImageUrlTh: String? = null,
    var MobDarkImageUrlEn: String? = null,
    var MobLightImageUrlTh: String? = null,
    var MobLightImageUrlEn: String? = null,
    var WebActImageUrlTh: String? = null,
    var WebActImageUrlEn: String? = null,
    var MobBannerUrlTh: String? = null,
    var MobBannerUrlEn: String? = null,
    var displayOnExplore: String? = null,
    var partnerCode: String? = null,
    var type: String? = null,
    var order: String? = null
)