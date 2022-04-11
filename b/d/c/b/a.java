package b.d.c.b;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.tplink.libtpanalytics.bean.AppUpdateParams;
import com.tplink.libtpanalytics.bean.EncryptedEventParam;
import com.tplink.libtpanalytics.bean.ExceptionParams;
import com.tplink.libtpanalytics.bean.GAParams;
import com.tplink.libtpanalytics.bean.OSUpdateParams;
import com.tplink.libtpanalytics.bean.PlaintextEventParam;
import com.tplink.libtpanalytics.bean.ScreenViewParams;
import com.tplink.libtpanalytics.core.define.e;
import com.tplink.libtpanalytics.core.define.f;

public class a
{
  private static final Gson a = new Gson();
  
  public static <T> com.tplink.libtpanalytics.database.d.b a(b<T> paramb)
  {
    com.tplink.libtpanalytics.database.d.b localb = new com.tplink.libtpanalytics.database.d.b();
    localb.s(paramb.a());
    localb.u(1021);
    com.tplink.libtpanalytics.utils.c.b(localb, paramb.c());
    Object localObject1 = paramb.c().e().b();
    Object localObject2 = paramb.a();
    ((String)localObject2).hashCode();
    int i = ((String)localObject2).hashCode();
    int j = -1;
    switch (i)
    {
    default: 
      break;
    case 2126010101: 
      if (((String)localObject2).equals("ga_event")) {
        j = 9;
      }
      break;
    case 1805085941: 
      if (((String)localObject2).equals("enter_background")) {
        j = 8;
      }
      break;
    case 1665367940: 
      if (((String)localObject2).equals("os_update")) {
        j = 7;
      }
      break;
    case 1337476263: 
      if (((String)localObject2).equals("app_update")) {
        j = 6;
      }
      break;
    case 1066479505: 
      if (((String)localObject2).equals("app_launch")) {
        j = 5;
      }
      break;
    case 826769674: 
      if (((String)localObject2).equals("enter_foreground")) {
        j = 4;
      }
      break;
    case 200597881: 
      if (((String)localObject2).equals("session_start")) {
        j = 3;
      }
      break;
    case -43018600: 
      if (((String)localObject2).equals("screen_view")) {
        j = 2;
      }
      break;
    case -229571277: 
      if (((String)localObject2).equals("user_engagement")) {
        j = 1;
      }
      break;
    case -520302671: 
      if (((String)localObject2).equals("app_exception")) {
        j = 0;
      }
      break;
    }
    Object localObject3;
    Object localObject4;
    switch (j)
    {
    default: 
      return null;
    case 9: 
      localObject3 = (GAParams)paramb.b();
      localObject4 = ((GAParams)localObject3).getCategory();
      localObject2 = ((GAParams)localObject3).getAction();
      String str1 = ((GAParams)localObject3).getLabel();
      String str2 = ((GAParams)localObject3).getValue();
      localObject3 = new EncryptedEventParam();
      ((EncryptedEventParam)localObject3).setNetWorkType(paramb.c().e().i());
      ((EncryptedEventParam)localObject3).setScreenClass(com.tplink.libtpanalytics.utils.b.f().g());
      ((EncryptedEventParam)localObject3).setCategory((String)localObject4);
      ((EncryptedEventParam)localObject3).setAction((String)localObject2);
      if (!TextUtils.isEmpty(str1)) {
        ((EncryptedEventParam)localObject3).setLabel(str1);
      }
      if (!TextUtils.isEmpty(str2)) {
        ((EncryptedEventParam)localObject3).setValue(str2);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        ((EncryptedEventParam)localObject3).setAccountId((String)localObject1);
      }
      paramb = new PlaintextEventParam();
      paramb.setSessionId(f.a().b());
      paramb.setScreenClass(com.tplink.libtpanalytics.utils.l.c.d(com.tplink.libtpanalytics.utils.b.f().g()));
      paramb.setCategory(com.tplink.libtpanalytics.utils.l.c.d((String)localObject4));
      paramb.setAction(com.tplink.libtpanalytics.utils.l.c.d((String)localObject2));
      localObject1 = a;
      localb.q(((Gson)localObject1).u(localObject3));
      localb.w(((Gson)localObject1).u(paramb));
      break;
    case 7: 
      localObject4 = (OSUpdateParams)paramb.b();
      localObject2 = new EncryptedEventParam();
      ((EncryptedEventParam)localObject2).setNetWorkType(paramb.c().e().i());
      ((EncryptedEventParam)localObject2).setLastVersion(((OSUpdateParams)localObject4).getLastVersion());
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        ((EncryptedEventParam)localObject2).setAccountId((String)localObject1);
      }
      localObject1 = new PlaintextEventParam();
      ((PlaintextEventParam)localObject1).setSessionId(f.a().b());
      paramb = a;
      localb.q(paramb.u(localObject2));
      localb.w(paramb.u(localObject1));
      break;
    case 6: 
      localObject4 = (AppUpdateParams)paramb.b();
      localObject2 = new EncryptedEventParam();
      ((EncryptedEventParam)localObject2).setNetWorkType(paramb.c().e().i());
      ((EncryptedEventParam)localObject2).setLastVersion(((AppUpdateParams)localObject4).getLastVersion());
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        ((EncryptedEventParam)localObject2).setAccountId((String)localObject1);
      }
      localObject1 = new PlaintextEventParam();
      ((PlaintextEventParam)localObject1).setSessionId(f.a().b());
      paramb = a;
      localb.q(paramb.u(localObject2));
      localb.w(paramb.u(localObject1));
      break;
    case 5: 
      localObject2 = new EncryptedEventParam();
      ((EncryptedEventParam)localObject2).setNetWorkType(paramb.c().e().i());
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        ((EncryptedEventParam)localObject2).setAccountId((String)localObject1);
      }
      paramb = new PlaintextEventParam();
      paramb.setSessionId(f.a().b());
      localObject1 = a;
      localb.q(((Gson)localObject1).u(localObject2));
      localb.w(((Gson)localObject1).u(paramb));
      break;
    case 2: 
      localObject3 = (ScreenViewParams)paramb.b();
      localObject4 = ((ScreenViewParams)localObject3).getLastScreenClass();
      localObject2 = new EncryptedEventParam();
      ((EncryptedEventParam)localObject2).setNetWorkType(paramb.c().e().i());
      if (TextUtils.isEmpty(((ScreenViewParams)localObject3).getScreenClass())) {
        ((EncryptedEventParam)localObject2).setScreenClass(com.tplink.libtpanalytics.utils.b.f().g());
      } else {
        ((EncryptedEventParam)localObject2).setScreenClass(((ScreenViewParams)localObject3).getScreenClass());
      }
      if (!TextUtils.isEmpty((CharSequence)localObject4)) {
        ((EncryptedEventParam)localObject2).setLastScreenClass((String)localObject4);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        ((EncryptedEventParam)localObject2).setAccountId((String)localObject1);
      }
      paramb = new PlaintextEventParam();
      paramb.setSessionId(f.a().b());
      if (TextUtils.isEmpty(((ScreenViewParams)localObject3).getScreenClass())) {
        paramb.setScreenClass(com.tplink.libtpanalytics.utils.l.c.d(com.tplink.libtpanalytics.utils.b.f().g()));
      } else {
        paramb.setScreenClass(com.tplink.libtpanalytics.utils.l.c.d(((ScreenViewParams)localObject3).getScreenClass()));
      }
      if (!TextUtils.isEmpty((CharSequence)localObject4)) {
        paramb.setLastScreenClass(com.tplink.libtpanalytics.utils.l.c.d((String)localObject4));
      }
      localObject1 = a;
      localb.q(((Gson)localObject1).u(localObject2));
      localb.w(((Gson)localObject1).u(paramb));
      break;
    case 1: 
    case 3: 
    case 4: 
    case 8: 
      localObject2 = new EncryptedEventParam();
      ((EncryptedEventParam)localObject2).setNetWorkType(paramb.c().e().i());
      ((EncryptedEventParam)localObject2).setScreenClass(com.tplink.libtpanalytics.utils.b.f().g());
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        ((EncryptedEventParam)localObject2).setAccountId((String)localObject1);
      }
      paramb = new PlaintextEventParam();
      paramb.setSessionId(f.a().b());
      paramb.setScreenClass(com.tplink.libtpanalytics.utils.l.c.d(com.tplink.libtpanalytics.utils.b.f().g()));
      localObject1 = a;
      localb.q(((Gson)localObject1).u(localObject2));
      localb.w(((Gson)localObject1).u(paramb));
      break;
    case 0: 
      localObject4 = (ExceptionParams)paramb.b();
      localObject2 = new EncryptedEventParam();
      ((EncryptedEventParam)localObject2).setNetWorkType(paramb.c().e().i());
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        ((EncryptedEventParam)localObject2).setAccountId((String)localObject1);
      }
      ((EncryptedEventParam)localObject2).setScreenClass(com.tplink.libtpanalytics.utils.b.f().g());
      ((EncryptedEventParam)localObject2).setContent(((ExceptionParams)localObject4).getContent());
      paramb = new PlaintextEventParam();
      paramb.setSessionId(f.a().b());
      paramb.setScreenClass(com.tplink.libtpanalytics.utils.l.c.d(com.tplink.libtpanalytics.utils.b.f().g()));
      paramb.setExceptionTimeStamp(((ExceptionParams)localObject4).getExceptionTime());
      localObject1 = a;
      localb.q(((Gson)localObject1).u(localObject2));
      localb.w(((Gson)localObject1).u(paramb));
    }
    return localb;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\c\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */