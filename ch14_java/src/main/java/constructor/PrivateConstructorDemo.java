package constructor;

// we can not extend a class with private constructor
public class PrivateConstructorDemo /* extends PrivateConstructor */ {

    public static void main(String[] args) {

        // but here we can not call private constructor
//        new PrivateConstructor();

        // we can call here static method
        PrivateConstructor.newInstance();
    }
}
