package androidx.media;

import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioFocusRequest.Builder;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.util.ObjectsCompat;
import java.util.Objects;

public class AudioFocusRequestCompat
{
  static final AudioAttributesCompat FOCUS_DEFAULT_ATTR = new AudioAttributesCompat.Builder().setUsage(1).build();
  private final AudioAttributesCompat mAudioAttributesCompat;
  private final Handler mFocusChangeHandler;
  private final int mFocusGain;
  private final Object mFrameworkAudioFocusRequest;
  private final AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener;
  private final boolean mPauseOnDuck;
  
  AudioFocusRequestCompat(int paramInt, AudioManager.OnAudioFocusChangeListener paramOnAudioFocusChangeListener, Handler paramHandler, AudioAttributesCompat paramAudioAttributesCompat, boolean paramBoolean)
  {
    this.mFocusGain = paramInt;
    this.mFocusChangeHandler = paramHandler;
    this.mAudioAttributesCompat = paramAudioAttributesCompat;
    this.mPauseOnDuck = paramBoolean;
    int i = Build.VERSION.SDK_INT;
    if ((i < 26) && (paramHandler.getLooper() != Looper.getMainLooper())) {
      this.mOnAudioFocusChangeListener = new OnAudioFocusChangeListenerHandlerCompat(paramOnAudioFocusChangeListener, paramHandler);
    } else {
      this.mOnAudioFocusChangeListener = paramOnAudioFocusChangeListener;
    }
    if (i >= 26) {
      this.mFrameworkAudioFocusRequest = new AudioFocusRequest.Builder(paramInt).setAudioAttributes(getAudioAttributes()).setWillPauseWhenDucked(paramBoolean).setOnAudioFocusChangeListener(this.mOnAudioFocusChangeListener, paramHandler).build();
    } else {
      this.mFrameworkAudioFocusRequest = null;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof AudioFocusRequestCompat)) {
      return false;
    }
    paramObject = (AudioFocusRequestCompat)paramObject;
    if ((this.mFocusGain != ((AudioFocusRequestCompat)paramObject).mFocusGain) || (this.mPauseOnDuck != ((AudioFocusRequestCompat)paramObject).mPauseOnDuck) || (!ObjectsCompat.equals(this.mOnAudioFocusChangeListener, ((AudioFocusRequestCompat)paramObject).mOnAudioFocusChangeListener)) || (!ObjectsCompat.equals(this.mFocusChangeHandler, ((AudioFocusRequestCompat)paramObject).mFocusChangeHandler)) || (!ObjectsCompat.equals(this.mAudioAttributesCompat, ((AudioFocusRequestCompat)paramObject).mAudioAttributesCompat))) {
      bool = false;
    }
    return bool;
  }
  
  @RequiresApi(21)
  AudioAttributes getAudioAttributes()
  {
    Object localObject = this.mAudioAttributesCompat;
    if (localObject != null) {
      localObject = (AudioAttributes)((AudioAttributesCompat)localObject).unwrap();
    } else {
      localObject = null;
    }
    return (AudioAttributes)localObject;
  }
  
  @NonNull
  public AudioAttributesCompat getAudioAttributesCompat()
  {
    return this.mAudioAttributesCompat;
  }
  
  @RequiresApi(26)
  AudioFocusRequest getAudioFocusRequest()
  {
    return (AudioFocusRequest)this.mFrameworkAudioFocusRequest;
  }
  
  @NonNull
  public Handler getFocusChangeHandler()
  {
    return this.mFocusChangeHandler;
  }
  
  public int getFocusGain()
  {
    return this.mFocusGain;
  }
  
  @NonNull
  public AudioManager.OnAudioFocusChangeListener getOnAudioFocusChangeListener()
  {
    return this.mOnAudioFocusChangeListener;
  }
  
  public int hashCode()
  {
    return ObjectsCompat.hash(new Object[] { Integer.valueOf(this.mFocusGain), this.mOnAudioFocusChangeListener, this.mFocusChangeHandler, this.mAudioAttributesCompat, Boolean.valueOf(this.mPauseOnDuck) });
  }
  
  public boolean willPauseWhenDucked()
  {
    return this.mPauseOnDuck;
  }
  
  public static final class Builder
  {
    private AudioAttributesCompat mAudioAttributesCompat = AudioFocusRequestCompat.FOCUS_DEFAULT_ATTR;
    private Handler mFocusChangeHandler;
    private int mFocusGain;
    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener;
    private boolean mPauseOnDuck;
    
    public Builder(int paramInt)
    {
      setFocusGain(paramInt);
    }
    
    public Builder(@NonNull AudioFocusRequestCompat paramAudioFocusRequestCompat)
    {
      if (paramAudioFocusRequestCompat != null)
      {
        this.mFocusGain = paramAudioFocusRequestCompat.getFocusGain();
        this.mOnAudioFocusChangeListener = paramAudioFocusRequestCompat.getOnAudioFocusChangeListener();
        this.mFocusChangeHandler = paramAudioFocusRequestCompat.getFocusChangeHandler();
        this.mAudioAttributesCompat = paramAudioFocusRequestCompat.getAudioAttributesCompat();
        this.mPauseOnDuck = paramAudioFocusRequestCompat.willPauseWhenDucked();
        return;
      }
      throw new IllegalArgumentException("AudioFocusRequestCompat to copy must not be null");
    }
    
    private static boolean isValidFocusGain(int paramInt)
    {
      return (paramInt == 1) || (paramInt == 2) || (paramInt == 3) || (paramInt == 4);
    }
    
    public AudioFocusRequestCompat build()
    {
      if (this.mOnAudioFocusChangeListener != null) {
        return new AudioFocusRequestCompat(this.mFocusGain, this.mOnAudioFocusChangeListener, this.mFocusChangeHandler, this.mAudioAttributesCompat, this.mPauseOnDuck);
      }
      throw new IllegalStateException("Can't build an AudioFocusRequestCompat instance without a listener");
    }
    
    @NonNull
    public Builder setAudioAttributes(@NonNull AudioAttributesCompat paramAudioAttributesCompat)
    {
      Objects.requireNonNull(paramAudioAttributesCompat, "Illegal null AudioAttributes");
      this.mAudioAttributesCompat = paramAudioAttributesCompat;
      return this;
    }
    
    @NonNull
    public Builder setFocusGain(int paramInt)
    {
      if (isValidFocusGain(paramInt))
      {
        int i = paramInt;
        if (Build.VERSION.SDK_INT < 19)
        {
          i = paramInt;
          if (paramInt == 4) {
            i = 2;
          }
        }
        this.mFocusGain = i;
        return this;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Illegal audio focus gain type ");
      localStringBuilder.append(paramInt);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    
    @NonNull
    public Builder setOnAudioFocusChangeListener(@NonNull AudioManager.OnAudioFocusChangeListener paramOnAudioFocusChangeListener)
    {
      return setOnAudioFocusChangeListener(paramOnAudioFocusChangeListener, new Handler(Looper.getMainLooper()));
    }
    
    @NonNull
    public Builder setOnAudioFocusChangeListener(@NonNull AudioManager.OnAudioFocusChangeListener paramOnAudioFocusChangeListener, @NonNull Handler paramHandler)
    {
      if (paramOnAudioFocusChangeListener != null)
      {
        if (paramHandler != null)
        {
          this.mOnAudioFocusChangeListener = paramOnAudioFocusChangeListener;
          this.mFocusChangeHandler = paramHandler;
          return this;
        }
        throw new IllegalArgumentException("Handler must not be null");
      }
      throw new IllegalArgumentException("OnAudioFocusChangeListener must not be null");
    }
    
    @NonNull
    public Builder setWillPauseWhenDucked(boolean paramBoolean)
    {
      this.mPauseOnDuck = paramBoolean;
      return this;
    }
  }
  
  private static class OnAudioFocusChangeListenerHandlerCompat
    implements Handler.Callback, AudioManager.OnAudioFocusChangeListener
  {
    private static final int FOCUS_CHANGE = 2782386;
    private final Handler mHandler;
    private final AudioManager.OnAudioFocusChangeListener mListener;
    
    OnAudioFocusChangeListenerHandlerCompat(@NonNull AudioManager.OnAudioFocusChangeListener paramOnAudioFocusChangeListener, @NonNull Handler paramHandler)
    {
      this.mListener = paramOnAudioFocusChangeListener;
      this.mHandler = new Handler(paramHandler.getLooper(), this);
    }
    
    public boolean handleMessage(Message paramMessage)
    {
      if (paramMessage.what == 2782386)
      {
        this.mListener.onAudioFocusChange(paramMessage.arg1);
        return true;
      }
      return false;
    }
    
    public void onAudioFocusChange(int paramInt)
    {
      Handler localHandler = this.mHandler;
      localHandler.sendMessage(Message.obtain(localHandler, 2782386, paramInt, 0));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\media\AudioFocusRequestCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */