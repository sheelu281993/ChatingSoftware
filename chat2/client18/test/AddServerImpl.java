/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//package Chatapp;

/**
 *
 * @author UnKnown
 */
import java.rmi.*;
import java.rmi.server.*;
import java.sql.*;
public class AddServerImpl extends UnicastRemoteObject implements AddServerIntf{
   public AddServerImpl()throws RemoteException{
   }
   Connection con=null;
   public void addRecord(String fname,String lname,String email,String pass)throws RemoteException
   {
       try{
       System.out.println("kaka");
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        con=DriverManager.getConnection("jdbc:oracle:thin:@:1521:XE","sheelu","sheelu");
         PreparedStatement pstm=null;
        String str="?";
                for(int i=1;i<4;i++)
                {str=str+",?";

                }
        System.out.println(str);
        pstm=con.prepareStatement("insert into member values("+str+")");
                System.out.println("insert");

       pstm.setString(1,fname);
       pstm.setString(2,lname);
       pstm.setString(3,email);
       pstm.setString(4,pass);

                         pstm.executeUpdate();
       //  jLabel21.setText(" succesful added");
         System.out.println("record added");
    }
    catch(Exception e)
    {
        System.out.println(e);
    }
   }

}
