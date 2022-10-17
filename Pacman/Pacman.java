import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pacman here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pacman extends Actor
{
    int speed = 2;
    int length;
    Level myWorld;
    
    public Pacman(){
        GreenfootImage myImage = getImage();
        //int myNewHeight = myImage.getHeight()/6;
        //int myNewWidth = myImage.getWidth()/6;
        myImage.scale(80, 80);

        length = getImage().getWidth();
    }
    
    public void addedToWorld(World w){
        myWorld = (Level)w;
    }
    
    public void eatTarget(){
        Actor t1 = getOneIntersectingObject(Pill.class);
        if(t1!=null){
            myWorld. removeObject(t1);
            myWorld.addScore(1);
        }
        Actor t2 = getOneIntersectingObject(Orange.class);
        if(t2!=null){
            myWorld. removeObject(t2);
            myWorld.addScore(10);
        }
        Actor t3 = getOneIntersectingObject(Sandia.class);
        if(t3!=null){
            myWorld. removeObject(t3);
            myWorld.addScore(15);
        }
        Actor t4 = getOneIntersectingObject(Cosa.class);
        if(t4!=null){
            myWorld. removeObject(t4);
            myWorld.addScore(100);
        }
    }

    public void act()
    {
        if(Greenfoot.isKeyDown("up")){
            setRotation(270);
            movePlayer();
         } else if(Greenfoot.isKeyDown("down")){
            setRotation(90);
            movePlayer();
         } else if(Greenfoot.isKeyDown("left")){
            setRotation(180);
            movePlayer();
         } else if(Greenfoot.isKeyDown("right")){
            setRotation(0);
            movePlayer();
         }
         eatTarget();
    }
    
    public void movePlayer(){
        int currentX = getX();
        int currentY = getY();
        int direction = getRotation();
        int changeX = getChangeX(direction);
        int changeY = getChangeY(direction);
        //setLocation(currentX + changeX, currentY + changeY);
        
        //Reconocimiento de obstaculos
        int adjustedChangeX = adjustOffset(changeX);
        int adjustedChangeY = adjustOffset(changeY);
        Actor wall = getOneObjectAtOffset(adjustedChangeX, adjustedChangeY, Wall.class);
        if(wall == null){
            setLocation(currentX + changeX,currentY + changeY);
        }
    }
    
    private int adjustOffset(int offset){
        int signOfOffset = (int)Math.signum(offset);
        int distanceToFront = length/6;
        int adjustAmount = distanceToFront * signOfOffset;
        return offset + adjustAmount;
    }
    
    private int getChangeX(int direction){
        if(direction == 0){
             return speed;
         }
        if(direction == 180){
             return -speed;
        }
         return 0;
    }
    
    private int getChangeY(int direction){
        if(direction == 90){
             return speed;
         }
        if(direction == 270){
             return -speed;
        }
         return 0;
    }

}
