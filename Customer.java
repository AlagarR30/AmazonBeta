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
    
    public void removeFromCart(String productName) {
        if (this.cart.isEmpty()) {
            System.out.println("CANNOT REMOVE ITEMS FROM AN EMPTY CART");
            return;
        }
    
        for (Product product : this.cart) {
            if (product.product_name.equals(productName)) {
                cart.remove(product);
                System.out.println(productName + " IS REMOVED FROM YOUR CART");
                return;
            }
        }
        System.out.println(productName + " IS NOT FOUND IN YOUR CART");
        
    }
    
    
    public void viewCart() {
        int total=0;
        System.out.println("YOUR CART");
        this.cart.forEach(product -> {System.out.println("PRODUCT NAME : " + product.product_name +
                                                         "\nPRICE : " + product.price +
                                                         "\nQUANTITY : " + product.quantity);
                                                         total+=product.price;
                                                        });
                                                        System.out.println("YOU HAVE "+cart.size()+" ITEMS IN YOUR CART\nTOTAL : "+total+" \u20A8");                                                 
    }

    public void getCartPrice(){
        int total=0;
        this.cart.forEach(product->total+=product.price);
        System.out.println("YOU HAVE "+cart.size()+" ITEMS IN YOUR CART\nTOTAL : "+total+" \u20A8");
    }

    public void clearCart() {
    	this.cart.clear();
		
	}
    public List<Product> placeOrder() {
    	return this.cart;//return all the product added when orer placed
		}
    

}