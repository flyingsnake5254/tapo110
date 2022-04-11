package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.g0;
import com.google.android.exoplayer2.util.h;
import com.google.android.exoplayer2.util.o0;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableListMultimap.a;
import com.google.common.collect.ImmutableMap;
import java.util.AbstractCollection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class p
  implements g, a0
{
  public static final ImmutableListMultimap<String, Integer> a = ;
  public static final ImmutableList<Long> b;
  public static final ImmutableList<Long> c;
  public static final ImmutableList<Long> d;
  public static final ImmutableList<Long> e;
  public static final ImmutableList<Long> f;
  public static final ImmutableList<Long> g;
  @Nullable
  private static p h;
  private final ImmutableMap<Integer, Long> i;
  private final g.a.a j;
  private final g0 k;
  private final h l;
  private final boolean m;
  private int n;
  private long o;
  private long p;
  private int q;
  private long r;
  private long s;
  private long t;
  private long u;
  private boolean v;
  private int w;
  
  static
  {
    Long localLong1 = Long.valueOf(2300000L);
    Long localLong2 = Long.valueOf(1300000L);
    b = ImmutableList.of(Long.valueOf(6200000L), Long.valueOf(3900000L), localLong1, localLong2, Long.valueOf(620000L));
    c = ImmutableList.of(Long.valueOf(248000L), Long.valueOf(160000L), Long.valueOf(142000L), Long.valueOf(127000L), Long.valueOf(113000L));
    Long localLong3 = Long.valueOf(2200000L);
    d = ImmutableList.of(localLong3, localLong2, Long.valueOf(950000L), Long.valueOf(760000L), Long.valueOf(520000L));
    localLong2 = Long.valueOf(1500000L);
    e = ImmutableList.of(Long.valueOf(4400000L), localLong1, localLong2, Long.valueOf(1100000L), Long.valueOf(640000L));
    f = ImmutableList.of(Long.valueOf(10000000L), Long.valueOf(7200000L), Long.valueOf(5000000L), Long.valueOf(2700000L), Long.valueOf(1600000L));
    g = ImmutableList.of(Long.valueOf(2600000L), localLong3, Long.valueOf(2000000L), localLong2, Long.valueOf(470000L));
  }
  
  private p(@Nullable Context paramContext, Map<Integer, Long> paramMap, int paramInt, h paramh, boolean paramBoolean)
  {
    this.i = ImmutableMap.copyOf(paramMap);
    this.j = new g.a.a();
    this.k = new g0(paramInt);
    this.l = paramh;
    this.m = paramBoolean;
    if (paramContext != null)
    {
      paramContext = com.google.android.exoplayer2.util.a0.c(paramContext);
      paramInt = paramContext.e();
      this.q = paramInt;
      this.t = k(paramInt);
      paramContext.i(new b(this));
    }
    else
    {
      this.q = 0;
      this.t = k(0);
    }
  }
  
  private static ImmutableListMultimap<String, Integer> j()
  {
    ImmutableListMultimap.a locala = ImmutableListMultimap.builder();
    Integer localInteger1 = Integer.valueOf(1);
    Integer localInteger2 = Integer.valueOf(0);
    Integer localInteger3 = Integer.valueOf(2);
    Integer localInteger4 = Integer.valueOf(3);
    Integer localInteger5 = Integer.valueOf(4);
    return locala.m("AD", new Integer[] { localInteger1, localInteger3, localInteger2, localInteger2, localInteger3, localInteger3 }).m("AE", new Integer[] { localInteger1, localInteger5, localInteger5, localInteger5, localInteger3, localInteger3 }).m("AF", new Integer[] { localInteger5, localInteger5, localInteger4, localInteger5, localInteger3, localInteger3 }).m("AG", new Integer[] { localInteger5, localInteger3, localInteger1, localInteger5, localInteger3, localInteger3 }).m("AI", new Integer[] { localInteger1, localInteger3, localInteger3, localInteger3, localInteger3, localInteger3 }).m("AL", new Integer[] { localInteger1, localInteger1, localInteger1, localInteger1, localInteger3, localInteger3 }).m("AM", new Integer[] { localInteger3, localInteger3, localInteger1, localInteger4, localInteger3, localInteger3 }).m("AO", new Integer[] { localInteger4, localInteger5, localInteger4, localInteger1, localInteger3, localInteger3 }).m("AR", new Integer[] { localInteger3, localInteger5, localInteger3, localInteger1, localInteger3, localInteger3 }).m("AS", new Integer[] { localInteger3, localInteger3, localInteger4, localInteger4, localInteger3, localInteger3 }).m("AT", new Integer[] { localInteger2, localInteger1, localInteger2, localInteger2, localInteger2, localInteger3 }).m("AU", new Integer[] { localInteger2, localInteger3, localInteger2, localInteger1, localInteger1, localInteger3 }).m("AW", new Integer[] { localInteger1, localInteger3, localInteger2, localInteger5, localInteger3, localInteger3 }).m("AX", new Integer[] { localInteger2, localInteger3, localInteger3, localInteger3, localInteger3, localInteger3 }).m("AZ", new Integer[] { localInteger4, localInteger4, localInteger4, localInteger5, localInteger5, localInteger3 }).m("BA", new Integer[] { localInteger1, localInteger1, localInteger2, localInteger1, localInteger3, localInteger3 }).m("BB", new Integer[] { localInteger2, localInteger3, localInteger2, localInteger2, localInteger3, localInteger3 }).m("BD", new Integer[] { localInteger3, localInteger2, localInteger4, localInteger4, localInteger3, localInteger3 }).m("BE", new Integer[] { localInteger2, localInteger2, localInteger3, localInteger4, localInteger3, localInteger3 }).m("BF", new Integer[] { localInteger5, localInteger5, localInteger5, localInteger3, localInteger3, localInteger3 }).m("BG", new Integer[] { localInteger2, localInteger1, localInteger2, localInteger2, localInteger3, localInteger3 }).m("BH", new Integer[] { localInteger1, localInteger2, localInteger3, localInteger5, localInteger3, localInteger3 }).m("BI", new Integer[] { localInteger5, localInteger5, localInteger5, localInteger5, localInteger3, localInteger3 }).m("BJ", new Integer[] { localInteger5, localInteger5, localInteger5, localInteger5, localInteger3, localInteger3 }).m("BL", new Integer[] { localInteger1, localInteger3, localInteger3, localInteger3, localInteger3, localInteger3 }).m("BM", new Integer[] { localInteger2, localInteger3, localInteger2, localInteger2, localInteger3, localInteger3 }).m("BN", new Integer[] { localInteger4, localInteger3, localInteger1, localInteger2, localInteger3, localInteger3 }).m("BO", new Integer[] { localInteger1, localInteger3, localInteger5, localInteger3, localInteger3, localInteger3 }).m("BQ", new Integer[] { localInteger1, localInteger3, localInteger1, localInteger3, localInteger3, localInteger3 }).m("BR", new Integer[] { localInteger3, localInteger5, localInteger4, localInteger3, localInteger3, localInteger3 }).m("BS", new Integer[] { localInteger3, localInteger3, localInteger1, localInteger4, localInteger3, localInteger3 }).m("BT", new Integer[] { localInteger4, localInteger2, localInteger4, localInteger3, localInteger3, localInteger3 }).m("BW", new Integer[] { localInteger4, localInteger5, localInteger1, localInteger1, localInteger3, localInteger3 }).m("BY", new Integer[] { localInteger1, localInteger1, localInteger1, localInteger3, localInteger3, localInteger3 }).m("BZ", new Integer[] { localInteger3, localInteger3, localInteger3, localInteger3, localInteger3, localInteger3 }).m("CA", new Integer[] { localInteger2, localInteger4, localInteger1, localInteger3, localInteger5, localInteger3 }).m("CD", new Integer[] { localInteger5, localInteger3, localInteger3, localInteger1, localInteger3, localInteger3 }).m("CF", new Integer[] { localInteger5, localInteger3, localInteger4, localInteger3, localInteger3, localInteger3 }).m("CG", new Integer[] { localInteger4, localInteger5, localInteger3, localInteger3, localInteger3, localInteger3 }).m("CH", new Integer[] { localInteger2, localInteger2, localInteger2, localInteger2, localInteger1, localInteger3 }).m("CI", new Integer[] { localInteger4, localInteger4, localInteger4, localInteger4, localInteger3, localInteger3 }).m("CK", new Integer[] { localInteger3, localInteger3, localInteger4, localInteger2, localInteger3, localInteger3 }).m("CL", new Integer[] { localInteger1, localInteger1, localInteger3, localInteger3, localInteger3, localInteger3 }).m("CM", new Integer[] { localInteger4, localInteger5, localInteger4, localInteger3, localInteger3, localInteger3 }).m("CN", new Integer[] { localInteger3, localInteger3, localInteger3, localInteger1, localInteger4, localInteger3 }).m("CO", new Integer[] { localInteger3, localInteger4, localInteger5, localInteger3, localInteger3, localInteger3 }).m("CR", new Integer[] { localInteger3, localInteger4, localInteger5, localInteger5, localInteger3, localInteger3 }).m("CU", new Integer[] { localInteger5, localInteger5, localInteger3, localInteger3, localInteger3, localInteger3 }).m("CV", new Integer[] { localInteger3, localInteger4, localInteger1, localInteger2, localInteger3, localInteger3 }).m("CW", new Integer[] { localInteger1, localInteger3, localInteger2, localInteger2, localInteger3, localInteger3 }).m("CY", new Integer[] { localInteger1, localInteger1, localInteger2, localInteger2, localInteger3, localInteger3 }).m("CZ", new Integer[] { localInteger2, localInteger1, localInteger2, localInteger2, localInteger1, localInteger3 }).m("DE", new Integer[] { localInteger2, localInteger2, localInteger1, localInteger1, localInteger2, localInteger3 }).m("DJ", new Integer[] { localInteger5, localInteger2, localInteger5, localInteger5, localInteger3, localInteger3 }).m("DK", new Integer[] { localInteger2, localInteger2, localInteger1, localInteger2, localInteger2, localInteger3 }).m("DM", new Integer[] { localInteger1, localInteger3, localInteger3, localInteger3, localInteger3, localInteger3 }).m("DO", new Integer[] { localInteger4, localInteger5, localInteger5, localInteger5, localInteger3, localInteger3 }).m("DZ", new Integer[] { localInteger4, localInteger4, localInteger5, localInteger5, localInteger3, localInteger5 }).m("EC", new Integer[] { localInteger3, localInteger5, localInteger4, localInteger1, localInteger3, localInteger3 }).m("EE", new Integer[] { localInteger2, localInteger1, localInteger2, localInteger2, localInteger3, localInteger3 }).m("EG", new Integer[] { localInteger4, localInteger5, localInteger4, localInteger4, localInteger3, localInteger3 }).m("EH", new Integer[] { localInteger3, localInteger3, localInteger3, localInteger3, localInteger3, localInteger3 }).m("ER", new Integer[] { localInteger5, localInteger3, localInteger3, localInteger3, localInteger3, localInteger3 }).m("ES", new Integer[] { localInteger2, localInteger1, localInteger1, localInteger1, localInteger3, localInteger3 }).m("ET", new Integer[] { localInteger5, localInteger5, localInteger5, localInteger1, localInteger3, localInteger3 }).m("FI", new Integer[] { localInteger2, localInteger2, localInteger2, localInteger2, localInteger2, localInteger3 }).m("FJ", new Integer[] { localInteger4, localInteger2, localInteger3, localInteger4, localInteger3, localInteger3 }).m("FK", new Integer[] { localInteger5, localInteger3, localInteger3, localInteger3, localInteger3, localInteger3 }).m("FM", new Integer[] { localInteger4, localInteger3, localInteger5, localInteger5, localInteger3, localInteger3 }).m("FO", new Integer[] { localInteger1, localInteger3, localInteger2, localInteger1, localInteger3, localInteger3 }).m("FR", new Integer[] { localInteger1, localInteger1, localInteger3, localInteger2, localInteger1, localInteger3 }).m("GA", new Integer[] { localInteger4, localInteger5, localInteger1, localInteger1, localInteger3, localInteger3 }).m("GB", new Integer[] { localInteger2, localInteger2, localInteger1, localInteger1, localInteger1, localInteger3 }).m("GD", new Integer[] { localInteger1, localInteger3, localInteger3, localInteger3, localInteger3, localInteger3 }).m("GE", new Integer[] { localInteger1, localInteger1, localInteger1, localInteger3, localInteger3, localInteger3 }).m("GF", new Integer[] { localInteger3, localInteger3, localInteger3, localInteger4, localInteger3, localInteger3 }).m("GG", new Integer[] { localInteger1, localInteger3, localInteger2, localInteger2, localInteger3, localInteger3 }).m("GH", new Integer[] { localInteger4, localInteger1, localInteger4, localInteger3, localInteger3, localInteger3 }).m("GI", new Integer[] { localInteger2, localInteger3, localInteger2, localInteger2, localInteger3, localInteger3 }).m("GL", new Integer[] { localInteger1, localInteger3, localInteger2, localInteger2, localInteger3, localInteger3 }).m("GM", new Integer[] { localInteger5, localInteger4, localInteger3, localInteger5, localInteger3, localInteger3 }).m("GN", new Integer[] { localInteger5, localInteger4, localInteger5, localInteger3, localInteger3, localInteger3 }).m("GP", new Integer[] { localInteger3, localInteger1, localInteger3, localInteger4, localInteger3, localInteger3 }).m("GQ", new Integer[] { localInteger5, localInteger3, localInteger3, localInteger5, localInteger3, localInteger3 }).m("GR", new Integer[] { localInteger1, localInteger3, localInteger2, localInteger2, localInteger3, localInteger3 }).m("GT", new Integer[] { localInteger4, localInteger3, localInteger4, localInteger1, localInteger3, localInteger3 }).m("GU", new Integer[] { localInteger1, localInteger3, localInteger4, localInteger5, localInteger3, localInteger3 }).m("GW", new Integer[] { localInteger5, localInteger5, localInteger5, localInteger5, localInteger3, localInteger3 }).m("GY", new Integer[] { localInteger4, localInteger4, localInteger4, localInteger5, localInteger3, localInteger3 }).m("HK", new Integer[] { localInteger2, localInteger1, localInteger3, localInteger4, localInteger3, localInteger2 }).m("HN", new Integer[] { localInteger4, localInteger1, localInteger4, localInteger4, localInteger3, localInteger3 }).m("HR", new Integer[] { localInteger1, localInteger1, localInteger2, localInteger2, localInteger4, localInteger3 }).m("HT", new Integer[] { localInteger5, localInteger5, localInteger5, localInteger5, localInteger3, localInteger3 }).m("HU", new Integer[] { localInteger2, localInteger2, localInteger2, localInteger2, localInteger2, localInteger3 }).m("ID", new Integer[] { localInteger4, localInteger3, localInteger4, localInteger4, localInteger3, localInteger3 }).m("IE", new Integer[] { localInteger2, localInteger2, localInteger1, localInteger1, localInteger4, localInteger3 }).m("IL", new Integer[] { localInteger1, localInteger2, localInteger3, localInteger4, localInteger5, localInteger3 }).m("IM", new Integer[] { localInteger2, localInteger3, localInteger2, localInteger1, localInteger3, localInteger3 }).m("IN", new Integer[] { localInteger3, localInteger1, localInteger4, localInteger4, localInteger3, localInteger3 }).m("IO", new Integer[] { localInteger5, localInteger3, localInteger3, localInteger5, localInteger3, localInteger3 }).m("IQ", new Integer[] { localInteger4, localInteger4, localInteger5, localInteger5, localInteger3, localInteger3 }).m("IR", new Integer[] { localInteger4, localInteger3, localInteger4, localInteger3, localInteger3, localInteger3 }).m("IS", new Integer[] { localInteger2, localInteger3, localInteger2, localInteger2, localInteger3, localInteger3 }).m("IT", new Integer[] { localInteger2, localInteger5, localInteger2, localInteger1, localInteger3, localInteger3 }).m("JE", new Integer[] { localInteger3, localInteger3, localInteger1, localInteger3, localInteger3, localInteger3 }).m("JM", new Integer[] { localInteger4, localInteger4, localInteger5, localInteger5, localInteger3, localInteger3 }).m("JO", new Integer[] { localInteger3, localInteger3, localInteger1, localInteger1, localInteger3, localInteger3 }).m("JP", new Integer[] { localInteger2, localInteger2, localInteger2, localInteger2, localInteger3, localInteger1 }).m("KE", new Integer[] { localInteger4, localInteger5, localInteger3, localInteger3, localInteger3, localInteger3 }).m("KG", new Integer[] { localInteger3, localInteger2, localInteger1, localInteger1, localInteger3, localInteger3 }).m("KH", new Integer[] { localInteger1, localInteger2, localInteger5, localInteger4, localInteger3, localInteger3 }).m("KI", new Integer[] { localInteger5, localInteger3, localInteger5, localInteger4, localInteger3, localInteger3 }).m("KM", new Integer[] { localInteger5, localInteger4, localInteger3, localInteger4, localInteger3, localInteger3 }).m("KN", new Integer[] { localInteger1, localInteger3, localInteger3, localInteger3, localInteger3, localInteger3 }).m("KP", new Integer[] { localInteger5, localInteger3, localInteger3, localInteger3, localInteger3, localInteger3 }).m("KR", new Integer[] { localInteger2, localInteger2, localInteger1, localInteger4, localInteger1, localInteger3 }).m("KW", new Integer[] { localInteger1, localInteger4, localInteger1, localInteger1, localInteger1, localInteger3 }).m("KY", new Integer[] { localInteger1, localInteger3, localInteger2, localInteger3, localInteger3, localInteger3 }).m("KZ", new Integer[] { localInteger3, localInteger3, localInteger3, localInteger4, localInteger3, localInteger3 }).m("LA", new Integer[] { localInteger1, localInteger3, localInteger1, localInteger1, localInteger3, localInteger3 }).m("LB", new Integer[] { localInteger4, localInteger3, localInteger2, localInteger2, localInteger3, localInteger3 }).m("LC", new Integer[] { localInteger1, localInteger3, localInteger2, localInteger2, localInteger3, localInteger3 }).m("LI", new Integer[] { localInteger2, localInteger3, localInteger3, localInteger3, localInteger3, localInteger3 }).m("LK", new Integer[] { localInteger3, localInteger2, localInteger3, localInteger4, localInteger3, localInteger3 }).m("LR", new Integer[] { localInteger4, localInteger5, localInteger5, localInteger4, localInteger3, localInteger3 }).m("LS", new Integer[] { localInteger4, localInteger4, localInteger3, localInteger4, localInteger3, localInteger3 }).m("LT", new Integer[] { localInteger2, localInteger2, localInteger2, localInteger2, localInteger3, localInteger3 }).m("LU", new Integer[] { localInteger1, localInteger2, localInteger1, localInteger1, localInteger3, localInteger3 }).m("LV", new Integer[] { localInteger2, localInteger2, localInteger2, localInteger2, localInteger3, localInteger3 }).m("LY", new Integer[] { localInteger5, localInteger3, localInteger5, localInteger4, localInteger3, localInteger3 }).m("MA", new Integer[] { localInteger4, localInteger3, localInteger3, localInteger1, localInteger3, localInteger3 }).m("MC", new Integer[] { localInteger2, localInteger3, localInteger2, localInteger2, localInteger3, localInteger3 }).m("MD", new Integer[] { localInteger1, localInteger3, localInteger2, localInteger2, localInteger3, localInteger3 }).m("ME", new Integer[] { localInteger1, localInteger3, localInteger2, localInteger1, localInteger3, localInteger3 }).m("MF", new Integer[] { localInteger3, localInteger3, localInteger1, localInteger1, localInteger3, localInteger3 }).m("MG", new Integer[] { localInteger4, localInteger5, localInteger3, localInteger3, localInteger3, localInteger3 }).m("MH", new Integer[] { localInteger5, localInteger3, localInteger3, localInteger5, localInteger3, localInteger3 }).m("MK", new Integer[] { localInteger1, localInteger1, localInteger2, localInteger2, localInteger3, localInteger3 }).m("ML", new Integer[] { localInteger5, localInteger5, localInteger3, localInteger3, localInteger3, localInteger3 }).m("MM", new Integer[] { localInteger3, localInteger4, localInteger4, localInteger4, localInteger3, localInteger3 }).m("MN", new Integer[] { localInteger3, localInteger5, localInteger3, localInteger3, localInteger3, localInteger3 }).m("MO", new Integer[] { localInteger2, localInteger3, localInteger5, localInteger5, localInteger3, localInteger3 }).m("MP", new Integer[] { localInteger2, localInteger3, localInteger3, localInteger3, localInteger3, localInteger3 }).m("MQ", new Integer[] { localInteger3, localInteger3, localInteger3, localInteger4, localInteger3, localInteger3 }).m("MR", new Integer[] { localInteger4, localInteger2, localInteger5, localInteger4, localInteger3, localInteger3 }).m("MS", new Integer[] { localInteger1, localInteger3, localInteger3, localInteger3, localInteger3, localInteger3 }).m("MT", new Integer[] { localInteger2, localInteger3, localInteger2, localInteger2, localInteger3, localInteger3 }).m("MU", new Integer[] { localInteger3, localInteger1, localInteger1, localInteger3, localInteger3, localInteger3 }).m("MV", new Integer[] { localInteger5, localInteger4, localInteger3, localInteger5, localInteger3, localInteger3 }).m("MW", new Integer[] { localInteger5, localInteger3, localInteger1, localInteger2, localInteger3, localInteger3 }).m("MX", new Integer[] { localInteger3, localInteger5, localInteger5, localInteger5, localInteger5, localInteger3 }).m("MY", new Integer[] { localInteger1, localInteger2, localInteger4, localInteger3, localInteger3, localInteger3 }).m("MZ", new Integer[] { localInteger4, localInteger4, localInteger3, localInteger1, localInteger3, localInteger3 }).m("NA", new Integer[] { localInteger5, localInteger4, localInteger4, localInteger3, localInteger3, localInteger3 }).m("NC", new Integer[] { localInteger4, localInteger2, localInteger5, localInteger5, localInteger3, localInteger3 }).m("NE", new Integer[] { localInteger5, localInteger5, localInteger5, localInteger5, localInteger3, localInteger3 }).m("NF", new Integer[] { localInteger3, localInteger3, localInteger3, localInteger3, localInteger3, localInteger3 }).m("NG", new Integer[] { localInteger4, localInteger4, localInteger3, localInteger4, localInteger3, localInteger3 }).m("NI", new Integer[] { localInteger3, localInteger1, localInteger5, localInteger5, localInteger3, localInteger3 }).m("NL", new Integer[] { localInteger2, localInteger3, localInteger4, localInteger3, localInteger2, localInteger3 }).m("NO", new Integer[] { localInteger2, localInteger1, localInteger3, localInteger2, localInteger2, localInteger3 }).m("NP", new Integer[] { localInteger3, localInteger2, localInteger5, localInteger3, localInteger3, localInteger3 }).m("NR", new Integer[] { localInteger4, localInteger3, localInteger4, localInteger1, localInteger3, localInteger3 }).m("NU", new Integer[] { localInteger5, localInteger3, localInteger3, localInteger3, localInteger3, localInteger3 }).m("NZ", new Integer[] { localInteger2, localInteger3, localInteger1, localInteger3, localInteger5, localInteger3 }).m("OM", new Integer[] { localInteger3, localInteger3, localInteger1, localInteger4, localInteger4, localInteger3 }).m("PA", new Integer[] { localInteger1, localInteger4, localInteger4, localInteger4, localInteger3, localInteger3 }).m("PE", new Integer[] { localInteger3, localInteger4, localInteger5, localInteger5, localInteger3, localInteger3 }).m("PF", new Integer[] { localInteger3, localInteger3, localInteger3, localInteger1, localInteger3, localInteger3 }).m("PG", new Integer[] { localInteger5, localInteger5, localInteger4, localInteger3, localInteger3, localInteger3 }).m("PH", new Integer[] { localInteger3, localInteger1, localInteger4, localInteger4, localInteger4, localInteger3 }).m("PK", new Integer[] { localInteger4, localInteger3, localInteger4, localInteger4, localInteger3, localInteger3 }).m("PL", new Integer[] { localInteger1, localInteger2, localInteger1, localInteger3, localInteger4, localInteger3 }).m("PM", new Integer[] { localInteger2, localInteger3, localInteger3, localInteger3, localInteger3, localInteger3 }).m("PR", new Integer[] { localInteger3, localInteger1, localInteger3, localInteger3, localInteger5, localInteger4 }).m("PS", new Integer[] { localInteger4, localInteger4, localInteger3, localInteger3, localInteger3, localInteger3 }).m("PT", new Integer[] { localInteger2, localInteger1, localInteger1, localInteger2, localInteger3, localInteger3 }).m("PW", new Integer[] { localInteger1, localInteger3, localInteger5, localInteger1, localInteger3, localInteger3 }).m("PY", new Integer[] { localInteger3, localInteger2, localInteger4, localInteger3, localInteger3, localInteger3 }).m("QA", new Integer[] { localInteger3, localInteger4, localInteger1, localInteger3, localInteger4, localInteger3 }).m("RE", new Integer[] { localInteger1, localInteger2, localInteger3, localInteger3, localInteger3, localInteger3 }).m("RO", new Integer[] { localInteger2, localInteger1, localInteger2, localInteger1, localInteger2, localInteger3 }).m("RS", new Integer[] { localInteger1, localInteger3, localInteger2, localInteger2, localInteger3, localInteger3 }).m("RU", new Integer[] { localInteger2, localInteger1, localInteger2, localInteger1, localInteger5, localInteger3 }).m("RW", new Integer[] { localInteger4, localInteger4, localInteger4, localInteger1, localInteger3, localInteger3 }).m("SA", new Integer[] { localInteger3, localInteger3, localInteger3, localInteger1, localInteger1, localInteger3 }).m("SB", new Integer[] { localInteger5, localInteger3, localInteger4, localInteger3, localInteger3, localInteger3 }).m("SC", new Integer[] { localInteger5, localInteger3, localInteger1, localInteger4, localInteger3, localInteger3 }).m("SD", new Integer[] { localInteger5, localInteger5, localInteger5, localInteger5, localInteger3, localInteger3 }).m("SE", new Integer[] { localInteger2, localInteger2, localInteger2, localInteger2, localInteger2, localInteger3 }).m("SG", new Integer[] { localInteger1, localInteger2, localInteger1, localInteger3, localInteger4, localInteger3 }).m("SH", new Integer[] { localInteger5, localInteger3, localInteger3, localInteger3, localInteger3, localInteger3 }).m("SI", new Integer[] { localInteger2, localInteger2, localInteger2, localInteger2, localInteger3, localInteger3 }).m("SJ", new Integer[] { localInteger3, localInteger3, localInteger3, localInteger3, localInteger3, localInteger3 }).m("SK", new Integer[] { localInteger2, localInteger1, localInteger2, localInteger2, localInteger3, localInteger3 }).m("SL", new Integer[] { localInteger5, localInteger4, localInteger5, localInteger2, localInteger3, localInteger3 }).m("SM", new Integer[] { localInteger2, localInteger3, localInteger3, localInteger3, localInteger3, localInteger3 }).m("SN", new Integer[] { localInteger5, localInteger5, localInteger5, localInteger5, localInteger3, localInteger3 }).m("SO", new Integer[] { localInteger4, localInteger4, localInteger4, localInteger5, localInteger3, localInteger3 }).m("SR", new Integer[] { localInteger4, localInteger3, localInteger3, localInteger3, localInteger3, localInteger3 }).m("SS", new Integer[] { localInteger5, localInteger5, localInteger4, localInteger4, localInteger3, localInteger3 }).m("ST", new Integer[] { localInteger3, localInteger3, localInteger1, localInteger3, localInteger3, localInteger3 }).m("SV", new Integer[] { localInteger3, localInteger1, localInteger5, localInteger4, localInteger3, localInteger3 }).m("SX", new Integer[] { localInteger3, localInteger3, localInteger1, localInteger2, localInteger3, localInteger3 }).m("SY", new Integer[] { localInteger5, localInteger4, localInteger4, localInteger3, localInteger3, localInteger3 }).m("SZ", new Integer[] { localInteger4, localInteger4, localInteger3, localInteger5, localInteger3, localInteger3 }).m("TC", new Integer[] { localInteger3, localInteger3, localInteger3, localInteger2, localInteger3, localInteger3 }).m("TD", new Integer[] { localInteger5, localInteger4, localInteger5, localInteger5, localInteger3, localInteger3 }).m("TG", new Integer[] { localInteger4, localInteger3, localInteger3, localInteger5, localInteger3, localInteger3 }).m("TH", new Integer[] { localInteger2, localInteger4, localInteger3, localInteger4, localInteger3, localInteger3 }).m("TJ", new Integer[] { localInteger5, localInteger5, localInteger5, localInteger5, localInteger3, localInteger3 }).m("TL", new Integer[] { localInteger5, localInteger2, localInteger5, localInteger5, localInteger3, localInteger3 }).m("TM", new Integer[] { localInteger5, localInteger3, localInteger5, localInteger4, localInteger3, localInteger3 }).m("TN", new Integer[] { localInteger3, localInteger1, localInteger1, localInteger3, localInteger3, localInteger3 }).m("TO", new Integer[] { localInteger4, localInteger4, localInteger5, localInteger4, localInteger3, localInteger3 }).m("TR", new Integer[] { localInteger1, localInteger3, localInteger1, localInteger1, localInteger3, localInteger3 }).m("TT", new Integer[] { localInteger1, localInteger5, localInteger2, localInteger1, localInteger3, localInteger3 }).m("TV", new Integer[] { localInteger4, localInteger3, localInteger3, localInteger5, localInteger3, localInteger3 }).m("TW", new Integer[] { localInteger2, localInteger2, localInteger2, localInteger2, localInteger1, localInteger2 }).m("TZ", new Integer[] { localInteger4, localInteger4, localInteger4, localInteger3, localInteger3, localInteger3 }).m("UA", new Integer[] { localInteger2, localInteger4, localInteger1, localInteger1, localInteger3, localInteger3 }).m("UG", new Integer[] { localInteger4, localInteger3, localInteger4, localInteger4, localInteger3, localInteger3 }).m("US", new Integer[] { localInteger1, localInteger1, localInteger3, localInteger3, localInteger5, localInteger3 }).m("UY", new Integer[] { localInteger3, localInteger3, localInteger1, localInteger1, localInteger3, localInteger3 }).m("UZ", new Integer[] { localInteger3, localInteger1, localInteger4, localInteger5, localInteger3, localInteger3 }).m("VC", new Integer[] { localInteger1, localInteger3, localInteger3, localInteger3, localInteger3, localInteger3 }).m("VE", new Integer[] { localInteger5, localInteger5, localInteger5, localInteger5, localInteger3, localInteger3 }).m("VG", new Integer[] { localInteger3, localInteger3, localInteger1, localInteger1, localInteger3, localInteger3 }).m("VI", new Integer[] { localInteger1, localInteger3, localInteger1, localInteger3, localInteger3, localInteger3 }).m("VN", new Integer[] { localInteger2, localInteger1, localInteger4, localInteger5, localInteger3, localInteger3 }).m("VU", new Integer[] { localInteger5, localInteger2, localInteger4, localInteger1, localInteger3, localInteger3 }).m("WF", new Integer[] { localInteger5, localInteger3, localInteger3, localInteger5, localInteger3, localInteger3 }).m("WS", new Integer[] { localInteger4, localInteger1, localInteger4, localInteger1, localInteger3, localInteger3 }).m("XK", new Integer[] { localInteger2, localInteger1, localInteger1, localInteger2, localInteger3, localInteger3 }).m("YE", new Integer[] { localInteger5, localInteger5, localInteger5, localInteger4, localInteger3, localInteger3 }).m("YT", new Integer[] { localInteger5, localInteger3, localInteger3, localInteger4, localInteger3, localInteger3 }).m("ZA", new Integer[] { localInteger4, localInteger4, localInteger3, localInteger1, localInteger3, localInteger3 }).m("ZM", new Integer[] { localInteger4, localInteger3, localInteger4, localInteger4, localInteger3, localInteger3 }).m("ZW", new Integer[] { localInteger4, localInteger3, localInteger5, localInteger4, localInteger3, localInteger3 }).h();
  }
  
  private long k(int paramInt)
  {
    Object localObject1 = (Long)this.i.get(Integer.valueOf(paramInt));
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = (Long)this.i.get(Integer.valueOf(0));
    }
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = Long.valueOf(1000000L);
    }
    return ((Long)localObject1).longValue();
  }
  
  public static p l(Context paramContext)
  {
    try
    {
      if (h == null)
      {
        b localb = new com/google/android/exoplayer2/upstream/p$b;
        localb.<init>(paramContext);
        h = localb.a();
      }
      paramContext = h;
      return paramContext;
    }
    finally {}
  }
  
  private static boolean m(n paramn, boolean paramBoolean)
  {
    if ((paramBoolean) && (!paramn.d(8))) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    return paramBoolean;
  }
  
  private void o(int paramInt, long paramLong1, long paramLong2)
  {
    if ((paramInt == 0) && (paramLong1 == 0L) && (paramLong2 == this.u)) {
      return;
    }
    this.u = paramLong2;
    this.j.b(paramInt, paramLong1, paramLong2);
  }
  
  private void p(int paramInt)
  {
    try
    {
      int i1 = this.q;
      if (i1 != 0)
      {
        boolean bool = this.m;
        if (!bool) {
          return;
        }
      }
      if (this.v) {
        paramInt = this.w;
      }
      if (i1 == paramInt) {
        return;
      }
      this.q = paramInt;
      if ((paramInt != 1) && (paramInt != 0) && (paramInt != 8))
      {
        this.t = k(paramInt);
        long l1 = this.l.elapsedRealtime();
        if (this.n > 0) {
          paramInt = (int)(l1 - this.o);
        } else {
          paramInt = 0;
        }
        o(paramInt, this.p, this.t);
        this.o = l1;
        this.p = 0L;
        this.s = 0L;
        this.r = 0L;
        this.k.g();
        return;
      }
      return;
    }
    finally {}
  }
  
  public void b(l paraml, n paramn, boolean paramBoolean)
  {
    try
    {
      paramBoolean = m(paramn, paramBoolean);
      if (!paramBoolean) {
        return;
      }
      if (this.n > 0) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      com.google.android.exoplayer2.util.g.g(paramBoolean);
      long l1 = this.l.elapsedRealtime();
      int i1 = (int)(l1 - this.o);
      this.r += i1;
      long l2 = this.s;
      long l3 = this.p;
      this.s = (l2 + l3);
      if (i1 > 0)
      {
        float f1 = (float)l3 * 8000.0F / i1;
        this.k.a((int)Math.sqrt(l3), f1);
        if ((this.r >= 2000L) || (this.s >= 524288L)) {
          this.t = (this.k.d(0.5F));
        }
        o(i1, this.p, this.t);
        this.o = l1;
        this.p = 0L;
      }
      this.n -= 1;
      return;
    }
    finally {}
  }
  
  public a0 c()
  {
    return this;
  }
  
  public void d(g.a parama)
  {
    this.j.d(parama);
  }
  
  public long e()
  {
    try
    {
      long l1 = this.t;
      return l1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void f(l paraml, n paramn, boolean paramBoolean, int paramInt)
  {
    try
    {
      paramBoolean = m(paramn, paramBoolean);
      if (!paramBoolean) {
        return;
      }
      this.p += paramInt;
      return;
    }
    finally {}
  }
  
  public void g(Handler paramHandler, g.a parama)
  {
    com.google.android.exoplayer2.util.g.e(paramHandler);
    com.google.android.exoplayer2.util.g.e(parama);
    this.j.a(paramHandler, parama);
  }
  
  public void h(l paraml, n paramn, boolean paramBoolean)
  {
    try
    {
      paramBoolean = m(paramn, paramBoolean);
      if (!paramBoolean) {
        return;
      }
      if (this.n == 0) {
        this.o = this.l.elapsedRealtime();
      }
      this.n += 1;
      return;
    }
    finally {}
  }
  
  public void i(l paraml, n paramn, boolean paramBoolean) {}
  
  public static final class b
  {
    @Nullable
    private final Context a;
    private Map<Integer, Long> b;
    private int c;
    private h d;
    private boolean e;
    
    public b(Context paramContext)
    {
      Context localContext;
      if (paramContext == null) {
        localContext = null;
      } else {
        localContext = paramContext.getApplicationContext();
      }
      this.a = localContext;
      this.b = c(o0.I(paramContext));
      this.c = 2000;
      this.d = h.a;
      this.e = true;
    }
    
    private static ImmutableList<Integer> b(String paramString)
    {
      ImmutableList localImmutableList = p.a.get(paramString);
      paramString = localImmutableList;
      if (localImmutableList.isEmpty()) {
        paramString = ImmutableList.of(Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(2));
      }
      return paramString;
    }
    
    private static Map<Integer, Long> c(String paramString)
    {
      ImmutableList localImmutableList1 = b(paramString);
      paramString = new HashMap(8);
      paramString.put(Integer.valueOf(0), Long.valueOf(1000000L));
      ImmutableList localImmutableList2 = p.b;
      paramString.put(Integer.valueOf(2), (Long)localImmutableList2.get(((Integer)localImmutableList1.get(0)).intValue()));
      paramString.put(Integer.valueOf(3), (Long)p.c.get(((Integer)localImmutableList1.get(1)).intValue()));
      paramString.put(Integer.valueOf(4), (Long)p.d.get(((Integer)localImmutableList1.get(2)).intValue()));
      paramString.put(Integer.valueOf(5), (Long)p.e.get(((Integer)localImmutableList1.get(3)).intValue()));
      paramString.put(Integer.valueOf(10), (Long)p.f.get(((Integer)localImmutableList1.get(4)).intValue()));
      paramString.put(Integer.valueOf(9), (Long)p.g.get(((Integer)localImmutableList1.get(5)).intValue()));
      paramString.put(Integer.valueOf(7), (Long)localImmutableList2.get(((Integer)localImmutableList1.get(0)).intValue()));
      return paramString;
    }
    
    public p a()
    {
      return new p(this.a, this.b, this.c, this.d, this.e, null);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\upstream\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */