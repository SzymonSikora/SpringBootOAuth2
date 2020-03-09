package com.webservice.dexter_service.Common.Enums;

public interface IREQUESTS {

    abstract class REQUESTS {
        public static final String API = "/api";
        public static final String OPEN = API + "/open";
        public static final String USER = API + "/user";
        public static final String ADMIN = API + "/admin";

        public static final String PREFIX_ACCOUNT = "/account";
        public static final String PREFIX_DESCR = "/descr";
        public static final String PREFIX_LANG = "/lang";
        public static final String PREFIX_OAUTH_CLIENT = "/oauthClient";
        public static final String PREFIX_OAUTH_GRANT_TYPE = "/oauthGrantType";
        public static final String PREFIX_OAUTH_SCOPE = "/oauthScope";
        public static final String PREFIX_ROLE = "/role";
        public static final String PREFIX_TYPE = "/type";
        public static final String PREFIX_TEST = "/test";

        public abstract class ACCOUNT {
            public static final String GET_ONE_BY_ID = ADMIN + PREFIX_ACCOUNT + "/getOneById";
            public static final String GET_ALL = ADMIN + PREFIX_ACCOUNT + "/getAll";
            public static final String CREATE = OPEN + PREFIX_ACCOUNT + "/create";
            public static final String GET_AUTH_ACCOUNT =  USER + PREFIX_ACCOUNT + "/getAuthAccount";
        }
        public abstract class DESCR {
            public static final String CREATE_OR_UPDATE = ADMIN + PREFIX_DESCR + "/createOrUpdate";
            public static final String GET_ONE_BY_ID = ADMIN + PREFIX_DESCR + "/getOneById";
            public static final String GET_ALL = ADMIN + PREFIX_DESCR + "/getAll";
        }
        public abstract class LANG {
            public static final String CREATE_OR_UPDATE = ADMIN + PREFIX_LANG + "/createOrUpdate";
            public static final String GET_ONE_BY_ID = ADMIN + PREFIX_LANG + "/getOneById";
            public static final String GET_ALL = ADMIN + PREFIX_LANG + "/getAll";
        }
        public abstract class OAUTH_CLIENT {
            public static final String CREATE_OR_UPDATE = ADMIN + PREFIX_OAUTH_CLIENT + "/createOrUpdate";
            public static final String GET_ONE_BY_CLIENT_ID = ADMIN + PREFIX_OAUTH_CLIENT + "/getOneByClientId";
            public static final String GET_ALL = ADMIN + PREFIX_OAUTH_CLIENT + "/getAll";
        }
        public abstract class OAUTH_GRANT_TYPE {
            public static final String CREATE_OR_UPDATE = ADMIN + PREFIX_OAUTH_GRANT_TYPE + "/createOrUpdate";
            public static final String GET_ONE_BY_ID = ADMIN + PREFIX_OAUTH_GRANT_TYPE + "/getOneById";
            public static final String GET_ALL = ADMIN + PREFIX_OAUTH_GRANT_TYPE + "/getAll";
        }
        public abstract class OAUTH_SCOPE {
            public static final String CREATE_OR_UPDATE = ADMIN + PREFIX_OAUTH_SCOPE + "/createOrUpdate";
            public static final String GET_ONE_BY_ID = ADMIN + PREFIX_OAUTH_SCOPE + "/getOneById";
            public static final String GET_ALL = ADMIN + PREFIX_OAUTH_SCOPE + "/getAll";
        }
        public abstract class ROLE {
            public static final String CREATE_OR_UPDATE = ADMIN + PREFIX_ROLE + "/createOrUpdate";
            public static final String GET_ONE_BY_ID = ADMIN + PREFIX_ROLE + "/getOneById";
            public static final String GET_ALL = ADMIN + PREFIX_ROLE + "/getAll";
        }
        public abstract class TYPE {
            public static final String CREATE_OR_UPDATE = ADMIN + PREFIX_TYPE + "/createOrUpdate";
            public static final String GET_ONE_BY_ID = ADMIN + PREFIX_TYPE + "/getOneById";
            public static final String GET_ALL = ADMIN + PREFIX_TYPE + "/getAll";
        }
        public abstract class TEST {
            public static final String CONNECTION1 = ADMIN + PREFIX_TEST + "/connection1";
            public static final String CONNECTION2 = OPEN + PREFIX_TEST + "/connection2";
            public static final String CONNECTION3 = OPEN + PREFIX_TEST + "/connection3";
            public static final String CONNECTION4 = OPEN + PREFIX_TEST + "/connection4";
        }
    }
}
