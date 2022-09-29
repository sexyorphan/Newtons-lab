import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ssuperbody here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ssuperbody extends SmoothMover
{
    int x;
    int y;
    /**
     * Act - do whatever the Ssuperbody wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        keyMoves();
        //applyForces(); 
    }
    private void keyMoves(){
        if (Greenfoot.isKeyDown("right")){
            this.getX();
            x = x+5; // moving 5 units to the right
        }
        if(Greenfoot.isKeyDown("left")){
            this.getX();
            x = x-5; // moving 5 units left
        }
        if(Greenfoot.isKeyDown("up")){
             this.getY();
             y = y - 2; // moving 2 unit up
        }
        if (Greenfoot.isKeyDown("down")){
            this.getY();
            y = y+5; // moving 3 units down
        }
        this.setLocation(x,y);
    }
    public void applyForces(){
    
    }
}
