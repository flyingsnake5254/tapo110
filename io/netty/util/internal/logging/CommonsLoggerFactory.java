package io.netty.util.internal.logging;

import org.apache.commons.logging.LogFactory;

@Deprecated
public class CommonsLoggerFactory
  extends InternalLoggerFactory
{
  public static final InternalLoggerFactory INSTANCE = new CommonsLoggerFactory();
  
  public InternalLogger newInstance(String paramString)
  {
    return new CommonsLogger(LogFactory.getLog(paramString), paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\logging\CommonsLoggerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */