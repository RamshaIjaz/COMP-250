import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Controller extends KeyAdapter {
		
	private GameModel game;
	private GamePanel view;
	
	public Controller(GameModel g, GamePanel v) {
		
		this.game = g;
		this.view = v;
		
		game.resetGame();
		
		//copying the common variables 
		view.myLose = game.myLose; 
		view.myLose = game.myLose;
		view.myScore = game.myScore;
		view.myTiles = game.myTiles;
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		//updating the variables with every key press
		view.myLose = game.myLose; 
		view.myLose = game.myLose;
		view.myScore = game.myScore;
		view.myTiles = game.myTiles;
		
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			game.resetGame();
		}
		if (!game.canMove()) {
			game.myLose = true;
		}
		
		if (!game.myWin && !game.myLose) {
			switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					game.left();
					break;
				case KeyEvent.VK_RIGHT:
					game.right();
					break;
				case KeyEvent.VK_DOWN:
					game.down();
					break;
				case KeyEvent.VK_UP:
					game.up();
					break;
			}
		}
		
		if (!game.myWin && !game.canMove()) {
			game.myLose = true;
		}
		
		view.repaint();
	}

	

}
	
	

