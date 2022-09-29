import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Obstacle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Obstacle extends Actor
{
    private boolean isTouching; 
    private String sound; 
    /**
     * Act - do whatever the Obstacle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       Object body = getOneIntersectingObject(Body.class);
       if(body == null && isTouching) { // not touching anymore
        setImage ("block.png");
        isTouching = false;
        }
        if (body!=null && !isTouching) { // touched
         setImage ("block-light.png");
         Greenfoot.playSound (sound);
         isTouching = true; 
        
        }
      
    }  
      public Obstacle(String soundFile)
    
     { 
        sound = soundFile;
      }
    public void setRotation(int rotation) {
        
    }
 
      
      
      
    
}
