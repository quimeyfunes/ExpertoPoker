/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package UI;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public abstract class Step extends JPanel {

    private boolean active = true;

    public boolean isActive(){
        return this.active;
    }

    protected void setActive(boolean active){
        this.active = active;
    }

    public abstract boolean executeStep();
    
  	private Image background;
   
  	public void paintComponent(Graphics g) {
  		int width = this.getSize().width;
  		int height = this.getSize().height;
   
  		super.paintComponent(g);
  		
  		if (this.background != null) {
  			g.drawImage(this.background, 0, 0, width, height, null);
  		}
  	}
   
  	public void setBackground(String imagePath) {
  		this.background = new ImageIcon(imagePath).getImage();
  		repaint();
  	}
}
