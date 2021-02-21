package producer_textile;

import java.util.ArrayList;

public class ServiceProduceImpl implements TextileServiceProduce {
	ArrayList<String> textiles_name = new ArrayList<String>();
	ArrayList<Double> textiles_price = new ArrayList<Double>();

	public ServiceProduceImpl() {
		textiles_name.add("T-Shirt");
		textiles_price.add(250.0);
		
		textiles_name.add("Shirt");
		textiles_price.add(150.0);
		
		textiles_name.add("Skirt");
		textiles_price.add(400.0);
		
		textiles_name.add("Trousers");
		textiles_price.add(2000.0);
		
		textiles_name.add("Tie");
		textiles_price.add(200.0);
	}

	@Override
	public void displayClothes() {
		for (int count = 0; count < textiles_name.size(); count++)
			System.out.println((count + 1) + ". " + textiles_name.get(count) + " - " + textiles_price.get(count));
	}

	@Override
	public double getPrice(int item) {
		return textiles_price.get(item - 1);
	}
}
