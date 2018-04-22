package com.jhomlala.sparking.spark;

import java.util.Arrays;
import java.util.List;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.sql.SparkSession;
import org.springframework.stereotype.Component;

import scala.Tuple2;

@Component
public class WordCountSparkJob extends SparkJob {

	@Override
	public void run() {
		System.out.println("Started!");
		System.out.println("Running session: " + sparkSession.toString());
		SparkSession spark = sparkSession;
		JavaRDD<String> textFile = spark.read().textFile("/Users/user/Documents/test.txt").javaRDD();
		JavaPairRDD<String, Integer> counts = textFile
			    .flatMap(s -> Arrays.asList(s.split(" ")).iterator())
			    .mapToPair(word -> new Tuple2<>(word, 1))
			    .reduceByKey((a, b) -> a + b);

		List<Tuple2<String, Integer>> output = counts.collect();
		for (Tuple2<?, ?> tuple : output) {
			System.out.println(tuple._1() + ": " + tuple._2());
		}

	}

}
