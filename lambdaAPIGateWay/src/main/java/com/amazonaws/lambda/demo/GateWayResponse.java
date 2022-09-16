package com.amazonaws.lambda.demo;

import java.util.Map;

public class GateWayResponse {

	private String body;
	private Integer statusCode;
	private Map<String,String> headers;
	private boolean isBase64Encoded;
	
	public GateWayResponse(String body, Integer statusCode, Map<String, String> headers, boolean isBase64Encoded) {
		super();
		this.body = body;
		this.statusCode = statusCode;
		this.headers = headers;
		this.isBase64Encoded = isBase64Encoded;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public Map<String, String> getHeaders() {
		return headers;
	}
	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}
	public boolean isBase64Encoded() {
		return isBase64Encoded;
	}
	public void setBase64Encoded(boolean isBase64Encoded) {
		this.isBase64Encoded = isBase64Encoded;
	}
	
}
