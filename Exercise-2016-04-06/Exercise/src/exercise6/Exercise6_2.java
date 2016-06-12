package exercise6;

/**
 * Created by cj on 2016-03-12.
 */
public class Exercise6_2 {
    public static void main(String[] args) {
        exercise7.SutdaCard card1 = new exercise7.SutdaCard(3, false);
        exercise7.SutdaCard card2 = new exercise7.SutdaCard();
        System.out.println(card1.info());
        System.out.println(card2.info());
    }
}

class SutdaCard {
    int num;
    boolean isKwang;

    SutdaCard() {
        this(1,true);
    }

    SutdaCard(int num,boolean isKwang) {
        this.num=num;
        this.isKwang=isKwang;
    }

    public String info() {
        char k=' ';
        if(isKwang==true)
            k='k';
        String str=""+num+k+"";
        return str;
    }

}