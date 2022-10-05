import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Ssuperbody here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ssuperbody extends SmoothMover
{
    private static final double GRAVITY = 5.8;
    private static final Color defaultColor = new Color(255, 216, 0);
    public double mass = 25;
    private int size = 50;
    int x;
    int y;
    /**
     * Act - do whatever the Ssuperbody wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Ssuperbody() {
     GreenfootImage image = getImage();  
     image.scale(50, 50);
     setImage(image);
    }
    public void act()
    {
        keyMoves();
        applyForces2Super();
        //applyGravity(); 
    }
    private void keyMoves(){
        if (Greenfoot.isKeyDown("right")){
            getX();
            x = x+5; // moving 5 units to the right
        }
        if(Greenfoot.isKeyDown("left")){
            getX();
            x = x-5; // moving 5 units left
        }
        if(Greenfoot.isKeyDown("up")){
             getY();
             y = y - 2; // moving 2 unit up
        }
        if (Greenfoot.isKeyDown("down")){
            getY();
            y = y+5; // moving 3 units down
        }
        this.setLocation(x,y);
    }
    public void applyForces2Super() 
    {
        List<Ssuperbody> superb = getWorld().getObjects(Ssuperbody.class); // creating a list
        // make a list that contain the body class
        //call the list bodies
        //world class to run get object method to 
        
        for (Ssuperbody currentsuper: superb)
        {
            if (currentsuper !=this){
               applyGravity(currentsuper);
            }
            }
        }
    private void applyGravity(Ssuperbody other)
    {
        double dx = other.getExactX() - this.getExactX();
        double dy = other.getExactY() - this.getExactY();
        Vector force = new Vector (dx, dy);
        double distance = Math.sqrt (dx*dx + dy*dy);
        double strength = GRAVITY * this.mass * other.mass / (distance*distance) ;
        double acceleration = strength / this.mass;
        force.setLength (acceleration);
        addForce (force);
    
    }
}
