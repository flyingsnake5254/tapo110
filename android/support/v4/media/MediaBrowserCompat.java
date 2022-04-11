package android.support.v4.media;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.browse.MediaBrowser;
import android.media.browse.MediaBrowser.ConnectionCallback;
import android.media.browse.MediaBrowser.ItemCallback;
import android.media.browse.MediaBrowser.MediaItem;
import android.media.browse.MediaBrowser.SubscriptionCallback;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Process;
import android.os.RemoteException;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.IMediaSession.Stub;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import androidx.core.app.BundleCompat;
import androidx.media.MediaBrowserCompatUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public final class MediaBrowserCompat
{
  public static final String CUSTOM_ACTION_DOWNLOAD = "android.support.v4.media.action.DOWNLOAD";
  public static final String CUSTOM_ACTION_REMOVE_DOWNLOADED_FILE = "android.support.v4.media.action.REMOVE_DOWNLOADED_FILE";
  static final boolean DEBUG = Log.isLoggable("MediaBrowserCompat", 3);
  public static final String EXTRA_DOWNLOAD_PROGRESS = "android.media.browse.extra.DOWNLOAD_PROGRESS";
  public static final String EXTRA_MEDIA_ID = "android.media.browse.extra.MEDIA_ID";
  public static final String EXTRA_PAGE = "android.media.browse.extra.PAGE";
  public static final String EXTRA_PAGE_SIZE = "android.media.browse.extra.PAGE_SIZE";
  static final String TAG = "MediaBrowserCompat";
  private final MediaBrowserImpl mImpl;
  
  public MediaBrowserCompat(Context paramContext, ComponentName paramComponentName, ConnectionCallback paramConnectionCallback, Bundle paramBundle)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 26) {
      this.mImpl = new MediaBrowserImplApi26(paramContext, paramComponentName, paramConnectionCallback, paramBundle);
    } else if (i >= 23) {
      this.mImpl = new MediaBrowserImplApi23(paramContext, paramComponentName, paramConnectionCallback, paramBundle);
    } else if (i >= 21) {
      this.mImpl = new MediaBrowserImplApi21(paramContext, paramComponentName, paramConnectionCallback, paramBundle);
    } else {
      this.mImpl = new MediaBrowserImplBase(paramContext, paramComponentName, paramConnectionCallback, paramBundle);
    }
  }
  
  public void connect()
  {
    Log.d("MediaBrowserCompat", "Connecting to a MediaBrowserService.");
    this.mImpl.connect();
  }
  
  public void disconnect()
  {
    this.mImpl.disconnect();
  }
  
  @Nullable
  public Bundle getExtras()
  {
    return this.mImpl.getExtras();
  }
  
  public void getItem(@NonNull String paramString, @NonNull ItemCallback paramItemCallback)
  {
    this.mImpl.getItem(paramString, paramItemCallback);
  }
  
  @Nullable
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public Bundle getNotifyChildrenChangedOptions()
  {
    return this.mImpl.getNotifyChildrenChangedOptions();
  }
  
  @NonNull
  public String getRoot()
  {
    return this.mImpl.getRoot();
  }
  
  @NonNull
  public ComponentName getServiceComponent()
  {
    return this.mImpl.getServiceComponent();
  }
  
  @NonNull
  public MediaSessionCompat.Token getSessionToken()
  {
    return this.mImpl.getSessionToken();
  }
  
  public boolean isConnected()
  {
    return this.mImpl.isConnected();
  }
  
  public void search(@NonNull String paramString, Bundle paramBundle, @NonNull SearchCallback paramSearchCallback)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramSearchCallback != null)
      {
        this.mImpl.search(paramString, paramBundle, paramSearchCallback);
        return;
      }
      throw new IllegalArgumentException("callback cannot be null");
    }
    throw new IllegalArgumentException("query cannot be empty");
  }
  
  public void sendCustomAction(@NonNull String paramString, Bundle paramBundle, @Nullable CustomActionCallback paramCustomActionCallback)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.mImpl.sendCustomAction(paramString, paramBundle, paramCustomActionCallback);
      return;
    }
    throw new IllegalArgumentException("action cannot be empty");
  }
  
  public void subscribe(@NonNull String paramString, @NonNull Bundle paramBundle, @NonNull SubscriptionCallback paramSubscriptionCallback)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramSubscriptionCallback != null)
      {
        if (paramBundle != null)
        {
          this.mImpl.subscribe(paramString, paramBundle, paramSubscriptionCallback);
          return;
        }
        throw new IllegalArgumentException("options are null");
      }
      throw new IllegalArgumentException("callback is null");
    }
    throw new IllegalArgumentException("parentId is empty");
  }
  
  public void subscribe(@NonNull String paramString, @NonNull SubscriptionCallback paramSubscriptionCallback)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramSubscriptionCallback != null)
      {
        this.mImpl.subscribe(paramString, null, paramSubscriptionCallback);
        return;
      }
      throw new IllegalArgumentException("callback is null");
    }
    throw new IllegalArgumentException("parentId is empty");
  }
  
  public void unsubscribe(@NonNull String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.mImpl.unsubscribe(paramString, null);
      return;
    }
    throw new IllegalArgumentException("parentId is empty");
  }
  
  public void unsubscribe(@NonNull String paramString, @NonNull SubscriptionCallback paramSubscriptionCallback)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramSubscriptionCallback != null)
      {
        this.mImpl.unsubscribe(paramString, paramSubscriptionCallback);
        return;
      }
      throw new IllegalArgumentException("callback is null");
    }
    throw new IllegalArgumentException("parentId is empty");
  }
  
  private static class CallbackHandler
    extends Handler
  {
    private final WeakReference<MediaBrowserCompat.MediaBrowserServiceCallbackImpl> mCallbackImplRef;
    private WeakReference<Messenger> mCallbacksMessengerRef;
    
    CallbackHandler(MediaBrowserCompat.MediaBrowserServiceCallbackImpl paramMediaBrowserServiceCallbackImpl)
    {
      this.mCallbackImplRef = new WeakReference(paramMediaBrowserServiceCallbackImpl);
    }
    
    public void handleMessage(@NonNull Message paramMessage)
    {
      Object localObject1 = this.mCallbacksMessengerRef;
      if ((localObject1 != null) && (((WeakReference)localObject1).get() != null) && (this.mCallbackImplRef.get() != null))
      {
        Object localObject2 = paramMessage.getData();
        MediaSessionCompat.ensureClassLoader((Bundle)localObject2);
        MediaBrowserCompat.MediaBrowserServiceCallbackImpl localMediaBrowserServiceCallbackImpl = (MediaBrowserCompat.MediaBrowserServiceCallbackImpl)this.mCallbackImplRef.get();
        localObject1 = (Messenger)this.mCallbacksMessengerRef.get();
        try
        {
          int i = paramMessage.what;
          Bundle localBundle1;
          if (i != 1)
          {
            if (i != 2)
            {
              if (i != 3)
              {
                localObject2 = new java/lang/StringBuilder;
                ((StringBuilder)localObject2).<init>();
                ((StringBuilder)localObject2).append("Unhandled message: ");
                ((StringBuilder)localObject2).append(paramMessage);
                ((StringBuilder)localObject2).append("\n  Client version: ");
                ((StringBuilder)localObject2).append(1);
                ((StringBuilder)localObject2).append("\n  Service version: ");
                ((StringBuilder)localObject2).append(paramMessage.arg1);
                Log.w("MediaBrowserCompat", ((StringBuilder)localObject2).toString());
              }
              else
              {
                localBundle1 = ((Bundle)localObject2).getBundle("data_options");
                MediaSessionCompat.ensureClassLoader(localBundle1);
                Bundle localBundle2 = ((Bundle)localObject2).getBundle("data_notify_children_changed_options");
                MediaSessionCompat.ensureClassLoader(localBundle2);
                localMediaBrowserServiceCallbackImpl.onLoadChildren((Messenger)localObject1, ((Bundle)localObject2).getString("data_media_item_id"), ((Bundle)localObject2).getParcelableArrayList("data_media_item_list"), localBundle1, localBundle2);
              }
            }
            else {
              localMediaBrowserServiceCallbackImpl.onConnectionFailed((Messenger)localObject1);
            }
          }
          else
          {
            localBundle1 = ((Bundle)localObject2).getBundle("data_root_hints");
            MediaSessionCompat.ensureClassLoader(localBundle1);
            localMediaBrowserServiceCallbackImpl.onServiceConnected((Messenger)localObject1, ((Bundle)localObject2).getString("data_media_item_id"), (MediaSessionCompat.Token)((Bundle)localObject2).getParcelable("data_media_session_token"), localBundle1);
          }
        }
        catch (BadParcelableException localBadParcelableException)
        {
          Log.e("MediaBrowserCompat", "Could not unparcel the data.");
          if (paramMessage.what == 1) {
            localMediaBrowserServiceCallbackImpl.onConnectionFailed((Messenger)localObject1);
          }
        }
      }
    }
    
    void setCallbacksMessenger(Messenger paramMessenger)
    {
      this.mCallbacksMessengerRef = new WeakReference(paramMessenger);
    }
  }
  
  public static class ConnectionCallback
  {
    final MediaBrowser.ConnectionCallback mConnectionCallbackFwk;
    ConnectionCallbackInternal mConnectionCallbackInternal;
    
    public ConnectionCallback()
    {
      if (Build.VERSION.SDK_INT >= 21) {
        this.mConnectionCallbackFwk = new ConnectionCallbackApi21();
      } else {
        this.mConnectionCallbackFwk = null;
      }
    }
    
    public void onConnected() {}
    
    public void onConnectionFailed() {}
    
    public void onConnectionSuspended() {}
    
    void setInternalConnectionCallback(ConnectionCallbackInternal paramConnectionCallbackInternal)
    {
      this.mConnectionCallbackInternal = paramConnectionCallbackInternal;
    }
    
    @RequiresApi(21)
    private class ConnectionCallbackApi21
      extends MediaBrowser.ConnectionCallback
    {
      ConnectionCallbackApi21() {}
      
      public void onConnected()
      {
        MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal localConnectionCallbackInternal = MediaBrowserCompat.ConnectionCallback.this.mConnectionCallbackInternal;
        if (localConnectionCallbackInternal != null) {
          localConnectionCallbackInternal.onConnected();
        }
        MediaBrowserCompat.ConnectionCallback.this.onConnected();
      }
      
      public void onConnectionFailed()
      {
        MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal localConnectionCallbackInternal = MediaBrowserCompat.ConnectionCallback.this.mConnectionCallbackInternal;
        if (localConnectionCallbackInternal != null) {
          localConnectionCallbackInternal.onConnectionFailed();
        }
        MediaBrowserCompat.ConnectionCallback.this.onConnectionFailed();
      }
      
      public void onConnectionSuspended()
      {
        MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal localConnectionCallbackInternal = MediaBrowserCompat.ConnectionCallback.this.mConnectionCallbackInternal;
        if (localConnectionCallbackInternal != null) {
          localConnectionCallbackInternal.onConnectionSuspended();
        }
        MediaBrowserCompat.ConnectionCallback.this.onConnectionSuspended();
      }
    }
    
    static abstract interface ConnectionCallbackInternal
    {
      public abstract void onConnected();
      
      public abstract void onConnectionFailed();
      
      public abstract void onConnectionSuspended();
    }
  }
  
  public static abstract class CustomActionCallback
  {
    public void onError(String paramString, Bundle paramBundle1, Bundle paramBundle2) {}
    
    public void onProgressUpdate(String paramString, Bundle paramBundle1, Bundle paramBundle2) {}
    
    public void onResult(String paramString, Bundle paramBundle1, Bundle paramBundle2) {}
  }
  
  private static class CustomActionResultReceiver
    extends ResultReceiver
  {
    private final String mAction;
    private final MediaBrowserCompat.CustomActionCallback mCallback;
    private final Bundle mExtras;
    
    CustomActionResultReceiver(String paramString, Bundle paramBundle, MediaBrowserCompat.CustomActionCallback paramCustomActionCallback, Handler paramHandler)
    {
      super();
      this.mAction = paramString;
      this.mExtras = paramBundle;
      this.mCallback = paramCustomActionCallback;
    }
    
    protected void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      if (this.mCallback == null) {
        return;
      }
      MediaSessionCompat.ensureClassLoader(paramBundle);
      if (paramInt != -1)
      {
        if (paramInt != 0)
        {
          if (paramInt != 1)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Unknown result code: ");
            localStringBuilder.append(paramInt);
            localStringBuilder.append(" (extras=");
            localStringBuilder.append(this.mExtras);
            localStringBuilder.append(", resultData=");
            localStringBuilder.append(paramBundle);
            localStringBuilder.append(")");
            Log.w("MediaBrowserCompat", localStringBuilder.toString());
          }
          else
          {
            this.mCallback.onProgressUpdate(this.mAction, this.mExtras, paramBundle);
          }
        }
        else {
          this.mCallback.onResult(this.mAction, this.mExtras, paramBundle);
        }
      }
      else {
        this.mCallback.onError(this.mAction, this.mExtras, paramBundle);
      }
    }
  }
  
  public static abstract class ItemCallback
  {
    final MediaBrowser.ItemCallback mItemCallbackFwk;
    
    public ItemCallback()
    {
      if (Build.VERSION.SDK_INT >= 23) {
        this.mItemCallbackFwk = new ItemCallbackApi23();
      } else {
        this.mItemCallbackFwk = null;
      }
    }
    
    public void onError(@NonNull String paramString) {}
    
    public void onItemLoaded(MediaBrowserCompat.MediaItem paramMediaItem) {}
    
    @RequiresApi(23)
    private class ItemCallbackApi23
      extends MediaBrowser.ItemCallback
    {
      ItemCallbackApi23() {}
      
      public void onError(@NonNull String paramString)
      {
        MediaBrowserCompat.ItemCallback.this.onError(paramString);
      }
      
      public void onItemLoaded(MediaBrowser.MediaItem paramMediaItem)
      {
        MediaBrowserCompat.ItemCallback.this.onItemLoaded(MediaBrowserCompat.MediaItem.fromMediaItem(paramMediaItem));
      }
    }
  }
  
  private static class ItemReceiver
    extends ResultReceiver
  {
    private final MediaBrowserCompat.ItemCallback mCallback;
    private final String mMediaId;
    
    ItemReceiver(String paramString, MediaBrowserCompat.ItemCallback paramItemCallback, Handler paramHandler)
    {
      super();
      this.mMediaId = paramString;
      this.mCallback = paramItemCallback;
    }
    
    protected void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      Bundle localBundle = paramBundle;
      if (paramBundle != null) {
        localBundle = MediaSessionCompat.unparcelWithClassLoader(paramBundle);
      }
      if ((paramInt == 0) && (localBundle != null) && (localBundle.containsKey("media_item")))
      {
        paramBundle = localBundle.getParcelable("media_item");
        if ((paramBundle != null) && (!(paramBundle instanceof MediaBrowserCompat.MediaItem))) {
          this.mCallback.onError(this.mMediaId);
        } else {
          this.mCallback.onItemLoaded((MediaBrowserCompat.MediaItem)paramBundle);
        }
        return;
      }
      this.mCallback.onError(this.mMediaId);
    }
  }
  
  static abstract interface MediaBrowserImpl
  {
    public abstract void connect();
    
    public abstract void disconnect();
    
    @Nullable
    public abstract Bundle getExtras();
    
    public abstract void getItem(@NonNull String paramString, @NonNull MediaBrowserCompat.ItemCallback paramItemCallback);
    
    @Nullable
    public abstract Bundle getNotifyChildrenChangedOptions();
    
    @NonNull
    public abstract String getRoot();
    
    public abstract ComponentName getServiceComponent();
    
    @NonNull
    public abstract MediaSessionCompat.Token getSessionToken();
    
    public abstract boolean isConnected();
    
    public abstract void search(@NonNull String paramString, Bundle paramBundle, @NonNull MediaBrowserCompat.SearchCallback paramSearchCallback);
    
    public abstract void sendCustomAction(@NonNull String paramString, Bundle paramBundle, @Nullable MediaBrowserCompat.CustomActionCallback paramCustomActionCallback);
    
    public abstract void subscribe(@NonNull String paramString, @Nullable Bundle paramBundle, @NonNull MediaBrowserCompat.SubscriptionCallback paramSubscriptionCallback);
    
    public abstract void unsubscribe(@NonNull String paramString, MediaBrowserCompat.SubscriptionCallback paramSubscriptionCallback);
  }
  
  @RequiresApi(21)
  static class MediaBrowserImplApi21
    implements MediaBrowserCompat.MediaBrowserImpl, MediaBrowserCompat.MediaBrowserServiceCallbackImpl, MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal
  {
    protected final MediaBrowser mBrowserFwk;
    protected Messenger mCallbacksMessenger;
    final Context mContext;
    protected final MediaBrowserCompat.CallbackHandler mHandler = new MediaBrowserCompat.CallbackHandler(this);
    private MediaSessionCompat.Token mMediaSessionToken;
    private Bundle mNotifyChildrenChangedOptions;
    protected final Bundle mRootHints;
    protected MediaBrowserCompat.ServiceBinderWrapper mServiceBinderWrapper;
    protected int mServiceVersion;
    private final ArrayMap<String, MediaBrowserCompat.Subscription> mSubscriptions = new ArrayMap();
    
    MediaBrowserImplApi21(Context paramContext, ComponentName paramComponentName, MediaBrowserCompat.ConnectionCallback paramConnectionCallback, Bundle paramBundle)
    {
      this.mContext = paramContext;
      Bundle localBundle = new android/os/Bundle;
      if (paramBundle != null) {
        localBundle.<init>(paramBundle);
      } else {
        localBundle.<init>();
      }
      this.mRootHints = localBundle;
      localBundle.putInt("extra_client_version", 1);
      localBundle.putInt("extra_calling_pid", Process.myPid());
      paramConnectionCallback.setInternalConnectionCallback(this);
      this.mBrowserFwk = new MediaBrowser(paramContext, paramComponentName, paramConnectionCallback.mConnectionCallbackFwk, localBundle);
    }
    
    public void connect()
    {
      this.mBrowserFwk.connect();
    }
    
    public void disconnect()
    {
      MediaBrowserCompat.ServiceBinderWrapper localServiceBinderWrapper = this.mServiceBinderWrapper;
      if (localServiceBinderWrapper != null)
      {
        Messenger localMessenger = this.mCallbacksMessenger;
        if (localMessenger != null) {
          try
          {
            localServiceBinderWrapper.unregisterCallbackMessenger(localMessenger);
          }
          catch (RemoteException localRemoteException)
          {
            Log.i("MediaBrowserCompat", "Remote error unregistering client messenger.");
          }
        }
      }
      this.mBrowserFwk.disconnect();
    }
    
    @Nullable
    public Bundle getExtras()
    {
      return this.mBrowserFwk.getExtras();
    }
    
    public void getItem(@NonNull final String paramString, @NonNull final MediaBrowserCompat.ItemCallback paramItemCallback)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        if (paramItemCallback != null)
        {
          if (!this.mBrowserFwk.isConnected())
          {
            Log.i("MediaBrowserCompat", "Not connected, unable to retrieve the MediaItem.");
            this.mHandler.post(new Runnable()
            {
              public void run()
              {
                paramItemCallback.onError(paramString);
              }
            });
            return;
          }
          if (this.mServiceBinderWrapper == null)
          {
            this.mHandler.post(new Runnable()
            {
              public void run()
              {
                paramItemCallback.onError(paramString);
              }
            });
            return;
          }
          MediaBrowserCompat.ItemReceiver localItemReceiver = new MediaBrowserCompat.ItemReceiver(paramString, paramItemCallback, this.mHandler);
          try
          {
            this.mServiceBinderWrapper.getMediaItem(paramString, localItemReceiver, this.mCallbacksMessenger);
          }
          catch (RemoteException localRemoteException)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Remote error getting media item: ");
            localStringBuilder.append(paramString);
            Log.i("MediaBrowserCompat", localStringBuilder.toString());
            this.mHandler.post(new Runnable()
            {
              public void run()
              {
                paramItemCallback.onError(paramString);
              }
            });
          }
          return;
        }
        throw new IllegalArgumentException("cb is null");
      }
      throw new IllegalArgumentException("mediaId is empty");
    }
    
    public Bundle getNotifyChildrenChangedOptions()
    {
      return this.mNotifyChildrenChangedOptions;
    }
    
    @NonNull
    public String getRoot()
    {
      return this.mBrowserFwk.getRoot();
    }
    
    public ComponentName getServiceComponent()
    {
      return this.mBrowserFwk.getServiceComponent();
    }
    
    @NonNull
    public MediaSessionCompat.Token getSessionToken()
    {
      if (this.mMediaSessionToken == null) {
        this.mMediaSessionToken = MediaSessionCompat.Token.fromToken(this.mBrowserFwk.getSessionToken());
      }
      return this.mMediaSessionToken;
    }
    
    public boolean isConnected()
    {
      return this.mBrowserFwk.isConnected();
    }
    
    public void onConnected()
    {
      try
      {
        Object localObject1 = this.mBrowserFwk.getExtras();
        if (localObject1 == null) {
          return;
        }
        this.mServiceVersion = ((Bundle)localObject1).getInt("extra_service_version", 0);
        Object localObject2 = BundleCompat.getBinder((Bundle)localObject1, "extra_messenger");
        if (localObject2 != null)
        {
          this.mServiceBinderWrapper = new MediaBrowserCompat.ServiceBinderWrapper((IBinder)localObject2, this.mRootHints);
          localObject2 = new Messenger(this.mHandler);
          this.mCallbacksMessenger = ((Messenger)localObject2);
          this.mHandler.setCallbacksMessenger((Messenger)localObject2);
          try
          {
            this.mServiceBinderWrapper.registerCallbackMessenger(this.mContext, this.mCallbacksMessenger);
          }
          catch (RemoteException localRemoteException)
          {
            Log.i("MediaBrowserCompat", "Remote error registering client messenger.");
          }
        }
        localObject1 = IMediaSession.Stub.asInterface(BundleCompat.getBinder((Bundle)localObject1, "extra_session_binder"));
        if (localObject1 != null) {
          this.mMediaSessionToken = MediaSessionCompat.Token.fromToken(this.mBrowserFwk.getSessionToken(), (IMediaSession)localObject1);
        }
        return;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        Log.e("MediaBrowserCompat", "Unexpected IllegalStateException", localIllegalStateException);
      }
    }
    
    public void onConnectionFailed() {}
    
    public void onConnectionFailed(Messenger paramMessenger) {}
    
    public void onConnectionSuspended()
    {
      this.mServiceBinderWrapper = null;
      this.mCallbacksMessenger = null;
      this.mMediaSessionToken = null;
      this.mHandler.setCallbacksMessenger(null);
    }
    
    public void onLoadChildren(Messenger paramMessenger, String paramString, List<MediaBrowserCompat.MediaItem> paramList, Bundle paramBundle1, Bundle paramBundle2)
    {
      if (this.mCallbacksMessenger != paramMessenger) {
        return;
      }
      paramMessenger = (MediaBrowserCompat.Subscription)this.mSubscriptions.get(paramString);
      if (paramMessenger == null)
      {
        if (MediaBrowserCompat.DEBUG)
        {
          paramMessenger = new StringBuilder();
          paramMessenger.append("onLoadChildren for id that isn't subscribed id=");
          paramMessenger.append(paramString);
          Log.d("MediaBrowserCompat", paramMessenger.toString());
        }
        return;
      }
      paramMessenger = paramMessenger.getCallback(paramBundle1);
      if (paramMessenger != null) {
        if (paramBundle1 == null)
        {
          if (paramList == null)
          {
            paramMessenger.onError(paramString);
          }
          else
          {
            this.mNotifyChildrenChangedOptions = paramBundle2;
            paramMessenger.onChildrenLoaded(paramString, paramList);
            this.mNotifyChildrenChangedOptions = null;
          }
        }
        else if (paramList == null)
        {
          paramMessenger.onError(paramString, paramBundle1);
        }
        else
        {
          this.mNotifyChildrenChangedOptions = paramBundle2;
          paramMessenger.onChildrenLoaded(paramString, paramList, paramBundle1);
          this.mNotifyChildrenChangedOptions = null;
        }
      }
    }
    
    public void onServiceConnected(Messenger paramMessenger, String paramString, MediaSessionCompat.Token paramToken, Bundle paramBundle) {}
    
    public void search(@NonNull final String paramString, final Bundle paramBundle, @NonNull final MediaBrowserCompat.SearchCallback paramSearchCallback)
    {
      if (isConnected())
      {
        if (this.mServiceBinderWrapper == null)
        {
          Log.i("MediaBrowserCompat", "The connected service doesn't support search.");
          this.mHandler.post(new Runnable()
          {
            public void run()
            {
              paramSearchCallback.onError(paramString, paramBundle);
            }
          });
          return;
        }
        MediaBrowserCompat.SearchResultReceiver localSearchResultReceiver = new MediaBrowserCompat.SearchResultReceiver(paramString, paramBundle, paramSearchCallback, this.mHandler);
        try
        {
          this.mServiceBinderWrapper.search(paramString, paramBundle, localSearchResultReceiver, this.mCallbacksMessenger);
        }
        catch (RemoteException localRemoteException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Remote error searching items with query: ");
          localStringBuilder.append(paramString);
          Log.i("MediaBrowserCompat", localStringBuilder.toString(), localRemoteException);
          this.mHandler.post(new Runnable()
          {
            public void run()
            {
              paramSearchCallback.onError(paramString, paramBundle);
            }
          });
        }
        return;
      }
      throw new IllegalStateException("search() called while not connected");
    }
    
    public void sendCustomAction(@NonNull final String paramString, final Bundle paramBundle, @Nullable final MediaBrowserCompat.CustomActionCallback paramCustomActionCallback)
    {
      if (isConnected())
      {
        if (this.mServiceBinderWrapper == null)
        {
          Log.i("MediaBrowserCompat", "The connected service doesn't support sendCustomAction.");
          if (paramCustomActionCallback != null) {
            this.mHandler.post(new Runnable()
            {
              public void run()
              {
                paramCustomActionCallback.onError(paramString, paramBundle, null);
              }
            });
          }
        }
        MediaBrowserCompat.CustomActionResultReceiver localCustomActionResultReceiver = new MediaBrowserCompat.CustomActionResultReceiver(paramString, paramBundle, paramCustomActionCallback, this.mHandler);
        try
        {
          this.mServiceBinderWrapper.sendCustomAction(paramString, paramBundle, localCustomActionResultReceiver, this.mCallbacksMessenger);
        }
        catch (RemoteException localRemoteException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Remote error sending a custom action: action=");
          localStringBuilder.append(paramString);
          localStringBuilder.append(", extras=");
          localStringBuilder.append(paramBundle);
          Log.i("MediaBrowserCompat", localStringBuilder.toString(), localRemoteException);
          if (paramCustomActionCallback != null) {
            this.mHandler.post(new Runnable()
            {
              public void run()
              {
                paramCustomActionCallback.onError(paramString, paramBundle, null);
              }
            });
          }
        }
        return;
      }
      paramCustomActionCallback = new StringBuilder();
      paramCustomActionCallback.append("Cannot send a custom action (");
      paramCustomActionCallback.append(paramString);
      paramCustomActionCallback.append(") with extras ");
      paramCustomActionCallback.append(paramBundle);
      paramCustomActionCallback.append(" because the browser is not connected to the service.");
      throw new IllegalStateException(paramCustomActionCallback.toString());
    }
    
    public void subscribe(@NonNull String paramString, Bundle paramBundle, @NonNull MediaBrowserCompat.SubscriptionCallback paramSubscriptionCallback)
    {
      MediaBrowserCompat.Subscription localSubscription = (MediaBrowserCompat.Subscription)this.mSubscriptions.get(paramString);
      Object localObject = localSubscription;
      if (localSubscription == null)
      {
        localObject = new MediaBrowserCompat.Subscription();
        this.mSubscriptions.put(paramString, localObject);
      }
      paramSubscriptionCallback.setSubscription((MediaBrowserCompat.Subscription)localObject);
      if (paramBundle == null) {
        paramBundle = null;
      } else {
        paramBundle = new Bundle(paramBundle);
      }
      ((MediaBrowserCompat.Subscription)localObject).putCallback(paramBundle, paramSubscriptionCallback);
      localObject = this.mServiceBinderWrapper;
      if (localObject == null) {
        this.mBrowserFwk.subscribe(paramString, paramSubscriptionCallback.mSubscriptionCallbackFwk);
      } else {
        try
        {
          ((MediaBrowserCompat.ServiceBinderWrapper)localObject).addSubscription(paramString, paramSubscriptionCallback.mToken, paramBundle, this.mCallbacksMessenger);
        }
        catch (RemoteException paramBundle)
        {
          paramBundle = new StringBuilder();
          paramBundle.append("Remote error subscribing media item: ");
          paramBundle.append(paramString);
          Log.i("MediaBrowserCompat", paramBundle.toString());
        }
      }
    }
    
    public void unsubscribe(@NonNull String paramString, MediaBrowserCompat.SubscriptionCallback paramSubscriptionCallback)
    {
      MediaBrowserCompat.Subscription localSubscription = (MediaBrowserCompat.Subscription)this.mSubscriptions.get(paramString);
      if (localSubscription == null) {
        return;
      }
      Object localObject = this.mServiceBinderWrapper;
      List localList;
      int i;
      if (localObject == null)
      {
        if (paramSubscriptionCallback == null)
        {
          this.mBrowserFwk.unsubscribe(paramString);
        }
        else
        {
          localObject = localSubscription.getCallbacks();
          localList = localSubscription.getOptionsList();
          for (i = ((List)localObject).size() - 1; i >= 0; i--) {
            if (((List)localObject).get(i) == paramSubscriptionCallback)
            {
              ((List)localObject).remove(i);
              localList.remove(i);
            }
          }
          if (((List)localObject).size() == 0) {
            this.mBrowserFwk.unsubscribe(paramString);
          }
        }
      }
      else
      {
        if (paramSubscriptionCallback == null) {}
        try
        {
          ((MediaBrowserCompat.ServiceBinderWrapper)localObject).removeSubscription(paramString, null, this.mCallbacksMessenger);
        }
        catch (RemoteException localRemoteException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("removeSubscription failed with RemoteException parentId=");
          localStringBuilder.append(paramString);
          Log.d("MediaBrowserCompat", localStringBuilder.toString());
        }
        localObject = localSubscription.getCallbacks();
        localList = localSubscription.getOptionsList();
        for (i = ((List)localObject).size() - 1; i >= 0; i--) {
          if (((List)localObject).get(i) == paramSubscriptionCallback)
          {
            this.mServiceBinderWrapper.removeSubscription(paramString, paramSubscriptionCallback.mToken, this.mCallbacksMessenger);
            ((List)localObject).remove(i);
            localList.remove(i);
          }
        }
      }
      if ((localSubscription.isEmpty()) || (paramSubscriptionCallback == null)) {
        this.mSubscriptions.remove(paramString);
      }
    }
  }
  
  @RequiresApi(23)
  static class MediaBrowserImplApi23
    extends MediaBrowserCompat.MediaBrowserImplApi21
  {
    MediaBrowserImplApi23(Context paramContext, ComponentName paramComponentName, MediaBrowserCompat.ConnectionCallback paramConnectionCallback, Bundle paramBundle)
    {
      super(paramComponentName, paramConnectionCallback, paramBundle);
    }
    
    public void getItem(@NonNull String paramString, @NonNull MediaBrowserCompat.ItemCallback paramItemCallback)
    {
      if (this.mServiceBinderWrapper == null) {
        this.mBrowserFwk.getItem(paramString, paramItemCallback.mItemCallbackFwk);
      } else {
        super.getItem(paramString, paramItemCallback);
      }
    }
  }
  
  @RequiresApi(26)
  static class MediaBrowserImplApi26
    extends MediaBrowserCompat.MediaBrowserImplApi23
  {
    MediaBrowserImplApi26(Context paramContext, ComponentName paramComponentName, MediaBrowserCompat.ConnectionCallback paramConnectionCallback, Bundle paramBundle)
    {
      super(paramComponentName, paramConnectionCallback, paramBundle);
    }
    
    public void subscribe(@NonNull String paramString, @Nullable Bundle paramBundle, @NonNull MediaBrowserCompat.SubscriptionCallback paramSubscriptionCallback)
    {
      if ((this.mServiceBinderWrapper != null) && (this.mServiceVersion >= 2)) {
        super.subscribe(paramString, paramBundle, paramSubscriptionCallback);
      } else if (paramBundle == null) {
        this.mBrowserFwk.subscribe(paramString, paramSubscriptionCallback.mSubscriptionCallbackFwk);
      } else {
        this.mBrowserFwk.subscribe(paramString, paramBundle, paramSubscriptionCallback.mSubscriptionCallbackFwk);
      }
    }
    
    public void unsubscribe(@NonNull String paramString, MediaBrowserCompat.SubscriptionCallback paramSubscriptionCallback)
    {
      if ((this.mServiceBinderWrapper != null) && (this.mServiceVersion >= 2)) {
        super.unsubscribe(paramString, paramSubscriptionCallback);
      } else if (paramSubscriptionCallback == null) {
        this.mBrowserFwk.unsubscribe(paramString);
      } else {
        this.mBrowserFwk.unsubscribe(paramString, paramSubscriptionCallback.mSubscriptionCallbackFwk);
      }
    }
  }
  
  static class MediaBrowserImplBase
    implements MediaBrowserCompat.MediaBrowserImpl, MediaBrowserCompat.MediaBrowserServiceCallbackImpl
  {
    static final int CONNECT_STATE_CONNECTED = 3;
    static final int CONNECT_STATE_CONNECTING = 2;
    static final int CONNECT_STATE_DISCONNECTED = 1;
    static final int CONNECT_STATE_DISCONNECTING = 0;
    static final int CONNECT_STATE_SUSPENDED = 4;
    final MediaBrowserCompat.ConnectionCallback mCallback;
    Messenger mCallbacksMessenger;
    final Context mContext;
    private Bundle mExtras;
    final MediaBrowserCompat.CallbackHandler mHandler = new MediaBrowserCompat.CallbackHandler(this);
    private MediaSessionCompat.Token mMediaSessionToken;
    private Bundle mNotifyChildrenChangedOptions;
    final Bundle mRootHints;
    private String mRootId;
    MediaBrowserCompat.ServiceBinderWrapper mServiceBinderWrapper;
    final ComponentName mServiceComponent;
    MediaServiceConnection mServiceConnection;
    int mState = 1;
    private final ArrayMap<String, MediaBrowserCompat.Subscription> mSubscriptions = new ArrayMap();
    
    public MediaBrowserImplBase(Context paramContext, ComponentName paramComponentName, MediaBrowserCompat.ConnectionCallback paramConnectionCallback, Bundle paramBundle)
    {
      if (paramContext != null)
      {
        if (paramComponentName != null)
        {
          if (paramConnectionCallback != null)
          {
            this.mContext = paramContext;
            this.mServiceComponent = paramComponentName;
            this.mCallback = paramConnectionCallback;
            if (paramBundle == null) {
              paramContext = null;
            } else {
              paramContext = new Bundle(paramBundle);
            }
            this.mRootHints = paramContext;
            return;
          }
          throw new IllegalArgumentException("connection callback must not be null");
        }
        throw new IllegalArgumentException("service component must not be null");
      }
      throw new IllegalArgumentException("context must not be null");
    }
    
    private static String getStateLabel(int paramInt)
    {
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt != 3)
            {
              if (paramInt != 4)
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("UNKNOWN/");
                localStringBuilder.append(paramInt);
                return localStringBuilder.toString();
              }
              return "CONNECT_STATE_SUSPENDED";
            }
            return "CONNECT_STATE_CONNECTED";
          }
          return "CONNECT_STATE_CONNECTING";
        }
        return "CONNECT_STATE_DISCONNECTED";
      }
      return "CONNECT_STATE_DISCONNECTING";
    }
    
    private boolean isCurrent(Messenger paramMessenger, String paramString)
    {
      if (this.mCallbacksMessenger == paramMessenger)
      {
        i = this.mState;
        if ((i != 0) && (i != 1)) {
          return true;
        }
      }
      int i = this.mState;
      if ((i != 0) && (i != 1))
      {
        paramMessenger = new StringBuilder();
        paramMessenger.append(paramString);
        paramMessenger.append(" for ");
        paramMessenger.append(this.mServiceComponent);
        paramMessenger.append(" with mCallbacksMessenger=");
        paramMessenger.append(this.mCallbacksMessenger);
        paramMessenger.append(" this=");
        paramMessenger.append(this);
        Log.i("MediaBrowserCompat", paramMessenger.toString());
      }
      return false;
    }
    
    public void connect()
    {
      int i = this.mState;
      if ((i != 0) && (i != 1))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("connect() called while neigther disconnecting nor disconnected (state=");
        localStringBuilder.append(getStateLabel(this.mState));
        localStringBuilder.append(")");
        throw new IllegalStateException(localStringBuilder.toString());
      }
      this.mState = 2;
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          Object localObject = MediaBrowserCompat.MediaBrowserImplBase.this;
          if (((MediaBrowserCompat.MediaBrowserImplBase)localObject).mState == 0) {
            return;
          }
          ((MediaBrowserCompat.MediaBrowserImplBase)localObject).mState = 2;
          if ((MediaBrowserCompat.DEBUG) && (((MediaBrowserCompat.MediaBrowserImplBase)localObject).mServiceConnection != null))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("mServiceConnection should be null. Instead it is ");
            ((StringBuilder)localObject).append(MediaBrowserCompat.MediaBrowserImplBase.this.mServiceConnection);
            throw new RuntimeException(((StringBuilder)localObject).toString());
          }
          if (((MediaBrowserCompat.MediaBrowserImplBase)localObject).mServiceBinderWrapper == null)
          {
            if (((MediaBrowserCompat.MediaBrowserImplBase)localObject).mCallbacksMessenger == null)
            {
              localObject = new Intent("android.media.browse.MediaBrowserService");
              ((Intent)localObject).setComponent(MediaBrowserCompat.MediaBrowserImplBase.this.mServiceComponent);
              MediaBrowserCompat.MediaBrowserImplBase localMediaBrowserImplBase = MediaBrowserCompat.MediaBrowserImplBase.this;
              localMediaBrowserImplBase.mServiceConnection = new MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection(localMediaBrowserImplBase);
              boolean bool1 = false;
              boolean bool2;
              try
              {
                localMediaBrowserImplBase = MediaBrowserCompat.MediaBrowserImplBase.this;
                bool2 = localMediaBrowserImplBase.mContext.bindService((Intent)localObject, localMediaBrowserImplBase.mServiceConnection, 1);
              }
              catch (Exception localException)
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("Failed binding to service ");
                localStringBuilder.append(MediaBrowserCompat.MediaBrowserImplBase.this.mServiceComponent);
                Log.e("MediaBrowserCompat", localStringBuilder.toString());
                bool2 = bool1;
              }
              if (!bool2)
              {
                MediaBrowserCompat.MediaBrowserImplBase.this.forceCloseConnection();
                MediaBrowserCompat.MediaBrowserImplBase.this.mCallback.onConnectionFailed();
              }
              if (MediaBrowserCompat.DEBUG)
              {
                Log.d("MediaBrowserCompat", "connect...");
                MediaBrowserCompat.MediaBrowserImplBase.this.dump();
              }
              return;
            }
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("mCallbacksMessenger should be null. Instead it is ");
            localStringBuilder.append(MediaBrowserCompat.MediaBrowserImplBase.this.mCallbacksMessenger);
            throw new RuntimeException(localStringBuilder.toString());
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("mServiceBinderWrapper should be null. Instead it is ");
          localStringBuilder.append(MediaBrowserCompat.MediaBrowserImplBase.this.mServiceBinderWrapper);
          throw new RuntimeException(localStringBuilder.toString());
        }
      });
    }
    
    public void disconnect()
    {
      this.mState = 0;
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          MediaBrowserCompat.MediaBrowserImplBase localMediaBrowserImplBase = MediaBrowserCompat.MediaBrowserImplBase.this;
          Messenger localMessenger = localMediaBrowserImplBase.mCallbacksMessenger;
          if (localMessenger != null) {
            try
            {
              localMediaBrowserImplBase.mServiceBinderWrapper.disconnect(localMessenger);
            }
            catch (RemoteException localRemoteException)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("RemoteException during connect for ");
              ((StringBuilder)localObject).append(MediaBrowserCompat.MediaBrowserImplBase.this.mServiceComponent);
              Log.w("MediaBrowserCompat", ((StringBuilder)localObject).toString());
            }
          }
          Object localObject = MediaBrowserCompat.MediaBrowserImplBase.this;
          int i = ((MediaBrowserCompat.MediaBrowserImplBase)localObject).mState;
          ((MediaBrowserCompat.MediaBrowserImplBase)localObject).forceCloseConnection();
          if (i != 0) {
            MediaBrowserCompat.MediaBrowserImplBase.this.mState = i;
          }
          if (MediaBrowserCompat.DEBUG)
          {
            Log.d("MediaBrowserCompat", "disconnect...");
            MediaBrowserCompat.MediaBrowserImplBase.this.dump();
          }
        }
      });
    }
    
    void dump()
    {
      Log.d("MediaBrowserCompat", "MediaBrowserCompat...");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("  mServiceComponent=");
      localStringBuilder.append(this.mServiceComponent);
      Log.d("MediaBrowserCompat", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("  mCallback=");
      localStringBuilder.append(this.mCallback);
      Log.d("MediaBrowserCompat", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("  mRootHints=");
      localStringBuilder.append(this.mRootHints);
      Log.d("MediaBrowserCompat", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("  mState=");
      localStringBuilder.append(getStateLabel(this.mState));
      Log.d("MediaBrowserCompat", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("  mServiceConnection=");
      localStringBuilder.append(this.mServiceConnection);
      Log.d("MediaBrowserCompat", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("  mServiceBinderWrapper=");
      localStringBuilder.append(this.mServiceBinderWrapper);
      Log.d("MediaBrowserCompat", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("  mCallbacksMessenger=");
      localStringBuilder.append(this.mCallbacksMessenger);
      Log.d("MediaBrowserCompat", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("  mRootId=");
      localStringBuilder.append(this.mRootId);
      Log.d("MediaBrowserCompat", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("  mMediaSessionToken=");
      localStringBuilder.append(this.mMediaSessionToken);
      Log.d("MediaBrowserCompat", localStringBuilder.toString());
    }
    
    void forceCloseConnection()
    {
      MediaServiceConnection localMediaServiceConnection = this.mServiceConnection;
      if (localMediaServiceConnection != null) {
        this.mContext.unbindService(localMediaServiceConnection);
      }
      this.mState = 1;
      this.mServiceConnection = null;
      this.mServiceBinderWrapper = null;
      this.mCallbacksMessenger = null;
      this.mHandler.setCallbacksMessenger(null);
      this.mRootId = null;
      this.mMediaSessionToken = null;
    }
    
    @Nullable
    public Bundle getExtras()
    {
      if (isConnected()) {
        return this.mExtras;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getExtras() called while not connected (state=");
      localStringBuilder.append(getStateLabel(this.mState));
      localStringBuilder.append(")");
      throw new IllegalStateException(localStringBuilder.toString());
    }
    
    public void getItem(@NonNull final String paramString, @NonNull final MediaBrowserCompat.ItemCallback paramItemCallback)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        if (paramItemCallback != null)
        {
          if (!isConnected())
          {
            Log.i("MediaBrowserCompat", "Not connected, unable to retrieve the MediaItem.");
            this.mHandler.post(new Runnable()
            {
              public void run()
              {
                paramItemCallback.onError(paramString);
              }
            });
            return;
          }
          MediaBrowserCompat.ItemReceiver localItemReceiver = new MediaBrowserCompat.ItemReceiver(paramString, paramItemCallback, this.mHandler);
          try
          {
            this.mServiceBinderWrapper.getMediaItem(paramString, localItemReceiver, this.mCallbacksMessenger);
          }
          catch (RemoteException localRemoteException)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Remote error getting media item: ");
            localStringBuilder.append(paramString);
            Log.i("MediaBrowserCompat", localStringBuilder.toString());
            this.mHandler.post(new Runnable()
            {
              public void run()
              {
                paramItemCallback.onError(paramString);
              }
            });
          }
          return;
        }
        throw new IllegalArgumentException("cb is null");
      }
      throw new IllegalArgumentException("mediaId is empty");
    }
    
    public Bundle getNotifyChildrenChangedOptions()
    {
      return this.mNotifyChildrenChangedOptions;
    }
    
    @NonNull
    public String getRoot()
    {
      if (isConnected()) {
        return this.mRootId;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getRoot() called while not connected(state=");
      localStringBuilder.append(getStateLabel(this.mState));
      localStringBuilder.append(")");
      throw new IllegalStateException(localStringBuilder.toString());
    }
    
    @NonNull
    public ComponentName getServiceComponent()
    {
      if (isConnected()) {
        return this.mServiceComponent;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getServiceComponent() called while not connected (state=");
      localStringBuilder.append(this.mState);
      localStringBuilder.append(")");
      throw new IllegalStateException(localStringBuilder.toString());
    }
    
    @NonNull
    public MediaSessionCompat.Token getSessionToken()
    {
      if (isConnected()) {
        return this.mMediaSessionToken;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSessionToken() called while not connected(state=");
      localStringBuilder.append(this.mState);
      localStringBuilder.append(")");
      throw new IllegalStateException(localStringBuilder.toString());
    }
    
    public boolean isConnected()
    {
      boolean bool;
      if (this.mState == 3) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public void onConnectionFailed(Messenger paramMessenger)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onConnectFailed for ");
      localStringBuilder.append(this.mServiceComponent);
      Log.e("MediaBrowserCompat", localStringBuilder.toString());
      if (!isCurrent(paramMessenger, "onConnectFailed")) {
        return;
      }
      if (this.mState != 2)
      {
        paramMessenger = new StringBuilder();
        paramMessenger.append("onConnect from service while mState=");
        paramMessenger.append(getStateLabel(this.mState));
        paramMessenger.append("... ignoring");
        Log.w("MediaBrowserCompat", paramMessenger.toString());
        return;
      }
      forceCloseConnection();
      this.mCallback.onConnectionFailed();
    }
    
    public void onLoadChildren(Messenger paramMessenger, String paramString, List<MediaBrowserCompat.MediaItem> paramList, Bundle paramBundle1, Bundle paramBundle2)
    {
      if (!isCurrent(paramMessenger, "onLoadChildren")) {
        return;
      }
      boolean bool = MediaBrowserCompat.DEBUG;
      if (bool)
      {
        paramMessenger = new StringBuilder();
        paramMessenger.append("onLoadChildren for ");
        paramMessenger.append(this.mServiceComponent);
        paramMessenger.append(" id=");
        paramMessenger.append(paramString);
        Log.d("MediaBrowserCompat", paramMessenger.toString());
      }
      paramMessenger = (MediaBrowserCompat.Subscription)this.mSubscriptions.get(paramString);
      if (paramMessenger == null)
      {
        if (bool)
        {
          paramMessenger = new StringBuilder();
          paramMessenger.append("onLoadChildren for id that isn't subscribed id=");
          paramMessenger.append(paramString);
          Log.d("MediaBrowserCompat", paramMessenger.toString());
        }
        return;
      }
      paramMessenger = paramMessenger.getCallback(paramBundle1);
      if (paramMessenger != null) {
        if (paramBundle1 == null)
        {
          if (paramList == null)
          {
            paramMessenger.onError(paramString);
          }
          else
          {
            this.mNotifyChildrenChangedOptions = paramBundle2;
            paramMessenger.onChildrenLoaded(paramString, paramList);
            this.mNotifyChildrenChangedOptions = null;
          }
        }
        else if (paramList == null)
        {
          paramMessenger.onError(paramString, paramBundle1);
        }
        else
        {
          this.mNotifyChildrenChangedOptions = paramBundle2;
          paramMessenger.onChildrenLoaded(paramString, paramList, paramBundle1);
          this.mNotifyChildrenChangedOptions = null;
        }
      }
    }
    
    public void onServiceConnected(Messenger paramMessenger, String paramString, MediaSessionCompat.Token paramToken, Bundle paramBundle)
    {
      if (!isCurrent(paramMessenger, "onConnect")) {
        return;
      }
      if (this.mState != 2)
      {
        paramMessenger = new StringBuilder();
        paramMessenger.append("onConnect from service while mState=");
        paramMessenger.append(getStateLabel(this.mState));
        paramMessenger.append("... ignoring");
        Log.w("MediaBrowserCompat", paramMessenger.toString());
        return;
      }
      this.mRootId = paramString;
      this.mMediaSessionToken = paramToken;
      this.mExtras = paramBundle;
      this.mState = 3;
      if (MediaBrowserCompat.DEBUG)
      {
        Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
        dump();
      }
      this.mCallback.onConnected();
      try
      {
        paramMessenger = this.mSubscriptions.entrySet().iterator();
        while (paramMessenger.hasNext())
        {
          paramToken = (Map.Entry)paramMessenger.next();
          paramString = (String)paramToken.getKey();
          paramBundle = (MediaBrowserCompat.Subscription)paramToken.getValue();
          paramToken = paramBundle.getCallbacks();
          paramBundle = paramBundle.getOptionsList();
          for (int i = 0; i < paramToken.size(); i++) {
            this.mServiceBinderWrapper.addSubscription(paramString, ((MediaBrowserCompat.SubscriptionCallback)paramToken.get(i)).mToken, (Bundle)paramBundle.get(i), this.mCallbacksMessenger);
          }
        }
        return;
      }
      catch (RemoteException paramMessenger)
      {
        Log.d("MediaBrowserCompat", "addSubscription failed with RemoteException.");
      }
    }
    
    public void search(@NonNull final String paramString, final Bundle paramBundle, @NonNull final MediaBrowserCompat.SearchCallback paramSearchCallback)
    {
      if (isConnected())
      {
        MediaBrowserCompat.SearchResultReceiver localSearchResultReceiver = new MediaBrowserCompat.SearchResultReceiver(paramString, paramBundle, paramSearchCallback, this.mHandler);
        try
        {
          this.mServiceBinderWrapper.search(paramString, paramBundle, localSearchResultReceiver, this.mCallbacksMessenger);
        }
        catch (RemoteException localRemoteException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Remote error searching items with query: ");
          localStringBuilder.append(paramString);
          Log.i("MediaBrowserCompat", localStringBuilder.toString(), localRemoteException);
          this.mHandler.post(new Runnable()
          {
            public void run()
            {
              paramSearchCallback.onError(paramString, paramBundle);
            }
          });
        }
        return;
      }
      paramString = new StringBuilder();
      paramString.append("search() called while not connected (state=");
      paramString.append(getStateLabel(this.mState));
      paramString.append(")");
      throw new IllegalStateException(paramString.toString());
    }
    
    public void sendCustomAction(@NonNull final String paramString, final Bundle paramBundle, @Nullable final MediaBrowserCompat.CustomActionCallback paramCustomActionCallback)
    {
      if (isConnected())
      {
        MediaBrowserCompat.CustomActionResultReceiver localCustomActionResultReceiver = new MediaBrowserCompat.CustomActionResultReceiver(paramString, paramBundle, paramCustomActionCallback, this.mHandler);
        try
        {
          this.mServiceBinderWrapper.sendCustomAction(paramString, paramBundle, localCustomActionResultReceiver, this.mCallbacksMessenger);
        }
        catch (RemoteException localRemoteException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Remote error sending a custom action: action=");
          localStringBuilder.append(paramString);
          localStringBuilder.append(", extras=");
          localStringBuilder.append(paramBundle);
          Log.i("MediaBrowserCompat", localStringBuilder.toString(), localRemoteException);
          if (paramCustomActionCallback != null) {
            this.mHandler.post(new Runnable()
            {
              public void run()
              {
                paramCustomActionCallback.onError(paramString, paramBundle, null);
              }
            });
          }
        }
        return;
      }
      paramCustomActionCallback = new StringBuilder();
      paramCustomActionCallback.append("Cannot send a custom action (");
      paramCustomActionCallback.append(paramString);
      paramCustomActionCallback.append(") with extras ");
      paramCustomActionCallback.append(paramBundle);
      paramCustomActionCallback.append(" because the browser is not connected to the service.");
      throw new IllegalStateException(paramCustomActionCallback.toString());
    }
    
    public void subscribe(@NonNull String paramString, Bundle paramBundle, @NonNull MediaBrowserCompat.SubscriptionCallback paramSubscriptionCallback)
    {
      MediaBrowserCompat.Subscription localSubscription1 = (MediaBrowserCompat.Subscription)this.mSubscriptions.get(paramString);
      MediaBrowserCompat.Subscription localSubscription2 = localSubscription1;
      if (localSubscription1 == null)
      {
        localSubscription2 = new MediaBrowserCompat.Subscription();
        this.mSubscriptions.put(paramString, localSubscription2);
      }
      if (paramBundle == null) {
        paramBundle = null;
      } else {
        paramBundle = new Bundle(paramBundle);
      }
      localSubscription2.putCallback(paramBundle, paramSubscriptionCallback);
      if (isConnected()) {
        try
        {
          this.mServiceBinderWrapper.addSubscription(paramString, paramSubscriptionCallback.mToken, paramBundle, this.mCallbacksMessenger);
        }
        catch (RemoteException paramBundle)
        {
          paramBundle = new StringBuilder();
          paramBundle.append("addSubscription failed with RemoteException parentId=");
          paramBundle.append(paramString);
          Log.d("MediaBrowserCompat", paramBundle.toString());
        }
      }
    }
    
    public void unsubscribe(@NonNull String paramString, MediaBrowserCompat.SubscriptionCallback paramSubscriptionCallback)
    {
      MediaBrowserCompat.Subscription localSubscription = (MediaBrowserCompat.Subscription)this.mSubscriptions.get(paramString);
      if (localSubscription == null) {
        return;
      }
      if (paramSubscriptionCallback == null) {}
      try
      {
        if (!isConnected()) {
          break label172;
        }
        this.mServiceBinderWrapper.removeSubscription(paramString, null, this.mCallbacksMessenger);
      }
      catch (RemoteException localRemoteException)
      {
        List localList1;
        List localList2;
        int i;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("removeSubscription failed with RemoteException parentId=");
        localStringBuilder.append(paramString);
        Log.d("MediaBrowserCompat", localStringBuilder.toString());
        label172:
        if ((!localSubscription.isEmpty()) && (paramSubscriptionCallback != null)) {
          return;
        }
        this.mSubscriptions.remove(paramString);
      }
      localList1 = localSubscription.getCallbacks();
      localList2 = localSubscription.getOptionsList();
      for (i = localList1.size() - 1; i >= 0; i--) {
        if (localList1.get(i) == paramSubscriptionCallback)
        {
          if (isConnected()) {
            this.mServiceBinderWrapper.removeSubscription(paramString, paramSubscriptionCallback.mToken, this.mCallbacksMessenger);
          }
          localList1.remove(i);
          localList2.remove(i);
        }
      }
    }
    
    private class MediaServiceConnection
      implements ServiceConnection
    {
      MediaServiceConnection() {}
      
      private void postOrRun(Runnable paramRunnable)
      {
        if (Thread.currentThread() == MediaBrowserCompat.MediaBrowserImplBase.this.mHandler.getLooper().getThread()) {
          paramRunnable.run();
        } else {
          MediaBrowserCompat.MediaBrowserImplBase.this.mHandler.post(paramRunnable);
        }
      }
      
      boolean isCurrent(String paramString)
      {
        Object localObject = MediaBrowserCompat.MediaBrowserImplBase.this;
        if (((MediaBrowserCompat.MediaBrowserImplBase)localObject).mServiceConnection == this)
        {
          i = ((MediaBrowserCompat.MediaBrowserImplBase)localObject).mState;
          if ((i != 0) && (i != 1)) {
            return true;
          }
        }
        int i = ((MediaBrowserCompat.MediaBrowserImplBase)localObject).mState;
        if ((i != 0) && (i != 1))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(" for ");
          ((StringBuilder)localObject).append(MediaBrowserCompat.MediaBrowserImplBase.this.mServiceComponent);
          ((StringBuilder)localObject).append(" with mServiceConnection=");
          ((StringBuilder)localObject).append(MediaBrowserCompat.MediaBrowserImplBase.this.mServiceConnection);
          ((StringBuilder)localObject).append(" this=");
          ((StringBuilder)localObject).append(this);
          Log.i("MediaBrowserCompat", ((StringBuilder)localObject).toString());
        }
        return false;
      }
      
      public void onServiceConnected(final ComponentName paramComponentName, final IBinder paramIBinder)
      {
        postOrRun(new Runnable()
        {
          public void run()
          {
            boolean bool = MediaBrowserCompat.DEBUG;
            if (bool)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("MediaServiceConnection.onServiceConnected name=");
              ((StringBuilder)localObject).append(paramComponentName);
              ((StringBuilder)localObject).append(" binder=");
              ((StringBuilder)localObject).append(paramIBinder);
              Log.d("MediaBrowserCompat", ((StringBuilder)localObject).toString());
              MediaBrowserCompat.MediaBrowserImplBase.this.dump();
            }
            if (!MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.this.isCurrent("onServiceConnected")) {
              return;
            }
            Object localObject = MediaBrowserCompat.MediaBrowserImplBase.this;
            ((MediaBrowserCompat.MediaBrowserImplBase)localObject).mServiceBinderWrapper = new MediaBrowserCompat.ServiceBinderWrapper(paramIBinder, ((MediaBrowserCompat.MediaBrowserImplBase)localObject).mRootHints);
            MediaBrowserCompat.MediaBrowserImplBase.this.mCallbacksMessenger = new Messenger(MediaBrowserCompat.MediaBrowserImplBase.this.mHandler);
            localObject = MediaBrowserCompat.MediaBrowserImplBase.this;
            ((MediaBrowserCompat.MediaBrowserImplBase)localObject).mHandler.setCallbacksMessenger(((MediaBrowserCompat.MediaBrowserImplBase)localObject).mCallbacksMessenger);
            MediaBrowserCompat.MediaBrowserImplBase.this.mState = 2;
            if (bool) {}
            try
            {
              Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
              MediaBrowserCompat.MediaBrowserImplBase.this.dump();
              localObject = MediaBrowserCompat.MediaBrowserImplBase.this;
              ((MediaBrowserCompat.MediaBrowserImplBase)localObject).mServiceBinderWrapper.connect(((MediaBrowserCompat.MediaBrowserImplBase)localObject).mContext, ((MediaBrowserCompat.MediaBrowserImplBase)localObject).mCallbacksMessenger);
            }
            catch (RemoteException localRemoteException)
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("RemoteException during connect for ");
              localStringBuilder.append(MediaBrowserCompat.MediaBrowserImplBase.this.mServiceComponent);
              Log.w("MediaBrowserCompat", localStringBuilder.toString());
              if (MediaBrowserCompat.DEBUG)
              {
                Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                MediaBrowserCompat.MediaBrowserImplBase.this.dump();
              }
            }
          }
        });
      }
      
      public void onServiceDisconnected(final ComponentName paramComponentName)
      {
        postOrRun(new Runnable()
        {
          public void run()
          {
            if (MediaBrowserCompat.DEBUG)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("MediaServiceConnection.onServiceDisconnected name=");
              ((StringBuilder)localObject).append(paramComponentName);
              ((StringBuilder)localObject).append(" this=");
              ((StringBuilder)localObject).append(this);
              ((StringBuilder)localObject).append(" mServiceConnection=");
              ((StringBuilder)localObject).append(MediaBrowserCompat.MediaBrowserImplBase.this.mServiceConnection);
              Log.d("MediaBrowserCompat", ((StringBuilder)localObject).toString());
              MediaBrowserCompat.MediaBrowserImplBase.this.dump();
            }
            if (!MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.this.isCurrent("onServiceDisconnected")) {
              return;
            }
            Object localObject = MediaBrowserCompat.MediaBrowserImplBase.this;
            ((MediaBrowserCompat.MediaBrowserImplBase)localObject).mServiceBinderWrapper = null;
            ((MediaBrowserCompat.MediaBrowserImplBase)localObject).mCallbacksMessenger = null;
            ((MediaBrowserCompat.MediaBrowserImplBase)localObject).mHandler.setCallbacksMessenger(null);
            localObject = MediaBrowserCompat.MediaBrowserImplBase.this;
            ((MediaBrowserCompat.MediaBrowserImplBase)localObject).mState = 4;
            ((MediaBrowserCompat.MediaBrowserImplBase)localObject).mCallback.onConnectionSuspended();
          }
        });
      }
    }
  }
  
  static abstract interface MediaBrowserServiceCallbackImpl
  {
    public abstract void onConnectionFailed(Messenger paramMessenger);
    
    public abstract void onLoadChildren(Messenger paramMessenger, String paramString, List<MediaBrowserCompat.MediaItem> paramList, Bundle paramBundle1, Bundle paramBundle2);
    
    public abstract void onServiceConnected(Messenger paramMessenger, String paramString, MediaSessionCompat.Token paramToken, Bundle paramBundle);
  }
  
  @SuppressLint({"BanParcelableUsage"})
  public static class MediaItem
    implements Parcelable
  {
    public static final Parcelable.Creator<MediaItem> CREATOR = new Parcelable.Creator()
    {
      public MediaBrowserCompat.MediaItem createFromParcel(Parcel paramAnonymousParcel)
      {
        return new MediaBrowserCompat.MediaItem(paramAnonymousParcel);
      }
      
      public MediaBrowserCompat.MediaItem[] newArray(int paramAnonymousInt)
      {
        return new MediaBrowserCompat.MediaItem[paramAnonymousInt];
      }
    };
    public static final int FLAG_BROWSABLE = 1;
    public static final int FLAG_PLAYABLE = 2;
    private final MediaDescriptionCompat mDescription;
    private final int mFlags;
    
    MediaItem(Parcel paramParcel)
    {
      this.mFlags = paramParcel.readInt();
      this.mDescription = ((MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(paramParcel));
    }
    
    public MediaItem(@NonNull MediaDescriptionCompat paramMediaDescriptionCompat, int paramInt)
    {
      if (paramMediaDescriptionCompat != null)
      {
        if (!TextUtils.isEmpty(paramMediaDescriptionCompat.getMediaId()))
        {
          this.mFlags = paramInt;
          this.mDescription = paramMediaDescriptionCompat;
          return;
        }
        throw new IllegalArgumentException("description must have a non-empty media id");
      }
      throw new IllegalArgumentException("description cannot be null");
    }
    
    public static MediaItem fromMediaItem(Object paramObject)
    {
      if ((paramObject != null) && (Build.VERSION.SDK_INT >= 21))
      {
        paramObject = (MediaBrowser.MediaItem)paramObject;
        int i = ((MediaBrowser.MediaItem)paramObject).getFlags();
        return new MediaItem(MediaDescriptionCompat.fromMediaDescription(((MediaBrowser.MediaItem)paramObject).getDescription()), i);
      }
      return null;
    }
    
    public static List<MediaItem> fromMediaItemList(List<?> paramList)
    {
      if ((paramList != null) && (Build.VERSION.SDK_INT >= 21))
      {
        ArrayList localArrayList = new ArrayList(paramList.size());
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
          localArrayList.add(fromMediaItem(paramList.next()));
        }
        return localArrayList;
      }
      return null;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    @NonNull
    public MediaDescriptionCompat getDescription()
    {
      return this.mDescription;
    }
    
    public int getFlags()
    {
      return this.mFlags;
    }
    
    @Nullable
    public String getMediaId()
    {
      return this.mDescription.getMediaId();
    }
    
    public boolean isBrowsable()
    {
      int i = this.mFlags;
      boolean bool = true;
      if ((i & 0x1) == 0) {
        bool = false;
      }
      return bool;
    }
    
    public boolean isPlayable()
    {
      boolean bool;
      if ((this.mFlags & 0x2) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    @NonNull
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("MediaItem{");
      localStringBuilder.append("mFlags=");
      localStringBuilder.append(this.mFlags);
      localStringBuilder.append(", mDescription=");
      localStringBuilder.append(this.mDescription);
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.mFlags);
      this.mDescription.writeToParcel(paramParcel, paramInt);
    }
  }
  
  public static abstract class SearchCallback
  {
    public void onError(@NonNull String paramString, Bundle paramBundle) {}
    
    public void onSearchResult(@NonNull String paramString, Bundle paramBundle, @NonNull List<MediaBrowserCompat.MediaItem> paramList) {}
  }
  
  private static class SearchResultReceiver
    extends ResultReceiver
  {
    private final MediaBrowserCompat.SearchCallback mCallback;
    private final Bundle mExtras;
    private final String mQuery;
    
    SearchResultReceiver(String paramString, Bundle paramBundle, MediaBrowserCompat.SearchCallback paramSearchCallback, Handler paramHandler)
    {
      super();
      this.mQuery = paramString;
      this.mExtras = paramBundle;
      this.mCallback = paramSearchCallback;
    }
    
    protected void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      Object localObject = paramBundle;
      if (paramBundle != null) {
        localObject = MediaSessionCompat.unparcelWithClassLoader(paramBundle);
      }
      if ((paramInt == 0) && (localObject != null) && (((Bundle)localObject).containsKey("search_results")))
      {
        paramBundle = ((Bundle)localObject).getParcelableArray("search_results");
        if (paramBundle != null)
        {
          localObject = new ArrayList();
          int i = paramBundle.length;
          for (paramInt = 0; paramInt < i; paramInt++) {
            ((List)localObject).add((MediaBrowserCompat.MediaItem)paramBundle[paramInt]);
          }
          this.mCallback.onSearchResult(this.mQuery, this.mExtras, (List)localObject);
        }
        else
        {
          this.mCallback.onError(this.mQuery, this.mExtras);
        }
        return;
      }
      this.mCallback.onError(this.mQuery, this.mExtras);
    }
  }
  
  private static class ServiceBinderWrapper
  {
    private Messenger mMessenger;
    private Bundle mRootHints;
    
    public ServiceBinderWrapper(IBinder paramIBinder, Bundle paramBundle)
    {
      this.mMessenger = new Messenger(paramIBinder);
      this.mRootHints = paramBundle;
    }
    
    private void sendRequest(int paramInt, Bundle paramBundle, Messenger paramMessenger)
      throws RemoteException
    {
      Message localMessage = Message.obtain();
      localMessage.what = paramInt;
      localMessage.arg1 = 1;
      localMessage.setData(paramBundle);
      localMessage.replyTo = paramMessenger;
      this.mMessenger.send(localMessage);
    }
    
    void addSubscription(String paramString, IBinder paramIBinder, Bundle paramBundle, Messenger paramMessenger)
      throws RemoteException
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("data_media_item_id", paramString);
      BundleCompat.putBinder(localBundle, "data_callback_token", paramIBinder);
      localBundle.putBundle("data_options", paramBundle);
      sendRequest(3, localBundle, paramMessenger);
    }
    
    void connect(Context paramContext, Messenger paramMessenger)
      throws RemoteException
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("data_package_name", paramContext.getPackageName());
      localBundle.putInt("data_calling_pid", Process.myPid());
      localBundle.putBundle("data_root_hints", this.mRootHints);
      sendRequest(1, localBundle, paramMessenger);
    }
    
    void disconnect(Messenger paramMessenger)
      throws RemoteException
    {
      sendRequest(2, null, paramMessenger);
    }
    
    void getMediaItem(String paramString, ResultReceiver paramResultReceiver, Messenger paramMessenger)
      throws RemoteException
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("data_media_item_id", paramString);
      localBundle.putParcelable("data_result_receiver", paramResultReceiver);
      sendRequest(5, localBundle, paramMessenger);
    }
    
    void registerCallbackMessenger(Context paramContext, Messenger paramMessenger)
      throws RemoteException
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("data_package_name", paramContext.getPackageName());
      localBundle.putInt("data_calling_pid", Process.myPid());
      localBundle.putBundle("data_root_hints", this.mRootHints);
      sendRequest(6, localBundle, paramMessenger);
    }
    
    void removeSubscription(String paramString, IBinder paramIBinder, Messenger paramMessenger)
      throws RemoteException
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("data_media_item_id", paramString);
      BundleCompat.putBinder(localBundle, "data_callback_token", paramIBinder);
      sendRequest(4, localBundle, paramMessenger);
    }
    
    void search(String paramString, Bundle paramBundle, ResultReceiver paramResultReceiver, Messenger paramMessenger)
      throws RemoteException
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("data_search_query", paramString);
      localBundle.putBundle("data_search_extras", paramBundle);
      localBundle.putParcelable("data_result_receiver", paramResultReceiver);
      sendRequest(8, localBundle, paramMessenger);
    }
    
    void sendCustomAction(String paramString, Bundle paramBundle, ResultReceiver paramResultReceiver, Messenger paramMessenger)
      throws RemoteException
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("data_custom_action", paramString);
      localBundle.putBundle("data_custom_action_extras", paramBundle);
      localBundle.putParcelable("data_result_receiver", paramResultReceiver);
      sendRequest(9, localBundle, paramMessenger);
    }
    
    void unregisterCallbackMessenger(Messenger paramMessenger)
      throws RemoteException
    {
      sendRequest(7, null, paramMessenger);
    }
  }
  
  private static class Subscription
  {
    private final List<MediaBrowserCompat.SubscriptionCallback> mCallbacks = new ArrayList();
    private final List<Bundle> mOptionsList = new ArrayList();
    
    public MediaBrowserCompat.SubscriptionCallback getCallback(Bundle paramBundle)
    {
      for (int i = 0; i < this.mOptionsList.size(); i++) {
        if (MediaBrowserCompatUtils.areSameOptions((Bundle)this.mOptionsList.get(i), paramBundle)) {
          return (MediaBrowserCompat.SubscriptionCallback)this.mCallbacks.get(i);
        }
      }
      return null;
    }
    
    public List<MediaBrowserCompat.SubscriptionCallback> getCallbacks()
    {
      return this.mCallbacks;
    }
    
    public List<Bundle> getOptionsList()
    {
      return this.mOptionsList;
    }
    
    public boolean isEmpty()
    {
      return this.mCallbacks.isEmpty();
    }
    
    public void putCallback(Bundle paramBundle, MediaBrowserCompat.SubscriptionCallback paramSubscriptionCallback)
    {
      for (int i = 0; i < this.mOptionsList.size(); i++) {
        if (MediaBrowserCompatUtils.areSameOptions((Bundle)this.mOptionsList.get(i), paramBundle))
        {
          this.mCallbacks.set(i, paramSubscriptionCallback);
          return;
        }
      }
      this.mCallbacks.add(paramSubscriptionCallback);
      this.mOptionsList.add(paramBundle);
    }
  }
  
  public static abstract class SubscriptionCallback
  {
    final MediaBrowser.SubscriptionCallback mSubscriptionCallbackFwk;
    WeakReference<MediaBrowserCompat.Subscription> mSubscriptionRef;
    final IBinder mToken = new Binder();
    
    public SubscriptionCallback()
    {
      int i = Build.VERSION.SDK_INT;
      if (i >= 26) {
        this.mSubscriptionCallbackFwk = new SubscriptionCallbackApi26();
      } else if (i >= 21) {
        this.mSubscriptionCallbackFwk = new SubscriptionCallbackApi21();
      } else {
        this.mSubscriptionCallbackFwk = null;
      }
    }
    
    public void onChildrenLoaded(@NonNull String paramString, @NonNull List<MediaBrowserCompat.MediaItem> paramList) {}
    
    public void onChildrenLoaded(@NonNull String paramString, @NonNull List<MediaBrowserCompat.MediaItem> paramList, @NonNull Bundle paramBundle) {}
    
    public void onError(@NonNull String paramString) {}
    
    public void onError(@NonNull String paramString, @NonNull Bundle paramBundle) {}
    
    void setSubscription(MediaBrowserCompat.Subscription paramSubscription)
    {
      this.mSubscriptionRef = new WeakReference(paramSubscription);
    }
    
    @RequiresApi(21)
    private class SubscriptionCallbackApi21
      extends MediaBrowser.SubscriptionCallback
    {
      SubscriptionCallbackApi21() {}
      
      List<MediaBrowserCompat.MediaItem> applyOptions(List<MediaBrowserCompat.MediaItem> paramList, Bundle paramBundle)
      {
        if (paramList == null) {
          return null;
        }
        int i = paramBundle.getInt("android.media.browse.extra.PAGE", -1);
        int j = paramBundle.getInt("android.media.browse.extra.PAGE_SIZE", -1);
        if ((i == -1) && (j == -1)) {
          return paramList;
        }
        int k = j * i;
        int m = k + j;
        if ((i >= 0) && (j >= 1) && (k < paramList.size()))
        {
          i = m;
          if (m > paramList.size()) {
            i = paramList.size();
          }
          return paramList.subList(k, i);
        }
        return Collections.emptyList();
      }
      
      public void onChildrenLoaded(@NonNull String paramString, List<MediaBrowser.MediaItem> paramList)
      {
        Object localObject = MediaBrowserCompat.SubscriptionCallback.this.mSubscriptionRef;
        if (localObject == null) {
          localObject = null;
        } else {
          localObject = (MediaBrowserCompat.Subscription)((WeakReference)localObject).get();
        }
        if (localObject == null)
        {
          MediaBrowserCompat.SubscriptionCallback.this.onChildrenLoaded(paramString, MediaBrowserCompat.MediaItem.fromMediaItemList(paramList));
        }
        else
        {
          List localList = MediaBrowserCompat.MediaItem.fromMediaItemList(paramList);
          paramList = ((MediaBrowserCompat.Subscription)localObject).getCallbacks();
          localObject = ((MediaBrowserCompat.Subscription)localObject).getOptionsList();
          for (int i = 0; i < paramList.size(); i++)
          {
            Bundle localBundle = (Bundle)((List)localObject).get(i);
            if (localBundle == null) {
              MediaBrowserCompat.SubscriptionCallback.this.onChildrenLoaded(paramString, localList);
            } else {
              MediaBrowserCompat.SubscriptionCallback.this.onChildrenLoaded(paramString, applyOptions(localList, localBundle), localBundle);
            }
          }
        }
      }
      
      public void onError(@NonNull String paramString)
      {
        MediaBrowserCompat.SubscriptionCallback.this.onError(paramString);
      }
    }
    
    @RequiresApi(26)
    private class SubscriptionCallbackApi26
      extends MediaBrowserCompat.SubscriptionCallback.SubscriptionCallbackApi21
    {
      SubscriptionCallbackApi26()
      {
        super();
      }
      
      public void onChildrenLoaded(@NonNull String paramString, @NonNull List<MediaBrowser.MediaItem> paramList, @NonNull Bundle paramBundle)
      {
        MediaSessionCompat.ensureClassLoader(paramBundle);
        MediaBrowserCompat.SubscriptionCallback.this.onChildrenLoaded(paramString, MediaBrowserCompat.MediaItem.fromMediaItemList(paramList), paramBundle);
      }
      
      public void onError(@NonNull String paramString, @NonNull Bundle paramBundle)
      {
        MediaSessionCompat.ensureClassLoader(paramBundle);
        MediaBrowserCompat.SubscriptionCallback.this.onError(paramString, paramBundle);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\android\support\v4\media\MediaBrowserCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */