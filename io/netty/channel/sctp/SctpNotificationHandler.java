package io.netty.channel.sctp;

import com.sun.nio.sctp.AbstractNotificationHandler;
import com.sun.nio.sctp.AssociationChangeNotification;
import com.sun.nio.sctp.HandlerResult;
import com.sun.nio.sctp.Notification;
import com.sun.nio.sctp.PeerAddressChangeNotification;
import com.sun.nio.sctp.SendFailedNotification;
import com.sun.nio.sctp.ShutdownNotification;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPipeline;
import io.netty.util.internal.ObjectUtil;

public final class SctpNotificationHandler
  extends AbstractNotificationHandler<Object>
{
  private final SctpChannel sctpChannel;
  
  public SctpNotificationHandler(SctpChannel paramSctpChannel)
  {
    this.sctpChannel = ((SctpChannel)ObjectUtil.checkNotNull(paramSctpChannel, "sctpChannel"));
  }
  
  private void fireEvent(Notification paramNotification)
  {
    this.sctpChannel.pipeline().fireUserEventTriggered(paramNotification);
  }
  
  public HandlerResult handleNotification(AssociationChangeNotification paramAssociationChangeNotification, Object paramObject)
  {
    fireEvent(paramAssociationChangeNotification);
    return HandlerResult.CONTINUE;
  }
  
  public HandlerResult handleNotification(PeerAddressChangeNotification paramPeerAddressChangeNotification, Object paramObject)
  {
    fireEvent(paramPeerAddressChangeNotification);
    return HandlerResult.CONTINUE;
  }
  
  public HandlerResult handleNotification(SendFailedNotification paramSendFailedNotification, Object paramObject)
  {
    fireEvent(paramSendFailedNotification);
    return HandlerResult.CONTINUE;
  }
  
  public HandlerResult handleNotification(ShutdownNotification paramShutdownNotification, Object paramObject)
  {
    fireEvent(paramShutdownNotification);
    this.sctpChannel.close();
    return HandlerResult.RETURN;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\sctp\SctpNotificationHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */