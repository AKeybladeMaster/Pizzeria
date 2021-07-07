package esPizzeria;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		PizzaManager obj = new PizzaManager();
		//obj.initializeListaIngredienti();
		int menu_choice = 0;
		do {
			System.out.println("\n0. End the program"
							 + "\n1. Add a new pizza"
							 + "\n2. Find pizzas without the ingredient chosen by you"
							 + "\n3. Find pizzas with greater price than the one in input"
							 + "\n4. Find the ingredients of a pizza searched by its name"
							 + "\n5. Show the list of Super Pizzas"
							 + "\n6. Show the cheapest pizza in the menu");
			menu_choice = sc.nextInt();
			sc.nextLine();

			switch (menu_choice) {
			case 0:
				System.out.println("Program terminated.");
				System.exit(0);
				break;
			case 1:
				obj.addNewPizza();
				System.out.println("");
				break;

			case 2:
				obj.findPizzasWithoutOneIngredient();
				System.out.println("");
				break;

			case 3:
				obj.findPizzasWithGreaterPrice();
				System.out.println("");
				break;
				
			case 4:
				obj.findPizzasIngredients();
				System.out.println("");
				break;
				
			case 5:
				obj.printSuperPizzas();
				System.out.println("");
				break;
				
			case 6:
				obj.findCheapestPizza();
				System.out.println("");
				break;

			default:
				System.out.println("Scelta errata. Riprova.");
				System.out.println("");
				break;
			}
		} while (menu_choice != 0);
		
		sc.close();
	}

}
