package producer_fruits;

import java.util.ArrayList;

public class ServiceProduceImpl implements FruitsServiceProduce {
	ArrayList<String> fruits_name = new ArrayList<String>();
	ArrayList<Double> fruits_price = new ArrayList<Double>();

	public ServiceProduceImpl() {
		fruits_name.add("Apple");
		fruits_price.add(200.0);
		
		fruits_name.add("Orange");
		fruits_price.add(100.0);
		
		fruits_name.add("Strawberry");
		fruits_price.add(800.0);
		
		fruits_name.add("Banana");
		fruits_price.add(250.0);
		
		fruits_name.add("Watermelon");
		fruits_price.add(600.0);
	}

	@Override
	public void displayFruits() {
		for (int count = 0; count < fruits_name.size(); count++)
			System.out.println((count + 1) + ". " + fruits_name.get(count) + " - " + fruits_price.get(count));
	}

	@Override
	public double getPrice(int item) {
		return fruits_price.get(item - 1);
	}
}
