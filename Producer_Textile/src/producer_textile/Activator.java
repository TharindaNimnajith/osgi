package producer_textile;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
	ServiceRegistration produceServiceRegistration;

	public void start(BundleContext context) throws Exception {
		System.out.println("Textiles producer started");
		TextileServiceProduce producerService = new ServiceProduceImpl();
		produceServiceRegistration = context.registerService(TextileServiceProduce.class.getName(), producerService, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Textiles producer stopped");
		produceServiceRegistration.unregister();
	}
}
