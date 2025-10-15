package angelsheart;

import java.io.*;
import javax.sound.sampled.*;



class music {
    
    
    
    static File music;
    static Clip clp;
    static AudioInputStream audio;
    static int l0,l1,l2,l3,l4,l5;
    
    
    
    static void zero(){
        if (l1>0 || l2>0 || l3>0 || l4>0 || l5>0){
            pause();
        }
        l1=0;l2=0;l3=0;l4=0;l5=0;
        l0+=1;
        if (l0==1){
            play("tracks/level0.wav");
        }
    }
    
    
    
    static void one(){
        if (l0>0 || l2>0 || l3>0 || l4>0 || l5>0){
            pause();
        }
        l0=0;l2=0;l3=0;l4=0;l5=0;
        l1+=1;
        if (l1==1){
            play("tracks/level1.wav");
        }
    }
    
    
    
    static void two(){
        if (l0>0 || l1>0 || l3>0 || l4>0 || l5>0){
            pause();
        }
        l0=0;l1=0;l3=0;l4=0;l5=0;
        l2+=1;
        if (l2==1){
            play("tracks/level2.wav");
        }
    }
    
    
    
    static void three(){
        if (l0>0 || l1>0 || l2>0 || l4>0 || l5>0){
            pause();
        }
        l0=0;l1=0;l2=0;l4=0;l5=0;
        l3+=1;
        if (l3==1){
            play("tracks/level3.wav");
        }
    }
    
    
    
    static void four(){
        if (l0>0 || l1>0 || l2>0 || l3>0 || l5>0){
            pause();
        }
        l0=0;l1=0;l2=0;l3=0;l5=0;
        l4+=1;
        if (l4==1){
            play("tracks/level4.wav");
        }
    }
    
    
    
    static void five(){
        if (l0>0 || l1>0 || l2>0 || l3>0 || l4>0){
            pause();
        }
        l0=0;l1=0;l2=0;l3=0;l4=0;
        l5+=1;
        if (l5==1){
            play("tracks/level5.wav");
        }
    }
    
    
    
    static void play(String path){
        try{
            music = new File(path);
            audio = AudioSystem.getAudioInputStream(music);
            clp = AudioSystem.getClip();
            clp.open(audio);
            clp.loop(Clip.LOOP_CONTINUOUSLY);
            clp.start();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    
    
    
    static void pause(){
        clp.stop();
        clp.close();
    }
    
    
    
}
