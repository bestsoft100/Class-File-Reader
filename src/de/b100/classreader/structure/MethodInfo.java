package de.b100.classreader.structure;

import de.b100.classreader.Reader;
import de.b100.classreader.Writer;

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

	public void save(Writer writer) {
		writer.write2(access_flags);
		writer.write2(nameindex);
		writer.write2(descriptorIndex);
		
		writer.write2(attributes.length);
		for(AttributeInfo info : attributes) info.save(writer);
	}
	
}
