package com.jhomlala.sparking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhomlala.sparking.spark.SparkService;
import com.jhomlala.sparking.spark.WordCountSparkJob;

@RestController
public class HelloController {

	@Autowired
	private SparkService sparkService;
	@Autowired
	private WordCountSparkJob wordCountSparkJob;
	
    @RequestMapping("/")
    public String index() {
    	WordCountSparkJob job = new WordCountSparkJob();
    	sparkService.startAsyncJob(job);
        return "Greetings from Spring Boot!";
    }

}