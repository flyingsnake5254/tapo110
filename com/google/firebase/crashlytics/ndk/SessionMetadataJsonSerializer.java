package com.google.firebase.crashlytics.ndk;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class SessionMetadataJsonSerializer
{
  static String serializeBeginSession(String paramString1, String paramString2, long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("session_id", paramString1);
    localHashMap.put("generator", paramString2);
    localHashMap.put("started_at_seconds", Long.valueOf(paramLong));
    return new JSONObject(localHashMap).toString();
  }
  
  static String serializeSessionApp(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("app_identifier", paramString1);
    localHashMap.put("version_code", paramString2);
    localHashMap.put("version_name", paramString3);
    localHashMap.put("install_uuid", paramString4);
    localHashMap.put("delivery_mechanism", Integer.valueOf(paramInt));
    localHashMap.put("unity_version", paramString5);
    return new JSONObject(localHashMap).toString();
  }
  
  static String serializeSessionDevice(int paramInt1, String paramString1, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, int paramInt3, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("arch", Integer.valueOf(paramInt1));
    localHashMap.put("build_model", paramString1);
    localHashMap.put("available_processors", Integer.valueOf(paramInt2));
    localHashMap.put("total_ram", Long.valueOf(paramLong1));
    localHashMap.put("disk_space", Long.valueOf(paramLong2));
    localHashMap.put("is_emulator", Boolean.valueOf(paramBoolean));
    localHashMap.put("state", Integer.valueOf(paramInt3));
    localHashMap.put("build_manufacturer", paramString2);
    localHashMap.put("build_product", paramString3);
    return new JSONObject(localHashMap).toString();
  }
  
  static String serializeSessionOs(String paramString1, String paramString2, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("version", paramString1);
    localHashMap.put("build_version", paramString2);
    localHashMap.put("is_rooted", Boolean.valueOf(paramBoolean));
    return new JSONObject(localHashMap).toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\ndk\SessionMetadataJsonSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */