package com.tplink.iot.Utils.z0;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.d.s.a.a;
import com.tplink.iot.view.quicksetup.base.EnumCountry;
import com.tplink.iot.view.quicksetup.sub.common.SubDeviceModel;
import com.tplink.iot.view.quicksetup.sub.common.d;
import com.tplink.iot.widget.DrawableEditText;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.FamilyManagerRepository;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.bean.DeviceModel;
import com.tplink.libtpnetwork.enumerate.EnumBulbAvatarType;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import com.tplink.libtpnetwork.enumerate.EnumHubAvatarType;
import com.tplink.libtpnetwork.enumerate.EnumIoTAvatarType;
import com.tplink.libtpnetwork.enumerate.EnumLightStripAvatarType;
import com.tplink.libtpnetwork.enumerate.EnumSwitchAvatarType;
import com.tplink.libtpnetwork.enumerate.EnumTRVAvatarType;

public class l
{
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    Object localObject = paramString;
    if (!paramString.contains("-")) {
      if (paramString.length() != 12)
      {
        localObject = paramString;
      }
      else
      {
        localObject = new StringBuilder();
        for (int i = 0; i < 12; i++)
        {
          ((StringBuilder)localObject).append(paramString.charAt(i));
          if ((i % 2 == 1) && (i <= 9)) {
            ((StringBuilder)localObject).append("-");
          }
        }
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    return (String)localObject;
  }
  
  public static String b(Context paramContext, @Nullable BaseALIoTDevice paramBaseALIoTDevice)
  {
    if (paramBaseALIoTDevice == null) {
      return "";
    }
    if (paramBaseALIoTDevice.isPlug()) {
      return q.e(paramBaseALIoTDevice);
    }
    if ((paramBaseALIoTDevice.isCamera()) && (!paramBaseALIoTDevice.isFirmwareSupportIoTCloud()) && ((paramBaseALIoTDevice instanceof ALCameraDevice))) {
      return h.h(paramContext, (ALCameraDevice)paramBaseALIoTDevice);
    }
    return h(paramBaseALIoTDevice);
  }
  
  @NonNull
  public static String c(Context paramContext, @Nullable BaseALIoTDevice paramBaseALIoTDevice)
  {
    if (paramBaseALIoTDevice == null) {
      return e(paramContext, null, null, null);
    }
    return e(paramContext, paramBaseALIoTDevice.getDeviceType(), paramBaseALIoTDevice.getDeviceName(), paramBaseALIoTDevice.getDeviceModel());
  }
  
  @NonNull
  public static String d(Context paramContext, String paramString1, String paramString2)
  {
    return e(paramContext, paramString1, paramString2, null);
  }
  
  @NonNull
  public static String e(Context paramContext, @Nullable String paramString1, String paramString2, @Nullable String paramString3)
  {
    if (!TextUtils.isEmpty(paramString2)) {
      return paramString2;
    }
    if (paramContext == null) {
      return "";
    }
    paramString1 = EnumDeviceType.fromType(paramString1);
    switch (a.a[paramString1.ordinal()])
    {
    default: 
      return paramContext.getString(2131954041, new Object[] { "" }).trim();
    case 7: 
      return paramContext.getString(2131954078);
    case 6: 
      return paramContext.getString(2131953370);
    case 5: 
      return paramContext.getString(2131954061);
    case 4: 
      return r.a(paramString3);
    case 3: 
      return paramContext.getString(2131954050);
    case 2: 
      return paramContext.getString(2131954032);
    }
    if (com.tplink.iot.g.b.c.c.i(paramString3)) {
      return paramContext.getString(2131954052);
    }
    return paramContext.getString(2131954029);
  }
  
  public static int f(EnumCountry paramEnumCountry, String paramString1, String paramString2)
  {
    paramString2 = EnumDeviceType.fromType(paramString2);
    if (EnumDeviceType.BULB == paramString2)
    {
      if (com.tplink.iot.g.b.c.c.i(paramString1)) {
        return com.tplink.iot.g.b.c.c.a(paramString1);
      }
      return g.a(paramString1);
    }
    if (EnumDeviceType.CAMERA == paramString2) {
      return com.tplink.iot.view.ipcamera.base.c.f(DeviceModel.fromValue(paramString1));
    }
    if (EnumDeviceType.HUB == paramString2) {
      return 2131689764;
    }
    if ((EnumDeviceType.SENSOR != paramString2) && (EnumDeviceType.SWITCH != paramString2) && (EnumDeviceType.ENERGY != paramString2)) {
      return q.a(paramEnumCountry, paramString1);
    }
    return d.a(SubDeviceModel.fromValue(paramString1));
  }
  
  @SuppressLint({"DefaultLocale"})
  public static String g(int paramInt)
  {
    float f = paramInt / 1000.0F;
    if (f < 0.1F) {
      return "<0.1";
    }
    return String.format("%.1f", new Object[] { Float.valueOf(f) });
  }
  
  public static String h(BaseALIoTDevice paramBaseALIoTDevice)
  {
    if ((paramBaseALIoTDevice != null) && (!paramBaseALIoTDevice.isUserRoleTypeDevice()))
    {
      String str = paramBaseALIoTDevice.getFamilyId();
      paramBaseALIoTDevice = paramBaseALIoTDevice.getRoomId();
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramBaseALIoTDevice)))
      {
        paramBaseALIoTDevice = ((FamilyManagerRepository)b.d.b.f.b.a(a.f(), FamilyManagerRepository.class)).f0(str, paramBaseALIoTDevice);
        if (TextUtils.isEmpty(paramBaseALIoTDevice)) {
          return "";
        }
        return paramBaseALIoTDevice;
      }
    }
    return "";
  }
  
  @SuppressLint({"DefaultLocale"})
  public static String i(int paramInt)
  {
    return String.format("%.1f", new Object[] { Float.valueOf(paramInt / 60.0F) });
  }
  
  private static int j(@NonNull BaseALIoTDevice<?> paramBaseALIoTDevice)
  {
    if (paramBaseALIoTDevice.isSwitch()) {
      return com.tplink.iot.g.c.a.b.a(EnumSwitchAvatarType.fromString(paramBaseALIoTDevice.getDeviceIcon()), paramBaseALIoTDevice.getDeviceModel());
    }
    if (com.tplink.iot.g.d.a.b.k(paramBaseALIoTDevice)) {
      return com.tplink.iot.g.d.a.b.f(EnumTRVAvatarType.fromString(paramBaseALIoTDevice.getDeviceIcon()));
    }
    return r.e(paramBaseALIoTDevice.getDeviceIcon(), paramBaseALIoTDevice.getDeviceModel());
  }
  
  public static int k(@NonNull BaseALIoTDevice<?> paramBaseALIoTDevice)
  {
    if (paramBaseALIoTDevice.isSwitch()) {
      return com.tplink.iot.g.c.a.b.b(EnumSwitchAvatarType.fromString(paramBaseALIoTDevice.getDeviceIcon()), paramBaseALIoTDevice.getDeviceModel());
    }
    if (com.tplink.iot.g.d.a.b.k(paramBaseALIoTDevice)) {
      return com.tplink.iot.g.d.a.b.g(EnumTRVAvatarType.fromString(paramBaseALIoTDevice.getDeviceIcon()));
    }
    return r.f(paramBaseALIoTDevice.getDeviceIcon(), paramBaseALIoTDevice.getDeviceModel());
  }
  
  public static String l(Context paramContext, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 7: 
      return paramContext.getString(2131954462);
    case 6: 
      return paramContext.getString(2131954460);
    case 5: 
      return paramContext.getString(2131954464);
    case 4: 
      return paramContext.getString(2131954466);
    case 3: 
      return paramContext.getString(2131954465);
    case 2: 
      return paramContext.getString(2131954461);
    }
    return paramContext.getString(2131954463);
  }
  
  public static void m(DrawableEditText paramDrawableEditText, String paramString)
  {
    n(paramDrawableEditText, paramString, 64);
  }
  
  private static void n(DrawableEditText paramDrawableEditText, String paramString, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramInt > 0))
    {
      if (paramString.getBytes().length <= paramInt)
      {
        paramDrawableEditText.setText(paramString);
        paramDrawableEditText.setSelection(paramString.length());
      }
      else
      {
        int i = paramString.length();
        for (int j = 1; (j < i) && (paramString.substring(0, j).getBytes().length <= paramInt); j++) {}
        if (j > 1)
        {
          paramString = paramString.substring(0, j - 1);
          paramDrawableEditText.setText(paramString);
          paramDrawableEditText.setSelection(paramString.length());
        }
        else
        {
          paramDrawableEditText.setText("");
          paramDrawableEditText.setSelection(0);
        }
      }
    }
    else
    {
      paramDrawableEditText.setText("");
      paramDrawableEditText.setSelection(0);
    }
  }
  
  public static void o(Context paramContext, @Nullable BaseALIoTDevice<?> paramBaseALIoTDevice, ImageView paramImageView)
  {
    if (paramBaseALIoTDevice == null)
    {
      paramImageView.setImageResource(2131690038);
      return;
    }
    if (paramBaseALIoTDevice.isBulb())
    {
      if (paramBaseALIoTDevice.isLightStrip()) {
        paramImageView.setImageResource(com.tplink.iot.g.b.c.c.b(EnumLightStripAvatarType.fromString(paramBaseALIoTDevice.getDeviceIcon())));
      } else {
        paramImageView.setImageResource(g.c(EnumBulbAvatarType.fromString(paramBaseALIoTDevice.getDeviceIcon())));
      }
    }
    else if ((paramBaseALIoTDevice.isCamera()) && ((paramBaseALIoTDevice instanceof ALCameraDevice))) {
      h.y(paramContext, (ALCameraDevice)paramBaseALIoTDevice, paramImageView);
    } else if (paramBaseALIoTDevice.isHub()) {
      paramImageView.setImageResource(p.d(EnumHubAvatarType.fromString(paramBaseALIoTDevice.getDeviceIcon())));
    } else if (paramBaseALIoTDevice.isSubDevice()) {
      paramImageView.setImageResource(j(paramBaseALIoTDevice));
    } else {
      paramImageView.setImageResource(q.g(EnumIoTAvatarType.fromString(paramBaseALIoTDevice.getDeviceIcon())));
    }
  }
  
  public static void p(Context paramContext, @Nullable BaseALIoTDevice<?> paramBaseALIoTDevice, @NonNull ImageView paramImageView)
  {
    if (paramBaseALIoTDevice == null)
    {
      paramImageView.setImageResource(2131690039);
      return;
    }
    if (paramBaseALIoTDevice.isBulb())
    {
      if (paramBaseALIoTDevice.isLightStrip()) {
        paramImageView.setImageResource(com.tplink.iot.g.b.c.c.c(EnumLightStripAvatarType.fromString(paramBaseALIoTDevice.getDeviceIcon())));
      } else {
        paramImageView.setImageResource(g.d(EnumBulbAvatarType.fromString(paramBaseALIoTDevice.getDeviceIcon())));
      }
    }
    else if ((paramBaseALIoTDevice.isCamera()) && ((paramBaseALIoTDevice instanceof ALCameraDevice))) {
      h.z(paramContext, (ALCameraDevice)paramBaseALIoTDevice, paramImageView);
    } else if (paramBaseALIoTDevice.isHub()) {
      paramImageView.setImageResource(p.e(EnumHubAvatarType.fromString(paramBaseALIoTDevice.getDeviceIcon())));
    } else if (paramBaseALIoTDevice.isSubDevice()) {
      paramImageView.setImageResource(k(paramBaseALIoTDevice));
    } else {
      paramImageView.setImageResource(q.h(EnumIoTAvatarType.fromString(paramBaseALIoTDevice.getDeviceIcon())));
    }
  }
  
  public static void q(Context paramContext, TextView paramTextView, int paramInt, Integer paramInteger, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramInteger != null))
    {
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      paramContext = new StringBuilder();
      paramContext.append(paramInteger);
      paramContext.append("(RSSI)");
      paramTextView.setText(paramContext.toString());
    }
    else
    {
      if (paramInt >= 3) {
        paramContext = paramContext.getResources().getDrawable(2131689853);
      } else if (paramInt == 2) {
        paramContext = paramContext.getResources().getDrawable(2131689852);
      } else {
        paramContext = paramContext.getResources().getDrawable(2131689851);
      }
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(paramContext, null, null, null);
      paramTextView.setText("");
    }
  }
  
  public static String r(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = paramString.indexOf(' ');
      String str = paramString;
      if (i != -1) {
        str = paramString.substring(0, i);
      }
      return str;
    }
    return "";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\z0\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */