/*******************************************************************************
 * © 2023 II Ciprian Tarlev. All Rights Reserved.
 *******************************************************************************/
package ii.cipriantarlev.pointofsaleapi.configuration;

import org.springframework.security.core.Authentication;

public interface AuthenticationInformation {
    Authentication getAuthentication();
}