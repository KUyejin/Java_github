import javax.swing.JOptionPane;

public class ThreadEX1 {

	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog("�ƹ����̳� �Է��ϼ���");
		System.out.println("�Է��Ͻ� ����" + input + "�Դϴ�");
		
		for(int i = 10; i >0; i--) {
			System.out.println(i);
			try { Thread.sleep(1000); } catch (Exception e) {}
			// Thread.sleep(1000); 1�ʵ��� ������ �����
			// OS�� 1�ʵ��� �ش羲���带 ����  (1000)=1��/(100)=0.1��
			// (1�ʰ� context switching ��Ű�� �ʰڴ� - �ٸ����α׷����� 1�ʰ� �纸�ϰڴ�) 
		}

	}

}
