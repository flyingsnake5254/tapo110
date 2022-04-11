package io.netty.channel.group;

import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.util.internal.ObjectUtil;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map.Entry;

public class ChannelGroupException
  extends ChannelException
  implements Iterable<Map.Entry<Channel, Throwable>>
{
  private static final long serialVersionUID = -4093064295562629453L;
  private final Collection<Map.Entry<Channel, Throwable>> failed;
  
  public ChannelGroupException(Collection<Map.Entry<Channel, Throwable>> paramCollection)
  {
    ObjectUtil.checkNonEmpty(paramCollection, "causes");
    this.failed = Collections.unmodifiableCollection(paramCollection);
  }
  
  public Iterator<Map.Entry<Channel, Throwable>> iterator()
  {
    return this.failed.iterator();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\group\ChannelGroupException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */