package de.b100.classreader.structure.constant;

import de.b100.classreader.Reader;
import de.b100.classreader.Writer;
import de.b100.classreader.structure.ConstantInfo;

public class Constant_InvokeDynamic extends ConstantInfo{

	int bootstrap_method_attr_index;
	int name_and_type_index;
	
	public void create(Reader reader) {
		bootstrap_method_attr_index = reader.read2();
		name_and_type_index = reader.read2();
	}

	public void save(Writer writer) {
		writer.write2(bootstrap_method_attr_index);
		writer.write2(name_and_type_index);
	}
}
