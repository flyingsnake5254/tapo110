package com.google.firebase.encoders.json;

import androidx.annotation.NonNull;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public final class JsonDataEncoderBuilder
  implements EncoderConfig<JsonDataEncoderBuilder>
{
  private static final ValueEncoder<Boolean> BOOLEAN_ENCODER = c.a;
  private static final ObjectEncoder<Object> DEFAULT_FALLBACK_ENCODER = a.a;
  private static final ValueEncoder<String> STRING_ENCODER = b.a;
  private static final TimestampEncoder TIMESTAMP_ENCODER = new TimestampEncoder(null);
  private ObjectEncoder<Object> fallbackEncoder = DEFAULT_FALLBACK_ENCODER;
  private boolean ignoreNullValues = false;
  private final Map<Class<?>, ObjectEncoder<?>> objectEncoders = new HashMap();
  private final Map<Class<?>, ValueEncoder<?>> valueEncoders = new HashMap();
  
  public JsonDataEncoderBuilder()
  {
    registerEncoder(String.class, STRING_ENCODER);
    registerEncoder(Boolean.class, BOOLEAN_ENCODER);
    registerEncoder(Date.class, TIMESTAMP_ENCODER);
  }
  
  @NonNull
  public DataEncoder build()
  {
    new DataEncoder()
    {
      public String encode(@NonNull Object paramAnonymousObject)
      {
        StringWriter localStringWriter = new StringWriter();
        try
        {
          encode(paramAnonymousObject, localStringWriter);
          return localStringWriter.toString();
        }
        catch (IOException paramAnonymousObject)
        {
          for (;;) {}
        }
      }
      
      public void encode(@NonNull Object paramAnonymousObject, @NonNull Writer paramAnonymousWriter)
        throws IOException
      {
        paramAnonymousWriter = new JsonValueObjectEncoderContext(paramAnonymousWriter, JsonDataEncoderBuilder.this.objectEncoders, JsonDataEncoderBuilder.this.valueEncoders, JsonDataEncoderBuilder.this.fallbackEncoder, JsonDataEncoderBuilder.this.ignoreNullValues);
        paramAnonymousWriter.add(paramAnonymousObject, false);
        paramAnonymousWriter.close();
      }
    };
  }
  
  @NonNull
  public JsonDataEncoderBuilder configureWith(@NonNull Configurator paramConfigurator)
  {
    paramConfigurator.configure(this);
    return this;
  }
  
  @NonNull
  public JsonDataEncoderBuilder ignoreNullValues(boolean paramBoolean)
  {
    this.ignoreNullValues = paramBoolean;
    return this;
  }
  
  @NonNull
  public <T> JsonDataEncoderBuilder registerEncoder(@NonNull Class<T> paramClass, @NonNull ObjectEncoder<? super T> paramObjectEncoder)
  {
    this.objectEncoders.put(paramClass, paramObjectEncoder);
    this.valueEncoders.remove(paramClass);
    return this;
  }
  
  @NonNull
  public <T> JsonDataEncoderBuilder registerEncoder(@NonNull Class<T> paramClass, @NonNull ValueEncoder<? super T> paramValueEncoder)
  {
    this.valueEncoders.put(paramClass, paramValueEncoder);
    this.objectEncoders.remove(paramClass);
    return this;
  }
  
  @NonNull
  public JsonDataEncoderBuilder registerFallbackEncoder(@NonNull ObjectEncoder<Object> paramObjectEncoder)
  {
    this.fallbackEncoder = paramObjectEncoder;
    return this;
  }
  
  private static final class TimestampEncoder
    implements ValueEncoder<Date>
  {
    private static final DateFormat rfc339;
    
    static
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
      rfc339 = localSimpleDateFormat;
      localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    }
    
    public void encode(@NonNull Date paramDate, @NonNull ValueEncoderContext paramValueEncoderContext)
      throws IOException
    {
      paramValueEncoderContext.add(rfc339.format(paramDate));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\encoders\json\JsonDataEncoderBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */