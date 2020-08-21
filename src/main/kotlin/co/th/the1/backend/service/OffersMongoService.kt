package co.th.the1.backend.service

import co.th.the1.backend.configuration.SMPConfiguration
import co.th.the1.backend.entity.mongo.Offers
import co.th.the1.backend.model.request.offers.PublicOffersBodyRequest
import co.th.the1.backend.model.request.offers.PublicOffersRequest
import co.th.the1.backend.repository.OffersMongoRepository
import org.bson.Document
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import org.springframework.stereotype.Service


@Service
class OffersMongoService(
        val repository: OffersMongoRepository,
        val mongoTemplate: MongoTemplate,
        val client: OffersClient,
        val smp: SMPConfiguration) {
    
    fun getAllOffers(): MutableList<Offers> = repository.findAll()

    fun deleteAllOffers() = repository.deleteAll()

    fun upsertAllOffer(bodyRequest: PublicOffersBodyRequest): List<Offers>? {
        val offers = getOffers(bodyRequest)
        val query = Query()
        val doc = Document()
        var list = offers?.map {it.offerId }?.toList()
        println(list.toString())
        query.addCriteria(Criteria.where("offerId").`in`("07ccec25-2616-44db-81aa-b3e69f7e6254", "b4722dca-e431-4414-bc8c-37fa2ae2f671"))
        offers?.forEach {
            mongoTemplate.converter.write(it, doc)
            val update = Update.fromDocument(doc)
            mongoTemplate.upsert(query, update, Offers::class.java)
        }
//        val update = Update()
//        offers?.forEach {
//            query.addCriteria(Criteria.where("rootOfferId").`in`(it.rootOfferId))
//            update.set("rootOfferId", it.rootOfferId)
//            update.set("title", it.title)
//            update.set("description", it.description)
//            mongoTemplate.upsert(query, update, Offers::class.java)
//        }
        return offers
    }

    fun saveAllOffers(bodyRequest: PublicOffersBodyRequest): List<Offers> {
        val offers = getOffers(bodyRequest)
        if (offers != null) {
            return repository.saveAll(offers)
        }
        return emptyList()
    }

    private fun getOffers(bodyRequest: PublicOffersBodyRequest): List<Offers>? {
        val offerRequest = createOfferRequest(bodyRequest)
        val offerResponse = client.getPublicOffers(offerRequest)?.toOfferResponse()
        val rewardStoreOffers = offerResponse?.payload?.rewardStoreOffers?.map { it.toRewardStoreOffer() }
        val offerDetails = rewardStoreOffers?.map { it.offerDetails?.toOfferDetails(it.rootOfferId, it.id) }
        return offerDetails?.map { it!!.toOffers() }?.toList()
    }

    private fun createOfferRequest(bodyRequest: PublicOffersBodyRequest) : PublicOffersRequest {
        return PublicOffersRequest().apply {
            retailerId = smp.retailerId
            rewardStoreIds = bodyRequest.rewardStoreIds // listOf("eafb7590-f0ae-414d-8e7a-c14d5cf170ac", "5f8ca5d9-3541-4ab0-af8b-c3f952daffc7")
            limitToOnlyActive = false
            excludeFreeOffers = true
            includeExpired = true
            skip = bodyRequest.skip
            take = bodyRequest.take
            sortColumn = "price"
            sortDirection = "asc"
            culture = "en-US"
        }
    }

}