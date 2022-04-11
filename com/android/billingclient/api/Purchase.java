package com.android.billingclient.api;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class Purchase
{
  private final String a;
  private final String b;
  private final JSONObject c;
  
  public Purchase(@NonNull String paramString1, @NonNull String paramString2)
    throws JSONException
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = new JSONObject(paramString1);
  }
  
  @NonNull
  public String a()
  {
    return this.c.optString("orderId");
  }
  
  @NonNull
  public String b()
  {
    return this.a;
  }
  
  @NonNull
  public String c()
  {
    return this.c.optString("packageName");
  }
  
  @NonNull
  public String d()
  {
    JSONObject localJSONObject = this.c;
    return localJSONObject.optString("token", localJSONObject.optString("purchaseToken"));
  }
  
  @NonNull
  public String e()
  {
    return this.b;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Purchase)) {
      return false;
    }
    paramObject = (Purchase)paramObject;
    return (TextUtils.equals(this.a, ((Purchase)paramObject).b())) && (TextUtils.equals(this.b, ((Purchase)paramObject).e()));
  }
  
  @NonNull
  public String f()
  {
    return this.c.optString("productId");
  }
  
  public boolean g()
  {
    return this.c.optBoolean("acknowledged", true);
  }
  
  public boolean h()
  {
    return this.c.optBoolean("autoRenewing");
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
  
  @NonNull
  public String toString()
  {
    String str = String.valueOf(this.a);
    if (str.length() != 0) {
      str = "Purchase. Json: ".concat(str);
    } else {
      str = new String("Purchase. Json: ");
    }
    return str;
  }
  
  public static class a
  {
    @Nullable
    private final List<Purchase> a;
    private final g b;
    
    public a(@NonNull g paramg, @Nullable List<Purchase> paramList)
    {
      this.a = paramList;
      this.b = paramg;
    }
    
    @NonNull
    public g a()
    {
      return this.b;
    }
    
    @Nullable
    public List<Purchase> b()
    {
      return this.a;
    }
    
    public int c()
    {
      return a().a();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\android\billingclient\api\Purchase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */