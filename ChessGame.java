import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.util.ArrayList;

 
public class ChessGame extends JFrame implements MouseListener, MouseMotionListener {
  JLayeredPane layeredPane;
  JPanel chessBoard;
  JLabel chessPiece;
  int xAdjustment;
  int yAdjustment;
  public static ArrayList<walk> walklist = new ArrayList<>();
  public static ArrayList<Color> colorlist = new ArrayList<>();
  public static int winnerp;
  public static int click;
  public static int num1;
  public static int num2;
  int end;
  int winnercheck;
  public static int loser;
  int valid;

  


  

 
  public ChessGame(){
  Dimension boardSize = new Dimension(600, 600);
  	
  	String players = JOptionPane.showInputDialog("How many players?");
	String field = JOptionPane.showInputDialog("Enter Desired value for N for a NxN Playing Field");
	
	
	
	num1 = Integer.parseInt(players);
	
	num2 = Integer.parseInt(field);
	
	int n= num2;
  
	//  Use a Layered Pane for this this application
  	layeredPane = new JLayeredPane();
  	getContentPane().add(layeredPane);
  	layeredPane.setPreferredSize(boardSize);
  	layeredPane.addMouseListener(this);
  	layeredPane.addMouseMotionListener(this);
 
  //Add a chess board to the Layered Pane 
 
  	chessBoard = new JPanel();
  	layeredPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
  	chessBoard.setLayout( new GridLayout(n, n) );
  	chessBoard.setPreferredSize( boardSize );
  	chessBoard.setBounds(0, 0, boardSize.width, boardSize.height);
  	if(num2%2==0) {
  	for (int i = 0; i < n*n; i++) {
  		JPanel square = new JPanel( new BorderLayout() );
  		chessBoard.add( square );
 
  		int row = (i / n) % 2;
  		if (row == 0)
  			square.setBackground( i % 2 == 0 ? Color.blue : Color.white );
  		else
  			square.setBackground( i % 2 == 0 ? Color.white : Color.blue );
  	}
  	}
  	else {
  		for (int i = 0; i < n*n; i++) {
  	  		JPanel square = new JPanel( new BorderLayout() );
  	  		chessBoard.add( square );
  	 
  	  		int row = (i / n) % 2;
  	  		if (row == 0)
  	  			square.setBackground( i % 2 == 0 ? Color.blue : Color.white );
  	  		else
  	  			square.setBackground( i % 2 == 0 ? Color.blue : Color.white );
  	  	}
  		
  		
  	}
  	for(int x =0;x<num1;x++) {
  		
  		Random rand = new Random();
  		colorlist.add(new Color(rand.nextInt(0xFFFFFF)));
  		
  	}
  	
  	
 
  	}
 
  	public void mousePressed(MouseEvent e){
  
  	}
 
  
  	public void mouseDragged(MouseEvent me) {
  	}
 
 
  	public void mouseReleased(MouseEvent e) {
  	}
 
  	public void mouseClicked(MouseEvent e) {
  			valid=0;
  			if(end==0) {
  			if(click==0) {
  				convert temp = new convert(e.getX(),e.getY());
  	  	  		
  				walklist.add(new walk(temp.getx(),temp.gety()));  
  				

  	  	  		
  				player one = new player();  	  		
  	  	  		Color color = colorlist.get(click%num1); 	  		
  	  	  		one.setBackground(color);
  	  	  		JPanel panel = (JPanel)chessBoard.findComponentAt(e.getX(), e.getY());
  	  	  		panel.add(one);
  	  	  		pack();
	  	  		
  	  	  		//System.out.println(click);

  	  	  		click=click+1;
  	  	  		
  	  	  		
  			}
  			else{
  				
  				convert temp = new convert(e.getX(),e.getY());
  				walk walker = new walk(temp.getx(),temp.gety());

  				int failure=0;
  				int pass=0;
	  			int winner=0;

	  			
  				
  				for(int x =0;x<walklist.size();x++) {
  	  		  		
  	  		  		if ((walker.getwalkx()==walklist.get(x).getwalkx()) && (walker.getwalky()==walklist.get(x).getwalky())) {
  	  		  			failure=1;
  	  		  			//break;
  	  		  		}
  	  		  		
  	  		  		
  	  		  		
  	  		  		
  	  		  		
  	  		  		if( (walker.getwalkx()==walklist.get(walklist.size()-1).getwalkx()+1) && (walker.getwalky()==walklist.get(walklist.size()-1).getwalky())) {
  	  		  			pass=1;
  	  		  			
  	  		  		}
  	  		  		if( (walker.getwalkx()==walklist.get(walklist.size()-1).getwalkx()-1) && (walker.getwalky()==walklist.get(walklist.size()-1).getwalky()) ) {
  	  		  			pass=1;
  	  		  			
  	  		  		}
  	  		  		if( (walker.getwalky()==walklist.get(walklist.size()-1).getwalky()+1) && (walker.getwalkx()==walklist.get(walklist.size()-1).getwalkx())) {
  	  		  			pass=1;
  	  		  			
  	  		  		}
  	  		  		if( (walker.getwalky()==walklist.get(walklist.size()-1).getwalky()-1) && (walker.getwalkx()==walklist.get(walklist.size()-1).getwalkx())) {
  	  		  			pass=1;
  	  		  			
  	  		  		}
  	  		  		
  	  		  		
  	  		  		
  	  		  	}
  				
  				if(failure==1 && pass==1 ) {
  					if(click>=4) {
  						if( (walker.getwalkx()==walklist.get(0).getwalkx()) && (walker.getwalky()==walklist.get(0).getwalky()) ) {
  	  	  	  				int winp = click%num1;
  	  	  	  				winnerp=winp + 1;
  	  	  	  				end=1;
  							
  	  	  	  			
  	  	  	  				
  	  	  	  				//winnerpoly frame2 = new winnerpoly();
  					  		//frame2.setVisible(true);


  						}
  					}
  				}
  				
  	  			if((failure==0 && pass==1)|| end==1) {
  	  				int size =0;
  	  				if(end==0) {
  	  					walklist.add(new walk(temp.getx(),temp.gety()));
  	  					player one = new player();  	  		
  	  					Color color = colorlist.get(click%num1); 	  		
  	  					one.setBackground(color);
  	  					JPanel panel = (JPanel)chessBoard.findComponentAt(e.getX(), e.getY());
  	  					panel.add(one);
  	  					pack();
  	  	  	  			click=click+1;

  	  					
  	  					
  	  				}
  	  	  			for(int l =0;l<walklist.size();l++) {
  					
  	  	  				if ((walker.getwalkx()+1==walklist.get(l).getwalkx()) && (walker.getwalky()==walklist.get(l).getwalky())) {
  		  			
  	  	  					winner= winner+1;
  						
  						
  	  	  				}
  	  	  				if ((walker.getwalkx()-1==walklist.get(l).getwalkx()) && (walker.getwalky()==walklist.get(l).getwalky())) {
  		  			
  	  	  					winner= winner+1;
						
						
  	  	  				}
  			
  	  	  				if ((walker.getwalkx()==walklist.get(l).getwalkx()) && (walker.getwalky()+1==walklist.get(l).getwalky())) {
		  			
  	  	  					winner= winner+1;
					
						
  	  	  				}
  	  	  				if ((walker.getwalkx()==walklist.get(l).getwalkx()) && (walker.getwalky()-1==walklist.get(l).getwalky())) {
  		  			
  	  	  					winner= winner+1;
					
						
  	  	  				}
  					
  					
  	  	  			}
  	  	  			
  	  	  			
  	  	  			
  	  	  			if(walker.getwalkx()+1 > num2) {
  	  	  				winner= winner+1;
  	  	  			}
  	  	  			if(walker.getwalky()+1 > num2) {
  	  	  				winner= winner+1;
  	  	  			}
  	  	  			if(walker.getwalkx()-1 <= 0) {
  	  	  				winner= winner+1;
  	  	  			}
  	  	  			if(walker.getwalky()-1 <= 0) {
  	  	  				winner= winner+1;
  	  	  			}
  	  	  			
  	  	  			
  	  	  			
  	  	  			
  	  	  			
  	  	  			
  	  	  			if ((walker.getwalkx()+1==walklist.get(0).getwalkx()) && (walker.getwalky()==walklist.get(0).getwalky())) {
  		  			
	  					valid= 1;
					
					
	  				}
	  				if ((walker.getwalkx()-1==walklist.get(0).getwalkx()) && (walker.getwalky()==walklist.get(0).getwalky())) {
	  			
	  					valid= 1;				
				
	  				}
		
	  				if ((walker.getwalkx()==walklist.get(0).getwalkx()) && (walker.getwalky()+1==walklist.get(0).getwalky())) {
  			
	  					valid= 1;			
				
	  				}
	  				if ((walker.getwalkx()==walklist.get(0).getwalkx()) && (walker.getwalky()-1==walklist.get(0).getwalky())) {
	  			
	  					valid= 1;			
				
	  				}
  	  	  			
  	  	  			
  	  	  			
  	  	  			
	  				
	  				if(winner==4 && valid==0) {
  	  	  				winnercheck=1;
  	  	  				int g = click%num1;
  	  	  				loser = g+1;
  	  	  				winnerL frame3 = new winnerL();
  	  	  				frame3.setVisible(true);
  	  	  				//System.out.println("The Loser Is Player "+click%num1);
  	  	  			} 
  	  	  			if(end==1 && winner !=4 && winnercheck==0) {
	  					winnerpoly frame2 = new winnerpoly();
	  					frame2.setVisible(true);
	  					
	  				}
  	  	  			
  	  	  			//click=click+1;
  	  			
  	  			
  	  			}
  				}
  	  		
  	  			
  			}
  	
  	  		
  	  		
  		  		
  	}
  	public void mouseMoved(MouseEvent e) {
  	}
  	public void mouseEntered(MouseEvent e){
  
  	}
  	public void mouseExited(MouseEvent e) {
  
  	}
 
  	
}
