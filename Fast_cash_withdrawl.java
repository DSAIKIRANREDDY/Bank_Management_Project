import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;
import java.sql.*;

public class Fast_cash_withdrawl extends JFrame implements ActionListener{
    JButton hundred,five_hundred,thousand,two_thousand,five_thousand,ten_thousand,back;
    String pinnumber;

    Fast_cash_withdrawl(String pinnumber){
        this.pinnumber=pinnumber;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("logos/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(700,650,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,700,650);
        add(image);

        JLabel text=new JLabel("Select Withdrawl amount");
        text.setBounds(170,235,400,20);
        text.setForeground(Color.WHITE);
        //text.setFont(new Font("arial",Font.BOLD,17));
        image.add(text);

        hundred=new JButton("Rs 100");
        hundred.setForeground(Color.BLACK);
        hundred.setBounds(130,300,100,22);
        hundred.addActionListener(this);
        image.add(hundred);

        five_thousand=new JButton("Rs 5000");
        five_thousand.setForeground(Color.BLACK);
        five_thousand.setBounds(130,350,100,22);
        five_thousand.addActionListener(this);
        image.add(five_thousand);

        thousand=new JButton("Rs 1000");
        thousand.setForeground(Color.BLACK);
        thousand.setBounds(130,325,100,22);
        thousand.addActionListener(this);
        image.add(thousand);

        five_hundred=new JButton("Rs 500");
        five_hundred.setForeground(Color.BLACK);
        five_hundred.setBounds(265,300,130,22);
        five_hundred.addActionListener(this);
        image.add(five_hundred);

        two_thousand=new JButton("Rs 2000");
        two_thousand.setForeground(Color.BLACK);
        two_thousand.setBounds(265,325,130,22);
        two_thousand.addActionListener(this);
        image.add(two_thousand);

        ten_thousand=new JButton("Rs 10000");
        ten_thousand.setForeground(Color.BLACK);
        ten_thousand.setBounds(265,350,130,22);
        ten_thousand.addActionListener(this);
        image.add(ten_thousand);

        back=new JButton("Back");
        back.setForeground(Color.BLACK);
        back.setBounds(265,375,130,22);
        back.addActionListener(this);
        image.add(back);

        setTitle("ATM");
        setLayout(null);
        setSize(700,650);
        //setUndecorated(true);
        setLocation(350,100);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Signinone(pinnumber);
            //back to signinone code...
        }
        else{
            String amount=null;
            if(ae.getSource()==hundred){
                //hundred code...
                amount="100";
            }
            else if(ae.getSource()==five_hundred){
                //five hundred code...
                amount="500";
            }
            else if(ae.getSource()==thousand){
                //thousand code...
                amount="1000";
            }
            else if(ae.getSource()==two_thousand){
                //two thousand code...
                amount="2000";
            }
            else if(ae.getSource()==five_thousand){
                //five thousand code...
                amount="5000";
            }
            else if(ae.getSource()==ten_thousand){
                //ten thousand code...
                amount="10000";
            }
            Date date=new Date();
            signuponeconn conn=new signuponeconn();
            int balance=0;
            int fund=Integer.parseInt(amount);
            try{
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
                

                if(balance>=fund){
                    String query="INSERT INTO bank (pinnumber, date, type, amount) VALUES ('"+pinnumber+"','"+date+"','withdraw','"+amount+"')";
                    int rowseffected=conn.s.executeUpdate(query);
                    System.out.println("Rows effected: "+rowseffected);
                    JOptionPane.showMessageDialog(null, "Amount "+amount+" withraw Successfully");
                    setVisible(false);
                    new Signinone(pinnumber);
                }
                else{
                    JOptionPane.showMessageDialog(null, "InSufficient Funds");
                    setVisible(false);
                    new Signinone(pinnumber);
                    return;
                }
                conn.s.close();
                conn.c.close();
            }
            catch(Exception e){
                System.out.println(e);
            }

        }
        
    }
    public static void main(String args[]){
        new Fast_cash_withdrawl("");
    }
}

