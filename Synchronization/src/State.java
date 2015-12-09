
public class State {
	int x;
	Q storage;
	Request request;

	synchronized public void setRequest(Request request) {
		while (request != null) {
			try {
				wait();
			} catch (InterruptedException e) {
				
			}
		}
		this.request = request;
		notifyAll();
	}
	public Q getStorage() {
		return storage;
	}
	public void setStorage(Q storage) {
		this.storage = storage;
	}
	State (int x) {
		this.x = x;
		this.request = null;
		this.storage = new Q();
	}
	State (int x, Q storage) {
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
				wait();
			} catch (InterruptedException e) {
				
			}
			if (request.getR() == this.x) {
				storage.put(this.toString());
				request = null;
				notifyAll();
			}
		}
	}
}
