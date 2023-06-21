package com.srishti.productservice;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.srishti.productservice.dto.ProductRequest;
import com.srishti.productservice.model.Product;
import com.srishti.productservice.service.ProductService;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;



@SpringBootTest
//@AutoConfigureMockMvc
class ProductServiceApplicationTests {
	// @Container
	// static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:6.0.3");

	// @Autowired
	// private MockMvc mockMvc;

	// @Autowired
	// private ObjectMapper objectMapper;

	// @MockBean
    // private ProductService productService;

	// @DynamicPropertySource
	// static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry) {
	// 	dynamicPropertyRegistry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
	// }

	// @Test
	// void shouldCreateProduct() throws Exception {
	// 	ProductRequest productRequest = getProductRequest();
	// 	Product product = new Product();
    //     product.setName(productRequest.getName());
    //     product.setDescription(productRequest.getDescription());
	// 	product.setPrice(productRequest.getPrice());
		
	// 	//Mockito.when(productService.createProduct(Mockito.any(ProductRequest.class))).thenReturn(product);

	// 	Mockito.when(productService.createProduct(Mockito.any(ProductRequest.class)));

	// 	String productRequestString = objectMapper.writeValueAsString(productRequest);

	// 	mockMvc.perform(MockMvcRequestBuilders.post("/api/product")
	// 		.contentType(MediaType.APPLICATION_JSON)
	// 		.content(productRequestString)
	// 	).andExpect(status().isOk());

	// }

	private ProductRequest getProductRequest() {
		return ProductRequest.builder()
				.name("iphone 13")
				.description("iphone 13")
				.price(BigDecimal.valueOf(100000))
				.build();
	}

}
