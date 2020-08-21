package co.th.the1.backend.model.reponse.reward.stores

import co.th.the1.backend.constant.EligibilityModes
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer

class EligibilityModeDeserializer : JsonDeserializer<EligibilityModes>() {

    override fun deserialize(p: JsonParser, ctxt: DeserializationContext?): EligibilityModes {
        return EligibilityModes.valueOf(p.text.toString().toUpperCase())
    }

}