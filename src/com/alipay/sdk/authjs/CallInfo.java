package com.alipay.sdk.authjs;

import org.json.JSONException;
import org.json.JSONObject;

public class CallInfo
{
    public static final String a = "CallInfo";
    public static final String b = "call";
    public static final String c = "callback";
    public static final String d = "bundleName";
    public static final String e = "clientId";
    public static final String f = "param";
    public static final String g = "func";
    public static final String h = "msgType";
    private String i;
    private String j;
    private String k;
    private String l;
    private JSONObject m;
    private boolean n = false;

    private static String a(CallError paramCallError) {
        switch (1.a[paramCallError.ordinal()]) {
        case 1:
            paramCallError = "function not found";
            break;
        case 2:
            paramCallError = "invalid parameter";
            break;
        case 3:
            paramCallError = "runtime error";
            break;
        default:
            paramCallError = "none";
        }
        return paramCallError;
    }

    private boolean e() {
        return this.n;
    }

    private void a(boolean paramBoolean) {
        this.n = paramBoolean;
    }

    public CallInfo(String paramString) {
        this.l = paramString;
    }

    public final String a() {
        return this.i;
    }

    public final void a(String paramString) {
        this.i = paramString;
    }

    private String f() {
        return this.j;
    }

    public final void b(String paramString) {
        this.j = paramString;
    }

    public final String b() {
        return this.k;
    }

    public final void c(String paramString) {
        this.k = paramString;
    }

    private String g() {
        return this.l;
    }

    private void d(String paramString) {
        this.l = paramString;
    }

    public final JSONObject c() {
        return this.m;
    }

    public final void a(JSONObject paramJSONObject) {
        this.m = paramJSONObject;
    }

    public final String d() throws JSONException {
        JSONObject localJSONObject;
        (localJSONObject = new JSONObject()).put("clientId", this.i);
        localJSONObject.put("func", this.k);
        localJSONObject.put("param", this.m);
        localJSONObject.put("msgType", this.l);
        return localJSONObject.toString();
    }

    public static enum CallError {

    }

}
