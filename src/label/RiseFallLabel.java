package label;

import java.util.List;

public class RiseFallLabel {

	/**
	 * 
	 * 返回数据集的label列表， 假设问题是用前30天的价格信息预测之后的三天有没有机会 (三天的平均收盘价是否大于第30天)
	 * 
	 * @param price_list
	 *            每天四个价格
	 * @return
	 */
	public static int[] getLabelList(List<List<Double>> price_list) {

		int[] label = new int[price_list.size() - 50 - 2];

		int list_size = price_list.size();

		for (int i = 50; i < list_size - 2; i++) {

			List<Double> current_price_1 = price_list.get(i);
			List<Double> current_price_2 = price_list.get(i + 1);
			List<Double> current_price_3 = price_list.get(i + 2);

			double close_price_1 = current_price_1.get(3);
			double close_price_2 = current_price_2.get(3);
			double close_price_3 = current_price_3.get(3);

			double average = (close_price_1 + close_price_2 + close_price_3) / 3;

			List<Double> last_day_price = price_list.get(i - 1);

			double last_day_close = last_day_price.get(3);

			if (average > last_day_close) {

				label[i - 50] = 1;

			}

		}

		return label;
	}
}
