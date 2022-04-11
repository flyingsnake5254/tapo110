package com.google.android.exoplayer2.o2.j0;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.u;
import java.nio.ByteBuffer;
import java.util.UUID;

public final class l
{
  public static byte[] a(UUID paramUUID, @Nullable byte[] paramArrayOfByte)
  {
    return b(paramUUID, null, paramArrayOfByte);
  }
  
  public static byte[] b(UUID paramUUID, @Nullable UUID[] paramArrayOfUUID, @Nullable byte[] paramArrayOfByte)
  {
    int i = 0;
    if (paramArrayOfByte != null) {
      j = paramArrayOfByte.length;
    } else {
      j = 0;
    }
    int k = j + 32;
    int j = k;
    if (paramArrayOfUUID != null) {
      j = k + (paramArrayOfUUID.length * 16 + 4);
    }
    ByteBuffer localByteBuffer = ByteBuffer.allocate(j);
    localByteBuffer.putInt(j);
    localByteBuffer.putInt(1886614376);
    if (paramArrayOfUUID != null) {
      j = 16777216;
    } else {
      j = 0;
    }
    localByteBuffer.putInt(j);
    localByteBuffer.putLong(paramUUID.getMostSignificantBits());
    localByteBuffer.putLong(paramUUID.getLeastSignificantBits());
    if (paramArrayOfUUID != null)
    {
      localByteBuffer.putInt(paramArrayOfUUID.length);
      k = paramArrayOfUUID.length;
      for (j = i; j < k; j++)
      {
        paramUUID = paramArrayOfUUID[j];
        localByteBuffer.putLong(paramUUID.getMostSignificantBits());
        localByteBuffer.putLong(paramUUID.getLeastSignificantBits());
      }
    }
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      localByteBuffer.putInt(paramArrayOfByte.length);
      localByteBuffer.put(paramArrayOfByte);
    }
    return localByteBuffer.array();
  }
  
  public static boolean c(byte[] paramArrayOfByte)
  {
    boolean bool;
    if (d(paramArrayOfByte) != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @Nullable
  private static a d(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new d0(paramArrayOfByte);
    if (paramArrayOfByte.f() < 32) {
      return null;
    }
    paramArrayOfByte.P(0);
    if (paramArrayOfByte.n() != paramArrayOfByte.a() + 4) {
      return null;
    }
    if (paramArrayOfByte.n() != 1886614376) {
      return null;
    }
    int i = e.c(paramArrayOfByte.n());
    if (i > 1)
    {
      paramArrayOfByte = new StringBuilder(37);
      paramArrayOfByte.append("Unsupported pssh version: ");
      paramArrayOfByte.append(i);
      u.h("PsshAtomUtil", paramArrayOfByte.toString());
      return null;
    }
    UUID localUUID = new UUID(paramArrayOfByte.w(), paramArrayOfByte.w());
    if (i == 1) {
      paramArrayOfByte.Q(paramArrayOfByte.H() * 16);
    }
    int j = paramArrayOfByte.H();
    if (j != paramArrayOfByte.a()) {
      return null;
    }
    byte[] arrayOfByte = new byte[j];
    paramArrayOfByte.j(arrayOfByte, 0, j);
    return new a(localUUID, i, arrayOfByte);
  }
  
  @Nullable
  public static byte[] e(byte[] paramArrayOfByte, UUID paramUUID)
  {
    Object localObject = d(paramArrayOfByte);
    if (localObject == null) {
      return null;
    }
    if (!paramUUID.equals(a.a((a)localObject)))
    {
      paramArrayOfByte = String.valueOf(paramUUID);
      localObject = String.valueOf(a.a((a)localObject));
      paramUUID = new StringBuilder(paramArrayOfByte.length() + 33 + ((String)localObject).length());
      paramUUID.append("UUID mismatch. Expected: ");
      paramUUID.append(paramArrayOfByte);
      paramUUID.append(", got: ");
      paramUUID.append((String)localObject);
      paramUUID.append(".");
      u.h("PsshAtomUtil", paramUUID.toString());
      return null;
    }
    return a.c((a)localObject);
  }
  
  @Nullable
  public static UUID f(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = d(paramArrayOfByte);
    if (paramArrayOfByte == null) {
      return null;
    }
    return a.a(paramArrayOfByte);
  }
  
  public static int g(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = d(paramArrayOfByte);
    if (paramArrayOfByte == null) {
      return -1;
    }
    return a.b(paramArrayOfByte);
  }
  
  private static class a
  {
    private final UUID a;
    private final int b;
    private final byte[] c;
    
    public a(UUID paramUUID, int paramInt, byte[] paramArrayOfByte)
    {
      this.a = paramUUID;
      this.b = paramInt;
      this.c = paramArrayOfByte;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\j0\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */