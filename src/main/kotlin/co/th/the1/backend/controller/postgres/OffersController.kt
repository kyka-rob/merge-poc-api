package co.th.the1.backend.controller.postgres

import co.th.the1.backend.model.request.offers.PublicOffersBodyRequest
import co.th.the1.backend.service.OffersPostgresService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/postgres")
class OffersController(val offersService: OffersPostgresService) {

    @GetMapping("/offers")
    fun listAllPublicOffers(@RequestParam("version") version: Long?) = offersService.listAllOffers(version)

    @PostMapping("/offers/save")
    fun fetchAndSaveAllOffer(@RequestBody publicOffersBodyRequest: PublicOffersBodyRequest) = offersService.fetchAndSaveAllOffers(publicOffersBodyRequest)

    @PostMapping("/offers/upsert")
    fun fetchAndUpsertOffer(@RequestBody publicOffersBodyRequest: PublicOffersBodyRequest) = offersService.fetchAndUpsertOffers(publicOffersBodyRequest)

    @DeleteMapping("/offers")
    fun removeAllPublicOffers() = offersService.removeAllOffers()

}