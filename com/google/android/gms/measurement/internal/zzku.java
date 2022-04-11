package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzcf;
import com.google.android.gms.internal.measurement.zzov;
import java.io.ByteArrayInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public final class zzku
  extends zzgo
{
  private static final String[] zzb = { "firebase_", "google_", "ga_" };
  private static final String[] zzc = { "_err" };
  private SecureRandom zzd;
  private final AtomicLong zze = new AtomicLong(0L);
  private int zzf;
  private Integer zzg = null;
  
  zzku(zzfu paramzzfu)
  {
    super(paramzzfu);
  }
  
  static MessageDigest zzN()
  {
    for (int i = 0; i < 2; i++) {
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
        if (localMessageDigest != null) {
          return localMessageDigest;
        }
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        for (;;) {}
      }
    }
    return null;
  }
  
  @VisibleForTesting
  static long zzO(byte[] paramArrayOfByte)
  {
    Preconditions.checkNotNull(paramArrayOfByte);
    int i = paramArrayOfByte.length;
    int j = 0;
    boolean bool;
    if (i > 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool);
    i--;
    long l = 0L;
    while ((i >= 0) && (i >= paramArrayOfByte.length - 8))
    {
      l += ((paramArrayOfByte[i] & 0xFF) << j);
      j += 8;
      i--;
    }
    return l;
  }
  
  static boolean zzP(Context paramContext, boolean paramBoolean)
  {
    Preconditions.checkNotNull(paramContext);
    if (Build.VERSION.SDK_INT >= 24) {
      return zzar(paramContext, "com.google.android.gms.measurement.AppMeasurementJobService");
    }
    return zzar(paramContext, "com.google.android.gms.measurement.AppMeasurementService");
  }
  
  static boolean zzR(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.startsWith("_"));
  }
  
  static boolean zzS(String paramString1, String paramString2)
  {
    if ((paramString1 == null) && (paramString2 == null)) {
      return true;
    }
    if (paramString1 == null) {
      return false;
    }
    return paramString1.equals(paramString2);
  }
  
  public static boolean zzY(String paramString)
  {
    return !zzc[0].equals(paramString);
  }
  
  public static ArrayList<Bundle> zzak(List<zzaa> paramList)
  {
    if (paramList == null) {
      return new ArrayList(0);
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject1 = (zzaa)paramList.next();
      Bundle localBundle = new Bundle();
      localBundle.putString("app_id", ((zzaa)localObject1).zza);
      localBundle.putString("origin", ((zzaa)localObject1).zzb);
      localBundle.putLong("creation_timestamp", ((zzaa)localObject1).zzd);
      localBundle.putString("name", ((zzaa)localObject1).zzc.zzb);
      zzgq.zza(localBundle, ((zzaa)localObject1).zzc.zza());
      localBundle.putBoolean("active", ((zzaa)localObject1).zze);
      Object localObject2 = ((zzaa)localObject1).zzf;
      if (localObject2 != null) {
        localBundle.putString("trigger_event_name", (String)localObject2);
      }
      localObject2 = ((zzaa)localObject1).zzg;
      if (localObject2 != null)
      {
        localBundle.putString("timed_out_event_name", ((zzas)localObject2).zza);
        localObject2 = ((zzaa)localObject1).zzg.zzb;
        if (localObject2 != null) {
          localBundle.putBundle("timed_out_event_params", ((zzaq)localObject2).zzf());
        }
      }
      localBundle.putLong("trigger_timeout", ((zzaa)localObject1).zzh);
      localObject2 = ((zzaa)localObject1).zzi;
      if (localObject2 != null)
      {
        localBundle.putString("triggered_event_name", ((zzas)localObject2).zza);
        localObject2 = ((zzaa)localObject1).zzi.zzb;
        if (localObject2 != null) {
          localBundle.putBundle("triggered_event_params", ((zzaq)localObject2).zzf());
        }
      }
      localBundle.putLong("triggered_timestamp", ((zzaa)localObject1).zzc.zzc);
      localBundle.putLong("time_to_live", ((zzaa)localObject1).zzj);
      localObject2 = ((zzaa)localObject1).zzk;
      if (localObject2 != null)
      {
        localBundle.putString("expired_event_name", ((zzas)localObject2).zza);
        localObject1 = ((zzaa)localObject1).zzk.zzb;
        if (localObject1 != null) {
          localBundle.putBundle("expired_event_params", ((zzaq)localObject1).zzf());
        }
      }
      localArrayList.add(localBundle);
    }
    return localArrayList;
  }
  
  static boolean zzam(Context paramContext)
  {
    Preconditions.checkNotNull(paramContext);
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      if (localPackageManager == null) {
        return false;
      }
      ComponentName localComponentName = new android/content/ComponentName;
      localComponentName.<init>(paramContext, "com.google.android.gms.measurement.AppMeasurementReceiver");
      paramContext = localPackageManager.getReceiverInfo(localComponentName, 0);
      if (paramContext != null)
      {
        boolean bool = paramContext.enabled;
        if (bool) {
          return true;
        }
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;) {}
    }
    return false;
  }
  
  static final boolean zzan(Bundle paramBundle, int paramInt)
  {
    if (paramBundle.getLong("_err") == 0L)
    {
      paramBundle.putLong("_err", paramInt);
      return true;
    }
    return false;
  }
  
  @VisibleForTesting
  static final boolean zzao(String paramString)
  {
    Preconditions.checkNotNull(paramString);
    return paramString.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$");
  }
  
  private final Object zzap(int paramInt, Object paramObject, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramObject == null) {
      return null;
    }
    if ((!(paramObject instanceof Long)) && (!(paramObject instanceof Double)))
    {
      if ((paramObject instanceof Integer)) {
        return Long.valueOf(((Integer)paramObject).intValue());
      }
      if ((paramObject instanceof Byte)) {
        return Long.valueOf(((Byte)paramObject).byteValue());
      }
      if ((paramObject instanceof Short)) {
        return Long.valueOf(((Short)paramObject).shortValue());
      }
      if ((paramObject instanceof Boolean))
      {
        long l;
        if (true != ((Boolean)paramObject).booleanValue()) {
          l = 0L;
        } else {
          l = 1L;
        }
        return Long.valueOf(l);
      }
      if ((paramObject instanceof Float)) {
        return Double.valueOf(((Float)paramObject).doubleValue());
      }
      if ((!(paramObject instanceof String)) && (!(paramObject instanceof Character)) && (!(paramObject instanceof CharSequence)))
      {
        if ((paramBoolean2) && (((paramObject instanceof Bundle[])) || ((paramObject instanceof Parcelable[]))))
        {
          ArrayList localArrayList = new ArrayList();
          for (Bundle localBundle : (Parcelable[])paramObject) {
            if ((localBundle instanceof Bundle))
            {
              localBundle = zzU((Bundle)localBundle);
              if (!localBundle.isEmpty()) {
                localArrayList.add(localBundle);
              }
            }
          }
          return localArrayList.toArray(new Bundle[localArrayList.size()]);
        }
        return null;
      }
      return zzC(String.valueOf(paramObject), paramInt, paramBoolean1);
    }
    return paramObject;
  }
  
  private final int zzaq(String paramString)
  {
    if ("_ldl".equals(paramString))
    {
      this.zzs.zzc();
      return 2048;
    }
    if (!"_id".equals(paramString))
    {
      if ((this.zzs.zzc().zzn(null, zzea.zzae)) && ("_lgclid".equals(paramString)))
      {
        this.zzs.zzc();
        return 100;
      }
      this.zzs.zzc();
      return 36;
    }
    this.zzs.zzc();
    return 256;
  }
  
  private static boolean zzar(Context paramContext, String paramString)
  {
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      if (localPackageManager == null) {
        return false;
      }
      ComponentName localComponentName = new android/content/ComponentName;
      localComponentName.<init>(paramContext, paramString);
      paramContext = localPackageManager.getServiceInfo(localComponentName, 0);
      if (paramContext != null)
      {
        boolean bool = paramContext.enabled;
        if (bool) {
          return true;
        }
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;) {}
    }
    return false;
  }
  
  private static boolean zzas(String paramString, String[] paramArrayOfString)
  {
    Preconditions.checkNotNull(paramArrayOfString);
    int i = paramArrayOfString.length;
    for (int j = 0; j < i; j++) {
      if (zzS(paramString, paramArrayOfString[j])) {
        return true;
      }
    }
    return false;
  }
  
  static boolean zzh(String paramString)
  {
    Preconditions.checkNotEmpty(paramString);
    return (paramString.charAt(0) != '_') || (paramString.equals("_ep"));
  }
  
  final boolean zzA(String paramString1, String paramString2, String paramString3)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (!zzao(paramString1))
      {
        if (this.zzs.zzq()) {
          this.zzs.zzau().zzd().zzb("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", zzem.zzl(paramString1));
        }
        return false;
      }
    }
    else
    {
      zzov.zzb();
      if ((!this.zzs.zzc().zzn(null, zzea.zzag)) || (TextUtils.isEmpty(paramString3)))
      {
        if (TextUtils.isEmpty(paramString2)) {
          break label112;
        }
        if (!zzao(paramString2))
        {
          this.zzs.zzau().zzd().zzb("Invalid admob_app_id. Analytics disabled.", zzem.zzl(paramString2));
          return false;
        }
      }
    }
    return true;
    label112:
    if (this.zzs.zzq()) {
      this.zzs.zzau().zzd().zza("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
    }
    return false;
  }
  
  final boolean zzB(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    boolean bool1 = TextUtils.isEmpty(paramString1);
    boolean bool2 = TextUtils.isEmpty(paramString2);
    if ((!bool1) && (!bool2))
    {
      Preconditions.checkNotNull(paramString1);
      return !paramString1.equals(paramString2);
    }
    if ((bool1) && (bool2))
    {
      if ((!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString4))) {
        return !paramString3.equals(paramString4);
      }
      return !TextUtils.isEmpty(paramString4);
    }
    if (!bool1)
    {
      if (TextUtils.isEmpty(paramString4)) {
        return false;
      }
      return (TextUtils.isEmpty(paramString3)) || (!paramString3.equals(paramString4));
    }
    return (TextUtils.isEmpty(paramString3)) || (!paramString3.equals(paramString4));
  }
  
  public final String zzC(String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramString == null) {
      return null;
    }
    if (paramString.codePointCount(0, paramString.length()) > paramInt)
    {
      if (paramBoolean) {
        return String.valueOf(paramString.substring(0, paramString.offsetByCodePoints(0, paramInt))).concat("...");
      }
      return null;
    }
    return paramString;
  }
  
  @WorkerThread
  final int zzD(String paramString1, String paramString2, String paramString3, Object paramObject, Bundle paramBundle, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    zzg();
    if (zzs(paramObject)) {
      if (paramBoolean2)
      {
        if (!zzas(paramString3, zzgs.zzc)) {
          return 20;
        }
        Object localObject = this.zzs.zzy();
        ((zzgn)localObject).zzg();
        ((zzf)localObject).zzb();
        if ((((zzjk)localObject).zzD()) && (((zzgn)localObject).zzs.zzl().zzZ() < 200900)) {
          return 25;
        }
        this.zzs.zzc();
        boolean bool = paramObject instanceof Parcelable[];
        if (bool)
        {
          i = ((Parcelable[])paramObject).length;
        }
        else
        {
          if (!(paramObject instanceof ArrayList)) {
            break label270;
          }
          i = ((ArrayList)paramObject).size();
        }
        if (i > 200)
        {
          this.zzs.zzau().zzh().zzd("Parameter array is too long; discarded. Value kind, name, array length", "param", paramString3, Integer.valueOf(i));
          this.zzs.zzc();
          if (bool)
          {
            localObject = (Parcelable[])paramObject;
            if (localObject.length > 200) {
              paramBundle.putParcelableArray(paramString3, (Parcelable[])Arrays.copyOf((Object[])localObject, 200));
            }
          }
          else if ((paramObject instanceof ArrayList))
          {
            localObject = (ArrayList)paramObject;
            if (((ArrayList)localObject).size() > 200) {
              paramBundle.putParcelableArrayList(paramString3, new ArrayList(((ArrayList)localObject).subList(0, 200)));
            }
          }
          i = 17;
          break label273;
        }
      }
      else
      {
        return 21;
      }
    }
    label270:
    int i = 0;
    label273:
    int j;
    if (((this.zzs.zzc().zzn(paramString1, zzea.zzR)) && (zzR(paramString2))) || (zzR(paramString3)))
    {
      this.zzs.zzc();
      j = 256;
    }
    else
    {
      this.zzs.zzc();
      j = 100;
    }
    if (zzt("param", paramString3, j, paramObject)) {
      return i;
    }
    if (paramBoolean2)
    {
      if ((paramObject instanceof Bundle))
      {
        zzz(paramString1, paramString2, paramString3, (Bundle)paramObject, paramList, paramBoolean1);
      }
      else
      {
        if ((paramObject instanceof Parcelable[])) {
          for (paramObject : (Parcelable[])paramObject)
          {
            if (!(paramObject instanceof Bundle))
            {
              this.zzs.zzau().zzh().zzc("All Parcelable[] elements must be of type Bundle. Value type, name", paramObject.getClass(), paramString3);
              break label593;
            }
            zzz(paramString1, paramString2, paramString3, (Bundle)paramObject, paramList, paramBoolean1);
          }
        }
        if (!(paramObject instanceof ArrayList)) {
          break label593;
        }
        paramBundle = (ArrayList)paramObject;
        ??? = paramBundle.size();
        for (j = 0; j < ???; j++)
        {
          paramObject = paramBundle.get(j);
          if (!(paramObject instanceof Bundle))
          {
            paramString2 = this.zzs.zzau().zzh();
            if (paramObject != null) {
              paramString1 = paramObject.getClass();
            } else {
              paramString1 = "null";
            }
            paramString2.zzc("All ArrayList elements must be of type Bundle. Value type, name", paramString1, paramString3);
            break label593;
          }
          zzz(paramString1, paramString2, paramString3, (Bundle)paramObject, paramList, paramBoolean1);
        }
      }
      return i;
    }
    label593:
    return 4;
  }
  
  final Object zzE(String paramString, Object paramObject)
  {
    boolean bool = "_ev".equals(paramString);
    int i = 256;
    if (bool)
    {
      this.zzs.zzc();
      return zzap(256, paramObject, true, true);
    }
    if (zzR(paramString))
    {
      this.zzs.zzc();
    }
    else
    {
      this.zzs.zzc();
      i = 100;
    }
    return zzap(i, paramObject, false, true);
  }
  
  final Bundle zzF(String paramString1, String paramString2, Bundle paramBundle, List<String> paramList, boolean paramBoolean)
  {
    boolean bool = zzas(paramString2, zzgr.zzd);
    Bundle localBundle = new Bundle(paramBundle);
    int i = this.zzs.zzc().zzc();
    Object localObject1;
    if (this.zzs.zzc().zzn(paramString1, zzea.zzW)) {
      localObject1 = new TreeSet(paramBundle.keySet());
    } else {
      localObject1 = paramBundle.keySet();
    }
    Iterator localIterator = ((Set)localObject1).iterator();
    int j = 0;
    label441:
    while (localIterator.hasNext())
    {
      localObject1 = (String)localIterator.next();
      int k;
      if ((paramList != null) && (paramList.contains(localObject1)))
      {
        k = 0;
      }
      else
      {
        int m;
        if (paramBoolean) {
          m = zzq((String)localObject1);
        } else {
          m = 0;
        }
        k = m;
        if (m == 0) {
          k = zzr((String)localObject1);
        }
      }
      Object localObject2;
      if (k != 0)
      {
        if (k == 3) {
          localObject2 = localObject1;
        } else {
          localObject2 = null;
        }
        zzI(localBundle, k, (String)localObject1, (String)localObject1, localObject2);
        localBundle.remove((String)localObject1);
      }
      else
      {
        k = zzD(paramString1, paramString2, (String)localObject1, paramBundle.get((String)localObject1), localBundle, paramList, paramBoolean, bool);
        if (k == 17)
        {
          zzI(localBundle, 17, (String)localObject1, (String)localObject1, Boolean.FALSE);
        }
        else if (k != 0)
        {
          localObject2 = localObject1;
          if (!"_ev".equals(localObject2))
          {
            if (k == 21) {
              localObject1 = paramString2;
            } else {
              localObject1 = localObject2;
            }
            zzI(localBundle, k, (String)localObject1, (String)localObject2, paramBundle.get((String)localObject2));
            localBundle.remove((String)localObject2);
            break label441;
          }
        }
        if (zzh((String)localObject1))
        {
          j++;
          if (j > i)
          {
            localObject2 = new StringBuilder(48);
            ((StringBuilder)localObject2).append("Event can't contain more than ");
            ((StringBuilder)localObject2).append(i);
            ((StringBuilder)localObject2).append(" params");
            localObject2 = ((StringBuilder)localObject2).toString();
            this.zzs.zzau().zzd().zzc((String)localObject2, this.zzs.zzm().zzc(paramString2), this.zzs.zzm().zzf(paramBundle));
            zzan(localBundle, 5);
            localBundle.remove((String)localObject1);
          }
        }
      }
    }
    return localBundle;
  }
  
  final void zzG(zzen paramzzen, int paramInt)
  {
    Iterator localIterator = new TreeSet(paramzzen.zzd.keySet()).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (zzh(str))
      {
        int j = i + 1;
        i = j;
        if (j > paramInt)
        {
          Object localObject = new StringBuilder(48);
          ((StringBuilder)localObject).append("Event can't contain more than ");
          ((StringBuilder)localObject).append(paramInt);
          ((StringBuilder)localObject).append(" params");
          localObject = ((StringBuilder)localObject).toString();
          this.zzs.zzau().zzd().zzc((String)localObject, this.zzs.zzm().zzc(paramzzen.zza), this.zzs.zzm().zzf(paramzzen.zzd));
          zzan(paramzzen.zzd, 5);
          paramzzen.zzd.remove(str);
          i = j;
        }
      }
    }
  }
  
  final void zzH(Bundle paramBundle1, Bundle paramBundle2)
  {
    if (paramBundle2 == null) {
      return;
    }
    Iterator localIterator = paramBundle2.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!paramBundle1.containsKey(str)) {
        this.zzs.zzl().zzL(paramBundle1, str, paramBundle2.get(str));
      }
    }
  }
  
  final void zzI(Bundle paramBundle, int paramInt, String paramString1, String paramString2, Object paramObject)
  {
    if (zzan(paramBundle, paramInt))
    {
      this.zzs.zzc();
      paramBundle.putString("_ev", zzC(paramString1, 40, true));
      if (paramObject != null)
      {
        Preconditions.checkNotNull(paramBundle);
        if (((paramObject instanceof String)) || ((paramObject instanceof CharSequence))) {
          paramBundle.putLong("_el", String.valueOf(paramObject).length());
        }
      }
    }
  }
  
  final int zzJ(String paramString, Object paramObject)
  {
    boolean bool;
    if ("_ldl".equals(paramString)) {
      bool = zzt("user property referrer", paramString, zzaq(paramString), paramObject);
    } else {
      bool = zzt("user property", paramString, zzaq(paramString), paramObject);
    }
    if (bool) {
      return 0;
    }
    return 7;
  }
  
  final Object zzK(String paramString, Object paramObject)
  {
    if ("_ldl".equals(paramString)) {
      return zzap(zzaq(paramString), paramObject, true, false);
    }
    return zzap(zzaq(paramString), paramObject, false, false);
  }
  
  final void zzL(Bundle paramBundle, String paramString, Object paramObject)
  {
    if (paramBundle == null) {
      return;
    }
    if ((paramObject instanceof Long))
    {
      paramBundle.putLong(paramString, ((Long)paramObject).longValue());
      return;
    }
    if ((paramObject instanceof String))
    {
      paramBundle.putString(paramString, String.valueOf(paramObject));
      return;
    }
    if ((paramObject instanceof Double))
    {
      paramBundle.putDouble(paramString, ((Double)paramObject).doubleValue());
      return;
    }
    if ((paramObject instanceof Bundle[]))
    {
      paramBundle.putParcelableArray(paramString, (Bundle[])paramObject);
      return;
    }
    if (paramString != null)
    {
      if (paramObject != null) {
        paramBundle = paramObject.getClass().getSimpleName();
      } else {
        paramBundle = null;
      }
      this.zzs.zzau().zzh().zzc("Not putting event parameter. Invalid value type. name, type", this.zzs.zzm().zzd(paramString), paramBundle);
    }
  }
  
  final void zzM(zzkt paramzzkt, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    zzan(localBundle, paramInt1);
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3))) {
      localBundle.putString(paramString2, paramString3);
    }
    if ((paramInt1 == 6) || (paramInt1 == 7) || (paramInt1 == 2)) {
      localBundle.putLong("_el", paramInt2);
    }
    if (paramBoolean)
    {
      paramzzkt.zza(paramString1, "_err", localBundle);
      return;
    }
    this.zzs.zzat();
    this.zzs.zzk().zzs("auto", "_err", localBundle);
  }
  
  @WorkerThread
  final boolean zzQ(String paramString)
  {
    zzg();
    if (Wrappers.packageManager(this.zzs.zzax()).checkCallingOrSelfPermission(paramString) == 0) {
      return true;
    }
    this.zzs.zzau().zzj().zzb("Permission not granted", paramString);
    return false;
  }
  
  final boolean zzT(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    String str = this.zzs.zzc().zzu();
    this.zzs.zzat();
    return str.equals(paramString);
  }
  
  final Bundle zzU(Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    if (paramBundle != null)
    {
      Iterator localIterator = paramBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = zzE(str, paramBundle.get(str));
        if (localObject == null) {
          this.zzs.zzau().zzh().zzb("Param value can't be null", this.zzs.zzm().zzd(str));
        } else {
          zzL(localBundle, str, localObject);
        }
      }
    }
    return localBundle;
  }
  
  final zzas zzV(String paramString1, String paramString2, Bundle paramBundle, String paramString3, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return null;
    }
    if (zzn(paramString2) == 0)
    {
      if (paramBundle != null) {
        paramBundle = new Bundle(paramBundle);
      } else {
        paramBundle = new Bundle();
      }
      paramBundle.putString("_o", paramString3);
      paramBundle = zzF(paramString1, paramString2, paramBundle, CollectionUtils.listOf("_o"), false);
      paramString1 = paramBundle;
      if (paramBoolean1) {
        paramString1 = zzU(paramBundle);
      }
      Preconditions.checkNotNull(paramString1);
      return new zzas(paramString2, new zzaq(paramString1), paramString3, paramLong);
    }
    this.zzs.zzau().zzb().zzb("Invalid conditional property event name", this.zzs.zzm().zze(paramString2));
    throw new IllegalArgumentException();
  }
  
  @VisibleForTesting
  final boolean zzW(Context paramContext, String paramString)
  {
    X500Principal localX500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
    try
    {
      paramContext = Wrappers.packageManager(paramContext).getPackageInfo(paramString, 64);
      if (paramContext != null)
      {
        paramContext = paramContext.signatures;
        if ((paramContext != null) && (paramContext.length > 0))
        {
          Object localObject = paramContext[0];
          paramContext = CertificateFactory.getInstance("X.509");
          paramString = new java/io/ByteArrayInputStream;
          paramString.<init>(((Signature)localObject).toByteArray());
          boolean bool = ((X509Certificate)paramContext.generateCertificate(paramString)).getSubjectX500Principal().equals(localX500Principal);
          return bool;
        }
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      this.zzs.zzau().zzb().zzb("Package name not found", paramContext);
    }
    catch (CertificateException paramContext)
    {
      this.zzs.zzau().zzb().zzb("Error obtaining certificate", paramContext);
    }
    return true;
  }
  
  final byte[] zzX(Parcelable paramParcelable)
  {
    if (paramParcelable == null) {
      return null;
    }
    Parcel localParcel = Parcel.obtain();
    try
    {
      paramParcelable.writeToParcel(localParcel, 0);
      paramParcelable = localParcel.marshall();
      return paramParcelable;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  @EnsuresNonNull({"this.apkVersion"})
  public final int zzZ()
  {
    if (this.zzg == null) {
      this.zzg = Integer.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zzs.zzax()) / 1000);
    }
    return this.zzg.intValue();
  }
  
  protected final boolean zza()
  {
    return true;
  }
  
  public final int zzaa(int paramInt)
  {
    return GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(this.zzs.zzax(), 12451000);
  }
  
  public final long zzab(long paramLong1, long paramLong2)
  {
    return (paramLong1 + paramLong2 * 60000L) / 86400000L;
  }
  
  @WorkerThread
  final void zzac(Bundle paramBundle, long paramLong)
  {
    long l = paramBundle.getLong("_et");
    if (l != 0L) {
      this.zzs.zzau().zze().zzb("Params already contained engagement", Long.valueOf(l));
    }
    paramBundle.putLong("_et", paramLong + l);
  }
  
  public final void zzad(zzcf paramzzcf, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("r", paramString);
    try
    {
      paramzzcf.zzb(localBundle);
      return;
    }
    catch (RemoteException paramzzcf)
    {
      this.zzs.zzau().zze().zzb("Error returning string value to wrapper", paramzzcf);
    }
  }
  
  public final void zzae(zzcf paramzzcf, long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("r", paramLong);
    try
    {
      paramzzcf.zzb(localBundle);
      return;
    }
    catch (RemoteException paramzzcf)
    {
      this.zzs.zzau().zze().zzb("Error returning long value to wrapper", paramzzcf);
    }
  }
  
  public final void zzaf(zzcf paramzzcf, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("r", paramInt);
    try
    {
      paramzzcf.zzb(localBundle);
      return;
    }
    catch (RemoteException paramzzcf)
    {
      this.zzs.zzau().zze().zzb("Error returning int value to wrapper", paramzzcf);
    }
  }
  
  public final void zzag(zzcf paramzzcf, byte[] paramArrayOfByte)
  {
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("r", paramArrayOfByte);
    try
    {
      paramzzcf.zzb(localBundle);
      return;
    }
    catch (RemoteException paramzzcf)
    {
      this.zzs.zzau().zze().zzb("Error returning byte array to wrapper", paramzzcf);
    }
  }
  
  public final void zzah(zzcf paramzzcf, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("r", paramBoolean);
    try
    {
      paramzzcf.zzb(localBundle);
      return;
    }
    catch (RemoteException paramzzcf)
    {
      this.zzs.zzau().zze().zzb("Error returning boolean value to wrapper", paramzzcf);
    }
  }
  
  public final void zzai(zzcf paramzzcf, Bundle paramBundle)
  {
    try
    {
      paramzzcf.zzb(paramBundle);
      return;
    }
    catch (RemoteException paramzzcf)
    {
      this.zzs.zzau().zze().zzb("Error returning bundle value to wrapper", paramzzcf);
    }
  }
  
  public final void zzaj(zzcf paramzzcf, ArrayList<Bundle> paramArrayList)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelableArrayList("r", paramArrayList);
    try
    {
      paramzzcf.zzb(localBundle);
      return;
    }
    catch (RemoteException paramzzcf)
    {
      this.zzs.zzau().zze().zzb("Error returning bundle list to wrapper", paramzzcf);
    }
  }
  
  public final URL zzal(long paramLong1, String paramString1, String paramString2, long paramLong2)
  {
    try
    {
      Preconditions.checkNotEmpty(paramString2);
      Preconditions.checkNotEmpty(paramString1);
      String str = String.format("https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=%s&rdid=%s&bundleid=%s&retry=%s", new Object[] { String.format("v%s.%s", new Object[] { Long.valueOf(42004L), Integer.valueOf(zzZ()) }), paramString2, paramString1, Long.valueOf(paramLong2) });
      paramString2 = str;
      if (paramString1.equals(this.zzs.zzc().zzv())) {
        paramString2 = str.concat("&ddl_test=1");
      }
      paramString1 = new URL(paramString2);
      return paramString1;
    }
    catch (IllegalArgumentException paramString1) {}catch (MalformedURLException paramString1) {}
    this.zzs.zzau().zzb().zzb("Failed to create BOW URL for Deferred Deep Link. exception", paramString1.getMessage());
    return null;
  }
  
  @WorkerThread
  protected final void zzaz()
  {
    zzg();
    SecureRandom localSecureRandom = new SecureRandom();
    long l1 = localSecureRandom.nextLong();
    long l2 = l1;
    if (l1 == 0L)
    {
      l1 = localSecureRandom.nextLong();
      l2 = l1;
      if (l1 == 0L)
      {
        this.zzs.zzau().zze().zza("Utils falling back to Random for random id");
        l2 = l1;
      }
    }
    this.zze.set(l2);
  }
  
  public final long zzd()
  {
    long l2;
    if (this.zze.get() == 0L) {
      synchronized (this.zze)
      {
        Random localRandom = new java/util/Random;
        localRandom.<init>(System.nanoTime() ^ this.zzs.zzay().currentTimeMillis());
        long l1 = localRandom.nextLong();
        int i = this.zzf + 1;
        this.zzf = i;
        l2 = i;
        return l1 + l2;
      }
    }
    synchronized (this.zze)
    {
      this.zze.compareAndSet(-1L, 1L);
      l2 = this.zze.getAndIncrement();
      return l2;
    }
  }
  
  @EnsuresNonNull({"this.secureRandom"})
  @WorkerThread
  final SecureRandom zzf()
  {
    zzg();
    if (this.zzd == null) {
      this.zzd = new SecureRandom();
    }
    return this.zzd;
  }
  
  final Bundle zzi(Uri paramUri)
  {
    if (paramUri != null) {
      try
      {
        boolean bool = paramUri.isHierarchical();
        String str1;
        String str3;
        String str4;
        if (bool)
        {
          str1 = paramUri.getQueryParameter("utm_campaign");
          str2 = paramUri.getQueryParameter("utm_source");
          str3 = paramUri.getQueryParameter("utm_medium");
          str4 = paramUri.getQueryParameter("gclid");
        }
        else
        {
          str1 = null;
          str2 = str1;
          str3 = str2;
          str4 = str3;
        }
        if ((TextUtils.isEmpty(str1)) && (TextUtils.isEmpty(str2)) && (TextUtils.isEmpty(str3)) && (TextUtils.isEmpty(str4))) {
          return null;
        }
        Bundle localBundle = new Bundle();
        if (!TextUtils.isEmpty(str1)) {
          localBundle.putString("campaign", str1);
        }
        if (!TextUtils.isEmpty(str2)) {
          localBundle.putString("source", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
          localBundle.putString("medium", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
          localBundle.putString("gclid", str4);
        }
        String str2 = paramUri.getQueryParameter("utm_term");
        if (!TextUtils.isEmpty(str2)) {
          localBundle.putString("term", str2);
        }
        str2 = paramUri.getQueryParameter("utm_content");
        if (!TextUtils.isEmpty(str2)) {
          localBundle.putString("content", str2);
        }
        str2 = paramUri.getQueryParameter("aclid");
        if (!TextUtils.isEmpty(str2)) {
          localBundle.putString("aclid", str2);
        }
        str2 = paramUri.getQueryParameter("cp1");
        if (!TextUtils.isEmpty(str2)) {
          localBundle.putString("cp1", str2);
        }
        paramUri = paramUri.getQueryParameter("anid");
        if (!TextUtils.isEmpty(paramUri)) {
          localBundle.putString("anid", paramUri);
        }
        return localBundle;
      }
      catch (UnsupportedOperationException paramUri)
      {
        this.zzs.zzau().zze().zzb("Install referrer url isn't a hierarchical URI", paramUri);
      }
    }
    return null;
  }
  
  final boolean zzj(String paramString1, String paramString2)
  {
    if (paramString2 == null)
    {
      this.zzs.zzau().zzd().zzb("Name is required and can't be null. Type", paramString1);
      return false;
    }
    if (paramString2.length() == 0)
    {
      this.zzs.zzau().zzd().zzb("Name is required and can't be empty. Type", paramString1);
      return false;
    }
    int i = paramString2.codePointAt(0);
    if (!Character.isLetter(i))
    {
      this.zzs.zzau().zzd().zzc("Name must start with a letter. Type, name", paramString1, paramString2);
      return false;
    }
    int j = paramString2.length();
    i = Character.charCount(i);
    while (i < j)
    {
      int k = paramString2.codePointAt(i);
      if ((k != 95) && (!Character.isLetterOrDigit(k)))
      {
        this.zzs.zzau().zzd().zzc("Name must consist of letters, digits or _ (underscores). Type, name", paramString1, paramString2);
        return false;
      }
      i += Character.charCount(k);
    }
    return true;
  }
  
  final boolean zzk(String paramString1, String paramString2)
  {
    if (paramString2 == null)
    {
      this.zzs.zzau().zzd().zzb("Name is required and can't be null. Type", paramString1);
      return false;
    }
    if (paramString2.length() == 0)
    {
      this.zzs.zzau().zzd().zzb("Name is required and can't be empty. Type", paramString1);
      return false;
    }
    int i = paramString2.codePointAt(0);
    int j = i;
    if (!Character.isLetter(i)) {
      if (i == 95)
      {
        j = 95;
      }
      else
      {
        this.zzs.zzau().zzd().zzc("Name must start with a letter or _ (underscore). Type, name", paramString1, paramString2);
        return false;
      }
    }
    i = paramString2.length();
    j = Character.charCount(j);
    while (j < i)
    {
      int k = paramString2.codePointAt(j);
      if ((k != 95) && (!Character.isLetterOrDigit(k)))
      {
        this.zzs.zzau().zzd().zzc("Name must consist of letters, digits or _ (underscores). Type, name", paramString1, paramString2);
        return false;
      }
      j += Character.charCount(k);
    }
    return true;
  }
  
  final boolean zzl(String paramString1, String[] paramArrayOfString1, String[] paramArrayOfString2, String paramString2)
  {
    if (paramString2 == null)
    {
      this.zzs.zzau().zzd().zzb("Name is required and can't be null. Type", paramString1);
      return false;
    }
    Preconditions.checkNotNull(paramString2);
    String[] arrayOfString = zzb;
    for (int i = 0; i < 3; i++) {
      if (paramString2.startsWith(arrayOfString[i]))
      {
        this.zzs.zzau().zzd().zzc("Name starts with reserved prefix. Type, name", paramString1, paramString2);
        return false;
      }
    }
    if ((paramArrayOfString1 != null) && (zzas(paramString2, paramArrayOfString1)) && ((paramArrayOfString2 == null) || (!zzas(paramString2, paramArrayOfString2))))
    {
      this.zzs.zzau().zzd().zzc("Name is reserved. Type, name", paramString1, paramString2);
      return false;
    }
    return true;
  }
  
  final boolean zzm(String paramString1, int paramInt, String paramString2)
  {
    if (paramString2 == null)
    {
      this.zzs.zzau().zzd().zzb("Name is required and can't be null. Type", paramString1);
      return false;
    }
    if (paramString2.codePointCount(0, paramString2.length()) > paramInt)
    {
      this.zzs.zzau().zzd().zzd("Name is too long. Type, maximum supported length, name", paramString1, Integer.valueOf(paramInt), paramString2);
      return false;
    }
    return true;
  }
  
  final int zzn(String paramString)
  {
    if (!zzk("event", paramString)) {
      return 2;
    }
    if (!zzl("event", zzgr.zza, zzgr.zzb, paramString)) {
      return 13;
    }
    this.zzs.zzc();
    if (!zzm("event", 40, paramString)) {
      return 2;
    }
    return 0;
  }
  
  final int zzo(String paramString)
  {
    if (!zzk("user property", paramString)) {
      return 6;
    }
    if (!zzl("user property", zzgt.zza, null, paramString)) {
      return 15;
    }
    this.zzs.zzc();
    if (!zzm("user property", 24, paramString)) {
      return 6;
    }
    return 0;
  }
  
  final int zzq(String paramString)
  {
    if (!zzj("event param", paramString)) {
      return 3;
    }
    if (!zzl("event param", null, null, paramString)) {
      return 14;
    }
    this.zzs.zzc();
    if (!zzm("event param", 40, paramString)) {
      return 3;
    }
    return 0;
  }
  
  final int zzr(String paramString)
  {
    if (!zzk("event param", paramString)) {
      return 3;
    }
    if (!zzl("event param", null, null, paramString)) {
      return 14;
    }
    this.zzs.zzc();
    if (!zzm("event param", 40, paramString)) {
      return 3;
    }
    return 0;
  }
  
  final boolean zzs(Object paramObject)
  {
    return ((paramObject instanceof Parcelable[])) || ((paramObject instanceof ArrayList)) || ((paramObject instanceof Bundle));
  }
  
  final boolean zzt(String paramString1, String paramString2, int paramInt, Object paramObject)
  {
    if (paramObject == null) {
      return true;
    }
    if ((!(paramObject instanceof Long)) && (!(paramObject instanceof Float)) && (!(paramObject instanceof Integer)) && (!(paramObject instanceof Byte)) && (!(paramObject instanceof Short)) && (!(paramObject instanceof Boolean)) && (!(paramObject instanceof Double)))
    {
      if ((!(paramObject instanceof String)) && (!(paramObject instanceof Character)) && (!(paramObject instanceof CharSequence))) {
        return false;
      }
      paramObject = String.valueOf(paramObject);
      if (((String)paramObject).codePointCount(0, ((String)paramObject).length()) > paramInt)
      {
        this.zzs.zzau().zzh().zzd("Value is too long; discarded. Value kind, name, value length", paramString1, paramString2, Integer.valueOf(((String)paramObject).length()));
        return false;
      }
    }
    return true;
  }
  
  final void zzz(String paramString1, String paramString2, String paramString3, Bundle paramBundle, List<String> paramList, boolean paramBoolean)
  {
    if (paramBundle == null) {
      return;
    }
    this.zzs.zzc();
    Iterator localIterator = new TreeSet(paramBundle.keySet()).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      int j;
      if ((paramList != null) && (paramList.contains(str1)))
      {
        j = 0;
      }
      else
      {
        int k;
        if (paramBoolean) {
          k = zzq(str1);
        } else {
          k = 0;
        }
        j = k;
        if (k == 0) {
          j = zzr(str1);
        }
      }
      if (j != 0)
      {
        String str2;
        if (j == 3) {
          str2 = str1;
        } else {
          str2 = null;
        }
        zzI(paramBundle, j, str1, str1, str2);
        paramBundle.remove(str1);
      }
      else
      {
        if (zzs(paramBundle.get(str1)))
        {
          this.zzs.zzau().zzh().zzd("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", paramString2, paramString3, str1);
          j = 22;
        }
        else
        {
          j = zzD(paramString1, paramString2, str1, paramBundle.get(str1), paramBundle, paramList, paramBoolean, false);
        }
        if ((j != 0) && (!"_ev".equals(str1)))
        {
          zzI(paramBundle, j, str1, str1, paramBundle.get(str1));
          paramBundle.remove(str1);
        }
        else if ((zzh(str1)) && (!zzas(str1, zzgs.zzd)))
        {
          j = i + 1;
          i = j;
          if (j > 0)
          {
            this.zzs.zzau().zzd().zzc("Item cannot contain custom parameters", this.zzs.zzm().zzc(paramString2), this.zzs.zzm().zzf(paramBundle));
            zzan(paramBundle, 23);
            paramBundle.remove(str1);
            i = j;
          }
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzku.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */