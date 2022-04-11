package b.d.q.b.p;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.os.StatFs;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import b.d.q.b.j;
import b.d.q.b.l;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang.e;

public class b
{
  private static final String a = "b";
  private static Context b;
  
  private static String b()
  {
    Object localObject = g();
    if (e.a((String)localObject)) {
      return "";
    }
    localObject = new File((String)localObject, "avatar");
    boolean bool = true;
    if (!((File)localObject).exists()) {
      bool = ((File)localObject).mkdir();
    }
    if (bool) {
      return ((File)localObject).getAbsolutePath();
    }
    return "";
  }
  
  public static String c(String paramString)
  {
    Object localObject = b();
    if (e.a((String)localObject)) {
      return "";
    }
    localObject = new File((String)localObject, "device_avatar");
    boolean bool = true;
    if (!((File)localObject).exists()) {
      bool = ((File)localObject).mkdir();
    }
    paramString = new File(((File)localObject).getPath(), paramString);
    if (!paramString.exists()) {
      bool = paramString.mkdir();
    }
    if (bool) {
      return paramString.getAbsolutePath();
    }
    return "";
  }
  
  public static String d()
  {
    Object localObject = b();
    if (e.a((String)localObject)) {
      return "";
    }
    localObject = new File((String)localObject, "device_crop_avatar");
    boolean bool = true;
    if (!((File)localObject).exists()) {
      bool = ((File)localObject).mkdir();
    }
    if (bool) {
      return ((File)localObject).getAbsolutePath();
    }
    return "";
  }
  
  public static boolean e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return new File(paramString).exists();
  }
  
  public static String f()
  {
    Object localObject = g();
    if (e.a((String)localObject)) {
      return "";
    }
    localObject = new File((String)localObject, "preset");
    boolean bool = true;
    if (!((File)localObject).exists()) {
      bool = ((File)localObject).mkdir();
    }
    if (bool) {
      return ((File)localObject).getAbsolutePath();
    }
    return "";
  }
  
  private static String g()
  {
    File localFile = b.getExternalFilesDir("");
    if (localFile != null) {
      return localFile.getPath();
    }
    return "";
  }
  
  public static String h()
  {
    Object localObject = g();
    if (e.a((String)localObject)) {
      return "";
    }
    localObject = new File((String)localObject, "memory");
    boolean bool = true;
    if (!((File)localObject).exists()) {
      bool = ((File)localObject).mkdir();
    }
    if (bool) {
      return ((File)localObject).getAbsolutePath();
    }
    return "";
  }
  
  public static void i(Context paramContext, final String paramString1, final String paramString2, String paramString3, final d paramd)
  {
    paramString1 = c(paramString1);
    if (e.a(paramString1))
    {
      if (paramd != null) {
        paramd.b("failed to create directory.");
      }
      return;
    }
    Object localObject1 = new File(d().concat(File.separator).concat(paramString2).concat(".png"));
    if (!((File)localObject1).exists())
    {
      if (paramd != null) {
        paramd.b("failed to create directory.");
      }
      return;
    }
    Object localObject2 = new File(paramString1);
    if ((((File)localObject2).listFiles() != null) && (((File)localObject2).listFiles().length > 0))
    {
      localObject2 = new ArrayList(Arrays.asList(((File)localObject2).listFiles())).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((File)((Iterator)localObject2).next()).delete();
      }
    }
    localObject1 = ((File)localObject1).getPath();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramString3);
    ((StringBuilder)localObject2).append(paramString2);
    ((StringBuilder)localObject2).append(".png");
    l((String)localObject1, paramString1, ((StringBuilder)localObject2).toString(), new a(paramContext, paramString1, paramString2, paramd));
  }
  
  private static void j(File paramFile1, final File paramFile2, final d paramd)
  {
    if (!paramFile1.exists())
    {
      if (paramd != null) {
        paramd.b("file not exists");
      }
      return;
    }
    new Thread(new b(paramFile1, paramFile2, paramd)).start();
  }
  
  private static void k(String paramString, File paramFile)
    throws IOException
  {
    paramFile = new FileOutputStream(paramFile, true);
    Object localObject = new File(paramString);
    paramString = new FileInputStream((File)localObject);
    long l1 = ((File)localObject).length();
    localObject = new byte[524288];
    int i;
    for (long l2 = 0L; l2 < l1; l2 += i)
    {
      i = paramString.read((byte[])localObject);
      if (i == -1) {
        break;
      }
      paramFile.write((byte[])localObject, 0, i);
    }
    paramString.close();
    paramFile.flush();
    paramFile.close();
  }
  
  private static void l(String paramString1, String paramString2, String paramString3, d paramd)
  {
    if (e.a(paramString2))
    {
      if (paramd != null) {
        paramd.b("failed to create destination directory.");
      }
      return;
    }
    File localFile = new File(paramString2, paramString3);
    if (localFile.exists()) {
      localFile.delete();
    }
    j(new File(paramString1), new File(paramString2, paramString3), paramd);
  }
  
  private static void m(String paramString1, String paramString2)
  {
    try
    {
      File localFile = new java/io/File;
      Object localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>();
      ((StringBuilder)localObject).append(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath());
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append("Tapo");
      localFile.<init>(((StringBuilder)localObject).toString());
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      localObject = new java/io/File;
      ((File)localObject).<init>(localFile, paramString2);
      k(paramString1, (File)localObject);
      boolean bool = paramString2.endsWith(".mp4");
      if (bool)
      {
        paramString1 = new android/content/ContentValues;
        paramString1.<init>();
        paramString1.put("mime_type", "video/*");
        paramString1.put("_display_name", paramString2);
        paramString1.put("_data", ((File)localObject).getAbsolutePath());
        int i = p(((File)localObject).getAbsolutePath());
        if (i > 0) {
          paramString1.put("duration", Integer.valueOf(i));
        }
        b.getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, paramString1);
      }
      else
      {
        paramString1 = new android/content/ContentValues;
        paramString1.<init>();
        paramString1.put("mime_type", "image/*");
        paramString1.put("_display_name", paramString2);
        paramString1.put("_data", ((File)localObject).getAbsolutePath());
        b.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, paramString1);
      }
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
    }
    catch (FileNotFoundException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public static String n()
  {
    String str2;
    try
    {
      String str1 = b.getPackageName();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      str2 = null;
    }
    String str3 = str2;
    if (e.a(str2)) {
      str3 = "com.tplink.decosmart";
    }
    return str3;
  }
  
  public static final long o()
  {
    Object localObject = Environment.getExternalStorageDirectory();
    try
    {
      localObject = new StatFs(((File)localObject).getPath());
      return ((StatFs)localObject).getBlockSizeLong() * ((StatFs)localObject).getAvailableBlocksLong();
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      b.d.w.c.a.e(a, Log.getStackTraceString(localIllegalArgumentException));
    }
    return 0L;
  }
  
  private static int p(String paramString)
  {
    try
    {
      MediaMetadataRetriever localMediaMetadataRetriever = new android/media/MediaMetadataRetriever;
      localMediaMetadataRetriever.<init>();
      localMediaMetadataRetriever.setDataSource(paramString);
      paramString = localMediaMetadataRetriever.extractMetadata(9);
    }
    catch (Exception paramString)
    {
      paramString = null;
    }
    int i;
    if ((paramString != null) && (!"0".equals(paramString))) {
      i = Math.round(Float.parseFloat(paramString));
    } else {
      i = 0;
    }
    return i;
  }
  
  public static boolean q()
  {
    boolean bool;
    if ((j.b()) && (!Environment.isExternalStorageLegacy())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static final boolean r()
  {
    boolean bool;
    if (o() - 419430400L > 0L) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static void t(Context paramContext, Uri paramUri)
  {
    Intent localIntent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
    localIntent.setData(paramUri);
    paramContext.sendBroadcast(localIntent);
  }
  
  public static void u(ALCameraDevice paramALCameraDevice, String paramString1, String paramString2, int paramInt)
  {
    l.h(new a(paramString1, paramString2, paramALCameraDevice, paramInt));
  }
  
  public static void v(Context paramContext)
  {
    b = paramContext;
  }
  
  public static void w(String paramString1, String paramString2)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath());
    Object localObject2 = File.separator;
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append("Tapo");
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append(paramString2);
    if (new File(((StringBuilder)localObject1).toString()).exists()) {
      return;
    }
    if (q())
    {
      localObject1 = new ContentValues();
      ((ContentValues)localObject1).put("_display_name", paramString2);
      paramString2 = new StringBuilder();
      paramString2.append(Environment.DIRECTORY_DCIM);
      paramString2.append((String)localObject2);
      paramString2.append("Tapo");
      ((ContentValues)localObject1).put("relative_path", paramString2.toString());
      ((ContentValues)localObject1).put("datetaken", Long.valueOf(System.currentTimeMillis()));
      ((ContentValues)localObject1).put("mime_type", "video/*");
      paramString2 = b.getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, (ContentValues)localObject1);
      try
      {
        localObject2 = b.getContentResolver().openFileDescriptor(paramString2, "w").getFileDescriptor();
        paramString2 = new java/io/File;
        paramString2.<init>(paramString1);
        localObject1 = a;
        paramString1 = new java/lang/StringBuilder;
        paramString1.<init>();
        paramString1.append("srcFileSize:");
        paramString1.append(paramString2.length());
        b.d.w.c.a.c((String)localObject1, paramString1.toString());
        long l1 = paramString2.length();
        long l2 = 0L;
        if (l1 <= 0L) {
          return;
        }
        paramString1 = new java/io/FileInputStream;
        paramString1.<init>(paramString2);
        localObject1 = new java/io/FileOutputStream;
        ((FileOutputStream)localObject1).<init>((FileDescriptor)localObject2);
        localObject2 = new byte[524288];
        while (l2 < paramString2.length())
        {
          int i = paramString1.read((byte[])localObject2);
          if (i == -1) {
            break;
          }
          ((FileOutputStream)localObject1).write((byte[])localObject2, 0, i);
          l2 += i;
        }
        paramString1.close();
        ((FileOutputStream)localObject1).flush();
        ((FileOutputStream)localObject1).close();
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
      catch (FileNotFoundException paramString1)
      {
        paramString1.printStackTrace();
      }
    }
    m(paramString1, paramString2);
  }
  
  public static void x(String paramString1, String paramString2)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath());
    Object localObject2 = File.separator;
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append("Tapo");
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append(paramString2);
    if (new File(((StringBuilder)localObject1).toString()).exists()) {
      return;
    }
    if (q())
    {
      localObject1 = new ContentValues();
      ((ContentValues)localObject1).put("_display_name", paramString2);
      paramString2 = new StringBuilder();
      paramString2.append(Environment.DIRECTORY_DCIM);
      paramString2.append((String)localObject2);
      paramString2.append("Tapo");
      ((ContentValues)localObject1).put("relative_path", paramString2.toString());
      ((ContentValues)localObject1).put("datetaken", Long.valueOf(System.currentTimeMillis()));
      ((ContentValues)localObject1).put("mime_type", "image/*");
      int i = p(paramString1);
      if (i > 0) {
        ((ContentValues)localObject1).put("duration", Integer.valueOf(i));
      }
      paramString2 = b.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, (ContentValues)localObject1);
      try
      {
        localObject2 = b.getContentResolver().openFileDescriptor(paramString2, "w").getFileDescriptor();
        paramString2 = new java/io/File;
        paramString2.<init>(paramString1);
        localObject1 = a;
        paramString1 = new java/lang/StringBuilder;
        paramString1.<init>();
        paramString1.append("srcFileSize:");
        paramString1.append(paramString2.length());
        b.d.w.c.a.c((String)localObject1, paramString1.toString());
        long l1 = paramString2.length();
        long l2 = 0L;
        if (l1 <= 0L) {
          return;
        }
        localObject1 = new java/io/FileInputStream;
        ((FileInputStream)localObject1).<init>(paramString2);
        paramString1 = new java/io/FileOutputStream;
        paramString1.<init>((FileDescriptor)localObject2);
        localObject2 = new byte[524288];
        while (l2 < paramString2.length())
        {
          i = ((FileInputStream)localObject1).read((byte[])localObject2);
          if (i == -1) {
            break;
          }
          paramString1.write((byte[])localObject2, 0, i);
          l2 += i;
        }
        ((FileInputStream)localObject1).close();
        paramString1.flush();
        paramString1.close();
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
      catch (FileNotFoundException paramString1)
      {
        paramString1.printStackTrace();
      }
    }
    m(paramString1, paramString2);
  }
  
  static final class a
    implements b.d
  {
    a(Context paramContext, String paramString1, String paramString2, b.d paramd) {}
    
    public void a()
    {
      b.a(this.a, Uri.fromFile(new File(paramString1, paramString2)));
      b.d locald = paramd;
      if (locald != null) {
        locald.a();
      }
    }
    
    public void b(String paramString)
    {
      b.d locald = paramd;
      if (locald != null) {
        locald.b(paramString);
      }
    }
  }
  
  static final class b
    implements Runnable
  {
    b(File paramFile1, File paramFile2, b.d paramd) {}
    
    public void run()
    {
      try
      {
        FileInputStream localFileInputStream = new java/io/FileInputStream;
        localFileInputStream.<init>(this.c);
        Object localObject1 = new java/io/FileOutputStream;
        ((FileOutputStream)localObject1).<init>(paramFile2);
        localObject2 = localFileInputStream.getChannel();
        localObject1 = ((FileOutputStream)localObject1).getChannel();
        ((FileChannel)localObject2).transferTo(0L, ((FileChannel)localObject2).size(), (WritableByteChannel)localObject1);
        localFileInputStream.close();
        ((FileChannel)localObject1).close();
        localObject2 = paramd;
        if (localObject2 != null) {
          ((b.d)localObject2).a();
        }
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        Object localObject2 = paramd;
        if (localObject2 != null) {
          ((b.d)localObject2).b(localIOException.getMessage());
        }
      }
    }
  }
  
  public static final class c
    implements Comparable<c>
  {
    private String c;
    private String d;
    private long f;
    
    public int a(@NonNull c paramc)
    {
      long l1 = d();
      long l2 = paramc.d();
      int i = 1;
      int j;
      if (l1 - l2 > 0L) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0) {
        j = i;
      } else {
        j = -1;
      }
      return j;
    }
    
    public String b()
    {
      return this.c;
    }
    
    public String c()
    {
      return this.d;
    }
    
    public long d()
    {
      return this.f;
    }
  }
  
  public static abstract interface d
  {
    public abstract void a();
    
    public abstract void b(String paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\q\b\p\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */