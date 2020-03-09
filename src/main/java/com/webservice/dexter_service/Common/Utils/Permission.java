package com.webservice.dexter_service.Common.Utils;

import com.webservice.dexter_service.Common.Enums.Enums;
import com.webservice.dexter_service.Security.CustomUserDetail;
import com.webservice.dexter_service.Security.UserSession;

public class Permission {

    public static Boolean hasPermission(Enums.PERMISSION permission) {
        CustomUserDetail user = UserSession.getUserSession();
        return user.getPermissions().contains(permission.getValue());
    }
}
