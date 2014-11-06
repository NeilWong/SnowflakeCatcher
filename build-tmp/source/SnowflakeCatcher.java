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

public class SnowflakeCatcher extends PApplet {

SnowFlake [] snow;
public void setup()
{
 size(530,530); 
 background(0);
  snow = new SnowFlake[53];
  for (int i = 0; i<snow.length;i++)
  {
    snow[i] = new SnowFlake();
  }
}
public void draw()
{
  //your code here
  for (int i = 0; i <snow.length; i++)
  {
    snow[i].move();
    snow[i].show();
    snow[i].wrap();
    snow[i].erase();
  }
}
public void mouseDragged()
{
   noStroke();
   fill(255,255,255);
   ellipse(pmouseX,pmouseY,20,20);
}
public void mousePressed()
   {
      noStroke();
      fill(0);
      ellipse(pmouseX,pmouseY,700,700);
   }
class SnowFlake
{
  //class member variable declarations
  int x; int y; int siz; boolean isMoving;
  {
    // classmember variable initializations
    x = (int)(Math.random()*530) ;
    y = (int)(Math.random()*500) ;
    siz = (int)(Math.random()*3)+3;
    isMoving = false;
  }
  public void show()
  {
    int outline = (int)(Math.random()*255);
    int siz1=siz;
    for (int i =0; i<snow.length; i++)
    {
      stroke(outline,outline,outline);
      fill(255,255,255);
      ellipse(x,y,siz,siz1);
    }
   // fill(255,0,0);
    //point(x,y);
  }
  public void erase()
  {
    fill(0);
    noStroke();
    ellipse(x,y-4.5f,6,6);
  }
  public void move()
  {
    if(y<580)
    {
      y+=2.5f;
    }
    if (get(x,y+3) != color(0))
    {
      y=y-y;
    }
  }
  public void wrap()
  //char dot = point(x,y+8);
  {
    if(y>530)
    {
      y=(int)(Math.random()*-20)+7;
      x=(int)(Math.random()*530);
    }  }
}


  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SnowflakeCatcher" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
