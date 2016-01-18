package classes;
import java.util.ArrayList;
import java.util.List;

public class Clients {

	private List<Client> clients;
	
	public Clients(){
		clients = new ArrayList<Client>();
	}
	
	public void addClient(Client c){
		clients.add(c);
	}
	
	public void delClient(Client c){
		clients.remove(c);
	}
}
