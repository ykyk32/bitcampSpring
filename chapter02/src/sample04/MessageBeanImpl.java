package sample04;

public class MessageBeanImpl implements MessageBean {
	private String name;
	private String phone;
	private Outputter outputter;
	
	
	public MessageBeanImpl(String name) {
		System.out.println("MessageBeanImpl(String name)");
		this.name = name;
	}
	public void setPhone(String phone) {
		System.out.println("setPhone(Sting phone)");
		this.phone = phone;
	}
	public void setOutputter(Outputter outputter) {
		System.out.println("setOutputter(Outputter outputter)");
		this.outputter = outputter;
	}
	@Override
	public void HelloCall() {
		System.out.println("HelloCall()");
		outputter.output(name + "\t" + phone);
	}

}
