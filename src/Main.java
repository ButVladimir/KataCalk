import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static String List()   // Вводим строку для вычисления
    {
        System.out.println("Введите арифметическое выражение!");
        Scanner scanner = new Scanner( System.in);
        String str1 = scanner.nextLine();
        str1 = str1.toLowerCase();
        str1= str1.replace(" ", "");
        scanner.close();
        return str1;
    }
    //что - то напечатал
    public static String[] disp (String str1) throws NumberExeption  //Получаем массив с числами для вычисления и операндом
    {   String a="";
        /*int sub=0;
        int mul=0;
        int div=0;*/
        int n=0;
        String  strAdd= Arrays.toString(new char[]{'+'});
        String  strMul= Arrays.toString(new char[]{'*'});
        String del = "";
        for (int i=0; i< (str1.length()-1); i++) {
            if (str1.charAt(i)=='+') {del=del.concat(strAdd); a="add"; n++;}
            if (str1.charAt(i)=='-') {del=del.concat("-"); a="sub";n++;}
            if (str1.charAt(i)=='*') {del=del.concat(strMul); a="mul";n++;}
            if (str1.charAt(i)=='/') {del=del.concat("/"); a="div";n++;}
        }
        if (n>1){throw new NumberExeption("В выражении не долно быть более одного операнда");}
        if (n==0) {throw new NumberExeption(
                "Выражение должно состоять из двух чисел (арабского или латинского) и операнда" + " + " + " - "+" * "+" / ");}
        //System.out.println("Количество вхождений символа в строку"+n);
        String [] strings1 = str1.split(del);
        String [] strings = new String [3]; //strings[2]="";
        strings[0]=strings1[0]; strings[1]=strings1[1]; strings[2]=a;
        /*for (String element: strings) {
            System.out.println (element);
        }*/ /*((strings[2]!=("sub"))||((strings[2]!=("mul"))||((strings[2]!=("div")*/
        if ((strings[0].isEmpty())||strings[1].isEmpty()) {throw new NumberExeption(
                "В выражении должно быть два числа");}


        return strings;
    }
    public static int[] mode(String [] str) throws NumberExeption // Получаем массив с числами для вычисления (сначала арабские затем латинские)
    {
           int operand =0;
           if (str[2].equals("add")) {operand=1;}
            if (str[2].equals("sub")) {operand=2;}
        if (str[2].equals("mul")) {operand=3;}
        if (str[2].equals("div")) {operand=4;}

            String [] str1=new String[2];  str1[0]=str[0]; str1[1]=str[1]; // Кривое объявление массива символов

                String [] numbers = {"0","1","2","3","4","5","6","7","8","9","10", "i","ii","iii",
                "iv","v","vi","vii","viii","ix","x"};

        int arabic1 = -1, latin1=0, arabic2 = -1, latin2=0;
        int k=0;
        for (int i=0; i<=1; i++)
        {

            for (int n=0; n<=20; n++)
            {
                if  (str1 [i].equals(numbers[n]))
                {
                    if ((n<=10) && (i==0)) {arabic1 = n;} else {if ((10<n)&&(i==0)) {latin1=(n-10);}}
                    if ((n<=10) && (i==1)) {arabic2 = n;} else {if ((10<n)&&(i==1)) {latin2=(n-10);}}
                            k++;
                }

            }
                    }
        //System.out.println("К равно  " +k+"  Первое слагаемое"+arabic1+"Второе слагаемое"+arabic2);
            if (k<2){throw new NumberExeption("Программа работает с арабскими числами от 0 до 10 и латинскими  числами от i до X");}
            if (((arabic1!=-1)&&((latin1!=0)||(latin2)!=0))||((arabic2!=-1)&&((latin1!=0)||(latin2)!=0))){throw new NumberExeption(
                    "Числа дожны быть либо оба арабские, либо оба латинские");}

        int [] number_s = {arabic1, arabic2,latin1,latin2,operand};

        return  number_s;
    }
        public static void display (int [] number_s) throws NumberExeption  //Вычисление выражения составленного из чисел в арабской или римской транскрипции и вывод их на в консоль
        {
            int a = 0;
            String latin = "L", l;
            if (number_s[2] == 0 && number_s[3] == 0) {
                if (number_s[4] == 1) {
                    System.out.println(number_s[0] + number_s[1]);
                }
                if (number_s[4] == 2) {
                    System.out.println(number_s[0] - number_s[1]);
                }
                if (number_s[4] == 3) {
                    System.out.println(number_s[0] * number_s[1]);
                }
                if (number_s[4] == 4) {
                    System.out.println(number_s[0] / number_s[1]);
                }
            } else  {if (number_s[0] == -1 && number_s[1] == -1)
                {
                    if (number_s[4] == 1) {
                        a = number_s[2] + number_s[3];
                        l = String.valueOf(a);
                        latin = latin.concat(l);
                        Latin chislo = Latin.valueOf(latin);
                        System.out.println(chislo.getTranslation());
                    }
                }
                if (number_s[4] == 2) {
                    a = number_s[2] - number_s[3];
                    if (a<0) {
                        System.out.println("Результат выражения является отрицательным числом.");}
                    if (a==0) {
                        System.out.println("Результат выражения является нулевым .");}
                    if (a<=0)  {throw new NumberExeption("Результат работы с латинскими числами не может быть ни отрицательным, ни нулевым.");}
                    l = String.valueOf(a);
                    latin = latin.concat(l);
                    Latin chislo = Latin.valueOf(latin);

                    System.out.println(chislo.getTranslation());
                }
                if (number_s[4] == 3) {
                    a = number_s[2] * number_s[3];
                    l = String.valueOf(a);
                    latin = latin.concat(l);
                    Latin chislo = Latin.valueOf(latin);
                    System.out.println(chislo.getTranslation());
                }
                if (number_s[4] == 4) {
                    a = number_s[2] / number_s[3];
                    l = String.valueOf(a);
                    latin = latin.concat(l);
                    Latin chislo = Latin.valueOf(latin);
                    System.out.println(chislo.getTranslation());
                }
            }
        }
    public static void main(String[] args) throws NumberExeption {
                                String str = List();  //Вводим строку для вычисления
            String [] strings = disp (str);  //Разбиваем строку на числа и операнды
            int []  number_s = mode(strings);  //Тут производятся вычисления
            display (number_s); // Вывод результата в консоль

    }

}
