package de.b100.classreader.structure.constant;

import de.b100.classreader.Reader;
import de.b100.classreader.Writer;
import de.b100.classreader.structure.Bytes;
import de.b100.classreader.structure.ConstantInfo;

public class Constant_Integer extends ConstantInfo{
	
	Bytes bytes;
	
	public void create(Reader reader) {
		bytes = reader.readBytes(4);
	}

	public void save(Writer writer) {
		writer.writeBytes(bytes);
	}
	
}
