
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.general.*;
import org.jfree.util.Rotation;

public class Struktur extends JPanel {
    private PiePanel piePanel;
    private TablePanel tablePanel;
    private JButton ResetButton;
    private JButton UpdateButton;
    private JLabel statsLabel;
    private JLabel dateTimeLabel;

    public Struktur() {
        identify();        
        String dTime = null;
        piePanel = new PiePanel();
        tablePanel = new TablePanel();
        long t = System.currentTimeMillis();
        dTime =  new java.util.Date(t).toString();

        //construct components
        statsLabel = new JLabel (" ");
        ResetButton = new JButton ("Reset");
        ResetButton.setToolTipText ("clear");
        UpdateButton = new JButton ("Update");        
        dateTimeLabel = new JLabel (" " + dTime + " ");
        UpdateButton.setToolTipText ("write to the database");

        //adjust size and set layout
        setPreferredSize (new Dimension (925, 725));
        setLayout (null);

        //add components
        add(piePanel);
        add(tablePanel);
        add (ResetButton);
        add (UpdateButton);
        add (statsLabel);
        add (dateTimeLabel);

        //Set component bounds (only needed by Absolute Positioning)
        //  from (0, 0, 0, 0) where (x,y... is upper left 
        //  and ...X,Y... is width and height);

        // Top;
        dateTimeLabel.setBounds ( 15, 15, 210, 30 ); 
        System.out.println("\tdateTimeLabel, where (x,y... is upper left: 15, 15");
        System.out.println("\tdateTimeLabel, 210 pix wide & 30 pix deep");
        System.out.println();

        // Pie area;
        piePanel.setBounds(25, 45, 850, 450 );
        System.out.println("\tpiePanel, where (x,y... is upper left: 65, 45");
        System.out.println("\tpiePanel, 750 pix wide & 450 pix deep");        
        System.out.println();

        // Table area;
        tablePanel.setBounds(65, 500, 750, 100 );
        System.out.println("\ttablePanel, where (x,y... is upper left: 65, 350");
        System.out.println("\ttablePanel, 750 pix wide & 150 pix deep");  
        System.out.println();

        // Lower percentage of User Interface;
        ResetButton.setBounds   (305, 655, 115, 40);
        UpdateButton.setBounds  (515, 655, 115, 40);

        // Bottom of Frame;
        statsLabel.setBounds    ( 30, 700, 895, 30 );
        return;
    }


  private boolean identify( ){
        boolean matched = true ;
        String whoTtxt = JOptionPane.showInputDialog( this, "Who?");
        String whatTtxt = JOptionPane.showInputDialog( this, "What?"); 
        if( ! (whoTtxt.equals("Howard") && whatTtxt.equals("wealthMoreMan")) )
        {
            System.out.println("<"+this.getClass().getName()+": authority failed, "+
            new java.util.Date(System.currentTimeMillis()).toString().toString()+">");
            System.exit(0);
        }        
        return matched;
   }


    public static void main (String[] args) {
        JFrame frame = new JFrame ("Struktur");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new Struktur());
        frame.pack();
        frame.setVisible (true);
        frame.setResizable(false);
        return;
    }
}
