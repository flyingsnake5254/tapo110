package io.netty.util.internal;

import io.netty.util.AsciiString;
import java.nio.ByteBuffer;
import java.security.cert.Certificate;

public final class EmptyArrays
{
  public static final AsciiString[] EMPTY_ASCII_STRINGS;
  public static final byte[] EMPTY_BYTES;
  public static final ByteBuffer[] EMPTY_BYTE_BUFFERS;
  public static final Certificate[] EMPTY_CERTIFICATES;
  public static final char[] EMPTY_CHARS;
  public static final Class<?>[] EMPTY_CLASSES;
  public static final int[] EMPTY_INTS = new int[0];
  public static final javax.security.cert.X509Certificate[] EMPTY_JAVAX_X509_CERTIFICATES = new javax.security.cert.X509Certificate[0];
  public static final Object[] EMPTY_OBJECTS;
  public static final StackTraceElement[] EMPTY_STACK_TRACE;
  public static final String[] EMPTY_STRINGS;
  public static final java.security.cert.X509Certificate[] EMPTY_X509_CERTIFICATES;
  
  static
  {
    EMPTY_BYTES = new byte[0];
    EMPTY_CHARS = new char[0];
    EMPTY_OBJECTS = new Object[0];
    EMPTY_CLASSES = new Class[0];
    EMPTY_STRINGS = new String[0];
    EMPTY_ASCII_STRINGS = new AsciiString[0];
    EMPTY_STACK_TRACE = new StackTraceElement[0];
    EMPTY_BYTE_BUFFERS = new ByteBuffer[0];
    EMPTY_CERTIFICATES = new Certificate[0];
    EMPTY_X509_CERTIFICATES = new java.security.cert.X509Certificate[0];
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\EmptyArrays.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */