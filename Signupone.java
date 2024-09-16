import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class Signupone extends JFrame implements ActionListener {
    JButton next;
    int appformno;
    JTextField namefield, fnamefield, emailfield, addressfield, cityfield, statefield, pincodefield;
    JTextField dobchooser;
    JRadioButton male, female, married, unmarried, others;
    Signupone(){
        appformno=1000+Math.abs((int)(Math.random()*1000));

        JLabel text=new JLabel("APPLICATION NO:"+ appformno);
        text.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,40));
        text.setBounds(120,30,650,40);
        add(text);

        JLabel page=new JLabel("PERSONAL DETAILS");
        page.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,22));
        page.setBounds(250,80,250,22);
        add(page);

        JLabel name=new JLabel("NAME                           :");
        name.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
        name.setBounds(150,120,200,20);
        add(name);

        namefield=new JTextField();
        namefield.setFont(new Font("arial",Font.BOLD,18));
        namefield.setBounds(370,120,230,25);
        add(namefield);

        JLabel fathername=new JLabel("FATHER NAME         :");
        fathername.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
        fathername.setBounds(150,160,200,20);
        add(fathername);

        fnamefield=new JTextField();
        fnamefield.setFont(new Font("arial",Font.BOLD,18));
        fnamefield.setBounds(370,160,230,25);
        add(fnamefield);

        JLabel dob=new JLabel("DATE OF BIRTH       :");
        dob.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
        dob.setBounds(150,200,200,20);
        add(dob);

        dobchooser=new JTextField();
        dobchooser.setBounds(370,200,230,25);
        dobchooser.setFont(new Font("arial",Font.BOLD,18));
        add(dobchooser);

        JLabel gender=new JLabel("GENDER                      :");
        gender.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
        gender.setBounds(150,240,200,20);
        add(gender);

        male=new JRadioButton("MALE");
        male.setBounds(370,240,65,20);
        male.setForeground(Color.BLACK);
        male.setBackground(Color.WHITE);
        add(male);

        female=new JRadioButton("FEMALE");
        female.setBounds(435,240,75,20);
        female.setForeground(Color.BLACK);
        female.setBackground(Color.WHITE);
        add(female);

        others=new JRadioButton("OTHERS");
        others.setBounds(515,240,85,20);
        others.setForeground(Color.BLACK);
        others.setBackground(Color.WHITE);
        add(others);

        ButtonGroup group=new ButtonGroup();
        group.add(male);
        group.add(female);
        group.add(others);

        JLabel email=new JLabel("EMAIL                         :");
        email.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
        email.setBounds(150,280,200,20);
        add(email);

        emailfield=new JTextField();
        emailfield.setFont(new Font("arial",Font.BOLD,18));
        emailfield.setBounds(370,280,230,25);
        add(emailfield);

        JLabel marital=new JLabel("MARITAL STATUS  :");
        marital.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
        marital.setBounds(150,320,200,20);
        add(marital);

        married=new JRadioButton("MARRIED");
        married.setBounds(370,320,90,20);
        married.setForeground(Color.BLACK);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried=new JRadioButton("UNMARRIED");
        unmarried.setBounds(460,320,100,20);
        unmarried.setForeground(Color.BLACK);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        ButtonGroup groups=new ButtonGroup();
        groups.add(married);
        groups.add(unmarried);

        JLabel address=new JLabel("ADDRESS                    :");
        address.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
        address.setBounds(150,360,200,20);
        add(address);

        addressfield=new JTextField();
        addressfield.setFont(new Font("arial",Font.BOLD,18));
        addressfield.setBounds(370,360,230,25);
        add(addressfield);

        JLabel city=new JLabel("CITY                             :");
        city.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
        city.setBounds(150,400,200,20);
        add(city);

        cityfield=new JTextField();
        cityfield.setFont(new Font("arial",Font.BOLD,18));
        cityfield.setBounds(370,400,230,25);
        add(cityfield);

        JLabel state=new JLabel("STATE                         :");
        state.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
        state.setBounds(150,440,200,20);
        add(state);

        statefield=new JTextField();
        statefield.setFont(new Font("arial",Font.BOLD,18));
        statefield.setBounds(370,440,230,25);
        add(statefield);

        JLabel pincode=new JLabel("PINCODE                   :");
        pincode.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
        pincode.setBounds(150,480,200,20);
        add(pincode);

        pincodefield=new JTextField();
        pincodefield.setFont(new Font("arial",Font.BOLD,18));
        pincodefield.setBounds(370,480,230,25);
        add(pincodefield);

        next=new JButton("NEXT->");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(520,550,80,25);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(730,700);
        setVisible(true);
        setTitle("sign_up_from_1");
        setLocation(300,50);
    }

    public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == next) {
        String formno = " " + appformno;
        String name = namefield.getText();
        String fname = fnamefield.getText();
        String dob = dobchooser.getText();
        String gender = male.isSelected() ? "Male" : female.isSelected() ? "Female" : "Others";
        String email = emailfield.getText();
        String marital = married.isSelected() ? "Married" : unmarried.isSelected() ? "Unmarried" : "";
        String address = addressfield.getText();
        String city = cityfield.getText();
        String state = statefield.getText();
        String pin = pincodefield.getText();

        try {
            if (name.isEmpty() || marital.isEmpty() || gender.isEmpty() || dob.isEmpty() || fname.isEmpty() || email.isEmpty() || address.isEmpty() || city.isEmpty() || state.isEmpty() || pin.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Data is Not entered");
            }
            else {
                signuponeconn conn = new signuponeconn();
                String query = "INSERT INTO signup (formno, name, father_name, dob, gender, email, marital_status, address, city, state, pin) " +
                               "VALUES ('" + formno + "', '" + name + "', '" + fname + "', '" + dob + "', '" + gender + "', '" + email + "', '" + marital + "', '" + address + "', '" + city + "', '" + state + "', '" + pin + "')";
                
                // Execute the update query
                int rowsAffected = conn.s.executeUpdate(query);
                System.out.println("Rows affected: " + rowsAffected);
                
                // Close resources
                conn.s.close();
                conn.c.close();
                setVisible(false);
                new Signuptwo(formno);
            }
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

    public static void main(String args[]){
        new Signupone();
    }
}
