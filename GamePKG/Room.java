package GamePKG;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Room 
{
	static int currentRoom=1;
	public static List<Rectangle> wallRecList1 = new CopyOnWriteArrayList<Rectangle>();
	public static List<Rectangle> wallRecList2 = new CopyOnWriteArrayList<Rectangle>();
	public static List<Rectangle> wallRecList3 = new CopyOnWriteArrayList<Rectangle>();//castle walls
	
	private Rectangle list1_wall1=new Rectangle(465,95,50,212);
	private Rectangle list1_wall2=new Rectangle(425,250,68,89);
	private Rectangle list1_wall3=new Rectangle(315,345,75,15);
	private Rectangle list1_wall4=new Rectangle(270,350,90,25);
	private Rectangle list1_wall5=new Rectangle(368,400,15,160);
	private Rectangle list1_wall6=new Rectangle(310,540,95,30);
	private Rectangle list1_wall7=new Rectangle(310,540,65,67);
	private Rectangle list1_wall8=new Rectangle(310,650,10,20);
	private Rectangle list1_wall9=new Rectangle(287,664,24,13);
	private Rectangle list1_wall10=new Rectangle(0,918,335,90);
	private Rectangle list1_wall11=new Rectangle(40,680,240,20);
	private Rectangle list1_wall12=new Rectangle(0,800,220,20);
	private Rectangle list1_wall13=new Rectangle(202,850,160,30);
	private Rectangle list1_wall14=new Rectangle(0,0,1,998);
	private Rectangle list1_wall15=new Rectangle(1415,120,2,170);
	private Rectangle list1_wall16=new Rectangle(1485,375,2,240);
	private Rectangle list1_wall17=new Rectangle(1280,595,2,280);
	private Rectangle list1_wall18=new Rectangle(1380,290,280,2);
	private Rectangle list1_wall19=new Rectangle(1535,290,2,200);
	private Rectangle list1_wall20=new Rectangle(1355,617,200,2);
	private Rectangle list1_wall21=new Rectangle(1225,875,450,2);
	private Rectangle list1_wall22=new Rectangle(1665,875,2,450);
	//********************************************************
	
	private Rectangle list2_wall1=new Rectangle(0,488,740,600);
	private Rectangle list2_wall2=new Rectangle(1150,97,800,600);
	private Rectangle list2_wall3=new Rectangle(600,97,550,170);
	private Rectangle list2_wall4=new Rectangle(900,97,600,210);
	private Rectangle list2_wall5=new Rectangle(1065,97,300,285);
	private Rectangle list2_wall6=new Rectangle(1670,97,400,1000);
	private Rectangle list2_wall7=new Rectangle(1500,97,300,780);
	private Rectangle list2_wall8=new Rectangle(1350,97,400,690);
//	private Rectangle list2_wall9=new Rectangle(0,221,210,10);
//	private Rectangle list2_wall10=new Rectangle(0,231,190,10);
//	private Rectangle list2_wall11=new Rectangle(0,241,170,10);
//	private Rectangle list2_wall12=new Rectangle(0,251,150,10);
//	private Rectangle list2_wall13=new Rectangle(0,261,125,10);
//	private Rectangle list2_wall14=new Rectangle(0,696,125,192);
//	private Rectangle list2_wall15=new Rectangle(0,855,1380,180);
//	private Rectangle list2_wall16=new Rectangle(1175,95,750,95);
//	private Rectangle list2_wall17=new Rectangle(1350,610,560,90);
//	private Rectangle list2_wall18=new Rectangle(1820,700,85,300);
	
	
	//********************************************************
	private Rectangle list3_wall1=new Rectangle(0,95,110,192);
	private Rectangle list3_wall2=new Rectangle(0,97,365,65);
	private Rectangle list3_wall3=new Rectangle(0,161,350,10);
	private Rectangle list3_wall4=new Rectangle(0,171,320,10);
	private Rectangle list3_wall5=new Rectangle(0,181,300,10);
	private Rectangle list3_wall6=new Rectangle(0,191,280,10);
	private Rectangle list3_wall7=new Rectangle(0,201,260,10);
	private Rectangle list3_wall8=new Rectangle(0,211,230,10);
	private Rectangle list3_wall9=new Rectangle(0,221,210,10);
	private Rectangle list3_wall10=new Rectangle(0,231,190,10);
	private Rectangle list3_wall11=new Rectangle(0,241,170,10);
	private Rectangle list3_wall12=new Rectangle(0,251,150,10);
	private Rectangle list3_wall13=new Rectangle(0,261,125,10);
	private Rectangle list3_wall14=new Rectangle(0,696,125,192);
	private Rectangle list3_wall15=new Rectangle(0,855,1380,180);
	private Rectangle list3_wall16=new Rectangle(1175,95,750,95);
	private Rectangle list3_wall17=new Rectangle(1350,610,560,90);
	private Rectangle list3_wall18=new Rectangle(1820,700,85,300);
	
	public Room(Pane pane)
	{
		list1_wall1.setFill(Color.TRANSPARENT);
		list1_wall1.setRotate(-35);
		list1_wall2.setFill(Color.TRANSPARENT);
		list1_wall3.setFill(Color.TRANSPARENT);
		list1_wall4.setFill(Color.TRANSPARENT);
		list1_wall5.setFill(Color.TRANSPARENT);
		list1_wall5.setRotate(-35);
		list1_wall6.setFill(Color.TRANSPARENT);
		list1_wall7.setFill(Color.TRANSPARENT);
		list1_wall8.setFill(Color.TRANSPARENT);
		list1_wall9.setFill(Color.TRANSPARENT);
		list1_wall10.setFill(Color.TRANSPARENT);
		list1_wall11.setFill(Color.TRANSPARENT);
		list1_wall11.setRotate(-2);
		list1_wall12.setFill(Color.TRANSPARENT);
		list1_wall13.setFill(Color.TRANSPARENT);
		list1_wall13.setRotate(31);
		list1_wall14.setFill(Color.TRANSPARENT);
		list1_wall15.setFill(Color.TRANSPARENT);
		list1_wall15.setRotate(-155);
		list1_wall16.setFill(Color.TRANSPARENT);
		list1_wall16.setRotate(-155);
		list1_wall17.setFill(Color.TRANSPARENT);
		list1_wall17.setRotate(-152);
		list1_wall18.setFill(Color.TRANSPARENT);
		
		//**************************************************************
		list3_wall1.setFill(Color.TRANSPARENT);
		list3_wall2.setFill(Color.TRANSPARENT);
		list3_wall3.setFill(Color.TRANSPARENT);
		list3_wall4.setFill(Color.TRANSPARENT);
		list3_wall5.setFill(Color.TRANSPARENT);
		list3_wall6.setFill(Color.TRANSPARENT);
		list3_wall7.setFill(Color.TRANSPARENT);
		list3_wall8.setFill(Color.TRANSPARENT);
		list3_wall9.setFill(Color.TRANSPARENT);
		list3_wall10.setFill(Color.TRANSPARENT);
		list3_wall11.setFill(Color.TRANSPARENT);
		list3_wall12.setFill(Color.TRANSPARENT);
		list3_wall13.setFill(Color.TRANSPARENT);
		list3_wall14.setFill(Color.TRANSPARENT);
		list3_wall15.setFill(Color.TRANSPARENT);
		list3_wall16.setFill(Color.TRANSPARENT);
		list3_wall17.setFill(Color.TRANSPARENT);
		list3_wall18.setFill(Color.TRANSPARENT);
		//*******************************************************************
		list2_wall1.setFill(Color.TRANSPARENT);
		list2_wall2.setFill(Color.TRANSPARENT);
		list2_wall3.setFill(Color.TRANSPARENT);
		list2_wall4.setFill(Color.TRANSPARENT);
		list2_wall5.setFill(Color.TRANSPARENT);
		list2_wall6.setFill(Color.TRANSPARENT);
		list2_wall7.setFill(Color.TRANSPARENT);
		list2_wall8.setFill(Color.TRANSPARENT);
//		list2_wall9.setFill(Color.TRANSPARENT);
//		list2_wall10.setFill(Color.TRANSPARENT);
//		list2_wall11.setFill(Color.TRANSPARENT);
//		list2_wall12.setFill(Color.TRANSPARENT);
//		list2_wall13.setFill(Color.TRANSPARENT);
//		list2_wall14.setFill(Color.TRANSPARENT);
//		list2_wall15.setFill(Color.TRANSPARENT);
//		list2_wall16.setFill(Color.TRANSPARENT);
//		list2_wall17.setFill(Color.TRANSPARENT);
//		list2_wall18.setFill(Color.TRANSPARENT);
		
		
		
		
		
		//pane.getChildren().addAll(list2_wall1,list2_wall2,list2_wall3,list2_wall4,list2_wall5,list2_wall6,list2_wall7,list2_wall8);//,list2_wall9
				//,list2_wall10,list2_wall11,list2_wall12,list2_wall13,list2_wall14,list2_wall15,list2_wall16,list2_wall17,list2_wall18);
		
		
		wallRecList1.add(list1_wall1);
		wallRecList1.add(list1_wall2);
		wallRecList1.add(list1_wall3);
		wallRecList1.add(list1_wall4);
		wallRecList1.add(list1_wall5);
		wallRecList1.add(list1_wall6);
		wallRecList1.add(list1_wall7);
		wallRecList1.add(list1_wall8);
		wallRecList1.add(list1_wall9);
		wallRecList1.add(list1_wall10);
		wallRecList1.add(list1_wall11);
		wallRecList1.add(list1_wall12);
		wallRecList1.add(list1_wall13);
		wallRecList1.add(list1_wall14);
		wallRecList1.add(list1_wall15);
		wallRecList1.add(list1_wall16);
		wallRecList1.add(list1_wall17);
		wallRecList1.add(list1_wall18);
		wallRecList1.add(list1_wall19);
		wallRecList1.add(list1_wall20);
		wallRecList1.add(list1_wall21);
		wallRecList1.add(list1_wall22);
		//****************************
		wallRecList2.add(list2_wall1);
		wallRecList2.add(list2_wall2);
		wallRecList2.add(list2_wall3);
		wallRecList2.add(list2_wall4);
		wallRecList2.add(list2_wall5);
		wallRecList2.add(list2_wall6);
		wallRecList2.add(list2_wall7);
		wallRecList2.add(list2_wall8);
		
		
		//****************************
		wallRecList3.add(list3_wall1);
		wallRecList3.add(list3_wall2);
		wallRecList3.add(list3_wall3);
		wallRecList3.add(list3_wall4);
		wallRecList3.add(list3_wall5);
		wallRecList3.add(list3_wall6);
		wallRecList3.add(list3_wall7);
		wallRecList3.add(list3_wall8);
		wallRecList3.add(list3_wall9);
		wallRecList3.add(list3_wall10);
		wallRecList3.add(list3_wall11);
		wallRecList3.add(list3_wall12);
		wallRecList3.add(list3_wall13);
		wallRecList3.add(list3_wall14);
		wallRecList3.add(list3_wall15);
		wallRecList3.add(list3_wall16);
		wallRecList3.add(list3_wall17);
		wallRecList3.add(list3_wall18);
		
	}
	
	public static void checkWallCollision(Rectangle spriteCollisionBox)
	{
		if(currentRoom==3)
		{
			int size3=wallRecList3.size();
			for(int i=0;i<size3;i++)
			{
				if ((wallRecList3.get(i).getBoundsInParent().intersects(spriteCollisionBox.getBoundsInParent())))
				{
					Sprite.setInBlockedArea(true);
				}
			}
		}
		else if(currentRoom==2)
		{
			int size2=wallRecList2.size();
			for(int i=0;i<size2;i++)
			{
				if ((wallRecList2.get(i).getBoundsInParent().intersects(spriteCollisionBox.getBoundsInParent())))
				{
					Sprite.setInBlockedArea(true);
				}
			}
		}
		else
		{
			int size1=wallRecList1.size();
			for(int i=0;i<size1;i++)
			{
				if ((wallRecList1.get(i).getBoundsInParent().intersects(spriteCollisionBox.getBoundsInParent())))
				{
					Sprite.setInBlockedArea(true);
				}
			}
		}		
	}

}
