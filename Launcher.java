import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Launcher {

	
	public static void main(String[] args) {
		
		GameModel model = new GameModel();
		GamePanel view = new GamePanel();
		Controller controller = new Controller(model, view);
		
		JFrame gameFrame = new JFrame();
		gameFrame.setTitle("2048 Game");
		gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		gameFrame.setSize(340, 400);
		gameFrame.setResizable(true);
		
		gameFrame.add(view);
		view.addKeyListener(controller);
		gameFrame.setLocationRelativeTo(null);
		gameFrame.setVisible(true);
	}
}


