package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.util.Arrays;

public final class zzha
  extends zzfu<zzha>
  implements Cloneable
{
  private String tag = "";
  public long zzbjf = 0L;
  public long zzbjg = 0L;
  private long zzbjh = 0L;
  public int zzbji = 0;
  private String zzbjj = "";
  private int zzbjk = 0;
  private boolean zzbjl = false;
  private zzhb[] zzbjm = zzhb.zzge();
  private byte[] zzbjn;
  private zzge.zzd zzbjo;
  public byte[] zzbjp;
  private String zzbjq;
  private String zzbjr;
  private zzgy zzbjs;
  private String zzbjt;
  public long zzbju;
  private zzgz zzbjv;
  public byte[] zzbjw;
  private String zzbjx;
  private int zzbjy;
  private int[] zzbjz;
  private long zzbka;
  private zzge.zzs zzbkb;
  public boolean zzbkc;
  
  public zzha()
  {
    byte[] arrayOfByte = zzgb.zzse;
    this.zzbjn = arrayOfByte;
    this.zzbjo = null;
    this.zzbjp = arrayOfByte;
    this.zzbjq = "";
    this.zzbjr = "";
    this.zzbjs = null;
    this.zzbjt = "";
    this.zzbju = 180000L;
    this.zzbjv = null;
    this.zzbjw = arrayOfByte;
    this.zzbjx = "";
    this.zzbjy = 0;
    this.zzbjz = zzgb.zzrx;
    this.zzbka = 0L;
    this.zzbkb = null;
    this.zzbkc = false;
    this.zzrj = null;
    this.zzrs = -1;
  }
  
  private final zzha zzgd()
  {
    try
    {
      zzha localzzha = (zzha)super.zzeo();
      Object localObject = this.zzbjm;
      if ((localObject != null) && (localObject.length > 0))
      {
        localzzha.zzbjm = new zzhb[localObject.length];
        for (int i = 0;; i++)
        {
          localObject = this.zzbjm;
          if (i >= localObject.length) {
            break;
          }
          if (localObject[i] != null) {
            localzzha.zzbjm[i] = ((zzhb)localObject[i].clone());
          }
        }
      }
      localObject = this.zzbjo;
      if (localObject != null) {
        localzzha.zzbjo = ((zzge.zzd)localObject);
      }
      localObject = this.zzbjs;
      if (localObject != null) {
        localzzha.zzbjs = ((zzgy)((zzfz)localObject).clone());
      }
      localObject = this.zzbjv;
      if (localObject != null) {
        localzzha.zzbjv = ((zzgz)((zzfz)localObject).clone());
      }
      localObject = this.zzbjz;
      if ((localObject != null) && (localObject.length > 0)) {
        localzzha.zzbjz = ((int[])((int[])localObject).clone());
      }
      localObject = this.zzbkb;
      if (localObject != null) {
        localzzha.zzbkb = ((zzge.zzs)localObject);
      }
      return localzzha;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError(localCloneNotSupportedException);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zzha)) {
      return false;
    }
    paramObject = (zzha)paramObject;
    if (this.zzbjf != ((zzha)paramObject).zzbjf) {
      return false;
    }
    if (this.zzbjg != ((zzha)paramObject).zzbjg) {
      return false;
    }
    Object localObject = this.tag;
    if (localObject == null)
    {
      if (((zzha)paramObject).tag != null) {
        return false;
      }
    }
    else if (!((String)localObject).equals(((zzha)paramObject).tag)) {
      return false;
    }
    if (this.zzbji != ((zzha)paramObject).zzbji) {
      return false;
    }
    localObject = this.zzbjj;
    if (localObject == null)
    {
      if (((zzha)paramObject).zzbjj != null) {
        return false;
      }
    }
    else if (!((String)localObject).equals(((zzha)paramObject).zzbjj)) {
      return false;
    }
    if (!zzfy.equals(this.zzbjm, ((zzha)paramObject).zzbjm)) {
      return false;
    }
    if (!Arrays.equals(this.zzbjn, ((zzha)paramObject).zzbjn)) {
      return false;
    }
    localObject = this.zzbjo;
    if (localObject == null)
    {
      if (((zzha)paramObject).zzbjo != null) {
        return false;
      }
    }
    else if (!((zzcg)localObject).equals(((zzha)paramObject).zzbjo)) {
      return false;
    }
    if (!Arrays.equals(this.zzbjp, ((zzha)paramObject).zzbjp)) {
      return false;
    }
    localObject = this.zzbjq;
    if (localObject == null)
    {
      if (((zzha)paramObject).zzbjq != null) {
        return false;
      }
    }
    else if (!((String)localObject).equals(((zzha)paramObject).zzbjq)) {
      return false;
    }
    localObject = this.zzbjr;
    if (localObject == null)
    {
      if (((zzha)paramObject).zzbjr != null) {
        return false;
      }
    }
    else if (!((String)localObject).equals(((zzha)paramObject).zzbjr)) {
      return false;
    }
    localObject = this.zzbjs;
    if (localObject == null)
    {
      if (((zzha)paramObject).zzbjs != null) {
        return false;
      }
    }
    else if (!((zzgy)localObject).equals(((zzha)paramObject).zzbjs)) {
      return false;
    }
    localObject = this.zzbjt;
    if (localObject == null)
    {
      if (((zzha)paramObject).zzbjt != null) {
        return false;
      }
    }
    else if (!((String)localObject).equals(((zzha)paramObject).zzbjt)) {
      return false;
    }
    if (this.zzbju != ((zzha)paramObject).zzbju) {
      return false;
    }
    localObject = this.zzbjv;
    if (localObject == null)
    {
      if (((zzha)paramObject).zzbjv != null) {
        return false;
      }
    }
    else if (!((zzgz)localObject).equals(((zzha)paramObject).zzbjv)) {
      return false;
    }
    if (!Arrays.equals(this.zzbjw, ((zzha)paramObject).zzbjw)) {
      return false;
    }
    localObject = this.zzbjx;
    if (localObject == null)
    {
      if (((zzha)paramObject).zzbjx != null) {
        return false;
      }
    }
    else if (!((String)localObject).equals(((zzha)paramObject).zzbjx)) {
      return false;
    }
    if (!zzfy.equals(this.zzbjz, ((zzha)paramObject).zzbjz)) {
      return false;
    }
    localObject = this.zzbkb;
    if (localObject == null)
    {
      if (((zzha)paramObject).zzbkb != null) {
        return false;
      }
    }
    else if (!((zzcg)localObject).equals(((zzha)paramObject).zzbkb)) {
      return false;
    }
    if (this.zzbkc != ((zzha)paramObject).zzbkc) {
      return false;
    }
    localObject = this.zzrj;
    if ((localObject != null) && (!((zzfw)localObject).isEmpty())) {
      return this.zzrj.equals(((zzfu)paramObject).zzrj);
    }
    paramObject = ((zzfu)paramObject).zzrj;
    return (paramObject == null) || (((zzfw)paramObject).isEmpty());
  }
  
  public final int hashCode()
  {
    int i = zzha.class.getName().hashCode();
    long l = this.zzbjf;
    int j = (int)(l ^ l >>> 32);
    l = this.zzbjg;
    int k = (int)(l ^ l >>> 32);
    Object localObject = this.tag;
    int m = 0;
    int n;
    if (localObject == null) {
      n = 0;
    } else {
      n = ((String)localObject).hashCode();
    }
    int i1 = this.zzbji;
    localObject = this.zzbjj;
    int i2;
    if (localObject == null) {
      i2 = 0;
    } else {
      i2 = ((String)localObject).hashCode();
    }
    int i3 = 1237;
    int i4 = zzfy.hashCode(this.zzbjm);
    int i5 = Arrays.hashCode(this.zzbjn);
    localObject = this.zzbjo;
    int i6;
    if (localObject == null) {
      i6 = 0;
    } else {
      i6 = ((zzcg)localObject).hashCode();
    }
    int i7 = Arrays.hashCode(this.zzbjp);
    localObject = this.zzbjq;
    int i8;
    if (localObject == null) {
      i8 = 0;
    } else {
      i8 = ((String)localObject).hashCode();
    }
    localObject = this.zzbjr;
    int i9;
    if (localObject == null) {
      i9 = 0;
    } else {
      i9 = ((String)localObject).hashCode();
    }
    localObject = this.zzbjs;
    int i10;
    if (localObject == null) {
      i10 = 0;
    } else {
      i10 = ((zzgy)localObject).hashCode();
    }
    localObject = this.zzbjt;
    int i11;
    if (localObject == null) {
      i11 = 0;
    } else {
      i11 = ((String)localObject).hashCode();
    }
    l = this.zzbju;
    int i12 = (int)(l ^ l >>> 32);
    localObject = this.zzbjv;
    int i13;
    if (localObject == null) {
      i13 = 0;
    } else {
      i13 = ((zzgz)localObject).hashCode();
    }
    int i14 = Arrays.hashCode(this.zzbjw);
    localObject = this.zzbjx;
    int i15;
    if (localObject == null) {
      i15 = 0;
    } else {
      i15 = ((String)localObject).hashCode();
    }
    int i16 = zzfy.hashCode(this.zzbjz);
    localObject = this.zzbkb;
    int i17;
    if (localObject == null) {
      i17 = 0;
    } else {
      i17 = ((zzcg)localObject).hashCode();
    }
    if (this.zzbkc) {
      i3 = 1231;
    }
    localObject = this.zzrj;
    int i18 = m;
    if (localObject != null) {
      if (((zzfw)localObject).isEmpty()) {
        i18 = m;
      } else {
        i18 = this.zzrj.hashCode();
      }
    }
    return ((((((((((((((((((((((i + 527) * 31 + j) * 31 + k) * 31 * 31 + n) * 31 + i1) * 31 + i2) * 31 * 31 + 1237) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8) * 31 + i9) * 31 + i10) * 31 + i11) * 31 + i12) * 31 + i13) * 31 + i14) * 31 + i15) * 31 * 31 + i16) * 31 * 31 + i17) * 31 + i3) * 31 + i18;
  }
  
  public final void zza(zzfs paramzzfs)
    throws IOException
  {
    long l = this.zzbjf;
    if (l != 0L) {
      paramzzfs.zzi(1, l);
    }
    Object localObject1 = this.tag;
    if ((localObject1 != null) && (!((String)localObject1).equals(""))) {
      paramzzfs.zza(2, this.tag);
    }
    localObject1 = this.zzbjm;
    int i = 0;
    if ((localObject1 != null) && (localObject1.length > 0)) {
      for (j = 0;; j++)
      {
        localObject1 = this.zzbjm;
        if (j >= localObject1.length) {
          break;
        }
        localObject1 = localObject1[j];
        if (localObject1 != null) {
          paramzzfs.zza(3, (zzfz)localObject1);
        }
      }
    }
    Object localObject2 = this.zzbjn;
    localObject1 = zzgb.zzse;
    if (!Arrays.equals((byte[])localObject2, (byte[])localObject1)) {
      paramzzfs.zza(4, this.zzbjn);
    }
    if (!Arrays.equals(this.zzbjp, (byte[])localObject1)) {
      paramzzfs.zza(6, this.zzbjp);
    }
    localObject2 = this.zzbjs;
    if (localObject2 != null) {
      paramzzfs.zza(7, (zzfz)localObject2);
    }
    localObject2 = this.zzbjq;
    if ((localObject2 != null) && (!((String)localObject2).equals(""))) {
      paramzzfs.zza(8, this.zzbjq);
    }
    localObject2 = this.zzbjo;
    if (localObject2 != null) {
      paramzzfs.zze(9, (zzdo)localObject2);
    }
    int j = this.zzbji;
    if (j != 0) {
      paramzzfs.zzc(11, j);
    }
    localObject2 = this.zzbjr;
    if ((localObject2 != null) && (!((String)localObject2).equals(""))) {
      paramzzfs.zza(13, this.zzbjr);
    }
    localObject2 = this.zzbjt;
    if ((localObject2 != null) && (!((String)localObject2).equals(""))) {
      paramzzfs.zza(14, this.zzbjt);
    }
    l = this.zzbju;
    if (l != 180000L)
    {
      paramzzfs.zzb(15, 0);
      paramzzfs.zzn(zzfs.zzj(l));
    }
    localObject2 = this.zzbjv;
    if (localObject2 != null) {
      paramzzfs.zza(16, (zzfz)localObject2);
    }
    l = this.zzbjg;
    if (l != 0L) {
      paramzzfs.zzi(17, l);
    }
    if (!Arrays.equals(this.zzbjw, (byte[])localObject1)) {
      paramzzfs.zza(18, this.zzbjw);
    }
    localObject1 = this.zzbjz;
    if ((localObject1 != null) && (localObject1.length > 0)) {
      for (j = i;; j++)
      {
        localObject1 = this.zzbjz;
        if (j >= localObject1.length) {
          break;
        }
        paramzzfs.zzc(20, localObject1[j]);
      }
    }
    localObject1 = this.zzbkb;
    if (localObject1 != null) {
      paramzzfs.zze(23, (zzdo)localObject1);
    }
    localObject1 = this.zzbjx;
    if ((localObject1 != null) && (!((String)localObject1).equals(""))) {
      paramzzfs.zza(24, this.zzbjx);
    }
    boolean bool = this.zzbkc;
    if (bool) {
      paramzzfs.zzb(25, bool);
    }
    localObject1 = this.zzbjj;
    if ((localObject1 != null) && (!((String)localObject1).equals(""))) {
      paramzzfs.zza(26, this.zzbjj);
    }
    super.zza(paramzzfs);
  }
  
  protected final int zzen()
  {
    int i = super.zzen();
    long l = this.zzbjf;
    int j = i;
    if (l != 0L) {
      j = i + zzfs.zzd(1, l);
    }
    Object localObject1 = this.tag;
    i = j;
    if (localObject1 != null)
    {
      i = j;
      if (!((String)localObject1).equals("")) {
        i = j + zzfs.zzb(2, this.tag);
      }
    }
    localObject1 = this.zzbjm;
    int k = 0;
    j = i;
    if (localObject1 != null)
    {
      j = i;
      if (localObject1.length > 0)
      {
        m = 0;
        for (;;)
        {
          localObject1 = this.zzbjm;
          j = i;
          if (m >= localObject1.length) {
            break;
          }
          localObject1 = localObject1[m];
          j = i;
          if (localObject1 != null) {
            j = i + zzfs.zzb(3, (zzfz)localObject1);
          }
          m++;
          i = j;
        }
      }
    }
    Object localObject2 = this.zzbjn;
    localObject1 = zzgb.zzse;
    int m = j;
    if (!Arrays.equals((byte[])localObject2, (byte[])localObject1)) {
      m = j + zzfs.zzb(4, this.zzbjn);
    }
    i = m;
    if (!Arrays.equals(this.zzbjp, (byte[])localObject1)) {
      i = m + zzfs.zzb(6, this.zzbjp);
    }
    localObject2 = this.zzbjs;
    j = i;
    if (localObject2 != null) {
      j = i + zzfs.zzb(7, (zzfz)localObject2);
    }
    localObject2 = this.zzbjq;
    m = j;
    if (localObject2 != null)
    {
      m = j;
      if (!((String)localObject2).equals("")) {
        m = j + zzfs.zzb(8, this.zzbjq);
      }
    }
    localObject2 = this.zzbjo;
    i = m;
    if (localObject2 != null) {
      i = m + zzbn.zzc(9, (zzdo)localObject2);
    }
    m = this.zzbji;
    j = i;
    if (m != 0) {
      j = i + (zzfs.zzr(11) + zzfs.zzs(m));
    }
    localObject2 = this.zzbjr;
    i = j;
    if (localObject2 != null)
    {
      i = j;
      if (!((String)localObject2).equals("")) {
        i = j + zzfs.zzb(13, this.zzbjr);
      }
    }
    localObject2 = this.zzbjt;
    j = i;
    if (localObject2 != null)
    {
      j = i;
      if (!((String)localObject2).equals("")) {
        j = i + zzfs.zzb(14, this.zzbjt);
      }
    }
    l = this.zzbju;
    i = j;
    if (l != 180000L) {
      i = j + (zzfs.zzr(15) + zzfs.zzo(zzfs.zzj(l)));
    }
    localObject2 = this.zzbjv;
    j = i;
    if (localObject2 != null) {
      j = i + zzfs.zzb(16, (zzfz)localObject2);
    }
    l = this.zzbjg;
    m = j;
    if (l != 0L) {
      m = j + zzfs.zzd(17, l);
    }
    i = m;
    if (!Arrays.equals(this.zzbjw, (byte[])localObject1)) {
      i = m + zzfs.zzb(18, this.zzbjw);
    }
    localObject1 = this.zzbjz;
    j = i;
    if (localObject1 != null)
    {
      j = i;
      if (localObject1.length > 0)
      {
        m = 0;
        for (j = k;; j++)
        {
          localObject1 = this.zzbjz;
          if (j >= localObject1.length) {
            break;
          }
          m += zzfs.zzs(localObject1[j]);
        }
        j = i + m + localObject1.length * 2;
      }
    }
    localObject1 = this.zzbkb;
    i = j;
    if (localObject1 != null) {
      i = j + zzbn.zzc(23, (zzdo)localObject1);
    }
    localObject1 = this.zzbjx;
    j = i;
    if (localObject1 != null)
    {
      j = i;
      if (!((String)localObject1).equals("")) {
        j = i + zzfs.zzb(24, this.zzbjx);
      }
    }
    i = j;
    if (this.zzbkc) {
      i = j + (zzfs.zzr(25) + 1);
    }
    localObject1 = this.zzbjj;
    j = i;
    if (localObject1 != null)
    {
      j = i;
      if (!((String)localObject1).equals("")) {
        j = i + zzfs.zzb(26, this.zzbjj);
      }
    }
    return j;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzha.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */