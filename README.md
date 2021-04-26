Build native executable
```
mvn clean package -Pnative
```

Start H2 database
```
java -cp ./h2/h2-1.4.199.jar org.h2.tools.Server -ifNotExists &
```

Start quarkus native runner
```
./target/quarkus-hibernateproxy-reproducer-0.0.1-SNAPSHOT-runner
```

Test
```
curl localhost:8080/entities
```

Error
```
ERROR [io.qua.ver.htt.run.QuarkusErrorHandler] (executor-thread-1) HTTP Request to /entities failed, error id: 1cd3de90-1d33-4f54-9d79-6adec6fc0b13-1: org.jboss.resteasy.spi.UnhandledException: javax.persistence.PersistenceException: org.hibernate.HibernateException: Unable to instantiate proxy instance
at org.jboss.resteasy.core.ExceptionHandler.handleApplicationException(ExceptionHandler.java:106)
at org.jboss.resteasy.core.ExceptionHandler.handleException(ExceptionHandler.java:372)
at org.jboss.resteasy.core.SynchronousDispatcher.writeException(SynchronousDispatcher.java:218)
at org.jboss.resteasy.core.SynchronousDispatcher.invoke(SynchronousDispatcher.java:519)
at org.jboss.resteasy.core.SynchronousDispatcher.lambda$invoke$4(SynchronousDispatcher.java:261)
at org.jboss.resteasy.core.SynchronousDispatcher.lambda$preprocess$0(SynchronousDispatcher.java:161)
at org.jboss.resteasy.core.interception.jaxrs.PreMatchContainerRequestContext.filter(PreMatchContainerRequestContext.java:364)
at org.jboss.resteasy.core.SynchronousDispatcher.preprocess(SynchronousDispatcher.java:164)
at org.jboss.resteasy.core.SynchronousDispatcher.invoke(SynchronousDispatcher.java:247)
at io.quarkus.resteasy.runtime.standalone.RequestDispatcher.service(RequestDispatcher.java:73)
at io.quarkus.resteasy.runtime.standalone.VertxRequestHandler.dispatch(VertxRequestHandler.java:138)
at io.quarkus.resteasy.runtime.standalone.VertxRequestHandler.access$000(VertxRequestHandler.java:41)
at io.quarkus.resteasy.runtime.standalone.VertxRequestHandler$1.run(VertxRequestHandler.java:93)
at org.jboss.threads.EnhancedQueueExecutor$Task.run(EnhancedQueueExecutor.java:2415)
at org.jboss.threads.EnhancedQueueExecutor$ThreadBody.run(EnhancedQueueExecutor.java:1452)
at org.jboss.threads.DelegatingRunnable.run(DelegatingRunnable.java:29)
at org.jboss.threads.ThreadLocalResettingRunnable.run(ThreadLocalResettingRunnable.java:29)
at java.lang.Thread.run(Thread.java:829)
at org.jboss.threads.JBossThread.run(JBossThread.java:501)
at com.oracle.svm.core.thread.JavaThreads.threadStartRoutine(JavaThreads.java:553)
at com.oracle.svm.core.posix.thread.PosixJavaThreads.pthreadStartRoutine(PosixJavaThreads.java:192)
Caused by: javax.persistence.PersistenceException: org.hibernate.HibernateException: Unable to instantiate proxy instance
at org.hibernate.internal.ExceptionConverterImpl.convert(ExceptionConverterImpl.java:154)
at org.hibernate.query.internal.AbstractProducedQuery.list(AbstractProducedQuery.java:1602)
at org.hibernate.query.Query.getResultList(Query.java:165)
at io.quarkus.hibernate.orm.panache.common.runtime.CommonPanacheQueryImpl.list(CommonPanacheQueryImpl.java:239)
at io.quarkus.hibernate.orm.panache.runtime.PanacheQueryImpl.list(PanacheQueryImpl.java:149)
at io.quarkus.hibernate.orm.panache.runtime.JpaOperations.list(JpaOperations.java:24)
at io.quarkus.hibernate.orm.panache.runtime.JpaOperations.list(JpaOperations.java:10)
at io.quarkus.hibernate.orm.panache.common.runtime.AbstractJpaOperations.listAll(AbstractJpaOperations.java:289)
at org.example.quarkus.EntityRepository.listAll(EntityRepository.java)
at org.example.quarkus.EntityRepository_ClientProxy.listAll(EntityRepository_ClientProxy.zig:1260)
at org.example.quarkus.EntityResource.getSamples(EntityResource.java:24)
at org.example.quarkus.EntityResource_ClientProxy.getSamples(EntityResource_ClientProxy.zig:126)
at java.lang.reflect.Method.invoke(Method.java:566)
at org.jboss.resteasy.core.MethodInjectorImpl.invoke(MethodInjectorImpl.java:170)
at org.jboss.resteasy.core.MethodInjectorImpl.invoke(MethodInjectorImpl.java:130)
at org.jboss.resteasy.core.ResourceMethodInvoker.internalInvokeOnTarget(ResourceMethodInvoker.java:643)
at org.jboss.resteasy.core.ResourceMethodInvoker.invokeOnTargetAfterFilter(ResourceMethodInvoker.java:507)
at org.jboss.resteasy.core.ResourceMethodInvoker.lambda$invokeOnTarget$2(ResourceMethodInvoker.java:457)
at org.jboss.resteasy.core.interception.jaxrs.PreMatchContainerRequestContext.filter(PreMatchContainerRequestContext.java:364)
at org.jboss.resteasy.core.ResourceMethodInvoker.invokeOnTarget(ResourceMethodInvoker.java:459)
at org.jboss.resteasy.core.ResourceMethodInvoker.invoke(ResourceMethodInvoker.java:419)
at org.jboss.resteasy.core.ResourceMethodInvoker.invoke(ResourceMethodInvoker.java:393)
at org.jboss.resteasy.core.ResourceMethodInvoker.invoke(ResourceMethodInvoker.java:68)
at org.jboss.resteasy.core.SynchronousDispatcher.invoke(SynchronousDispatcher.java:492)
... 17 more
Caused by: org.hibernate.HibernateException: Unable to instantiate proxy instance
at org.hibernate.bytecode.internal.bytebuddy.BasicProxyFactoryImpl.getProxy(BasicProxyFactoryImpl.java:62)
at org.hibernate.tuple.component.PojoComponentTuplizer$ProxiedInstantiator.instantiate(PojoComponentTuplizer.java:174)
at org.hibernate.tuple.component.AbstractComponentTuplizer.instantiate(AbstractComponentTuplizer.java:84)
at org.hibernate.type.ComponentType.instantiate(ComponentType.java:587)
at org.hibernate.type.ComponentType.instantiate(ComponentType.java:593)
at org.hibernate.type.EmbeddedComponentType.instantiate(EmbeddedComponentType.java:48)
at org.hibernate.type.ComponentType.resolve(ComponentType.java:691)
at org.hibernate.loader.Loader.extractKeysFromResultSet(Loader.java:873)
at org.hibernate.loader.Loader.getRowFromResultSet(Loader.java:727)
at org.hibernate.loader.Loader.getRowsFromResultSet(Loader.java:1039)
at org.hibernate.loader.Loader.processResultSet(Loader.java:990)
at org.hibernate.loader.Loader.doQuery(Loader.java:959)
at org.hibernate.loader.Loader.doQueryAndInitializeNonLazyCollections(Loader.java:349)
at org.hibernate.loader.Loader.doList(Loader.java:2849)
at org.hibernate.loader.Loader.doList(Loader.java:2831)
at org.hibernate.loader.Loader.listIgnoreQueryCache(Loader.java:2663)
at org.hibernate.loader.Loader.list(Loader.java:2658)
at org.hibernate.loader.hql.QueryLoader.list(QueryLoader.java:506)
at org.hibernate.hql.internal.ast.QueryTranslatorImpl.list(QueryTranslatorImpl.java:400)
at org.hibernate.engine.query.spi.HQLQueryPlan.performList(HQLQueryPlan.java:219)
at org.hibernate.internal.SessionImpl.list(SessionImpl.java:1414)
at org.hibernate.query.internal.AbstractProducedQuery.doList(AbstractProducedQuery.java:1625)
at org.hibernate.query.internal.AbstractProducedQuery.list(AbstractProducedQuery.java:1593)
... 39 more
Caused by: java.lang.InstantiationException: Type `org.example.quarkus.AbstractEntity$HibernateBasicProxy$VBTQbnAf` can not be instantiated reflectively as it does not have a no-parameter constructor or the no-parameter constructor has not been added explicitly to the native image.
at java.lang.Class.newInstance(DynamicHub.java:912)
at org.hibernate.bytecode.internal.bytebuddy.BasicProxyFactoryImpl.getProxy(BasicProxyFactoryImpl.java:57)
... 61 more
```