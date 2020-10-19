import java.util.Scanner;
import javax.swing.*;
import java.awt.event.*;

class D_A_T_E extends JFrame implements ActionListener
{
private static int d,m,y,D;
private static String str;
 D_A_T_E(){d=5; m=8; y=2017; D=6; str="";}
 
public void actionPerformed(ActionEvent e)
 {
   d=5; m=8; y=2017; D=6; str="";
   int day=0,month=1,year=0;
   day=Integer.parseInt(Tell_Me_The_Day.T1.getText());
   month+=Tell_Me_The_Day.C.getSelectedIndex();
   year=Integer.parseInt(Tell_Me_The_Day.T2.getText());
   Find_Day(day,month,year);
   str="It's "+str+"\n On "+day+"/"+month+"/"+year;
   JOptionPane.showMessageDialog(this,str);
 }
 public void Find_Day(int day,int month,int year)
  {
     int Temp=-1;
     if((year*10000+month*100+day)==(y*10000+m*100+d))
        Temp=6;
    else if((year*10000+month*100+day)<(y*10000+m*100+d))
        {
         while((year*10000+month*100+day)!=(y*10000+m*100+d))
	   {
  	     D--;
             if(D<0) D=6;  
	     day++;
             if((day>28&&mon(month,year)<day))
                 {day=1; month++; if(month>12) {month=1; year++;}}
           }
 	  Temp=D;
        }
    else if((year*10000+month*100+day)>(d*1000000+m*10000+y))
        {
	 while((year*10000+month*100+day)!=(y*10000+m*100+d))
         {
	   Temp++;
   	   day--;
	   if(day==0) 
            {
		month--; 
		if(month==0) 
		  {month=12;year--;}
		day=mon(month,year);
	    }
         }
          Temp+=D+1;
      	  Temp%=7;
        }
    Set_Day(Temp);
  }
 public int mon(int M,int Y)
  {
     switch(M)
     {
       case 1: return 31;
       case 2: if((Y%400==0)||(Y%4==0&&Y%100!=0)) return 29;
 	       else return 28;
       case 3: return 31; 
       case 4: return 30;
       case 5: return 31;
       case 6: return 30;
       case 7: return 31;
       case 8: return 31;
       case 9: return 30;
       case 10: return 31;
       case 11: return 30;
       case 12: return 31;
     }
    return 0;
  }
 public void Set_Day(int value)
 {
  switch(value)
  {
   case 0:str="SUNDAY"; break;
   case 1:str="MONDAY"; break;
   case 2:str="TUESDAY"; break;
   case 3:str="WEDNESDAY"; break;
   case 4:str="THURSDAY"; break;
   case 5:str="FRIDAY"; break;
   case 6:str="SATURDAY"; break;
  }
 }
}

public class Tell_Me_The_Day
{
public static JFrame jf;
public static JTextField T1,T2;
public static JComboBox C;
public static JLabel L1,L2,L3,L4;
private static JButton B;

public static void Declare()
 {
   jf=new JFrame("Say The Day");
   T1=new JTextField();
   T2=new JTextField();
   L1=new JLabel("Enter The Date: ");
   L2=new JLabel("Day");
   L3=new JLabel("Month");
   L4=new JLabel("Year");
   String Month_name[]={"January","February","March","April","May","June","July","August","September","October","November","December"};
   C=new JComboBox(Month_name);
   B=new JButton("Get Day");
 }
public static void Design()
 {
   jf.setSize(400,300);
   L1.setBounds(10,10,200,30);
   L2.setBounds(50,50,100,30); 
   L3.setBounds(160,50,100,30);
   L4.setBounds(270,50,100,30);
   T1.setBounds(20,90,100,30);
   C.setBounds(130,90,100,30);
   T2.setBounds(240,90,100,30);
   B.setBounds(120,150,100,30);
 }
public static void Add_Elem()
 {
   jf.add(L1);
   jf.add(L2);
   jf.add(L3);
   jf.add(L4);
   jf.add(T1);
   jf.add(C);
   jf.add(T2);
   jf.add(B);
 }
 public static void main(String args[])
  {
    Declare();
    jf.setVisible(true);
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jf.setLayout(null);
    Design();
    Add_Elem();
    B.addActionListener(new D_A_T_E());
  }
}