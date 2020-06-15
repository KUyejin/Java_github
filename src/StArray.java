interface Stack{
	boolean isEmpty(); 
	boolean isFull();
	void push(int item);
	int pop();
	int peek();
	void clear();
}		

public class StArray implements Stack{
	
	private int top;
	private int stackSize;
	private int stackArr[];
	
	public StArray(int stackSize) {
		top = -1; // 0이면 스택에 값이 쌓인다.
		this.stackSize = stackSize;
		stackArr = new int[this.stackSize];
	}
	
	public boolean isEmpty() {
		return(top == -1);
	}
	
	public boolean isFull() {
		return(top == this.stackSize-1);
	}
	
	public void push(int item) {
		if(isFull()) {
			System.out.println("스택이 가득 찼습니다");
		}else {
			stackArr[++top] = item;
			System.out.println("넣은 값은: " + item);
		}
	
	}
	

	public int pop() {
		if(isEmpty()) {
			System.out.println("지우는 것을 실패했습니다! 스택이 비어있습니다!");
			return 0;
		}else {
			System.out.println("지운 값은: " + stackArr[top]);
			return stackArr[--top];
		}
	}
	
	public int peek() {
		if(isEmpty()) {
			System.out.println("최상위 값을 추출하는 데 실패!! 스택이 비어있습니다");
			return 0;
		}else {
			System.out.println("최상위 값은: " + stackArr[top]);
			return stackArr[top];
		}
	}
	
	public void clear() {
		if(isEmpty()) {
			System.out.println("스택은 이미 비워져있습니다!!");
		}else {
			top = -1;
			stackArr = new int[this.stackSize]; //새로운 스택배열생성
			System.out.println("스택을 다 비웠습니다");
					
		}
	}
	
	public void printStack() {
		if(isEmpty()) {
			System.out.println("스택은 빈공간입니다");
		}else {
			System.out.println("스택 elements: ");
			for(int i = 0; i <= top; i++) {
				System.out.print(stackArr[i]+ " ");
			}
			System.out.println();
		}
	}
			

	public static void main(String[] args) {
		int stackSize = 5;
		StArray st = new StArray(stackSize);
		
		st.push('A');
		st.printStack();
		
		st.push('B');
		st.printStack();
		
		st.push('C');
		st.printStack();
		
		st.push('D');
		st.printStack();
		
		st.pop();
		st.printStack();
		
		st.pop();
		st.printStack();
		
		st.peek();
		st.printStack();
		
		st.clear();
		st.printStack();


	}
}	
