class ThreadB extends Thread{
    int result;
    int request;
    public ThreadB() {
    	result = 0;
    }
    public ThreadB(int request) {
    	this.request = request;
    }
    @Override
    public void run(){
        synchronized(this){
        	result = 0;
        	while (result < request) {
        		result++;
        	}
            notify();
            try{
                System.out.println("Waiting for someone else to notify...");
                wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("But this still runs.");
        }
    }
	public int get() {
		// TODO Auto-generated method stub
		return result;
	}
}