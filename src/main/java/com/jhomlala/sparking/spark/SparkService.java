package com.jhomlala.sparking.spark;

import javax.annotation.PostConstruct;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhomlala.sparking.config.ApplicationConfig;

@Service
public class SparkService {

	@Autowired
	private ApplicationConfig config;
	@Autowired
	private ThreadPoolService threadPoolService;
	
	
	public SparkSession sparkSession;
	public SparkConf sparkConf;
	public JavaSparkContext sparkContext;

	@PostConstruct
	public void init() {
		System.out.println("INIT SPARK CONF");
		sparkConf = new SparkConf().setAppName("Spark").setSparkHome(config.getSparkHome())
				.setMaster(config.getMasterUri());
		sparkContext = new JavaSparkContext(sparkConf);
		sparkSession = SparkSession.builder().sparkContext(sparkContext.sc())
				.appName("Java Spark SQL basic example").getOrCreate();
	}

	public void startJob(SparkJob job) {
		job.init(this);
		job.run();
	}
	
	public void startAsyncJob(SparkJob job){
		System.out.println("Starting async job.");
		job.init(this);
		threadPoolService.processJob(new WorkerThread(job));
	}

}
