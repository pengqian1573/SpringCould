
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan("com.pq.ribbon")
@EnableHystrix
public class RibbonApplication {



	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}


	/**
	 * ribbon 负载均衡客户端
	 * pq
	 * */
	public static void main(String[] args) {
		SpringApplication.run(RibbonApplication.class, args);
	}
}
