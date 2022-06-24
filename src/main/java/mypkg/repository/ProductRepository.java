package mypkg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mypkg.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
