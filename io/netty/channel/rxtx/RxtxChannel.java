package io.netty.channel.rxtx;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import io.netty.channel.AbstractChannel;
import io.netty.channel.AbstractChannel.AbstractUnsafe;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.channel.oio.OioByteStreamChannel;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.concurrent.Promise;
import java.net.SocketAddress;
import java.util.concurrent.TimeUnit;

@Deprecated
public class RxtxChannel
  extends OioByteStreamChannel
{
  private static final RxtxDeviceAddress LOCAL_ADDRESS = new RxtxDeviceAddress("localhost");
  private final RxtxChannelConfig config = new DefaultRxtxChannelConfig(this);
  private RxtxDeviceAddress deviceAddress;
  private boolean open = true;
  private SerialPort serialPort;
  
  public RxtxChannel()
  {
    super(null);
  }
  
  public RxtxChannelConfig config()
  {
    return this.config;
  }
  
  protected void doBind(SocketAddress paramSocketAddress)
    throws Exception
  {
    throw new UnsupportedOperationException();
  }
  
  protected void doClose()
    throws Exception
  {
    this.open = false;
    try
    {
      super.doClose();
      SerialPort localSerialPort = this.serialPort;
      if (localSerialPort != null)
      {
        localSerialPort.removeEventListener();
        this.serialPort.close();
        this.serialPort = null;
      }
      return;
    }
    finally
    {
      if (this.serialPort != null)
      {
        this.serialPort.removeEventListener();
        this.serialPort.close();
        this.serialPort = null;
      }
    }
  }
  
  protected void doConnect(SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2)
    throws Exception
  {
    paramSocketAddress1 = (RxtxDeviceAddress)paramSocketAddress1;
    paramSocketAddress2 = CommPortIdentifier.getPortIdentifier(paramSocketAddress1.value()).open(getClass().getName(), 1000);
    paramSocketAddress2.enableReceiveTimeout(((Integer)config().getOption(RxtxChannelOption.READ_TIMEOUT)).intValue());
    this.deviceAddress = paramSocketAddress1;
    this.serialPort = ((SerialPort)paramSocketAddress2);
  }
  
  protected void doDisconnect()
    throws Exception
  {
    doClose();
  }
  
  protected void doInit()
    throws Exception
  {
    this.serialPort.setSerialPortParams(((Integer)config().getOption(RxtxChannelOption.BAUD_RATE)).intValue(), ((RxtxChannelConfig.Databits)config().getOption(RxtxChannelOption.DATA_BITS)).value(), ((RxtxChannelConfig.Stopbits)config().getOption(RxtxChannelOption.STOP_BITS)).value(), ((RxtxChannelConfig.Paritybit)config().getOption(RxtxChannelOption.PARITY_BIT)).value());
    this.serialPort.setDTR(((Boolean)config().getOption(RxtxChannelOption.DTR)).booleanValue());
    this.serialPort.setRTS(((Boolean)config().getOption(RxtxChannelOption.RTS)).booleanValue());
    activate(this.serialPort.getInputStream(), this.serialPort.getOutputStream());
  }
  
  protected boolean isInputShutdown()
  {
    return this.open ^ true;
  }
  
  public boolean isOpen()
  {
    return this.open;
  }
  
  public RxtxDeviceAddress localAddress()
  {
    return (RxtxDeviceAddress)super.localAddress();
  }
  
  protected RxtxDeviceAddress localAddress0()
  {
    return LOCAL_ADDRESS;
  }
  
  protected AbstractChannel.AbstractUnsafe newUnsafe()
  {
    return new RxtxUnsafe(null);
  }
  
  public RxtxDeviceAddress remoteAddress()
  {
    return (RxtxDeviceAddress)super.remoteAddress();
  }
  
  protected RxtxDeviceAddress remoteAddress0()
  {
    return this.deviceAddress;
  }
  
  protected ChannelFuture shutdownInput()
  {
    return newFailedFuture(new UnsupportedOperationException("shutdownInput"));
  }
  
  private final class RxtxUnsafe
    extends AbstractChannel.AbstractUnsafe
  {
    private RxtxUnsafe()
    {
      super();
    }
    
    public void connect(SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2, ChannelPromise paramChannelPromise)
    {
      if ((paramChannelPromise.setUncancellable()) && (ensureOpen(paramChannelPromise))) {
        try
        {
          boolean bool = RxtxChannel.this.isActive();
          RxtxChannel.this.doConnect(paramSocketAddress1, paramSocketAddress2);
          int i = ((Integer)RxtxChannel.this.config().getOption(RxtxChannelOption.WAIT_TIME)).intValue();
          if (i > 0)
          {
            paramSocketAddress2 = RxtxChannel.this.eventLoop();
            paramSocketAddress1 = new io/netty/channel/rxtx/RxtxChannel$RxtxUnsafe$1;
            paramSocketAddress1.<init>(this, paramChannelPromise, bool);
            paramSocketAddress2.schedule(paramSocketAddress1, i, TimeUnit.MILLISECONDS);
          }
          else
          {
            RxtxChannel.this.doInit();
            safeSetSuccess(paramChannelPromise);
            if ((!bool) && (RxtxChannel.this.isActive())) {
              RxtxChannel.this.pipeline().fireChannelActive();
            }
          }
        }
        finally
        {
          safeSetFailure(paramChannelPromise, paramSocketAddress1);
          closeIfClosed();
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\rxtx\RxtxChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */