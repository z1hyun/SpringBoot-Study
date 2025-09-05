package com.manning.sbip.ch02.configurationproperties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@ConfigurationProperties("app.sbip.ct")
public class AppProperties {
    /* app.ship.ct가 @ConfigurationProperties의 접두어로 지정되어있음
        @ConstructorBinding 어노테이션을 제외한 이유 : 스프링 3.0이상 부터는 어노테이션 필요X    *
    * */

    private final String name;      //애플리케이션 이름

    private final String ip;        //애플리케이션 Ip

    private final int port;         //애플리케이션 Port

    private final Security security;    //애플리케이션 보안 설정


    public String getName() {
        return name;
    }

    public String getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }

    public Security getSecurity() {
        return security;
    }

    public AppProperties(String name, String ip, @DefaultValue("8080") int port, Security security) {
        this.name = name;
        this.ip = ip;
        this.port  = port;
        this.security = security;
    }

    /* @DefaultValue를 사용하면 프로퍼티의 기본값을 지정할 수 있다.*/

    @Override
    public String toString() {
        return "AppProperties{" +
                "name='" + name + '\'' +
                ", ip='" + ip + '\'' +
                ", port=" + port +
                ", security=" + security +
                '}';
    }

public static class Security {

    private boolean enabled;  //애플리케이션 보안 활성여부

    private final String token;  //토큰값

    private final List<String> roles;   //역할

    public Security(boolean enabled, String token, List<String> roles) {
         this.enabled = enabled;
         this.token = token;
         this.roles = roles;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public String getToken() {
        return token;
    }

    public List<String> getRoles() {
        return roles;
    }

    @Override
    public String toString() {
        return "Security{" +
                "enabled=" + enabled +
                ", token='" + token + '\'' +
                ", roles=" + roles +
                '}';
    }
  }
}
