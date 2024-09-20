package kr.or.ddit.designpattern.adapterpattern;

public class OtherConcrete implements Target {

	@Override
	public void request() {
		System.out.println("OtherConcrete에서 요청을 처리했음.");

	}

}
