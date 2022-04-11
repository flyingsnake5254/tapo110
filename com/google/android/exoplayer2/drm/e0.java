package com.google.android.exoplayer2.drm;

import android.media.DeniedByServerException;
import android.media.MediaCryptoException;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public abstract interface e0
{
  public abstract Class<? extends d0> a();
  
  public abstract Map<String, String> b(byte[] paramArrayOfByte);
  
  public abstract d0 c(byte[] paramArrayOfByte)
    throws MediaCryptoException;
  
  public abstract d d();
  
  public abstract byte[] e()
    throws MediaDrmException;
  
  public abstract void f(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  public abstract void g(@Nullable b paramb);
  
  public abstract void h(byte[] paramArrayOfByte)
    throws DeniedByServerException;
  
  public abstract void i(byte[] paramArrayOfByte);
  
  @Nullable
  public abstract byte[] j(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws NotProvisionedException, DeniedByServerException;
  
  public abstract a k(byte[] paramArrayOfByte, @Nullable List<DrmInitData.SchemeData> paramList, int paramInt, @Nullable HashMap<String, String> paramHashMap)
    throws NotProvisionedException;
  
  public abstract void release();
  
  public static final class a
  {
    private final byte[] a;
    private final String b;
    private final int c;
    
    public a(byte[] paramArrayOfByte, String paramString, int paramInt)
    {
      this.a = paramArrayOfByte;
      this.b = paramString;
      this.c = paramInt;
    }
    
    public byte[] a()
    {
      return this.a;
    }
    
    public String b()
    {
      return this.b;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(e0 parame0, @Nullable byte[] paramArrayOfByte1, int paramInt1, int paramInt2, @Nullable byte[] paramArrayOfByte2);
  }
  
  public static abstract interface c
  {
    public abstract e0 a(UUID paramUUID);
  }
  
  public static final class d
  {
    private final byte[] a;
    private final String b;
    
    public d(byte[] paramArrayOfByte, String paramString)
    {
      this.a = paramArrayOfByte;
      this.b = paramString;
    }
    
    public byte[] a()
    {
      return this.a;
    }
    
    public String b()
    {
      return this.b;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\drm\e0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */