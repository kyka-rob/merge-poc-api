package co.th.the1.backend.controller.mongo

import co.th.the1.backend.model.request.offers.PublicOffersBodyRequest
import co.th.the1.backend.service.OffersMongoService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/mongo")
class OffersMongoController(val service: OffersMongoService) {

    @GetMapping("/offers")
    fun listAllPublicOffers() = service.getAllOffers()

    @PostMapping("/offers/save")
    fun fetchAndSaveAllOffer(@RequestBody publicOffersBodyRequest: PublicOffersBodyRequest) = service.saveAllOffers(publicOffersBodyRequest)

    @PostMapping("/offers/upsert")
    fun fetchAndUpsertOffer(@RequestBody publicOffersBodyRequest: PublicOffersBodyRequest) = service.upsertAllOffer(publicOffersBodyRequest)

    @DeleteMapping("/offers")
    fun removeAllPublicOffers() = service.deleteAllOffers()
}