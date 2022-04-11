package com.bumptech.glide.l;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.nio.ByteBuffer;

public abstract interface a
{
  @Nullable
  public abstract Bitmap a();
  
  public abstract void b();
  
  public abstract int c();
  
  public abstract void clear();
  
  public abstract void d(@NonNull Bitmap.Config paramConfig);
  
  public abstract int e();
  
  public abstract void f();
  
  public abstract int g();
  
  @NonNull
  public abstract ByteBuffer getData();
  
  public abstract int h();
  
  public static abstract interface a
  {
    public abstract void a(@NonNull Bitmap paramBitmap);
    
    @NonNull
    public abstract byte[] b(int paramInt);
    
    @NonNull
    public abstract Bitmap c(int paramInt1, int paramInt2, @NonNull Bitmap.Config paramConfig);
    
    @NonNull
    public abstract int[] d(int paramInt);
    
    public abstract void e(@NonNull byte[] paramArrayOfByte);
    
    public abstract void f(@NonNull int[] paramArrayOfInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\l\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */