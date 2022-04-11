package com.tplink.iot.view.feedback;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore.Audio.Media;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;

public class d
{
  public static String a(Context paramContext, Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    Object localObject = null;
    try
    {
      paramUri = paramContext.getContentResolver().query(paramUri, new String[] { "_data" }, paramString, paramArrayOfString, null);
      if (paramUri != null) {
        try
        {
          if (paramUri.moveToFirst())
          {
            paramContext = paramUri.getString(paramUri.getColumnIndexOrThrow("_data"));
            paramUri.close();
            return paramContext;
          }
        }
        finally
        {
          break label80;
        }
      }
      if (paramUri != null) {
        paramUri.close();
      }
      return null;
    }
    finally
    {
      paramUri = (Uri)localObject;
      label80:
      if (paramUri != null) {
        paramUri.close();
      }
    }
  }
  
  @TargetApi(19)
  public static String b(Context paramContext, Uri paramUri)
  {
    int i;
    if (Build.VERSION.SDK_INT >= 19) {
      i = 1;
    } else {
      i = 0;
    }
    Object localObject = null;
    if ((i != 0) && (DocumentsContract.isDocumentUri(paramContext, paramUri)))
    {
      if (d(paramUri))
      {
        paramContext = DocumentsContract.getDocumentId(paramUri).split(":");
        if ("primary".equalsIgnoreCase(paramContext[0]))
        {
          paramUri = new StringBuilder();
          paramUri.append(Environment.getExternalStorageDirectory());
          paramUri.append("/");
          paramUri.append(paramContext[1]);
          return paramUri.toString();
        }
      }
      else
      {
        if (c(paramUri))
        {
          paramUri = DocumentsContract.getDocumentId(paramUri);
          return a(paramContext, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(paramUri).longValue()), null, null);
        }
        if (f(paramUri))
        {
          String[] arrayOfString = DocumentsContract.getDocumentId(paramUri).split(":");
          String str = arrayOfString[0];
          if ("image".equals(str))
          {
            paramUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
          }
          else if ("video".equals(str))
          {
            paramUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
          }
          else
          {
            paramUri = (Uri)localObject;
            if ("audio".equals(str)) {
              paramUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            }
          }
          return a(paramContext, paramUri, "_id=?", new String[] { arrayOfString[1] });
        }
      }
    }
    else
    {
      if ("content".equalsIgnoreCase(paramUri.getScheme()))
      {
        if (e(paramUri)) {
          return paramUri.getLastPathSegment();
        }
        return a(paramContext, paramUri, null, null);
      }
      if ("file".equalsIgnoreCase(paramUri.getScheme())) {
        return paramUri.getPath();
      }
    }
    return null;
  }
  
  public static boolean c(Uri paramUri)
  {
    return "com.android.providers.downloads.documents".equals(paramUri.getAuthority());
  }
  
  public static boolean d(Uri paramUri)
  {
    return "com.android.externalstorage.documents".equals(paramUri.getAuthority());
  }
  
  public static boolean e(Uri paramUri)
  {
    return "com.google.android.apps.photos.content".equals(paramUri.getAuthority());
  }
  
  public static boolean f(Uri paramUri)
  {
    return "com.android.providers.media.documents".equals(paramUri.getAuthority());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\feedback\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */