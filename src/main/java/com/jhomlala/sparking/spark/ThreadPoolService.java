package com.jhomlala.sparking.spark;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

@Service
public class ThreadPoolService {
	private ExecutorService executorService;
	@PostConstruct
	public void init(){
		 executorService = Executors.newFixedThreadPool(5);
	}
	
	public void processJob(WorkerThread thread){
		thread.run();
	}
	
	
	
}
