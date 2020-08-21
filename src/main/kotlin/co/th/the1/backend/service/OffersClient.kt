package co.th.the1.backend.service

import co.th.the1.backend.configuration.SMPConfiguration
import co.th.the1.backend.model.reponse.offers.OfferResponse
import co.th.the1.backend.model.request.offers.MemberOffersRequest
import co.th.the1.backend.model.request.offers.PublicOffersRequest
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder

@Component
class OffersClient(
    val restTemplate: RestTemplate,
    val smpConfiguration: SMPConfiguration
) {

    fun getPublicOffers(publicOffersRequest: PublicOffersRequest) : OfferResponse? {
        val url = UriComponentsBuilder
                .fromHttpUrl(smpConfiguration.domain!!)
                .path(smpConfiguration.ism15!!)
                .build()
                .toUri()

        val httpHeaders = createSMPHeaders()
        val requestEntity = HttpEntity(publicOffersRequest, httpHeaders)

        return restTemplate.postForObject(url, requestEntity, OfferResponse::class.java)

    }

    fun getMemberOffers(offerRequest: MemberOffersRequest) : OfferResponse? {
        val url = UriComponentsBuilder
                .fromHttpUrl(smpConfiguration.domain!!)
                .path(smpConfiguration.ism16!!)
                .build()
                .toUri()

        val httpHeaders = createSMPHeaders()
        val requestEntity = HttpEntity(offerRequest, httpHeaders)

        return restTemplate.postForObject(url, requestEntity, OfferResponse::class.java)

    }

    private fun createSMPHeaders(): HttpHeaders {
        return HttpHeaders().apply {
            setBasicAuth(smpConfiguration.authorization!!)
            add("Content-Type", MediaType.APPLICATION_JSON.toString())
        }
    }
    
}