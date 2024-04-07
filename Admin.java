package AmazonBeta;

import java.util.*;
class Admin {
    //Instance variables
    public HashMap<Seller, List<Product>> inventory = new HashMap<>(); // used to remove a individual invventory or seller
    public HashMap<Seller, List<Product>> requests= new HashMap<>(); // used to approve requests!
    public HashMap<String, Seller> sellers = new HashMap<>();
    public void request(Seller s, Product p){
        // used to place request to the admin (to add it into inventory) by seller....
        List<Product> temp;
        if(requests.containsKey(s)){
            temp=requests.get(s); 
        }
        else{
            temp=new ArrayList<>();
        }
        temp.add(p);
        requests.put(s, temp);
        System.out.println("REQUEST PLACED SUCCESSFULLY !\n");
    }

    public Product searchProductRequest(Seller s, String productName){
        List<Product> temp = requests.get(s);
        for(Product iter:temp){
            if(iter.product_name.equals(productName)){
                return iter;
            }
        }
        return null;
    }

    public void displayRequest(){
        // used to display all the request by sellers for admin to approve one
        for(Seller s: requests.keySet()){
            System.out.println("SELLER : "+s.sellerName);
            List<Product> temp = requests.get(s);
            int index = 1;
            for(Product p:temp){
                System.out.println(index+".\tPRODUCT : "+p.product_name+"\tPRICE : "+p.price+"\tQUANTITY : "+p.quantity);
            }
        }
        System.out.println();
    }

    
    public void addInventory(String sellerName, String productName){

        // used to add the approved products to inventory
        Seller s = sellers.get(sellerName);
        Product p= searchProductRequest(s, productName);

        List<Product> temp;
        if(inventory.containsKey(s)){
            temp = inventory.get(s);
        }
        else{
            temp = new ArrayList<>();
        }

        temp.add(p);
        inventory.put(s, temp);

        requests.get(s).remove(p);
        if(requests.get(s).size()==0){
            requests.remove(s);
        }

        s.products.put(p.product_name, p);
        System.out.println("INVENTORY ADDED SUCCESSFULLY !\n");
    }
    
    public void displayInventory(){
        for(Seller s : inventory.keySet()){
            List<Product> temp = inventory.get(s);
            System.out.println("SELLER : "+s.sellerName);
            int index = 1;
            for(Product p:temp){
                System.out.println(index+".\tPRODUCT : "+p.product_name+"\tPRICE : "+p.price);
                index++;
            }
        }
        System.out.println();
    }
    
    public void removeProduct(Seller s, int product_index){
        if(inventory.containsKey(s)){
            List<Product> temp = inventory.get(s);
            Product p = temp.get(product_index-1);
            temp.remove(p);
            inventory.put(s, temp);
            s.products.remove(p.product_name);
            if(temp.size()==0){
                inventory.remove(s);
            }
            System.out.println("PRODUCT : "+p.product_name+" IS REMOVED SUCCESSFULLY !\n");
        }
        else{
            System.out.println("SELLER DOESN'T EXIST !\n");
        }
    }
    
    public void removeSeller(Seller s){
        requests.remove(s);
        inventory.remove(s);
        System.out.println("SELLER "+s.sellerName+" REMOVED SUCCESSFULLY !\n");
    }
}