package com.jhomlala.sparking.spark;

import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public abstract class SparkJob {

	protected SparkSession sparkSession;

	public void init(SparkService sparkService) {
		this.sparkSession = sparkService.sparkSession;
		
	}
	public abstract void run();

	
}
