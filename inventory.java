// Inventory Management System(Console-based)
// Author: Nayan Kewlani
import java.util.Scanner;
import java.util.ArrayList;
class Product{
	private String product;
	private int quantity;
	private int costprice;
	private int sellingprice;

		public Product(String tempproduct,int tempquantity,int tempcostprice,int tempsellprice){
			this.product=tempproduct;
			this.quantity=tempquantity;
			this.costprice=tempcostprice;
			this.sellingprice=tempsellprice;

		}
	public String getname(){
		return this.product;
	}
	public Integer getcostprice(){
		return this.costprice;
	}
	public Integer getquantity(){
		return this.quantity;
	}
	public Integer getsellingprice(){
		return this.sellingprice;

	}
	public void updatename(String change){
		this.product=change;
	}
	public void addquantity(int newquant){
		this.quantity+=newquant;
	}
	public void updatesellprice(int newsellprice){
		this.sellingprice=newsellprice;
	}
	public void updatecostprice(int newcostprice){
		this.costprice=newcostprice;
	}
	public String toString(){
		return "Name "+product
			+", quantity "+quantity
			+", cost "+costprice
			+", sell price "+sellingprice;
		}	
}

public class inventory{
	public static void main(String[] args){

		ArrayList<Product>productarray= new ArrayList<Product>();
		boolean end=false;
		Scanner scnr=new Scanner(System.in);
	while(!end){
	
	System.out.println("""
	______ Inventory Menu:____
	 Enter  1. Add New Product
		2. Update Stock
		3.view all product
	""");		
	
		int task=scnr.nextInt();
		scnr.nextLine();		
		if(task==1){
		
		System.out.println("enter new product name");
		String name=scnr.nextLine();
		
		System.out.println("enter quantity");
		int quantity=scnr.nextInt();
		
		System.out.println("enter cost Price");
		int costprice=scnr.nextInt();
		
		System.out.println("enter sell Price");
		int sellprice=scnr.nextInt();
		
		productarray.add(new Product(name,quantity,costprice,sellprice));
		System.out.println("you have sucessfully created a product "+name);
	
		System.out.println("press 1.to continue\n 2.to end");
		int confirm=scnr.nextInt();
		if(confirm==2){
		end=true;
		}
	}else if(task==2){
		boolean found=false;
		System.out.println("enter name of product you want change");
		
		String searchname=scnr.nextLine();
	
		for(Product tempproducts:productarray){
			
			if(tempproducts.getname().equalsIgnoreCase(searchname)){
			System.out.println("""
			what do you want to update:
			Enter 1. to update Product name
			2.To Update quantity
			3.to update sell price
			4.to update cost price
			""");
			int updateoption=scnr.nextInt();
			scnr.nextLine();

			if(updateoption==1){
				System.out.println("enter new name");
				String newname=scnr.nextLine();
				tempproducts.updatename(newname);
				System.out.print("changes saved sucessfully");
				}
			else if(updateoption==2){
				System.out.println("enter new quantity to add");
				int newquantity=scnr.nextInt();
				scnr.nextLine();
				tempproducts.addquantity(newquantity);
				System.out.print("changes saved sucessfully");
				}
			
			else if(updateoption==3){
				System.out.println("enter new sell price");
				int newselling=scnr.nextInt();
				scnr.nextLine();
				tempproducts.updatesellprice(newselling);
				System.out.print("changes saved sucessfully");
				}
			
			else if(updateoption==4){
				System.out.println("enter new costprice");
				int newcost=scnr.nextInt();
				scnr.nextLine();
				tempproducts.updatecostprice(newcost);
				System.out.print("changes saved sucessfully");
				}
			else{System.out.println("error");}
	
			found=true;
			break;
			}
		}
		
		if(!found){
			System.out.println("name not found");
			}

		System.out.println("press 1.to continue\n 2.to end");
		int confirm=scnr.nextInt();
		if(confirm==2){
		end=true;
			}
		}
		else if(task==3){
		for(Product p:productarray){
			System.out.println(p);
			}
		System.out.println("press 1.to continue\n 2.to end");
		int confirm=scnr.nextInt();
		if(confirm==2){
		end=true;
		}
		}else{System.out.println("invalid input");}
	}
}
}