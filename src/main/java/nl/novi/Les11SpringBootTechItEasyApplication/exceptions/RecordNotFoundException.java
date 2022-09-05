package nl.novi.Les11SpringBootTechItEasyApplication.exceptions;


public class RecordNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public RecordNotFoundException() {
        super();
    }

    public RecordNotFoundException(String message) {
        super(message);
    }
}

//een default exception
//een exception met message
