package com.jhomlala.sparking.config;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
public class ApplicationConfig {

	@Value("${spark.home}")
	private String sparkHome;

	@Value("${master.uri:local}")
	private String masterUri;

	public String getSparkHome() {
		return sparkHome;
	}

	public void setSparkHome(String sparkHome) {
		this.sparkHome = sparkHome;
	}

	public String getMasterUri() {
		return masterUri;
	}

	public void setMasterUri(String masterUri) {
		this.masterUri = masterUri;
	}

}