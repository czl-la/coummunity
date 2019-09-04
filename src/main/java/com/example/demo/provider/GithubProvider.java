package com.example.demo.provider;

import com.alibaba.fastjson.JSON;
import com.example.demo.dto.AccessTokenDto;
import com.example.demo.dto.GithubUserDto;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GithubProvider {
public String getAccessToken(AccessTokenDto accessTokenDto){
   MediaType mediaType= MediaType.get("application/json; charset=utf-8");
    OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(mediaType,JSON.toJSONString(accessTokenDto));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String str= response.body().string();
            String token_str=str.split("&")[0].split("=")[1];
            return token_str;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
}
public GithubUserDto getUser(String accessToken){
    OkHttpClient client=new OkHttpClient();
    Request request=new Request.Builder()
            .url("https://api.github.com/user?access_token="+accessToken)
            .build();
    try{
        Response response=client.newCall(request).execute();
        String str=response.body().string();
        GithubUserDto githubUserDto= JSON.parseObject(str,GithubUserDto.class);
        return  githubUserDto;
    }catch(IOException e){
        e.printStackTrace();
    }
return null;
}

}
