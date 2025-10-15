package angelsheart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;



abstract class panel extends JPanel implements ActionListener,KeyListener{
    
    
    
    boolean up,down,left,right;
    boolean can;
    int cx,cy;
    int fxr,fxl;
    int frspd,progress,hlt,rnd,kick;
    int lv=0,psh=100,limit=5,total=0;
    int[][] star = new int[10][2];
    int[] spot = new int[10];
    double cpspd;
    Timer time,swap;
    JButton butst = new JButton();
    JButton butcn = new JButton();
    JButton butrp = new JButton();
    JButton butcs = new JButton();
    JButton butbk = new JButton();
    JButton buton = new JButton();
    JButton buttw = new JButton();
    JButton butth = new JButton();
    JButton butfo = new JButton();
    JButton butfi = new JButton();
    JLabel fail = new JLabel();
    JLabel name = new JLabel();
    JLabel score = new JLabel();
    JLabel over = new JLabel();
    JLabel span = new JLabel();
    JLabel won = new JLabel();
    JLabel fnsh = new JLabel();
    JLabel how = new JLabel();
    JProgressBar health = new JProgressBar();
    JProgressBar count = new JProgressBar(0,100);
    allimg images = new allimg();
    
    
    
    panel(){
        
        this.setPreferredSize(new Dimension(300,650));
       
        btst();
        btcs();
        ttl();
        ins();
        
        
        Timer loop = new Timer(50,this);
        loop.start();
        
        swap = new Timer(3000,new ActionListener(){
            public void actionPerformed(ActionEvent e){
                point();
            }
        });
        
        this.addKeyListener(this);
        this.setFocusable(true);
    }
    
    
    
    @Override
    public void paintComponent (Graphics g){
        super.paintComponent(g);
        draw(g);
        repaint();
    }
    
    
    
    public void draw (Graphics g){
        switch (lv){
            case 0 : bgn(g); count.setVisible(false); break;
            case 1 : lvl1(g); break;
            case 2 : lvl2(g); break;
            case 3 : lvl3(g); break;
            case 4 : lvl4(g); break;
            case 5 : lvl5(g); break;
            case -1 : menu(g); count.setVisible(false); break;
        }
    }
    
    
    
    public void song(){
        switch(lv){
            case 0 : music.zero(); break;
            case 1 : music.one(); break;
            case 2 : music.two(); break;
            case 3 : music.three(); break;
            case 4 : music.four(); break;
            case 5 : music.five(); break;
        }
    }
    
    
    
    public void point(){
        Random r = new Random();
        for (int a=0;a<10;a++){
            int x = r.nextInt(30,240);
            star[a][0] = x;
            star[a][1] = spot[a];
        }
    }
    
    
    
    public void move(){
        if (can==true){
            
            
            
            if (up==true){
                if (cy>=20){
                    cy-=cpspd;
                }
            }
            if (down==true){
                if (cy<=570){
                    cy+=cpspd;
                }
            }
            if (left==true){
                if (cx>=5){
                    cx-=cpspd;
                }
            }
            if (right==true){
                if (cx<=270){
                    cx+=cpspd;
                }
            }
            
            
            
            if (cy>=550 && cx>=120 && cx<=170 && hlt>0 && progress>0){
                rnd=1;
                cpspd=5;
                frspd=25;
                kick=-1;
                hlt=100;
                health.setValue(hlt);
                count.setVisible(false);
                time.stop();
            }
            
            
            
            if (cy<=20 && hlt>0 && rnd==1){
                if (lv<=4){
                    total+=limit;
                    succ();
                    btcn();
                    pass();
                }
                else if (lv==5){
                    total+=limit;
                    succ();
                    cplt();
                }
            }
            
            
            
            if (progress<=0){
                limit-=1;
                if (limit==0){
                    dead();
                }
                else{
                    notsucc();
                }
            }
            
            
            if (coll()){
                if (lv==2){
                    cpspd-=0.5;
                    dmg();
                    con();
                }
                if (lv==1){
                    frspd+=5;
                    dmg();
                    con();
                }
                if (lv==5){
                    cy-=(25*kick);
                    dmg();
                    con();
                }
                if (lv==3){
                    cx+=psh;
                    psh*=-1;
                    dmg();
                    con();
                }
                if (lv==4){
                    frspd*=-1;
                    dmg();
                    con();
                }
            }
            
            
            
        }
    }
    
    
    
    public void fire(){
        if (can==true){
            fxr-=frspd;
            fxl+=frspd;
            if (fxr<0 && frspd>0){
                fxr=300;
            }
            if (fxl>300 && frspd>0){
                fxl=0;
            }
            if (fxr>300 && frspd<0){
                fxr=0;
            }
            if (fxl<0 && frspd<0){
                fxl=300;
            }
        }
    }
    
    
    
    public void con(){
        if (hlt<=0){
            limit-=1;
            if (limit==0){
                dead();
            }
            else{
                notsucc();
            }
        }
    }
    
    
    
    public void succ(){
        res();
        scr();
        btbk();
    }
    
    
    
    public void notsucc(){
        fld();
        lft();
        btrp();
        res();
        btbk();
    }
    
    
    
    public void dead(){
        gov();
        scr();
        res();
        btbk();
    }
    
    
    
    public boolean coll(){
        boolean[] b = new boolean[10];
        int d=0;
        for (int c=50;c<=500;c+=100){
            b[d] = (cy+25>c && cy<c+20);
            d+=2;
        }
        int e=1;
        for (int c=100;c<=500;c+=100){
            b[e] = (cy+25>c && cy<c+20);
            e+=2;
        }
        return ((cx+20>fxr && cx<fxr+20) && (b[0]||b[2]||b[4]||b[6]||b[8])) 
                || ((cx+20>fxl && cx<fxl+20) && (b[1]||b[3]||b[5]||b[7]||b[9]));
    }
    
    
    
    public boolean get(int x, int y){
        if ((cx+15>x && cx<x+15) && (cy+25>y && cy<y+25)){
            return true;
        }
        return false;
    }
    
    
    
    public void hltbr(){
        health = new JProgressBar();
        health.setBounds(0,0,285,15);
        health.setValue(100);
        health.setForeground(Color.green);
        health.setBackground(Color.blue);
        add(health);
        hlt=100;
    }
    
    
    
    public void tmrbr(){
        progress = 100;
        count = new JProgressBar(0,100);
        count.setBounds(0,600,285,15);
        count.setValue(progress);
        count.setForeground(Color.red);
        count.setBackground(Color.yellow);
        add(count);
        
        time = new Timer(300,new ActionListener(){
            public void actionPerformed(ActionEvent e){
                progress-=1;
                count.setValue(progress);
                if (progress<=0){
                    count.setValue(0);
                    time.stop();
                }
            }
        });
        time.start();
    }
    
    
    
    public void dmg(){
        hlt-=20;
        if (hlt<0){
            hlt=0;
        }
        health.setValue(hlt);
    }
    
    
    
    abstract public void lft();
    abstract public void cplt();
    abstract public void pass();
    abstract public void gov();
    abstract public void scr();
    abstract public void fld();
    abstract public void ttl();
    abstract public void ins();
    
    
    
    abstract public void bton();
    abstract public void bttw();
    abstract public void btth();
    abstract public void btfo();
    abstract public void btfi();
    abstract public void btst();
    abstract public void btcs();
    abstract public void btcn();
    abstract public void btrp();
    abstract public void btbk();
    
    
    
    public void bgn(Graphics g){
        g.drawImage(images.backimg,0,0,300,615,null);
        g.drawImage(images.trapimg,3,0,280,300,null);
        g.drawImage(images.mirtrapimg,3,295,280,200,null);
        g.drawImage(images.cupidimg,120,180,50,100,null);
    }
    
    
    
    public void menu(Graphics g){
        g.drawImage(images.backimg,0,0,300,615,null);
    }


    
    public void lvl1(Graphics g){
        g.drawImage(images.backbimg,0,0,300,615,null);
        
        sent(g);
        
        g.drawImage(images.sickimg,125,550,50,50,null);
        
        for (int a=50;a<=500;a+=100){
            g.drawImage(images.ghostwimg,255,a,30,30,null);
        }
        for (int a=100;a<=500;a+=100){
            g.drawImage(images.mirghostwimg,0,a,30,30,null);
        }
        
        ran(g);
        
        for (int a=50;a<=500;a+=100){
            g.drawImage(images.firewimg,fxr,a,15,15,null);
        }
        for (int a=100;a<=500;a+=100){
            g.drawImage(images.firewimg,fxl,a,15,15,null);
        }
    }
    
    
    
    public void lvl2(Graphics g){
        g.drawImage(images.backrimg,0,0,300,615,null);
        
        sent(g);
        
        g.drawImage(images.sickimg,125,550,50,50,null);
        
        for (int a=50;a<=500;a+=100){
            g.drawImage(images.ghostgimg,255,a,30,30,null);
        }
        for (int a=100;a<=500;a+=100){
            g.drawImage(images.mirghostgimg,0,a,30,30,null);
        }
        
        ran(g);
        
        for (int a=50;a<=500;a+=100){
            g.drawImage(images.firegimg,fxr,a,15,15,null);
        }
        for (int a=100;a<=500;a+=100){
            g.drawImage(images.firegimg,fxl,a,15,15,null);
        }
    }
    
    
    
    public void lvl3(Graphics g){
        g.drawImage(images.backyimg,0,0,300,615,null);
        
        sent(g);
        
        g.drawImage(images.sickimg,125,550,50,50,null);
        
        for (int a=50;a<=500;a+=100){
            g.drawImage(images.ghostpimg,255,a,30,30,null);
        }
        for (int a=100;a<=500;a+=100){
            g.drawImage(images.mirghostpimg,0,a,30,30,null);
        }
        
        ran(g);
        
        for (int a=50;a<=500;a+=100){
            g.drawImage(images.firepimg,fxr,a,15,15,null);
        }
        for (int a=100;a<=500;a+=100){
            g.drawImage(images.firepimg,fxl,a,15,15,null);
        }
    }
    
    
    
    public void lvl4(Graphics g){
        g.drawImage(images.backgimg,0,0,300,615,null);
        
        sent(g);
        
        g.drawImage(images.sickimg,125,550,50,50,null);
        
        for (int a=50;a<=500;a+=100){
            g.drawImage(images.ghostbrimg,255,a,30,30,null);
        }
        for (int a=100;a<=500;a+=100){
            g.drawImage(images.mirghostbrimg,0,a,30,30,null);
        }
        
        ran(g);
        
        for (int a=50;a<=500;a+=100){
            g.drawImage(images.firebrimg,fxr,a,15,15,null);
        }
        for (int a=100;a<=500;a+=100){
            g.drawImage(images.firebrimg,fxl,a,15,15,null);
        }
    }
    
    
    
    public void lvl5(Graphics g){
        g.drawImage(images.backpimg,0,0,300,615,null);
        
        sent(g);
        
        g.drawImage(images.sickimg,125,550,50,50,null);
        
        for (int a=50;a<=500;a+=100){
            g.drawImage(images.ghostblimg,255,a,30,30,null);
        }
        for (int a=100;a<=500;a+=100){
            g.drawImage(images.mirghostblimg,0,a,30,30,null);
        }
        
        ran(g);
        
        for (int a=50;a<=500;a+=100){
            g.drawImage(images.fireblimg,fxr,a,15,15,null);
        }
        for (int a=100;a<=500;a+=100){
            g.drawImage(images.fireblimg,fxl,a,15,15,null);
        }
    }
    
    
    
    public void sent(Graphics g){
        if (rnd==0){
            g.drawImage(images.cupidimg,cx,cy,10,20,null);
        }
        else{
            g.drawImage(images.cupidimg2,cx,cy,10,20,null);
        }
    }
    
    
    
    public void ran(Graphics g){
        for (int a=0;a<10;a++){
            g.drawImage(images.starimg,star[a][0],star[a][1],15,15,null);
            boolean b = get(star[a][0],star[a][1]);
            if (b==true){
                if (hlt<100){
                    star[a][1] = 700;
                    spot[a] = 700;
                    hlt+=10;
                    health.setValue(hlt);
                }
            }
        }
    }
    
    
    
    public void each(){
        alllvl();
        hltbr();
        tmrbr();
        point();
        swap.start();
    }
    
    
    
    public void alllvl(){
        can = true;
        cx=145;cy=20;
        fxr=300;fxl=0;
        cpspd=5;
        frspd=30;
        rnd=0;
        kick=1;
        spot = new int[] {50,100,150,200,250,300,350,400,450,500};
        butbk.setVisible(false);
        buton.setVisible(false);
        buttw.setVisible(false);
        butth.setVisible(false);
        butfo.setVisible(false);
        butfi.setVisible(false);
    }
    
    
    
    public void res(){
        health.setVisible(false);
        count.setVisible(false);
        time.stop();
        swap.stop();
        can = false;
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==butst){
            lv+=1;
            each();
            butst.setVisible(false);
            butcs.setVisible(false);
            name.setVisible(false);
            how.setVisible(false);
        }
        if (e.getSource()==butrp){
            lv+=0;
            each();
            butrp.setVisible(false);
            butbk.setVisible(false);
            score.setVisible(false);
            fail.setVisible(false);
            span.setVisible(false);
        }
        if (e.getSource()==butcn){
            lv+=1;
            limit=5;
            each();
            butcn.setVisible(false);
            butbk.setVisible(false);
            score.setVisible(false);
            fnsh.setVisible(false);
        }
        if (e.getSource()==butcs){
            lv=-1;
            tmrbr();
            time.stop();
            butst.setVisible(false);
            butcs.setVisible(false);
            name.setVisible(false);
            how.setVisible(false);
            bton();
            bttw();
            btth();
            btfo();
            btfi();
            btbk();
        }
        if (e.getSource()==butbk){
            lv=0;
            limit=5;
            total=0;
            alllvl();
            tmrbr();
            time.stop();
            butrp.setVisible(false);
            butcn.setVisible(false);
            fail.setVisible(false);
            score.setVisible(false);
            over.setVisible(false);
            span.setVisible(false);
            won.setVisible(false);
            fnsh.setVisible(false);
            btst();
            btcs();
            ttl();
            ins();
        }
        if (e.getSource()==buton){
            lv=1;
            each();
        }
        if (e.getSource()==buttw){
            lv=2;
            each();
        }
        if (e.getSource()==butth){
            lv=3;
            each();
        }
        if (e.getSource()==butfo){
            lv=4;
            each();
        }
        if (e.getSource()==butfi){
            lv=5;
            each();
        }
        move();
        fire();
        song();
    }
    
    
    
    @Override
    public void keyTyped(KeyEvent e) {
    }
    
    
    
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_UP : up=true; break;
            case KeyEvent.VK_DOWN : down=true; break;
            case KeyEvent.VK_LEFT : left=true; break;
            case KeyEvent.VK_RIGHT : right=true; break;
        }
    }
    
    
    
    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_UP : up=false; break;
            case KeyEvent.VK_DOWN : down=false; break;
            case KeyEvent.VK_LEFT : left=false; break;
            case KeyEvent.VK_RIGHT : right=false; break;
        }
    }
    
    
    
}