import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class winnerL extends JFrame {

	private JPanel contentPane;
	ArrayList<JLabel> list = new ArrayList<>();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					winnerL frame = new winnerL();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public winnerL() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCongratsTheWinners = new JLabel("Congrats! The winners are:");
		lblCongratsTheWinners.setBounds(127, 32, 168, 16);
		contentPane.add(lblCongratsTheWinners);
		
		//System.out.println(ChessGame.num1);
		//System.out.println(ChessGame.loser);

		int y = 32;
		
		String s;
		int x=0;
		for(int i=1;i <= ChessGame.num1;i++) {
			if(i != ChessGame.loser) {
				
				s=Integer.toString(i);

				JLabel e = new JLabel("PLAYER "+s);
				y=y+35;
				e.setBounds(127, y, 168, 16);
				list.add(e);
				
				contentPane.add(list.get(x));
				x=x+1;
				
			}
			
		}
	}

}
