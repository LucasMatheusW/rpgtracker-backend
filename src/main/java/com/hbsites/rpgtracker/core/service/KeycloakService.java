package com.hbsites.rpgtracker.core.service;

import org.jboss.resteasy.client.jaxrs.internal.ResteasyClientBuilderImpl;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class KeycloakService {
    private final String SERVER_URL = "http://localhost:8083/auth";
    private final String REALM = "hbsites";
    private final String CLIENT_ID = "keycloak-admin";
    private Keycloak kc;

    public KeycloakService() {
        kc = KeycloakBuilder.builder()
                .serverUrl(SERVER_URL)
                .grantType(OAuth2Constants.PASSWORD)
                .realm(REALM)
                .clientId(CLIENT_ID)
                .username("webclientuser")
                .password("webclientuser")
                .resteasyClient(new ResteasyClientBuilderImpl().connectionPoolSize(10).build())
                .build();
    }

    public String getUsernameById(UUID id) {
        try {
            kc.tokenManager().getAccessToken();
            UsersResource resource = kc.realm(REALM).users();
            UserResource userResource = resource.get(id.toString());
            UserRepresentation  representation = userResource != null ? userResource.toRepresentation() : null;

            String playerName = null;
            if (representation != null) {
                playerName = "";
                if (representation.getFirstName() != null && representation.getLastName() != null) {
                    playerName = representation.getFirstName().concat(" ").concat(representation.getLastName());
                }
                if (representation.getUsername() != null) {
                    if (!playerName.isEmpty()) {
                        playerName = playerName.concat(" (").concat(representation.getUsername()).concat(")");
                    } else {
                        playerName = representation.getUsername();
                    }
                }
            }
            return playerName;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
