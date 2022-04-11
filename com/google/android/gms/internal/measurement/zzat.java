package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class zzat
  implements Iterable<zzap>, zzap
{
  private final String zza;
  
  public zzat(String paramString)
  {
    if (paramString != null)
    {
      this.zza = paramString;
      return;
    }
    throw new IllegalArgumentException("StringValue cannot be null.");
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zzat)) {
      return false;
    }
    paramObject = (zzat)paramObject;
    return this.zza.equals(((zzat)paramObject).zza);
  }
  
  public final int hashCode()
  {
    return this.zza.hashCode();
  }
  
  public final Iterator<zzap> iterator()
  {
    return new zzas(this);
  }
  
  public final String toString()
  {
    String str = this.zza;
    StringBuilder localStringBuilder = new StringBuilder(str.length() + 2);
    localStringBuilder.append('"');
    localStringBuilder.append(str);
    localStringBuilder.append('"');
    return localStringBuilder.toString();
  }
  
  public final zzap zzbK(String paramString, zzg paramzzg, List<zzap> paramList)
  {
    if ((!"charAt".equals(paramString)) && (!"concat".equals(paramString)) && (!"hasOwnProperty".equals(paramString)) && (!"indexOf".equals(paramString)) && (!"lastIndexOf".equals(paramString)) && (!"match".equals(paramString)) && (!"replace".equals(paramString)) && (!"search".equals(paramString)) && (!"slice".equals(paramString)) && (!"split".equals(paramString)) && (!"substring".equals(paramString)) && (!"toLowerCase".equals(paramString)) && (!"toLocaleLowerCase".equals(paramString)) && (!"toString".equals(paramString)) && (!"toUpperCase".equals(paramString)) && (!"toLocaleUpperCase".equals(paramString)) && (!"trim".equals(paramString))) {
      throw new IllegalArgumentException(String.format("%s is not a String function", new Object[] { paramString }));
    }
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      break;
      if (paramString.equals("indexOf"))
      {
        i = 3;
        if (paramString.equals("replace"))
        {
          i = 6;
          if (paramString.equals("substring"))
          {
            i = 10;
            if (paramString.equals("split"))
            {
              i = 9;
              if (paramString.equals("slice"))
              {
                i = 8;
                if (paramString.equals("match"))
                {
                  i = 5;
                  if (paramString.equals("trim"))
                  {
                    i = 16;
                    if (paramString.equals("toUpperCase"))
                    {
                      i = 15;
                      if (paramString.equals("lastIndexOf"))
                      {
                        i = 4;
                        if (paramString.equals("toLocaleUpperCase"))
                        {
                          i = 11;
                          if (paramString.equals("search"))
                          {
                            i = 7;
                            if (paramString.equals("toLowerCase"))
                            {
                              i = 13;
                              if (paramString.equals("concat"))
                              {
                                i = 1;
                                break label600;
                                if (paramString.equals("charAt"))
                                {
                                  i = 0;
                                  break label600;
                                  if (paramString.equals("toLocaleLowerCase"))
                                  {
                                    i = 12;
                                    if (paramString.equals("toString"))
                                    {
                                      i = 14;
                                      break label600;
                                      if (paramString.equals("hasOwnProperty"))
                                      {
                                        i = 2;
                                        break label600;
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    int i = -1;
    label600:
    Object localObject1 = "";
    paramString = "undefined";
    int m;
    Object localObject2;
    double d;
    int k;
    switch (i)
    {
    default: 
      throw new IllegalArgumentException("Command not supported");
    case 16: 
      zzh.zza("toUpperCase", 0, paramList);
      paramString = new zzat(this.zza.trim());
      break;
    case 15: 
      zzh.zza("toUpperCase", 0, paramList);
      paramString = new zzat(this.zza.toUpperCase(Locale.ENGLISH));
      break;
    case 14: 
      zzh.zza("toString", 0, paramList);
      break;
    case 13: 
      zzh.zza("toLowerCase", 0, paramList);
      paramString = new zzat(this.zza.toLowerCase(Locale.ENGLISH));
      break;
    case 12: 
      zzh.zza("toLocaleLowerCase", 0, paramList);
      paramString = new zzat(this.zza.toLowerCase());
      break;
    case 11: 
      zzh.zza("toLocaleUpperCase", 0, paramList);
      paramString = new zzat(this.zza.toUpperCase());
      break;
    case 10: 
      zzh.zzc("substring", 2, paramList);
      paramString = this.zza;
      if (paramList.size() > 0) {
        i = (int)zzh.zzi(paramzzg.zza((zzap)paramList.get(0)).zzd().doubleValue());
      } else {
        i = 0;
      }
      if (paramList.size() > 1) {
        m = (int)zzh.zzi(paramzzg.zza((zzap)paramList.get(1)).zzd().doubleValue());
      } else {
        m = paramString.length();
      }
      i = Math.min(Math.max(i, 0), paramString.length());
      m = Math.min(Math.max(m, 0), paramString.length());
    case 9: 
    case 8: 
      for (paramString = new zzat(paramString.substring(Math.min(i, m), Math.max(i, m)));; paramString = new zzat(paramString.substring(k, Math.max(0, (int)d - k) + k)))
      {
        break;
        zzh.zzc("split", 2, paramList);
        localObject2 = this.zza;
        if (((String)localObject2).length() == 0)
        {
          paramString = new zzae(Arrays.asList(new zzap[] { this }));
          break;
        }
        localObject1 = new ArrayList();
        if (paramList.size() == 0)
        {
          ((List)localObject1).add(this);
        }
        else
        {
          paramString = paramzzg.zza((zzap)paramList.get(0)).zzc();
          long l;
          if (paramList.size() > 1) {
            l = zzh.zzh(paramzzg.zza((zzap)paramList.get(1)).zzd().doubleValue());
          } else {
            l = 2147483647L;
          }
          if (l == 0L)
          {
            paramString = new zzae();
            break;
          }
          paramzzg = ((String)localObject2).split(Pattern.quote(paramString), (int)l + 1);
          int n = paramzzg.length;
          int j;
          if ((paramString.equals("")) && (n > 0))
          {
            j = paramzzg[0].equals("");
            i1 = n - 1;
            m = i1;
            if (!paramzzg[i1].equals("")) {
              m = n;
            }
          }
          else
          {
            m = n;
            j = 0;
          }
          int i1 = m;
          if (n > l) {
            i1 = m - 1;
          }
          while (j < i1)
          {
            ((List)localObject1).add(new zzat(paramzzg[j]));
            j++;
          }
        }
        paramString = new zzae((List)localObject1);
        break;
        zzh.zzc("slice", 2, paramList);
        paramString = this.zza;
        if (paramList.size() > 0) {
          d = paramzzg.zza((zzap)paramList.get(0)).zzd().doubleValue();
        } else {
          d = 0.0D;
        }
        d = zzh.zzi(d);
        if (d < 0.0D) {
          d = Math.max(paramString.length() + d, 0.0D);
        } else {
          d = Math.min(d, paramString.length());
        }
        k = (int)d;
        if (paramList.size() > 1) {
          d = paramzzg.zza((zzap)paramList.get(1)).zzd().doubleValue();
        } else {
          d = paramString.length();
        }
        d = zzh.zzi(d);
        if (d < 0.0D) {
          d = Math.max(paramString.length() + d, 0.0D);
        } else {
          d = Math.min(d, paramString.length());
        }
      }
    case 7: 
      zzh.zzc("search", 1, paramList);
      if (paramList.size() > 0) {
        paramString = paramzzg.zza((zzap)paramList.get(0)).zzc();
      }
      paramzzg = this.zza;
      paramString = Pattern.compile(paramString).matcher(paramzzg);
      if (paramString.find()) {
        paramString = new zzah(Double.valueOf(paramString.start()));
      } else {
        paramString = new zzah(Double.valueOf(-1.0D));
      }
      break;
    case 6: 
      localObject2 = this;
      zzh.zzc("replace", 2, paramList);
      zzap localzzap = zzap.zzf;
      localObject1 = localzzap;
      if (paramList.size() > 0)
      {
        str = paramzzg.zza((zzap)paramList.get(0)).zzc();
        localObject1 = localzzap;
        paramString = str;
        if (paramList.size() > 1)
        {
          localObject1 = paramzzg.zza((zzap)paramList.get(1));
          paramString = str;
        }
      }
      String str = ((zzat)localObject2).zza;
      k = str.indexOf(paramString);
      if (k >= 0)
      {
        paramList = (List<zzap>)localObject1;
        if ((localObject1 instanceof zzai)) {
          paramList = ((zzai)localObject1).zza(paramzzg, Arrays.asList(new zzap[] { new zzat(paramString), new zzah(Double.valueOf(k)), localObject2 }));
        }
        paramzzg = str.substring(0, k);
        paramList = paramList.zzc();
        paramString = str.substring(k + paramString.length());
        localObject1 = new StringBuilder(String.valueOf(paramzzg).length() + String.valueOf(paramList).length() + String.valueOf(paramString).length());
        ((StringBuilder)localObject1).append(paramzzg);
        ((StringBuilder)localObject1).append(paramList);
        ((StringBuilder)localObject1).append(paramString);
        paramString = new zzat(((StringBuilder)localObject1).toString());
      }
      break;
    case 5: 
      zzh.zzc("match", 1, paramList);
      localObject2 = this.zza;
      if (paramList.size() <= 0) {
        paramString = (String)localObject1;
      } else {
        paramString = paramzzg.zza((zzap)paramList.get(0)).zzc();
      }
      paramString = Pattern.compile(paramString).matcher((CharSequence)localObject2);
      if (paramString.find()) {
        paramString = new zzae(Arrays.asList(new zzap[] { new zzat(paramString.group()) }));
      } else {
        paramString = zzap.zzg;
      }
      break;
    case 4: 
      zzh.zzc("lastIndexOf", 2, paramList);
      localObject1 = this.zza;
      if (paramList.size() > 0) {
        paramString = paramzzg.zza((zzap)paramList.get(0)).zzc();
      }
      if (paramList.size() < 2) {
        d = NaN.0D;
      } else {
        d = paramzzg.zza((zzap)paramList.get(1)).zzd().doubleValue();
      }
      if (Double.isNaN(d)) {
        d = Double.POSITIVE_INFINITY;
      } else {
        d = zzh.zzi(d);
      }
      paramString = new zzah(Double.valueOf(((String)localObject1).lastIndexOf(paramString, (int)d)));
      break;
    case 3: 
      zzh.zzc("indexOf", 2, paramList);
      localObject1 = this.zza;
      if (paramList.size() > 0) {
        paramString = paramzzg.zza((zzap)paramList.get(0)).zzc();
      }
      if (paramList.size() < 2) {
        d = 0.0D;
      } else {
        d = paramzzg.zza((zzap)paramList.get(1)).zzd().doubleValue();
      }
      paramString = new zzah(Double.valueOf(((String)localObject1).indexOf(paramString, (int)zzh.zzi(d))));
      break;
    case 2: 
      zzh.zza("hasOwnProperty", 1, paramList);
      paramString = this.zza;
      paramzzg = paramzzg.zza((zzap)paramList.get(0));
      if ("length".equals(paramzzg.zzc()))
      {
        paramString = zzap.zzk;
      }
      else
      {
        d = paramzzg.zzd().doubleValue();
        if (d == Math.floor(d))
        {
          k = (int)d;
          if ((k >= 0) && (k < paramString.length()))
          {
            paramString = zzap.zzk;
            break;
          }
        }
        paramString = zzap.zzl;
      }
      break;
    case 1: 
      if (paramList.size() != 0)
      {
        paramString = new StringBuilder(this.zza);
        for (k = 0; k < paramList.size(); k++) {
          paramString.append(paramzzg.zza((zzap)paramList.get(k)).zzc());
        }
        paramString = new zzat(paramString.toString());
      }
      else
      {
        paramString = this;
      }
      break;
    }
    zzh.zzc("charAt", 1, paramList);
    if (paramList.size() > 0) {
      k = (int)zzh.zzi(paramzzg.zza((zzap)paramList.get(0)).zzd().doubleValue());
    } else {
      k = 0;
    }
    paramString = this.zza;
    if ((k >= 0) && (k < paramString.length())) {
      paramString = new zzat(String.valueOf(paramString.charAt(k)));
    } else {
      paramString = zzap.zzm;
    }
    return paramString;
  }
  
  public final String zzc()
  {
    return this.zza;
  }
  
  public final Double zzd()
  {
    if (this.zza.isEmpty()) {
      return Double.valueOf(0.0D);
    }
    try
    {
      Double localDouble = Double.valueOf(this.zza);
      return localDouble;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return Double.valueOf(NaN.0D);
  }
  
  public final Boolean zze()
  {
    return Boolean.valueOf(this.zza.isEmpty() ^ true);
  }
  
  public final Iterator<zzap> zzf()
  {
    return new zzar(this);
  }
  
  public final zzap zzt()
  {
    return new zzat(this.zza);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */