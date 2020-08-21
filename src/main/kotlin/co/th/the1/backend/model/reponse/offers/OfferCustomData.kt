package co.th.the1.backend.model.reponse.offers

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class OfferCustomData(
    var amount: String? = null,
    var cashCouponExchangeRate: String? = null,
    var category: String? = null,
    var countdownTimer: String? = null,
    var descriptionEn: String? = null,
    var descriptionTh: String? = null,
    var fastCategory: String? = null,
    var guestMode: String? = null,
    var hbOrder: String? = null,
    var hdrListEn: String? = null,
    var hdrListTh: String? = null,
    var issueChannel: String? = null,
    var itemPrice: String? = null,
    var itemCost: String? = null,
    var legacyAppId: String? = null,
    var legacyRewardItemId: String? = null,
    var offerShortDescriptionEn: String? = null,
    var offerShortDescriptionTh: String? = null,
    var partnerBranchCode: String? = null,
    var partnerBranchName: String? = null,
    var partnerCode: String? = null,
    var partnerName: String? = null,
    var partnerTag: String? = null,
    var pointValue: String? = null,
    var posVoucherType: String? = null,
    var productSubType: String? = null,
    var productType: String? = null,
    var siebelPoints: String? = null,
    var tags: String? = null,
    var targetedTier: String? = null,
    var vatTax: String? = null,
    var vatType: String? = null,
    var voucherType: String? = null
)