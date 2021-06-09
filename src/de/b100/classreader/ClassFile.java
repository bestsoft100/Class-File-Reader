package de.b100.classreader;

import java.io.File;
import java.io.FileInputStream;

import de.b100.classreader.structure.AttributeInfo;
import de.b100.classreader.structure.ClassVersion;
import de.b100.classreader.structure.ConstantInfo;
import de.b100.classreader.structure.FieldInfo;
import de.b100.classreader.structure.MethodInfo;
import de.b100.classreader.structure.constant.Constant_Utf8;
import de.b100.classreader.utils.Utils;

public class ClassFile {
	
	int className;
	int superClass;
	ClassVersion version;
	ConstantInfo[] constantPool;
	int accessFlags;
	int[] interfaces;
	FieldInfo[] fields;
	MethodInfo[] methods;
	AttributeInfo[] attributes;
	
	public ClassFile(File file) {
		this(Utils.getData(file));
	}
	
	public ClassFile(int[] data) {
		Reader reader = new Reader(data);
		
		if(reader.read4() != -889275714) {
			throw new RuntimeException("Not a valid class file!");
		}
		
		version = new ClassVersion(reader);
		
		constantPool = ConstantInfo.getArray(reader);
		
		accessFlags = reader.read2();
		
		this.className = reader.read2();
		this.superClass = reader.read2();
		
		interfaces = reader.readArray2B(reader.read2());
		fields = FieldInfo.getArray(reader);
		methods = MethodInfo.getArray(reader);
		attributes = AttributeInfo.getArray(reader);
	}
	
	public String getString(int i) {
		Constant_Utf8 utf8 = (Constant_Utf8) constantPool[i];
		return utf8.toString();
	}
	
	public ClassVersion getVersion() {
		return version;
	}
	
	public String getName() {
		return getString(className);
	}
	
	public String getSuperClass() {
		return getString(superClass);
	}
	
}
