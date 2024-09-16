import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener{
    JButton withdrawl,back;
    String pinnumber;
    JTextField amount;
    Withdrawl(String pinnumber){
        this.pinnumber=pinnumber;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("logos/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(700, 650, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,700,650);
        add(image);

        JLabel text=new JLabel("Enter the amount want to Withdrawl");
        text.setForeground(Color.WHITE);
        text.setBounds(170,235,400,20);
        image.add(text);

        amount=new JTextField();
        amount.setBounds(170,265,200,20);
        image.add(amount);

        withdrawl=new JButton("Withdrawl");
        withdrawl.setBounds(275,350,120,20);
        withdrawl.setForeground(Color.BLACK);
        withdrawl.setBackground(Color.WHITE);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

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
        if(ae.getSource()==withdrawl){
            String number=amount.getText();
            Date date=new Date();
            if(!number.isEmpty()){
                try{
                    signuponeconn conn=new signuponeconn();
                    int balance=0;
                    String balquery = "SELECT * FROM bank WHERE pinnumber = '" + pinnumber + "'";
                    ResultSet res=conn.s.executeQuery(balquery);
                    while(res.next()){
                        if(res.getString("type").equals("deposit")){
                            balance+=Integer.parseInt(res.getString("amount"));
                        }
                        else{
                            balance-=Integer.parseInt(res.getString("amount"));
                        }
                    }
                    int fund=Integer.parseInt(number);
                    if(balance>=fund){
                        String query = "INSERT INTO bank (pinnumber, date, type, amount) VALUES ('" + pinnumber + "','" + date + "','withdraw','" + number + "')";
                        int rowseffected=conn.s.executeUpdate(query);
                        System.out.println("Rows Efected: "+rowseffected);
                        conn.s.close();
                        conn.c.close();
                        JOptionPane.showMessageDialog(null, "Amount "+ number+ " withdraw Successfully");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Insufficient Funds");
                    }
                }
                catch(Exception e){
                    System.out.println(e);
                }
                setVisible(false);
                new Signinone(pinnumber);
            }
            else{
                JOptionPane.showMessageDialog(null, "Enter amounted to withdraw");
            }
        }
        else if(ae.getSource()==back){
            setVisible(false);
            new Signinone(pinnumber);
            //back code...
        }
    }
    public static void main(String args[]){
        new Withdrawl("");
    }
}
