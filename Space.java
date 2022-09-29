import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/** add a body with mouse click 
 * 
 * 
 * Space. The final frontier. 
 * 
 * @author Michael Kolling
 * @version 1.0
 */
public class Space extends World
{

    private String [] objectSound = // [] create an array
   {"2a", "2b", "2c", "2d", "2e", "2f", "2g","3c","3d","3e","3f","3g","3a","3b","4c"}; 
   private String type = ".wav";
    
   
    /**
     * Create space.
     */
    public Space()
    {    
        super(960, 620, 1);
        
        addObstacle();
        randomBodies(4);
        //manualPress();
        //mouseKlick(); 
        
        //sunAndPlanet();
        //sunAndTwoPlanets()
        //sunPlanetMoon();
    }
    
    /**
     * Set up the universe with a sun and a planet.
     */
    public void sunAndPlanet()
    {
        removeAllObjects(); //private class at the bottom 
        addObject (new Body (50, 240.0, new Vector(270, 0.03), new Color(255, 216, 0)), 460, 270); // rgb value
        addObject (new Body (20, 4.2, new Vector(90, 2.2), new Color(0, 124, 196)), 695, 260);
    }
    
    /**
     * Set up the universe with a sun and two planets.
     */
    public void sunAndTwoPlanets()
    {
        removeAllObjects();
        addObject (new Body (50, 240.0, new Vector(270, 0.0), new Color(255, 216, 0)), 460, 310);
        addObject (new Body (20, 4.2, new Vector(90, 2.2), new Color(0, 124, 196)), 695, 300);
        addObject (new Body (24, 4.6, new Vector(270, 1.8), new Color(248, 160, 86)), 180, 290);
    }

    /**
     * Set up the universe with a sun, a planet, and a moon.
     */
    public void sunPlanetMoon()
    {
        removeAllObjects();
        addObject (new Body (50, 240.0, new Vector(270, 0.0), new Color(255, 216, 0)), 460, 270); //corrispond to the constructor
        addObject (new Body (20, 4.2, new Vector(90, 2.2), new Color(0, 124, 196)), 720, 260);
        addObject (new Body (5, 0.8, new Vector(90, 3.25), new Color(240, 220, 96)), 748, 260);
    } 
    public void addObstacle()
    {
        for (int i = 0; i < objectSound.length; i++)
        
        {
         // addObject ( new Obstacle(), 60 +(i*77),350 ); // middle row
         addObject (new Obstacle(objectSound [i] + type ), 57+ (i*60),650 ); // bottom row 
         addObject (new Obstacle(objectSound [i] + type), 57+(i*60),2 ); // top row 
         addObject (new Obstacle(objectSound [i] + type), 950, (i*44) );  // right c
         addObject (new Obstacle(objectSound [i] + type), 5, (i*44));  /// left 
        }
    }
     
    public void randomBodies(int number) 
    {
    
             removeObjects(getObjects(Body.class)) ;
             
             for ( int i =0 ; i < number; i++) 
             {
              int s = 20 + Greenfoot.getRandomNumber(30);
              double m = s * Greenfoot.getRandomNumber(20);
              int d = Greenfoot.getRandomNumber(360);
              double speed = Greenfoot.getRandomNumber(150) / 100.0;
              int x = Greenfoot.getRandomNumber(getWidth()); 
              int y = Greenfoot.getRandomNumber(getHeight());
              int r =  Greenfoot.getRandomNumber(255);
              int g =  Greenfoot.getRandomNumber(255);
              int b =  Greenfoot.getRandomNumber(255);
              addObject (new Body (s, m, new Vector(d, speed), new Color(r, g, b)), x, y);
             }
    
         }
      /**
     * Remove all objects currently in the world.
     */
    private void removeAllObjects()
    {
        removeObjects (getObjects(Actor.class)); 
        //get object from the actors and then remove them
        // getObjects is a method of the world clas
    }   
     // public void manualPress(){
        //if(Greenfoot.isKeyDown("0")){
        //}
     // }
    // public void mouseKlick(){ 
        // MouseInfo mouse = Greenfoot.getMouseInfo();
        // if (mouse !=null){
        // int x =mouse.getX();
        // int y = mouse.getY();
         // addObject(new Body(s, m, new Vector(d,s),new Color(rgb)),x,y);
        // }
    // }
}