package b.d.i.a.a;

import b.d.p.a;
import b.d.p.d;
import com.tplink.libmediakit.jniinterface.GenKey;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class e
{
  private static a a(String paramString1, String paramString2, String paramString3)
    throws NoSuchAlgorithmException
  {
    if (GenKey.b().equals(paramString1))
    {
      d.a("StreamAesUtils", "AES use User Password");
    }
    else
    {
      if (!"none".equals(paramString1)) {
        break label111;
      }
      paramString3 = GenKey.a();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append(":");
    localStringBuilder.append(paramString3);
    paramString3 = c(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(":");
    localStringBuilder.append(paramString2);
    return new a(paramString3, c(localStringBuilder.toString()));
    label111:
    d.a("StreamAesUtils", "AES key-exchange unknown username");
    return null;
  }
  
  public static a b(String paramString1, String paramString2)
    throws UnsupportedEncodingException, NoSuchAlgorithmException
  {
    HashMap localHashMap = new HashMap();
    paramString1 = paramString1.split(" ");
    if (paramString1 == null) {
      return null;
    }
    for (int i = 0; i < paramString1.length; i++)
    {
      Object localObject = paramString1[i].trim().split("=", 2);
      if ((localObject.length == 2) && (localObject[0] != null) && (localObject[1] != null))
      {
        String str = localObject[0].trim();
        localObject = localObject[1].replace("\"", "").trim();
        if (localObject != null) {
          localHashMap.put(str, localObject);
        }
      }
    }
    if (!localHashMap.containsKey("nonce")) {
      return null;
    }
    paramString1 = new StringBuilder();
    paramString1.append("cipher=");
    paramString1.append((String)localHashMap.get("cipher"));
    d.a("StreamAesUtils", paramString1.toString());
    paramString1 = new StringBuilder();
    paramString1.append("username=");
    paramString1.append((String)localHashMap.get("username"));
    d.a("StreamAesUtils", paramString1.toString());
    paramString1 = new StringBuilder();
    paramString1.append("padding=");
    paramString1.append((String)localHashMap.get("padding"));
    d.a("StreamAesUtils", paramString1.toString());
    paramString1 = new StringBuilder();
    paramString1.append("algorithm=");
    paramString1.append((String)localHashMap.get("algorithm"));
    d.a("StreamAesUtils", paramString1.toString());
    paramString1 = new StringBuilder();
    paramString1.append("nonce=");
    paramString1.append((String)localHashMap.get("nonce"));
    d.a("StreamAesUtils", paramString1.toString());
    return a((String)localHashMap.get("username"), (String)localHashMap.get("nonce"), paramString2);
  }
  
  private static byte[] c(String paramString)
    throws NoSuchAlgorithmException
  {
    MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
    localMessageDigest.update(paramString.getBytes());
    return localMessageDigest.digest();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\i\a\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */