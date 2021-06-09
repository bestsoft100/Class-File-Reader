package de.b100.classreader.structure.constant;

import de.b100.classreader.Reader;
import de.b100.classreader.Writer;
import de.b100.classreader.structure.Bytes;
import de.b100.classreader.structure.ConstantInfo;

public class Constant_Long extends ConstantInfo{
	
	Bytes highBytes;
	Bytes lowBytes;
	
	public void create(Reader reader) {
		highBytes = reader.readBytes(4);
		lowBytes = reader.readBytes(4);
	}

	public void save(Writer writer) {
		writer.writeBytes(highBytes);
		writer.writeBytes(lowBytes);
	}

}
