package com.thinkinginjava.exception;

public class Cleanup {
	public static void main(String[] args) {
		try {
			InputFile in = new InputFile("InpuFile.java");
			try {
				String s = null;
				int i = 0;
				while(in.readLine()!=null){
					//
				}
			} catch (Exception e) {
				//
			}finally {
				in.dispose();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
