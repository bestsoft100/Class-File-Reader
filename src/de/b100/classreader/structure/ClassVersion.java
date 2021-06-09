package de.b100.classreader.structure;

import de.b100.classreader.Reader;
import de.b100.classreader.Writer;

public class ClassVersion {
	
	int major;
	int minor;
	
	public ClassVersion(Reader reader) {
		minor = reader.read2();
		major = reader.read2();
	}
	
	public String toString() {
		return major + "." + minor;
	}

	public void write(Writer writer) {
		writer.write2(minor);
		writer.write2(major);
	}
	
}
