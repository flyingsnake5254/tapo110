package b.d.k.f;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.Nullable;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Formatter;

public class a
{
  private static String a(byte[] paramArrayOfByte)
  {
    Formatter localFormatter = new Formatter();
    for (int i = 0; i < paramArrayOfByte.length - 1; i++) {
      localFormatter.format("%02x:", new Object[] { Byte.valueOf(paramArrayOfByte[i]) });
    }
    localFormatter.format("%02x", new Object[] { Byte.valueOf(paramArrayOfByte[(paramArrayOfByte.length - 1)]) });
    return localFormatter.toString().toUpperCase();
  }
  
  @Nullable
  private static String b(Context paramContext, String paramString)
    throws PackageManager.NameNotFoundException
  {
    paramContext = new ByteArrayInputStream(paramContext.getPackageManager().getPackageInfo(paramString, 64).signatures[0].toByteArray());
    try
    {
      paramContext = (X509Certificate)CertificateFactory.getInstance("X509").generateCertificate(paramContext);
      paramContext = a(MessageDigest.getInstance("SHA-256").digest(paramContext.getEncoded()));
      return paramContext;
    }
    catch (CertificateException|NoSuchAlgorithmException paramContext)
    {
      b.d.w.c.a.c("AppFlip", "Failed to process the certificate");
    }
    return null;
  }
  
  public static boolean c(Context paramContext, ComponentName paramComponentName, Intent paramIntent)
  {
    if (!e(paramContext, paramComponentName)) {
      return false;
    }
    if (paramIntent == null) {
      return false;
    }
    boolean bool = paramIntent.hasExtra("CLIENT_ID");
    paramContext = null;
    paramComponentName = null;
    if (bool)
    {
      String str = paramIntent.getStringExtra("CLIENT_ID");
      if (paramIntent.hasExtra("SCOPE")) {
        paramContext = paramIntent.getStringExtra("SCOPE");
      } else {
        paramContext = null;
      }
      if (paramIntent.hasExtra("REDIRECT_URI")) {
        paramComponentName = paramIntent.getStringExtra("REDIRECT_URI");
      }
      paramIntent = new StringBuilder();
      paramIntent.append("clientId=");
      paramIntent.append(str);
      Log.d("AppFlip", paramIntent.toString());
      paramIntent = new StringBuilder();
      paramIntent.append("scopes=");
      paramIntent.append(paramContext);
      Log.d("AppFlip", paramIntent.toString());
      paramContext = new StringBuilder();
      paramContext.append("redirectUri=");
      paramContext.append(paramComponentName);
      b.d.w.c.a.c("AppFlip", paramContext.toString());
      paramContext = str;
    }
    return b.d.k.d.a.d().equals(paramContext);
  }
  
  public static Boolean d(Intent paramIntent)
  {
    if (paramIntent == null) {
      return Boolean.FALSE;
    }
    Object localObject1 = null;
    Object localObject2 = paramIntent.getData();
    paramIntent = (Intent)localObject1;
    if (localObject2 != null)
    {
      paramIntent = ((Uri)localObject2).getQueryParameter("CLIENT_ID".toLowerCase());
      Object localObject3 = ((Uri)localObject2).getQueryParameter("SCOPE".toLowerCase());
      localObject1 = ((Uri)localObject2).getQueryParameter("REDIRECT_URI".toLowerCase());
      localObject2 = ((Uri)localObject2).getQueryParameter("state");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("clientId=");
      localStringBuilder.append(paramIntent);
      Log.d("AppFlip", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("scopes=");
      localStringBuilder.append((String)localObject3);
      Log.d("AppFlip", localStringBuilder.toString());
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("redirectUri=");
      ((StringBuilder)localObject3).append((String)localObject1);
      b.d.w.c.a.c("AppFlip", ((StringBuilder)localObject3).toString());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("state=");
      ((StringBuilder)localObject1).append((String)localObject2);
      b.d.w.c.a.c("AppFlip", ((StringBuilder)localObject1).toString());
    }
    return Boolean.valueOf(b.d.k.d.a.c().equals(paramIntent));
  }
  
  private static boolean e(Context paramContext, ComponentName paramComponentName)
  {
    if (paramComponentName != null)
    {
      paramComponentName = paramComponentName.getPackageName();
      if ("com.google.android.googlequicksearchbox".equalsIgnoreCase(paramComponentName)) {
        try
        {
          paramContext = b(paramContext, paramComponentName);
          paramComponentName = new java/lang/StringBuilder;
          paramComponentName.<init>();
          paramComponentName.append("fingerPrint=");
          paramComponentName.append(paramContext);
          b.d.w.c.a.c("AppFlip", paramComponentName.toString());
          boolean bool = "F0:FD:6C:5B:41:0F:25:CB:25:C3:B5:33:46:C8:97:2F:AE:30:F8:EE:74:11:DF:91:04:80:AD:6B:2D:60:DB:83".equalsIgnoreCase(paramContext);
          return bool;
        }
        catch (PackageManager.NameNotFoundException paramContext)
        {
          b.d.w.c.a.c("AppFlip", "No such app is installed");
        }
      }
    }
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\k\f\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */