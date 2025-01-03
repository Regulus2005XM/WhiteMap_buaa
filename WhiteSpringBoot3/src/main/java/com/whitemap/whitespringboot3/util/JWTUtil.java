package com.whitemap.whitespringboot3.util;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTUtil {
    // 密匙
    private static final String SECRET_KEY = "BAIZE";
    /**
     * 获取JWT令牌
     * @param userId 用户id
     * @return 令牌
     */
    public static String generateToken(String userId) {
        return Jwts.builder()
                .setSubject(userId)
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    /**
     * 解析JWT令牌
     * @param jwt 令牌信息
     * @return 用户账号
     */
    public static String getUserIdFromJwt(String jwt) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(jwt)
                .getBody();
        return claims.getSubject();
    }

    /**
     * 验证令牌有效性
     * @param token 令牌信息
     * @return 是否有效
     */
    public static boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(generateToken("admin"));
        System.out.println(getUserIdFromJwt("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxIn0.67oxEbflG528Okvpctip_OZPJ81L4TGmn9itW0Bko-qy_X5p9yYlx_XNXykFtdvywFDGta8yLOTf0GXwl_ywaw"));
    }
}
