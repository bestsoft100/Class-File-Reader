package de.b100.classreader.structure;

import de.b100.classreader.Reader;
import de.b100.classreader.Writer;

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

	public void save(Writer writer) {
		writer.write2(accessFlags);
		writer.write2(name_index);
		writer.write2(descriptorIndex);
		
		writer.write2(attributes.length);
		for(AttributeInfo info : attributes) info.save(writer);
	}
	
}
