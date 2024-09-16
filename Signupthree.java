import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Signupthree extends JFrame implements ActionListener {
    JButton cancel,submit;
    String formno;
    JRadioButton savingsac, currentac, fixedac, recuringac;
    JCheckBox chequebook, mobilebanking, atmservice, internetbank, alerts, statements,finaltext;
    
    Signupthree(String formno){
        this.formno=formno;

        JLabel text=new JLabel("ACCOUNT DETAILS");
        text.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,22));
        text.setBounds(200,50,700,22);
        add(text);

        JLabel type=new JLabel("Account Type");
        type.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
        type.setBounds(100,120,500,30);
        add(type);

        savingsac=new JRadioButton("Savings account");
        savingsac.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
        savingsac.setBounds(130,170,200,20);
        savingsac.setBackground(Color.WHITE);
        add(savingsac);

        currentac=new JRadioButton("Current account");
        currentac.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
        currentac.setBounds(130,200,200,20);
        currentac.setBackground(Color.WHITE);
        add(currentac);

        fixedac=new JRadioButton("Fixed deposit account");
        fixedac.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
        fixedac.setBounds(350,170,300,20);
        fixedac.setBackground(Color.WHITE);
        add(fixedac);

        recuringac=new JRadioButton("Recuring deposit account");
        recuringac.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
        recuringac.setBounds(350,200,300,20);
        recuringac.setBackground(Color.WHITE);
        add(recuringac);

        ButtonGroup group=new ButtonGroup();
        group.add(savingsac);
        group.add(currentac);
        group.add(fixedac);
        group.add(recuringac);

        JLabel cardno=new JLabel("Card Number  :");
        cardno.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
        cardno.setBounds(100,240,350,20);
        add(cardno);

        JLabel cardnumber=new JLabel("XXXX-XXXX-XXXX-1234");
        cardnumber.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
        cardnumber.setBounds(250,240,300,20);
        add(cardnumber);

        JLabel cardtext=new JLabel("Your 16 Digit Card Number");
        cardtext.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,10));
        cardtext.setBounds(100,265,350,10);
        add(cardtext);

        JLabel pinno=new JLabel("PIN Number    :");
        pinno.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
        pinno.setBounds(100,295,350,20);
        add(pinno);

        JLabel pin=new JLabel("XXXX");
        pin.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
        pin.setBounds(250,295,60,20);
        add(pin);

        JLabel pintext=new JLabel("Your 4 Digit PIN Number");
        pintext.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,10));
        pintext.setBounds(100,320,350,10);
        add(pintext);

        JLabel services=new JLabel("Services Required");
        services.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
        services.setBounds(100,370,350,20);
        add(services);

        atmservice=new JCheckBox("ATM CARD");
        atmservice.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
        atmservice.setBackground(Color.WHITE);
        atmservice.setBounds(130,400,200,20);
        add(atmservice);

        mobilebanking=new JCheckBox("Mobile Banking");
        mobilebanking.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
        mobilebanking.setBackground(Color.WHITE);
        mobilebanking.setBounds(130,430,200,20);
        add(mobilebanking);

        chequebook=new JCheckBox("Cheque Book");
        chequebook.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
        chequebook.setBackground(Color.WHITE);
        chequebook.setBounds(130,460,200,20);
        add(chequebook);

        internetbank=new JCheckBox("Internet Banking");
        internetbank.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
        internetbank.setBackground(Color.WHITE);
        internetbank.setBounds(350,400,300,20);
        add(internetbank);

        alerts=new JCheckBox("EMAIL & SMS Alerts");
        alerts.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
        alerts.setBackground(Color.WHITE);
        alerts.setBounds(350,430,300,20);
        add(alerts);

        statements=new JCheckBox("E-Statement");
        statements.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
        statements.setBackground(Color.WHITE);
        statements.setBounds(350,460,300,20);
        add(statements);

        finaltext=new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge.");
        finaltext.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,12));
        finaltext.setBounds(130,535,600,12);
        finaltext.setBackground(Color.WHITE);
        add(finaltext);

        cancel=new JButton("CANCEL");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(150,570,100,30);
        cancel.addActionListener(this);
        add(cancel);

        submit=new JButton("SUBMIT");
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLACK);
        submit.setBounds(450,570,100,30);
        submit.addActionListener(this);
        add(submit);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(730,700);
        setVisible(true);
        setTitle("sign_up_form_3");
        setLocation(300,50);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==cancel){
            setVisible(false);
            new Login();
        }
        else if(ae.getSource()==submit && finaltext.isSelected()){
            String accounttype=null;
            if(savingsac.isSelected()){
                accounttype="Savings account";
            }
            else if(currentac.isSelected()){
                accounttype="Current account";
            }
            else if(fixedac.isSelected()){
                accounttype="Fixed account";
            }
            else if(recuringac.isSelected()){
                accounttype="Recuring account";
            }
            Random random=new Random();
            String cardnumber=""+(Math.abs((random.nextLong()/9000000000000L))+ 4801421400000000L);
            String pin=""+(Math.abs(random.nextInt(9000))+1000);

            String facilites="";
            if(chequebook.isSelected()){
                facilites+="Cheque Book";
            }
            if(mobilebanking.isSelected()){
                facilites+="Mobile Banking";
            }
            if(atmservice.isSelected()){
                facilites+="ATM Card";
            }
            if(internetbank.isSelected()){
                facilites+="Internet Banking";
            }
            if(alerts.isSelected()){
                facilites+="EMAIL & SMS alerts";
            }
            if(statements.isSelected()){
                facilites+="E-Statement";
            }


            try{
                signuponeconn conn=new signuponeconn();

                String query="INSERT INTO signupthree(formno, accounttype, cardnumber, pin, services) VALUES ('"+formno+"','"+accounttype+"','"+cardnumber+"','"+pin+"','"+facilites+"')";
                String credentials="INSERT INTO login(formno, cardnumber, pin) VALUES('"+formno+"','"+cardnumber +"','"+pin+"')";
                int rowseffected=conn.s.executeUpdate(query);
                int rows=conn.s.executeUpdate(credentials);
                System.out.println("Rows Updated in signupthree: "+rowseffected);
                System.out.println("Rows effected in login: "+rows);
                conn.s.close();
                conn.c.close();
            }
            catch(Exception e){
                System.out.println(e);
            }

            JOptionPane.showMessageDialog(null,"cardnumber: "+cardnumber+"\n pin: "+pin);
            setVisible(false);
            new Login();

        }
    }

    public static void main(String args[]){
        new Signupthree("");
    }
}
