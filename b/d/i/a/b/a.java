package b.d.i.a.b;

import androidx.annotation.NonNull;
import com.tplink.libtpappcommonmedia.bean.stream.BitStreamType;
import com.tplink.libtpcommonstream.stream.control.common.StreamControlRequest;
import com.tplink.libtpcommonstream.stream.control.request.GetDownloadRequest;
import com.tplink.libtpcommonstream.stream.control.request.GetPlaybackRequest;
import com.tplink.libtpcommonstream.stream.control.request.GetPreviewRequest;
import com.tplink.libtpcommonstream.stream.control.request.GetTalkRequest;
import com.tplink.libtpcommonstream.stream.control.request.param.GetDownloadParams;
import com.tplink.libtpcommonstream.stream.control.request.param.GetPreviewParams;
import com.tplink.libtpcommonstream.stream.control.request.param.GetTalkParams;
import com.tplink.libtpcommonstream.stream.control.request.param.GetVodParams;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class a
{
  public static String a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    GetDownloadParams localGetDownloadParams = new GetDownloadParams();
    localGetDownloadParams.setChannels(Collections.singletonList(Integer.valueOf(0)));
    localGetDownloadParams.setClientId(paramInt1);
    localGetDownloadParams.setMediaType(Integer.valueOf(paramInt2));
    localGetDownloadParams.setStartTime(paramString);
    paramString = new GetDownloadRequest();
    paramString.setDownload(localGetDownloadParams);
    paramString = new StreamControlRequest(paramString);
    paramString.setSeq(paramInt3);
    return b.d(paramString);
  }
  
  public static String b(int paramInt1, String paramString, @NonNull int[] paramArrayOfInt, long paramLong1, long paramLong2, int paramInt2)
  {
    GetVodParams localGetVodParams = new GetVodParams();
    int i = 0;
    localGetVodParams.setChannels(Collections.singletonList(Integer.valueOf(0)));
    localGetVodParams.setClientId(paramInt1);
    localGetVodParams.setScale(paramString);
    paramString = new ArrayList();
    for (paramInt1 = i; paramInt1 < paramArrayOfInt.length; paramInt1++) {
      paramString.add(Integer.valueOf(paramArrayOfInt[paramInt1]));
    }
    localGetVodParams.setEventType(paramString);
    if (paramLong1 <= 0L) {
      return null;
    }
    localGetVodParams.setStartTime(String.valueOf(paramLong1));
    if (paramLong2 > 0L) {
      localGetVodParams.setEndTime(String.valueOf(paramLong2));
    }
    paramString = new GetPlaybackRequest();
    paramString.setPlayback(localGetVodParams);
    paramString = new StreamControlRequest(paramString);
    paramString.setSeq(paramInt2);
    return b.d(paramString);
  }
  
  public static String c(String paramString1, BitStreamType paramBitStreamType, String paramString2, int paramInt)
  {
    GetPreviewParams localGetPreviewParams = new GetPreviewParams();
    localGetPreviewParams.setChannels(Collections.singletonList(Integer.valueOf(0)));
    BitStreamType localBitStreamType = paramBitStreamType;
    if (paramBitStreamType == null) {
      localBitStreamType = b.d.d.e.a.b(paramString1);
    }
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "default";
    }
    localGetPreviewParams.setResolutions(Collections.singletonList(localBitStreamType.getValue()));
    localGetPreviewParams.setAudio(Collections.singletonList(paramString1));
    paramString1 = new GetPreviewRequest();
    paramString1.setPreview(localGetPreviewParams);
    paramString1 = new StreamControlRequest(paramString1);
    paramString1.setSeq(paramInt);
    return b.d(paramString1);
  }
  
  public static String d(String paramString1, String paramString2, int paramInt)
  {
    paramString1 = new GetTalkParams();
    paramString1.setMode(paramString2);
    paramString2 = new GetTalkRequest();
    paramString2.setTalk(paramString1);
    paramString1 = new StreamControlRequest(paramString2);
    paramString1.setSeq(paramInt);
    return b.d(paramString1);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\i\a\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */