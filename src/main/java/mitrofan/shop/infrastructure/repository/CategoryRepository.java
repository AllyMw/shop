package mitrofan.shop.infrastructure.repository;

import mitrofan.shop.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long > {
    Category findByTitle(String categoryTitle);
}
