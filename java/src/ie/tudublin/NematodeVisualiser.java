package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class NematodeVisualiser extends PApplet
{
	ArrayList<Nematode> nematodevisualiser = new ArrayList<Nematode>();

	int direction =0;
	public void keyPressed()
	{		
		if (keyCode == LEFT)
		{
			if(direction == 1)
			{
				direction = nematodevisualiser.size() -1;
			}
			direction = direction - 1;
		}	
		if (keyCode == RIGHT)
		{
			if(direction == nematodevisualiser.size() -1)
			{
				direction = 0;
			}
			direction = direction + 1;
		}		
	}


	public void settings()
	{
		size(800, 800);
	}

	public void setup() 
	{
		colorMode(HSB);
		background(0);
		smooth();			
		loadNematodes();	
	}

	public void loadNematodes()
    {
        Table table = loadTable("nematodes.csv", "header");

        for(TableRow row:table.rows())
        {
            Nematode n = new Nematode(row);
			
            nematodevisualiser.add(n);
        }
    }


	public void draw()
	{		  
		//displaying the name from the file
		textSize(30);
		textAlign(CENTER);
		fill(0,0,255);
		text(nematodevisualiser.get(direction).getName(), width/2, height/10);


		int length = nematodevisualiser.get(direction).getLength();
		
}
}
