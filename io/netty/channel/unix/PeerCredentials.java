package io.netty.channel.unix;

import io.netty.util.internal.EmptyArrays;

public final class PeerCredentials
{
  private final int[] gids;
  private final int pid;
  private final int uid;
  
  PeerCredentials(int paramInt1, int paramInt2, int... paramVarArgs)
  {
    this.pid = paramInt1;
    this.uid = paramInt2;
    int[] arrayOfInt = paramVarArgs;
    if (paramVarArgs == null) {
      arrayOfInt = EmptyArrays.EMPTY_INTS;
    }
    this.gids = arrayOfInt;
  }
  
  public int[] gids()
  {
    return (int[])this.gids.clone();
  }
  
  public int pid()
  {
    return this.pid;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("UserCredentials[pid=");
    localStringBuilder.append(this.pid);
    localStringBuilder.append("; uid=");
    localStringBuilder.append(this.uid);
    localStringBuilder.append("; gids=[");
    int[] arrayOfInt = this.gids;
    if (arrayOfInt.length > 0)
    {
      localStringBuilder.append(arrayOfInt[0]);
      for (int i = 1; i < this.gids.length; i++)
      {
        localStringBuilder.append(", ");
        localStringBuilder.append(this.gids[i]);
      }
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public int uid()
  {
    return this.uid;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\unix\PeerCredentials.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */