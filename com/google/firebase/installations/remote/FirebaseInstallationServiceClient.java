package com.google.firebase.installations.remote;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import android.util.JsonReader;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.heartbeatinfo.HeartBeatInfo.HeartBeat;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsException;
import com.google.firebase.installations.FirebaseInstallationsException.Status;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class FirebaseInstallationServiceClient
{
  private static final String ACCEPT_HEADER_KEY = "Accept";
  private static final String API_KEY_HEADER = "x-goog-api-key";
  private static final String CACHE_CONTROL_DIRECTIVE = "no-cache";
  private static final String CACHE_CONTROL_HEADER_KEY = "Cache-Control";
  private static final String CONTENT_ENCODING_HEADER_KEY = "Content-Encoding";
  private static final String CONTENT_TYPE_HEADER_KEY = "Content-Type";
  private static final String CREATE_REQUEST_RESOURCE_NAME_FORMAT = "projects/%s/installations";
  private static final String DELETE_REQUEST_RESOURCE_NAME_FORMAT = "projects/%s/installations/%s";
  private static final Pattern EXPIRATION_TIMESTAMP_PATTERN = Pattern.compile("[0-9]+s");
  private static final String FIREBASE_INSTALLATIONS_API_DOMAIN = "firebaseinstallations.googleapis.com";
  private static final String FIREBASE_INSTALLATIONS_API_VERSION = "v1";
  private static final String FIREBASE_INSTALLATIONS_ID_HEARTBEAT_TAG = "fire-installations-id";
  private static final String FIREBASE_INSTALLATION_AUTH_VERSION = "FIS_v2";
  private static final String FIS_TAG = "Firebase-Installations";
  private static final String GENERATE_AUTH_TOKEN_REQUEST_RESOURCE_NAME_FORMAT = "projects/%s/installations/%s/authTokens:generate";
  private static final String GZIP_CONTENT_ENCODING = "gzip";
  private static final String HEART_BEAT_HEADER = "x-firebase-client-log-type";
  private static final String JSON_CONTENT_TYPE = "application/json";
  private static final int MAX_RETRIES = 1;
  private static final int NETWORK_TIMEOUT_MILLIS = 10000;
  @VisibleForTesting
  static final String PARSING_EXPIRATION_TIME_ERROR_MESSAGE = "Invalid Expiration Timestamp.";
  private static final String SDK_VERSION_PREFIX = "a:";
  private static final int TRAFFIC_STATS_CREATE_INSTALLATION_TAG = 32769;
  private static final int TRAFFIC_STATS_DELETE_INSTALLATION_TAG = 32770;
  private static final int TRAFFIC_STATS_FIREBASE_INSTALLATIONS_TAG = 32768;
  private static final int TRAFFIC_STATS_GENERATE_AUTH_TOKEN_TAG = 32771;
  private static final String USER_AGENT_HEADER = "x-firebase-client";
  private static final Charset UTF_8 = Charset.forName("UTF-8");
  private static final String X_ANDROID_CERT_HEADER_KEY = "X-Android-Cert";
  private static final String X_ANDROID_IID_MIGRATION_KEY = "x-goog-fis-android-iid-migration-auth";
  private static final String X_ANDROID_PACKAGE_HEADER_KEY = "X-Android-Package";
  private final Context context;
  private final Provider<HeartBeatInfo> heartbeatInfo;
  private final RequestLimiter requestLimiter;
  private boolean shouldServerErrorRetry;
  private final Provider<UserAgentPublisher> userAgentPublisher;
  
  public FirebaseInstallationServiceClient(@NonNull Context paramContext, @NonNull Provider<UserAgentPublisher> paramProvider, @NonNull Provider<HeartBeatInfo> paramProvider1)
  {
    this.context = paramContext;
    this.userAgentPublisher = paramProvider;
    this.heartbeatInfo = paramProvider1;
    this.requestLimiter = new RequestLimiter();
  }
  
  private static String availableFirebaseOptions(@Nullable String paramString1, @NonNull String paramString2, @NonNull String paramString3)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      paramString1 = "";
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(", ");
      localStringBuilder.append(paramString1);
      paramString1 = localStringBuilder.toString();
    }
    return String.format("Firebase options used while communicating with Firebase server APIs: %s, %s%s", new Object[] { paramString2, paramString3, paramString1 });
  }
  
  private static JSONObject buildCreateFirebaseInstallationRequestBody(@Nullable String paramString1, @NonNull String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new org/json/JSONObject;
      localJSONObject.<init>();
      localJSONObject.put("fid", paramString1);
      localJSONObject.put("appId", paramString2);
      localJSONObject.put("authVersion", "FIS_v2");
      localJSONObject.put("sdkVersion", "a:17.0.0");
      return localJSONObject;
    }
    catch (JSONException paramString1)
    {
      throw new IllegalStateException(paramString1);
    }
  }
  
  private static JSONObject buildGenerateAuthTokenRequestBody()
  {
    try
    {
      JSONObject localJSONObject1 = new org/json/JSONObject;
      localJSONObject1.<init>();
      localJSONObject1.put("sdkVersion", "a:17.0.0");
      JSONObject localJSONObject2 = new org/json/JSONObject;
      localJSONObject2.<init>();
      localJSONObject2.put("installation", localJSONObject1);
      return localJSONObject2;
    }
    catch (JSONException localJSONException)
    {
      throw new IllegalStateException(localJSONException);
    }
  }
  
  private String getFingerprintHashForPackage()
  {
    try
    {
      localObject = this.context;
      localObject = AndroidUtilsLight.getPackageCertificateHashBytes((Context)localObject, ((Context)localObject).getPackageName());
      if (localObject == null)
      {
        localObject = new java/lang/StringBuilder;
        ((StringBuilder)localObject).<init>();
        ((StringBuilder)localObject).append("Could not get fingerprint hash for package: ");
        ((StringBuilder)localObject).append(this.context.getPackageName());
        Log.e("ContentValues", ((StringBuilder)localObject).toString());
        return null;
      }
      localObject = Hex.bytesToStringUppercase((byte[])localObject, false);
      return (String)localObject;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("No such package: ");
      ((StringBuilder)localObject).append(this.context.getPackageName());
      Log.e("ContentValues", ((StringBuilder)localObject).toString(), localNameNotFoundException);
    }
    return null;
  }
  
  private URL getFullyQualifiedRequestUri(String paramString)
    throws FirebaseInstallationsException
  {
    try
    {
      paramString = new URL(String.format("https://%s/%s/%s", new Object[] { "firebaseinstallations.googleapis.com", "v1", paramString }));
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      throw new FirebaseInstallationsException(paramString.getMessage(), FirebaseInstallationsException.Status.UNAVAILABLE);
    }
  }
  
  private static byte[] getJsonBytes(JSONObject paramJSONObject)
    throws IOException
  {
    return paramJSONObject.toString().getBytes("UTF-8");
  }
  
  private static boolean isSuccessfulResponseCode(int paramInt)
  {
    boolean bool;
    if ((paramInt >= 200) && (paramInt < 300)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static void logBadConfigError()
  {
    Log.e("Firebase-Installations", "Firebase Installations can not communicate with Firebase server APIs due to invalid configuration. Please update your Firebase initialization process and set valid Firebase options (API key, Project ID, Application ID) when initializing Firebase.");
  }
  
  private static void logFisCommunicationError(HttpURLConnection paramHttpURLConnection, @Nullable String paramString1, @NonNull String paramString2, @NonNull String paramString3)
  {
    paramHttpURLConnection = readErrorResponse(paramHttpURLConnection);
    if (!TextUtils.isEmpty(paramHttpURLConnection))
    {
      Log.w("Firebase-Installations", paramHttpURLConnection);
      Log.w("Firebase-Installations", availableFirebaseOptions(paramString1, paramString2, paramString3));
    }
  }
  
  private HttpURLConnection openHttpURLConnection(URL paramURL, String paramString)
    throws FirebaseInstallationsException
  {
    try
    {
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)paramURL.openConnection();
      localHttpURLConnection.setConnectTimeout(10000);
      localHttpURLConnection.setUseCaches(false);
      localHttpURLConnection.setReadTimeout(10000);
      localHttpURLConnection.addRequestProperty("Content-Type", "application/json");
      localHttpURLConnection.addRequestProperty("Accept", "application/json");
      localHttpURLConnection.addRequestProperty("Content-Encoding", "gzip");
      localHttpURLConnection.addRequestProperty("Cache-Control", "no-cache");
      localHttpURLConnection.addRequestProperty("X-Android-Package", this.context.getPackageName());
      if ((this.heartbeatInfo.get() != null) && (this.userAgentPublisher.get() != null))
      {
        paramURL = ((HeartBeatInfo)this.heartbeatInfo.get()).getHeartBeatCode("fire-installations-id");
        if (paramURL != HeartBeatInfo.HeartBeat.NONE)
        {
          localHttpURLConnection.addRequestProperty("x-firebase-client", ((UserAgentPublisher)this.userAgentPublisher.get()).getUserAgent());
          localHttpURLConnection.addRequestProperty("x-firebase-client-log-type", Integer.toString(paramURL.getCode()));
        }
      }
      localHttpURLConnection.addRequestProperty("X-Android-Cert", getFingerprintHashForPackage());
      localHttpURLConnection.addRequestProperty("x-goog-api-key", paramString);
      return localHttpURLConnection;
    }
    catch (IOException paramURL)
    {
      throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
    }
  }
  
  @VisibleForTesting
  static long parseTokenExpirationTimestamp(String paramString)
  {
    Preconditions.checkArgument(EXPIRATION_TIMESTAMP_PATTERN.matcher(paramString).matches(), "Invalid Expiration Timestamp.");
    long l;
    if ((paramString != null) && (paramString.length() != 0)) {
      l = Long.parseLong(paramString.substring(0, paramString.length() - 1));
    } else {
      l = 0L;
    }
    return l;
  }
  
  private InstallationResponse readCreateResponse(HttpURLConnection paramHttpURLConnection)
    throws AssertionError, IOException
  {
    InputStream localInputStream = paramHttpURLConnection.getInputStream();
    JsonReader localJsonReader = new JsonReader(new InputStreamReader(localInputStream, UTF_8));
    TokenResult.Builder localBuilder = TokenResult.builder();
    paramHttpURLConnection = InstallationResponse.builder();
    localJsonReader.beginObject();
    while (localJsonReader.hasNext())
    {
      String str = localJsonReader.nextName();
      if (str.equals("name"))
      {
        paramHttpURLConnection.setUri(localJsonReader.nextString());
      }
      else if (str.equals("fid"))
      {
        paramHttpURLConnection.setFid(localJsonReader.nextString());
      }
      else if (str.equals("refreshToken"))
      {
        paramHttpURLConnection.setRefreshToken(localJsonReader.nextString());
      }
      else if (str.equals("authToken"))
      {
        localJsonReader.beginObject();
        while (localJsonReader.hasNext())
        {
          str = localJsonReader.nextName();
          if (str.equals("token")) {
            localBuilder.setToken(localJsonReader.nextString());
          } else if (str.equals("expiresIn")) {
            localBuilder.setTokenExpirationTimestamp(parseTokenExpirationTimestamp(localJsonReader.nextString()));
          } else {
            localJsonReader.skipValue();
          }
        }
        paramHttpURLConnection.setAuthToken(localBuilder.build());
        localJsonReader.endObject();
      }
      else
      {
        localJsonReader.skipValue();
      }
    }
    localJsonReader.endObject();
    localJsonReader.close();
    localInputStream.close();
    return paramHttpURLConnection.setResponseCode(InstallationResponse.ResponseCode.OK).build();
  }
  
  /* Error */
  @Nullable
  private static String readErrorResponse(HttpURLConnection paramHttpURLConnection)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 498	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnonnull +5 -> 11
    //   9: aconst_null
    //   10: areturn
    //   11: new 500	java/io/BufferedReader
    //   14: dup
    //   15: new 395	java/io/InputStreamReader
    //   18: dup
    //   19: aload_1
    //   20: getstatic 125	com/google/firebase/installations/remote/FirebaseInstallationServiceClient:UTF_8	Ljava/nio/charset/Charset;
    //   23: invokespecial 398	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   26: invokespecial 501	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   29: astore_1
    //   30: new 158	java/lang/StringBuilder
    //   33: astore_2
    //   34: aload_2
    //   35: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   38: aload_1
    //   39: invokevirtual 504	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   42: astore_3
    //   43: aload_3
    //   44: ifnull +19 -> 63
    //   47: aload_2
    //   48: aload_3
    //   49: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload_2
    //   54: bipush 10
    //   56: invokevirtual 507	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: goto -22 -> 38
    //   63: ldc_w 509
    //   66: iconst_3
    //   67: anewarray 4	java/lang/Object
    //   70: dup
    //   71: iconst_0
    //   72: aload_0
    //   73: invokevirtual 512	java/net/HttpURLConnection:getResponseCode	()I
    //   76: invokestatic 516	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   79: aastore
    //   80: dup
    //   81: iconst_1
    //   82: aload_0
    //   83: invokevirtual 519	java/net/HttpURLConnection:getResponseMessage	()Ljava/lang/String;
    //   86: aastore
    //   87: dup
    //   88: iconst_2
    //   89: aload_2
    //   90: aastore
    //   91: invokestatic 177	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   94: astore_0
    //   95: aload_1
    //   96: invokevirtual 520	java/io/BufferedReader:close	()V
    //   99: aload_0
    //   100: areturn
    //   101: astore_0
    //   102: aload_1
    //   103: invokevirtual 520	java/io/BufferedReader:close	()V
    //   106: aload_0
    //   107: athrow
    //   108: astore_0
    //   109: aload_1
    //   110: invokevirtual 520	java/io/BufferedReader:close	()V
    //   113: aconst_null
    //   114: areturn
    //   115: astore_1
    //   116: goto -17 -> 99
    //   119: astore_1
    //   120: goto -14 -> 106
    //   123: astore_0
    //   124: goto -11 -> 113
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	paramHttpURLConnection	HttpURLConnection
    //   4	106	1	localObject	Object
    //   115	1	1	localIOException1	IOException
    //   119	1	1	localIOException2	IOException
    //   33	57	2	localStringBuilder	StringBuilder
    //   42	7	3	str	String
    // Exception table:
    //   from	to	target	type
    //   30	38	101	finally
    //   38	43	101	finally
    //   47	60	101	finally
    //   63	95	101	finally
    //   30	38	108	java/io/IOException
    //   38	43	108	java/io/IOException
    //   47	60	108	java/io/IOException
    //   63	95	108	java/io/IOException
    //   95	99	115	java/io/IOException
    //   102	106	119	java/io/IOException
    //   109	113	123	java/io/IOException
  }
  
  private TokenResult readGenerateAuthTokenResponse(HttpURLConnection paramHttpURLConnection)
    throws AssertionError, IOException
  {
    paramHttpURLConnection = paramHttpURLConnection.getInputStream();
    JsonReader localJsonReader = new JsonReader(new InputStreamReader(paramHttpURLConnection, UTF_8));
    TokenResult.Builder localBuilder = TokenResult.builder();
    localJsonReader.beginObject();
    while (localJsonReader.hasNext())
    {
      String str = localJsonReader.nextName();
      if (str.equals("token")) {
        localBuilder.setToken(localJsonReader.nextString());
      } else if (str.equals("expiresIn")) {
        localBuilder.setTokenExpirationTimestamp(parseTokenExpirationTimestamp(localJsonReader.nextString()));
      } else {
        localJsonReader.skipValue();
      }
    }
    localJsonReader.endObject();
    localJsonReader.close();
    paramHttpURLConnection.close();
    return localBuilder.setResponseCode(TokenResult.ResponseCode.OK).build();
  }
  
  private void writeFIDCreateRequestBodyToOutputStream(HttpURLConnection paramHttpURLConnection, @Nullable String paramString1, @NonNull String paramString2)
    throws IOException
  {
    writeRequestBodyToOutputStream(paramHttpURLConnection, getJsonBytes(buildCreateFirebaseInstallationRequestBody(paramString1, paramString2)));
  }
  
  private void writeGenerateAuthTokenRequestBodyToOutputStream(HttpURLConnection paramHttpURLConnection)
    throws IOException
  {
    writeRequestBodyToOutputStream(paramHttpURLConnection, getJsonBytes(buildGenerateAuthTokenRequestBody()));
  }
  
  /* Error */
  private static void writeRequestBodyToOutputStream(java.net.URLConnection paramURLConnection, byte[] paramArrayOfByte)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 550	java/net/URLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   4: astore_0
    //   5: aload_0
    //   6: ifnull +37 -> 43
    //   9: new 552	java/util/zip/GZIPOutputStream
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 555	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   17: astore_2
    //   18: aload_2
    //   19: aload_1
    //   20: invokevirtual 559	java/util/zip/GZIPOutputStream:write	([B)V
    //   23: aload_2
    //   24: invokevirtual 560	java/util/zip/GZIPOutputStream:close	()V
    //   27: aload_0
    //   28: invokevirtual 563	java/io/OutputStream:close	()V
    //   31: return
    //   32: astore_1
    //   33: aload_2
    //   34: invokevirtual 560	java/util/zip/GZIPOutputStream:close	()V
    //   37: aload_0
    //   38: invokevirtual 563	java/io/OutputStream:close	()V
    //   41: aload_1
    //   42: athrow
    //   43: new 272	java/io/IOException
    //   46: dup
    //   47: ldc_w 565
    //   50: invokespecial 566	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   53: athrow
    //   54: astore_0
    //   55: goto -24 -> 31
    //   58: astore_0
    //   59: goto -18 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	paramURLConnection	java.net.URLConnection
    //   0	62	1	paramArrayOfByte	byte[]
    //   17	17	2	localGZIPOutputStream	java.util.zip.GZIPOutputStream
    // Exception table:
    //   from	to	target	type
    //   18	23	32	finally
    //   23	31	54	java/io/IOException
    //   33	41	58	java/io/IOException
  }
  
  /* Error */
  @NonNull
  public InstallationResponse createFirebaseInstallation(@NonNull String paramString1, @Nullable String paramString2, @NonNull String paramString3, @NonNull String paramString4, @Nullable String paramString5)
    throws FirebaseInstallationsException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 142	com/google/firebase/installations/remote/FirebaseInstallationServiceClient:requestLimiter	Lcom/google/firebase/installations/remote/RequestLimiter;
    //   4: invokevirtual 571	com/google/firebase/installations/remote/RequestLimiter:isRequestAllowed	()Z
    //   7: ifeq +244 -> 251
    //   10: iconst_0
    //   11: istore 6
    //   13: aload_0
    //   14: ldc 26
    //   16: iconst_1
    //   17: anewarray 4	java/lang/Object
    //   20: dup
    //   21: iconst_0
    //   22: aload_3
    //   23: aastore
    //   24: invokestatic 177	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   27: invokespecial 573	com/google/firebase/installations/remote/FirebaseInstallationServiceClient:getFullyQualifiedRequestUri	(Ljava/lang/String;)Ljava/net/URL;
    //   30: astore 7
    //   32: iload 6
    //   34: iconst_1
    //   35: if_icmpgt +202 -> 237
    //   38: ldc 72
    //   40: invokestatic 578	android/net/TrafficStats:setThreadStatsTag	(I)V
    //   43: aload_0
    //   44: aload 7
    //   46: aload_1
    //   47: invokespecial 580	com/google/firebase/installations/remote/FirebaseInstallationServiceClient:openHttpURLConnection	(Ljava/net/URL;Ljava/lang/String;)Ljava/net/HttpURLConnection;
    //   50: astore 8
    //   52: aload 8
    //   54: ldc_w 582
    //   57: invokevirtual 585	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   60: aload 8
    //   62: iconst_1
    //   63: invokevirtual 588	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   66: aload 5
    //   68: ifnull +12 -> 80
    //   71: aload 8
    //   73: ldc 89
    //   75: aload 5
    //   77: invokevirtual 316	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   80: aload_0
    //   81: aload 8
    //   83: aload_2
    //   84: aload 4
    //   86: invokespecial 590	com/google/firebase/installations/remote/FirebaseInstallationServiceClient:writeFIDCreateRequestBodyToOutputStream	(Ljava/net/HttpURLConnection;Ljava/lang/String;Ljava/lang/String;)V
    //   89: aload 8
    //   91: invokevirtual 512	java/net/HttpURLConnection:getResponseCode	()I
    //   94: istore 9
    //   96: aload_0
    //   97: getfield 142	com/google/firebase/installations/remote/FirebaseInstallationServiceClient:requestLimiter	Lcom/google/firebase/installations/remote/RequestLimiter;
    //   100: iload 9
    //   102: invokevirtual 593	com/google/firebase/installations/remote/RequestLimiter:setNextRequestTime	(I)V
    //   105: iload 9
    //   107: invokestatic 595	com/google/firebase/installations/remote/FirebaseInstallationServiceClient:isSuccessfulResponseCode	(I)Z
    //   110: ifeq +24 -> 134
    //   113: aload_0
    //   114: aload 8
    //   116: invokespecial 597	com/google/firebase/installations/remote/FirebaseInstallationServiceClient:readCreateResponse	(Ljava/net/HttpURLConnection;)Lcom/google/firebase/installations/remote/InstallationResponse;
    //   119: astore 10
    //   121: aload 10
    //   123: astore_1
    //   124: aload 8
    //   126: invokevirtual 600	java/net/HttpURLConnection:disconnect	()V
    //   129: invokestatic 603	android/net/TrafficStats:clearThreadStatsTag	()V
    //   132: aload_1
    //   133: areturn
    //   134: aload 8
    //   136: aload 4
    //   138: aload_1
    //   139: aload_3
    //   140: invokestatic 605	com/google/firebase/installations/remote/FirebaseInstallationServiceClient:logFisCommunicationError	(Ljava/net/HttpURLConnection;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   143: iload 9
    //   145: sipush 429
    //   148: if_icmpeq +45 -> 193
    //   151: iload 9
    //   153: sipush 500
    //   156: if_icmplt +14 -> 170
    //   159: iload 9
    //   161: sipush 600
    //   164: if_icmpge +6 -> 170
    //   167: goto +56 -> 223
    //   170: invokestatic 607	com/google/firebase/installations/remote/FirebaseInstallationServiceClient:logBadConfigError	()V
    //   173: invokestatic 412	com/google/firebase/installations/remote/InstallationResponse:builder	()Lcom/google/firebase/installations/remote/InstallationResponse$Builder;
    //   176: getstatic 610	com/google/firebase/installations/remote/InstallationResponse$ResponseCode:BAD_CONFIG	Lcom/google/firebase/installations/remote/InstallationResponse$ResponseCode;
    //   179: invokevirtual 492	com/google/firebase/installations/remote/InstallationResponse$Builder:setResponseCode	(Lcom/google/firebase/installations/remote/InstallationResponse$ResponseCode;)Lcom/google/firebase/installations/remote/InstallationResponse$Builder;
    //   182: invokevirtual 495	com/google/firebase/installations/remote/InstallationResponse$Builder:build	()Lcom/google/firebase/installations/remote/InstallationResponse;
    //   185: astore 10
    //   187: aload 10
    //   189: astore_1
    //   190: goto -66 -> 124
    //   193: new 246	com/google/firebase/installations/FirebaseInstallationsException
    //   196: astore 10
    //   198: aload 10
    //   200: ldc_w 612
    //   203: getstatic 615	com/google/firebase/installations/FirebaseInstallationsException$Status:TOO_MANY_REQUESTS	Lcom/google/firebase/installations/FirebaseInstallationsException$Status;
    //   206: invokespecial 267	com/google/firebase/installations/FirebaseInstallationsException:<init>	(Ljava/lang/String;Lcom/google/firebase/installations/FirebaseInstallationsException$Status;)V
    //   209: aload 10
    //   211: athrow
    //   212: astore_1
    //   213: aload 8
    //   215: invokevirtual 600	java/net/HttpURLConnection:disconnect	()V
    //   218: invokestatic 603	android/net/TrafficStats:clearThreadStatsTag	()V
    //   221: aload_1
    //   222: athrow
    //   223: aload 8
    //   225: invokevirtual 600	java/net/HttpURLConnection:disconnect	()V
    //   228: invokestatic 603	android/net/TrafficStats:clearThreadStatsTag	()V
    //   231: iinc 6 1
    //   234: goto -202 -> 32
    //   237: new 246	com/google/firebase/installations/FirebaseInstallationsException
    //   240: dup
    //   241: ldc_w 352
    //   244: getstatic 264	com/google/firebase/installations/FirebaseInstallationsException$Status:UNAVAILABLE	Lcom/google/firebase/installations/FirebaseInstallationsException$Status;
    //   247: invokespecial 267	com/google/firebase/installations/FirebaseInstallationsException:<init>	(Ljava/lang/String;Lcom/google/firebase/installations/FirebaseInstallationsException$Status;)V
    //   250: athrow
    //   251: new 246	com/google/firebase/installations/FirebaseInstallationsException
    //   254: dup
    //   255: ldc_w 352
    //   258: getstatic 264	com/google/firebase/installations/FirebaseInstallationsException$Status:UNAVAILABLE	Lcom/google/firebase/installations/FirebaseInstallationsException$Status;
    //   261: invokespecial 267	com/google/firebase/installations/FirebaseInstallationsException:<init>	(Ljava/lang/String;Lcom/google/firebase/installations/FirebaseInstallationsException$Status;)V
    //   264: athrow
    //   265: astore 10
    //   267: goto -44 -> 223
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	270	0	this	FirebaseInstallationServiceClient
    //   0	270	1	paramString1	String
    //   0	270	2	paramString2	String
    //   0	270	3	paramString3	String
    //   0	270	4	paramString4	String
    //   0	270	5	paramString5	String
    //   11	221	6	i	int
    //   30	15	7	localURL	URL
    //   50	174	8	localHttpURLConnection	HttpURLConnection
    //   94	71	9	j	int
    //   119	91	10	localObject	Object
    //   265	1	10	localAssertionError	AssertionError
    // Exception table:
    //   from	to	target	type
    //   52	66	212	finally
    //   71	80	212	finally
    //   80	121	212	finally
    //   134	143	212	finally
    //   170	187	212	finally
    //   193	212	212	finally
    //   52	66	265	java/lang/AssertionError
    //   52	66	265	java/io/IOException
    //   71	80	265	java/lang/AssertionError
    //   71	80	265	java/io/IOException
    //   80	121	265	java/lang/AssertionError
    //   80	121	265	java/io/IOException
    //   134	143	265	java/lang/AssertionError
    //   134	143	265	java/io/IOException
    //   170	187	265	java/lang/AssertionError
    //   170	187	265	java/io/IOException
    //   193	212	265	java/lang/AssertionError
    //   193	212	265	java/io/IOException
  }
  
  /* Error */
  @NonNull
  public void deleteFirebaseInstallation(@NonNull String paramString1, @NonNull String paramString2, @NonNull String paramString3, @NonNull String paramString4)
    throws FirebaseInstallationsException
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_0
    //   4: ldc 29
    //   6: iconst_2
    //   7: anewarray 4	java/lang/Object
    //   10: dup
    //   11: iconst_0
    //   12: aload_3
    //   13: aastore
    //   14: dup
    //   15: iconst_1
    //   16: aload_2
    //   17: aastore
    //   18: invokestatic 177	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   21: invokespecial 573	com/google/firebase/installations/remote/FirebaseInstallationServiceClient:getFullyQualifiedRequestUri	(Ljava/lang/String;)Ljava/net/URL;
    //   24: astore 6
    //   26: iload 5
    //   28: iconst_1
    //   29: if_icmpgt +182 -> 211
    //   32: ldc 74
    //   34: invokestatic 578	android/net/TrafficStats:setThreadStatsTag	(I)V
    //   37: aload_0
    //   38: aload 6
    //   40: aload_1
    //   41: invokespecial 580	com/google/firebase/installations/remote/FirebaseInstallationServiceClient:openHttpURLConnection	(Ljava/net/URL;Ljava/lang/String;)Ljava/net/HttpURLConnection;
    //   44: astore_2
    //   45: aload_2
    //   46: ldc_w 619
    //   49: invokevirtual 585	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   52: new 158	java/lang/StringBuilder
    //   55: astore 7
    //   57: aload 7
    //   59: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   62: aload 7
    //   64: ldc_w 621
    //   67: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload 7
    //   73: aload 4
    //   75: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload_2
    //   80: ldc_w 623
    //   83: aload 7
    //   85: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokevirtual 316	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   91: aload_2
    //   92: invokevirtual 512	java/net/HttpURLConnection:getResponseCode	()I
    //   95: istore 8
    //   97: iload 8
    //   99: sipush 200
    //   102: if_icmpeq +91 -> 193
    //   105: iload 8
    //   107: sipush 401
    //   110: if_icmpeq +83 -> 193
    //   113: iload 8
    //   115: sipush 404
    //   118: if_icmpne +6 -> 124
    //   121: goto +72 -> 193
    //   124: aload_2
    //   125: aconst_null
    //   126: aload_1
    //   127: aload_3
    //   128: invokestatic 605	com/google/firebase/installations/remote/FirebaseInstallationServiceClient:logFisCommunicationError	(Ljava/net/HttpURLConnection;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   131: iload 8
    //   133: sipush 429
    //   136: if_icmpeq +44 -> 180
    //   139: iload 8
    //   141: sipush 500
    //   144: if_icmplt +14 -> 158
    //   147: iload 8
    //   149: sipush 600
    //   152: if_icmpge +6 -> 158
    //   155: goto +25 -> 180
    //   158: invokestatic 607	com/google/firebase/installations/remote/FirebaseInstallationServiceClient:logBadConfigError	()V
    //   161: new 246	com/google/firebase/installations/FirebaseInstallationsException
    //   164: astore 7
    //   166: aload 7
    //   168: ldc_w 625
    //   171: getstatic 627	com/google/firebase/installations/FirebaseInstallationsException$Status:BAD_CONFIG	Lcom/google/firebase/installations/FirebaseInstallationsException$Status;
    //   174: invokespecial 267	com/google/firebase/installations/FirebaseInstallationsException:<init>	(Ljava/lang/String;Lcom/google/firebase/installations/FirebaseInstallationsException$Status;)V
    //   177: aload 7
    //   179: athrow
    //   180: iinc 5 1
    //   183: aload_2
    //   184: invokevirtual 600	java/net/HttpURLConnection:disconnect	()V
    //   187: invokestatic 603	android/net/TrafficStats:clearThreadStatsTag	()V
    //   190: goto -164 -> 26
    //   193: aload_2
    //   194: invokevirtual 600	java/net/HttpURLConnection:disconnect	()V
    //   197: invokestatic 603	android/net/TrafficStats:clearThreadStatsTag	()V
    //   200: return
    //   201: astore_1
    //   202: aload_2
    //   203: invokevirtual 600	java/net/HttpURLConnection:disconnect	()V
    //   206: invokestatic 603	android/net/TrafficStats:clearThreadStatsTag	()V
    //   209: aload_1
    //   210: athrow
    //   211: new 246	com/google/firebase/installations/FirebaseInstallationsException
    //   214: dup
    //   215: ldc_w 352
    //   218: getstatic 264	com/google/firebase/installations/FirebaseInstallationsException$Status:UNAVAILABLE	Lcom/google/firebase/installations/FirebaseInstallationsException$Status;
    //   221: invokespecial 267	com/google/firebase/installations/FirebaseInstallationsException:<init>	(Ljava/lang/String;Lcom/google/firebase/installations/FirebaseInstallationsException$Status;)V
    //   224: athrow
    //   225: astore 7
    //   227: goto -47 -> 180
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	230	0	this	FirebaseInstallationServiceClient
    //   0	230	1	paramString1	String
    //   0	230	2	paramString2	String
    //   0	230	3	paramString3	String
    //   0	230	4	paramString4	String
    //   1	180	5	i	int
    //   24	15	6	localURL	URL
    //   55	123	7	localObject	Object
    //   225	1	7	localIOException	IOException
    //   95	58	8	j	int
    // Exception table:
    //   from	to	target	type
    //   45	97	201	finally
    //   124	131	201	finally
    //   158	180	201	finally
    //   45	97	225	java/io/IOException
    //   124	131	225	java/io/IOException
    //   158	180	225	java/io/IOException
  }
  
  /* Error */
  @NonNull
  public TokenResult generateAuthToken(@NonNull String paramString1, @NonNull String paramString2, @NonNull String paramString3, @NonNull String paramString4)
    throws FirebaseInstallationsException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 142	com/google/firebase/installations/remote/FirebaseInstallationServiceClient:requestLimiter	Lcom/google/firebase/installations/remote/RequestLimiter;
    //   4: invokevirtual 571	com/google/firebase/installations/remote/RequestLimiter:isRequestAllowed	()Z
    //   7: ifeq +295 -> 302
    //   10: iconst_0
    //   11: istore 5
    //   13: aload_0
    //   14: ldc 49
    //   16: iconst_2
    //   17: anewarray 4	java/lang/Object
    //   20: dup
    //   21: iconst_0
    //   22: aload_3
    //   23: aastore
    //   24: dup
    //   25: iconst_1
    //   26: aload_2
    //   27: aastore
    //   28: invokestatic 177	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   31: invokespecial 573	com/google/firebase/installations/remote/FirebaseInstallationServiceClient:getFullyQualifiedRequestUri	(Ljava/lang/String;)Ljava/net/URL;
    //   34: astore 6
    //   36: iload 5
    //   38: iconst_1
    //   39: if_icmpgt +249 -> 288
    //   42: ldc 78
    //   44: invokestatic 578	android/net/TrafficStats:setThreadStatsTag	(I)V
    //   47: aload_0
    //   48: aload 6
    //   50: aload_1
    //   51: invokespecial 580	com/google/firebase/installations/remote/FirebaseInstallationServiceClient:openHttpURLConnection	(Ljava/net/URL;Ljava/lang/String;)Ljava/net/HttpURLConnection;
    //   54: astore 7
    //   56: aload 7
    //   58: ldc_w 582
    //   61: invokevirtual 585	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   64: new 158	java/lang/StringBuilder
    //   67: astore_2
    //   68: aload_2
    //   69: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   72: aload_2
    //   73: ldc_w 621
    //   76: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload_2
    //   81: aload 4
    //   83: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload 7
    //   89: ldc_w 623
    //   92: aload_2
    //   93: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokevirtual 316	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: aload 7
    //   101: iconst_1
    //   102: invokevirtual 588	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   105: aload_0
    //   106: aload 7
    //   108: invokespecial 631	com/google/firebase/installations/remote/FirebaseInstallationServiceClient:writeGenerateAuthTokenRequestBodyToOutputStream	(Ljava/net/HttpURLConnection;)V
    //   111: aload 7
    //   113: invokevirtual 512	java/net/HttpURLConnection:getResponseCode	()I
    //   116: istore 8
    //   118: aload_0
    //   119: getfield 142	com/google/firebase/installations/remote/FirebaseInstallationServiceClient:requestLimiter	Lcom/google/firebase/installations/remote/RequestLimiter;
    //   122: iload 8
    //   124: invokevirtual 593	com/google/firebase/installations/remote/RequestLimiter:setNextRequestTime	(I)V
    //   127: iload 8
    //   129: invokestatic 595	com/google/firebase/installations/remote/FirebaseInstallationServiceClient:isSuccessfulResponseCode	(I)Z
    //   132: ifeq +22 -> 154
    //   135: aload_0
    //   136: aload 7
    //   138: invokespecial 633	com/google/firebase/installations/remote/FirebaseInstallationServiceClient:readGenerateAuthTokenResponse	(Ljava/net/HttpURLConnection;)Lcom/google/firebase/installations/remote/TokenResult;
    //   141: astore_2
    //   142: aload_2
    //   143: astore_1
    //   144: aload 7
    //   146: invokevirtual 600	java/net/HttpURLConnection:disconnect	()V
    //   149: invokestatic 603	android/net/TrafficStats:clearThreadStatsTag	()V
    //   152: aload_1
    //   153: areturn
    //   154: aload 7
    //   156: aconst_null
    //   157: aload_1
    //   158: aload_3
    //   159: invokestatic 605	com/google/firebase/installations/remote/FirebaseInstallationServiceClient:logFisCommunicationError	(Ljava/net/HttpURLConnection;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   162: iload 8
    //   164: sipush 401
    //   167: if_icmpeq +78 -> 245
    //   170: iload 8
    //   172: sipush 404
    //   175: if_icmpne +6 -> 181
    //   178: goto +67 -> 245
    //   181: iload 8
    //   183: sipush 429
    //   186: if_icmpeq +43 -> 229
    //   189: iload 8
    //   191: sipush 500
    //   194: if_icmplt +14 -> 208
    //   197: iload 8
    //   199: sipush 600
    //   202: if_icmpge +6 -> 208
    //   205: goto +69 -> 274
    //   208: invokestatic 607	com/google/firebase/installations/remote/FirebaseInstallationServiceClient:logBadConfigError	()V
    //   211: invokestatic 407	com/google/firebase/installations/remote/TokenResult:builder	()Lcom/google/firebase/installations/remote/TokenResult$Builder;
    //   214: getstatic 635	com/google/firebase/installations/remote/TokenResult$ResponseCode:BAD_CONFIG	Lcom/google/firebase/installations/remote/TokenResult$ResponseCode;
    //   217: invokevirtual 530	com/google/firebase/installations/remote/TokenResult$Builder:setResponseCode	(Lcom/google/firebase/installations/remote/TokenResult$ResponseCode;)Lcom/google/firebase/installations/remote/TokenResult$Builder;
    //   220: invokevirtual 469	com/google/firebase/installations/remote/TokenResult$Builder:build	()Lcom/google/firebase/installations/remote/TokenResult;
    //   223: astore_2
    //   224: aload_2
    //   225: astore_1
    //   226: goto -82 -> 144
    //   229: new 246	com/google/firebase/installations/FirebaseInstallationsException
    //   232: astore_2
    //   233: aload_2
    //   234: ldc_w 612
    //   237: getstatic 615	com/google/firebase/installations/FirebaseInstallationsException$Status:TOO_MANY_REQUESTS	Lcom/google/firebase/installations/FirebaseInstallationsException$Status;
    //   240: invokespecial 267	com/google/firebase/installations/FirebaseInstallationsException:<init>	(Ljava/lang/String;Lcom/google/firebase/installations/FirebaseInstallationsException$Status;)V
    //   243: aload_2
    //   244: athrow
    //   245: invokestatic 407	com/google/firebase/installations/remote/TokenResult:builder	()Lcom/google/firebase/installations/remote/TokenResult$Builder;
    //   248: getstatic 638	com/google/firebase/installations/remote/TokenResult$ResponseCode:AUTH_ERROR	Lcom/google/firebase/installations/remote/TokenResult$ResponseCode;
    //   251: invokevirtual 530	com/google/firebase/installations/remote/TokenResult$Builder:setResponseCode	(Lcom/google/firebase/installations/remote/TokenResult$ResponseCode;)Lcom/google/firebase/installations/remote/TokenResult$Builder;
    //   254: invokevirtual 469	com/google/firebase/installations/remote/TokenResult$Builder:build	()Lcom/google/firebase/installations/remote/TokenResult;
    //   257: astore_2
    //   258: aload_2
    //   259: astore_1
    //   260: goto -116 -> 144
    //   263: astore_1
    //   264: aload 7
    //   266: invokevirtual 600	java/net/HttpURLConnection:disconnect	()V
    //   269: invokestatic 603	android/net/TrafficStats:clearThreadStatsTag	()V
    //   272: aload_1
    //   273: athrow
    //   274: aload 7
    //   276: invokevirtual 600	java/net/HttpURLConnection:disconnect	()V
    //   279: invokestatic 603	android/net/TrafficStats:clearThreadStatsTag	()V
    //   282: iinc 5 1
    //   285: goto -249 -> 36
    //   288: new 246	com/google/firebase/installations/FirebaseInstallationsException
    //   291: dup
    //   292: ldc_w 352
    //   295: getstatic 264	com/google/firebase/installations/FirebaseInstallationsException$Status:UNAVAILABLE	Lcom/google/firebase/installations/FirebaseInstallationsException$Status;
    //   298: invokespecial 267	com/google/firebase/installations/FirebaseInstallationsException:<init>	(Ljava/lang/String;Lcom/google/firebase/installations/FirebaseInstallationsException$Status;)V
    //   301: athrow
    //   302: new 246	com/google/firebase/installations/FirebaseInstallationsException
    //   305: dup
    //   306: ldc_w 352
    //   309: getstatic 264	com/google/firebase/installations/FirebaseInstallationsException$Status:UNAVAILABLE	Lcom/google/firebase/installations/FirebaseInstallationsException$Status;
    //   312: invokespecial 267	com/google/firebase/installations/FirebaseInstallationsException:<init>	(Ljava/lang/String;Lcom/google/firebase/installations/FirebaseInstallationsException$Status;)V
    //   315: athrow
    //   316: astore_2
    //   317: goto -43 -> 274
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	320	0	this	FirebaseInstallationServiceClient
    //   0	320	1	paramString1	String
    //   0	320	2	paramString2	String
    //   0	320	3	paramString3	String
    //   0	320	4	paramString4	String
    //   11	272	5	i	int
    //   34	15	6	localURL	URL
    //   54	221	7	localHttpURLConnection	HttpURLConnection
    //   116	87	8	j	int
    // Exception table:
    //   from	to	target	type
    //   56	142	263	finally
    //   154	162	263	finally
    //   208	224	263	finally
    //   229	245	263	finally
    //   245	258	263	finally
    //   56	142	316	java/lang/AssertionError
    //   56	142	316	java/io/IOException
    //   154	162	316	java/lang/AssertionError
    //   154	162	316	java/io/IOException
    //   208	224	316	java/lang/AssertionError
    //   208	224	316	java/io/IOException
    //   229	245	316	java/lang/AssertionError
    //   229	245	316	java/io/IOException
    //   245	258	316	java/lang/AssertionError
    //   245	258	316	java/io/IOException
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\installations\remote\FirebaseInstallationServiceClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */