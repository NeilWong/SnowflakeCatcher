SnowFlake [] snow;
void setup()
{
 size(530,530); 
 background(0);
  snow = new SnowFlake[53];
  for (int i = 0; i<snow.length;i++)
  {
    snow[i] = new SnowFlake();
  }
}
void draw()
{
  
  for (int i = 0; i <snow.length; i++)
  {
    snow[i].move();
    snow[i].show();
    snow[i].wrap();
    snow[i].erase();
  }
}
void mouseDragged()
{
   noStroke();
   fill(255,255,255);
   ellipse(pmouseX,pmouseY,20,20);
}
void mousePressed()
   {
      noStroke();
      fill(0);
      ellipse(pmouseX,pmouseY,700,700);
   }
class SnowFlake
{
  
  int x; int y; int siz; boolean isMoving;
  {
    // classmember variable initializations
    x = (int)(Math.random()*530) ;
    y = (int)(Math.random()*500) ;
    siz = (int)(Math.random()*3)+3;
    isMoving = false;
  }
  void show()
  {
    int outline = (int)(Math.random()*255);
    int siz1=siz;
    for (int i =0; i<snow.length; i++)
    {
      stroke(outline,outline,outline);
      fill(255,255,255);
      ellipse(x,y,siz,siz1);
    }
  }
  void erase()
  {
    fill(0);
    noStroke();
    ellipse(x,y-4,6,6);
  }
  void move()
  {
    if(y<580)
    {
      y+=2.5;
    }
    if (get(x,y+3) != color(0))
    {
      y=y-y;
    }
  }
  void wrap()
  //char dot = point(x,y+8);
  {
    if(y>530)
    {
      y=(int)(Math.random()*-20)+7;
      x=(int)(Math.random()*530);
    }  }
}
