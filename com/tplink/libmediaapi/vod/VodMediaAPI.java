package com.tplink.libmediaapi.vod;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.databinding.ObservableBoolean;
import b.d.l.a;
import com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback;
import com.tplink.libmediaapi.common.apicallback.StreamNotificationCallback;
import com.tplink.libmediaapi.common.apicallback.VodStreamDisplayCallback;
import com.tplink.libmediaapi.vod.repo.VodMediaRepository;
import com.tplink.libtpimagedownloadmedia.loader.g;
import com.tplink.libtpmediamanager.RelayTimerManager;
import com.tplink.libtpmediamanager.g.d;

public class VodMediaAPI
{
  public static void addSteamDisplayCommonCallback(String paramString, StreamDisplayCommonCallback paramStreamDisplayCommonCallback)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ((VodMediaRepository)d.b(paramString, VodMediaRepository.class)).addSteamDisplayCommonCallback(paramString, paramStreamDisplayCommonCallback);
  }
  
  public static void bindCallingVariable(@Nullable ObservableBoolean paramObservableBoolean)
  {
    RelayTimerManager.INSTANCE.bindCallingVariable(paramObservableBoolean);
  }
  
  public static void bindRecordingVariable(@Nullable ObservableBoolean paramObservableBoolean)
  {
    RelayTimerManager.INSTANCE.bindRecordingVariable(paramObservableBoolean);
  }
  
  public static void changeVodPlayRate(String paramString1, String paramString2, long paramLong)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    ((VodMediaRepository)d.b(paramString1, VodMediaRepository.class)).changeVodPlayRate(paramString1, paramString2, paramLong);
  }
  
  public static void clearPlayerCache(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ((VodMediaRepository)d.b(paramString, VodMediaRepository.class)).clearPlayerCache();
  }
  
  public static void disableRelayTimer()
  {
    RelayTimerManager.INSTANCE.disableRelayTimer();
  }
  
  public static void downloadImageIntoView(g paramg, ImageView paramImageView, int paramInt)
  {
    if ((paramg != null) && (!TextUtils.isEmpty(paramg.b()))) {
      ((VodMediaRepository)d.b(paramg.b(), VodMediaRepository.class)).downloadImageIntoView(paramg, paramImageView, paramInt);
    }
  }
  
  public static void enableRelayTimer()
  {
    RelayTimerManager.INSTANCE.enableRelayTimer();
  }
  
  public static ObservableBoolean getCallingObservable()
  {
    return RelayTimerManager.INSTANCE.getCallingObservable();
  }
  
  public static int getMultiDeviceTimeoutSeconds()
  {
    RelayTimerManager localRelayTimerManager = RelayTimerManager.INSTANCE;
    return 120;
  }
  
  public static ObservableBoolean getRecordingObservable()
  {
    return RelayTimerManager.INSTANCE.getRecordingObservable();
  }
  
  public static int getSingleDeviceTimeoutSeconds()
  {
    RelayTimerManager localRelayTimerManager = RelayTimerManager.INSTANCE;
    return 300;
  }
  
  public static boolean isFlushing(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return ((VodMediaRepository)d.b(paramString, VodMediaRepository.class)).isFlushing();
  }
  
  public static boolean isStreamAlive(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return ((VodMediaRepository)d.b(paramString, VodMediaRepository.class)).isStreamAlive(paramString);
  }
  
  public static void muteAudio(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ((VodMediaRepository)d.b(paramString, VodMediaRepository.class)).muteAudio(paramBoolean);
  }
  
  public static void pauseDisplay(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ((VodMediaRepository)d.b(paramString, VodMediaRepository.class)).pauseDisplay();
  }
  
  public static void releaseDownloadImage()
  {
    a.b().c();
  }
  
  public static void releaseStream(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ((VodMediaRepository)d.b(paramString, VodMediaRepository.class)).releaseStream(paramString);
  }
  
  public static void resumeDisplay(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ((VodMediaRepository)d.b(paramString, VodMediaRepository.class)).resumeDisplay();
  }
  
  public static void seekVodStreamDisplay(String paramString1, int paramInt, long paramLong, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    ((VodMediaRepository)d.b(paramString1, VodMediaRepository.class)).seekVodStreamDisplay(paramString1, paramInt, paramLong, paramString2);
  }
  
  public static void setPlayInPreviewPage(boolean paramBoolean)
  {
    RelayTimerManager.INSTANCE.setPlayInPreviewPage(paramBoolean);
  }
  
  public static void setStreamControlNotificationCallback(String paramString, StreamNotificationCallback paramStreamNotificationCallback)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ((VodMediaRepository)d.b(paramString, VodMediaRepository.class)).setStreamControlNotificationCallback(paramString, paramStreamNotificationCallback);
  }
  
  public static void setVodStreamDisplayCallback(String paramString, VodStreamDisplayCallback paramVodStreamDisplayCallback)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ((VodMediaRepository)d.b(paramString, VodMediaRepository.class)).setVodStreamDisplayCallback(paramVodStreamDisplayCallback);
  }
  
  public static void snapshot(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ((VodMediaRepository)d.b(paramString, VodMediaRepository.class)).snapshot();
  }
  
  public static void startRecord(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ((VodMediaRepository)d.b(paramString, VodMediaRepository.class)).startRecord();
  }
  
  public static void startVodStreamDisplay(String paramString1, Context paramContext, long paramLong, int paramInt, int[] paramArrayOfInt, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    ((VodMediaRepository)d.b(paramString1, VodMediaRepository.class)).startVodStreamDisplay(paramString1, paramContext, paramLong, paramInt, paramArrayOfInt, paramString2);
  }
  
  public static void stopDisplay(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ((VodMediaRepository)d.b(paramString, VodMediaRepository.class)).stopDisplay(paramString);
  }
  
  public static void stopRecord(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ((VodMediaRepository)d.b(paramString, VodMediaRepository.class)).stopRecord();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libmediaapi\vod\VodMediaAPI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */