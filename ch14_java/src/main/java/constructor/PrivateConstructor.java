package constructor;

/**
 * Created by ilyarudyak on 7/8/16.
 */
public class PrivateConstructor {

    private static PrivateConstructor privateConstructor;

    private PrivateConstructor() {
        System.out.println("private constructor is called ...");
    }

    public static PrivateConstructor newInstance() {

        if (privateConstructor == null) {
            privateConstructor = new PrivateConstructor();
        }
        return privateConstructor;
    }

    public static void main(String[] args) {

        // here we can call private constructor
        new PrivateConstructor();
//        PrivateConstructor.newInstance();
    }
}
