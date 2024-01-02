package files;

import java.awt.Color;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

/**
 * Determines the objects in the frame interface
 * 
 * @author Santiago Carrizo
 * @since 1.0
 */

public class interfacee extends JFrame {

	// **************************************************
    // Variables
    // **************************************************
	
    key_listener kl = new key_listener();
    action_listener al = new action_listener();
    mouse_listener ml = new mouse_listener();

    static int butonsAmount = 12;
    
    static JButton buttons[] = new JButton[butonsAmount];
    static JButton btnEarse;
    static JTextField txtNumbers;
    static String numberScreen="";
    static int limit=0;
    String[] numbers= {"1","2","3","4","5","6","7","8","9","#","0","*"};
    
    JMenuBar mnuMain;
    JMenu mnuFile,mnuMobile,mnuOthers;
    static JMenuItem mnuSave;
    static JMenuItem mnuRead;
    static JMenuItem mnuReset;
    static JMenuItem mnuEscape;
    static JMenuItem mnuAbout;
    
    int posX=10;
    int posY=150;
    int cont=0;
    
    // **************************************************
    // Getters and setters
    // **************************************************
    
    public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getCont() {
		return cont;
	}

	public void setCont(int cont) {
		this.cont = cont;
	}

	public key_listener getKl() {
		return kl;
	}

	public void setKl(key_listener kl) {
		this.kl = kl;
	}

	public action_listener getAl() {
		return al;
	}

	public void setAl(action_listener al) {
		this.al = al;
	}

	public mouse_listener getMl() {
		return ml;
	}

	public void setMl(mouse_listener ml) {
		this.ml = ml;
	}

	public static int getButonsAmount() {
		return butonsAmount;
	}

	public static void setButonsAmount(int butonsAmount) {
		interfacee.butonsAmount = butonsAmount;
	}

	public static JButton[] getButtons() {
		return buttons;
	}

	public static void setButtons(JButton[] buttons) {
		interfacee.buttons = buttons;
	}

	public static JButton getBtnEarse() {
		return btnEarse;
	}

	public static void setBtnEarse(JButton btnEarse) {
		interfacee.btnEarse = btnEarse;
	}

	public static JTextField getTxtNumbers() {
		return txtNumbers;
	}

	public static void setTxtNumbers(JTextField txtNumbers) {
		interfacee.txtNumbers = txtNumbers;
	}

	public static String getNumberScreen() {
		return numberScreen;
	}

	public static void setNumberScreen(String numberScreen) {
		interfacee.numberScreen = numberScreen;
	}

	public static int getLimit() {
		return limit;
	}

	public static void setLimit(int limit) {
		interfacee.limit = limit;
	}

	public String[] getNumbers() {
		return numbers;
	}

	public void setNumbers(String[] numbers) {
		this.numbers = numbers;
	}

	public JMenuBar getMnuMain() {
		return mnuMain;
	}

	public void setMnuMain(JMenuBar mnuMain) {
		this.mnuMain = mnuMain;
	}

	public JMenu getMnuFile() {
		return mnuFile;
	}

	public void setMnuFile(JMenu mnuFile) {
		this.mnuFile = mnuFile;
	}

	public JMenu getMnuMobile() {
		return mnuMobile;
	}

	public void setMnuMobile(JMenu mnuMobile) {
		this.mnuMobile = mnuMobile;
	}

	public JMenu getMnuOthers() {
		return mnuOthers;
	}

	public void setMnuOthers(JMenu mnuOthers) {
		this.mnuOthers = mnuOthers;
	}

	public static JMenuItem getMnuSave() {
		return mnuSave;
	}

	public static void setMnuSave(JMenuItem mnuSave) {
		interfacee.mnuSave = mnuSave;
	}

	public static JMenuItem getMnuRead() {
		return mnuRead;
	}

	public static void setMnuRead(JMenuItem mnuRead) {
		interfacee.mnuRead = mnuRead;
	}

	public static JMenuItem getMnuReset() {
		return mnuReset;
	}

	public static void setMnuReset(JMenuItem mnuReset) {
		interfacee.mnuReset = mnuReset;
	}

	public static JMenuItem getMnuEscape() {
		return mnuEscape;
	}

	public static void setMnuEscape(JMenuItem mnuEscape) {
		interfacee.mnuEscape = mnuEscape;
	}

	public static JMenuItem getMnuAbout() {
		return mnuAbout;
	}

	public static void setMnuAbout(JMenuItem mnuAbout) {
		interfacee.mnuAbout = mnuAbout;
	}

	
	// **************************************************
    // Constructor
    // **************************************************
	
    public interfacee(){
        super("Mobile");
        setLayout(null);
        
        //Buttons
    
        for(int i=0;i<buttons.length;i++){
            cont=cont+1;
            
            buttons[i] = addButton(numbers[i],50,50,posX, posY,Color.white, getMl(), getKl());
            
            this.add(buttons[i]);

            if(cont%3==0){
                setPosX(10);
                setPosY(getPosY()+55);
            }else{
                setPosX(getPosX()+55);
            }
        }

        btnEarse= addButton("Reset", 75, 15, 50, 380, Color.GRAY, getMl(), getKl());
        this.add(btnEarse);

        //Text field
        
        txtNumbers = new JTextField("", 9);
        txtNumbers.setLocation(5,5);
        txtNumbers.setSize(175,140);
        txtNumbers.setEditable(false);
        txtNumbers.addMouseListener(ml);
        txtNumbers.addMouseMotionListener(ml);
        txtNumbers.addKeyListener(kl);
        this.add(txtNumbers);
        
        //Menu
        
        setMnuSave(addMenuItem("Save number",'S', getAl()));
        setMnuRead(addMenuItem("Read number",'L',getAl()));
        setMnuReset(addMenuItem("Reset",'R',getAl()));
        setMnuEscape(addMenuItem("Escape",'Q',getAl()));
        setMnuAbout(addMenuItem("About...",'H',getAl()));
        
        setMnuFile(addMenu("File",'F', getMnuSave(),getMnuRead()));
        setMnuMobile(addMenu("Mobile",'M', getMnuReset(),getMnuEscape()));
        setMnuOthers(addMenu("Others",'O', getMnuAbout()));

        mnuMain= new JMenuBar();
        mnuMain.add(mnuFile);
        mnuMain.add(mnuMobile);
        mnuMain.add(mnuOthers);
        this.setJMenuBar(mnuMain);

    }
    
    /**
     * Method designed to return a menu item that will be added to a menu with the specified variables.
     * 
     * @param name text that will appear in the correspond item.
     * @param mnemonic char of the key assigned to be the mnemonic of the item.
     * @param listener {@link action_listener} group of methods that will help to do actions with the item.
     * @return menu item to put on the frame.
     */
    
    public JMenuItem addMenuItem (String name, char mnemonic, action_listener listener) {
    	
    	System.out.println(listener.toString());
    	JMenuItem mi = new JMenuItem();
    	
    	mi = new JMenuItem(name);
    	mi.setMnemonic(mnemonic);
    	mi.addActionListener(listener);
    	
    	return mi;
    }
    
    /**
     * Method designed to return a menu that will be added to the frame with the specified variables.
     * 
     * @param name text that will appear in the correspond menu.
     * @param mnemonic char of the key assigned to be the mnemonic of the menu.
     * @param menu group of menu items that will be added to the menu.
     * @return menu to put on the frame.
     */
    
    public JMenu addMenu (String name, char mnemonic, JMenuItem... menu) {
    	JMenu m = new JMenu();
    	
    	m = new JMenu(name);
    	m.setMnemonic(mnemonic);
    	if(menu.length != 0) {
    		for(int i=0; i<menu.length; i++) {
    			m.add(menu[i]);
    		}
    	}

    	return m;
    }
    
    /**
     * Method designed to return a button that will be added to the frame with the specified variables.
     * 
     * @param name text that will appear in the correspond button.
     * @param width correspond to the size of the button.
     * @param hight correspond to the size of the button.
     * @param x correspond to the position of the button on the frame.
     * @param y correspond to the position of the button on the frame.
     * @param color background of the button.
     * @param ml {@link mouse_listener} group of methods that will help to do actions based on the use of the mouse.
     * @param kl {@link key_listener} group of methods that will help to do actions based on the use of the keyboard.
     * @return button to put on the frame.
     */
    
    public JButton addButton (String name, int width, int hight, int x, int y, Color color, mouse_listener ml, key_listener kl) {
    	JButton b = new JButton(name);
    	
    	b.setSize(width,hight);
    	b.setLocation(x, y);
    	b.setBackground(color);
    	b.addMouseListener(ml);
    	b.addMouseMotionListener(ml);
    	b.addKeyListener(kl);
    	
    	return b;
    }
}
