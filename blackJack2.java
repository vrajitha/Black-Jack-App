package bJGUI;
import java.util.Scanner;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.*;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class blackJack2 extends JFrame{
	private static final long serialVersionUID = 1L;		
	public blackJack2() {
	 String[] suit = { "Spades", "Hearts", "Diamonds", "Clubs" };		
		 String[] rank = { "Ace","2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
		 int SUITS = suit.length;
		 int RANKS = rank.length;
		 int N = SUITS * RANKS;
		 final String[] deck = new String[N];     
		 for (int i = 0; i < SUITS; i++) {
			 for(int j=0;j<RANKS;j++)
			 {
		  deck[RANKS*i+j] = rank[j] + " of " + suit[i];
		   }
		 }
		 final ImageIcon[] images = new ImageIcon[52];
		 for(int i=0;i<52;i++)
		 {
		 images[i] =  new ImageIcon("src/" + (i+1) + ".png");
		 }
		   //shuffle
		  for (int i1 = 0; i1 < N; i1++) {
		        int r = i1 + (int) (Math.random() * (N-i1));
		        String t = deck[r];
		      ImageIcon temp= images[r];
		        deck[r] = deck[i1];
		        images[r]=images[i1];
		        deck[i1] = t;
		        images[i1]= temp;
		    }  
		final ArrayList<String>  usersCards = new ArrayList<String>() ;
		final ArrayList<String> dealersCards = new ArrayList<String>() ;
	    
			final JFrame frame =new JFrame("Black Jack");
		frame.setSize(900,700);
		frame.setLocationRelativeTo(null);
		//frame.pack();
		//frame.getContentPane().setBackground(Color.GREEN);
		final JPanel p1 = new JPanel();
		JLabel l1 = new JLabel("BLACK JACK");
		l1.setFont(new Font("Arial", Font.BOLD, 45));
		p1.add(l1);
		p1.setSize(900,700);
		p1.setLayout(null);
		p1.setBackground(Color.GREEN);
		l1.setLocation(300,0);
		l1.setSize(320,60);
		JButton b1 = new JButton("New Hand");
		JButton b2 = new JButton("Hit me!");
		JButton b3 = new JButton("Stand");
		JButton b4 = new JButton("Hint");
		b1.setLocation(180,500);
		b1.setSize(130,50);
		b1.setBackground(Color.PINK);
		b1.setFont(new Font("Arial", Font.PLAIN, 20));  
		b2.setLocation(380,500);
		b2.setSize(130,50);
		b2.setBackground(Color.PINK);
		b2.setFont(new Font("Arial", Font.PLAIN, 20));  
		b3.setLocation(580,500);
		b3.setSize(130,50);
		b3.setBackground(Color.PINK);
		b3.setFont(new Font("Arial", Font.PLAIN, 20));  
		b4.setLocation(380,600);
		b4.setSize(130,50);
		b4.setBackground(Color.PINK);
		b4.setFont(new Font("Arial", Font.PLAIN, 20));  		
		ImageIcon i1 = new ImageIcon();
		i1 =  new ImageIcon("src/" + 54 + ".png");
		//ImageIcon i2 = new ImageIcon();
		//i2 =  new ImageIcon("src/" + 53 + ".png");
	    final JLabel l2= new JLabel(i1);
		l2.setBounds(100,100,100,150);
		final JLabel l3= new JLabel(i1);
		l3.setBounds(125,125,100,150);
		//l3.setIcon(i2);
		final JLabel l4= new JLabel(i1);
		l4.setBounds(700,100,100,150);
		final JLabel l5= new JLabel(i1);
		l5.setBounds(675,125,100,150);
		JLabel l6= new JLabel("Dealer");
		l6.setBounds(120,80, 70, 20);
		l6.setForeground(Color.RED);
		JLabel l7= new JLabel("Player");
		l7.setBounds(700,80, 70, 20);
		l7.setForeground(Color.RED);
		final JLabel l8= new JLabel("Dealer Cards Value : ");
		l8.setBounds(350,370, 350, 30);
		l8.setVisible(false);
		final JLabel l9= new JLabel("Player Cards Value : ");
		l9.setBounds(350,400, 350, 30);
		l9.setVisible(false);
		final JLabel l10= new JLabel(i1);
		l10.setBounds(650,150,100,150);
		final JLabel l11= new JLabel(i1);
		l11.setBounds(625,175,100,150);
		final JLabel l12= new JLabel(i1);
		l12.setBounds(600,200,100,150);
		final JLabel l13= new JLabel(i1);
		l13.setBounds(575,225,100,150);
		final JLabel l14= new JLabel(i1);
		l14.setBounds(150,150,100,150);
		final JLabel l15= new JLabel(i1);
		l15.setBounds(175,175,100,150);
		final JLabel l16= new JLabel(i1);
		l16.setBounds(200,200,100,150);
		final JLabel l17= new JLabel(i1);
		l17.setBounds(225,225,100,150);
		l10.setVisible(false);
		l11.setVisible(false);
		l12.setVisible(false);
		l13.setVisible(false);
		l14.setVisible(false);
		l15.setVisible(false);
		l16.setVisible(false);
		l17.setVisible(false);		
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(b4);	
		p1.add(l2);
		//l3.setVisible(false);
		p1.add(l3);
		p1.add(l4);
		p1.add(l5);
		p1.add(l6);
		p1.add(l7);
		p1.add(l8);
		p1.add(l9);
		p1.add(l10);
		p1.add(l11);
		p1.add(l12);
		p1.add(l13);
		p1.add(l14);
		p1.add(l15);
		p1.add(l16);
		p1.add(l17);
		frame.getContentPane().add(p1);
		frame.setDefaultCloseOperation(3);
		frame.setVisible(true);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dealersCards.add(deck[0]);
				usersCards.add(deck[1]);
				dealersCards.add(deck[2]);
				usersCards.add(deck[3]);
				
				//this.count++;
				ImageIcon[] i10 = new ImageIcon[4];
				for(int i=0;i<4;i++)
					i10[i]=images[i];
				l2.removeAll();
				l2.setIcon(i10[0]);
				l2.revalidate();
				//l3.removeAll();
				//l3.setIcon(i10[2]);
				//l3.revalidate();
				l4.removeAll();
				l4.setIcon(i10[1]);
				l4.revalidate();
				l5.removeAll();
				l5.setIcon(i10[3]);
				l5.revalidate();
				int usersValue = 0;
				for(int i = 0; i < usersCards.size(); i++) {
					if(usersCards.get(i).contains("2")) {
						usersValue += 2;
					} else if(usersCards.get(i).contains("3")) {
						usersValue += 3;
					} else if(usersCards.get(i).contains("4")) {
						usersValue += 4;
					} else if(usersCards.get(i).contains("5")) {
						usersValue += 5;
					} else if(usersCards.get(i).contains("6")) {
						usersValue += 6;
					} else if(usersCards.get(i).contains("7")) {
						usersValue += 7;
					} else if(usersCards.get(i).contains("8")) {
						usersValue += 8;
					} else if(usersCards.get(i).contains("9")) {
						usersValue += 9;
					} else if(usersCards.get(i).contains("10")) {
						usersValue += 10;
					} else if(usersCards.get(i).contains("Jack")) {
						usersValue += 10;
					} else if(usersCards.get(i).contains("Queen")) {
						usersValue += 10;
					} else if(usersCards.get(i).contains("King")) {
						usersValue += 10;
					} else if(usersCards.get(i).contains("Ace")) {
						if(usersValue>10)
							usersValue += 1;
						else
						usersValue += 11;
					}
				}
				int dealersValue = 0;
				for(int i = 0; i < dealersCards.size()-1; i++) {
					if(dealersCards.get(i).contains("2")) {
						dealersValue += 2;
					} else if(dealersCards.get(i).contains("3")) {
						dealersValue += 3;
					} else if(dealersCards.get(i).contains("4")) {
						dealersValue += 4;
					} else if(dealersCards.get(i).contains("5")) {
						dealersValue += 5;
					} else if(dealersCards.get(i).contains("6")) {
						dealersValue += 6;
					} else if(dealersCards.get(i).contains("7")) {
						dealersValue += 7;
					} else if(dealersCards.get(i).contains("8")) {
						dealersValue += 8;
					} else if(dealersCards.get(i).contains("9")) {
						dealersValue += 9;
					} else if(dealersCards.get(i).contains("10")) {
						dealersValue += 10;
					} else if(dealersCards.get(i).contains("Jack")) {
						dealersValue += 10;
					} else if(dealersCards.get(i).contains("Queen")) {
						dealersValue += 10;
					} else if(dealersCards.get(i).contains("King")) {
						dealersValue += 10;
					} else if(dealersCards.get(i).contains("Ace")) {
						if(dealersValue>10)
							dealersValue+=1;
						else
						dealersValue += 11;
					}
				}
				l8.removeAll();
				l8.setText("Dealer Cards Value : " + dealersValue);
				l8.setVisible(true);
				l8.revalidate();
				l9.removeAll();
				l9.setText("User Cards Value : " + usersValue);
				l9.setVisible(true);
				l9.revalidate();
				System.out.println(usersCards.get(0));
				
				System.out.println(usersCards.get(1));
				System.out.println(dealersCards.get(0));
				System.out.println(dealersCards.get(1));
				if(usersValue==21)
				{
					JOptionPane.showMessageDialog(frame,
						    "Congrats!!! You got Black Jack",
						    "Message",
						    JOptionPane.PLAIN_MESSAGE);
				}
				

			}});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int c=0;
				c=usersCards.size()+dealersCards.size();
				usersCards.add(deck[c]);
				if(c==4)
				{
					l10.removeAll();
					l10.setIcon(images[c]);
					l10.setVisible(true);
					l10.revalidate();
					
				}
				if(c==5)
				{
					l11.removeAll();
					l11.setIcon(images[c]);
					l11.setVisible(true);
					l11.revalidate();
					
				}
				if(c==6)
				{
					l12.removeAll();
					l12.setIcon(images[c]);
					l12.setVisible(true);
					l12.revalidate();
					
				}
				if(c==7)
				{
					l13.removeAll();
					l13.setIcon(images[c]);
					l13.setVisible(true);
					l13.revalidate();
					
				}
				int usersValue = 0;
				for(int i = 0; i < usersCards.size(); i++) {
					if(usersCards.get(i).contains("2")) {
						usersValue += 2;
					} else if(usersCards.get(i).contains("3")) {
						usersValue += 3;
					} else if(usersCards.get(i).contains("4")) {
						usersValue += 4;
					} else if(usersCards.get(i).contains("5")) {
						usersValue += 5;
					} else if(usersCards.get(i).contains("6")) {
						usersValue += 6;
					} else if(usersCards.get(i).contains("7")) {
						usersValue += 7;
					} else if(usersCards.get(i).contains("8")) {
						usersValue += 8;
					} else if(usersCards.get(i).contains("9")) {
						usersValue += 9;
					} else if(usersCards.get(i).contains("10")) {
						usersValue += 10;
					} else if(usersCards.get(i).contains("Jack")) {
						usersValue += 10;
					} else if(usersCards.get(i).contains("Queen")) {
						usersValue += 10;
					} else if(usersCards.get(i).contains("King")) {
						usersValue += 10;
					} else if(usersCards.get(i).contains("Ace")) {
						if(usersValue>10)
							usersValue += 1;
						else
						usersValue += 11;
					}
				}
				l9.removeAll();
				l9.setText("User Cards Value : " + usersValue);
				l9.setVisible(true);
				l9.revalidate();
				if(usersValue==21)
				{
					JOptionPane.showMessageDialog(frame,
						    "Congrats!!! You got Black Jack",
						    "Message",
						    JOptionPane.PLAIN_MESSAGE);
					System.exit(0);

				}
				if(usersValue>21)
				{
					JOptionPane.showMessageDialog(frame,
						    "Oops!! You Bust",
						    "Message",
						    JOptionPane.PLAIN_MESSAGE);
					System.exit(0);

				}
				
			}});
		
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				l3.removeAll();
				l3.setIcon(images[2]);
				l3.revalidate();
				int t=0;				
				while(t==0)
				{
					int usersValue = 0;				
				for(int i = 0; i < usersCards.size(); i++) {
					if(usersCards.get(i).contains("2")) {
						usersValue += 2;
					} else if(usersCards.get(i).contains("3")) {
						usersValue += 3;
					} else if(usersCards.get(i).contains("4")) {
						usersValue += 4;
					} else if(usersCards.get(i).contains("5")) {
						usersValue += 5;
					} else if(usersCards.get(i).contains("6")) {
						usersValue += 6;
					} else if(usersCards.get(i).contains("7")) {
						usersValue += 7;
					} else if(usersCards.get(i).contains("8")) {
						usersValue += 8;
					} else if(usersCards.get(i).contains("9")) {
						usersValue += 9;
					} else if(usersCards.get(i).contains("10")) {
						usersValue += 10;
					} else if(usersCards.get(i).contains("Jack")) {
						usersValue += 10;
					} else if(usersCards.get(i).contains("Queen")) {
						usersValue += 10;
					} else if(usersCards.get(i).contains("King")) {
						usersValue += 10;
					} else if(usersCards.get(i).contains("Ace")) {
						if(usersValue>10)
							usersValue += 1;
						else
						usersValue += 11;
					}
				}
				int dealersValue=0;
				for(int i = 0; i < dealersCards.size(); i++) {
					if(dealersCards.get(i).contains("2")) {
						dealersValue += 2;
					} else if(dealersCards.get(i).contains("3")) {
						dealersValue += 3;
					} else if(dealersCards.get(i).contains("4")) {
						dealersValue += 4;
					} else if(dealersCards.get(i).contains("5")) {
						dealersValue += 5;
					} else if(dealersCards.get(i).contains("6")) {
						dealersValue += 6;
					} else if(dealersCards.get(i).contains("7")) {
						dealersValue += 7;
					} else if(dealersCards.get(i).contains("8")) {
						dealersValue += 8;
					} else if(dealersCards.get(i).contains("9")) {
						dealersValue += 9;
					} else if(dealersCards.get(i).contains("10")) {
						dealersValue += 10;
					} else if(dealersCards.get(i).contains("Jack")) {
						dealersValue += 10;
					} else if(dealersCards.get(i).contains("Queen")) {
						dealersValue += 10;
					} else if(dealersCards.get(i).contains("King")) {
						dealersValue += 10;
					} else if(dealersCards.get(i).contains("Ace")) {
						if(dealersValue>10)
							dealersValue+=1;
						else
						dealersValue += 11;
					}
				}
				l8.removeAll();
				l8.setText("Dealer Cards Value : " + dealersValue);
				l8.setVisible(true);
				l8.revalidate();				
				
				 if(dealersValue>21)
				{
					JOptionPane.showMessageDialog(frame,
						    "Congrats!! Dealer Bust, You win",
						    "Message",
						    JOptionPane.PLAIN_MESSAGE);
					System.exit(0);

					t=1;
				}
				 else 
					 {
					 if(dealersValue>usersValue)
					{
						JOptionPane.showMessageDialog(frame,
							    "Oops!! Dealer wins",
							    "Message",
							    JOptionPane.PLAIN_MESSAGE);
						System.exit(0);

						t=1;
						
					}
					 else if(dealersValue==17)
					 {
						 JOptionPane.showMessageDialog(frame,
								    "Its draw, No win No loss",
								    "Message",
								    JOptionPane.PLAIN_MESSAGE);
							System.exit(0);

							t=1;
					 }
					 else if(dealersValue<17)
					 {
						 int c=0;
						 c=usersCards.size()+dealersCards.size();
						 dealersCards.add(deck[c]);
						 int x=dealersCards.size();
						 if(x==2)
						 {
							 l14.removeAll();
								l14.setIcon(images[c]);
								l14.setVisible(true);
								l14.revalidate();
						 }
						 if(x==3)
						 {
							 l15.removeAll();
								l15.setIcon(images[c]);
								l15.setVisible(true);
								l15.revalidate();
						 }
						 if(x==4)
						 {
							 l16.removeAll();
								l16.setIcon(images[c]);
								l16.setVisible(true);
								l16.revalidate();
						 }
						 if(x==5)
						 {
							 l17.removeAll();
								l17.setIcon(images[c]);
								l17.setVisible(true);
								l17.revalidate();
						 }
						 }
					 else{
						 JOptionPane.showMessageDialog(frame,
								    "Its draw, No win No loss",
								    "Message",
								    JOptionPane.PLAIN_MESSAGE);
							System.exit(0);
					 }
					 }
				}
				
				
			}});
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame j1=new JFrame("Hint");
				JPanel p5= new JPanel();
				ImageIcon i20 = new ImageIcon("src/HintTable.png");
				JLabel l20 = new JLabel(i20);
				l20.setBounds(0,0,500,300);
				p5.add(l20);
				//JPanel p6= new JPanel();
				char [][] hint = {{'H','H','H','H','H','H','H','H','H','H'},
						{'H','H','H','D','D','H','H','H','H','H'},
						{'D','D','D','D','D','H','H','H','H','H'},
						{'D','D','D','D','D','D','D','D','H','H'},
						{'D','D','D','D','D','D','D','D','D','D'},
						{'H','H','S','S','S','H','H','H','H','H'},
						{'S','S','S','S','S','H','H','H','H','H'},
						{'S','S','S','S','S','H','H','H','H','H'},
						{'S','S','S','S','S','H','H','H','H','H'},
						{'S','S','S','S','S','H','H','H','h','h'},
						{'S','S','S','S','S','S','S','S','S','S'},
						{'H','H','H','H','H','H','H','H','H','H'}};
				int usersValue = 0;
				for(int i = 0; i < usersCards.size(); i++) {
					if(usersCards.get(i).contains("2")) {
						usersValue += 2;
					} else if(usersCards.get(i).contains("3")) {
						usersValue += 3;
					} else if(usersCards.get(i).contains("4")) {
						usersValue += 4;
					} else if(usersCards.get(i).contains("5")) {
						usersValue += 5;
					} else if(usersCards.get(i).contains("6")) {
						usersValue += 6;
					} else if(usersCards.get(i).contains("7")) {
						usersValue += 7;
					} else if(usersCards.get(i).contains("8")) {
						usersValue += 8;
					} else if(usersCards.get(i).contains("9")) {
						usersValue += 9;
					} else if(usersCards.get(i).contains("10")) {
						usersValue += 10;
					} else if(usersCards.get(i).contains("Jack")) {
						usersValue += 10;
					} else if(usersCards.get(i).contains("Queen")) {
						usersValue += 10;
					} else if(usersCards.get(i).contains("King")) {
						usersValue += 10;
					} else if(usersCards.get(i).contains("Ace")) {
						if(usersValue>10)
							usersValue += 1;
						else
						usersValue += 11;
					}
				}
				int dealersValue = 0;
				for(int i = 0; i < dealersCards.size()-1; i++) {
					if(dealersCards.get(i).contains("2")) {
						dealersValue += 2;
					} else if(dealersCards.get(i).contains("3")) {
						dealersValue += 3;
					} else if(dealersCards.get(i).contains("4")) {
						dealersValue += 4;
					} else if(dealersCards.get(i).contains("5")) {
						dealersValue += 5;
					} else if(dealersCards.get(i).contains("6")) {
						dealersValue += 6;
					} else if(dealersCards.get(i).contains("7")) {
						dealersValue += 7;
					} else if(dealersCards.get(i).contains("8")) {
						dealersValue += 8;
					} else if(dealersCards.get(i).contains("9")) {
						dealersValue += 9;
					} else if(dealersCards.get(i).contains("10")) {
						dealersValue += 10;
					} else if(dealersCards.get(i).contains("Jack")) {
						dealersValue += 10;
					} else if(dealersCards.get(i).contains("Queen")) {
						dealersValue += 10;
					} else if(dealersCards.get(i).contains("King")) {
						dealersValue += 10;
					} else if(dealersCards.get(i).contains("Ace")) {
						if(dealersValue>10)
							dealersValue+=1;
						else
						dealersValue += 11;
					}
				}
				JLabel l21 = new JLabel("Suggestion");
				l21.setBounds(0,0,500,300);
				p5.add(l21);
				l21.setBounds(480,0,500,100);
				if(usersValue<18)
				{
				if(usersValue<7)
				{
					if(hint[0][dealersValue-2]=='S'){
						l21.removeAll();
						l21.setText("Suggestion : Stand");
						l21.revalidate();
					}
					else {
						l21.removeAll();
						l21.setText("Suggestion : Hit");
						l21.revalidate();
					}
				}
				else {
				if(hint[usersValue-6][dealersValue-2]=='S'){
					
					l21.removeAll();
					l21.setText("Suggestion : Stand");
					l21.revalidate();
				}
				
				else 
				{   l21.removeAll();
					l21.setText("Suggestion : Hit");
					l21.revalidate();
				}
				}
				}
				if(usersValue>18){
					l21.removeAll();
					l21.setText("Suggestion : Stand");
					l21.revalidate();
				}


				
				
				
				j1.setSize(500,400);
				j1.setLocationRelativeTo(null);
				j1.getContentPane().add(p5);
				j1.setDefaultCloseOperation(3);
				j1.setVisible(true);
				
				}});
		
		
		//frame.getContentPane().add(p1);
		//frame.setDefaultCloseOperation(3);
		//frame.setVisible(true);
	}
		
	
	
	public void onNewHand()
	{
		
		System.out.println("NewHand");
	}
	public void onHitme()
	{
		System.out.println("Hit");
	}
	public void onStand()
	{
		System.out.println("Stand");
	}
	public void onHint()
	{
		System.out.println("Hint");
	}
	
	public static void main(String[] args)
	{
		new blackJack2();
		
	}
	


}