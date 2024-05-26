import com.project.parks_domain.entity.PopularMovieResponse
import com.project.parks_domain.entity.TopRatedMovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface MovieService {
    @GET("movie/popular")
    fun getPopularMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String = "ko-KR",
        @Query("page") page: Int = 1
    ): Call<PopularMovieResponse>

    @GET("movie/top_rated")
    fun getTopRatedMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String = "ko-KR",
        @Query("page") page: Int = 1
    ): Call<TopRatedMovieResponse>
}