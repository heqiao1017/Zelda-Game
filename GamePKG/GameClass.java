package GamePKG;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GameClass extends Application
{
	//named constant
	static final int CANVAS_WIDTH = 1900;
	static final int CANVAS_HEIGHT = 998;
	public static final String TITLE = "Zelda Game Level 2";
	
	//Rooms
	private Image wood1 = new Image("image/background-forest.png");
	private Image wood2 = new Image("image/back2.png");
	private Image castle = new Image("image/Castle Interior.png");
	private Image over = new Image("image/gameover.png");
	private Image win = new Image("image/vicvotry.png");
	
	//player
	private Image player = new Image("image/main_walk.png");
	private int px=500;
	private int py=300;
	private int pwidth=100;
	private int pheight=100;
	private int pspeed=10;
	
	//prince Arthur
	private Image Arthur = new Image("image/prince.png");
	private int ax=950;
	private int ay=500;
	private int awidth=100;
	private int aheight=100;
	private int aspeed=10;
	
	//Bear
	private Image Bear = new Image("image/monster.png");
	private int bwidth=100;
	private int bheight=100;
	
	//Guard
	private Image Guard = new Image("image/guard.png");
	private int gwidth=100;
	private int gheight=100;
	
	//Meat
	private Image meat = new Image("image/Meat (1).png");
	private int mwidth=100;
	private int mheight=100;
	
	//sandwich
	private Image sandwich = new Image("image/sandwich.png");
	private int swidth=100;
	private int sheight=100;
	
	//panes and scenes
	Pane firstPane,secondPane,thirdPane, gameOverPane, victoryPane; 
	Scene scene1,scene2,scene3, sceneOver, sceneWin;
	int sceneNum=1;
	
	//music
	Sound mySound;
	
	//life counter
	ImageView lifeCounter;
	
	boolean done=false;
	
	Meat meats[]=new Meat[3];
	Sandwich sandwiches[]=new Sandwich[3];
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		firstPane=new Pane();
		firstPane.getChildren().add(new ImageView(wood1));
		scene1 = new Scene(firstPane,CANVAS_WIDTH,CANVAS_HEIGHT);
		
		Room room1 = new Room(firstPane);
		
		//set up monsters
		Bear bears[]=new Bear[5];
		bears[0]=new Bear(firstPane, Bear,600,400,bwidth,bheight,0);
		bears[1]=new Bear(firstPane, Bear,850,700,bwidth,bheight,0);
		bears[2]=new Bear(firstPane, Bear,1200,200,bwidth,bheight,0);
		bears[3]=new Bear(firstPane, Bear,500,790,bwidth,bheight,0);
		bears[4]=new Bear(firstPane, Bear,990,400,bwidth,bheight,0);
		//set up foods
		
		meats[0]=new Meat(firstPane, meat,1000, 700,mwidth,mheight,0);
		meats[1]=new Meat(firstPane, meat,700, 870,mwidth,mheight,0);
		meats[2]=new Meat(firstPane, meat,850, 200,mwidth,mheight,0);
		
		//*********************************************************
		secondPane=new Pane();
		secondPane.getChildren().add(new ImageView(wood2));
		scene2 = new Scene(secondPane,CANVAS_WIDTH,CANVAS_HEIGHT);
		Guard guards[]=new Guard[4];
		guards[0]=new Guard(secondPane, Guard, 900,400,gwidth,gheight,0);
		guards[1]=new Guard(secondPane, Guard, 950,650,gwidth,gheight,0);
		guards[2]=new Guard(secondPane, Guard, 850,400,gwidth,gheight,0);
		guards[3]=new Guard(secondPane, Guard, 870,700,gwidth,gheight,0);
		
		sandwiches[0]=new Sandwich(secondPane,sandwich,1350,850,swidth,sheight,0);
		sandwiches[1]=new Sandwich(secondPane,sandwich,800,350,swidth,sheight,0);
		sandwiches[2]=new Sandwich(secondPane,sandwich,700,400,swidth,sheight,0);
		//*********************************************************
		thirdPane=new Pane();
		thirdPane.getChildren().add(new ImageView(castle));
		scene3=new Scene(thirdPane,CANVAS_WIDTH,CANVAS_HEIGHT);
		PrinceArthur boss[]=new PrinceArthur[1];
		boss[0]=new PrinceArthur(thirdPane, Arthur, ax,ay,awidth,aheight,0);
		//***********************************************************
		Player Nix = new Player(firstPane,player,px,py,pwidth,pheight,pspeed);
		
		Nix.updateLife(Nix.life);
		lifeCounter=Nix.getHeartContainer();
		lifeCounter.setX(900);
		lifeCounter.setY(0);
		firstPane.getChildren().add(lifeCounter);
		
		//*****************************************************************
		primaryStage.setTitle(TITLE);
        primaryStage.setScene(scene1);
        primaryStage.show();
        
        mySound=new Sound();
        mySound.playClip(1);
        //*****************************************************************
        gameOverPane=new Pane();
        gameOverPane.getChildren().add(new ImageView(over));
        sceneOver=new Scene(gameOverPane,CANVAS_WIDTH,CANVAS_HEIGHT);
        
        victoryPane=new Pane();
        victoryPane.getChildren().add(new ImageView(win));
        sceneWin=new Scene(victoryPane,CANVAS_WIDTH,CANVAS_HEIGHT);
        //********************************************************************
        
        AnimationTimer gameLoop = new AnimationTimer()  
        {  
        	private long lastupdate=0;
        	@Override 
            public void handle(long now) 
        	{
        		//check die of player
        		if(Nix.life==0)
        		{
        			primaryStage.setScene(sceneOver);
        		}
     		
        		//check if change rooms
        		CheckRoomShifting(Nix,primaryStage);
        		
        		//setting up enemies for each room
        		switch(sceneNum)
        		{
        		case 1:
        			Nix.updateLife(Nix.life);
    				lifeCounter=Nix.getHeartContainer();
    				lifeCounter.setX(900);
    				lifeCounter.setY(0);
    				firstPane.getChildren().add(lifeCounter);
    				
    				for(int i=0;i<meats.length;i++)
    				{
    					if(meats[i].checkCollision(Nix))
        				{
        					meats[i].disappear(firstPane);
        					if(Nix.life<7.5 )
        					{
        						Nix.life+=1;
        					}       					
        				}
    				}
    				
        			if(now -lastupdate >= 1000_000_000 )
            		{
        				for(int i=0;i<bears.length;i++)
            			{
            				bears[i].RandomMove(Nix.getCollisionBox(),meats,bears, i);
            			}       				
        				lastupdate=now;
            		}
        			
        			inputHandle(primaryStage,firstPane,Nix,bears);
        			break;
        		case 2:
        			Nix.updateLife(Nix.life);
    				lifeCounter=Nix.getHeartContainer();
    				lifeCounter.setX(900);
    				lifeCounter.setY(0);
    				secondPane.getChildren().add(lifeCounter);
    				for(int i=0;i<sandwiches.length;i++)
    				{
    					if(sandwiches[i].checkCollision(Nix))
        				{
    						sandwiches[i].disappear(secondPane);
        					if(Nix.life<7.5 )
        					{
        						Nix.life+=1;
        					}       					
        				}
    				}
        			if(now -lastupdate >= 1000_000_000 )
            		{
        				for(int i=0;i<guards.length;i++)
            			{
            				guards[i].RandomMove(Nix.getCollisionBox(),sandwiches, guards, i);
            			}       				
        				lastupdate=now;
            		}
        			inputHandle(primaryStage,secondPane,Nix,guards);
        			break;
        		case 3:
        			Nix.updateLife(Nix.life);
    				lifeCounter=Nix.getHeartContainer();
    				lifeCounter.setX(900);
    				lifeCounter.setY(0);
    				thirdPane.getChildren().add(lifeCounter);
    				
        			if(boss[0].EnemyInAttackDistance(Nix.getCollisionBox()))
    				{
    					boss[0].Attack();
    				}
    				else
    				{
    					if(now -lastupdate >= 1000_000_000 )
                		{
    						boss[0].RandomMove();         				   				
            				lastupdate=now;
                		}   					
    				}       			        			
        			inputHandle(primaryStage,thirdPane,Nix,boss);
        			break;
        		}
        	}
        };
        gameLoop.start();		
	}
	
	public void inputHandle(Stage primaryStage,Pane pane, Player player,Sprite []enemies)
	{
		/**
		 * Count the frame
		 */
		player.waitingFrames();
		player.getImageView().setOnKeyPressed(e -> 
		{
			if(sceneNum==1)
			{
				mySound.stopClip(5);
				mySound.playClip(4);
			}
			else
			{
				mySound.stopClip(4);
				mySound.playClip(5);
			}
			switch(e.getCode())
			{			
				case UP:
					player.move("UP",enemies);
					break;
				case DOWN:
					player.move("DOWN",enemies);
					break;
				case LEFT:
					player.move("LEFT",enemies);
					break;
				case RIGHT:
					player.move("RIGHT",enemies);

					break;
				case SPACE:
					player.Attack();
					if(sceneNum==3)
					{
						if(enemies[0].life==0)
						{
							//win
							primaryStage.setScene(sceneWin);
						}
						enemies[0].getAttacked();
						enemies[0].life--;
					}
					else
					{
						for(int i=0;i<enemies.length;i++)
						{
							if(player.EnemyInAttackDistance(enemies[i].getCollisionBox()))
							{
								enemies[i].die(pane);
							}
						}
					}
												
					break;
				default:
					break;
			}		
		});
		player.getImageView().requestFocus();
	}
	
	public void CheckRoomShifting(Player player,Stage primaryStage)
	{
		//System.out.println(player.getPx()+", "+player.getPy());
		if(sceneNum==1 && (player.getPy()<=82 || player.getPy()>=900))
		{
			//first to second
			firstPane.getChildren().remove(player.getImageView());
			secondPane.getChildren().add(player.getImageView());
			primaryStage.setScene(scene2);
			player.setPosition(950, 870);
			sceneNum=2;
			Room.currentRoom=2;
			//linksprite.setCheckWallRoomTwoTrue();
		}
		else if(sceneNum==2 && player.getPy()>=950)
		{			
			//second back to first
			secondPane.getChildren().remove(player.getImageView());
			firstPane.getChildren().add(player.getImageView());
			primaryStage.setScene(scene1);
			player.setPosition(500, 300);
			sceneNum=1;
			Room.currentRoom=1;
		}
		else if( sceneNum==2 && (player.getPy()<300 && player.getPx()<=550))
		{
			//second to third
			mySound.stopClip(1);
			mySound.playClip(2);
			secondPane.getChildren().remove(player.getImageView());
			thirdPane.getChildren().add(player.getImageView());
			primaryStage.setScene(scene3);
			player.setPosition(1650, 888);
			sceneNum=3;
			Room.currentRoom=3;
		}
		else if(sceneNum==3 && (player.getPy()>=970 ||player.getPy()<=82 ||player.getPx()<=-20 || player.getPx()>=1850) )
		{
			//third to second
			mySound.stopClip(2);
			mySound.playClip(1);
			thirdPane.getChildren().remove(player.getImageView());
			secondPane.getChildren().add(player.getImageView());
			primaryStage.setScene(scene2);
			player.setPosition(950, 870);
			sceneNum=2;
			Room.currentRoom=2;
		}
	}
	
	
	public static void main(String[] args) {
        launch(args);
    } 
}
