package io.netty.util;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.SystemPropertyUtil;
import java.util.Locale;

public final class NettyRuntime
{
  private static final AvailableProcessorsHolder holder = new AvailableProcessorsHolder();
  
  public static int availableProcessors()
  {
    return holder.availableProcessors();
  }
  
  public static void setAvailableProcessors(int paramInt)
  {
    holder.setAvailableProcessors(paramInt);
  }
  
  static class AvailableProcessorsHolder
  {
    private int availableProcessors;
    
    @SuppressForbidden(reason="to obtain default number of available processors")
    int availableProcessors()
    {
      try
      {
        if (this.availableProcessors == 0) {
          setAvailableProcessors(SystemPropertyUtil.getInt("io.netty.availableProcessors", Runtime.getRuntime().availableProcessors()));
        }
        int i = this.availableProcessors;
        return i;
      }
      finally {}
    }
    
    void setAvailableProcessors(int paramInt)
    {
      try
      {
        ObjectUtil.checkPositive(paramInt, "availableProcessors");
        int i = this.availableProcessors;
        if (i == 0)
        {
          this.availableProcessors = paramInt;
          return;
        }
        String str = String.format(Locale.ROOT, "availableProcessors is already set to [%d], rejecting [%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
        IllegalStateException localIllegalStateException = new java/lang/IllegalStateException;
        localIllegalStateException.<init>(str);
        throw localIllegalStateException;
      }
      finally {}
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\NettyRuntime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */