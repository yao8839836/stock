package test;

import java.io.IOException;
import java.util.List;

import util.Price;

public class ContinueStop {

	/*
	 * 统计一只股连续两天涨停后的一个交易日上涨几率
	 */

	public static void main(String[] args) throws IOException {

		String filename = "data//300431.csv";

		List<List<Double>> price_list = Price.getPriceInFileByDay(filename);

		int stop = 0;

		int rise = 0;

		for (int i = 0; i < price_list.size() - 3; i++) {

			List<Double> current = price_list.get(i);
			List<Double> next = price_list.get(i + 1);
			List<Double> next_next = price_list.get(i + 2);
			List<Double> next_next_next = price_list.get(i + 3);

			double current_close = current.get(3);
			double next_close = next.get(3);
			double next_next_close = next_next.get(3);
			double next_next_next_close = next_next_next.get(3);

			if (next_close / current_close >= 1.099 && next_next_close / next_close >= 1.099) {

				stop++;

				if (next_next_next_close > next_next_close)
					rise++;

			}

		}

		System.out.println(rise + "\t" + stop + "\t" + (double) rise / stop);

	}

}
