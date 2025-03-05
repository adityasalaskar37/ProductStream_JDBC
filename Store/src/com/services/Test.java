package com.services;

import java.util.Scanner;

import com.operationsmodel.Product;

public class Test {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Select an option:");
			System.out.println("1. Insert new product\n2. Delete existing product\n3. Update existing product\n4. Retrieve all products\n5. Retrieve particular product\n6. Close");
			int option = sc.nextInt();
			switch(option) {
			case 1:
				System.out.print("Enter Product id: ");
				int id = sc.nextInt();
				System.out.print("Enter Product name: ");
				String name = sc.next();
				sc.nextLine();
				System.out.print("Enter Product price: ");
				float price = sc.nextFloat();
				System.out.print("Enter Product quantity: ");
				int quantity = sc.nextInt();
				System.out.print("Enter Product category: ");
				String category = sc.next();
				Product.insert(id, name, price, quantity, category);
				break;
			case 2:
				System.out.print("Enter Product id: ");
				int id1 = sc.nextInt();
				Product.delete(id1);
				break;
			case 3:
				System.out.print("Enter Product id: ");
				int id2 = sc.nextInt();
				System.out.print("Update Product name to: ");
				String name1 = sc.next();
				sc.nextLine();
				System.out.print("Update Product price to: ");
				float price1 = sc.nextFloat();
				System.out.print("Update Product quantity to: ");
				int quantity1 = sc.nextInt();
				System.out.print("Update Product category to: ");
				String category1 = sc.next();
				Product.update(id2, name1, price1, quantity1, category1);
				break;
			case 4:
				Product.retrieveAllProducts();
				break;
			case 5:
				System.out.print("Enter product id: ");
				int id3 = sc.nextInt();
				Product.retrieveProductById(id3);
				break;
			case 6:
				System.exit(0);
			default:
				System.out.println("Wrong option...");
			}
		}
	}
}
