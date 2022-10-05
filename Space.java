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
        //randomBodies(4);
        //manualPress();
         
        
        //sunAndPlanet();
        //sunAndTwoPlanets()
        //sunPlanetMoon();
    }
    public void act()
    {
        manualPress();
        mouseClick();
        addingSuper();
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
     * 
     */
    private void mouseClick()
    {
        if(Greenfoot.mouseClicked(null))
        {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            if (mouse.getButton() == 1) 
            // left click, adding planet. 
            {
                int s = 20 + Greenfoot.getRandomNumber(30);
                double m = Greenfoot.getRandomNumber(75)+10;
                double speed = Greenfoot.getRandomNumber(40) / 25;
                int d = Greenfoot.getRandomNumber(360);
                int x = (mouse.getX());
                int y = (mouse.getY());
                int r =  Greenfoot.getRandomNumber(255);
                int g =  Greenfoot.getRandomNumber(255);
                int b =  Greenfoot.getRandomNumber(255);
                addObject (new Body (s, m, new Vector(d, speed), new Color(r, g, b)), x, y);
            }
            Actor body = mouse.getActor();
            if (mouse.getButton() == 3) 
            // right click. 
            {
                if (body != null && (body instanceof Body))
                {
                    removeObject(body);
                }
            }
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
     private void manualPress(){
         
          String key = Greenfoot.getKey(); 
          // getting information from our keys
        if (key == null) return; 
        // null - nothing. so no key is found. 
        int index = "0123456789".indexOf(key);
        // indexOf - returns the first charcter in the string,. but its gonna return a number 
        if (index >= 0)
            randomBodies(index);
           
            // could do this but its too much..smh
        // if(Greenfoot.isKeyDown("1"))
        // { randomBodies(1);
        // }
        // if(Greenfoot.isKeyDown("2"))
        // { randomBodies(2);
        // }
         // if(Greenfoot.isKeyDown("3"))
        // { randomBodies(3);
        // }
        // if(Greenfoot.isKeyDown("4"))
        // { randomBodies(4);
        // }
        // if(Greenfoot.isKeyDown("5"))
        // { randomBodies(5);
        // }
        // if(Greenfoot.isKeyDown("6"))
        // { randomBodies(6);
        // }
        // if(Greenfoot.isKeyDown("7"))
        // { randomBodies(7);
        // }
        // if(Greenfoot.isKeyDown("8"))
        // { randomBodies(8);
        // }
        // if(Greenfoot.isKeyDown("9"))
        // { randomBodies(9);
        // }
        // if (Greenfoot.isKeyDown("0"))
        // {
            // removeObjects (getObjects(Body.class));
        // }
        }
    private void addingSuper(){
        if (Greenfoot.isKeyDown("a"))
        {
                int x = Greenfoot.getRandomNumber(getWidth());
                int y = Greenfoot.getRandomNumber(getHeight());
                addObject(new Ssuperbody(), x, y);
            
        }
         if (Greenfoot.isKeyDown("p"))
        {
            removeObjects (getObjects(Ssuperbody.class));
        }
        }
}