package memorygame1;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class NameButton  {
    static int difficulty;
    
    
	 public  NameButton()
         {  
                             try
                    {
                        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
                            {
                                if ("Nimbus".equals(info.getName()))
                                    {
                                        UIManager.setLookAndFeel(info.getClassName());
                                break;
                                    }
                            }
                    }
                catch (Exception e) {}
		JFrame f=new JFrame("Παιχνίδι Μνήμης");        
					//label gia titlo
                JButton b1=new JButton("Έυκολο");
                b1.setBounds(10,160,85, 40);
                JButton b2=new JButton("Κανονικό");
                b2.setBounds(97,160,90, 40);
                JButton b3=new JButton("Δύσκολο");
                b3.setBounds(189,160,90, 40);
		JLabel label = new JLabel();
                JLabel label2 = new JLabel();
		label.setText("Δώσε όνομα:");
		label.setBounds(10, 10, 100, 100);
                label2.setText("Δυσκολία:");
                label2.setBounds(10, 80, 160, 100);
		JLabel label1 = new JLabel();
		label1.setBounds(10, 110, 200, 100);
		//textfield gia onoma
		JTextField textfield= new JTextField();
		textfield.setBounds(110, 50, 130, 30);
                
                String onoma=textfield.getText();
                
		f.add(label1);
		f.add(textfield);
		f.add(label);
                f.add(label2);
                f.add(b1);
                f.add(b2);
                f.add(b3);
		f.setSize(300,300);    
		f.setLayout(null);    
		f.setVisible(true);    
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
		
                
                b1.addActionListener(new ActionListener() {
	        
			@Override
			public void actionPerformed(ActionEvent arg0) 
                            {
                                difficulty=1;
                                MemoryGame instance = new MemoryGame();
                                instance.Restart();
                                label1.setText("Το όνομα καταχωρήθηκε.");
                                f.setVisible(false);
                            }
	      });
                b2.addActionListener(new ActionListener() {
	        
			@Override
			public void actionPerformed(ActionEvent arg1) 
                            {
                                difficulty=2;
                                MemoryGame instance = new MemoryGame();
                                instance.Restart();
                                label1.setText("Το όνομα καταχωρήθηκε.");
                                f.setVisible(false);
                            }
	      });
                b3.addActionListener(new ActionListener() {
	        
			@Override
			public void actionPerformed(ActionEvent arg2) 
                            {
                                difficulty=3;
                                MemoryGame instance = new MemoryGame();
                                instance.Restart();
                                label1.setText("Το όνομα καταχωρήθηκε.");
                                f.setVisible(false);
                            }
	      });
		}
         
         
		


 }