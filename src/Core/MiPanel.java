package Core;



import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;


public class MiPanel extends JPanel{
	
	
	/*Clase que extiene de JPanel cuyo objetivo es el de aplicar una imagen de fondo al panel deseado*/
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image imagen;
	
	public MiPanel(Image imagen) {
		if (imagen != null) {
		 this.imagen = imagen;
		}
	}

	public void setImagen(Image nuevaImagen) {
		this.imagen = nuevaImagen;
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		
		if (imagen != null) {
			g.drawImage(imagen, 0, 0, getWidth(), getHeight(),this);
			setOpaque(false);
		} else {
			setOpaque(true);
		}	
		
		super.paint(g);
	}
}