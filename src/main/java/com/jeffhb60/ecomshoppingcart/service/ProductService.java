package com.jeffhb60.ecomshoppingcart.service;

import com.jeffhb60.ecomshoppingcart.dto.ProductDTO;
import com.jeffhb60.ecomshoppingcart.dto.ProductResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ProductService {
    ProductDTO addProduct(Long categoryId, ProductDTO product);

    ProductResponse getAllProducts();

    ProductResponse searchByCategory(Long categoryId);


    ProductResponse searchProductsByKeyword(String productKeyword);

    ProductDTO getProductById(Long productId);

    ProductDTO updateProduct(Long productId, ProductDTO product);

    ProductDTO deleteProduct(Long productId);

    ProductDTO updateProductImage(Long productId, MultipartFile image) throws IOException;
}
