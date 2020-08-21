package co.th.the1.backend.model.reponse.offers

import co.th.the1.backend.entity.mongo.Offers
import co.th.the1.backend.entity.postgres.OfferId
import co.th.the1.backend.entity.postgres.OffersEntity
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class OfferDetails (
    var rootOfferId: String? = null,
    var offerId: String? = null,
    var internalName: String? = null,
    var title: String? = null,
    var description: String? = null,
    var terms: String? = null,

    @JsonDeserialize(using = OfferCustomDataDeserializer::class)
    var customData: OfferCustomData? = null
){

    fun toOfferDetails(rootOfferId: String?, offerId: String?) : OfferDetails {
        return OfferDetails().also {
            it.rootOfferId = rootOfferId
            it.offerId = offerId
            it.internalName = internalName
            it.title = title
            it.description = description
            it.terms = terms
            it.customData = customData
        }
    }

    fun toOffersEntity(version: Long?) : OffersEntity {
//        val offerId = OfferId().also {
//            it.rootOfferId = rootOfferId
//            it.offerId = offerId
//            it.version = version // #3
//        }
        return OffersEntity().also {
//            it.offerId = offerId
            it.rootOfferId = rootOfferId
            it.offerId = offerId
            it.title = title
            it.description = description
            it.version = version // #3
        }
    }

    fun toOffers() : Offers {
        return Offers().also {
            it.rootOfferId = rootOfferId
            it.offerId = offerId
            it.title = title
            it.description = description
        }
    }

}