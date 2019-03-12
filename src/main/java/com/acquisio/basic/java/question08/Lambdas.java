package com.acquisio.basic.java.question08;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * QUESTION 09: Lambdas
 * (https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html)
 * Using JDK8 Lambdas, add the code to transform the input file to apply those
 * rules. 1- Keep lines where the amount is greater than or equals to 50$ 2- Add
 * a Taxes column right after the Amount column, which is 15% of the Amount. 3-
 * Add a Total column right after the Taxes column, which is the sum of Amount
 * and Taxes. 4- Remove the ShoppingCartTitle columns.
 * <p>
 * The input file contains those columns User,Amount,ShoppingCartTitle,NbItems
 * <p>
 * IMPORTANT: Add all missing javadoc and/or unit tests that you think is
 * necessary.
 */

public class Lambdas {

	private final String CSV_DELIMITER = ",";
	private final float TAX_RATE = 0.15F;

	public static void main(String[] args) throws IOException, URISyntaxException {
		Lambdas instance = new Lambdas();
		File input = new File(Thread.currentThread().getContextClassLoader().getResource("./carts.csv").toURI());
		File output = new File("./carts_output.csv");
		output.delete();

		instance.convertCarts(input, output);

		if (output.exists()) {
			Files.lines(output.toPath()).forEachOrdered(line -> System.out.println(line));
		}
	}

	/**
	 * Convert a line to OrderDetail obj
	 */
	private Function<String, OrderDetail> mapToOrderDetail = (line) -> {
		String[] cols = line.split(CSV_DELIMITER);

		OrderDetail item = new OrderDetail();
		item.setUser(cols[0]);
		if (cols.length > 1)
			try {
				item.setAmount(Double.parseDouble(cols[1]));
			} catch (NumberFormatException nfe) {
			}
		if (cols.length > 2)
			item.setShoppingCartTitle(cols[2]);
		if (cols.length > 3)
			try {
				item.setNbItems(Integer.parseInt(cols[3]));
			} catch (NumberFormatException nfe) {
			}
		return item;
	};

	void convertCarts(File input, File output) throws IOException {
		List<OrderDetail> allOrdersDetailList = new ArrayList<OrderDetail>();
		allOrdersDetailList = Files.lines(Paths.get(input.getPath())).map(mapToOrderDetail)
				.collect(Collectors.toList());
		// filter out the orders with amount greater than 50$
		List<OrderDetail> filteredOrdersDetailList = allOrdersDetailList.stream()
				.filter(order -> (order.getAmount() >= 50.0)).collect(Collectors.toList());
		dumpListToOutputFile(filteredOrdersDetailList, output);
	}

	/**
	 * Write the output file with additional columns (Tax & Total)
	 * @param orderList 
	 * @param output
	 * @throws IOException
	 */
	void dumpListToOutputFile(List<OrderDetail> orderList, File output) throws IOException {
		String lineTmp;

		try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output.getPath())))) {
			// User,Amount,Tax, Total, (ShoppingCartTitle),NbItems
			for (OrderDetail od : orderList) {
				double tax = od.getAmount() * TAX_RATE;
				double total = od.getAmount() + tax;
				lineTmp = od.getUser() + CSV_DELIMITER + String.format("%.2f", od.getAmount()) + CSV_DELIMITER
						+ String.format("%.2f", tax) + CSV_DELIMITER + String.format("%.2f", total) + CSV_DELIMITER
						+ od.getNbItems();
				// System.out.println(lineTmp);
				writer.write(lineTmp + "\n");
			}
		}
	}

}
