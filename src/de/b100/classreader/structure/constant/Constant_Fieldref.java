package de.b100.classreader.structure.constant;

import de.b100.classreader.Reader;
import de.b100.classreader.Writer;
import de.b100.classreader.structure.ConstantInfo;

public class Constant_Fieldref extends ConstantInfo{
	
	int class_index;
	int name_and_type_index;
	
	public void create(Reader reader) {
		class_index = reader.read2();
		name_and_type_index = reader.read2();
	}

	public void save(Writer writer) {
		writer.write2(class_index);
		writer.write2(name_and_type_index);
	}

}
