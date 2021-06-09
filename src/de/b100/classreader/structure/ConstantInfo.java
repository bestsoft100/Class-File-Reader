package de.b100.classreader.structure;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import de.b100.classreader.Reader;
import de.b100.classreader.Writer;
import de.b100.classreader.structure.constant.Constant_Class;
import de.b100.classreader.structure.constant.Constant_Double;
import de.b100.classreader.structure.constant.Constant_Fieldref;
import de.b100.classreader.structure.constant.Constant_Float;
import de.b100.classreader.structure.constant.Constant_Integer;
import de.b100.classreader.structure.constant.Constant_InterfaceMethodref;
import de.b100.classreader.structure.constant.Constant_InvokeDynamic;
import de.b100.classreader.structure.constant.Constant_Long;
import de.b100.classreader.structure.constant.Constant_MethodHandle;
import de.b100.classreader.structure.constant.Constant_MethodType;
import de.b100.classreader.structure.constant.Constant_Methodref;
import de.b100.classreader.structure.constant.Constant_NameAndType;
import de.b100.classreader.structure.constant.Constant_String;
import de.b100.classreader.structure.constant.Constant_Utf8;

public abstract class ConstantInfo {
	
	public abstract void create(Reader reader);
	
	public abstract void save(Writer writer);
	
	public static ConstantInfo[] getArray(Reader reader) {
		ConstantInfo[] constants = new ConstantInfo[reader.read2() - 1];
		
		for(int i=0; i < constants.length; i++) {
			constants[i] = get(reader);
		}
		
		return constants;
	}
	
	public static ConstantInfo get(Reader reader) {
		int tag = reader.read1();
		Class<? extends ConstantInfo> type = types.get(tag);
		
		try {
			ConstantInfo info = type.newInstance();
			
			info.create(reader);
			
			return info;
		} catch (Exception e) {
			String typeString;
			
			if(type == null) {
				typeString = "null";
			}else {
				typeString = type.getName();
			}
			
			throw new RuntimeException("Tag: "+tag+" Type: "+typeString, e);
		}
	}
	
	public static void save(ConstantInfo[] constantPool, Writer writer) {
		writer.write2(constantPool.length + 1);
		
		for(int i=0; i < constantPool.length; i++) {
			int tag = getTag(constantPool[i]);
			
			writer.write1(tag);
			
			constantPool[i].save(writer);
		}
	}
	
	public static int getTag(ConstantInfo constant) {
		Set<Entry<Integer, Class<? extends ConstantInfo>>> entrySet = types.entrySet();
		
		Class<? extends ConstantInfo> class1 = constant.getClass();
		
		for(Entry<Integer, Class<? extends ConstantInfo>> entry : entrySet) {
			Class<? extends ConstantInfo> class2 = entry.getValue();
			
			if(class1 == class2) {
				return entry.getKey();
			}
		}
		
		throw new RuntimeException();
	}
	
	public static Map<Integer, Class<? extends ConstantInfo>> types;
	
	static {
		types = new HashMap<>();

		types.put(7, Constant_Class.class);
		types.put(9, Constant_Fieldref.class);
		types.put(10, Constant_Methodref.class);
		types.put(11, Constant_InterfaceMethodref.class);
		types.put(8, Constant_String.class);
		types.put(3, Constant_Integer.class);
		types.put(4, Constant_Float.class);
		types.put(5, Constant_Long.class);
		types.put(6, Constant_Double.class);
		types.put(12, Constant_NameAndType.class);
		types.put(1, Constant_Utf8.class);
		types.put(15, Constant_MethodHandle.class);
		types.put(16, Constant_MethodType.class);
		types.put(18, Constant_InvokeDynamic.class);
	}
	
}
