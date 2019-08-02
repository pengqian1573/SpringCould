# SpringCould
简单SpringCould Demo 


Eureka，服务注册中心，特性有失效剔除、服务保护。


Dashboard，Hystrix仪表盘，监控集群模式和单点模式，其中集群模式需要收集器Turbine配合。


Zuul，API服务网关，功能有路由分发和过滤。


Config，分布式配置中心，支持本地仓库、SVN、Git、Jar包内配置等模式，



Ribbon，客户端负载均衡，特性有区域亲和、重试机制。


Hystrix，客户端容错保护，特性有服务降级、服务熔断、请求缓存、请求合并、依赖隔离。


Feign，声明式服务调用，本质上就是Ribbon+Hystrix


Stream，消息驱动，有Sink、Source、Processor三种通道，特性有订阅发布、消费组、消息分区。


Bus，消息总线，配合Config仓库修改的一种Stream实现，


Sleuth，分布式服务追踪，需要搞清楚TraceID和SpanID以及抽样，如何与ELK整合。


