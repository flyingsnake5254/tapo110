package com.google.android.gms.common.images;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.util.Log;
import android.widget.ImageView;
import androidx.collection.LruCache;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.internal.base.zak;
import com.google.android.gms.internal.base.zap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ImageManager
{
  private static final Object zamh = new Object();
  private static HashSet<Uri> zami = new HashSet();
  private static ImageManager zamj;
  private final Context mContext;
  private final Handler mHandler;
  private final ExecutorService zamk;
  private final zaa zaml;
  private final zak zamm;
  private final Map<zaa, ImageReceiver> zamn;
  private final Map<Uri, ImageReceiver> zamo;
  private final Map<Uri, Long> zamp;
  
  private ImageManager(Context paramContext, boolean paramBoolean)
  {
    this.mContext = paramContext.getApplicationContext();
    this.mHandler = new zap(Looper.getMainLooper());
    this.zamk = Executors.newFixedThreadPool(4);
    this.zaml = null;
    this.zamm = new zak();
    this.zamn = new HashMap();
    this.zamo = new HashMap();
    this.zamp = new HashMap();
  }
  
  public static ImageManager create(Context paramContext)
  {
    if (zamj == null) {
      zamj = new ImageManager(paramContext, false);
    }
    return zamj;
  }
  
  private final Bitmap zaa(zab paramzab)
  {
    zaa localzaa = this.zaml;
    if (localzaa == null) {
      return null;
    }
    return (Bitmap)localzaa.get(paramzab);
  }
  
  private final void zaa(zaa paramzaa)
  {
    Asserts.checkMainThread("ImageManager.loadImage() must be called in the main thread");
    new zac(paramzaa).run();
  }
  
  public final void loadImage(ImageView paramImageView, int paramInt)
  {
    zaa(new zac(paramImageView, paramInt));
  }
  
  public final void loadImage(ImageView paramImageView, Uri paramUri)
  {
    zaa(new zac(paramImageView, paramUri));
  }
  
  public final void loadImage(ImageView paramImageView, Uri paramUri, int paramInt)
  {
    paramImageView = new zac(paramImageView, paramUri);
    paramImageView.zamx = paramInt;
    zaa(paramImageView);
  }
  
  public final void loadImage(OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri)
  {
    zaa(new zad(paramOnImageLoadedListener, paramUri));
  }
  
  public final void loadImage(OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri, int paramInt)
  {
    paramOnImageLoadedListener = new zad(paramOnImageLoadedListener, paramUri);
    paramOnImageLoadedListener.zamx = paramInt;
    zaa(paramOnImageLoadedListener);
  }
  
  @KeepName
  private final class ImageReceiver
    extends ResultReceiver
  {
    private final Uri mUri;
    private final ArrayList<zaa> zamq;
    
    ImageReceiver(Uri paramUri)
    {
      super();
      this.mUri = paramUri;
      this.zamq = new ArrayList();
    }
    
    public final void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      paramBundle = (ParcelFileDescriptor)paramBundle.getParcelable("com.google.android.gms.extra.fileDescriptor");
      ImageManager.zaf(ImageManager.this).execute(new ImageManager.zab(ImageManager.this, this.mUri, paramBundle));
    }
    
    public final void zab(zaa paramzaa)
    {
      Asserts.checkMainThread("ImageReceiver.addImageRequest() must be called in the main thread");
      this.zamq.add(paramzaa);
    }
    
    public final void zac(zaa paramzaa)
    {
      Asserts.checkMainThread("ImageReceiver.removeImageRequest() must be called in the main thread");
      this.zamq.remove(paramzaa);
    }
    
    public final void zace()
    {
      Intent localIntent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
      localIntent.putExtra("com.google.android.gms.extras.uri", this.mUri);
      localIntent.putExtra("com.google.android.gms.extras.resultReceiver", this);
      localIntent.putExtra("com.google.android.gms.extras.priority", 3);
      ImageManager.zab(ImageManager.this).sendBroadcast(localIntent);
    }
  }
  
  public static abstract interface OnImageLoadedListener
  {
    public abstract void onImageLoaded(Uri paramUri, Drawable paramDrawable, boolean paramBoolean);
  }
  
  private static final class zaa
    extends LruCache<zab, Bitmap>
  {}
  
  private final class zab
    implements Runnable
  {
    private final Uri mUri;
    private final ParcelFileDescriptor zams;
    
    public zab(Uri paramUri, ParcelFileDescriptor paramParcelFileDescriptor)
    {
      this.mUri = paramUri;
      this.zams = paramParcelFileDescriptor;
    }
    
    public final void run()
    {
      Asserts.checkNotMainThread("LoadBitmapFromDiskRunnable can't be executed in the main thread");
      Object localObject1 = this.zams;
      boolean bool = false;
      Object localObject3 = null;
      if (localObject1 != null)
      {
        try
        {
          localObject1 = BitmapFactory.decodeFileDescriptor(((ParcelFileDescriptor)localObject1).getFileDescriptor());
          localObject3 = localObject1;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          String str = String.valueOf(this.mUri);
          localObject1 = new StringBuilder(str.length() + 34);
          ((StringBuilder)localObject1).append("OOM while loading bitmap for uri: ");
          ((StringBuilder)localObject1).append(str);
          Log.e("ImageManager", ((StringBuilder)localObject1).toString(), localOutOfMemoryError);
          bool = true;
        }
        try
        {
          this.zams.close();
        }
        catch (IOException localIOException)
        {
          Log.e("ImageManager", "closed failed", localIOException);
        }
      }
      else
      {
        localObject3 = null;
        bool = false;
      }
      Object localObject2 = new CountDownLatch(1);
      ImageManager.zag(ImageManager.this).post(new ImageManager.zad(ImageManager.this, this.mUri, (Bitmap)localObject3, bool, (CountDownLatch)localObject2));
      try
      {
        ((CountDownLatch)localObject2).await();
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        localObject2 = String.valueOf(this.mUri);
        StringBuilder localStringBuilder = new StringBuilder(((String)localObject2).length() + 32);
        localStringBuilder.append("Latch interrupted while posting ");
        localStringBuilder.append((String)localObject2);
        Log.w("ImageManager", localStringBuilder.toString());
      }
    }
  }
  
  private final class zac
    implements Runnable
  {
    private final zaa zamt;
    
    public zac(zaa paramzaa)
    {
      this.zamt = paramzaa;
    }
    
    public final void run()
    {
      Asserts.checkMainThread("LoadImageRunnable must be executed on the main thread");
      Object localObject1 = (ImageManager.ImageReceiver)ImageManager.zaa(ImageManager.this).get(this.zamt);
      if (localObject1 != null)
      {
        ImageManager.zaa(ImageManager.this).remove(this.zamt);
        ((ImageManager.ImageReceiver)localObject1).zac(this.zamt);
      }
      localObject1 = this.zamt;
      zab localzab = ((zaa)localObject1).zamv;
      if (localzab.uri == null)
      {
        ((zaa)localObject1).zaa(ImageManager.zab(ImageManager.this), ImageManager.zac(ImageManager.this), true);
        return;
      }
      localObject1 = ImageManager.zaa(ImageManager.this, localzab);
      if (localObject1 != null)
      {
        this.zamt.zaa(ImageManager.zab(ImageManager.this), (Bitmap)localObject1, true);
        return;
      }
      localObject1 = (Long)ImageManager.zad(ImageManager.this).get(localzab.uri);
      if (localObject1 != null)
      {
        if (SystemClock.elapsedRealtime() - ((Long)localObject1).longValue() < 3600000L)
        {
          this.zamt.zaa(ImageManager.zab(ImageManager.this), ImageManager.zac(ImageManager.this), true);
          return;
        }
        ImageManager.zad(ImageManager.this).remove(localzab.uri);
      }
      this.zamt.zaa(ImageManager.zab(ImageManager.this), ImageManager.zac(ImageManager.this));
      ??? = (ImageManager.ImageReceiver)ImageManager.zae(ImageManager.this).get(localzab.uri);
      localObject1 = ???;
      if (??? == null)
      {
        localObject1 = new ImageManager.ImageReceiver(ImageManager.this, localzab.uri);
        ImageManager.zae(ImageManager.this).put(localzab.uri, localObject1);
      }
      ((ImageManager.ImageReceiver)localObject1).zab(this.zamt);
      if (!(this.zamt instanceof zad)) {
        ImageManager.zaa(ImageManager.this).put(this.zamt, localObject1);
      }
      synchronized (ImageManager.zacc())
      {
        if (!ImageManager.zacd().contains(localzab.uri))
        {
          ImageManager.zacd().add(localzab.uri);
          ((ImageManager.ImageReceiver)localObject1).zace();
        }
        return;
      }
    }
  }
  
  private final class zad
    implements Runnable
  {
    private final Bitmap mBitmap;
    private final Uri mUri;
    private final CountDownLatch zadr;
    private boolean zamu;
    
    public zad(Uri paramUri, Bitmap paramBitmap, boolean paramBoolean, CountDownLatch paramCountDownLatch)
    {
      this.mUri = paramUri;
      this.mBitmap = paramBitmap;
      this.zamu = paramBoolean;
      this.zadr = paramCountDownLatch;
    }
    
    public final void run()
    {
      Asserts.checkMainThread("OnBitmapLoadedRunnable must be executed in the main thread");
      int i;
      if (this.mBitmap != null) {
        i = 1;
      } else {
        i = 0;
      }
      if (ImageManager.zah(ImageManager.this) != null)
      {
        if (this.zamu)
        {
          ImageManager.zah(ImageManager.this).evictAll();
          System.gc();
          this.zamu = false;
          ImageManager.zag(ImageManager.this).post(this);
          return;
        }
        if (i != 0) {
          ImageManager.zah(ImageManager.this).put(new zab(this.mUri), this.mBitmap);
        }
      }
      ??? = (ImageManager.ImageReceiver)ImageManager.zae(ImageManager.this).remove(this.mUri);
      if (??? != null)
      {
        ArrayList localArrayList = ImageManager.ImageReceiver.zaa((ImageManager.ImageReceiver)???);
        int j = localArrayList.size();
        for (int k = 0; k < j; k++)
        {
          ??? = (zaa)localArrayList.get(k);
          if (i != 0)
          {
            ((zaa)???).zaa(ImageManager.zab(ImageManager.this), this.mBitmap, false);
          }
          else
          {
            ImageManager.zad(ImageManager.this).put(this.mUri, Long.valueOf(SystemClock.elapsedRealtime()));
            ((zaa)???).zaa(ImageManager.zab(ImageManager.this), ImageManager.zac(ImageManager.this), false);
          }
          if (!(??? instanceof zad)) {
            ImageManager.zaa(ImageManager.this).remove(???);
          }
        }
      }
      this.zadr.countDown();
      synchronized (ImageManager.zacc())
      {
        ImageManager.zacd().remove(this.mUri);
        return;
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\images\ImageManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */