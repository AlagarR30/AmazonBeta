public package AmazonBeta;
import java.util.*;
class Admin {
    //Instance variables
    public HashMap<Seller, List<Product>> inventory = new HashMap<>(); // used to remove a individual invventory or seller
    public HashMap<Seller, List<Product>> requests=new HashMap<>(); // used to approve requests!
    
    public void request(Seller s, Product p){
        // used to place request to the admin (to add it into inventory) by seller....
        List<Product> seller_products;
        if(requests.containsKey(s)){
            seller_products=requests.get(s); 
        }
        else{
            seller_products=new ArrayList<>();
        }
        seller_products.add(p);
        requests.put(s, seller_products);
        System.out.println("REQUEST PLACED SUCCESSFULLY !\n");
    }

    public void displayRequest(){
        // used to display all the request by sellers for admin to approve one
        for(Seller s: requests.keySet()){
            System.out.println("SELLER : "+s.name);
            List<Product> temp = requests.get(s);
            for(int i=0;i<temp.size();i++){
                System.out.println((i+1)+".\tPRODUCT : "+temp.get(i).name+"\tPRICE : "+temp.get(i).price+"\tQUANTITY : "+temp.get(i).quantity);
            }
            System.out.println();
        }
        System.out.println();
    }

    public void addInventory(Seller s, int product_index){
        // used to add the approved products to inventory
        Product p= requests.get(s).get(product_index-1);

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

        System.out.println("INVENTORY ADDED SUCCESSFULLY !\n");
    }
    
    public void displayInventory(){
        for(Seller s : inventory.keySet()){
            List<Product> temp = inventory.get(s);
            System.out.println("SELLER : "+s);
            int index = 1;
            for(Product p:temp){
                System.out.println(index+".\tPRODUCT : "+p.name+"\tPRICE : "+p.price);
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

            if(temp.size()==0){
                inventory.remove(s);
            }
            System.out.println("PRODUCT : "+p.name+" IS REMOVED SUCCESSFULLY !\n");
        }
        else{
            System.out.println("SELLER DOESN'T EXIST !\n");
        }
    }
    
    public void removeSeller(Seller s){
        requests.remove(s);
        inventory.remove(s);
        System.out.println("SELLER REMOVED SUCCESSFULLY !\n");
    }
}