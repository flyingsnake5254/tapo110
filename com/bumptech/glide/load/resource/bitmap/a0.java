package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.e.b;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.g;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public class a0<T>
  implements g<T, Bitmap>
{
  public static final com.bumptech.glide.load.e<Long> a = com.bumptech.glide.load.e.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", Long.valueOf(-1L), new a());
  public static final com.bumptech.glide.load.e<Integer> b = com.bumptech.glide.load.e.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", Integer.valueOf(2), new b());
  private static final e c = new e();
  private final f<T> d;
  private final com.bumptech.glide.load.engine.z.e e;
  private final e f;
  
  a0(com.bumptech.glide.load.engine.z.e parame, f<T> paramf)
  {
    this(parame, paramf, c);
  }
  
  @VisibleForTesting
  a0(com.bumptech.glide.load.engine.z.e parame, f<T> paramf, e parame1)
  {
    this.e = parame;
    this.d = paramf;
    this.f = parame1;
  }
  
  public static g<AssetFileDescriptor, Bitmap> c(com.bumptech.glide.load.engine.z.e parame)
  {
    return new a0(parame, new c(null));
  }
  
  @RequiresApi(api=23)
  public static g<ByteBuffer, Bitmap> d(com.bumptech.glide.load.engine.z.e parame)
  {
    return new a0(parame, new d());
  }
  
  @Nullable
  private static Bitmap e(MediaMetadataRetriever paramMediaMetadataRetriever, long paramLong, int paramInt1, int paramInt2, int paramInt3, DownsampleStrategy paramDownsampleStrategy)
  {
    if ((Build.VERSION.SDK_INT >= 27) && (paramInt2 != Integer.MIN_VALUE) && (paramInt3 != Integer.MIN_VALUE) && (paramDownsampleStrategy != DownsampleStrategy.f)) {
      paramDownsampleStrategy = g(paramMediaMetadataRetriever, paramLong, paramInt1, paramInt2, paramInt3, paramDownsampleStrategy);
    } else {
      paramDownsampleStrategy = null;
    }
    Object localObject = paramDownsampleStrategy;
    if (paramDownsampleStrategy == null) {
      localObject = f(paramMediaMetadataRetriever, paramLong, paramInt1);
    }
    if (localObject != null) {
      return (Bitmap)localObject;
    }
    throw new h();
  }
  
  private static Bitmap f(MediaMetadataRetriever paramMediaMetadataRetriever, long paramLong, int paramInt)
  {
    return paramMediaMetadataRetriever.getFrameAtTime(paramLong, paramInt);
  }
  
  @TargetApi(27)
  @Nullable
  private static Bitmap g(MediaMetadataRetriever paramMediaMetadataRetriever, long paramLong, int paramInt1, int paramInt2, int paramInt3, DownsampleStrategy paramDownsampleStrategy)
  {
    try
    {
      int i = Integer.parseInt(paramMediaMetadataRetriever.extractMetadata(18));
      int j = Integer.parseInt(paramMediaMetadataRetriever.extractMetadata(19));
      int k = Integer.parseInt(paramMediaMetadataRetriever.extractMetadata(24));
      int m;
      int n;
      if (k != 90)
      {
        m = i;
        n = j;
        if (k != 270) {}
      }
      else
      {
        n = i;
        m = j;
      }
      float f1 = paramDownsampleStrategy.b(m, n, paramInt2, paramInt3);
      paramMediaMetadataRetriever = paramMediaMetadataRetriever.getScaledFrameAtTime(paramLong, paramInt1, Math.round(m * f1), Math.round(f1 * n));
      return paramMediaMetadataRetriever;
    }
    finally
    {
      if (Log.isLoggable("VideoDecoder", 3)) {
        Log.d("VideoDecoder", "Exception trying to decode a scaled frame on oreo+, falling back to a fullsize frame", paramMediaMetadataRetriever);
      }
    }
    return null;
  }
  
  public static g<ParcelFileDescriptor, Bitmap> h(com.bumptech.glide.load.engine.z.e parame)
  {
    return new a0(parame, new g());
  }
  
  public boolean a(@NonNull T paramT, @NonNull f paramf)
  {
    return true;
  }
  
  public u<Bitmap> b(@NonNull T paramT, int paramInt1, int paramInt2, @NonNull f paramf)
    throws IOException
  {
    long l = ((Long)paramf.c(a)).longValue();
    if ((l < 0L) && (l != -1L))
    {
      paramT = new StringBuilder();
      paramT.append("Requested frame must be non-negative, or DEFAULT_FRAME, given: ");
      paramT.append(l);
      throw new IllegalArgumentException(paramT.toString());
    }
    Object localObject1 = (Integer)paramf.c(b);
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = Integer.valueOf(2);
    }
    localObject1 = (DownsampleStrategy)paramf.c(DownsampleStrategy.h);
    paramf = (f)localObject1;
    if (localObject1 == null) {
      paramf = DownsampleStrategy.g;
    }
    localObject1 = this.f.a();
    try
    {
      this.d.a((MediaMetadataRetriever)localObject1, paramT);
      paramT = e((MediaMetadataRetriever)localObject1, l, ((Integer)localObject2).intValue(), paramInt1, paramInt2, paramf);
      return e.f(paramT, this.e);
    }
    finally
    {
      ((MediaMetadataRetriever)localObject1).release();
    }
  }
  
  class a
    implements e.b<Long>
  {
    private final ByteBuffer a = ByteBuffer.allocate(8);
    
    public void b(@NonNull byte[] arg1, @NonNull Long paramLong, @NonNull MessageDigest paramMessageDigest)
    {
      paramMessageDigest.update(???);
      synchronized (this.a)
      {
        this.a.position(0);
        paramMessageDigest.update(this.a.putLong(paramLong.longValue()).array());
        return;
      }
    }
  }
  
  class b
    implements e.b<Integer>
  {
    private final ByteBuffer a = ByteBuffer.allocate(4);
    
    public void b(@NonNull byte[] arg1, @NonNull Integer paramInteger, @NonNull MessageDigest paramMessageDigest)
    {
      if (paramInteger == null) {
        return;
      }
      paramMessageDigest.update(???);
      synchronized (this.a)
      {
        this.a.position(0);
        paramMessageDigest.update(this.a.putInt(paramInteger.intValue()).array());
        return;
      }
    }
  }
  
  private static final class c
    implements a0.f<AssetFileDescriptor>
  {
    public void b(MediaMetadataRetriever paramMediaMetadataRetriever, AssetFileDescriptor paramAssetFileDescriptor)
    {
      paramMediaMetadataRetriever.setDataSource(paramAssetFileDescriptor.getFileDescriptor(), paramAssetFileDescriptor.getStartOffset(), paramAssetFileDescriptor.getLength());
    }
  }
  
  @RequiresApi(23)
  static final class d
    implements a0.f<ByteBuffer>
  {
    public void b(MediaMetadataRetriever paramMediaMetadataRetriever, final ByteBuffer paramByteBuffer)
    {
      paramMediaMetadataRetriever.setDataSource(new a(paramByteBuffer));
    }
    
    class a
      extends MediaDataSource
    {
      a(ByteBuffer paramByteBuffer) {}
      
      public void close() {}
      
      public long getSize()
      {
        return paramByteBuffer.limit();
      }
      
      public int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      {
        if (paramLong >= paramByteBuffer.limit()) {
          return -1;
        }
        paramByteBuffer.position((int)paramLong);
        paramInt2 = Math.min(paramInt2, paramByteBuffer.remaining());
        paramByteBuffer.get(paramArrayOfByte, paramInt1, paramInt2);
        return paramInt2;
      }
    }
  }
  
  @VisibleForTesting
  static class e
  {
    public MediaMetadataRetriever a()
    {
      return new MediaMetadataRetriever();
    }
  }
  
  @VisibleForTesting
  static abstract interface f<T>
  {
    public abstract void a(MediaMetadataRetriever paramMediaMetadataRetriever, T paramT);
  }
  
  static final class g
    implements a0.f<ParcelFileDescriptor>
  {
    public void b(MediaMetadataRetriever paramMediaMetadataRetriever, ParcelFileDescriptor paramParcelFileDescriptor)
    {
      paramMediaMetadataRetriever.setDataSource(paramParcelFileDescriptor.getFileDescriptor());
    }
  }
  
  private static final class h
    extends RuntimeException
  {
    h()
    {
      super();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\resource\bitmap\a0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */