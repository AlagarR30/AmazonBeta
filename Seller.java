import java.util.HashMap;

class Seller{
    String sellerName;
    HashMap<String,Product> products=new HashMap<>();
    Seller(String sellerName){
        this.sellerName=sellerName;
    }

    public void addProduct(String productName,int price,int quantity){
        Admin a=new Admin();
        a.request(this,new Product(productName,price,quantity));
    }

    public void getProductByName(String productName){
        if(products.containsKey(productName)){
            Product p=products.get(productName);
            System.out.println("PRODUCT NAME : "+p.product_name);
            System.out.println("PRODUCT PRICE : "+p.price);
            System.out.println("PRODUCT NAME : "+p.quantity);
        }else{
            System.out.println("PRODUCT DOES NOT EXIST!");
        }
    }

    public void displayProducts(){
        for(String pName:products.getKey()){
            getProductByName(pName);
            System.out.println();
        }
    }



}