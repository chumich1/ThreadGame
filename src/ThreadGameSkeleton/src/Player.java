package ThreadGameSkeleton.src;


public abstract class Player implements Runnable {

	int points;
	Location location;
	char direction;
	GraphicsPanel gPanel;
	int DELAY;
	
	
	public Player(GraphicsPanel gPanel, int DELAY){
		this.DELAY = DELAY;
		this.gPanel = gPanel;
		this.points = 0;
		direction = 'D';
		this.setInitialLocation();
	}
	
	public abstract void setInitialLocation();
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			Thread.sleep(DELAY);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(!this.checkDirectionBlocked()){
		move();
		}
		
		//System.out.println(gPanel.isTarget(location));
		this.targetRemoval();
		
	
		
		
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
	
	public void targetRemoval(){
		if(gPanel.isTarget(location)){
			for(int j = 0; j < gPanel.targetLocs.size(); j++){
				if(location.equals(gPanel.targetLocs.get(j))){
					gPanel.targetLocs.remove(j);
					this.points++;
				}
			}
		}
	}
	
	//check if the current direction is blocked
	public boolean checkDirectionBlocked(){
		switch (direction){
		case 'U': return (gPanel.isBlocked(new Location(location.getX(), location.getY()-1), true));
				
		case 'D': return (gPanel.isBlocked(new Location(location.getX(), location.getY()+1), true));
				
		case 'L': return (gPanel.isBlocked(new Location(location.getX()-1, location.getY()), true));
				
		case 'R': return (gPanel.isBlocked(new Location(location.getX()+1, location.getY()), true));
		
	
	}
		 return false;
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
		System.out.println(direction);
		synchronized(location){
		//check if up is minus or plus
		switch (direction){
			case 'U': this.location.setY(location.getY()-1);
					break;
			case 'D': this.location.setY(location.getY()+1);
					break;		
			case 'L': this.location.setX(location.getX()-1);
					break;
			case 'R': this.location.setX(location.getX()+1);
					break;
		}
		}
	}

}
