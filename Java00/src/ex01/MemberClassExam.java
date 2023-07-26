package ex01;

// Member Class >> 클래스 안에 클래스가 존재하는 것
interface Printable{
	void print();
}

class Papers{
	private String con;
	public Papers(String con) {
		this.con = con;
	}
	
	public Printable getPrinter() {
		return new Printer(); 
	}
	
	private class Printer implements Printable{

		@Override
		public void print() {
			System.out.println("msg : " + con);
		}
	}
}


public class MemberClassExam {
	
	public static void main(String[] args) {
		Papers p = new Papers("이 문장을 출력해 주세요");
		
		Printable prn = p.getPrinter();
		
		prn.print();
	}
}
