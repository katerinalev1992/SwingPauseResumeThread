package pack3;

/**
 * Created by katerynalevytska on 3/21/17.
 */
public class Main {
    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new MainFrame().setVisible(true);
            }
        });
    }
}
