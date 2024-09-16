import java.awt.event.*;
import java.sql.ResultSet;
import java.awt.*;
import javax.swing.*;

public class Statement extends JFrame implements ActionListener{
    JButton back;
    String pinnumber;
    Statement(String pinnumber){
        this.pinnumber=pinnumber;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("logos/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(700,650,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,700,650);
        add(image);

        JLabel text=new JLabel("Canara Bank");
        text.setBounds(230,210,400,20);
        text.setForeground(Color.WHITE);
        //text.setFont(new Font("arial",Font.BOLD,17));
        image.add(text);

        JLabel cardtext=new JLabel();
        cardtext.setBounds(130,240,400,18);
        cardtext.setForeground(Color.WHITE);
        //text.setFont(new Font("arial",Font.BOLD,17));
        image.add(cardtext);

        try{
            signuponeconn conn=new signuponeconn();
            String query1="SELECT * FROM login WHERE pin='"+pinnumber+"'";
            ResultSet res=conn.s.executeQuery(query1);
            String cardno="XXXXXXXXXXXXXXX";
            if(res.next())
            cardno=res.getString("cardnumber");
            cardtext.setText("CardNumber: "+cardno.substring(0,4)+"XXXXXXXX"+cardno.substring(11,15));
            conn.s.close();
            conn.c.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        //code for mini_statement
        JLabel mini=new JLabel();
        mini.setBounds(125,260,400,100);
        mini.setForeground(Color.WHITE);
        image.add(mini);

        try{
            signuponeconn conn=new signuponeconn();
            String query="SELECT * FROM bank WHERE pinnumber ='"+pinnumber+"' order by date asc";
            ResultSet res=conn.s.executeQuery(query);
            StringBuilder sb=new StringBuilder();
            int count=1;
            sb.append("<html>");
            while(res.next() && count<=5){
                sb.append(res.getString("date"));
                sb.append("  ");
                sb.append(res.getString("type"));
                sb.append("  ");
                sb.append(res.getString("amount"));
                sb.append("<br>");
                count++;
            }
            sb.append("<html>");
            mini.setText(sb.toString());
            conn.s.close();
            conn.c.close();
        }
        catch(Exception e){
            System.out.println(e);
        }

        int balance=0;
        try{
            signuponeconn conn=new signuponeconn();
            ResultSet result=conn.s.executeQuery("SELECT * FROM bank WHERE pinnumber='"+pinnumber+"'");
            while(result.next()){
                if(result.getString("type").equals("deposit"))
                    balance+=Integer.parseInt(result.getString("amount"));
                else
                    balance-=Integer.parseInt(result.getString("amount"));
            }
            conn.s.close();
            conn.c.close();
        }
        catch(Exception e){
            System.out.println(e);
        }

        JLabel balancetext=new JLabel();
        balancetext.setText("Balance: "+balance);
        balancetext.setBounds(130,370,380,20);
        balancetext.setForeground(Color.WHITE);
        balancetext.setBackground(Color.WHITE);
        image.add(balancetext);

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
            //code for back_button
        }
    }
    public static void main(String args[]){
        new Statement("");
    }
}
