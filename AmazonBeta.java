package AmazonBeta;

import java.util.Scanner;

public class AmazonBeta {
    
    public static void main(String args[]){
        Admin adminObj = new Admin();
        Scanner sc = new Scanner(System.in);
        boolean userFlag = true;
        while(userFlag){
            System.out.println("ENTER YOUR IDENTITY: \n1.ADMIN \n2.SELLER \n3.CUSTOMER ");
            int choosen = sc.nextInt();
            if(choosen == 1){
                System.out.println("ENTER ADMIN PASSWORD: ");
                String pass = sc.nextLine();
                if(adminObj.passCheck(pass)){
                    boolean adminFlag = true;
                    while (adminFlag){
                        System.out.println("\n1.PENDING REQUESTS \n2.APPROVE REQUEST \n3.VIEW INVENTORY \n4.REMOVE SELLER \n5.REMOVE PRODUCT");
                        int adminChoosen = sc.nextInt();
                        if(adminChoosen == 1){
                            adminObj.displayRequest();
                        }
                        else if(adminChoosen ==2){
                            System.out.println("ENTER THE SELLER NAME FOR APPROVAL: ");
                            String as = sc.nextLine();
                            System.out.println("ENTER THE PRODUCT NAME FOR APPROVAL: ");
                            String ap = sc.nextLine();
                            Seller seller = adminObj.findSeller(as);
                            if(seller != null){
                                adminObj.addInventory(seller, ap);
                            }
                            else System.out.println("SELLER NOT FOUND!");
                        }
                        else if(adminChoosen == 3){
                            adminObj.displayInventory();
                        }
                        else if(adminChoosen==4){
                            System.out.println("ENTER SELLERNAME: ");
                            String sname = sc.nextLine();
                            Seller seller = adminObj.findSeller(sname);
                            if(seller != null){
                                adminObj.removeSeller(sname);
                            }
                            else System.out.println("SELLER NOT FOUND!");
                        }
                        else if(adminChoosen == 5){
                            System.out.println("ENTER SELLER NAME: ");
                            String sname = sc.nextLine();
                            System.out.println("ENTER PRODUCT ID: ");
                            int  id = sc.nextInt();
                            Seller seller = adminObj.findSeller(sname);
                            if(seller != null){
                                adminObj.removeProduct(seller, id);
                            }
                            else System.out.println("SELLER NOT FOUND!");
                            
                        }
                        System.out.println("DO YOU WANT TO CONTINUE AS ADMIN (Y/N)? ");
                        String conti = sc.nextLine();
                        adminFlag = conti.equals("Y");
                    }
                }
                else System.out.println("WRONG ADMIN PASSWORD!");
            }
            else if(choosen ==2){
                
            }
            System.out.println("DO YOU WANT TO CONTINUE (Y/N)? ");
            String conti = sc.nextLine();
            userFlag = conti.equals("Y"); 
        }    
        
    }
}
