package ch12_exception;

// 모든 예외클래스는 Exception 클래스를 상속 받는다.
public class BizException extends Exception{
    // 에러 코드에 대한 필드변수 추가
    private int errCode;

    public BizException(String message, int errCode) {
        super(message);
        this.errCode = errCode;
    }

    public int getErrCode() {
        return errCode;
    }

}
