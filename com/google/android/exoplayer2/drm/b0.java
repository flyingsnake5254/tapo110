package com.google.android.exoplayer2.drm;

import android.media.MediaDrmException;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiresApi(18)
public final class b0
  implements e0
{
  public Class<j0> a()
  {
    return j0.class;
  }
  
  public Map<String, String> b(byte[] paramArrayOfByte)
  {
    throw new IllegalStateException();
  }
  
  public d0 c(byte[] paramArrayOfByte)
  {
    throw new IllegalStateException();
  }
  
  public e0.d d()
  {
    throw new IllegalStateException();
  }
  
  public byte[] e()
    throws MediaDrmException
  {
    throw new MediaDrmException("Attempting to open a session using a dummy ExoMediaDrm.");
  }
  
  public void f(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    throw new IllegalStateException();
  }
  
  public void g(@Nullable e0.b paramb) {}
  
  public void h(byte[] paramArrayOfByte)
  {
    throw new IllegalStateException();
  }
  
  public void i(byte[] paramArrayOfByte) {}
  
  @Nullable
  public byte[] j(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    throw new IllegalStateException();
  }
  
  public e0.a k(byte[] paramArrayOfByte, @Nullable List<DrmInitData.SchemeData> paramList, int paramInt, @Nullable HashMap<String, String> paramHashMap)
  {
    throw new IllegalStateException();
  }
  
  public void release() {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\drm\b0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */