package classifiers;

import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.functions.LibSVM;
import weka.classifiers.functions.Logistic;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.classifiers.meta.AdaBoostM1;
import weka.classifiers.trees.J48;
import weka.classifiers.trees.RandomForest;
import weka.core.Instances;

public class Classifiers {

	/**
	 * 训练Logistic Regression 分类器
	 * 
	 * @param train
	 *            训练集
	 * @return 训练好的分类器
	 * 
	 * @throws Exception
	 */
	public static Logistic logistic_regression(Instances train) throws Exception {

		System.out.println("Logistic Regression Training.......");

		Logistic logistic = new Logistic();

		logistic.setRidge(0.8);

		logistic.buildClassifier(train);

		System.out.println("Logistic Regression Training End.......");

		return logistic;

	}

	/**
	 * 训练SVM分类器
	 * 
	 * @param train
	 *            训练集
	 * @return 训练好的分类器
	 * @throws Exception
	 */
	public static LibSVM SVM(Instances train) throws Exception {

		System.out.println("SVM Training.......");

		LibSVM libsvm = new LibSVM();

		libsvm.setCost(100);

		libsvm.buildClassifier(train);

		System.out.println("SVM Training End.......");

		return libsvm;

	}

	/**
	 * 训练随机森林分类器
	 * 
	 * @param train
	 *            训练集
	 * @return 训练好的分类器
	 * @throws Exception
	 */
	public static RandomForest random_forest(Instances train) throws Exception {

		System.out.println("RandomForest Training.......");

		RandomForest forest = new RandomForest();

		forest.setNumTrees(100);

		// forest.setMaxDepth(10);

		forest.buildClassifier(train);

		System.out.println("RandomForest Training End.......");

		return forest;

	}

	/**
	 * 训练朴素贝叶斯分类器
	 * 
	 * @param train
	 *            训练集
	 * @return 训练好的分类器
	 * @throws Exception
	 */
	public static NaiveBayes naive_bayes(Instances train) throws Exception {

		System.out.println("Naive Bayes Training.......");

		NaiveBayes bayes = new NaiveBayes();

		bayes.buildClassifier(train);

		System.out.println("Naive Bayes Training End.......");

		return bayes;

	}

	/**
	 * 训练BP神经网络分类器
	 * 
	 * @param train
	 *            训练集
	 * @return 训练好的分类器
	 * @throws Exception
	 */
	public static MultilayerPerceptron BP(Instances train) throws Exception {

		System.out.println("BP Training.......");

		MultilayerPerceptron mlp = new MultilayerPerceptron();

		mlp.buildClassifier(train);

		System.out.println("BP Training End.......");

		return mlp;
	}

	/**
	 * 训练C4.5决策树分类器
	 * 
	 * @param train
	 *            训练集
	 * @return 训练好的分类器
	 * @throws Exception
	 */
	public static J48 decision_tree(Instances train) throws Exception {

		System.out.println("C4.5 Training.......");

		J48 tree = new J48();

		tree.buildClassifier(train);

		System.out.println("C4.5 Training End.......");

		return tree;
	}

	/**
	 * 训练Adaboost组合分类器
	 * 
	 * @param train
	 *            训练集
	 * @return 训练好的分类器
	 * @throws Exception
	 */
	public static AdaBoostM1 Ada_boost(Instances train) throws Exception {

		System.out.println("Adaboost Training.......");

		AdaBoostM1 boost = new AdaBoostM1();

		boost.buildClassifier(train);

		System.out.println("Adaboost Training End.......");

		return boost;

	}

}
