import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{
    JButton deposit,back;
    JTextField amount;
    String pinnumber;
    Deposit(String pinnumber){
        this.pinnumber=pinnumber;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("logos/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(700, 650, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,700,650);
        add(image);

        JLabel text=new JLabel("Enter the amount want to Deposit");
        text.setForeground(Color.WHITE);
        text.setBounds(170,235,400,20);
        image.add(text);

        amount=new JTextField();
        amount.setBounds(170,265,200,20);
        image.add(amount);

        deposit=new JButton("Deposit");
        deposit.setBounds(275,350,120,20);
        deposit.setForeground(Color.BLACK);
        deposit.setBackground(Color.WHITE);
        deposit.addActionListener(this);
        image.add(deposit);

        back=new JButton("Back");
        back.setBounds(275,375,120,18);
        back.setForeground(Color.BLACK);
        back.setBackground(Color.WHITE);
        back.addActionListener(this);
        image.add(back);

        add(image);
        setTitle("ATM");
        setLayout(null);
        setSize(700,650);
        //setUndecorated(true);
        setLocation(350,100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==deposit && !pinnumber.isEmpty()){
            //deposit code...
            String number=amount.getText();
            signuponeconn conn=new signuponeconn();
            try{
                Date date=new Date();
                String query="INSERT INTO bank (pinnumber, date, type, amount) VALUES ('"+pinnumber+"','"+date+"','deposit','"+number+"')";
                int rowseffected=conn.s.executeUpdate(query);
                System.out.println("Rows Effected: "+rowseffected);
                JOptionPane.showMessageDialog(null, "Amount "+number+" Successfully deposited");
                setVisible(false);
                new Signinone(pinnumber);
                conn.s.close();
                conn.c.close();
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource()==back){
            setVisible(false);
            new Signinone(pinnumber);
            //back code...
        }
    }

    public static void main(String args[]){
            new Deposit("");
    }
}
