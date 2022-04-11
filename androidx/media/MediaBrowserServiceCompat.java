package androidx.media;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.browse.MediaBrowser.MediaItem;
import android.media.session.MediaSession.Token;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.service.media.MediaBrowserService;
import android.service.media.MediaBrowserService.BrowserRoot;
import android.service.media.MediaBrowserService.Result;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaBrowserCompat.MediaItem;
import android.support.v4.media.session.IMediaSession;
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
import androidx.core.util.Pair;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public abstract class MediaBrowserServiceCompat
  extends Service
{
  static final boolean DEBUG = Log.isLoggable("MBServiceCompat", 3);
  private static final float EPSILON = 1.0E-5F;
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public static final String KEY_MEDIA_ITEM = "media_item";
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public static final String KEY_SEARCH_RESULTS = "search_results";
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public static final int RESULT_ERROR = -1;
  static final int RESULT_FLAG_ON_LOAD_ITEM_NOT_IMPLEMENTED = 2;
  static final int RESULT_FLAG_ON_SEARCH_NOT_IMPLEMENTED = 4;
  static final int RESULT_FLAG_OPTION_NOT_HANDLED = 1;
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public static final int RESULT_OK = 0;
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public static final int RESULT_PROGRESS_UPDATE = 1;
  public static final String SERVICE_INTERFACE = "android.media.browse.MediaBrowserService";
  static final String TAG = "MBServiceCompat";
  final ConnectionRecord mConnectionFromFwk = new ConnectionRecord("android.media.session.MediaController", -1, -1, null, null);
  final ArrayMap<IBinder, ConnectionRecord> mConnections = new ArrayMap();
  ConnectionRecord mCurConnection;
  final ServiceHandler mHandler = new ServiceHandler();
  private MediaBrowserServiceImpl mImpl;
  final ArrayList<ConnectionRecord> mPendingConnections = new ArrayList();
  MediaSessionCompat.Token mSession;
  
  void addSubscription(String paramString, ConnectionRecord paramConnectionRecord, IBinder paramIBinder, Bundle paramBundle)
  {
    Object localObject1 = (List)paramConnectionRecord.subscriptions.get(paramString);
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new ArrayList();
    }
    localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Pair localPair = (Pair)((Iterator)localObject1).next();
      if ((paramIBinder == localPair.first) && (MediaBrowserCompatUtils.areSameOptions(paramBundle, (Bundle)localPair.second))) {
        return;
      }
    }
    ((List)localObject2).add(new Pair(paramIBinder, paramBundle));
    paramConnectionRecord.subscriptions.put(paramString, localObject2);
    performLoadChildren(paramString, paramConnectionRecord, paramBundle, null);
    this.mCurConnection = paramConnectionRecord;
    onSubscribe(paramString, paramBundle);
    this.mCurConnection = null;
  }
  
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
      j = m;
      if (m > paramList.size()) {
        j = paramList.size();
      }
      return paramList.subList(k, j);
    }
    return Collections.emptyList();
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void attachToBaseContext(Context paramContext)
  {
    attachBaseContext(paramContext);
  }
  
  public void dump(FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {}
  
  public final Bundle getBrowserRootHints()
  {
    return this.mImpl.getBrowserRootHints();
  }
  
  @NonNull
  public final MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo()
  {
    return this.mImpl.getCurrentBrowserInfo();
  }
  
  @Nullable
  public MediaSessionCompat.Token getSessionToken()
  {
    return this.mSession;
  }
  
  boolean isValidPackage(String paramString, int paramInt)
  {
    if (paramString == null) {
      return false;
    }
    String[] arrayOfString = getPackageManager().getPackagesForUid(paramInt);
    int i = arrayOfString.length;
    for (paramInt = 0; paramInt < i; paramInt++) {
      if (arrayOfString[paramInt].equals(paramString)) {
        return true;
      }
    }
    return false;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void notifyChildrenChanged(@NonNull MediaSessionManager.RemoteUserInfo paramRemoteUserInfo, @NonNull String paramString, @NonNull Bundle paramBundle)
  {
    if (paramRemoteUserInfo != null)
    {
      if (paramString != null)
      {
        if (paramBundle != null)
        {
          this.mImpl.notifyChildrenChanged(paramRemoteUserInfo, paramString, paramBundle);
          return;
        }
        throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
      }
      throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
    }
    throw new IllegalArgumentException("remoteUserInfo cannot be null in notifyChildrenChanged");
  }
  
  public void notifyChildrenChanged(@NonNull String paramString)
  {
    if (paramString != null)
    {
      this.mImpl.notifyChildrenChanged(paramString, null);
      return;
    }
    throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
  }
  
  public void notifyChildrenChanged(@NonNull String paramString, @NonNull Bundle paramBundle)
  {
    if (paramString != null)
    {
      if (paramBundle != null)
      {
        this.mImpl.notifyChildrenChanged(paramString, paramBundle);
        return;
      }
      throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
    }
    throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.mImpl.onBind(paramIntent);
  }
  
  public void onCreate()
  {
    super.onCreate();
    int i = Build.VERSION.SDK_INT;
    if (i >= 28) {
      this.mImpl = new MediaBrowserServiceImplApi28();
    } else if (i >= 26) {
      this.mImpl = new MediaBrowserServiceImplApi26();
    } else if (i >= 23) {
      this.mImpl = new MediaBrowserServiceImplApi23();
    } else if (i >= 21) {
      this.mImpl = new MediaBrowserServiceImplApi21();
    } else {
      this.mImpl = new MediaBrowserServiceImplBase();
    }
    this.mImpl.onCreate();
  }
  
  public void onCustomAction(@NonNull String paramString, Bundle paramBundle, @NonNull Result<Bundle> paramResult)
  {
    paramResult.sendError(null);
  }
  
  @Nullable
  public abstract BrowserRoot onGetRoot(@NonNull String paramString, int paramInt, @Nullable Bundle paramBundle);
  
  public abstract void onLoadChildren(@NonNull String paramString, @NonNull Result<List<MediaBrowserCompat.MediaItem>> paramResult);
  
  public void onLoadChildren(@NonNull String paramString, @NonNull Result<List<MediaBrowserCompat.MediaItem>> paramResult, @NonNull Bundle paramBundle)
  {
    paramResult.setFlags(1);
    onLoadChildren(paramString, paramResult);
  }
  
  public void onLoadItem(String paramString, @NonNull Result<MediaBrowserCompat.MediaItem> paramResult)
  {
    paramResult.setFlags(2);
    paramResult.sendResult(null);
  }
  
  public void onSearch(@NonNull String paramString, Bundle paramBundle, @NonNull Result<List<MediaBrowserCompat.MediaItem>> paramResult)
  {
    paramResult.setFlags(4);
    paramResult.sendResult(null);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public void onSubscribe(String paramString, Bundle paramBundle) {}
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public void onUnsubscribe(String paramString) {}
  
  void performCustomAction(String paramString, Bundle paramBundle, ConnectionRecord paramConnectionRecord, final ResultReceiver paramResultReceiver)
  {
    paramResultReceiver = new Result(paramString)
    {
      void onErrorSent(Bundle paramAnonymousBundle)
      {
        paramResultReceiver.send(-1, paramAnonymousBundle);
      }
      
      void onProgressUpdateSent(Bundle paramAnonymousBundle)
      {
        paramResultReceiver.send(1, paramAnonymousBundle);
      }
      
      void onResultSent(Bundle paramAnonymousBundle)
      {
        paramResultReceiver.send(0, paramAnonymousBundle);
      }
    };
    this.mCurConnection = paramConnectionRecord;
    onCustomAction(paramString, paramBundle, paramResultReceiver);
    this.mCurConnection = null;
    if (paramResultReceiver.isDone()) {
      return;
    }
    paramConnectionRecord = new StringBuilder();
    paramConnectionRecord.append("onCustomAction must call detach() or sendResult() or sendError() before returning for action=");
    paramConnectionRecord.append(paramString);
    paramConnectionRecord.append(" extras=");
    paramConnectionRecord.append(paramBundle);
    throw new IllegalStateException(paramConnectionRecord.toString());
  }
  
  void performLoadChildren(final String paramString, final ConnectionRecord paramConnectionRecord, final Bundle paramBundle1, final Bundle paramBundle2)
  {
    paramBundle2 = new Result(paramString)
    {
      void onResultSent(List<MediaBrowserCompat.MediaItem> paramAnonymousList)
      {
        if (MediaBrowserServiceCompat.this.mConnections.get(paramConnectionRecord.callbacks.asBinder()) != paramConnectionRecord)
        {
          if (MediaBrowserServiceCompat.DEBUG)
          {
            paramAnonymousList = new StringBuilder();
            paramAnonymousList.append("Not sending onLoadChildren result for connection that has been disconnected. pkg=");
            paramAnonymousList.append(paramConnectionRecord.pkg);
            paramAnonymousList.append(" id=");
            paramAnonymousList.append(paramString);
            Log.d("MBServiceCompat", paramAnonymousList.toString());
          }
          return;
        }
        Object localObject = paramAnonymousList;
        if ((getFlags() & 0x1) != 0) {
          localObject = MediaBrowserServiceCompat.this.applyOptions(paramAnonymousList, paramBundle1);
        }
        try
        {
          paramConnectionRecord.callbacks.onLoadChildren(paramString, (List)localObject, paramBundle1, paramBundle2);
        }
        catch (RemoteException paramAnonymousList)
        {
          paramAnonymousList = new StringBuilder();
          paramAnonymousList.append("Calling onLoadChildren() failed for id=");
          paramAnonymousList.append(paramString);
          paramAnonymousList.append(" package=");
          paramAnonymousList.append(paramConnectionRecord.pkg);
          Log.w("MBServiceCompat", paramAnonymousList.toString());
        }
      }
    };
    this.mCurConnection = paramConnectionRecord;
    if (paramBundle1 == null) {
      onLoadChildren(paramString, paramBundle2);
    } else {
      onLoadChildren(paramString, paramBundle2, paramBundle1);
    }
    this.mCurConnection = null;
    if (paramBundle2.isDone()) {
      return;
    }
    paramBundle1 = new StringBuilder();
    paramBundle1.append("onLoadChildren must call detach() or sendResult() before returning for package=");
    paramBundle1.append(paramConnectionRecord.pkg);
    paramBundle1.append(" id=");
    paramBundle1.append(paramString);
    throw new IllegalStateException(paramBundle1.toString());
  }
  
  void performLoadItem(String paramString, ConnectionRecord paramConnectionRecord, final ResultReceiver paramResultReceiver)
  {
    paramResultReceiver = new Result(paramString)
    {
      void onResultSent(MediaBrowserCompat.MediaItem paramAnonymousMediaItem)
      {
        if ((getFlags() & 0x2) != 0)
        {
          paramResultReceiver.send(-1, null);
          return;
        }
        Bundle localBundle = new Bundle();
        localBundle.putParcelable("media_item", paramAnonymousMediaItem);
        paramResultReceiver.send(0, localBundle);
      }
    };
    this.mCurConnection = paramConnectionRecord;
    onLoadItem(paramString, paramResultReceiver);
    this.mCurConnection = null;
    if (paramResultReceiver.isDone()) {
      return;
    }
    paramConnectionRecord = new StringBuilder();
    paramConnectionRecord.append("onLoadItem must call detach() or sendResult() before returning for id=");
    paramConnectionRecord.append(paramString);
    throw new IllegalStateException(paramConnectionRecord.toString());
  }
  
  void performSearch(String paramString, Bundle paramBundle, ConnectionRecord paramConnectionRecord, final ResultReceiver paramResultReceiver)
  {
    paramResultReceiver = new Result(paramString)
    {
      void onResultSent(List<MediaBrowserCompat.MediaItem> paramAnonymousList)
      {
        if (((getFlags() & 0x4) == 0) && (paramAnonymousList != null))
        {
          Bundle localBundle = new Bundle();
          localBundle.putParcelableArray("search_results", (Parcelable[])paramAnonymousList.toArray(new MediaBrowserCompat.MediaItem[0]));
          paramResultReceiver.send(0, localBundle);
          return;
        }
        paramResultReceiver.send(-1, null);
      }
    };
    this.mCurConnection = paramConnectionRecord;
    onSearch(paramString, paramBundle, paramResultReceiver);
    this.mCurConnection = null;
    if (paramResultReceiver.isDone()) {
      return;
    }
    paramBundle = new StringBuilder();
    paramBundle.append("onSearch must call detach() or sendResult() before returning for query=");
    paramBundle.append(paramString);
    throw new IllegalStateException(paramBundle.toString());
  }
  
  boolean removeSubscription(String paramString, ConnectionRecord paramConnectionRecord, IBinder paramIBinder)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    boolean bool3 = false;
    if (paramIBinder == null) {}
    try
    {
      paramIBinder = paramConnectionRecord.subscriptions.remove(paramString);
      if (paramIBinder != null) {
        bool3 = bool1;
      } else {
        bool3 = false;
      }
      return bool3;
    }
    finally
    {
      List localList;
      Iterator localIterator;
      this.mCurConnection = paramConnectionRecord;
      onUnsubscribe(paramString);
      this.mCurConnection = null;
    }
    localList = (List)paramConnectionRecord.subscriptions.get(paramString);
    bool1 = bool2;
    if (localList != null)
    {
      localIterator = localList.iterator();
      while (localIterator.hasNext()) {
        if (paramIBinder == ((Pair)localIterator.next()).first)
        {
          localIterator.remove();
          bool3 = true;
        }
      }
      bool1 = bool3;
      if (localList.size() == 0)
      {
        paramConnectionRecord.subscriptions.remove(paramString);
        bool1 = bool3;
      }
    }
    this.mCurConnection = paramConnectionRecord;
    onUnsubscribe(paramString);
    this.mCurConnection = null;
    return bool1;
  }
  
  public void setSessionToken(MediaSessionCompat.Token paramToken)
  {
    if (paramToken != null)
    {
      if (this.mSession == null)
      {
        this.mSession = paramToken;
        this.mImpl.setSessionToken(paramToken);
        return;
      }
      throw new IllegalStateException("The session token has already been set");
    }
    throw new IllegalArgumentException("Session token may not be null");
  }
  
  public static final class BrowserRoot
  {
    public static final String EXTRA_OFFLINE = "android.service.media.extra.OFFLINE";
    public static final String EXTRA_RECENT = "android.service.media.extra.RECENT";
    public static final String EXTRA_SUGGESTED = "android.service.media.extra.SUGGESTED";
    @Deprecated
    public static final String EXTRA_SUGGESTION_KEYWORDS = "android.service.media.extra.SUGGESTION_KEYWORDS";
    private final Bundle mExtras;
    private final String mRootId;
    
    public BrowserRoot(@NonNull String paramString, @Nullable Bundle paramBundle)
    {
      if (paramString != null)
      {
        this.mRootId = paramString;
        this.mExtras = paramBundle;
        return;
      }
      throw new IllegalArgumentException("The root id in BrowserRoot cannot be null. Use null for BrowserRoot instead");
    }
    
    public Bundle getExtras()
    {
      return this.mExtras;
    }
    
    public String getRootId()
    {
      return this.mRootId;
    }
  }
  
  private class ConnectionRecord
    implements IBinder.DeathRecipient
  {
    public final MediaSessionManager.RemoteUserInfo browserInfo;
    public final MediaBrowserServiceCompat.ServiceCallbacks callbacks;
    public final int pid;
    public final String pkg;
    public MediaBrowserServiceCompat.BrowserRoot root;
    public final Bundle rootHints;
    public final HashMap<String, List<Pair<IBinder, Bundle>>> subscriptions = new HashMap();
    public final int uid;
    
    ConnectionRecord(String paramString, int paramInt1, int paramInt2, Bundle paramBundle, MediaBrowserServiceCompat.ServiceCallbacks paramServiceCallbacks)
    {
      this.pkg = paramString;
      this.pid = paramInt1;
      this.uid = paramInt2;
      this.browserInfo = new MediaSessionManager.RemoteUserInfo(paramString, paramInt1, paramInt2);
      this.rootHints = paramBundle;
      this.callbacks = paramServiceCallbacks;
    }
    
    public void binderDied()
    {
      MediaBrowserServiceCompat.this.mHandler.post(new Runnable()
      {
        public void run()
        {
          MediaBrowserServiceCompat.ConnectionRecord localConnectionRecord = MediaBrowserServiceCompat.ConnectionRecord.this;
          localConnectionRecord.this$0.mConnections.remove(localConnectionRecord.callbacks.asBinder());
        }
      });
    }
  }
  
  static abstract interface MediaBrowserServiceImpl
  {
    public abstract Bundle getBrowserRootHints();
    
    public abstract MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo();
    
    public abstract void notifyChildrenChanged(MediaSessionManager.RemoteUserInfo paramRemoteUserInfo, String paramString, Bundle paramBundle);
    
    public abstract void notifyChildrenChanged(String paramString, Bundle paramBundle);
    
    public abstract IBinder onBind(Intent paramIntent);
    
    public abstract void onCreate();
    
    public abstract void setSessionToken(MediaSessionCompat.Token paramToken);
  }
  
  @RequiresApi(21)
  class MediaBrowserServiceImplApi21
    implements MediaBrowserServiceCompat.MediaBrowserServiceImpl
  {
    Messenger mMessenger;
    final List<Bundle> mRootExtrasList = new ArrayList();
    MediaBrowserService mServiceFwk;
    
    MediaBrowserServiceImplApi21() {}
    
    public Bundle getBrowserRootHints()
    {
      Object localObject = this.mMessenger;
      Bundle localBundle = null;
      if (localObject == null) {
        return null;
      }
      localObject = MediaBrowserServiceCompat.this.mCurConnection;
      if (localObject != null)
      {
        if (((MediaBrowserServiceCompat.ConnectionRecord)localObject).rootHints != null) {
          localBundle = new Bundle(MediaBrowserServiceCompat.this.mCurConnection.rootHints);
        }
        return localBundle;
      }
      throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
    }
    
    public MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo()
    {
      MediaBrowserServiceCompat.ConnectionRecord localConnectionRecord = MediaBrowserServiceCompat.this.mCurConnection;
      if (localConnectionRecord != null) {
        return localConnectionRecord.browserInfo;
      }
      throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
    }
    
    public void notifyChildrenChanged(MediaSessionManager.RemoteUserInfo paramRemoteUserInfo, String paramString, Bundle paramBundle)
    {
      notifyChildrenChangedForCompat(paramRemoteUserInfo, paramString, paramBundle);
    }
    
    public void notifyChildrenChanged(String paramString, Bundle paramBundle)
    {
      notifyChildrenChangedForFramework(paramString, paramBundle);
      notifyChildrenChangedForCompat(paramString, paramBundle);
    }
    
    void notifyChildrenChangedForCompat(final MediaSessionManager.RemoteUserInfo paramRemoteUserInfo, final String paramString, final Bundle paramBundle)
    {
      MediaBrowserServiceCompat.this.mHandler.post(new Runnable()
      {
        public void run()
        {
          for (int i = 0; i < MediaBrowserServiceCompat.this.mConnections.size(); i++)
          {
            MediaBrowserServiceCompat.ConnectionRecord localConnectionRecord = (MediaBrowserServiceCompat.ConnectionRecord)MediaBrowserServiceCompat.this.mConnections.valueAt(i);
            if (localConnectionRecord.browserInfo.equals(paramRemoteUserInfo)) {
              MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.this.notifyChildrenChangedForCompatOnHandler(localConnectionRecord, paramString, paramBundle);
            }
          }
        }
      });
    }
    
    void notifyChildrenChangedForCompat(final String paramString, final Bundle paramBundle)
    {
      MediaBrowserServiceCompat.this.mHandler.post(new Runnable()
      {
        public void run()
        {
          Iterator localIterator = MediaBrowserServiceCompat.this.mConnections.keySet().iterator();
          while (localIterator.hasNext())
          {
            Object localObject = (IBinder)localIterator.next();
            localObject = (MediaBrowserServiceCompat.ConnectionRecord)MediaBrowserServiceCompat.this.mConnections.get(localObject);
            MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.this.notifyChildrenChangedForCompatOnHandler((MediaBrowserServiceCompat.ConnectionRecord)localObject, paramString, paramBundle);
          }
        }
      });
    }
    
    void notifyChildrenChangedForCompatOnHandler(MediaBrowserServiceCompat.ConnectionRecord paramConnectionRecord, String paramString, Bundle paramBundle)
    {
      Object localObject = (List)paramConnectionRecord.subscriptions.get(paramString);
      if (localObject != null)
      {
        Iterator localIterator = ((List)localObject).iterator();
        while (localIterator.hasNext())
        {
          localObject = (Pair)localIterator.next();
          if (MediaBrowserCompatUtils.hasDuplicatedItems(paramBundle, (Bundle)((Pair)localObject).second)) {
            MediaBrowserServiceCompat.this.performLoadChildren(paramString, paramConnectionRecord, (Bundle)((Pair)localObject).second, paramBundle);
          }
        }
      }
    }
    
    void notifyChildrenChangedForFramework(String paramString, Bundle paramBundle)
    {
      this.mServiceFwk.notifyChildrenChanged(paramString);
    }
    
    public IBinder onBind(Intent paramIntent)
    {
      return this.mServiceFwk.onBind(paramIntent);
    }
    
    public void onCreate()
    {
      MediaBrowserServiceApi21 localMediaBrowserServiceApi21 = new MediaBrowserServiceApi21(MediaBrowserServiceCompat.this);
      this.mServiceFwk = localMediaBrowserServiceApi21;
      localMediaBrowserServiceApi21.onCreate();
    }
    
    public MediaBrowserServiceCompat.BrowserRoot onGetRoot(String paramString, int paramInt, Bundle paramBundle)
    {
      Object localObject2;
      int i;
      if ((paramBundle != null) && (paramBundle.getInt("extra_client_version", 0) != 0))
      {
        paramBundle.remove("extra_client_version");
        this.mMessenger = new Messenger(MediaBrowserServiceCompat.this.mHandler);
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("extra_service_version", 2);
        BundleCompat.putBinder((Bundle)localObject1, "extra_messenger", this.mMessenger.getBinder());
        localObject2 = MediaBrowserServiceCompat.this.mSession;
        if (localObject2 != null)
        {
          localObject2 = ((MediaSessionCompat.Token)localObject2).getExtraBinder();
          if (localObject2 == null) {
            localObject2 = null;
          } else {
            localObject2 = ((IInterface)localObject2).asBinder();
          }
          BundleCompat.putBinder((Bundle)localObject1, "extra_session_binder", (IBinder)localObject2);
        }
        else
        {
          this.mRootExtrasList.add(localObject1);
        }
        i = paramBundle.getInt("extra_calling_pid", -1);
        paramBundle.remove("extra_calling_pid");
        localObject2 = localObject1;
      }
      else
      {
        localObject2 = null;
        i = -1;
      }
      Object localObject1 = new MediaBrowserServiceCompat.ConnectionRecord(MediaBrowserServiceCompat.this, paramString, i, paramInt, paramBundle, null);
      MediaBrowserServiceCompat localMediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
      localMediaBrowserServiceCompat.mCurConnection = ((MediaBrowserServiceCompat.ConnectionRecord)localObject1);
      paramBundle = localMediaBrowserServiceCompat.onGetRoot(paramString, paramInt, paramBundle);
      paramString = MediaBrowserServiceCompat.this;
      paramString.mCurConnection = null;
      if (paramBundle == null) {
        return null;
      }
      if (this.mMessenger != null) {
        paramString.mPendingConnections.add(localObject1);
      }
      if (localObject2 == null)
      {
        paramString = paramBundle.getExtras();
      }
      else
      {
        paramString = (String)localObject2;
        if (paramBundle.getExtras() != null)
        {
          ((Bundle)localObject2).putAll(paramBundle.getExtras());
          paramString = (String)localObject2;
        }
      }
      return new MediaBrowserServiceCompat.BrowserRoot(paramBundle.getRootId(), paramString);
    }
    
    public void onLoadChildren(String paramString, final MediaBrowserServiceCompat.ResultWrapper<List<Parcel>> paramResultWrapper)
    {
      MediaBrowserServiceCompat.Result local2 = new MediaBrowserServiceCompat.Result(paramString)
      {
        public void detach()
        {
          paramResultWrapper.detach();
        }
        
        void onResultSent(List<MediaBrowserCompat.MediaItem> paramAnonymousList)
        {
          if (paramAnonymousList != null)
          {
            ArrayList localArrayList = new ArrayList();
            Iterator localIterator = paramAnonymousList.iterator();
            for (;;)
            {
              paramAnonymousList = localArrayList;
              if (!localIterator.hasNext()) {
                break;
              }
              paramAnonymousList = (MediaBrowserCompat.MediaItem)localIterator.next();
              Parcel localParcel = Parcel.obtain();
              paramAnonymousList.writeToParcel(localParcel, 0);
              localArrayList.add(localParcel);
            }
          }
          paramAnonymousList = null;
          paramResultWrapper.sendResult(paramAnonymousList);
        }
      };
      paramResultWrapper = MediaBrowserServiceCompat.this;
      paramResultWrapper.mCurConnection = paramResultWrapper.mConnectionFromFwk;
      paramResultWrapper.onLoadChildren(paramString, local2);
      MediaBrowserServiceCompat.this.mCurConnection = null;
    }
    
    public void setSessionToken(final MediaSessionCompat.Token paramToken)
    {
      MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable()
      {
        public void run()
        {
          if (!MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.this.mRootExtrasList.isEmpty())
          {
            IMediaSession localIMediaSession = paramToken.getExtraBinder();
            if (localIMediaSession != null)
            {
              Iterator localIterator = MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.this.mRootExtrasList.iterator();
              while (localIterator.hasNext()) {
                BundleCompat.putBinder((Bundle)localIterator.next(), "extra_session_binder", localIMediaSession.asBinder());
              }
            }
            MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.this.mRootExtrasList.clear();
          }
          MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.this.mServiceFwk.setSessionToken((MediaSession.Token)paramToken.getToken());
        }
      });
    }
    
    class MediaBrowserServiceApi21
      extends MediaBrowserService
    {
      MediaBrowserServiceApi21(Context paramContext)
      {
        attachBaseContext(paramContext);
      }
      
      @SuppressLint({"SyntheticAccessor"})
      public MediaBrowserService.BrowserRoot onGetRoot(String paramString, int paramInt, Bundle paramBundle)
      {
        MediaSessionCompat.ensureClassLoader(paramBundle);
        MediaBrowserServiceCompat.MediaBrowserServiceImplApi21 localMediaBrowserServiceImplApi21 = MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.this;
        Object localObject = null;
        if (paramBundle == null) {
          paramBundle = null;
        } else {
          paramBundle = new Bundle(paramBundle);
        }
        paramString = localMediaBrowserServiceImplApi21.onGetRoot(paramString, paramInt, paramBundle);
        if (paramString == null) {
          paramString = (String)localObject;
        } else {
          paramString = new MediaBrowserService.BrowserRoot(paramString.mRootId, paramString.mExtras);
        }
        return paramString;
      }
      
      public void onLoadChildren(String paramString, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> paramResult)
      {
        MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.this.onLoadChildren(paramString, new MediaBrowserServiceCompat.ResultWrapper(paramResult));
      }
    }
  }
  
  @RequiresApi(23)
  class MediaBrowserServiceImplApi23
    extends MediaBrowserServiceCompat.MediaBrowserServiceImplApi21
  {
    MediaBrowserServiceImplApi23()
    {
      super();
    }
    
    public void onCreate()
    {
      MediaBrowserServiceApi23 localMediaBrowserServiceApi23 = new MediaBrowserServiceApi23(MediaBrowserServiceCompat.this);
      this.mServiceFwk = localMediaBrowserServiceApi23;
      localMediaBrowserServiceApi23.onCreate();
    }
    
    public void onLoadItem(String paramString, final MediaBrowserServiceCompat.ResultWrapper<Parcel> paramResultWrapper)
    {
      MediaBrowserServiceCompat.Result local1 = new MediaBrowserServiceCompat.Result(paramString)
      {
        public void detach()
        {
          paramResultWrapper.detach();
        }
        
        void onResultSent(MediaBrowserCompat.MediaItem paramAnonymousMediaItem)
        {
          if (paramAnonymousMediaItem == null)
          {
            paramResultWrapper.sendResult(null);
          }
          else
          {
            Parcel localParcel = Parcel.obtain();
            paramAnonymousMediaItem.writeToParcel(localParcel, 0);
            paramResultWrapper.sendResult(localParcel);
          }
        }
      };
      paramResultWrapper = MediaBrowserServiceCompat.this;
      paramResultWrapper.mCurConnection = paramResultWrapper.mConnectionFromFwk;
      paramResultWrapper.onLoadItem(paramString, local1);
      MediaBrowserServiceCompat.this.mCurConnection = null;
    }
    
    class MediaBrowserServiceApi23
      extends MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.MediaBrowserServiceApi21
    {
      MediaBrowserServiceApi23(Context paramContext)
      {
        super(paramContext);
      }
      
      public void onLoadItem(String paramString, MediaBrowserService.Result<MediaBrowser.MediaItem> paramResult)
      {
        MediaBrowserServiceCompat.MediaBrowserServiceImplApi23.this.onLoadItem(paramString, new MediaBrowserServiceCompat.ResultWrapper(paramResult));
      }
    }
  }
  
  @RequiresApi(26)
  class MediaBrowserServiceImplApi26
    extends MediaBrowserServiceCompat.MediaBrowserServiceImplApi23
  {
    MediaBrowserServiceImplApi26()
    {
      super();
    }
    
    public Bundle getBrowserRootHints()
    {
      Object localObject = MediaBrowserServiceCompat.this;
      MediaBrowserServiceCompat.ConnectionRecord localConnectionRecord = ((MediaBrowserServiceCompat)localObject).mCurConnection;
      if (localConnectionRecord != null)
      {
        if (localConnectionRecord == ((MediaBrowserServiceCompat)localObject).mConnectionFromFwk) {
          return this.mServiceFwk.getBrowserRootHints();
        }
        if (localConnectionRecord.rootHints == null) {
          localObject = null;
        } else {
          localObject = new Bundle(MediaBrowserServiceCompat.this.mCurConnection.rootHints);
        }
        return (Bundle)localObject;
      }
      throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
    }
    
    void notifyChildrenChangedForFramework(String paramString, Bundle paramBundle)
    {
      if (paramBundle != null) {
        this.mServiceFwk.notifyChildrenChanged(paramString, paramBundle);
      } else {
        super.notifyChildrenChangedForFramework(paramString, paramBundle);
      }
    }
    
    public void onCreate()
    {
      MediaBrowserServiceApi26 localMediaBrowserServiceApi26 = new MediaBrowserServiceApi26(MediaBrowserServiceCompat.this);
      this.mServiceFwk = localMediaBrowserServiceApi26;
      localMediaBrowserServiceApi26.onCreate();
    }
    
    public void onLoadChildren(String paramString, final MediaBrowserServiceCompat.ResultWrapper<List<Parcel>> paramResultWrapper, final Bundle paramBundle)
    {
      MediaBrowserServiceCompat.Result local1 = new MediaBrowserServiceCompat.Result(paramString)
      {
        public void detach()
        {
          paramResultWrapper.detach();
        }
        
        void onResultSent(List<MediaBrowserCompat.MediaItem> paramAnonymousList)
        {
          if (paramAnonymousList == null)
          {
            paramResultWrapper.sendResult(null);
            return;
          }
          Object localObject = paramAnonymousList;
          if ((getFlags() & 0x1) != 0) {
            localObject = MediaBrowserServiceCompat.this.applyOptions(paramAnonymousList, paramBundle);
          }
          paramAnonymousList = new ArrayList();
          Iterator localIterator = ((List)localObject).iterator();
          while (localIterator.hasNext())
          {
            MediaBrowserCompat.MediaItem localMediaItem = (MediaBrowserCompat.MediaItem)localIterator.next();
            localObject = Parcel.obtain();
            localMediaItem.writeToParcel((Parcel)localObject, 0);
            paramAnonymousList.add(localObject);
          }
          paramResultWrapper.sendResult(paramAnonymousList);
        }
      };
      paramResultWrapper = MediaBrowserServiceCompat.this;
      paramResultWrapper.mCurConnection = paramResultWrapper.mConnectionFromFwk;
      paramResultWrapper.onLoadChildren(paramString, local1, paramBundle);
      MediaBrowserServiceCompat.this.mCurConnection = null;
    }
    
    class MediaBrowserServiceApi26
      extends MediaBrowserServiceCompat.MediaBrowserServiceImplApi23.MediaBrowserServiceApi23
    {
      MediaBrowserServiceApi26(Context paramContext)
      {
        super(paramContext);
      }
      
      public void onLoadChildren(String paramString, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> paramResult, Bundle paramBundle)
      {
        MediaSessionCompat.ensureClassLoader(paramBundle);
        MediaBrowserServiceCompat.MediaBrowserServiceImplApi26 localMediaBrowserServiceImplApi26 = MediaBrowserServiceCompat.MediaBrowserServiceImplApi26.this;
        MediaBrowserServiceCompat localMediaBrowserServiceCompat = localMediaBrowserServiceImplApi26.this$0;
        localMediaBrowserServiceCompat.mCurConnection = localMediaBrowserServiceCompat.mConnectionFromFwk;
        localMediaBrowserServiceImplApi26.onLoadChildren(paramString, new MediaBrowserServiceCompat.ResultWrapper(paramResult), paramBundle);
        MediaBrowserServiceCompat.this.mCurConnection = null;
      }
    }
  }
  
  @RequiresApi(28)
  class MediaBrowserServiceImplApi28
    extends MediaBrowserServiceCompat.MediaBrowserServiceImplApi26
  {
    MediaBrowserServiceImplApi28()
    {
      super();
    }
    
    public MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo()
    {
      MediaBrowserServiceCompat localMediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
      MediaBrowserServiceCompat.ConnectionRecord localConnectionRecord = localMediaBrowserServiceCompat.mCurConnection;
      if (localConnectionRecord != null)
      {
        if (localConnectionRecord == localMediaBrowserServiceCompat.mConnectionFromFwk) {
          return new MediaSessionManager.RemoteUserInfo(this.mServiceFwk.getCurrentBrowserInfo());
        }
        return localConnectionRecord.browserInfo;
      }
      throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
    }
  }
  
  class MediaBrowserServiceImplBase
    implements MediaBrowserServiceCompat.MediaBrowserServiceImpl
  {
    private Messenger mMessenger;
    
    MediaBrowserServiceImplBase() {}
    
    public Bundle getBrowserRootHints()
    {
      Object localObject = MediaBrowserServiceCompat.this.mCurConnection;
      if (localObject != null)
      {
        if (((MediaBrowserServiceCompat.ConnectionRecord)localObject).rootHints == null) {
          localObject = null;
        } else {
          localObject = new Bundle(MediaBrowserServiceCompat.this.mCurConnection.rootHints);
        }
        return (Bundle)localObject;
      }
      throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
    }
    
    public MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo()
    {
      MediaBrowserServiceCompat.ConnectionRecord localConnectionRecord = MediaBrowserServiceCompat.this.mCurConnection;
      if (localConnectionRecord != null) {
        return localConnectionRecord.browserInfo;
      }
      throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
    }
    
    public void notifyChildrenChanged(@NonNull final MediaSessionManager.RemoteUserInfo paramRemoteUserInfo, @NonNull final String paramString, final Bundle paramBundle)
    {
      MediaBrowserServiceCompat.this.mHandler.post(new Runnable()
      {
        public void run()
        {
          for (int i = 0; i < MediaBrowserServiceCompat.this.mConnections.size(); i++)
          {
            MediaBrowserServiceCompat.ConnectionRecord localConnectionRecord = (MediaBrowserServiceCompat.ConnectionRecord)MediaBrowserServiceCompat.this.mConnections.valueAt(i);
            if (localConnectionRecord.browserInfo.equals(paramRemoteUserInfo))
            {
              MediaBrowserServiceCompat.MediaBrowserServiceImplBase.this.notifyChildrenChangedOnHandler(localConnectionRecord, paramString, paramBundle);
              break;
            }
          }
        }
      });
    }
    
    public void notifyChildrenChanged(@NonNull final String paramString, final Bundle paramBundle)
    {
      MediaBrowserServiceCompat.this.mHandler.post(new Runnable()
      {
        public void run()
        {
          Iterator localIterator = MediaBrowserServiceCompat.this.mConnections.keySet().iterator();
          while (localIterator.hasNext())
          {
            Object localObject = (IBinder)localIterator.next();
            localObject = (MediaBrowserServiceCompat.ConnectionRecord)MediaBrowserServiceCompat.this.mConnections.get(localObject);
            MediaBrowserServiceCompat.MediaBrowserServiceImplBase.this.notifyChildrenChangedOnHandler((MediaBrowserServiceCompat.ConnectionRecord)localObject, paramString, paramBundle);
          }
        }
      });
    }
    
    void notifyChildrenChangedOnHandler(MediaBrowserServiceCompat.ConnectionRecord paramConnectionRecord, String paramString, Bundle paramBundle)
    {
      Object localObject = (List)paramConnectionRecord.subscriptions.get(paramString);
      if (localObject != null)
      {
        Iterator localIterator = ((List)localObject).iterator();
        while (localIterator.hasNext())
        {
          localObject = (Pair)localIterator.next();
          if (MediaBrowserCompatUtils.hasDuplicatedItems(paramBundle, (Bundle)((Pair)localObject).second)) {
            MediaBrowserServiceCompat.this.performLoadChildren(paramString, paramConnectionRecord, (Bundle)((Pair)localObject).second, paramBundle);
          }
        }
      }
    }
    
    public IBinder onBind(Intent paramIntent)
    {
      if ("android.media.browse.MediaBrowserService".equals(paramIntent.getAction())) {
        return this.mMessenger.getBinder();
      }
      return null;
    }
    
    public void onCreate()
    {
      this.mMessenger = new Messenger(MediaBrowserServiceCompat.this.mHandler);
    }
    
    public void setSessionToken(final MediaSessionCompat.Token paramToken)
    {
      MediaBrowserServiceCompat.this.mHandler.post(new Runnable()
      {
        public void run()
        {
          Iterator localIterator = MediaBrowserServiceCompat.this.mConnections.values().iterator();
          while (localIterator.hasNext())
          {
            MediaBrowserServiceCompat.ConnectionRecord localConnectionRecord = (MediaBrowserServiceCompat.ConnectionRecord)localIterator.next();
            try
            {
              localConnectionRecord.callbacks.onConnect(localConnectionRecord.root.getRootId(), paramToken, localConnectionRecord.root.getExtras());
            }
            catch (RemoteException localRemoteException)
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("Connection for ");
              localStringBuilder.append(localConnectionRecord.pkg);
              localStringBuilder.append(" is no longer valid.");
              Log.w("MBServiceCompat", localStringBuilder.toString());
              localIterator.remove();
            }
          }
        }
      });
    }
  }
  
  public static class Result<T>
  {
    private final Object mDebug;
    private boolean mDetachCalled;
    private int mFlags;
    private boolean mSendErrorCalled;
    private boolean mSendResultCalled;
    
    Result(Object paramObject)
    {
      this.mDebug = paramObject;
    }
    
    private void checkExtraFields(Bundle paramBundle)
    {
      if (paramBundle == null) {
        return;
      }
      if (paramBundle.containsKey("android.media.browse.extra.DOWNLOAD_PROGRESS"))
      {
        float f = paramBundle.getFloat("android.media.browse.extra.DOWNLOAD_PROGRESS");
        if ((f < -1.0E-5F) || (f > 1.00001F)) {
          throw new IllegalArgumentException("The value of the EXTRA_DOWNLOAD_PROGRESS field must be a float number within [0.0, 1.0]");
        }
      }
    }
    
    public void detach()
    {
      if (!this.mDetachCalled)
      {
        if (!this.mSendResultCalled)
        {
          if (!this.mSendErrorCalled)
          {
            this.mDetachCalled = true;
            return;
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("detach() called when sendError() had already been called for: ");
          localStringBuilder.append(this.mDebug);
          throw new IllegalStateException(localStringBuilder.toString());
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("detach() called when sendResult() had already been called for: ");
        localStringBuilder.append(this.mDebug);
        throw new IllegalStateException(localStringBuilder.toString());
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("detach() called when detach() had already been called for: ");
      localStringBuilder.append(this.mDebug);
      throw new IllegalStateException(localStringBuilder.toString());
    }
    
    int getFlags()
    {
      return this.mFlags;
    }
    
    boolean isDone()
    {
      boolean bool;
      if ((!this.mDetachCalled) && (!this.mSendResultCalled) && (!this.mSendErrorCalled)) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    void onErrorSent(Bundle paramBundle)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("It is not supported to send an error for ");
      paramBundle.append(this.mDebug);
      throw new UnsupportedOperationException(paramBundle.toString());
    }
    
    void onProgressUpdateSent(Bundle paramBundle)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("It is not supported to send an interim update for ");
      paramBundle.append(this.mDebug);
      throw new UnsupportedOperationException(paramBundle.toString());
    }
    
    void onResultSent(T paramT) {}
    
    public void sendError(Bundle paramBundle)
    {
      if ((!this.mSendResultCalled) && (!this.mSendErrorCalled))
      {
        this.mSendErrorCalled = true;
        onErrorSent(paramBundle);
        return;
      }
      paramBundle = new StringBuilder();
      paramBundle.append("sendError() called when either sendResult() or sendError() had already been called for: ");
      paramBundle.append(this.mDebug);
      throw new IllegalStateException(paramBundle.toString());
    }
    
    public void sendProgressUpdate(Bundle paramBundle)
    {
      if ((!this.mSendResultCalled) && (!this.mSendErrorCalled))
      {
        checkExtraFields(paramBundle);
        onProgressUpdateSent(paramBundle);
        return;
      }
      paramBundle = new StringBuilder();
      paramBundle.append("sendProgressUpdate() called when either sendResult() or sendError() had already been called for: ");
      paramBundle.append(this.mDebug);
      throw new IllegalStateException(paramBundle.toString());
    }
    
    public void sendResult(T paramT)
    {
      if ((!this.mSendResultCalled) && (!this.mSendErrorCalled))
      {
        this.mSendResultCalled = true;
        onResultSent(paramT);
        return;
      }
      paramT = new StringBuilder();
      paramT.append("sendResult() called when either sendResult() or sendError() had already been called for: ");
      paramT.append(this.mDebug);
      throw new IllegalStateException(paramT.toString());
    }
    
    void setFlags(int paramInt)
    {
      this.mFlags = paramInt;
    }
  }
  
  @RequiresApi(21)
  static class ResultWrapper<T>
  {
    MediaBrowserService.Result mResultFwk;
    
    ResultWrapper(MediaBrowserService.Result paramResult)
    {
      this.mResultFwk = paramResult;
    }
    
    public void detach()
    {
      this.mResultFwk.detach();
    }
    
    List<MediaBrowser.MediaItem> parcelListToItemList(List<Parcel> paramList)
    {
      if (paramList == null) {
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        paramList = (Parcel)localIterator.next();
        paramList.setDataPosition(0);
        localArrayList.add((MediaBrowser.MediaItem)MediaBrowser.MediaItem.CREATOR.createFromParcel(paramList));
        paramList.recycle();
      }
      return localArrayList;
    }
    
    public void sendResult(T paramT)
    {
      if ((paramT instanceof List))
      {
        this.mResultFwk.sendResult(parcelListToItemList((List)paramT));
      }
      else if ((paramT instanceof Parcel))
      {
        paramT = (Parcel)paramT;
        paramT.setDataPosition(0);
        this.mResultFwk.sendResult(MediaBrowser.MediaItem.CREATOR.createFromParcel(paramT));
        paramT.recycle();
      }
      else
      {
        this.mResultFwk.sendResult(null);
      }
    }
  }
  
  private class ServiceBinderImpl
  {
    ServiceBinderImpl() {}
    
    public void addSubscription(final String paramString, final IBinder paramIBinder, final Bundle paramBundle, final MediaBrowserServiceCompat.ServiceCallbacks paramServiceCallbacks)
    {
      MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable()
      {
        public void run()
        {
          Object localObject = paramServiceCallbacks.asBinder();
          localObject = (MediaBrowserServiceCompat.ConnectionRecord)MediaBrowserServiceCompat.this.mConnections.get(localObject);
          if (localObject == null)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("addSubscription for callback that isn't registered id=");
            ((StringBuilder)localObject).append(paramString);
            Log.w("MBServiceCompat", ((StringBuilder)localObject).toString());
            return;
          }
          MediaBrowserServiceCompat.this.addSubscription(paramString, (MediaBrowserServiceCompat.ConnectionRecord)localObject, paramIBinder, paramBundle);
        }
      });
    }
    
    public void connect(final String paramString, final int paramInt1, final int paramInt2, final Bundle paramBundle, final MediaBrowserServiceCompat.ServiceCallbacks paramServiceCallbacks)
    {
      if (MediaBrowserServiceCompat.this.isValidPackage(paramString, paramInt2))
      {
        MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable()
        {
          public void run()
          {
            Object localObject1 = paramServiceCallbacks.asBinder();
            MediaBrowserServiceCompat.this.mConnections.remove(localObject1);
            MediaBrowserServiceCompat.ConnectionRecord localConnectionRecord = new MediaBrowserServiceCompat.ConnectionRecord(MediaBrowserServiceCompat.this, paramString, paramInt1, paramInt2, paramBundle, paramServiceCallbacks);
            Object localObject2 = MediaBrowserServiceCompat.this;
            ((MediaBrowserServiceCompat)localObject2).mCurConnection = localConnectionRecord;
            localObject2 = ((MediaBrowserServiceCompat)localObject2).onGetRoot(paramString, paramInt2, paramBundle);
            localConnectionRecord.root = ((MediaBrowserServiceCompat.BrowserRoot)localObject2);
            MediaBrowserServiceCompat localMediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
            localMediaBrowserServiceCompat.mCurConnection = null;
            StringBuilder localStringBuilder1;
            if (localObject2 == null)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("No root for client ");
              ((StringBuilder)localObject1).append(paramString);
              ((StringBuilder)localObject1).append(" from service ");
              ((StringBuilder)localObject1).append(getClass().getName());
              Log.i("MBServiceCompat", ((StringBuilder)localObject1).toString());
              try
              {
                paramServiceCallbacks.onConnectFailed();
              }
              catch (RemoteException localRemoteException1)
              {
                localStringBuilder1 = new StringBuilder();
                localStringBuilder1.append("Calling onConnectFailed() failed. Ignoring. pkg=");
                localStringBuilder1.append(paramString);
                Log.w("MBServiceCompat", localStringBuilder1.toString());
              }
            }
            else
            {
              try
              {
                localMediaBrowserServiceCompat.mConnections.put(localStringBuilder1, localConnectionRecord);
                localStringBuilder1.linkToDeath(localConnectionRecord, 0);
                if (MediaBrowserServiceCompat.this.mSession != null) {
                  paramServiceCallbacks.onConnect(localConnectionRecord.root.getRootId(), MediaBrowserServiceCompat.this.mSession, localConnectionRecord.root.getExtras());
                }
              }
              catch (RemoteException localRemoteException2)
              {
                StringBuilder localStringBuilder2 = new StringBuilder();
                localStringBuilder2.append("Calling onConnect() failed. Dropping client. pkg=");
                localStringBuilder2.append(paramString);
                Log.w("MBServiceCompat", localStringBuilder2.toString());
                MediaBrowserServiceCompat.this.mConnections.remove(localStringBuilder1);
              }
            }
          }
        });
        return;
      }
      paramBundle = new StringBuilder();
      paramBundle.append("Package/uid mismatch: uid=");
      paramBundle.append(paramInt2);
      paramBundle.append(" package=");
      paramBundle.append(paramString);
      throw new IllegalArgumentException(paramBundle.toString());
    }
    
    public void disconnect(final MediaBrowserServiceCompat.ServiceCallbacks paramServiceCallbacks)
    {
      MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable()
      {
        public void run()
        {
          Object localObject = paramServiceCallbacks.asBinder();
          localObject = (MediaBrowserServiceCompat.ConnectionRecord)MediaBrowserServiceCompat.this.mConnections.remove(localObject);
          if (localObject != null) {
            ((MediaBrowserServiceCompat.ConnectionRecord)localObject).callbacks.asBinder().unlinkToDeath((IBinder.DeathRecipient)localObject, 0);
          }
        }
      });
    }
    
    public void getMediaItem(final String paramString, final ResultReceiver paramResultReceiver, final MediaBrowserServiceCompat.ServiceCallbacks paramServiceCallbacks)
    {
      if ((!TextUtils.isEmpty(paramString)) && (paramResultReceiver != null)) {
        MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable()
        {
          public void run()
          {
            Object localObject = paramServiceCallbacks.asBinder();
            localObject = (MediaBrowserServiceCompat.ConnectionRecord)MediaBrowserServiceCompat.this.mConnections.get(localObject);
            if (localObject == null)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("getMediaItem for callback that isn't registered id=");
              ((StringBuilder)localObject).append(paramString);
              Log.w("MBServiceCompat", ((StringBuilder)localObject).toString());
              return;
            }
            MediaBrowserServiceCompat.this.performLoadItem(paramString, (MediaBrowserServiceCompat.ConnectionRecord)localObject, paramResultReceiver);
          }
        });
      }
    }
    
    public void registerCallbacks(final MediaBrowserServiceCompat.ServiceCallbacks paramServiceCallbacks, final String paramString, final int paramInt1, final int paramInt2, final Bundle paramBundle)
    {
      MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable()
      {
        public void run()
        {
          IBinder localIBinder = paramServiceCallbacks.asBinder();
          MediaBrowserServiceCompat.this.mConnections.remove(localIBinder);
          Iterator localIterator = MediaBrowserServiceCompat.this.mPendingConnections.iterator();
          Object localObject1;
          MediaBrowserServiceCompat.ConnectionRecord localConnectionRecord;
          do
          {
            boolean bool = localIterator.hasNext();
            localObject1 = null;
            localObject2 = null;
            if (!bool) {
              break;
            }
            localConnectionRecord = (MediaBrowserServiceCompat.ConnectionRecord)localIterator.next();
          } while (localConnectionRecord.uid != paramInt2);
          if (!TextUtils.isEmpty(paramString))
          {
            localObject1 = localObject2;
            if (paramInt1 > 0) {}
          }
          else
          {
            localObject1 = new MediaBrowserServiceCompat.ConnectionRecord(MediaBrowserServiceCompat.this, localConnectionRecord.pkg, localConnectionRecord.pid, localConnectionRecord.uid, paramBundle, paramServiceCallbacks);
          }
          localIterator.remove();
          Object localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new MediaBrowserServiceCompat.ConnectionRecord(MediaBrowserServiceCompat.this, paramString, paramInt1, paramInt2, paramBundle, paramServiceCallbacks);
          }
          MediaBrowserServiceCompat.this.mConnections.put(localIBinder, localObject2);
          try
          {
            localIBinder.linkToDeath((IBinder.DeathRecipient)localObject2, 0);
          }
          catch (RemoteException localRemoteException)
          {
            Log.w("MBServiceCompat", "IBinder is already dead.");
          }
        }
      });
    }
    
    public void removeSubscription(final String paramString, final IBinder paramIBinder, final MediaBrowserServiceCompat.ServiceCallbacks paramServiceCallbacks)
    {
      MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable()
      {
        public void run()
        {
          Object localObject = paramServiceCallbacks.asBinder();
          localObject = (MediaBrowserServiceCompat.ConnectionRecord)MediaBrowserServiceCompat.this.mConnections.get(localObject);
          if (localObject == null)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("removeSubscription for callback that isn't registered id=");
            ((StringBuilder)localObject).append(paramString);
            Log.w("MBServiceCompat", ((StringBuilder)localObject).toString());
            return;
          }
          if (!MediaBrowserServiceCompat.this.removeSubscription(paramString, (MediaBrowserServiceCompat.ConnectionRecord)localObject, paramIBinder))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("removeSubscription called for ");
            ((StringBuilder)localObject).append(paramString);
            ((StringBuilder)localObject).append(" which is not subscribed");
            Log.w("MBServiceCompat", ((StringBuilder)localObject).toString());
          }
        }
      });
    }
    
    public void search(final String paramString, final Bundle paramBundle, final ResultReceiver paramResultReceiver, final MediaBrowserServiceCompat.ServiceCallbacks paramServiceCallbacks)
    {
      if ((!TextUtils.isEmpty(paramString)) && (paramResultReceiver != null)) {
        MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable()
        {
          public void run()
          {
            Object localObject = paramServiceCallbacks.asBinder();
            localObject = (MediaBrowserServiceCompat.ConnectionRecord)MediaBrowserServiceCompat.this.mConnections.get(localObject);
            if (localObject == null)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("search for callback that isn't registered query=");
              ((StringBuilder)localObject).append(paramString);
              Log.w("MBServiceCompat", ((StringBuilder)localObject).toString());
              return;
            }
            MediaBrowserServiceCompat.this.performSearch(paramString, paramBundle, (MediaBrowserServiceCompat.ConnectionRecord)localObject, paramResultReceiver);
          }
        });
      }
    }
    
    public void sendCustomAction(final String paramString, final Bundle paramBundle, final ResultReceiver paramResultReceiver, final MediaBrowserServiceCompat.ServiceCallbacks paramServiceCallbacks)
    {
      if ((!TextUtils.isEmpty(paramString)) && (paramResultReceiver != null)) {
        MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable()
        {
          public void run()
          {
            Object localObject = paramServiceCallbacks.asBinder();
            localObject = (MediaBrowserServiceCompat.ConnectionRecord)MediaBrowserServiceCompat.this.mConnections.get(localObject);
            if (localObject == null)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("sendCustomAction for callback that isn't registered action=");
              ((StringBuilder)localObject).append(paramString);
              ((StringBuilder)localObject).append(", extras=");
              ((StringBuilder)localObject).append(paramBundle);
              Log.w("MBServiceCompat", ((StringBuilder)localObject).toString());
              return;
            }
            MediaBrowserServiceCompat.this.performCustomAction(paramString, paramBundle, (MediaBrowserServiceCompat.ConnectionRecord)localObject, paramResultReceiver);
          }
        });
      }
    }
    
    public void unregisterCallbacks(final MediaBrowserServiceCompat.ServiceCallbacks paramServiceCallbacks)
    {
      MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable()
      {
        public void run()
        {
          IBinder localIBinder = paramServiceCallbacks.asBinder();
          MediaBrowserServiceCompat.ConnectionRecord localConnectionRecord = (MediaBrowserServiceCompat.ConnectionRecord)MediaBrowserServiceCompat.this.mConnections.remove(localIBinder);
          if (localConnectionRecord != null) {
            localIBinder.unlinkToDeath(localConnectionRecord, 0);
          }
        }
      });
    }
  }
  
  private static abstract interface ServiceCallbacks
  {
    public abstract IBinder asBinder();
    
    public abstract void onConnect(String paramString, MediaSessionCompat.Token paramToken, Bundle paramBundle)
      throws RemoteException;
    
    public abstract void onConnectFailed()
      throws RemoteException;
    
    public abstract void onLoadChildren(String paramString, List<MediaBrowserCompat.MediaItem> paramList, Bundle paramBundle1, Bundle paramBundle2)
      throws RemoteException;
  }
  
  private static class ServiceCallbacksCompat
    implements MediaBrowserServiceCompat.ServiceCallbacks
  {
    final Messenger mCallbacks;
    
    ServiceCallbacksCompat(Messenger paramMessenger)
    {
      this.mCallbacks = paramMessenger;
    }
    
    private void sendRequest(int paramInt, Bundle paramBundle)
      throws RemoteException
    {
      Message localMessage = Message.obtain();
      localMessage.what = paramInt;
      localMessage.arg1 = 2;
      localMessage.setData(paramBundle);
      this.mCallbacks.send(localMessage);
    }
    
    public IBinder asBinder()
    {
      return this.mCallbacks.getBinder();
    }
    
    public void onConnect(String paramString, MediaSessionCompat.Token paramToken, Bundle paramBundle)
      throws RemoteException
    {
      Bundle localBundle = paramBundle;
      if (paramBundle == null) {
        localBundle = new Bundle();
      }
      localBundle.putInt("extra_service_version", 2);
      paramBundle = new Bundle();
      paramBundle.putString("data_media_item_id", paramString);
      paramBundle.putParcelable("data_media_session_token", paramToken);
      paramBundle.putBundle("data_root_hints", localBundle);
      sendRequest(1, paramBundle);
    }
    
    public void onConnectFailed()
      throws RemoteException
    {
      sendRequest(2, null);
    }
    
    public void onLoadChildren(String paramString, List<MediaBrowserCompat.MediaItem> paramList, Bundle paramBundle1, Bundle paramBundle2)
      throws RemoteException
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("data_media_item_id", paramString);
      localBundle.putBundle("data_options", paramBundle1);
      localBundle.putBundle("data_notify_children_changed_options", paramBundle2);
      if (paramList != null)
      {
        if ((paramList instanceof ArrayList)) {
          paramString = (ArrayList)paramList;
        } else {
          paramString = new ArrayList(paramList);
        }
        localBundle.putParcelableArrayList("data_media_item_list", paramString);
      }
      sendRequest(3, localBundle);
    }
  }
  
  private final class ServiceHandler
    extends Handler
  {
    private final MediaBrowserServiceCompat.ServiceBinderImpl mServiceBinderImpl = new MediaBrowserServiceCompat.ServiceBinderImpl(MediaBrowserServiceCompat.this);
    
    ServiceHandler() {}
    
    public void handleMessage(Message paramMessage)
    {
      Object localObject = paramMessage.getData();
      Bundle localBundle;
      switch (paramMessage.what)
      {
      default: 
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Unhandled message: ");
        ((StringBuilder)localObject).append(paramMessage);
        ((StringBuilder)localObject).append("\n  Service version: ");
        ((StringBuilder)localObject).append(2);
        ((StringBuilder)localObject).append("\n  Client version: ");
        ((StringBuilder)localObject).append(paramMessage.arg1);
        Log.w("MBServiceCompat", ((StringBuilder)localObject).toString());
        break;
      case 9: 
        localBundle = ((Bundle)localObject).getBundle("data_custom_action_extras");
        MediaSessionCompat.ensureClassLoader(localBundle);
        this.mServiceBinderImpl.sendCustomAction(((Bundle)localObject).getString("data_custom_action"), localBundle, (ResultReceiver)((Bundle)localObject).getParcelable("data_result_receiver"), new MediaBrowserServiceCompat.ServiceCallbacksCompat(paramMessage.replyTo));
        break;
      case 8: 
        localBundle = ((Bundle)localObject).getBundle("data_search_extras");
        MediaSessionCompat.ensureClassLoader(localBundle);
        this.mServiceBinderImpl.search(((Bundle)localObject).getString("data_search_query"), localBundle, (ResultReceiver)((Bundle)localObject).getParcelable("data_result_receiver"), new MediaBrowserServiceCompat.ServiceCallbacksCompat(paramMessage.replyTo));
        break;
      case 7: 
        this.mServiceBinderImpl.unregisterCallbacks(new MediaBrowserServiceCompat.ServiceCallbacksCompat(paramMessage.replyTo));
        break;
      case 6: 
        localBundle = ((Bundle)localObject).getBundle("data_root_hints");
        MediaSessionCompat.ensureClassLoader(localBundle);
        this.mServiceBinderImpl.registerCallbacks(new MediaBrowserServiceCompat.ServiceCallbacksCompat(paramMessage.replyTo), ((Bundle)localObject).getString("data_package_name"), ((Bundle)localObject).getInt("data_calling_pid"), ((Bundle)localObject).getInt("data_calling_uid"), localBundle);
        break;
      case 5: 
        this.mServiceBinderImpl.getMediaItem(((Bundle)localObject).getString("data_media_item_id"), (ResultReceiver)((Bundle)localObject).getParcelable("data_result_receiver"), new MediaBrowserServiceCompat.ServiceCallbacksCompat(paramMessage.replyTo));
        break;
      case 4: 
        this.mServiceBinderImpl.removeSubscription(((Bundle)localObject).getString("data_media_item_id"), BundleCompat.getBinder((Bundle)localObject, "data_callback_token"), new MediaBrowserServiceCompat.ServiceCallbacksCompat(paramMessage.replyTo));
        break;
      case 3: 
        localBundle = ((Bundle)localObject).getBundle("data_options");
        MediaSessionCompat.ensureClassLoader(localBundle);
        this.mServiceBinderImpl.addSubscription(((Bundle)localObject).getString("data_media_item_id"), BundleCompat.getBinder((Bundle)localObject, "data_callback_token"), localBundle, new MediaBrowserServiceCompat.ServiceCallbacksCompat(paramMessage.replyTo));
        break;
      case 2: 
        this.mServiceBinderImpl.disconnect(new MediaBrowserServiceCompat.ServiceCallbacksCompat(paramMessage.replyTo));
        break;
      case 1: 
        localBundle = ((Bundle)localObject).getBundle("data_root_hints");
        MediaSessionCompat.ensureClassLoader(localBundle);
        this.mServiceBinderImpl.connect(((Bundle)localObject).getString("data_package_name"), ((Bundle)localObject).getInt("data_calling_pid"), ((Bundle)localObject).getInt("data_calling_uid"), localBundle, new MediaBrowserServiceCompat.ServiceCallbacksCompat(paramMessage.replyTo));
      }
    }
    
    public void postOrRun(Runnable paramRunnable)
    {
      if (Thread.currentThread() == getLooper().getThread()) {
        paramRunnable.run();
      } else {
        post(paramRunnable);
      }
    }
    
    public boolean sendMessageAtTime(Message paramMessage, long paramLong)
    {
      Bundle localBundle = paramMessage.getData();
      localBundle.setClassLoader(MediaBrowserCompat.class.getClassLoader());
      localBundle.putInt("data_calling_uid", Binder.getCallingUid());
      int i = Binder.getCallingPid();
      if (i > 0) {
        localBundle.putInt("data_calling_pid", i);
      } else if (!localBundle.containsKey("data_calling_pid")) {
        localBundle.putInt("data_calling_pid", -1);
      }
      return super.sendMessageAtTime(paramMessage, paramLong);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\media\MediaBrowserServiceCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */