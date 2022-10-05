
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/** remove a body 
 * A 'Body' is any kind of object in space that has a mass. It could be a star, or a planet, 
 * or anything else that floats around in space.
 * plural vector- degree/direction and then the length of the
 * 
 * @author Michael Kolling 
 * @version 0.1
 */
public class Body extends SmoothMover
{
    // constants
    private static final double GRAVITY = 5.8; //final=  constant. static- only 1 copy for the entire class 
    private static final Color defaultColor = new Color(255, 216, 0);
    
    // fields. also gives the smass
    private double mass;
    private int size; 
    private boolean mouseClicked;
    
    /**
     * Construct a Body with default size, mass, movement and color.
     */
    public Body()// one cnstuctor thats not aksing for anything. have a defult that gives size, mass, vextor, oclour
    {
        this (20, 300, new Vector(0, 1.0), defaultColor);
        
    }
    
    /**
     * Construct a Body with a specified size, mass, movement and color.
     */
    public Body(int size, double mass, Vector movement, Color color)// asking for size ,mass, colour etc. its not strings so order matters
    {
        this.mass = mass; //
        this.size = size;
        addForce(movement);
        GreenfootImage image = new GreenfootImage (size, size);
        image.setColor (color);
        image.fillOval (0, 0, size-1, size-1);
        setImage (image);
    }
    
    /**
     * Act. That is: apply  the gravitation forces from
     * all other bodies around, and then move.
     */
    public void act() 
    {
        move ();
        applyForces();
        bounceAtEdge(); 
    }
    
    /**
     * Return the mass of this body.
     */
    public double getMass()
    {
        return mass;
    }
    public void applyForces() 
    {
        List<Body> listofBodies = getWorld().getObjects(Body.class); // creating a list
        // make a list that contain the body class
        //call the list bodies
        //world class to run get object method to 
        
        for (Body currentBody: listofBodies)
        {
            if (currentBody !=this){
           
               applyGravity(currentBody);
            }
            }
        }
    private void applyGravity(Body other)
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

     private void bounceAtEdge ()
    {
    
        if(getX() ==0 || getX() == getWorld().getWidth()-1){ // = setting. == actual equals is
           setLocation ((double)getX(), (double)getY());
           getMovement().revertHorizontal();
           accelerate (0.9);
           changeColour();
        }
         else if (getY()== 0 || getY() == getWorld().getHeight()-1 ){
         setLocation((double)getX(), (double)getY());
         getMovement().revertVertical();
         accelerate(0.9);
         changeColour();
         }
     }

      private void changeColour()
     
      {
        int r = Greenfoot.getRandomNumber(255); // // to generate random rgb values
        int g = Greenfoot.getRandomNumber(255); 
        int b = Greenfoot.getRandomNumber(255);
        GreenfootImage image = new GreenfootImage (size-1, size-1);
        image.setColor (new Color(r,g,b));
        image.fillOval (0,0,size-1, size-1);
        setImage(image);
         }
       
    }

