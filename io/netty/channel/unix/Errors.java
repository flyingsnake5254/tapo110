package io.netty.channel.unix;

import io.netty.util.internal.EmptyArrays;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.nio.channels.AlreadyConnectedException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ConnectionPendingException;
import java.nio.channels.NotYetConnectedException;

public final class Errors
{
  public static final int ERRNO_EAGAIN_NEGATIVE;
  public static final int ERRNO_EBADF_NEGATIVE;
  public static final int ERRNO_ECONNRESET_NEGATIVE;
  public static final int ERRNO_EINPROGRESS_NEGATIVE;
  public static final int ERRNO_ENOENT_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errnoENOENT();
  public static final int ERRNO_ENOTCONN_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errnoENOTCONN();
  public static final int ERRNO_EPIPE_NEGATIVE;
  public static final int ERRNO_EWOULDBLOCK_NEGATIVE;
  private static final String[] ERRORS;
  public static final int ERROR_EALREADY_NEGATIVE;
  public static final int ERROR_ECONNREFUSED_NEGATIVE;
  public static final int ERROR_EISCONN_NEGATIVE;
  public static final int ERROR_ENETUNREACH_NEGATIVE;
  
  static
  {
    ERRNO_EBADF_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errnoEBADF();
    ERRNO_EPIPE_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errnoEPIPE();
    ERRNO_ECONNRESET_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errnoECONNRESET();
    ERRNO_EAGAIN_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errnoEAGAIN();
    ERRNO_EWOULDBLOCK_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errnoEWOULDBLOCK();
    ERRNO_EINPROGRESS_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errnoEINPROGRESS();
    ERROR_ECONNREFUSED_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errorECONNREFUSED();
    ERROR_EISCONN_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errorEISCONN();
    ERROR_EALREADY_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errorEALREADY();
    ERROR_ENETUNREACH_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errorENETUNREACH();
    ERRORS = new String['Ȁ'];
    for (int i = 0;; i++)
    {
      String[] arrayOfString = ERRORS;
      if (i >= arrayOfString.length) {
        break;
      }
      arrayOfString[i] = ErrorsStaticallyReferencedJniMethods.strError(i);
    }
  }
  
  public static int ioResult(String paramString, int paramInt)
    throws IOException
  {
    if ((paramInt != ERRNO_EAGAIN_NEGATIVE) && (paramInt != ERRNO_EWOULDBLOCK_NEGATIVE))
    {
      if (paramInt != ERRNO_EBADF_NEGATIVE)
      {
        if (paramInt != ERRNO_ENOTCONN_NEGATIVE)
        {
          if (paramInt == ERRNO_ENOENT_NEGATIVE) {
            throw new FileNotFoundException();
          }
          throw new NativeIoException(paramString, paramInt, false);
        }
        throw new NotYetConnectedException();
      }
      throw new ClosedChannelException();
    }
    return 0;
  }
  
  @Deprecated
  public static int ioResult(String paramString, int paramInt, NativeIoException paramNativeIoException, ClosedChannelException paramClosedChannelException)
    throws IOException
  {
    if ((paramInt != ERRNO_EAGAIN_NEGATIVE) && (paramInt != ERRNO_EWOULDBLOCK_NEGATIVE))
    {
      if (paramInt != paramNativeIoException.expectedErr())
      {
        if (paramInt != ERRNO_EBADF_NEGATIVE)
        {
          if (paramInt != ERRNO_ENOTCONN_NEGATIVE)
          {
            if (paramInt == ERRNO_ENOENT_NEGATIVE) {
              throw new FileNotFoundException();
            }
            throw newIOException(paramString, paramInt);
          }
          throw new NotYetConnectedException();
        }
        throw paramClosedChannelException;
      }
      throw paramNativeIoException;
    }
    return 0;
  }
  
  public static NativeIoException newConnectionResetException(String paramString, int paramInt)
  {
    paramString = new NativeIoException(paramString, paramInt, false);
    paramString.setStackTrace(EmptyArrays.EMPTY_STACK_TRACE);
    return paramString;
  }
  
  public static NativeIoException newIOException(String paramString, int paramInt)
  {
    return new NativeIoException(paramString, paramInt);
  }
  
  static void throwConnectException(String paramString, int paramInt)
    throws IOException
  {
    if (paramInt != ERROR_EALREADY_NEGATIVE)
    {
      if (paramInt != ERROR_ENETUNREACH_NEGATIVE)
      {
        if (paramInt != ERROR_EISCONN_NEGATIVE)
        {
          if (paramInt == ERRNO_ENOENT_NEGATIVE) {
            throw new FileNotFoundException();
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString);
          localStringBuilder.append("(..) failed: ");
          localStringBuilder.append(ERRORS[(-paramInt)]);
          throw new ConnectException(localStringBuilder.toString());
        }
        throw new AlreadyConnectedException();
      }
      throw new NoRouteToHostException();
    }
    throw new ConnectionPendingException();
  }
  
  static final class NativeConnectException
    extends ConnectException
  {
    private static final long serialVersionUID = -5532328671712318161L;
    private final int expectedErr;
    
    NativeConnectException(String paramString, int paramInt)
    {
      super();
      this.expectedErr = paramInt;
    }
    
    int expectedErr()
    {
      return this.expectedErr;
    }
  }
  
  public static final class NativeIoException
    extends IOException
  {
    private static final long serialVersionUID = 8222160204268655526L;
    private final int expectedErr;
    private final boolean fillInStackTrace;
    
    public NativeIoException(String paramString, int paramInt)
    {
      this(paramString, paramInt, true);
    }
    
    public NativeIoException(String paramString, int paramInt, boolean paramBoolean)
    {
      super();
      this.expectedErr = paramInt;
      this.fillInStackTrace = paramBoolean;
    }
    
    public int expectedErr()
    {
      return this.expectedErr;
    }
    
    public Throwable fillInStackTrace()
    {
      try
      {
        if (this.fillInStackTrace)
        {
          Throwable localThrowable = super.fillInStackTrace();
          return localThrowable;
        }
        return this;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\unix\Errors.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */