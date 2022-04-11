package com.google.android.gms.internal.vision;

public enum zzet
  implements zzhb
{
  private static final zzha<zzet> zzhl = new zzev();
  private final int value;
  
  static
  {
    zzet localzzet1 = new zzet("UNRECOGNIZED", 0, 0);
    zzqr = localzzet1;
    zzet localzzet2 = new zzet("CODE_128", 1, 1);
    zzqs = localzzet2;
    zzet localzzet3 = new zzet("CODE_39", 2, 2);
    zzqt = localzzet3;
    zzet localzzet4 = new zzet("CODE_93", 3, 3);
    zzqu = localzzet4;
    zzet localzzet5 = new zzet("CODABAR", 4, 4);
    zzqv = localzzet5;
    zzet localzzet6 = new zzet("DATA_MATRIX", 5, 5);
    zzqw = localzzet6;
    zzet localzzet7 = new zzet("EAN_13", 6, 6);
    zzqx = localzzet7;
    zzet localzzet8 = new zzet("EAN_8", 7, 7);
    zzqy = localzzet8;
    zzet localzzet9 = new zzet("ITF", 8, 8);
    zzqz = localzzet9;
    zzet localzzet10 = new zzet("QR_CODE", 9, 9);
    zzra = localzzet10;
    zzet localzzet11 = new zzet("UPC_A", 10, 10);
    zzrb = localzzet11;
    zzet localzzet12 = new zzet("UPC_E", 11, 11);
    zzrc = localzzet12;
    zzet localzzet13 = new zzet("PDF417", 12, 12);
    zzrd = localzzet13;
    zzet localzzet14 = new zzet("AZTEC", 13, 13);
    zzre = localzzet14;
    zzet localzzet15 = new zzet("DATABAR", 14, 14);
    zzrf = localzzet15;
    zzet localzzet16 = new zzet("TEZ_CODE", 15, 16);
    zzrg = localzzet16;
    zzrh = new zzet[] { localzzet1, localzzet2, localzzet3, localzzet4, localzzet5, localzzet6, localzzet7, localzzet8, localzzet9, localzzet10, localzzet11, localzzet12, localzzet13, localzzet14, localzzet15, localzzet16 };
  }
  
  private zzet(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static zzet zzac(int paramInt)
  {
    switch (paramInt)
    {
    case 15: 
    default: 
      return null;
    case 16: 
      return zzrg;
    case 14: 
      return zzrf;
    case 13: 
      return zzre;
    case 12: 
      return zzrd;
    case 11: 
      return zzrc;
    case 10: 
      return zzrb;
    case 9: 
      return zzra;
    case 8: 
      return zzqz;
    case 7: 
      return zzqy;
    case 6: 
      return zzqx;
    case 5: 
      return zzqw;
    case 4: 
      return zzqv;
    case 3: 
      return zzqu;
    case 2: 
      return zzqt;
    case 1: 
      return zzqs;
    }
    return zzqr;
  }
  
  public static zzhd zzai()
  {
    return zzeu.zzho;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("<");
    localStringBuilder.append(zzet.class.getName());
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */