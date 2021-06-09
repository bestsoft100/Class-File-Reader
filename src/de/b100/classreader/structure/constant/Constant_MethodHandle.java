package de.b100.classreader.structure.constant;

import de.b100.classreader.Reader;
import de.b100.classreader.structure.ConstantInfo;

public class Constant_MethodHandle extends ConstantInfo{
	
	int referenceKind;
	int referenceIndex;
	
	public void create(Reader reader) {
		referenceIndex = reader.read1();
		referenceIndex = reader.read2();
	}
	
	
	
}
