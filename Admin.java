public package AmazonBeta;
import java.util.*;
class Admin {
    //Instance variables
    public HashMap<Product, Seller> products = new HashMap<>(); // used to remove a individual product
    public HashMap<Seller, Product> Inventory = new HashMap<>(); // used to remove a individual invventory or seller
    public HashMap<Seller, List<Product>> requests=new HashMap<>(); // used to approve requests!

    public void request(Seller s, Product p){
        List<Product> seller_products;
        if(requests.containsKey(s)){
            seller_products=requests.get(s); 
        }
        else{
            seller_products=new ArrayList<>();
        }
        seller_products.add(p);
        requests.put(s, seller_products);
    }

    public void displayRequest(){
        for(Seller s: requests.keySet()){
            System.out.println(s.name);
            List<Product> temp = requests.get(s);
            for(int i=0;i<temp.size();i++){
                System.out.println("Name : "+temp.get(i).name+"\tPrice : "+temp.get(i).price+"\tQuanitity : "+temp.get(i).quantity);
            }
            System.out.println();
        }
    }

    public void addInventory(){
        // used to add the approved products to inventory
        products.add(p, );
    }
    public void displayInventory();
    public void removeProduct();
    public void removeSeller();
}