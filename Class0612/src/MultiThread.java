//��Ƽ������
//��°��� ����ؼ� �ٲ��.
//cpu�� ������ ������ ���� ���μ����� �ƴ϶� �������̴�
//�����忡 �ִ� ������ ���������� context switching�� ���� �����ư��鼭 ó�����ش�.
//��3���� ���ư��� �ִ�
//

public class MultiThread {
	public static void main(String[] args) {
		MyThread1 th1 = new MyThread1();
		MyThread2 th2 = new MyThread2();
		th1.start(); //start�� OS���� ������ �޶�� ��û�ϴ� �� 
		th2.start();
	}
}

class MyThread1 extends Thread{
	public void run() {
		for(int i = 0; i<300; i++) {
			System.out.println("...");
		}
	}
}

class MyThread2 extends Thread{
	public void run() {
		for(int i = 0; i<300; i++) {
			System.out.println("i");
		}
	}
}
