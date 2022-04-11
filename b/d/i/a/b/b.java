package b.d.i.a.b;

import com.google.gson.Gson;
import com.google.gson.d;
import com.google.gson.i;
import com.tplink.libtpcommonstream.stream.control.common.CommonPayload;
import com.tplink.libtpcommonstream.stream.control.common.StreamControlNotification;
import com.tplink.libtpcommonstream.stream.control.common.StreamControlRequest;
import com.tplink.libtpcommonstream.stream.control.common.StreamControlResponse;
import com.tplink.libtpcommonstream.stream.control.notification.ChannelLensMaskInfo;
import com.tplink.libtpcommonstream.stream.control.notification.ChannelMotorStatus;
import com.tplink.libtpcommonstream.stream.control.notification.ChannelPassengerFlowInfo;
import com.tplink.libtpcommonstream.stream.control.notification.ChannelPreviewParams;
import com.tplink.libtpcommonstream.stream.control.notification.ChannelSmartCodecInfo;
import com.tplink.libtpcommonstream.stream.control.notification.ChannelStreamStatus;
import com.tplink.libtpcommonstream.stream.control.notification.DeviceLockedInfo;
import com.tplink.libtpcommonstream.stream.control.notification.StreamFinish;
import com.tplink.libtpcommonstream.stream.control.notification.StreamStatus;
import com.tplink.libtpcommonstream.stream.control.notification.UnsupportAudio;
import java.util.HashMap;
import java.util.Map;

public class b
{
  private static Map<String, Class> a;
  
  static
  {
    HashMap localHashMap = new HashMap();
    a = localHashMap;
    localHashMap.put("stream_status", StreamStatus.class);
    a.put("stream_sequence", String.class);
    a.put("stream_finish", StreamFinish.class);
    a.put("internal_error", InternalError.class);
    a.put("channel_preview_params", ChannelPreviewParams.class);
    a.put("channel_stream_status", ChannelStreamStatus.class);
    a.put("channel_lens_mask_info", ChannelLensMaskInfo.class);
    a.put("channel_smart_codec_info", ChannelSmartCodecInfo.class);
    a.put("channel_passenger_flow_info", ChannelPassengerFlowInfo.class);
    a.put("channel_motor_status", ChannelMotorStatus.class);
    a.put("unsupport_audio", UnsupportAudio.class);
    a.put("device_locked", DeviceLockedInfo.class);
  }
  
  public static <T> T a(i parami, Class<T> paramClass)
  {
    return (T)f().g(parami, paramClass);
  }
  
  public static <T> T b(String paramString, Class<T> paramClass)
  {
    return (T)f().l(paramString, paramClass);
  }
  
  public static StreamControlNotification<Object> c(CommonPayload paramCommonPayload)
  {
    if ((paramCommonPayload != null) && (paramCommonPayload.getParams() != null) && ("notification".equals(paramCommonPayload.getType())))
    {
      StreamControlNotification localStreamControlNotification = (StreamControlNotification)a(paramCommonPayload.getParams(), StreamControlNotification.class);
      if ((localStreamControlNotification.getEventType() != null) && (a.containsKey(localStreamControlNotification.getEventType())))
      {
        Class localClass = (Class)a.get(localStreamControlNotification.getEventType());
        paramCommonPayload = a(paramCommonPayload.getParams(), localClass);
        return new StreamControlNotification(localStreamControlNotification.getEventType(), paramCommonPayload);
      }
      return localStreamControlNotification;
    }
    return null;
  }
  
  public static <T> String d(StreamControlRequest<T> paramStreamControlRequest)
  {
    return f().v(paramStreamControlRequest, StreamControlRequest.class);
  }
  
  public static <T> StreamControlResponse<T> e(CommonPayload paramCommonPayload, Class<T> paramClass)
  {
    StreamControlResponse localStreamControlResponse = new StreamControlResponse();
    localStreamControlResponse.setSeq(paramCommonPayload.getSeq());
    localStreamControlResponse.setType(paramCommonPayload.getType());
    localStreamControlResponse.setResult(f().g(paramCommonPayload.getParams(), paramClass));
    return localStreamControlResponse;
  }
  
  public static Gson f()
  {
    return new d().c().b();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\i\a\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */