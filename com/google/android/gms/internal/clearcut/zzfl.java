package com.google.android.gms.internal.clearcut;

public enum zzfl
{
  private final zzfq zzqu;
  private final int zzqv;
  
  static
  {
    zzfl localzzfl1 = new zzfl("DOUBLE", 0, zzfq.zzra, 1);
    zzqc = localzzfl1;
    zzfl localzzfl2 = new zzfl("FLOAT", 1, zzfq.zzqz, 5);
    zzqd = localzzfl2;
    Object localObject1 = zzfq.zzqy;
    zzfl localzzfl3 = new zzfl("INT64", 2, (zzfq)localObject1, 0);
    zzqe = localzzfl3;
    zzfl localzzfl4 = new zzfl("UINT64", 3, (zzfq)localObject1, 0);
    zzqf = localzzfl4;
    Object localObject2 = zzfq.zzqx;
    zzfl localzzfl5 = new zzfl("INT32", 4, (zzfq)localObject2, 0);
    zzqg = localzzfl5;
    zzfl localzzfl6 = new zzfl("FIXED64", 5, (zzfq)localObject1, 1);
    zzqh = localzzfl6;
    zzfl localzzfl7 = new zzfl("FIXED32", 6, (zzfq)localObject2, 5);
    zzqi = localzzfl7;
    zzfl localzzfl8 = new zzfl("BOOL", 7, zzfq.zzrb, 0);
    zzqj = localzzfl8;
    zzfm localzzfm = new zzfm("STRING", 8, zzfq.zzrc, 2);
    zzqk = localzzfm;
    Object localObject3 = zzfq.zzrf;
    zzfn localzzfn = new zzfn("GROUP", 9, (zzfq)localObject3, 3);
    zzql = localzzfn;
    zzfo localzzfo = new zzfo("MESSAGE", 10, (zzfq)localObject3, 2);
    zzqm = localzzfo;
    zzfp localzzfp = new zzfp("BYTES", 11, zzfq.zzrd, 2);
    zzqn = localzzfp;
    zzfl localzzfl9 = new zzfl("UINT32", 12, (zzfq)localObject2, 0);
    zzqo = localzzfl9;
    localObject3 = new zzfl("ENUM", 13, zzfq.zzre, 0);
    zzqp = (zzfl)localObject3;
    zzfl localzzfl10 = new zzfl("SFIXED32", 14, (zzfq)localObject2, 5);
    zzqq = localzzfl10;
    zzfl localzzfl11 = new zzfl("SFIXED64", 15, (zzfq)localObject1, 1);
    zzqr = localzzfl11;
    localObject2 = new zzfl("SINT32", 16, (zzfq)localObject2, 0);
    zzqs = (zzfl)localObject2;
    localObject1 = new zzfl("SINT64", 17, (zzfq)localObject1, 0);
    zzqt = (zzfl)localObject1;
    zzqw = new zzfl[] { localzzfl1, localzzfl2, localzzfl3, localzzfl4, localzzfl5, localzzfl6, localzzfl7, localzzfl8, localzzfm, localzzfn, localzzfo, localzzfp, localzzfl9, localObject3, localzzfl10, localzzfl11, localObject2, localObject1 };
  }
  
  private zzfl(zzfq paramzzfq, int paramInt)
  {
    this.zzqu = paramzzfq;
    this.zzqv = paramInt;
  }
  
  public final zzfq zzek()
  {
    return this.zzqu;
  }
  
  public final int zzel()
  {
    return this.zzqv;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzfl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */