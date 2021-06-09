package de.b100.classreader.structure;

public class Bytes {
	
	private SingleByte[] bytes;
	
	public Bytes(int count) {
		bytes = new SingleByte[count];
	}
	
	public void set(int i, SingleByte value) {
		bytes[i] = value;
	}
	
	public SingleByte get(int i) {
		return bytes[i];
	}
	
	public int getCount() {
		return bytes.length;
	}
	
}
