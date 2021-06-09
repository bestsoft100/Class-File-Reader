package de.b100.classreader.structure;

import de.b100.classreader.Reader;

public class AttributeInfo {
	
	int attribute_name_index;
	long attribute_length;
	int[] info;
	
	public AttributeInfo(Reader reader) {
		attribute_name_index = reader.read2();
		attribute_length = reader.read4();
		info = reader.readArray1B((int)attribute_length);
	}
	
	public static AttributeInfo[] getArray(Reader reader) {
		AttributeInfo[] info = new AttributeInfo[reader.read2()];
		
		for(int i=0; i < info.length; i++) {
			info[i] = new AttributeInfo(reader);
		}
		
		return info;
	}
	
}
