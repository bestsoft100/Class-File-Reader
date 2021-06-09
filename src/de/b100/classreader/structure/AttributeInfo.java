package de.b100.classreader.structure;

import de.b100.classreader.Reader;
import de.b100.classreader.Writer;

public class AttributeInfo {
	
	int attribute_name_index;
	long attribute_length;
	int[] info;
	
	public AttributeInfo(Reader reader) {
		attribute_name_index = reader.read2();
		attribute_length = reader.read4L();
		info = reader.readArray1B((int)attribute_length);
	}
	
	public static AttributeInfo[] getArray(Reader reader) {
		AttributeInfo[] info = new AttributeInfo[reader.read2()];
		
		for(int i=0; i < info.length; i++) {
			info[i] = new AttributeInfo(reader);
		}
		
		return info;
	}

	public void save(Writer writer) {
		writer.write2(attribute_name_index);
		writer.write4L(attribute_length);
		for(int i : info) writer.write1(i);
	}
	
}
