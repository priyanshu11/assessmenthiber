package main;

import java.util.List;
import java.util.Scanner;

import dao.ProductDao;
import model.Product;

public class Main {

	public static void main(String[] args) {
		 int option = 0;
		
	        Scanner s = new Scanner(System.in);
            ProductDao fd=new ProductDao();
		 
		  do{
	            System.out.println("\n---------------------MENU---------------------------------");
	            System.out.println("If stockManager then:");
	            System.out.println("1. Add Product");
	            System.out.println("2. Update the Products in Stock");
	            System.out.println("3. Delete Product ");
	            System.out.println("4. Display Product ");
	            System.out.println("Option:");
	            option=s.nextInt();
	            switch (option){
                case 1:
                     fd.add(); 
                    break;
                case 2:
                	System.out.println("Name of the product for updation:");
                	String name=s.next();
                	fd.update(name);
                    break;
                case 3:
                	System.out.println("Name of the product to delete:");
                	String name1=s.next();
                	fd.delete(name1);
                	break;
                	
                case 4:
                    List<Product> gh=fd.printProducts();
                    for(Product i:gh)
                    {
                    	System.out.println(i);
                    }
 
                default:
                	option=8;
                	break;
            }
        }while ( option !=8);	

	}

}
			