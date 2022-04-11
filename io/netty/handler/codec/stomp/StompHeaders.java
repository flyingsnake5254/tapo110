package io.netty.handler.codec.stomp;

import io.netty.handler.codec.Headers;
import io.netty.util.AsciiString;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public abstract interface StompHeaders
  extends Headers<CharSequence, CharSequence, StompHeaders>
{
  public static final AsciiString ACCEPT_VERSION = AsciiString.cached("accept-version");
  public static final AsciiString ACK;
  public static final AsciiString CONTENT_LENGTH = AsciiString.cached("content-length");
  public static final AsciiString CONTENT_TYPE = AsciiString.cached("content-type");
  public static final AsciiString DESTINATION;
  public static final AsciiString HEART_BEAT;
  public static final AsciiString HOST = AsciiString.cached("host");
  public static final AsciiString ID;
  public static final AsciiString LOGIN = AsciiString.cached("login");
  public static final AsciiString MESSAGE;
  public static final AsciiString MESSAGE_ID;
  public static final AsciiString PASSCODE = AsciiString.cached("passcode");
  public static final AsciiString RECEIPT;
  public static final AsciiString RECEIPT_ID;
  public static final AsciiString SERVER;
  public static final AsciiString SESSION;
  public static final AsciiString SUBSCRIPTION;
  public static final AsciiString TRANSACTION;
  public static final AsciiString VERSION;
  
  static
  {
    HEART_BEAT = AsciiString.cached("heart-beat");
    VERSION = AsciiString.cached("version");
    SESSION = AsciiString.cached("session");
    SERVER = AsciiString.cached("server");
    DESTINATION = AsciiString.cached("destination");
    ID = AsciiString.cached("id");
    ACK = AsciiString.cached("ack");
    TRANSACTION = AsciiString.cached("transaction");
    RECEIPT = AsciiString.cached("receipt");
    MESSAGE_ID = AsciiString.cached("message-id");
    SUBSCRIPTION = AsciiString.cached("subscription");
    RECEIPT_ID = AsciiString.cached("receipt-id");
    MESSAGE = AsciiString.cached("message");
  }
  
  public abstract boolean contains(CharSequence paramCharSequence1, CharSequence paramCharSequence2, boolean paramBoolean);
  
  public abstract List<String> getAllAsString(CharSequence paramCharSequence);
  
  public abstract String getAsString(CharSequence paramCharSequence);
  
  public abstract Iterator<Map.Entry<String, String>> iteratorAsString();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\stomp\StompHeaders.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */