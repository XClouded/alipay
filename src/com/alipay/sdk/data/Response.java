package com.alipay.sdk.data;

import org.apache.http.Header;
import org.json.JSONObject;

public class Response
{
    public static final int a = 1000;
    public static final int b = 503;
    public static final int c = 0;
    private int f = 0;
    private String g = "";
    private long h = 0L;
    private String i = "";
    private String j = null;
    private String k = null;

    private JSONObject l = null;
    private String m;
    private boolean n = true;

    Envelope d = null;

    Header[] e = null;

    public final Envelope a() {
        return this.d;
    }

    public final void b() {
        this.n = false;
    }

    private boolean e() {
        return this.n;
    }

    public final int c() {
        return this.f;
    }

    public final void a(int paramInt) {
        this.f = paramInt;
    }

    public final String d() {
        return this.g;
    }

    public final void a(String paramString) {
        this.g = paramString;
    }

    private String f() {
        return this.i;
    }

    public final void b(String paramString) {
        this.i = paramString;
    }

    private String g() {
        return this.j;
    }

    public final void c(String paramString) {
        this.j = paramString;
    }

    private String h() {
        return this.k;
    }

    public final void d(String paramString) {
        this.k = paramString;
    }

    public final void a(long paramLong) {
        this.h = paramLong;
    }

    public final void a(JSONObject paramJSONObject) {
        this.l = paramJSONObject;
    }

    public final void e(String paramString) {
        this.m = paramString;
    }

    private String i() {
        return this.m;
    }

    public final void a(Envelope paramEnvelope) {
        this.d = paramEnvelope;
    }

    public String toString() {
        String str = this.d.toString() + ", code = " + this.f + ", errorMsg = " + this.g + ", timeStamp = " + this.h + ", endCode = " + this.i;
        if (this.l != null) {
            str = str + ", reflectedData = " + this.l;
        }
        return str;
    }
}
