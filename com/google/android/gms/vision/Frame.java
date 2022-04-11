package com.google.android.gms.vision;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.Image.Plane;
import androidx.annotation.RequiresApi;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

public class Frame
{
  public static final int ROTATION_0 = 0;
  public static final int ROTATION_180 = 2;
  public static final int ROTATION_270 = 3;
  public static final int ROTATION_90 = 1;
  private final Metadata zzao = new Metadata();
  @Nullable
  private ByteBuffer zzap = null;
  @Nullable
  @RequiresApi(19)
  private zza zzaq = null;
  @Nullable
  private Bitmap zzar = null;
  
  public Bitmap getBitmap()
  {
    return this.zzar;
  }
  
  public ByteBuffer getGrayscaleImageData()
  {
    Object localObject = this.zzar;
    if (localObject != null)
    {
      int i = ((Bitmap)localObject).getWidth();
      int j = this.zzar.getHeight();
      int k = i * j;
      int[] arrayOfInt = new int[k];
      this.zzar.getPixels(arrayOfInt, 0, i, 0, 0, i, j);
      localObject = new byte[k];
      for (j = 0; j < k; j++) {
        localObject[j] = ((byte)(byte)(int)(Color.red(arrayOfInt[j]) * 0.299F + Color.green(arrayOfInt[j]) * 0.587F + Color.blue(arrayOfInt[j]) * 0.114F));
      }
      return ByteBuffer.wrap((byte[])localObject);
    }
    return this.zzap;
  }
  
  public Metadata getMetadata()
  {
    return this.zzao;
  }
  
  @Nullable
  @RequiresApi(19)
  @KeepForSdk
  public Image.Plane[] getPlanes()
  {
    zza localzza = this.zzaq;
    if (localzza == null) {
      return null;
    }
    return localzza.getPlanes();
  }
  
  public static class Builder
  {
    private final Frame zzax = new Frame(null);
    
    public Frame build()
    {
      if ((Frame.zza(this.zzax) == null) && (Frame.zzb(this.zzax) == null) && (Frame.zzc(this.zzax) == null)) {
        throw new IllegalStateException("Missing image data.  Call either setBitmap or setImageData to specify the image");
      }
      return this.zzax;
    }
    
    public Builder setBitmap(Bitmap paramBitmap)
    {
      int i = paramBitmap.getWidth();
      int j = paramBitmap.getHeight();
      Frame.zza(this.zzax, paramBitmap);
      paramBitmap = this.zzax.getMetadata();
      Frame.Metadata.zza(paramBitmap, i);
      Frame.Metadata.zzb(paramBitmap, j);
      return this;
    }
    
    public Builder setId(int paramInt)
    {
      Frame.Metadata.zzd(this.zzax.getMetadata(), paramInt);
      return this;
    }
    
    public Builder setImageData(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3)
    {
      if (paramByteBuffer != null)
      {
        if (paramByteBuffer.capacity() >= paramInt1 * paramInt2)
        {
          if ((paramInt3 != 16) && (paramInt3 != 17) && (paramInt3 != 842094169))
          {
            paramByteBuffer = new StringBuilder(37);
            paramByteBuffer.append("Unsupported image format: ");
            paramByteBuffer.append(paramInt3);
            throw new IllegalArgumentException(paramByteBuffer.toString());
          }
          Frame.zza(this.zzax, paramByteBuffer);
          paramByteBuffer = this.zzax.getMetadata();
          Frame.Metadata.zza(paramByteBuffer, paramInt1);
          Frame.Metadata.zzb(paramByteBuffer, paramInt2);
          Frame.Metadata.zzc(paramByteBuffer, paramInt3);
          return this;
        }
        throw new IllegalArgumentException("Invalid image data size.");
      }
      throw new IllegalArgumentException("Null image data supplied.");
    }
    
    @RequiresApi(19)
    @KeepForSdk
    public Builder setPlanes(Image.Plane[] paramArrayOfPlane, int paramInt1, int paramInt2, int paramInt3)
    {
      if (paramArrayOfPlane != null)
      {
        if (paramArrayOfPlane.length == 3)
        {
          if (paramArrayOfPlane[0].getBuffer().capacity() >= paramInt1 * paramInt2)
          {
            Frame.zza(this.zzax, new Frame.zza(paramArrayOfPlane));
            paramArrayOfPlane = this.zzax.getMetadata();
            Frame.Metadata.zza(paramArrayOfPlane, paramInt1);
            Frame.Metadata.zzb(paramArrayOfPlane, paramInt2);
            Frame.Metadata.zzc(paramArrayOfPlane, paramInt3);
            return this;
          }
          throw new IllegalArgumentException("Invalid image data size.");
        }
        throw new IllegalArgumentException("Only android.graphics.ImageFormat#YUV_420_888 is supported which should have 3 planes.");
      }
      throw new IllegalArgumentException("Null image data supplied.");
    }
    
    public Builder setRotation(int paramInt)
    {
      Frame.Metadata.zze(this.zzax.getMetadata(), paramInt);
      return this;
    }
    
    public Builder setTimestampMillis(long paramLong)
    {
      Frame.Metadata.zza(this.zzax.getMetadata(), paramLong);
      return this;
    }
  }
  
  public static class Metadata
  {
    private int format = -1;
    private int height;
    private int id;
    private int rotation;
    private int width;
    private long zzaz;
    
    public Metadata() {}
    
    public Metadata(Metadata paramMetadata)
    {
      this.width = paramMetadata.getWidth();
      this.height = paramMetadata.getHeight();
      this.id = paramMetadata.getId();
      this.zzaz = paramMetadata.getTimestampMillis();
      this.rotation = paramMetadata.getRotation();
      this.format = paramMetadata.getFormat();
    }
    
    public int getFormat()
    {
      return this.format;
    }
    
    public int getHeight()
    {
      return this.height;
    }
    
    public int getId()
    {
      return this.id;
    }
    
    public int getRotation()
    {
      return this.rotation;
    }
    
    public long getTimestampMillis()
    {
      return this.zzaz;
    }
    
    public int getWidth()
    {
      return this.width;
    }
    
    public final void zze()
    {
      if (this.rotation % 2 != 0)
      {
        int i = this.width;
        this.width = this.height;
        this.height = i;
      }
      this.rotation = 0;
    }
  }
  
  static final class zza
  {
    private final Image.Plane[] zzay;
    
    zza(Image.Plane[] paramArrayOfPlane)
    {
      this.zzay = paramArrayOfPlane;
    }
    
    final Image.Plane[] getPlanes()
    {
      return this.zzay;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\vision\Frame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */