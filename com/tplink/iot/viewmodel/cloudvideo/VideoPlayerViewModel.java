package com.tplink.iot.viewmodel.cloudvideo;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import b.d.q.b.p.b;
import com.tplink.iot.cloud.bean.cloudvideo.common.CloudVideo;
import com.tplink.iot.model.cloudvideo.CloudVideoItem;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import com.tplink.libtpnetwork.Utils.d0;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import io.reactivex.e0.c;
import io.reactivex.g;
import io.reactivex.q;
import io.reactivex.r;
import io.reactivex.s;
import io.reactivex.v;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

public class VideoPlayerViewModel
  extends AndroidViewModel
{
  public ALCameraDevice a;
  private String b = "";
  private SingleLiveEvent<Boolean> c = new SingleLiveEvent();
  
  public VideoPlayerViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
  }
  
  private boolean i(Bitmap paramBitmap)
  {
    bool1 = false;
    bool2 = bool1;
    Object localObject1;
    Object localObject2;
    if (paramBitmap != null) {
      if (paramBitmap.isRecycled())
      {
        bool2 = bool1;
      }
      else
      {
        localObject1 = String.valueOf(System.currentTimeMillis());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(b.h());
        localObject2 = File.separator;
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append("cloudvideo");
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(".jpg");
        localObject2 = localStringBuilder.toString();
        b.u(this.a, (String)localObject1, (String)localObject2, -1);
        localObject1 = new File((String)localObject2);
      }
    }
    try
    {
      localObject2 = new java/io/FileOutputStream;
      ((FileOutputStream)localObject2).<init>((File)localObject1);
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, 90, (OutputStream)localObject2);
      ((FileOutputStream)localObject2).flush();
      ((FileOutputStream)localObject2).close();
      paramBitmap.recycle();
      bool2 = true;
    }
    catch (Exception paramBitmap)
    {
      for (;;)
      {
        bool2 = bool1;
      }
    }
    return bool2;
  }
  
  private void p(ALCameraDevice paramALCameraDevice)
  {
    if (paramALCameraDevice == null) {
      return;
    }
    if (!d0.a(this.a, paramALCameraDevice)) {
      this.a = paramALCameraDevice;
    }
  }
  
  public void h(final Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return;
    }
    q.m(new b(paramBitmap)).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).a(new a());
  }
  
  public LiveData<Boolean> j()
  {
    return this.c;
  }
  
  public CloudVideoItem k(String paramString, List<CloudVideoItem> paramList)
  {
    if ((paramString != null) && (paramList != null))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        CloudVideoItem localCloudVideoItem = (CloudVideoItem)paramList.next();
        if (paramString.equals(localCloudVideoItem.getCloudVideo().getUuid())) {
          return localCloudVideoItem;
        }
      }
    }
    return null;
  }
  
  public boolean l(long paramLong)
  {
    boolean bool;
    if (System.currentTimeMillis() > paramLong) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void m(String paramString, int paramInt)
  {
    long l = System.currentTimeMillis();
    b.u(this.a, String.valueOf(l), paramString, paramInt);
  }
  
  public void n(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.b = str;
    if (TextUtils.isEmpty(str)) {
      paramString = null;
    } else {
      paramString = (ALCameraDevice)TPIoTClientManager.K1(this.b).getCameraDevice();
    }
    p(paramString);
  }
  
  public void o(String paramString, ALCameraDevice paramALCameraDevice)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.b = str;
    p(paramALCameraDevice);
  }
  
  class a
    implements v<Boolean>
  {
    a() {}
    
    public void a(Boolean paramBoolean)
    {
      if ((paramBoolean != null) && (paramBoolean.booleanValue())) {
        VideoPlayerViewModel.f(VideoPlayerViewModel.this).postValue(Boolean.TRUE);
      }
    }
    
    public void onComplete() {}
    
    public void onError(Throwable paramThrowable) {}
    
    public void onSubscribe(c paramc) {}
  }
  
  class b
    implements s<Boolean>
  {
    b(Bitmap paramBitmap) {}
    
    public void subscribe(r<Boolean> paramr)
      throws Exception
    {
      paramr.onNext(Boolean.valueOf(VideoPlayerViewModel.g(VideoPlayerViewModel.this, paramBitmap)));
      paramr.onComplete();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\cloudvideo\VideoPlayerViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */