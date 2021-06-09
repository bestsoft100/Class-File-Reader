package de.b100.classreader.structure;

public class SingleByte {
	
	private boolean[] bits = new boolean[8];
	
	public SingleByte(int value) {
		if(value >= 256)throw new RuntimeException("" + value);
		
		for(int i=0; i < 8; i++) {
			bits[i] = value%2 == 1;
			value /= 2;
		}
	}
	
	public String toString() {
		String str = "";
		
		for(int i=0; i < 8; i++) {
			str = (bits[i] ? 1 : 0) + str;
		}
		
		return str;
	}
	
	public int getValue() {
		int value = 0;
		
		for(int i=0; i < 8; i++) {
			if(bits[i])value += pow(2, i);
		}
		
		return value;
	}
	
	public int pow(int a, int b) {
		return (int)Math.pow(a, b);
	}
	
}
