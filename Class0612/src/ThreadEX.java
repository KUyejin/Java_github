
class Account {
	int balance = 1000;
	
	public void withdraw(int money) {
		if(balance >= money) {
			try {Thread.sleep(1000);} catch(Exception e) {} //t1(m:100)잠들고 t2깬다.
			balance -= money; 
			//t2죽을때 t1값이 들어온다 -> b:1000-m:100 = b:900
			//while문으로 간다. acc.b= 900 int money= 100 
			//withdraw 함수호출 -> if문이 트루기 때문에 t1다시 잠들고 t2깬다
			//balance값 부터 실행됨 
		}
	}
	
//  동기화문제(-값이 계속나올 때) synchronize를 붙여주면 된다. -context switching이 일어나는 위치에	
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
		//100,200,300 중의 한 값을 임의로 선택해서 출금(withdraw)
		
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

//출력값이 마이너스가 나오는 이유는?
//