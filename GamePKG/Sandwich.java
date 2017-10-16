package GamePKG;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class Sandwich extends Sprite
{

	public Sandwich(Pane pane, Image image, double pX, double pY, double width, double height, double speed) {
		super(pane, image, pX, pY, width, height, speed);
		// TODO Auto-generated constructor stub
		super.getCollisionBox().setX(pX);
		super.getCollisionBox().setY(pY+10);
		super.getCollisionBox().setWidth(width);
		super.getCollisionBox().setHeight(height-20);
	}
	public boolean checkCollision(Player player )
	{
		if ((player.getCollisionBox().getBoundsInParent().intersects(this.getCollisionBox().getBoundsInParent())))
		{
			return true;			
		}
		return false;
	}
	public void disappear(Pane pane)
	{
		super.getCollisionBox().setX(0);
		super.getCollisionBox().setY(0);
		pane.getChildren().remove(this.getImageView());
	}

}
