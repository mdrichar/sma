
public class StateMachine extends Thread {
	int x;
	int counter;
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}

	Q storage;
	Request request;

	synchronized public void setRequest(Request request) {
		while (this.request != null) {
			try {
				System.out.println("Waiting because request != null");
				wait();
			} catch (InterruptedException e) {
				
			}
		}
		System.out.println("Processing request");
		this.request = request;
		notifyAll();
	}
	public Q getStorage() {
		return storage;
	}
	public void setStorage(Q storage) {
		this.storage = storage;
	}
	StateMachine (int x) {
		this.x = x;
		this.request = null;
		this.storage = new Q();
	}
	StateMachine (int x, Q storage) {
		this.x = x;
		this.request = null;
		this.storage = storage;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	public void go() {
		log();
		while (this.x < 10) {
			this.x++;
			log();
		}
	}
	
	public synchronized void log() {
		while (request == null) {
			try {
				System.out.println("Waiting because request == null");
				wait();
			} catch (InterruptedException e) {
				
			}
		}
		if (request.getR() == this.getCounter()) {
			System.out.println("Found right state");
			storage.put(String.valueOf(x));
			request = null;
			notifyAll();
		}
		this.counter++;
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		go();
	}
	
}
