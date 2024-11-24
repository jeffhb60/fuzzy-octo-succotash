package com.jeffhb60.ecomshoppingcart.service;

import com.jeffhb60.ecomshoppingcart.dto.CategoryDTO;
import com.jeffhb60.ecomshoppingcart.dto.CategoryResponse;
import com.jeffhb60.ecomshoppingcart.dto.ProductDTO;
import com.jeffhb60.ecomshoppingcart.dto.ProductResponse;
import com.jeffhb60.ecomshoppingcart.exceptions.ResourceNotFoundException;
import com.jeffhb60.ecomshoppingcart.model.Category;
import com.jeffhb60.ecomshoppingcart.model.Product;
import com.jeffhb60.ecomshoppingcart.repositories.CategoryRepository;
import com.jeffhb60.ecomshoppingcart.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private FileService fileService;

    @Value("${file.upload-dir}")
    private String uploadDir;

    @Override
    public ProductDTO addProduct(Long categoryId, ProductDTO productDTO) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Category","categoryId",categoryId));

        Product product = modelMapper.map(productDTO, Product.class);
        product.setImage("default.png");
        product.setCategory(category);
        double specialPrice = product.getPrice() -
                ((product.getDiscount() * 0.01) * product.getPrice());
        product.setSpecialPrice(specialPrice);
        Product savedProduct = productRepository.save(product);
        return modelMapper.map(savedProduct, ProductDTO.class);
    }

    @Override
    public ProductResponse getAllProducts(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder) {
        Sort sortByAndOrder = sortOrder.equalsIgnoreCase("asc")
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageDetails = PageRequest.of(pageNumber, pageSize, sortByAndOrder);
        Page<Product> productPage = productRepository.findAll(pageDetails);

        if (productPage.isEmpty()) {
            return new ProductResponse();
        }

        List<ProductDTO> productDTOS = productPage.getContent().stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .toList();
        ProductResponse productResponse = new ProductResponse();
        productResponse.setContent(productDTOS);
        productResponse.setPageNumber(pageNumber);
        productResponse.setPageSize(pageSize);
        productResponse.setTotalPages(productPage.getTotalPages());
        productResponse.setTotalElements(productPage.getTotalElements());
        productResponse.setLastPage(productPage.isLast());

        return productResponse;
    }

    @Override
    public ProductResponse searchByCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category","categoryId",categoryId));
        List<Product> products = productRepository.findByCategoryOrderByPriceAsc(category);


        List<ProductDTO> productDTOS = products.stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .toList();
        ProductResponse productResponse = new ProductResponse();
        productResponse.setContent(productDTOS);
        return productResponse;
    }

    @Override
    public ProductResponse searchProductsByKeyword(String productKeyword) {

        List<Product> products = productRepository.findByProductNameLikeIgnoreCaseOrderByPriceAsc(productKeyword);


        List<ProductDTO> productDTOS = products.stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .toList();
        ProductResponse productResponse = new ProductResponse();
        productResponse.setContent(productDTOS);
        return productResponse;
    }

    @Override
    public ProductDTO getProductById(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "productId", productId));
        return modelMapper.map(product, ProductDTO.class);
    }

    @Override
    public ProductDTO updateProduct(Long productId, ProductDTO productDTO) {
        Product dbProduct = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "productId", productId));

        Product product = modelMapper.map(productDTO, Product.class);
        dbProduct.setProductName(product.getProductName());
        dbProduct.setDescription(product.getDescription());
        dbProduct.setQuantity(product.getQuantity());
        dbProduct.setDiscount(product.getDiscount());
        dbProduct.setPrice(product.getPrice());
        dbProduct.setSpecialPrice(product.getPrice() - product.getDiscount() * product.getPrice() * .01);
        Product savedProduct = productRepository.save(dbProduct);
        return modelMapper.map(savedProduct, ProductDTO.class);
    }

    @Override
    public ProductDTO deleteProduct(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "productId", productId));
        productRepository.delete(product);
        return modelMapper.map(product, ProductDTO.class);
    }

    @Override
    public ProductDTO updateProductImage(Long productId, MultipartFile image) throws IOException {
        Product dbProduct = productRepository.findById(productId)
                .orElseThrow(()->new ResourceNotFoundException("Product", "productId",productId));


        String filename = fileService.uploadImage(uploadDir, image);
        dbProduct.setImage(filename);
        Product udpatedProduct = productRepository.save(dbProduct);
        return modelMapper.map(udpatedProduct, ProductDTO.class);
    }




}
