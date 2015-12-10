
public class RequestSatisfier extends Thread {
	StateMachine state;
	
	void setRequest(Request request) {
		 if (state == null) {
		 		state = new StateMachine(0);
		 		System.out.println("New machine");
  			    state.setRequest(request);
		 		System.out.println("Request has been set");
		 		state.go();
		 } else if (state.getX() > request.getR()) {
			    state = new StateMachine(0,state.getStorage());
			    state.setRequest(request);
			    state.go();
		 } else {
			 	state.setRequest(request);
		 }
		// set the request
	}
	
	public static void main(String args[]) {
		RequestSatisfier rs = new RequestSatisfier();
		rs.run();
		Request request = new Request(4);
		rs.setRequest(request);
		String item = rs.state.getStorage().get();
		System.out.println("Done");
		System.out.println(item);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		//state.go();
	}
	
	
}
