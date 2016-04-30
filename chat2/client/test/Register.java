 import java.rmi.*;
 public class Register
 {
 public static void main(String args[])
	 {
 try
        {
            String addServerURL="rmi://lifeispuzzle/AddServer";
            AddServerIntf addServerIntf=(AddServerIntf)Naming.lookup(addServerURL);
            
            addServerIntf.addRecord(args[0],args[1],args[2],args[3]);

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
 }}