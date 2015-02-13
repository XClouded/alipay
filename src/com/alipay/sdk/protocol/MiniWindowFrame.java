package com.alipay.sdk.protocol;

import android.text.TextUtils;
import com.alipay.sdk.data.Request;
import com.alipay.sdk.data.Response;
import org.json.JSONObject;

public class MiniWindowFrame extends WindowData
{
    private int i;
    private boolean j = false;

    protected MiniWindowFrame(Request paramRequest, Response paramResponse) {
        super(paramRequest, paramResponse);
    }

    public final boolean d() {
        return (this.i == 4) || (this.i == 9);
    }

    public final int e() {
        return this.i;
    }

    public final String f() {
        return null;
    }

    private boolean g() {
        return this.j;
    }

    public final void a(JSONObject paramJSONObject) {
        super.a(paramJSONObject);
        if (paramJSONObject.has("form")) {
            String str = (paramJSONObject = paramJSONObject.optJSONObject("form")).optString("type");
            int m = Boolean.parseBoolean(paramJSONObject.optString("oneTime"));
            this.h = m;
            if (TextUtils.equals("page", str)) {
                this.j = true;
                this.i = 9;
                return;
            }
            if (TextUtils.equals("dialog", str)) {
                this.i = 7;
                this.j = false;
                return;
            }
            int k;
            if (TextUtils.equals("toast", str)) {
                paramJSONObject = ElementAction.a(paramJSONObject, "onload");
                this.i = 6;
                if (paramJSONObject != null) {
                    k = (paramJSONObject = ActionType.a(paramJSONObject)).length;
                    for (m = 0; m < k; m++) {
                        Object localObject;
                        if (((localObject = paramJSONObject[m]) == ActionType.d) || (localObject == ActionType.e)) {
                            this.i = 10;
                        }
                    }
                }
                return;
            }
            if (!TextUtils.equals("confirm", k)) {
                this.j = TextUtils.equals(k, "fullscreen");
                this.i = 4;
            }
            return;
        }

        if (MiniStatus.a(paramJSONObject.optString("status")) == MiniStatus.c) {
            this.i = -10;
            return;
        }
        this.i = 8;
    }
}
