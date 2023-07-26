package ex02;

// Local Class
interface Printable{
	void print();
}

class Papers{
	private String con;
	public Papers(String con) {
		this.con = con;
	}
	
	public Printable getPrinter() { 	// 로컬클래스
		
		class Printer implements Printable{
			@Override
			public void print() {
				System.out.println("msg : " + con);
			}
		}
		
		return new Printer();
	}
}

public class LocalClassExam {

	public static void main(String[] args) {
		Papers p = new Papers("이번에도 이 문장 출력해줘");
		
		Printable prn = p.getPrinter();
		
		prn.print();
	}
}
