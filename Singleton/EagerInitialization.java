package Singleton;
public class EagerInitialization {

    /**
     * We eagerly create the object at class loading time.
     * Note that the member is static and final. Only 1 copy of this can exist.
     */
    private static final EagerInitialization SINGLE_INSTANCE = new EagerInitialization();

    /**
     * Lock down the constructor to prevent Client's from creating instance of this class
     */
    private EagerInitialization() {
    }

    /**
     * Returns the eagerly created single instance of this class.
     *
     * @return single instance of this class.
     */
    public static EagerInitialization getInstance() {
        return SINGLE_INSTANCE;
    }

    /**
     * The business method - we're a logger for sake of this demo.
     *
     * @param msg the message to log
     */
    public void log(String msg) {
        System.out.println("LOG: msg");
    }
}