import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JButton signin,signup,clear;
    JTextField cardtextfield;
    JPasswordField pintextfield;

    Login(){
        setSize(600,500);

        ImageIcon imageicon=new ImageIcon(ClassLoader.getSystemResource("logos/logo.jpg"));
        Image image=imageicon.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i1=new ImageIcon(image);
        JLabel label=new JLabel(i1);
        label.setBounds(120,90,100,100);
        add(label);

        JLabel textLabel=new JLabel("WELCOME TO ATM");
        textLabel.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
        textLabel.setBounds(250,130,200,20);
        add(textLabel);

        JLabel cardno=new JLabel("Card no :");
        cardno.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,15));
        cardno.setBounds(150,220,100,20);
        add(cardno);

        JLabel pin=new JLabel("        Pin :");
        pin.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,15));
        pin.setBounds(150,250,100,20);
        add(pin);

        cardtextfield=new JTextField();
        cardtextfield.setBounds(230,220,200,25);
        cardtextfield.setFont(new Font("arial",Font.BOLD,15));
        add(cardtextfield);

        pintextfield=new JPasswordField();
        pintextfield.setBounds(230,250,200,25);
        add(pintextfield);

        signin=new JButton("SIGN IN");
        signin.setForeground(Color.WHITE);
        signin.setBackground(Color.BLACK);
        signin.setBounds(200,300,90,25);
        signin.addActionListener(this);
        add(signin);

        clear=new JButton("CLEAR");
        clear.setForeground(Color.WHITE);
        clear.setBackground(Color.BLACK);
        clear.setBounds(320,300,90,25);
        clear.addActionListener(this);
        add(clear);

        signup=new JButton("SIGN UP");
        signup.setForeground(Color.WHITE);
        signup.setBackground(Color.BLACK);
        signup.setBounds(260,340,90,25);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setTitle("ATM");
        setVisible(true);
        setLocation(500,100);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== clear){
            cardtextfield.setText("");
            pintextfield.setText("");
        }
        else if(ae.getSource()== signin){
            signuponeconn conn=new signuponeconn();
            String cardnumber=cardtextfield.getText();
            String pin=pintextfield.getText();
            if(!cardnumber.isEmpty() && !pin.isEmpty()){
                try{
                String query="SELECT * FROM login where cardnumber ='"+cardnumber+"'and pin ='"+pin+"'";
                ResultSet result=conn.s.executeQuery(query);
                if(result.next()){
                    setVisible(false);
                    new Signinone(pin);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid Account number or Password");
                }
                conn.s.close();
                conn.c.close();
                }
                catch(Exception e){
                    System.out.print(e);
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"Enter Account number and Password");
            }
        }
        else if(ae.getSource()== signup){
           setVisible(false);
           new Signupone();
        }
    }
    public static void main(String[] args) {
        new Login();
    }
}