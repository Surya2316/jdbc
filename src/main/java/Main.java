import com.spring.*;
import java.awt.List;
import java.util.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main
{
    public static void main(String args[])
    {
        Logger log = Logger.getLogger("org.hibernate");
        log.setLevel(Level.OFF);
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");

        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");  
        EventDAO dao1=(EventDAO)ctx.getBean(EventDAO.class);
        OwnerDAO dao2 = (OwnerDAO)ctx.getBean(OwnerDAO.class);
        ArrayList<Owner> list = (ArrayList<Owner>)dao2.getAllOwners();
        for(Owner o : list)
        {
            System.out.println(o.getName()+" - "+o.getEmailId());
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Event Registration");
        System.out.println("Enter the name");
        String s1 = sc.nextLine();
        System.out.println("Enter the eventName");
        String s2 = sc.nextLine();
        int owner = dao2.getIdByName(s1);
        if(owner<=0)
        {
            System.out.println("No such user");
            System.exit(0);
        }
        int event = dao1.getIdByEventName(s2);
        {
            if(event>0)
            {
                System.out.println("Event already booked");
                System.exit(0);
            }
        }
        dao1.createUser(s1,s2);
    }
}