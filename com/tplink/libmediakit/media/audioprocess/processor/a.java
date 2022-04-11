package com.tplink.libmediakit.media.audioprocess.processor;

import com.tplink.libmediakit.media.audioprocess.c;
import com.tplink.libmediakit.media.audioprocess.d;
import com.tplink.libmediakit.media.audioprocess.f;

public class a<T extends d>
  extends f<T>
{
  public a(c paramc)
  {
    super(paramc, 7);
    this.d = 1024;
  }
  
  protected int l(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte2 != null) && (paramArrayOfByte1.length == paramArrayOfByte2.length)) {
      System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte2, 0, paramArrayOfByte1.length);
    }
    return 0;
  }
  
  protected boolean p()
  {
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libmediakit\media\audioprocess\processor\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */