package com.google.gson.stream;

public enum JsonToken
{
  static
  {
    JsonToken localJsonToken1 = new JsonToken("BEGIN_ARRAY", 0);
    BEGIN_ARRAY = localJsonToken1;
    JsonToken localJsonToken2 = new JsonToken("END_ARRAY", 1);
    END_ARRAY = localJsonToken2;
    JsonToken localJsonToken3 = new JsonToken("BEGIN_OBJECT", 2);
    BEGIN_OBJECT = localJsonToken3;
    JsonToken localJsonToken4 = new JsonToken("END_OBJECT", 3);
    END_OBJECT = localJsonToken4;
    JsonToken localJsonToken5 = new JsonToken("NAME", 4);
    NAME = localJsonToken5;
    JsonToken localJsonToken6 = new JsonToken("STRING", 5);
    STRING = localJsonToken6;
    JsonToken localJsonToken7 = new JsonToken("NUMBER", 6);
    NUMBER = localJsonToken7;
    JsonToken localJsonToken8 = new JsonToken("BOOLEAN", 7);
    BOOLEAN = localJsonToken8;
    JsonToken localJsonToken9 = new JsonToken("NULL", 8);
    NULL = localJsonToken9;
    JsonToken localJsonToken10 = new JsonToken("END_DOCUMENT", 9);
    END_DOCUMENT = localJsonToken10;
    $VALUES = new JsonToken[] { localJsonToken1, localJsonToken2, localJsonToken3, localJsonToken4, localJsonToken5, localJsonToken6, localJsonToken7, localJsonToken8, localJsonToken9, localJsonToken10 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\gson\stream\JsonToken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */