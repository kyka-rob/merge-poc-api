package co.th.the1.backend.entity.mongo

import org.bson.types.ObjectId
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
import javax.persistence.Id

@Document
data class Offers (
//        @Id
//        val id: ObjectId = ObjectId.get(),
        @Id
        var rootOfferId: String? = null,
        var offerId: String? = null,
        var title: String? = null,
        var description: String? = null,

        @LastModifiedDate
        val updatedAt: LocalDateTime = LocalDateTime.now()
)