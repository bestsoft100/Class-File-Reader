package de.b100.classreader;

import java.util.ArrayList;
import java.util.List;

import de.b100.classreader.structure.Bytes;
import de.b100.classreader.structure.SingleByte;

public class Writer {
	
	private List<Integer> data;
	
	public Writer() {
		data = new ArrayList<>();
	}
	
	public void write1(int v) {
		if(v < 0 || v >= 256)throw new RuntimeException(""+v);
		
		data.add(v);
	}
	
	public void write2(int v) {
		write1((v >> 8) % 256);
		write1((v >> 0) % 256);
	}
	
	public void write4L(long v) {
		long v0 = v >> 24;
		long v1 = v >> 16;
		long v2 = v >> 8;
		long v3 = v >> 0;
		
		v0 = v0 % 256;
		v1 = v1 % 256;
		v2 = v2 % 256;
		v3 = v3 % 256;
		
		write1((int)v0);
		write1((int)v1);
		write1((int)v2);
		write1((int)v3);
	}
	
	public int[] getData() {
		int[] data = new int[this.data.size()];
		
		for(int i=0; i < data.length; i++) {
			data[i] = this.data.get(i);
		}
		
		return data;
	}

	public void writeBytes(Bytes bytes) {
		int count = bytes.getCount();
		
		for(int i=0; i < count; i++) {
			SingleByte abyte = bytes.get(i);
			
			write(abyte);
		}
	}
	
	public void write(SingleByte abyte) {
		write1(abyte.getValue());
	}
	
	public int getWrittenDataSize() {
		return data.size();
	}
	
}
