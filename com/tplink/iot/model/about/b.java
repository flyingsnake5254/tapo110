package com.tplink.iot.model.about;

import android.text.TextUtils;
import com.tplink.cloud.context.TCAccountBean;

public class b
{
  private static String a()
  {
    String str = b.d.s.a.a.f().c().getCloudUserName();
    if (!TextUtils.isEmpty(str)) {
      return b.d.w.h.a.g(str);
    }
    return "";
  }
  
  public static String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("user_improvement_version_code_");
    localStringBuilder.append(a());
    return localStringBuilder.toString();
  }
  
  public static String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("upload_user_experience_improvement_enable_");
    localStringBuilder.append(a());
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\model\about\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */