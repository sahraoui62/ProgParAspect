package classes;

public class Main {

	public static void main(String[] args) {
		// tous les clients
		Clients clients = new Clients();
		// toutes les commandes
		Orders orders = new Orders();
		
		Client c1 = new Client("Slimane","1 rue Lavoisier 59370 Mons en Baroeul");
		Client c2 = new Client("Sofiane","394 rue General de Gaulle 59000 Lille");
		clients.addClient(c1);
		clients.addClient(c2);
		
		Order o1 = new Order(1,20);
		Order o2 = new Order(2,5);
		Order o3 = new Order(3,2);
		Order o4 = new Order(4,98);
		Order o5 = new Order(5,1900);
		Order o6 = new Order(6,6);
		
		o1.setClient(c1);
		o2.setClient(c1);
		o3.setClient(c2);
		o4.setClient(c2);
		o5.setClient(c2);
		o6.setClient(c1);
		
		orders.addOrder(o1);
		orders.addOrder(o2);
		orders.addOrder(o3);
		orders.addOrder(o4);
		orders.addOrder(o5);
		orders.addOrder(o6);
		
		for(Order o : orders.getOrders()){
			o.printOrder();
		}
		
		o1.setClient(c2);
		
		orders.delOrder(o1);
		orders.delOrder(o4);
		orders.delOrder(o5);
	
		System.out.println("***************************");
		
		for(Order o : orders.getOrders()){
			o.printOrder();
		}
		
		clients.delClient(c2);
	}
	
}
