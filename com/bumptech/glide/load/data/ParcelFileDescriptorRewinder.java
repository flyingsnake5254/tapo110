package com.bumptech.glide.load.data;

import android.os.Build.VERSION;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.io.IOException;

public final class ParcelFileDescriptorRewinder
  implements e<ParcelFileDescriptor>
{
  private final InternalRewinder a;
  
  @RequiresApi(21)
  public ParcelFileDescriptorRewinder(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    this.a = new InternalRewinder(paramParcelFileDescriptor);
  }
  
  public static boolean c()
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 21) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void b() {}
  
  @NonNull
  @RequiresApi(21)
  public ParcelFileDescriptor d()
    throws IOException
  {
    return this.a.rewind();
  }
  
  @RequiresApi(21)
  private static final class InternalRewinder
  {
    private final ParcelFileDescriptor a;
    
    InternalRewinder(ParcelFileDescriptor paramParcelFileDescriptor)
    {
      this.a = paramParcelFileDescriptor;
    }
    
    ParcelFileDescriptor rewind()
      throws IOException
    {
      try
      {
        Os.lseek(this.a.getFileDescriptor(), 0L, OsConstants.SEEK_SET);
        return this.a;
      }
      catch (ErrnoException localErrnoException)
      {
        throw new IOException(localErrnoException);
      }
    }
  }
  
  @RequiresApi(21)
  public static final class a
    implements e.a<ParcelFileDescriptor>
  {
    @NonNull
    public Class<ParcelFileDescriptor> a()
    {
      return ParcelFileDescriptor.class;
    }
    
    @NonNull
    public e<ParcelFileDescriptor> c(@NonNull ParcelFileDescriptor paramParcelFileDescriptor)
    {
      return new ParcelFileDescriptorRewinder(paramParcelFileDescriptor);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\data\ParcelFileDescriptorRewinder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */