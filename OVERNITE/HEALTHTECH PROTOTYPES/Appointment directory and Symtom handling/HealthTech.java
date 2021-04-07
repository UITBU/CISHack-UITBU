import java.util.*;
class HealthTech
{
    int searchid(int id[],int idt)
    {
        int l=id.length,r=-1;
        for(int i=0;i<l;i++)
        {
            if(idt==id[i])
                r=i;
        }
        return r;
    }

    int searchph(long id[],long idt)
    {
        int l=id.length,r=-1;
        for(int i=0;i<l;i++)
        {
            if(idt==id[i])
                r=i;
        }
        return r;
    }
    String test_analyser(String s)
    {
        String sy="";
        if(s.equalsIgnoreCase("FRACTURE"))
            sy="X-RAY";
        if(s.equalsIgnoreCase("Fever"))
            sy="COVID TEST or any other viral infection blood test";
        if(s.equalsIgnoreCase("loss of vision"))
            sy="EYE REPORT";
        if(s.equalsIgnoreCase("chest pain"))
            sy="MRI";    
        if(s.equalsIgnoreCase("weight loss")||s.equalsIgnoreCase("frequent urination"))
            sy="FAST BLOOD SUGAR TEST";
        if(s.equalsIgnoreCase("STOMACH PAIN"))
            sy="ULTRASONOGRAPHY";
        return sy;
            //OTHER SYMPTOMS TO BE IMPORTED FROM DATABASE
    }
    void main()
    {
        Scanner sc=new Scanner(System.in);
        String name[]=new String[1000];
        String gen[]=new String[1000];
        String sym[]=new String[1000];
        int age[]=new int[1000];
        int id[]=new int[1000]; //ID should be a 5 DIGIT NUMBER BETWEEN 10000-99999
        long mob[]=new long[1000];
        int month[][]=new int[30][10];
        int n=0,i,j,pat_id,pos,posph;
        long pat_ph;
        String pat_name,symp="",test="";
        for(i=0;i<30;i++)
            for(j=0;j<10;j++)
                month[i][j]=0;

        while(n<1000)
        {
            System.out.println("WELCOME HEALTHTECH SOLUTIONS");
            System.out.println("1.OLD PATIENT");
            System.out.println("2.NEW PATIENT");
            System.out.println(" ENTER YOUR CHOICE : ");
            int ch=sc.nextInt();
            switch(ch)
            {
                case 1:
                System.out.println("ENTER PATIENT ID OF THE PATIENT, if you have forgotten please enter 0 in patient id and entered registered mobile number: ");
                System.out.println("ENTER PATIENT ID NO : ");
                pat_id=sc.nextInt();
                pos=searchid(id,pat_id);
                if(pat_id==0)
                {
                    System.out.println("ENTER MOBILE NO OF THE PATIENT : ");
                    pat_ph=sc.nextLong();
                    pos=searchph(mob,pat_ph);
                }
                
                //search will be conducted after linking it to the database
                System.out.println("--------------------------------------------------------------------------------------");
                System.out.println("PATIENT NAME              - "+name[pos]);
                System.out.println("PATIENT ID                - "+id[pos]);
                System.out.println("PATIENT PHONE NO          - "+mob[pos]);
                System.out.println("PATIENT AGE               - "+age[pos]);
                System.out.println("PATIENT PREVIOUS REPORTS  - "+sym[pos]);
                System.out.println("--------------------------------------------------------------------------------------");
                System.out.println("Enter the new symptoms : ");
                sc.next();
                symp=sc.next();
                
                break;

                case 2:
                System.out.println("ENTER NAME OF THE PATIENT : ");
                sc.next();
                name[n]=sc.nextLine();
                System.out.println("ENTER MOBILE NO OF THE PATIENT : ");
                mob[n]=sc.nextLong();
                System.out.println("ENTER GENDER OF THE PATIENT : ");
                gen[n]=sc.next();
                System.out.println("ENTER AGE OF THE PATIENT : ");
                age[n]=sc.nextInt();
                System.out.println("ENTER PATIENT ID NO : ");
                id[n]=sc.nextInt();
                System.out.println("ENTER SYMPTOMS : ");
                sc.next();
                sym[n]=sc.next();
                break;

                default:
                System.out.println("INVALID ENTRY");
            }
            if(ch==1||ch==2)
            {
                System.out.println("ENTER APPOINTMENT DATE : ");
                int date=sc.nextInt();
                System.out.println("SLOT AVAILABLE : ");
                for(i=0;i<10;i++)
                {
                    if(month[date][i]==0)
                        System.out.println("Slot - "+(i+1));
                    else
                        System.out.println("Slot - "+(i+1)+" HAS BEEN BOOKED");
                }
                System.out.println("ENTER SLOT NO. THAT NEEDS TO BE BOOKED");
                int slot = sc.nextInt();
                
                
                System.out.println("TEST that you need to perform : ");
                if(ch==1)
                test=test_analyser(symp);
                else
                test=test_analyser(sym[n]);
                month[date][slot-1]=1;
                System.out.println("--------------------------------------------------------------------------------------");
            }
        }   
    }
}