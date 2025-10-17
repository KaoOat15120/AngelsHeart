package angelsheart;

import javax.swing.*;



public class Angelsheart extends JFrame{
    
    
    
    static Angelsheart frame;
    static panel pan;

    
    
    public static void main(String[] args) {
        frame = new Angelsheart();
        frame.setTitle("Angel's Heart");
        frame.setSize(300,650);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pan = new comp();
        pan.setBounds(0,0,300,650);
        pan.setLayout(null);
        frame.add(pan);
       
        frame.setVisible(true);
        pan.requestFocus();
    }
    
    
    
}