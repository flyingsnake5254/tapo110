package com.tplink.iot.dailysummary.viewmodel;

import android.app.Application;
import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.tplink.iot.dailysummary.network.DailySummaryRepository;
import com.tplink.iot.dailysummary.network.bean.common.Summary;
import com.tplink.iot.dailysummary.network.bean.common.SummaryClip;
import com.tplink.iot.dailysummary.network.bean.common.SummaryVideo;
import com.tplink.iot.dailysummary.network.bean.params.CreateSummaryParams;
import com.tplink.iot.dailysummary.network.bean.result.SummaryClipInfoResult;
import com.tplink.iot.dailysummary.network.bean.result.SummaryEventIdResult;
import com.tplink.iot.dailysummary.network.bean.result.SummaryResult;
import com.tplink.iot.e.a.e;
import com.tplink.iot.h.f;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.Utils.d0;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import io.reactivex.q;
import io.reactivex.r;
import io.reactivex.s;
import io.reactivex.v;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.jvm.internal.j;
import kotlin.text.m;

public final class SummaryPlayViewModel
  extends BaseSummaryListViewModel
{
  public static final a n = new a(null);
  private final MutableLiveData<List<SummaryClip>> A;
  private final MutableLiveData<ArrayList<Long>> B;
  private final MutableLiveData<Boolean> C;
  private final MutableLiveData<String> D;
  private final LiveData<ArrayList<com.tplink.iot.view.ipcamera.widget.calendar.d>> E;
  private final MutableLiveData<String> F;
  private final MutableLiveData<Boolean> G;
  private final MutableLiveData<Boolean> H;
  private final MutableLiveData<Boolean> I;
  private final MutableLiveData<Boolean> J;
  private final MutableLiveData<Boolean> K;
  private final MutableLiveData<Boolean> L;
  private final MutableLiveData<Boolean> M;
  private final MutableLiveData<com.tplink.iot.dailysummary.model.b> N;
  private final MutableLiveData<SummaryVideo> O;
  private final MutableLiveData<LinkedList<com.tplink.iot.dailysummary.model.c>> P;
  private final MutableLiveData<Long> Q;
  private final MutableLiveData<Boolean> R;
  private final MutableLiveData<Boolean> S;
  private final MutableLiveData<Boolean> T;
  private final MutableLiveData<Boolean> U;
  private final MutableLiveData<Long> V;
  private final MutableLiveData<Long> W;
  private final LiveData<String> X;
  private final MutableLiveData<Boolean> Y;
  private final MutableLiveData<String> Z;
  private final MutableLiveData<Integer> a0;
  private ALCameraDevice o;
  private f p;
  private io.reactivex.e0.c q;
  private String r = "";
  private String s = "";
  private int t;
  private long u;
  private boolean v = true;
  private final com.tplink.iot.dailysummary.model.b w = new com.tplink.iot.dailysummary.model.b("", 100, "", null, 0, false, false, 120, null);
  private final com.tplink.iot.dailysummary.model.b x = new com.tplink.iot.dailysummary.model.b("", -6, "", null, 0, false, false, 120, null);
  private final MutableLiveData<com.tplink.iot.dailysummary.model.d> y;
  private final MutableLiveData<Integer> z;
  
  public SummaryPlayViewModel(Application paramApplication)
  {
    super(paramApplication);
    paramApplication = new MutableLiveData();
    this.y = paramApplication;
    this.z = new MutableLiveData();
    this.A = new MutableLiveData();
    this.B = new MutableLiveData();
    this.C = new MutableLiveData();
    this.D = new MutableLiveData();
    Object localObject1 = Transformations.map(y(), l.a);
    j.d(localObject1, "Transformations.map(mSum…       markDaysList\n    }");
    this.E = ((LiveData)localObject1);
    this.F = new MutableLiveData();
    this.G = new MutableLiveData();
    this.H = new MutableLiveData();
    this.I = new MutableLiveData();
    this.J = new MutableLiveData();
    this.K = new MutableLiveData();
    this.L = new MutableLiveData();
    this.M = new MutableLiveData();
    this.N = new MutableLiveData();
    this.O = new MutableLiveData();
    localObject1 = new MutableLiveData();
    this.P = ((MutableLiveData)localObject1);
    this.Q = new MutableLiveData();
    this.R = new MutableLiveData();
    this.S = new MutableLiveData();
    this.T = new MutableLiveData();
    this.U = new MutableLiveData();
    this.V = new MutableLiveData();
    Object localObject2 = new MutableLiveData();
    this.W = ((MutableLiveData)localObject2);
    localObject2 = Transformations.map((LiveData)localObject2, f.a);
    j.d(localObject2, "Transformations.map(mDis…it / 1000).toInt())\n    }");
    this.X = ((LiveData)localObject2);
    this.Y = new MutableLiveData();
    this.Z = new MutableLiveData();
    this.a0 = new MutableLiveData();
    if (t() == null) {
      G((DailySummaryRepository)b.d.b.f.b.a(b.d.s.a.a.f(), DailySummaryRepository.class));
    }
    paramApplication.setValue(com.tplink.iot.e.a.c.k.j());
    ((MutableLiveData)localObject1).setValue(new LinkedList());
  }
  
  private final void P0()
  {
    Object localObject1 = com.tplink.iot.e.a.c.k;
    F(((com.tplink.iot.e.a.c)localObject1).b());
    Object localObject2 = b.d.w.h.a.g(s());
    if ((localObject2 != null) && (!TextUtils.isEmpty((CharSequence)localObject2)))
    {
      localObject2 = TPIoTClientManager.K1((String)localObject2);
      j.d(localObject2, "TPIoTClientManager.getCameraContext(md5String)");
      localObject2 = (ALCameraDevice)((TPBaseDeviceContext)localObject2).getCameraDevice();
      if ((localObject2 != null) && (!d0.a(this.o, localObject2))) {
        this.o = ((ALCameraDevice)localObject2);
      }
    }
    localObject2 = r();
    localObject1 = (Boolean)((com.tplink.iot.e.a.c)localObject1).e().get(s());
    boolean bool;
    if (localObject1 != null) {
      bool = ((Boolean)localObject1).booleanValue();
    } else {
      bool = false;
    }
    ((MutableLiveData)localObject2).setValue(Boolean.valueOf(bool));
  }
  
  private final void R0()
  {
    this.t = 0;
    Long localLong = Long.valueOf(0L);
    this.u = 0L;
    MutableLiveData localMutableLiveData = this.R;
    Boolean localBoolean = Boolean.FALSE;
    localMutableLiveData.setValue(localBoolean);
    this.S.setValue(localBoolean);
    this.U.setValue(localBoolean);
    this.Q.setValue(localLong);
    this.L.setValue(localBoolean);
    this.V.setValue(localLong);
  }
  
  /* Error */
  private final boolean W(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 349	android/graphics/Bitmap:isRecycled	()Z
    //   4: istore_2
    //   5: iconst_0
    //   6: istore_3
    //   7: iload_2
    //   8: ifeq +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: invokestatic 355	java/lang/System:currentTimeMillis	()J
    //   16: invokestatic 360	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   19: astore 4
    //   21: new 362	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 363	java/lang/StringBuilder:<init>	()V
    //   28: astore 5
    //   30: aload 5
    //   32: invokestatic 368	b/d/q/b/p/b:h	()Ljava/lang/String;
    //   35: invokevirtual 372	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: getstatic 377	java/io/File:separator	Ljava/lang/String;
    //   42: astore 6
    //   44: aload 5
    //   46: aload 6
    //   48: invokevirtual 372	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: aload 5
    //   54: ldc_w 379
    //   57: invokevirtual 372	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload 5
    //   63: aload 6
    //   65: invokevirtual 372	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload 5
    //   71: aload 4
    //   73: invokevirtual 372	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload 5
    //   79: ldc_w 381
    //   82: invokevirtual 372	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload 5
    //   88: invokevirtual 384	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: astore 6
    //   93: aload_0
    //   94: getfield 258	com/tplink/iot/dailysummary/viewmodel/SummaryPlayViewModel:o	Lcom/tplink/libtpnetwork/cameranetwork/bean/ALCameraDevice;
    //   97: aload 4
    //   99: aload 6
    //   101: iconst_m1
    //   102: invokestatic 387	b/d/q/b/p/b:u	(Lcom/tplink/libtpnetwork/cameranetwork/bean/ALCameraDevice;Ljava/lang/String;Ljava/lang/String;I)V
    //   105: new 389	java/io/FileOutputStream
    //   108: dup
    //   109: new 374	java/io/File
    //   112: dup
    //   113: aload 6
    //   115: invokespecial 391	java/io/File:<init>	(Ljava/lang/String;)V
    //   118: invokespecial 394	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   121: astore 4
    //   123: aload_1
    //   124: getstatic 400	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   127: bipush 90
    //   129: aload 4
    //   131: invokevirtual 404	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   134: pop
    //   135: aload 4
    //   137: invokevirtual 407	java/io/FileOutputStream:flush	()V
    //   140: aload 4
    //   142: invokevirtual 410	java/io/FileOutputStream:close	()V
    //   145: aload 4
    //   147: invokevirtual 410	java/io/FileOutputStream:close	()V
    //   150: iconst_1
    //   151: istore_3
    //   152: goto +51 -> 203
    //   155: astore_1
    //   156: goto +49 -> 205
    //   159: astore_1
    //   160: new 362	java/lang/StringBuilder
    //   163: astore_1
    //   164: aload_1
    //   165: invokespecial 363	java/lang/StringBuilder:<init>	()V
    //   168: aload_1
    //   169: ldc_w 412
    //   172: invokevirtual 372	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload_1
    //   177: aload_0
    //   178: invokevirtual 418	java/lang/Object:getClass	()Ljava/lang/Class;
    //   181: invokevirtual 423	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   184: invokevirtual 372	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: ldc_w 425
    //   191: aload_1
    //   192: invokevirtual 384	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokestatic 431	b/d/w/c/a:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   198: aload 4
    //   200: invokevirtual 410	java/io/FileOutputStream:close	()V
    //   203: iload_3
    //   204: ireturn
    //   205: aload 4
    //   207: invokevirtual 410	java/io/FileOutputStream:close	()V
    //   210: aload_1
    //   211: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	212	0	this	SummaryPlayViewModel
    //   0	212	1	paramBitmap	Bitmap
    //   4	4	2	bool1	boolean
    //   6	198	3	bool2	boolean
    //   19	187	4	localObject	Object
    //   28	59	5	localStringBuilder	StringBuilder
    //   42	72	6	str	String
    // Exception table:
    //   from	to	target	type
    //   123	145	155	finally
    //   160	198	155	finally
    //   123	145	159	java/lang/Exception
  }
  
  private final boolean Z()
  {
    Object localObject1 = (String)this.D.getValue();
    boolean bool1 = false;
    boolean bool2 = bool1;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("summary_");
      ((StringBuilder)localObject2).append(s());
      ((StringBuilder)localObject2).append('_');
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(".mp4");
      this.r = ((StringBuilder)localObject2).toString();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(b.d.q.b.p.b.h());
      localObject2 = File.separator;
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("cloudvideo");
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("download");
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(this.r);
      this.s = ((StringBuilder)localObject1).toString();
    }
    try
    {
      localObject2 = new java/io/File;
      ((File)localObject2).<init>(this.s);
      bool2 = ((File)localObject2).exists();
      return bool2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        bool2 = bool1;
      }
    }
  }
  
  private final void c0()
  {
    final String str = (String)this.D.getValue();
    if (str != null)
    {
      CreateSummaryParams localCreateSummaryParams = new CreateSummaryParams();
      localCreateSummaryParams.setDate(str);
      localCreateSummaryParams.setDeviceId(s());
      DailySummaryRepository localDailySummaryRepository = t();
      if (localDailySummaryRepository != null) {
        localDailySummaryRepository.E(localCreateSummaryParams).H0(new d(localCreateSummaryParams, str, this), e.c);
      }
    }
  }
  
  private final void j0()
  {
    DailySummaryRepository localDailySummaryRepository = t();
    if (localDailySummaryRepository != null)
    {
      String str = (String)this.D.getValue();
      if (str != null)
      {
        Object localObject = this.q;
        if (localObject != null) {
          ((io.reactivex.e0.c)localObject).dispose();
        }
        localObject = s();
        j.d(str, "it");
        this.q = localDailySummaryRepository.I((String)localObject, str).H0(new h(localDailySummaryRepository, this), new i(localDailySummaryRepository, this));
      }
    }
  }
  
  public final MutableLiveData<String> A0()
  {
    return this.Z;
  }
  
  public final MutableLiveData<Boolean> B0()
  {
    return this.G;
  }
  
  public final MutableLiveData<Boolean> C0()
  {
    return this.M;
  }
  
  public final MutableLiveData<Boolean> D0()
  {
    return this.L;
  }
  
  public final MutableLiveData<Integer> E0()
  {
    return this.z;
  }
  
  public final MutableLiveData<Boolean> F0()
  {
    return this.C;
  }
  
  public final MutableLiveData<List<SummaryClip>> G0()
  {
    return this.A;
  }
  
  public final MutableLiveData<ArrayList<Long>> H0()
  {
    return this.B;
  }
  
  public final MutableLiveData<Long> I0()
  {
    return this.Q;
  }
  
  public final MutableLiveData<com.tplink.iot.dailysummary.model.b> J0()
  {
    return this.N;
  }
  
  public final LiveData<ArrayList<com.tplink.iot.view.ipcamera.widget.calendar.d>> K0()
  {
    return this.E;
  }
  
  public final MutableLiveData<LinkedList<com.tplink.iot.dailysummary.model.c>> L0()
  {
    return this.P;
  }
  
  public final MutableLiveData<SummaryVideo> M0()
  {
    return this.O;
  }
  
  public final void N0()
  {
    final String str1 = s();
    final String str2 = (String)this.D.getValue();
    final Object localObject = (com.tplink.iot.dailysummary.model.b)this.N.getValue();
    if (localObject != null) {
      localObject = ((com.tplink.iot.dailysummary.model.b)localObject).l();
    } else {
      localObject = null;
    }
    if ((str2 != null) && (localObject != null) && (str1.length() != 0) && (str2.length() != 0) && (((String)localObject).length() != 0))
    {
      DailySummaryRepository localDailySummaryRepository = t();
      if (localDailySummaryRepository != null) {
        localDailySummaryRepository.J(str1, str2, (String)localObject).H0(new j(this, str1, str2, (String)localObject), k.c);
      }
    }
  }
  
  public final void O0()
  {
    P0();
    Q0();
    R0();
    T0();
  }
  
  public final void Q0()
  {
    this.z.setValue(Integer.valueOf(0));
    MutableLiveData localMutableLiveData = this.G;
    Boolean localBoolean = Boolean.FALSE;
    localMutableLiveData.setValue(localBoolean);
    this.K.setValue(localBoolean);
    this.J.setValue(localBoolean);
    this.M.setValue(localBoolean);
    this.V.setValue(Long.valueOf(0L));
  }
  
  public final void S0(long paramLong)
  {
    b1(paramLong);
  }
  
  public final void T0()
  {
    this.N.setValue(this.w);
    if ((String)this.D.getValue() != null) {
      j0();
    }
  }
  
  public final void U()
  {
    f localf = this.p;
    if (localf != null) {
      localf.y();
    }
  }
  
  public final void U0(int paramInt)
  {
    if (s().length() == 0) {
      F(com.tplink.iot.e.a.c.k.b());
    }
    if (j.a((Boolean)r().getValue(), Boolean.TRUE)) {
      for (;;)
      {
        com.tplink.iot.e.a.c localc = com.tplink.iot.e.a.c.k;
        if (localc.c() >= paramInt / 10 + 6) {
          break;
        }
        BaseSummaryListViewModel.E(this, s(), localc.a(), 10, false, 8, null);
      }
    }
    if (!com.tplink.iot.e.a.c.k.g()) {
      BaseSummaryListViewModel.B(this, s(), 30, false, 4, null);
    }
  }
  
  public final void V(final Bitmap paramBitmap)
  {
    j.e(paramBitmap, "bitmap");
    q.m(new b(this, paramBitmap)).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).a(new c(this));
  }
  
  public final void V0()
  {
    LinkedList localLinkedList = (LinkedList)this.P.getValue();
    if (localLinkedList != null)
    {
      Iterator localIterator = localLinkedList.iterator();
      while (localIterator.hasNext()) {
        ((com.tplink.iot.dailysummary.model.c)localIterator.next()).a().recycle();
      }
      localLinkedList.clear();
    }
  }
  
  public final void W0(int paramInt, long paramLong, boolean paramBoolean)
  {
    this.t = paramInt;
    this.u = paramLong;
    this.v = paramBoolean;
  }
  
  public final void X()
  {
    if (j.a((Boolean)this.R.getValue(), Boolean.TRUE))
    {
      boolean bool = false;
      Boolean localBoolean = (Boolean)this.M.getValue();
      if (localBoolean != null) {
        bool = localBoolean.booleanValue() ^ true;
      }
      this.M.setValue(Boolean.valueOf(bool));
    }
  }
  
  public final void X0(boolean paramBoolean)
  {
    this.I.setValue(Boolean.valueOf(paramBoolean));
  }
  
  public final void Y(boolean paramBoolean)
  {
    this.K.setValue(Boolean.valueOf(paramBoolean));
  }
  
  public final void Y0(boolean paramBoolean)
  {
    this.H.setValue(Boolean.valueOf(paramBoolean));
  }
  
  public final void Z0(String paramString)
  {
    j.e(paramString, "str");
    this.F.setValue(paramString);
  }
  
  public final void a0()
  {
    Boolean localBoolean = (Boolean)this.L.getValue();
    if ((localBoolean != null) && (j.a((Boolean)this.R.getValue(), Boolean.TRUE)))
    {
      this.L.setValue(Boolean.valueOf(localBoolean.booleanValue() ^ true));
      this.M.setValue(Boolean.valueOf(localBoolean.booleanValue() ^ true));
    }
  }
  
  public final void a1(com.tplink.iot.view.ipcamera.widget.calendar.d paramd)
  {
    j.e(paramd, "oneDayInfo");
    int i = paramd.e();
    int j = paramd.d();
    int k = paramd.c();
    paramd = kotlin.jvm.internal.p.a;
    paramd = String.format("%04d-%02d-%02d", Arrays.copyOf(new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) }, 3));
    j.d(paramd, "java.lang.String.format(format, *args)");
    this.D.setValue(paramd);
    T0();
  }
  
  public final void b0()
  {
    c0();
  }
  
  public final void b1(long paramLong)
  {
    this.W.setValue(Long.valueOf(paramLong));
  }
  
  public final void c1(long paramLong)
  {
    this.V.postValue(Long.valueOf(paramLong));
  }
  
  public final void d0(final boolean paramBoolean)
  {
    Object localObject1 = (SummaryVideo)this.O.getValue();
    if (localObject1 != null) {
      if (Z())
      {
        if (paramBoolean) {
          this.Z.setValue(this.s);
        } else {
          this.z.setValue(Integer.valueOf(4));
        }
      }
      else
      {
        j.d(localObject1, "it");
        final Object localObject2 = b.d.w.h.a.a(((SummaryVideo)localObject1).getM3u8());
        final String str = ((SummaryVideo)localObject1).getUri();
        localObject1 = new f("1000");
        ((f)localObject1).z(this.r, (String)localObject2, str, new g((f)localObject1, (String)localObject2, str, this, paramBoolean));
        localObject2 = kotlin.p.a;
        this.p = ((f)localObject1);
      }
    }
  }
  
  public final void d1(int paramInt)
  {
    this.t = paramInt;
  }
  
  public final MutableLiveData<Boolean> e0()
  {
    return this.I;
  }
  
  public final void e1(boolean paramBoolean)
  {
    MutableLiveData localMutableLiveData = this.U;
    if (paramBoolean)
    {
      com.tplink.iot.dailysummary.model.b localb = (com.tplink.iot.dailysummary.model.b)this.N.getValue();
      if ((localb != null) && (localb.j() == 2))
      {
        paramBoolean = true;
        break label39;
      }
    }
    paramBoolean = false;
    label39:
    localMutableLiveData.setValue(Boolean.valueOf(paramBoolean));
  }
  
  public final MutableLiveData<Boolean> f0()
  {
    return this.H;
  }
  
  public final void f1(boolean paramBoolean)
  {
    this.S.setValue(Boolean.valueOf(paramBoolean));
    if (paramBoolean)
    {
      g1(false);
      this.U.setValue(Boolean.FALSE);
    }
  }
  
  public final MutableLiveData<String> g0()
  {
    return this.F;
  }
  
  public final void g1(boolean paramBoolean)
  {
    this.R.setValue(Boolean.valueOf(paramBoolean));
    if (paramBoolean)
    {
      MutableLiveData localMutableLiveData = this.M;
      Boolean localBoolean = Boolean.TRUE;
      localMutableLiveData.setValue(localBoolean);
      this.L.setValue(localBoolean);
    }
  }
  
  public final MutableLiveData<Boolean> h0()
  {
    return this.Y;
  }
  
  public final void h1(long paramLong)
  {
    this.u = paramLong;
  }
  
  public final MutableLiveData<String> i0()
  {
    return this.D;
  }
  
  public final void i1(boolean paramBoolean)
  {
    this.T.postValue(Boolean.valueOf(paramBoolean));
  }
  
  public final void j1(boolean paramBoolean)
  {
    MutableLiveData localMutableLiveData = this.F;
    String str = (String)this.D.getValue();
    if (str != null) {
      str = m.v0(str, 3);
    } else {
      str = null;
    }
    localMutableLiveData.setValue(str);
    this.G.setValue(Boolean.valueOf(paramBoolean));
  }
  
  public final MutableLiveData<Long> k0()
  {
    return this.W;
  }
  
  public final void k1(int paramInt)
  {
    this.z.postValue(Integer.valueOf(paramInt));
    if (paramInt != 5)
    {
      if (paramInt == 6) {
        this.J.postValue(Boolean.TRUE);
      }
    }
    else
    {
      MutableLiveData localMutableLiveData = this.J;
      Boolean localBoolean = Boolean.FALSE;
      localMutableLiveData.postValue(localBoolean);
      this.C.postValue(localBoolean);
    }
  }
  
  public final LiveData<String> l0()
  {
    return this.X;
  }
  
  public final void l1(boolean paramBoolean)
  {
    this.C.setValue(Boolean.valueOf(paramBoolean));
  }
  
  public final MutableLiveData<Integer> m0()
  {
    return this.a0;
  }
  
  public final void m1(ArrayList<Long> paramArrayList)
  {
    j.e(paramArrayList, "splitPointList");
    this.B.setValue(paramArrayList);
  }
  
  public final com.tplink.iot.dailysummary.model.b n0()
  {
    return this.w;
  }
  
  public final void n1(long paramLong)
  {
    this.Q.setValue(Long.valueOf(paramLong));
  }
  
  public final com.tplink.iot.dailysummary.model.b o0()
  {
    return this.x;
  }
  
  public final void o1(LinkedList<com.tplink.iot.dailysummary.model.c> paramLinkedList)
  {
    j.e(paramLinkedList, "thumbnailList");
    this.P.setValue(paramLinkedList);
  }
  
  public final MutableLiveData<com.tplink.iot.dailysummary.model.d> p0()
  {
    return this.y;
  }
  
  public final MutableLiveData<Long> q0()
  {
    return this.V;
  }
  
  public final int r0()
  {
    return this.t;
  }
  
  public final MutableLiveData<Boolean> s0()
  {
    return this.U;
  }
  
  public final MutableLiveData<Boolean> t0()
  {
    return this.K;
  }
  
  public final MutableLiveData<Boolean> u0()
  {
    return this.J;
  }
  
  public final MutableLiveData<Boolean> v0()
  {
    return this.S;
  }
  
  public final boolean w0()
  {
    return this.v;
  }
  
  public final MutableLiveData<Boolean> x0()
  {
    return this.R;
  }
  
  public final long y0()
  {
    return this.u;
  }
  
  public final MutableLiveData<Boolean> z0()
  {
    return this.T;
  }
  
  public static final class a {}
  
  public static final class b
    implements s<Boolean>
  {
    b(Bitmap paramBitmap) {}
    
    public void subscribe(r<Boolean> paramr)
    {
      j.e(paramr, "emitter");
      paramr.onNext(Boolean.valueOf(SummaryPlayViewModel.H(this.a, paramBitmap)));
      paramr.onComplete();
    }
  }
  
  public static final class c
    implements v<Boolean>
  {
    c(SummaryPlayViewModel paramSummaryPlayViewModel) {}
    
    public void a(boolean paramBoolean)
    {
      SummaryPlayViewModel.J(this.c).setValue(Boolean.valueOf(paramBoolean));
    }
    
    public void onComplete() {}
    
    public void onError(Throwable paramThrowable)
    {
      j.e(paramThrowable, "e");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("capturePic failed: ");
      localStringBuilder.append(paramThrowable.getMessage());
      b.d.w.c.a.c("PlayViewModel-tyler", localStringBuilder.toString());
      SummaryPlayViewModel.J(this.c).setValue(Boolean.FALSE);
    }
    
    public void onSubscribe(io.reactivex.e0.c paramc)
    {
      j.e(paramc, "d");
    }
  }
  
  static final class d<T>
    implements io.reactivex.g0.g<SummaryEventIdResult>
  {
    d(CreateSummaryParams paramCreateSummaryParams, String paramString, SummaryPlayViewModel paramSummaryPlayViewModel) {}
    
    public final void a(SummaryEventIdResult paramSummaryEventIdResult)
    {
      HashMap localHashMap = jdField_this.u();
      String str = str;
      j.d(paramSummaryEventIdResult, "it");
      localHashMap.put(str, paramSummaryEventIdResult.getEventId());
      paramSummaryEventIdResult = (com.tplink.iot.dailysummary.model.b)SummaryPlayViewModel.R(jdField_this).getValue();
      if (paramSummaryEventIdResult != null) {
        paramSummaryEventIdResult.r(1);
      }
      SummaryPlayViewModel.R(jdField_this).setValue(SummaryPlayViewModel.R(jdField_this).getValue());
      SummaryPlayViewModel.I(jdField_this);
      paramSummaryEventIdResult = com.tplink.iot.e.a.c.k;
      paramSummaryEventIdResult.r(true);
      paramSummaryEventIdResult.o(true);
    }
  }
  
  static final class e<T>
    implements io.reactivex.g0.g<Throwable>
  {
    public static final e c = new e();
    
    public final void a(Throwable paramThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("create summary failed!\n");
      localStringBuilder.append(paramThrowable.getMessage());
      b.d.w.c.a.c("PlayViewModel-tyler", localStringBuilder.toString());
    }
  }
  
  static final class f<I, O>
    implements Function<Long, String>
  {
    public static final f a = new f();
    
    public final String a(Long paramLong)
    {
      return e.a.b((int)(paramLong.longValue() / 'Ϩ'));
    }
  }
  
  public static final class g
    implements com.tplink.iot.h.i.b
  {
    g(f paramf, String paramString1, String paramString2, SummaryPlayViewModel paramSummaryPlayViewModel, boolean paramBoolean) {}
    
    public void a(long paramLong1, long paramLong2, int paramInt)
    {
      f localf = SummaryPlayViewModel.M(jdField_this);
      if ((localf != null) && (localf.E() == true) && (paramLong1 > 0L)) {
        SummaryPlayViewModel.L(jdField_this).setValue(Integer.valueOf(Math.min((int)(100 * paramLong2 / paramLong1), 99)));
      }
    }
    
    public void b(int paramInt1, int paramInt2)
    {
      ALCameraDevice localALCameraDevice = SummaryPlayViewModel.K(jdField_this);
      if (localALCameraDevice != null)
      {
        b.d.q.b.p.b.u(localALCameraDevice, String.valueOf(System.currentTimeMillis()), this.a.B(), paramInt2);
        SummaryPlayViewModel.O(jdField_this).setValue(Integer.valueOf(2));
        if (paramBoolean) {
          SummaryPlayViewModel.N(jdField_this).setValue(SummaryPlayViewModel.Q(jdField_this));
        }
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      j.e(paramThrowable, "errorMsg");
      SummaryPlayViewModel.O(jdField_this).setValue(Integer.valueOf(3));
    }
    
    public void onStart()
    {
      SummaryPlayViewModel.O(jdField_this).setValue(Integer.valueOf(1));
    }
  }
  
  static final class h<T>
    implements io.reactivex.g0.g<SummaryResult>
  {
    h(DailySummaryRepository paramDailySummaryRepository, SummaryPlayViewModel paramSummaryPlayViewModel) {}
    
    public final void a(SummaryResult paramSummaryResult)
    {
      SummaryPlayViewModel.T(jdField_this);
      j.d(paramSummaryResult, "it");
      com.tplink.iot.dailysummary.model.b localb = com.tplink.iot.e.a.a.e(paramSummaryResult);
      if (localb != null)
      {
        paramSummaryResult = paramSummaryResult.getSummaryList().get(0);
        j.d(paramSummaryResult, "it.summaryList[0]");
        paramSummaryResult = ((Summary)paramSummaryResult).getVideo();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getSummaryByDate: \n");
        localStringBuilder.append("summaryItem = ");
        localStringBuilder.append(localb);
        localStringBuilder.append("\n ");
        localStringBuilder.append("summaryVideo = ");
        localStringBuilder.append(paramSummaryResult);
        b.d.w.c.a.c("PlayViewModel-tyler", localStringBuilder.toString());
        if ((!j.a((Boolean)jdField_this.r().getValue(), Boolean.TRUE)) && (localb.j() != 2)) {
          SummaryPlayViewModel.R(jdField_this).setValue(jdField_this.o0());
        } else {
          SummaryPlayViewModel.R(jdField_this).setValue(localb);
        }
        SummaryPlayViewModel.S(jdField_this).setValue(paramSummaryResult);
      }
      else
      {
        SummaryPlayViewModel.R(jdField_this).setValue(jdField_this.o0());
      }
    }
  }
  
  static final class i<T>
    implements io.reactivex.g0.g<Throwable>
  {
    i(DailySummaryRepository paramDailySummaryRepository, SummaryPlayViewModel paramSummaryPlayViewModel) {}
    
    public final void a(Throwable paramThrowable)
    {
      SummaryPlayViewModel.R(jdField_this).setValue(jdField_this.n0());
      SummaryPlayViewModel.T(jdField_this);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSummaryByDate failed: ");
      localStringBuilder.append(paramThrowable.getMessage());
      b.d.w.c.a.c("PlayViewModel-tyler", localStringBuilder.toString());
    }
  }
  
  static final class j<T>
    implements io.reactivex.g0.g<SummaryClipInfoResult>
  {
    j(SummaryPlayViewModel paramSummaryPlayViewModel, String paramString1, String paramString2, String paramString3) {}
    
    public final void a(SummaryClipInfoResult paramSummaryClipInfoResult)
    {
      MutableLiveData localMutableLiveData = SummaryPlayViewModel.P(this.c);
      j.d(paramSummaryClipInfoResult, "it");
      localMutableLiveData.setValue(paramSummaryClipInfoResult.getClipList());
    }
  }
  
  static final class k<T>
    implements io.reactivex.g0.g<Throwable>
  {
    public static final k c = new k();
    
    public final void a(Throwable paramThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSummaryClipInfo failed: ");
      localStringBuilder.append(paramThrowable);
      b.d.w.c.a.e("tylerTest", localStringBuilder.toString());
    }
  }
  
  static final class l<I, O>
    implements Function<HashMap<String, Integer>, ArrayList<com.tplink.iot.view.ipcamera.widget.calendar.d>>
  {
    public static final l a = new l();
    
    public final ArrayList<com.tplink.iot.view.ipcamera.widget.calendar.d> a(HashMap<String, Integer> paramHashMap)
    {
      ArrayList localArrayList = new ArrayList();
      j.d(paramHashMap, "it");
      paramHashMap = paramHashMap.entrySet().iterator();
      while (paramHashMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramHashMap.next();
        int i = ((Number)localEntry.getValue()).intValue();
        if ((i == 2) || (i == 1) || (i == 0)) {
          localArrayList.add(com.tplink.iot.e.a.a.a((String)localEntry.getKey()));
        }
      }
      return localArrayList;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\dailysummary\viewmodel\SummaryPlayViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */