package com.android.billingclient.api;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class SkuDetails
{
  private final String a;
  private final JSONObject b;
  
  public SkuDetails(@NonNull String paramString)
    throws JSONException
  {
    this.a = paramString;
    paramString = new JSONObject(paramString);
    this.b = paramString;
    if (!TextUtils.isEmpty(paramString.optString("productId")))
    {
      if (!TextUtils.isEmpty(paramString.optString("type"))) {
        return;
      }
      throw new IllegalArgumentException("SkuType cannot be empty.");
    }
    throw new IllegalArgumentException("SKU cannot be empty.");
  }
  
  @NonNull
  public String a()
  {
    return this.b.optString("description");
  }
  
  @NonNull
  public String b()
  {
    return this.b.optString("introductoryPrice");
  }
  
  public long c()
  {
    return this.b.optLong("introductoryPriceAmountMicros");
  }
  
  public int d()
  {
    return this.b.optInt("introductoryPriceCycles");
  }
  
  @NonNull
  public String e()
  {
    return this.a;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof SkuDetails)) {
      return false;
    }
    paramObject = (SkuDetails)paramObject;
    return TextUtils.equals(this.a, ((SkuDetails)paramObject).a);
  }
  
  public long f()
  {
    if (this.b.has("original_price_micros")) {
      return this.b.optLong("original_price_micros");
    }
    return g();
  }
  
  public long g()
  {
    return this.b.optLong("price_amount_micros");
  }
  
  @NonNull
  public String h()
  {
    return this.b.optString("price_currency_code");
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
  
  @NonNull
  public String i()
  {
    return this.b.optString("productId");
  }
  
  @NonNull
  public String j()
  {
    return this.b.optString("subscriptionPeriod");
  }
  
  @NonNull
  public String k()
  {
    return this.b.optString("title");
  }
  
  @NonNull
  public String l()
  {
    return this.b.optString("type");
  }
  
  @NonNull
  public final String m()
  {
    return this.b.optString("packageName");
  }
  
  final String n()
  {
    return this.b.optString("skuDetailsToken");
  }
  
  @NonNull
  public String o()
  {
    return this.b.optString("offer_id");
  }
  
  public int p()
  {
    return this.b.optInt("offer_type");
  }
  
  @NonNull
  public String toString()
  {
    String str = String.valueOf(this.a);
    if (str.length() != 0) {
      str = "SkuDetails: ".concat(str);
    } else {
      str = new String("SkuDetails: ");
    }
    return str;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\android\billingclient\api\SkuDetails.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */