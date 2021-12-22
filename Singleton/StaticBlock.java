package Singleton;
public final class StaticBlock {

    /**
     * Private constructor.
     */
    private StaticBlock() {
    }
  
    /**
     * Singleton instance.
     *
     * @return Singleton instance
     */
    public static StaticBlock getInstance() {
      return HelperHolder.INSTANCE;
    }
  
    /**
     * Provides the lazy-loaded Singleton instance.
     */
    private static class HelperHolder {
      private static final StaticBlock INSTANCE =
          new StaticBlock();
    }
     public void log(String msg) {
              System.out.println("LOG: msg");
          }
  }