package de.b100.classreader.structure;

import de.b100.classreader.Reader;

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
	
}
