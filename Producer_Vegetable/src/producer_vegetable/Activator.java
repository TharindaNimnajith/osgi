package producer_vegetable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
	ServiceRegistration produceServiceRegistration;

	public void start(BundleContext context) throws Exception {
		System.out.println("Vegetable producer started");
		VegetableServiceProduce producerService = new ServiceProduceImpl();
		produceServiceRegistration = context.registerService(VegetableServiceProduce.class.getName(), producerService, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Vegetable producer stopped");
		produceServiceRegistration.unregister();
	}
}
