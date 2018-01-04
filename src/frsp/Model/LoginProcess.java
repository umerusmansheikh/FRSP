package frsp.Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoginProcess
{
    private static String loginID;
    public static boolean hasAccount(Users u){
        try{
            FileReader f = new FileReader("users.dat");
            BufferedReader o = new BufferedReader(f);
            String n = o.readLine();
            String[] users = n.split("£");
            for(String a: users){
                String[] details = a.split("%");
                if(details[2].equals(u.getEmail()) && details[3].equals(u.getPassword())){
                    loginID = details[0];
                    return true;
                }
                    
            }          
        }catch(IOException e){
            System.out.println(e);
        }catch(Exception e){
            System.out.println(e);
        }
        return false;
    }
    public static String getLoginID(){
        return loginID;
    }
}
