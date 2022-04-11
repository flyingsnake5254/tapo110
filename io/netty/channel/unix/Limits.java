package io.netty.channel.unix;

public final class Limits
{
  public static final int IOV_MAX = ;
  public static final int SIZEOF_JLONG = LimitsStaticallyReferencedJniMethods.sizeOfjlong();
  public static final long SSIZE_MAX;
  public static final int UIO_MAX_IOV = LimitsStaticallyReferencedJniMethods.uioMaxIov();
  
  static
  {
    SSIZE_MAX = LimitsStaticallyReferencedJniMethods.ssizeMax();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\unix\Limits.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */