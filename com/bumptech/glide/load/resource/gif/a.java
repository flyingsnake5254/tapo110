package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.i;
import com.bumptech.glide.util.j;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

public class a
  implements g<ByteBuffer, GifDrawable>
{
  private static final a a = new a();
  private static final b b = new b();
  private final Context c;
  private final List<ImageHeaderParser> d;
  private final b e;
  private final a f;
  private final b g;
  
  public a(Context paramContext, List<ImageHeaderParser> paramList, com.bumptech.glide.load.engine.z.e parame, com.bumptech.glide.load.engine.z.b paramb)
  {
    this(paramContext, paramList, parame, paramb, b, a);
  }
  
  @VisibleForTesting
  a(Context paramContext, List<ImageHeaderParser> paramList, com.bumptech.glide.load.engine.z.e parame, com.bumptech.glide.load.engine.z.b paramb, b paramb1, a parama)
  {
    this.c = paramContext.getApplicationContext();
    this.d = paramList;
    this.f = parama;
    this.g = new b(parame, paramb);
    this.e = paramb1;
  }
  
  @Nullable
  private d c(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, com.bumptech.glide.l.d paramd, f paramf)
  {
    long l = com.bumptech.glide.util.e.b();
    try
    {
      Object localObject = paramd.c();
      if ((((com.bumptech.glide.l.c)localObject).b() > 0) && (((com.bumptech.glide.l.c)localObject).c() == 0))
      {
        if (paramf.c(h.a) == DecodeFormat.PREFER_RGB_565) {
          paramd = Bitmap.Config.RGB_565;
        } else {
          paramd = Bitmap.Config.ARGB_8888;
        }
        int i = e((com.bumptech.glide.l.c)localObject, paramInt1, paramInt2);
        paramByteBuffer = this.f.a(this.g, (com.bumptech.glide.l.c)localObject, paramByteBuffer, i);
        paramByteBuffer.d(paramd);
        paramByteBuffer.b();
        paramd = paramByteBuffer.a();
        if (paramd == null) {
          return null;
        }
        localObject = com.bumptech.glide.load.k.c.c();
        paramf = new com/bumptech/glide/load/resource/gif/GifDrawable;
        paramf.<init>(this.c, paramByteBuffer, (i)localObject, paramInt1, paramInt2, paramd);
        paramd = new d(paramf);
        return paramd;
      }
      return null;
    }
    finally
    {
      if (Log.isLoggable("BufferGifDecoder", 2))
      {
        paramByteBuffer = new StringBuilder();
        paramByteBuffer.append("Decoded GIF from stream in ");
        paramByteBuffer.append(com.bumptech.glide.util.e.a(l));
        Log.v("BufferGifDecoder", paramByteBuffer.toString());
      }
    }
  }
  
  private static int e(com.bumptech.glide.l.c paramc, int paramInt1, int paramInt2)
  {
    int i = Math.min(paramc.a() / paramInt2, paramc.d() / paramInt1);
    if (i == 0) {
      i = 0;
    } else {
      i = Integer.highestOneBit(i);
    }
    i = Math.max(1, i);
    if ((Log.isLoggable("BufferGifDecoder", 2)) && (i > 1))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Downsampling GIF, sampleSize: ");
      localStringBuilder.append(i);
      localStringBuilder.append(", target dimens: [");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("x");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("], actual dimens: [");
      localStringBuilder.append(paramc.d());
      localStringBuilder.append("x");
      localStringBuilder.append(paramc.a());
      localStringBuilder.append("]");
      Log.v("BufferGifDecoder", localStringBuilder.toString());
    }
    return i;
  }
  
  public d d(@NonNull ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, @NonNull f paramf)
  {
    com.bumptech.glide.l.d locald = this.e.a(paramByteBuffer);
    try
    {
      paramByteBuffer = c(paramByteBuffer, paramInt1, paramInt2, locald, paramf);
      return paramByteBuffer;
    }
    finally
    {
      this.e.b(locald);
    }
  }
  
  public boolean f(@NonNull ByteBuffer paramByteBuffer, @NonNull f paramf)
    throws IOException
  {
    boolean bool;
    if ((!((Boolean)paramf.c(h.b)).booleanValue()) && (com.bumptech.glide.load.b.f(this.d, paramByteBuffer) == ImageHeaderParser.ImageType.GIF)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @VisibleForTesting
  static class a
  {
    com.bumptech.glide.l.a a(com.bumptech.glide.l.a.a parama, com.bumptech.glide.l.c paramc, ByteBuffer paramByteBuffer, int paramInt)
    {
      return new com.bumptech.glide.l.e(parama, paramc, paramByteBuffer, paramInt);
    }
  }
  
  @VisibleForTesting
  static class b
  {
    private final Queue<com.bumptech.glide.l.d> a = j.f(0);
    
    com.bumptech.glide.l.d a(ByteBuffer paramByteBuffer)
    {
      try
      {
        com.bumptech.glide.l.d locald1 = (com.bumptech.glide.l.d)this.a.poll();
        com.bumptech.glide.l.d locald2 = locald1;
        if (locald1 == null)
        {
          locald2 = new com/bumptech/glide/l/d;
          locald2.<init>();
        }
        paramByteBuffer = locald2.p(paramByteBuffer);
        return paramByteBuffer;
      }
      finally {}
    }
    
    void b(com.bumptech.glide.l.d paramd)
    {
      try
      {
        paramd.a();
        this.a.offer(paramd);
        return;
      }
      finally
      {
        paramd = finally;
        throw paramd;
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\resource\gif\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */