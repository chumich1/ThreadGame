package ThreadGameSkeleton.src;

public class HumanPlayer extends Player {

	public HumanPlayer(GraphicsPanel g, int DELAY) {
		super(g, DELAY);
		// TODO Auto-generated constructor stub
	}
	
	public void run(){
		while(!this.stop_playing){
			super.run();
		}
	}

	@Override
	public void setInitialLocation() {
		this.location = new Location(1,1);

	}

	@Override
	public void chooseDirection() {
		// TODO Auto-generated method stub

	}

}
