package ThreadGameSkeleton.src;


public abstract class Player implements Runnable {

	int points;
	Location location;
	char direction;
	
	
	public Player(){
		this.points = 0;
		direction = 'D';
		this.setInitialLocation();
	}
	
	public abstract void setInitialLocation();
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	public void start() {
		// TODO Auto-generated method stub
		Thread t = new Thread(this);
		t.start();
	}

	public void stopPlaying() {
		// TODO Auto-generated method stub
		
	}

	public int getPoints() {
		// TODO Auto-generated method stub
		return points;
	}

	public void setDirection(char c) {
		// TODO Auto-generated method stub
		direction = c;
	}

	public Location getLocation() {
		// TODO Auto-generated method stub
		return location;
	}
	
	public abstract void chooseDirection();
	
	public synchronized void move(){
		synchronized(location){
		//check if up is minus or plus
		switch (direction){
			case 'U': this.location.setY(location.getY()+1);
					break;
			case 'D': this.location.setY(location.getY()-1);
					break;		
			case 'L': this.location.setX(location.getX()-1);
					break;
			case 'R': this.location.setX(location.getX()+1);
					break;
		}
		}
	}

}
