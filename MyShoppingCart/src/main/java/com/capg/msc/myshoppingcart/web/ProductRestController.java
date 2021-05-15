package com.capg.msc.myshoppingcart.web;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.capg.msc.myshoppingcart.beans.Product;
import com.capg.msc.myshoppingcart.exception.InvalidCategoryException;
import com.capg.msc.myshoppingcart.exception.InvalidCostRangeException;
import com.capg.msc.myshoppingcart.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Validated
@RestController
@RequestMapping("/api")
@Api(value = "Online Laptop Store",description = "Various api works on laptop inventory management")
public class ProductRestController {
	
	@Autowired
	private ProductService service;
	
	public ProductRestController() {
		System.out.println("------>> Product Rest Controller Constructor");
	}
	@GetMapping("/home")
	public String homeRequest() {
		return "Welcome : My Shopping App" + LocalDateTime.now();
	}

	@ApiOperation(value = "Product post mapping" , response = Product.class)
	@PostMapping("/product/insert")
	public Product insertProduct(@RequestBody @Valid Product p) {
		service.saveProduct(p);
		return p;
	}
	
	@ApiOperation(value = "product Get mapping to fatch all products" , response = List.class)
	@GetMapping("/product/all")
	public List<Product> getAllproducts(){
		return service.getAllProducts();
	}
	
	@GetMapping("/product/search/{id}")
	public Product searchProduct(@PathVariable int id){
		return service.searchProduct(id);
	}
	
	@PutMapping("/product/update/{id}")
	public Product updateProduct(@RequestBody Product p,@PathVariable int id)
	{
		return service.updateProduct(p, id);
	}

	@PostMapping("/product/delete/{id}")
	public String deleteProduct(@PathVariable int id) {
		if (service.deleteProduct(id))return "Deleted!";
		else return "No such ID found";
	}
	
	@GetMapping("/products/{category}")
	public List<Product> getAllProductsByCategory(@PathVariable String category) throws InvalidCategoryException
	{
		if(category.equals("Laptop") || category.equals("Camera"))
		return service.getAllProductsByCategory(category);
		else throw new InvalidCategoryException(category);
	}
	
	@GetMapping("/products/{category}/{range1}/{range2}")
	public List<Product> getAllProductsByCategoryAndPrice(@PathVariable String category,
			@PathVariable int range1,@PathVariable int range2)throws InvalidCostRangeException
	{
		if(category.equals("Laptop")&&range1<10000)
		{
			throw new InvalidCostRangeException(range1,range2);
		}
		return service.getAllProductsByCategoryAndPrice(category, range1, range2);
	}
}
