import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * Created by evemorgen on 13.01.2016.
 */
public class Brakety {
    static Deque<Character> stos = new ArrayDeque<Character>();


    public static void main(String[] args)
    {
        try {
            File plik = new File("dziecizbullerbyn.txt");
            Scanner in = new Scanner(plik);

            String linia = in.nextLine();
            for(int i = 0;i<linia.length();i++)
            {
                if(linia.charAt(i) == '['){stos.push('[');}
                if(linia.charAt(i) == '('){stos.push('(');}
                if(linia.charAt(i) == ']'){
                    if(stos.peek() == '[')
                    {
                        stos.pop();
                    }
                    else
                    {
                        stos.push(']');
                    }
                }
                if(linia.charAt(i) == ')') {
                    if(stos.peek() == '(') {
                        stos.pop();
                    }
                    else{
                        stos.push(')');
                    }
                }
            }

            while(stos.isEmpty() != true)
            {
                System.out.println(stos.pop() + " ");
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Ni ma pliku :(");
        }
    }
}
