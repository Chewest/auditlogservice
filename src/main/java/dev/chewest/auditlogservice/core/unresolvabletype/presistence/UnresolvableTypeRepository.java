package dev.chewest.auditlogservice.core.unresolvabletype.presistence;

import dev.chewest.auditlogservice.core.unresolvabletype.domain.UnresolvableType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UnresolvableTypeRepository extends JpaRepository<UnresolvableType, UUID> {
}
