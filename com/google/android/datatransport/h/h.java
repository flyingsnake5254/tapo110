package com.google.android.datatransport.h;

import androidx.annotation.NonNull;
import com.google.android.datatransport.b;
import java.util.Arrays;
import java.util.Objects;

public final class h
{
  private final b a;
  private final byte[] b;
  
  public h(@NonNull b paramb, @NonNull byte[] paramArrayOfByte)
  {
    Objects.requireNonNull(paramb, "encoding is null");
    Objects.requireNonNull(paramArrayOfByte, "bytes is null");
    this.a = paramb;
    this.b = paramArrayOfByte;
  }
  
  public byte[] a()
  {
    return this.b;
  }
  
  public b b()
  {
    return this.a;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof h)) {
      return false;
    }
    paramObject = (h)paramObject;
    if (!this.a.equals(((h)paramObject).a)) {
      return false;
    }
    return Arrays.equals(this.b, ((h)paramObject).b);
  }
  
  public int hashCode()
  {
    return (this.a.hashCode() ^ 0xF4243) * 1000003 ^ Arrays.hashCode(this.b);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EncodedPayload{encoding=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", bytes=[...]}");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\h\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */