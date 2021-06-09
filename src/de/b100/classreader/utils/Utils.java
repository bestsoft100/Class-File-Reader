package de.b100.classreader.utils;

import java.io.File;
import java.io.FileInputStream;

public class Utils {
	
	public static int[] getData(File file) {
		try {
			FileInputStream stream = new FileInputStream(file);
			
			int[] data = new int[stream.available()];
			
			for(int i=0; i < data.length; i++) {
				data[i] = stream.read();
			}
			
			stream.close();
			
			return data;
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
