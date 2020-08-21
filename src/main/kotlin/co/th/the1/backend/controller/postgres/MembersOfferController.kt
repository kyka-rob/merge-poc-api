package co.th.the1.backend.controller.postgres

import co.th.the1.backend.service.OffersPostgresService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/postgres")
class MembersOfferController(val offersService: OffersPostgresService) {

//    @GetMapping("/v1/member/offers")
//    fun listAllMemberOffers(): List<OffersEntity> = offersService.listAllMemberOffers()

//    @PostMapping("/v1/member/offers/save")
//    fun fetchAndSave(@RequestBody publicOffersBodyRequest: PublicOffersBodyRequest) = offersService.fetchAndSave(publicOffersBodyRequest)

//    @DeleteMapping("/v1/member/offers")
//    fun removeAllMemberOffers() = offersService.removeAllMemberOffers()

}