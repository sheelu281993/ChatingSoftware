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
public interface AddServerIntf extends Remote{

   public void addRecord(String fname,String lname,String email,String pass)throws RemoteException;
}
