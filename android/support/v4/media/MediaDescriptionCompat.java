package android.support.v4.media;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.media.MediaDescription.Builder;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

@SuppressLint({"BanParcelableUsage"})
public final class MediaDescriptionCompat
  implements Parcelable
{
  public static final long BT_FOLDER_TYPE_ALBUMS = 2L;
  public static final long BT_FOLDER_TYPE_ARTISTS = 3L;
  public static final long BT_FOLDER_TYPE_GENRES = 4L;
  public static final long BT_FOLDER_TYPE_MIXED = 0L;
  public static final long BT_FOLDER_TYPE_PLAYLISTS = 5L;
  public static final long BT_FOLDER_TYPE_TITLES = 1L;
  public static final long BT_FOLDER_TYPE_YEARS = 6L;
  public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new Parcelable.Creator()
  {
    public MediaDescriptionCompat createFromParcel(Parcel paramAnonymousParcel)
    {
      if (Build.VERSION.SDK_INT < 21) {
        return new MediaDescriptionCompat(paramAnonymousParcel);
      }
      return MediaDescriptionCompat.fromMediaDescription(MediaDescription.CREATOR.createFromParcel(paramAnonymousParcel));
    }
    
    public MediaDescriptionCompat[] newArray(int paramAnonymousInt)
    {
      return new MediaDescriptionCompat[paramAnonymousInt];
    }
  };
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public static final String DESCRIPTION_KEY_MEDIA_URI = "android.support.v4.media.description.MEDIA_URI";
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public static final String DESCRIPTION_KEY_NULL_BUNDLE_FLAG = "android.support.v4.media.description.NULL_BUNDLE_FLAG";
  public static final String EXTRA_BT_FOLDER_TYPE = "android.media.extra.BT_FOLDER_TYPE";
  public static final String EXTRA_DOWNLOAD_STATUS = "android.media.extra.DOWNLOAD_STATUS";
  public static final long STATUS_DOWNLOADED = 2L;
  public static final long STATUS_DOWNLOADING = 1L;
  public static final long STATUS_NOT_DOWNLOADED = 0L;
  private static final String TAG = "MediaDescriptionCompat";
  private final CharSequence mDescription;
  private MediaDescription mDescriptionFwk;
  private final Bundle mExtras;
  private final Bitmap mIcon;
  private final Uri mIconUri;
  private final String mMediaId;
  private final Uri mMediaUri;
  private final CharSequence mSubtitle;
  private final CharSequence mTitle;
  
  MediaDescriptionCompat(Parcel paramParcel)
  {
    this.mMediaId = paramParcel.readString();
    this.mTitle = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.mSubtitle = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.mDescription = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    ClassLoader localClassLoader = MediaDescriptionCompat.class.getClassLoader();
    this.mIcon = ((Bitmap)paramParcel.readParcelable(localClassLoader));
    this.mIconUri = ((Uri)paramParcel.readParcelable(localClassLoader));
    this.mExtras = paramParcel.readBundle(localClassLoader);
    this.mMediaUri = ((Uri)paramParcel.readParcelable(localClassLoader));
  }
  
  MediaDescriptionCompat(String paramString, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, Bitmap paramBitmap, Uri paramUri1, Bundle paramBundle, Uri paramUri2)
  {
    this.mMediaId = paramString;
    this.mTitle = paramCharSequence1;
    this.mSubtitle = paramCharSequence2;
    this.mDescription = paramCharSequence3;
    this.mIcon = paramBitmap;
    this.mIconUri = paramUri1;
    this.mExtras = paramBundle;
    this.mMediaUri = paramUri2;
  }
  
  public static MediaDescriptionCompat fromMediaDescription(Object paramObject)
  {
    Builder localBuilder = null;
    Object localObject1 = null;
    Object localObject2 = localBuilder;
    if (paramObject != null)
    {
      int i = Build.VERSION.SDK_INT;
      localObject2 = localBuilder;
      if (i >= 21)
      {
        localBuilder = new Builder();
        MediaDescription localMediaDescription = (MediaDescription)paramObject;
        localBuilder.setMediaId(localMediaDescription.getMediaId());
        localBuilder.setTitle(localMediaDescription.getTitle());
        localBuilder.setSubtitle(localMediaDescription.getSubtitle());
        localBuilder.setDescription(localMediaDescription.getDescription());
        localBuilder.setIconBitmap(localMediaDescription.getIconBitmap());
        localBuilder.setIconUri(localMediaDescription.getIconUri());
        localObject2 = localMediaDescription.getExtras();
        paramObject = localObject2;
        if (localObject2 != null) {
          paramObject = MediaSessionCompat.unparcelWithClassLoader((Bundle)localObject2);
        }
        if (paramObject != null) {
          localObject2 = (Uri)((Bundle)paramObject).getParcelable("android.support.v4.media.description.MEDIA_URI");
        } else {
          localObject2 = null;
        }
        if (localObject2 != null) {
          if ((((Bundle)paramObject).containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG")) && (((Bundle)paramObject).size() == 2))
          {
            paramObject = localObject1;
          }
          else
          {
            ((Bundle)paramObject).remove("android.support.v4.media.description.MEDIA_URI");
            ((Bundle)paramObject).remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
          }
        }
        localBuilder.setExtras((Bundle)paramObject);
        if (localObject2 != null) {
          localBuilder.setMediaUri((Uri)localObject2);
        } else if (i >= 23) {
          localBuilder.setMediaUri(localMediaDescription.getMediaUri());
        }
        localObject2 = localBuilder.build();
        ((MediaDescriptionCompat)localObject2).mDescriptionFwk = localMediaDescription;
      }
    }
    return (MediaDescriptionCompat)localObject2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @Nullable
  public CharSequence getDescription()
  {
    return this.mDescription;
  }
  
  @Nullable
  public Bundle getExtras()
  {
    return this.mExtras;
  }
  
  @Nullable
  public Bitmap getIconBitmap()
  {
    return this.mIcon;
  }
  
  @Nullable
  public Uri getIconUri()
  {
    return this.mIconUri;
  }
  
  public Object getMediaDescription()
  {
    Object localObject1 = this.mDescriptionFwk;
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      int i = Build.VERSION.SDK_INT;
      if (i < 21)
      {
        localObject2 = localObject1;
      }
      else
      {
        MediaDescription.Builder localBuilder = new MediaDescription.Builder();
        localBuilder.setMediaId(this.mMediaId);
        localBuilder.setTitle(this.mTitle);
        localBuilder.setSubtitle(this.mSubtitle);
        localBuilder.setDescription(this.mDescription);
        localBuilder.setIconBitmap(this.mIcon);
        localBuilder.setIconUri(this.mIconUri);
        localObject1 = this.mExtras;
        localObject2 = localObject1;
        if (i < 23)
        {
          localObject2 = localObject1;
          if (this.mMediaUri != null)
          {
            localObject2 = localObject1;
            if (localObject1 == null)
            {
              localObject2 = new Bundle();
              ((Bundle)localObject2).putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
            }
            ((Bundle)localObject2).putParcelable("android.support.v4.media.description.MEDIA_URI", this.mMediaUri);
          }
        }
        localBuilder.setExtras((Bundle)localObject2);
        if (i >= 23) {
          localBuilder.setMediaUri(this.mMediaUri);
        }
        localObject2 = localBuilder.build();
        this.mDescriptionFwk = ((MediaDescription)localObject2);
      }
    }
    return localObject2;
  }
  
  @Nullable
  public String getMediaId()
  {
    return this.mMediaId;
  }
  
  @Nullable
  public Uri getMediaUri()
  {
    return this.mMediaUri;
  }
  
  @Nullable
  public CharSequence getSubtitle()
  {
    return this.mSubtitle;
  }
  
  @Nullable
  public CharSequence getTitle()
  {
    return this.mTitle;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mTitle);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.mSubtitle);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.mDescription);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (Build.VERSION.SDK_INT < 21)
    {
      paramParcel.writeString(this.mMediaId);
      TextUtils.writeToParcel(this.mTitle, paramParcel, paramInt);
      TextUtils.writeToParcel(this.mSubtitle, paramParcel, paramInt);
      TextUtils.writeToParcel(this.mDescription, paramParcel, paramInt);
      paramParcel.writeParcelable(this.mIcon, paramInt);
      paramParcel.writeParcelable(this.mIconUri, paramInt);
      paramParcel.writeBundle(this.mExtras);
      paramParcel.writeParcelable(this.mMediaUri, paramInt);
    }
    else
    {
      ((MediaDescription)getMediaDescription()).writeToParcel(paramParcel, paramInt);
    }
  }
  
  public static final class Builder
  {
    private CharSequence mDescription;
    private Bundle mExtras;
    private Bitmap mIcon;
    private Uri mIconUri;
    private String mMediaId;
    private Uri mMediaUri;
    private CharSequence mSubtitle;
    private CharSequence mTitle;
    
    public MediaDescriptionCompat build()
    {
      return new MediaDescriptionCompat(this.mMediaId, this.mTitle, this.mSubtitle, this.mDescription, this.mIcon, this.mIconUri, this.mExtras, this.mMediaUri);
    }
    
    public Builder setDescription(@Nullable CharSequence paramCharSequence)
    {
      this.mDescription = paramCharSequence;
      return this;
    }
    
    public Builder setExtras(@Nullable Bundle paramBundle)
    {
      this.mExtras = paramBundle;
      return this;
    }
    
    public Builder setIconBitmap(@Nullable Bitmap paramBitmap)
    {
      this.mIcon = paramBitmap;
      return this;
    }
    
    public Builder setIconUri(@Nullable Uri paramUri)
    {
      this.mIconUri = paramUri;
      return this;
    }
    
    public Builder setMediaId(@Nullable String paramString)
    {
      this.mMediaId = paramString;
      return this;
    }
    
    public Builder setMediaUri(@Nullable Uri paramUri)
    {
      this.mMediaUri = paramUri;
      return this;
    }
    
    public Builder setSubtitle(@Nullable CharSequence paramCharSequence)
    {
      this.mSubtitle = paramCharSequence;
      return this;
    }
    
    public Builder setTitle(@Nullable CharSequence paramCharSequence)
    {
      this.mTitle = paramCharSequence;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\android\support\v4\media\MediaDescriptionCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */