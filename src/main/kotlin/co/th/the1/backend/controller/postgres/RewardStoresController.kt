package co.th.the1.backend.controller.postgres

import co.th.the1.backend.service.OffersPostgresService
import org.springframework.web.bind.annotation.RestController

@RestController
class RewardStoresController(val offerService: OffersPostgresService) {

//    @GetMapping("/postgres/offers")
//    fun listAll(): List<OffersEntity> = offerService.listAll()

//    @PostMapping("/postgres/offers/save")
//    fun fetchAndSave(@RequestBody publicOffersBodyRequest: PublicOffersBodyRequest) = offerService.fetchAndSave(publicOffersBodyRequest)

//    @DeleteMapping("/postgres/offers")
//    fun removeAll() = offerService.removeAll()

}