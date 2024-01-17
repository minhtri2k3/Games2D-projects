package Events;

import TextSreen.playState;

public class Quizz_Events extends SuperEvent {
    private int x;
    private int y;
    public boolean teleport = false;

    public Quizz_Events() {
    }

    // public void ModeSpeed(int i){
    // announce("Speed up");
    // super.ModeSpeed(5);
    // }

    public void correct() {
        if (objectName == "question") {
            if (getObjectIndex() == 13 || getObjectIndex() == 14) {
                announce("Correct. Please choose a portal to pass");
                gp.playSE("clear");
                clear_object();
            } else {
                announce("Correct, you can pass");
                gp.playSE("unlock");

                clear_object();

            }
        }
        if (objectName == "doll") {
            announce("Correct. \nThere is something may help you in the North pool");
            Key1();
            isDoll = false;
        }
        if (objectName == "monster") {
            if (getObjectIndex() == 35) {
                announce("Very good. Maybe see you later");
                nextState(gp.playState);
                clear_object();
            } else {
                announce("Correct, you can pass me");
                nextState(gp.playState);
                clear_object();
            }
        }
       
        

    }

    public void wrong() {
        if (objectName == "question") {
            if (getObjectIndex() == 13 || getObjectIndex() == 14) {
                announce("Wrong. Here is a surprise for you");
                setTeleport(15, 81);
            } else {
                announce("Wrong, you can not pass");
            }
        } else if (objectName == "doll") {
            if (Keys() == 0) {
                announce("Wrong. Here is suprised for you");
                setTeleport(52, 29);
            }
            if (Keys() == 1) {
                announce("Wrong and go away. I will take your key as punnish");
                loseKey();
                setTeleport(52, 29);
            }

        } else if (getObjectIndex() == 13 || getObjectIndex() == 14) {
            announce("Wrong.");
            setTeleport(15, 81);
        } else if (objectName == "monster") {
            if (getObjectIndex() == 35) {
                if (Keys() > 1 || (Keys() == 1 && (gp.object[31] != null || gp.object[29] != null))) {
                    announce("Wrong. You have a lot of keys, I will take your key.");
                    gp.playSE("clear");
                    nextState(gp.playState);
                    loseKey();
                    clear_object();
                    isMonster = false;

                } else if (Keys() == 0) {
                    if (player.speed == 4) {
                        announce("Wrong. Feel my  super power....");
                        nextState(gp.playState);
                        setTeleport(22, 29);
                        ModeSpeed(-1);
                    }
                    if (player.speed == 3) {
                        announce("Wrong. Feel my power....");
                        nextState(gp.playState);
                        setTeleport(22, 29);
                    }
                }
            }

            else {
                announce("Wrong. You can not pass me. Here is your punnish");
                setTeleport(44, 71);
                nextState(gp.playState);
            }
        }
        // if(gp.isGraph){
        //     if(objectName == "portal"){
        //         nextState(gp.playState);
        //     }

        // }

    }

    public void teleport() {
        super.teleport(x, y, "right");
    }

    public void setTeleport(int x, int y) {
        this.x = x;
        this.y = y;
        teleport = true;
    }
    public void graph() {
            if(objectName == "portal"){

                gp.h.teleport();
                gp.gamestate = gp.playState;
                gp.player.isMove = true;
                // clear_object();
            }

        }
    
}
