package feature;

import java.util.List;

public class Feature {

	/**
	 * 返回数据集的feature列表， 假设问题是用前30天的价格信息预测之后的三天有没有机会 (三天的平均收盘价是否大于第30天)
	 * 
	 * @param price_list
	 *            每天四个价格
	 * @return
	 */
	public static double[][] simpleFeature(List<List<Double>> price_list) {

		int data_size = price_list.size() - 50 - 2;

		double[][] data_feature = new double[data_size][250];

		int list_size = price_list.size();

		for (int i = 50; i < list_size - 2; i++) {

			for (int j = 0; j < 50; j++) {

				List<Double> price = price_list.get(i - 1 - j);

				int price_kind = price.size();

				for (int k = 0; k < price_kind; k++)
					data_feature[i - 50][j * 5 + k] = price.get(k);

			}

		}

		return data_feature;

	}

}
