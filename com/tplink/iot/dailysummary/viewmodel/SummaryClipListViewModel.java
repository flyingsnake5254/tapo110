package com.tplink.iot.dailysummary.viewmodel;

import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tplink.iot.dailysummary.network.bean.common.SummaryClipVideo;
import com.tplink.iot.h.f;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.Utils.d0;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import io.reactivex.g;
import io.reactivex.q;
import io.reactivex.r;
import io.reactivex.s;
import io.reactivex.v;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class SummaryClipListViewModel
  extends ViewModel
{
  private ALCameraDevice a;
  private String b = "";
  private SummaryClipVideo c;
  private f d;
  private final MutableLiveData<Integer> e = new MutableLiveData();
  private final MutableLiveData<Boolean> f = new MutableLiveData();
  private final MutableLiveData<Boolean> g = new MutableLiveData();
  private final MutableLiveData<Boolean> h = new MutableLiveData();
  private final MutableLiveData<Boolean> i = new MutableLiveData();
  private final MutableLiveData<Boolean> j = new MutableLiveData();
  private final MutableLiveData<Boolean> k = new MutableLiveData();
  private final MutableLiveData<Integer> l = new MutableLiveData();
  
  /* Error */
  private final boolean n(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 77	android/graphics/Bitmap:isRecycled	()Z
    //   4: istore_2
    //   5: iconst_0
    //   6: istore_3
    //   7: iload_2
    //   8: ifeq +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: invokestatic 83	java/lang/System:currentTimeMillis	()J
    //   16: invokestatic 89	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   19: astore 4
    //   21: new 91	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   28: astore 5
    //   30: aload 5
    //   32: invokestatic 97	b/d/q/b/p/b:h	()Ljava/lang/String;
    //   35: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: getstatic 106	java/io/File:separator	Ljava/lang/String;
    //   42: astore 6
    //   44: aload 5
    //   46: aload 6
    //   48: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: aload 5
    //   54: ldc 108
    //   56: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload 5
    //   62: aload 6
    //   64: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload 5
    //   70: aload 4
    //   72: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload 5
    //   78: ldc 110
    //   80: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload 5
    //   86: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: astore 5
    //   91: aload_0
    //   92: getfield 66	com/tplink/iot/dailysummary/viewmodel/SummaryClipListViewModel:a	Lcom/tplink/libtpnetwork/cameranetwork/bean/ALCameraDevice;
    //   95: aload 4
    //   97: aload 5
    //   99: iconst_m1
    //   100: invokestatic 117	b/d/q/b/p/b:u	(Lcom/tplink/libtpnetwork/cameranetwork/bean/ALCameraDevice;Ljava/lang/String;Ljava/lang/String;I)V
    //   103: new 119	java/io/FileOutputStream
    //   106: dup
    //   107: new 103	java/io/File
    //   110: dup
    //   111: aload 5
    //   113: invokespecial 122	java/io/File:<init>	(Ljava/lang/String;)V
    //   116: invokespecial 125	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   119: astore 4
    //   121: aload_1
    //   122: getstatic 131	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   125: bipush 90
    //   127: aload 4
    //   129: invokevirtual 135	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   132: pop
    //   133: aload 4
    //   135: invokevirtual 138	java/io/FileOutputStream:flush	()V
    //   138: aload 4
    //   140: invokevirtual 141	java/io/FileOutputStream:close	()V
    //   143: aload 4
    //   145: invokevirtual 141	java/io/FileOutputStream:close	()V
    //   148: iconst_1
    //   149: istore_3
    //   150: goto +49 -> 199
    //   153: astore_1
    //   154: goto +47 -> 201
    //   157: astore_1
    //   158: new 91	java/lang/StringBuilder
    //   161: astore_1
    //   162: aload_1
    //   163: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   166: aload_1
    //   167: ldc -113
    //   169: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload_1
    //   174: aload_0
    //   175: invokevirtual 149	java/lang/Object:getClass	()Ljava/lang/Class;
    //   178: invokevirtual 154	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   181: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: ldc -100
    //   187: aload_1
    //   188: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: invokestatic 161	b/d/w/c/a:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   194: aload 4
    //   196: invokevirtual 141	java/io/FileOutputStream:close	()V
    //   199: iload_3
    //   200: ireturn
    //   201: aload 4
    //   203: invokevirtual 141	java/io/FileOutputStream:close	()V
    //   206: aload_1
    //   207: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	this	SummaryClipListViewModel
    //   0	208	1	paramBitmap	Bitmap
    //   4	4	2	bool1	boolean
    //   6	194	3	bool2	boolean
    //   19	183	4	localObject1	Object
    //   28	84	5	localObject2	Object
    //   42	21	6	str	String
    // Exception table:
    //   from	to	target	type
    //   121	143	153	finally
    //   158	194	153	finally
    //   121	143	157	java/lang/Exception
  }
  
  public final void A(boolean paramBoolean)
  {
    this.f.setValue(Boolean.valueOf(paramBoolean));
  }
  
  public final void B(int paramInt)
  {
    this.e.postValue(Integer.valueOf(paramInt));
    if (paramInt != 5)
    {
      if (paramInt == 6) {
        this.g.postValue(Boolean.TRUE);
      }
    }
    else {
      this.g.postValue(Boolean.FALSE);
    }
  }
  
  public final void l()
  {
    f localf = this.d;
    if (localf != null) {
      localf.y();
    }
  }
  
  public final void m(final Bitmap paramBitmap)
  {
    j.e(paramBitmap, "bitmap");
    q.m(new a(this, paramBitmap)).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).a(new b(this));
  }
  
  public final void o(boolean paramBoolean)
  {
    this.h.setValue(Boolean.valueOf(paramBoolean));
  }
  
  public final void p()
  {
    SummaryClipVideo localSummaryClipVideo = this.c;
    if (localSummaryClipVideo != null)
    {
      final Object localObject1 = b.d.w.h.a.a(localSummaryClipVideo.getM3u8());
      final String str = localSummaryClipVideo.getUri();
      final Object localObject2 = new StringBuilder();
      Object localObject3 = localSummaryClipVideo.getStartTimestamp();
      if (localObject3 == null) {
        localObject3 = localSummaryClipVideo.getUriExpiresAt();
      }
      ((StringBuilder)localObject2).append(String.valueOf(((Long)localObject3).longValue()));
      ((StringBuilder)localObject2).append(".mp4");
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject3 = new f("1000");
      ((f)localObject3).z((String)localObject2, (String)localObject1, str, new c((f)localObject3, (String)localObject2, (String)localObject1, str, this));
      localObject1 = p.a;
      this.d = ((f)localObject3);
    }
  }
  
  public final MutableLiveData<Boolean> r()
  {
    return this.k;
  }
  
  public final MutableLiveData<Integer> s()
  {
    return this.l;
  }
  
  public final MutableLiveData<Boolean> t()
  {
    return this.f;
  }
  
  public final MutableLiveData<Boolean> u()
  {
    return this.h;
  }
  
  public final MutableLiveData<Integer> v()
  {
    return this.e;
  }
  
  public final void w()
  {
    Object localObject = com.tplink.iot.e.a.c.k.b();
    this.b = ((String)localObject);
    localObject = b.d.w.h.a.g((String)localObject);
    if ((localObject != null) && (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      localObject = TPIoTClientManager.K1((String)localObject);
      j.d(localObject, "TPIoTClientManager.getCameraContext(md5String)");
      localObject = (ALCameraDevice)((TPBaseDeviceContext)localObject).getCameraDevice();
      if ((localObject != null) && (!d0.a(this.a, localObject))) {
        this.a = ((ALCameraDevice)localObject);
      }
    }
    this.h.setValue(Boolean.TRUE);
  }
  
  public final void x(SummaryClipVideo paramSummaryClipVideo)
  {
    j.e(paramSummaryClipVideo, "clipVideo");
    this.c = paramSummaryClipVideo;
  }
  
  public final void y(boolean paramBoolean)
  {
    this.i.setValue(Boolean.valueOf(paramBoolean));
  }
  
  public final void z(boolean paramBoolean)
  {
    this.j.setValue(Boolean.valueOf(paramBoolean));
    if (paramBoolean)
    {
      A(false);
      this.i.setValue(Boolean.FALSE);
    }
  }
  
  public static final class a
    implements s<Boolean>
  {
    a(Bitmap paramBitmap) {}
    
    public void subscribe(r<Boolean> paramr)
    {
      j.e(paramr, "emitter");
      paramr.onNext(Boolean.valueOf(SummaryClipListViewModel.f(this.a, paramBitmap)));
      paramr.onComplete();
    }
  }
  
  public static final class b
    implements v<Boolean>
  {
    b(SummaryClipListViewModel paramSummaryClipListViewModel) {}
    
    public void a(boolean paramBoolean)
    {
      SummaryClipListViewModel.g(this.c).setValue(Boolean.valueOf(paramBoolean));
    }
    
    public void onComplete() {}
    
    public void onError(Throwable paramThrowable)
    {
      j.e(paramThrowable, "e");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("capturePic failed: ");
      localStringBuilder.append(paramThrowable.getMessage());
      b.d.w.c.a.c("PlayViewModel-tyler", localStringBuilder.toString());
      SummaryClipListViewModel.g(this.c).setValue(Boolean.FALSE);
    }
    
    public void onSubscribe(io.reactivex.e0.c paramc)
    {
      j.e(paramc, "d");
    }
  }
  
  public static final class c
    implements com.tplink.iot.h.i.b
  {
    c(f paramf, String paramString1, String paramString2, String paramString3, SummaryClipListViewModel paramSummaryClipListViewModel) {}
    
    public void a(long paramLong1, long paramLong2, int paramInt)
    {
      f localf = SummaryClipListViewModel.j(jdField_this);
      if ((localf != null) && (localf.E() == true) && (paramLong1 > 0L)) {
        SummaryClipListViewModel.i(jdField_this).setValue(Integer.valueOf(Math.min((int)(100 * paramLong2 / paramLong1), 99)));
      }
    }
    
    public void b(int paramInt1, int paramInt2)
    {
      ALCameraDevice localALCameraDevice = SummaryClipListViewModel.h(jdField_this);
      if (localALCameraDevice != null)
      {
        b.d.q.b.p.b.u(localALCameraDevice, String.valueOf(System.currentTimeMillis()), this.a.B(), paramInt2);
        SummaryClipListViewModel.k(jdField_this).setValue(Integer.valueOf(2));
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      j.e(paramThrowable, "errorMsg");
      SummaryClipListViewModel.k(jdField_this).setValue(Integer.valueOf(3));
    }
    
    public void onStart()
    {
      SummaryClipListViewModel.k(jdField_this).setValue(Integer.valueOf(1));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\dailysummary\viewmodel\SummaryClipListViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */