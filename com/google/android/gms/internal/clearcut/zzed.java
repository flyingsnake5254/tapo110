package com.google.android.gms.internal.clearcut;

import java.lang.reflect.Field;
import java.util.Arrays;

final class zzed
{
  private final int flags;
  private final Object[] zzmj;
  private final int zzmk;
  private final int zzml;
  private final int zzmm;
  private final int[] zzms;
  private final zzee zznh;
  private Class<?> zzni;
  private final int zznj;
  private final int zznk;
  private final int zznl;
  private final int zznm;
  private final int zznn;
  private final int zzno;
  private int zznp;
  private int zznq;
  private int zznr = Integer.MAX_VALUE;
  private int zzns = Integer.MIN_VALUE;
  private int zznt = 0;
  private int zznu = 0;
  private int zznv = 0;
  private int zznw = 0;
  private int zznx = 0;
  private int zzny;
  private int zznz;
  private int zzoa;
  private int zzob;
  private int zzoc;
  private Field zzod;
  private Object zzoe;
  private Object zzof;
  private Object zzog;
  
  zzed(Class<?> paramClass, String paramString, Object[] paramArrayOfObject)
  {
    this.zzni = paramClass;
    paramString = new zzee(paramString);
    this.zznh = paramString;
    this.zzmj = paramArrayOfObject;
    this.flags = paramString.next();
    int i = paramString.next();
    this.zznj = i;
    paramClass = null;
    if (i == 0)
    {
      this.zznk = 0;
      this.zznl = 0;
      this.zzmk = 0;
      this.zzml = 0;
      this.zznm = 0;
      this.zznn = 0;
      this.zzmm = 0;
      this.zzno = 0;
      this.zzms = null;
      return;
    }
    i = paramString.next();
    this.zznk = i;
    int j = paramString.next();
    this.zznl = j;
    this.zzmk = paramString.next();
    this.zzml = paramString.next();
    this.zznn = paramString.next();
    this.zzmm = paramString.next();
    this.zznm = paramString.next();
    this.zzno = paramString.next();
    int k = paramString.next();
    if (k != 0) {
      paramClass = new int[k];
    }
    this.zzms = paramClass;
    this.zznp = ((i << 1) + j);
  }
  
  private static Field zza(Class<?> paramClass, String paramString)
  {
    try
    {
      Field localField = paramClass.getDeclaredField(paramString);
      return localField;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (localObject2 : paramClass.getDeclaredFields()) {
        if (paramString.equals(((Field)localObject2).getName())) {
          return (Field)localObject2;
        }
      }
      paramClass = paramClass.getName();
      Object localObject2 = Arrays.toString((Object[])???);
      ??? = new StringBuilder(String.valueOf(paramString).length() + 40 + paramClass.length() + String.valueOf(localObject2).length());
      ((StringBuilder)???).append("Field ");
      ((StringBuilder)???).append(paramString);
      ((StringBuilder)???).append(" for ");
      ((StringBuilder)???).append(paramClass);
      ((StringBuilder)???).append(" not found. Known fields are ");
      ((StringBuilder)???).append((String)localObject2);
      throw new RuntimeException(((StringBuilder)???).toString());
    }
  }
  
  private final Object zzcw()
  {
    Object[] arrayOfObject = this.zzmj;
    int i = this.zznp;
    this.zznp = (i + 1);
    return arrayOfObject[i];
  }
  
  private final boolean zzcz()
  {
    return (this.flags & 0x1) == 1;
  }
  
  final boolean next()
  {
    boolean bool = this.zznh.hasNext();
    int i = 0;
    if (!bool) {
      return false;
    }
    this.zzny = this.zznh.next();
    int j = this.zznh.next();
    this.zznz = j;
    int k = j & 0xFF;
    this.zzoa = k;
    j = this.zzny;
    if (j < this.zznr) {
      this.zznr = j;
    }
    if (j > this.zzns) {
      this.zzns = j;
    }
    zzcb localzzcb = zzcb.zziw;
    if (k == localzzcb.id()) {
      this.zznt += 1;
    } else if ((this.zzoa >= zzcb.zzhq.id()) && (this.zzoa <= zzcb.zziv.id())) {
      this.zznu += 1;
    }
    j = this.zznx + 1;
    this.zznx = j;
    if (zzeh.zzc(this.zznr, this.zzny, j))
    {
      j = this.zzny + 1;
      this.zznw = j;
      j -= this.zznr;
    }
    else
    {
      j = this.zznv + 1;
    }
    this.zznv = j;
    if ((this.zznz & 0x400) != 0) {
      j = 1;
    } else {
      j = 0;
    }
    if (j != 0)
    {
      localObject = this.zzms;
      j = this.zznq;
      this.zznq = (j + 1);
      localObject[j] = this.zzny;
    }
    this.zzoe = null;
    this.zzof = null;
    this.zzog = null;
    if (zzda())
    {
      this.zzob = this.zznh.next();
      if ((this.zzoa != zzcb.zzhh.id() + 51) && (this.zzoa != zzcb.zzhp.id() + 51))
      {
        if ((this.zzoa != zzcb.zzhk.id() + 51) || (!zzcz())) {
          break label574;
        }
        this.zzof = zzcw();
        break label574;
      }
    }
    label359:
    for (Object localObject = zzcw();; localObject = this.zzod.getType())
    {
      this.zzoe = localObject;
      break label574;
      this.zzod = zza(this.zzni, (String)zzcw());
      if (zzde()) {
        this.zzoc = this.zznh.next();
      }
      if ((this.zzoa != zzcb.zzhh.id()) && (this.zzoa != zzcb.zzhp.id()))
      {
        if ((this.zzoa == zzcb.zzhz.id()) || (this.zzoa == zzcb.zziv.id())) {
          break label359;
        }
        if ((this.zzoa != zzcb.zzhk.id()) && (this.zzoa != zzcb.zzic.id()) && (this.zzoa != zzcb.zziq.id()))
        {
          if (this.zzoa != localzzcb.id()) {
            break label574;
          }
          this.zzog = zzcw();
          j = i;
          if ((this.zznz & 0x800) != 0) {
            j = 1;
          }
          if (j == 0) {
            break label574;
          }
        }
        else
        {
          if (!zzcz()) {
            break label574;
          }
        }
        break;
      }
    }
    label574:
    return true;
  }
  
  final int zzcx()
  {
    return this.zzny;
  }
  
  final int zzcy()
  {
    return this.zzoa;
  }
  
  final boolean zzda()
  {
    return this.zzoa > zzcb.zziw.id();
  }
  
  final Field zzdb()
  {
    int i = this.zzob << 1;
    Object localObject = this.zzmj[i];
    if ((localObject instanceof Field)) {
      return (Field)localObject;
    }
    localObject = zza(this.zzni, (String)localObject);
    this.zzmj[i] = localObject;
    return (Field)localObject;
  }
  
  final Field zzdc()
  {
    int i = (this.zzob << 1) + 1;
    Object localObject = this.zzmj[i];
    if ((localObject instanceof Field)) {
      return (Field)localObject;
    }
    localObject = zza(this.zzni, (String)localObject);
    this.zzmj[i] = localObject;
    return (Field)localObject;
  }
  
  final Field zzdd()
  {
    return this.zzod;
  }
  
  final boolean zzde()
  {
    return (zzcz()) && (this.zzoa <= zzcb.zzhp.id());
  }
  
  final Field zzdf()
  {
    int i = (this.zznk << 1) + this.zzoc / 32;
    Object localObject = this.zzmj[i];
    if ((localObject instanceof Field)) {
      return (Field)localObject;
    }
    localObject = zza(this.zzni, (String)localObject);
    this.zzmj[i] = localObject;
    return (Field)localObject;
  }
  
  final int zzdg()
  {
    return this.zzoc % 32;
  }
  
  final boolean zzdh()
  {
    return (this.zznz & 0x100) != 0;
  }
  
  final boolean zzdi()
  {
    return (this.zznz & 0x200) != 0;
  }
  
  final Object zzdj()
  {
    return this.zzoe;
  }
  
  final Object zzdk()
  {
    return this.zzof;
  }
  
  final Object zzdl()
  {
    return this.zzog;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */