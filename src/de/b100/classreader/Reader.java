package de.b100.classreader;

import de.b100.classreader.structure.Bytes;
import de.b100.classreader.structure.SingleByte;

public class Reader {
	
	private int[] data;
	private int i;
	
	public Reader(int[] data) {
		this.data = data;
		this.i = 0;
	}
	
	public int read1() {
		return data[i++];
	}
	
	public long read1L() {
		return data[i++];
	}
	
	public int read2() {
		return read1() * 256 + read1();
	}

	public long read4L() {
		long v0 = read1();
		long v1 = read1();
		long v2 = read1();
		long v3 = read1();
		
		v0 = v0 << 24;
		v1 = v1 << 16;
		v2 = v2 << 8;
		v3 = v3 << 0;
		
		return v0 + v1 + v2 + v3;
	}
	
	public int available() {
		return data.length - i;
	}
	
	public SingleByte readByte() {
		return new SingleByte(read1());
	}
	
	public Bytes readBytes(int count) {
		Bytes bytes = new Bytes(count);
		
		for(int i=0; i<count; i++) {
			bytes.set(i, new SingleByte(read1()));
		}
		
		return bytes;
	}
	
	public int[] readArray1B(int size) {
		int[] bytes = new int[size];
		
		for(int i=0; i < bytes.length; i++) {
			bytes[i] = read1();
		}
		
		return bytes;
	}
	
	public int[] readArray2B(int size) {
		int[] bytes = new int[size];
		
		for(int i=0; i < bytes.length; i++) {
			bytes[i] = read2();
		}
		
		return bytes;
	}
	
	public int getPosition() {
		return i;
	}
	
}
