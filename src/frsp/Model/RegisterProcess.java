package frsp.Model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

public class RegisterProcess
{
    public static boolean createAccount(Users u){
        try{
            FileWriter fw = new FileWriter("users.dat", true);
            BufferedWriter bw = new BufferedWriter(fw);
            u.setID(String.valueOf(UUID.randomUUID()));
            bw.write(u.toString());
            bw.close();
            return true;
        }catch(IOException e){
            System.out.println("IO Error");
        }catch(Exception e){
            System.out.println("General Error");
        }
        return false;
    }
}
