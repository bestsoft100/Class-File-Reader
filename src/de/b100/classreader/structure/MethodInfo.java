package de.b100.classreader.structure;

import de.b100.classreader.Reader;

public class MethodInfo {
	
	int access_flags;
	int nameindex;
	int descriptorIndex;
	AttributeInfo[] attributes;
	
	public MethodInfo(Reader reader) {
		access_flags = reader.read2();
		nameindex = reader.read2();
		descriptorIndex = reader.read2();
		attributes = new AttributeInfo[reader.read2()];
		
		for(int i=0; i < attributes.length; i++) {
			attributes[i] = new AttributeInfo(reader);
		}
	}
	
	public static MethodInfo[] getArray(Reader reader) {
		MethodInfo[] info = new MethodInfo[reader.read2()];
		
		for(int i=0; i < info.length; i++) {
			info[i] = new MethodInfo(reader);
		}
		
		return info;
	}
	
}
