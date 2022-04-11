package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.ParcelFileDescriptor;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.data.k;
import com.bumptech.glide.util.i;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

abstract interface q
{
  @Nullable
  public abstract Bitmap a(BitmapFactory.Options paramOptions)
    throws IOException;
  
  public abstract void b();
  
  public abstract int c()
    throws IOException;
  
  public abstract ImageHeaderParser.ImageType d()
    throws IOException;
  
  public static final class a
    implements q
  {
    private final k a;
    private final com.bumptech.glide.load.engine.z.b b;
    private final List<ImageHeaderParser> c;
    
    a(InputStream paramInputStream, List<ImageHeaderParser> paramList, com.bumptech.glide.load.engine.z.b paramb)
    {
      this.b = ((com.bumptech.glide.load.engine.z.b)i.d(paramb));
      this.c = ((List)i.d(paramList));
      this.a = new k(paramInputStream, paramb);
    }
    
    @Nullable
    public Bitmap a(BitmapFactory.Options paramOptions)
      throws IOException
    {
      return BitmapFactory.decodeStream(this.a.d(), null, paramOptions);
    }
    
    public void b()
    {
      this.a.c();
    }
    
    public int c()
      throws IOException
    {
      return com.bumptech.glide.load.b.b(this.c, this.a.d(), this.b);
    }
    
    public ImageHeaderParser.ImageType d()
      throws IOException
    {
      return com.bumptech.glide.load.b.e(this.c, this.a.d(), this.b);
    }
  }
  
  @RequiresApi(21)
  public static final class b
    implements q
  {
    private final com.bumptech.glide.load.engine.z.b a;
    private final List<ImageHeaderParser> b;
    private final ParcelFileDescriptorRewinder c;
    
    b(ParcelFileDescriptor paramParcelFileDescriptor, List<ImageHeaderParser> paramList, com.bumptech.glide.load.engine.z.b paramb)
    {
      this.a = ((com.bumptech.glide.load.engine.z.b)i.d(paramb));
      this.b = ((List)i.d(paramList));
      this.c = new ParcelFileDescriptorRewinder(paramParcelFileDescriptor);
    }
    
    @Nullable
    public Bitmap a(BitmapFactory.Options paramOptions)
      throws IOException
    {
      return BitmapFactory.decodeFileDescriptor(this.c.d().getFileDescriptor(), null, paramOptions);
    }
    
    public void b() {}
    
    public int c()
      throws IOException
    {
      return com.bumptech.glide.load.b.a(this.b, this.c, this.a);
    }
    
    public ImageHeaderParser.ImageType d()
      throws IOException
    {
      return com.bumptech.glide.load.b.d(this.b, this.c, this.a);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\resource\bitmap\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */