package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzaa;
import com.google.android.gms.internal.measurement.zzej;
import com.google.android.gms.internal.measurement.zzel;
import com.google.android.gms.internal.measurement.zzeq;
import com.google.android.gms.internal.measurement.zzes;
import com.google.android.gms.internal.measurement.zzex;
import com.google.android.gms.internal.measurement.zzfk;
import com.google.android.gms.internal.measurement.zzfm;
import com.google.android.gms.internal.measurement.zzfn;
import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzfr;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzfv;
import com.google.android.gms.internal.measurement.zzfw;
import com.google.android.gms.internal.measurement.zzgd;
import com.google.android.gms.internal.measurement.zzgf;
import com.google.android.gms.internal.measurement.zzgg;
import com.google.android.gms.internal.measurement.zzgh;
import com.google.android.gms.internal.measurement.zzjp;
import com.google.android.gms.internal.measurement.zzjz;
import com.google.android.gms.internal.measurement.zzlh;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPOutputStream;

public final class zzkp
  extends zzke
{
  zzkp(zzkn paramzzkn)
  {
    super(paramzzkn);
  }
  
  static final zzfs zzA(zzfo paramzzfo, String paramString)
  {
    Iterator localIterator = paramzzfo.zza().iterator();
    while (localIterator.hasNext())
    {
      paramzzfo = (zzfs)localIterator.next();
      if (paramzzfo.zzb().equals(paramString)) {
        return paramzzfo;
      }
    }
    return null;
  }
  
  static final Object zzB(zzfo paramzzfo, String paramString)
  {
    paramzzfo = zzA(paramzzfo, paramString);
    if (paramzzfo != null)
    {
      if (paramzzfo.zzc()) {
        return paramzzfo.zzd();
      }
      if (paramzzfo.zze()) {
        return Long.valueOf(paramzzfo.zzf());
      }
      if (paramzzfo.zzi()) {
        return Double.valueOf(paramzzfo.zzj());
      }
      if (paramzzfo.zzm() > 0)
      {
        paramString = paramzzfo.zzk();
        paramzzfo = new ArrayList();
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
          zzfs localzzfs = (zzfs)paramString.next();
          if (localzzfs != null)
          {
            Bundle localBundle = new Bundle();
            Iterator localIterator = localzzfs.zzk().iterator();
            while (localIterator.hasNext())
            {
              localzzfs = (zzfs)localIterator.next();
              if (localzzfs.zzc()) {
                localBundle.putString(localzzfs.zzb(), localzzfs.zzd());
              } else if (localzzfs.zze()) {
                localBundle.putLong(localzzfs.zzb(), localzzfs.zzf());
              } else if (localzzfs.zzi()) {
                localBundle.putDouble(localzzfs.zzb(), localzzfs.zzj());
              }
            }
            if (!localBundle.isEmpty()) {
              paramzzfo.add(localBundle);
            }
          }
        }
        return (Bundle[])paramzzfo.toArray(new Bundle[paramzzfo.size()]);
      }
    }
    return null;
  }
  
  private final void zzC(StringBuilder paramStringBuilder, int paramInt, List<zzfs> paramList)
  {
    if (paramList == null) {
      return;
    }
    paramInt++;
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      zzfs localzzfs = (zzfs)localIterator.next();
      if (localzzfs != null)
      {
        zzE(paramStringBuilder, paramInt);
        paramStringBuilder.append("param {\n");
        boolean bool = localzzfs.zza();
        Object localObject = null;
        if (bool) {
          paramList = this.zzs.zzm().zzd(localzzfs.zzb());
        } else {
          paramList = null;
        }
        zzH(paramStringBuilder, paramInt, "name", paramList);
        if (localzzfs.zzc()) {
          paramList = localzzfs.zzd();
        } else {
          paramList = null;
        }
        zzH(paramStringBuilder, paramInt, "string_value", paramList);
        if (localzzfs.zze()) {
          paramList = Long.valueOf(localzzfs.zzf());
        } else {
          paramList = null;
        }
        zzH(paramStringBuilder, paramInt, "int_value", paramList);
        paramList = (List<zzfs>)localObject;
        if (localzzfs.zzi()) {
          paramList = Double.valueOf(localzzfs.zzj());
        }
        zzH(paramStringBuilder, paramInt, "double_value", paramList);
        if (localzzfs.zzm() > 0) {
          zzC(paramStringBuilder, paramInt, localzzfs.zzk());
        }
        zzE(paramStringBuilder, paramInt);
        paramStringBuilder.append("}\n");
      }
    }
  }
  
  private final void zzD(StringBuilder paramStringBuilder, int paramInt, zzel paramzzel)
  {
    if (paramzzel == null) {
      return;
    }
    zzE(paramStringBuilder, paramInt);
    paramStringBuilder.append("filter {\n");
    if (paramzzel.zze()) {
      zzH(paramStringBuilder, paramInt, "complement", Boolean.valueOf(paramzzel.zzf()));
    }
    if (paramzzel.zzg()) {
      zzH(paramStringBuilder, paramInt, "param_name", this.zzs.zzm().zzd(paramzzel.zzh()));
    }
    if (paramzzel.zza())
    {
      int i = paramInt + 1;
      Object localObject = paramzzel.zzb();
      if (localObject != null)
      {
        zzE(paramStringBuilder, i);
        paramStringBuilder.append("string_filter {\n");
        if (((zzex)localObject).zza()) {
          zzH(paramStringBuilder, i, "match_type", ((zzex)localObject).zzb().name());
        }
        if (((zzex)localObject).zzc()) {
          zzH(paramStringBuilder, i, "expression", ((zzex)localObject).zzd());
        }
        if (((zzex)localObject).zze()) {
          zzH(paramStringBuilder, i, "case_sensitive", Boolean.valueOf(((zzex)localObject).zzf()));
        }
        if (((zzex)localObject).zzh() > 0)
        {
          zzE(paramStringBuilder, i + 1);
          paramStringBuilder.append("expression_list {\n");
          Iterator localIterator = ((zzex)localObject).zzg().iterator();
          while (localIterator.hasNext())
          {
            localObject = (String)localIterator.next();
            zzE(paramStringBuilder, i + 2);
            paramStringBuilder.append((String)localObject);
            paramStringBuilder.append("\n");
          }
          paramStringBuilder.append("}\n");
        }
        zzE(paramStringBuilder, i);
        paramStringBuilder.append("}\n");
      }
    }
    if (paramzzel.zzc()) {
      zzI(paramStringBuilder, paramInt + 1, "number_filter", paramzzel.zzd());
    }
    zzE(paramStringBuilder, paramInt);
    paramStringBuilder.append("}\n");
  }
  
  private static final void zzE(StringBuilder paramStringBuilder, int paramInt)
  {
    for (int i = 0; i < paramInt; i++) {
      paramStringBuilder.append("  ");
    }
  }
  
  private static final String zzF(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramBoolean1) {
      localStringBuilder.append("Dynamic ");
    }
    if (paramBoolean2) {
      localStringBuilder.append("Sequence ");
    }
    if (paramBoolean3) {
      localStringBuilder.append("Session-Scoped ");
    }
    return localStringBuilder.toString();
  }
  
  private static final void zzG(StringBuilder paramStringBuilder, int paramInt, String paramString, zzgd paramzzgd)
  {
    if (paramzzgd == null) {
      return;
    }
    zzE(paramStringBuilder, 3);
    paramStringBuilder.append(paramString);
    paramStringBuilder.append(" {\n");
    Object localObject;
    if (paramzzgd.zzd() != 0)
    {
      zzE(paramStringBuilder, 4);
      paramStringBuilder.append("results: ");
      localObject = paramzzgd.zzc().iterator();
      for (paramInt = 0; ((Iterator)localObject).hasNext(); paramInt++)
      {
        paramString = (Long)((Iterator)localObject).next();
        if (paramInt != 0) {
          paramStringBuilder.append(", ");
        }
        paramStringBuilder.append(paramString);
      }
      paramStringBuilder.append('\n');
    }
    if (paramzzgd.zzb() != 0)
    {
      zzE(paramStringBuilder, 4);
      paramStringBuilder.append("status: ");
      paramString = paramzzgd.zza().iterator();
      for (paramInt = 0; paramString.hasNext(); paramInt++)
      {
        localObject = (Long)paramString.next();
        if (paramInt != 0) {
          paramStringBuilder.append(", ");
        }
        paramStringBuilder.append(localObject);
      }
      paramStringBuilder.append('\n');
    }
    if (paramzzgd.zzf() != 0)
    {
      zzE(paramStringBuilder, 4);
      paramStringBuilder.append("dynamic_filter_timestamps: {");
      localObject = paramzzgd.zze().iterator();
      for (paramInt = 0; ((Iterator)localObject).hasNext(); paramInt++)
      {
        zzfm localzzfm = (zzfm)((Iterator)localObject).next();
        if (paramInt != 0) {
          paramStringBuilder.append(", ");
        }
        if (localzzfm.zza()) {
          paramString = Integer.valueOf(localzzfm.zzb());
        } else {
          paramString = null;
        }
        paramStringBuilder.append(paramString);
        paramStringBuilder.append(":");
        if (localzzfm.zzc()) {
          paramString = Long.valueOf(localzzfm.zzd());
        } else {
          paramString = null;
        }
        paramStringBuilder.append(paramString);
      }
      paramStringBuilder.append("}\n");
    }
    if (paramzzgd.zzi() != 0)
    {
      zzE(paramStringBuilder, 4);
      paramStringBuilder.append("sequence_filter_timestamps: {");
      paramzzgd = paramzzgd.zzh().iterator();
      for (paramInt = 0; paramzzgd.hasNext(); paramInt++)
      {
        localObject = (zzgf)paramzzgd.next();
        if (paramInt != 0) {
          paramStringBuilder.append(", ");
        }
        if (((zzgf)localObject).zza()) {
          paramString = Integer.valueOf(((zzgf)localObject).zzb());
        } else {
          paramString = null;
        }
        paramStringBuilder.append(paramString);
        paramStringBuilder.append(": [");
        paramString = ((zzgf)localObject).zzc().iterator();
        for (int i = 0; paramString.hasNext(); i++)
        {
          long l = ((Long)paramString.next()).longValue();
          if (i != 0) {
            paramStringBuilder.append(", ");
          }
          paramStringBuilder.append(l);
        }
        paramStringBuilder.append("]");
      }
      paramStringBuilder.append("}\n");
    }
    zzE(paramStringBuilder, 3);
    paramStringBuilder.append("}\n");
  }
  
  private static final void zzH(StringBuilder paramStringBuilder, int paramInt, String paramString, Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    zzE(paramStringBuilder, paramInt + 1);
    paramStringBuilder.append(paramString);
    paramStringBuilder.append(": ");
    paramStringBuilder.append(paramObject);
    paramStringBuilder.append('\n');
  }
  
  private static final void zzI(StringBuilder paramStringBuilder, int paramInt, String paramString, zzeq paramzzeq)
  {
    if (paramzzeq == null) {
      return;
    }
    zzE(paramStringBuilder, paramInt);
    paramStringBuilder.append(paramString);
    paramStringBuilder.append(" {\n");
    if (paramzzeq.zza()) {
      zzH(paramStringBuilder, paramInt, "comparison_type", paramzzeq.zzb().name());
    }
    if (paramzzeq.zzc()) {
      zzH(paramStringBuilder, paramInt, "match_as_float", Boolean.valueOf(paramzzeq.zzd()));
    }
    if (paramzzeq.zze()) {
      zzH(paramStringBuilder, paramInt, "comparison_value", paramzzeq.zzf());
    }
    if (paramzzeq.zzg()) {
      zzH(paramStringBuilder, paramInt, "min_comparison_value", paramzzeq.zzh());
    }
    if (paramzzeq.zzi()) {
      zzH(paramStringBuilder, paramInt, "max_comparison_value", paramzzeq.zzj());
    }
    zzE(paramStringBuilder, paramInt);
    paramStringBuilder.append("}\n");
  }
  
  static boolean zzl(String paramString)
  {
    return (paramString != null) && (paramString.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)")) && (paramString.length() <= 310);
  }
  
  static boolean zzm(List<Long> paramList, int paramInt)
  {
    return (paramInt < paramList.size() * 64) && ((1L << paramInt % 64 & ((Long)paramList.get(paramInt / 64)).longValue()) != 0L);
  }
  
  static List<Long> zzn(BitSet paramBitSet)
  {
    int i = (paramBitSet.length() + 63) / 64;
    ArrayList localArrayList = new ArrayList(i);
    for (int j = 0; j < i; j++)
    {
      long l1 = 0L;
      int k = 0;
      while (k < 64)
      {
        int m = j * 64 + k;
        if (m >= paramBitSet.length()) {
          break;
        }
        long l2 = l1;
        if (paramBitSet.get(m)) {
          l2 = l1 | 1L << k;
        }
        k++;
        l1 = l2;
      }
      localArrayList.add(Long.valueOf(l1));
    }
    return localArrayList;
  }
  
  static <Builder extends zzlh> Builder zzt(Builder paramBuilder, byte[] paramArrayOfByte)
    throws com.google.android.gms.internal.measurement.zzkn
  {
    zzjp localzzjp = zzjp.zzb();
    if (localzzjp != null) {
      return paramBuilder.zzav(paramArrayOfByte, localzzjp);
    }
    return paramBuilder.zzaw(paramArrayOfByte);
  }
  
  static int zzu(zzfv paramzzfv, String paramString)
  {
    for (int i = 0; i < paramzzfv.zzk(); i++) {
      if (paramString.equals(paramzzfv.zzl(i).zzc())) {
        return i;
      }
    }
    return -1;
  }
  
  static List<zzfs> zzv(Bundle[] paramArrayOfBundle)
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramArrayOfBundle.length;
    for (int j = 0; j < i; j++)
    {
      Bundle localBundle = paramArrayOfBundle[j];
      if (localBundle != null)
      {
        zzfr localzzfr1 = zzfs.zzn();
        Iterator localIterator = localBundle.keySet().iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (String)localIterator.next();
          zzfr localzzfr2 = zzfs.zzn();
          localzzfr2.zza((String)localObject);
          localObject = localBundle.get((String)localObject);
          if ((localObject instanceof Long))
          {
            localzzfr2.zzd(((Long)localObject).longValue());
          }
          else if ((localObject instanceof String))
          {
            localzzfr2.zzb((String)localObject);
          }
          else
          {
            if (!(localObject instanceof Double)) {
              continue;
            }
            localzzfr2.zzf(((Double)localObject).doubleValue());
          }
          localzzfr1.zzi(localzzfr2);
        }
        if (localzzfr1.zzh() > 0) {
          localArrayList.add((zzfs)localzzfr1.zzaA());
        }
      }
    }
    return localArrayList;
  }
  
  static zzas zzx(zzaa paramzzaa)
  {
    Bundle localBundle = new Bundle();
    Object localObject1 = paramzzaa.zzf().keySet().iterator();
    Object localObject2 = "app";
    while (((Iterator)localObject1).hasNext())
    {
      String str = (String)((Iterator)localObject1).next();
      Object localObject3 = paramzzaa.zze(str);
      localObject4 = localObject2;
      if ("_o".equals(str))
      {
        localObject4 = localObject2;
        if (localObject3 != null) {
          localObject4 = localObject3.toString();
        }
      }
      if (localObject3 == null)
      {
        localBundle.putString(str, null);
        localObject2 = localObject4;
      }
      else if ((localObject3 instanceof Long))
      {
        localBundle.putLong(str, ((Long)localObject3).longValue());
        localObject2 = localObject4;
      }
      else if ((localObject3 instanceof Double))
      {
        localBundle.putDouble(str, ((Double)localObject3).doubleValue());
        localObject2 = localObject4;
      }
      else
      {
        localBundle.putString(str, localObject3.toString());
        localObject2 = localObject4;
      }
    }
    localObject1 = zzgr.zzb(paramzzaa.zzb());
    Object localObject4 = localObject1;
    if (localObject1 == null) {
      localObject4 = paramzzaa.zzb();
    }
    return new zzas((String)localObject4, new zzaq(localBundle), (String)localObject2, paramzzaa.zza());
  }
  
  static final void zzy(zzfn paramzzfn, String paramString, Object paramObject)
  {
    Object localObject = paramzzfn.zza();
    for (int i = 0; i < ((List)localObject).size(); i++) {
      if (paramString.equals(((zzfs)((List)localObject).get(i)).zzb())) {
        break label52;
      }
    }
    i = -1;
    label52:
    localObject = zzfs.zzn();
    ((zzfr)localObject).zza(paramString);
    if ((paramObject instanceof Long)) {
      ((zzfr)localObject).zzd(((Long)paramObject).longValue());
    } else if ((paramObject instanceof String)) {
      ((zzfr)localObject).zzb((String)paramObject);
    } else if ((paramObject instanceof Double)) {
      ((zzfr)localObject).zzf(((Double)paramObject).doubleValue());
    } else if ((paramObject instanceof Bundle[])) {
      ((zzfr)localObject).zzj(zzv((Bundle[])paramObject));
    }
    if (i >= 0)
    {
      paramzzfn.zze(i, (zzfr)localObject);
      return;
    }
    paramzzfn.zzg((zzfr)localObject);
  }
  
  @WorkerThread
  static final boolean zzz(zzas paramzzas, zzp paramzzp)
  {
    Preconditions.checkNotNull(paramzzas);
    Preconditions.checkNotNull(paramzzp);
    return (!TextUtils.isEmpty(paramzzp.zzb)) || (!TextUtils.isEmpty(paramzzp.zzq));
  }
  
  protected final boolean zzaA()
  {
    return false;
  }
  
  final void zzc(zzgg paramzzgg, Object paramObject)
  {
    Preconditions.checkNotNull(paramObject);
    paramzzgg.zzd();
    paramzzgg.zzf();
    paramzzgg.zzh();
    if ((paramObject instanceof String))
    {
      paramzzgg.zzc((String)paramObject);
      return;
    }
    if ((paramObject instanceof Long))
    {
      paramzzgg.zze(((Long)paramObject).longValue());
      return;
    }
    if ((paramObject instanceof Double))
    {
      paramzzgg.zzg(((Double)paramObject).doubleValue());
      return;
    }
    this.zzs.zzau().zzb().zzb("Ignoring invalid (type) user attribute value", paramObject);
  }
  
  final void zzd(zzfr paramzzfr, Object paramObject)
  {
    Preconditions.checkNotNull(paramObject);
    paramzzfr.zzc();
    paramzzfr.zze();
    paramzzfr.zzg();
    paramzzfr.zzk();
    if ((paramObject instanceof String))
    {
      paramzzfr.zzb((String)paramObject);
      return;
    }
    if ((paramObject instanceof Long))
    {
      paramzzfr.zzd(((Long)paramObject).longValue());
      return;
    }
    if ((paramObject instanceof Double))
    {
      paramzzfr.zzf(((Double)paramObject).doubleValue());
      return;
    }
    if ((paramObject instanceof Bundle[]))
    {
      paramzzfr.zzj(zzv((Bundle[])paramObject));
      return;
    }
    this.zzs.zzau().zzb().zzb("Ignoring invalid (type) event param value", paramObject);
  }
  
  final zzfo zzf(zzan paramzzan)
  {
    zzfn localzzfn = zzfo.zzk();
    localzzfn.zzq(paramzzan.zze);
    zzap localzzap = new zzap(paramzzan.zzf);
    while (localzzap.hasNext())
    {
      Object localObject = localzzap.zza();
      zzfr localzzfr = zzfs.zzn();
      localzzfr.zza((String)localObject);
      localObject = paramzzan.zzf.zza((String)localObject);
      Preconditions.checkNotNull(localObject);
      zzd(localzzfr, localObject);
      localzzfn.zzg(localzzfr);
    }
    return (zzfo)localzzfn.zzaA();
  }
  
  final String zzh(com.google.android.gms.internal.measurement.zzfu paramzzfu)
  {
    if (paramzzfu == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nbatch {\n");
    Iterator localIterator1 = paramzzfu.zza().iterator();
    while (localIterator1.hasNext())
    {
      Object localObject = (zzfw)localIterator1.next();
      if (localObject != null)
      {
        zzE(localStringBuilder, 1);
        localStringBuilder.append("bundle {\n");
        if (((zzfw)localObject).zza()) {
          zzH(localStringBuilder, 1, "protocol_version", Integer.valueOf(((zzfw)localObject).zzb()));
        }
        zzH(localStringBuilder, 1, "platform", ((zzfw)localObject).zzt());
        if (((zzfw)localObject).zzC()) {
          zzH(localStringBuilder, 1, "gmp_version", Long.valueOf(((zzfw)localObject).zzD()));
        }
        if (((zzfw)localObject).zzE()) {
          zzH(localStringBuilder, 1, "uploading_gmp_version", Long.valueOf(((zzfw)localObject).zzF()));
        }
        if (((zzfw)localObject).zzae()) {
          zzH(localStringBuilder, 1, "dynamite_version", Long.valueOf(((zzfw)localObject).zzaf()));
        }
        if (((zzfw)localObject).zzW()) {
          zzH(localStringBuilder, 1, "config_version", Long.valueOf(((zzfw)localObject).zzX()));
        }
        zzH(localStringBuilder, 1, "gmp_app_id", ((zzfw)localObject).zzP());
        zzH(localStringBuilder, 1, "admob_app_id", ((zzfw)localObject).zzad());
        zzH(localStringBuilder, 1, "app_id", ((zzfw)localObject).zzA());
        zzH(localStringBuilder, 1, "app_version", ((zzfw)localObject).zzB());
        if (((zzfw)localObject).zzU()) {
          zzH(localStringBuilder, 1, "app_version_major", Integer.valueOf(((zzfw)localObject).zzV()));
        }
        zzH(localStringBuilder, 1, "firebase_instance_id", ((zzfw)localObject).zzT());
        if (((zzfw)localObject).zzK()) {
          zzH(localStringBuilder, 1, "dev_cert_hash", Long.valueOf(((zzfw)localObject).zzL()));
        }
        zzH(localStringBuilder, 1, "app_store", ((zzfw)localObject).zzz());
        if (((zzfw)localObject).zzi()) {
          zzH(localStringBuilder, 1, "upload_timestamp_millis", Long.valueOf(((zzfw)localObject).zzj()));
        }
        if (((zzfw)localObject).zzk()) {
          zzH(localStringBuilder, 1, "start_timestamp_millis", Long.valueOf(((zzfw)localObject).zzm()));
        }
        if (((zzfw)localObject).zzn()) {
          zzH(localStringBuilder, 1, "end_timestamp_millis", Long.valueOf(((zzfw)localObject).zzo()));
        }
        if (((zzfw)localObject).zzp()) {
          zzH(localStringBuilder, 1, "previous_bundle_start_timestamp_millis", Long.valueOf(((zzfw)localObject).zzq()));
        }
        if (((zzfw)localObject).zzr()) {
          zzH(localStringBuilder, 1, "previous_bundle_end_timestamp_millis", Long.valueOf(((zzfw)localObject).zzs()));
        }
        zzH(localStringBuilder, 1, "app_instance_id", ((zzfw)localObject).zzJ());
        zzH(localStringBuilder, 1, "resettable_device_id", ((zzfw)localObject).zzG());
        zzH(localStringBuilder, 1, "ds_id", ((zzfw)localObject).zzaa());
        if (((zzfw)localObject).zzH()) {
          zzH(localStringBuilder, 1, "limited_ad_tracking", Boolean.valueOf(((zzfw)localObject).zzI()));
        }
        zzH(localStringBuilder, 1, "os_version", ((zzfw)localObject).zzu());
        zzH(localStringBuilder, 1, "device_model", ((zzfw)localObject).zzv());
        zzH(localStringBuilder, 1, "user_default_language", ((zzfw)localObject).zzw());
        if (((zzfw)localObject).zzx()) {
          zzH(localStringBuilder, 1, "time_zone_offset_minutes", Integer.valueOf(((zzfw)localObject).zzy()));
        }
        if (((zzfw)localObject).zzM()) {
          zzH(localStringBuilder, 1, "bundle_sequential_index", Integer.valueOf(((zzfw)localObject).zzN()));
        }
        if (((zzfw)localObject).zzQ()) {
          zzH(localStringBuilder, 1, "service_upload", Boolean.valueOf(((zzfw)localObject).zzR()));
        }
        zzH(localStringBuilder, 1, "health_monitor", ((zzfw)localObject).zzO());
        if ((!this.zzs.zzc().zzn(null, zzea.zzat)) && (((zzfw)localObject).zzY()) && (((zzfw)localObject).zzZ() != 0L)) {
          zzH(localStringBuilder, 1, "android_id", Long.valueOf(((zzfw)localObject).zzZ()));
        }
        if (((zzfw)localObject).zzab()) {
          zzH(localStringBuilder, 1, "retry_counter", Integer.valueOf(((zzfw)localObject).zzac()));
        }
        if (((zzfw)localObject).zzah()) {
          zzH(localStringBuilder, 1, "consent_signals", ((zzfw)localObject).zzai());
        }
        paramzzfu = ((zzfw)localObject).zzf();
        Iterator localIterator2;
        if (paramzzfu != null)
        {
          localIterator2 = paramzzfu.iterator();
          while (localIterator2.hasNext())
          {
            zzgh localzzgh = (zzgh)localIterator2.next();
            if (localzzgh != null)
            {
              zzE(localStringBuilder, 2);
              localStringBuilder.append("user_property {\n");
              if (localzzgh.zza()) {
                paramzzfu = Long.valueOf(localzzgh.zzb());
              } else {
                paramzzfu = null;
              }
              zzH(localStringBuilder, 2, "set_timestamp_millis", paramzzfu);
              zzH(localStringBuilder, 2, "name", this.zzs.zzm().zze(localzzgh.zzc()));
              zzH(localStringBuilder, 2, "string_value", localzzgh.zze());
              if (localzzgh.zzf()) {
                paramzzfu = Long.valueOf(localzzgh.zzg());
              } else {
                paramzzfu = null;
              }
              zzH(localStringBuilder, 2, "int_value", paramzzfu);
              if (localzzgh.zzh()) {
                paramzzfu = Double.valueOf(localzzgh.zzi());
              } else {
                paramzzfu = null;
              }
              zzH(localStringBuilder, 2, "double_value", paramzzfu);
              zzE(localStringBuilder, 2);
              localStringBuilder.append("}\n");
            }
          }
        }
        paramzzfu = ((zzfw)localObject).zzS();
        if (paramzzfu != null)
        {
          localIterator2 = paramzzfu.iterator();
          while (localIterator2.hasNext())
          {
            paramzzfu = (zzfk)localIterator2.next();
            if (paramzzfu != null)
            {
              zzE(localStringBuilder, 2);
              localStringBuilder.append("audience_membership {\n");
              if (paramzzfu.zza()) {
                zzH(localStringBuilder, 2, "audience_id", Integer.valueOf(paramzzfu.zzb()));
              }
              if (paramzzfu.zzf()) {
                zzH(localStringBuilder, 2, "new_audience", Boolean.valueOf(paramzzfu.zzg()));
              }
              zzG(localStringBuilder, 2, "current_data", paramzzfu.zzc());
              if (paramzzfu.zzd()) {
                zzG(localStringBuilder, 2, "previous_data", paramzzfu.zze());
              }
              zzE(localStringBuilder, 2);
              localStringBuilder.append("}\n");
            }
          }
        }
        paramzzfu = ((zzfw)localObject).zzc();
        if (paramzzfu != null)
        {
          localObject = paramzzfu.iterator();
          while (((Iterator)localObject).hasNext())
          {
            paramzzfu = (zzfo)((Iterator)localObject).next();
            if (paramzzfu != null)
            {
              zzE(localStringBuilder, 2);
              localStringBuilder.append("event {\n");
              zzH(localStringBuilder, 2, "name", this.zzs.zzm().zzc(paramzzfu.zzd()));
              if (paramzzfu.zze()) {
                zzH(localStringBuilder, 2, "timestamp_millis", Long.valueOf(paramzzfu.zzf()));
              }
              if (paramzzfu.zzg()) {
                zzH(localStringBuilder, 2, "previous_timestamp_millis", Long.valueOf(paramzzfu.zzh()));
              }
              if (paramzzfu.zzi()) {
                zzH(localStringBuilder, 2, "count", Integer.valueOf(paramzzfu.zzj()));
              }
              if (paramzzfu.zzb() != 0) {
                zzC(localStringBuilder, 2, paramzzfu.zza());
              }
              zzE(localStringBuilder, 2);
              localStringBuilder.append("}\n");
            }
          }
        }
        zzE(localStringBuilder, 1);
        localStringBuilder.append("}\n");
      }
    }
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
  
  final String zzi(zzej paramzzej)
  {
    if (paramzzej == null) {
      return "null";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nevent_filter {\n");
    if (paramzzej.zza()) {
      zzH(localStringBuilder, 0, "filter_id", Integer.valueOf(paramzzej.zzb()));
    }
    zzH(localStringBuilder, 0, "event_name", this.zzs.zzm().zzc(paramzzej.zzc()));
    String str = zzF(paramzzej.zzi(), paramzzej.zzj(), paramzzej.zzm());
    if (!str.isEmpty()) {
      zzH(localStringBuilder, 0, "filter_type", str);
    }
    if (paramzzej.zzg()) {
      zzI(localStringBuilder, 1, "event_count_filter", paramzzej.zzh());
    }
    if (paramzzej.zze() > 0)
    {
      localStringBuilder.append("  filters {\n");
      paramzzej = paramzzej.zzd().iterator();
      while (paramzzej.hasNext()) {
        zzD(localStringBuilder, 2, (zzel)paramzzej.next());
      }
    }
    zzE(localStringBuilder, 1);
    localStringBuilder.append("}\n}\n");
    return localStringBuilder.toString();
  }
  
  final String zzj(zzes paramzzes)
  {
    if (paramzzes == null) {
      return "null";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nproperty_filter {\n");
    if (paramzzes.zza()) {
      zzH(localStringBuilder, 0, "filter_id", Integer.valueOf(paramzzes.zzb()));
    }
    zzH(localStringBuilder, 0, "property_name", this.zzs.zzm().zze(paramzzes.zzc()));
    String str = zzF(paramzzes.zze(), paramzzes.zzf(), paramzzes.zzh());
    if (!str.isEmpty()) {
      zzH(localStringBuilder, 0, "filter_type", str);
    }
    zzD(localStringBuilder, 1, paramzzes.zzd());
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
  
  /* Error */
  final <T extends android.os.Parcelable> T zzk(byte[] paramArrayOfByte, android.os.Parcelable.Creator<T> paramCreator)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: invokestatic 954	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   9: astore_3
    //   10: aload_3
    //   11: aload_1
    //   12: iconst_0
    //   13: aload_1
    //   14: arraylength
    //   15: invokevirtual 958	android/os/Parcel:unmarshall	([BII)V
    //   18: aload_3
    //   19: iconst_0
    //   20: invokevirtual 961	android/os/Parcel:setDataPosition	(I)V
    //   23: aload_2
    //   24: aload_3
    //   25: invokeinterface 967 2 0
    //   30: checkcast 969	android/os/Parcelable
    //   33: astore_1
    //   34: aload_3
    //   35: invokevirtual 972	android/os/Parcel:recycle	()V
    //   38: aload_1
    //   39: areturn
    //   40: astore_1
    //   41: goto +26 -> 67
    //   44: astore_1
    //   45: aload_0
    //   46: getfield 144	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   49: invokevirtual 552	com/google/android/gms/measurement/internal/zzfu:zzau	()Lcom/google/android/gms/measurement/internal/zzem;
    //   52: invokevirtual 557	com/google/android/gms/measurement/internal/zzem:zzb	()Lcom/google/android/gms/measurement/internal/zzek;
    //   55: ldc_w 974
    //   58: invokevirtual 977	com/google/android/gms/measurement/internal/zzek:zza	(Ljava/lang/String;)V
    //   61: aload_3
    //   62: invokevirtual 972	android/os/Parcel:recycle	()V
    //   65: aconst_null
    //   66: areturn
    //   67: aload_3
    //   68: invokevirtual 972	android/os/Parcel:recycle	()V
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	zzkp
    //   0	73	1	paramArrayOfByte	byte[]
    //   0	73	2	paramCreator	android.os.Parcelable.Creator<T>
    //   9	59	3	localParcel	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   10	34	40	finally
    //   45	61	40	finally
    //   10	34	44	com/google/android/gms/common/internal/safeparcel/SafeParcelReader$ParseException
  }
  
  final List<Long> zzo(List<Long> paramList, List<Integer> paramList1)
  {
    paramList = new ArrayList(paramList);
    Iterator localIterator = paramList1.iterator();
    while (localIterator.hasNext())
    {
      paramList1 = (Integer)localIterator.next();
      if (paramList1.intValue() < 0)
      {
        this.zzs.zzau().zze().zzb("Ignoring negative bit index to be cleared", paramList1);
      }
      else
      {
        i = paramList1.intValue() / 64;
        if (i >= paramList.size()) {
          this.zzs.zzau().zze().zzc("Ignoring bit index greater than bitSet size", paramList1, Integer.valueOf(paramList.size()));
        } else {
          paramList.set(i, Long.valueOf(((Long)paramList.get(i)).longValue() & (1L << paramList1.intValue() % 64 ^ 0xFFFFFFFFFFFFFFFF)));
        }
      }
    }
    int j = paramList.size();
    int k;
    for (int i = paramList.size() - 1; (i >= 0) && (((Long)paramList.get(i)).longValue() == 0L); i = k)
    {
      k = i - 1;
      j = i;
    }
    return paramList.subList(0, j);
  }
  
  final boolean zzq(long paramLong1, long paramLong2)
  {
    return (paramLong1 == 0L) || (paramLong2 <= 0L) || (Math.abs(this.zzs.zzay().currentTimeMillis() - paramLong1) > paramLong2);
  }
  
  @WorkerThread
  final long zzr(byte[] paramArrayOfByte)
  {
    Preconditions.checkNotNull(paramArrayOfByte);
    this.zzs.zzl().zzg();
    MessageDigest localMessageDigest = zzku.zzN();
    if (localMessageDigest == null)
    {
      this.zzs.zzau().zzb().zza("Failed to get MD5");
      return 0L;
    }
    return zzku.zzO(localMessageDigest.digest(paramArrayOfByte));
  }
  
  final byte[] zzs(byte[] paramArrayOfByte)
    throws IOException
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new java/io/ByteArrayOutputStream;
      localByteArrayOutputStream.<init>();
      GZIPOutputStream localGZIPOutputStream = new java/util/zip/GZIPOutputStream;
      localGZIPOutputStream.<init>(localByteArrayOutputStream);
      localGZIPOutputStream.write(paramArrayOfByte);
      localGZIPOutputStream.close();
      localByteArrayOutputStream.close();
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      return paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte)
    {
      this.zzs.zzau().zzb().zzb("Failed to gzip content", paramArrayOfByte);
      throw paramArrayOfByte;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzkp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */