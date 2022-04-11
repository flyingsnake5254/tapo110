package com.bumptech.glide.load.data;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import java.io.IOException;

public class h
  extends b<ParcelFileDescriptor>
{
  public h(AssetManager paramAssetManager, String paramString)
  {
    super(paramAssetManager, paramString);
  }
  
  @NonNull
  public Class<ParcelFileDescriptor> a()
  {
    return ParcelFileDescriptor.class;
  }
  
  protected void g(ParcelFileDescriptor paramParcelFileDescriptor)
    throws IOException
  {
    paramParcelFileDescriptor.close();
  }
  
  protected ParcelFileDescriptor h(AssetManager paramAssetManager, String paramString)
    throws IOException
  {
    return paramAssetManager.openFd(paramString).getParcelFileDescriptor();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\data\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */