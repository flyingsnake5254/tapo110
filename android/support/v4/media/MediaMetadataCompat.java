package android.support.v4.media;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.media.MediaMetadata;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import java.util.Iterator;
import java.util.Set;

@SuppressLint({"BanParcelableUsage"})
public final class MediaMetadataCompat
  implements Parcelable
{
  public static final Parcelable.Creator<MediaMetadataCompat> CREATOR = new Parcelable.Creator()
  {
    public MediaMetadataCompat createFromParcel(Parcel paramAnonymousParcel)
    {
      return new MediaMetadataCompat(paramAnonymousParcel);
    }
    
    public MediaMetadataCompat[] newArray(int paramAnonymousInt)
    {
      return new MediaMetadataCompat[paramAnonymousInt];
    }
  };
  static final ArrayMap<String, Integer> METADATA_KEYS_TYPE;
  public static final String METADATA_KEY_ADVERTISEMENT = "android.media.metadata.ADVERTISEMENT";
  public static final String METADATA_KEY_ALBUM = "android.media.metadata.ALBUM";
  public static final String METADATA_KEY_ALBUM_ART = "android.media.metadata.ALBUM_ART";
  public static final String METADATA_KEY_ALBUM_ARTIST = "android.media.metadata.ALBUM_ARTIST";
  public static final String METADATA_KEY_ALBUM_ART_URI = "android.media.metadata.ALBUM_ART_URI";
  public static final String METADATA_KEY_ART = "android.media.metadata.ART";
  public static final String METADATA_KEY_ARTIST = "android.media.metadata.ARTIST";
  public static final String METADATA_KEY_ART_URI = "android.media.metadata.ART_URI";
  public static final String METADATA_KEY_AUTHOR = "android.media.metadata.AUTHOR";
  public static final String METADATA_KEY_BT_FOLDER_TYPE = "android.media.metadata.BT_FOLDER_TYPE";
  public static final String METADATA_KEY_COMPILATION = "android.media.metadata.COMPILATION";
  public static final String METADATA_KEY_COMPOSER = "android.media.metadata.COMPOSER";
  public static final String METADATA_KEY_DATE = "android.media.metadata.DATE";
  public static final String METADATA_KEY_DISC_NUMBER = "android.media.metadata.DISC_NUMBER";
  public static final String METADATA_KEY_DISPLAY_DESCRIPTION = "android.media.metadata.DISPLAY_DESCRIPTION";
  public static final String METADATA_KEY_DISPLAY_ICON = "android.media.metadata.DISPLAY_ICON";
  public static final String METADATA_KEY_DISPLAY_ICON_URI = "android.media.metadata.DISPLAY_ICON_URI";
  public static final String METADATA_KEY_DISPLAY_SUBTITLE = "android.media.metadata.DISPLAY_SUBTITLE";
  public static final String METADATA_KEY_DISPLAY_TITLE = "android.media.metadata.DISPLAY_TITLE";
  public static final String METADATA_KEY_DOWNLOAD_STATUS = "android.media.metadata.DOWNLOAD_STATUS";
  public static final String METADATA_KEY_DURATION = "android.media.metadata.DURATION";
  public static final String METADATA_KEY_GENRE = "android.media.metadata.GENRE";
  public static final String METADATA_KEY_MEDIA_ID = "android.media.metadata.MEDIA_ID";
  public static final String METADATA_KEY_MEDIA_URI = "android.media.metadata.MEDIA_URI";
  public static final String METADATA_KEY_NUM_TRACKS = "android.media.metadata.NUM_TRACKS";
  public static final String METADATA_KEY_RATING = "android.media.metadata.RATING";
  public static final String METADATA_KEY_TITLE = "android.media.metadata.TITLE";
  public static final String METADATA_KEY_TRACK_NUMBER = "android.media.metadata.TRACK_NUMBER";
  public static final String METADATA_KEY_USER_RATING = "android.media.metadata.USER_RATING";
  public static final String METADATA_KEY_WRITER = "android.media.metadata.WRITER";
  public static final String METADATA_KEY_YEAR = "android.media.metadata.YEAR";
  static final int METADATA_TYPE_BITMAP = 2;
  static final int METADATA_TYPE_LONG = 0;
  static final int METADATA_TYPE_RATING = 3;
  static final int METADATA_TYPE_TEXT = 1;
  private static final String[] PREFERRED_BITMAP_ORDER;
  private static final String[] PREFERRED_DESCRIPTION_ORDER;
  private static final String[] PREFERRED_URI_ORDER;
  private static final String TAG = "MediaMetadata";
  final Bundle mBundle;
  private MediaDescriptionCompat mDescription;
  private MediaMetadata mMetadataFwk;
  
  static
  {
    ArrayMap localArrayMap = new ArrayMap();
    METADATA_KEYS_TYPE = localArrayMap;
    Integer localInteger1 = Integer.valueOf(1);
    localArrayMap.put("android.media.metadata.TITLE", localInteger1);
    localArrayMap.put("android.media.metadata.ARTIST", localInteger1);
    Integer localInteger2 = Integer.valueOf(0);
    localArrayMap.put("android.media.metadata.DURATION", localInteger2);
    localArrayMap.put("android.media.metadata.ALBUM", localInteger1);
    localArrayMap.put("android.media.metadata.AUTHOR", localInteger1);
    localArrayMap.put("android.media.metadata.WRITER", localInteger1);
    localArrayMap.put("android.media.metadata.COMPOSER", localInteger1);
    localArrayMap.put("android.media.metadata.COMPILATION", localInteger1);
    localArrayMap.put("android.media.metadata.DATE", localInteger1);
    localArrayMap.put("android.media.metadata.YEAR", localInteger2);
    localArrayMap.put("android.media.metadata.GENRE", localInteger1);
    localArrayMap.put("android.media.metadata.TRACK_NUMBER", localInteger2);
    localArrayMap.put("android.media.metadata.NUM_TRACKS", localInteger2);
    localArrayMap.put("android.media.metadata.DISC_NUMBER", localInteger2);
    localArrayMap.put("android.media.metadata.ALBUM_ARTIST", localInteger1);
    Integer localInteger3 = Integer.valueOf(2);
    localArrayMap.put("android.media.metadata.ART", localInteger3);
    localArrayMap.put("android.media.metadata.ART_URI", localInteger1);
    localArrayMap.put("android.media.metadata.ALBUM_ART", localInteger3);
    localArrayMap.put("android.media.metadata.ALBUM_ART_URI", localInteger1);
    Integer localInteger4 = Integer.valueOf(3);
    localArrayMap.put("android.media.metadata.USER_RATING", localInteger4);
    localArrayMap.put("android.media.metadata.RATING", localInteger4);
    localArrayMap.put("android.media.metadata.DISPLAY_TITLE", localInteger1);
    localArrayMap.put("android.media.metadata.DISPLAY_SUBTITLE", localInteger1);
    localArrayMap.put("android.media.metadata.DISPLAY_DESCRIPTION", localInteger1);
    localArrayMap.put("android.media.metadata.DISPLAY_ICON", localInteger3);
    localArrayMap.put("android.media.metadata.DISPLAY_ICON_URI", localInteger1);
    localArrayMap.put("android.media.metadata.MEDIA_ID", localInteger1);
    localArrayMap.put("android.media.metadata.BT_FOLDER_TYPE", localInteger2);
    localArrayMap.put("android.media.metadata.MEDIA_URI", localInteger1);
    localArrayMap.put("android.media.metadata.ADVERTISEMENT", localInteger2);
    localArrayMap.put("android.media.metadata.DOWNLOAD_STATUS", localInteger2);
    PREFERRED_DESCRIPTION_ORDER = new String[] { "android.media.metadata.TITLE", "android.media.metadata.ARTIST", "android.media.metadata.ALBUM", "android.media.metadata.ALBUM_ARTIST", "android.media.metadata.WRITER", "android.media.metadata.AUTHOR", "android.media.metadata.COMPOSER" };
    PREFERRED_BITMAP_ORDER = new String[] { "android.media.metadata.DISPLAY_ICON", "android.media.metadata.ART", "android.media.metadata.ALBUM_ART" };
    PREFERRED_URI_ORDER = new String[] { "android.media.metadata.DISPLAY_ICON_URI", "android.media.metadata.ART_URI", "android.media.metadata.ALBUM_ART_URI" };
  }
  
  MediaMetadataCompat(Bundle paramBundle)
  {
    paramBundle = new Bundle(paramBundle);
    this.mBundle = paramBundle;
    MediaSessionCompat.ensureClassLoader(paramBundle);
  }
  
  MediaMetadataCompat(Parcel paramParcel)
  {
    this.mBundle = paramParcel.readBundle(MediaSessionCompat.class.getClassLoader());
  }
  
  public static MediaMetadataCompat fromMediaMetadata(Object paramObject)
  {
    if ((paramObject != null) && (Build.VERSION.SDK_INT >= 21))
    {
      Parcel localParcel = Parcel.obtain();
      paramObject = (MediaMetadata)paramObject;
      ((MediaMetadata)paramObject).writeToParcel(localParcel, 0);
      localParcel.setDataPosition(0);
      MediaMetadataCompat localMediaMetadataCompat = (MediaMetadataCompat)CREATOR.createFromParcel(localParcel);
      localParcel.recycle();
      localMediaMetadataCompat.mMetadataFwk = ((MediaMetadata)paramObject);
      return localMediaMetadataCompat;
    }
    return null;
  }
  
  public boolean containsKey(String paramString)
  {
    return this.mBundle.containsKey(paramString);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Bitmap getBitmap(String paramString)
  {
    try
    {
      paramString = (Bitmap)this.mBundle.getParcelable(paramString);
    }
    catch (Exception paramString)
    {
      Log.w("MediaMetadata", "Failed to retrieve a key as Bitmap.", paramString);
      paramString = null;
    }
    return paramString;
  }
  
  public Bundle getBundle()
  {
    return new Bundle(this.mBundle);
  }
  
  public MediaDescriptionCompat getDescription()
  {
    Object localObject1 = this.mDescription;
    if (localObject1 != null) {
      return (MediaDescriptionCompat)localObject1;
    }
    String str = getString("android.media.metadata.MEDIA_ID");
    CharSequence[] arrayOfCharSequence = new CharSequence[3];
    localObject1 = getText("android.media.metadata.DISPLAY_TITLE");
    int k;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      arrayOfCharSequence[0] = localObject1;
      arrayOfCharSequence[1] = getText("android.media.metadata.DISPLAY_SUBTITLE");
      arrayOfCharSequence[2] = getText("android.media.metadata.DISPLAY_DESCRIPTION");
    }
    else
    {
      int i = 0;
      j = 0;
      while (i < 3)
      {
        localObject1 = PREFERRED_DESCRIPTION_ORDER;
        if (j >= localObject1.length) {
          break;
        }
        localObject1 = getText(localObject1[j]);
        k = i;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          arrayOfCharSequence[i] = localObject1;
          k = i + 1;
        }
        j++;
        i = k;
      }
    }
    Uri localUri;
    for (int j = 0;; j++)
    {
      localObject1 = PREFERRED_BITMAP_ORDER;
      k = localObject1.length;
      localUri = null;
      if (j >= k) {
        break;
      }
      localObject1 = getBitmap(localObject1[j]);
      if (localObject1 != null) {
        break label171;
      }
    }
    localObject1 = null;
    label171:
    for (j = 0;; j++)
    {
      localObject2 = PREFERRED_URI_ORDER;
      if (j >= localObject2.length) {
        break;
      }
      localObject2 = getString(localObject2[j]);
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject2 = Uri.parse((String)localObject2);
        break label225;
      }
    }
    Object localObject2 = null;
    label225:
    Object localObject3 = getString("android.media.metadata.MEDIA_URI");
    if (!TextUtils.isEmpty((CharSequence)localObject3)) {
      localUri = Uri.parse((String)localObject3);
    }
    localObject3 = new MediaDescriptionCompat.Builder();
    ((MediaDescriptionCompat.Builder)localObject3).setMediaId(str);
    ((MediaDescriptionCompat.Builder)localObject3).setTitle(arrayOfCharSequence[0]);
    ((MediaDescriptionCompat.Builder)localObject3).setSubtitle(arrayOfCharSequence[1]);
    ((MediaDescriptionCompat.Builder)localObject3).setDescription(arrayOfCharSequence[2]);
    ((MediaDescriptionCompat.Builder)localObject3).setIconBitmap((Bitmap)localObject1);
    ((MediaDescriptionCompat.Builder)localObject3).setIconUri((Uri)localObject2);
    ((MediaDescriptionCompat.Builder)localObject3).setMediaUri(localUri);
    localObject1 = new Bundle();
    if (this.mBundle.containsKey("android.media.metadata.BT_FOLDER_TYPE")) {
      ((Bundle)localObject1).putLong("android.media.extra.BT_FOLDER_TYPE", getLong("android.media.metadata.BT_FOLDER_TYPE"));
    }
    if (this.mBundle.containsKey("android.media.metadata.DOWNLOAD_STATUS")) {
      ((Bundle)localObject1).putLong("android.media.extra.DOWNLOAD_STATUS", getLong("android.media.metadata.DOWNLOAD_STATUS"));
    }
    if (!((Bundle)localObject1).isEmpty()) {
      ((MediaDescriptionCompat.Builder)localObject3).setExtras((Bundle)localObject1);
    }
    localObject1 = ((MediaDescriptionCompat.Builder)localObject3).build();
    this.mDescription = ((MediaDescriptionCompat)localObject1);
    return (MediaDescriptionCompat)localObject1;
  }
  
  public long getLong(String paramString)
  {
    return this.mBundle.getLong(paramString, 0L);
  }
  
  public Object getMediaMetadata()
  {
    if ((this.mMetadataFwk == null) && (Build.VERSION.SDK_INT >= 21))
    {
      Parcel localParcel = Parcel.obtain();
      writeToParcel(localParcel, 0);
      localParcel.setDataPosition(0);
      this.mMetadataFwk = ((MediaMetadata)MediaMetadata.CREATOR.createFromParcel(localParcel));
      localParcel.recycle();
    }
    return this.mMetadataFwk;
  }
  
  public RatingCompat getRating(String paramString)
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 19) {
        paramString = RatingCompat.fromRating(this.mBundle.getParcelable(paramString));
      } else {
        paramString = (RatingCompat)this.mBundle.getParcelable(paramString);
      }
    }
    catch (Exception paramString)
    {
      Log.w("MediaMetadata", "Failed to retrieve a key as Rating.", paramString);
      paramString = null;
    }
    return paramString;
  }
  
  public String getString(String paramString)
  {
    paramString = this.mBundle.getCharSequence(paramString);
    if (paramString != null) {
      return paramString.toString();
    }
    return null;
  }
  
  public CharSequence getText(String paramString)
  {
    return this.mBundle.getCharSequence(paramString);
  }
  
  public Set<String> keySet()
  {
    return this.mBundle.keySet();
  }
  
  public int size()
  {
    return this.mBundle.size();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeBundle(this.mBundle);
  }
  
  public static final class Builder
  {
    private final Bundle mBundle;
    
    public Builder()
    {
      this.mBundle = new Bundle();
    }
    
    public Builder(MediaMetadataCompat paramMediaMetadataCompat)
    {
      paramMediaMetadataCompat = new Bundle(paramMediaMetadataCompat.mBundle);
      this.mBundle = paramMediaMetadataCompat;
      MediaSessionCompat.ensureClassLoader(paramMediaMetadataCompat);
    }
    
    @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public Builder(MediaMetadataCompat paramMediaMetadataCompat, int paramInt)
    {
      this(paramMediaMetadataCompat);
      paramMediaMetadataCompat = this.mBundle.keySet().iterator();
      while (paramMediaMetadataCompat.hasNext())
      {
        String str = (String)paramMediaMetadataCompat.next();
        Object localObject = this.mBundle.get(str);
        if ((localObject instanceof Bitmap))
        {
          localObject = (Bitmap)localObject;
          if ((((Bitmap)localObject).getHeight() > paramInt) || (((Bitmap)localObject).getWidth() > paramInt)) {
            putBitmap(str, scaleBitmap((Bitmap)localObject, paramInt));
          }
        }
      }
    }
    
    private Bitmap scaleBitmap(Bitmap paramBitmap, int paramInt)
    {
      float f = paramInt;
      f = Math.min(f / paramBitmap.getWidth(), f / paramBitmap.getHeight());
      paramInt = (int)(paramBitmap.getHeight() * f);
      return Bitmap.createScaledBitmap(paramBitmap, (int)(paramBitmap.getWidth() * f), paramInt, true);
    }
    
    public MediaMetadataCompat build()
    {
      return new MediaMetadataCompat(this.mBundle);
    }
    
    public Builder putBitmap(String paramString, Bitmap paramBitmap)
    {
      ArrayMap localArrayMap = MediaMetadataCompat.METADATA_KEYS_TYPE;
      if ((localArrayMap.containsKey(paramString)) && (((Integer)localArrayMap.get(paramString)).intValue() != 2))
      {
        paramBitmap = new StringBuilder();
        paramBitmap.append("The ");
        paramBitmap.append(paramString);
        paramBitmap.append(" key cannot be used to put a Bitmap");
        throw new IllegalArgumentException(paramBitmap.toString());
      }
      this.mBundle.putParcelable(paramString, paramBitmap);
      return this;
    }
    
    public Builder putLong(String paramString, long paramLong)
    {
      Object localObject = MediaMetadataCompat.METADATA_KEYS_TYPE;
      if ((((SimpleArrayMap)localObject).containsKey(paramString)) && (((Integer)((SimpleArrayMap)localObject).get(paramString)).intValue() != 0))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("The ");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" key cannot be used to put a long");
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
      this.mBundle.putLong(paramString, paramLong);
      return this;
    }
    
    public Builder putRating(String paramString, RatingCompat paramRatingCompat)
    {
      ArrayMap localArrayMap = MediaMetadataCompat.METADATA_KEYS_TYPE;
      if ((localArrayMap.containsKey(paramString)) && (((Integer)localArrayMap.get(paramString)).intValue() != 3))
      {
        paramRatingCompat = new StringBuilder();
        paramRatingCompat.append("The ");
        paramRatingCompat.append(paramString);
        paramRatingCompat.append(" key cannot be used to put a Rating");
        throw new IllegalArgumentException(paramRatingCompat.toString());
      }
      if (Build.VERSION.SDK_INT >= 19) {
        this.mBundle.putParcelable(paramString, (Parcelable)paramRatingCompat.getRating());
      } else {
        this.mBundle.putParcelable(paramString, paramRatingCompat);
      }
      return this;
    }
    
    public Builder putString(String paramString1, String paramString2)
    {
      ArrayMap localArrayMap = MediaMetadataCompat.METADATA_KEYS_TYPE;
      if ((localArrayMap.containsKey(paramString1)) && (((Integer)localArrayMap.get(paramString1)).intValue() != 1))
      {
        paramString2 = new StringBuilder();
        paramString2.append("The ");
        paramString2.append(paramString1);
        paramString2.append(" key cannot be used to put a String");
        throw new IllegalArgumentException(paramString2.toString());
      }
      this.mBundle.putCharSequence(paramString1, paramString2);
      return this;
    }
    
    public Builder putText(String paramString, CharSequence paramCharSequence)
    {
      ArrayMap localArrayMap = MediaMetadataCompat.METADATA_KEYS_TYPE;
      if ((localArrayMap.containsKey(paramString)) && (((Integer)localArrayMap.get(paramString)).intValue() != 1))
      {
        paramCharSequence = new StringBuilder();
        paramCharSequence.append("The ");
        paramCharSequence.append(paramString);
        paramCharSequence.append(" key cannot be used to put a CharSequence");
        throw new IllegalArgumentException(paramCharSequence.toString());
      }
      this.mBundle.putCharSequence(paramString, paramCharSequence);
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\android\support\v4\media\MediaMetadataCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */