package de.b100.classreader.structure;

import de.b100.classreader.Reader;

public class FieldInfo {
	
	int accessFlags;
	int name_index;
	int descriptorIndex;
	AttributeInfo[] attributes;
	
	public FieldInfo(Reader reader) {
		accessFlags = reader.read2();
		name_index = reader.read2();
		descriptorIndex = reader.read2();
		attributes = AttributeInfo.getArray(reader);
	}
	
	public static FieldInfo[] getArray(Reader reader) {
		FieldInfo[] info = new FieldInfo[reader.read2()];
		
		for(int i=0; i < info.length; i++) {
			info[i] = new FieldInfo(reader);
		}
		
		return info;
	}
	
}
