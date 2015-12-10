
public class Q {
	String string;
	boolean isConsumable;
	public Q() {
		isConsumable = false;
		string = null;
	}
	
	public synchronized String get() {
		while (!isConsumable) {
			try {
				System.out.println("Calling get");
				wait();
			} catch (InterruptedException e) {
				
			}
		}
		isConsumable = false;
		notifyAll();
		return string;
	}
	
	public synchronized void put(String string) {
		while (isConsumable) {
			try {
				wait();
			} catch (InterruptedException e) {
				
			}
		}
		isConsumable = true;
		this.string = string;
		notifyAll();

	}
	
	

}
