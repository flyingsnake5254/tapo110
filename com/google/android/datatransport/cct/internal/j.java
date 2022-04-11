package com.google.android.datatransport.cct.internal;

import androidx.annotation.NonNull;
import com.google.auto.value.AutoValue;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.annotations.Encodable;
import com.google.firebase.encoders.annotations.Encodable.Field;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.util.List;

@Encodable
@AutoValue
public abstract class j
{
  @NonNull
  public static j a(@NonNull List<l> paramList)
  {
    return new d(paramList);
  }
  
  @NonNull
  public static DataEncoder b()
  {
    return new JsonDataEncoderBuilder().configureWith(b.a).ignoreNullValues(true).build();
  }
  
  @Encodable.Field(name="logRequest")
  @NonNull
  public abstract List<l> c();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\cct\internal\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */