package com.projetos.CrudSpring.repository;

import com.projetos.CrudSpring.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepositoy extends JpaRepository<Product, String> {
}
