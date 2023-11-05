package com.ibrahimdenizz.HrmsApplication.modules.employee.model.response;

public class CreateEmployeeResponse {
    private String username;
    private String password;

    public CreateEmployeeResponse() {
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static CreateEmployeeResponseBuilder builder() {
        return new CreateEmployeeResponseBuilder();
    }

    public static class CreateEmployeeResponseBuilder {

        private final CreateEmployeeResponse createEmployeeResponse;

        public CreateEmployeeResponseBuilder() {
            this.createEmployeeResponse = new CreateEmployeeResponse();
        }

        public CreateEmployeeResponseBuilder username(String username) {
            this.createEmployeeResponse.username = username;
            return this;
        }

        public CreateEmployeeResponseBuilder password(String password) {
            this.createEmployeeResponse.password = password;
            return this;
        }

        public CreateEmployeeResponse build() {
            return this.createEmployeeResponse;
        }
    }

}
