package co.th.the1.backend.repository

import co.th.the1.backend.entity.postgres.OfferId
import co.th.the1.backend.entity.postgres.OffersEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.time.LocalDateTime
import javax.transaction.Transactional

@Repository
interface OffersRepository : JpaRepository<OffersEntity, String> {

    fun findAllByOrderByUpdatedAtDesc(): List<OffersEntity>
    fun findByVersion(version: Long?): List<OffersEntity>

//    @Modifying
//    @Transactional
//    @Query(value = "INSERT INTO offers (root_offer_id, offer_Id, title, description, updated_at) VALUES(?1,?2,?3,?4,?5) " +
//            "ON CONFLICT(root_offer_id, offer_Id) DO UPDATE SET root_offer_id=?1, offer_Id=?2, title=?3, description=?4, updated_at=?5 ", nativeQuery = true)
//    fun upsert(rootOfferId: String?, offerId: String?, title: String?, description: String?, updatedAt: LocalDateTime?): Integer
// #3
    @Query(value = "INSERT INTO offers (root_offer_id, offer_Id, title, description, updated_at, version) VALUES(?1,?2,?3,?4,?5,?6) " +
            "ON CONFLICT(root_offer_id, offer_Id, version) DO UPDATE SET root_offer_id=?1, offer_Id=?2, title=?3, description=?4, updated_at=?5, version=?6 ", nativeQuery = true)
    fun upsert(rootOfferId: String?, offerId: String?, title: String?, description: String?, updatedAt: LocalDateTime?, version: Long?): Integer

}