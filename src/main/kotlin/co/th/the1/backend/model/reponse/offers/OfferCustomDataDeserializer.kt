package co.th.the1.backend.model.reponse.offers

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

class OfferCustomDataDeserializer: JsonDeserializer<OfferCustomData>() {

    override fun deserialize(jsonParser: JsonParser,
                             deserializationContext: DeserializationContext
    ): OfferCustomData {
        val objectMapper = jacksonObjectMapper()
        return objectMapper.readerFor(OfferCustomData::class.java).readValue(jsonParser.valueAsString)
    }

}