package aspects;

import java.util.ArrayList;
import java.util.List;

import classes.Client;
import classes.Clients;
import classes.Order;

public aspect AClientOrder {

	private Client Order.client;
	private List<Order> Client.orders  = new ArrayList<Order>();
	
	public void Client.addOrder(Order o){
		orders.add(o);
	}
	
	public boolean Client.hasOrder(){
		return orders.size() != 0;
	}
	
	public void Client.delOrder(Order o){
		orders.remove(o);
	}
	
	public void Order.setClient(Client c){
		client = c;
		client.addOrder(this);
	}
	
	public Client Order.getClient(){
		return client;
	}

	pointcut delClientPointcut() : call ( void Clients.delClient(Client));
	
	void around() : delClientPointcut() {
		Client c = (Client)thisJoinPoint.getArgs()[0];
		if(!c.orders.isEmpty()){
			System.err.println("The deletion is impossible. The client has one or some orders.");
		}else{
			proceed();	
		}
	}
}