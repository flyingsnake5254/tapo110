package okhttp3.logging;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.EventListener.Factory;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

public final class LoggingEventListener
  extends EventListener
{
  private final HttpLoggingInterceptor.Logger logger;
  private long startNs;
  
  private LoggingEventListener(HttpLoggingInterceptor.Logger paramLogger)
  {
    this.logger = paramLogger;
  }
  
  private void logWithTime(String paramString)
  {
    long l = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - this.startNs);
    HttpLoggingInterceptor.Logger localLogger = this.logger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(l);
    localStringBuilder.append(" ms] ");
    localStringBuilder.append(paramString);
    localLogger.log(localStringBuilder.toString());
  }
  
  public void callEnd(Call paramCall)
  {
    logWithTime("callEnd");
  }
  
  public void callFailed(Call paramCall, IOException paramIOException)
  {
    paramCall = new StringBuilder();
    paramCall.append("callFailed: ");
    paramCall.append(paramIOException);
    logWithTime(paramCall.toString());
  }
  
  public void callStart(Call paramCall)
  {
    this.startNs = System.nanoTime();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("callStart: ");
    localStringBuilder.append(paramCall.request());
    logWithTime(localStringBuilder.toString());
  }
  
  public void connectEnd(Call paramCall, InetSocketAddress paramInetSocketAddress, Proxy paramProxy, @Nullable Protocol paramProtocol)
  {
    paramCall = new StringBuilder();
    paramCall.append("connectEnd: ");
    paramCall.append(paramProtocol);
    logWithTime(paramCall.toString());
  }
  
  public void connectFailed(Call paramCall, InetSocketAddress paramInetSocketAddress, Proxy paramProxy, @Nullable Protocol paramProtocol, IOException paramIOException)
  {
    paramCall = new StringBuilder();
    paramCall.append("connectFailed: ");
    paramCall.append(paramProtocol);
    paramCall.append(" ");
    paramCall.append(paramIOException);
    logWithTime(paramCall.toString());
  }
  
  public void connectStart(Call paramCall, InetSocketAddress paramInetSocketAddress, Proxy paramProxy)
  {
    paramCall = new StringBuilder();
    paramCall.append("connectStart: ");
    paramCall.append(paramInetSocketAddress);
    paramCall.append(" ");
    paramCall.append(paramProxy);
    logWithTime(paramCall.toString());
  }
  
  public void connectionAcquired(Call paramCall, Connection paramConnection)
  {
    paramCall = new StringBuilder();
    paramCall.append("connectionAcquired: ");
    paramCall.append(paramConnection);
    logWithTime(paramCall.toString());
  }
  
  public void connectionReleased(Call paramCall, Connection paramConnection)
  {
    logWithTime("connectionReleased");
  }
  
  public void dnsEnd(Call paramCall, String paramString, List<InetAddress> paramList)
  {
    paramCall = new StringBuilder();
    paramCall.append("dnsEnd: ");
    paramCall.append(paramList);
    logWithTime(paramCall.toString());
  }
  
  public void dnsStart(Call paramCall, String paramString)
  {
    paramCall = new StringBuilder();
    paramCall.append("dnsStart: ");
    paramCall.append(paramString);
    logWithTime(paramCall.toString());
  }
  
  public void requestBodyEnd(Call paramCall, long paramLong)
  {
    paramCall = new StringBuilder();
    paramCall.append("requestBodyEnd: byteCount=");
    paramCall.append(paramLong);
    logWithTime(paramCall.toString());
  }
  
  public void requestBodyStart(Call paramCall)
  {
    logWithTime("requestBodyStart");
  }
  
  public void requestHeadersEnd(Call paramCall, Request paramRequest)
  {
    logWithTime("requestHeadersEnd");
  }
  
  public void requestHeadersStart(Call paramCall)
  {
    logWithTime("requestHeadersStart");
  }
  
  public void responseBodyEnd(Call paramCall, long paramLong)
  {
    paramCall = new StringBuilder();
    paramCall.append("responseBodyEnd: byteCount=");
    paramCall.append(paramLong);
    logWithTime(paramCall.toString());
  }
  
  public void responseBodyStart(Call paramCall)
  {
    logWithTime("responseBodyStart");
  }
  
  public void responseHeadersEnd(Call paramCall, Response paramResponse)
  {
    paramCall = new StringBuilder();
    paramCall.append("responseHeadersEnd: ");
    paramCall.append(paramResponse);
    logWithTime(paramCall.toString());
  }
  
  public void responseHeadersStart(Call paramCall)
  {
    logWithTime("responseHeadersStart");
  }
  
  public void secureConnectEnd(Call paramCall, @Nullable Handshake paramHandshake)
  {
    logWithTime("secureConnectEnd");
  }
  
  public void secureConnectStart(Call paramCall)
  {
    logWithTime("secureConnectStart");
  }
  
  public static class Factory
    implements EventListener.Factory
  {
    private final HttpLoggingInterceptor.Logger logger;
    
    public Factory()
    {
      this(HttpLoggingInterceptor.Logger.DEFAULT);
    }
    
    public Factory(HttpLoggingInterceptor.Logger paramLogger)
    {
      this.logger = paramLogger;
    }
    
    public EventListener create(Call paramCall)
    {
      return new LoggingEventListener(this.logger, null);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okhttp3\logging\LoggingEventListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */