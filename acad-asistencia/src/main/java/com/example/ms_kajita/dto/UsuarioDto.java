package com.example.ms_kajita.dto;



public class UsuarioDto {

    private Integer idUsuario;

    private String clave;

    private String estado;

    private String cargo;

    private String userName;

    @Override
    public String toString() {
        return "UsuarioDto{" +
                "idUsuario=" + idUsuario +
                ", clave='" + clave + '\'' +
                ", estado='" + estado + '\'' +
                ", cargo='" + cargo + '\'' +
                ", user='" + userName + '\'' +
                '}';
    }

    public UsuarioDto() {
    }

    public UsuarioDto(Integer idUsuario, String clave, String estado, String user, String cargo) {
        this.idUsuario = idUsuario;
        this.clave = clave;
        this.estado = estado;
        this.userName = user;
        this.cargo = cargo;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUser() {
        return userName;
    }

    public void setUser(String user) {
        this.userName = user;
    }
}
