package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import androidx.annotation.NonNull;
import java.io.FileNotFoundException;
import java.io.IOException;

public final class a
  extends l<AssetFileDescriptor>
{
  public a(ContentResolver paramContentResolver, Uri paramUri)
  {
    super(paramContentResolver, paramUri);
  }
  
  @NonNull
  public Class<AssetFileDescriptor> a()
  {
    return AssetFileDescriptor.class;
  }
  
  protected void g(AssetFileDescriptor paramAssetFileDescriptor)
    throws IOException
  {
    paramAssetFileDescriptor.close();
  }
  
  protected AssetFileDescriptor h(Uri paramUri, ContentResolver paramContentResolver)
    throws FileNotFoundException
  {
    paramContentResolver = paramContentResolver.openAssetFileDescriptor(paramUri, "r");
    if (paramContentResolver != null) {
      return paramContentResolver;
    }
    paramContentResolver = new StringBuilder();
    paramContentResolver.append("FileDescriptor is null for: ");
    paramContentResolver.append(paramUri);
    throw new FileNotFoundException(paramContentResolver.toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\data\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */