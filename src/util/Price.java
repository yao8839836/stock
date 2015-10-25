package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Price {

	/**
	 * 从文件中读取某个股票(指数)的每天价格列表，包括开盘最高最低收盘成交量
	 * 
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	public static List<List<Double>> getPriceInFileByDay(String filename) throws IOException {

		File f = new File(filename);
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f), "UTF-8"));
		String line = "";

		List<List<Double>> price_list = new ArrayList<>();

		reader.readLine();
		while ((line = reader.readLine()) != null) {

			String[] temp = line.split(",");
			List<Double> price = new ArrayList<>();

			price.add(Double.parseDouble(temp[1]));
			price.add(Double.parseDouble(temp[2]));
			price.add(Double.parseDouble(temp[3]));
			price.add(Double.parseDouble(temp[4]));
			price.add(Double.parseDouble(temp[5]));

			price_list.add(price);

		}
		reader.close();

		Collections.reverse(price_list);
		return price_list;

	}

}
