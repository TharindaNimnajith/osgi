package producer_stationary;

import java.util.ArrayList;

public class ServiceProduceImpl implements StationaryServiceProduce {
	ArrayList<String> stationaries_name = new ArrayList<String>();
	ArrayList<Double> stationaries_price = new ArrayList<Double>();

	public ServiceProduceImpl() {
		stationaries_name.add("Pen");
		stationaries_price.add(20.0);
		
		stationaries_name.add("Pencil");
		stationaries_price.add(10.0);
		
		stationaries_name.add("Book");
		stationaries_price.add(80.0);
		
		stationaries_name.add("Ruler");
		stationaries_price.add(25.0);
		
		stationaries_name.add("Box");
		stationaries_price.add(60.0);
	}

	@Override
	public void displayStationaries() {
		for (int count = 0; count < stationaries_name.size(); count++)
			System.out.println((count + 1) + ". " + stationaries_name.get(count) + " - " + stationaries_price.get(count));
	}

	@Override
	public double getPrice(int item) {
		return stationaries_price.get(item - 1);
	}
}
