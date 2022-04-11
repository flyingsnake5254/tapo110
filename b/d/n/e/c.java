package b.d.n.e;

import android.text.TextUtils;
import b.d.n.i.a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class c
  implements Runnable
{
  private static final b c = new a();
  private String d;
  private String f;
  private InputStream p0;
  private OutputStream p1;
  private volatile boolean p2;
  private final String p3;
  private final int q;
  private final a x;
  private final b y;
  private HttpURLConnection z;
  
  private c(String paramString1, String paramString2, int paramInt, String paramString3, a parama, b paramb)
  {
    this.f = paramString2;
    this.d = paramString1;
    this.q = paramInt;
    this.y = paramb;
    paramString1 = new StringBuilder();
    paramString1.append(paramString3);
    paramString1.append(File.separator);
    paramString1.append(paramString2);
    this.p3 = paramString1.toString();
    this.x = parama;
  }
  
  public c(String paramString1, String paramString2, String paramString3, a parama)
  {
    this(paramString1, paramString2, 10000, paramString3, parama, c);
  }
  
  private static boolean b(int paramInt)
  {
    boolean bool;
    if (paramInt / 100 == 2) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static boolean c(int paramInt)
  {
    boolean bool;
    if (paramInt / 100 == 3) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void a()
  {
    InputStream localInputStream = this.p0;
    if (localInputStream != null) {
      try
      {
        localInputStream.close();
      }
      catch (IOException localIOException1) {}
    }
    OutputStream localOutputStream = this.p1;
    if (localOutputStream != null) {
      try
      {
        localOutputStream.close();
      }
      catch (IOException localIOException2) {}
    }
    HttpURLConnection localHttpURLConnection = this.z;
    if (localHttpURLConnection != null) {
      localHttpURLConnection.disconnect();
    }
    this.z = null;
  }
  
  public void d(URL paramURL, int paramInt)
  {
    try
    {
      Object localObject = this.y.a(paramURL);
      this.z = ((HttpURLConnection)localObject);
      ((HttpURLConnection)localObject).setConnectTimeout(this.q);
      this.z.setReadTimeout(this.q);
      this.z.setUseCaches(false);
      this.z.setDoInput(true);
      this.z.setInstanceFollowRedirects(false);
      this.z.connect();
      this.p0 = this.z.getInputStream();
      if (this.p2) {
        return;
      }
      int i = this.z.getResponseCode();
      if (b(i))
      {
        this.p0 = this.z.getInputStream();
        paramURL = new java/io/File;
        paramURL.<init>(this.p3);
        if (paramURL.exists()) {
          paramURL.delete();
        }
        paramURL.createNewFile();
        localObject = new java/io/FileOutputStream;
        ((FileOutputStream)localObject).<init>(paramURL);
        this.p1 = ((OutputStream)localObject);
        paramURL = new byte['က'];
        for (;;)
        {
          paramInt = this.p0.read(paramURL);
          if (paramInt == -1) {
            break;
          }
          this.p1.write(paramURL, 0, paramInt);
        }
        this.p1.flush();
        this.p1.close();
        this.p0.close();
        this.x.a(this.f, this.p3);
      }
      else
      {
        boolean bool = c(i);
        if (bool)
        {
          localObject = this.z.getHeaderField("Location");
          if (TextUtils.isEmpty((CharSequence)localObject))
          {
            paramURL = this.x;
            localObject = new java/lang/StringBuilder;
            ((StringBuilder)localObject).<init>();
            ((StringBuilder)localObject).append("statusCode:");
            ((StringBuilder)localObject).append(i);
            paramURL.c(((StringBuilder)localObject).toString());
            return;
          }
          a();
          URL localURL = new java/net/URL;
          localURL.<init>(paramURL, (String)localObject);
          if (paramInt < 5) {
            d(localURL, paramInt + 1);
          }
        }
        else
        {
          localObject = this.x;
          paramURL = new java/lang/StringBuilder;
          paramURL.<init>();
          paramURL.append("statusCode:");
          paramURL.append(i);
          ((a)localObject).c(paramURL.toString());
        }
      }
    }
    catch (IOException paramURL)
    {
      paramURL.printStackTrace();
      this.x.c(paramURL.getMessage());
    }
  }
  
  public void run()
  {
    if ((!TextUtils.isEmpty(this.f)) && (!TextUtils.isEmpty(this.d)))
    {
      Object localObject = this.x;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("materialId:");
      localStringBuilder.append(this.f);
      localStringBuilder.append(" url:");
      localStringBuilder.append(this.d);
      ((a)localObject).b(localStringBuilder.toString());
      try
      {
        localObject = new java/net/URL;
        ((URL)localObject).<init>(this.d);
        d((URL)localObject, 0);
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
    }
    else
    {
      this.x.c("materialId or url empty!!!");
    }
  }
  
  private static class a
    implements c.b
  {
    public HttpURLConnection a(URL paramURL)
      throws IOException
    {
      return (HttpURLConnection)paramURL.openConnection();
    }
  }
  
  static abstract interface b
  {
    public abstract HttpURLConnection a(URL paramURL)
      throws IOException;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\n\e\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */