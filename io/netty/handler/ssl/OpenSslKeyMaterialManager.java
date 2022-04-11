package io.netty.handler.ssl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.SSLException;
import javax.net.ssl.X509ExtendedKeyManager;
import javax.net.ssl.X509KeyManager;
import javax.security.auth.x500.X500Principal;

final class OpenSslKeyMaterialManager
{
  private static final Map<String, String> KEY_TYPES;
  static final String KEY_TYPE_DH_RSA = "DH_RSA";
  static final String KEY_TYPE_EC = "EC";
  static final String KEY_TYPE_EC_EC = "EC_EC";
  static final String KEY_TYPE_EC_RSA = "EC_RSA";
  static final String KEY_TYPE_RSA = "RSA";
  private final OpenSslKeyMaterialProvider provider;
  
  static
  {
    HashMap localHashMap = new HashMap();
    KEY_TYPES = localHashMap;
    localHashMap.put("RSA", "RSA");
    localHashMap.put("DHE_RSA", "RSA");
    localHashMap.put("ECDHE_RSA", "RSA");
    localHashMap.put("ECDHE_ECDSA", "EC");
    localHashMap.put("ECDH_RSA", "EC_RSA");
    localHashMap.put("ECDH_ECDSA", "EC_EC");
    localHashMap.put("DH_RSA", "DH_RSA");
  }
  
  OpenSslKeyMaterialManager(OpenSslKeyMaterialProvider paramOpenSslKeyMaterialProvider)
  {
    this.provider = paramOpenSslKeyMaterialProvider;
  }
  
  private String chooseClientAlias(ReferenceCountedOpenSslEngine paramReferenceCountedOpenSslEngine, String[] paramArrayOfString, X500Principal[] paramArrayOfX500Principal)
  {
    X509KeyManager localX509KeyManager = this.provider.keyManager();
    if ((localX509KeyManager instanceof X509ExtendedKeyManager)) {
      return ((X509ExtendedKeyManager)localX509KeyManager).chooseEngineClientAlias(paramArrayOfString, paramArrayOfX500Principal, paramReferenceCountedOpenSslEngine);
    }
    return localX509KeyManager.chooseClientAlias(paramArrayOfString, paramArrayOfX500Principal, null);
  }
  
  private String chooseServerAlias(ReferenceCountedOpenSslEngine paramReferenceCountedOpenSslEngine, String paramString)
  {
    X509KeyManager localX509KeyManager = this.provider.keyManager();
    if ((localX509KeyManager instanceof X509ExtendedKeyManager)) {
      return ((X509ExtendedKeyManager)localX509KeyManager).chooseEngineServerAlias(paramString, null, paramReferenceCountedOpenSslEngine);
    }
    return localX509KeyManager.chooseServerAlias(paramString, null, null);
  }
  
  /* Error */
  private boolean setKeyMaterial(ReferenceCountedOpenSslEngine paramReferenceCountedOpenSslEngine, String paramString)
    throws SSLException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aconst_null
    //   6: astore 5
    //   8: aload_0
    //   9: getfield 55	io/netty/handler/ssl/OpenSslKeyMaterialManager:provider	Lio/netty/handler/ssl/OpenSslKeyMaterialProvider;
    //   12: aload_1
    //   13: getfield 95	io/netty/handler/ssl/ReferenceCountedOpenSslEngine:alloc	Lio/netty/buffer/ByteBufAllocator;
    //   16: aload_2
    //   17: invokevirtual 99	io/netty/handler/ssl/OpenSslKeyMaterialProvider:chooseKeyMaterial	(Lio/netty/buffer/ByteBufAllocator;Ljava/lang/String;)Lio/netty/handler/ssl/OpenSslKeyMaterial;
    //   20: astore_2
    //   21: aload_2
    //   22: ifnull +32 -> 54
    //   25: aload_2
    //   26: astore 5
    //   28: aload_2
    //   29: astore_3
    //   30: aload_2
    //   31: astore 4
    //   33: aload_1
    //   34: aload_2
    //   35: invokevirtual 102	io/netty/handler/ssl/ReferenceCountedOpenSslEngine:setKeyMaterial	(Lio/netty/handler/ssl/OpenSslKeyMaterial;)Z
    //   38: istore 6
    //   40: iload 6
    //   42: ifeq +6 -> 48
    //   45: goto +9 -> 54
    //   48: iconst_0
    //   49: istore 6
    //   51: goto +6 -> 57
    //   54: iconst_1
    //   55: istore 6
    //   57: aload_2
    //   58: ifnull +10 -> 68
    //   61: aload_2
    //   62: invokeinterface 108 1 0
    //   67: pop
    //   68: iload 6
    //   70: ireturn
    //   71: astore_1
    //   72: goto +31 -> 103
    //   75: astore_2
    //   76: aload_3
    //   77: astore 5
    //   79: new 87	javax/net/ssl/SSLException
    //   82: astore_1
    //   83: aload_3
    //   84: astore 5
    //   86: aload_1
    //   87: aload_2
    //   88: invokespecial 111	javax/net/ssl/SSLException:<init>	(Ljava/lang/Throwable;)V
    //   91: aload_3
    //   92: astore 5
    //   94: aload_1
    //   95: athrow
    //   96: astore_1
    //   97: aload 4
    //   99: astore 5
    //   101: aload_1
    //   102: athrow
    //   103: aload 5
    //   105: ifnull +11 -> 116
    //   108: aload 5
    //   110: invokeinterface 108 1 0
    //   115: pop
    //   116: aload_1
    //   117: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	this	OpenSslKeyMaterialManager
    //   0	118	1	paramReferenceCountedOpenSslEngine	ReferenceCountedOpenSslEngine
    //   0	118	2	paramString	String
    //   1	91	3	str1	String
    //   3	95	4	str2	String
    //   6	103	5	str3	String
    //   38	31	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   8	21	71	finally
    //   33	40	71	finally
    //   79	83	71	finally
    //   86	91	71	finally
    //   94	96	71	finally
    //   101	103	71	finally
    //   8	21	75	java/lang/Exception
    //   33	40	75	java/lang/Exception
    //   8	21	96	javax/net/ssl/SSLException
    //   33	40	96	javax/net/ssl/SSLException
  }
  
  void setKeyMaterialClientSide(ReferenceCountedOpenSslEngine paramReferenceCountedOpenSslEngine, String[] paramArrayOfString, X500Principal[] paramArrayOfX500Principal)
    throws SSLException
  {
    paramArrayOfString = chooseClientAlias(paramReferenceCountedOpenSslEngine, paramArrayOfString, paramArrayOfX500Principal);
    if (paramArrayOfString != null) {
      setKeyMaterial(paramReferenceCountedOpenSslEngine, paramArrayOfString);
    }
  }
  
  void setKeyMaterialServerSide(ReferenceCountedOpenSslEngine paramReferenceCountedOpenSslEngine)
    throws SSLException
  {
    String[] arrayOfString = paramReferenceCountedOpenSslEngine.authMethods();
    if (arrayOfString.length == 0) {
      return;
    }
    HashSet localHashSet = new HashSet(arrayOfString.length);
    int i = arrayOfString.length;
    for (int j = 0; j < i; j++)
    {
      String str = arrayOfString[j];
      str = (String)KEY_TYPES.get(str);
      if (str != null)
      {
        str = chooseServerAlias(paramReferenceCountedOpenSslEngine, str);
        if ((str != null) && (localHashSet.add(str)) && (!setKeyMaterial(paramReferenceCountedOpenSslEngine, str))) {
          return;
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\OpenSslKeyMaterialManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */