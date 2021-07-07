package esPizzeria;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PizzaManager {

	Scanner sc = new Scanner(System.in);
	private ArrayList<Pizza> list_of_pizzas;
	private String[] list_of_ingredients = { "Pepperoni", "Prosciutto cotto", "Prosciutto crudo", "Porcini mushrooms",
			"Parmigiano reggiano", "Olives", "Tuna", "Sausages", "Chips", "Mozzarella" };

	private String pizza_name, ingredient_input;
	private float pizza_price;
	boolean is_present;

	public PizzaManager() {
		list_of_pizzas = new ArrayList<Pizza>();
	}

	public void addNewPizza() {
		ArrayList<String> list_of_ingredients_in_input = new ArrayList<String>();
		System.out.print("Pizza name: ");
		pizza_name = sc.nextLine();
		printListOfIngredients();
		do {
			System.out.print("\nType the ingredient (blank to end): ");
			ingredient_input = sc.nextLine();

			if (ingredientExists(ingredient_input)) {
				list_of_ingredients_in_input.add(ingredient_input.toLowerCase());
				System.out.println("Ingredient added!");
			} else if (ingredient_input.isBlank() || ingredient_input.isEmpty())
				continue;
			else
				System.out.println("It doesn't exist. Try again.");
		} while (!ingredient_input.equals(""));

		try {
			System.out.print("Price (float with a comma): ");
			pizza_price = sc.nextFloat();
			sc.nextLine();

			if (list_of_ingredients_in_input.size() > 10) {
				list_of_pizzas.add(new SuperPizza(pizza_name, list_of_ingredients_in_input, pizza_price));
				System.out.println("Super Pizza added!");
			} else {
				list_of_pizzas.add(new Pizza(pizza_name, list_of_ingredients_in_input, pizza_price));
				System.out.println("Common Pizza added!");
			}
		} catch (InputMismatchException e) {
			System.out.println("Incorrect input! Returning to the start...");
			sc.nextLine();
		}
	}

	public void findPizzasWithoutOneIngredient() {
		if (list_of_pizzas.size() == 0)
			System.out.println("There's no pizzas yet! Add some first.");
		else {
			System.out.print("Type the ingredient you don't want to show in your pizza choice: ");
			ingredient_input = sc.nextLine();
			if (ingredientExists(ingredient_input)) {
			System.out.println("");
			for (int i = 0; i < list_of_pizzas.size(); i++) {
				if (!list_of_pizzas.get(i).getList_of_ingredients().contains(ingredient_input.toLowerCase())) {
					System.out.println(list_of_pizzas.get(i));
				}
			}
			}
			else
				System.out.println("This ingredient doesn't exist!");
		}
	}

	public void findPizzasWithGreaterPrice() {
		if (list_of_pizzas.size() == 0)
			System.out.println("There's no pizzas yet! Add some first.");
		else {
			try {
				System.out.print("Type the price to use to filter (float with a comma): ");
				pizza_price = sc.nextFloat();
				sc.nextLine();
				for (int i = 0; i < list_of_pizzas.size(); i++) {
					if (list_of_pizzas.get(i).getPrice() > pizza_price) {
						System.out.println(list_of_pizzas.get(i));
					}
				}
			} catch (InputMismatchException e) {
				System.out.println("Incorrect input! Returning to the start...");
			}
		}
	}

	public void findPizzasIngredients() {
		if (list_of_pizzas.size() == 0)
			System.out.println("There's no pizzas yet! Add some first.");
		else {
			System.out.println("Here's the list of pizza names: ");
			for (int i = 0; i < list_of_pizzas.size(); i++) {
				System.out.println(list_of_pizzas.get(i).getName());
			}
			System.out.print("\nType the name of a pizza whom you want to show the ingredients of: ");
			pizza_name = sc.nextLine();

			for (int j = 0; j < list_of_pizzas.size(); j++) {
				if (list_of_pizzas.get(j).getName().equalsIgnoreCase(pizza_name)) {
					System.out.println("Here's the pizza ingredients: ");
					System.out.println(list_of_pizzas.get(j).getList_of_ingredients());
				}
			}
		}
	}

	public void printSuperPizzas() {
		if (list_of_pizzas.size() == 0)
			System.out.println("There's no pizzas yet! Add some first.");
		else {
			System.out.println("Here's the list of Super Pizzas: ");
			for (Pizza p : list_of_pizzas) {
				 if (p instanceof SuperPizza) {
				System.out.println(p.toString());
				 }
			}
		}
	}

	public void findCheapestPizza() {
		Pizza p = null;
		float min = 100000;
		if (list_of_pizzas.size() == 0)
			System.out.println("There's no pizzas yet! Add some first.");
		else {
			for (int i = 0; i < list_of_pizzas.size(); i++) {
				if (list_of_pizzas.get(i).getPrice() < min) {
					min = list_of_pizzas.get(i).getPrice();
					p = list_of_pizzas.get(i);
				}
			}
			System.out.println("Here's the cheapest pizza:\n" + p.toString());
		}
	}

	private void printListOfIngredients() {
		System.out.println("Ecco la lista degli ingredienti ");
		for (int i = 0; i < list_of_ingredients.length; i++) {
			System.out.println(list_of_ingredients[i]);
		}
	}

	private boolean ingredientExists(String ingredient_input) {
		for (int j = 0; j < list_of_ingredients.length; j++) {
			if (ingredient_input.equalsIgnoreCase(list_of_ingredients[j])) {
				return true;
			}
		}
		return false;
	}
}
