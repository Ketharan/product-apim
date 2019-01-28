/*
 *Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *WSO2 Inc. licenses this file to you under the Apache License,
 *Version 2.0 (the "License"); you may not use this file except
 *in compliance with the License.
 *You may obtain a copy of the License at
 *
 *http://www.apache.org/licenses/LICENSE-2.0
 *
 *Unless required by applicable law or agreed to in writing,
 *software distributed under the License is distributed on an
 *"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *KIND, either express or implied.  See the License for the
 *specific language governing permissions and limitations
 *under the License.
 */

package org.wso2.am.scenario.tests.api.secure.userRoles;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.wso2.am.integration.test.utils.APIManagerIntegrationTestException;
import org.wso2.am.integration.test.utils.base.APIMIntegrationConstants;
import org.wso2.am.integration.test.utils.bean.APPKeyRequestGenerator;
import org.wso2.am.scenario.test.common.APIStoreRestClient;
import org.wso2.am.scenario.test.common.HttpClient;
import org.wso2.am.scenario.test.common.ScenarioDataProvider;
import org.wso2.am.scenario.test.common.ScenarioTestBase;
import org.wso2.carbon.automation.test.utils.http.client.HttpResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

public class SecureUsingUserRolesTestCases extends ScenarioTestBase {
    private APIStoreRestClient apiStore;
    private List<String> applicationsList = new ArrayList<>();
    private static final Log log = LogFactory.getLog(SecureUsingUserRolesTestCases.class);
    private static final String ADMIN_LOGIN_USERNAME = "admin";
    private static final String ADMIN_LOGIN_PW = "admin";
    private static final String ERROR_APPLICATION_TIER_MISMATCH = "Application tier value mismatch for application: ";
    private static final String ERROR_APPLICATION_DESCRIPTION_MISMATCH = "Application description value mismatch" +
            " for application: ";
    private static final String ERROR_APPLICATION_TOKEN_TYPE_MISMATCH = "Application token type value mismatch" +
            " for application: ";
    private static final String ERROR_GENERATING_KEY = " key generation failed for application:  ";
    private static final String ERROR = "error";
    private static final String STATUS = "status";
    private static final String STATUS_APPROVED = "APPROVED";
    private static final String NAME = "name";
    private static final String TIER = "tier";
    private static final String DESCRIPTION = "description";
    private static final String TOKEN_TYPE = "tokenType";
    private static final String APPLICATIONS = "applications";
    private static final String DATA = "data";
    private static final String KEY = "key";
    private static final String KEY_STATE = "keyState";
    private static final String APP_DETAILS = "appDetails";
    private static final String KEY_TYPE = "key_type";
    private static final String CONSUMER_KEY = "consumerKey";
    private static final String CONSUMER_SECRET = "consumerSecret";
    private static final String ACCESS_TOKEN = "accessToken";
    private static final String PRODUCTION = "PRODUCTION";
    private static final String SANDBOX = "SANDBOX";
    private static final String APPLICATION_NAME = "Application";
    private static final String APPLICATION_DESCRIPTION = "ApplicationDescription";

    @BeforeClass(alwaysRun = true)
    public void init() throws APIManagerIntegrationTestException {
        apiStore = new APIStoreRestClient(storeURL);
        apiStore.login(ADMIN_LOGIN_USERNAME, ADMIN_LOGIN_PW);
    }


    @AfterClass(alwaysRun = true)
    public void destroy() throws Exception {
        for (String name : applicationsList) {
            apiStore.removeApplication(name);
        }
        applicationsList.clear();
    }
}
