import java.util.ArrayList;
import java.lang.Math;

class Model
{
	int turtle_x;
	int turtle_y;
	int dest_x;
	int dest_y;
	static int speed = 4;
	ArrayList<Thing> things;
	int itemNum;

	Model()
	{
		this.turtle_x = 100;
		this.turtle_y = 100;
		this.dest_x = 150;
		this.dest_y = 100;
		this.itemNum = 0;
		this.things = new ArrayList<Thing>();
	}

	public void update()
	{ 
		// if(this.turtle_x < this.dest_x)
        //     this.turtle_x += Math.min(speed, dest_x - turtle_x);
		// else if(this.turtle_x > this.dest_x)
        //     this.turtle_x -= Math.max(speed, dest_x - turtle_x);
		// if(this.turtle_y < this.dest_y)
        //     this.turtle_y += Math.min(speed, dest_y - turtle_y);
		// else if(this.turtle_y > this.dest_y)
        //     this.turtle_y -= Math.max(speed, dest_y - turtle_y);	
	}

    public void reset()
    { 
        // turtle_x = 200;
        // turtle_y = 200;
        // dest_x = turtle_x;
        // dest_y = turtle_y;	
    }

	public void setDestination(int x, int y) {
		// this.dest_x = x;
		// this.dest_y = y;
	}

	public void addThing(int x, int y) {
		things.add(new Thing(x, y, itemNum));
	}

  	public void removeThing(int x, int y) {
		//variable for shortest distance
		double shortest_distance = 100000.0;

		//variable for index of shortest distance
		int shortest_index = 0;

		for(int i = 0; i < things.size(); i++) {
			if((Math.sqrt(Math.pow(x - things.get(i).x, 2) + Math.pow(y - things.get(i).y, 2))) <= shortest_distance) {
				shortest_distance = Math.sqrt(Math.pow(x - things.get(i).x, 2) + Math.pow(y - things.get(i).y, 2));	
				shortest_index = i;
			}		
		}
		things.remove(things.get(shortest_index));		
	}
}

class Thing
{
	public int x;
	public int y;
	public int kind;

	Thing(int x, int y, int kind)
	{
		this.x = x;
		this.y = y;
		this.kind = kind;
	}


}