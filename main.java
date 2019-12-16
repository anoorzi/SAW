import javax.swing.JFrame;

public class main {

	public static void main(String[] args) {
  		JFrame frame5 = new ChessGame();
  		frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  		
  		frame5.pack();
  		frame5.setResizable(true);
  		frame5.setLocationRelativeTo( null );
  		frame5.setVisible(true);
  	}
	}