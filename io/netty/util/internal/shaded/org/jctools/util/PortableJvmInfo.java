package io.netty.util.internal.shaded.org.jctools.util;

public abstract interface PortableJvmInfo
{
  public static final int CACHE_LINE_SIZE = Integer.getInteger("jctools.cacheLineSize", 64).intValue();
  public static final int CPUs;
  public static final int RECOMENDED_OFFER_BATCH;
  public static final int RECOMENDED_POLL_BATCH;
  
  static
  {
    int i = Runtime.getRuntime().availableProcessors();
    CPUs = i;
    RECOMENDED_OFFER_BATCH = i * 4;
    RECOMENDED_POLL_BATCH = i * 4;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\shaded\org\jctools\util\PortableJvmInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */