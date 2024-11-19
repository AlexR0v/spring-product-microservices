import { PassedInitialConfig } from 'angular-auth-oidc-client'

export const authConfig: PassedInitialConfig = {
    config: {
        authority: 'http://localhost:9080/realms/spring-microservices',
        redirectUrl: window.location.origin,
        postLogoutRedirectUri: window.location.origin,
        clientId: 'ui-client',
        scope: 'openid profile offline_access',
        responseType: 'code',
        silentRenew: true,
        useRefreshToken: true,
        renewTimeBeforeTokenExpiresInSeconds: 30,
    },
}
