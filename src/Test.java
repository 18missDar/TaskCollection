public class Test {
    public static void main(String[] args) {
        MyArrayList<String> myst = new MyArrayList<>();
        myst.add("Hello");
        myst.add("world");
        myst.add("friend");
        myst.add("welcome");

        MyArrayList<String> myst2 = new MyArrayList<>();
        myst2.add("one");
        myst.addMy(myst2);

        String[] mas = {"second","third"};
        myst.addCollection(mas);


        for (String s: myst){
            System.out.println(s);;
        }


//        String[] my = {"next","fggggg","fffff"};
//        ArrayIterator<String> myit = new ArrayIterator<>(my);
//        while(myit.hasNext()){
//            if (myit.next().equals("next")){
//                myit.remove();
//            }
//        }
//        while(myit.hasNext()){
//            System.out.println(myit.next());
//        }

    }
}
