
import java.util.Random;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        int n,exactmatch,randomatch,noteForMatched1[],noteForMatched2[];

        /*  noteForMatched1[]: array for noting down the marking matched element
        so that they are not counted again in Matched at wrong postion
         */
        String randomString,userString,computerString;

        Scanner sc= new Scanner(System.in);

        Random rand = new Random();
        n = (int)rand.nextInt(8)+2;// generating randomly length of String from 2 to 9

        noteForMatched1=new int[n];
        noteForMatched2=new int[n];

        randomString= generateRandomString(n);
        System.out.println("Random String is "+randomString);
        System.out.println("Enter String of Length "+n);
        userString = sc.next().toLowerCase();

        exactmatch = checkForExactMatch(randomString,userString,noteForMatched1);
        System.out.println("Characters Matched at Exact Position "+exactmatch);

        randomatch= checkForRandomMatch(randomString,userString,noteForMatched1);
        System.out.println("Characters Matched at Wrong Position "+randomatch);


        System.out.println("Computer gessing starts ......");
        computerString=generateRandomString(n);
        System.out.println("Random String is "+computerString);


        exactmatch = checkForExactMatch(randomString,computerString,noteForMatched2);
        System.out.println("Characters Matched at Exact Position "+exactmatch);

        randomatch= checkForRandomMatch(randomString,computerString,noteForMatched2);
        System.out.println("Characters Matched at Wrong Position "+randomatch);


    }

   // generating random String
    public  static String generateRandomString (int n){

        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'

        Random random = new Random();
        StringBuilder buffer = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();

        return  generatedString;

    }

    // Finding match at exact Position
    public static int checkForExactMatch(String random, String user,int m[]){
         int c=0;
        for (int i = 0; i < random.length(); i++) {
            if(random.charAt(i)==user.charAt(i)){
                c++;
                m[i]=1;

            }
        }
        return c;
    }

    // Finding match at Wrong Postion

    public static int checkForRandomMatch(String random, String user,int m[]){
        int l=random.length();
        int c=0,k;

        for (int i = 0; i <l ; i++) {
            k=0;
            if(m[i]==1) continue;

            for (int j = 0; j <l; j++) {


                if(user.charAt(i)==random.charAt(j)){
                    k=1;
                    break;

                }

            }
            if(k==1) c++;
        }
        return  c;
    }
}
