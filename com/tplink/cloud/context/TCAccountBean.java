package com.tplink.cloud.context;

import android.text.TextUtils;
import b.d.w.h.b;
import com.tplink.cloud.define.EnumAccountStatus;
import java.io.Serializable;

public class TCAccountBean
  implements Serializable
{
  private String accountId;
  private EnumAccountStatus accountStatus = EnumAccountStatus.ACCOUNT_STATUS_UNREGISTERED;
  private String avatarUrl;
  private String cloudUserName;
  private String countryCode;
  private String email;
  private String nickName;
  private String password;
  private String phone;
  private String refreshToken;
  private String regTime;
  private String token;
  private String userName;
  
  public TCAccountBean() {}
  
  public TCAccountBean(String paramString1, String paramString2)
  {
    this.cloudUserName = paramString1;
    this.password = paramString2;
  }
  
  public TCAccountBean(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, EnumAccountStatus paramEnumAccountStatus, String paramString9, String paramString10, String paramString11)
  {
    this.accountId = paramString1;
    this.email = paramString2;
    this.cloudUserName = paramString3;
    this.phone = paramString4;
    this.userName = paramString5;
    this.password = paramString6;
    this.nickName = paramString7;
    this.regTime = paramString8;
    this.accountStatus = paramEnumAccountStatus;
    this.token = paramString9;
    this.refreshToken = paramString10;
    this.avatarUrl = paramString11;
  }
  
  public String getAccountId()
  {
    return this.accountId;
  }
  
  public EnumAccountStatus getAccountStatus()
  {
    return this.accountStatus;
  }
  
  public String getAvatarUrl()
  {
    return this.avatarUrl;
  }
  
  public String getCloudUserName()
  {
    return this.cloudUserName;
  }
  
  public String getCountryCode()
  {
    return this.countryCode;
  }
  
  public String getDisplayUserName()
  {
    Object localObject1 = getNickName();
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = getUserName();
    }
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = b.b(getEmail());
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = b.b(getCloudUserName());
    }
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = getCloudUserName();
    }
    return (String)localObject1;
  }
  
  public String getEmail()
  {
    return this.email;
  }
  
  public String getNickName()
  {
    return this.nickName;
  }
  
  public String getPassword()
  {
    return this.password;
  }
  
  public String getPhone()
  {
    return this.phone;
  }
  
  public String getRefreshToken()
  {
    return this.refreshToken;
  }
  
  public String getRegTime()
  {
    return this.regTime;
  }
  
  public String getToken()
  {
    return this.token;
  }
  
  public String getUserName()
  {
    return this.userName;
  }
  
  public boolean isAccountInfoFullValid()
  {
    boolean bool;
    if ((!TextUtils.isEmpty(this.cloudUserName)) && (!TextUtils.isEmpty(this.token)) && (!TextUtils.isEmpty(this.password))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isAccountInfoValid()
  {
    boolean bool;
    if ((!TextUtils.isEmpty(this.cloudUserName)) && ((!TextUtils.isEmpty(this.token)) || (!TextUtils.isEmpty(this.password)))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void setAccountId(String paramString)
  {
    this.accountId = paramString;
  }
  
  public void setAccountStatus(EnumAccountStatus paramEnumAccountStatus)
  {
    this.accountStatus = paramEnumAccountStatus;
  }
  
  public void setAvatarUrl(String paramString)
  {
    this.avatarUrl = paramString;
  }
  
  public void setCloudUserName(String paramString)
  {
    this.cloudUserName = paramString;
  }
  
  public void setCountryCode(String paramString)
  {
    this.countryCode = paramString;
  }
  
  public void setEmail(String paramString)
  {
    this.email = paramString;
  }
  
  public void setNickName(String paramString)
  {
    this.nickName = paramString;
  }
  
  public void setPassword(String paramString)
  {
    this.password = paramString;
  }
  
  public void setPhone(String paramString)
  {
    this.phone = paramString;
  }
  
  public void setRefreshToken(String paramString)
  {
    this.refreshToken = paramString;
  }
  
  public void setRegTime(String paramString)
  {
    this.regTime = paramString;
  }
  
  public void setToken(String paramString)
  {
    this.token = paramString;
  }
  
  public void setUserName(String paramString)
  {
    this.userName = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\context\TCAccountBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */