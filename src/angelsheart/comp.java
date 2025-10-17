package angelsheart;

import javax.swing.*;
import java.awt.*;



class comp extends panel{
    
    
    
    public void ttl(){
        name = new JLabel();
        name.setBounds(10,30,265,150);
        name.setText("<html>&nbsp;ANGEL'S<br>&nbsp;&nbsp;&nbsp;&nbsp;HEART</html>");
        name.setForeground(Color.decode("0xFFD700"));
        name.setFont(new Font("Jokerman",Font.BOLD,50));
        this.add(name);
    }
    
    
    
    public void ins(){
        how = new JLabel();
        how.setBounds(20,470,300,150);
        String space = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
        how.setText("<html>"+"GO SAVE the patient<br>"+space+space+"&"+"<br>COME BACK to heaven"+"</html>");
        how.setForeground(Color.decode("0x90EE90"));
        how.setFont(new Font("Broadway",Font.PLAIN,20));
        this.add(how);
    }
    
    
    
    public void lft(){
        span = new JLabel();
        span.setBounds(8,540,270,50);
        span.setText("<html>"+"&nbsp;"+limit+"&nbsp;"+"ROUND LEFT"+"</html>");
        span.setFont(new Font("Orbitron",Font.BOLD,30));
        span.setOpaque(true);
        span.setForeground(Color.decode("0xE75480"));
        span.setBackground(Color.decode("0xFFC0CB"));
        this.add(span);
    }
    
    
    
    public void cplt(){
        won = new JLabel();
        won.setBounds(10,200,270,180);
        won.setText("<html>"+"G A M E"+"<br>"+"&nbsp;&nbsp;&nbsp;"+"D O N E"+"</html>");
        won.setFont(new Font("Elephant",Font.BOLD,50));
        won.setForeground(Color.yellow);
        this.add(won);
    }
    
    
    
    public void pass(){
        fnsh = new JLabel();
        fnsh.setBounds(25,210,270,180);
        String space = "&nbsp;&nbsp;";
        fnsh.setText("<html>"+space+space+space+"S S"+"<br>"
                +space+space+"A"+space+space+"E"+"<br>"
                +space+"P"+space+space+space+space+"D"+"</html>");
        fnsh.setFont(new Font("Elephant",Font.BOLD,50));
        fnsh.setForeground(Color.yellow);
        this.add(fnsh);
    }
    
    
    
    public void gov(){
        over = new JLabel();
        over.setBounds(20,120,250,350);
        String space = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
        over.setText("<html>"+"&nbsp;"+"G"+space+"&nbsp;&nbsp;&nbsp;"+"O"+"<br>"
                +"&nbsp;"+"A"+space+"&nbsp;&nbsp;"+"V"+"<br>"
                +"&nbsp;"+"M"+space+"E"+"<br>"
                +"&nbsp;"+"E"+space+"&nbsp;&nbsp;"+"R"+"</html>");
        over.setFont(new Font("Ravie",Font.BOLD,50));
        over.setForeground(Color.decode("0xFFEC8B"));
        this.add(over);
    }
    
    
    
    public void scr(){
        score = new JLabel();
        score.setBounds(45,430,190,110);
        score.setText("<html>"+"&nbsp;"+"SCORE"+"<br>"
                +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+total+"</html>");
        score.setFont(new Font("Stencil",Font.BOLD,50));
        score.setOpaque(true);
        score.setForeground(Color.decode("0x5C4033"));
        score.setBackground(Color.decode("0xFFA500"));
        this.add(score);
    }
    
    
    
    public void fld(){
        fail = new JLabel();
        fail.setBounds(0,250,500,300);
        String space = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
        fail.setText("<html>"+space+"F"+space+space+space+space+"F"+"<br>"
                + space+space+"A"+space+space+"A"+"<br>"
                + space+space+space+"I"+"&nbsp;&nbsp;"+"I"+"<br>"
                + space+space+space+"L"+"L<br>"
                + space+space+"E"+space+space+"E<br>"
                + space+"D"+space+space+space+space+"D</html>");
        fail.setForeground(Color.decode("0xFFEC8B"));
        fail.setFont(new Font("Ravie",Font.BOLD,35));
        this.add(fail);
    }
    
    
    
    public void bton(){
        buton = new JButton();
        buton.setBounds(120,150,50,50);
        buton.setText("1");
        buton.setFont(new Font("Lemon",Font.BOLD,20));
        buton.setFocusable(false);
        buton.setBackground(Color.blue);
        buton.setForeground(Color.white);
        buton.addActionListener(this);
        this.add(buton);
    }
    
    
    
    public void bttw(){
        buttw = new JButton();
        buttw.setBounds(120,225,50,50);
        buttw.setText("2");
        buttw.setFont(new Font("Lemon",Font.BOLD,20));
        buttw.setFocusable(false);
        buttw.setBackground(Color.red);
        buttw.setForeground(Color.gray);
        buttw.addActionListener(this);
        this.add(buttw);
    }
    
    
    
    public void btth(){
        butth = new JButton();
        butth.setBounds(120,300,50,50);
        butth.setText("3");
        butth.setFont(new Font("Lemon",Font.BOLD,20));
        butth.setFocusable(false);
        butth.setBackground(Color.yellow);
        butth.setForeground(Color.pink);
        butth.addActionListener(this);
        this.add(butth);
    }
    
    
    
    public void btfo(){
        butfo = new JButton();
        butfo.setBounds(120,375,50,50);
        butfo.setText("4");
        butfo.setFont(new Font("Lemon",Font.BOLD,20));
        butfo.setFocusable(false);
        butfo.setBackground(Color.green);
        butfo.setForeground(Color.decode("0xA52A2A"));
        butfo.addActionListener(this);
        this.add(butfo);
    }
    
    
    
    public void btfi(){
        butfi = new JButton();
        butfi.setBounds(120,450,50,50);
        butfi.setText("5");
        butfi.setFont(new Font("Lemon",Font.BOLD,20));
        butfi.setFocusable(false);
        butfi.setBackground(Color.decode("0xA020F0"));
        butfi.setForeground(Color.black);
        butfi.addActionListener(this);
        this.add(butfi);
    }
    
    
    
    public void btst(){
        butst = new JButton();
        butst.setBounds(90,325,100,50);
        butst.setText("START");
        butst.setFont(new Font("Algerian",Font.BOLD,20));
        butst.setFocusable(false);
        butst.setBackground(Color.white);
        butst.setForeground(Color.black);
        butst.addActionListener(this);
        this.add(butst);
    }
    
    
    
    public void btcs(){
        butcs = new JButton();
        butcs.setBounds(45,425,200,50);
        butcs.setText("CHOOSE LEVELS");
        butcs.setFont(new Font("Algerian",Font.BOLD,20));
        butcs.setFocusable(false);
        butcs.setBackground(Color.black);
        butcs.setForeground(Color.white);
        butcs.addActionListener(this);
        this.add(butcs);
    }
    
    
    
    public void btcn(){
        butcn = new JButton();
        butcn.setBounds(45,130,200,50);
        butcn.setText("CONTINUE");
        butcn.setFont(new Font("Lemon",Font.BOLD,20));
        butcn.setFocusable(false);
        butcn.setBackground(Color.white);
        butcn.setForeground(Color.magenta);
        butcn.addActionListener(this);
        this.add(butcn);
    }
    
    
    
    public void btrp(){
        butrp = new JButton();
        butrp.setBounds(45,150,200,50);
        butrp.setText("RETRY");
        butrp.setFont(new Font("Lemon",Font.BOLD,20));
        butrp.setFocusable(false);
        butrp.setBackground(Color.magenta);
        butrp.setForeground(Color.white);
        butrp.addActionListener(this);
        this.add(butrp);
    }
    
    
    
    public void btbk(){
        butbk = new JButton();
        butbk.setBounds(40,60,210,50);
        butbk.setText("BACK TO MENU");
        butbk.setFont(new Font("Lemon",Font.BOLD,20));
        butbk.setFocusable(false);
        butbk.setBackground(Color.cyan);
        butbk.setForeground(Color.black);
        butbk.addActionListener(this);
        this.add(butbk);
    }
    
    
    
}
