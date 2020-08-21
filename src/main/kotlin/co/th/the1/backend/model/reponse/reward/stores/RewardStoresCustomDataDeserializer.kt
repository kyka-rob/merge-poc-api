package co.th.the1.backend.model.reponse.reward.stores

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

class RewardStoresCustomDataDeserializer: JsonDeserializer<RewardStoresCustomData>() {

    override fun deserialize(jsonParser: JsonParser,
                             deserializationContext: DeserializationContext
    ): RewardStoresCustomData {
        val objectMapper = jacksonObjectMapper()
        return objectMapper.readerFor(RewardStoresCustomData::class.java).readValue(jsonParser.valueAsString)
    }

}