package com.example.ms_kajita.dto;



public class UsuarioDto {

    private Integer id;

    private String password;

    private String estado;

    private String cargo;

    private String userName;

    @Override
    public String toString() {
        return "UsuarioDto{" +
                "idUsuario=" + id +
                ", clave='" + password + '\'' +
                ", estado='" + estado + '\'' +
                ", cargo='" + cargo + '\'' +
                ", user='" + userName + '\'' +
                '}';
    }

    public UsuarioDto() {
    }

    public UsuarioDto(Integer id, String clave, String estado, String user, String cargo) {
        this.id = id;
        this.password = clave;
        this.estado = estado;
        this.userName = user;
        this.cargo = cargo;
    }

    public Integer getIdUsuario() {
        return id;
    }

    public void setIdUsuario(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return userName;
    }

    public void setUser(String user) {
        this.userName = user;
    }
}
