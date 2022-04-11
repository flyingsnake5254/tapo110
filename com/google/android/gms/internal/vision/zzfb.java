package com.google.android.gms.internal.vision;

import java.io.IOException;

public abstract class zzfb<MessageType extends zzey<MessageType, BuilderType>, BuilderType extends zzfb<MessageType, BuilderType>>
  implements zzig
{
  protected abstract BuilderType zza(MessageType paramMessageType);
  
  public abstract BuilderType zza(zzfy paramzzfy, zzgi paramzzgi)
    throws IOException;
  
  public BuilderType zza(byte[] paramArrayOfByte, int paramInt1, int paramInt2, zzgi paramzzgi)
    throws zzhh
  {
    try
    {
      paramArrayOfByte = zzfy.zza(paramArrayOfByte, 0, paramInt2, false);
      zza(paramArrayOfByte, paramzzgi);
      paramArrayOfByte.zzar(0);
      return this;
    }
    catch (IOException paramArrayOfByte)
    {
      paramzzgi = getClass().getName();
      StringBuilder localStringBuilder = new StringBuilder(paramzzgi.length() + 60 + "byte array".length());
      localStringBuilder.append("Reading ");
      localStringBuilder.append(paramzzgi);
      localStringBuilder.append(" from a ");
      localStringBuilder.append("byte array");
      localStringBuilder.append(" threw an IOException (should never happen).");
      throw new RuntimeException(localStringBuilder.toString(), paramArrayOfByte);
    }
    catch (zzhh paramArrayOfByte)
    {
      throw paramArrayOfByte;
    }
  }
  
  public abstract BuilderType zzdo();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzfb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */