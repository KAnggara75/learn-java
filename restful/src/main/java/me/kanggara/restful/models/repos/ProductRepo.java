package me.kanggara.restful.models.repos;

import me.kanggara.restful.models.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepo extends CrudRepository <Product,Long>{

    Page<Product> findByNameContains(Pageable pageable, String name);
}