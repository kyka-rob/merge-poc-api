package co.th.the1.backend.repository

import java.util.*
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext


class OffersRepositoryCustomizeImp {

    @PersistenceContext
    private val entityManager: EntityManager? = null

    @Override
    fun <OffersEntity> upsertAll(entities: List<OffersEntity>?): List<OffersEntity> {
        val result = ArrayList<OffersEntity>()

        for (entity in entities!!) {
            entityManager?.persist(entity)
            result.add(entity)
        }
        entityManager?.flush()

        return result
    }
}