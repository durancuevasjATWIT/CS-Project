package application;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Enemy 
{	
	private int x;
	private int y;
	private int attack = 10;
	private int health = 10;
	private boolean isAlive;
	
	BufferedImage image;
	File fImage = new File("enemySquare.png");

	// Create an enemy at the value position; 
	public Enemy(int x, int y)
	{
		try
		{
			image = ImageIO.read(fImage);
		} 
		catch (Exception e){}
		
		if (image == null)
		{
			image.createGraphics();
		}			
		
		System.out.printf("Enemy has been created at %d%d", x ,y);
	}	
	
	public void spawnLocation()
	{
		int n = ((int) (Math.random() * 245));
		int m = ((int) (Math.random() * 140));
		int i = ((int) (Math.random() * 4)) + 1;
		int j = ((int) (Math.random() * 4)) + 1;

		if (i == 2 && j == 2 || i == 2 && j == 3 || i == 3 && j == 2 || i == 3 && j == 3)
		{
			int l = ((int) (Math.random()));

			if (l == 0)
			{
				i = 1;					
			}
			else
			{
				i = 4;
			}
			
			l = ((int) (Math.random()));
			
			if (l == 0)
			{
				j = 1;
			}
			else
			{
				j = 4;
			}
		}

		x = n * i;
		y = m * j;
		
	}

	public void update(int level)
	{
		health = health + (health / 10 * level);
	}

	// Decreased the enemy's health if they get hit by the player
	public void hasBeenHit(int damage) 
	{
		health -= damage;
		currentHealth();
		String.format("Enemy health has been reduced by %d, current enemy health is: %d", damage, currentHealth());
	}
	
	public void attack()
	{
		String.format("Player's health has decreased by %d", attack);		
	}
	
	// Delete the enemy if the dies
	public void die()
	{
		if(currentHealth() == 0)
		{
			System.out.printf("Enemy has died in %f%f", x, y);
			setAlive(false);
		}
	}
	
	public int currentHealth() 
	{
		return health;
	}
	
	public double getX()
	{
		return x;
	}
	
	public void setX(int x)
	{
        this.x = x;
    }
		
	public double getY()
	{
		return y;
	}
	
	public void setY(int y)
	{
        this.y = y;
    }

	public void setIsAlive()
	{
		setAlive(true);
	}

	public boolean isAlive()
	{
		return isAlive;
	}

	public void setAlive(boolean isAlive)
	{
		this.isAlive = isAlive;
	}
	
}
