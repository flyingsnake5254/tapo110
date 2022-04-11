package io.netty.handler.codec.http2;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SuppressJava6Requirement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Http2Exception
  extends Exception
{
  private static final long serialVersionUID = -6941186345430164209L;
  private final Http2Error error;
  private final ShutdownHint shutdownHint;
  
  public Http2Exception(Http2Error paramHttp2Error)
  {
    this(paramHttp2Error, ShutdownHint.HARD_SHUTDOWN);
  }
  
  public Http2Exception(Http2Error paramHttp2Error, ShutdownHint paramShutdownHint)
  {
    this.error = ((Http2Error)ObjectUtil.checkNotNull(paramHttp2Error, "error"));
    this.shutdownHint = ((ShutdownHint)ObjectUtil.checkNotNull(paramShutdownHint, "shutdownHint"));
  }
  
  public Http2Exception(Http2Error paramHttp2Error, String paramString)
  {
    this(paramHttp2Error, paramString, ShutdownHint.HARD_SHUTDOWN);
  }
  
  public Http2Exception(Http2Error paramHttp2Error, String paramString, ShutdownHint paramShutdownHint)
  {
    super(paramString);
    this.error = ((Http2Error)ObjectUtil.checkNotNull(paramHttp2Error, "error"));
    this.shutdownHint = ((ShutdownHint)ObjectUtil.checkNotNull(paramShutdownHint, "shutdownHint"));
  }
  
  @SuppressJava6Requirement(reason="uses Java 7+ Exception.<init>(String, Throwable, boolean, boolean) but is guarded by version checks")
  private Http2Exception(Http2Error paramHttp2Error, String paramString, ShutdownHint paramShutdownHint, boolean paramBoolean)
  {
    super(paramString, null, false, true);
    this.error = ((Http2Error)ObjectUtil.checkNotNull(paramHttp2Error, "error"));
    this.shutdownHint = ((ShutdownHint)ObjectUtil.checkNotNull(paramShutdownHint, "shutdownHint"));
  }
  
  public Http2Exception(Http2Error paramHttp2Error, String paramString, Throwable paramThrowable)
  {
    this(paramHttp2Error, paramString, paramThrowable, ShutdownHint.HARD_SHUTDOWN);
  }
  
  public Http2Exception(Http2Error paramHttp2Error, String paramString, Throwable paramThrowable, ShutdownHint paramShutdownHint)
  {
    super(paramString, paramThrowable);
    this.error = ((Http2Error)ObjectUtil.checkNotNull(paramHttp2Error, "error"));
    this.shutdownHint = ((ShutdownHint)ObjectUtil.checkNotNull(paramShutdownHint, "shutdownHint"));
  }
  
  public static Http2Exception closedStreamError(Http2Error paramHttp2Error, String paramString, Object... paramVarArgs)
  {
    return new ClosedStreamCreationException(paramHttp2Error, String.format(paramString, paramVarArgs));
  }
  
  public static Http2Exception connectionError(Http2Error paramHttp2Error, String paramString, Object... paramVarArgs)
  {
    return new Http2Exception(paramHttp2Error, String.format(paramString, paramVarArgs));
  }
  
  public static Http2Exception connectionError(Http2Error paramHttp2Error, Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    return new Http2Exception(paramHttp2Error, String.format(paramString, paramVarArgs), paramThrowable);
  }
  
  public static Http2Exception headerListSizeError(int paramInt, Http2Error paramHttp2Error, boolean paramBoolean, String paramString, Object... paramVarArgs)
  {
    if (paramInt == 0) {
      paramHttp2Error = connectionError(paramHttp2Error, paramString, paramVarArgs);
    } else {
      paramHttp2Error = new HeaderListSizeException(paramInt, paramHttp2Error, String.format(paramString, paramVarArgs), paramBoolean);
    }
    return paramHttp2Error;
  }
  
  public static boolean isStreamError(Http2Exception paramHttp2Exception)
  {
    return paramHttp2Exception instanceof StreamException;
  }
  
  static Http2Exception newStatic(Http2Error paramHttp2Error, String paramString, ShutdownHint paramShutdownHint)
  {
    if (PlatformDependent.javaVersion() >= 7) {
      return new Http2Exception(paramHttp2Error, paramString, paramShutdownHint, true);
    }
    return new Http2Exception(paramHttp2Error, paramString, paramShutdownHint);
  }
  
  public static Http2Exception streamError(int paramInt, Http2Error paramHttp2Error, String paramString, Object... paramVarArgs)
  {
    if (paramInt == 0) {
      paramHttp2Error = connectionError(paramHttp2Error, paramString, paramVarArgs);
    } else {
      paramHttp2Error = new StreamException(paramInt, paramHttp2Error, String.format(paramString, paramVarArgs));
    }
    return paramHttp2Error;
  }
  
  public static Http2Exception streamError(int paramInt, Http2Error paramHttp2Error, Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    if (paramInt == 0) {
      paramHttp2Error = connectionError(paramHttp2Error, paramThrowable, paramString, paramVarArgs);
    } else {
      paramHttp2Error = new StreamException(paramInt, paramHttp2Error, String.format(paramString, paramVarArgs), paramThrowable);
    }
    return paramHttp2Error;
  }
  
  public static int streamId(Http2Exception paramHttp2Exception)
  {
    int i;
    if (isStreamError(paramHttp2Exception)) {
      i = ((StreamException)paramHttp2Exception).streamId();
    } else {
      i = 0;
    }
    return i;
  }
  
  public Http2Error error()
  {
    return this.error;
  }
  
  public ShutdownHint shutdownHint()
  {
    return this.shutdownHint;
  }
  
  public static final class ClosedStreamCreationException
    extends Http2Exception
  {
    private static final long serialVersionUID = -6746542974372246206L;
    
    public ClosedStreamCreationException(Http2Error paramHttp2Error)
    {
      super();
    }
    
    public ClosedStreamCreationException(Http2Error paramHttp2Error, String paramString)
    {
      super(paramString);
    }
    
    public ClosedStreamCreationException(Http2Error paramHttp2Error, String paramString, Throwable paramThrowable)
    {
      super(paramString, paramThrowable);
    }
  }
  
  public static final class CompositeStreamException
    extends Http2Exception
    implements Iterable<Http2Exception.StreamException>
  {
    private static final long serialVersionUID = 7091134858213711015L;
    private final List<Http2Exception.StreamException> exceptions;
    
    public CompositeStreamException(Http2Error paramHttp2Error, int paramInt)
    {
      super(Http2Exception.ShutdownHint.NO_SHUTDOWN);
      this.exceptions = new ArrayList(paramInt);
    }
    
    public void add(Http2Exception.StreamException paramStreamException)
    {
      this.exceptions.add(paramStreamException);
    }
    
    public Iterator<Http2Exception.StreamException> iterator()
    {
      return this.exceptions.iterator();
    }
  }
  
  public static final class HeaderListSizeException
    extends Http2Exception.StreamException
  {
    private static final long serialVersionUID = -8807603212183882637L;
    private final boolean decode;
    
    HeaderListSizeException(int paramInt, Http2Error paramHttp2Error, String paramString, boolean paramBoolean)
    {
      super(paramHttp2Error, paramString);
      this.decode = paramBoolean;
    }
    
    public boolean duringDecode()
    {
      return this.decode;
    }
  }
  
  public static enum ShutdownHint
  {
    static
    {
      ShutdownHint localShutdownHint1 = new ShutdownHint("NO_SHUTDOWN", 0);
      NO_SHUTDOWN = localShutdownHint1;
      ShutdownHint localShutdownHint2 = new ShutdownHint("GRACEFUL_SHUTDOWN", 1);
      GRACEFUL_SHUTDOWN = localShutdownHint2;
      ShutdownHint localShutdownHint3 = new ShutdownHint("HARD_SHUTDOWN", 2);
      HARD_SHUTDOWN = localShutdownHint3;
      $VALUES = new ShutdownHint[] { localShutdownHint1, localShutdownHint2, localShutdownHint3 };
    }
  }
  
  public static class StreamException
    extends Http2Exception
  {
    private static final long serialVersionUID = 602472544416984384L;
    private final int streamId;
    
    StreamException(int paramInt, Http2Error paramHttp2Error, String paramString)
    {
      super(paramString, Http2Exception.ShutdownHint.NO_SHUTDOWN);
      this.streamId = paramInt;
    }
    
    StreamException(int paramInt, Http2Error paramHttp2Error, String paramString, Throwable paramThrowable)
    {
      super(paramString, paramThrowable, Http2Exception.ShutdownHint.NO_SHUTDOWN);
      this.streamId = paramInt;
    }
    
    public int streamId()
    {
      return this.streamId;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\Http2Exception.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */