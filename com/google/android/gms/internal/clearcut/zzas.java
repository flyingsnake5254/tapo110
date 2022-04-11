package com.google.android.gms.internal.clearcut;

import java.io.IOException;

public abstract class zzas<MessageType extends zzas<MessageType, BuilderType>, BuilderType extends zzat<MessageType, BuilderType>>
  implements zzdo
{
  private static boolean zzey = false;
  protected int zzex = 0;
  
  void zzf(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public final zzbb zzr()
  {
    try
    {
      localObject = zzbb.zzk(zzas());
      zzb(((zzbg)localObject).zzae());
      localObject = ((zzbg)localObject).zzad();
      return (zzbb)localObject;
    }
    catch (IOException localIOException)
    {
      String str = getClass().getName();
      Object localObject = new StringBuilder(str.length() + 62 + "ByteString".length());
      ((StringBuilder)localObject).append("Serializing ");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(" to a ");
      ((StringBuilder)localObject).append("ByteString");
      ((StringBuilder)localObject).append(" threw an IOException (should never happen).");
      throw new RuntimeException(((StringBuilder)localObject).toString(), localIOException);
    }
  }
  
  int zzs()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzas.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */