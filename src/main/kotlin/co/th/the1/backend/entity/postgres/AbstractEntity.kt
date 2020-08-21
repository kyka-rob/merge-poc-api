package co.th.the1.backend.entity.postgres

import org.springframework.data.domain.Persistable
import javax.persistence.MappedSuperclass
import javax.persistence.PostLoad
import javax.persistence.PrePersist

@MappedSuperclass
abstract class AbstractEntity<ID>: Persistable<ID> {

    @Transient
    private var isNew = true

    override fun isNew(): Boolean {
        return isNew
    }

    @PrePersist
    @PostLoad
    fun markNotNew() {
        isNew = false
    }
}