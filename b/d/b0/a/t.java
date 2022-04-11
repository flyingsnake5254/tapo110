package b.d.b0.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableLong;
import androidx.lifecycle.MutableLiveData;
import b.d.h.b.a;
import b.d.j.a.a.a;
import com.tplink.libmediakit.jniinterface.DecoderProperty;
import com.tplink.libmediakit.jniinterface.DecoderProperty.a;
import com.tplink.libmediakit.media.display.renderer.YUVBuffer;
import com.tplink.libtpappcommonmedia.bean.stream.BitStreamType;
import com.tplink.libtpappcommonmedia.bean.stream.MediaDataFormat;
import com.tplink.libtpappcommonmedia.bean.stream.StreamMediaData;
import com.tplink.libtpdemux.tsdemux.common.EnumESFrameType;
import com.tplink.libtpdemux.tsdemux.common.EnumESType;
import com.tplink.libtpvideorender.view.GLSurfaceViewGPU;
import com.tplink.libtpvideorender.view.GestureSurfaceView;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class t
  implements b.d.z.b.g, b.d.x.a, b.a, b.d.z.b.h, b.d.r.a.g.b, b.d.d.h.b, b.d.d.h.a, Runnable, a.a
{
  private b.d.e.a H3;
  private float I3;
  private boolean J3;
  private b.d.r.a.g.a K3 = null;
  private b.d.d.h.c L3;
  private b.d.d.h.d M3;
  private final Object N3 = new Object();
  private BitStreamType O3;
  private int P3 = 0;
  private int Q3 = 0;
  private float R3 = 1.0F;
  private int S3 = 1;
  private boolean T3 = false;
  private boolean U3 = false;
  private volatile boolean V3 = false;
  private final AtomicBoolean W3 = new AtomicBoolean(false);
  private volatile boolean X3 = false;
  private boolean Y3 = false;
  private boolean Z3 = false;
  private final ObservableBoolean a4 = new ObservableBoolean();
  private final ObservableBoolean b4 = new ObservableBoolean(false);
  private final String c = "StreamDisplayClient";
  private final ObservableLong c4 = new ObservableLong(0L);
  private GestureSurfaceView d;
  private MutableLiveData<b.d.d.m.f<Pair<Bitmap, String>>> d4;
  private MutableLiveData<b.d.d.m.f<String>> e4;
  private Context f;
  private final String f4;
  private int g4;
  private final ArrayList<WeakReference<b.d.z.a.a>> h4 = new ArrayList();
  private b.d.d.g.b i4;
  private Handler j4 = new a(Looper.getMainLooper());
  protected b.d.j.a.a p0;
  protected DecoderProperty p1 = new DecoderProperty();
  private com.tplink.libmediakit.media.audioprocess.b<com.tplink.libmediakit.media.audioprocess.a> p2;
  private b.d.x.b p3;
  private b.d.z.b.i q;
  private b.d.h.b x;
  private final b.d.r.a.b y;
  private final Object z = new Object();
  
  public t(String paramString)
  {
    this.f4 = paramString;
    b.d.d.e.a.a(paramString, new m(this));
    this.y = new b.d.r.a.b();
    this.g4 = -1;
    Object localObject = new b.d.j.a.a();
    this.p0 = ((b.d.j.a.a)localObject);
    ((b.d.j.a.a)localObject).r(this);
    localObject = new com.tplink.libmediakit.media.audioprocess.b();
    this.p2 = ((com.tplink.libmediakit.media.audioprocess.b)localObject);
    ((com.tplink.libmediakit.media.audioprocess.b)localObject).l(8000);
    this.p2.c(2);
    this.p2.c(6);
    this.p2.k(new n(this, paramString));
    this.I3 = 1.0F;
    this.J3 = false;
  }
  
  private int[] C(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte[0] == 0) && (paramArrayOfByte[1] == 0) && (paramArrayOfByte[2] == 0) && (paramArrayOfByte[3] == 1) && ((paramArrayOfByte[4] & 0x1F) == 7))
    {
      for (int i = 5; i < paramArrayOfByte.length - 4; i++) {
        if ((paramArrayOfByte[i] == 0) && (paramArrayOfByte[(i + 1)] == 0) && (paramArrayOfByte[(i + 2)] == 0) && (paramArrayOfByte[(i + 3)] == 1)) {
          break label88;
        }
      }
      i = 0;
      label88:
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, i);
      paramArrayOfByte = new DecoderProperty.a();
      this.p1.a(arrayOfByte, paramArrayOfByte);
      return new int[] { paramArrayOfByte.b(), paramArrayOfByte.a() };
    }
    return null;
  }
  
  private void K(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      b.d.e.a locala = this.H3;
      if ((locala != null) && (locala.f() > 0.0F)) {
        this.I3 = this.H3.f();
      }
      h0(0.0F);
    }
    else
    {
      h0(this.I3);
    }
  }
  
  private void P()
  {
    Object localObject = this.x;
    if (localObject != null) {
      ((b.d.h.b)localObject).e();
    }
    K(true);
    localObject = this.H3;
    if (localObject != null) {
      ((b.d.e.a)localObject).c();
    }
  }
  
  private boolean Q()
  {
    float f1 = this.R3;
    boolean bool = true;
    if ((f1 != 1.0F) || (this.S3 != 1)) {
      bool = false;
    }
    return bool;
  }
  
  private void R(byte[] paramArrayOfByte, StreamMediaData paramStreamMediaData, long paramLong1, long paramLong2)
  {
    if (paramArrayOfByte.length <= 0) {
      return;
    }
    com.tplink.libmediakit.media.audioprocess.a locala = new com.tplink.libmediakit.media.audioprocess.a();
    locala.a = paramLong2;
    locala.d = ((byte[])paramArrayOfByte.clone());
    locala.b = paramLong1;
    locala.q(paramStreamMediaData.deviceIdMD5);
    paramArrayOfByte = this.p2;
    if (paramArrayOfByte != null) {
      paramArrayOfByte.i(locala);
    }
  }
  
  private void U()
  {
    Object localObject = this.x;
    if (localObject != null) {
      ((b.d.h.b)localObject).g();
    }
    K(false);
    localObject = this.H3;
    if (localObject != null) {
      ((b.d.e.a)localObject).g();
    }
  }
  
  private int V(String paramString1, String paramString2)
  {
    Object localObject1 = null;
    Object localObject2;
    try
    {
      MediaMetadataRetriever localMediaMetadataRetriever = new android/media/MediaMetadataRetriever;
      localMediaMetadataRetriever.<init>();
      try
      {
        localMediaMetadataRetriever.setDataSource(paramString2);
        String str = localMediaMetadataRetriever.extractMetadata(9);
        localObject1 = str;
      }
      catch (Exception localException2) {}
      if (localObject2 == null) {
        break label53;
      }
    }
    catch (Exception localException1)
    {
      localObject2 = null;
    }
    ((MediaMetadataRetriever)localObject2).release();
    label53:
    int i;
    if ((localObject1 != null) && (!"0".equals(localObject1))) {
      i = Math.round(Float.parseFloat((String)localObject1) / 1000.0F);
    } else {
      i = 0;
    }
    if (i <= 0)
    {
      paramString1 = new File(paramString2);
      if (paramString1.exists()) {
        paramString1.delete();
      }
    }
    else
    {
      b.d.d.l.a.c(this.f4, paramString1, paramString2, i);
    }
    return i;
  }
  
  private void v()
  {
    if (this.K3 != null)
    {
      Object localObject;
      if (!Q())
      {
        localObject = this.K3;
        if (!(localObject instanceof b.d.r.a.a))
        {
          ((b.d.r.a.g.a)localObject).d();
          localObject = new b.d.r.a.a();
          this.K3 = ((b.d.r.a.g.a)localObject);
          ((b.d.r.a.g.a)localObject).f(this);
          return;
        }
      }
      if (Q())
      {
        localObject = this.K3;
        if ((localObject instanceof b.d.r.a.a))
        {
          ((b.d.r.a.g.a)localObject).d();
          localObject = new b.d.r.a.e();
          this.K3 = ((b.d.r.a.g.a)localObject);
          ((b.d.r.a.g.a)localObject).f(this);
        }
      }
    }
  }
  
  public void A(int paramInt)
  {
    if (this.j4 != null)
    {
      Message localMessage = new Message();
      Bundle localBundle = new Bundle();
      localBundle.putInt("timeoutSeconds", paramInt);
      localMessage.what = 15;
      localMessage.setData(localBundle);
      this.j4.sendMessage(localMessage);
    }
  }
  
  public int B()
  {
    return this.g4;
  }
  
  public boolean D()
  {
    return this.U3;
  }
  
  public boolean E()
  {
    return this.W3.get();
  }
  
  public ObservableBoolean F()
  {
    return this.a4;
  }
  
  public void L(StreamMediaData paramStreamMediaData)
  {
    if (this.L3 == null)
    {
      ??? = new b.d.d.h.c();
      this.L3 = ((b.d.d.h.c)???);
      ((b.d.d.h.c)???).c(this);
    }
    ??? = paramStreamMediaData.rawData;
    if (??? != null) {
      this.L3.a(???.length);
    }
    if (this.M3 == null)
    {
      ??? = new b.d.d.h.d();
      this.M3 = ((b.d.d.h.d)???);
      ((b.d.d.h.d)???).e(this);
    }
    ??? = MediaDataFormat.VIDEO_MP2T;
    if (??? == paramStreamMediaData.format) {
      this.M3.a(1);
    }
    if ((??? == paramStreamMediaData.format) && (paramStreamMediaData.isConfigFrame) && (!this.T3))
    {
      this.P3 = paramStreamMediaData.width;
      this.Q3 = paramStreamMediaData.height;
      this.T3 = true;
    }
    if (!this.T3) {
      return;
    }
    this.y.c(paramStreamMediaData);
    synchronized (this.z)
    {
      this.z.notifyAll();
      if ((!this.W3.get()) && (this.y.f() > 300))
      {
        paramStreamMediaData = com.tplink.libtpstreamclientmanager.m.V().Z(this.f4);
        if (paramStreamMediaData != null)
        {
          paramStreamMediaData = paramStreamMediaData.iterator();
          while (paramStreamMediaData.hasNext())
          {
            ??? = (b.d.a0.b.e)paramStreamMediaData.next();
            if (??? != null) {
              ((b.d.a0.b.e)???).v();
            }
          }
        }
      }
      return;
    }
  }
  
  public void M(byte[] paramArrayOfByte)
  {
    b.d.j.a.a locala = this.p0;
    if (locala != null) {
      locala.o(paramArrayOfByte, paramArrayOfByte.length);
    }
  }
  
  public void N()
  {
    StreamMediaData localStreamMediaData = new StreamMediaData(false);
    localStreamMediaData.format = MediaDataFormat.VOD_STREAM_FINISH;
    localStreamMediaData.deviceIdMD5 = this.f4;
    localStreamMediaData.rawData = new byte[] { 0 };
    localStreamMediaData.playTimeMs = b.d.j.a.b.a().e(this.f4, 1);
    L(localStreamMediaData);
  }
  
  public void O()
  {
    this.V3 = true;
    P();
  }
  
  public void S()
  {
    this.S3 = 1;
    this.R3 = 1.0F;
    b.d.h.b localb = this.x;
    if (localb != null) {
      localb.i(1);
    }
    this.y.e((int)this.R3);
  }
  
  public void T()
  {
    this.V3 = false;
    synchronized (this.N3)
    {
      this.N3.notifyAll();
      U();
      return;
    }
  }
  
  public void W(boolean paramBoolean)
  {
    this.U3 = paramBoolean;
  }
  
  public void X(int paramInt)
  {
    this.g4 = paramInt;
  }
  
  public void Y(boolean paramBoolean)
  {
    this.J3 = paramBoolean;
    b.d.e.a locala = this.H3;
    if (locala != null) {
      locala.b(paramBoolean);
    }
    K(paramBoolean);
  }
  
  public void Z(float paramFloat)
  {
    this.R3 = paramFloat;
    if (paramFloat < 1.0F) {
      this.R3 = 1.0F;
    } else if (paramFloat > 16.0F) {
      this.R3 = 16.0F;
    }
    int i = (int)(1.0F / paramFloat);
    this.S3 = i;
    if (i <= 0) {
      this.S3 = 1;
    } else if (i > 16) {
      this.S3 = 16;
    }
    b.d.h.b localb = this.x;
    if (localb != null) {
      localb.i(this.S3);
    }
    this.y.e((int)this.R3);
    v();
  }
  
  public void a(String paramString1, String paramString2)
  {
    int i = V(paramString1, paramString2);
    Bundle localBundle = new Bundle();
    localBundle.putInt("RecordDuration", i);
    localBundle.putString("RecordFileUri", paramString2);
    paramString1 = new Message();
    paramString1.what = 7;
    paramString1.setData(localBundle);
    paramString2 = this.j4;
    if (paramString2 != null) {
      paramString2.sendMessage(paramString1);
    }
  }
  
  public void a0(Context paramContext)
  {
    this.f = paramContext;
  }
  
  public void b(int paramInt)
  {
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("FramePerSecond", paramInt);
    Object localObject2 = this.j4;
    if (localObject2 != null)
    {
      localObject2 = ((Handler)localObject2).obtainMessage(16);
      ((Message)localObject2).setData((Bundle)localObject1);
      localObject1 = this.j4;
      if (localObject1 != null) {
        ((Handler)localObject1).sendMessage((Message)localObject2);
      }
    }
  }
  
  public void b0(b.d.d.g.b paramb)
  {
    this.i4 = paramb;
  }
  
  public void c(int paramInt, String paramString1, String paramString2)
  {
    int i = paramInt;
    if (paramInt != -1)
    {
      i = paramInt;
      switch (paramInt)
      {
      default: 
        i = -1;
        break;
      case -3200003: 
        V(paramString1, paramString2);
        i = paramInt;
        break;
      case -3200004: 
        V(paramString1, paramString2);
        i = paramInt;
      }
    }
    if (this.j4 != null)
    {
      paramString1 = new Message();
      paramString2 = new Bundle();
      paramString2.putInt("error_code", i);
      paramString1.what = 8;
      paramString1.setData(paramString2);
      this.j4.sendMessage(paramString1);
    }
  }
  
  public void c0()
  {
    b.d.z.b.i locali = this.q;
    if (locali != null) {
      locali.o(null);
    }
  }
  
  public void d(@NonNull YUVBuffer paramYUVBuffer)
  {
    b.d.x.b localb = this.p3;
    if (localb != null) {
      localb.c(paramYUVBuffer);
    }
  }
  
  public void d0()
  {
    this.W3.set(true);
    Object localObject = com.tplink.libtpstreamclientmanager.m.V().Z(this.f4);
    if (localObject != null)
    {
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        localObject = (b.d.a0.b.e)localIterator.next();
        if (localObject != null) {
          ((b.d.a0.b.e)localObject).w();
        }
      }
    }
  }
  
  public void e(byte[] paramArrayOfByte, int paramInt, com.tplink.libtpdemux.tsdemux.common.b paramb)
  {
    Object localObject;
    long l;
    if ((paramb != null) && (paramb.b() == EnumESType.TS_ES_TYPE_AUDIO))
    {
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
      {
        localObject = new StreamMediaData(false);
        ((StreamMediaData)localObject).format = MediaDataFormat.AUDIO_MP2T;
        ((StreamMediaData)localObject).deviceIdMD5 = this.f4;
        ((StreamMediaData)localObject).ptsUs = StreamMediaData.parsePtsUs(paramb.a().d());
        b.d.j.a.b.a().g(this.f4, 1, paramb.a(), paramInt * 2);
        l = b.d.j.a.b.a().c(this.f4, 1);
        R(b.d.e.c.a(paramArrayOfByte, paramArrayOfByte.length), (StreamMediaData)localObject, ((StreamMediaData)localObject).ptsUs, l);
      }
    }
    else if ((paramb != null) && (paramb.b() == EnumESType.TS_ES_TYPE_VIDEO))
    {
      StreamMediaData localStreamMediaData = new StreamMediaData(false);
      if (EnumESFrameType.TS_ES_FRAME_TYPE_SPS == paramb.c().a())
      {
        localObject = C(paramArrayOfByte);
        if ((localObject != null) && (localObject.length == 2))
        {
          localStreamMediaData.width = localObject[0];
          localStreamMediaData.height = localObject[1];
          localStreamMediaData.isConfigFrame = true;
        }
      }
      localStreamMediaData.format = MediaDataFormat.VIDEO_MP2T;
      localStreamMediaData.deviceIdMD5 = this.f4;
      localStreamMediaData.rawData = paramArrayOfByte;
      l = b.d.j.a.b.a().h(this.f4, 1, paramb.c());
      localStreamMediaData.playTimeMs = b.d.j.a.b.a().e(this.f4, 1);
      localStreamMediaData.duration = l;
      localStreamMediaData.isKeyFrame = paramb.c().d();
      localStreamMediaData.ptsUs = StreamMediaData.parsePtsUs(paramb.c().b());
      L(localStreamMediaData);
    }
  }
  
  public void e0()
  {
    if (!this.b4.get())
    {
      this.b4.set(true);
      if (this.a4.get())
      {
        b.d.z.c.a.a(this.h4, r.a);
        v();
        Object localObject = this.K3;
        if (localObject != null) {
          ((b.d.r.a.g.a)localObject).g();
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("device ");
        ((StringBuilder)localObject).append(this.f4);
        ((StringBuilder)localObject).append(" start record");
        b.d.p.d.a("StreamDisplayClient", ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void f(int paramInt, String paramString)
  {
    b.d.d.l.a.d(this.f4, paramString);
    MutableLiveData localMutableLiveData = this.e4;
    if (localMutableLiveData != null)
    {
      localMutableLiveData.postValue(new b.d.d.m.f(this.f4));
      this.e4 = null;
    }
    if (!TextUtils.isEmpty(this.f4)) {
      b.d.d.f.a.e(this.f4, new File(paramString).getName());
    }
  }
  
  public void f0()
  {
    if (this.b4.get())
    {
      this.b4.set(false);
      b.d.r.a.g.a locala = this.K3;
      if (locala != null) {
        locala.h();
      }
      b.d.z.c.a.a(this.h4, o.a);
    }
  }
  
  public void g(float paramFloat)
  {
    if (this.j4 != null)
    {
      Object localObject1 = new Bundle();
      ((Bundle)localObject1).putFloat("NetworkSpeed", paramFloat);
      Object localObject2 = this.j4;
      if (localObject2 != null)
      {
        localObject2 = ((Handler)localObject2).obtainMessage(10);
        ((Message)localObject2).setData((Bundle)localObject1);
        localObject1 = this.j4;
        if (localObject1 != null) {
          ((Handler)localObject1).sendMessage((Message)localObject2);
        }
      }
    }
  }
  
  public void g0(Exception paramException)
  {
    b.d.p.d.f("StreamDisplayClient");
    Object localObject = paramException;
    if (paramException == null) {
      localObject = new Exception("UnKnown Exception!");
    }
    if (this.j4 != null)
    {
      paramException = new Bundle();
      paramException.putSerializable("Exception", (Serializable)localObject);
      localObject = new Message();
      ((Message)localObject).setData(paramException);
      ((Message)localObject).what = 4;
      this.j4.sendMessage((Message)localObject);
      w();
    }
  }
  
  public void h(int paramInt, String paramString)
  {
    Object localObject = this.d4;
    if (localObject != null)
    {
      ((MutableLiveData)localObject).postValue(new b.d.d.m.f(new Pair(null, paramString)));
      this.d4 = null;
    }
    else
    {
      localObject = this.j4;
      if (localObject != null)
      {
        ((Handler)localObject).removeMessages(5);
        Message localMessage = this.j4.obtainMessage(5);
        localObject = new Bundle();
        ((Bundle)localObject).putString("snapShotUri", paramString);
        localMessage.setData((Bundle)localObject);
        this.j4.sendMessage(localMessage);
        b.d.p.d.a("StreamDisplayClient", "截图完成");
      }
    }
  }
  
  public void h0(float paramFloat)
  {
    b.d.e.a locala = this.H3;
    if (locala != null) {
      locala.d(paramFloat);
    }
  }
  
  public void i(YUVBuffer paramYUVBuffer, boolean paramBoolean)
  {
    if (this.Y3)
    {
      this.Y3 = false;
      h0(1.0F);
    }
    Object localObject = this.q;
    int i = 1;
    if (localObject == null)
    {
      localObject = new b.d.z.b.i(1);
      this.q = ((b.d.z.b.i)localObject);
      ((b.d.z.b.b)localObject).l(this);
      this.q.n(this);
    }
    if (this.x == null)
    {
      localObject = new b.d.h.b(paramBoolean);
      this.x = ((b.d.h.b)localObject);
      ((b.d.h.b)localObject).j(this);
      this.x.h(this);
      localObject = this.x;
      if (!paramBoolean) {
        i = this.S3;
      }
      ((b.d.h.b)localObject).i(i);
      this.x.l();
    }
    this.x.b(paramYUVBuffer);
  }
  
  public void i0(boolean paramBoolean, float paramFloat)
  {
    this.W3.set(false);
    Z(paramFloat);
    if (this.j4 != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("success", paramBoolean);
      localBundle.putFloat("rate", paramFloat);
      Message localMessage = this.j4.obtainMessage(12);
      localMessage.setData(localBundle);
      this.j4.sendMessage(localMessage);
      this.j4.removeMessages(2);
      this.j4.sendEmptyMessageDelayed(2, 3000L);
    }
  }
  
  public void j(YUVBuffer paramYUVBuffer)
  {
    if (this.W3.get())
    {
      localObject = this.p3;
      if (localObject != null) {
        ((b.d.x.b)localObject).c(paramYUVBuffer);
      }
      return;
    }
    if (this.d == null)
    {
      this.P3 = paramYUVBuffer.width;
      this.Q3 = paramYUVBuffer.height;
      localObject = new GestureSurfaceView(this.f);
      this.d = ((GestureSurfaceView)localObject);
      ((GestureSurfaceView)localObject).k(paramYUVBuffer.width, paramYUVBuffer.height);
      this.d.setGlRenderer(this.q);
      localObject = this.j4;
      if (localObject != null)
      {
        ((Handler)localObject).removeMessages(3);
        this.j4.sendEmptyMessage(3);
      }
    }
    int i = this.P3;
    int j = paramYUVBuffer.width;
    if (i != j)
    {
      i = this.Q3;
      int k = paramYUVBuffer.height;
      if (i != k)
      {
        localObject = this.d;
        if (localObject != null)
        {
          ((GestureSurfaceView)localObject).k(j, k);
          this.d.i();
        }
      }
    }
    Object localObject = this.d;
    if (localObject != null) {
      ((GLSurfaceViewGPU)localObject).setOutputBuffer(paramYUVBuffer);
    }
    long l = paramYUVBuffer.timestamp;
    if (l > 0L)
    {
      paramYUVBuffer = this.H3;
      if (paramYUVBuffer != null) {
        paramYUVBuffer.e(l);
      }
      if (this.V3)
      {
        paramYUVBuffer = this.j4;
        if (paramYUVBuffer != null) {
          paramYUVBuffer.removeMessages(6);
        }
      }
      else
      {
        paramYUVBuffer = this.j4;
        if (paramYUVBuffer != null)
        {
          paramYUVBuffer.removeMessages(6);
          localObject = this.j4.obtainMessage(6);
          paramYUVBuffer = new Bundle();
          paramYUVBuffer.putLong("vodPlayProgress", l);
          ((Message)localObject).setData(paramYUVBuffer);
          this.j4.sendMessage((Message)localObject);
        }
      }
      paramYUVBuffer = this.j4;
      if (paramYUVBuffer != null)
      {
        paramYUVBuffer.removeMessages(2);
        this.j4.sendEmptyMessage(2);
      }
    }
    paramYUVBuffer = this.x;
    if ((paramYUVBuffer != null) && (paramYUVBuffer.k() == 0) && (this.X3))
    {
      f0();
      paramYUVBuffer = this.j4;
      if (paramYUVBuffer != null)
      {
        paramYUVBuffer.removeMessages(18);
        this.j4.sendEmptyMessage(18);
      }
    }
  }
  
  public void j0(long paramLong)
  {
    this.W3.set(false);
    Handler localHandler = this.j4;
    if (localHandler != null)
    {
      localHandler.removeMessages(2);
      this.j4.sendEmptyMessage(1);
    }
  }
  
  public void k0(boolean paramBoolean)
  {
    this.W3.set(false);
    if (this.j4 != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("success", paramBoolean);
      Message localMessage = this.j4.obtainMessage(13);
      localMessage.setData(localBundle);
      this.j4.sendMessage(localMessage);
      this.j4.removeMessages(2);
      this.j4.sendEmptyMessageDelayed(2, 3000L);
    }
  }
  
  public void recordProgress(long paramLong)
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putLong("RecordTime", paramLong);
    Message localMessage = new Message();
    localMessage.what = 14;
    localMessage.setData((Bundle)localObject);
    localObject = this.j4;
    if (localObject != null) {
      ((Handler)localObject).sendMessage(localMessage);
    }
  }
  
  public void run()
  {
    this.U3 = true;
    Handler localHandler = this.j4;
    if (localHandler != null) {
      localHandler.sendEmptyMessage(1);
    }
    while (this.U3) {
      try
      {
        if (this.V3) {
          synchronized (this.N3)
          {
            this.N3.wait();
          }
        }
        int i = this.y.f();
        if ((!this.X3) && (i < 150))
        {
          ??? = com.tplink.libtpstreamclientmanager.m.V().Z(this.f4);
          if (??? != null)
          {
            ??? = ((List)???).iterator();
            while (((Iterator)???).hasNext())
            {
              ??? = (b.d.a0.b.e)((Iterator)???).next();
              if (??? != null) {
                ((b.d.a0.b.e)???).w();
              }
            }
          }
        }
        if ((this.y.f() == 0) && (this.U3)) {
          synchronized (this.z)
          {
            this.z.wait();
          }
        }
        ??? = this.y.g();
        if (??? != null)
        {
          MediaDataFormat localMediaDataFormat = ((StreamMediaData)???).format;
          boolean bool = ((StreamMediaData)???).isLiveStream;
          if (MediaDataFormat.VOD_STREAM_FINISH == localMediaDataFormat)
          {
            this.X3 = true;
          }
          else
          {
            Object localObject5;
            if (((StreamMediaData)???).isConfigFrame)
            {
              int j = ((StreamMediaData)???).width;
              i = ((StreamMediaData)???).height;
              if ((this.P3 != j) || (this.Q3 != i))
              {
                this.P3 = j;
                this.Q3 = i;
                f0();
                localObject5 = this.K3;
                if (localObject5 != null)
                {
                  ((b.d.r.a.g.a)localObject5).d();
                  this.K3 = null;
                }
              }
            }
            if (MediaDataFormat.VIDEO_MP2T == localMediaDataFormat)
            {
              localObject5 = this.p3;
              if (localObject5 == null)
              {
                localObject5 = new b/d/x/c;
                ((b.d.x.c)localObject5).<init>(bool);
                this.p3 = ((b.d.x.b)localObject5);
                ((b.d.x.b)localObject5).b(this);
                this.p3.a((StreamMediaData)???);
              }
              else
              {
                ((b.d.x.b)localObject5).a((StreamMediaData)???);
              }
              localObject5 = this.K3;
              if (localObject5 == null)
              {
                localObject5 = new b/d/r/a/e;
                ((b.d.r.a.e)localObject5).<init>();
                this.K3 = ((b.d.r.a.g.a)localObject5);
                ((b.d.r.a.g.a)localObject5).f(this);
                this.K3.e(((StreamMediaData)???).clone());
              }
              else
              {
                ((b.d.r.a.g.a)localObject5).e(((StreamMediaData)???).clone());
              }
              v();
            }
            else if (MediaDataFormat.AUDIO_MP2T == localMediaDataFormat)
            {
              localObject5 = this.K3;
              if (localObject5 == null)
              {
                localObject5 = new b/d/r/a/e;
                ((b.d.r.a.e)localObject5).<init>();
                this.K3 = ((b.d.r.a.g.a)localObject5);
                ((b.d.r.a.g.a)localObject5).f(this);
                this.K3.e(((StreamMediaData)???).clone());
              }
              else
              {
                ((b.d.r.a.g.a)localObject5).e(((StreamMediaData)???).clone());
              }
              v();
              if (this.S3 <= 1)
              {
                localObject5 = this.H3;
                if (localObject5 == null)
                {
                  localObject5 = new b/d/e/b;
                  ((b.d.e.b)localObject5).<init>(2);
                  this.H3 = ((b.d.e.a)localObject5);
                  ((b.d.e.a)localObject5).b(this.J3);
                  this.H3.a((StreamMediaData)???);
                  if (this.Y3) {
                    h0(0.0F);
                  }
                }
                else
                {
                  ((b.d.e.a)localObject5).a((StreamMediaData)???);
                }
              }
            }
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void u(b.d.z.a.a parama)
  {
    if (parama != null)
    {
      for (int i = this.h4.size() - 1; i >= 0; i--)
      {
        b.d.z.a.a locala = (b.d.z.a.a)((WeakReference)this.h4.get(i)).get();
        if ((locala != null) && (locala.equals(parama))) {
          return;
        }
      }
      this.h4.add(new WeakReference(parama));
    }
  }
  
  public void w()
  {
    this.y.a();
    b.d.h.b localb = this.x;
    if (localb != null) {
      localb.a();
    }
    this.p2.d();
  }
  
  public void x()
  {
    this.h4.clear();
  }
  
  public void y()
  {
    this.U3 = false;
    this.j4.removeCallbacksAndMessages(null);
    this.j4 = null;
    this.y.c(new StreamMediaData());
    synchronized (this.z)
    {
      this.z.notifyAll();
      ??? = this.p0;
      if (??? != null)
      {
        ((b.d.j.a.a)???).r(null);
        this.p0.q();
      }
      z();
      this.d = null;
      this.a4.set(false);
      b.d.z.c.a.a(this.h4, p.a);
      return;
    }
  }
  
  public void z()
  {
    this.T3 = false;
    this.X3 = false;
    this.Y3 = true;
    Object localObject = this.x;
    if (localObject != null)
    {
      ((b.d.h.b)localObject).m();
      this.x = null;
    }
    localObject = this.p3;
    if (localObject != null)
    {
      ((b.d.x.b)localObject).destroy();
      this.p3 = null;
    }
    localObject = this.H3;
    if (localObject != null)
    {
      ((b.d.e.a)localObject).destroy();
      this.H3 = null;
    }
    localObject = this.K3;
    if (localObject != null)
    {
      ((b.d.r.a.g.a)localObject).d();
      this.K3 = null;
    }
    localObject = this.L3;
    if (localObject != null)
    {
      ((b.d.d.h.c)localObject).b();
      this.L3 = null;
    }
    localObject = this.M3;
    if (localObject != null)
    {
      ((b.d.d.h.d)localObject).b();
      this.M3 = null;
    }
    localObject = this.j4;
    if (localObject != null) {
      ((Handler)localObject).removeMessages(15);
    }
  }
  
  class a
    extends Handler
  {
    a(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      int i;
      long l;
      boolean bool;
      float f;
      switch (paramMessage.what)
      {
      case 9: 
      default: 
        break;
      case 18: 
        b.d.z.c.a.a(t.n(t.this), s.a);
        break;
      case 17: 
        paramMessage = (BitStreamType)paramMessage.getData().getSerializable("STREAM_TYPE");
        b.d.z.c.a.a(t.n(t.this), new c(paramMessage));
        break;
      case 16: 
        i = paramMessage.getData().getInt("FramePerSecond");
        b.d.z.c.a.a(t.n(t.this), new e(this, i));
        break;
      case 15: 
        i = paramMessage.getData().getInt("timeoutSeconds");
        b.d.z.c.a.a(t.n(t.this), new j(i));
        t.m(t.this).set(false);
        break;
      case 14: 
        l = paramMessage.getData().getLong("RecordTime");
        t.q(t.this).set(l / 1000L);
        b.d.z.c.a.a(t.n(t.this), new d(l));
        break;
      case 13: 
        if (t.p(t.this) != null)
        {
          bool = paramMessage.getData().getBoolean("success");
          t.p(t.this).vodSeekTime(bool);
        }
        break;
      case 12: 
        if (t.p(t.this) != null)
        {
          bool = paramMessage.getData().getBoolean("success");
          f = paramMessage.getData().getFloat("rate");
          t.p(t.this).vodPlayRate(bool, f);
        }
        break;
      case 11: 
        bool = paramMessage.getData().getBoolean("success");
        i = paramMessage.getData().getInt("errorCode");
        paramMessage = paramMessage.getData().getString("BitStreamType");
        if (bool) {
          t.s(t.this, BitStreamType.fromString(paramMessage));
        } else {
          b.d.d.e.a.c(t.t(t.this), t.r(t.this));
        }
        paramMessage = BitStreamType.fromString(paramMessage);
        b.d.z.c.a.a(t.n(t.this), new i(this, paramMessage, bool, i));
        break;
      case 10: 
        if (!t.k(t.this))
        {
          f = paramMessage.getData().getFloat("NetworkSpeed");
          b.d.z.c.a.a(t.n(t.this), new b(f));
        }
        break;
      case 8: 
        t.this.f0();
        i = paramMessage.getData().getInt("error_code");
        b.d.z.c.a.a(t.n(t.this), new f(i));
        break;
      case 7: 
        i = paramMessage.getData().getInt("RecordDuration");
        paramMessage = paramMessage.getData().getString("RecordFileUri");
        b.d.z.c.a.a(t.n(t.this), new k(i, paramMessage));
        break;
      case 6: 
        l = paramMessage.getData().getLong("vodPlayProgress");
        if (t.p(t.this) != null) {
          t.p(t.this).showDisplayProgress(l);
        }
        break;
      case 5: 
        paramMessage = paramMessage.getData().getString("snapShotUri");
        b.d.z.c.a.a(t.n(t.this), new l(paramMessage));
        break;
      case 4: 
        t.this.f0();
        t.m(t.this).set(false);
        paramMessage = (Exception)paramMessage.getData().getSerializable("Exception");
        b.d.z.c.a.a(t.n(t.this), new g(paramMessage));
        break;
      case 3: 
        if (t.o(t.this) != null)
        {
          t.o(t.this).b();
          b.d.z.c.a.a(t.n(t.this), new h(this));
        }
        break;
      case 2: 
        t.m(t.this).set(true);
        if (t.k(t.this)) {
          t.l(t.this, false);
        }
        b.d.z.c.a.a(t.n(t.this), q.a);
        break;
      case 1: 
        t.l(t.this, true);
        t.m(t.this).set(false);
        b.d.z.c.a.a(t.n(t.this), a.a);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\b0\a\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */