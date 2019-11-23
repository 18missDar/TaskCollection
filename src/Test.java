import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        MyArrayList<String> myst = new MyArrayList<>();
        myst.add("Hello");
        myst.add("world");
        myst.add("friend");
        myst.add("welcome");

//        MyArrayList<String> myst2 = new MyArrayList<>();
//        myst2.add("one");
//        myst.addCollection(myst2);


        String str = "";
        Iterator<String> i = myst.iterator();
        while (i.hasNext()) {
            str = i.next();
            if (str.equals("world")) {
                i.remove();
                System.out.println("\nThe element world is removed");
                break;
            }
        }

        for (String s: myst){
            System.out.println(s);
        }

    }
}
