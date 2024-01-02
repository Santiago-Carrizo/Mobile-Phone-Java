
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JFrame;

import files.interfacee;

/**
 * Initializes the program and determines the characteristics of its frame
 * 
 * @author Santiago Carrizo
 * @since 1.0
 */

public class executable {
  public static void main(String[] args) {
    interfacee frame = new interfacee();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(200, 470);
    frame.setVisible(true);

  }
}
