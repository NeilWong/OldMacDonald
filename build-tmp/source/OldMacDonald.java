import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class OldMacDonald extends PApplet {

//your variable declarations here
public void setup()
{
	background(0);
	/*Cow c = new Cow("cow", "moo");   
    System.out.println("The " + c.getType() + " goes " + c.getSound());  */
	Farm f = new Farm();
	f.animalSounds();

}
interface Animal
	{
		public String getSound();
		public String getType();
	}
//declare classes and the interface below
class Cow implements Animal 
{     
  protected String myType;     
  protected String mySound;      
  public Cow(String type, String sound)    
  {         
     myType = type;         
     mySound = sound;     
  }     
  public Cow()    
  {         
     myType = "cow";         
     mySound = "moo";     
  }      
  public String getSound(){return mySound;}     
  public String getType(){return myType;} 
}
  class NamedCow extends Cow
  {
  	private String myType;
  	private String mySound;
  	private String myName;
	public NamedCow(String type, String sound, String name)
  	{
  		String myName = name;
  	}
  	public NamedCow()
  	{
  		myName = "Elsie!";
  	}
  	public String getName(){return "Elsie!";}
  }


class Pig implements Animal
{
	private String myType;
	private String mySound;
	public Pig(String type, String sound)
	{
		myType = type;
		mySound = sound;
	}
	public Pig()
	{
		myType = "Pig";
		mySound = "Oink!";
	}
	public String getSound()
	{
		return mySound;
	}
	public String getType()
	{
		return myType;
	}
}
class Chick implements Animal
{
	private String myType;
	private String mySound;
	private String mySound2;
	public Chick(String type, String sound, String sound2)
	{
		myType = type;
		mySound = sound;
		mySound2 = sound2;
	}
	public Chick()
	{
		myType = "Chick";
		mySound = "Chirp!";
		mySound2 = "Cheep!";
	}
	public String getSound()
	{
		int x = (int)(Math.random()*3);
		if(x <= 1)
		{
		return mySound;
		}
		else 
		{
		return mySound2;
		}
	}
	public String getType()
	{
		return myType;
	}
}
class Farm 
{     
  private Animal[] aBunchOfAnimals = new Animal[3];    
  public Farm()    
  {       
   aBunchOfAnimals[0] = new NamedCow("cow","moo!","Elsie");          
   aBunchOfAnimals[1] = new Chick("chick","cheep","cluck");
   aBunchOfAnimals[2] = new Pig("pig","oink");    
  }     
  public void animalSounds()    
  {
    for (int nI=0; nI < aBunchOfAnimals.length; nI++) 
    {             
       System.out.println("The " + aBunchOfAnimals[nI].getType() + " goes " + aBunchOfAnimals[nI].getSound() );       
    }       
    System.out.println( "The cow is known as " + ((NamedCow)aBunchOfAnimals[0]).getName() );    
  } 
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "OldMacDonald" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
