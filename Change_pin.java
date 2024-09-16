import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Change_pin extends JFrame implements ActionListener{
    JButton change,back;
    JPasswordField re_enter,rnewpin;
    String pinnumber;
    Change_pin(String pinnumber){
        this.pinnumber=pinnumber;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("logos/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(700,650,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,700,650);
        add(image);

        JLabel text=new JLabel("PIN CHANGE");
        text.setBounds(170,235,400,20);
        text.setForeground(Color.WHITE);
        //text.setFont(new Font("arial",Font.BOLD,17));
        image.add(text);

        JLabel newpin=new JLabel("New PIN");
        //newpin.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
        newpin.setForeground(Color.WHITE);
        newpin.setBounds(130,265,200,20);
        image.add(newpin);

        rnewpin=new JPasswordField();
        rnewpin.setBounds(240,265,150,20);
        image.add(rnewpin);

        JLabel re_enternewpin=new JLabel("Re-Enter New PIN");
        //re_enternewpin.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
        re_enternewpin.setForeground(Color.WHITE);
        re_enternewpin.setBounds(130,295,200,20);
        image.add(re_enternewpin);

        re_enter=new JPasswordField();
        re_enter.setBounds(240,295,150,20);
        image.add(re_enter);

        change=new JButton("PIN CHANGE");
        change.setBounds(275,350,120,20);
        change.setForeground(Color.BLACK);
        change.setBackground(Color.WHITE);
        change.addActionListener(this);
        image.add(change);

        back=new JButton("BACK");
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
    };
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==change){
            String first=rnewpin.getText();
            String second=re_enter.getText();
            if(first.equals(second) && !first.isEmpty()){
                //continue for pin change
                try{
                    String query1 = "UPDATE bank SET pinnumber = '"+first+"' WHERE pinnumber = '"+pinnumber+"'";
                    String query2= "UPDATE signupthree SET pin = '"+first+"' WHERE pin = '"+pinnumber+"'";
                    String query3= "UPDATE login SET pin = '"+first+"' WHERE pin = '"+pinnumber+"'";
                    signuponeconn conn=new signuponeconn();
                    int row1=conn.s.executeUpdate(query1);
                    int row2=conn.s.executeUpdate(query2);
                    int row3=conn.s.executeUpdate(query3);
                    System.out.println("Rows Effected: "+(row1+row2+row3));
                    conn.s.close();
                    conn.c.close();
                    JOptionPane.showMessageDialog(null, "PIN changed Successfully");
                    setVisible(false);
                    new Signinone(pinnumber);
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "PINs don't match.");
                rnewpin.setText("");
                re_enter.setText("");
            }
        }
        else if(ae.getSource()==back){
            setVisible(false);
            new Signinone(pinnumber);
            //back code...
        }
    }
    public static void main(String args[]){
        new Change_pin("");
    }
}
