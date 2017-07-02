package sopt.client.cleanting.Network;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import sopt.client.cleanting.Main.Login.FindIdResult;
import sopt.client.cleanting.Main.Login.LoginResult;
import sopt.client.cleanting.Main.SignUp.IdCheckResult;
import sopt.client.cleanting.Main.SignUp.SignUpResult;
import sopt.client.cleanting.MakeTing.MakeTingLocationResult;
import sopt.client.cleanting.MakeTing.MakeTingRequestResult;
import sopt.client.cleanting.MakeTing.MakeTingResult;
import sopt.client.cleanting.MyRequest.MyRequestTingEditResult;
import sopt.client.cleanting.MyRequest.RequestTingDetailResult;
import sopt.client.cleanting.Mypage.ModifyPasswordResult;
import sopt.client.cleanting.Mypage.WithdrawResult;

/**
 * Created by 김지원 on 2017-06-25.
 */

public interface NetworkService {
    /**api 문서를 기반으로 숫자를 써주자*/
    // 1-1 회원가입
    @POST("members/signUp")
    Call<SignUpResult> getSignUpResult(@Body SignUpResult.SignUpData signUpData);

    // 1-2 아이디 중복확인
    @GET("members/duplicate/{id}")
    Call<IdCheckResult> getIdCheckResult(@Path("id") String id);

    // 1-3 로그인
    @POST("members")
    Call<LoginResult> getLoginResult(@Body LoginResult.SendLoginData sendLoginData);

    // 1-4 아이디 찾기
    @GET("members/id/{phone}")
    Call<FindIdResult> getFindIdResult(@Path("userId") String userId);

    // 1-5 비밀번호 수정
    @PUT("members/id/{phone}")
    Call<ModifyPasswordResult> getModifyPasswordResult(@Path("pwd") String pwd);

    // 1-6 회원 탈퇴
    @DELETE("members/withdraw/{userId}")
    Call<WithdrawResult> getWithdrawResult(@Path("userId") String userId);

    // 팅 생성하기
    @POST("ting")
    Call<MakeTingResult> getMakeTingResult(@Body MakeTingResult.MakeTingResultData makeTingResultData);

    // 팅 신청하기
    @POST("ting/{tingId}")
    Call<MakeTingRequestResult> getMakeTingRequestResult(@Path("tId") String tId, @Body MakeTingRequestResult.MakeTingRequestResultData makeTingRequestResultData);

    // 팅 조회(지역)
    @GET("ting/area/{userId}")
    Call<MakeTingLocationResult> getMakeTingLocationResult(@Path("userId") String userId, @Header("order") String order);

    // 팅 상세정보 보기

    // 팅 수정
    @PUT("ting/{tingId}")
    Call<MyRequestTingEditResult> getMyRequestTingEditResult(@Path("tingId") String tingId);

    // 사용자 신청 팅 조회
    @GET("ting/register/{userId}")
    Call<RequestTingDetailResult> getRequestTingDetailResult(@Path("userId") String userId);

    // 팅 완료
}
