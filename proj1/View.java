import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import javax.swing.JButton;
import java.awt.Color;

class View extends JPanel
{
	JButton b1;
	//BufferedImage turtle_image;
	BufferedImage[] images = new BufferedImage[10];
	Model model;
	int imageNum;

	View(Controller c, Model m, Game game)
	{
		// Link up to other objects
		c.setView(this);
		model = m;

		// Send mouse events to the controller
		this.addMouseListener(c);

		for(imageNum = 0; imageNum < game.THINGS.length; imageNum++) {
			String fileName = "images/" + game.THINGS[imageNum] + ".png";
			try {
				this.images[imageNum] = ImageIO.read(new File(fileName));

			} catch(Exception e) {
				e.printStackTrace(System.err);
				System.exit(1);
			}
		}
	}

	public void paintComponent(Graphics g)
	{
		// Clear the background
		g.setColor(new Color(0, 204, 0));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(new Color(128, 0, 128));
		g.fillRect(0, 0, 200, 200);

		// Draw the image so that its bottom center is at (x,y)
		//int w = this.images[model.itemNum].getWidth();
		//int h = this.images[model.itemNum].getHeight();
		g.drawImage(this.images[model.itemNum], 0, 0, null);

		for(int i = 0; i < model.things.size(); i++) {
			Thing thing = model.things.get(i);
			int x = thing.x;
			int y = thing.y;
			int kind = thing.kind;
			BufferedImage image = images[kind];
			g.drawImage(image, x, y, null);
		}
	}
	
	void removeButton()
	{
		this.remove(this.b1);
		this.repaint();
	}
}