package com.webservice.dexter_service.Common.Enums;

public interface IENUMS<T> {

    T getValue();

    enum ROLE implements IENUMS<Integer> {
        ADMIN(1),
        USER(2);

        Integer idRole;

        private ROLE(Integer idRole) {
            this.idRole = idRole;
        }

        @Override
        public Integer getValue() {
            return idRole;
        }
    }

    enum PERMISSION implements IENUMS<Integer> {
        ACCOUNT(1),
        ROLE(2);

        Integer idPermission;

        PERMISSION(Integer idPermission) {
            this.idPermission = idPermission;
        }

        @Override
        public Integer getValue() {
            return idPermission;
        }
    }
}
