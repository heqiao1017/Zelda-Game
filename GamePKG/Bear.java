package GamePKG;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Bear extends Sprite
{
	private boolean isCollision=false;
	private Rectangle BearCollisionBox=new Rectangle();	
	private SpriteAnimation walkingAnimation;// = new SpriteAnimation(spriteImageView, Duration.millis(500),3,3,0,0,width,height);
	
	Rectangle border1=new Rectangle(0,997,1900,0);
	Rectangle border2=new Rectangle(0,100,1900,0);
	public Bear(Pane pane, Image image, double pX, double pY, double width, double height, double speed) {
		super(pane, image, pX, pY, width, height, speed);
		// TODO Auto-generated constructor stub
		BearCollisionBox.setFill(Color.TRANSPARENT);
		BearCollisionBox.setWidth(width-40);
		BearCollisionBox.setHeight(height);
		BearCollisionBox.setX(pX);
		BearCollisionBox.setY(pY);
		pane.getChildren().add(BearCollisionBox);
	}
	public void RandomMove(Rectangle linkBox, Meat[] meat,Bear[] bears, int index)
	{
		this.setCollision(false);
		dx=(-1+(int)(Math.random()*3))*15;
		dy=(-1+(int)(Math.random()*3))*15;
		BearCollisionBox.setX(super.getPx()+20+dx);
		BearCollisionBox.setY(super.getPy()+dy);
		for(int i=0;i<meat.length;i++)
		{
			checkCollision(BearCollisionBox,linkBox,meat[i].getCollisionBox());
		}
		
		for(int i=0;i<bears.length;i++)
		{
			if(i==index)
			{
				continue;
			}
			checkCollisonBetweenEnemies(BearCollisionBox,bears[i].getCollisionBox());
		}
		if(!isCollision)
		{
			pX+=dx;
			pY+=dy;
			updatePosition();			
		}		
		if(dx<0)
		{
			walkingAnimation=new SpriteAnimation(spriteImageView,Duration.millis(500),3,4,0,200,width,height);
			walkingAnimation.play();
			//spriteImageView.setViewport(new Rectangle2D(0, 200, width, height));
		}
		else if(dx>0)
		{
			walkingAnimation=new SpriteAnimation(spriteImageView,Duration.millis(500),3,4,0,100,width,height);
			walkingAnimation.play();
			//spriteImageView.setViewport(new Rectangle2D(0, 100, width, height));
		}
		else if(dy>0)
		{
			walkingAnimation=new SpriteAnimation(spriteImageView,Duration.millis(500),3,4,0,0,width,height);
			walkingAnimation.play();
			//spriteImageView.setViewport(new Rectangle2D(0, 0, width, height));
		}
		else if(dy<0)
		{
			walkingAnimation=new SpriteAnimation(spriteImageView,Duration.millis(500),3,4,0,300,width,height);
			walkingAnimation.play();
			//spriteImageView.setViewport(new Rectangle2D(0, 300, width, height));
		}
				
	}
	public Rectangle getCollisionBox()
	{
		return BearCollisionBox;
	}
	public void setCollision(boolean isCollision) {
		this.isCollision = isCollision;
	}
	public void checkCollision(Rectangle EnemyCollisionBox, Rectangle LinkCollisionBox, Rectangle meatBox)
	{
		int size1=Room.wallRecList1.size();
		for(int i=0;i<size1;i++)
		{
			if ((Room.wallRecList1.get(i).getBoundsInParent().intersects(EnemyCollisionBox.getBoundsInParent())))
			{
				this.setCollision(true);
			}
		}
		if(border1.getBoundsInParent().intersects(EnemyCollisionBox.getBoundsInParent())||
				border2.getBoundsInParent().intersects(EnemyCollisionBox.getBoundsInParent())
				||LinkCollisionBox.getBoundsInParent().intersects(EnemyCollisionBox.getBoundsInParent())
				||meatBox.getBoundsInParent().intersects(EnemyCollisionBox.getBoundsInParent()))
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
		this.BearCollisionBox.relocate(0, 0);
	}
}
