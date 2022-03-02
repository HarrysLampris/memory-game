
package memorygame1;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class TurnCounterLabel extends JLabel
{
        private int numpoints = 0;
	private int numTurns = 0;
        private final String DESCRIPTION1 = "   Πόντοι: ";
	private final String DESCRIPTION = "Προσπάθειες: ";
	
//kanei update to counter live
	private void update()
	{
            setText(DESCRIPTION + Integer.toString(this.numTurns) + DESCRIPTION1 + Integer.toString(this.numpoints));
            try (PrintWriter out = new PrintWriter("Score.txt")) 
                {
                    out.println("Giannis");
                    out.println("Συνολικοί Πόντοι: " +numpoints);
                    out.println("Συνολικές Προσπάθειες: " +numTurns);
                }               
            catch (FileNotFoundException ex) 
                {
                        Logger.getLogger(TurnCounterLabel.class.getName()).log(Level.SEVERE, null, ex);
                }
            
	}
	
	public TurnCounterLabel()
	{
		super();
		reset();
                reset1();
	}
	
	public void increment()
	{
		this.numTurns++;
		update();
	}
        
        public void increment1()
	{
		this.numpoints++;
		update();
	}
	
	public void reset()
	{
		this.numTurns = 0;
		update();
	}
        
        public void reset1()
	{
		this.numpoints = 0;
		update();
	}
}