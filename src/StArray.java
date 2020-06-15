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
		top = -1; // 0�̸� ���ÿ� ���� ���δ�.
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
			System.out.println("������ ���� á���ϴ�");
		}else {
			stackArr[++top] = item;
			System.out.println("���� ����: " + item);
		}
	
	}
	

	public int pop() {
		if(isEmpty()) {
			System.out.println("����� ���� �����߽��ϴ�! ������ ����ֽ��ϴ�!");
			return 0;
		}else {
			System.out.println("���� ����: " + stackArr[top]);
			return stackArr[--top];
		}
	}
	
	public int peek() {
		if(isEmpty()) {
			System.out.println("�ֻ��� ���� �����ϴ� �� ����!! ������ ����ֽ��ϴ�");
			return 0;
		}else {
			System.out.println("�ֻ��� ����: " + stackArr[top]);
			return stackArr[top];
		}
	}
	
	public void clear() {
		if(isEmpty()) {
			System.out.println("������ �̹� ������ֽ��ϴ�!!");
		}else {
			top = -1;
			stackArr = new int[this.stackSize]; //���ο� ���ù迭����
			System.out.println("������ �� ������ϴ�");
					
		}
	}
	
	public void printStack() {
		if(isEmpty()) {
			System.out.println("������ ������Դϴ�");
		}else {
			System.out.println("���� elements: ");
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
