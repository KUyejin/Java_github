import javax.swing.JOptionPane;

public class ThreadEX1 {

	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog("아무값이나 입력하세요");
		System.out.println("입력하신 값은" + input + "입니다");
		
		for(int i = 10; i >0; i--) {
			System.out.println(i);
			try { Thread.sleep(1000); } catch (Exception e) {}
			// Thread.sleep(1000); 1초동안 잠들었다 실행됨
			// OS가 1초동안 해당쓰레드를 멈춤  (1000)=1초/(100)=0.1초
			// (1초간 context switching 시키지 않겠다 - 다른프로그램에게 1초간 양보하겠다) 
		}

	}

}
