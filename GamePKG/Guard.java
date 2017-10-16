package GamePKG;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Guard extends Sprite
{
	private boolean isCollision=false;
	private Rectangle guardCollisionBox=new Rectangle();	
	private SpriteAnimation walkingAnimation;
	Rectangle border1=new Rectangle(0,997,1900,0);
	Rectangle border2=new Rectangle(0,0,600,600);
	public Guard(Pane pane, Image image, double pX, double pY, double width, double height, double speed) {
		super(pane, image, pX, pY, width, height, speed);
		// TODO Auto-generated constructor stub
		guardCollisionBox.setFill(Color.TRANSPARENT);
		guardCollisionBox.setWidth(width-40);
		guardCollisionBox.setHeight(height);
		guardCollisionBox.setX(pX);
		guardCollisionBox.setY(pY);
		pane.getChildren().add(guardCollisionBox);
	}
	public void RandomMove(Rectangle linkBox, Sandwich[] sandwich,Guard[] guards, int index)
	{
		this.setCollision(false);
		dx=(-1+(int)(Math.random()*3))*15;
		dy=(-1+(int)(Math.random()*3))*15;
		guardCollisionBox.setX(super.getPx()+20+dx);
		guardCollisionBox.setY(super.getPy()+dy);
		for(int i=0;i<sandwich.length;i++)
		{
			checkCollision(guardCollisionBox,linkBox,sandwich[i].getCollisionBox());
		}

		for(int i=0;i<guards.length;i++)
		{
			if(i==index)
			{
				continue;
			}
			checkCollisonBetweenEnemies(guardCollisionBox,guards[i].getCollisionBox());
		}
		if(!isCollision)
		{
			pX+=dx;
			pY+=dy;
			updatePosition();			
		}		
		if(dx<0)
		{
			walkingAnimation=new SpriteAnimation(spriteImageView,Duration.millis(500),4,4,0,200,width,height);
			walkingAnimation.play();
			//spriteImageView.setViewport(new Rectangle2D(0, 200, width, height));
		}
		else if(dx>0)
		{
			walkingAnimation=new SpriteAnimation(spriteImageView,Duration.millis(500),4,4,0,100,width,height);
			walkingAnimation.play();
			//spriteImageView.setViewport(new Rectangle2D(0, 100, width, height));
		}
		else if(dy>0)
		{
			walkingAnimation=new SpriteAnimation(spriteImageView,Duration.millis(500),4,4,0,0,width,height);
			walkingAnimation.play();
			//spriteImageView.setViewport(new Rectangle2D(0, 0, width, height));
		}
		else if(dy<0)
		{
			walkingAnimation=new SpriteAnimation(spriteImageView,Duration.millis(500),4,4,0,300,width,height);
			walkingAnimation.play();
			//spriteImageView.setViewport(new Rectangle2D(0, 300, width, height));
		}
				
	}
	public Rectangle getCollisionBox()
	{
		return guardCollisionBox;
	}
	public void setCollision(boolean isCollision) {
		this.isCollision = isCollision;
	}
	public void checkCollision(Rectangle EnemyCollisionBox, Rectangle LinkCollisionBox,Rectangle sandwichBox)
	{
		int size2=Room.wallRecList2.size();
		for(int i=0;i<size2;i++)
		{
			if ((Room.wallRecList2.get(i).getBoundsInParent().intersects(EnemyCollisionBox.getBoundsInParent())))
			{
				this.setCollision(true);
			}
		}
		if(border1.getBoundsInParent().intersects(EnemyCollisionBox.getBoundsInParent())
				||border2.getBoundsInParent().intersects(EnemyCollisionBox.getBoundsInParent())
				||LinkCollisionBox.getBoundsInParent().intersects(EnemyCollisionBox.getBoundsInParent())
				||sandwichBox.getBoundsInParent().intersects(EnemyCollisionBox.getBoundsInParent()))
		{
			this.setCollision(true);
		}			
	}
	public void checkCollisonBetweenEnemies(Rectangle EnemyCollisionBox1,Rectangle EnemyCollisionBox2)
	{
		if (EnemyCollisionBox1.getBoundsInParent().intersects(EnemyCollisionBox2.getBoundsInParent()))
		{
			this.setCollision(true);
		}
	}
	public void die(Pane pane)
	{
		pane.getChildren().remove(spriteImageView);
		this.guardCollisionBox.relocate(0, 0);
	}

}
