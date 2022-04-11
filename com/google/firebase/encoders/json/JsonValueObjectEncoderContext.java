package com.google.firebase.encoders.json;

import android.util.Base64;
import android.util.JsonWriter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class JsonValueObjectEncoderContext
  implements ObjectEncoderContext, ValueEncoderContext
{
  private boolean active = true;
  private JsonValueObjectEncoderContext childContext = null;
  private final ObjectEncoder<Object> fallbackEncoder;
  private final boolean ignoreNullValues;
  private final JsonWriter jsonWriter;
  private final Map<Class<?>, ObjectEncoder<?>> objectEncoders;
  private final Map<Class<?>, ValueEncoder<?>> valueEncoders;
  
  private JsonValueObjectEncoderContext(JsonValueObjectEncoderContext paramJsonValueObjectEncoderContext)
  {
    this.jsonWriter = paramJsonValueObjectEncoderContext.jsonWriter;
    this.objectEncoders = paramJsonValueObjectEncoderContext.objectEncoders;
    this.valueEncoders = paramJsonValueObjectEncoderContext.valueEncoders;
    this.fallbackEncoder = paramJsonValueObjectEncoderContext.fallbackEncoder;
    this.ignoreNullValues = paramJsonValueObjectEncoderContext.ignoreNullValues;
  }
  
  JsonValueObjectEncoderContext(@NonNull Writer paramWriter, @NonNull Map<Class<?>, ObjectEncoder<?>> paramMap, @NonNull Map<Class<?>, ValueEncoder<?>> paramMap1, ObjectEncoder<Object> paramObjectEncoder, boolean paramBoolean)
  {
    this.jsonWriter = new JsonWriter(paramWriter);
    this.objectEncoders = paramMap;
    this.valueEncoders = paramMap1;
    this.fallbackEncoder = paramObjectEncoder;
    this.ignoreNullValues = paramBoolean;
  }
  
  private boolean cannotBeInline(Object paramObject)
  {
    boolean bool;
    if ((paramObject != null) && (!paramObject.getClass().isArray()) && (!(paramObject instanceof Collection)) && (!(paramObject instanceof Date)) && (!(paramObject instanceof Enum)) && (!(paramObject instanceof Number))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private JsonValueObjectEncoderContext internalAdd(@NonNull String paramString, @Nullable Object paramObject)
    throws IOException, EncodingException
  {
    maybeUnNest();
    this.jsonWriter.name(paramString);
    if (paramObject == null)
    {
      this.jsonWriter.nullValue();
      return this;
    }
    return add(paramObject, false);
  }
  
  private JsonValueObjectEncoderContext internalAddIgnoreNullValues(@NonNull String paramString, @Nullable Object paramObject)
    throws IOException, EncodingException
  {
    if (paramObject == null) {
      return this;
    }
    maybeUnNest();
    this.jsonWriter.name(paramString);
    return add(paramObject, false);
  }
  
  private void maybeUnNest()
    throws IOException
  {
    if (this.active)
    {
      JsonValueObjectEncoderContext localJsonValueObjectEncoderContext = this.childContext;
      if (localJsonValueObjectEncoderContext != null)
      {
        localJsonValueObjectEncoderContext.maybeUnNest();
        this.childContext.active = false;
        this.childContext = null;
        this.jsonWriter.endObject();
      }
      return;
    }
    throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
  }
  
  @NonNull
  public ObjectEncoderContext add(@NonNull FieldDescriptor paramFieldDescriptor, double paramDouble)
    throws IOException
  {
    return add(paramFieldDescriptor.getName(), paramDouble);
  }
  
  @NonNull
  public ObjectEncoderContext add(@NonNull FieldDescriptor paramFieldDescriptor, float paramFloat)
    throws IOException
  {
    return add(paramFieldDescriptor.getName(), paramFloat);
  }
  
  @NonNull
  public ObjectEncoderContext add(@NonNull FieldDescriptor paramFieldDescriptor, int paramInt)
    throws IOException
  {
    return add(paramFieldDescriptor.getName(), paramInt);
  }
  
  @NonNull
  public ObjectEncoderContext add(@NonNull FieldDescriptor paramFieldDescriptor, long paramLong)
    throws IOException
  {
    return add(paramFieldDescriptor.getName(), paramLong);
  }
  
  @NonNull
  public ObjectEncoderContext add(@NonNull FieldDescriptor paramFieldDescriptor, @Nullable Object paramObject)
    throws IOException
  {
    return add(paramFieldDescriptor.getName(), paramObject);
  }
  
  @NonNull
  public ObjectEncoderContext add(@NonNull FieldDescriptor paramFieldDescriptor, boolean paramBoolean)
    throws IOException
  {
    return add(paramFieldDescriptor.getName(), paramBoolean);
  }
  
  @NonNull
  public JsonValueObjectEncoderContext add(double paramDouble)
    throws IOException
  {
    maybeUnNest();
    this.jsonWriter.value(paramDouble);
    return this;
  }
  
  @NonNull
  public JsonValueObjectEncoderContext add(float paramFloat)
    throws IOException
  {
    maybeUnNest();
    this.jsonWriter.value(paramFloat);
    return this;
  }
  
  @NonNull
  public JsonValueObjectEncoderContext add(int paramInt)
    throws IOException
  {
    maybeUnNest();
    this.jsonWriter.value(paramInt);
    return this;
  }
  
  @NonNull
  public JsonValueObjectEncoderContext add(long paramLong)
    throws IOException
  {
    maybeUnNest();
    this.jsonWriter.value(paramLong);
    return this;
  }
  
  @NonNull
  JsonValueObjectEncoderContext add(@Nullable Object paramObject, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    int k = 0;
    int m = 0;
    if ((paramBoolean) && (cannotBeInline(paramObject)))
    {
      if (paramObject == null) {
        paramObject = null;
      } else {
        paramObject = paramObject.getClass();
      }
      throw new EncodingException(String.format("%s cannot be encoded inline", new Object[] { paramObject }));
    }
    if (paramObject == null)
    {
      this.jsonWriter.nullValue();
      return this;
    }
    if ((paramObject instanceof Number))
    {
      this.jsonWriter.value((Number)paramObject);
      return this;
    }
    if (paramObject.getClass().isArray())
    {
      if ((paramObject instanceof byte[])) {
        return add((byte[])paramObject);
      }
      this.jsonWriter.beginArray();
      if ((paramObject instanceof int[]))
      {
        paramObject = (int[])paramObject;
        i = paramObject.length;
        while (m < i)
        {
          j = paramObject[m];
          this.jsonWriter.value(j);
          m++;
        }
      }
      if ((paramObject instanceof long[]))
      {
        paramObject = (long[])paramObject;
        j = paramObject.length;
        for (m = i; m < j; m++) {
          add(paramObject[m]);
        }
      }
      if ((paramObject instanceof double[]))
      {
        paramObject = (double[])paramObject;
        i = paramObject.length;
        for (m = j; m < i; m++)
        {
          double d = paramObject[m];
          this.jsonWriter.value(d);
        }
      }
      if ((paramObject instanceof boolean[]))
      {
        paramObject = (boolean[])paramObject;
        i = paramObject.length;
        for (m = k; m < i; m++)
        {
          paramBoolean = paramObject[m];
          this.jsonWriter.value(paramBoolean);
        }
      }
      if ((paramObject instanceof Number[]))
      {
        paramObject = (Number[])paramObject;
        i = paramObject.length;
        for (m = 0; m < i; m++) {
          add(paramObject[m], false);
        }
      }
      paramObject = (Object[])paramObject;
      i = paramObject.length;
      for (m = 0; m < i; m++) {
        add(paramObject[m], false);
      }
      this.jsonWriter.endArray();
      return this;
    }
    if ((paramObject instanceof Collection))
    {
      paramObject = (Collection)paramObject;
      this.jsonWriter.beginArray();
      paramObject = ((Collection)paramObject).iterator();
      while (((Iterator)paramObject).hasNext()) {
        add(((Iterator)paramObject).next(), false);
      }
      this.jsonWriter.endArray();
      return this;
    }
    if ((paramObject instanceof Map))
    {
      paramObject = (Map)paramObject;
      this.jsonWriter.beginObject();
      Iterator localIterator = ((Map)paramObject).entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        paramObject = localEntry.getKey();
        try
        {
          add((String)paramObject, localEntry.getValue());
        }
        catch (ClassCastException localClassCastException)
        {
          throw new EncodingException(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", new Object[] { paramObject, paramObject.getClass() }), localClassCastException);
        }
      }
      this.jsonWriter.endObject();
      return this;
    }
    Object localObject = (ObjectEncoder)this.objectEncoders.get(paramObject.getClass());
    if (localObject != null) {
      return doEncode((ObjectEncoder)localObject, paramObject, paramBoolean);
    }
    localObject = (ValueEncoder)this.valueEncoders.get(paramObject.getClass());
    if (localObject != null)
    {
      ((ValueEncoder)localObject).encode(paramObject, this);
      return this;
    }
    if ((paramObject instanceof Enum))
    {
      add(((Enum)paramObject).name());
      return this;
    }
    return doEncode(this.fallbackEncoder, paramObject, paramBoolean);
  }
  
  @NonNull
  public JsonValueObjectEncoderContext add(@Nullable String paramString)
    throws IOException
  {
    maybeUnNest();
    this.jsonWriter.value(paramString);
    return this;
  }
  
  @NonNull
  public JsonValueObjectEncoderContext add(@NonNull String paramString, double paramDouble)
    throws IOException
  {
    maybeUnNest();
    this.jsonWriter.name(paramString);
    return add(paramDouble);
  }
  
  @NonNull
  public JsonValueObjectEncoderContext add(@NonNull String paramString, int paramInt)
    throws IOException
  {
    maybeUnNest();
    this.jsonWriter.name(paramString);
    return add(paramInt);
  }
  
  @NonNull
  public JsonValueObjectEncoderContext add(@NonNull String paramString, long paramLong)
    throws IOException
  {
    maybeUnNest();
    this.jsonWriter.name(paramString);
    return add(paramLong);
  }
  
  @NonNull
  public JsonValueObjectEncoderContext add(@NonNull String paramString, @Nullable Object paramObject)
    throws IOException
  {
    if (this.ignoreNullValues) {
      return internalAddIgnoreNullValues(paramString, paramObject);
    }
    return internalAdd(paramString, paramObject);
  }
  
  @NonNull
  public JsonValueObjectEncoderContext add(@NonNull String paramString, boolean paramBoolean)
    throws IOException
  {
    maybeUnNest();
    this.jsonWriter.name(paramString);
    return add(paramBoolean);
  }
  
  @NonNull
  public JsonValueObjectEncoderContext add(boolean paramBoolean)
    throws IOException
  {
    maybeUnNest();
    this.jsonWriter.value(paramBoolean);
    return this;
  }
  
  @NonNull
  public JsonValueObjectEncoderContext add(@Nullable byte[] paramArrayOfByte)
    throws IOException
  {
    maybeUnNest();
    if (paramArrayOfByte == null) {
      this.jsonWriter.nullValue();
    } else {
      this.jsonWriter.value(Base64.encodeToString(paramArrayOfByte, 2));
    }
    return this;
  }
  
  void close()
    throws IOException
  {
    maybeUnNest();
    this.jsonWriter.flush();
  }
  
  JsonValueObjectEncoderContext doEncode(ObjectEncoder<Object> paramObjectEncoder, Object paramObject, boolean paramBoolean)
    throws IOException
  {
    if (!paramBoolean) {
      this.jsonWriter.beginObject();
    }
    paramObjectEncoder.encode(paramObject, this);
    if (!paramBoolean) {
      this.jsonWriter.endObject();
    }
    return this;
  }
  
  @NonNull
  public ObjectEncoderContext inline(@Nullable Object paramObject)
    throws IOException
  {
    return add(paramObject, true);
  }
  
  @NonNull
  public ObjectEncoderContext nested(@NonNull FieldDescriptor paramFieldDescriptor)
    throws IOException
  {
    return nested(paramFieldDescriptor.getName());
  }
  
  @NonNull
  public ObjectEncoderContext nested(@NonNull String paramString)
    throws IOException
  {
    maybeUnNest();
    this.childContext = new JsonValueObjectEncoderContext(this);
    this.jsonWriter.name(paramString);
    this.jsonWriter.beginObject();
    return this.childContext;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\encoders\json\JsonValueObjectEncoderContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */