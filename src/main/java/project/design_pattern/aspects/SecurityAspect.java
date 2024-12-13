package project.design_pattern.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import project.design_pattern.annotations.SecuredBy;

import java.util.Arrays;
import java.util.List;

@Aspect
@Component
public class SecurityAspect {

    private final List<String> currentUserRoles = Arrays.asList("ADMIN", "USER");

    @Before("@annotation(securedBy)")
    public void checkSecurity(SecuredBy securedBy) {
        List<String> requiredRoles = Arrays.asList(securedBy.roles());
        boolean hasAccess = currentUserRoles.stream().anyMatch(requiredRoles::contains);

        if (!hasAccess) {
            throw new SecurityException("Access denied! Required roles: " + requiredRoles);
        }
    }
}

