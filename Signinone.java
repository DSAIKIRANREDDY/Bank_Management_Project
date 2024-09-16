import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Signinone extends JFrame implements ActionListener{
    JButton deposit,fastcash,exit,withdrawl,pinchange,statement,enquiry;
    String pinnumber;
    Signinone(String pinnumber){
        this.pinnumber=pinnumber;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("logos/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(700,650,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,700,650);
        add(image);

        JLabel text=new JLabel("Please select your Transaction");
        text.setBounds(170,235,400,20);
        text.setForeground(Color.WHITE);
        //text.setFont(new Font("arial",Font.BOLD,17));
        image.add(text);

        deposit=new JButton("Deposit");
        deposit.setForeground(Color.BLACK);
        deposit.setBounds(130,300,100,22);
        deposit.addActionListener(this);
        image.add(deposit);

        fastcash=new JButton("Fast Cash");
        fastcash.setForeground(Color.BLACK);
        fastcash.setBounds(130,350,100,22);
        fastcash.addActionListener(this);
        image.add(fastcash);

        pinchange=new JButton("Pin Change");
        pinchange.setForeground(Color.BLACK);
        pinchange.setBounds(130,325,100,22);
        pinchange.addActionListener(this);
        image.add(pinchange);

        withdrawl=new JButton("Cash Withdrawl");
        withdrawl.setForeground(Color.BLACK);
        withdrawl.setBounds(265,300,130,22);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        statement=new JButton("Mini Statement");
        statement.setForeground(Color.BLACK);
        statement.setBounds(265,325,130,22);
        statement.addActionListener(this);
        image.add(statement);

        enquiry=new JButton("Balance Enquiry");
        enquiry.setForeground(Color.BLACK);
        enquiry.setBounds(265,350,130,22);
        enquiry.addActionListener(this);
        image.add(enquiry);

        exit=new JButton("Exit");
        exit.setForeground(Color.BLACK);
        exit.setBounds(265,375,130,22);
        exit.addActionListener(this);
        image.add(exit);

        setTitle("ATM");
        setLayout(null);
        setSize(700,650);
        //setUndecorated(true);
        setLocation(350,100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber);
        }
        else if(ae.getSource()==fastcash){
            setVisible(false);
            new Fast_cash_withdrawl(pinnumber);
            //code for fast_cash_withdrawl
        }
        else if(ae.getSource()==pinchange){
            setVisible(false);
            new Change_pin(pinnumber);
            //code for change_pin
        }
        else if(ae.getSource()==withdrawl){
            setVisible(false);
            new Withdrawl(pinnumber);
            //codde for withdrawl
        }
        else if(ae.getSource()==statement){
            setVisible(false);
            new Statement(pinnumber);
            //code for mini statement
        }
        else if(ae.getSource()==enquiry){
            setVisible(false);
            new Balance_enquiry(pinnumber);
            //code for balance_enquiry
        }
        else if(ae.getSource()==exit){
            setVisible(false);
            new Login();
        }
    }
    public static void main(String args[]){
        new Signinone("");
    }
}
