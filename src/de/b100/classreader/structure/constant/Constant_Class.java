package de.b100.classreader.structure.constant;

import de.b100.classreader.Reader;
import de.b100.classreader.structure.ConstantInfo;

public class Constant_Class extends ConstantInfo{
	
	int nameIndex;
	
	public void create(Reader reader) {
		nameIndex = reader.read2();
	}

}
