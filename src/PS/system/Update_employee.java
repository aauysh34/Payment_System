package PS.system;

//Importing Class
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Update_employee extends JFrame implements ActionListener,ItemListener{
    JLabel l1,l2,l3,l4,l5,l6,l7,emp;//declaring label
    JTextField t1,t2,t3,t4,t5,t6,t7;//declaring text field
    JButton b1,b2;//declaring button
    Choice c1,c2;//declaring choice

    Update_employee(){

        super("Update Employee");

        setLayout(null);
        getContentPane().setBackground(new Color(114, 204, 198));//adding background pane and colour

        c2 = new Choice();
        c2.setBounds(160,40,200,20);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");

            while(rs.next()){
                c2.add(rs.getString("id"));
            }
        }catch(Exception e){ }

        emp = new JLabel("Select Empno");
        emp.setBounds(40,40,100,20);
        add(emp);
        add(c2);

        l1 = new JLabel("Name : ");
        t1 = new JTextField(15);

        l1.setBounds(40,80,100,20);
        t1.setBounds(160,80,200,20);
        add(l1);
        add(t1);

        c1 = new Choice();
        c1.add("Male");
        c1.add("Female");

        l2 = new JLabel("Gender : ");

        l2.setBounds(40,120,100,20);
        c1.setBounds(160,120,200,20);
        add(l2);
        add(c1);

        l3 = new JLabel("Address : ");
        t3 = new JTextField(15);

        l3.setBounds(40,160,100,20);
        t3.setBounds(160,160,200,20);
        add(l3);
        add(t3);

        l4 = new JLabel("State : ");
        t4 = new JTextField(15);

        l4.setBounds(40,200,100,20);
        t4.setBounds(160,200,200,20);
        add(l4);
        add(t4);

        l5 = new JLabel("City : ");
        t5 = new JTextField(15);

        l5.setBounds(40,240,100,20);
        t5.setBounds(160,240,200,20);
        add(l5);
        add(t5);

        l6 = new JLabel("Email : ");
        t6 = new JTextField(15);

        l6.setBounds(40,280,100,20);
        t6.setBounds(160,280,200,20);
        add(l6);
        add(t6);

        l7 = new JLabel("Phone : ");
        t7= new JTextField(15);

        l7.setBounds(40,320,100,20);
        t7.setBounds(160,320,200,20);
        add(l7);
        add(t7);

        b1 =new JButton("Update");
        b2 = new JButton("Delete");

        b1.setBounds(40,400,150,30);
        b2.setBounds(200,400,150,30);
        add(b1);
        add(b2);

        b1.setBackground(new Color(7, 119, 113));
        b1.setForeground(Color.WHITE);

        b2.setBackground(new Color(7, 119, 113));
        b2.setForeground(Color.WHITE);

        b1.addActionListener(this);
        b2.addActionListener(this);

        c2.addItemListener(this);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("PS/icons/pay.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1500,900,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1500,800);
        add(l3);

        //setting windows visibility,size and location on screen
        setVisible(true);
        setSize(400,500);
        setLocation(600,200);
    }
    //adding action perfomer to give response to the buttons
    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==b1){
            String n = t1.getText();
            String g = c1.getSelectedItem();
            String a = t3.getText();
            String s = t4.getText();
            String c = t5.getText();
            String e = t6.getText();
            String p = t7.getText();
            String qry = "update employee set name='"+n+"',gender='"+g+"',address='"+a+"',state='"+s+"',city='"+c+"',email='"+e+"',phone='"+p+"'   where id="+c2.getSelectedItem();

            try{
                Conn c1 = new Conn();
                c1.s.executeUpdate(qry);
                JOptionPane.showMessageDialog(null,"Employee Updated");
                dispose();
            }catch(Exception ee){
                ee.printStackTrace();
            }
        }

        if(ae.getSource()==b2){
            try{
                Conn c1 = new Conn();
                c1.s.executeUpdate("delete from employee where id="+c2.getSelectedItem());
                JOptionPane.showMessageDialog(null,"Employee Deleted");
                this.setVisible(false);
            }catch(Exception ee){
                ee.printStackTrace();
            }
        }
    }

    public void itemStateChanged(ItemEvent ie){
        try{
            Conn c1 = new Conn();
            ResultSet rs = c1.s.executeQuery("select * from employee where id="+c2.getSelectedItem());

            if(rs.next()){
                t1.setText(rs.getString("name"));
                t3.setText(rs.getString("address"));
                t4.setText(rs.getString("state"));
                t5.setText(rs.getString("city"));
                t6.setText(rs.getString("email"));
                t7.setText(rs.getString("phone"));
            }

        }catch(Exception ee){
            ee.printStackTrace();
        }

    }

    public static void main(String[] args){

        new Update_employee();
    }

}

