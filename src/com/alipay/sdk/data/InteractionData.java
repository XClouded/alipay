package com.alipay.sdk.data;

import java.util.ArrayList;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

public class InteractionData
{
    public static final String a = "application/octet-stream;binary/octet-stream";
    private Header[] b = null;
    private String c = null;
    private String d = null;

    public final void a(Header[] paramArrayOfHeader) {
        this.b = paramArrayOfHeader;
    }

    private Header[] d() {
        return this.b;
    }

    public final ArrayList a() {
        if ((this.b == null) || (this.b.length == 0)) {
            return null;
        }
        ArrayList localArrayList = new ArrayList();
        for (Header localHeader : this.b) {
            localArrayList.add(new BasicHeader(localHeader.getName(), localHeader.getValue()));
        }
        return localArrayList;
    }

    public final String b() {
        return this.c;
    }

    private void a(String paramString) {
        this.c = paramString;
    }

    public final String c() {
        return this.d;
    }

    private void b(String paramString) {
        this.d = paramString;
    }

    private void e() {
        this.d = null;
        this.c = null;
    }
}
