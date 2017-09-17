package com.githubapi.client.core;

import static com.githubapi.client.util.PropertiesCache.getProperty;

public class Data {

    static class General {
        static final String BASE_API_URL = getProperty("base.api.url"),
        AUTHORIZATION_HEADER = getProperty("authorization.header"),
        AUTHORIZATION_HEADER_VALUE = getProperty("authorization.header.value");
    }

    public static class Commits {
        public static final String COMMITS_ENDPOINT = getProperty("commits.endpoint");
    }

    static class Authorization {
        static final String AUTHORIZATIONS_ENDPOINT = getProperty("authorizations.endpoint");
    }
}
