package PS.system;

//Importing Class

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Salary extends JFrame implements ActionListener{

    JLabel l1,l3,l4,l5,l6;//adding label
    JTextField t1,t3,t4,t5,t6;//adding textfield
    JButton b1,b2;//adding button
    Choice c2;//adding choice

    Salary(){

        super("Set Salary");

        setLayout(new GridLayout(8,2,20,20));
        c2 = new Choice();

        //connecting database
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");

            while(rs.next()){
                c2.add(rs.getString("id"));
            }
        }catch(Exception e){ }

        add(new JLabel("Select Empno"));//label for employer no
        add(c2);

        l1 = new JLabel("House rent");//label for house rent allowance
        t1 = new JTextField(15);
        add(l1);
        add(t1);

        l3 = new JLabel("Domestic allowance");//label for domestic allowance
        t3 = new JTextField(15);
        add(l3);
        add(t3);

        l4 = new JLabel("medical allowance");//label for medical allowance
        t4 = new JTextField(15);
        add(l4);
        add(t4);

        l5 = new JLabel("provident fund");//label for provident fund
        t5 = new JTextField(15);
        add(l5);
        add(t5);

        l6 = new JLabel("Basic Salary");//label for Basic salary
        t6 = new JTextField(15);
        add(l6);
        add(t6);

        b1 =new JButton("Submit");//button for submit
        b1.setBackground(new Color(184, 184, 189));
        b1.setForeground(Color.WHITE);

        b2 = new JButton("Cancel");//button for cancel
        b2.setBackground(new Color(183, 183, 187));
        b2.setForeground(Color.WHITE);

        add(b1);
        add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);


//setting windows visibility,size and location on screen

        setSize(450,500);
        setLocation(500,200);
        setVisible(true);



        getContentPane().setBackground(new Color(175, 231, 227));

    }
    //adding action performer to give response to the buttons
    public void actionPerformed(ActionEvent ae){

        String hra = t1.getText();
        String id = c2.getSelectedItem();
        String da = t3.getText();
        String med = t4.getText();
        String pf = t5.getText();
        String basic = t6.getText();
        String qry = "insert into salary values("+id+","+hra+","+da+","+med+","+pf+","+basic+")";

        try{
            Conn c1 = new Conn();//connecting database
            c1.s.executeUpdate(qry);
            JOptionPane.showMessageDialog(null,"Salary updated");
            this.setVisible(false);
        }catch(Exception ee){
            ee.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Salary();

    }
}

