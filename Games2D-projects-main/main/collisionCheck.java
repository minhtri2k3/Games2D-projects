package main;

import entity.Entity;

public class collisionCheck {
    GamePanel gp;
    Entity entity;
    public collisionCheck(GamePanel gp) {
        this.gp = gp;
    }
    public void checkTile(Entity entity) {
        int entityLeftWorldX = entity.worldX+entity.solidArea.x;
        int entityRightWorldX = entity.worldX+entity.solidArea.x+entity.solidArea.width;
        int entityTopWorldY = entity.worldY+entity.solidArea.y;
        int entityBottomWorldY = entity.worldY+entity.solidArea.y+entity.solidArea.height; 
        int entityLeftCol = entityLeftWorldX/gp.tileSize;
        int entityRightCol = entityRightWorldX/gp.tileSize;
        int entityTopRow = entityTopWorldY/gp.tileSize;
        int entityBottomRow = entityBottomWorldY/gp.tileSize;
        int tileNum1, tileNum2;
        if(entity.direction == "up"){
            entityTopRow =(entityTopWorldY-entity.speed) /gp.tileSize;
            tileNum1 = gp.tilesM.mapTileNumber[entityLeftCol][entityTopRow];
            tileNum2 = gp.tilesM.mapTileNumber[entityRightCol][entityTopRow];
            if(gp.tilesM.tile[tileNum1].collision== true|| gp.tilesM.tile[tileNum2].collision== true){
                entity.collisionEnabled = true;
            }
        }
        if(entity.direction == "down"){
            entityBottomRow =(entityBottomWorldY+entity.speed)/gp.tileSize;
            tileNum1 = gp.tilesM.mapTileNumber[entityLeftCol][entityBottomRow];
            tileNum2 = gp.tilesM.mapTileNumber[entityRightCol][entityBottomRow];
            if(gp.tilesM.tile[tileNum1].collision== true|| gp.tilesM.tile[tileNum2].collision== true){
                entity.collisionEnabled = true;
            }
        }
        if(entity.direction == "left"){
            entityLeftCol =(entityLeftWorldX-entity.speed)/gp.tileSize;
            tileNum1 = gp.tilesM.mapTileNumber[entityLeftCol][entityTopRow];
            tileNum2 = gp.tilesM.mapTileNumber[entityLeftCol][entityBottomRow];
            if(gp.tilesM.tile[tileNum1].collision== true|| gp.tilesM.tile[tileNum2].collision== true){
                entity.collisionEnabled = true;
            }}
        if(entity.direction == "right"){
            entityRightCol =(entityRightWorldX+entity.speed)/gp.tileSize;
            tileNum1 = gp.tilesM.mapTileNumber[entityRightCol][entityTopRow];
            tileNum2 = gp.tilesM.mapTileNumber[entityRightCol][entityBottomRow];
            if(gp.tilesM.tile[tileNum1].collision== true|| gp.tilesM.tile[tileNum2].collision== true){
                entity.collisionEnabled = true;
            }
        }
    }    
    public int checkObject(Entity entity,boolean player) {
        int index = -1;
        for(int i = 0; i <gp.object.length;i++){
            if(gp.object[i] != null){
                entity.solidArea.x = entity.worldX+entity.solidArea.x;  
                entity.solidArea.y = entity.worldY+entity.solidArea.y;
                gp.object[i].solidArea.x= gp.object[i].worldX+ gp.object[i].solidArea.x; 
                gp.object[i].solidArea.y = gp.object[i].worldY+ gp.object[i].solidArea.y;
                switch (entity.direction) {
                    case "up":
                            entity.solidArea.y-=entity.speed;
                            if(entity.solidArea.intersects(gp.object[i].solidArea)){
                                if(gp.object[i].collision==true){
                                    entity.collisionEnabled = true;
                                }
                                if(player==true){
                                    index = i;
                                }
                            }
                           
                        break;
                    case "down":
                    entity.solidArea.y+=entity.speed;
                    if(entity.solidArea.intersects(gp.object[i].solidArea)){
                        if(gp.object[i].collision==true){
                            entity.collisionEnabled = true;
                        }
                        if(player==true){
                            index = i;
                        }
                    }
    
                    if(entity.solidArea.intersects(gp.object[i].solidArea)){
                        
                        if(entity.solidArea.intersects(gp.object[i].solidArea)){
                            if(gp.object[i].collision==true){
                                entity.collisionEnabled = true;
                            }
                            if(player==true){
                                index = i;
                            }
                        }
                    }
                    entity.solidArea.y+=entity.speed;
                    case "left":
                    entity.solidArea.x-=entity.speed;
    
                    if(entity.solidArea.intersects(gp.object[i].solidArea)){
                        if(entity.solidArea.intersects(gp.object[i].solidArea)){
                            if(gp.object[i].collision==true){
                                entity.collisionEnabled = true;
                            }
                            if(player==true){
                                index = i;
                            }
                        }
                    }
                    case "right":
                    entity.solidArea.x+=entity.speed;
    
                    if(entity.solidArea.intersects(gp.object[i].solidArea)){
                        if(entity.solidArea.intersects(gp.object[i].solidArea)){
                            if(gp.object[i].collision==true){
                                entity.collisionEnabled = true;
                            }
                            if(player==true){
                                index = i;
                            }
                        }
                    }
                }
            entity.solidArea.x = entity.solidAreaDefaultX;
            entity.solidArea.y = entity.solidAreaDefaultY;
            gp.object[i].solidArea.x = gp.object[i].solidAreaDefaultX;
            gp.object[i].solidArea.y = gp.object[i].solidAreaDefaultY; 
            }
          
        }

        return index;
    }
}

