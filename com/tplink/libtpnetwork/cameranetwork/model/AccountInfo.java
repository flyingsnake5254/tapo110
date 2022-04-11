package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;

public final class AccountInfo
{
  @c("secname")
  private final String group;
  @c("passwd")
  private String newPassword;
  @c("old_passwd")
  private String oldPassword;
  @c("ciphertext")
  private final String passwordEncrypted;
  private String username;
  
  public AccountInfo(Account paramAccount, String paramString)
  {
    this("root", paramAccount.getUsername(), com.tplink.libtpnetwork.cameranetwork.util.j.a(paramString), paramAccount.getPassword(), com.tplink.libtpnetwork.cameranetwork.util.j.d(com.tplink.libtpnetwork.cameranetwork.util.j.a(paramString)));
  }
  
  public AccountInfo(String paramString1, String paramString2)
  {
    this("third_account", paramString1, com.tplink.libtpnetwork.cameranetwork.util.j.a(paramString2), "", com.tplink.libtpnetwork.cameranetwork.util.j.d(paramString2));
  }
  
  public AccountInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.group = paramString1;
    this.username = paramString2;
    this.newPassword = paramString3;
    this.oldPassword = paramString4;
    this.passwordEncrypted = paramString5;
  }
  
  public final String component1()
  {
    return this.group;
  }
  
  public final String component2()
  {
    return this.username;
  }
  
  public final String component3()
  {
    return this.newPassword;
  }
  
  public final String component4()
  {
    return this.oldPassword;
  }
  
  public final String component5()
  {
    return this.passwordEncrypted;
  }
  
  public final AccountInfo copy(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    kotlin.jvm.internal.j.e(paramString1, "group");
    kotlin.jvm.internal.j.e(paramString2, "username");
    kotlin.jvm.internal.j.e(paramString3, "newPassword");
    kotlin.jvm.internal.j.e(paramString4, "oldPassword");
    kotlin.jvm.internal.j.e(paramString5, "passwordEncrypted");
    return new AccountInfo(paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof AccountInfo))
      {
        paramObject = (AccountInfo)paramObject;
        if ((kotlin.jvm.internal.j.a(this.group, ((AccountInfo)paramObject).group)) && (kotlin.jvm.internal.j.a(this.username, ((AccountInfo)paramObject).username)) && (kotlin.jvm.internal.j.a(this.newPassword, ((AccountInfo)paramObject).newPassword)) && (kotlin.jvm.internal.j.a(this.oldPassword, ((AccountInfo)paramObject).oldPassword)) && (kotlin.jvm.internal.j.a(this.passwordEncrypted, ((AccountInfo)paramObject).passwordEncrypted))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getGroup()
  {
    return this.group;
  }
  
  public final String getNewPassword()
  {
    return this.newPassword;
  }
  
  public final String getOldPassword()
  {
    return this.oldPassword;
  }
  
  public final String getPasswordEncrypted()
  {
    return this.passwordEncrypted;
  }
  
  public final String getUsername()
  {
    return this.username;
  }
  
  public int hashCode()
  {
    String str = this.group;
    int i = 0;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.username;
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    str = this.newPassword;
    int m;
    if (str != null) {
      m = str.hashCode();
    } else {
      m = 0;
    }
    str = this.oldPassword;
    int n;
    if (str != null) {
      n = str.hashCode();
    } else {
      n = 0;
    }
    str = this.passwordEncrypted;
    if (str != null) {
      i = str.hashCode();
    }
    return (((j * 31 + k) * 31 + m) * 31 + n) * 31 + i;
  }
  
  public final void setNewPassword(String paramString)
  {
    kotlin.jvm.internal.j.e(paramString, "<set-?>");
    this.newPassword = paramString;
  }
  
  public final void setOldPassword(String paramString)
  {
    kotlin.jvm.internal.j.e(paramString, "<set-?>");
    this.oldPassword = paramString;
  }
  
  public final void setUsername(String paramString)
  {
    kotlin.jvm.internal.j.e(paramString, "<set-?>");
    this.username = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AccountInfo(group=");
    localStringBuilder.append(this.group);
    localStringBuilder.append(", username=");
    localStringBuilder.append(this.username);
    localStringBuilder.append(", newPassword=");
    localStringBuilder.append(this.newPassword);
    localStringBuilder.append(", oldPassword=");
    localStringBuilder.append(this.oldPassword);
    localStringBuilder.append(", passwordEncrypted=");
    localStringBuilder.append(this.passwordEncrypted);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\AccountInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */