package co.th.the1.backend.repository

interface OffersRepositoryCustomize {

    fun <OffersEntity> upsertAll(entities: Iterable<OffersEntity>?): List<OffersEntity>

}