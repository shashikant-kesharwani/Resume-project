import java.time.*;
import java.io.*;
class Restaurant2{
    public static void main(String args[])
    {
        Console in=  System.console();
        String items[]={"samosha","dhosa","bargar","momos","chat","chaomin","Quit"};
        int rate[]={10,80,15,20,30,30,0};
        int qt[]=new int[7];
        int i,j=1;
        int total[]=new int[100];
        int total1=0;
        boolean quit=true;
        do {
            System.out.println("\t************Menu************");
            System.out.println("Sr.no.\tRate\t\tItems");
            for(i=0; i<7; i++)
            {
                System.out.println((i+1)+"\t"+rate[i]+"\t\t"+items[i]);
            }
            
            String ch=in.readLine("What you want:");
            int ch1=Integer.parseInt(ch);
            if (ch1>0 && ch1<7) {
                String q=in.readLine("How many quantity of "+items[ch1-1]+":");
                int q1=Integer.parseInt(q);
                qt[ch1-1]+=q1;
            } else {
                quit=false;
            }
        }
        while(quit);
        
        System.out.println("\n\t\t***********Your Bill***********");
        System.out.print("\t---------------------------------------------------\n");
        System.out.println("\n\tSr.no.\tItem\t  Rate\t\tQuantity\tTotal");
        
        for (i=0;i<6;i++) {
            if (qt[i]!=0) {            
                total[i]+=rate[i]*qt[i];
                System.out.println("\t"+(j)+"\t"+items[i]+"\t  "+rate[i]+"\t\t"+qt[i]+"\t\t"+total[i]);
                total1+=total[i];
                j+=1;
            }
        }
        System.out.print("\n\t---------------------------------------------------\n");
        System.out.println("\n\t\t\t\t\tTotal amount:"+total1+" rs");
        System.out.print("\nDate:"+LocalDate.now());
        System.out.println("\nTime:"+LocalTime.now()+"\t\t\t\tThank you\n");
    }
}