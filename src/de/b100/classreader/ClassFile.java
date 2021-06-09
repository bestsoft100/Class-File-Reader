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

	public static final long MAGIC = 3405691582L; //0xCAFEBABE
	
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
		
		if(reader.read4L() != MAGIC) {
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
	
	public int[] save() {
		Writer writer = new Writer();
		
		writer.write4L(MAGIC);
		version.write(writer);
		
		ConstantInfo.save(constantPool, writer);
		
		writer.write2(accessFlags);
		
		writer.write2(className);
		writer.write2(superClass);
		
		writer.write2(interfaces.length);
		for(int i : interfaces) writer.write2(i);
		
		writer.write2(fields.length);
		for(FieldInfo field : fields) field.save(writer);
		
		writer.write2(methods.length);
		for(MethodInfo method : methods) method.save(writer);
		
		writer.write2(attributes.length);
		for(AttributeInfo attribute : attributes) attribute.save(writer);
		
		return writer.getData();
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
