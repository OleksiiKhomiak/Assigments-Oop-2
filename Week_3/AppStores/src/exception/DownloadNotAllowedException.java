package exception;

public class DownloadNotAllowedException extends Exception {

    public DownloadNotAllowedException() {
        super();
    }

    public DownloadNotAllowedException(String message) {
        super(message);
    }
}