package co.th.the1.backend.service

import co.th.the1.backend.configuration.SMPConfiguration
import co.th.the1.backend.entity.postgres.OffersEntity
import co.th.the1.backend.model.request.offers.PublicOffersBodyRequest
import co.th.the1.backend.model.request.offers.PublicOffersRequest
import co.th.the1.backend.repository.OffersRepository
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class OffersPostgresService(val repository: OffersRepository, val client: OffersClient, val smp: SMPConfiguration) {

    fun listAllOffers(version: Long?): List<OffersEntity> {
        if (version == null || version == 0L) {
            return repository.findAllByOrderByUpdatedAtDesc()
        }
        return repository.findByVersion(version.toLong())
    }

    fun removeAllOffers() = repository.deleteAll()

    @Transactional
    fun fetchAndSaveAllOffers(publicOffersBodyRequest: PublicOffersBodyRequest): List<OffersEntity> {
        val offersEntity = getOffers(publicOffersBodyRequest)
        if (offersEntity != null) {
            return repository.saveAll(offersEntity)
        }
        return emptyList()
    }

    @Transactional
    fun fetchAndUpsertOffers(publicOffersBodyRequest: PublicOffersBodyRequest): List<OffersEntity>? {
        val offersEntity = getOffers(publicOffersBodyRequest)
        if (offersEntity != null) {
            offersEntity.forEach { repository.upsert(it.rootOfferId, it.offerId, it.title, it.description, it.updatedAt, it.version) }
            return offersEntity
        }
        return emptyList()
    }

    private fun getOffers(bodyRequest: PublicOffersBodyRequest): List<OffersEntity>? {
        val offerRequest = createOfferRequest(bodyRequest)
        val offerResponse = client.getPublicOffers(offerRequest)?.toOfferResponse()
        val rewardStoreOffers = offerResponse?.payload?.rewardStoreOffers?.map { it.toRewardStoreOffer() }
        val offerDetails = rewardStoreOffers?.map { it.offerDetails?.toOfferDetails(it.rootOfferId, it.id) }
        return offerDetails?.map { it!!.toOffersEntity(bodyRequest.version) }?.toList()
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