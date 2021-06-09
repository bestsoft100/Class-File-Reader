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
	
	public int read2() {
		return read1() * 256 + read1();
	}

	public int read4() {
		int value = 0;
		
		value += read1() << 24;
		value += read1() << 16;
		value += read1() << 8;
		value += read1();
		
		return value;
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
			bytes.set(i, readByte());
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
	
}
