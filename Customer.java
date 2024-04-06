package amazonBeta.AmazonBeta;

import java.util.*;

class Customer{
    String CustomerName = "";
public Customer(String name ){
    CustomerName = name;
}
    List<Product> cart = new ArrayList<>();
    
    public void addToCart(Product product) {
    	this.cart.add(product);//add each product to cart
    	System.out.println(product+" IS ADDED TO YOUR CART");
    	
		
	}
    
    public void removeFromCart(Product product) {
    	this.cart.remove(product);
    	System.out.println(product+" IS REMOVED FROM YOUR CART");
		
	}
    
    public void viewCart() {
        System.out.println("YOUR CART");
        this.cart.forEach(product -> System.out.println("PRODUCT NAME : " + product.product_name +
                                                         "\nPRICE : " + product.price +
                                                         "\nQUANTITY : " + product.quantity));
    }

    public void clearCart() {
    	this.cart.clear();
		
	}
    public List<Product> placeOrder() {
    	return this.cart;//return all the product added when orer placed
		}
    

}