package com.pluralsight.corejdbc.m3c3;

public class Main {

	public static void main(String[] args) throws Exception {
		try {
			final String errorMsg = "You must secify either JEE or CDI as an imput paramters";

			if (args.length != 1) {
				System.out.println(errorMsg);
				return;
			}

			String argValue = args[0];

			if (argValue.equalsIgnoreCase("JEE")) {

				ProductsComponent_JEE component = new ProductsComponent_JEE();
				DataSourceProducer producer = new DataSourceProducer();
				component.dataSource = producer.produceDataSource();

				if (component.getProductCount()) {
					System.out.println("Demo m3c3: Try to Connect with JEE DataSource");
					System.out.println("SUCCESS");
				} else {
					System.out.println("Demo m3c3: Try to Connect with JEE DataSource");
					System.out.println("FAILED");
				}

			} else if (argValue.equalsIgnoreCase("CDI")) {

				ProductsComponent_CDI component = new ProductsComponent_CDI();
				DataSourceProducer producer = new DataSourceProducer();
				component.dataSource = producer.produceDataSource();

				if (component.getProductCount()) {
					System.out.println("Demo m3c3: Try to Connect with CDI DataSource");
					System.out.println("SUCCESS");
				} else {
					System.out.println("Demo m3c3: Try to Connect with CDI DataSource");
					System.out.println("FAILED");
				}

			} else {
				System.out.println(errorMsg);
			}

		} catch (Exception exception) {
			util.ExceptionHandler.handleException(exception);
		}

	}
}
