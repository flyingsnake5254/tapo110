package b.d.i.a.b.c;

import com.google.gson.Gson;
import com.tplink.libtpappcommonmedia.bean.stream.BitStreamType;
import com.tplink.libtpcommonstream.stream.control.common.CommonPayload;
import com.tplink.libtpcommonstream.stream.control.common.StreamControlNotification;
import com.tplink.libtpcommonstream.stream.control.common.StreamControlRequest;
import com.tplink.libtpcommonstream.stream.control.common.StreamControlResponse;
import com.tplink.libtpcommonstream.stream.control.notification.ChannelLensMaskInfo;
import com.tplink.libtpcommonstream.stream.control.notification.ChannelMotorStatus;
import com.tplink.libtpcommonstream.stream.control.notification.DeviceLockedInfo;
import com.tplink.libtpcommonstream.stream.control.notification.StreamFinish;
import com.tplink.libtpcommonstream.stream.control.notification.StreamNotificationCallback;
import com.tplink.libtpcommonstream.stream.control.request.DoChangeResolutionsRequest;
import com.tplink.libtpcommonstream.stream.control.request.DoPlayParams;
import com.tplink.libtpcommonstream.stream.control.request.DoPlayRequest;
import com.tplink.libtpcommonstream.stream.control.request.GetDownloadRequest;
import com.tplink.libtpcommonstream.stream.control.request.param.GetDownloadParams;
import com.tplink.libtpcommonstream.stream.control.request.param.GetPreviewParams;
import com.tplink.libtpcommonstream.stream.control.response.DoPlayResponse;
import com.tplink.libtpcommonstream.stream.control.response.GetDownloadResponse;
import com.tplink.libtpcommonstream.stream.control.response.GetPreviewResponse;
import com.tplink.libtpcommonstream.stream.control.response.Response;
import io.reactivex.q;
import io.reactivex.r;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class o
  implements n
{
  private static int a = 1;
  private final Map<String, r<CommonPayload>> b = new HashMap();
  private StreamNotificationCallback c;
  
  public o()
  {
    E();
  }
  
  private <T, R> q<StreamControlResponse<R>> B(StreamControlRequest<T> paramStreamControlRequest, Class<R> paramClass, String paramString1, b.d.i.a.a.f paramf, String paramString2)
  {
    return D(paramStreamControlRequest, paramString1, paramf, paramString2, 15L).N(new f(paramClass)).L0(io.reactivex.l0.a.c());
  }
  
  private <T, R> q<StreamControlResponse<R>> C(StreamControlRequest<T> paramStreamControlRequest, Class<R> paramClass, String paramString1, b.d.i.a.a.f paramf, String paramString2, int paramInt)
  {
    return D(paramStreamControlRequest, paramString1, paramf, paramString2, paramInt).N(new h(paramClass)).L0(io.reactivex.l0.a.c());
  }
  
  private q<CommonPayload> D(StreamControlRequest paramStreamControlRequest, String paramString1, b.d.i.a.a.f paramf, String paramString2, long paramLong)
  {
    return q.f0(paramStreamControlRequest).g0(new d(this, paramf)).N(new j(this)).U0(paramLong, TimeUnit.SECONDS, q.f0(f()));
  }
  
  private CommonPayload f()
  {
    CommonPayload localCommonPayload = new CommonPayload();
    localCommonPayload.setType("response");
    Response localResponse = new Response();
    localResponse.setErrorCode(-2);
    localCommonPayload.setParams(b.d.i.a.b.b.f().A(localResponse));
    return localCommonPayload;
  }
  
  private int g()
  {
    int i = a;
    a = i + 1;
    return i;
  }
  
  private void h(String paramString, StreamControlNotification<Object> paramStreamControlNotification)
  {
    String str = paramStreamControlNotification.getEventType();
    if (this.c == null) {
      return;
    }
    str.hashCode();
    int i = -1;
    switch (str.hashCode())
    {
    default: 
      break;
    case 1267100380: 
      if (str.equals("channel_lens_mask_info")) {
        i = 4;
      }
      break;
    case 624430481: 
      if (str.equals("stream_status")) {
        i = 3;
      }
      break;
    case 242469426: 
      if (str.equals("stream_finish")) {
        i = 2;
      }
      break;
    case -255557448: 
      if (str.equals("channel_motor_status")) {
        i = 1;
      }
      break;
    case -1172151021: 
      if (str.equals("device_locked")) {
        i = 0;
      }
      break;
    }
    switch (i)
    {
    default: 
      break;
    case 4: 
      boolean bool = "on".equals(((ChannelLensMaskInfo)paramStreamControlNotification.getResult()).getEnabled());
      q.f0(Integer.valueOf(1)).l0(io.reactivex.d0.b.a.a()).G0(new a(this, paramString, bool));
      break;
    case 3: 
      q.f0(Integer.valueOf(1)).l0(io.reactivex.d0.b.a.a()).G0(new e(this, paramString, paramStreamControlNotification));
      break;
    case 2: 
      paramStreamControlNotification = (StreamFinish)paramStreamControlNotification.getResult();
      q.f0(Integer.valueOf(1)).l0(io.reactivex.d0.b.a.a()).G0(new i(this, paramString, paramStreamControlNotification));
      break;
    case 1: 
      paramStreamControlNotification = ((ChannelMotorStatus)paramStreamControlNotification.getResult()).getStatus();
      if ((paramStreamControlNotification != null) && (!paramStreamControlNotification.isEmpty())) {
        q.f0((String)paramStreamControlNotification.get(0)).l0(io.reactivex.d0.b.a.a()).G0(new g(this, paramString));
      }
      break;
    case 0: 
      paramStreamControlNotification = (DeviceLockedInfo)paramStreamControlNotification.getResult();
      q.f0(Integer.valueOf(1)).l0(io.reactivex.d0.b.a.a()).G0(new b(this, paramString, paramStreamControlNotification));
    }
  }
  
  public void E()
  {
    a = 1;
    b.d.p.d.a("StreamControlClient", "resetSequence ");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mObservableMap size ");
    localStringBuilder.append(this.b.size());
    b.d.p.d.a("StreamControlClient", localStringBuilder.toString());
    this.b.clear();
  }
  
  public q<GetDownloadResponse> F(b.d.i.a.a.f paramf, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    GetDownloadParams localGetDownloadParams = new GetDownloadParams();
    localGetDownloadParams.setChannels(Collections.singletonList(Integer.valueOf(0)));
    localGetDownloadParams.setClientId(paramInt1);
    localGetDownloadParams.setMediaType(Integer.valueOf(paramInt2));
    localGetDownloadParams.setStartTime(paramString2);
    paramString2 = new GetDownloadRequest();
    paramString2.setDownload(localGetDownloadParams);
    return B(new StreamControlRequest(paramString2), GetDownloadResponse.class, "download_type", paramf, paramString1).g0(l.c);
  }
  
  public void G(StreamNotificationCallback paramStreamNotificationCallback)
  {
    this.c = paramStreamNotificationCallback;
  }
  
  public void a(String paramString, StreamControlNotification<Object> paramStreamControlNotification)
  {
    h(paramString, paramStreamControlNotification);
  }
  
  public int b()
  {
    return g();
  }
  
  public void c(CommonPayload paramCommonPayload)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramCommonPayload.getSeq());
    ((StringBuilder)localObject1).append("");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onReceiveResponse seq ");
    ((StringBuilder)localObject2).append((String)localObject1);
    b.d.p.d.a("StreamControlClient", ((StringBuilder)localObject2).toString());
    localObject2 = (r)this.b.get(localObject1);
    if (localObject2 != null)
    {
      this.b.remove(localObject1);
      ((io.reactivex.g)localObject2).onNext(paramCommonPayload);
      ((io.reactivex.g)localObject2).onComplete();
    }
    paramCommonPayload = new StringBuilder();
    paramCommonPayload.append("onReceiveResponse mObservableMap ");
    paramCommonPayload.append(this.b.size());
    b.d.p.d.a("StreamControlClient", paramCommonPayload.toString());
  }
  
  public q<DoPlayResponse> d(b.d.i.a.a.f paramf, String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    DoPlayParams localDoPlayParams = new DoPlayParams();
    localDoPlayParams.setScale(paramString2);
    if (paramLong1 <= 0L) {
      return q.J(new Exception("playback start time must invalid"));
    }
    localDoPlayParams.setStartTime(String.valueOf(paramLong1));
    if (paramLong2 > 0L) {
      localDoPlayParams.setEndTime(String.valueOf(paramLong2));
    }
    paramString2 = new DoPlayRequest();
    paramString2.setPlay(localDoPlayParams);
    return B(new StreamControlRequest(paramString2), DoPlayResponse.class, "playback_type", paramf, paramString1).g0(k.c);
  }
  
  public q<Response> e(b.d.i.a.a.f paramf, String paramString1, BitStreamType paramBitStreamType, String paramString2)
  {
    GetPreviewParams localGetPreviewParams = new GetPreviewParams();
    localGetPreviewParams.setChannels(Collections.singletonList(Integer.valueOf(0)));
    BitStreamType localBitStreamType = paramBitStreamType;
    if (paramBitStreamType == null) {
      localBitStreamType = b.d.d.e.a.b(paramString1);
    }
    paramBitStreamType = paramString2;
    if (paramString2 == null) {
      paramBitStreamType = "default";
    }
    localGetPreviewParams.setResolutions(Collections.singletonList(localBitStreamType.getValue()));
    localGetPreviewParams.setAudio(Collections.singletonList(paramBitStreamType));
    paramBitStreamType = new DoChangeResolutionsRequest();
    paramBitStreamType.setChangeResolutions(localGetPreviewParams);
    return C(new StreamControlRequest(paramBitStreamType), GetPreviewResponse.class, "preview_type", paramf, paramString1, 60).g0(m.c);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\i\a\b\c\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */