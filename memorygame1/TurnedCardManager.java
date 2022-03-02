
package memorygame1;

import java.awt.Component;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class TurnedCardManager extends MemoryGame implements ActionListener
{
        public int cc=0;
	// data fields
	private Vector turnedCards;			// oses exoun gyrisei kai den tairiazane
	private TurnCounterLabel turnCounterLabel;// to counter auksanei se kathe 2i karta pou gyristike
	private Timer turnDownTimer;				// kathisterisi
	private final int turnDownDelay = 500; 	// kathisterisi se ms
        private ImageIcon cardIcon[];
	

	public TurnedCardManager(TurnCounterLabel turnCounterLabel)
	{
		// save parameter
		this.turnCounterLabel = turnCounterLabel;
		// create list
		this.turnedCards = new Vector(2);
		// make timer object
		this.turnDownTimer = new Timer(this.turnDownDelay, this);
		this.turnDownTimer.setRepeats(false);
	}
	
	private boolean doAddCard(Card card)
	{
                
		// prosthesi kartas sti lista
		this.turnedCards.add(card);
		// 2 kartes
		if(this.turnedCards.size() == 2)
		{
			// metraw tin kinisi
			this.turnCounterLabel.increment();
			// edw pairnw tin alli karta pou gyristike
			Card otherCard = (Card)this.turnedCards.get(0);
			// oi kartes tairiazoun ara prepei na allaksoun se EMPTY
			if(otherCard.getNum() == card.getNum()) //ΕΑΝ ΤΑΙΡΙΑΖΟΥΝ ΟΙ ΚΑΡΤΕΣ||
                            {
                            //otherCard.setIcon(new ImageIcon(getClass().getResource("/cards/empty.png")));

                                cc=cc+1;
				this.turnedCards.clear();
                                this.turnCounterLabel.increment1();
                                Component frame = null;
                                if(NameButton.difficulty==1)
                                    {
                                        if(cc>=6)
                                        JOptionPane.showMessageDialog(frame, "Κερδίσατε!\n ");
                                    }
                                else if(NameButton.difficulty==2)
                                    {
                                        if(cc>=10)
                                        JOptionPane.showMessageDialog(frame, "Κερδίσατε!\n");
                                    }
                                else if(NameButton.difficulty==3)
                                    {
                                        if(cc>=18)
                                        JOptionPane.showMessageDialog(frame, "Κερδίσατε!\n");
                                    }
                            }
			// oi kartes den tairiazoun ara timer gia na toubaroun
			else this.turnDownTimer.start();
		}
		return true;
	}
	
	public boolean turnUp(Card card)
	{
		// i karta mporei na gyrisei
		if(this.turnedCards.size() < 2) return doAddCard(card);
		// yparxoyn idi 2 kartes
		return false;
	}
	
	public void del(Card card)
	{
		this.turnedCards.remove(card);
	}
	

	public void actionPerformed(ActionEvent e)
	{
		// touba i kathe karta
		for(int i = 0; i < this.turnedCards.size(); i++ )
		{
			Card card = (Card)this.turnedCards.get(i);
			card.turnDown();
		}
		// ksexnaei tis kartes
		this.turnedCards.clear();
	}
}