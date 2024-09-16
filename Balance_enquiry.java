import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.ResultSet;

public class Balance_enquiry extends JFrame implements ActionListener{
    JButton back;
    String pinnumber;
    Balance_enquiry(String pinnumber){
        this.pinnumber=pinnumber;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("logos/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(700,650,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,700,650);
        add(image);

        JLabel text=new JLabel("Balance amount :");
        text.setBounds(170,235,400,20);
        text.setForeground(Color.WHITE);
        //text.setFont(new Font("arial",Font.BOLD,17));
        image.add(text);

        int balance=0;
        try{
            signuponeconn conn=new signuponeconn();
            String query="SELECT * FROM bank WHERE pinnumber = '"+pinnumber+"'";
            ResultSet res=conn.s.executeQuery(query);
            while(res.next()){
                if(res.getString("type").equals("deposit")){
                    balance+=Integer.parseInt(res.getString("amount"));
                }
                if(res.getString("type").equals("withdraw")){
                    balance-=Integer.parseInt(res.getString("amount"));
                }
            }
            conn.s.close();
            conn.c.close();
        }
        catch(Exception e){
            System.out.println(e);
        }

        JLabel amounttext=new JLabel(" "+ balance);
        amounttext.setBounds(300,235,400,20);
        amounttext.setForeground(Color.WHITE);
        //text.setFont(new Font("arial",Font.BOLD,17));
        image.add(amounttext);

        back=new JButton("Back");
        back.setBounds(275,375,120,18);
        back.setForeground(Color.BLACK);
        back.setBackground(Color.WHITE);
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
        }
    }
    
    public static void main(String args[]){
        new Balance_enquiry("");
    }
}
