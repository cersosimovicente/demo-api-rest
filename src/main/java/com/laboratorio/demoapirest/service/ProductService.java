package com.laboratorio.demoapirest.service;

import com.laboratorio.demoapirest.entity.Product;
import com.laboratorio.demoapirest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
    public Product updateProduct(Long id, Product product) {
        Product existingProduct = productRepository.findById(id).orElse(null);
        if (existingProduct != null) {
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setQuantity(product.getQuantity());
            return productRepository.save(existingProduct);
        }
        return null;
    }
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }


}
