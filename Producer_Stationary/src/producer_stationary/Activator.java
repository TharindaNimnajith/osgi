package producer_stationary;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
	ServiceRegistration produceServiceRegistration;

	public void start(BundleContext context) throws Exception {
		System.out.println("Stationary producer started ");
		StationaryServiceProduce producerService = new ServiceProduceImpl();
		produceServiceRegistration = context.registerService(StationaryServiceProduce.class.getName(), producerService, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Stationary producer stopped");
		produceServiceRegistration.unregister();
	}
}
