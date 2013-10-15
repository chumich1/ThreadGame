package ThreadGameSkeleton.src;

import java.util.Random;

public class ComputerPlayer extends Player {

	public ComputerPlayer(GraphicsPanel g, int DELAY) {
		super(g, DELAY);
		// TODO Auto-generated constructor stub
	}
	
	public void run(){
		for(int i = 0; i<1000000; i++){
	
		chooseDirection();
		super.run();
		}
	}

	@Override
	public void setInitialLocation() {
		// TODO Auto-generated method stub
		Random rand = new Random();
		this.location = new Location(rand.nextInt(10), rand.nextInt(10));
	}

	
	public boolean checkDirection(){
		if(direction == 'U'){
			return gPanel.isBlocked(new Location(location.getX(), location.getY() - 1), true);
		}
		else if(direction == 'D'){
			return gPanel.isBlocked(new Location(location.getX(), location.getY() + 1), true);
		}
		
		else if(direction == 'L'){
			return gPanel.isBlocked(new Location(location.getX() - 1, location.getY()), true);
		}
		else if(direction == 'R'){
			return gPanel.isBlocked(new Location(location.getX() + 1, location.getY()), true);
		}
		else{
			return false;
		}
	}
	
	
	@Override
	public synchronized void chooseDirection() {
		// TODO Auto-generated method stub
		int i = 1;
		boolean target_found = false;
		boolean left_blocked = false;
		boolean right_blocked = false;
		boolean up_blocked = false;
		boolean down_blocked = false;
		
		while(i <= this.gPanel.MAX_X && target_found == false){
			
			//If the left direction has not been found to be blocked
			if(!left_blocked){
				//If the next increment to the left is not blocked
				if(!this.gPanel.isBlocked(new Location(location.getX() - i, location.getY()), true)){
					if(this.gPanel.isTarget(new Location(location.getX() - i, location.getY()))){
						target_found = true;
						direction = 'L';
					}
				}
				else {
					left_blocked = true;
				}
			}
			
			//If the right direction has not been found to be blocked
			if(!right_blocked){
				//If the next increment to the right is not blocked
				if(!this.gPanel.isBlocked(new Location(location.getX() + i, location.getY()), true)){
					if(this.gPanel.isTarget(new Location(location.getX() + i, location.getY()))){
						target_found = true;
						direction = 'R';
					}
				}
				else {
					right_blocked = true;
				}
			}
			
			//If the up direction has not been found to be blocked
			if(!up_blocked){
				//If the next increment to the up is not blocked
				if(!this.gPanel.isBlocked(new Location(location.getX(), location.getY() - i), true)){
					if(this.gPanel.isTarget(new Location(location.getX(), location.getY() - i))){
						target_found = true;
						direction = 'U';
					}
				}
				else {
					up_blocked = true;
				}
			}
			
			//If the down direction has not been found to be blocked
			if(!down_blocked){
				//If the next increment to the down is not blocked
				if(!this.gPanel.isBlocked(new Location(location.getX(), location.getY() + i), true)){
					if(this.gPanel.isTarget(new Location(location.getX(), location.getY() + i))){
						target_found = true;
						direction = 'D';
					}
				}
				else {
					down_blocked = true;
				}
			}
			
			i++;
		
		}
		System.out.println(target_found);
		if(!target_found && checkDirection()){
			Random rand = new Random();
			int r = rand.nextInt(4)+1;
			switch (r%4){
			case 0: direction = 'U';
					break;
			case 1: direction = 'D';
				break;
			case 2: direction = 'L';
				break;
			case 3: direction = 'R';
				break;
			}
			
			
		}
	

	}

}
