package com.alipay.sdk.data;

import android.os.Build;
import android.text.TextUtils;
import com.alipay.sdk.util.JsonUtils;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class Request
{
    private Envelope a;
    private JSONObject b;
    private JSONObject c;
    private long d;
    private WeakReference e = null;
    private boolean f = true;
    private boolean g = true;

    public final void a(boolean paramBoolean) {
        this.g = paramBoolean;
    }

    private boolean e() {
        return this.g;
    }

    public Request(Envelope paramEnvelope, JSONObject paramJSONObject) {
        this(paramEnvelope, paramJSONObject, (byte)0);
    }

    private Request(Envelope paramEnvelope, JSONObject paramJSONObject, byte paramByte) {
        this.a = paramEnvelope;
        this.b = paramJSONObject;
        this.c = null;
        this.e = new WeakReference(null);
    }

    public final String a() {
        return this.a.b();
    }

    private void b(boolean paramBoolean) {
        this.f = paramBoolean;
    }

    private long f() {
        return this.d;
    }

    private void a(long paramLong) {
        this.d = paramLong;
    }

    public final InteractionData b() {
        return (InteractionData)this.e.get();
    }

    public final void a(InteractionData paramInteractionData) {
        this.e = new WeakReference(paramInteractionData);
    }

    private void a(JSONObject paramJSONObject) {
        this.c = paramJSONObject;
    }

    public final JSONObject a(String paramString) {
        JSONObject localJSONObject1 = new JSONObject();
        try {
            JSONObject localJSONObject2;
            (localJSONObject2 = new JSONObject()).put("device", Build.MODEL);

            JSONObject localJSONObject3 = new JSONObject();
            (localJSONObject2 = JsonUtils.a(localJSONObject2, this.c)).put("namespace", this.a.c());
            localJSONObject2.put("api_name", this.a.a());
            localJSONObject2.put("api_version", this.a.e());
            if (this.b == null) {
                this.b = new JSONObject();
            }
            this.b.put("action", localJSONObject3);
            Object localObject;
            if (!TextUtils.isEmpty(localObject = this.a.d()))
                try {
                localObject = ((String)localObject).split("/");
                localJSONObject3.put("type", localObject[1]);
                if (localObject.length > 1)
                    localJSONObject3.put("method", localObject[2]);
                } catch (Exception localException2) {
                }
            this.b.put("gzip", this.g);
            if (this.f) {
                localObject = new JSONObject();
                new StringBuilder("requestData before: ").append(this.b.toString()).toString();
                ((JSONObject)localObject).put("req_data", JsonUtils.a(paramString, this.b.toString()));
                localJSONObject2.put("params", localObject);
            } else {
                localJSONObject2.put("params", this.b);
            }
            localJSONObject1.put("data", localJSONObject2);
        } catch (Exception localException1) {

        }
        new StringBuilder("requestData : ").append(localJSONObject1.toString()).toString();

        return localJSONObject1;
    }

    public final boolean c() {
        return this.f;
    }

    public String toString() {
        return this.a.toString() + ", requestData = " + JsonUtils.a(this.b, this.c) + ", timeStamp = " + this.d;
    }

    public final Envelope d() {
        return this.a;
    }
}
