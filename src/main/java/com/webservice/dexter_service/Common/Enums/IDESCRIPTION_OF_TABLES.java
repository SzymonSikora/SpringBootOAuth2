package com.webservice.dexter_service.Common.Enums;

public interface IDESCRIPTION_OF_TABLES {

    abstract class TABLES {

        public abstract class ACCOUNT {
            public static final String ACCOUNT = "account";
            public static final String ID_ACCOUNT = "id_account";
            public static final String USERNAME = "username";
            public static final String PASSWORD = "password";
            public static final String EMAIL = "email";
            public static final String IS_ACTIVE = "is_active";
            public static final String CREATE_DATE = "create_date";
            public static final String DEACTIVATION_DATE = "deactivation_date";
        }

        public abstract class ACCOUNT_ROLE {
            public static final String ACCOUNT_ROLE = "account_role";
            public static final String ID_ACCOUNT = "id_account";
            public static final String ID_ROLE = "id_role";
        }

        public abstract class ROLE {
            public static final String ROLE = "role";
            public static final String ID_ROLE = "id_role";
            public static final String NAME = "name";
        }

        public abstract class OAUTH_CLIENT {
            public static final String OAUTH_CLIENT = "oauth_client";
            public static final String ID_CLIENT = "id_client";
            public static final String CLIENT_SECRET = "client_secret";
            public static final String OAUTH_CLIENT_GRANT_TYPE = "oauth_client_grant_type";
            public static final String OAUTH_CLIENT_SCOPES = "oauth_client_scopes";
            public static final String ACCESS_TOKEN_VALIDITY_SECENDS = "access_token_validity_secends";
            public static final String REFRESH_TOKEN_VALIDITY_SECENDS = "refresh_token_validity_secends";
        }

        public abstract class OAUTH_GRANT_TYPE {
            public static final String OAUTH_GRANT_TYPE = "oauth_grant_type";
            public static final String ID_GRANT_TYPE = "id_grant_type";
            public static final String GRANT_TYPE = "grant_type";
        }

        public abstract class OAUTH_SCOPE {
            public static final String OAUTH_SCOPE = "oauth_scope";
            public static final String ID_SCOPE = "id_scope";
            public static final String SCOPE = "scope";
        }
    }

}
