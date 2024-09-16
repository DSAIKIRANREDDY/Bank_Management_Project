import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signuptwo extends JFrame implements ActionListener{
    JButton next;
    String formno;
    JComboBox<String> religionbox, categorybox, incomevalues, qualificationvalues, occupationvalues;
    JTextField panfield, adharfield;
    JRadioButton yes,no,eyes,eno;
    Signuptwo(String formno){
        this.formno=formno;

        JLabel page=new JLabel("ADDITIONAL DETAILS");
        page.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,22));
        page.setBounds(250,80,250,22);
        add(page);

        JLabel religion=new JLabel("RELIGION                      :");
        religion.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
        religion.setBounds(150,120,214,20);
        add(religion);

        String[] religions={"Hindu","Muslim","Chirstian","Bhramhin","Others"};
        religionbox=new JComboBox<>(religions);
        religionbox.setBounds(370,120,230,25);
        religionbox.setBackground(Color.WHITE);
        add(religionbox);

        JLabel category=new JLabel("CATEGORY                   :");
        category.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
        category.setBounds(150,160,212,20);
        add(category);

        String[] categories={"General","OBC","SC","ST","Others"};
        categorybox=new JComboBox<>(categories);
        categorybox.setBounds(370,160,230,25);
        categorybox.setBackground(Color.WHITE);
        add(categorybox);

        JLabel income=new JLabel("INCOME                         :");
        income.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
        income.setBounds(150,200,210,20);
        add(income);

        String[] incomes={"Null","lessthan 1,50,000","lessthan 2,50,000","lessthan 5,00,000","lessthan 10,00,000"};
        incomevalues=new JComboBox<>(incomes);
        incomevalues.setBackground(Color.WHITE);
        incomevalues.setBounds(370,200,230,25);
        add(incomevalues);        

        JLabel qualification=new JLabel("EDUCATIONAL");
        qualification.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
        qualification.setBounds(150,240,210,20);
        add(qualification);

        JLabel qualify=new JLabel("QUALIFICATION        :");
        qualify.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
        qualify.setBounds(150,262,210,20);
        add(qualify);

        String[] qualifications={"Non-Graduation","Graduate","Post-Graduation","Doctrate","Others"};
        qualificationvalues=new JComboBox<>(qualifications);
        qualificationvalues.setBackground(Color.WHITE);
        qualificationvalues.setBounds(370,262,230,25);
        add(qualificationvalues);

        JLabel occupation=new JLabel("OCCUPATION              :");
        occupation.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
        occupation.setBounds(150,302,210,20);
        add(occupation);

        String[] occupations={"salaried","self employed","Business","Student","Retired"};
        occupationvalues=new JComboBox<>(occupations);
        occupationvalues.setBackground(Color.WHITE);
        occupationvalues.setBounds(370,302,230,25);
        add(occupationvalues);

        JLabel pan=new JLabel("PAN NUMBER             :");
        pan.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
        pan.setBounds(150,342,210,20);
        add(pan);

        panfield=new JTextField();
        panfield.setFont(new Font("arial",Font.BOLD,18));
        panfield.setBounds(370,342,230,25);
        add(panfield);        

        JLabel adhar=new JLabel("AADHAR NUMBER    :");
        adhar.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
        adhar.setBounds(150,382,210,20);
        add(adhar);

        adharfield=new JTextField();
        adharfield.setFont(new Font("arial",Font.BOLD,18));
        adharfield.setBounds(370,382,230,25);
        add(adharfield);

        JLabel agegroup=new JLabel("SENIOR CITIZEN       :");
        agegroup.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
        agegroup.setBounds(150,422,210,20);
        add(agegroup);

        yes=new JRadioButton("YES");
        yes.setBounds(370,422,70,20);
        yes.setBackground(Color.WHITE);
        add(yes);

        no=new JRadioButton("NO");
        no.setBounds(450,422,70,20);
        no.setBackground(Color.WHITE);
        add(no);

        ButtonGroup age=new ButtonGroup();
        age.add(yes);
        age.add(no);

        JLabel existingac=new JLabel("EXISTING ACCOUNT:");
        existingac.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
        existingac.setBounds(150,462,210,20);
        add(existingac);

        eyes=new JRadioButton("YES");
        eyes.setBounds(370,462,70,20);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno=new JRadioButton("NO");
        eno.setBounds(450,462,70,20);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup agee=new ButtonGroup();
        agee.add(eyes);
        agee.add(eno);

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
        setTitle("sign_up_form_2");
        setLocation(300,50);
    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()== next){
            String sreligion=(String)religionbox.getSelectedItem();
            String scategory=(String) categorybox.getSelectedItem();
            String sincome=(String) incomevalues.getSelectedItem();
            String squalification=(String) qualificationvalues.getSelectedItem();
            String soccupation=(String) occupationvalues.getSelectedItem();
            String span=panfield.getText();
            String saadhar=adharfield.getText();
            String ssenior="";
            if(yes.isSelected()){
                ssenior="yes";
            }
            else if(no.isSelected()){
                ssenior="no";
            }
            String existsac="";
            if(eyes.isSelected()){
                existsac="yes";
            }
            else if(eno.isSelected()){
                existsac="no";
            }

            if(!sreligion.isEmpty() && !ssenior.isEmpty() && !existsac.isEmpty() && !scategory.isEmpty() && !sincome.isEmpty() && !squalification.isEmpty() && !soccupation.isEmpty() && !span.isEmpty() && !saadhar.isEmpty()){
                try{
                signuponeconn conn=new signuponeconn();
                String query = "INSERT INTO signuptwo (formno, religion, category, income, qualification, occupation, pan, aadhar, senior, existsaccount) " +
                   "VALUES ('" + formno + "', '" + sreligion + "', '" + scategory + "', '" + sincome + "', '" + squalification + "', '" + soccupation + "', '" + span + "', '" + saadhar + "', '" + ssenior + "', '" + existsac + "')";
                int rowseffected = conn.s.executeUpdate(query);
                System.out.print("Rows Effected:"+rowseffected);
                conn.s.close();
                conn.c.close();
                }
                catch (Exception e){
                    System.out.println(e);
                }

                setVisible(false);
                new Signupthree(formno);
            }
            else{
                JOptionPane.showMessageDialog(null,"Please Fill the total form");
            }
        }

    }

    public static void main(String args[]){
        new Signuptwo("");
    }
}
