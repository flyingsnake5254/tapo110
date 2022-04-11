package com.tplink.libtpnetwork.Utils;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.k;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.cloud.define.EnumAccountStatus;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.WirelessInfoParams;
import com.tplink.libtputility.security.PlainEncryptKeyDelegate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class o
  extends b.d.w.g.a
{
  private static Context c;
  private static volatile o d;
  private com.tplink.libtputility.security.a e;
  
  private o()
  {
    super(c, "aria_sp");
    q0();
  }
  
  public static String E()
  {
    String str = b.d.s.a.a.f().c().getCloudUserName();
    if (!TextUtils.isEmpty(str)) {
      return b.d.w.h.a.g(str);
    }
    return "";
  }
  
  public static void G0(Context paramContext)
  {
    c = paramContext;
  }
  
  public static Set<String> M()
  {
    o localo = h0();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_home_mode_can_show_device");
    localStringBuilder.append(E());
    return localo.g(localStringBuilder.toString());
  }
  
  public static void N0()
  {
    o localo = h0();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_first_edit_away_mode");
    localStringBuilder.append(E());
    localo.h(localStringBuilder.toString(), false);
  }
  
  public static void O0()
  {
    o localo = h0();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_first_edit_home_mode");
    localStringBuilder.append(E());
    localo.h(localStringBuilder.toString(), false);
  }
  
  public static void S0(Set<String> paramSet)
  {
    o localo = h0();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_home_mode_can_show_device");
    localStringBuilder.append(E());
    localo.m(localStringBuilder.toString(), paramSet);
  }
  
  public static o h0()
  {
    if (d == null) {
      try
      {
        if (d == null)
        {
          o localo = new com/tplink/libtpnetwork/Utils/o;
          localo.<init>();
          d = localo;
        }
      }
      finally {}
    }
    return d;
  }
  
  public static boolean k0()
  {
    o localo = h0();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_first_edit_away_mode");
    localStringBuilder.append(E());
    return localo.c(localStringBuilder.toString(), true);
  }
  
  public static boolean l0()
  {
    o localo = h0();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_first_edit_home_mode");
    localStringBuilder.append(E());
    return localo.c(localStringBuilder.toString(), true);
  }
  
  private void o()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = b().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((localEntry.getValue() instanceof String)) {
        localArrayList.add(localEntry.getKey());
      }
    }
    n(localArrayList);
  }
  
  private void q0()
  {
    Object localObject1 = com.tplink.libtputility.security.b.c();
    Object localObject2;
    Object localObject3;
    if ((((com.tplink.libtputility.security.b)localObject1).f("deco_sp_file_key")) && (a("deco_sp_key")) && (a("deco_sp_vector")))
    {
      localObject2 = super.f("deco_sp_key", "");
      localObject3 = super.f("deco_sp_vector", "");
      if ((!((String)localObject2).isEmpty()) && (!((String)localObject3).isEmpty()))
      {
        localObject2 = ((com.tplink.libtputility.security.b)localObject1).a((String)localObject2, "deco_sp_file_key");
        localObject3 = ((com.tplink.libtputility.security.b)localObject1).a((String)localObject3, "deco_sp_file_key");
        if ((localObject2 != null) && (!((String)localObject2).isEmpty()) && (localObject3 != null) && (!((String)localObject3).isEmpty())) {
          this.e = new com.tplink.libtputility.security.a((String)localObject2, (String)localObject3);
        } else {
          this.e = r((com.tplink.libtputility.security.b)localObject1);
        }
      }
      else
      {
        this.e = r((com.tplink.libtputility.security.b)localObject1);
      }
    }
    else
    {
      ((com.tplink.libtputility.security.b)localObject1).e(c, "deco_sp_file_key");
      if ((a("deco_sp_key")) || (a("deco_sp_vector"))) {
        o();
      }
      localObject3 = new HashMap();
      localObject2 = new com.tplink.libtputility.security.a();
      this.e = ((com.tplink.libtputility.security.a)localObject2);
      String str = ((com.tplink.libtputility.security.a)localObject2).h();
      localObject2 = this.e.g();
      str = ((com.tplink.libtputility.security.b)localObject1).b(str, "deco_sp_file_key");
      localObject1 = ((com.tplink.libtputility.security.b)localObject1).b((String)localObject2, "deco_sp_file_key");
      if ((str != null) && (!str.isEmpty()) && (localObject1 != null) && (!((String)localObject1).isEmpty()))
      {
        ((Map)localObject3).put("deco_sp_key", str);
        ((Map)localObject3).put("deco_sp_vector", localObject1);
        l((Map)localObject3);
      }
      else
      {
        this.e = null;
      }
    }
  }
  
  private com.tplink.libtputility.security.a r(com.tplink.libtputility.security.b paramb)
  {
    o();
    com.tplink.libtputility.security.a locala = new com.tplink.libtputility.security.a();
    String str1 = locala.h();
    String str2 = locala.g();
    str1 = paramb.b(str1, "deco_sp_file_key");
    paramb = paramb.b(str2, "deco_sp_file_key");
    if ((str1 != null) && (!str1.isEmpty()) && (paramb != null) && (!paramb.isEmpty()))
    {
      super.k("deco_sp_key", str1);
      super.k("deco_sp_vector", paramb);
      paramb = locala;
    }
    else
    {
      paramb = null;
    }
    return paramb;
  }
  
  public static Set<String> x()
  {
    o localo = h0();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_away_mode_can_show_device");
    localStringBuilder.append(E());
    return localo.g(localStringBuilder.toString());
  }
  
  private String y()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_has_connected_ap_list");
    localStringBuilder.append(b.d.s.a.a.f().c().getCloudUserName());
    return localStringBuilder.toString();
  }
  
  public static void z0(Set<String> paramSet)
  {
    o localo = h0();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_away_mode_can_show_device");
    localStringBuilder.append(E());
    localo.m(localStringBuilder.toString(), paramSet);
  }
  
  public String A(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_camera_need_pay_function_list");
    localStringBuilder.append(paramString);
    return f(localStringBuilder.toString(), null);
  }
  
  public void A0(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_camera_need_pay_function_list");
    localStringBuilder.append(paramString1);
    k(localStringBuilder.toString(), paramString2);
  }
  
  public boolean B(String paramString)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("sp_showed_conflict_flag_");
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(E());
    localStringBuilder2.append(paramString);
    localStringBuilder1.append(b.d.w.h.a.g(localStringBuilder2.toString()));
    return c(localStringBuilder1.toString(), true);
  }
  
  public void B0()
  {
    h("first_time_apply_camera_permission", false);
  }
  
  public boolean C(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_cloud_video_has_show_");
    localStringBuilder.append(b.d.w.h.a.g(paramString));
    return c(localStringBuilder.toString(), false);
  }
  
  public void C0(String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("sp_showed_conflict_flag_");
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(E());
    localStringBuilder2.append(paramString);
    localStringBuilder1.append(b.d.w.h.a.g(localStringBuilder2.toString()));
    h(localStringBuilder1.toString(), paramBoolean);
  }
  
  public boolean D()
  {
    return c("sp_color_bulb_guide_set_preset_key", false);
  }
  
  public void D0()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_check_google_service");
    localStringBuilder.append(E());
    h(localStringBuilder.toString(), true);
  }
  
  public void E0(String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_cloud_video_has_show_");
    localStringBuilder.append(b.d.w.h.a.g(paramString));
    h(localStringBuilder.toString(), paramBoolean);
  }
  
  public long F()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_detail_banner_close_time_");
    localStringBuilder.append(E());
    return e(localStringBuilder.toString(), 0L);
  }
  
  public void F0(boolean paramBoolean)
  {
    h("sp_color_bulb_guide_set_preset_key", paramBoolean);
  }
  
  public long G()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_detail_banner_close_time_");
    localStringBuilder.append(E());
    return e(localStringBuilder.toString(), 0L);
  }
  
  public long H()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_downgrade_timestamp_");
    localStringBuilder.append(E());
    return e(localStringBuilder.toString(), 0L);
  }
  
  public void H0(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_detail_banner_close_time_");
    localStringBuilder.append(E());
    j(localStringBuilder.toString(), paramLong);
  }
  
  public int I()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_downgrade_handel_show_times_");
    localStringBuilder.append(E());
    return d(localStringBuilder.toString(), 0);
  }
  
  public void I0(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_detail_banner_close_time_");
    localStringBuilder.append(E());
    j(localStringBuilder.toString(), paramLong);
  }
  
  public boolean J(String paramString)
  {
    if (paramString != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sp_email_topic_has_subscribe_");
      localStringBuilder.append(b.d.w.h.a.g(paramString));
      return c(localStringBuilder.toString(), false);
    }
    return false;
  }
  
  public void J0(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_downgrade_timestamp_");
    localStringBuilder.append(E());
    j(localStringBuilder.toString(), paramLong);
  }
  
  public int K(String paramString)
  {
    if (paramString != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sp_email_topic_has_show_times_");
      localStringBuilder.append(b.d.w.h.a.g(paramString));
      return d(localStringBuilder.toString(), 0);
    }
    return 0;
  }
  
  public void K0(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_downgrade_handel_show_times_");
    localStringBuilder.append(E());
    i(localStringBuilder.toString(), paramInt);
  }
  
  public boolean L()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_region_different_utc_");
    localStringBuilder.append(E());
    return c(localStringBuilder.toString(), false);
  }
  
  public void L0(String paramString, boolean paramBoolean)
  {
    if (paramString != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sp_email_topic_has_subscribe_");
      localStringBuilder.append(b.d.w.h.a.g(paramString));
      h(localStringBuilder.toString(), paramBoolean);
    }
  }
  
  public void M0(String paramString, int paramInt)
  {
    if (paramString != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sp_email_topic_has_show_times_");
      localStringBuilder.append(b.d.w.h.a.g(paramString));
      i(localStringBuilder.toString(), paramInt);
    }
  }
  
  public boolean N()
  {
    return c("sp_is_first_open_music_rhyme", true);
  }
  
  public boolean O()
  {
    return c("is_first_show_home_tips", true);
  }
  
  public TCAccountBean P()
  {
    Object localObject1 = f("LAST_LOGIN_ACCOUNT_KEY", "");
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return null;
    }
    try
    {
      Object localObject2 = new org/json/JSONObject;
      ((JSONObject)localObject2).<init>((String)localObject1);
      String str1 = ((JSONObject)localObject2).optString("cloudUserName", "");
      if (TextUtils.isEmpty(str1)) {
        return null;
      }
      String str2 = ((JSONObject)localObject2).optString("cloudPassword");
      localObject1 = new com/tplink/cloud/context/TCAccountBean;
      ((TCAccountBean)localObject1).<init>();
      Object localObject3 = b.d.w.h.a.f(PlainEncryptKeyDelegate.a(c).getBytes("utf-8"));
      com.tplink.libtputility.security.a locala = new com/tplink/libtputility/security/a;
      locala.<init>((byte[])localObject3, null, "AES");
      localObject3 = new java/lang/String;
      ((String)localObject3).<init>(locala.b(b.d.w.h.a.j(str1)));
      ((TCAccountBean)localObject1).setCloudUserName((String)localObject3);
      if (!TextUtils.isEmpty(str2))
      {
        str1 = new java/lang/String;
        str1.<init>(locala.b(b.d.w.h.a.j(str2)));
        ((TCAccountBean)localObject1).setPassword(str1);
      }
      ((TCAccountBean)localObject1).setEmail(((JSONObject)localObject2).optString("email"));
      ((TCAccountBean)localObject1).setUserName(((JSONObject)localObject2).optString("username"));
      ((TCAccountBean)localObject1).setPhone(((JSONObject)localObject2).optString("phone"));
      ((TCAccountBean)localObject1).setNickName(((JSONObject)localObject2).optString("nickname"));
      ((TCAccountBean)localObject1).setRegTime(((JSONObject)localObject2).optString("regTime"));
      ((TCAccountBean)localObject1).setAccountStatus(EnumAccountStatus.getStatusByInt(((JSONObject)localObject2).optInt("status")));
      str2 = ((JSONObject)localObject2).optString("token");
      if (!TextUtils.isEmpty(str2))
      {
        str1 = new java/lang/String;
        str1.<init>(locala.b(b.d.w.h.a.j(str2)));
        ((TCAccountBean)localObject1).setToken(str1);
      }
      localObject2 = ((JSONObject)localObject2).optString("refreshToken");
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        str2 = new java/lang/String;
        str2.<init>(locala.b(b.d.w.h.a.j((String)localObject2)));
        ((TCAccountBean)localObject1).setRefreshToken(str2);
      }
      return (TCAccountBean)localObject1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return null;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }
  
  public void P0()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_voice_control_guide_key_");
    localStringBuilder.append(E());
    h(localStringBuilder.toString(), true);
  }
  
  public String Q()
  {
    return f("last_post_fcm_token", null);
  }
  
  public void Q0()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_subscribe_msg_init_flag_");
    localStringBuilder.append(E());
    h(localStringBuilder.toString(), true);
  }
  
  public long R(String paramString)
  {
    long l = 0L;
    if (paramString != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sp_last_time_email_topic_show_");
      localStringBuilder.append(b.d.w.h.a.g(paramString));
      l = e(localStringBuilder.toString(), 0L);
    }
    return l;
  }
  
  public void R0()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_region_different_utc_");
    localStringBuilder.append(E());
    h(localStringBuilder.toString(), true);
  }
  
  public String S(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("latest_iot_device_cache_");
    localStringBuilder.append(paramString);
    return f(localStringBuilder.toString(), "");
  }
  
  public boolean T()
  {
    return c("sp_light_strip_guide_set_preset_key", false);
  }
  
  public void T0(boolean paramBoolean)
  {
    h("sp_is_first_open_music_rhyme", paramBoolean);
  }
  
  public long U()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_preview_banner_close_time_");
    localStringBuilder.append(E());
    return e(localStringBuilder.toString(), 0L);
  }
  
  public void U0(boolean paramBoolean)
  {
    h("is_first_show_home_tips", paramBoolean);
  }
  
  public String V(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject1 = f(y(), "");
    Object localObject2;
    try
    {
      localObject1 = i.e((String)localObject1, WirelessInfoParams.class);
    }
    catch (Exception localException)
    {
      localObject2 = new ArrayList();
    }
    if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        WirelessInfoParams localWirelessInfoParams = (WirelessInfoParams)((Iterator)localObject2).next();
        if (TextUtils.equals(localWirelessInfoParams.getSsid(), paramString)) {
          return localWirelessInfoParams.getPassword();
        }
      }
    }
    return null;
  }
  
  public void V0(String paramString)
  {
    if (paramString != null) {
      k("last_post_fcm_token", paramString);
    }
  }
  
  public long W()
  {
    return e("sp_sys_notification_disabled_timestamp", 0L);
  }
  
  public void W0(String paramString, long paramLong)
  {
    if (paramString != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sp_last_time_email_topic_show_");
      localStringBuilder.append(b.d.w.h.a.g(paramString));
      j(localStringBuilder.toString(), paramLong);
    }
  }
  
  public int X()
  {
    return d("sp_smart_fragment_index", 0);
  }
  
  public void X0(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("latest_iot_device_cache_");
    localStringBuilder.append(paramString1);
    k(localStringBuilder.toString(), paramString2);
  }
  
  public boolean Y(String paramString)
  {
    if (paramString != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sp_storage_services_one_has_show_");
      localStringBuilder.append(b.d.w.h.a.g(paramString));
      return c(localStringBuilder.toString(), false);
    }
    return false;
  }
  
  public void Y0(boolean paramBoolean)
  {
    h("sp_light_strip_guide_set_preset_key", paramBoolean);
  }
  
  public boolean Z(String paramString)
  {
    if (paramString != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sp_storage_services_seven_has_show_");
      localStringBuilder.append(b.d.w.h.a.g(paramString));
      return c(localStringBuilder.toString(), false);
    }
    return false;
  }
  
  public void Z0(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_preview_banner_close_time_");
    localStringBuilder.append(E());
    j(localStringBuilder.toString(), paramLong);
  }
  
  public boolean a0(String paramString)
  {
    if (paramString != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sp_storage_services_three_has_show_");
      localStringBuilder.append(b.d.w.h.a.g(paramString));
      return c(localStringBuilder.toString(), false);
    }
    return false;
  }
  
  public void a1(WirelessInfoParams paramWirelessInfoParams)
  {
    List localList = z();
    if (!localList.isEmpty())
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext()) {
        if (TextUtils.equals(((WirelessInfoParams)localIterator.next()).getSsid(), paramWirelessInfoParams.getSsid())) {
          localIterator.remove();
        }
      }
    }
    localList.add(0, paramWirelessInfoParams);
    k(y(), i.f(localList));
  }
  
  public boolean b0()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_subscribe_msg_firmware_");
    localStringBuilder.append(E());
    return c(localStringBuilder.toString(), true);
  }
  
  public void b1(long paramLong)
  {
    j("sp_sys_notification_disabled_timestamp", paramLong);
  }
  
  public boolean c0()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_subscribe_msg_iac_market_promotion_");
    localStringBuilder.append(E());
    return c(localStringBuilder.toString(), true);
  }
  
  public void c1(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_first_click_preview_mode_");
    localStringBuilder.append(E());
    h(localStringBuilder.toString(), paramBoolean);
  }
  
  public boolean d0()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_subscribe_msg_init_flag_");
    localStringBuilder.append(E());
    return c(localStringBuilder.toString(), false);
  }
  
  public void d1(String paramString, boolean paramBoolean)
  {
    if (paramString != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sp_storage_services_one_has_show_");
      localStringBuilder.append(b.d.w.h.a.g(paramString));
      h(localStringBuilder.toString(), paramBoolean);
    }
  }
  
  public boolean e0()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_subscribe_msg_sdcard_");
    localStringBuilder.append(E());
    return c(localStringBuilder.toString(), true);
  }
  
  public void e1(String paramString, boolean paramBoolean)
  {
    if (paramString != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sp_storage_services_seven_has_show_");
      localStringBuilder.append(b.d.w.h.a.g(paramString));
      h(localStringBuilder.toString(), paramBoolean);
    }
  }
  
  public String f(String paramString1, String paramString2)
  {
    if (this.e != null)
    {
      String str = paramString1;
      if (b.d.w.h.b.c(paramString1)) {
        str = b.d.w.h.a.g(paramString1);
      }
      if (!a(str)) {
        return paramString2;
      }
      paramString1 = super.f(str, paramString2);
      try
      {
        paramString1 = this.e.a(paramString1);
        paramString2 = paramString1;
      }
      catch (Exception paramString1)
      {
        b.d.w.c.a.d(paramString1.toString());
      }
      return paramString2;
    }
    return super.f(paramString1, paramString2);
  }
  
  public boolean f0()
  {
    return c("sp_switch_vibrate_key", true);
  }
  
  public void f1(String paramString, boolean paramBoolean)
  {
    if (paramString != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sp_storage_services_three_has_show_");
      localStringBuilder.append(b.d.w.h.a.g(paramString));
      h(localStringBuilder.toString(), paramBoolean);
    }
  }
  
  public boolean g0(String paramString)
  {
    if (paramString != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sp_un_favorite_device_in_all_");
      localStringBuilder.append(b.d.w.h.a.g(paramString));
      return c(localStringBuilder.toString(), false);
    }
    return false;
  }
  
  public void g1(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_subscribe_msg_firmware_");
    localStringBuilder.append(E());
    h(localStringBuilder.toString(), paramBoolean);
  }
  
  public void h1(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_subscribe_msg_iac_market_promotion_");
    localStringBuilder.append(E());
    h(localStringBuilder.toString(), paramBoolean);
  }
  
  public boolean i0()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_check_google_service");
    localStringBuilder.append(E());
    return c(localStringBuilder.toString(), false);
  }
  
  public void i1(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_subscribe_msg_sdcard_");
    localStringBuilder.append(E());
    h(localStringBuilder.toString(), paramBoolean);
  }
  
  public boolean j0()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_first_click_preview_mode_");
    localStringBuilder.append(E());
    return c(localStringBuilder.toString(), true);
  }
  
  public void j1(boolean paramBoolean)
  {
    h("sp_switch_vibrate_key", paramBoolean);
  }
  
  public void k(String paramString1, String paramString2)
  {
    if (this.e != null)
    {
      String str = paramString1;
      if (b.d.w.h.b.c(paramString1)) {
        str = b.d.w.h.a.g(paramString1);
      }
      if (paramString2 == null) {
        paramString1 = null;
      }
      try
      {
        paramString1 = this.e.c(paramString2);
        super.k(str, paramString1);
      }
      catch (Exception paramString1)
      {
        b.d.w.c.a.d(paramString1.toString());
      }
    }
    else
    {
      super.k(paramString1, paramString2);
    }
  }
  
  public void k1(String paramString, boolean paramBoolean)
  {
    if (paramString != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sp_un_favorite_device_in_all_");
      localStringBuilder.append(b.d.w.h.a.g(paramString));
      h(localStringBuilder.toString(), paramBoolean);
    }
  }
  
  public void l1(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_showed_subscription_entrance_");
    localStringBuilder.append(b.d.w.h.a.g(paramString));
    h(localStringBuilder.toString(), true);
  }
  
  public boolean m0()
  {
    return c("first_time_apply_camera_permission", true);
  }
  
  public void m1(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("sp_showed_subscription_entrance_");
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(paramString1);
    localStringBuilder2.append(paramString2);
    localStringBuilder1.append(b.d.w.h.a.g(localStringBuilder2.toString()));
    h(localStringBuilder1.toString(), true);
  }
  
  public boolean n0()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_voice_control_guide_key_");
    localStringBuilder.append(E());
    return c(localStringBuilder.toString(), false);
  }
  
  public boolean o0(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_showed_subscription_entrance_");
    localStringBuilder.append(b.d.w.h.a.g(paramString));
    return c(localStringBuilder.toString(), false);
  }
  
  public void p()
  {
    String str = f("LAST_LOGIN_ACCOUNT_KEY", "");
    if (TextUtils.isEmpty(str)) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new org/json/JSONObject;
      localJSONObject.<init>(str);
      localJSONObject.put("cloudPassword", "");
      localJSONObject.put("token", "");
      localJSONObject.put("refreshToken", "");
      k("LAST_LOGIN_ACCOUNT_KEY", localJSONObject.toString());
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public boolean p0(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("sp_showed_subscription_entrance_");
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(paramString1);
    localStringBuilder2.append(paramString2);
    localStringBuilder1.append(b.d.w.h.a.g(localStringBuilder2.toString()));
    return c(localStringBuilder1.toString(), false);
  }
  
  public void q()
  {
    p();
    if (!u()) {
      k("LAST_LOGIN_ACCOUNT_KEY", new k().toString());
    }
  }
  
  public void r0(WirelessInfoParams paramWirelessInfoParams)
  {
    List localList = z();
    if (!localList.isEmpty())
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext()) {
        if (TextUtils.equals(((WirelessInfoParams)localIterator.next()).getSsid(), paramWirelessInfoParams.getSsid())) {
          localIterator.remove();
        }
      }
    }
    k(y(), i.f(localList));
  }
  
  public String s(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ACCOUNT_NICKNAME_PREFIX_");
    localStringBuilder.append(b.d.w.h.a.g(paramString));
    return f(localStringBuilder.toString(), "");
  }
  
  public void s0(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ACCOUNT_NICKNAME_PREFIX_");
      localStringBuilder.append(b.d.w.h.a.g(paramString1));
      k(localStringBuilder.toString(), paramString2);
    }
  }
  
  public String t(String paramString)
  {
    if (paramString != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sp_choose_region_");
      localStringBuilder.append(b.d.w.h.a.g(paramString));
      return f(localStringBuilder.toString(), null);
    }
    return null;
  }
  
  public void t0(TCAccountBean paramTCAccountBean)
  {
    if (paramTCAccountBean == null) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (!TextUtils.isEmpty(paramTCAccountBean.getEmail())) {
        localJSONObject.put("email", paramTCAccountBean.getEmail());
      }
      if (!TextUtils.isEmpty(paramTCAccountBean.getUserName())) {
        localJSONObject.put("username", paramTCAccountBean.getUserName());
      }
      if (!TextUtils.isEmpty(paramTCAccountBean.getPhone())) {
        localJSONObject.put("phone", paramTCAccountBean.getPhone());
      }
      byte[] arrayOfByte = b.d.w.h.a.f(PlainEncryptKeyDelegate.a(c).getBytes("utf-8"));
      com.tplink.libtputility.security.a locala = new com/tplink/libtputility/security/a;
      locala.<init>(arrayOfByte, null, "AES");
      if (!TextUtils.isEmpty(paramTCAccountBean.getCloudUserName())) {
        localJSONObject.put("cloudUserName", b.d.w.h.a.l(locala.d(paramTCAccountBean.getCloudUserName().getBytes())));
      }
      if (!TextUtils.isEmpty(paramTCAccountBean.getPassword())) {
        localJSONObject.put("cloudPassword", b.d.w.h.a.l(locala.d(paramTCAccountBean.getPassword().getBytes())));
      }
      if (!TextUtils.isEmpty(paramTCAccountBean.getNickName())) {
        localJSONObject.put("nickname", paramTCAccountBean.getNickName());
      }
      if (!TextUtils.isEmpty(paramTCAccountBean.getRegTime())) {
        localJSONObject.put("regTime", paramTCAccountBean.getRegTime());
      }
      localJSONObject.put("status", paramTCAccountBean.getAccountStatus().getValue());
      if (!TextUtils.isEmpty(paramTCAccountBean.getToken())) {
        localJSONObject.put("token", b.d.w.h.a.l(locala.d(paramTCAccountBean.getToken().getBytes())));
      }
      if (!TextUtils.isEmpty(paramTCAccountBean.getRefreshToken())) {
        localJSONObject.put("refreshToken", b.d.w.h.a.l(locala.d(paramTCAccountBean.getToken().getBytes())));
      }
      k("LAST_LOGIN_ACCOUNT_KEY", localJSONObject.toString());
    }
    catch (Exception paramTCAccountBean)
    {
      paramTCAccountBean.printStackTrace();
    }
    catch (JSONException paramTCAccountBean)
    {
      paramTCAccountBean.printStackTrace();
    }
  }
  
  public boolean u()
  {
    return c("accountRememberMe", true);
  }
  
  public void u0(int paramInt)
  {
    i("sp_smart_fragment_index", paramInt);
  }
  
  public boolean v()
  {
    return c("first_time_active_login_user", false);
  }
  
  public void v0(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sp_choose_region_");
      localStringBuilder.append(b.d.w.h.a.g(paramString1));
      k(localStringBuilder.toString(), paramString2);
    }
  }
  
  public long w(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("app_marketing_last_query_time_");
    localStringBuilder.append(paramString);
    return e(localStringBuilder.toString(), 0L);
  }
  
  public void w0(boolean paramBoolean)
  {
    h("accountRememberMe", paramBoolean);
  }
  
  public void x0(boolean paramBoolean)
  {
    h("first_time_active_login_user", paramBoolean);
  }
  
  public void y0(String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("app_marketing_last_query_time_");
    localStringBuilder.append(paramString);
    j(localStringBuilder.toString(), paramLong);
  }
  
  public List<WirelessInfoParams> z()
  {
    Object localObject = f(y(), "");
    ArrayList localArrayList1;
    try
    {
      localObject = i.e((String)localObject, WirelessInfoParams.class);
    }
    catch (Exception localException)
    {
      localArrayList1 = new ArrayList();
    }
    ArrayList localArrayList2 = localArrayList1;
    if (localArrayList1 == null) {
      localArrayList2 = new ArrayList();
    }
    return localArrayList2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\Utils\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */