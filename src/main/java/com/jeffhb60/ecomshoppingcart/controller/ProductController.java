package com.jeffhb60.ecomshoppingcart.controller;

import com.jeffhb60.ecomshoppingcart.dto.CategoryDTO;
import com.jeffhb60.ecomshoppingcart.dto.ProductDTO;
import com.jeffhb60.ecomshoppingcart.dto.ProductResponse;
import com.jeffhb60.ecomshoppingcart.model.Product;
import com.jeffhb60.ecomshoppingcart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("admin/categories/{categoryId}/product")
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO productDTO,
                                                 @PathVariable Long categoryId){
        ProductDTO savedProductDTO = productService.addProduct(categoryId, productDTO);
        return new ResponseEntity<>(productDTO, HttpStatus.CREATED);
    }

    @GetMapping("/public/products")
    public ResponseEntity<ProductResponse> getAllProducts(){

        ProductResponse productResponse = productService.getAllProducts();
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    @GetMapping("/public/categories/{categoryId}/products")
    public ResponseEntity<ProductResponse> getProductsByCategory(@PathVariable Long categoryId){
        ProductResponse productResponse = productService.searchByCategory(categoryId);
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    @GetMapping("/public/products/keyword/{productKeyword}")
    public ResponseEntity<ProductResponse> getProductByKeyword(@PathVariable String productKeyword) {
        ProductResponse productResponse = productService.searchProductsByKeyword(productKeyword);
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    @GetMapping("/public/products/{productId}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long productId) {
        ProductDTO productDTO = productService.getProductById(productId);
        return new ResponseEntity<>(productDTO, HttpStatus.OK);
    }
    @PutMapping("/admin/products/{productId}")
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO productDTO,
                                                    @PathVariable Long productId) {
        ProductDTO savedpdatedProductDTO = productService.updateProduct(productId, productDTO);
        return new ResponseEntity<>(productDTO, HttpStatus.OK);
    }

    @DeleteMapping("/admin/products/{productId}")
    public ResponseEntity<ProductDTO> deleteProduct(@PathVariable Long productId) {
        ProductDTO savedProductDTO = productService.deleteProduct(productId);
        return new ResponseEntity<>(savedProductDTO, HttpStatus.OK);
    }

    @PutMapping("/public/products/{productId}/images")
    ResponseEntity<ProductDTO> updateProductImage(@PathVariable Long productId,
                                                  @RequestParam("Image") MultipartFile image) {
        ProductDTO updatedProduct = null;
        try {
            updatedProduct = productService.updateProductImage(productId, image);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }
}
