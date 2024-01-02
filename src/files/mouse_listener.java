package files;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;

/**
 * Modify the interface and return data based on the actions with the mouse
 * 
 * @author Santiago Carrizo
 * @since 1.0
 */

public class mouse_listener implements MouseListener,MouseMotionListener{

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    
            if(interfacee.getLimit()<9){
                
                for(JButton button:interfacee.getButtons()){    
                    if(e.getSource()==button){
                        button.setBackground(Color.pink);
                        String x=button.getText();
                        interfacee.setNumberScreen(interfacee.getNumberScreen()+x);
                        interfacee.getTxtNumbers().setText(interfacee.getNumberScreen());
                        
                    }
                    
                }
                interfacee.setLimit(interfacee.getLimit()+1);
            }

            if(e.getSource()==interfacee.getBtnEarse()){
                String blank="";
                interfacee.setNumberScreen("");
                interfacee.setLimit(0);

                interfacee.getTxtNumbers().setText(blank);

                for(JButton button:interfacee.getButtons()){
                    button.setBackground(Color.white);
                }
            }

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        for(JButton button:interfacee.getButtons()){    
            if(e.getSource()==button && button.getBackground()!=Color.PINK){
                button.setBackground(Color.GRAY);
            
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        for(JButton button:interfacee.getButtons()){    
            if(e.getSource()==button && button.getBackground()==Color.GRAY){
                button.setBackground(Color.WHITE);
            
            }
        }
    }
    
}
