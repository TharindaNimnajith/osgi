package producer_vegetable;

import java.util.ArrayList;

public class ServiceProduceImpl implements VegetableServiceProduce {
	ArrayList<String> vegetables_name = new ArrayList<String>();
	ArrayList<Double> vegetables_price = new ArrayList<Double>();

	public ServiceProduceImpl() {
		vegetables_name.add("Beans");
		vegetables_price.add(20.0);
		
		vegetables_name.add("Pumpkin");
		vegetables_price.add(160.0);
		
		vegetables_name.add("Tomato");
		vegetables_price.add(40.0);
		
		vegetables_name.add("Carrot");
		vegetables_price.add(200.0);
		
		vegetables_name.add("Potato");
		vegetables_price.add(250.0);
	}

	@Override
	public void displayVegetables() {
		for (int count = 0; count < vegetables_name.size(); count++)
			System.out.println((count + 1) + ". " + vegetables_name.get(count) + " - " + vegetables_price.get(count));
	}

	@Override
	public double getPrice(int item) {
		return vegetables_price.get(item - 1);
	}
}
