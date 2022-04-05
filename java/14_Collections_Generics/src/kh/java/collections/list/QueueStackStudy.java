package kh.java.collections.list;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueStackStudy {

	public static void main(String[] args) {
		QueueStackStudy study = new QueueStackStudy();
//		study.test1();
		study.test2();
	}

	/**
	 * Stack
	 * - 선입후출 FILO : first in Last out
	 * 
	 *  method
	 *  - push : 맨 뒤에 추가
	 *  - pop : 맨 뒤에 제거
	 */
	private void test2() {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		
		int n = stack.pop(); //stack에서 제거
		System.out.println(n); //제거된 Integer
		n = stack.pop(); //stack에서 제거
		System.out.println(n); //제거된 Integer
		
		stack.push(6);
		
		System.out.println(stack);
	}


	/**
	 * Queue
	 *  - 선입선출 FIFO : first in first out
	 *  
	 *  method
	 *  - offer : 맨뒤에 추가
	 *  - poll : 맨앞에 제거
	 */
	private void test1() {
		//LinkedList implements Queue<>
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(3);
		queue.offer(5);
		queue.offer(7);
		
		int n = queue.poll(); //queue에서 제거
		System.out.println(n); //제거된 Integer
		
		queue.offer(9);
		
		System.out.println(queue);
		
		//모든요소를 순서대로 꺼내기
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
	}

}
