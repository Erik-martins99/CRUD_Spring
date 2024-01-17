package com.projetos.CrudSpring.services;

import com.projetos.CrudSpring.dto.ProductDTO;
import com.projetos.CrudSpring.dto.ProductPutDTO;
import com.projetos.CrudSpring.model.Product;
import com.projetos.CrudSpring.repository.ProductRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepositoy repositoy;

    public List<ProductDTO> getAllProducts() {
        List<Product> productList = repositoy.findAll();

        return productList.stream()
                .map(p -> new ProductDTO(p.getName(),
                        p.getPrice_in_cents()))
                .collect(Collectors.toList());
    }

    public void registerProduct(ProductDTO data) {
        Product product = new Product(data);
        repositoy.save(product);
    }

    public void updateProduct(ProductPutDTO data) {
        Product product = repositoy.getReferenceById(data.id());
        product.setName(data.name());
        product.setPrice_in_cents(data.price_in_cents());
        repositoy.save(product);
    }

    public void deleteProduct(String id) {
        Product product = repositoy.getReferenceById(id);
        repositoy.delete(product);
    }
}
