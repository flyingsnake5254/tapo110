package io.netty.handler.codec.serialization;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.io.StreamCorruptedException;

class CompactObjectInputStream
  extends ObjectInputStream
{
  private final ClassResolver classResolver;
  
  CompactObjectInputStream(InputStream paramInputStream, ClassResolver paramClassResolver)
    throws IOException
  {
    super(paramInputStream);
    this.classResolver = paramClassResolver;
  }
  
  protected ObjectStreamClass readClassDescriptor()
    throws IOException, ClassNotFoundException
  {
    int i = read();
    if (i >= 0)
    {
      if (i != 0)
      {
        if (i == 1)
        {
          localObject = readUTF();
          return ObjectStreamClass.lookupAny(this.classResolver.resolve((String)localObject));
        }
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Unexpected class descriptor type: ");
        ((StringBuilder)localObject).append(i);
        throw new StreamCorruptedException(((StringBuilder)localObject).toString());
      }
      return super.readClassDescriptor();
    }
    throw new EOFException();
  }
  
  protected void readStreamHeader()
    throws IOException
  {
    int i = readByte() & 0xFF;
    if (i == 5) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unsupported version: ");
    localStringBuilder.append(i);
    throw new StreamCorruptedException(localStringBuilder.toString());
  }
  
  protected Class<?> resolveClass(ObjectStreamClass paramObjectStreamClass)
    throws IOException, ClassNotFoundException
  {
    try
    {
      Class localClass = this.classResolver.resolve(paramObjectStreamClass.getName());
      paramObjectStreamClass = localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      paramObjectStreamClass = super.resolveClass(paramObjectStreamClass);
    }
    return paramObjectStreamClass;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\serialization\CompactObjectInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */