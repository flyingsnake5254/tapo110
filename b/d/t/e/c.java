package b.d.t.e;

import com.google.gson.i;
import com.google.gson.k;

public class c
{
  public static String a(String paramString1, int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, int paramInt4, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt5)
  {
    k localk = new k();
    localk.m("device_id", paramString1);
    localk.l("p2p_type", Integer.valueOf(paramInt1));
    localk.l("stream_type", Integer.valueOf(paramInt2));
    localk.l("resolution", Integer.valueOf(paramInt3));
    localk.l("start_time", Long.valueOf(paramLong1));
    localk.l("end_time", Long.valueOf(paramLong2));
    localk.l("audio_mode", Integer.valueOf(paramInt4));
    localk.m("device_username", paramString2);
    localk.m("device_password", paramString3);
    localk.m("control_host", paramString4);
    localk.m("control_host_p2p", paramString5);
    return localk.toString();
  }
  
  public static String b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt1, int paramInt2, int paramInt3, String paramString8, String paramString9, String paramString10, boolean paramBoolean, String paramString11)
  {
    k localk = new k();
    localk.m("client_hwaddr", paramString1);
    localk.m("client_type", paramString2);
    localk.m("device_id", paramString3);
    localk.m("tplink_id", paramString4);
    localk.m("user_token", paramString5);
    localk.m("client_uuid", paramString6);
    localk.m("platform_model", paramString7);
    localk.l("p2p_type", Integer.valueOf(paramInt1));
    localk.l("stream_type", Integer.valueOf(paramInt2));
    localk.l("resolution", Integer.valueOf(paramInt3));
    localk.m("server_addr", paramString8);
    localk.m("https_server_addr", paramString9);
    localk.m("boundary", paramString10);
    localk.l("is_support_iot", Integer.valueOf(paramBoolean));
    localk.m("app_cid", paramString11);
    return localk.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\t\e\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */