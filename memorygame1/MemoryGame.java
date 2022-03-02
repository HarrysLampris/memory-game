package memorygame1;

import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.*;
import java.util.Random;
import sun.misc.IOUtils;

public class MemoryGame  implements ActionListener

{
    
        JPanel mini = new JPanel();
	private JFrame mainFrame;					
	private Container mainContentPane;			// frame me tis kartes
	private TurnCounterLabel turnCounterLabel;
	private ImageIcon cardIcon[];
	
        
	private static void newMenuItem(String text, JMenu menu, ActionListener listener)
	{
		JMenuItem newItem = new JMenuItem(text);
		newItem.setActionCommand(text);
		newItem.addActionListener(listener);
		menu.add(newItem);
	}
	
	private ImageIcon[] loadCardIcons()
	{
		// pinakas gia na mpoun oi eikones
		ImageIcon icon[] = new ImageIcon[21];
		for(int i = 0; i < 21; i++ )
		{
		
                        
                        String x ="src/cards/" + i + ".png";
                        
    
			icon[i] = new ImageIcon(x);
		}
		return icon;
	}
        

	public MemoryGame()
	{
		// parathyro paixnidiou
		this.mainFrame = new JFrame("Καλωσήρθατε στο παιχνίδι μνήμης!");
		this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.mainFrame.setSize(1000,1000);
		this.mainContentPane = this.mainFrame.getContentPane();
		this.mainContentPane.setLayout(new BoxLayout(this.mainContentPane, BoxLayout.PAGE_AXIS)); 
		//counter label
		this.turnCounterLabel = new TurnCounterLabel();
                this.mainFrame.add(mini, BorderLayout.CENTER);
		// Menu bar
		JMenuBar menuBar = new JMenuBar();
		this.mainFrame.setJMenuBar(menuBar);
		// Game menu
		JMenu gameMenu = new JMenu("Game");
		menuBar.add(gameMenu);
                newMenuItem("New Game", gameMenu, this);
		newMenuItem("Restart", gameMenu, this);
		newMenuItem("Exit", gameMenu, this);
		// Help menu
		JMenu helpMenu = new JMenu("Help");
		menuBar.add(helpMenu);
		newMenuItem("How To Play", helpMenu, this);
		newMenuItem("About", helpMenu, this);
		// Fortwma eikonwn
		this.cardIcon = loadCardIcons(); 
	}
	
	private void showInstructions()
	{
		dprintln("MemoryGame.showInstructions()");
		final String HOWTOPLAYTEXT = 
			
			"Απομνημονεύστε τις θέσεις των καρτών και φτιάξτε ζευγάρια!";
		JOptionPane.showMessageDialog(this.mainFrame, HOWTOPLAYTEXT
			, "How To Play", JOptionPane.PLAIN_MESSAGE);
	}
	
	private void showAbout()
	{
		dprintln("MemoryGame.showAbout()");
		final String ABOUTTEXT = 
			"Project 2019 φτιαγμένο από τον Σηφοστρατουδάκη και τον Λάμπρη!";
		JOptionPane.showMessageDialog(this.mainFrame, ABOUTTEXT
			, "About Memory Game", JOptionPane.PLAIN_MESSAGE);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		dprintln("actionPerformed " + e.getActionCommand());
                if(e.getActionCommand().equals("New Game")) NewGame();
		else if(e.getActionCommand().equals("Restart")) Restart();
		else if(e.getActionCommand().equals("How To Play")) showInstructions();
		else if(e.getActionCommand().equals("About")) showAbout();
		else if(e.getActionCommand().equals("Exit")) System.exit(0);
	}
	

	static public void dprintln( String message )
	{
		//System.out.println( message );
	}
	
	public static void randomizeIntArray(int[] a)
	{
		Random randomizer = new Random();
                
		for(int i = 0; i < a.length; i++ )
		{
			// dialegw enan random int gia na andallaksw arithmo kartas
			int d = randomizer.nextInt(a.length);
			// andallazw
			int t = a[d];
			a[d] = a[i];
			a[i] = t;
		}
	}
   
    public JPanel makeCards() {


        if (NameButton.difficulty == 1) {
            JPanel panel = new JPanel(new GridLayout(4,3));
            TurnedCardManager turnedManager = new TurnedCardManager(this.turnCounterLabel);
            // OLES OI KARTES NA EXOYN TO FLIPPED ARXIKA
            ImageIcon backIcon = this.cardIcon[20];
            
            int cardsToAdd[] = new int[13];
            
            for(int i = 1; i < 5; i++)
            {
                cardsToAdd[2*i] = i;
                cardsToAdd[2*6] = 6;
                cardsToAdd[2*i + 1] = i;
                
            }
            randomizeIntArray(cardsToAdd);
            
            for(int i = 0; i < cardsToAdd.length; i++)
            {
                int num = cardsToAdd[i];
                Card newCard = new Card(turnedManager, this.cardIcon[num], backIcon, num);
                panel.add(newCard);
            }
            return panel;
            } 
        
        else if (NameButton.difficulty == 2) {
            JPanel panel = new JPanel(new GridLayout(5, 4));
            TurnedCardManager turnedManager = new TurnedCardManager(this.turnCounterLabel);
            //// OLES OI KARTES NA EXOYN TO FLIPPED ARXIKA
            ImageIcon backIcon = this.cardIcon[20];
            
            int cardsToAdd[] = new int[20];
            
            for(int i = 1; i < 10; i++)
            {
                cardsToAdd[2*i] = i;
                cardsToAdd[2*i + 1] = i;
            }
            randomizeIntArray(cardsToAdd);
            
            for(int i = 0; i < cardsToAdd.length; i++)
            {
                int num = cardsToAdd[i];
                Card newCard = new Card(turnedManager, this.cardIcon[num], backIcon, num);
                panel.add(newCard);
            }
            return panel;
        }
        
        else if (NameButton.difficulty == 3) {
            JPanel panel = new JPanel(new GridLayout(6, 6));
            TurnedCardManager turnedManager = new TurnedCardManager(this.turnCounterLabel);
            //OLES OI KARTES NA EXOYN TO FLIPPED ARXIKA
            ImageIcon backIcon = this.cardIcon[20];
            
            int cardsToAdd[] = new int[36];
            
            for(int i = 1; i < 18; i++)
            {
                cardsToAdd[2*i] = i;
                cardsToAdd[2*i + 1] = i;
            }
            randomizeIntArray(cardsToAdd);
            
            for(int i = 0; i < cardsToAdd.length; i++)
            {
                int num = cardsToAdd[i];
                Card newCard = new Card(turnedManager, this.cardIcon[num], backIcon, num);
                panel.add(newCard);
            }
            return panel;
        }
        return null;
    }

	public void Restart()
	{
		this.turnCounterLabel.reset();
		this.mainContentPane.removeAll();
		this.mainContentPane.add(makeCards());
		this.mainContentPane.add(this.turnCounterLabel);
		this.mainFrame.setVisible(true);
	
        }
        
        
        public void NewGame()
        {
            new NameButton();
            this.mainFrame.setVisible(false);
        }
}
