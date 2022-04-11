package com.google.android.gms.internal.vision;

import java.util.Arrays;
import java.util.Map.Entry;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzdq<K, V>
  extends zzdl<K, V>
{
  private static final zzdl<Object, Object> zzmm = new zzdq(null, new Object[0], 0);
  private final transient int size;
  private final transient Object[] zzmk;
  private final transient Object zzmn;
  
  private zzdq(Object paramObject, Object[] paramArrayOfObject, int paramInt)
  {
    this.zzmn = paramObject;
    this.zzmk = paramArrayOfObject;
    this.size = paramInt;
  }
  
  static <K, V> zzdq<K, V> zza(int paramInt, Object[] paramArrayOfObject)
  {
    paramInt = paramArrayOfObject.length;
    boolean bool = true;
    zzcy.zze(4, paramInt >> 1);
    int i = Math.max(4, 2);
    int j = 1073741824;
    int k = 0;
    int m = 0;
    int n = 0;
    if (i < 751619276)
    {
      paramInt = Integer.highestOneBit(i - 1) << 1;
      for (;;)
      {
        j = paramInt;
        if (paramInt * 0.7D >= i) {
          break;
        }
        paramInt <<= 1;
      }
    }
    if (i >= 1073741824) {
      bool = false;
    }
    zzcy.checkArgument(bool, "collection too large");
    i = j - 1;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (j <= 128)
    {
      localObject1 = new byte[j];
      Arrays.fill((byte[])localObject1, (byte)-1);
      paramInt = n;
      localObject2 = localObject1;
      if (paramInt < 4)
      {
        n = paramInt * 2;
        localObject2 = paramArrayOfObject[n];
        localObject3 = paramArrayOfObject[(n ^ 0x1)];
        zzdf.zza(localObject2, localObject3);
        for (j = zzdi.zzs(localObject2.hashCode());; j++)
        {
          j &= i;
          k = localObject1[j] & 0xFF;
          if (k == 255)
          {
            localObject1[j] = ((byte)(byte)n);
            paramInt++;
            break;
          }
          if (paramArrayOfObject[k].equals(localObject2)) {
            break label217;
          }
        }
        label217:
        throw zza(localObject2, localObject3, paramArrayOfObject, k);
      }
    }
    else if (j <= 32768)
    {
      localObject1 = new short[j];
      Arrays.fill((short[])localObject1, (short)-1);
      paramInt = k;
      localObject2 = localObject1;
      if (paramInt < 4)
      {
        n = paramInt * 2;
        localObject3 = paramArrayOfObject[n];
        localObject2 = paramArrayOfObject[(n ^ 0x1)];
        zzdf.zza(localObject3, localObject2);
        for (j = zzdi.zzs(localObject3.hashCode());; j++)
        {
          j &= i;
          k = localObject1[j] & 0xFFFF;
          if (k == 65535)
          {
            localObject1[j] = ((short)(short)n);
            paramInt++;
            break;
          }
          if (paramArrayOfObject[k].equals(localObject3)) {
            break label351;
          }
        }
        label351:
        throw zza(localObject3, localObject2, paramArrayOfObject, k);
      }
    }
    else
    {
      localObject1 = new int[j];
      Arrays.fill((int[])localObject1, -1);
      paramInt = m;
      localObject2 = localObject1;
      if (paramInt < 4)
      {
        n = paramInt * 2;
        localObject3 = paramArrayOfObject[n];
        localObject2 = paramArrayOfObject[(n ^ 0x1)];
        zzdf.zza(localObject3, localObject2);
        for (j = zzdi.zzs(localObject3.hashCode());; j = k + 1)
        {
          k = j & i;
          j = localObject1[k];
          if (j == -1)
          {
            localObject1[k] = n;
            paramInt++;
            break;
          }
          if (paramArrayOfObject[j].equals(localObject3)) {
            break label475;
          }
        }
        label475:
        throw zza(localObject3, localObject2, paramArrayOfObject, j);
      }
    }
    return new zzdq(localObject2, paramArrayOfObject, 4);
  }
  
  private static IllegalArgumentException zza(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject, int paramInt)
  {
    paramObject1 = String.valueOf(paramObject1);
    String str = String.valueOf(paramObject2);
    paramObject2 = String.valueOf(paramArrayOfObject[paramInt]);
    paramArrayOfObject = String.valueOf(paramArrayOfObject[(paramInt ^ 0x1)]);
    StringBuilder localStringBuilder = new StringBuilder(((String)paramObject1).length() + 39 + str.length() + ((String)paramObject2).length() + paramArrayOfObject.length());
    localStringBuilder.append("Multiple entries with same key: ");
    localStringBuilder.append((String)paramObject1);
    localStringBuilder.append("=");
    localStringBuilder.append(str);
    localStringBuilder.append(" and ");
    localStringBuilder.append((String)paramObject2);
    localStringBuilder.append("=");
    localStringBuilder.append(paramArrayOfObject);
    return new IllegalArgumentException(localStringBuilder.toString());
  }
  
  @NullableDecl
  public final V get(@NullableDecl Object paramObject)
  {
    Object localObject = this.zzmn;
    Object[] arrayOfObject = this.zzmk;
    int i = this.size;
    if (paramObject == null) {
      return null;
    }
    if (i == 1)
    {
      if (arrayOfObject[0].equals(paramObject)) {
        return (V)arrayOfObject[1];
      }
      return null;
    }
    if (localObject == null) {
      return null;
    }
    int k;
    if ((localObject instanceof byte[]))
    {
      localObject = (byte[])localObject;
      j = localObject.length;
      for (i = zzdi.zzs(paramObject.hashCode());; i++)
      {
        i &= j - 1;
        k = localObject[i] & 0xFF;
        if (k == 255) {
          return null;
        }
        if (arrayOfObject[k].equals(paramObject)) {
          return (V)arrayOfObject[(k ^ 0x1)];
        }
      }
    }
    if ((localObject instanceof short[]))
    {
      localObject = (short[])localObject;
      j = localObject.length;
      for (i = zzdi.zzs(paramObject.hashCode());; i = k + 1)
      {
        k = i & j - 1;
        i = localObject[k] & 0xFFFF;
        if (i == 65535) {
          return null;
        }
        if (arrayOfObject[i].equals(paramObject)) {
          return (V)arrayOfObject[(i ^ 0x1)];
        }
      }
    }
    localObject = (int[])localObject;
    int j = localObject.length;
    for (i = zzdi.zzs(paramObject.hashCode());; i++)
    {
      i &= j - 1;
      k = localObject[i];
      if (k == -1) {
        return null;
      }
      if (arrayOfObject[k].equals(paramObject)) {
        return (V)arrayOfObject[(k ^ 0x1)];
      }
    }
  }
  
  public final int size()
  {
    return this.size;
  }
  
  final zzdo<Map.Entry<K, V>> zzcf()
  {
    return new zzdp(this, this.zzmk, 0, this.size);
  }
  
  final zzdo<K> zzcg()
  {
    return new zzdr(this, new zzdu(this.zzmk, 0, this.size));
  }
  
  final zzdh<V> zzch()
  {
    return new zzdu(this.zzmk, 1, this.size);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzdq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */