package sopt.client.cleanting.Network;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import sopt.client.cleanting.MakeTing.MakeTingLocationResult;
import sopt.client.cleanting.MakeTing.MakeTingRequestResult;
import sopt.client.cleanting.MakeTing.MakeTingResult;
import sopt.client.cleanting.MyRequest.MyRequestTingEditResult;
import sopt.client.cleanting.MyRequest.RequestTingDetailResult;

/**
 * Created by 김지원 on 2017-06-25.
 */

public interface NetworkService {
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
