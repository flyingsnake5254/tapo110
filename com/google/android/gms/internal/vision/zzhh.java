package com.google.android.gms.internal.vision;

import java.io.IOException;

public class zzhh
  extends IOException
{
  private zzih zzxw = null;
  
  public zzhh(String paramString)
  {
    super(paramString);
  }
  
  static zzhh zzgn()
  {
    return new zzhh("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
  }
  
  static zzhh zzgo()
  {
    return new zzhh("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
  }
  
  static zzhh zzgp()
  {
    return new zzhh("CodedInputStream encountered a malformed varint.");
  }
  
  static zzhh zzgq()
  {
    return new zzhh("Protocol message contained an invalid tag (zero).");
  }
  
  static zzhh zzgr()
  {
    return new zzhh("Protocol message end-group tag did not match expected tag.");
  }
  
  static zzhg zzgs()
  {
    return new zzhg("Protocol message tag had invalid wire type.");
  }
  
  static zzhh zzgt()
  {
    return new zzhh("Failed to parse the message.");
  }
  
  static zzhh zzgu()
  {
    return new zzhh("Protocol message had invalid UTF-8.");
  }
  
  public final zzhh zzg(zzih paramzzih)
  {
    this.zzxw = paramzzih;
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzhh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */