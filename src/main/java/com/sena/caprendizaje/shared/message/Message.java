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
   
}
