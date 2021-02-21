package producer_fruits;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
	ServiceRegistration produceServiceRegistration;

	public void start(BundleContext context) throws Exception {
		System.out.println("Fruits producer started");
		FruitsServiceProduce producerService = new ServiceProduceImpl();
		produceServiceRegistration = context.registerService(FruitsServiceProduce.class.getName(), producerService, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Fruits producer stopped");
		produceServiceRegistration.unregister();
	}
}
