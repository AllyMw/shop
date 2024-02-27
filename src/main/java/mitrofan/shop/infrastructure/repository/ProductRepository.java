package mitrofan.shop.infrastructure.repository;

import mitrofan.shop.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByTitle(String title);


    List<Product> findByCategory_Title(String titleCategory);
}
