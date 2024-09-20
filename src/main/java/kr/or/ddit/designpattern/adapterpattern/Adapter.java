package kr.or.ddit.designpattern.adapterpattern;

/**
 * adapter pattern (Wrapper pattern)
 * : 원 객체의 인터페이스를 변경하지 않고, 새로운 구조를 추가하고 싶을때 사용하는 패턴.
 *	ex)
 *	int nubmer = 3;
 *	Integer numObj = new Integer(num);
 *	numObj.toBinaryString();
 */
public class Adapter implements Target {
	
	private Adaptee adaptee;
	
	
	public Adapter(Adaptee adaptee) { //기본생성자 삭제
		super();
		this.adaptee = adaptee;
	}


	@Override
	public void request() {
		adaptee.specificRequest();
	}

}
