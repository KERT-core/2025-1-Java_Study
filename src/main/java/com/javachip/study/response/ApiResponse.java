package com.javachip.study.response;

//공통 API응답 Wrapper 클래스
//응답 데이터를 <T>제네릭으로 받아서 넘김
//팩토리 메서드 패턴이라는 디자인 패턴을 사용함.

public class ApiResponse<T> {
    private final T data;
    private final boolean success;
    private final String message;
    private final int status;

    //다른 클래스들과 달리 생성자가 private인것을 볼수 있음. ex)싱글톤 패턴
    //팩토리 메서드를 통해서만 객체를 생성할 수 있도록 함
    private ApiResponse(
            T data,
            boolean success,
            String message,
            int status
    ) {
        this.data = data;
        this.success = success;
        this.message = message;
        this.status = status;
    }

    //정적 팩토리 메서드 부분
    //생성자 대신 static 메서드로 객체를 생성함
    //성공 응답에 대한 것으로, 실패 시 응답은 구현되어 있지 않음(해야함)
    public static <T> ApiResponse<T> success(T data){
        return new ApiResponse<>(data, true, null, 200);
    }
    public static <T> ApiResponse<T> fail(Exception e, int status){
        return new ApiResponse<>(null, false, e.getMessage(), status);
    }

    //실제 응답 반환
    public T getData() {
        return data;
    }
    public boolean isSuccess() { return success; }
    public String getMessage() { return message; }
    public int getStatus() { return status; }

}
