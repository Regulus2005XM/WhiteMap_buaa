package com.whitemap.whitespringboot3.web.dto.User;

public class RegisterBackDTO {
        private String jwt;
        private String id;

        public RegisterBackDTO(String jwt, String id) {
            this.jwt = jwt;
            this.id = id;
        }

        public String getJwt() {
            return jwt;
        }

        public String getId() {
            return id;
        }
}
