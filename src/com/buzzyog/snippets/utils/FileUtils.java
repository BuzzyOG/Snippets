package com.buzzyog.snippets.utils;
 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
 
public class FileUtils {
 
    public static String readInternalFile(String file) throws IOException{
	return readStream(FileUtils.class.getResourceAsStream(file));
    }
    
    public static String readFile(String file) throws IOException{
	return readFile(new File(file));
    }
    
    public static String readFile(File file) throws IOException{
	return readReader(new FileReader(file));
    }
    
    public static String readStream(InputStream stream) throws IOException {
	return readReader(new InputStreamReader(stream));
    }
    
    public static String readReader(InputStreamReader reader) throws IOException{
	
	BufferedReader br = new BufferedReader(reader);
	StringBuilder sb = new StringBuilder();
	
	char[] buff = new char[512];
	
	while (true) {
	    int len = br.read(buff, 0, buff.length);
	    if (len == -1) {
		break;
	    }
	    sb.append(buff, 0, len);
	}
	br.close();
	
	return sb.toString();
	
    }
}