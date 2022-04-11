package kotlinx.coroutines.channels;

import java.util.NoSuchElementException;

public final class ClosedReceiveChannelException
  extends NoSuchElementException
{
  public ClosedReceiveChannelException(String paramString)
  {
    super(paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\channels\ClosedReceiveChannelException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */