package com.example.equipmentloan.enumtype;

// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 * DBには "ROLE_ADMIN" / "ROLE_USER" を保存する（Spring Securityの慣例に合わせる）
 */
public enum RoleType {
    ROLE_ADMIN,
    ROLE_USER
    
    /**
     * このRoleを Spring Security の権限（authority）に変換 
     */
    // public GrantedAuthority asAuthority() {
    //     return new SimpleGrantedAuthority(this.name()); //"ROLE_ADMIN"等
    // }
    /** Collectionsで使いやすい形 */
    // public String authorityName() {
    //     return this.name();
    // }
}
