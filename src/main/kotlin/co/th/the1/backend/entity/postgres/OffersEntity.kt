package co.th.the1.backend.entity.postgres

import org.hibernate.annotations.UpdateTimestamp
import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Embeddable
import javax.persistence.EmbeddedId
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.SequenceGenerator
import javax.persistence.Table
import javax.persistence.Version

@Entity
@Table(name="offers")
open class OffersEntity(

//        @Id
//        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hilopooled")
//        @GenericGenerator(name = "hilopooled", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
//                parameters = [
//                        Parameter(name = "sequence_name", value = "hilo_sequence"),
//                        Parameter(name = "initial_value", value = "1"),
//                        Parameter(name = "increment_size", value = "100"),
//                        Parameter(name = "optimizer", value = "pooled")
//                ]
//        )
//        open var id: Long? = null,

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "the1_offers_seq")
        @SequenceGenerator(
                sequenceName = "the1_offers_seq",
                allocationSize = 1,
                name = "the1_offers_seq"
        )
        open var id: Long = 0,

//        @Id
        @Column(updatable = false, nullable = false)
        open var rootOfferId: String? = null,

//        @Id
        @Column(updatable = false, nullable = false)
        open var offerId: String? = null,

//        @EmbeddedId
//        open var offerId: OfferId? = null,

        open var title: String? = null,

        @Column(columnDefinition = "text")
        open var description: String? = null,

        @UpdateTimestamp
        @Column(nullable = false)
        open var updatedAt: LocalDateTime? = LocalDateTime.now(),

//        @Version // #1.2
//        private var version: Long? = null

// #3
        @Column(columnDefinition = "integer DEFAULT 0", nullable = false)
        open var version: Long? = 0L
//)
// #1.1, #3
) : Serializable, AbstractEntity<Long>() {
    /**
     * Returns the id of the entity.
     *
     * @return the id. Can be null.
     */
    override fun getId(): Long {
        return id
    }
}

@Embeddable
data class OfferId (
        var rootOfferId: String? = null,
        var offerId: String? = null,
        var version: Long? = null // #3
): Serializable