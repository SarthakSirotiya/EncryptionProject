//@author Sarthak Sirotiya
//dedicated to Mr. Britton in May of 2018

/*
ASSIGNMENT:
Encryption
Research online different methods of encrypting textual information. Choose both a simple method, and a more sophisticated method.
Create a user-friendly GUI program where the user can type information into a text area. Offer the user both encryption methods.
Allow the user to both encrypt and decrypt the information. Allow the user to output the encrypted information to a text file.
 */

//import statements because there's no reason to re-invent the wheel
import BreezySwing.*; //imports industry-standard GUI software
import javax.swing.*; //imports Swing because it's necessary for BreezySwing


public class EncryptionProject extends GBFrame {

	//setting up GUI (buttons, labels, etc) (text, row, column, width, height)
	JTextField input = addTextField("Enter your text here", 1, 1, 2, 1); //adds a textfield for the user to input their text
	ButtonGroup types = new ButtonGroup(); //adds a button group for the radio buttons that determine what type of encryption/decryption to use
	JRadioButton basicRB = addRadioButton("Basic", 2, 1, 1, 1); //adds a radio button to select basic encryption
	JRadioButton advancedRB = addRadioButton("Advanced", 2, 2, 1, 1); //adds a radio button to select advanced encryption
	JButton encryptButton = addButton("Encrypt", 3, 1, 1, 1); //adds a button to start the encryption
	JButton decryptButton = addButton("Decrypt", 3, 2, 1, 1); //adds a button to start the decryption
	JLabel output = addLabel("Your text will appear here", 4, 1, 2, 1); //adds a label for the user to receive their permuted text

	public EncryptionProject() //constructor for some basic setup
	{
		//adds Radio Buttons to the 'types' ButtonGroup (this prevents them from both being selected simultaneously)
		types.add(basicRB); //adds the 'basic' Radio Button to the 'types' ButtonGroup
		types.add(advancedRB); //adds the 'advanced' Radio Button to the 'types' ButtonGroup
	}

	public void buttonClicked(JButton b) //when a button is clicked...
	{
		if(b == encryptButton) //if the encrypt button is clicked
		{
			if(basicRB.isSelected()) //if the 'Basic' radio button is selected
			{
				output.setText(basicEncryption(input.getText())); //encrypts the user input from the JTextField using basic encryption and puts the encrypted string in the output label
			}
			else if(advancedRB.isSelected()) //if the 'Advanced' radio button is selected
			{
				output.setText(advancedEncryption(input.getText())); //encrypts the user input from the JTextField using advanced encryption and puts the encrypted string in the output label
			}

			else
			{
				messageBox("Please select a type of encryption.");
			}
		}
		else if(b == decryptButton) //if the decrypt button is clicked
		{
			if(basicRB.isSelected()) //if the 'Basic' radio button is selected
			{
				output.setText(basicDecryption(input.getText())); //decrypts the user input from the JTextField using basic decryption and puts the decrypted string in the output label
			}
			else if(advancedRB.isSelected()) //if the 'Advanced' radio button is selected
			{
				output.setText(advancedDecryption(input.getText())); //decrypts the user input from the JTextField using advanced decryption and puts the decrypted string in the output label
			}
			else
			{
				messageBox("Please select a type of decryption.");
			}
		}
	}

	//basic encryption methods (using caesar cipher with a shift of 5)
	public String basicEncryption(String s) //this method uses a caesar cipher to shift letters 5 to the right (very secure)
	{
		StringBuilder e = new StringBuilder(); //StringBuilder is efficient for string manipulation; this variable stores the encrypted string and its string value will be returned
		for(int i = 0; i < s.length(); i++) //for each character in the original string
		{
			int ascii = (int)s.charAt(i) + 5; //converts each character in the original string into its value and adds 5 to that value
			e.append(((char) ascii)); //converts the ascii value back into a character and appends it to the end of the StringBuilder
		}
		return e.toString(); //returns the String value of the StringBuilder e
	}

	public String basicDecryption(String s) //this method uses a caesar cipher to shift letters 5 to the left
	{
		StringBuilder d = new StringBuilder(); //StringBuilder is efficient for string manipulation; this variable stores the decrypted string and its string value will be returned
		for(int i = 0; i < s.length(); i++) //for each character in the original string
		{
			int ascii = (int)s.charAt(i) - 5; //converts each character in the original string into its value and subtracts 5 from that value
			d.append(((char) ascii)); //converts the ascii value back into a character and appends it to the end of the StringBuilder
		}
		return d.toString(); //returns the String value of the StringBuilder d
	}

	//advanced encryption methods (using XOR encryption)
	public String advancedEncryption(String s) //this method uses XOR encryption to encrypt the user's String
	{
		StringBuilder e = new StringBuilder(); //StringBuilder is efficient for string manipulation; this variable stores the encrypted string and its string value will be returned
		String key = JOptionPane.showInputDialog("Please enter the key to encrypt with."); //prompts the user for a key
		for(int i = 0; i < s.length(); i++) //for each letter in the user's input String
		{
			int encryptedInt = (s.charAt(i) ^ key.charAt(i%key.length()))+65; //uses the XOR operation on the int values of each char, then adds 65 to fit the ascii char values
			char encryptedChar = (char) encryptedInt; //casts the encryptedInt to a char to add to StringBuilder
			e.append(encryptedChar); //adds the encrypted character to the StringBuilder
		}
		System.out.println(e.toString());
		return e.toString(); //returns the String value of the StringBuilder e
	}

	public String advancedDecryption(String s) //this method uses XOR decryption to decrypt the user's String
	{
		StringBuilder d = new StringBuilder(); //StringBuilder is efficient for string manipulation; this variable stores the decrypted string and its string value will be returned
		String key = JOptionPane.showInputDialog("Please enter the key to decrypt with.");
		for(int i = 0; i < s.length(); i++) //for each letter in the user's input String
		{
			int decryptedInt = ((s.charAt(i)-65) ^ key.charAt(i%key.length())); //TODO: calculations are incorrect, remember to debug
			char decryptedChar = (char) decryptedInt;
			d.append(decryptedChar);
		}
		System.out.println(d.toString());
		return d.toString(); //returns the String value of the StringBuilder d
	}

	public static void main(String[] args)
    {
        JFrame frm = new EncryptionProject(); //constructs a new JFrame
	    frm.setSize(500,600); //sets the size of the JFrame to 500x600
	    frm.setTitle("Encryption Time!"); //sets an informative title
	    frm.setIconImage(new ImageIcon("icon.png").getImage()); //a fun icon image to keep the user engaged
        frm.setVisible(true); //makes the frame visible to the user
	    ((EncryptionProject) frm).messageBox("dalebritton.jpg not found"); //this is a bug that may be fixed in future versions
    }
}
