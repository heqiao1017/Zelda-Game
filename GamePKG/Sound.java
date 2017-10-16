package GamePKG;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound 
{
	protected static final String AudioPlayer = null;
	
	public Clip woodsMusic  = loadClip("/sound/perfectWorld1.wav");
	public Clip castleMusic = loadClip("/sound/perfectWorld2.wav");
	public Clip attack = loadClip("/sound/attack-1.wav");
	public Clip footstepsnow = loadClip("/sound/walking-in-snow-1.wav");
	public Clip footstepfloor = loadClip("/sound/footsteps-1.wav");
	public Sound() {
		
	} // Sound constructor

	public Clip loadClip(String filename)
	{
		Clip clip = null;		
		try
		{
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(getClass().getResource(filename));
			clip = AudioSystem.getClip();
			clip.open( audioIn );
		}// try
		catch (Exception e)
		{
			e.printStackTrace();
		}// catch
		
		return(clip);
		
	} // Clip
	
	public void playClip( int index )
	{
		if (index == 1)
		{		
		    stopClip(1);
		    woodsMusic.start();
		}
		else
		{
			if (index == 2)
		    {			
			    if (!castleMusic.isRunning())
			    {
			       stopClip(2);
			       castleMusic.start();
			    }
		    }
			else if(index==3)
			{
				if (!attack.isRunning())
			    {
			       stopClip(3);
			       attack.start();
			    }
			}
			else if(index==4)
			{
				if (!footstepsnow.isRunning())
			    {
			       stopClip(4);
			       footstepsnow.start();
			    }
			}
			else if(index==5)
			{
				if (!footstepfloor.isRunning())
			    {
			       stopClip(5);
			       footstepfloor.start();
			    }
			}
		}
	} // playClip
	
	public void stopClip( int index )
	{
		if (index == 1)
		{
		   if (woodsMusic.isRunning() )
		   {
			   woodsMusic.stop();
		   }
		   woodsMusic.setFramePosition(0);
		}
		else if (index == 2)
		{
		   if (castleMusic.isRunning() )
		   {
			   castleMusic.stop();
		   }
		   castleMusic.setFramePosition(0);
		}
		else if (index == 3)
		{
		   if (attack.isRunning() )
		   {
			   attack.stop();
		   }
		   attack.setFramePosition(0);
		}
		else if (index == 4)
		{
		   if (footstepsnow.isRunning() )
		   {
			   footstepsnow.stop();
		   }
		   footstepsnow.setFramePosition(0);
		}
		else if (index == 5)
		{
		   if (footstepfloor.isRunning() )
		   {
			   footstepfloor.stop();
		   }
		   footstepfloor.setFramePosition(0);
		}
	} // stopClip

}
