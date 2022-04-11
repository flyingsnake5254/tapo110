package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.internal.play_billing.zza;
import com.google.android.gms.internal.play_billing.zzd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

class d
  extends c
{
  private int a = 0;
  private final String b;
  private final Handler c = new Handler(Looper.getMainLooper());
  private i0 d;
  private Context e;
  private Context f;
  private zzd g;
  private v h;
  private boolean i;
  private boolean j;
  private int k = 0;
  private boolean l;
  private boolean m;
  private boolean n;
  private boolean o;
  private boolean p;
  private boolean q;
  private boolean r;
  private boolean s;
  private boolean t;
  private ExecutorService u;
  
  private d(Context paramContext, boolean paramBoolean, k paramk, String paramString1, String paramString2)
  {
    this.b = paramString1;
    k(paramContext, paramk, paramBoolean);
  }
  
  @UiThread
  d(@Nullable String paramString, boolean paramBoolean, Context paramContext, k paramk)
  {
    this(paramContext, true, paramk, paramString, null);
  }
  
  private final g L(g paramg)
  {
    this.d.b().a(paramg, null);
    return paramg;
  }
  
  @Nullable
  private final <T> Future<T> M(Callable<T> paramCallable, long paramLong, @Nullable Runnable paramRunnable)
  {
    paramLong = (paramLong * 0.95D);
    if (this.u == null) {
      this.u = Executors.newFixedThreadPool(zza.zza, new r0(this));
    }
    try
    {
      paramCallable = this.u.submit(paramCallable);
      this.c.postDelayed(new s0(this, paramCallable, paramRunnable), paramLong);
      return paramCallable;
    }
    catch (Exception paramCallable)
    {
      paramRunnable = String.valueOf(paramCallable);
      paramCallable = new StringBuilder(paramRunnable.length() + 28);
      paramCallable.append("Async task throws exception ");
      paramCallable.append(paramRunnable);
      zza.zzb("BillingClient", paramCallable.toString());
    }
    return null;
  }
  
  private void k(Context paramContext, k paramk, boolean paramBoolean)
  {
    Context localContext = paramContext.getApplicationContext();
    this.f = localContext;
    this.d = new i0(localContext, paramk);
    this.e = paramContext;
    this.t = paramBoolean;
  }
  
  private final g l(String paramString)
  {
    paramString = M(new u0(this, paramString), 5000L, null);
    try
    {
      if (((Integer)paramString.get(5000L, TimeUnit.MILLISECONDS)).intValue() == 0) {
        paramString = y.p;
      } else {
        paramString = y.i;
      }
      return paramString;
    }
    catch (Exception paramString)
    {
      zza.zzb("BillingClient", "Exception while checking if billing is supported; try to reconnect");
    }
    return y.q;
  }
  
  private final void m(Runnable paramRunnable)
  {
    if (Thread.interrupted()) {
      return;
    }
    this.c.post(paramRunnable);
  }
  
  private final g n()
  {
    int i1 = this.a;
    g localg;
    if ((i1 != 0) && (i1 != 3)) {
      localg = y.l;
    } else {
      localg = y.q;
    }
    return localg;
  }
  
  public final void a(a parama, b paramb)
  {
    if (!e())
    {
      paramb.a(y.q);
      return;
    }
    if (TextUtils.isEmpty(parama.a()))
    {
      zza.zzb("BillingClient", "Please provide a valid purchase token.");
      paramb.a(y.k);
      return;
    }
    if (!this.n)
    {
      paramb.a(y.b);
      return;
    }
    if (M(new p0(this, parama, paramb), 30000L, new q0(this, paramb)) == null) {
      paramb.a(n());
    }
  }
  
  public final void b(h paramh, i parami)
  {
    if (!e())
    {
      parami.a(y.q, paramh.a());
      return;
    }
    if (M(new l0(this, paramh, parami), 30000L, new m0(this, parami, paramh)) == null) {
      parami.a(n(), paramh.a());
    }
  }
  
  /* Error */
  public final void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: aconst_null
    //   2: putfield 227	com/android/billingclient/api/d:e	Landroid/content/Context;
    //   5: aload_0
    //   6: getfield 138	com/android/billingclient/api/d:d	Lcom/android/billingclient/api/i0;
    //   9: invokevirtual 498	com/android/billingclient/api/i0:c	()V
    //   12: aload_0
    //   13: getfield 500	com/android/billingclient/api/d:h	Lcom/android/billingclient/api/v;
    //   16: astore_1
    //   17: aload_1
    //   18: ifnull +7 -> 25
    //   21: aload_1
    //   22: invokevirtual 504	com/android/billingclient/api/v:a	()V
    //   25: aload_0
    //   26: getfield 500	com/android/billingclient/api/d:h	Lcom/android/billingclient/api/v;
    //   29: ifnull +34 -> 63
    //   32: aload_0
    //   33: getfield 281	com/android/billingclient/api/d:g	Lcom/google/android/gms/internal/play_billing/zzd;
    //   36: ifnull +27 -> 63
    //   39: ldc -52
    //   41: ldc_w 506
    //   44: invokestatic 295	com/google/android/gms/internal/play_billing/zza:zza	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: aload_0
    //   48: getfield 222	com/android/billingclient/api/d:f	Landroid/content/Context;
    //   51: aload_0
    //   52: getfield 500	com/android/billingclient/api/d:h	Lcom/android/billingclient/api/v;
    //   55: invokevirtual 510	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   58: aload_0
    //   59: aconst_null
    //   60: putfield 500	com/android/billingclient/api/d:h	Lcom/android/billingclient/api/v;
    //   63: aload_0
    //   64: aconst_null
    //   65: putfield 281	com/android/billingclient/api/d:g	Lcom/google/android/gms/internal/play_billing/zzd;
    //   68: aload_0
    //   69: getfield 152	com/android/billingclient/api/d:u	Ljava/util/concurrent/ExecutorService;
    //   72: astore_1
    //   73: aload_1
    //   74: ifnull +15 -> 89
    //   77: aload_1
    //   78: invokeinterface 514 1 0
    //   83: pop
    //   84: aload_0
    //   85: aconst_null
    //   86: putfield 152	com/android/billingclient/api/d:u	Ljava/util/concurrent/ExecutorService;
    //   89: aload_0
    //   90: iconst_3
    //   91: putfield 41	com/android/billingclient/api/d:a	I
    //   94: return
    //   95: astore_1
    //   96: goto +55 -> 151
    //   99: astore_1
    //   100: aload_1
    //   101: invokestatic 187	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   104: astore_2
    //   105: aload_2
    //   106: invokevirtual 193	java/lang/String:length	()I
    //   109: istore_3
    //   110: new 189	java/lang/StringBuilder
    //   113: astore_1
    //   114: aload_1
    //   115: iload_3
    //   116: bipush 48
    //   118: iadd
    //   119: invokespecial 196	java/lang/StringBuilder:<init>	(I)V
    //   122: aload_1
    //   123: ldc_w 516
    //   126: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload_1
    //   131: aload_2
    //   132: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: ldc -52
    //   138: aload_1
    //   139: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokestatic 212	com/google/android/gms/internal/play_billing/zza:zzb	(Ljava/lang/String;Ljava/lang/String;)V
    //   145: aload_0
    //   146: iconst_3
    //   147: putfield 41	com/android/billingclient/api/d:a	I
    //   150: return
    //   151: aload_0
    //   152: iconst_3
    //   153: putfield 41	com/android/billingclient/api/d:a	I
    //   156: aload_1
    //   157: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	this	d
    //   16	62	1	localObject1	Object
    //   95	1	1	localObject2	Object
    //   99	2	1	localException	Exception
    //   113	44	1	localStringBuilder	StringBuilder
    //   104	28	2	str	String
    //   109	10	3	i1	int
    // Exception table:
    //   from	to	target	type
    //   0	17	95	finally
    //   21	25	95	finally
    //   25	63	95	finally
    //   63	73	95	finally
    //   77	89	95	finally
    //   100	145	95	finally
    //   0	17	99	java/lang/Exception
    //   21	25	99	java/lang/Exception
    //   25	63	99	java/lang/Exception
    //   63	73	99	java/lang/Exception
    //   77	89	99	java/lang/Exception
  }
  
  public final g d(String paramString)
  {
    if (!e()) {
      return y.q;
    }
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 1987365622: 
      if (paramString.equals("subscriptions")) {
        i1 = 0;
      }
      break;
    case 1219490065: 
      if (paramString.equals("subscriptionsOnVr")) {
        i1 = 3;
      }
      break;
    case 292218239: 
      if (paramString.equals("inAppItemsOnVr")) {
        i1 = 2;
      }
      break;
    case 207616302: 
      if (paramString.equals("priceChangeConfirmation")) {
        i1 = 4;
      }
      break;
    case 100293: 
      if (paramString.equals("eee")) {
        i1 = 9;
      }
      break;
    case 99300: 
      if (paramString.equals("ddd")) {
        i1 = 7;
      }
      break;
    case 98307: 
      if (paramString.equals("ccc")) {
        i1 = 8;
      }
      break;
    case 97314: 
      if (paramString.equals("bbb")) {
        i1 = 5;
      }
      break;
    case 96321: 
      if (paramString.equals("aaa")) {
        i1 = 6;
      }
      break;
    case -422092961: 
      if (paramString.equals("subscriptionsUpdate")) {
        i1 = 1;
      }
      break;
    }
    int i1 = -1;
    switch (i1)
    {
    default: 
      if (paramString.length() != 0) {
        paramString = "Unsupported feature: ".concat(paramString);
      }
      break;
    case 8: 
    case 9: 
      if (this.s) {
        paramString = y.p;
      } else {
        paramString = y.i;
      }
      return paramString;
    case 7: 
      if (this.q) {
        paramString = y.p;
      } else {
        paramString = y.i;
      }
      return paramString;
    case 6: 
      if (this.r) {
        paramString = y.p;
      } else {
        paramString = y.i;
      }
      return paramString;
    case 5: 
      if (this.p) {
        paramString = y.p;
      } else {
        paramString = y.i;
      }
      return paramString;
    case 4: 
      if (this.m) {
        paramString = y.p;
      } else {
        paramString = y.i;
      }
      return paramString;
    case 3: 
      return l("subs");
    case 2: 
      return l("inapp");
    case 1: 
      if (this.j) {
        paramString = y.p;
      } else {
        paramString = y.i;
      }
      return paramString;
    case 0: 
      if (this.i) {
        paramString = y.p;
      } else {
        paramString = y.i;
      }
      return paramString;
    }
    paramString = new String("Unsupported feature: ");
    zza.zzb("BillingClient", paramString);
    return y.v;
  }
  
  public final boolean e()
  {
    return (this.a == 2) && (this.g != null) && (this.h != null);
  }
  
  public final g f(Activity paramActivity, f paramf)
  {
    String str1 = "BUY_INTENT";
    if (!e())
    {
      paramActivity = y.q;
      L(paramActivity);
      return paramActivity;
    }
    ArrayList localArrayList1 = paramf.f();
    SkuDetails localSkuDetails1 = (SkuDetails)localArrayList1.get(0);
    String str2 = localSkuDetails1.l();
    if ((str2.equals("subs")) && (!this.i))
    {
      zza.zzb("BillingClient", "Current client doesn't support subscriptions.");
      paramActivity = y.s;
      L(paramActivity);
      return paramActivity;
    }
    Object localObject1 = paramf.a();
    if ((localObject1 != null) && (!this.j))
    {
      zza.zzb("BillingClient", "Current client doesn't support subscriptions update.");
      paramActivity = y.t;
      L(paramActivity);
      return paramActivity;
    }
    if ((paramf.h()) && (!this.l))
    {
      zza.zzb("BillingClient", "Current client doesn't support extra params for buy intent.");
      paramActivity = y.h;
      L(paramActivity);
      return paramActivity;
    }
    if ((localArrayList1.size() > 1) && (!this.s))
    {
      zza.zzb("BillingClient", "Current client doesn't support multi-item purchases.");
      paramActivity = y.u;
      L(paramActivity);
      return paramActivity;
    }
    Object localObject2 = "";
    Object localObject3 = "";
    Object localObject6;
    for (int i1 = 0; i1 < localArrayList1.size(); i1++)
    {
      localObject3 = String.valueOf(localObject3);
      localObject4 = String.valueOf(localArrayList1.get(i1));
      localObject6 = new StringBuilder(((String)localObject3).length() + ((String)localObject4).length());
      ((StringBuilder)localObject6).append((String)localObject3);
      ((StringBuilder)localObject6).append((String)localObject4);
      localObject4 = ((StringBuilder)localObject6).toString();
      localObject3 = localObject4;
      if (i1 < localArrayList1.size() - 1) {
        localObject3 = String.valueOf(localObject4).concat(", ");
      }
    }
    Object localObject4 = new StringBuilder(String.valueOf(localObject3).length() + 41 + str2.length());
    ((StringBuilder)localObject4).append("Constructing buy intent for ");
    ((StringBuilder)localObject4).append((String)localObject3);
    ((StringBuilder)localObject4).append(", item type: ");
    ((StringBuilder)localObject4).append(str2);
    zza.zza("BillingClient", ((StringBuilder)localObject4).toString());
    if (this.l)
    {
      localObject1 = zza.zzg(paramf, this.n, this.t, this.b);
      localObject6 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      ArrayList localArrayList4 = new ArrayList();
      int i2 = localArrayList1.size();
      int i3 = 0;
      boolean bool = false;
      int i4 = 0;
      i1 = 0;
      Object localObject5;
      while (i3 < i2)
      {
        SkuDetails localSkuDetails2 = (SkuDetails)localArrayList1.get(i3);
        if (!localSkuDetails2.n().isEmpty()) {
          ((ArrayList)localObject6).add(localSkuDetails2.n());
        }
        String str3 = localSkuDetails2.e();
        try
        {
          localObject4 = new org/json/JSONObject;
          ((JSONObject)localObject4).<init>(str3);
          localObject4 = ((JSONObject)localObject4).optString("offer_id_token");
        }
        catch (JSONException localJSONException)
        {
          localObject5 = localObject2;
        }
        str3 = localSkuDetails2.o();
        int i5 = localSkuDetails2.p();
        localArrayList2.add(localObject5);
        bool |= TextUtils.isEmpty((CharSequence)localObject5) ^ true;
        localArrayList3.add(str3);
        int i6 = i4 | TextUtils.isEmpty(str3) ^ true;
        localArrayList4.add(Integer.valueOf(i5));
        if (i5 != 0) {
          i4 = 1;
        } else {
          i4 = 0;
        }
        i1 |= i4;
        i3++;
        i4 = i6;
      }
      if (!((ArrayList)localObject6).isEmpty()) {
        ((Bundle)localObject1).putStringArrayList("skuDetailsTokens", (ArrayList)localObject6);
      }
      if (bool)
      {
        if (!this.q)
        {
          paramActivity = y.i;
          L(paramActivity);
          return paramActivity;
        }
        ((Bundle)localObject1).putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", localArrayList2);
      }
      if (i4 != 0) {
        ((Bundle)localObject1).putStringArrayList("SKU_OFFER_ID_LIST", localArrayList3);
      }
      if (i1 != 0) {
        ((Bundle)localObject1).putIntegerArrayList("SKU_OFFER_TYPE_LIST", localArrayList4);
      }
      if (!TextUtils.isEmpty(localSkuDetails1.m()))
      {
        ((Bundle)localObject1).putString("skuPackageName", localSkuDetails1.m());
        i1 = 1;
      }
      else
      {
        i1 = 0;
      }
      if (!TextUtils.isEmpty(null)) {
        ((Bundle)localObject1).putString("accountName", null);
      }
      if (localArrayList1.size() > 1)
      {
        localObject2 = new ArrayList(localArrayList1.size() - 1);
        localObject5 = new ArrayList(localArrayList1.size() - 1);
        for (i2 = 1; i2 < localArrayList1.size(); i2++)
        {
          ((ArrayList)localObject2).add(((SkuDetails)localArrayList1.get(i2)).i());
          ((ArrayList)localObject5).add(((SkuDetails)localArrayList1.get(i2)).l());
        }
        ((Bundle)localObject1).putStringArrayList("additionalSkus", (ArrayList)localObject2);
        ((Bundle)localObject1).putStringArrayList("additionalSkuTypes", (ArrayList)localObject5);
      }
      if (!TextUtils.isEmpty(paramActivity.getIntent().getStringExtra("PROXY_PACKAGE")))
      {
        localObject2 = paramActivity.getIntent().getStringExtra("PROXY_PACKAGE");
        ((Bundle)localObject1).putString("proxyPackage", (String)localObject2);
        try
        {
          ((Bundle)localObject1).putString("proxyPackageVersion", this.f.getPackageManager().getPackageInfo((String)localObject2, 0).versionName);
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          ((Bundle)localObject1).putString("proxyPackageVersion", "package not found");
        }
      }
      if ((this.r) && (i1 != 0)) {
        i1 = 15;
      } else if (this.n) {
        i1 = 9;
      } else if (paramf.d()) {
        i1 = 7;
      } else {
        i1 = 6;
      }
      paramf = M(new y0(this, i1, localSkuDetails1, str2, paramf, (Bundle)localObject1), 5000L, null);
    }
    else
    {
      str1 = "BUY_INTENT";
      if (localObject1 != null) {
        paramf = M(new z0(this, paramf, localSkuDetails1), 5000L, null);
      } else {
        paramf = M(new o(this, localSkuDetails1, str2), 5000L, null);
      }
    }
    try
    {
      Bundle localBundle = (Bundle)paramf.get(5000L, TimeUnit.MILLISECONDS);
      i1 = zza.zzd(localBundle, "BillingClient");
      paramf = zza.zze(localBundle, "BillingClient");
      if (i1 != 0)
      {
        paramActivity = new java/lang/StringBuilder;
        paramActivity.<init>(52);
        paramActivity.append("Unable to buy item, Error response code: ");
        paramActivity.append(i1);
        zza.zzb("BillingClient", paramActivity.toString());
        paramActivity = g.b();
        paramActivity.c(i1);
        paramActivity.b(paramf);
        paramActivity = paramActivity.a();
        L(paramActivity);
        return paramActivity;
      }
      paramf = new android/content/Intent;
      paramf.<init>(paramActivity, ProxyBillingActivity.class);
      paramf.putExtra(str1, (PendingIntent)localBundle.getParcelable(str1));
      paramActivity.startActivity(paramf);
      return y.p;
    }
    catch (Exception paramActivity)
    {
      paramActivity = new StringBuilder(String.valueOf(localObject3).length() + 69);
      paramActivity.append("Exception while launching billing flow: ; for sku: ");
      paramActivity.append((String)localObject3);
      paramActivity.append("; try to reconnect");
      zza.zzb("BillingClient", paramActivity.toString());
      paramActivity = y.q;
      L(paramActivity);
      return paramActivity;
    }
    catch (TimeoutException|CancellationException paramActivity)
    {
      paramActivity = new StringBuilder(String.valueOf(localObject3).length() + 68);
      paramActivity.append("Time out while launching billing flow: ; for sku: ");
      paramActivity.append((String)localObject3);
      paramActivity.append("; try to reconnect");
      zza.zzb("BillingClient", paramActivity.toString());
      paramActivity = y.r;
      L(paramActivity);
    }
    return paramActivity;
  }
  
  public final Purchase.a h(String paramString)
  {
    if (!e()) {
      return new Purchase.a(y.q, null);
    }
    if (TextUtils.isEmpty(paramString))
    {
      zza.zzb("BillingClient", "Please provide a valid SKU type.");
      return new Purchase.a(y.g, null);
    }
    paramString = M(new p(this, paramString), 5000L, null);
    try
    {
      paramString = (Purchase.a)paramString.get(5000L, TimeUnit.MILLISECONDS);
      return paramString;
    }
    catch (Exception paramString)
    {
      return new Purchase.a(y.l, null);
    }
    catch (TimeoutException|CancellationException paramString) {}
    return new Purchase.a(y.r, null);
  }
  
  public final void i(l paraml, m paramm)
  {
    if (!e())
    {
      paramm.a(y.q, null);
      return;
    }
    String str1 = paraml.a();
    Object localObject = paraml.b();
    if (TextUtils.isEmpty(str1))
    {
      zza.zzb("BillingClient", "Please fix the input params. SKU type can't be empty.");
      paramm.a(y.g, null);
      return;
    }
    if (localObject != null)
    {
      paraml = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str2 = (String)((Iterator)localObject).next();
        e0 locale0 = new e0(null);
        locale0.a(str2);
        paraml.add(locale0.b());
      }
      if (M(new r(this, str1, paraml, null, paramm), 30000L, new k0(this, paramm)) == null) {
        paramm.a(n(), null);
      }
      return;
    }
    zza.zzb("BillingClient", "Please fix the input params. The list of SKUs can't be empty - set SKU list or SkuWithOffer list.");
    paramm.a(y.f, null);
  }
  
  public final void j(e parame)
  {
    if (e())
    {
      zza.zza("BillingClient", "Service connection is valid. No need to re-initialize.");
      parame.a(y.p);
      return;
    }
    int i1 = this.a;
    if (i1 == 1)
    {
      zza.zzb("BillingClient", "Client is already in the process of connecting to billing service.");
      parame.a(y.d);
      return;
    }
    if (i1 == 3)
    {
      zza.zzb("BillingClient", "Client was already closed and can't be reused. Please create another instance.");
      parame.a(y.q);
      return;
    }
    this.a = 1;
    this.d.a();
    zza.zza("BillingClient", "Starting in-app billing setup.");
    this.h = new v(this, parame, null);
    Intent localIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
    localIntent.setPackage("com.android.vending");
    Object localObject1 = this.f.getPackageManager().queryIntentServices(localIntent, 0);
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      Object localObject2 = ((ResolveInfo)((List)localObject1).get(0)).serviceInfo;
      if (localObject2 != null)
      {
        localObject1 = ((ServiceInfo)localObject2).packageName;
        localObject2 = ((ServiceInfo)localObject2).name;
        if (("com.android.vending".equals(localObject1)) && (localObject2 != null))
        {
          localObject1 = new ComponentName((String)localObject1, (String)localObject2);
          localIntent = new Intent(localIntent);
          localIntent.setComponent((ComponentName)localObject1);
          localIntent.putExtra("playBillingLibraryVersion", this.b);
          if (this.f.bindService(localIntent, this.h, 1))
          {
            zza.zza("BillingClient", "Service was bonded successfully.");
            return;
          }
          zza.zzb("BillingClient", "Connection to Billing service is blocked.");
        }
        else
        {
          zza.zzb("BillingClient", "The device doesn't have valid Play Store.");
        }
      }
    }
    this.a = 0;
    zza.zza("BillingClient", "Billing service unavailable on device.");
    parame.a(y.c);
  }
  
  @VisibleForTesting
  final b0 o(String paramString1, List<f0> paramList, @Nullable String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    int i1 = paramList.size();
    int i2 = 0;
    while (i2 < i1)
    {
      int i3 = i2 + 20;
      if (i3 > i1) {
        i4 = i1;
      } else {
        i4 = i3;
      }
      Object localObject1 = new ArrayList(paramList.subList(i2, i4));
      Object localObject2 = new ArrayList();
      int i4 = ((List)localObject1).size();
      for (i2 = 0; i2 < i4; i2++) {
        ((ArrayList)localObject2).add(((f0)((List)localObject1).get(i2)).a());
      }
      paramString2 = new Bundle();
      paramString2.putStringArrayList("ITEM_ID_LIST", (ArrayList)localObject2);
      paramString2.putString("playBillingLibraryVersion", this.b);
      try
      {
        if (this.o) {
          paramString2 = this.g.zzm(10, this.f.getPackageName(), paramString1, paramString2, zza.zzi(this.k, this.t, this.b, null, (ArrayList)localObject1));
        } else {
          paramString2 = this.g.zzb(3, this.f.getPackageName(), paramString1, paramString2);
        }
        if (paramString2 == null)
        {
          zza.zzb("BillingClient", "querySkuDetailsAsync got null sku details list");
          return new b0(4, "Item is unavailable for purchase.", null);
        }
        if (!paramString2.containsKey("DETAILS_LIST"))
        {
          i3 = zza.zzd(paramString2, "BillingClient");
          paramList = zza.zze(paramString2, "BillingClient");
          if (i3 != 0)
          {
            paramString1 = new StringBuilder(50);
            paramString1.append("getSkuDetails() failed. Response code: ");
            paramString1.append(i3);
            zza.zzb("BillingClient", paramString1.toString());
            return new b0(i3, paramList, localArrayList);
          }
          zza.zzb("BillingClient", "getSkuDetails() returned a bundle with neither an error nor a detail list.");
          return new b0(6, paramList, localArrayList);
        }
        paramString2 = paramString2.getStringArrayList("DETAILS_LIST");
        if (paramString2 != null)
        {
          i2 = 0;
          while (i2 < paramString2.size())
          {
            localObject1 = (String)paramString2.get(i2);
            try
            {
              SkuDetails localSkuDetails = new SkuDetails((String)localObject1);
              localObject2 = String.valueOf(localSkuDetails);
              localObject1 = new StringBuilder(((String)localObject2).length() + 17);
              ((StringBuilder)localObject1).append("Got sku details: ");
              ((StringBuilder)localObject1).append((String)localObject2);
              zza.zza("BillingClient", ((StringBuilder)localObject1).toString());
              localArrayList.add(localSkuDetails);
              i2++;
            }
            catch (JSONException paramString1)
            {
              zza.zzb("BillingClient", "Got a JSON exception trying to decode SkuDetails.");
              return new b0(6, "Error trying to decode SkuDetails.", null);
            }
          }
          i2 = i3;
        }
        else
        {
          zza.zzb("BillingClient", "querySkuDetailsAsync got null response list");
          return new b0(4, "Item is unavailable for purchase.", null);
        }
      }
      catch (Exception paramString1)
      {
        paramList = String.valueOf(paramString1);
        paramString1 = new StringBuilder(paramList.length() + 63);
        paramString1.append("querySkuDetailsAsync got a remote exception (try to reconnect).");
        paramString1.append(paramList);
        zza.zzb("BillingClient", paramString1.toString());
        return new b0(-1, "Service connection is disconnected.", null);
      }
    }
    return new b0(0, "", localArrayList);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\android\billingclient\api\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */