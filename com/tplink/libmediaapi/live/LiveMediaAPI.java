package com.tplink.libmediaapi.live;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableLong;
import androidx.lifecycle.MutableLiveData;
import com.tplink.libmediaapi.common.apicallback.DoubleTalkStreamCallback;
import com.tplink.libmediaapi.common.apicallback.OnConnectionTypeChangeListener;
import com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback;
import com.tplink.libmediaapi.common.apicallback.StreamNotificationCallback;
import com.tplink.libmediaapi.live.repo.LiveMediaRepository;
import com.tplink.libmediaapi.live.repo.TalkMediaRepository;
import com.tplink.libtpappcommonmedia.bean.stream.BitStreamType;
import com.tplink.libtpmediamanager.ConnectionTypeManager;
import com.tplink.libtpmediamanager.RelayTimerManager;
import com.tplink.libtpstreamclientmanager.m;
import java.util.Iterator;
import java.util.List;

public class LiveMediaAPI
{
  public static void addDoubleTalkStreamCallback(String paramString, DoubleTalkStreamCallback paramDoubleTalkStreamCallback)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ((TalkMediaRepository)com.tplink.libtpmediamanager.g.d.b(paramString, TalkMediaRepository.class)).addDoubleTalkStreamCallback(paramString, paramDoubleTalkStreamCallback);
  }
  
  public static void addSteamDisplayCommonCallback(String paramString, int paramInt, StreamDisplayCommonCallback paramStreamDisplayCommonCallback)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ((LiveMediaRepository)com.tplink.libtpmediamanager.g.d.b(paramString, LiveMediaRepository.class)).addSteamDisplayCommonCallback(paramInt, paramStreamDisplayCommonCallback);
  }
  
  public static void addSteamDisplayCommonCallback(String paramString, StreamDisplayCommonCallback paramStreamDisplayCommonCallback)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ((LiveMediaRepository)com.tplink.libtpmediamanager.g.d.b(paramString, LiveMediaRepository.class)).addSteamDisplayCommonCallback(paramStreamDisplayCommonCallback);
  }
  
  public static void allDisplayScreenshotPreview()
  {
    com.tplink.libtpmediamanager.f.j().g();
  }
  
  public static void bindCallingVariable(@Nullable ObservableBoolean paramObservableBoolean)
  {
    RelayTimerManager.INSTANCE.bindCallingVariable(paramObservableBoolean);
  }
  
  public static void bindRecordingVariable(@Nullable ObservableBoolean paramObservableBoolean)
  {
    RelayTimerManager.INSTANCE.bindRecordingVariable(paramObservableBoolean);
  }
  
  public static void changePreviewResolutions(String paramString1, BitStreamType paramBitStreamType, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    ((LiveMediaRepository)com.tplink.libtpmediamanager.g.d.b(paramString1, LiveMediaRepository.class)).changePreviewResolutions(paramString1, paramBitStreamType, paramString2);
  }
  
  public static void clearCommonCallback(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ((LiveMediaRepository)com.tplink.libtpmediamanager.g.d.b(paramString, LiveMediaRepository.class)).clearCommonCallback();
  }
  
  public static void destroyAllDisplay()
  {
    Iterator localIterator = com.tplink.libtpmediamanager.f.j().i().iterator();
    while (localIterator.hasNext()) {
      clearCommonCallback((String)localIterator.next());
    }
  }
  
  public static void destroyAllDisplayAndStream()
  {
    destroyAllDisplay();
    m.V().O();
  }
  
  public static void destroyAllDoubleTalkClient()
  {
    com.tplink.libtpmediamanager.d.h().e();
  }
  
  public static void destroyDoubleTalkClient(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ((TalkMediaRepository)com.tplink.libtpmediamanager.g.d.b(paramString, TalkMediaRepository.class)).destroyDoubleTalkClient(paramString);
  }
  
  public static void disableRelayTimer()
  {
    RelayTimerManager.INSTANCE.disableRelayTimer();
  }
  
  public static void enableRelayTimer()
  {
    RelayTimerManager.INSTANCE.enableRelayTimer();
  }
  
  public static ObservableBoolean getCallingObservable()
  {
    return RelayTimerManager.INSTANCE.getCallingObservable();
  }
  
  public static int getConnectType(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -1;
    }
    return ((LiveMediaRepository)com.tplink.libtpmediamanager.g.d.b(paramString, LiveMediaRepository.class)).getConnectType();
  }
  
  public static int getConnectionType(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -1;
    }
    return ((LiveMediaRepository)com.tplink.libtpmediamanager.g.d.b(paramString, LiveMediaRepository.class)).getConnectionType(paramString);
  }
  
  public static int getMultiDeviceTimeoutSeconds()
  {
    RelayTimerManager localRelayTimerManager = RelayTimerManager.INSTANCE;
    return 120;
  }
  
  public static List<String> getPlayingDevices()
  {
    return com.tplink.libtpmediamanager.f.j().k();
  }
  
  public static ObservableLong getRecordDuration(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new ObservableLong();
    }
    return ((LiveMediaRepository)com.tplink.libtpmediamanager.g.d.b(paramString, LiveMediaRepository.class)).getRecordDuration();
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
  
  public static boolean isPlayingProperly(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return ((LiveMediaRepository)com.tplink.libtpmediamanager.g.d.b(paramString, LiveMediaRepository.class)).isPlayingProperly();
  }
  
  public static boolean isRecording(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return ((LiveMediaRepository)com.tplink.libtpmediamanager.g.d.b(paramString, LiveMediaRepository.class)).isRecording();
  }
  
  public static ObservableBoolean isRecordingObservable(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new ObservableBoolean();
    }
    return ((LiveMediaRepository)com.tplink.libtpmediamanager.g.d.b(paramString, LiveMediaRepository.class)).isRecordingObservable();
  }
  
  public static void keepDoubleTalk(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ((LiveMediaRepository)com.tplink.libtpmediamanager.g.d.b(paramString, LiveMediaRepository.class)).keepDoubleTalk(paramString);
  }
  
  public static boolean lockLiveStreamAudio()
  {
    return com.tplink.libtpmediamanager.f.j().n();
  }
  
  public static void muteAudio(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ((LiveMediaRepository)com.tplink.libtpmediamanager.g.d.b(paramString, LiveMediaRepository.class)).muteAudio(paramString, paramBoolean);
  }
  
  public static void muteRecordAudio(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ((TalkMediaRepository)com.tplink.libtpmediamanager.g.d.b(paramString, TalkMediaRepository.class)).muteRecordAudio(paramBoolean);
  }
  
  public static void muteVolume(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ((LiveMediaRepository)com.tplink.libtpmediamanager.g.d.b(paramString, LiveMediaRepository.class)).muteVolume(paramString, paramBoolean);
  }
  
  public static void onDetectPipePause()
  {
    b.d.o.a.f.m().o();
  }
  
  public static void onDetectPipeResume()
  {
    b.d.o.a.f.m().p();
  }
  
  public static void onNetworkChanged()
  {
    b.d.o.a.f.m().u();
    b.d.a0.a.f.c().h();
    b.d.o.a.f.m().n();
    b.d.o.a.f.m().r();
    b.d.a0.a.f.c().d();
  }
  
  public static void openDoubleTalkClient(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    ((TalkMediaRepository)com.tplink.libtpmediamanager.g.d.b(paramString1, TalkMediaRepository.class)).openDoubleTalkClient(paramString1, paramString2);
  }
  
  public static void pause(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ((LiveMediaRepository)com.tplink.libtpmediamanager.g.d.b(paramString, LiveMediaRepository.class)).pause();
  }
  
  public static void pauseSendAudio(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ((TalkMediaRepository)com.tplink.libtpmediamanager.g.d.b(paramString, TalkMediaRepository.class)).pauseSendAudio();
  }
  
  public static void previewCapture(String paramString, MutableLiveData<b.d.d.m.f<String>> paramMutableLiveData)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ((LiveMediaRepository)com.tplink.libtpmediamanager.g.d.b(paramString, LiveMediaRepository.class)).previewCapture(paramMutableLiveData);
  }
  
  public static void previewScreenShot(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ((LiveMediaRepository)com.tplink.libtpmediamanager.g.d.b(paramString, LiveMediaRepository.class)).previewScreenShot();
  }
  
  public static void releaseStream(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ((LiveMediaRepository)com.tplink.libtpmediamanager.g.d.b(paramString, LiveMediaRepository.class)).releaseStream(paramString);
  }
  
  public static void removeSteamDisplayCommonCallback(String paramString, StreamDisplayCommonCallback paramStreamDisplayCommonCallback)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ((LiveMediaRepository)com.tplink.libtpmediamanager.g.d.b(paramString, LiveMediaRepository.class)).removeSteamDisplayCommonCallback(paramStreamDisplayCommonCallback);
  }
  
  public static void resetPipeErrorStatus()
  {
    b.d.o.a.f.m().u();
    b.d.a0.a.f.c().h();
  }
  
  public static void resume(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ((LiveMediaRepository)com.tplink.libtpmediamanager.g.d.b(paramString, LiveMediaRepository.class)).resume();
  }
  
  public static void setConnectionTypeListener(OnConnectionTypeChangeListener paramOnConnectionTypeChangeListener)
  {
    if (paramOnConnectionTypeChangeListener != null) {
      ConnectionTypeManager.INSTANCE.setListener(new a(paramOnConnectionTypeChangeListener));
    } else {
      ConnectionTypeManager.INSTANCE.setListener(null);
    }
  }
  
  public static void setConnectionTypeListenerEnable(boolean paramBoolean)
  {
    ConnectionTypeManager.INSTANCE.setEnabled(paramBoolean);
  }
  
  public static void setMaxVolume(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ((TalkMediaRepository)com.tplink.libtpmediamanager.g.d.b(paramString, TalkMediaRepository.class)).setMaxVolume(paramInt);
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
    ((LiveMediaRepository)com.tplink.libtpmediamanager.g.d.b(paramString, LiveMediaRepository.class)).setStreamControlNotificationCallback(paramString, paramStreamNotificationCallback);
  }
  
  public static void setVolume(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ((TalkMediaRepository)com.tplink.libtpmediamanager.g.d.b(paramString, TalkMediaRepository.class)).setVolume(paramInt);
  }
  
  public static void snapshot(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ((LiveMediaRepository)com.tplink.libtpmediamanager.g.d.b(paramString, LiveMediaRepository.class)).snapshot();
  }
  
  public static void snapshot(String paramString, MutableLiveData<b.d.d.m.f<Pair<Bitmap, String>>> paramMutableLiveData)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ((LiveMediaRepository)com.tplink.libtpmediamanager.g.d.b(paramString, LiveMediaRepository.class)).snapshot(paramMutableLiveData);
  }
  
  public static void startHoldToTalk(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ((LiveMediaRepository)com.tplink.libtpmediamanager.g.d.b(paramString, LiveMediaRepository.class)).startHoldToTalk();
  }
  
  public static void startLiveStreamDisplay(String paramString, Context paramContext, BitStreamType paramBitStreamType)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ((LiveMediaRepository)com.tplink.libtpmediamanager.g.d.b(paramString, LiveMediaRepository.class)).startLiveStreamDisplay(paramString, paramContext, paramBitStreamType);
  }
  
  public static void startRecord(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ((LiveMediaRepository)com.tplink.libtpmediamanager.g.d.b(paramString, LiveMediaRepository.class)).startRecord();
  }
  
  public static void startSendAudio(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ((TalkMediaRepository)com.tplink.libtpmediamanager.g.d.b(paramString, TalkMediaRepository.class)).startSendAudio();
  }
  
  public static void stopDisplay(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ((LiveMediaRepository)com.tplink.libtpmediamanager.g.d.b(paramString, LiveMediaRepository.class)).stopDisplay(paramString);
  }
  
  public static void stopHoldToTalk(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ((LiveMediaRepository)com.tplink.libtpmediamanager.g.d.b(paramString, LiveMediaRepository.class)).stopHoldToTalk();
  }
  
  public static void stopKeepDoubleTalk(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ((LiveMediaRepository)com.tplink.libtpmediamanager.g.d.b(paramString, LiveMediaRepository.class)).stopKeepDoubleTalk(paramString);
  }
  
  public static void stopNetworkStatics(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ((LiveMediaRepository)com.tplink.libtpmediamanager.g.d.b(paramString, LiveMediaRepository.class)).stopNetworkStatics();
  }
  
  public static void stopRecord(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ((LiveMediaRepository)com.tplink.libtpmediamanager.g.d.b(paramString, LiveMediaRepository.class)).stopRecord();
  }
  
  public static boolean unlockLiveStreamAudio()
  {
    return com.tplink.libtpmediamanager.f.j().u();
  }
  
  public static void updateAudioVolume(String paramString, float paramFloat1, float paramFloat2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ((LiveMediaRepository)com.tplink.libtpmediamanager.g.d.b(paramString, LiveMediaRepository.class)).updateAudioVolume(paramFloat1, paramFloat2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libmediaapi\live\LiveMediaAPI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */