package de.b100.classreader.structure.constant;

import de.b100.classreader.Reader;
import de.b100.classreader.structure.ConstantInfo;

public class Constant_NameAndType extends ConstantInfo{

	int nameIndex;
	int descriptorIndex;
	
	public void create(Reader reader) {
		nameIndex = reader.read2();
		descriptorIndex = reader.read2();
	}
}
