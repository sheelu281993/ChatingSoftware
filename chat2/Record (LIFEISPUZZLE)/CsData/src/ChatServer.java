
import java.io.*;
import java.net.*;
import java.util.*;
public class ChatServer {
    ServerSocket ss=null;
 static   Socket s,s1,s2;
    ArrayList a=new ArrayList();
    ArrayList a1=new ArrayList();
    ArrayList a2=new ArrayList();
static    ArrayList allusers=new ArrayList();
public ChatServer() throws IOException
{
    ss=new ServerSocket(1993);
    while(true)
    {
        s=ss.accept();
        s1=ss.accept();
        s2=ss.accept();
        a.add(s);
        a1.add(s1);
        a2.add(s2);
        ListUsers lu=new ListUsers(s2,a2,allusers);
        Thread t=new Thread(lu);
        t.start();
        MyThread r=new MyThread(s,a);
        Thread t1=new Thread(r);
        t1.start();


    }
    
}
public static void main(String args[]) throws IOException
{

new ChatServer();
}

}
//class used to maintain the list of all usernames
class ListUsers implements Runnable
{
    Socket s2;
    static ArrayList a2;
    static ArrayList allusers;
    static DataInputStream din;
    static DataOutputStream dout;

    ListUsers(Socket s2,ArrayList a2,ArrayList allusers)
    {
       this.s2=s2;
       ListUsers.a2=a2;
       ListUsers.allusers=allusers;
    }
    public void run()
    {
     try
     {
        din=new DataInputStream(s2.getInputStream());
        //store the list of all usernames
        allusers.add(din.readUTF());
        every();
     }
     catch(Exception e){}

    }
  //  send the list of all usernames
  synchronized  static void every() throws Exception{

        Iterator i1=a2.iterator();
        Socket list;
        while(i1.hasNext())
        {
        list=(Socket)i1.next();
        dout=new DataOutputStream(list.getOutputStream());
        ObjectOutputStream obj=new ObjectOutputStream(dout);
        obj.writeObject(allusers);
        dout.flush();
        obj.flush();

        }
    }


}
//class used to send messages to all the clients
class MyThread implements Runnable
{Socket s;
 static ArrayList a;
 DataInputStream din,din1;
 DataOutputStream dout;
 static ArrayList allusers;
 MyThread(Socket s,ArrayList a)
 {
 this.s=s;
 MyThread.a=a;

 }
public void run()
{
   String str;
  String name;
   int i=1;
   try
   { //din1=new DataInputStream(ChatServer.s2.getInputStream());
       din=new DataInputStream(s.getInputStream());
    }
   catch(Exception e)
   {
   }
   while(i==1)
   {
       try{
           name=din.readUTF();
           System.out.println("server  "+name);

           str=din.readUTF();
           System.out.println(str);
           send(str,name);

       }
       catch(Exception e){}
   }
}
synchronized public void send(String str,String name)throws IOException
{
    Iterator i=a.iterator();
    Iterator i1=ChatServer.allusers.iterator();
    Socket st;
    while(i.hasNext())
    {
         if(((String)i1.next()).equals(name))
         {
           st=(Socket)i.next();
           dout=new DataOutputStream(st.getOutputStream());
           dout.writeUTF(str);
           System.out.println(str);
           dout.flush();
        
         }
        i.next();
        }
    }


}