package com.google.firebase.messaging;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_messaging.zzm;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Executor;

class ImageDownload
  implements Closeable
{
  @Nullable
  private volatile InputStream connectionInputStream;
  @Nullable
  private Task<Bitmap> task;
  private final URL url;
  
  private ImageDownload(URL paramURL)
  {
    this.url = paramURL;
  }
  
  /* Error */
  private byte[] blockingDownloadBytes()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 21	com/google/firebase/messaging/ImageDownload:url	Ljava/net/URL;
    //   4: invokevirtual 32	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   7: astore_1
    //   8: aload_1
    //   9: invokevirtual 38	java/net/URLConnection:getContentLength	()I
    //   12: ldc 39
    //   14: if_icmpgt +140 -> 154
    //   17: aload_1
    //   18: invokevirtual 43	java/net/URLConnection:getInputStream	()Ljava/io/InputStream;
    //   21: astore_2
    //   22: aload_0
    //   23: aload_2
    //   24: putfield 45	com/google/firebase/messaging/ImageDownload:connectionInputStream	Ljava/io/InputStream;
    //   27: aload_2
    //   28: ldc2_w 46
    //   31: invokestatic 53	com/google/android/gms/internal/firebase_messaging/zzl:zzb	(Ljava/io/InputStream;J)Ljava/io/InputStream;
    //   34: invokestatic 57	com/google/android/gms/internal/firebase_messaging/zzl:zza	(Ljava/io/InputStream;)[B
    //   37: astore_1
    //   38: aload_2
    //   39: ifnull +7 -> 46
    //   42: aload_2
    //   43: invokevirtual 62	java/io/InputStream:close	()V
    //   46: ldc 64
    //   48: iconst_2
    //   49: invokestatic 70	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   52: ifeq +63 -> 115
    //   55: aload_0
    //   56: getfield 21	com/google/firebase/messaging/ImageDownload:url	Ljava/net/URL;
    //   59: invokestatic 76	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   62: astore_3
    //   63: new 78	java/lang/StringBuilder
    //   66: dup
    //   67: aload_3
    //   68: invokevirtual 81	java/lang/String:length	()I
    //   71: bipush 34
    //   73: iadd
    //   74: invokespecial 84	java/lang/StringBuilder:<init>	(I)V
    //   77: astore_2
    //   78: aload_2
    //   79: ldc 86
    //   81: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload_2
    //   86: aload_1
    //   87: arraylength
    //   88: invokevirtual 93	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload_2
    //   93: ldc 95
    //   95: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload_2
    //   100: aload_3
    //   101: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: ldc 64
    //   107: aload_2
    //   108: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokestatic 103	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   114: pop
    //   115: aload_1
    //   116: arraylength
    //   117: ldc 39
    //   119: if_icmpgt +5 -> 124
    //   122: aload_1
    //   123: areturn
    //   124: new 26	java/io/IOException
    //   127: dup
    //   128: ldc 105
    //   130: invokespecial 108	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   133: athrow
    //   134: astore_1
    //   135: aload_2
    //   136: ifnull +16 -> 152
    //   139: aload_2
    //   140: invokevirtual 62	java/io/InputStream:close	()V
    //   143: goto +9 -> 152
    //   146: astore_2
    //   147: aload_1
    //   148: aload_2
    //   149: invokestatic 113	com/google/android/gms/internal/firebase_messaging/zzt:zza	(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    //   152: aload_1
    //   153: athrow
    //   154: new 26	java/io/IOException
    //   157: dup
    //   158: ldc 115
    //   160: invokespecial 108	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   163: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	this	ImageDownload
    //   7	116	1	localObject1	Object
    //   134	19	1	localThrowable1	Throwable
    //   21	119	2	localObject2	Object
    //   146	3	2	localThrowable2	Throwable
    //   62	39	3	str	String
    // Exception table:
    //   from	to	target	type
    //   22	38	134	finally
    //   139	143	146	finally
  }
  
  @Nullable
  public static ImageDownload create(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      Object localObject = new java/net/URL;
      ((URL)localObject).<init>(paramString);
      localObject = new ImageDownload((URL)localObject);
      return (ImageDownload)localObject;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {
        paramString = "Not downloading image, bad URL: ".concat(paramString);
      } else {
        paramString = new String("Not downloading image, bad URL: ");
      }
      Log.w("FirebaseMessaging", paramString);
    }
    return null;
  }
  
  public Bitmap blockingDownload()
    throws IOException
  {
    Object localObject1 = String.valueOf(this.url);
    Object localObject2 = new StringBuilder(((String)localObject1).length() + 22);
    ((StringBuilder)localObject2).append("Starting download of: ");
    ((StringBuilder)localObject2).append((String)localObject1);
    Log.i("FirebaseMessaging", ((StringBuilder)localObject2).toString());
    localObject1 = blockingDownloadBytes();
    Bitmap localBitmap = BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length);
    if (localBitmap != null)
    {
      if (Log.isLoggable("FirebaseMessaging", 3))
      {
        localObject2 = String.valueOf(this.url);
        localObject1 = new StringBuilder(((String)localObject2).length() + 31);
        ((StringBuilder)localObject1).append("Successfully downloaded image: ");
        ((StringBuilder)localObject1).append((String)localObject2);
        Log.d("FirebaseMessaging", ((StringBuilder)localObject1).toString());
      }
      return localBitmap;
    }
    localObject1 = String.valueOf(this.url);
    localObject2 = new StringBuilder(((String)localObject1).length() + 24);
    ((StringBuilder)localObject2).append("Failed to decode image: ");
    ((StringBuilder)localObject2).append((String)localObject1);
    throw new IOException(((StringBuilder)localObject2).toString());
  }
  
  public void close()
  {
    try
    {
      zzm.zza(this.connectionInputStream);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      Log.e("FirebaseMessaging", "Failed to close the image download stream.", localNullPointerException);
    }
  }
  
  public Task<Bitmap> getTask()
  {
    return (Task)Preconditions.checkNotNull(this.task);
  }
  
  public void start(Executor paramExecutor)
  {
    this.task = Tasks.call(paramExecutor, new ImageDownload..Lambda.0(this));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\messaging\ImageDownload.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */