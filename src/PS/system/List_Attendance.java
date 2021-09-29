package PS.system;

//Importing Class
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class List_Attendance extends JFrame implements ActionListener{ //creating frame

    //declaring table and buttons
    JTable j1;
    JButton b1;
    String h[]={"Emp id","Date Time","First Half","Second Half"};
    String d[][]=new String[15][4];
    int i=0,j=0;

    List_Attendance(){

        super("View Employees Attendance");//Title name
        setSize(800,300);
        setLocation(450,150);

        //Running sql query
        try{
            String q="select * from attendance";
            Conn c1=new Conn();
            ResultSet rs=c1.s.executeQuery(q);
            while(rs.next()){
                d[i][j++]=rs.getString("id");
                d[i][j++]=rs.getString("date_tm");
                d[i][j++]=rs.getString("f_half");
                d[i][j++]=rs.getString("s_half");
                i++;
                j=0;
            }

            j1=new JTable(d,h);

        }catch(Exception e){}

        //Adding button for print
        b1=new JButton("Print");
        add(b1,"South");
        JScrollPane s1=new JScrollPane(j1);
        add(s1);

        b1.addActionListener(this);

    }
    //adding action performer to give response to the buttons
    public void actionPerformed(ActionEvent ae){
        try{
            j1.print();
        }catch(Exception e){}
    }

    public static void main(String[] args)
    {
        new List_Attendance().setVisible(true);

    }
}


