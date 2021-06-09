package de.b100.classreader.structure.constant;

import de.b100.classreader.Reader;
import de.b100.classreader.structure.ConstantInfo;

public class Constant_String extends ConstantInfo{
	
	int stringIndex;
	
	public void create(Reader reader) {
		stringIndex = reader.read2();
	}
	
}
