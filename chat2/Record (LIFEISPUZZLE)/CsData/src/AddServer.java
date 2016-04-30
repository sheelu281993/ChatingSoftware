/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author UnKnown
 */

import java.rmi.*;
public class AddServer {
    public static void main(String args[])
    {
        try
        {
         AddServerImpl addServerImpl=new AddServerImpl();
         Naming.rebind("AddServer", addServerImpl);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

}
