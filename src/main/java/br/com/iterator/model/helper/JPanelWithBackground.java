package br.com.iterator.model.helper;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import br.com.iterator.view.Principal;

public class JPanelWithBackground extends JPanel {

	private static final long serialVersionUID = 1L;
	private String pathImage = "";

   public JPanelWithBackground() {
   }

   public JPanelWithBackground(String pathImage) {
       this.pathImage = pathImage;
   }

   @Override
   public void paintComponent(Graphics g) {
	   ImageIcon imageicon = new ImageIcon(Principal.class.getResource(pathImage));
	   Image image = imageicon.getImage();

	   /*Draw image on the panel*/
	   super.paintComponent(g);

	   if (image != null)
	   g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
   }
}


