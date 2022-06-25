package views;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
/**
 *
 * @author KELOMPOK 1
 */
public class Background extends JPanel{
    private Image image;
    public Background(){
        image = new ImageIcon(getClass().getResource("/images/tutwurihandayani-logo.png")).getImage();
    }
    @Override
    protected void paintComponent(Graphics graph){
        super.paintComponents(graph);
        Graphics2D gd = (Graphics2D) graph.create();
        gd.drawImage(image,0,0, getWidth(), getHeight(), null);
        gd.dispose();
    }    
}
