package com.tplink.iot.view.ipcamera.setting.video;

import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.j;

public final class a
{
  public static final void a(Context paramContext, String paramString)
  {
    j.e(paramContext, "context");
    j.e(paramString, "deviceIdMD5");
    paramContext.startActivity(new Intent(paramContext, VideoQualityActivity.class).putExtra("device_id_md5", paramString));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\video\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */