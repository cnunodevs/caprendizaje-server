package com.sena.caprendizaje.shared.message;

public class Message {

    public static class Success {
        public static final String SUCCESS_PROCESS = "Solicitud procesada satisfactoriamente";
        public static final String SUCCESS = "success";
    }

    public static class Fail {
        public static final String FAIL = "fail";
        public static final String FAILED_PROCESS = "Transaccion no exitosa";
        public static final String SOMETHING_WENT_WRONG = "Algo salió mal al procesar su solicitud. Intentalo nuevamente";

    }

    public static class Resources {

        public static class Postulacion {
            public static final String ALREADY_POSTULADO = "Ya se encuentra postulado";
            public static final String POSTULACION_NOT_FOUND = "No se encontró la postulacion";
        }

        public static class DataPersonal {
            public static final String DATA_PERSONAL_NOT_FOUND = "No existe los datos de la persona.";
        }

        public static class Perfil {
            public static final String PERFIL_NOT_FOUND = "No existe el perfil buscado.";
        }

        public static class Usuario {
            public static final String USUARIO_NOT_FOUND = "No existe el usuario buscado.";
        }

        public static class Parametro {
            public static final String PARAMETRO_NOT_FOUND = "No existe el parametro buscado.";
            public static final String PARAMETRO_IS_EMPTY_BY_MAESTRO = "No existe ningun parametro asociado al maestro indicado.";
        }

        public static class MaestroParametro {
            public static final String MAESTRO_PARAMETRO_NOT_FOUND = "No existe el parametro maestro.";
        }

    }

}
