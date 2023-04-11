package sample01;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class MessageBeanImpl implements MessageBean {
	@NonNull
	private String fruit;
	@Setter
	private int cost, qty;
	
	
	//fruit 생성자 이용해서 받아오기 
	//Constructor Injection
//	public MessageBeanImpl(String fruit) {
//		super();
//		this.fruit = fruit;
//	}

	
	//cost, qty setter 이용해서 받기 
	//Setter Injection
//	public void setCost(int cost) {
//		this.cost = cost;
//	}
//
//	public void setQty(int qty) {
//		this.qty = qty;
//	}

	//lombok을 이용하여 위에 fruit생성자랑 cost,qty setter받기 
	
	
	@Override
	public void sayHello() {
		System.out.println(fruit + "\t" + cost + "\t" + qty);

	}

	@Override
	public void sayHello(String fruit, int cost) {
		System.out.println(fruit + "\t" + cost + "\t" + qty);

	}

	@Override
	public void sayHello(String fruit, int cost, int qty) {
		System.out.println(fruit + "\t" + cost + "\t" + qty);

	}

}
