package ThreadGameSkeleton.src;

import java.util.Random;

public class ComputerPlayer extends Player {

	public ComputerPlayer(GraphicsPanel g) {
		super(g);
		// TODO Auto-generated constructor stub
	}
	
	public void run(){
		chooseDirection();
		super.run();
	}

	@Override
	public void setInitialLocation() {
		// TODO Auto-generated method stub
		Random rand = new Random();
		this.location = new Location(rand.nextInt(10), rand.nextInt(10));
	}

	@Override
	public void chooseDirection() {
		// TODO Auto-generated method stub
		direction = 'L';

	}

}
