package consumer_2;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import producer_fruits.FruitsServiceProduce;
import producer_stationary.StationaryServiceProduce;
import producer_textile.TextileServiceProduce;
import producer_vegetable.VegetableServiceProduce;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Activator implements BundleActivator {
	ServiceReference serviceReferenceVegetable;
	ServiceReference serviceReferenceFruits;
	ServiceReference serviceReferenceTextiles;
	ServiceReference serviceReferenceStationary;

	Scanner sc = new Scanner(System.in);

	public void start(BundleContext context) throws Exception {
		serviceReferenceVegetable = context.getServiceReference(VegetableServiceProduce.class.getName());
		VegetableServiceProduce vegetableServiceProduce = (VegetableServiceProduce) context
				.getService(serviceReferenceVegetable);

		serviceReferenceTextiles = context.getServiceReference(TextileServiceProduce.class.getName());
		TextileServiceProduce textileServiceProduce = (TextileServiceProduce) context
				.getService(serviceReferenceTextiles);

		serviceReferenceFruits = context.getServiceReference(FruitsServiceProduce.class.getName());
		FruitsServiceProduce fruitsServiceProduce = (FruitsServiceProduce) context.getService(serviceReferenceFruits);

		serviceReferenceStationary = context.getServiceReference(StationaryServiceProduce.class.getName());
		StationaryServiceProduce stationaryServiceProduce = (StationaryServiceProduce) context
				.getService(serviceReferenceStationary);

		System.out.println("Discounted consumer started");

		System.out.println("Categories");
		System.out.println("1. Vegetables");
		System.out.println("2. Fruits");
		System.out.println("3. Textile");
		System.out.println("4. Stationaries");

		try {
			double total = 0.0;
			double disPrice = 0.0;

			System.out.print("Select a category : ");
			int category = sc.nextInt();

			System.out.println("Enter items from the list. Enter 0 to exit.");

			if (category == 1) {
				vegetableServiceProduce.displayVegetables();
				int vegetable = sc.nextInt();
				while (vegetable != 0) {
					total += vegetableServiceProduce.getPrice(vegetable);
					vegetable = sc.nextInt();
				}
				disPrice = total - ( total * 0.1 );
				System.out.println("Congratulations! You have got 10%");
			} else if (category == 2) {
				fruitsServiceProduce.displayFruits();
				int fruit = sc.nextInt();
				while (fruit != 0) {
					total += fruitsServiceProduce.getPrice(fruit);
					fruit = sc.nextInt();
				}
				disPrice = total - ( total * 0.2 );
				System.out.println("Congratulations! You have got 20%");
			} else if (category == 3) {
				textileServiceProduce.displayClothes();
				int textile = sc.nextInt();
				while (textile != 0) {
					total += textileServiceProduce.getPrice(textile);
					textile = sc.nextInt();
				}
				disPrice = total - ( total * 0.3 );
				System.out.println("Congratulations! You have got 30%");
			} else if (category == 4) {
				stationaryServiceProduce.displayStationaries();
				int stationary = sc.nextInt();
				while (stationary != 0) {
					total += stationaryServiceProduce.getPrice(stationary);
					stationary = sc.nextInt();
				}
				disPrice = total - ( total * 0.4 );
				System.out.println("Congratulations! You have got 40%");
			} else {
				System.out.println("Invalid input. Try again!");
			}
			System.out.println("Total : " + total);
			System.out.println("Discounted Price : " + disPrice);
		} catch (InputMismatchException e) {
			System.out.println("Error! Enter an integer. " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Discounted consumer stopped");
		context.ungetService(serviceReferenceVegetable);
		context.ungetService(serviceReferenceFruits);
		context.ungetService(serviceReferenceStationary);
		context.ungetService(serviceReferenceTextiles);
	}
}
