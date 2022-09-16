package com.demo.collection;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class CountWordExample {

	public static void main(String[] args) throws Exception {
		 
		Path path  =Paths.get(System.getProperty("user.dir")).resolve("../resource/static/al.txt");
		
		BufferedReader reader = new BufferedReader(new FileReader(path.toFile()));
		
		Map<String,Integer> map =new HashMap<String,Integer>();
		
		String line = reader.readLine();
		
		while(line != null){
			System.out.println("Porceesing line"+line);
			line = reader.readLine();
		}
		
	}

}
