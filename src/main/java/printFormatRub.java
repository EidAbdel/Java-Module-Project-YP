import java.util.ArrayList;
import java.util.Arrays;

public class printFormatRub {

    public static void outFormattedRub(double num){
        int val= (int)num;
        String s="";
        if (val>=5 && val%100<=20) s="рублей";
        else if (val%10==1) s="рубль";
        else if (new ArrayList<Integer>(Arrays.asList(2,3,4)).contains(val%10)) s="рубля";
        else s="рублей";
        System.out.println(String.format("Каждый из друзей должен заплатить %.2f %s", num, s));
    }
}

