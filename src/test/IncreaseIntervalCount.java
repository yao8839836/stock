package test;

import java.io.IOException;
import java.util.List;

import util.Price;
import util.ReadWriteFile;

public class IncreaseIntervalCount {

	/**
	 * 1. 前日最高价为涨停价，但收盘价不是涨停价 。 2. 昨日涨停 。求今日最低涨幅最高涨幅区间
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		String filename = "data//300431.csv";

		List<List<Double>> price_list = Price.getPriceInFileByDay(filename);

		// List<double[]> intervals = new ArrayList<>();

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < price_list.size() - 3; i++) {

			List<Double> current = price_list.get(i);
			List<Double> next = price_list.get(i + 1);
			List<Double> next_next = price_list.get(i + 2);
			List<Double> next_next_next = price_list.get(i + 3);

			double current_close = current.get(3);
			double next_close = next.get(3);
			double next_next_close = next_next.get(3);
			// double next_next_next_close = next_next_next.get(3);

			double next_high = next.get(1);

			if (next_high / current_close >= 1.099 && next_close / current_close < 1.099) {

				if (next_next_close / next_close >= 1.099) {

					double next_next_next_high = next_next_next.get(1);
					double next_next_next_low = next_next_next.get(2);

					double max = (next_next_next_high - next_next_close) / next_next_close;

					double min = (next_next_next_low - next_next_close) / next_next_close;

					System.out.println("最大涨幅：" + max * 100 + "%" + "\t" + "最小涨幅：" + min * 100 + "%");

					sb.append(max + "," + min + "\n");

				}

			}

		}
		System.out.println("输出文件：file//最大最小范围.csv");
		ReadWriteFile.writeFile("file//最大最小范围.csv", sb.toString());

	}

}
