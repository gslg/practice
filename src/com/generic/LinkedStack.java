package com.generic;

public class LinkedStack<T> {

	private static class Node<T>{
		T item;
		Node<T> next;
		Node(){item=null;next=null;}
		Node(T t,Node<T> next){
			this.item = t;
			this.next = next;
		}
		
		boolean end(){return item==null && next==null;}
	}
	
	Node<T> top = new Node<T>();//充当栈底哨兵
	/**
	 * 向栈顶推入元素
	 * @param item
	 */
	public void push(T item){
		top = new Node<T>(item,top);
	}
	/**
	 * 弹出栈顶元素
	 * @return
	 */
	public T pop(){
		T result = top.item;
		if(!top.end())
			top = top.next;
		return result;
	}
	public static void main(String[] args) {
		LinkedStack<String> ls = new LinkedStack<String>();
		
		for(String s : "a b c d e f".split(" "))
			ls.push(s);
		String s=null;
		while((s=ls.pop())!=null){
			System.out.println(s);
		}
	}
}
