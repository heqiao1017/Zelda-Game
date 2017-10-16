package GamePKG;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Player extends Sprite
{
	double life=3;
	ImageView heartContainer;
	boolean lifeChanged=false;
	boolean die=false;
	int count=4;
	int column=4;
	int offsetX=0;
	int offsetY=0;
	
	/**
	 * 
	 */
	private int waitingFrames = 0;
	private int framesToWait = 10;
	boolean action = true;
	
	
	private SpriteAnimation walkingAnimation;
	private SpriteAnimation touchEnemyAnimation = new SpriteAnimation(super.spriteImageView, Duration.millis(500),15,15,0,0,width,height);
	
	private int attackDistance=40;
	private Rectangle playerCollisionBox=new Rectangle();
	private Rectangle attackBoxUp = new Rectangle(getPx(), getPy() - attackDistance, width, attackDistance);
	private Rectangle attackBoxDown = new Rectangle(getPx(), getPy() + height, width, attackDistance);
	private Rectangle attackBoxLeft = new Rectangle(getPx() - attackDistance,getPy(),attackDistance, height);
	private Rectangle attackBoxRight = new Rectangle(getPx() + attackDistance , getPy(), attackDistance, height);

	int room=1;
	
	Image holdImage;
	//String direction;
	public Player(Pane pane, Image image, double pX, double pY, double width, double height, double speed) 
	{
		super(pane, image, pX, pY, width, height, speed);
		// TODO Auto-generated constructor stub
		holdImage=super.getImage();
		playerCollisionBox.setFill(Color.TRANSPARENT);
		playerCollisionBox.setWidth(super.width-50);
		playerCollisionBox.setHeight(super.height-35);
		
		attackBoxUp.setFill(Color.TRANSPARENT);
		attackBoxDown.setFill(Color.TRANSPARENT);
		attackBoxLeft.setFill(Color.TRANSPARENT);
		attackBoxRight.setFill(Color.TRANSPARENT);
		
		pane.getChildren().addAll(playerCollisionBox,attackBoxUp,attackBoxDown,attackBoxLeft,attackBoxRight);
		this.updatePosition();
	}
	
	public void updatePosition()
	{
		super.updatePosition();
		
		playerCollisionBox.setX(pX+25);
		attackBoxUp.setX(pX);
		attackBoxDown.setX(pX);
		attackBoxLeft.setX(pX - attackDistance);
		attackBoxRight.setX(pX + width);
		
		playerCollisionBox.setY(pY+18);
		attackBoxUp.setY(pY-attackDistance);
		attackBoxDown.setY(pY+height);
		attackBoxLeft.setY(pY);
		attackBoxRight.setY(pY);	
	}
	
	public void setRoom(int roomNum)
	{
		room=roomNum;
	}
	
	public void move(String direction,Sprite[] enemies)
	{
		//direction=super.getDirection();
//		spriteImageView.setImage(holdImage);
//		switch(direction)
//		{
//		case "UP":
//			spriteImageView.setViewport(new Rectangle2D(300, 0, 100, 100));
//			break;
//		case "DOWN":
//			spriteImageView.setViewport(new Rectangle2D(0, 0, 100, 100));
//			break;
//		case "LEFT":
//			spriteImageView.setViewport(new Rectangle2D(100, 0, 100, 100));
//			break;
//		case "RIGHT":
//			spriteImageView.setViewport(new Rectangle2D(200, 0, 100, 100));
//			break;
//		}
		
		setInBlockedArea(false);

		Room.checkWallCollision(playerCollisionBox);
		for(int i=0;i<enemies.length;i++)
		{
			checkEnemyCollision(enemies[i].getCollisionBox(),playerCollisionBox);
		}
		if(getInBlockedArea()==false)
		{
			super.move(direction);					
		}
		else
		{
			pX-=dx;
			pY-=dy;					
		}
		this.updatePosition();
		switch(getDirection())
		{
			case "UP":				
				walkingAnimation=new SpriteAnimation(spriteImageView,Duration.millis(500),count,column,offsetX,offsetY+300,width,height);
				break;
			case "DOWN":
				walkingAnimation=new SpriteAnimation(spriteImageView,Duration.millis(500),count,column,offsetX,offsetY,width,height);
				break;
			case "LEFT":
				walkingAnimation=new SpriteAnimation(spriteImageView,Duration.millis(500),count,column,offsetX,offsetY+100,width,height);
				break;
			case "RIGHT":
				walkingAnimation=new SpriteAnimation(spriteImageView,Duration.millis(500),count,column,offsetX,offsetY+200,width,height);
				break;
			default: break;
		}
		walkingAnimation.play();
	}
	
	public void checkWallCollision(Rectangle LinkCollisionBox)
	{
		switch(room)
		{
		case 1:
			int size1=Room.wallRecList1.size();
			for(int i=0;i<size1;i++)
			{
				if ((Room.wallRecList1.get(i).getBoundsInParent().intersects(LinkCollisionBox.getBoundsInParent())))
				{
					Sprite.setInBlockedArea(true);
				}
			}
			break;
		case 2:
			int size2=Room.wallRecList2.size();
			for(int i=0;i<size2;i++)
			{
				if ((Room.wallRecList2.get(i).getBoundsInParent().intersects(LinkCollisionBox.getBoundsInParent())))
				{
					Sprite.setInBlockedArea(true);
				}
			}
			break;
		case 3:
			int size3=Room.wallRecList3.size();
			for(int i=0;i<size3;i++)
			{
				if ((Room.wallRecList3.get(i).getBoundsInParent().intersects(LinkCollisionBox.getBoundsInParent())))
				{
					Sprite.setInBlockedArea(true);
				}
			}
			break;
		default: break;
		}
	}
	
	public void checkEnemyCollision(Rectangle EnemyCollisionBox,Rectangle playerCollisionBox)
	{
		if (EnemyCollisionBox.getBoundsInParent().intersects(playerCollisionBox.getBoundsInParent()))
		{
			if(life>0)
			{
				life-=0.5;
				System.out.println(life);
				lifeChanged=true;
			}			
			Sprite.setInBlockedArea(true);
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
						spriteImageView.setViewport(new Rectangle2D(0, 100, width, height));
						break;
					case "RIGHT": 
						spriteImageView.setViewport(new Rectangle2D(0, 200, height, height));
						break;
					default:break;
				}
			});
			touchEnemyAnimation.play();
		}
	}
	
	public Rectangle getCollisionBox()
	{
		return playerCollisionBox;
	}
	
	public void Attack()
	{
		/**
		 * can attack only when action is set to true and if there are no frames to wait
		 */
		if(action && waitingFrames == 0)
		{
			spriteImageView.setImage(new Image("image/main_attack.png"));
			switch(getDirection())
			{
				case "UP": 	spriteImageView.setViewport(new Rectangle2D(300, 0, width, height)); action = false; break;
				case "DOWN": spriteImageView.setViewport(new Rectangle2D(0, 0, width, height)); action = false;  break;
				case "LEFT": spriteImageView.setViewport(new Rectangle2D(100, 0, width, height)); action = false; break;
				case "RIGHT": spriteImageView.setViewport(new Rectangle2D(200, 0, width, height)); action = false; break;
				default: break;
			}
			
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
	
	/**
	 * count a number of frame before an action can be performed
	 */
	public void waitingFrames()
	{
		if(waitingFrames < framesToWait && action == false)
		{
			waitingFrames ++;
		}
		else if(waitingFrames == framesToWait && action == false)
		{
			waitingFrames = 0;
			action = true;
			spriteImageView.setImage(holdImage);
			switch(getDirection())
			{
			case "UP":
				spriteImageView.setViewport(new Rectangle2D(0, 300, 100, 100));
				break;
			case "DOWN":
				spriteImageView.setViewport(new Rectangle2D(0, 0, 100, 100));
				break;
			case "LEFT":
				spriteImageView.setViewport(new Rectangle2D(0, 100, 100, 100));
				break;
			case "RIGHT":
				spriteImageView.setViewport(new Rectangle2D(0, 200, 100, 100));
				break;
			}
//			switch(getDirection())
//			{
//				case "UP":				
//					walkingAnimation=new SpriteAnimation(spriteImageView,Duration.millis(500),count,column,offsetX,offsetY+300,width,height);
//					break;
//				case "DOWN":
//					walkingAnimation=new SpriteAnimation(spriteImageView,Duration.millis(500),count,column,offsetX,offsetY,width,height);
//					break;
//				case "LEFT":
//					walkingAnimation=new SpriteAnimation(spriteImageView,Duration.millis(500),count,column,offsetX,offsetY+100,width,height);
//					break;
//				case "RIGHT":
//					walkingAnimation=new SpriteAnimation(spriteImageView,Duration.millis(500),count,column,offsetX,offsetY+200,width,height);
//					break;
//				default: break;
//			}
//			walkingAnimation.play();
		}
	}
	
	public void updateLife(double life)
	{
		if(life==8.0 || life==7.5)
		{
			heartContainer=new ImageView(new Image("image/Heart-Containers-1.png"));
		}
		else if(life==7.0|| life==6.5)
		{
			heartContainer=new ImageView(new Image("image/Heart-Containers-2.png"));
		}
		else if(life==6.0|| life==5.5)
		{
			heartContainer=new ImageView(new Image("image/Heart-Containers-3.png"));
		}
		else if(life==5.0|| life==4.5)
		{
			heartContainer=new ImageView(new Image("image/Heart-Containers-4.png"));
		}
		else if(life==4.0|| life==3.5)
		{
			heartContainer=new ImageView(new Image("image/Heart-Containers-5.png"));
		}
		else if(life==3.0|| life==2.5)
		{
			heartContainer=new ImageView(new Image("image/Heart-Containers-6.png"));
		}
		else if(life==2.0|| life==1.5)
		{
			heartContainer=new ImageView(new Image("image/Heart-Containers-7.png"));
		}
		else if(life==1.0|| life==0.5)
		{
			heartContainer=new ImageView(new Image("image/Heart-Containers-8.png"));
		}
		else if(life==0.0)
		{
			heartContainer=new ImageView(new Image("image/Heart-Containers-9.png"));
		}
	}
	
	public ImageView getHeartContainer()
	{
		return heartContainer;
	}
	
}
