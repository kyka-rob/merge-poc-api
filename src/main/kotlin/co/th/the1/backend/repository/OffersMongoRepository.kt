package co.th.the1.backend.repository

import co.th.the1.backend.entity.mongo.Offers
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface OffersMongoRepository: MongoRepository<Offers, ObjectId> {

}