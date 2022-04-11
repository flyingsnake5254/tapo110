package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.media.session.PlaybackState;
import android.media.session.PlaybackState.Builder;
import android.media.session.PlaybackState.CustomAction;
import android.media.session.PlaybackState.CustomAction.Builder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SuppressLint({"BanParcelableUsage"})
public final class PlaybackStateCompat
  implements Parcelable
{
  public static final long ACTION_FAST_FORWARD = 64L;
  public static final long ACTION_PAUSE = 2L;
  public static final long ACTION_PLAY = 4L;
  public static final long ACTION_PLAY_FROM_MEDIA_ID = 1024L;
  public static final long ACTION_PLAY_FROM_SEARCH = 2048L;
  public static final long ACTION_PLAY_FROM_URI = 8192L;
  public static final long ACTION_PLAY_PAUSE = 512L;
  public static final long ACTION_PREPARE = 16384L;
  public static final long ACTION_PREPARE_FROM_MEDIA_ID = 32768L;
  public static final long ACTION_PREPARE_FROM_SEARCH = 65536L;
  public static final long ACTION_PREPARE_FROM_URI = 131072L;
  public static final long ACTION_REWIND = 8L;
  public static final long ACTION_SEEK_TO = 256L;
  public static final long ACTION_SET_CAPTIONING_ENABLED = 1048576L;
  public static final long ACTION_SET_PLAYBACK_SPEED = 4194304L;
  public static final long ACTION_SET_RATING = 128L;
  public static final long ACTION_SET_REPEAT_MODE = 262144L;
  public static final long ACTION_SET_SHUFFLE_MODE = 2097152L;
  @Deprecated
  public static final long ACTION_SET_SHUFFLE_MODE_ENABLED = 524288L;
  public static final long ACTION_SKIP_TO_NEXT = 32L;
  public static final long ACTION_SKIP_TO_PREVIOUS = 16L;
  public static final long ACTION_SKIP_TO_QUEUE_ITEM = 4096L;
  public static final long ACTION_STOP = 1L;
  public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new Parcelable.Creator()
  {
    public PlaybackStateCompat createFromParcel(Parcel paramAnonymousParcel)
    {
      return new PlaybackStateCompat(paramAnonymousParcel);
    }
    
    public PlaybackStateCompat[] newArray(int paramAnonymousInt)
    {
      return new PlaybackStateCompat[paramAnonymousInt];
    }
  };
  public static final int ERROR_CODE_ACTION_ABORTED = 10;
  public static final int ERROR_CODE_APP_ERROR = 1;
  public static final int ERROR_CODE_AUTHENTICATION_EXPIRED = 3;
  public static final int ERROR_CODE_CONCURRENT_STREAM_LIMIT = 5;
  public static final int ERROR_CODE_CONTENT_ALREADY_PLAYING = 8;
  public static final int ERROR_CODE_END_OF_QUEUE = 11;
  public static final int ERROR_CODE_NOT_AVAILABLE_IN_REGION = 7;
  public static final int ERROR_CODE_NOT_SUPPORTED = 2;
  public static final int ERROR_CODE_PARENTAL_CONTROL_RESTRICTED = 6;
  public static final int ERROR_CODE_PREMIUM_ACCOUNT_REQUIRED = 4;
  public static final int ERROR_CODE_SKIP_LIMIT_REACHED = 9;
  public static final int ERROR_CODE_UNKNOWN_ERROR = 0;
  private static final int KEYCODE_MEDIA_PAUSE = 127;
  private static final int KEYCODE_MEDIA_PLAY = 126;
  public static final long PLAYBACK_POSITION_UNKNOWN = -1L;
  public static final int REPEAT_MODE_ALL = 2;
  public static final int REPEAT_MODE_GROUP = 3;
  public static final int REPEAT_MODE_INVALID = -1;
  public static final int REPEAT_MODE_NONE = 0;
  public static final int REPEAT_MODE_ONE = 1;
  public static final int SHUFFLE_MODE_ALL = 1;
  public static final int SHUFFLE_MODE_GROUP = 2;
  public static final int SHUFFLE_MODE_INVALID = -1;
  public static final int SHUFFLE_MODE_NONE = 0;
  public static final int STATE_BUFFERING = 6;
  public static final int STATE_CONNECTING = 8;
  public static final int STATE_ERROR = 7;
  public static final int STATE_FAST_FORWARDING = 4;
  public static final int STATE_NONE = 0;
  public static final int STATE_PAUSED = 2;
  public static final int STATE_PLAYING = 3;
  public static final int STATE_REWINDING = 5;
  public static final int STATE_SKIPPING_TO_NEXT = 10;
  public static final int STATE_SKIPPING_TO_PREVIOUS = 9;
  public static final int STATE_SKIPPING_TO_QUEUE_ITEM = 11;
  public static final int STATE_STOPPED = 1;
  final long mActions;
  final long mActiveItemId;
  final long mBufferedPosition;
  List<CustomAction> mCustomActions;
  final int mErrorCode;
  final CharSequence mErrorMessage;
  final Bundle mExtras;
  final long mPosition;
  final float mSpeed;
  final int mState;
  private PlaybackState mStateFwk;
  final long mUpdateTime;
  
  PlaybackStateCompat(int paramInt1, long paramLong1, long paramLong2, float paramFloat, long paramLong3, int paramInt2, CharSequence paramCharSequence, long paramLong4, List<CustomAction> paramList, long paramLong5, Bundle paramBundle)
  {
    this.mState = paramInt1;
    this.mPosition = paramLong1;
    this.mBufferedPosition = paramLong2;
    this.mSpeed = paramFloat;
    this.mActions = paramLong3;
    this.mErrorCode = paramInt2;
    this.mErrorMessage = paramCharSequence;
    this.mUpdateTime = paramLong4;
    this.mCustomActions = new ArrayList(paramList);
    this.mActiveItemId = paramLong5;
    this.mExtras = paramBundle;
  }
  
  PlaybackStateCompat(Parcel paramParcel)
  {
    this.mState = paramParcel.readInt();
    this.mPosition = paramParcel.readLong();
    this.mSpeed = paramParcel.readFloat();
    this.mUpdateTime = paramParcel.readLong();
    this.mBufferedPosition = paramParcel.readLong();
    this.mActions = paramParcel.readLong();
    this.mErrorMessage = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.mCustomActions = paramParcel.createTypedArrayList(CustomAction.CREATOR);
    this.mActiveItemId = paramParcel.readLong();
    this.mExtras = paramParcel.readBundle(MediaSessionCompat.class.getClassLoader());
    this.mErrorCode = paramParcel.readInt();
  }
  
  public static PlaybackStateCompat fromPlaybackState(Object paramObject)
  {
    PlaybackState localPlaybackState = null;
    Object localObject1 = null;
    Object localObject2 = localPlaybackState;
    if (paramObject != null)
    {
      localObject2 = localPlaybackState;
      if (Build.VERSION.SDK_INT >= 21)
      {
        localPlaybackState = (PlaybackState)paramObject;
        localObject2 = localPlaybackState.getCustomActions();
        if (localObject2 != null)
        {
          paramObject = new ArrayList(((List)localObject2).size());
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((List)paramObject).add(CustomAction.fromCustomAction(((Iterator)localObject2).next()));
          }
        }
        else
        {
          paramObject = null;
        }
        localObject2 = localObject1;
        if (Build.VERSION.SDK_INT >= 22)
        {
          localObject2 = localPlaybackState.getExtras();
          MediaSessionCompat.ensureClassLoader((Bundle)localObject2);
        }
        localObject2 = new PlaybackStateCompat(localPlaybackState.getState(), localPlaybackState.getPosition(), localPlaybackState.getBufferedPosition(), localPlaybackState.getPlaybackSpeed(), localPlaybackState.getActions(), 0, localPlaybackState.getErrorMessage(), localPlaybackState.getLastPositionUpdateTime(), (List)paramObject, localPlaybackState.getActiveQueueItemId(), (Bundle)localObject2);
        ((PlaybackStateCompat)localObject2).mStateFwk = localPlaybackState;
      }
    }
    return (PlaybackStateCompat)localObject2;
  }
  
  public static int toKeyCode(long paramLong)
  {
    if (paramLong == 4L) {
      return 126;
    }
    if (paramLong == 2L) {
      return 127;
    }
    if (paramLong == 32L) {
      return 87;
    }
    if (paramLong == 16L) {
      return 88;
    }
    if (paramLong == 1L) {
      return 86;
    }
    if (paramLong == 64L) {
      return 90;
    }
    if (paramLong == 8L) {
      return 89;
    }
    if (paramLong == 512L) {
      return 85;
    }
    return 0;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public long getActions()
  {
    return this.mActions;
  }
  
  public long getActiveQueueItemId()
  {
    return this.mActiveItemId;
  }
  
  public long getBufferedPosition()
  {
    return this.mBufferedPosition;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public long getCurrentPosition(Long paramLong)
  {
    long l1 = this.mPosition;
    float f = this.mSpeed;
    long l2;
    if (paramLong != null) {
      l2 = paramLong.longValue();
    } else {
      l2 = SystemClock.elapsedRealtime() - this.mUpdateTime;
    }
    return Math.max(0L, l1 + (f * (float)l2));
  }
  
  public List<CustomAction> getCustomActions()
  {
    return this.mCustomActions;
  }
  
  public int getErrorCode()
  {
    return this.mErrorCode;
  }
  
  public CharSequence getErrorMessage()
  {
    return this.mErrorMessage;
  }
  
  @Nullable
  public Bundle getExtras()
  {
    return this.mExtras;
  }
  
  public long getLastPositionUpdateTime()
  {
    return this.mUpdateTime;
  }
  
  public float getPlaybackSpeed()
  {
    return this.mSpeed;
  }
  
  public Object getPlaybackState()
  {
    if ((this.mStateFwk == null) && (Build.VERSION.SDK_INT >= 21))
    {
      PlaybackState.Builder localBuilder = new PlaybackState.Builder();
      localBuilder.setState(this.mState, this.mPosition, this.mSpeed, this.mUpdateTime);
      localBuilder.setBufferedPosition(this.mBufferedPosition);
      localBuilder.setActions(this.mActions);
      localBuilder.setErrorMessage(this.mErrorMessage);
      Iterator localIterator = this.mCustomActions.iterator();
      while (localIterator.hasNext()) {
        localBuilder.addCustomAction((PlaybackState.CustomAction)((CustomAction)localIterator.next()).getCustomAction());
      }
      localBuilder.setActiveQueueItemId(this.mActiveItemId);
      if (Build.VERSION.SDK_INT >= 22) {
        localBuilder.setExtras(this.mExtras);
      }
      this.mStateFwk = localBuilder.build();
    }
    return this.mStateFwk;
  }
  
  public long getPosition()
  {
    return this.mPosition;
  }
  
  public int getState()
  {
    return this.mState;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("PlaybackState {");
    localStringBuilder.append("state=");
    localStringBuilder.append(this.mState);
    localStringBuilder.append(", position=");
    localStringBuilder.append(this.mPosition);
    localStringBuilder.append(", buffered position=");
    localStringBuilder.append(this.mBufferedPosition);
    localStringBuilder.append(", speed=");
    localStringBuilder.append(this.mSpeed);
    localStringBuilder.append(", updated=");
    localStringBuilder.append(this.mUpdateTime);
    localStringBuilder.append(", actions=");
    localStringBuilder.append(this.mActions);
    localStringBuilder.append(", error code=");
    localStringBuilder.append(this.mErrorCode);
    localStringBuilder.append(", error message=");
    localStringBuilder.append(this.mErrorMessage);
    localStringBuilder.append(", custom actions=");
    localStringBuilder.append(this.mCustomActions);
    localStringBuilder.append(", active item id=");
    localStringBuilder.append(this.mActiveItemId);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mState);
    paramParcel.writeLong(this.mPosition);
    paramParcel.writeFloat(this.mSpeed);
    paramParcel.writeLong(this.mUpdateTime);
    paramParcel.writeLong(this.mBufferedPosition);
    paramParcel.writeLong(this.mActions);
    TextUtils.writeToParcel(this.mErrorMessage, paramParcel, paramInt);
    paramParcel.writeTypedList(this.mCustomActions);
    paramParcel.writeLong(this.mActiveItemId);
    paramParcel.writeBundle(this.mExtras);
    paramParcel.writeInt(this.mErrorCode);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static @interface Actions {}
  
  public static final class Builder
  {
    private long mActions;
    private long mActiveItemId;
    private long mBufferedPosition;
    private final List<PlaybackStateCompat.CustomAction> mCustomActions;
    private int mErrorCode;
    private CharSequence mErrorMessage;
    private Bundle mExtras;
    private long mPosition;
    private float mRate;
    private int mState;
    private long mUpdateTime;
    
    public Builder()
    {
      this.mCustomActions = new ArrayList();
      this.mActiveItemId = -1L;
    }
    
    public Builder(PlaybackStateCompat paramPlaybackStateCompat)
    {
      ArrayList localArrayList = new ArrayList();
      this.mCustomActions = localArrayList;
      this.mActiveItemId = -1L;
      this.mState = paramPlaybackStateCompat.mState;
      this.mPosition = paramPlaybackStateCompat.mPosition;
      this.mRate = paramPlaybackStateCompat.mSpeed;
      this.mUpdateTime = paramPlaybackStateCompat.mUpdateTime;
      this.mBufferedPosition = paramPlaybackStateCompat.mBufferedPosition;
      this.mActions = paramPlaybackStateCompat.mActions;
      this.mErrorCode = paramPlaybackStateCompat.mErrorCode;
      this.mErrorMessage = paramPlaybackStateCompat.mErrorMessage;
      List localList = paramPlaybackStateCompat.mCustomActions;
      if (localList != null) {
        localArrayList.addAll(localList);
      }
      this.mActiveItemId = paramPlaybackStateCompat.mActiveItemId;
      this.mExtras = paramPlaybackStateCompat.mExtras;
    }
    
    public Builder addCustomAction(PlaybackStateCompat.CustomAction paramCustomAction)
    {
      if (paramCustomAction != null)
      {
        this.mCustomActions.add(paramCustomAction);
        return this;
      }
      throw new IllegalArgumentException("You may not add a null CustomAction to PlaybackStateCompat");
    }
    
    public Builder addCustomAction(String paramString1, String paramString2, int paramInt)
    {
      return addCustomAction(new PlaybackStateCompat.CustomAction(paramString1, paramString2, paramInt, null));
    }
    
    public PlaybackStateCompat build()
    {
      return new PlaybackStateCompat(this.mState, this.mPosition, this.mBufferedPosition, this.mRate, this.mActions, this.mErrorCode, this.mErrorMessage, this.mUpdateTime, this.mCustomActions, this.mActiveItemId, this.mExtras);
    }
    
    public Builder setActions(long paramLong)
    {
      this.mActions = paramLong;
      return this;
    }
    
    public Builder setActiveQueueItemId(long paramLong)
    {
      this.mActiveItemId = paramLong;
      return this;
    }
    
    public Builder setBufferedPosition(long paramLong)
    {
      this.mBufferedPosition = paramLong;
      return this;
    }
    
    public Builder setErrorMessage(int paramInt, CharSequence paramCharSequence)
    {
      this.mErrorCode = paramInt;
      this.mErrorMessage = paramCharSequence;
      return this;
    }
    
    @Deprecated
    public Builder setErrorMessage(CharSequence paramCharSequence)
    {
      this.mErrorMessage = paramCharSequence;
      return this;
    }
    
    public Builder setExtras(Bundle paramBundle)
    {
      this.mExtras = paramBundle;
      return this;
    }
    
    public Builder setState(int paramInt, long paramLong, float paramFloat)
    {
      return setState(paramInt, paramLong, paramFloat, SystemClock.elapsedRealtime());
    }
    
    public Builder setState(int paramInt, long paramLong1, float paramFloat, long paramLong2)
    {
      this.mState = paramInt;
      this.mPosition = paramLong1;
      this.mUpdateTime = paramLong2;
      this.mRate = paramFloat;
      return this;
    }
  }
  
  public static final class CustomAction
    implements Parcelable
  {
    public static final Parcelable.Creator<CustomAction> CREATOR = new Parcelable.Creator()
    {
      public PlaybackStateCompat.CustomAction createFromParcel(Parcel paramAnonymousParcel)
      {
        return new PlaybackStateCompat.CustomAction(paramAnonymousParcel);
      }
      
      public PlaybackStateCompat.CustomAction[] newArray(int paramAnonymousInt)
      {
        return new PlaybackStateCompat.CustomAction[paramAnonymousInt];
      }
    };
    private final String mAction;
    private PlaybackState.CustomAction mCustomActionFwk;
    private final Bundle mExtras;
    private final int mIcon;
    private final CharSequence mName;
    
    CustomAction(Parcel paramParcel)
    {
      this.mAction = paramParcel.readString();
      this.mName = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
      this.mIcon = paramParcel.readInt();
      this.mExtras = paramParcel.readBundle(MediaSessionCompat.class.getClassLoader());
    }
    
    CustomAction(String paramString, CharSequence paramCharSequence, int paramInt, Bundle paramBundle)
    {
      this.mAction = paramString;
      this.mName = paramCharSequence;
      this.mIcon = paramInt;
      this.mExtras = paramBundle;
    }
    
    public static CustomAction fromCustomAction(Object paramObject)
    {
      if ((paramObject != null) && (Build.VERSION.SDK_INT >= 21))
      {
        paramObject = (PlaybackState.CustomAction)paramObject;
        Object localObject = ((PlaybackState.CustomAction)paramObject).getExtras();
        MediaSessionCompat.ensureClassLoader((Bundle)localObject);
        localObject = new CustomAction(((PlaybackState.CustomAction)paramObject).getAction(), ((PlaybackState.CustomAction)paramObject).getName(), ((PlaybackState.CustomAction)paramObject).getIcon(), (Bundle)localObject);
        ((CustomAction)localObject).mCustomActionFwk = ((PlaybackState.CustomAction)paramObject);
        return (CustomAction)localObject;
      }
      return null;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String getAction()
    {
      return this.mAction;
    }
    
    public Object getCustomAction()
    {
      PlaybackState.CustomAction localCustomAction = this.mCustomActionFwk;
      Object localObject = localCustomAction;
      if (localCustomAction == null) {
        if (Build.VERSION.SDK_INT < 21)
        {
          localObject = localCustomAction;
        }
        else
        {
          localObject = new PlaybackState.CustomAction.Builder(this.mAction, this.mName, this.mIcon);
          ((PlaybackState.CustomAction.Builder)localObject).setExtras(this.mExtras);
          localObject = ((PlaybackState.CustomAction.Builder)localObject).build();
        }
      }
      return localObject;
    }
    
    public Bundle getExtras()
    {
      return this.mExtras;
    }
    
    public int getIcon()
    {
      return this.mIcon;
    }
    
    public CharSequence getName()
    {
      return this.mName;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Action:mName='");
      localStringBuilder.append(this.mName);
      localStringBuilder.append(", mIcon=");
      localStringBuilder.append(this.mIcon);
      localStringBuilder.append(", mExtras=");
      localStringBuilder.append(this.mExtras);
      return localStringBuilder.toString();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.mAction);
      TextUtils.writeToParcel(this.mName, paramParcel, paramInt);
      paramParcel.writeInt(this.mIcon);
      paramParcel.writeBundle(this.mExtras);
    }
    
    public static final class Builder
    {
      private final String mAction;
      private Bundle mExtras;
      private final int mIcon;
      private final CharSequence mName;
      
      public Builder(String paramString, CharSequence paramCharSequence, int paramInt)
      {
        if (!TextUtils.isEmpty(paramString))
        {
          if (!TextUtils.isEmpty(paramCharSequence))
          {
            if (paramInt != 0)
            {
              this.mAction = paramString;
              this.mName = paramCharSequence;
              this.mIcon = paramInt;
              return;
            }
            throw new IllegalArgumentException("You must specify an icon resource id to build a CustomAction");
          }
          throw new IllegalArgumentException("You must specify a name to build a CustomAction");
        }
        throw new IllegalArgumentException("You must specify an action to build a CustomAction");
      }
      
      public PlaybackStateCompat.CustomAction build()
      {
        return new PlaybackStateCompat.CustomAction(this.mAction, this.mName, this.mIcon, this.mExtras);
      }
      
      public Builder setExtras(Bundle paramBundle)
      {
        this.mExtras = paramBundle;
        return this;
      }
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public static @interface MediaKeyAction {}
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static @interface RepeatMode {}
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static @interface ShuffleMode {}
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static @interface State {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\android\support\v4\media\session\PlaybackStateCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */