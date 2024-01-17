package KeyBoard;

import java.awt.event.KeyEvent;

import main.GamePanel;

public class playKey extends keyControl implements KeyCommand {
    private GamePanel gp;
    public playKey(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void keyPressed(int key_code) {
        if ((key_code == KeyEvent.VK_A || key_code == KeyEvent.VK_LEFT)&&(isSpace==false)) {
            leftPress = true;
        }
        else if ((key_code == KeyEvent.VK_D || key_code == KeyEvent.VK_RIGHT)&&(isSpace==false)) {
            rightPress = true;
        }
        else if (key_code == KeyEvent.VK_SPACE) {
            isSpace = true;
        }

        else if (key_code == KeyEvent.VK_1) {
            isOne = true;
        }
        else if (key_code == KeyEvent.VK_P) {
            pPress = true;
        }
        else if ((key_code == KeyEvent.VK_S || key_code == KeyEvent.VK_DOWN)) {
            downPress = true;

        }
        else if (key_code == KeyEvent.VK_W || key_code == KeyEvent.VK_UP) {
            upPress = true;
        } 
        else if (key_code == KeyEvent.VK_2) {
            isTwo = true;
        }
        else if(key_code == KeyEvent.VK_M){
            gp.h.openMap();
        }
         else if(key_code == KeyEvent.VK_R){
            gp.h.reset();
            gp.player.coin= 0;
        }
         else if(key_code == KeyEvent.VK_Y){
            if(gp.h.oldman == true){
                            gp.gamestate = gp.playState;
                gp.h.oldman = false;
                                    gp.player.isMove = true;

            }
            else{
 gp.h.teleport();
                        gp.gamestate = gp.playState;
                        gp.player.isMove = true;
                      
            }
           

        }
           else if(key_code == KeyEvent.VK_N){
             if(gp.h.oldman == true){
                            gp.gamestate = gp.playState;
                                            gp.h.oldman = false;
                        gp.player.isMove = true;


            }
            else{
            gp.gamestate = gp.playState;
                                    gp.player.isMove = true;


        }
    }
        
       
    }

    @Override
    public void keyReleased(int key_code) {
        if (((key_code == KeyEvent.VK_A || key_code == KeyEvent.VK_LEFT))) {
            leftPress = false;
        }
        else if (key_code == KeyEvent.VK_P) {
            pPress = false;
        }
        else if ((key_code == KeyEvent.VK_D || key_code == KeyEvent.VK_RIGHT)) {
            rightPress = false;
        }
        else if (key_code == KeyEvent.VK_S || key_code == KeyEvent.VK_DOWN) {
            downPress = false;
        }
        else if (key_code == KeyEvent.VK_W || key_code == KeyEvent.VK_UP) {
            upPress = false;
        }
        else if (key_code == KeyEvent.VK_2) {
            isTwo = false;
        }
        else if (key_code == KeyEvent.VK_1) {
            isOne = false;
        }
        else if (key_code == KeyEvent.VK_SPACE) {
            isSpace = false;
        }
        else if (key_code == KeyEvent.VK_F) {
            fPress = false;
        }
        else if(key_code == KeyEvent.VK_M){
            mPress = false;
        }
        
    }
    
}
