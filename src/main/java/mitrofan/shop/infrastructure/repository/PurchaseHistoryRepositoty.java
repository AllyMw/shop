package mitrofan.shop.infrastructure.repository;

import mitrofan.shop.domain.entity.PurchaseHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseHistoryRepositoty extends JpaRepository<PurchaseHistory, Long > {
}
