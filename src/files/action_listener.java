package files;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Modify the interface and return data based on the actions made on the menu bar
 * 
 * @author Santiago Carrizo
 * @since 1.0
 */

public class action_listener extends JFrame implements ActionListener{

	// **************************************************
    // Variables of the database
    // **************************************************
	
	String url = "jdbc:mysql://localhost:3306/mobile";
    String username = "root";
    String password = "";
	
    @Override
    public void actionPerformed(ActionEvent e) {
        Scanner sc= new  Scanner(System.in);
        String numbers= interfacee.getTxtNumbers().getText();

        if(e.getSource()==interfacee.getMnuSave()){
            try {
            	
            	 try (Connection connection = DriverManager.getConnection(url, username, password)) {
            		 
            		 Statement myStmt = connection.createStatement();
            		 
            		 myStmt.execute("insert into numbers (number) values ('"+numbers+"');");
            		 
            		 connection.close();
            	 } catch (SQLException e1) {
            		 System.out.println(e1.getLocalizedMessage());
            	 }
            	
               
            } catch (Exception e1) {
            	JOptionPane.showMessageDialog(null,
                        "Can't connect with the database", "Database error",
                        JOptionPane.NO_OPTION); 
            }
        }else if(e.getSource()==interfacee.getMnuRead()){
        	
        	String showNum="";
        	
        	try (Connection connection = DriverManager.getConnection(url, username, password)) {
       		 
       		 Statement myStmt = connection.createStatement();
       		 
       		 ResultSet myRs = myStmt.executeQuery("select * from numbers");
       		 
       		while(myRs.next()) {
       			showNum+= myRs.getString("number") + "\n";
       		}
       		 
       		JOptionPane.showMessageDialog(null,
                    showNum, "Numbers",
                    JOptionPane.NO_OPTION);
       		
       		 connection.close();
       	 	} catch (SQLException e1) {
       	 	JOptionPane.showMessageDialog(null,
                    "Can't connect with the database", "Database error",
                    JOptionPane.NO_OPTION);
       	 	}

        }else if(e.getSource()==interfacee.getMnuReset()){
            String blanc="";
            interfacee.setNumberScreen("");
            interfacee.setLimit(0);
            interfacee.getTxtNumbers().setText(blanc);
            for(JButton button:interfacee.getButtons()){
                button.setBackground(Color.white);
            }
            
        }else if(e.getSource()==interfacee.getMnuAbout()){

            String info="App = Mobile phone\n Author = Santiago Carrizo\n This application has been designed to replicate a mobile phone";
            JOptionPane.showMessageDialog(null,
                        info, "About",
                        JOptionPane.NO_OPTION);
        }else if(e.getSource()==interfacee.getMnuEscape()){
            System.exit(0);
        }

        sc.close();

    }
    
}
