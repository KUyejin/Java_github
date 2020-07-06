//멀티쓰레드
//출력값이 계속해서 바뀐다.
//cpu가 실제로 돌리는 것은 프로세스가 아니라 쓰레드이다
//쓰레드에 있는 내용이 끝날때까지 context switching를 통해 번갈아가면서 처리해준다.
//총3개가 돌아가고 있다
//

public class MultiThread {
	public static void main(String[] args) {
		MyThread1 th1 = new MyThread1();
		MyThread2 th2 = new MyThread2();
		th1.start(); //start는 OS에게 쓰레드 달라고 요청하는 것 
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

