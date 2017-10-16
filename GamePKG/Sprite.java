package GamePKG;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class Sprite 
{
	Image image;
	ImageView spriteImageView=new ImageView();
	double pX;
	double pY;
	double width;
	double height;
	
	double speed;
	double dx;
	double dy;
	String direction;
	
	private static boolean InblockedArea;
	
	Rectangle CollisionBox=new Rectangle();
	
	int life=8;
	public Sprite(Pane pane, Image image, double pX, double pY, double width, double height, double speed)
	{
		this.image=image;
		this.spriteImageView.setImage(this.image);
		this.pX=pX;
		this.pY=pY;
		this.width=width;
		this.height=height;
		this.speed=speed;
		this.dx=0;
		this.dy=this.speed*-1;
		direction="DOWN";
		InblockedArea=false;
		spriteImageView.setViewport(new Rectangle2D(0, 0, 100, 100));
		pane.getChildren().add(spriteImageView);
		spriteImageView.setX(pX);
		spriteImageView.setY(pY);
	}	
	public void move(String direction) 
	{
		setDirection(direction);//change dx,dy
		pX+=dx;
		pY+=dy;
    }
	public void updatePosition() 
	{
		spriteImageView.relocate(pX, pY);
    }
	
	public void setPosition(double x,double y)
	{
		pX=x;
		pY=y;
		updatePosition();
	}
	public double getPx()
	{
		return pX;
	}
	public double getPy()
	{
		return pY;
	}
	
	public void setDirection(String direction)
	{
		switch(direction)
		{
			case "UP": this.direction = "UP"; dx=0;dy=-speed;break;
			case "DOWN": this.direction = "DOWN"; dx=0;dy=speed;break;
			case "LEFT": this.direction = "LEFT"; dx=-speed;dy=0;break;
			case "RIGHT": this.direction = "RIGHT"; dx=speed;dy=0;break;
			default: break;
		}
	}
	public boolean getInBlockedArea()
	{
		return InblockedArea;
	}
	
	public static void setInBlockedArea(boolean flag)
	{
		InblockedArea=flag;
	}
	public String getDirection()
	{
		return direction;
	}
	public Image getImage()
	{
		return image;
	}

	public ImageView getImageView()
	{
		return spriteImageView;
	}
	public Rectangle getCollisionBox()
	{
		return CollisionBox;
	}
	public void die(Pane pane)
	{
		pane.getChildren().remove(spriteImageView);
		this.CollisionBox.relocate(0, 0);
	}
	public void getAttacked()
	{
		
	}
}
