package com.google.android.gms.internal.clearcut;

final class zzbm
  extends zzbk
{
  private final byte[] buffer;
  private int limit;
  private int pos;
  private final boolean zzfu;
  private int zzfv;
  private int zzfw;
  private int zzfx = Integer.MAX_VALUE;
  
  private zzbm(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(null);
    this.buffer = paramArrayOfByte;
    this.limit = (paramInt2 + paramInt1);
    this.pos = paramInt1;
    this.zzfw = paramInt1;
    this.zzfu = paramBoolean;
  }
  
  public final int zzaf()
  {
    return this.pos - this.zzfw;
  }
  
  public final int zzl(int paramInt)
    throws zzco
  {
    if (paramInt >= 0)
    {
      int i = paramInt + zzaf();
      int j = this.zzfx;
      if (i <= j)
      {
        this.zzfx = i;
        paramInt = this.limit + this.zzfv;
        this.limit = paramInt;
        int k = paramInt - this.zzfw;
        if (k > i)
        {
          i = k - i;
          this.zzfv = i;
          this.limit = (paramInt - i);
        }
        else
        {
          this.zzfv = 0;
        }
        return j;
      }
      throw zzco.zzbl();
    }
    throw new zzco("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzbm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */