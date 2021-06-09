package de.b100.classreader.structure.constant;

import de.b100.classreader.Reader;
import de.b100.classreader.structure.Bytes;
import de.b100.classreader.structure.ConstantInfo;
import de.b100.classreader.structure.SingleByte;

public class Constant_Utf8 extends ConstantInfo{

	int length;
	Bytes bytes;
	
	public void create(Reader reader) {
		length = reader.read2();
		bytes = reader.readBytes(length); //TODO Check if allowed
	}
	
	public String toString() {
		String str = "";
		int count = bytes.getCount();
		
		for(int i=0; i < count; i++) {
			SingleByte abyte = bytes.get(i);
			int value = abyte.getValue();
			char c = (char) value;
			
			str += c;
		}
		
		return str;
	}

}
