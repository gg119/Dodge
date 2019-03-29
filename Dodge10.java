import java.awt.event.KeyEvent;

public class Dodge10
{
  static double x = 0.5;
  static double y = 0.0; 
  static double r = 0.01;
  static double asteroidX = 0.5;
  static double asteroidY = 0.2;
  static double asteroidR = Math.random() * (.03 - .01) + .01;
  static double asteroidX1 = .5;
  static double asteroidY1 = .4;
  static double asteroidR1 = .03;
  static double asteroidX2 = .5;
  static double asteroidY2 = .6;
  static double asteroidR2 = .01;
  static double asteroidX3 = .5;
  static double asteroidY3 = .8;
  static double asteroidR3 = Math.random() * (.03 - .01) + .02;
  static double asteroidSpeed = .008;
  static double asteroidSpeed1 = Math.random() * (.01 - .09) + .01;
  static double asteroidSpeed2 = Math.random() * (.01 - .09) + .01;
  static double asteroidSpeed3 = .09;
  static double halfWidth = .02;
  static double halfHeight = .03;
  static double d = Math.sqrt(Math.pow(x - asteroidX, 2) + (Math.pow(y - asteroidY, 2)));
  

   public static void drawScene()
   { 
      StdDraw.filledCircle(asteroidX, asteroidY, asteroidR);
      StdDraw.filledCircle(asteroidX1, asteroidY1, asteroidR1);
      StdDraw.filledCircle(asteroidX2, asteroidY2, asteroidR2);
      StdDraw.filledCircle(asteroidX3, asteroidY3, asteroidR3);
      StdDraw.rectangle(x, y, halfWidth, halfHeight);
      StdDraw.show(1000 / 24);
   }
      
   public static void userMove()
   {
       if (StdDraw.isKeyPressed(KeyEvent.VK_UP))
      {
         y += .03;
         
      }
      if(StdDraw.isKeyPressed(KeyEvent.VK_DOWN))
      {
         y -= .03;
         
      }
      if(StdDraw.isKeyPressed(KeyEvent.VK_LEFT))
      {
         x -= .03;
         
      }
      if(StdDraw.isKeyPressed(KeyEvent.VK_RIGHT))
      {
         x += .03;
         
      }

   }

  public static void moveAsteroid()
   {
      asteroidX += asteroidSpeed;
     
   }  
   public static void asteroidLimit()
  {
      if(asteroidX + asteroidR >= 1)
      {
         asteroidSpeed *= -1;
         asteroidX = 1 - .01 * 2 - asteroidR;
      }
      
      if(asteroidX - asteroidR <= 0)
      {
         asteroidSpeed *= -1;
         asteroidX = .01 + .01 + asteroidR;
      }
    }
    public static void moveAsteroid1()
   {
      asteroidX1 += asteroidSpeed1;
   }
   public static void asteroidLimit1()
  {
      
      if(asteroidX1 + asteroidR1 >= 1)
      {
         asteroidSpeed1 *= -1;
         asteroidX1 = 1 - .01 * 2 - asteroidR1;
      }
      
      if(asteroidX1 - asteroidR1 <= 0)
      {
         asteroidSpeed1 *= -1;
         asteroidX1 = .01 * 2 + asteroidR1;
      }
    }
    public static void moveAsteroid2()
   {
      asteroidX2 += asteroidSpeed2;
   }
   public static void asteroidLimit2()
  {
      if(asteroidX2 + asteroidR2 >= 1)
      {
         asteroidSpeed2 *= -1;
         asteroidX2 = 1 - .01 * 2 - asteroidR2;
      }
      
      if(asteroidX2 - asteroidR2 <= 0)
      {
         asteroidSpeed2 *= -1;
         asteroidX2 = .01 + .01 + asteroidR2;
      }
    }
  public static void moveAsteroid3()
   {
      asteroidX3 += asteroidSpeed3;
   }
   public static void asteroidLimit3()
  {
      
      if(asteroidX3 + asteroidR3 >= 1)
      {
         asteroidSpeed3 *= -1;
         asteroidX3 = 1 - .01 * 2 - asteroidR3;
      }
      
      if(asteroidX3 - asteroidR3 <= 0)
      {
         asteroidSpeed3 *= -1;
         asteroidX3 = .01 * 2 + asteroidR3;
      }
    }
    public static void userLimit()
   {
      if(y - r <= -0.1)
      {
         y = .04 + r;
      }
      if(x + r >= 1)
      {
         x = 1 - .04 * 2 - r;
      }
      if(x - r <= 0)
      {
         x = .04 + .04 + r;
      }
   }
   public static void showPicture()
      {
         StdDraw.clear();
         StdDraw.picture(x, y, "rocket3.png"); 
      }

 
 public static void main(String[] args)
   {
      while(true)
      {
         StdDraw.clear(StdDraw.BLACK);  
         StdDraw.text(0.5, 0.7, "Welcome to Dodge");
         StdDraw.rectangle(.5, .5, .25, .1);
         StdDraw.setPenColor(StdDraw.WHITE);
         StdDraw.text(.5, .5, "Click to Start Game or Press Enter");
         StdDraw.show(1000/24);
         if (StdDraw.mousePressed() &&
             StdDraw.mouseY() > .2 && StdDraw.mouseY() < .6 &&
             StdDraw.mouseX() > .25 && StdDraw.mouseY() < .75)
             {
               StdDraw.setPenColor(StdDraw.RED);
               break;
             }
             
         if (StdDraw.isKeyPressed(KeyEvent.VK_ENTER))
         {
            StdDraw.setPenColor(StdDraw.BLUE);
            break;   
         }
      }
      while(true)
      {
         Dodge10.showPicture();
         Dodge10.drawScene();
         Dodge10.userMove();
         Dodge10.moveAsteroid();
         Dodge10.asteroidLimit();
         Dodge10.userLimit();
         Dodge10.moveAsteroid1();
         Dodge10.asteroidLimit1();
         Dodge10.moveAsteroid2();
         Dodge10.asteroidLimit2();
         Dodge10.moveAsteroid3();
         Dodge10.asteroidLimit3();
         
       if (y + r >= 1.1)
      {
        StdDraw.clear(StdDraw.BLACK);
        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.text(.5, .5, "You Win !!!!!!!!");
        StdAudio.play("Street_Fighter_II-You_Win_Perfect.wav"); 
        StdDraw.show(1000 / 24);
         break;
      }
      
    }
  }
}
 