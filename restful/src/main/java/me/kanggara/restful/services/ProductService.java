package me.kanggara.restful.services;

import jakarta.transaction.Transactional;

import me.kanggara.restful.models.entities.Product;
import me.kanggara.restful.models.repos.ProductRepo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {

    private final ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Product save(Product product) {
        return productRepo.save(product);
    }

    public Product findOne(Long id){
        Optional<Product> product= productRepo.findById(id);
        return product.orElse(null);
    }

    public Iterable<Product> findAll() {
        return productRepo.findAll();
    }

    public void removeOne(Long id) {
        Product product= productRepo.findById(id).orElseThrow();
        productRepo.delete(product);
    }


    public Page<Product> findByName(String name, int start, int size){
        Pageable pageable = PageRequest.of(start,size);
        return productRepo.findByNameContains(pageable, name);
    }
}
