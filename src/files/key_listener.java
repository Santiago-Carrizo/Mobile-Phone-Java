package files;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Recive and return data based on the key pressed
 * 
 * @author Santiago Carrizo
 * @since 1.0
 */

public class key_listener extends JFrame implements KeyListener{

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(interfacee.getLimit()<9){
            
            for(JButton button:interfacee.getButtons()){    
                String x=button.getText();
                char c=x.charAt(0);
                if(e.getKeyChar()==c){
                    button.setBackground(Color.pink);
                    interfacee.setNumberScreen(interfacee.getNumberScreen()+c);
                    interfacee.getTxtNumbers().setText(interfacee.getNumberScreen());
                    
                    interfacee.setLimit(interfacee.getLimit()+1);
                }
            }
            
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
    }
    
}
