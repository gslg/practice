package com.thinkinginjava.exception;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class InputFile {
	private BufferedReader br;
	
	public InputFile(String filename) throws Exception{
		try {
			br = new BufferedReader(new FileReader(filename));
		} catch (FileNotFoundException e) {
			//文件没有打开不应该关闭文件
			throw e;
		} catch(Exception e){
			//其他错误异常应该关闭文件
			try {
				br.close();
			} catch (IOException e1) {
				e1.printStackTrace();
				throw e1;
			}
		}finally{
			//dont close
		}
		
	}
	
	public String readLine(){
		String s = null;
		try {
			s = br.readLine();
		} catch (IOException e) {
			
			throw new RuntimeException("File readline failed");
		}
		return s;
	}
	
	public void dispose(){
		try {
			br.close();
			System.out.println("file close success");
		} catch (IOException e) {
			throw new RuntimeException("close file failed");
		}
	}
}
