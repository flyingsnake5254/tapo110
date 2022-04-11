package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.media.MediaMetadata;
import android.media.Rating;
import android.media.session.MediaController;
import android.media.session.MediaController.Callback;
import android.media.session.MediaController.PlaybackInfo;
import android.media.session.MediaController.TransportControls;
import android.media.session.MediaSession.QueueItem;
import android.media.session.MediaSession.Token;
import android.media.session.PlaybackState;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.app.BundleCompat;
import androidx.media.AudioAttributesCompat;
import androidx.media.AudioAttributesCompat.Builder;
import androidx.media.R.id;
import androidx.versionedparcelable.ParcelUtils;
import androidx.versionedparcelable.VersionedParcelable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public final class MediaControllerCompat
{
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public static final String COMMAND_ADD_QUEUE_ITEM = "android.support.v4.media.session.command.ADD_QUEUE_ITEM";
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public static final String COMMAND_ADD_QUEUE_ITEM_AT = "android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT";
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public static final String COMMAND_ARGUMENT_INDEX = "android.support.v4.media.session.command.ARGUMENT_INDEX";
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public static final String COMMAND_ARGUMENT_MEDIA_DESCRIPTION = "android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION";
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public static final String COMMAND_GET_EXTRA_BINDER = "android.support.v4.media.session.command.GET_EXTRA_BINDER";
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public static final String COMMAND_REMOVE_QUEUE_ITEM = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM";
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public static final String COMMAND_REMOVE_QUEUE_ITEM_AT = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT";
  static final String TAG = "MediaControllerCompat";
  private final MediaControllerImpl mImpl;
  @SuppressLint({"BanConcurrentHashMap"})
  private final ConcurrentHashMap<Callback, Boolean> mRegisteredCallbacks = new ConcurrentHashMap();
  private final MediaSessionCompat.Token mToken;
  
  public MediaControllerCompat(Context paramContext, @NonNull MediaSessionCompat.Token paramToken)
  {
    if (paramToken != null)
    {
      this.mToken = paramToken;
      if (Build.VERSION.SDK_INT >= 21) {
        this.mImpl = new MediaControllerImplApi21(paramContext, paramToken);
      } else {
        this.mImpl = new MediaControllerImplBase(paramToken);
      }
      return;
    }
    throw new IllegalArgumentException("sessionToken must not be null");
  }
  
  public MediaControllerCompat(Context paramContext, @NonNull MediaSessionCompat paramMediaSessionCompat)
  {
    if (paramMediaSessionCompat != null)
    {
      paramMediaSessionCompat = paramMediaSessionCompat.getSessionToken();
      this.mToken = paramMediaSessionCompat;
      if (Build.VERSION.SDK_INT >= 21) {
        this.mImpl = new MediaControllerImplApi21(paramContext, paramMediaSessionCompat);
      } else {
        this.mImpl = new MediaControllerImplBase(paramMediaSessionCompat);
      }
      return;
    }
    throw new IllegalArgumentException("session must not be null");
  }
  
  public static MediaControllerCompat getMediaController(@NonNull Activity paramActivity)
  {
    Object localObject = paramActivity.getWindow().getDecorView().getTag(R.id.media_controller_compat_view_tag);
    if ((localObject instanceof MediaControllerCompat)) {
      return (MediaControllerCompat)localObject;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject = paramActivity.getMediaController();
      if (localObject == null) {
        return null;
      }
      return new MediaControllerCompat(paramActivity, MediaSessionCompat.Token.fromToken(((MediaController)localObject).getSessionToken()));
    }
    return null;
  }
  
  public static void setMediaController(@NonNull Activity paramActivity, MediaControllerCompat paramMediaControllerCompat)
  {
    paramActivity.getWindow().getDecorView().setTag(R.id.media_controller_compat_view_tag, paramMediaControllerCompat);
    if (Build.VERSION.SDK_INT >= 21)
    {
      MediaController localMediaController = null;
      if (paramMediaControllerCompat != null) {
        localMediaController = new MediaController(paramActivity, (MediaSession.Token)paramMediaControllerCompat.getSessionToken().getToken());
      }
      paramActivity.setMediaController(localMediaController);
    }
  }
  
  static void validateCustomAction(String paramString, Bundle paramBundle)
  {
    if (paramString == null) {
      return;
    }
    if (((!paramString.equals("android.support.v4.media.session.action.FOLLOW")) && (!paramString.equals("android.support.v4.media.session.action.UNFOLLOW"))) || ((paramBundle != null) && (paramBundle.containsKey("android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE")))) {
      return;
    }
    paramBundle = new StringBuilder();
    paramBundle.append("An extra field android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE is required for this action ");
    paramBundle.append(paramString);
    paramBundle.append(".");
    throw new IllegalArgumentException(paramBundle.toString());
  }
  
  public void addQueueItem(MediaDescriptionCompat paramMediaDescriptionCompat)
  {
    this.mImpl.addQueueItem(paramMediaDescriptionCompat);
  }
  
  public void addQueueItem(MediaDescriptionCompat paramMediaDescriptionCompat, int paramInt)
  {
    this.mImpl.addQueueItem(paramMediaDescriptionCompat, paramInt);
  }
  
  public void adjustVolume(int paramInt1, int paramInt2)
  {
    this.mImpl.adjustVolume(paramInt1, paramInt2);
  }
  
  public boolean dispatchMediaButtonEvent(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent != null) {
      return this.mImpl.dispatchMediaButtonEvent(paramKeyEvent);
    }
    throw new IllegalArgumentException("KeyEvent may not be null");
  }
  
  public Bundle getExtras()
  {
    return this.mImpl.getExtras();
  }
  
  public long getFlags()
  {
    return this.mImpl.getFlags();
  }
  
  public Object getMediaController()
  {
    return this.mImpl.getMediaController();
  }
  
  public MediaMetadataCompat getMetadata()
  {
    return this.mImpl.getMetadata();
  }
  
  public String getPackageName()
  {
    return this.mImpl.getPackageName();
  }
  
  public PlaybackInfo getPlaybackInfo()
  {
    return this.mImpl.getPlaybackInfo();
  }
  
  public PlaybackStateCompat getPlaybackState()
  {
    return this.mImpl.getPlaybackState();
  }
  
  public List<MediaSessionCompat.QueueItem> getQueue()
  {
    return this.mImpl.getQueue();
  }
  
  public CharSequence getQueueTitle()
  {
    return this.mImpl.getQueueTitle();
  }
  
  public int getRatingType()
  {
    return this.mImpl.getRatingType();
  }
  
  public int getRepeatMode()
  {
    return this.mImpl.getRepeatMode();
  }
  
  @Nullable
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public VersionedParcelable getSession2Token()
  {
    return this.mToken.getSession2Token();
  }
  
  public PendingIntent getSessionActivity()
  {
    return this.mImpl.getSessionActivity();
  }
  
  @NonNull
  public Bundle getSessionInfo()
  {
    return this.mImpl.getSessionInfo();
  }
  
  public MediaSessionCompat.Token getSessionToken()
  {
    return this.mToken;
  }
  
  public int getShuffleMode()
  {
    return this.mImpl.getShuffleMode();
  }
  
  public TransportControls getTransportControls()
  {
    return this.mImpl.getTransportControls();
  }
  
  public boolean isCaptioningEnabled()
  {
    return this.mImpl.isCaptioningEnabled();
  }
  
  public boolean isSessionReady()
  {
    return this.mImpl.isSessionReady();
  }
  
  public void registerCallback(@NonNull Callback paramCallback)
  {
    registerCallback(paramCallback, null);
  }
  
  public void registerCallback(@NonNull Callback paramCallback, Handler paramHandler)
  {
    if (paramCallback != null)
    {
      if (this.mRegisteredCallbacks.putIfAbsent(paramCallback, Boolean.TRUE) != null)
      {
        Log.w("MediaControllerCompat", "the callback has already been registered");
        return;
      }
      Handler localHandler = paramHandler;
      if (paramHandler == null) {
        localHandler = new Handler();
      }
      paramCallback.setHandler(localHandler);
      this.mImpl.registerCallback(paramCallback, localHandler);
      return;
    }
    throw new IllegalArgumentException("callback must not be null");
  }
  
  public void removeQueueItem(MediaDescriptionCompat paramMediaDescriptionCompat)
  {
    this.mImpl.removeQueueItem(paramMediaDescriptionCompat);
  }
  
  @Deprecated
  public void removeQueueItemAt(int paramInt)
  {
    Object localObject = getQueue();
    if ((localObject != null) && (paramInt >= 0) && (paramInt < ((List)localObject).size()))
    {
      localObject = (MediaSessionCompat.QueueItem)((List)localObject).get(paramInt);
      if (localObject != null) {
        removeQueueItem(((MediaSessionCompat.QueueItem)localObject).getDescription());
      }
    }
  }
  
  public void sendCommand(@NonNull String paramString, @Nullable Bundle paramBundle, @Nullable ResultReceiver paramResultReceiver)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.mImpl.sendCommand(paramString, paramBundle, paramResultReceiver);
      return;
    }
    throw new IllegalArgumentException("command must neither be null nor empty");
  }
  
  public void setVolumeTo(int paramInt1, int paramInt2)
  {
    this.mImpl.setVolumeTo(paramInt1, paramInt2);
  }
  
  public void unregisterCallback(@NonNull Callback paramCallback)
  {
    if (paramCallback != null)
    {
      if (this.mRegisteredCallbacks.remove(paramCallback) == null)
      {
        Log.w("MediaControllerCompat", "the callback has never been registered");
        return;
      }
      try
      {
        this.mImpl.unregisterCallback(paramCallback);
        return;
      }
      finally
      {
        paramCallback.setHandler(null);
      }
    }
    throw new IllegalArgumentException("callback must not be null");
  }
  
  public static abstract class Callback
    implements IBinder.DeathRecipient
  {
    final MediaController.Callback mCallbackFwk;
    MessageHandler mHandler;
    IMediaControllerCallback mIControllerCallback;
    
    public Callback()
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        this.mCallbackFwk = new MediaControllerCallbackApi21(this);
      }
      else
      {
        this.mCallbackFwk = null;
        this.mIControllerCallback = new StubCompat(this);
      }
    }
    
    public void binderDied()
    {
      postToHandler(8, null, null);
    }
    
    @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public IMediaControllerCallback getIControllerCallback()
    {
      return this.mIControllerCallback;
    }
    
    public void onAudioInfoChanged(MediaControllerCompat.PlaybackInfo paramPlaybackInfo) {}
    
    public void onCaptioningEnabledChanged(boolean paramBoolean) {}
    
    public void onExtrasChanged(Bundle paramBundle) {}
    
    public void onMetadataChanged(MediaMetadataCompat paramMediaMetadataCompat) {}
    
    public void onPlaybackStateChanged(PlaybackStateCompat paramPlaybackStateCompat) {}
    
    public void onQueueChanged(List<MediaSessionCompat.QueueItem> paramList) {}
    
    public void onQueueTitleChanged(CharSequence paramCharSequence) {}
    
    public void onRepeatModeChanged(int paramInt) {}
    
    public void onSessionDestroyed() {}
    
    public void onSessionEvent(String paramString, Bundle paramBundle) {}
    
    public void onSessionReady() {}
    
    public void onShuffleModeChanged(int paramInt) {}
    
    void postToHandler(int paramInt, Object paramObject, Bundle paramBundle)
    {
      MessageHandler localMessageHandler = this.mHandler;
      if (localMessageHandler != null)
      {
        paramObject = localMessageHandler.obtainMessage(paramInt, paramObject);
        ((Message)paramObject).setData(paramBundle);
        ((Message)paramObject).sendToTarget();
      }
    }
    
    void setHandler(Handler paramHandler)
    {
      if (paramHandler == null)
      {
        paramHandler = this.mHandler;
        if (paramHandler != null)
        {
          paramHandler.mRegistered = false;
          paramHandler.removeCallbacksAndMessages(null);
          this.mHandler = null;
        }
      }
      else
      {
        paramHandler = new MessageHandler(paramHandler.getLooper());
        this.mHandler = paramHandler;
        paramHandler.mRegistered = true;
      }
    }
    
    @RequiresApi(21)
    private static class MediaControllerCallbackApi21
      extends MediaController.Callback
    {
      private final WeakReference<MediaControllerCompat.Callback> mCallback;
      
      MediaControllerCallbackApi21(MediaControllerCompat.Callback paramCallback)
      {
        this.mCallback = new WeakReference(paramCallback);
      }
      
      public void onAudioInfoChanged(MediaController.PlaybackInfo paramPlaybackInfo)
      {
        MediaControllerCompat.Callback localCallback = (MediaControllerCompat.Callback)this.mCallback.get();
        if (localCallback != null) {
          localCallback.onAudioInfoChanged(new MediaControllerCompat.PlaybackInfo(paramPlaybackInfo.getPlaybackType(), AudioAttributesCompat.wrap(paramPlaybackInfo.getAudioAttributes()), paramPlaybackInfo.getVolumeControl(), paramPlaybackInfo.getMaxVolume(), paramPlaybackInfo.getCurrentVolume()));
        }
      }
      
      public void onExtrasChanged(Bundle paramBundle)
      {
        MediaSessionCompat.ensureClassLoader(paramBundle);
        MediaControllerCompat.Callback localCallback = (MediaControllerCompat.Callback)this.mCallback.get();
        if (localCallback != null) {
          localCallback.onExtrasChanged(paramBundle);
        }
      }
      
      public void onMetadataChanged(MediaMetadata paramMediaMetadata)
      {
        MediaControllerCompat.Callback localCallback = (MediaControllerCompat.Callback)this.mCallback.get();
        if (localCallback != null) {
          localCallback.onMetadataChanged(MediaMetadataCompat.fromMediaMetadata(paramMediaMetadata));
        }
      }
      
      public void onPlaybackStateChanged(PlaybackState paramPlaybackState)
      {
        MediaControllerCompat.Callback localCallback = (MediaControllerCompat.Callback)this.mCallback.get();
        if ((localCallback != null) && (localCallback.mIControllerCallback == null)) {
          localCallback.onPlaybackStateChanged(PlaybackStateCompat.fromPlaybackState(paramPlaybackState));
        }
      }
      
      public void onQueueChanged(List<MediaSession.QueueItem> paramList)
      {
        MediaControllerCompat.Callback localCallback = (MediaControllerCompat.Callback)this.mCallback.get();
        if (localCallback != null) {
          localCallback.onQueueChanged(MediaSessionCompat.QueueItem.fromQueueItemList(paramList));
        }
      }
      
      public void onQueueTitleChanged(CharSequence paramCharSequence)
      {
        MediaControllerCompat.Callback localCallback = (MediaControllerCompat.Callback)this.mCallback.get();
        if (localCallback != null) {
          localCallback.onQueueTitleChanged(paramCharSequence);
        }
      }
      
      public void onSessionDestroyed()
      {
        MediaControllerCompat.Callback localCallback = (MediaControllerCompat.Callback)this.mCallback.get();
        if (localCallback != null) {
          localCallback.onSessionDestroyed();
        }
      }
      
      public void onSessionEvent(String paramString, Bundle paramBundle)
      {
        MediaSessionCompat.ensureClassLoader(paramBundle);
        MediaControllerCompat.Callback localCallback = (MediaControllerCompat.Callback)this.mCallback.get();
        if ((localCallback != null) && ((localCallback.mIControllerCallback == null) || (Build.VERSION.SDK_INT >= 23))) {
          localCallback.onSessionEvent(paramString, paramBundle);
        }
      }
    }
    
    private class MessageHandler
      extends Handler
    {
      private static final int MSG_DESTROYED = 8;
      private static final int MSG_EVENT = 1;
      private static final int MSG_SESSION_READY = 13;
      private static final int MSG_UPDATE_CAPTIONING_ENABLED = 11;
      private static final int MSG_UPDATE_EXTRAS = 7;
      private static final int MSG_UPDATE_METADATA = 3;
      private static final int MSG_UPDATE_PLAYBACK_STATE = 2;
      private static final int MSG_UPDATE_QUEUE = 5;
      private static final int MSG_UPDATE_QUEUE_TITLE = 6;
      private static final int MSG_UPDATE_REPEAT_MODE = 9;
      private static final int MSG_UPDATE_SHUFFLE_MODE = 12;
      private static final int MSG_UPDATE_VOLUME = 4;
      boolean mRegistered = false;
      
      MessageHandler(Looper paramLooper)
      {
        super();
      }
      
      public void handleMessage(Message paramMessage)
      {
        if (!this.mRegistered) {
          return;
        }
        switch (paramMessage.what)
        {
        case 10: 
        default: 
          break;
        case 13: 
          MediaControllerCompat.Callback.this.onSessionReady();
          break;
        case 12: 
          MediaControllerCompat.Callback.this.onShuffleModeChanged(((Integer)paramMessage.obj).intValue());
          break;
        case 11: 
          MediaControllerCompat.Callback.this.onCaptioningEnabledChanged(((Boolean)paramMessage.obj).booleanValue());
          break;
        case 9: 
          MediaControllerCompat.Callback.this.onRepeatModeChanged(((Integer)paramMessage.obj).intValue());
          break;
        case 8: 
          MediaControllerCompat.Callback.this.onSessionDestroyed();
          break;
        case 7: 
          paramMessage = (Bundle)paramMessage.obj;
          MediaSessionCompat.ensureClassLoader(paramMessage);
          MediaControllerCompat.Callback.this.onExtrasChanged(paramMessage);
          break;
        case 6: 
          MediaControllerCompat.Callback.this.onQueueTitleChanged((CharSequence)paramMessage.obj);
          break;
        case 5: 
          MediaControllerCompat.Callback.this.onQueueChanged((List)paramMessage.obj);
          break;
        case 4: 
          MediaControllerCompat.Callback.this.onAudioInfoChanged((MediaControllerCompat.PlaybackInfo)paramMessage.obj);
          break;
        case 3: 
          MediaControllerCompat.Callback.this.onMetadataChanged((MediaMetadataCompat)paramMessage.obj);
          break;
        case 2: 
          MediaControllerCompat.Callback.this.onPlaybackStateChanged((PlaybackStateCompat)paramMessage.obj);
          break;
        case 1: 
          Bundle localBundle = paramMessage.getData();
          MediaSessionCompat.ensureClassLoader(localBundle);
          MediaControllerCompat.Callback.this.onSessionEvent((String)paramMessage.obj, localBundle);
        }
      }
    }
    
    private static class StubCompat
      extends IMediaControllerCallback.Stub
    {
      private final WeakReference<MediaControllerCompat.Callback> mCallback;
      
      StubCompat(MediaControllerCompat.Callback paramCallback)
      {
        this.mCallback = new WeakReference(paramCallback);
      }
      
      public void onCaptioningEnabledChanged(boolean paramBoolean)
        throws RemoteException
      {
        MediaControllerCompat.Callback localCallback = (MediaControllerCompat.Callback)this.mCallback.get();
        if (localCallback != null) {
          localCallback.postToHandler(11, Boolean.valueOf(paramBoolean), null);
        }
      }
      
      public void onEvent(String paramString, Bundle paramBundle)
        throws RemoteException
      {
        MediaControllerCompat.Callback localCallback = (MediaControllerCompat.Callback)this.mCallback.get();
        if (localCallback != null) {
          localCallback.postToHandler(1, paramString, paramBundle);
        }
      }
      
      public void onExtrasChanged(Bundle paramBundle)
        throws RemoteException
      {
        MediaControllerCompat.Callback localCallback = (MediaControllerCompat.Callback)this.mCallback.get();
        if (localCallback != null) {
          localCallback.postToHandler(7, paramBundle, null);
        }
      }
      
      public void onMetadataChanged(MediaMetadataCompat paramMediaMetadataCompat)
        throws RemoteException
      {
        MediaControllerCompat.Callback localCallback = (MediaControllerCompat.Callback)this.mCallback.get();
        if (localCallback != null) {
          localCallback.postToHandler(3, paramMediaMetadataCompat, null);
        }
      }
      
      public void onPlaybackStateChanged(PlaybackStateCompat paramPlaybackStateCompat)
        throws RemoteException
      {
        MediaControllerCompat.Callback localCallback = (MediaControllerCompat.Callback)this.mCallback.get();
        if (localCallback != null) {
          localCallback.postToHandler(2, paramPlaybackStateCompat, null);
        }
      }
      
      public void onQueueChanged(List<MediaSessionCompat.QueueItem> paramList)
        throws RemoteException
      {
        MediaControllerCompat.Callback localCallback = (MediaControllerCompat.Callback)this.mCallback.get();
        if (localCallback != null) {
          localCallback.postToHandler(5, paramList, null);
        }
      }
      
      public void onQueueTitleChanged(CharSequence paramCharSequence)
        throws RemoteException
      {
        MediaControllerCompat.Callback localCallback = (MediaControllerCompat.Callback)this.mCallback.get();
        if (localCallback != null) {
          localCallback.postToHandler(6, paramCharSequence, null);
        }
      }
      
      public void onRepeatModeChanged(int paramInt)
        throws RemoteException
      {
        MediaControllerCompat.Callback localCallback = (MediaControllerCompat.Callback)this.mCallback.get();
        if (localCallback != null) {
          localCallback.postToHandler(9, Integer.valueOf(paramInt), null);
        }
      }
      
      public void onSessionDestroyed()
        throws RemoteException
      {
        MediaControllerCompat.Callback localCallback = (MediaControllerCompat.Callback)this.mCallback.get();
        if (localCallback != null) {
          localCallback.postToHandler(8, null, null);
        }
      }
      
      public void onSessionReady()
        throws RemoteException
      {
        MediaControllerCompat.Callback localCallback = (MediaControllerCompat.Callback)this.mCallback.get();
        if (localCallback != null) {
          localCallback.postToHandler(13, null, null);
        }
      }
      
      public void onShuffleModeChanged(int paramInt)
        throws RemoteException
      {
        MediaControllerCompat.Callback localCallback = (MediaControllerCompat.Callback)this.mCallback.get();
        if (localCallback != null) {
          localCallback.postToHandler(12, Integer.valueOf(paramInt), null);
        }
      }
      
      public void onShuffleModeChangedRemoved(boolean paramBoolean)
        throws RemoteException
      {}
      
      public void onVolumeInfoChanged(ParcelableVolumeInfo paramParcelableVolumeInfo)
        throws RemoteException
      {
        MediaControllerCompat.Callback localCallback = (MediaControllerCompat.Callback)this.mCallback.get();
        if (localCallback != null)
        {
          if (paramParcelableVolumeInfo != null) {
            paramParcelableVolumeInfo = new MediaControllerCompat.PlaybackInfo(paramParcelableVolumeInfo.volumeType, paramParcelableVolumeInfo.audioStream, paramParcelableVolumeInfo.controlType, paramParcelableVolumeInfo.maxVolume, paramParcelableVolumeInfo.currentVolume);
          } else {
            paramParcelableVolumeInfo = null;
          }
          localCallback.postToHandler(4, paramParcelableVolumeInfo, null);
        }
      }
    }
  }
  
  static abstract interface MediaControllerImpl
  {
    public abstract void addQueueItem(MediaDescriptionCompat paramMediaDescriptionCompat);
    
    public abstract void addQueueItem(MediaDescriptionCompat paramMediaDescriptionCompat, int paramInt);
    
    public abstract void adjustVolume(int paramInt1, int paramInt2);
    
    public abstract boolean dispatchMediaButtonEvent(KeyEvent paramKeyEvent);
    
    public abstract Bundle getExtras();
    
    public abstract long getFlags();
    
    public abstract Object getMediaController();
    
    public abstract MediaMetadataCompat getMetadata();
    
    public abstract String getPackageName();
    
    public abstract MediaControllerCompat.PlaybackInfo getPlaybackInfo();
    
    public abstract PlaybackStateCompat getPlaybackState();
    
    public abstract List<MediaSessionCompat.QueueItem> getQueue();
    
    public abstract CharSequence getQueueTitle();
    
    public abstract int getRatingType();
    
    public abstract int getRepeatMode();
    
    public abstract PendingIntent getSessionActivity();
    
    public abstract Bundle getSessionInfo();
    
    public abstract int getShuffleMode();
    
    public abstract MediaControllerCompat.TransportControls getTransportControls();
    
    public abstract boolean isCaptioningEnabled();
    
    public abstract boolean isSessionReady();
    
    public abstract void registerCallback(MediaControllerCompat.Callback paramCallback, Handler paramHandler);
    
    public abstract void removeQueueItem(MediaDescriptionCompat paramMediaDescriptionCompat);
    
    public abstract void sendCommand(String paramString, Bundle paramBundle, ResultReceiver paramResultReceiver);
    
    public abstract void setVolumeTo(int paramInt1, int paramInt2);
    
    public abstract void unregisterCallback(MediaControllerCompat.Callback paramCallback);
  }
  
  @RequiresApi(21)
  static class MediaControllerImplApi21
    implements MediaControllerCompat.MediaControllerImpl
  {
    private HashMap<MediaControllerCompat.Callback, ExtraCallback> mCallbackMap = new HashMap();
    protected final MediaController mControllerFwk;
    final Object mLock = new Object();
    @GuardedBy("mLock")
    private final List<MediaControllerCompat.Callback> mPendingCallbacks = new ArrayList();
    private Bundle mSessionInfo;
    final MediaSessionCompat.Token mSessionToken;
    
    MediaControllerImplApi21(Context paramContext, MediaSessionCompat.Token paramToken)
    {
      this.mSessionToken = paramToken;
      this.mControllerFwk = new MediaController(paramContext, (MediaSession.Token)paramToken.getToken());
      if (paramToken.getExtraBinder() == null) {
        requestExtraBinder();
      }
    }
    
    private void requestExtraBinder()
    {
      sendCommand("android.support.v4.media.session.command.GET_EXTRA_BINDER", null, new ExtraBinderRequestResultReceiver(this));
    }
    
    public void addQueueItem(MediaDescriptionCompat paramMediaDescriptionCompat)
    {
      if ((getFlags() & 0x4) != 0L)
      {
        Bundle localBundle = new Bundle();
        localBundle.putParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION", paramMediaDescriptionCompat);
        sendCommand("android.support.v4.media.session.command.ADD_QUEUE_ITEM", localBundle, null);
        return;
      }
      throw new UnsupportedOperationException("This session doesn't support queue management operations");
    }
    
    public void addQueueItem(MediaDescriptionCompat paramMediaDescriptionCompat, int paramInt)
    {
      if ((getFlags() & 0x4) != 0L)
      {
        Bundle localBundle = new Bundle();
        localBundle.putParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION", paramMediaDescriptionCompat);
        localBundle.putInt("android.support.v4.media.session.command.ARGUMENT_INDEX", paramInt);
        sendCommand("android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT", localBundle, null);
        return;
      }
      throw new UnsupportedOperationException("This session doesn't support queue management operations");
    }
    
    public void adjustVolume(int paramInt1, int paramInt2)
    {
      this.mControllerFwk.adjustVolume(paramInt1, paramInt2);
    }
    
    public boolean dispatchMediaButtonEvent(KeyEvent paramKeyEvent)
    {
      return this.mControllerFwk.dispatchMediaButtonEvent(paramKeyEvent);
    }
    
    public Bundle getExtras()
    {
      return this.mControllerFwk.getExtras();
    }
    
    public long getFlags()
    {
      return this.mControllerFwk.getFlags();
    }
    
    public Object getMediaController()
    {
      return this.mControllerFwk;
    }
    
    public MediaMetadataCompat getMetadata()
    {
      Object localObject = this.mControllerFwk.getMetadata();
      if (localObject != null) {
        localObject = MediaMetadataCompat.fromMediaMetadata(localObject);
      } else {
        localObject = null;
      }
      return (MediaMetadataCompat)localObject;
    }
    
    public String getPackageName()
    {
      return this.mControllerFwk.getPackageName();
    }
    
    public MediaControllerCompat.PlaybackInfo getPlaybackInfo()
    {
      Object localObject = this.mControllerFwk.getPlaybackInfo();
      if (localObject != null) {
        localObject = new MediaControllerCompat.PlaybackInfo(((MediaController.PlaybackInfo)localObject).getPlaybackType(), AudioAttributesCompat.wrap(((MediaController.PlaybackInfo)localObject).getAudioAttributes()), ((MediaController.PlaybackInfo)localObject).getVolumeControl(), ((MediaController.PlaybackInfo)localObject).getMaxVolume(), ((MediaController.PlaybackInfo)localObject).getCurrentVolume());
      } else {
        localObject = null;
      }
      return (MediaControllerCompat.PlaybackInfo)localObject;
    }
    
    public PlaybackStateCompat getPlaybackState()
    {
      if (this.mSessionToken.getExtraBinder() != null) {
        try
        {
          PlaybackStateCompat localPlaybackStateCompat = this.mSessionToken.getExtraBinder().getPlaybackState();
          return localPlaybackStateCompat;
        }
        catch (RemoteException localRemoteException)
        {
          Log.e("MediaControllerCompat", "Dead object in getPlaybackState.", localRemoteException);
        }
      }
      Object localObject = this.mControllerFwk.getPlaybackState();
      if (localObject != null) {
        localObject = PlaybackStateCompat.fromPlaybackState(localObject);
      } else {
        localObject = null;
      }
      return (PlaybackStateCompat)localObject;
    }
    
    public List<MediaSessionCompat.QueueItem> getQueue()
    {
      List localList = this.mControllerFwk.getQueue();
      if (localList != null) {
        localList = MediaSessionCompat.QueueItem.fromQueueItemList(localList);
      } else {
        localList = null;
      }
      return localList;
    }
    
    public CharSequence getQueueTitle()
    {
      return this.mControllerFwk.getQueueTitle();
    }
    
    public int getRatingType()
    {
      if ((Build.VERSION.SDK_INT < 22) && (this.mSessionToken.getExtraBinder() != null)) {
        try
        {
          int i = this.mSessionToken.getExtraBinder().getRatingType();
          return i;
        }
        catch (RemoteException localRemoteException)
        {
          Log.e("MediaControllerCompat", "Dead object in getRatingType.", localRemoteException);
        }
      }
      return this.mControllerFwk.getRatingType();
    }
    
    public int getRepeatMode()
    {
      if (this.mSessionToken.getExtraBinder() != null) {
        try
        {
          int i = this.mSessionToken.getExtraBinder().getRepeatMode();
          return i;
        }
        catch (RemoteException localRemoteException)
        {
          Log.e("MediaControllerCompat", "Dead object in getRepeatMode.", localRemoteException);
        }
      }
      return -1;
    }
    
    public PendingIntent getSessionActivity()
    {
      return this.mControllerFwk.getSessionActivity();
    }
    
    public Bundle getSessionInfo()
    {
      if (this.mSessionInfo != null) {
        return new Bundle(this.mSessionInfo);
      }
      if (Build.VERSION.SDK_INT >= 29) {
        this.mSessionInfo = this.mControllerFwk.getSessionInfo();
      } else if (this.mSessionToken.getExtraBinder() != null) {
        try
        {
          this.mSessionInfo = this.mSessionToken.getExtraBinder().getSessionInfo();
        }
        catch (RemoteException localRemoteException)
        {
          Log.e("MediaControllerCompat", "Dead object in getSessionInfo.", localRemoteException);
          this.mSessionInfo = Bundle.EMPTY;
        }
      }
      Bundle localBundle = MediaSessionCompat.unparcelWithClassLoader(this.mSessionInfo);
      this.mSessionInfo = localBundle;
      if (localBundle == null) {
        localBundle = Bundle.EMPTY;
      } else {
        localBundle = new Bundle(this.mSessionInfo);
      }
      return localBundle;
    }
    
    public int getShuffleMode()
    {
      if (this.mSessionToken.getExtraBinder() != null) {
        try
        {
          int i = this.mSessionToken.getExtraBinder().getShuffleMode();
          return i;
        }
        catch (RemoteException localRemoteException)
        {
          Log.e("MediaControllerCompat", "Dead object in getShuffleMode.", localRemoteException);
        }
      }
      return -1;
    }
    
    public MediaControllerCompat.TransportControls getTransportControls()
    {
      return new MediaControllerCompat.TransportControlsApi21(this.mControllerFwk.getTransportControls());
    }
    
    public boolean isCaptioningEnabled()
    {
      if (this.mSessionToken.getExtraBinder() != null) {
        try
        {
          boolean bool = this.mSessionToken.getExtraBinder().isCaptioningEnabled();
          return bool;
        }
        catch (RemoteException localRemoteException)
        {
          Log.e("MediaControllerCompat", "Dead object in isCaptioningEnabled.", localRemoteException);
        }
      }
      return false;
    }
    
    public boolean isSessionReady()
    {
      boolean bool;
      if (this.mSessionToken.getExtraBinder() != null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    @GuardedBy("mLock")
    void processPendingCallbacksLocked()
    {
      if (this.mSessionToken.getExtraBinder() == null) {
        return;
      }
      Iterator localIterator = this.mPendingCallbacks.iterator();
      while (localIterator.hasNext())
      {
        MediaControllerCompat.Callback localCallback = (MediaControllerCompat.Callback)localIterator.next();
        ExtraCallback localExtraCallback = new ExtraCallback(localCallback);
        this.mCallbackMap.put(localCallback, localExtraCallback);
        localCallback.mIControllerCallback = localExtraCallback;
        try
        {
          this.mSessionToken.getExtraBinder().registerCallbackListener(localExtraCallback);
          localCallback.postToHandler(13, null, null);
        }
        catch (RemoteException localRemoteException)
        {
          Log.e("MediaControllerCompat", "Dead object in registerCallback.", localRemoteException);
        }
      }
      this.mPendingCallbacks.clear();
    }
    
    public final void registerCallback(MediaControllerCompat.Callback paramCallback, Handler arg2)
    {
      this.mControllerFwk.registerCallback(paramCallback.mCallbackFwk, ???);
      synchronized (this.mLock)
      {
        if (this.mSessionToken.getExtraBinder() != null)
        {
          ExtraCallback localExtraCallback = new android/support/v4/media/session/MediaControllerCompat$MediaControllerImplApi21$ExtraCallback;
          localExtraCallback.<init>(paramCallback);
          this.mCallbackMap.put(paramCallback, localExtraCallback);
          paramCallback.mIControllerCallback = localExtraCallback;
          try
          {
            this.mSessionToken.getExtraBinder().registerCallbackListener(localExtraCallback);
            paramCallback.postToHandler(13, null, null);
          }
          catch (RemoteException paramCallback)
          {
            Log.e("MediaControllerCompat", "Dead object in registerCallback.", paramCallback);
          }
        }
        else
        {
          paramCallback.mIControllerCallback = null;
          this.mPendingCallbacks.add(paramCallback);
        }
        return;
      }
    }
    
    public void removeQueueItem(MediaDescriptionCompat paramMediaDescriptionCompat)
    {
      if ((getFlags() & 0x4) != 0L)
      {
        Bundle localBundle = new Bundle();
        localBundle.putParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION", paramMediaDescriptionCompat);
        sendCommand("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM", localBundle, null);
        return;
      }
      throw new UnsupportedOperationException("This session doesn't support queue management operations");
    }
    
    public void sendCommand(String paramString, Bundle paramBundle, ResultReceiver paramResultReceiver)
    {
      this.mControllerFwk.sendCommand(paramString, paramBundle, paramResultReceiver);
    }
    
    public void setVolumeTo(int paramInt1, int paramInt2)
    {
      this.mControllerFwk.setVolumeTo(paramInt1, paramInt2);
    }
    
    public final void unregisterCallback(MediaControllerCompat.Callback paramCallback)
    {
      this.mControllerFwk.unregisterCallback(paramCallback.mCallbackFwk);
      synchronized (this.mLock)
      {
        Object localObject2 = this.mSessionToken.getExtraBinder();
        if (localObject2 != null) {
          try
          {
            localObject2 = (ExtraCallback)this.mCallbackMap.remove(paramCallback);
            if (localObject2 == null) {
              break label92;
            }
            paramCallback.mIControllerCallback = null;
            this.mSessionToken.getExtraBinder().unregisterCallbackListener((IMediaControllerCallback)localObject2);
          }
          catch (RemoteException paramCallback)
          {
            Log.e("MediaControllerCompat", "Dead object in unregisterCallback.", paramCallback);
          }
        } else {
          this.mPendingCallbacks.remove(paramCallback);
        }
        label92:
        return;
      }
    }
    
    private static class ExtraBinderRequestResultReceiver
      extends ResultReceiver
    {
      private WeakReference<MediaControllerCompat.MediaControllerImplApi21> mMediaControllerImpl;
      
      ExtraBinderRequestResultReceiver(MediaControllerCompat.MediaControllerImplApi21 paramMediaControllerImplApi21)
      {
        super();
        this.mMediaControllerImpl = new WeakReference(paramMediaControllerImplApi21);
      }
      
      protected void onReceiveResult(int paramInt, Bundle paramBundle)
      {
        MediaControllerCompat.MediaControllerImplApi21 localMediaControllerImplApi21 = (MediaControllerCompat.MediaControllerImplApi21)this.mMediaControllerImpl.get();
        if ((localMediaControllerImplApi21 != null) && (paramBundle != null)) {
          synchronized (localMediaControllerImplApi21.mLock)
          {
            localMediaControllerImplApi21.mSessionToken.setExtraBinder(IMediaSession.Stub.asInterface(BundleCompat.getBinder(paramBundle, "android.support.v4.media.session.EXTRA_BINDER")));
            localMediaControllerImplApi21.mSessionToken.setSession2Token(ParcelUtils.getVersionedParcelable(paramBundle, "android.support.v4.media.session.SESSION_TOKEN2"));
            localMediaControllerImplApi21.processPendingCallbacksLocked();
            return;
          }
        }
      }
    }
    
    private static class ExtraCallback
      extends MediaControllerCompat.Callback.StubCompat
    {
      ExtraCallback(MediaControllerCompat.Callback paramCallback)
      {
        super();
      }
      
      public void onExtrasChanged(Bundle paramBundle)
        throws RemoteException
      {
        throw new AssertionError();
      }
      
      public void onMetadataChanged(MediaMetadataCompat paramMediaMetadataCompat)
        throws RemoteException
      {
        throw new AssertionError();
      }
      
      public void onQueueChanged(List<MediaSessionCompat.QueueItem> paramList)
        throws RemoteException
      {
        throw new AssertionError();
      }
      
      public void onQueueTitleChanged(CharSequence paramCharSequence)
        throws RemoteException
      {
        throw new AssertionError();
      }
      
      public void onSessionDestroyed()
        throws RemoteException
      {
        throw new AssertionError();
      }
      
      public void onVolumeInfoChanged(ParcelableVolumeInfo paramParcelableVolumeInfo)
        throws RemoteException
      {
        throw new AssertionError();
      }
    }
  }
  
  static class MediaControllerImplBase
    implements MediaControllerCompat.MediaControllerImpl
  {
    private IMediaSession mBinder;
    private Bundle mSessionInfo;
    private MediaControllerCompat.TransportControls mTransportControls;
    
    MediaControllerImplBase(MediaSessionCompat.Token paramToken)
    {
      this.mBinder = IMediaSession.Stub.asInterface((IBinder)paramToken.getToken());
    }
    
    public void addQueueItem(MediaDescriptionCompat paramMediaDescriptionCompat)
    {
      try
      {
        if ((this.mBinder.getFlags() & 0x4) != 0L)
        {
          this.mBinder.addQueueItem(paramMediaDescriptionCompat);
        }
        else
        {
          paramMediaDescriptionCompat = new java/lang/UnsupportedOperationException;
          paramMediaDescriptionCompat.<init>("This session doesn't support queue management operations");
          throw paramMediaDescriptionCompat;
        }
      }
      catch (RemoteException paramMediaDescriptionCompat)
      {
        Log.e("MediaControllerCompat", "Dead object in addQueueItem.", paramMediaDescriptionCompat);
      }
    }
    
    public void addQueueItem(MediaDescriptionCompat paramMediaDescriptionCompat, int paramInt)
    {
      try
      {
        if ((this.mBinder.getFlags() & 0x4) != 0L)
        {
          this.mBinder.addQueueItemAt(paramMediaDescriptionCompat, paramInt);
        }
        else
        {
          paramMediaDescriptionCompat = new java/lang/UnsupportedOperationException;
          paramMediaDescriptionCompat.<init>("This session doesn't support queue management operations");
          throw paramMediaDescriptionCompat;
        }
      }
      catch (RemoteException paramMediaDescriptionCompat)
      {
        Log.e("MediaControllerCompat", "Dead object in addQueueItemAt.", paramMediaDescriptionCompat);
      }
    }
    
    public void adjustVolume(int paramInt1, int paramInt2)
    {
      try
      {
        this.mBinder.adjustVolume(paramInt1, paramInt2, null);
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("MediaControllerCompat", "Dead object in adjustVolume.", localRemoteException);
      }
    }
    
    public boolean dispatchMediaButtonEvent(KeyEvent paramKeyEvent)
    {
      if (paramKeyEvent != null)
      {
        try
        {
          this.mBinder.sendMediaButton(paramKeyEvent);
        }
        catch (RemoteException paramKeyEvent)
        {
          Log.e("MediaControllerCompat", "Dead object in dispatchMediaButtonEvent.", paramKeyEvent);
        }
        return false;
      }
      throw new IllegalArgumentException("event may not be null.");
    }
    
    public Bundle getExtras()
    {
      try
      {
        Bundle localBundle = this.mBinder.getExtras();
        return localBundle;
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("MediaControllerCompat", "Dead object in getExtras.", localRemoteException);
      }
      return null;
    }
    
    public long getFlags()
    {
      try
      {
        long l = this.mBinder.getFlags();
        return l;
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("MediaControllerCompat", "Dead object in getFlags.", localRemoteException);
      }
      return 0L;
    }
    
    public Object getMediaController()
    {
      return null;
    }
    
    public MediaMetadataCompat getMetadata()
    {
      try
      {
        MediaMetadataCompat localMediaMetadataCompat = this.mBinder.getMetadata();
        return localMediaMetadataCompat;
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("MediaControllerCompat", "Dead object in getMetadata.", localRemoteException);
      }
      return null;
    }
    
    public String getPackageName()
    {
      try
      {
        String str = this.mBinder.getPackageName();
        return str;
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("MediaControllerCompat", "Dead object in getPackageName.", localRemoteException);
      }
      return null;
    }
    
    public MediaControllerCompat.PlaybackInfo getPlaybackInfo()
    {
      try
      {
        Object localObject = this.mBinder.getVolumeAttributes();
        localObject = new MediaControllerCompat.PlaybackInfo(((ParcelableVolumeInfo)localObject).volumeType, ((ParcelableVolumeInfo)localObject).audioStream, ((ParcelableVolumeInfo)localObject).controlType, ((ParcelableVolumeInfo)localObject).maxVolume, ((ParcelableVolumeInfo)localObject).currentVolume);
        return (MediaControllerCompat.PlaybackInfo)localObject;
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("MediaControllerCompat", "Dead object in getPlaybackInfo.", localRemoteException);
      }
      return null;
    }
    
    public PlaybackStateCompat getPlaybackState()
    {
      try
      {
        PlaybackStateCompat localPlaybackStateCompat = this.mBinder.getPlaybackState();
        return localPlaybackStateCompat;
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("MediaControllerCompat", "Dead object in getPlaybackState.", localRemoteException);
      }
      return null;
    }
    
    public List<MediaSessionCompat.QueueItem> getQueue()
    {
      try
      {
        List localList = this.mBinder.getQueue();
        return localList;
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("MediaControllerCompat", "Dead object in getQueue.", localRemoteException);
      }
      return null;
    }
    
    public CharSequence getQueueTitle()
    {
      try
      {
        CharSequence localCharSequence = this.mBinder.getQueueTitle();
        return localCharSequence;
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("MediaControllerCompat", "Dead object in getQueueTitle.", localRemoteException);
      }
      return null;
    }
    
    public int getRatingType()
    {
      try
      {
        int i = this.mBinder.getRatingType();
        return i;
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("MediaControllerCompat", "Dead object in getRatingType.", localRemoteException);
      }
      return 0;
    }
    
    public int getRepeatMode()
    {
      try
      {
        int i = this.mBinder.getRepeatMode();
        return i;
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("MediaControllerCompat", "Dead object in getRepeatMode.", localRemoteException);
      }
      return -1;
    }
    
    public PendingIntent getSessionActivity()
    {
      try
      {
        PendingIntent localPendingIntent = this.mBinder.getLaunchPendingIntent();
        return localPendingIntent;
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("MediaControllerCompat", "Dead object in getSessionActivity.", localRemoteException);
      }
      return null;
    }
    
    public Bundle getSessionInfo()
    {
      try
      {
        this.mSessionInfo = this.mBinder.getSessionInfo();
      }
      catch (RemoteException localRemoteException)
      {
        Log.d("MediaControllerCompat", "Dead object in getSessionInfo.", localRemoteException);
      }
      Bundle localBundle = MediaSessionCompat.unparcelWithClassLoader(this.mSessionInfo);
      this.mSessionInfo = localBundle;
      if (localBundle == null) {
        localBundle = Bundle.EMPTY;
      } else {
        localBundle = new Bundle(this.mSessionInfo);
      }
      return localBundle;
    }
    
    public int getShuffleMode()
    {
      try
      {
        int i = this.mBinder.getShuffleMode();
        return i;
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("MediaControllerCompat", "Dead object in getShuffleMode.", localRemoteException);
      }
      return -1;
    }
    
    public MediaControllerCompat.TransportControls getTransportControls()
    {
      if (this.mTransportControls == null) {
        this.mTransportControls = new MediaControllerCompat.TransportControlsBase(this.mBinder);
      }
      return this.mTransportControls;
    }
    
    public boolean isCaptioningEnabled()
    {
      try
      {
        boolean bool = this.mBinder.isCaptioningEnabled();
        return bool;
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("MediaControllerCompat", "Dead object in isCaptioningEnabled.", localRemoteException);
      }
      return false;
    }
    
    public boolean isSessionReady()
    {
      return true;
    }
    
    public void registerCallback(MediaControllerCompat.Callback paramCallback, Handler paramHandler)
    {
      if (paramCallback != null)
      {
        try
        {
          this.mBinder.asBinder().linkToDeath(paramCallback, 0);
          this.mBinder.registerCallbackListener(paramCallback.mIControllerCallback);
          paramCallback.postToHandler(13, null, null);
        }
        catch (RemoteException paramHandler)
        {
          Log.e("MediaControllerCompat", "Dead object in registerCallback.", paramHandler);
          paramCallback.postToHandler(8, null, null);
        }
        return;
      }
      throw new IllegalArgumentException("callback may not be null.");
    }
    
    public void removeQueueItem(MediaDescriptionCompat paramMediaDescriptionCompat)
    {
      try
      {
        if ((this.mBinder.getFlags() & 0x4) != 0L)
        {
          this.mBinder.removeQueueItem(paramMediaDescriptionCompat);
        }
        else
        {
          paramMediaDescriptionCompat = new java/lang/UnsupportedOperationException;
          paramMediaDescriptionCompat.<init>("This session doesn't support queue management operations");
          throw paramMediaDescriptionCompat;
        }
      }
      catch (RemoteException paramMediaDescriptionCompat)
      {
        Log.e("MediaControllerCompat", "Dead object in removeQueueItem.", paramMediaDescriptionCompat);
      }
    }
    
    public void sendCommand(String paramString, Bundle paramBundle, ResultReceiver paramResultReceiver)
    {
      try
      {
        IMediaSession localIMediaSession = this.mBinder;
        if (paramResultReceiver == null) {
          paramResultReceiver = null;
        } else {
          paramResultReceiver = new MediaSessionCompat.ResultReceiverWrapper(paramResultReceiver);
        }
        localIMediaSession.sendCommand(paramString, paramBundle, paramResultReceiver);
      }
      catch (RemoteException paramString)
      {
        Log.e("MediaControllerCompat", "Dead object in sendCommand.", paramString);
      }
    }
    
    public void setVolumeTo(int paramInt1, int paramInt2)
    {
      try
      {
        this.mBinder.setVolumeTo(paramInt1, paramInt2, null);
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("MediaControllerCompat", "Dead object in setVolumeTo.", localRemoteException);
      }
    }
    
    public void unregisterCallback(MediaControllerCompat.Callback paramCallback)
    {
      if (paramCallback != null)
      {
        try
        {
          this.mBinder.unregisterCallbackListener(paramCallback.mIControllerCallback);
          this.mBinder.asBinder().unlinkToDeath(paramCallback, 0);
        }
        catch (RemoteException paramCallback)
        {
          Log.e("MediaControllerCompat", "Dead object in unregisterCallback.", paramCallback);
        }
        return;
      }
      throw new IllegalArgumentException("callback may not be null.");
    }
  }
  
  public static final class PlaybackInfo
  {
    public static final int PLAYBACK_TYPE_LOCAL = 1;
    public static final int PLAYBACK_TYPE_REMOTE = 2;
    private final AudioAttributesCompat mAudioAttrsCompat;
    private final int mCurrentVolume;
    private final int mMaxVolume;
    private final int mPlaybackType;
    private final int mVolumeControl;
    
    PlaybackInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      this(paramInt1, new AudioAttributesCompat.Builder().setLegacyStreamType(paramInt2).build(), paramInt3, paramInt4, paramInt5);
    }
    
    PlaybackInfo(int paramInt1, @NonNull AudioAttributesCompat paramAudioAttributesCompat, int paramInt2, int paramInt3, int paramInt4)
    {
      this.mPlaybackType = paramInt1;
      this.mAudioAttrsCompat = paramAudioAttributesCompat;
      this.mVolumeControl = paramInt2;
      this.mMaxVolume = paramInt3;
      this.mCurrentVolume = paramInt4;
    }
    
    @NonNull
    public AudioAttributesCompat getAudioAttributes()
    {
      return this.mAudioAttrsCompat;
    }
    
    @Deprecated
    public int getAudioStream()
    {
      return this.mAudioAttrsCompat.getLegacyStreamType();
    }
    
    public int getCurrentVolume()
    {
      return this.mCurrentVolume;
    }
    
    public int getMaxVolume()
    {
      return this.mMaxVolume;
    }
    
    public int getPlaybackType()
    {
      return this.mPlaybackType;
    }
    
    public int getVolumeControl()
    {
      return this.mVolumeControl;
    }
  }
  
  public static abstract class TransportControls
  {
    public static final String EXTRA_LEGACY_STREAM_TYPE = "android.media.session.extra.LEGACY_STREAM_TYPE";
    
    public abstract void fastForward();
    
    public abstract void pause();
    
    public abstract void play();
    
    public abstract void playFromMediaId(String paramString, Bundle paramBundle);
    
    public abstract void playFromSearch(String paramString, Bundle paramBundle);
    
    public abstract void playFromUri(Uri paramUri, Bundle paramBundle);
    
    public abstract void prepare();
    
    public abstract void prepareFromMediaId(String paramString, Bundle paramBundle);
    
    public abstract void prepareFromSearch(String paramString, Bundle paramBundle);
    
    public abstract void prepareFromUri(Uri paramUri, Bundle paramBundle);
    
    public abstract void rewind();
    
    public abstract void seekTo(long paramLong);
    
    public abstract void sendCustomAction(PlaybackStateCompat.CustomAction paramCustomAction, Bundle paramBundle);
    
    public abstract void sendCustomAction(String paramString, Bundle paramBundle);
    
    public abstract void setCaptioningEnabled(boolean paramBoolean);
    
    public void setPlaybackSpeed(float paramFloat) {}
    
    public abstract void setRating(RatingCompat paramRatingCompat);
    
    public abstract void setRating(RatingCompat paramRatingCompat, Bundle paramBundle);
    
    public abstract void setRepeatMode(int paramInt);
    
    public abstract void setShuffleMode(int paramInt);
    
    public abstract void skipToNext();
    
    public abstract void skipToPrevious();
    
    public abstract void skipToQueueItem(long paramLong);
    
    public abstract void stop();
  }
  
  @RequiresApi(21)
  static class TransportControlsApi21
    extends MediaControllerCompat.TransportControls
  {
    protected final MediaController.TransportControls mControlsFwk;
    
    TransportControlsApi21(MediaController.TransportControls paramTransportControls)
    {
      this.mControlsFwk = paramTransportControls;
    }
    
    public void fastForward()
    {
      this.mControlsFwk.fastForward();
    }
    
    public void pause()
    {
      this.mControlsFwk.pause();
    }
    
    public void play()
    {
      this.mControlsFwk.play();
    }
    
    public void playFromMediaId(String paramString, Bundle paramBundle)
    {
      this.mControlsFwk.playFromMediaId(paramString, paramBundle);
    }
    
    public void playFromSearch(String paramString, Bundle paramBundle)
    {
      this.mControlsFwk.playFromSearch(paramString, paramBundle);
    }
    
    public void playFromUri(Uri paramUri, Bundle paramBundle)
    {
      if (Build.VERSION.SDK_INT >= 23)
      {
        this.mControlsFwk.playFromUri(paramUri, paramBundle);
        return;
      }
      if ((paramUri != null) && (!Uri.EMPTY.equals(paramUri)))
      {
        Bundle localBundle = new Bundle();
        localBundle.putParcelable("android.support.v4.media.session.action.ARGUMENT_URI", paramUri);
        localBundle.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", paramBundle);
        sendCustomAction("android.support.v4.media.session.action.PLAY_FROM_URI", localBundle);
        return;
      }
      throw new IllegalArgumentException("You must specify a non-empty Uri for playFromUri.");
    }
    
    public void prepare()
    {
      if (Build.VERSION.SDK_INT >= 24)
      {
        this.mControlsFwk.prepare();
        return;
      }
      sendCustomAction("android.support.v4.media.session.action.PREPARE", null);
    }
    
    public void prepareFromMediaId(String paramString, Bundle paramBundle)
    {
      if (Build.VERSION.SDK_INT >= 24)
      {
        this.mControlsFwk.prepareFromMediaId(paramString, paramBundle);
        return;
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("android.support.v4.media.session.action.ARGUMENT_MEDIA_ID", paramString);
      localBundle.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", paramBundle);
      sendCustomAction("android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID", localBundle);
    }
    
    public void prepareFromSearch(String paramString, Bundle paramBundle)
    {
      if (Build.VERSION.SDK_INT >= 24)
      {
        this.mControlsFwk.prepareFromSearch(paramString, paramBundle);
        return;
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("android.support.v4.media.session.action.ARGUMENT_QUERY", paramString);
      localBundle.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", paramBundle);
      sendCustomAction("android.support.v4.media.session.action.PREPARE_FROM_SEARCH", localBundle);
    }
    
    public void prepareFromUri(Uri paramUri, Bundle paramBundle)
    {
      if (Build.VERSION.SDK_INT >= 24)
      {
        this.mControlsFwk.prepareFromUri(paramUri, paramBundle);
        return;
      }
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("android.support.v4.media.session.action.ARGUMENT_URI", paramUri);
      localBundle.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", paramBundle);
      sendCustomAction("android.support.v4.media.session.action.PREPARE_FROM_URI", localBundle);
    }
    
    public void rewind()
    {
      this.mControlsFwk.rewind();
    }
    
    public void seekTo(long paramLong)
    {
      this.mControlsFwk.seekTo(paramLong);
    }
    
    public void sendCustomAction(PlaybackStateCompat.CustomAction paramCustomAction, Bundle paramBundle)
    {
      MediaControllerCompat.validateCustomAction(paramCustomAction.getAction(), paramBundle);
      this.mControlsFwk.sendCustomAction(paramCustomAction.getAction(), paramBundle);
    }
    
    public void sendCustomAction(String paramString, Bundle paramBundle)
    {
      MediaControllerCompat.validateCustomAction(paramString, paramBundle);
      this.mControlsFwk.sendCustomAction(paramString, paramBundle);
    }
    
    public void setCaptioningEnabled(boolean paramBoolean)
    {
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED", paramBoolean);
      sendCustomAction("android.support.v4.media.session.action.SET_CAPTIONING_ENABLED", localBundle);
    }
    
    public void setPlaybackSpeed(float paramFloat)
    {
      if (paramFloat != 0.0F)
      {
        if (Build.VERSION.SDK_INT >= 29)
        {
          this.mControlsFwk.setPlaybackSpeed(paramFloat);
          return;
        }
        Bundle localBundle = new Bundle();
        localBundle.putFloat("android.support.v4.media.session.action.ARGUMENT_PLAYBACK_SPEED", paramFloat);
        sendCustomAction("android.support.v4.media.session.action.SET_PLAYBACK_SPEED", localBundle);
        return;
      }
      throw new IllegalArgumentException("speed must not be zero");
    }
    
    public void setRating(RatingCompat paramRatingCompat)
    {
      MediaController.TransportControls localTransportControls = this.mControlsFwk;
      if (paramRatingCompat != null) {
        paramRatingCompat = (Rating)paramRatingCompat.getRating();
      } else {
        paramRatingCompat = null;
      }
      localTransportControls.setRating(paramRatingCompat);
    }
    
    public void setRating(RatingCompat paramRatingCompat, Bundle paramBundle)
    {
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("android.support.v4.media.session.action.ARGUMENT_RATING", paramRatingCompat);
      localBundle.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", paramBundle);
      sendCustomAction("android.support.v4.media.session.action.SET_RATING", localBundle);
    }
    
    public void setRepeatMode(int paramInt)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE", paramInt);
      sendCustomAction("android.support.v4.media.session.action.SET_REPEAT_MODE", localBundle);
    }
    
    public void setShuffleMode(int paramInt)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE", paramInt);
      sendCustomAction("android.support.v4.media.session.action.SET_SHUFFLE_MODE", localBundle);
    }
    
    public void skipToNext()
    {
      this.mControlsFwk.skipToNext();
    }
    
    public void skipToPrevious()
    {
      this.mControlsFwk.skipToPrevious();
    }
    
    public void skipToQueueItem(long paramLong)
    {
      this.mControlsFwk.skipToQueueItem(paramLong);
    }
    
    public void stop()
    {
      this.mControlsFwk.stop();
    }
  }
  
  static class TransportControlsBase
    extends MediaControllerCompat.TransportControls
  {
    private IMediaSession mBinder;
    
    public TransportControlsBase(IMediaSession paramIMediaSession)
    {
      this.mBinder = paramIMediaSession;
    }
    
    public void fastForward()
    {
      try
      {
        this.mBinder.fastForward();
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("MediaControllerCompat", "Dead object in fastForward.", localRemoteException);
      }
    }
    
    public void pause()
    {
      try
      {
        this.mBinder.pause();
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("MediaControllerCompat", "Dead object in pause.", localRemoteException);
      }
    }
    
    public void play()
    {
      try
      {
        this.mBinder.play();
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("MediaControllerCompat", "Dead object in play.", localRemoteException);
      }
    }
    
    public void playFromMediaId(String paramString, Bundle paramBundle)
    {
      try
      {
        this.mBinder.playFromMediaId(paramString, paramBundle);
      }
      catch (RemoteException paramString)
      {
        Log.e("MediaControllerCompat", "Dead object in playFromMediaId.", paramString);
      }
    }
    
    public void playFromSearch(String paramString, Bundle paramBundle)
    {
      try
      {
        this.mBinder.playFromSearch(paramString, paramBundle);
      }
      catch (RemoteException paramString)
      {
        Log.e("MediaControllerCompat", "Dead object in playFromSearch.", paramString);
      }
    }
    
    public void playFromUri(Uri paramUri, Bundle paramBundle)
    {
      try
      {
        this.mBinder.playFromUri(paramUri, paramBundle);
      }
      catch (RemoteException paramUri)
      {
        Log.e("MediaControllerCompat", "Dead object in playFromUri.", paramUri);
      }
    }
    
    public void prepare()
    {
      try
      {
        this.mBinder.prepare();
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("MediaControllerCompat", "Dead object in prepare.", localRemoteException);
      }
    }
    
    public void prepareFromMediaId(String paramString, Bundle paramBundle)
    {
      try
      {
        this.mBinder.prepareFromMediaId(paramString, paramBundle);
      }
      catch (RemoteException paramString)
      {
        Log.e("MediaControllerCompat", "Dead object in prepareFromMediaId.", paramString);
      }
    }
    
    public void prepareFromSearch(String paramString, Bundle paramBundle)
    {
      try
      {
        this.mBinder.prepareFromSearch(paramString, paramBundle);
      }
      catch (RemoteException paramString)
      {
        Log.e("MediaControllerCompat", "Dead object in prepareFromSearch.", paramString);
      }
    }
    
    public void prepareFromUri(Uri paramUri, Bundle paramBundle)
    {
      try
      {
        this.mBinder.prepareFromUri(paramUri, paramBundle);
      }
      catch (RemoteException paramUri)
      {
        Log.e("MediaControllerCompat", "Dead object in prepareFromUri.", paramUri);
      }
    }
    
    public void rewind()
    {
      try
      {
        this.mBinder.rewind();
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("MediaControllerCompat", "Dead object in rewind.", localRemoteException);
      }
    }
    
    public void seekTo(long paramLong)
    {
      try
      {
        this.mBinder.seekTo(paramLong);
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("MediaControllerCompat", "Dead object in seekTo.", localRemoteException);
      }
    }
    
    public void sendCustomAction(PlaybackStateCompat.CustomAction paramCustomAction, Bundle paramBundle)
    {
      sendCustomAction(paramCustomAction.getAction(), paramBundle);
    }
    
    public void sendCustomAction(String paramString, Bundle paramBundle)
    {
      MediaControllerCompat.validateCustomAction(paramString, paramBundle);
      try
      {
        this.mBinder.sendCustomAction(paramString, paramBundle);
      }
      catch (RemoteException paramString)
      {
        Log.e("MediaControllerCompat", "Dead object in sendCustomAction.", paramString);
      }
    }
    
    public void setCaptioningEnabled(boolean paramBoolean)
    {
      try
      {
        this.mBinder.setCaptioningEnabled(paramBoolean);
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("MediaControllerCompat", "Dead object in setCaptioningEnabled.", localRemoteException);
      }
    }
    
    public void setPlaybackSpeed(float paramFloat)
    {
      if (paramFloat != 0.0F)
      {
        try
        {
          this.mBinder.setPlaybackSpeed(paramFloat);
        }
        catch (RemoteException localRemoteException)
        {
          Log.e("MediaControllerCompat", "Dead object in setPlaybackSpeed.", localRemoteException);
        }
        return;
      }
      throw new IllegalArgumentException("speed must not be zero");
    }
    
    public void setRating(RatingCompat paramRatingCompat)
    {
      try
      {
        this.mBinder.rate(paramRatingCompat);
      }
      catch (RemoteException paramRatingCompat)
      {
        Log.e("MediaControllerCompat", "Dead object in setRating.", paramRatingCompat);
      }
    }
    
    public void setRating(RatingCompat paramRatingCompat, Bundle paramBundle)
    {
      try
      {
        this.mBinder.rateWithExtras(paramRatingCompat, paramBundle);
      }
      catch (RemoteException paramRatingCompat)
      {
        Log.e("MediaControllerCompat", "Dead object in setRating.", paramRatingCompat);
      }
    }
    
    public void setRepeatMode(int paramInt)
    {
      try
      {
        this.mBinder.setRepeatMode(paramInt);
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("MediaControllerCompat", "Dead object in setRepeatMode.", localRemoteException);
      }
    }
    
    public void setShuffleMode(int paramInt)
    {
      try
      {
        this.mBinder.setShuffleMode(paramInt);
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("MediaControllerCompat", "Dead object in setShuffleMode.", localRemoteException);
      }
    }
    
    public void skipToNext()
    {
      try
      {
        this.mBinder.next();
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("MediaControllerCompat", "Dead object in skipToNext.", localRemoteException);
      }
    }
    
    public void skipToPrevious()
    {
      try
      {
        this.mBinder.previous();
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("MediaControllerCompat", "Dead object in skipToPrevious.", localRemoteException);
      }
    }
    
    public void skipToQueueItem(long paramLong)
    {
      try
      {
        this.mBinder.skipToQueueItem(paramLong);
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("MediaControllerCompat", "Dead object in skipToQueueItem.", localRemoteException);
      }
    }
    
    public void stop()
    {
      try
      {
        this.mBinder.stop();
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("MediaControllerCompat", "Dead object in stop.", localRemoteException);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\android\support\v4\media\session\MediaControllerCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */