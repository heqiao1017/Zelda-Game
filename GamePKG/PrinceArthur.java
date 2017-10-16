package GamePKG;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class PrinceArthur extends Sprite
{
	int offsetX=0;
	int offsetY=0;
	private SpriteAnimation walkingAnimation;
	private SpriteAnimation touchEnemyAnimation = new SpriteAnimation(super.spriteImageView, Duration.millis(500),15,15,0,0,width,height);
	
	private int attackDistance=50;
	private Rectangle playerCollisionBox=new Rectangle();
	private Rectangle attackBoxUp = new Rectangle(getPx(), getPy() - attackDistance, width, attackDistance);
	private Rectangle attackBoxDown = new Rectangle(getPx(), getPy() + height, width, attackDistance);
	private Rectangle attackBoxLeft = new Rectangle(getPx() - attackDistance,getPy(),attackDistance, height);
	private Rectangle attackBoxRight = new Rectangle(getPx() + attackDistance , getPy(), attackDistance, height);
	
	private Image holdImage;
	
	Rectangle border1=new Rectangle(0,997,1900,0);
	Rectangle border2=new Rectangle(0,100,1900,0);
	Rectangle border3=new Rectangle(0,0,0,998);
	Rectangle border4=new Rectangle(1900,0,0,998);
	
	public PrinceArthur(Pane pane, Image image, double pX, double pY, double width, double height, double speed) {
		super(pane, image, pX, pY, width, height, speed);
		// TODO Auto-generated constructor stub
		holdImage=super.getImage();
		playerCollisionBox.setFill(Color.TRANSPARENT);
		playerCollisionBox.setWidth(super.width-40);
		playerCollisionBox.setHeight(super.height-15);
		
		attackBoxUp.setFill(Color.TRANSPARENT);
		attackBoxDown.setFill(Color.TRANSPARENT);
		attackBoxLeft.setFill(Color.TRANSPARENT);
		attackBoxRight.setFill(Color.TRANSPARENT);
		
		pane.getChildren().addAll(playerCollisionBox,attackBoxUp,attackBoxDown,attackBoxLeft,attackBoxRight);
		this.updatePosition();
		
	}
	public Rectangle getCollisionBox()
	{
		return playerCollisionBox;
	}
	public void updatePosition()
	{
		super.updatePosition();
		
		playerCollisionBox.setX(pX+20);
		attackBoxUp.setX(pX);
		attackBoxDown.setX(pX);
		attackBoxLeft.setX(pX - attackDistance);
		attackBoxRight.setX(pX + width);
		
		playerCollisionBox.setY(pY+10);
		attackBoxUp.setY(pY-attackDistance);
		attackBoxDown.setY(pY+height);
		attackBoxLeft.setY(pY);
		attackBoxRight.setY(pY);	
	}
	
	public void RandomMove()
	{
		spriteImageView.setImage(holdImage);
		setInBlockedArea(false);
		dx=(-1+(int)(Math.random()*3))*30;
		if(dx==0)
		{
			dy=(-1+(int)(Math.random()*3))*30;
		}
		else
		{
			dy=0;
		}
		playerCollisionBox.setX(super.getPx()+20+dx);
		playerCollisionBox.setY(super.getPy()+dy);
		checkWallCollision(playerCollisionBox);
		if(getInBlockedArea()==false)
		{
			pX+=dx;
			pY+=dy;
			updatePosition();			
		}		
		if(dx<0 && dy==0)
		{
			super.setDirection("LEFT");
			walkingAnimation=new SpriteAnimation(spriteImageView,Duration.millis(500),4,4,0,200,width,height);
			walkingAnimation.play();
			//spriteImageView.setViewport(new Rectangle2D(0, 200, width, height));
		}
		else if(dx>0 && dy==0)
		{
			super.setDirection("RIGHT");
			walkingAnimation=new SpriteAnimation(spriteImageView,Duration.millis(500),4,4,0,100,width,height);
			walkingAnimation.play();
			//spriteImageView.setViewport(new Rectangle2D(0, 100, width, height));
		}
		else if(dy>0 && dx==0)
		{
			super.setDirection("DOWN");
			walkingAnimation=new SpriteAnimation(spriteImageView,Duration.millis(500),4,4,0,0,width,height);
			walkingAnimation.play();
			//spriteImageView.setViewport(new Rectangle2D(0, 0, width, height));
		}
		else if(dy<0 && dx==0)
		{
			super.setDirection("UP");
			walkingAnimation=new SpriteAnimation(spriteImageView,Duration.millis(500),4,4,0,300,width,height);
			walkingAnimation.play();
			//spriteImageView.setViewport(new Rectangle2D(0, 300, width, height));
		}
	}
	

	public void checkWallCollision(Rectangle LinkCollisionBox)
	{
		int size3=Room.wallRecList3.size();
		for(int i=0;i<size3;i++)
		{
			if ((Room.wallRecList3.get(i).getBoundsInParent().intersects(LinkCollisionBox.getBoundsInParent())))
			{
				Sprite.setInBlockedArea(true);
			}
		}
		if(border1.getBoundsInParent().intersects(LinkCollisionBox.getBoundsInParent())||
				border2.getBoundsInParent().intersects(LinkCollisionBox.getBoundsInParent())
				||border3.getBoundsInParent().intersects(LinkCollisionBox.getBoundsInParent())
				||border4.getBoundsInParent().intersects(LinkCollisionBox.getBoundsInParent()))
		{
			Sprite.setInBlockedArea(true);
		}
	}
	public void Attack()
	{
		spriteImageView.setImage(new Image("image/prince_attack.png"));
		System.out.print(super.getDirection());
		switch(super.getDirection())
		{
			case "UP": 	spriteImageView.setViewport(new Rectangle2D(300, 0, width, height)); break;
				//attackingAnimation=new SpriteAnimation(spriteImageView,Duration.millis(500),2,2,offsetX+300,offsetY,100,100);
			case "DOWN": spriteImageView.setViewport(new Rectangle2D(0, 0, width, height)); break;
				//attackingAnimation=new SpriteAnimation(spriteImageView,Duration.millis(500),2,2,offsetX,offsetY,100,100);
			case "LEFT": spriteImageView.setViewport(new Rectangle2D(100, 0, width, height)); break;
				//attackingAnimation=new SpriteAnimation(spriteImageView,Duration.millis(500),2,2,100,offsetY,100,100);
			case "RIGHT": spriteImageView.setViewport(new Rectangle2D(200, 0, width, height)); break;
				//attackingAnimation=new SpriteAnimation(spriteImageView,Duration.millis(500),2,2,200,offsetY,100,100);
		}	
	}
	public boolean EnemyInAttackDistance(Rectangle EnemyCollisionBox)
	{
		switch(getDirection())
		{
			case "UP": 
				if(EnemyCollisionBox.getBoundsInParent().intersects(attackBoxUp.getBoundsInParent()))
				{
					return true;
				}
				break;
			case "DOWN": 
				if(EnemyCollisionBox.getBoundsInParent().intersects(attackBoxDown.getBoundsInParent()))
				{
					return true;
				}
				break;
			case "LEFT":
				if(EnemyCollisionBox.getBoundsInParent().intersects(attackBoxLeft.getBoundsInParent()))
				{
					return true;
				}
				break;
			case "RIGHT": 
				if(EnemyCollisionBox.getBoundsInParent().intersects(attackBoxRight.getBoundsInParent()))
				{
					return true;
				}
				break;
		}
		return false;
	}
	public void getAttacked()
	{
		touchEnemyAnimation.setCycleCount(1);			
		touchEnemyAnimation.setOnFinished( e ->
		{
			switch(getDirection())
			{
				case "UP": 
					spriteImageView.setViewport(new Rectangle2D(0, 300, width, height));
					break;
				case "DOWN": 
					spriteImageView.setViewport(new Rectangle2D(0, 0, width, height));
					break;
				case "LEFT": 
					spriteImageView.setViewport(new Rectangle2D(0,200, width, height));
					break;
				case "RIGHT": 
					spriteImageView.setViewport(new Rectangle2D(0, 100, height, height));
					break;
				default:break;
			}
		});
		touchEnemyAnimation.play();
	}

}
