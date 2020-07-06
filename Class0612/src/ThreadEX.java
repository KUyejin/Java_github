
class Account {
	int balance = 1000;
	
	public void withdraw(int money) {
		if(balance >= money) {
			try {Thread.sleep(1000);} catch(Exception e) {} //t1(m:100)���� t2����.
			balance -= money; 
			//t2������ t1���� ���´� -> b:1000-m:100 = b:900
			//while������ ����. acc.b= 900 int money= 100 
			//withdraw �Լ�ȣ�� -> if���� Ʈ��� ������ t1�ٽ� ���� t2����
			//balance�� ���� ����� 
		}
	}
	
//  ����ȭ����(-���� ��ӳ��� ��) synchronize�� �ٿ��ָ� �ȴ�. -context switching�� �Ͼ�� ��ġ��	
//	public synchronized void withdraw(int money) {
//		if(balance >= money) {
//			try {Thread.sleep(1000);} catch(Exception e) {}
//			balance -= money; 
//		}
//	}
	
}

class RunnableEX implements Runnable{
	Account acc = new Account();
	
	@Override
	public void run() {
		while(acc.balance > 0) { 
		//100,200,300 ���� �� ���� ���Ƿ� �����ؼ� ���(withdraw)
		
		//int money =(int)(Math.random() * 3 + 1) * 100;
		int money = 100;
		
		acc.withdraw(money);
		System.out.println("balance: " + acc.balance);
		}
	}//run

}

public class ThreadEX{
	public static void main(String[] args) {
		
		Runnable r = new RunnableEX();
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		
		t1.start();
		t2.start();
	}
}

//��°��� ���̳ʽ��� ������ ������?
//