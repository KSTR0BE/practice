package kr.or.ddit.designpattern.adapterpattern;

public class AdapterPatternPlayground {
	public static void main(String[] args) {
		Client client = new Client();
		client.setTarget(new OtherConcrete());
		
		client.getTarget().request();
		
		client.setTarget(new Adapter(new Adaptee()));
		client.getTarget().request();
	}
}
