package ex05;

@FunctionalInterface
interface Addible{
	void add(int a, int b);
}

class Papers{
	private String con;
	public Papers(String con) {
		this.con = con;
	}
	
	public Addible doAdd() {		// 람다식으로 변형
		
//		class number implements Addible{
//			@Override
//			public void add(int a, int b) {
//				return a+b;
//			}			
//		}
		
//		return new Addible() {
//			@Override
//			public void add(int a, int b) {
//				return a+b;
//			}
//		};
		
		return (int a, int b) -> System.out.println(a+b);
	}
}

public class RamdaClassExam {

	public static void main(String[] args) {
		
		Papers p = new Papers("더하기");
		
//		Addible a = p.doAdd();	
//		a.add(10, 20);

		p.doAdd().add(10, 20);
	}
}
