package jedpayt.demo.main;

import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jedpayt.demo.entity.Product;
import jedpayt.demo.entity.Vendor;
import jedpayt.demo.service.api.ServiceApi;

public class Main {
    public static void main( String[] args ){
    	
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");        
		ServiceApi service = (ServiceApi) ctx.getBean("serviceImpl");
		
		
		System.out.println( "\n  ~Spring Hibernate Demo~  \n" );

		System.out.println("Creating product...");
		Product product_a = new Product();
		product_a.setProd_name("Rake");
		product_a.setProd_price(20.00);
		product_a.setProd_qoh(10);
		service.createProduct(product_a);
		System.out.println("Product created: " + product_a.getProd_name() + "\n");
		
		
		System.out.println("Creating vendor...");
		Vendor vendor_a = new Vendor();
		vendor_a.setVendor_name("WYX Distributors");
		vendor_a.setVendor_address("100 East St.");
		vendor_a.setVendor_city("Denver");
		vendor_a.setVendor_state("CO");
		vendor_a.setVendor_contact("Sarah Bleach");
		vendor_a.setVendor_phone("713-321-5555");
		service.createVendor(vendor_a);
		System.out.println("Vendor created: " + vendor_a.getVendor_name() + "\n");
		
		System.out.println("Updating product...");
		Product product_b = service.getProductByName("Rake");
		product_b.setVendor(vendor_a);
		service.updateProduct(product_b);
		System.out.println("Product updated: " + product_b.getProd_name() + "\n");
		
		System.out.println("Getting all vendors...");
		List<Vendor> vendor_list = service.getAllVendors();
		System.out.println("Printing vendors and products...");
		for(Vendor v : vendor_list){
			System.out.println(v);
			for(Product p : v.getProducts())
				System.out.println(p);
		}
		System.out.print("\n");
		
		System.out.println("Deleting product...");
		service.deleteProduct(product_b);
		System.out.println("Product deleted. \n");

        System.out.println("\n~End~");
    }
    public void process(){
    	
    	
    }

}