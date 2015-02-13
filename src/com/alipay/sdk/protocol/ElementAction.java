package com.alipay.sdk.protocol;

import android.text.TextUtils;
import com.alipay.sdk.cons.GlobalConstants;
import org.json.JSONObject;

public class ElementAction
{
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private boolean f;
    private boolean g = true;
    private boolean h = true;
    private String i;
    private String j;
    private String k;
    private JSONObject l;

    private ElementAction(String paramString) {
        this.a = paramString;
    }

    public final JSONObject a() {
        return this.l;
    }

    public final String b() {
        return this.k;
    }

    public final String c() {
        return this.i;
    }

    public final String d() {
        return this.j;
    }

    private static ElementAction a(JSONObject paramJSONObject) {
        String str1 = null;
        if ((paramJSONObject != null) && (paramJSONObject.has("name"))) {
            str1 = paramJSONObject.optString("name");
        }
        String str2 = null;
        if ((paramJSONObject != null) && (paramJSONObject.has("host"))) {
            str2 = paramJSONObject.optString("host");
        }
        String str3 = null;
        if ((paramJSONObject != null) && (paramJSONObject.has("params"))) {
            str3 = paramJSONObject.optString("params");
        }
        String str4 = null;
        if ((paramJSONObject != null) && (paramJSONObject.has("enctype"))) {
            str4 = paramJSONObject.optString("enctype");
        }
        String str5 = null;
        if ((paramJSONObject != null) && (paramJSONObject.has("request_param"))) {
            str5 = paramJSONObject.optString("request_param");
        }
        boolean bool1 = true;
        if ((paramJSONObject != null) && (paramJSONObject.has("validate"))) {
            bool1 = paramJSONObject.optBoolean("validate", true);
        }

        boolean bool2 = true;
        if ((paramJSONObject != null) && (paramJSONObject.has("https"))) {
            bool2 = !paramJSONObject.optBoolean("https");
        }

        boolean bool3 = true;
        if ((paramJSONObject != null) && (paramJSONObject.has("formSubmit"))) {
            bool3 = paramJSONObject.optBoolean("formSubmit");
        }

        String str6 = "";
        if ((paramJSONObject != null) && (paramJSONObject.has("namespace"))) {
            str6 = paramJSONObject.optString("namespace");
        }

        String str7 = "";
        if ((paramJSONObject != null) && (paramJSONObject.has("apiVersion"))) {
            str7 = paramJSONObject.optString("apiVersion");
        }

        String str8 = "";
        if ((paramJSONObject != null) && (paramJSONObject.has("apiName"))) {
            str8 = paramJSONObject.optString("apiName");
        }

        return a(str1, str2, str3, str4, str5, bool1, bool2, bool3, str6, str7, str8, paramJSONObject);
    }

    public static ElementAction a(JSONObject paramJSONObject, String paramString) {
        paramJSONObject = paramJSONObject.optJSONObject(paramString);
        paramString = null;
        if ((paramJSONObject != null) && (paramJSONObject.has("name")))
            paramString = paramJSONObject.optString("name");
        String str1 = null;
        if ((paramJSONObject != null) && (paramJSONObject.has("host")))
            str1 = paramJSONObject.optString("host");
        String str2 = null;
        if ((paramJSONObject != null) && (paramJSONObject.has("params")))
            str2 = paramJSONObject.optString("params");
        String str3 = null;
        if ((paramJSONObject != null) && (paramJSONObject.has("enctype")))
            str3 = paramJSONObject.optString("enctype");
        String str4 = null;
        if ((paramJSONObject != null) && (paramJSONObject.has("request_param")))
            str4 = paramJSONObject.optString("request_param");
        boolean bool1 = true;
        if ((paramJSONObject != null) && (paramJSONObject.has("validate")))
            bool1 = paramJSONObject.optBoolean("validate", true);
        boolean bool2 = true;
        if ((paramJSONObject != null) && (paramJSONObject.has("https")))
            bool2 = !paramJSONObject.optBoolean("https");
        boolean bool3 = true;
        if ((paramJSONObject != null) && (paramJSONObject.has("formSubmit")))
            bool3 = paramJSONObject.optBoolean("formSubmit");
        String str5 = "";
        if ((paramJSONObject != null) && (paramJSONObject.has("namespace")))
            str5 = paramJSONObject.optString("namespace");
        String str6 = "";
        if ((paramJSONObject != null) && (paramJSONObject.has("apiVersion")))
            str6 = paramJSONObject.optString("apiVersion");
        String str7 = "";
        if ((paramJSONObject != null) && (paramJSONObject.has("apiName")))
            str7 = paramJSONObject.optString("apiName");
        return a(paramString, str1, str2, str3, str4, bool1, bool2, bool3, str5, str6, str7, paramJSONObject);
    }

    private static ElementAction a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString6, String paramString7, String paramString8, JSONObject paramJSONObject) {
        if (TextUtils.isEmpty(paramString1))
            return null;
        ElementAction localElementAction;
        (localElementAction = new ElementAction(paramString1)).a = paramString1;
        localElementAction.b = (TextUtils.isEmpty(paramString2) ? null : paramString2.trim());
        localElementAction.c = paramString3;
        localElementAction.d = paramString4;
        localElementAction.e = paramString5;
        localElementAction.f = paramBoolean1;
        localElementAction.g = paramBoolean2;
        localElementAction.h = paramBoolean3;
        localElementAction.i = paramString6;
        localElementAction.j = paramString7;
        localElementAction.k = paramString8;
        localElementAction.l = paramJSONObject;
        return localElementAction;
    }

    public static ElementAction a(String paramString, ActionType paramActionType) {
        return a(paramString, paramActionType.f(), paramActionType.l(), paramActionType.g(), paramActionType.h(), paramActionType.i(), paramActionType.j(), paramActionType.k(), paramActionType.c(), paramActionType.d(), paramActionType.b(), paramActionType.a());
    }

    public final String e() {
        return this.a;
    }

    public final String f() {
        if (TextUtils.isEmpty(this.b)) {
            this.b = GlobalConstants.b;
        }
        return this.b;
    }

    public final String g() {
        return this.c;
    }

    public final JSONObject h() {
        JSONObject localJSONObject = null;
        try {
            localJSONObject = new JSONObject(this.c);
        } catch (Exception localException) {
        }
        return localJSONObject;
    }

    public final String i() {
        return this.d;
    }

    public final String j() {
        return this.e;
    }

    public final boolean k() {
        return this.f;
    }

    public final boolean l() {
        return this.g;
    }

    public final boolean m() {
        return this.h;
    }

}
