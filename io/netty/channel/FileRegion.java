package io.netty.channel;

import io.netty.util.ReferenceCounted;
import java.io.IOException;
import java.nio.channels.WritableByteChannel;

public abstract interface FileRegion
  extends ReferenceCounted
{
  public abstract long count();
  
  public abstract long position();
  
  public abstract FileRegion retain();
  
  public abstract FileRegion retain(int paramInt);
  
  public abstract FileRegion touch();
  
  public abstract FileRegion touch(Object paramObject);
  
  public abstract long transferTo(WritableByteChannel paramWritableByteChannel, long paramLong)
    throws IOException;
  
  @Deprecated
  public abstract long transfered();
  
  public abstract long transferred();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\FileRegion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */