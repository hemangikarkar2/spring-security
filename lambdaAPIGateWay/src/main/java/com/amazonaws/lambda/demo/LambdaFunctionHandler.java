package com.amazonaws.lambda.demo;

import java.util.Collection;
import java.util.Collections;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

public class LambdaFunctionHandler implements RequestHandler<Object, GateWayResponse> {

	@Override
	public GateWayResponse handleRequest(Object object, Context context) {
		// TODO Auto-generated method stub
		String msg = "Hello !! ";
		System.out.println(msg);
		
		GateWayResponse response = new GateWayResponse(msg, 200, Collections.singletonMap("key1", "LambdaExample"), false);
		return response ;
	}

	 

  
}