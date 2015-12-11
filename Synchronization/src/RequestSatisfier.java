
public class RequestSatisfier {
	StateMachine state;

	public RequestSatisfier() {
		state = new StateMachine(0);
		System.out.println("Starting new SM");
		state.start();
	}
	void setRequest(Request request) {
		 if (state == null) {
		 		state = new StateMachine(0);
		 		System.out.println("New machine");
  			    state.setRequest(request);
		 		System.out.println("Request has been set");
		 		state.start();
		 } else if (state.getX() > request.getR()) {
			    state = new StateMachine(0,state.getStorage());
			    state.setRequest(request);
			    state.start();
		 } else {
			 	state.setRequest(request);
		 }
		// set the request
	}
	
	public static void main(String args[]) {
		RequestSatisfier rs = new RequestSatisfier();
		Request request = new Request(4);
		System.out.println("Setting request");
		rs.setRequest(request);
		System.out.println("Getting response");
		String response = rs.state.getStorage().get();
		System.out.println("Response to 4: " + response);
		rs.setRequest(new Request(3));
		response = rs.state.getStorage().get();
		System.out.println("Response to 3: " + response);
		System.out.println("Done");
		System.out.println(response);
	}


}
