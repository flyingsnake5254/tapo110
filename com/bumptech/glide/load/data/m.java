package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import androidx.annotation.NonNull;
import java.io.IOException;
import java.io.InputStream;

public class m
  extends b<InputStream>
{
  public m(AssetManager paramAssetManager, String paramString)
  {
    super(paramAssetManager, paramString);
  }
  
  @NonNull
  public Class<InputStream> a()
  {
    return InputStream.class;
  }
  
  protected void g(InputStream paramInputStream)
    throws IOException
  {
    paramInputStream.close();
  }
  
  protected InputStream h(AssetManager paramAssetManager, String paramString)
    throws IOException
  {
    return paramAssetManager.open(paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\data\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */