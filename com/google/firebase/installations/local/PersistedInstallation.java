package com.google.firebase.installations.local;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.firebase.FirebaseApp;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class PersistedInstallation
{
  private static final String AUTH_TOKEN_KEY = "AuthToken";
  private static final String EXPIRES_IN_SECONDS_KEY = "ExpiresInSecs";
  private static final String FIREBASE_INSTALLATION_ID_KEY = "Fid";
  private static final String FIS_ERROR_KEY = "FisError";
  private static final String PERSISTED_STATUS_KEY = "Status";
  private static final String REFRESH_TOKEN_KEY = "RefreshToken";
  private static final String SETTINGS_FILE_NAME_PREFIX = "PersistedInstallation";
  private static final String TOKEN_CREATION_TIME_IN_SECONDS_KEY = "TokenCreationEpochInSecs";
  private final File dataFile;
  @NonNull
  private final FirebaseApp firebaseApp;
  
  public PersistedInstallation(@NonNull FirebaseApp paramFirebaseApp)
  {
    File localFile = paramFirebaseApp.getApplicationContext().getFilesDir();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PersistedInstallation.");
    localStringBuilder.append(paramFirebaseApp.getPersistenceKey());
    localStringBuilder.append(".json");
    this.dataFile = new File(localFile, localStringBuilder.toString());
    this.firebaseApp = paramFirebaseApp;
  }
  
  /* Error */
  private JSONObject readJSONFromFile()
  {
    // Byte code:
    //   0: new 91	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 92	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_1
    //   8: sipush 16384
    //   11: newarray <illegal type>
    //   13: astore_2
    //   14: new 94	java/io/FileInputStream
    //   17: astore_3
    //   18: aload_3
    //   19: aload_0
    //   20: getfield 79	com/google/firebase/installations/local/PersistedInstallation:dataFile	Ljava/io/File;
    //   23: invokespecial 97	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   26: aload_3
    //   27: aload_2
    //   28: iconst_0
    //   29: sipush 16384
    //   32: invokevirtual 101	java/io/FileInputStream:read	([BII)I
    //   35: istore 4
    //   37: iload 4
    //   39: ifge +21 -> 60
    //   42: new 103	org/json/JSONObject
    //   45: astore_2
    //   46: aload_2
    //   47: aload_1
    //   48: invokevirtual 104	java/io/ByteArrayOutputStream:toString	()Ljava/lang/String;
    //   51: invokespecial 107	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   54: aload_3
    //   55: invokevirtual 110	java/io/FileInputStream:close	()V
    //   58: aload_2
    //   59: areturn
    //   60: aload_1
    //   61: aload_2
    //   62: iconst_0
    //   63: iload 4
    //   65: invokevirtual 114	java/io/ByteArrayOutputStream:write	([BII)V
    //   68: goto -42 -> 26
    //   71: astore_1
    //   72: aload_3
    //   73: invokevirtual 110	java/io/FileInputStream:close	()V
    //   76: goto +9 -> 85
    //   79: astore_3
    //   80: aload_1
    //   81: aload_3
    //   82: invokevirtual 120	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   85: aload_1
    //   86: athrow
    //   87: astore_3
    //   88: new 103	org/json/JSONObject
    //   91: dup
    //   92: invokespecial 121	org/json/JSONObject:<init>	()V
    //   95: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	PersistedInstallation
    //   7	54	1	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   71	15	1	localObject1	Object
    //   13	49	2	localObject2	Object
    //   17	56	3	localFileInputStream	java.io.FileInputStream
    //   79	3	3	localThrowable	Throwable
    //   87	1	3	localIOException	IOException
    //   35	29	4	i	int
    // Exception table:
    //   from	to	target	type
    //   26	37	71	finally
    //   42	54	71	finally
    //   60	68	71	finally
    //   72	76	79	finally
    //   14	26	87	java/io/IOException
    //   14	26	87	org/json/JSONException
    //   54	58	87	java/io/IOException
    //   54	58	87	org/json/JSONException
    //   80	85	87	java/io/IOException
    //   80	85	87	org/json/JSONException
    //   85	87	87	java/io/IOException
    //   85	87	87	org/json/JSONException
  }
  
  public void clearForTesting()
  {
    this.dataFile.delete();
  }
  
  @NonNull
  public PersistedInstallationEntry insertOrUpdatePersistedInstallationEntry(@NonNull PersistedInstallationEntry paramPersistedInstallationEntry)
  {
    try
    {
      JSONObject localJSONObject = new org/json/JSONObject;
      localJSONObject.<init>();
      localJSONObject.put("Fid", paramPersistedInstallationEntry.getFirebaseInstallationId());
      localJSONObject.put("Status", paramPersistedInstallationEntry.getRegistrationStatus().ordinal());
      localJSONObject.put("AuthToken", paramPersistedInstallationEntry.getAuthToken());
      localJSONObject.put("RefreshToken", paramPersistedInstallationEntry.getRefreshToken());
      localJSONObject.put("TokenCreationEpochInSecs", paramPersistedInstallationEntry.getTokenCreationEpochInSecs());
      localJSONObject.put("ExpiresInSecs", paramPersistedInstallationEntry.getExpiresInSecs());
      localJSONObject.put("FisError", paramPersistedInstallationEntry.getFisError());
      Object localObject = File.createTempFile("PersistedInstallation", "tmp", this.firebaseApp.getApplicationContext().getFilesDir());
      FileOutputStream localFileOutputStream = new java/io/FileOutputStream;
      localFileOutputStream.<init>((File)localObject);
      localFileOutputStream.write(localJSONObject.toString().getBytes("UTF-8"));
      localFileOutputStream.close();
      if (!((File)localObject).renameTo(this.dataFile))
      {
        localObject = new java/io/IOException;
        ((IOException)localObject).<init>("unable to rename the tmpfile to PersistedInstallation");
        throw ((Throwable)localObject);
      }
    }
    catch (JSONException|IOException localJSONException)
    {
      for (;;) {}
    }
    return paramPersistedInstallationEntry;
  }
  
  @NonNull
  public PersistedInstallationEntry readPersistedInstallationEntryValue()
  {
    Object localObject = readJSONFromFile();
    String str1 = ((JSONObject)localObject).optString("Fid", null);
    int i = ((JSONObject)localObject).optInt("Status", RegistrationStatus.ATTEMPT_MIGRATION.ordinal());
    String str2 = ((JSONObject)localObject).optString("AuthToken", null);
    String str3 = ((JSONObject)localObject).optString("RefreshToken", null);
    long l1 = ((JSONObject)localObject).optLong("TokenCreationEpochInSecs", 0L);
    long l2 = ((JSONObject)localObject).optLong("ExpiresInSecs", 0L);
    localObject = ((JSONObject)localObject).optString("FisError", null);
    return PersistedInstallationEntry.builder().setFirebaseInstallationId(str1).setRegistrationStatus(RegistrationStatus.values()[i]).setAuthToken(str2).setRefreshToken(str3).setTokenCreationEpochInSecs(l1).setExpiresInSecs(l2).setFisError((String)localObject).build();
  }
  
  public static enum RegistrationStatus
  {
    static
    {
      RegistrationStatus localRegistrationStatus1 = new RegistrationStatus("ATTEMPT_MIGRATION", 0);
      ATTEMPT_MIGRATION = localRegistrationStatus1;
      RegistrationStatus localRegistrationStatus2 = new RegistrationStatus("NOT_GENERATED", 1);
      NOT_GENERATED = localRegistrationStatus2;
      RegistrationStatus localRegistrationStatus3 = new RegistrationStatus("UNREGISTERED", 2);
      UNREGISTERED = localRegistrationStatus3;
      RegistrationStatus localRegistrationStatus4 = new RegistrationStatus("REGISTERED", 3);
      REGISTERED = localRegistrationStatus4;
      RegistrationStatus localRegistrationStatus5 = new RegistrationStatus("REGISTER_ERROR", 4);
      REGISTER_ERROR = localRegistrationStatus5;
      $VALUES = new RegistrationStatus[] { localRegistrationStatus1, localRegistrationStatus2, localRegistrationStatus3, localRegistrationStatus4, localRegistrationStatus5 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\installations\local\PersistedInstallation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */