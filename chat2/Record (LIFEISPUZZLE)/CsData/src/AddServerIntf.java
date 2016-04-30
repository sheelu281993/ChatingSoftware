/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author UnKnown
 */
import java.rmi.*;
public interface AddServerIntf extends Remote{

   public int addRecord(String fname,String lname,String email,String pass)throws RemoteException;
}
