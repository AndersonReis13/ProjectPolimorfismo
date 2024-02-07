package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Project {	
	public static void main(String args[]) {
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		List<Product> lista = new ArrayList<>();
		
		System.out.println("Quantos membros serão registrados?");
		int x = sc.nextInt();
		
		for(int i=1; i<=x;i++) {
			System.out.println("Produto" + i+1 + " info:" );
			
			
			System.out.print("Produto comum, usado ou importado? (c,u,i)");
			char let = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Nome: ");
			String name = sc.nextLine();
			System.out.print("Price: ");
			Double price = sc.nextDouble();
			
			if(let == 'u') {
				System.out.print(" Data: ");
				LocalDate data = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				Product pd = new UsedProduct(name, price, data);
				lista.add(pd);
			}else if(let == 'c') {
				Product pd = new Product(name, price);
				lista.add(pd);
			}else if(let == 'i') {
				System.out.print("Custos adicionais:  ");
				Double customsFee = sc.nextDouble();
				Product pd = new ImportedProduct(name, price, customsFee );
				lista.add(pd);
			}
		}
		
		System.out.println();
		
		for(Product p : lista) {
			System.out.print(p.priceTag());
		}
		
	}

}
