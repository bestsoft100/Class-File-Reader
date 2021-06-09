package de.b100.classreader.structure.constant;

import de.b100.classreader.Reader;
import de.b100.classreader.structure.ConstantInfo;

public class Constant_MethodType extends ConstantInfo{

	int descriptorIndex;
	
	public void create(Reader reader) {
		descriptorIndex = reader.read2();
	}
	
}
