package esPizzeria;

import java.util.ArrayList;

public class Pizza {

	private String name;
	private float price;
	private ArrayList<String> list_of_ingredients;
	
	public Pizza(String name, ArrayList<String> list_of_ingredients, float price) {
		this.name = name;
		this.price = price;
		this.list_of_ingredients = list_of_ingredients;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public ArrayList<String> getList_of_ingredients() {
		return list_of_ingredients;
	}

	public void setList_of_ingredients(ArrayList<String> list_of_ingredients) {
		this.list_of_ingredients = list_of_ingredients;
	}

	@Override
	public String toString() {
		if (this instanceof Pizza) {
		return "Common Pizza - [" + name + "], price=[" + price + "], list of ingredients=[" + list_of_ingredients + "]";
		}
		else {
			return "Super Pizza - [" + name + "], price=[" + price + "], list of ingredients=[" + list_of_ingredients + "]";
		}
	}
}
