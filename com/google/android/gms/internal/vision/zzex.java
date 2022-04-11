package com.google.android.gms.internal.vision;

public enum zzex
  implements zzhb
{
  private static final zzha<zzex> zzhl = new zzew();
  private final int value;
  
  static
  {
    zzex localzzex1 = new zzex("UNKNOWN_FORMAT", 0, 0);
    zzri = localzzex1;
    zzex localzzex2 = new zzex("CONTACT_INFO", 1, 1);
    zzrj = localzzex2;
    zzex localzzex3 = new zzex("EMAIL", 2, 2);
    zzrk = localzzex3;
    zzex localzzex4 = new zzex("ISBN", 3, 3);
    zzrl = localzzex4;
    zzex localzzex5 = new zzex("PHONE", 4, 4);
    zzrm = localzzex5;
    zzex localzzex6 = new zzex("PRODUCT", 5, 5);
    zzrn = localzzex6;
    zzex localzzex7 = new zzex("SMS", 6, 6);
    zzro = localzzex7;
    zzex localzzex8 = new zzex("TEXT", 7, 7);
    zzrp = localzzex8;
    zzex localzzex9 = new zzex("URL", 8, 8);
    zzrq = localzzex9;
    zzex localzzex10 = new zzex("WIFI", 9, 9);
    zzrr = localzzex10;
    zzex localzzex11 = new zzex("GEO", 10, 10);
    zzrs = localzzex11;
    zzex localzzex12 = new zzex("CALENDAR_EVENT", 11, 11);
    zzrt = localzzex12;
    zzex localzzex13 = new zzex("DRIVER_LICENSE", 12, 12);
    zzru = localzzex13;
    zzex localzzex14 = new zzex("BOARDING_PASS", 13, 13);
    zzrv = localzzex14;
    zzrw = new zzex[] { localzzex1, localzzex2, localzzex3, localzzex4, localzzex5, localzzex6, localzzex7, localzzex8, localzzex9, localzzex10, localzzex11, localzzex12, localzzex13, localzzex14 };
  }
  
  private zzex(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static zzex zzad(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 13: 
      return zzrv;
    case 12: 
      return zzru;
    case 11: 
      return zzrt;
    case 10: 
      return zzrs;
    case 9: 
      return zzrr;
    case 8: 
      return zzrq;
    case 7: 
      return zzrp;
    case 6: 
      return zzro;
    case 5: 
      return zzrn;
    case 4: 
      return zzrm;
    case 3: 
      return zzrl;
    case 2: 
      return zzrk;
    case 1: 
      return zzrj;
    }
    return zzri;
  }
  
  public static zzhd zzai()
  {
    return zzez.zzho;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("<");
    localStringBuilder.append(zzex.class.getName());
    localStringBuilder.append('@');
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" number=");
    localStringBuilder.append(this.value);
    localStringBuilder.append(" name=");
    localStringBuilder.append(name());
    localStringBuilder.append('>');
    return localStringBuilder.toString();
  }
  
  public final int zzah()
  {
    return this.value;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */