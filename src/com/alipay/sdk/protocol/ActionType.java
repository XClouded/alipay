package com.alipay.sdk.protocol;

import android.text.TextUtils;
import org.json.JSONObject;

public enum ActionType
{
    private String h;
    private String i;
    private String j;
    private JSONObject k;
    private String l;
    private String m;
    private String n;
    private boolean o;
    private boolean p;
    private boolean q;
    private String r;
    private String s;
    private String t;
    private JSONObject u;

    private ActionType(String arg3) {
        Object localObject;
        this.h = localObject;
    }

    public final JSONObject a() {
        return this.u;
    }

    public final String b() {
        return this.t;
    }

    public final String c() {
        return this.r;
    }

    public final String d() {
        return this.s;
    }

    public final String e() {
        return this.i;
    }

    public final String f() {
        return this.j;
    }

    private JSONObject m() {
        return this.k;
    }

    public final String g() {
        return this.m;
    }

    public final String h() {
        return this.n;
    }

    public final boolean i() {
        return this.o;
    }

    public final boolean j() {
        return this.p;
    }

    public final boolean k() {
        return this.q;
    }

    public final String l() {
        return this.l;
    }

    private static String[] a(String paramString) {
        String[] arrayOfString = null;
        if (!TextUtils.isEmpty(paramString)) {
            arrayOfString = paramString.split(";");
        }
        return arrayOfString;
    }

    public static ActionType[] a(ElementAction paramElementAction) {
        Object localObject1;
        if (paramElementAction != null) {
            localObject1 = paramElementAction.e(); String[] arrayOfString = null; if (!TextUtils.isEmpty((CharSequence)localObject1)) arrayOfString = ((String)localObject1).split(";");
            if ((arrayOfString = arrayOfString) == null) {
                    (localObject1 = new ActionType[1])[0] = c;
                    return localObject1;
            }
            localObject1 = new ActionType[arrayOfString.length];
            int i1 = 0;
            for (String str : arrayOfString) {
                Object localObject2 = c;
                for (ActionType localActionType : values()) {
                    if (str.startsWith(localActionType.h)) {
                        localObject2 = localActionType;
                        break;
                    }
                }

                ((ActionType)localObject2).i = str;
                ((ActionType)localObject2).j = paramElementAction.f();
                ((ActionType)localObject2).k = paramElementAction.h();
                ((ActionType)localObject2).l = paramElementAction.g();
                ((ActionType)localObject2).m = paramElementAction.i();
                ((ActionType)localObject2).n = paramElementAction.j();
                ((ActionType)localObject2).o = paramElementAction.k();
                ((ActionType)localObject2).p = paramElementAction.l();
                ((ActionType)localObject2).q = paramElementAction.m();
                ((ActionType)localObject2).r = paramElementAction.c();
                ((ActionType)localObject2).s = paramElementAction.d();
                ((ActionType)localObject2).t = paramElementAction.b();
                ((ActionType)localObject2).u = paramElementAction.a();
                localObject1[i1] = localObject2;
                i1++;
            }
        } else {
            (localObject1 = new ActionType[1])[0] = c;
        }
        return localObject1;
    }

}
