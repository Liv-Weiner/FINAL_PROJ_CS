import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.* ;
import java.awt.event.* ;
import java.awt.geom.* ; //  Classes GeneralPath etc.
import java.awt.image.* ;
import java.io.File;
import java.io.IOException;
import java.lang.instrument.IllegalClassFormatException;

import javax.imageio.ImageIO;
import javax.swing.* ;


public class View extends JPanel{
	
	 private JButton solve;  
		private JButton guess;
	    private JLabel message;  // Label for displaying messages to the user.
	    private Game model;
	    private JLabel names;
	    private JTextField name;
	    private Controller controller;
	    private JLabel playerName;
	    private JTextField numsPlay;
	    private BufferedImage master;
	    private JPanel numContainer;
        private BufferedImage rotated;
        private JPanel players;
        private JPanel naming;
        private JLabel letterTitle;
        private JPanel lettersGuessed;
        private JLabel secretWord;
        private JLabel solveOrLetter;
        private JLabel letterGuess;
        private JTextField letter;
        private JPanel buttonPanel;
        private JLabel moneyBank;
        private JPanel moneyAndWord;
        private JLabel listOfLetters;
        private boolean doneBefore = false;
        private boolean letterVSWord; // true for Letter, false for Word
	   private boolean stop; // False for stop
	   private JLabel wheelBalance;
	   private JLabel namePlayer;
	   private JLabel gameOver;
	   private JLabel lenOfWord;

	    
	    public View(Game m) {
	    	stop = false;
	    	//check = false;
	    	 try {
	                master = ImageIO.read(new File("WheelOfFortune_CS.png"));
	                rotated = rotateImageByDegrees(master, 0.0);
	            } catch (IOException ex) {
	                ex.printStackTrace();
	            }

            Timer timer = new Timer(10, new ActionListener() {
                private double angle = 0;
                private double delta = 1.0;

                @Override
                public void actionPerformed(ActionEvent e) {
                	if(stop == false) {
                		return;
                	}
                    angle += delta;
                    rotated = rotateImageByDegrees(master, angle);
                    repaint();
                }
            });
            //Everything from the try until the repaint is not mine. It is utilized from Stack Overflow https://stackoverflow.com/questions/37758061/rotate-a-buffered-image-in-java
            timer.start();
	    	
	    	this.model = m;
	    	this.controller = new Controller(model, this);
	    	
	    
	        setLayout(new BorderLayout());  // I will do the layout myself.
	        setPreferredSize( new Dimension(550,450) );
	        setBackground(Color.white);
	        buttonPanel = new JPanel();
	        buttonPanel.setBackground(Color.WHITE);

	        wheelBalance = new JLabel();
	        wheelBalance.setFont(new Font("Serif", Font.BOLD, 14));
	        
	        gameOver = new JLabel("YOU HAVE WONN! GAME OVER! The word is " + model.getFullWord());
	        gameOver.setFont(new Font("Serif", Font.BOLD, 30));
	        buttonPanel.add(gameOver);
	        gameOver.setVisible(false);
	    
	        guess = new JButton("Guess A Letter");
	        guess.addActionListener(controller); 
	         
	        solve = new JButton("Solve");
	        solve.addActionListener(controller); 
	        
	        
	        guess.setBounds(410, 60, 120, 30);
	        solve.setBounds(410, 0, 120, 30);
	        wheelBalance.setBounds(410, 460,200,200);
	        this.add(wheelBalance, BorderLayout.SOUTH);
	        buttonPanel.add(solve); 
	        buttonPanel.add(guess);
	        this.add(buttonPanel, BorderLayout.EAST);
	        
	        lettersGuessed = new JPanel();
	        letterTitle = new JLabel("Letters Guessed:");
	        listOfLetters = new JLabel();
	        lettersGuessed.add(letterTitle);
	        lettersGuessed.add(listOfLetters);
	        listOfLetters.setFont(new Font("Serif", Font.BOLD, 20));
	        lettersGuessed.setBackground(Color.WHITE);
	        this.add(lettersGuessed, BorderLayout.WEST);
	        

	        
	        moneyAndWord = new JPanel();
	        namePlayer = new JLabel();
	        
	        namePlayer.setVisible(false);
	        namePlayer.setFont(new Font("Serif", Font.BOLD, 30));
	        namePlayer.setBounds(-900, 100, 100, 100);
	        moneyBank = new JLabel("$0");
	        moneyBank.setFont(new Font("Serif", Font.BOLD, 34));
	        secretWord = new JLabel(model.getWord());
	        secretWord.setFont(new Font("Serif", Font.BOLD, 34));
	        lenOfWord = new JLabel("Word Length: " + model.getLengthOfWord());
	        moneyAndWord.add(namePlayer);
	        moneyAndWord.add(moneyBank);
	        
	        
	        moneyAndWord.add(secretWord);
	        moneyAndWord.add(lenOfWord);
	        this.add(moneyAndWord, BorderLayout.NORTH);
	 	        	        
	        players = new JPanel();
	        players.setLayout(new BorderLayout());
	        numContainer = new JPanel();
	        numContainer.setLayout(new GridLayout(1,2));	        
	        playerName = new JLabel("Name of Player:");
	        playerName.setFont(new Font("Serif", Font.BOLD, 14));
	        numsPlay = new JTextField("Welcome to Single Player Wheel of Fortune");	     
	        numContainer.add(playerName);
	        numContainer.add(numsPlay);
	        solveOrLetter = new JLabel("You can now choose to either a. Solve or b. Guess a Letter");
			numContainer.add(solveOrLetter);
			solveOrLetter.setVisible(false);
	        players.add(numContainer,BorderLayout.SOUTH);
	        players.setVisible(true);
	        this.add(players, BorderLayout.SOUTH);
	        numsPlay.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String text = numsPlay.getText();
					model.setName(text);
							model.setNotStart(false);
							playerName.setVisible(false);
							numsPlay.setVisible(false);
							solveOrLetter.setVisible(true);
							namePlayer.setText(text+ "'s money:");
							namePlayer.setVisible(true);
					
			        					
				}			        	
	        });
	        
	        
	        
	        naming = new JPanel();
	        naming.setLayout(new GridLayout(1,2));
			players.add(naming, BorderLayout.EAST);
			naming.setVisible(false);
  
	    }

	   

	        @Override
	        public Dimension getPreferredSize() {
	            return master == null
	                         ? new Dimension(100, 100)
	                         : new Dimension(master.getWidth(), master.getHeight());
	        }


	        public BufferedImage rotateImageByDegrees(BufferedImage img, double angle) {

	            double rads = Math.toRadians(angle);
	            double sin = Math.abs(Math.sin(rads)), cos = Math.abs(Math.cos(rads));
	            int w = img.getWidth();
	            int h = img.getHeight();
	            int newWidth = (int) Math.floor(w * cos + h * sin);
	            int newHeight = (int) Math.floor(h * cos + w * sin);

	            BufferedImage rotated = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
	            Graphics2D g2d = rotated.createGraphics();
	            AffineTransform at = new AffineTransform();
	            at.translate((newWidth - w) / 2, (newHeight - h) / 2);

	            int x = w / 2;
	            int y = h / 2;

	            at.rotate(rads, x, y);
	            g2d.setTransform(at);
	            g2d.drawImage(img, 0, 0, this);
	            g2d.dispose();

	            return rotated;
	        
	    }
	      //Get preferred Size and rotate Image by degrees is not my code. It is utilized from Stack Overflow https://stackoverflow.com/questions/37758061/rotate-a-buffered-image-in-java


	      public void getLetterGuess() {
	    	  String s = (String)JOptionPane.showInputDialog(
	                    this,
	                    "Choose a letter:",
	                    null, JOptionPane.PLAIN_MESSAGE,
	                    null,
	                    null, null
	                    );
	    	  try {
	    		  model.setLetter(s.charAt(0));
	    	  } catch(NullPointerException e) {
	    		  model.setLetter('/');
	    	  
	    	  }
	    	  model.letterChosen(true);
	    	 stop = true;

	      }
	      public void getSolveGuess() {
	    	  String s = (String)JOptionPane.showInputDialog(
	                    this,
	                    "What do you think the word is:",
	                    null, JOptionPane.PLAIN_MESSAGE,
	                    null,
	                    null, null
	                    );
	    	  try {
	    		  model.setMessage(s);
	    		  model.ChosenWord(true);
	    	  } catch(NullPointerException e) {
	    		  model.setMessage("/");	
	    		  model.ChosenWord(true);
	    	  }	    	  
	    	  
	    	  stop = true;
	    	  
	      }
	      
  	      

	public void paintComponent(Graphics g) {
		 super.paintComponent(g);
         if (rotated != null) {
             Graphics2D g2d = (Graphics2D) g.create();
             int x = (getWidth() - rotated.getWidth()) / 2;
             int y = (getHeight() - rotated.getHeight()) / 2;
             g2d.drawImage(rotated, x, y, this);
             g2d.dispose();
         }
		Graphics2D  graphics2D  =  (Graphics2D) g ;
		g.setFont(g.getFont().deriveFont(30f));
		g.setColor(Color.BLUE);
		if(model.getWinner()) {
			gameOver.setVisible(true);
			moneyAndWord.setVisible(false);
			solve.setVisible(false);
			guess.setVisible(false);
			listOfLetters.setVisible(false);
			letterTitle.setVisible(false);
			

		}
		secretWord.setText(model.getWordFilledIn());
		moneyBank.setText("$" + model.getBalance());
		listOfLetters.setText(model.parseArray());
		wheelBalance.setText("You Have Been Awarded: " + model.getWheelBalanceUpdate());
	}

	 public void numPlayersVis() {
	    	players.setVisible(false);
	    }
	 public void setStop(boolean b) {
		 stop = b;
	 }
	 public boolean getBool() {
		 return letterVSWord;
	 }


	 
	}


	



