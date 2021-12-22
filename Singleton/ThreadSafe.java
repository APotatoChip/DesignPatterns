package Singleton;

public final class ThreadSafe{

    private static volatile ThreadSafe instance;
  
    /**
     * private constructor to prevent client from instantiating.
     */
    private ThreadSafe() {
      // to prevent instantiating by Reflection call
      if (instance != null) {
        throw new IllegalStateException("Already initialized.");
      }
    }
  
    /**
     * Public accessor.
     *
     * @return an instance of the class.
     */
    public static ThreadSafe getInstance() {
      // local variable increases performance by 25 percent
      // Joshua Bloch "Effective Java, Second Edition", p. 283-284
  
      var result = instance;
      // Check if singleton instance is initialized.
      // If it is initialized then we can return the instance.
      if (result == null) {
        // It is not initialized but we cannot be sure because some other thread might have
        // initialized it in the meanwhile.
        // So to make sure we need to lock on an object to get mutual exclusion.
        synchronized (ThreadSafe.class) {
          // Again assign the instance to local variable to check if it was initialized by some
          // other thread while current thread was blocked to enter the locked zone.
          // If it was initialized then we can return the previously created instance
          // just like the previous null check.
          result = instance;
          if (result == null) {
            // The instance is still not initialized so we can safely
            // (no other thread can enter this zone)
            // create an instance and make it our singleton instance.
            instance = result = new ThreadSafe();
          }
        }
      }
      return result;
    }
    public void log(String msg) {
        System.out.println("LOG: msg");
    }
  }